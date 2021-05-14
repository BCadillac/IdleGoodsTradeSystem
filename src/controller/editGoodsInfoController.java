package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DAO.GoodsInfoDocDAO;
import pojo.Goods;

@Controller
public class editGoodsInfoController {
	@RequestMapping(value="/editGoodsInfo",method=RequestMethod.GET)
	public ModelAndView defaultEnter(ModelAndView mav,HttpServletRequest request) throws IOException{
		int goodsId=Integer.parseInt(request.getParameter("goodsId"));
		GoodsInfoDocDAO gidDAO=new GoodsInfoDocDAO();
		Goods goodsGoingToEdit=gidDAO.getGoods(goodsId);
		mav.setViewName("editGoodsInfo");
		mav.addObject("goodsId",goodsId);
		mav.addObject("name",goodsGoingToEdit.getName());
		mav.addObject("description",goodsGoingToEdit.getDescription());
		return mav;
	}
	
	@RequestMapping(value="/editGoodsInfo",method=RequestMethod.POST)
	public ModelAndView handlePost(ModelAndView mav,Goods inputGoods) throws IOException{
		GoodsInfoDocDAO gidDAO=new GoodsInfoDocDAO();
		if(gidDAO.updateGoods(inputGoods)){
			mav.setViewName("success");
			mav.addObject("message","edit success");
		}else{
			mav.setViewName("fail");
			mav.addObject("message","fail because update error!");
		}		
		return mav;
	}
}
