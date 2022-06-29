package com.spring.memberDto;

public class SchedulesDto {
	
	private String scroom;
	private String scdate;
	private String scthcode;
	private String scmvcode;
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
	public String getScthcode() {
		return scthcode;
	}
	public void setScthcode(String scthcode) {
		this.scthcode = scthcode;
	}
	public String getScmvcode() {
		return scmvcode;
	}
	public void setScmvcode(String scmvcode) {
		this.scmvcode = scmvcode;
	}
	@Override
	public String toString() {
		return "SchedulesDto [scroom=" + scroom + ", scdate=" + scdate + ", scthcode=" + scthcode + ", scmvcode="
				+ scmvcode + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
