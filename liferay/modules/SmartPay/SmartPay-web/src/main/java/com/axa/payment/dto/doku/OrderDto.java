package com.axa.payment.dto.doku;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderDto {
	private int amount;
	@SerializedName("invoice_number")
    private String invoiceNumber;
    private String currency;
    @SerializedName("callback_url")
    private String callbackUrl;
    @SerializedName("callback_url_cancel")
    private String callbackUrlCancel;
    @SerializedName("callback_url_result")
    private String callbackUrlResult;
    private String language;
    @SerializedName("auto_redirect")
    private Boolean autoRedirect;
    @SerializedName("disable_retry_payment")
    private Boolean disableRetryPayment;
    @SerializedName("line_items")
    private List<LineItemDto> lineItems;
    
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	
	public void setCallbackUrlCancel(String callbackUrlCancel) {
		this.callbackUrlCancel = callbackUrlCancel;
	}
	
	public void setCallbackUrlResult(String callbackUrlResult) {
		this.callbackUrlResult = callbackUrlResult;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public void setAutoRedirect(boolean autoRedirect) {
		this.autoRedirect = autoRedirect;
	}
	
	public void setDisableRetryPayment(boolean disableRetryPayment) {
		this.disableRetryPayment = disableRetryPayment;
	}
	
	public void setLineItems(List<LineItemDto> lineItems) {
		this.lineItems = lineItems;
	}
}
