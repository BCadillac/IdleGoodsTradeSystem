package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DAO.GoodsInfoDocDAO;
import pojo.Account;
import pojo.Goods;
import pojo.UploadedImage;

@Controller
public class ReleaseGoodsController {
	@RequestMapping(value = "/releaseGoods", method = RequestMethod.GET)
	public ModelAndView enterEditGoods() {
		return new ModelAndView("releaseGoods");
	}

	@RequestMapping(value = "/releaseGoods", method = RequestMethod.POST)
	public ModelAndView handleEditGoods(ModelAndView mav, HttpSession httpSession, HttpServletRequest request,
			Goods goods, UploadedImage uploadedImage) throws IOException {
		Account currentAccount = (Account) httpSession.getAttribute("currentAccount");
		String pictureId = saveImage(request, uploadedImage, currentAccount.getId());
		GoodsInfoDocDAO gidDAO=new GoodsInfoDocDAO();
		goods.setPictureId(pictureId);
		goods.setSellerId(currentAccount.getId());
		if (gidDAO.addGoods(goods)) {
			mav.setViewName("releaseGoods");
			mav.addObject("successMessage", "上传成功！");
		} else {
			mav.setViewName("releaseGoods");
			mav.addObject("failMessage", "上传失败！请联系系统管理员");
		}
		return mav;
	}

	public String saveImage(HttpServletRequest request, UploadedImage image, String sellerId)
			throws IllegalStateException, IOException {
		// this function will save image and return its id
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");// 设置日期格式
		String pictureId = df.format(new Date()) + "@" + sellerId + ".jpg";// new Date()为获取当前系统时间
		File newFile = new File(request.getServletContext().getRealPath("/GoodsImg"), pictureId);// 第一个参数指定目录，这一步用于创建路径
		newFile.getParentFile().mkdirs();
		image.getImage().transferTo(newFile);// 将图片复制到newFile指定的路径
		return pictureId;
	}
}
