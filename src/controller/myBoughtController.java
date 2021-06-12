package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import DAO.AccountInfoDocDAO;
import DAO.GoodsInfoDocDAO;
import DAO.TransactionDocDAO;
import pojo.Account;
import pojo.Transaction;

@Controller
public class myBoughtController {
	@RequestMapping(value="/myBought",method=RequestMethod.GET)
	public ModelAndView defaultEnter(ModelAndView mav,HttpSession httpSession) throws IOException{
		mav.setViewName("myBought");
		return mav;
	}
	@RequestMapping(value="/myBought",method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getMyBought(HttpSession httpSession) throws IOException{
		Account currentAccount=(Account)httpSession.getAttribute("currentAccount");
		TransactionDocDAO tDao=new TransactionDocDAO();
		List<Transaction> listOfTransactions =tDao.getMyBroughtTransactions(currentAccount.getId());
		
		Map<String,String> listOfContact=new HashMap<>();
		Map<String, String>listOfGoodsImg=new HashMap<>();	//Map的key必须string，否则下面转换json后传给前端无法解析
		AccountInfoDocDAO aidDAO=new AccountInfoDocDAO();
		GoodsInfoDocDAO gidDAO=new GoodsInfoDocDAO();
		for(Transaction transaction : listOfTransactions){
			String sellerId=transaction.getSellerId();
			String contactInfo=aidDAO.getAccount(sellerId).getContactInfo();
			listOfContact.put(sellerId, contactInfo);
			Integer goodsId=transaction.getGoodsId();
			String pictureId=gidDAO.getGoods(goodsId).getPictureId();
			listOfGoodsImg.put(goodsId.toString(), pictureId);
		}		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("listOfTransactions", JSONObject.toJSON(listOfTransactions));
		jsonObject.put("listOfContact", listOfContact);
		jsonObject.put("listOfGoodsImg", listOfGoodsImg);
		//System.out.println(jsonObject.toJSONString());
		return jsonObject.toJSONString();
	}
	
}
