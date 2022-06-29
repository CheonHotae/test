package com.spring_movie.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.memberDto.memberDto;
import com.spring_movie.Dao.MemberDao;

@Service
public class MemberService {

	private ModelAndView mav = new ModelAndView();

	@Autowired
	private MemberDao mdao;

	@Autowired
	private HttpSession session;
	
	//이미지 파일 저장 경로 설정
	private String savePath = "C:\\Users\\user\\Documents\\workspace-spring-tool-suite-4-4.14.1.RELEASE\\spring_Movie\\src\\main\\webapp\\resources\\mprofileUpLoad";

	public ModelAndView memberJoin(memberDto member) throws IllegalStateException, IOException {

		System.out.println("MemberService.memberJoin()");
		mav = new ModelAndView();
		MultipartFile mfile = member.getMfile();

		System.out.println(mfile.isEmpty()); // 첨부파일이 있는지없는지 비교해주는 방법
		String mprofile = "";
		if (!mfile.isEmpty()) {
			System.out.println("첨부파일 있음");

			// 32자리의 임의코드를 만들어주는 명령어
			UUID uuid = UUID.randomUUID();
			System.out.println(uuid.toString() + "_" + mfile.getOriginalFilename());
			// 1.파일명 생성 (파일명이 중복되지않게 생성)
			mprofile = uuid.toString() + "_" + mfile.getOriginalFilename();
			// 프로필 이미지 파일 저장
			mfile.transferTo(new File(savePath, mprofile));

		}
		
		System.out.println("mprofile : " + mprofile);
		member.setMprofile(mprofile);
		
		//주소 처리
		member.setMaddress(member.getMpostcode() + "_" + member.getMaddr() + "_" + 
		member.getMdetailAddress() + "_" + member.getMextraaddr());
		
		
		// 회원가입 처리 (dao - insert 문)
		int joinResult = mdao.insertMember(member);

		// 2.저장경로 설정
		// 3.파일을 저장
		// 4.회원가입

		// 파일저장 파일이름
		//직접 주소 연결 
		//mav.setViewName("Main");
		
		mav.setViewName("redirect:/");
		
		return mav;
	}
	//아이디 중복확인 
	public String memberIdCheck(String inputId) {
		System.out.println("MemberService.memberIdCheck()호출 ");
		
		String memberIdCheck = mdao.selectId(inputId);
	
		return memberIdCheck;
	}
	public ModelAndView getLogin(String mid, String mpw ,RedirectAttributes ra ) {
		System.out.println("MemberService.memberLogin()호출");
		System.out.println("입력한 아이디 : " + mid);
		System.out.println("입력한 비밀번호 : " + mpw);
		
		
		memberDto loginMember = mdao.SelectMemberLogin(mid,mpw);
		
		System.out.println(loginMember);
		
		if(loginMember != null) {
			//로그인 성공
			session.setAttribute("loginId", loginMember.getMid());
			session.setAttribute("loginProfile", loginMember.getMprofile());
			mav.setViewName("redirect:/");
		}else {
			//로그인 실패
			ra.addFlashAttribute("msg", "아이디 또는 비밀번호가 일치 하지 않습니다.");
			mav.setViewName("redirect:/memberLoginForm");
			//redirect 통해서 페이지를 넘겨줄때만 ra 메세지 호출 
			
			/*
			mav.addObject("msg",  "아이디 또는 비밀번호가 일치하지 않습니다.");
			mav.setViewName("Member/MemberLoginForm");
			*/
		}
		
		return mav;
	}
	
	//로그아웃 기능
	public ModelAndView memberLogout(RedirectAttributes ra) {
		System.out.println("MemberService.memberLogout() 호출");
		session.invalidate();
		ra.addFlashAttribute("msg", "로그아웃 되었습니다.");
		
		mav.setViewName("redirect:/");
		
		return mav;
	}
	//회원정보 페이지
	public ModelAndView memberView() {
		System.out.println("MemberService.memberView() 호출");
		
		//로그인된 아이디 가져오기 
		String loginId = (String)session.getAttribute("loginId");
		
		System.out.println("로그인된 아이디 " + loginId );
		
		memberDto myInfo = mdao.myInfo(loginId);
		System.out.println(myInfo);
		mav.setViewName("Member/MemberView");
		//주소 분리 
		String maddress = myInfo.getMaddress();
		String[]maddress_arr = maddress.split("_");
		
		if(maddress_arr.length >=4) {
			myInfo.setMpostcode(maddress_arr[0]);
			myInfo.setMaddr(maddress_arr[1]);
			myInfo.setMdetailAddress(maddress_arr[2]);
			myInfo.setMextraaddr(maddress_arr[3]);	
		}
		
		
		if(myInfo != null) {
			//가져온 정보들 담기
			session.setAttribute("myid", myInfo.getMid());
			session.setAttribute("mypw", myInfo.getMpw());
			session.setAttribute("myname", myInfo.getMname());
			session.setAttribute("mybirth", myInfo.getMbirth());
			session.setAttribute("myemail", myInfo.getMemail());
			session.setAttribute("myprofile", myInfo.getMprofile());
			session.setAttribute("myaddress", myInfo.getMaddress());
		}
		
		return mav;
	}
	public ModelAndView memberKaKaoLogin(memberDto member, RedirectAttributes ra) {
		System.out.println("MemberService.memberKaKaoLogin() 호출");
		
		memberDto KaKaomember = mdao.selectMemberKaKao(member.getMid());
		System.out.println(KaKaomember);
		
		if(KaKaomember != null) {
			//로그인처리 
			session.setAttribute("loginId", KaKaomember.getMid());
			session.setAttribute("loginProfile", KaKaomember.getMprofile());
			ra.addFlashAttribute("msg","카카오계정으로 로그인 되었습니다.");
			mav.setViewName("redirect:/");
		}else {
			//회원가입 처리
			member.setMpw("1234");
			mdao.insertMemberKaKao(member);
			ra.addFlashAttribute("msg","회원정보가 등록 되었습니다. 다시 로그인 해주세요.");
			mav.setViewName("redirect:/memberLoginForm");
		}
		
		return mav;
	}
	
	

}
