package com.spring_Moive.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.memberDto.ReservationDto;
import com.spring.memberDto.ReviewDto;
import com.spring_movie.service.MovieService;

@Controller
public class MovieController {

	
	@Autowired
	private MovieService mvsvc;
	
	@RequestMapping (value="/getCgvMovieList")
	public ModelAndView getCgvMovieList() throws IOException {
		
		ModelAndView mav = mvsvc.getCgvMovieList();
		
		return mav;
	}
	
	@RequestMapping (value="/movieList")
	public ModelAndView movieList() {
		System.out.println("영화목록 페이지 요청");
		
		ModelAndView mav = mvsvc.movieList();
		
		return mav;
	}

	@RequestMapping (value="/movieView")
	public ModelAndView movieView(HttpServletRequest request) {
		System.out.println("영화 상세보기 페이지 이동요청");
		
		String mvcode = request.getParameter("mvcode");
		System.out.println(mvcode);
		ModelAndView mav = mvsvc.movieView(mvcode);
		
		return mav;
	}
	
	@RequestMapping (value="/movieReservationPage")
	public ModelAndView movieReservationPage() {
		System.out.println("영화예매 페이지 이동 요청");
		
		ModelAndView mav = mvsvc.movieReservationPage();
		
		return mav;
	}


	@RequestMapping (value="/getThList")
	public @ResponseBody String getThList(HttpServletRequest request) {
		System.out.println("극장 목록 조회 ");
		String mvcode = request.getParameter("mvcode");
		System.out.println(mvcode);
		String reThList = mvsvc.getThList(mvcode);
		return reThList;
	}
	
	
	//영화 예매가능 날짜 목록 조회 
	@RequestMapping (value="/getScDateList")
	public @ResponseBody String getScDateList(HttpServletRequest request) {
		System.out.println("예매가능한 날짜 목록 조회 ");
		String mvcode = request.getParameter("mvcode");
		String thcode = request.getParameter("thcode");
	
		System.out.println(mvcode);
		System.out.println(thcode);
		
		String scDateList = mvsvc.getScDateList(mvcode ,thcode);
		
		return scDateList;
		
		
	}
	
	//상영관 및 시간 목록 조회
	@RequestMapping (value="/getScRoomTimeList")
	public @ResponseBody String getScRoomTimeList(HttpServletRequest request){
		System.out.println("예매가능한 상영관 및 시간");
		String mvcode = request.getParameter("mvcode");
		String thcode = request.getParameter("thcode");
		String scdate = request.getParameter("scdate");
		
		System.out.println(mvcode);
		System.out.println(thcode);
		System.out.println(scdate);
		
		String scRoomTime = mvsvc.getRoomTime(mvcode , thcode, scdate);
		
		
		return scRoomTime;
	}

	
	@RequestMapping (value="/movieReservation")
	public ModelAndView insertResult(RedirectAttributes ra , ReservationDto  reInfo) {
		System.out.println("영화예매 요청");
		
		
		
		ModelAndView mav = mvsvc.movieReservation(ra ,reInfo);
		
		
		return mav;
	}


	@RequestMapping(value="/movieReservationList")
	public ModelAndView movieReservationList(RedirectAttributes ra ) {
		System.out.println("예매내역 페이지 이동요청 ");
		
		ModelAndView mav = mvsvc.movieReservationList(ra);
		return mav;
	}

	//예매취소 
	@RequestMapping(value="/reservationCancel")
	public ModelAndView reservationCancel(RedirectAttributes ra,String recode ) {
		System.out.println("취소할 예매코드  : " + recode );
			
		
			System.out.println("예매취소 요청 ");
		
		ModelAndView mav = mvsvc.reservationCancel(ra,recode);
		return mav;
	}
	

	@RequestMapping(value="/reviewWrite")
	public ModelAndView reviewWrite(RedirectAttributes ra , ReviewDto review, String rvmvcode) {
		System.out.println("리뷰 작성 요청");
		System.out.println(rvmvcode);
		review.setRemvcode(rvmvcode);
		
		ModelAndView mav = mvsvc.reviewWrite(ra,review);
		return mav;
	}
	
	//영화검색 기능
	@RequestMapping(value="/movieSelect")		
	public ModelAndView movieSelect(HttpServletRequest request) {
		System.out.println("영화 검색 요청");
		String searchName = request.getParameter("searchName");
		
		
		System.out.println(searchName);
		
		ModelAndView mav = mvsvc.movieSelect(searchName);
		return mav;
	}
	
	
	
	



}
