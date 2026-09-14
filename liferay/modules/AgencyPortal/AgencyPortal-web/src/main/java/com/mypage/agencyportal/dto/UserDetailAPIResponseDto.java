package com.mypage.agencyportal.dto;

import com.google.gson.annotations.SerializedName;

public class UserDetailAPIResponseDto {
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
		    @SerializedName("Name")
	        private String name;
	        @SerializedName("Role")
	        private String role;
	        @SerializedName("Status")
	        private String status;
	        @SerializedName("Email")
	        private String email;
	        @SerializedName("AgentCode")
	        private String agentCode;
	        @SerializedName("DeptoreCode")
	        private String deptoreCode;
	        @SerializedName("PrettyUrl")
	        private String prettyUrl;
	        @SerializedName("PrettyUrlChange")
	        private int prettyUrlChange;
		    @SerializedName("Dob")
	        private String dob;
		    @SerializedName("JoinDate")
	        private String joinDate;
		    @SerializedName("EndDate")
	        private String endDate;
		    @SerializedName("Gender")
	        private String gender;
		    @SerializedName("MobilePhone")
	        private String mobilePhone;

		// Getters and setters

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAgentCode() {
			return agentCode;
		}

		public void setAgentCode(String agentCode) {
			this.agentCode = agentCode;
		}

		public String getDeptoreCode() {
			return deptoreCode;
		}

		public void setDeptoreCode(String deptoreCode) {
			this.deptoreCode = deptoreCode;
		}

		public String getPrettyUrl() {
			return prettyUrl;
		}

		public void setPrettyUrl(String prettyUrl) {
			this.prettyUrl = prettyUrl;
		}

		public int getPrettyUrlChange() {
			return prettyUrlChange;
		}

		public void setPrettyUrlChange(int prettyUrlChange) {
			this.prettyUrlChange = prettyUrlChange;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getJoinDate() {
			return joinDate;
		}

		public void setJoinDate(String joinDate) {
			this.joinDate = joinDate;
		}

		public String getEndDate() {
			return endDate;
		}

		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getMobilePhone() {
			return mobilePhone;
		}

		public void setMobilePhone(String mobilePhone) {
			this.mobilePhone = mobilePhone;
		}
	}
}
