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
public class EditPasswordController {
	@RequestMapping(value="/editPassword",method=RequestMethod.GET)
	public ModelAndView defaultEnter(ModelAndView mav){
		mav.setViewName("editPassword");
		return mav;
	}
	
	@RequestMapping(value="/editPassword",method=RequestMethod.POST)
	public ModelAndView editPassword(HttpSession httpSession,ModelAndView mav,String originalPw,String newPw) throws IOException{
		Account currentAccount=(Account)httpSession.getAttribute("currentAccount");
		if(!originalPw.equals(currentAccount.getPassword())){
			mav.setViewName("fail");
			mav.addObject("message","fail because wrong original password ");
		}else{
			currentAccount.setPassword(newPw);
			AccountInfoDocDAO aidDAO=new AccountInfoDocDAO();
			if(!aidDAO.updateAccountPw(currentAccount)){
				mav.setViewName("fail");//如果想重定向，需要再写一个failController
				mav.addObject("message","fail because the id existing!");
			}else{
				mav.setViewName("success");
				mav.addObject("message","success, please login in again");
				httpSession.setAttribute("currentAccount", null);
			}
			return mav;
		}
		
		return mav;
	}
}
