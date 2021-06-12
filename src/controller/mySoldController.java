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
public class mySoldController {
	@RequestMapping(value="/mySold",method=RequestMethod.GET)
	public ModelAndView defaultEnter(ModelAndView mav,HttpSession httpSession) throws IOException{
		Account currentAccount=(Account)httpSession.getAttribute("currentAccount");
		TransactionDocDAO tDao=new TransactionDocDAO();
		List<Transaction> listOfTransactions =tDao.getMySoldTransactions(currentAccount.getId());
		mav.setViewName("mySold");
		mav.addObject("listOfTransactions",listOfTransactions);
		return mav;
	}
	@RequestMapping(value="/mySold",method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getMySold(HttpSession httpSession) throws IOException{
		Account currentAccount=(Account)httpSession.getAttribute("currentAccount");
		TransactionDocDAO tDao=new TransactionDocDAO();
		List<Transaction> listOfTransactions =tDao.getMySoldTransactions(currentAccount.getId());
		Map<String,String> listOfContact=new HashMap<>();
		Map<String, String>listOfGoodsImg=new HashMap<>();	//Map的key必须string，否则下面转换json后传给前端无法解析
		AccountInfoDocDAO aidDAO=new AccountInfoDocDAO();
		GoodsInfoDocDAO gidDAO=new GoodsInfoDocDAO();
		for(Transaction transaction : listOfTransactions){
			String buyerId=transaction.getBuyerId();
			String contactInfo=aidDAO.getAccount(buyerId).getContactInfo();
			listOfContact.put(buyerId, contactInfo);
			Integer goodsId=transaction.getGoodsId();
			String pictureId=gidDAO.getGoods(goodsId).getPictureId();
			listOfGoodsImg.put(goodsId.toString(), pictureId);
		}
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("listOfTransactions", JSONObject.toJSON(listOfTransactions));
		jsonObject.put("listOfContact", listOfContact);
		jsonObject.put("listOfGoodsImg", listOfGoodsImg);
//		System.out.println(jsonObject.toJSONString());
		return jsonObject.toJSONString();
	}
}

