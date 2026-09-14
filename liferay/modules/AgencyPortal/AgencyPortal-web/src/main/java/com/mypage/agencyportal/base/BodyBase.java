package com.mypage.agencyportal.base;

public interface BodyBase {
    void setTransactionId(String transactionId);
    void setAppID(String appID);
    void setEntity(String entity);
    void setOperation(String operation);
    void setService(String service);
}
