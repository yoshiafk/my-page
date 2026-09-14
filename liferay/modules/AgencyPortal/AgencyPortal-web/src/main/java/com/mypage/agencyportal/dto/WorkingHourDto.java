package com.mypage.agencyportal.dto;

public class WorkingHourDto {

	private String day;
	private String startTime;
	private String endTime;
	private int status;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getStatus(){
		return status;
	}

	public void setStatus(int isActive){
		this.status = isActive;
	}
}
