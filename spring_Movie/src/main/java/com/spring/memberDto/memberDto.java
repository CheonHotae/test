package com.spring.memberDto;

import org.springframework.web.multipart.MultipartFile;

public class memberDto {
	private String mid;
	private String mpw;
	private String mname;
	private String mbirth;
	private String memail;
	
	private String maddress;
	private String mpostcode; 	//우편번호	
	private String maddr;		//주소
	private String mdetailAddress;//상세주소	
	private String mextraaddr;	//참고항목
	
	
	public String getMpostcode() {
		return mpostcode;
	}
	public void setMpostcode(String mpostcode) {
		this.mpostcode = mpostcode;
	}
	public String getMaddr() {
		return maddr;
	}
	public void setMaddr(String maddr) {
		this.maddr = maddr;
	}
	public String getMdetailAddress() {
		return mdetailAddress;
	}
	public void setMdetailAddress(String mdetailAddress) {
		this.mdetailAddress = mdetailAddress;
	}
	public String getMextraaddr() {
		return mextraaddr;
	}
	public void setMextraaddr(String mextraaddr) {
		this.mextraaddr = mextraaddr;
	}
	private String mprofile; // 프로필 파일 이름을 저장할 필드
	private MultipartFile mfile;// 프로필 파일 
	private int mstate;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMbirth() {
		return mbirth;
	}
	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMaddress() {
		return maddress;
	}
	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}
	public String getMprofile() {
		return mprofile;
	}
	public MultipartFile getMfile() {
		return mfile;
	}
	public void setMfile(MultipartFile mfile) {
		this.mfile = mfile;
	}
	public void setMprofile(String mprofile) {
		this.mprofile = mprofile;
	}
	public int getMstate() {
		return mstate;
	}
	public void setMstate(int mstate) {
		this.mstate = mstate;
	}
	@Override
	public String toString() {
		return "memberDto [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mbirth=" + mbirth + ", memail="
				+ memail + ", maddress=" + maddress + ", mprofile=" + mprofile + ", mfile=" + mfile + ", mstate="
				+ mstate + "]";
	}
	
	
}
