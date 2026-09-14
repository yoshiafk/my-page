package com.mypage.agencyportal.dto;

import com.google.gson.annotations.SerializedName;

public class DeleteResponseDto {
	
	@SerializedName("Message")
	private String message;
	@SerializedName("Status")
	private int status;
	@SerializedName("Data")
	private Data data;

	// Getters and setters

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	// Data class representing the "Data" object in the JSON response
	public static class Data {
		    @SerializedName("Total")
	        private String total;

			public String getTotal() {
				return total;
			}

			public void setTotal(String total) {
				this.total = total;
			}
		    
		    
	        
	}

}
