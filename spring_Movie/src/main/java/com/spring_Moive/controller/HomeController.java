package com.spring_Moive.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "Main";
	}
	
	@RequestMapping (value = "/movieMain", method = RequestMethod.GET)
	public String MovieMain() {
	
			return "MovieMain";
	}
	
	
	@RequestMapping (value = "/adminMain", method = RequestMethod.GET)
	public String adminMain(String inputPw,RedirectAttributes ra) {
		String Pw = "1234";
		
		if(Pw.equals(inputPw)) {
			return "AdminMain";
		}else {
			ra.addFlashAttribute("msg" , "관리자 비밀번호가 일치하지 않습니다.");
			return "redirect:/";
		}
		
		
	}
	
}
