package com.mypage.agencyportal.dto;

import com.liferay.petra.string.StringPool;

public class StatusUserDto {
	private long userId = 0L;
	private long authUserId = 0L;
	private long expiresTime = 0L;
	private String status = StringPool.BLANK;
	private boolean isTimetoUnlock;
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getAuthUserId() {
		return authUserId;
	}
	
	public void setAuthUserId(long auhtUserId) {
		this.authUserId = auhtUserId;
	}
	
	public long getExpiresTime() {
		return expiresTime;
	}
	
	public void setExpiresTime(long expiresTime) {
		this.expiresTime = expiresTime;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean getIsTimetoUnlock() {
		return isTimetoUnlock;
	}
	
	public void setIsTimetoUnlock(boolean isTimetoUnlock) {
		this.isTimetoUnlock = isTimetoUnlock;
	}
}
