package com.axa.payment.dto.doku;

import com.google.gson.annotations.SerializedName;

public class PaymentRequestDto {
	private OrderDto order;
    private PaymentDto payment;
    private CustomerDto customer;
    @SerializedName("shipping_address")
    private AddressDto shippingAddress;
    @SerializedName("billing_address")
    private AddressDto billingAddress;
    @SerializedName("additional_info")
    private AdditionalInfoDto additionalInfo;
    
	public void setOrder(OrderDto order) {
		this.order = order;
	}
	
	public void setPayment(PaymentDto payment) {
		this.payment = payment;
	}
	
	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}
	
	public void setShippingAddress(AddressDto shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public void setBillingAddress(AddressDto billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	public void setAdditionalInfo(AdditionalInfoDto additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}
