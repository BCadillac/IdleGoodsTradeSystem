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
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView defaultEnterSystem()throws Exception{
		return new ModelAndView("redirect:/login");
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView enterLogin()throws Exception{
		return new ModelAndView("login");
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView handleLogin(Account inputAccount,HttpSession httpSession,ModelAndView mav) throws IOException{
		AccountInfoDocDAO aidDAO=new AccountInfoDocDAO();
		//ModelAndView mav=new ModelAndView();
				
		//check id existing
		if(!aidDAO.isIdExisting(inputAccount.getId())){
			mav.setViewName("login");
			mav.addObject("failMessage","fail because the id is not existing");
		}else{
			//根据id查找数据库得到密码
			Account docAccount=aidDAO.getAccount(inputAccount.getId());
			//数据库验证密码
			if(docAccount.getPassword().equals(inputAccount.getPassword())){
				//later should been changed to home page
				//mav.setViewName("success");
				//mav.addObject("message","login success");
				httpSession.setAttribute("currentAccount", docAccount);
				mav.setViewName("redirect:/home");
			}else{
				mav.setViewName("login");
				mav.addObject("failMessage","fail because wrong password ");
			}
		}
		return mav;
	}
	
	
	
}