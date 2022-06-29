package com.spring_movie.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.spring.memberDto.MovieDto;
import com.spring.memberDto.ReservationDto;
import com.spring.memberDto.ReserveInfoDto;
import com.spring.memberDto.ReviewDto;
import com.spring.memberDto.SchedulesDto;
import com.spring.memberDto.TheatersDto;
import com.spring_movie.Dao.MovieDao;
@Service
public class MovieService {
	
	@Autowired
	private MovieDao mvdao;
	
	@Autowired
	HttpSession session;

	public ModelAndView getCgvMovieList() throws IOException {
		System.out.println("MovieService.getCgvMovieList()호출");
		
		ModelAndView mav = new ModelAndView();
		
		String cgvMovieUrl = "http://www.cgv.co.kr/movies/?lt=1&ft=0";
		
		Document doc = Jsoup.connect(cgvMovieUrl).get();
		
		Elements movieList_div = doc.select("div.sect-movie-chart");
		
		Elements movieList_ol = movieList_div.eq(0).select("ol");
		
		ArrayList<MovieDto> cgvMvList = new ArrayList<MovieDto>();
		
		for(int i = 0; i < movieList_ol.select("li").size(); i++) {
			
			MovieDto mv = new MovieDto();
			/*
			System.out.println(elements_ol.select("li").eq(i).select("strong.rank").text());
			System.out.println(elements_ol.select("li").eq(i).select("strong.tltle").text());
			System.out.println(elements_ol.select("li").eq(i).select("div.score").text());
			System.out.println(elements_ol.select("li").eq(i).select("span.txt_info").text());
			*/
			String detailUrl ="http://www.cgv.co.kr" + movieList_ol.select("li").eq(i).select("div.box-image a").eq(0).attr("href");
			//System.out.println(detailUrl);
			
			Document detailDoc = Jsoup.connect(detailUrl).get();
			Elements baseMovie = detailDoc.select("div.sect-base-Movie");
			//System.out.println(baseMovie.size());
			String movieTitle = baseMovie.select("div.box-contents div.title strong").text();
			String moviePd = baseMovie.select("div.box-contents div.spec dd").eq(0).text();
			String posterUrl = baseMovie.select("div.box-image span.thumb-image img").attr("src");
			String movieActors = baseMovie.select("div.box-contents div.spec dd.on").eq(0).text();
			String movieGenre  = baseMovie.select("div.box-contents div.spec dd.on").eq(0).next().text().replace("장르","");
			String movieGrade = baseMovie.select("div.box-contents div.spec dd.on").eq(1).text().split(",")[0];
			String movieTime = baseMovie.select("div.box-contents div.spec dd.on").eq(1).text().split(",")[1];
			String movieOpen = baseMovie.select("div.box-contents div.spec dd.on").eq(2).text();
			//System.out.println("movieTitle : " +movieTitle);
			mv.setMvname(movieTitle);
			//System.out.println("posterUrl : " + posterUrl);
			mv.setMvposter(posterUrl);
			//System.out.println("moviePd : " + moviePd);
			mv.setMvpd(moviePd);
			//System.out.println("movieActors : " + movieActors);
			mv.setMvactor(movieActors);
			//System.out.println("movieGenre"+movieGenre);
			mv.setMvgenre(movieGenre);
			//System.out.println("movieGrade : "+movieGrade);
			mv.setMvage(movieGrade);
			//System.out.println("movieTime : "+movieTime);
			mv.setMvtime(movieTime);
			//System.out.println("movieOpen : "+movieOpen);
			mv.setMvopen(movieOpen);
			
			
			cgvMvList.add(mv);
			
		}
		System.out.println(cgvMvList);
		
		for(int i = 0; i < cgvMvList.size(); i++) {
			//0.이미 등록된 영화라면 등록 x (영화제목과 개봉일을 where을 활용하여 등록할지 안할지 구분한다
			String mvname = cgvMvList.get(i).getMvname();
			String mvopen = cgvMvList.get(i).getMvopen();
					
			String selectMovie = mvdao.getselectMovie(mvname,mvopen);
			//1.영화코드 생성 (select)
			if(selectMovie == null) {
				String max = mvdao.getMax();
				String mvcode = "MV";
				
				//max = 1
				if(max ==null) {
					mvcode = mvcode + "001";
				}else {
					
					max = max.substring(2);
					int maxCode = Integer.parseInt(max)+1;
					if(maxCode < 10) {
						mvcode = mvcode + "00" + maxCode;
					}else if(maxCode <100) {
						mvcode = mvcode + "0" + maxCode;
					}else {
						mvcode = mvcode + maxCode;
					}
				}
				cgvMvList.get(i).setMvcode(mvcode);
				//2.영화정보 insert 
				
				int insertMovie = mvdao.insertMovie(cgvMvList.get(i));
			}
			
		}
		System.out.println("영화정보 insert 시작");
		
		mav.setViewName("redirect:/");
		
		return mav;
	}
	//영화목록 조회
	public ModelAndView movieList() {
		System.out.println("MovieService.movieList()호출");
		ModelAndView mav = new ModelAndView();
		//1.영화목록 조회
		ArrayList<MovieDto>mvList = mvdao.selectMovieList();
		for (int i = 0; i < mvList.size(); i++) {
			String mvcode = mvList.get(i).getMvcode();
			ArrayList<ReviewDto>reviewList = mvdao.selectReviewList(mvcode);
			
			int totalReservation = mvdao.selectCountReservation();
			
			System.out.println("totalReservation : " + totalReservation);
			
			//영화 예매수 조회
			int mvCountReservation = mvdao.selectMvReservation(mvcode);
			
			System.out.println("mvCountReservation : " + mvCountReservation);
			
			//소수점 
			double reservationRatio = (double)mvCountReservation/totalReservation * 100;
			
			mvList.get(i).setReservationRatio(Math.round(reservationRatio*100)/100.0);
			
			
			int goodcount = 0;
			int badcount = 0;
			for(int j = 0; j < reviewList.size(); j++) {
				
				if(reviewList.get(j).getRvrecommend() == 1) {
					goodcount++;
				}else {
					badcount++;
				}
			}
			
			
			
			
			mvList.get(i).setGoodRecommend(goodcount);
			mvList.get(i).setBadRecommend(badcount);
			
		}
		
		
		
		System.out.println(mvList);
		
		mav.addObject("mvList", mvList);
		//2.영화목록 페이지
		mav.setViewName("movie/MovieList");
		
		return mav;
	}
	
	//영화 상세보기
	public ModelAndView movieView(String mvcode) {
		System.out.println("MovieService.movieView()호출");
		ModelAndView mav = new ModelAndView();
		
		//영화정보 조회
		MovieDto movieView = mvdao.selectView(mvcode);
		
		//관람평 목록 조회 
		ArrayList<ReviewDto>reviewList = mvdao.selectReviewList(mvcode);
		
		ArrayList<MovieDto>getcommend = mvdao.getcommend();
		int goodcount = 0;
		int badcount = 0;
		for (int i = 0; i < reviewList.size(); i++) {
			String rvcomment = reviewList.get(i).getRvcomment();
			rvcomment = rvcomment.replace("\r\n", "<br>");
			rvcomment = rvcomment.replace(" ", "&nbsp;");
			reviewList.get(i).setRvcomment(rvcomment);
			
			
			if(reviewList.get(i).getRvrecommend() == 1) {
				goodcount++;
			}else  {
				badcount++;
			}
			
		}
		
		movieView.setGoodRecommend(goodcount);
		movieView.setBadRecommend(badcount);
		
		//전체 예매수 조회 
		int totalReservation = mvdao.selectCountReservation();
		
		System.out.println("totalReservation : " + totalReservation);
		
		//영화 예매수 조회
		int mvCountReservation = mvdao.selectMvReservation(mvcode);
		
		System.out.println("mvCountReservation : " + mvCountReservation);
		
		//소수점 
		double reservationRatio = (double)mvCountReservation/totalReservation * 100;
		
		movieView.setReservationRatio(Math.round(reservationRatio*100)/100.0);
		
		System.out.println("reservationRatio : " +reservationRatio);
		mav.addObject("reviewList", reviewList);
		mav.addObject("mvInfo",movieView);
		mav.setViewName("movie/MovieView");
		
		return mav;
	}
	
	//영화 예매 페이지 이동
	public ModelAndView movieReservationPage() {
		System.out.println("MovieService.movieReservationPage()호출");
		ModelAndView mav = new ModelAndView();
		
		//1.영화목록 영화목록 조회(예매가능한 영화)
		ArrayList<MovieDto> reMvList = mvdao.selectReserveMvList();
		
		System.out.println(reMvList);
		mav.addObject("reMvList", reMvList);
		mav.setViewName("movie/MovieReservationPage");
		
		return mav;
	}
	//극장 목록 조회
	public String getThList(String mvcode) {
		
		
		ArrayList<TheatersDto> thList = mvdao.getThList(mvcode);
		System.out.println("극장 목록 조회 기능 호출");
		
		Gson gson= new Gson();
		String thList_json = gson.toJson(thList);
		System.out.println(thList_json);

		return thList_json;
	}
	
	//예매가능 날짜 목록 조회
	public String getScDateList(String mvcode, String thcode) {
		
		ArrayList<SchedulesDto>scDateList = mvdao.getscDateList(mvcode,thcode);
		
		Gson gson = new Gson();
		String scDateList_json = gson.toJson(scDateList);
		
		System.out.println(scDateList_json);
		
		return scDateList_json;
	}
	
	//상영관 및 시간 출력
	public String getRoomTime(String mvcode, String thcode, String scdate) {

		ArrayList<SchedulesDto>getRoomTime = mvdao.getTimeRoom(mvcode,thcode,scdate);
		
		Gson gson = new Gson();
		String getRoomTime_json = gson.toJson(getRoomTime);
		
		System.out.println(getRoomTime_json);
		
		return getRoomTime_json;
	}
	//예약내역 insert기능 
	public ModelAndView movieReservation(RedirectAttributes ra, ReservationDto reInfo) {
		System.out.println("movieReservation.getScDateList()호출");
		
		ModelAndView mav = new ModelAndView();
		
		
		String recode = "RE";
		String maxRecode = mvdao.getMaxRecode();
		
		if(maxRecode == null) {
			recode = recode + "01";
		}else {
			maxRecode = maxRecode.substring(2); //'RE01' >>'02'
			int codeNum = Integer.parseInt(maxRecode)+1;
			if(codeNum < 10) {
			recode = recode + "0" + codeNum;
			}else {
				recode = recode + codeNum;
			}
		}
		System.out.println(recode);
		reInfo.setRecode(recode);
		System.out.println("예매정보");
		System.out.println(reInfo);
		mvdao.insertReservationInfo(reInfo);
		
		
		ReserveInfoDto reserveInfo = mvdao.selectResevationInfo(recode);
		ra.addFlashAttribute("reserveInfo",reserveInfo);
		mav.setViewName("redirect:/");
		return mav;
	}
	
	//예매내역 조회
	public ModelAndView movieReservationList(RedirectAttributes ra ) {
		System.out.println("movieReservation.getScDateList()호출");
		
		
		ModelAndView mav = new ModelAndView();
		
		String remid = (String) session.getAttribute("loginId");
		
		System.out.println(remid);
		
		if(remid == null) {
			ra.addFlashAttribute("msg","로그인 후 이용가능합니다");
			mav.setViewName("redirect:/");
		}else {
			ArrayList<ReserveInfoDto>reInfoList = mvdao.selectReservationList(remid);
			for(int i = 0; i < reInfoList.size(); i++) {
				ReviewDto review = mvdao.selectReviewInfo(reInfoList.get(i).getRecode());
				System.out.println(reInfoList.get(i).getRecode());
				
				if(review != null) {
					String rvcomment = review.getRvcomment();
					rvcomment = rvcomment.replace("|w|n", "<br>");
					rvcomment = rvcomment.replace(" ", "&nbsp");
					review.setRvcomment(rvcomment);
					
				}
				reInfoList.get(i).setReview(review);
			
			}
			
			System.out.println(reInfoList);
			mav.addObject("reInfoList",reInfoList);
			
			mav.setViewName("movie/ReservationList");
			
		}
		
		
		
		return mav;
	}
	
	//예매취소 메소드
	public ModelAndView reservationCancel(RedirectAttributes ra, String recode) {
		System.out.println("movieReservation.reservationCancel()호출");
		ModelAndView mav = new ModelAndView();
		mvdao.deleteReservation(recode);
		
		ra.addFlashAttribute("msg","예매가 취소되었습니다");
		
		mav.setViewName("redirect:/movieReservationList");
		
		return mav;
	}
	//관람평 작성 
	public ModelAndView reviewWrite(RedirectAttributes ra, ReviewDto review) {
		System.out.println("movieReservation.reviewWrite()호출");
		ModelAndView mav = new ModelAndView();
		System.out.println("관람평 정보 : " + review);
		
		
		mvdao.insertReview(review);
		
		
		ra.addFlashAttribute("msg" , "관람평이 작성 되었습니다.");
		mav.setViewName("redirect:/");
		
		
		return mav;
	}
	
	//영화 검색 기능
	public ModelAndView movieSelect(String searchName) {
		System.out.println("movieReservation.movieSelect()호출");
		ModelAndView mav = new ModelAndView();
		
		//영화 검색 목록
		ArrayList<MovieDto>selectMovie = mvdao.searchMovie(searchName);
		
		System.out.println(selectMovie);
		
		
		//예매가능한 영화 검색 목록
		ArrayList<MovieDto>selectReMovie = mvdao.selectReMovie(searchName);
	
		
		mav.addObject("searchMovie",selectMovie);
		mav.addObject("selectReMovie",selectReMovie);
		mav.setViewName("movie/searchMovie");
		return mav;
	}

	
	
}
