package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DAO.AccountInfoDocDAO;
import pojo.Account;

@Controller
public class EditPersonalInfoController {
	@RequestMapping(value="/editPersonalInfo",method=RequestMethod.GET)
	public ModelAndView defaultEnter(HttpSession httpSession,ModelAndView mav){
		Account currentAccount=(Account)httpSession.getAttribute("currentAccount");
		mav.setViewName("editPersonalInfo");
		mav.addObject("id",currentAccount.getId());
		mav.addObject("contactInfo",currentAccount.getContactInfo());
		return mav;
	}
	
	@RequestMapping(value="editPersonalInfo",method=RequestMethod.POST)
	public  ModelAndView handleEdit(Account inputAccount,ModelAndView mav,HttpSession httpSession) throws IOException{
		AccountInfoDocDAO aidDAO=new AccountInfoDocDAO();
		if(aidDAO.isIdExisting(inputAccount.getId())){
			mav.setViewName("fail");
			mav.addObject("message","fail because the id is existing!");
		}else{
			Account currentAccount =(Account)httpSession.getAttribute("currentAccount");
			Map<String, String> updateInfo=new HashMap<String, String>();
			updateInfo.put("newId", inputAccount.getId());
			updateInfo.put("formerId", currentAccount.getId());
			updateInfo.put("contactInfo", inputAccount.getContactInfo());
			updateInfo.put("password", currentAccount.getPassword());
			if(aidDAO.updateAccount(updateInfo)){
				mav.setViewName("success");
				mav.addObject("message","success!please re login");
			}else{
				mav.setViewName("fail");
				mav.addObject("message","fail because update error!");
			}
		}		
		return mav;
	}
}