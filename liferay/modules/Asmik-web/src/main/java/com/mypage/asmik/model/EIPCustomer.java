package com.mypage.asmik.model;

import java.util.List;

public class EIPCustomer {
    private List<EIPHasPolicyAccount> hasPolicyAccount;
    private List<EIPHaveCommunicatedMessage> haveCommunicatedMessage;

    public List<EIPHaveCommunicatedMessage> getHaveCommunicatedMessage() {
		return haveCommunicatedMessage;
	}

	public void setHaveCommunicatedMessage(List<EIPHaveCommunicatedMessage> haveCommunicatedMessage) {
		this.haveCommunicatedMessage = haveCommunicatedMessage;
	}

	public List<EIPHasPolicyAccount> getHasPolicyAccount() {
        return hasPolicyAccount;
    }

    public void setHasPolicyAccount(List<EIPHasPolicyAccount> hasPolicyAccount) {
        this.hasPolicyAccount = hasPolicyAccount;
    }
}
