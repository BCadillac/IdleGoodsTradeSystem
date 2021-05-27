package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DAO.GoodsInfoDocDAO;

@Controller
public class deleteController {
	@RequestMapping(value="/deleteGoods",method=RequestMethod.GET)
	public ModelAndView handle(ModelAndView mav,HttpServletRequest request,HttpSession httpSession) throws IOException{
		int goodsId=Integer.parseInt(request.getParameter("goodsId"));
		
//		Account currentAccount=(Account)httpSession.getAttribute("currentAccount");
//		String sellerOfGoods =gidDAO.getGoods(goodsId).getSellerId();
//		if(sellerOfGoods.equals(currentAccount.getId())){	//检验商品是否属于当前用户，维护数据一致
//		}  
		
		GoodsInfoDocDAO gidDAO=new GoodsInfoDocDAO();
		if(gidDAO.deleteGoods(request,goodsId)){
			mav.setViewName("personalCenter");
		}else{
			mav.setViewName("fail");
			mav.addObject("message","delete fail");
		}
		return mav;
	}
}