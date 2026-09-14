package com.axa.payment.dto.doku;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AdditionalInfoDto {
	@SerializedName("allow_tenor")
	private List<Integer> allowTenor;
	@SerializedName("doku_wallet_notify_url")
    private String dokuWalletNotifyUrl;
    
	public void setAllowTenor(List<Integer> allowTenor) {
		this.allowTenor = allowTenor;
	}
	
	public void setDokuWalletNotifyUrl(String dokuWalletNotifyUrl) {
		this.dokuWalletNotifyUrl = dokuWalletNotifyUrl;
	}
}
