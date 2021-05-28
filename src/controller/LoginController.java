package controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DAO.AccountInfoDocDAO;
import pojo.Account;
 
@Controller
public class LoginController{
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView enterLogin()throws Exception{
		return new ModelAndView("login");
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView handleLogin(Account inputAccount,HttpSession httpSession,ModelAndView mav) throws IOException{
		AccountInfoDocDAO aidDAO=new AccountInfoDocDAO();	
		//����û�ID�Ƿ����
		if(!aidDAO.isIdExisting(inputAccount.getId())){
			mav.setViewName("login");
			mav.addObject("failMessage","�û�ID������");
		}else{
			//����id�������ݿ�õ�����
			Account docAccount=aidDAO.getAccount(inputAccount.getId());
			//���ݿ���֤����
			if(docAccount.getPassword().equals(inputAccount.getPassword())){
				httpSession.setAttribute("currentAccount", docAccount);
				mav.setViewName("redirect:/home");
			}else{
				mav.setViewName("login");
				mav.addObject("failMessage","�������");
			}
		}
		return mav;
	}
	
	
	
}