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
			mav.setViewName("fail");//如果想重定向，需要再写一个failController
			mav.addObject("message","fail because the id existing!");
		}else{
			//write account into sql
			if(aidDAO.addAccount(account)){
				mav.setViewName("success");
				mav.addObject("message","success!");
			}else{
				mav.setViewName("fail");
				mav.addObject("message","fail because insert error!");
			}
		}
		return mav;
	}
}
