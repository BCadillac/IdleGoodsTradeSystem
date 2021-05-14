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
public class goodsInfoController {
	@RequestMapping(value="/goodsInfo",method=RequestMethod.GET)
	public ModelAndView enterHome(ModelAndView mav,HttpServletRequest httpServletRequest) throws IOException{
		int goodsId = Integer.parseInt(httpServletRequest.getParameter("goodsId"));
		GoodsInfoDocDAO gidDAO=new GoodsInfoDocDAO();
		Goods goods=gidDAO.getGoods(goodsId);
		mav.addObject("goods", goods);
		return mav;
	}
}
