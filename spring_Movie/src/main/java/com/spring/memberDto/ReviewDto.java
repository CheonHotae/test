package com.spring.memberDto;

public class ReviewDto {

	
	private String rvrecode;
	private String rvmid;
	private String rvmvcode;
	private String rvcomment;
	private String rvdate;
	private int rvrecommend;
	
	private String mprofile;
	
	public String getRvmvcode() {
		return rvmvcode;
	}
	public void setRvmvcode(String rvmvcode) {
		this.rvmvcode = rvmvcode;
	}
	public String getMprofile() {
		return mprofile;
	}
	public void setMprofile(String mprofile) {
		this.mprofile = mprofile;
	}
	public String getRvrecode() {
		return rvrecode;
	}
	public void setRvrecode(String rvrecode) {
		this.rvrecode = rvrecode;
	}
	public String getRvmid() {
		return rvmid;
	}
	public void setRvmid(String rvmid) {
		this.rvmid = rvmid;
	}
	public String getRemvcode() {
		return rvmvcode;
	}
	public void setRemvcode(String remvcode) {
		this.rvmvcode = remvcode;
	}
	public String getRvcomment() {
		return rvcomment;
	}
	public void setRvcomment(String rvcomment) {
		this.rvcomment = rvcomment;
	}
	public String getRvdate() {
		return rvdate;
	}
	public void setRvdate(String rvdate) {
		this.rvdate = rvdate;
	}
	public int getRvrecommend() {
		return rvrecommend;
	}
	public void setRvrecommend(int rvrecommend) {
		this.rvrecommend = rvrecommend;
	}
	@Override
	public String toString() {
		return "ReviewDto [rvrecode=" + rvrecode + ", rvmid=" + rvmid + ", rvmvcode=" + rvmvcode + ", rvcomment="
				+ rvcomment + ", rvdate=" + rvdate + ", rvrecommend=" + rvrecommend + ", mprofile=" + mprofile + "]";
	}
	
	
}
