package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import DAO.GoodsInfoDocDAO;
import pojo.Account;
import pojo.Goods;

@Controller
public class PersonalGoodsController {
	@RequestMapping(value="/personalGoods",method=RequestMethod.GET)
	public ModelAndView defaultEnter(ModelAndView mav,HttpSession httpSession) throws IOException{
		Account currentAccount=(Account)httpSession.getAttribute("currentAccount");
		GoodsInfoDocDAO gidDAO=new GoodsInfoDocDAO();
		List<Goods> listOfPersonalGoods = gidDAO.getPersonalGoods(currentAccount.getId());
		mav.setViewName("personalGoods");
		mav.addObject("listOfPersonalGoods",listOfPersonalGoods);
		return mav;
	}
	
	@RequestMapping(value="/personalGoods",method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getGoodsList(HttpSession httpSession) throws IOException{
		Account currentAccount=(Account)httpSession.getAttribute("currentAccount");
		GoodsInfoDocDAO gidDAO=new GoodsInfoDocDAO();
		List<Goods> listOfPersonalGoods = gidDAO.getPersonalGoods(currentAccount.getId());
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("listOfPersonalGoods", JSONObject.toJSON(listOfPersonalGoods));
		System.out.println(jsonObject.toJSONString());
		return jsonObject.toJSONString();
	}
	
}
