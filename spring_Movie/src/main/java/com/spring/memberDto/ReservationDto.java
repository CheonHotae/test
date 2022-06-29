package com.spring.memberDto;

public class ReservationDto {

	
	private String recode;
	private String remid;
	private String rescthcode;
	private String rescroom;
	private String rescdate;
	private int reamount;
	public String getRecode() {
		return recode;
	}
	public void setRecode(String recode) {
		this.recode = recode;
	}
	public String getRemid() {
		return remid;
	}
	public void setRemid(String remid) {
		this.remid = remid;
	}
	public String getRescthcode() {
		return rescthcode;
	}
	public void setRescthcode(String rescthcode) {
		this.rescthcode = rescthcode;
	}
	public String getRescroom() {
		return rescroom;
	}
	public void setRescroom(String rescroom) {
		this.rescroom = rescroom;
	}
	public String getRescdate() {
		return rescdate;
	}
	public void setRescdate(String rescdate) {
		this.rescdate = rescdate;
	}
	public int getReamount() {
		return reamount;
	}
	public void setReamount(int reamount) {
		this.reamount = reamount;
	}
	@Override
	public String toString() {
		return "ReservationDto [recode=" + recode + ", remid=" + remid + ", rescthcode=" + rescthcode + ", rescroom="
				+ rescroom + ", rescdate=" + rescdate + ", reamount=" + reamount + "]";
	}
	
	
	
}
