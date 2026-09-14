package com.axa.payment.dto.doku;

import com.google.gson.annotations.SerializedName;

public class AddressDto {
	@SerializedName("first_name")
	private String firstName;
	@SerializedName("last_name")
    private String lastName;
    private String address;
    private String city;
    @SerializedName("postal_code")
    private String postalCode;
    private String phone;
    @SerializedName("country_code")
    private String countryCode;
    
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
