package com.spring.memberDto;

public class ReserveInfoDto {

	private String mvcode;
	private String mvname;
	private String mvposter;

	private String thname;

	private String scroom;
	private String scdate;


	private String recode;
	private String reamount;

	private ReviewDto review; // 관람평 정보
	
	


	public ReviewDto getReview() {
		return review;
	}
	
	public void setReview(ReviewDto review) {
		this.review = review;
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

	public String getMvposter() {
		return mvposter;
	}

	public void setMvposter(String mvposter) {
		this.mvposter = mvposter;
	}

	public String getThname() {
		return thname;
	}

	public void setThname(String thname) {
		this.thname = thname;
	}

	public String getScroom() {
		return scroom;
	}

	public void setScroom(String scroom) {
		this.scroom = scroom;
	}

	public String getScdate() {
		return scdate;
	}

	public void setScdate(String scdate) {
		this.scdate = scdate;
	}

	public String getRecode() {
		return recode;
	}

	public void setRecode(String recode) {
		this.recode = recode;
	}

	public String getReamount() {
		return reamount;
	}

	public void setReamount(String reamount) {
		this.reamount = reamount;
	}

	@Override
	public String toString() {
		return "ReserveInfoDto [mvcode=" + mvcode + ", mvname=" + mvname + ", mvposter=" + mvposter + ", thname="
				+ thname + ", scroom=" + scroom + ", scdate=" + scdate + ", recode=" + recode + ", reamount=" + reamount
				+ ", review=" + review + "]";
	}

}
