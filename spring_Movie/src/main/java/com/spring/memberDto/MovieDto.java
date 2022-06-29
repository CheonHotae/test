package com.spring.memberDto;

public class MovieDto {
	private String mvcode;		//영화코드
	private String mvname;		//영화이름
	private String mvpd;		//영화감독
	private String mvactor;		//영화배우
	private String mvgenre;		//영화장르
	private String mvage;		//관람연령
	private String mvtime;		//관람시간
	private String mvopen;		//개봉일
	private String mvposter;	//포스터
	
	private int goodRecommend;  //추천
	private int badRecommend;	//비추천
	
	private double reservationRatio; // 예매율 
	
	public double getReservationRatio() {
		return reservationRatio;
	}
	public void setReservationRatio(double reservationRatio) {
		this.reservationRatio = reservationRatio;
	}
	public int getGoodRecommend() {
		return goodRecommend;
	}
	public void setGoodRecommend(int goodRecommend) {
		this.goodRecommend = goodRecommend;
	}
	public int getBadRecommend() {
		return badRecommend;
	}
	public void setBadRecommend(int badRecommend) {
		this.badRecommend = badRecommend;
	}
	public String getMvcode() {
		return mvcode;
	}
	public void setMvcode(String mvcode) {
		this.mvcode = mvcode;
	}
	public String getMvname() {
		return mvname;
	}
	public void setMvname(String mvname) {
		this.mvname = mvname;
	}
	public String getMvpd() {
		return mvpd;
	}
	public void setMvpd(String mvpd) {
		this.mvpd = mvpd;
	}
	public String getMvactor() {
		return mvactor;
	}
	public void setMvactor(String mvactor) {
		this.mvactor = mvactor;
	}
	public String getMvgenre() {
		return mvgenre;
	}
	public void setMvgenre(String mvgenre) {
		this.mvgenre = mvgenre;
	}
	public String getMvage() {
		return mvage;
	}
	public void setMvage(String mvage) {
		this.mvage = mvage;
	}
	public String getMvtime() {
		return mvtime;
	}
	public void setMvtime(String mvtime) {
		this.mvtime = mvtime;
	}
	public String getMvopen() {
		return mvopen;
	}
	public void setMvopen(String mvopen) {
		this.mvopen = mvopen;
	}
	public String getMvposter() {
		return mvposter;
	}
	public void setMvposter(String mvposter) {
		this.mvposter = mvposter;
	}
	@Override
	public String toString() {
		return "MovieDto [mvcode=" + mvcode + ", mvname=" + mvname + ", mvpd=" + mvpd + ", mvactor=" + mvactor
				+ ", mvgenre=" + mvgenre + ", mvage=" + mvage + ", mvtime=" + mvtime + ", mvopen=" + mvopen
				+ ", mvposter=" + mvposter + ", goodRecommend=" + goodRecommend + ", badRecommend=" + badRecommend
				+ ", reservationRatio=" + reservationRatio + "]";
	}
	
	
}
