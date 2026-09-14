package com.mypage.agencyportal.dto;

public class CommissionDto {
	private String Message;
	private int Status;
	private Data Data;
	
	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public Data getData() {
		return Data;
	}

	public void setData(Data data) {
		this.Data = data;
	}

	public static class Data {
		private double Commission;

		public double getCommission() {
			return Commission;
		}

		public void setCommission(double commission) {
			Commission = commission;
		}
	}
}
