package com.spring_Moive.controller;



import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.memberDto.memberDto;

import com.spring_movie.service.MemberService;


@Controller
public class MemberController {
	
	
	private ModelAndView mav;
	
	@Autowired
	private MemberService mscv;
	
	
	@RequestMapping(value = "/memberJoinForm")
	public String memberJoinForm(Model model) {
		System.out.println("회원가입 페이지 이동 요청");
		model.addAttribute("testdat1" , 1234);
		return "Member/MemberJoinForm";
	}
	
	@RequestMapping(value="/memberJoin")
	public ModelAndView memberJoin(memberDto member , Model model) throws IllegalStateException, IOException {
		System.out.println("회원가입 요청");
		
		System.out.println(member);
		
		/* mav = 서비스; */
		mav = mscv.memberJoin(member);
		return mav;
	}
	
	@RequestMapping(value="/memberIdCheck")
	public @ResponseBody String memberIdCheck(String inputId) {
		//데이터만 받아주는 controller를 사용하기 위해서는  @ResponseBody 사용한다
		System.out.println("아이디 중복 확인 요청");
		System.out.println("입력한 아이디 : " + inputId);
		
		String idCheckResult = mscv.memberIdCheck(inputId);
		
		return idCheckResult; //"OK.jsp "
	}
	
	
	@RequestMapping(value="/memberLoginForm")
	public String memberLoginForm() {
		System.out.println("로그인 페이지 요청");
	
		
		return "Member/MemberLoginForm";
	}
	
	@RequestMapping(value="/memberLogin")
	public ModelAndView memberLogin(String mid , String mpw , RedirectAttributes ra) {
		System.out.println("로그인 요청");
		
		mav = mscv.getLogin(mid,mpw,ra);
		
		
		return mav;
	}
	
	@RequestMapping(value="/memberLogout")
	public ModelAndView memberLogout(RedirectAttributes ra) {
		System.out.println("로그아웃 요청");
		
		mav = mscv.memberLogout(ra);
		return mav;
		
	}
	
	//내정보 요청 
	@RequestMapping(value="/memberView")
	public ModelAndView memberView() {
		System.out.println("회원정보 페이지");
		
		mav = mscv.memberView();
		
		return mav;
		
	}
	
	
	
	@RequestMapping(value="/memberKaKaoLogin")
	public ModelAndView memberKaKaoLogin(memberDto member,RedirectAttributes ra) {
		System.out.println("카카오 로그인 요청 ");
		System.out.println(member);
		ModelAndView mav = mscv.memberKaKaoLogin(member,ra);
		return mav;
	}
	
	
	
	
	
	
	
	
	
}
