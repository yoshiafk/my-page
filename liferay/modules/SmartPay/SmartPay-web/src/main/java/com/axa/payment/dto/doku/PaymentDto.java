package com.axa.payment.dto.doku;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaymentDto {
	@SerializedName("payment_due_date")
	private int paymentDueDate;
    private String type;
    @SerializedName("payment_method_types")
    private List<String> paymentMethodTypes;
    
	public void setPaymentDueDate(int paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setPaymentMethodTypes(List<String> paymentMethodTypes) {
		this.paymentMethodTypes = paymentMethodTypes;
	}
}
