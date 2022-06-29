package com.spring_movie.Dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.spring.memberDto.MovieDto;
import com.spring.memberDto.ReservationDto;
import com.spring.memberDto.ReserveInfoDto;
import com.spring.memberDto.ReviewDto;
import com.spring.memberDto.SchedulesDto;
import com.spring.memberDto.TheatersDto;

public interface MovieDao {

	
	//영화중복 확인
	@Select( "select * from MOVIES where MVNAME = #{name} AND TO_Char(MVOPEN,'yyyy/mm/dd') = #{open}")
	String getselectMovie(@Param("name")String mvname,@Param("open")String mvopen);

	//영화코드 생성
	@Select("select MAX(MVCODE) from MOVIES")
	String getMax();

	//영화 등록
	@Insert("INSERT INTO MOVIES (MVCODE, MVNAME, MVPD, MVACTOR ,MVGENRE, MVAGE, MVTIME, MVOPEN, MVPOSTER )  "
			+ " VALUES(#{mvcode}, #{mvname}, #{mvpd}, #{mvactor}, #{mvgenre}, #{mvage}, #{mvtime}, #{mvopen}, #{mvposter})")
	int insertMovie(MovieDto movieDto);

	ArrayList<MovieDto> selectMovieList();

	MovieDto selectView(String mvcode);

	ArrayList<MovieDto> selectReserveMvList();
	

	ArrayList<TheatersDto> getThList(String mvcode);

	ArrayList<SchedulesDto> getscDateList(@Param("scmvcode")String mvcode, @Param("scthcode")String thcode);

	ArrayList<SchedulesDto> getTimeRoom(@Param("scmvcode")String mvcode, @Param("scthcode")String thcode, @Param("scdate")String scdate);

	String getMaxRecode();

	void insertReservationInfo(ReservationDto reInfo);

	ArrayList<ReserveInfoDto> selectReservationList(String remid);

	void deleteReservation(String recode);

	ReserveInfoDto selectResevationInfo(String recode);

	void insertReview(ReviewDto review);

	String selectReviewWriterCheck(String recode);

	

	ReviewDto selectReviewInfo(String rvrecode);

	ArrayList<ReviewDto> selectReviewList(String mvcode);

	ArrayList<MovieDto> getcommend();

	int selectCountReservation();

	int selectMvReservation(String mvcode);

	ArrayList<MovieDto> searchMovie(String searchName);

	ArrayList<MovieDto> selectReMovie(String searchName);


}
