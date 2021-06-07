package controller;

import java.io.IOException;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pojo.Account;
import DAO.AccountInfoDocDAO;

@Controller
public class RegisterController {
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView enterRegister(){
		return new ModelAndView("register");
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView handleRegister(Account account) throws IOException{
		AccountInfoDocDAO aidDAO=new AccountInfoDocDAO();
		ModelAndView mav=new ModelAndView();
		
		if(aidDAO.isIdExisting(account.getId())){
			mav.setViewName("register");//如果想重定向，需要再写一个failController
			mav.addObject("failMessage","抱歉，该用户ID已存在");
		}else{
			//write account into sql
			if(aidDAO.addAccount(account)){
				mav.setViewName("register");
				mav.addObject("successMessage","注册成功！");
			}else{
				mav.setViewName("register");
				mav.addObject("failMessage","注册失败！");
			}
		}
		return mav;
	}
}
