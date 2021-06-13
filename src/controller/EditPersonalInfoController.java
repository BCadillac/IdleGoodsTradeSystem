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
			mav.setViewName("editPersonalInfo");
			mav.addObject("failMessage","该ID已存在！");
		}else{
			Account currentAccount =(Account)httpSession.getAttribute("currentAccount");
			Map<String, String> updateInfo=new HashMap<String, String>();
			updateInfo.put("newId", inputAccount.getId());
			updateInfo.put("formerId", currentAccount.getId());
			updateInfo.put("contactInfo", inputAccount.getContactInfo());
			updateInfo.put("password", currentAccount.getPassword());
			if(aidDAO.updateAccount(updateInfo)){
				httpSession.setAttribute("currentAccount", null);
				mav.setViewName("editPersonalInfo");
				mav.addObject("successMessage","成功！请重新登录！");
			}else{
				mav.setViewName("editPersonalInfo");
				mav.addObject("failMessage","修改失败！请联系系统管理员");
			}
		}		
		return mav;
	}
}