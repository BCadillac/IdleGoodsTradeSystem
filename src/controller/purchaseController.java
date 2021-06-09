package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DAO.AccountInfoDocDAO;
import DAO.GoodsInfoDocDAO;
import DAO.TransactionDocDAO;
import pojo.Account;
import pojo.Goods;
import pojo.Transaction;

@Controller
public class purchaseController {
	@RequestMapping(value="/purchase",method=RequestMethod.GET)
	public ModelAndView defaultEnter(ModelAndView mav,HttpSession httpSession,HttpServletRequest httpServletRequest) throws IOException{
		Account currentAccount=(Account)httpSession.getAttribute("currentAccount");
		//add new transaction
		//get the goods
		int goodsId = Integer.parseInt(httpServletRequest.getParameter("goodsId"));
		GoodsInfoDocDAO gidDAO=new GoodsInfoDocDAO();
		Goods goods=gidDAO.getGoods(goodsId);
		
		//init the transaction
		Transaction newTransaction=new Transaction();
		newTransaction.setGoodsId(goodsId);
		newTransaction.setSellerId(goods.getSellerId());
		newTransaction.setBuyerId(currentAccount.getId());
		
		//write into doc
		TransactionDocDAO tdDao=new TransactionDocDAO();
		if(tdDao.addTransaction(newTransaction)){
			gidDAO.setSELLED(goodsId);
			AccountInfoDocDAO aidDAO=new AccountInfoDocDAO();
			Account seller=aidDAO.getAccount(goods.getSellerId());
			mav.setViewName("purchase");
			mav.addObject("successMessage","购买成功!<br />出售者联系方式:"+seller.getContactInfo());
		}else{
			mav.setViewName("purchase");
			mav.addObject("failMessage","抱歉，购买失败！");
		}
		
		return mav;
	}
}
