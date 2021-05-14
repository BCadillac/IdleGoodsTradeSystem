package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pojo.Account;


@Controller
public class PersonalCenterController {
	@RequestMapping(value="/personalCenter",method=RequestMethod.GET)
	public ModelAndView enterRegister(HttpSession httpSession,ModelAndView mav){
		Account currentAccount=(Account)httpSession.getAttribute("currentAccount");
		mav.addObject("id",currentAccount.getId());
		mav.addObject("contactInfo",currentAccount.getContactInfo());
		return mav;
	}
}
