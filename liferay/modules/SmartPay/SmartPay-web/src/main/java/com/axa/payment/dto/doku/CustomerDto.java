package com.axa.payment.dto.doku;

import com.google.gson.annotations.SerializedName;

public class CustomerDto {
	private String id;
    private String name;
    @SerializedName("last_name")
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String postcode;
    private String state;
    private String city;
    private String country;
    
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
}
