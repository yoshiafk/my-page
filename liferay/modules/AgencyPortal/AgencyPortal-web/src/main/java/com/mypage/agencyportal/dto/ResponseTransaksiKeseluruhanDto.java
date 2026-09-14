package com.mypage.agencyportal.dto;

import java.util.List;

public class ResponseTransaksiKeseluruhanDto {
	
	private String statusMessage;
	private int responseCode;
	private int totalData;
	private List<PolicySummaryDto> datas;
	
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public int getTotalData() {
		return totalData;
	}
	public void setTotalData(int totalData) {
		this.totalData = totalData;
	}
	public List<PolicySummaryDto> getDatas() {
		return datas;
	}
	public void setDatas(List<PolicySummaryDto> datas) {
		this.datas = datas;
	}
	
	

}
