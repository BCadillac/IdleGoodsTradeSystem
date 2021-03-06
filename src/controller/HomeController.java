package controller;
 
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import DAO.GoodsInfoDocDAO;
import pojo.Goods;


@Controller
public class HomeController {
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public ModelAndView enterHome() throws IOException{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value="/home",method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getGoodsList() throws IOException{
		GoodsInfoDocDAO gidDAO=new GoodsInfoDocDAO();
		List<Goods> listOfSellingGoods = gidDAO.getAllSellingGoods();				
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("listOfSellingGoods", JSONObject.toJSON(listOfSellingGoods));
		//System.out.println(jsonObject.toJSONString());
		return jsonObject.toJSONString();
	}
	
}
