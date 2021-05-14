package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DAO.TransactionDocDAO;
import pojo.Account;
import pojo.Transaction;

@Controller
public class myBoughtController {
	@RequestMapping(value="/myBought",method=RequestMethod.GET)
	public ModelAndView defaultEnter(ModelAndView mav,HttpSession httpSession) throws IOException{
		Account currentAccount=(Account)httpSession.getAttribute("currentAccount");
		TransactionDocDAO tDao=new TransactionDocDAO();
		List<Transaction> listOfTransactions =tDao.getMyBroughtTransactions(currentAccount.getId());
		mav.setViewName("myBought");
		mav.addObject("listOfTransactions",listOfTransactions);
		return mav;
	}
}
