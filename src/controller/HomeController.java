package controller;
 
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DAO.GoodsInfoDocDAO;
import pojo.Goods;


@Controller
public class HomeController {
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView enterHome() throws IOException{
		ModelAndView mav=new ModelAndView();
		GoodsInfoDocDAO gidDAO=new GoodsInfoDocDAO();
		List<Goods> listOfSellingGoods = gidDAO.getAllSellingGoods();
		mav.setViewName("home");
		mav.addObject("listOfSellingGoods",listOfSellingGoods);
		return mav;
	}
	
}
