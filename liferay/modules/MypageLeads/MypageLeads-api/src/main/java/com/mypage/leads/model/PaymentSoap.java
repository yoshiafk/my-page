/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.mypage.leads.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.leads.service.http.PaymentServiceSoap}.
 *
 * @author Gositus
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PaymentSoap implements Serializable {

	public static PaymentSoap toSoapModel(Payment model) {
		PaymentSoap soapModel = new PaymentSoap();

		soapModel.setPaymentId(model.getPaymentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTransactionId(model.getTransactionId());
		soapModel.setSessionId(model.getSessionId());
		soapModel.setLeadsId(model.getLeadsId());
		soapModel.setAmount(model.getAmount());
		soapModel.setDiscount(model.getDiscount());
		soapModel.setDiscountAmount(model.getDiscountAmount());
		soapModel.setPaymentStatus(model.getPaymentStatus());
		soapModel.setPaymentChannelId(model.getPaymentChannelId());
		soapModel.setLinkAjaRefNum(model.getLinkAjaRefNum());
		soapModel.setTenor(model.getTenor());
		soapModel.setPaymentCode(model.getPaymentCode());
		soapModel.setPaymentMessage(model.getPaymentMessage());
		soapModel.setCreditCardType(model.getCreditCardType());
		soapModel.setTransactionDateTime(model.getTransactionDateTime());
		soapModel.setPaymentDateTime(model.getPaymentDateTime());
		soapModel.setBank(model.getBank());
		soapModel.setManagedBy(model.getManagedBy());
		soapModel.setReportGenerated(model.getReportGenerated());
		soapModel.setDailyReportGenerated(model.getDailyReportGenerated());
		soapModel.setWeeklyReportGenerated(model.getWeeklyReportGenerated());
		soapModel.setMonthlyReportGenerated(model.getMonthlyReportGenerated());
		soapModel.setCheckStatusCounter(model.getCheckStatusCounter());
		soapModel.setUserCreditId(model.getUserCreditId());
		soapModel.setCreditPaymentStatus(model.getCreditPaymentStatus());
		soapModel.setCreditTransactionId(model.getCreditTransactionId());
		soapModel.setCreditPaymentDate(model.getCreditPaymentDate());
		soapModel.setCreditPaymentChannelId(model.getCreditPaymentChannelId());
		soapModel.setCreditBank(model.getCreditBank());
		soapModel.setCreditPaymentCode(model.getCreditPaymentCode());
		soapModel.setCreditPaymentMessage(model.getCreditPaymentMessage());
		soapModel.setReportSettlementGenerated(
			model.getReportSettlementGenerated());
		soapModel.setCreditSettlementAttachmentId(
			model.getCreditSettlementAttachmentId());
		soapModel.setUtmId(model.getUtmId());
		soapModel.setSojern(model.getSojern());
		soapModel.setInvolveAsia(model.getInvolveAsia());
		soapModel.setAda(model.getAda());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static PaymentSoap[] toSoapModels(Payment[] models) {
		PaymentSoap[] soapModels = new PaymentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PaymentSoap[][] toSoapModels(Payment[][] models) {
		PaymentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PaymentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PaymentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PaymentSoap[] toSoapModels(List<Payment> models) {
		List<PaymentSoap> soapModels = new ArrayList<PaymentSoap>(
			models.size());

		for (Payment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PaymentSoap[soapModels.size()]);
	}

	public PaymentSoap() {
	}

	public long getPrimaryKey() {
		return _paymentId;
	}

	public void setPrimaryKey(long pk) {
		setPaymentId(pk);
	}

	public long getPaymentId() {
		return _paymentId;
	}

	public void setPaymentId(long paymentId) {
		_paymentId = paymentId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTransactionId() {
		return _TransactionId;
	}

	public void setTransactionId(String TransactionId) {
		_TransactionId = TransactionId;
	}

	public String getSessionId() {
		return _SessionId;
	}

	public void setSessionId(String SessionId) {
		_SessionId = SessionId;
	}

	public long getLeadsId() {
		return _LeadsId;
	}

	public void setLeadsId(long LeadsId) {
		_LeadsId = LeadsId;
	}

	public double getAmount() {
		return _Amount;
	}

	public void setAmount(double Amount) {
		_Amount = Amount;
	}

	public double getDiscount() {
		return _Discount;
	}

	public void setDiscount(double Discount) {
		_Discount = Discount;
	}

	public double getDiscountAmount() {
		return _DiscountAmount;
	}

	public void setDiscountAmount(double DiscountAmount) {
		_DiscountAmount = DiscountAmount;
	}

	public String getPaymentStatus() {
		return _PaymentStatus;
	}

	public void setPaymentStatus(String PaymentStatus) {
		_PaymentStatus = PaymentStatus;
	}

	public long getPaymentChannelId() {
		return _PaymentChannelId;
	}

	public void setPaymentChannelId(long PaymentChannelId) {
		_PaymentChannelId = PaymentChannelId;
	}

	public String getLinkAjaRefNum() {
		return _LinkAjaRefNum;
	}

	public void setLinkAjaRefNum(String LinkAjaRefNum) {
		_LinkAjaRefNum = LinkAjaRefNum;
	}

	public String getTenor() {
		return _Tenor;
	}

	public void setTenor(String Tenor) {
		_Tenor = Tenor;
	}

	public String getPaymentCode() {
		return _PaymentCode;
	}

	public void setPaymentCode(String PaymentCode) {
		_PaymentCode = PaymentCode;
	}

	public String getPaymentMessage() {
		return _PaymentMessage;
	}

	public void setPaymentMessage(String PaymentMessage) {
		_PaymentMessage = PaymentMessage;
	}

	public String getCreditCardType() {
		return _CreditCardType;
	}

	public void setCreditCardType(String CreditCardType) {
		_CreditCardType = CreditCardType;
	}

	public Date getTransactionDateTime() {
		return _TransactionDateTime;
	}

	public void setTransactionDateTime(Date TransactionDateTime) {
		_TransactionDateTime = TransactionDateTime;
	}

	public Date getPaymentDateTime() {
		return _PaymentDateTime;
	}

	public void setPaymentDateTime(Date PaymentDateTime) {
		_PaymentDateTime = PaymentDateTime;
	}

	public String getBank() {
		return _Bank;
	}

	public void setBank(String Bank) {
		_Bank = Bank;
	}

	public long getManagedBy() {
		return _ManagedBy;
	}

	public void setManagedBy(long ManagedBy) {
		_ManagedBy = ManagedBy;
	}

	public int getReportGenerated() {
		return _ReportGenerated;
	}

	public void setReportGenerated(int ReportGenerated) {
		_ReportGenerated = ReportGenerated;
	}

	public int getDailyReportGenerated() {
		return _DailyReportGenerated;
	}

	public void setDailyReportGenerated(int DailyReportGenerated) {
		_DailyReportGenerated = DailyReportGenerated;
	}

	public int getWeeklyReportGenerated() {
		return _WeeklyReportGenerated;
	}

	public void setWeeklyReportGenerated(int WeeklyReportGenerated) {
		_WeeklyReportGenerated = WeeklyReportGenerated;
	}

	public int getMonthlyReportGenerated() {
		return _MonthlyReportGenerated;
	}

	public void setMonthlyReportGenerated(int MonthlyReportGenerated) {
		_MonthlyReportGenerated = MonthlyReportGenerated;
	}

	public int getCheckStatusCounter() {
		return _CheckStatusCounter;
	}

	public void setCheckStatusCounter(int CheckStatusCounter) {
		_CheckStatusCounter = CheckStatusCounter;
	}

	public long getUserCreditId() {
		return _UserCreditId;
	}

	public void setUserCreditId(long UserCreditId) {
		_UserCreditId = UserCreditId;
	}

	public String getCreditPaymentStatus() {
		return _CreditPaymentStatus;
	}

	public void setCreditPaymentStatus(String CreditPaymentStatus) {
		_CreditPaymentStatus = CreditPaymentStatus;
	}

	public String getCreditTransactionId() {
		return _CreditTransactionId;
	}

	public void setCreditTransactionId(String CreditTransactionId) {
		_CreditTransactionId = CreditTransactionId;
	}

	public Date getCreditPaymentDate() {
		return _CreditPaymentDate;
	}

	public void setCreditPaymentDate(Date CreditPaymentDate) {
		_CreditPaymentDate = CreditPaymentDate;
	}

	public long getCreditPaymentChannelId() {
		return _CreditPaymentChannelId;
	}

	public void setCreditPaymentChannelId(long CreditPaymentChannelId) {
		_CreditPaymentChannelId = CreditPaymentChannelId;
	}

	public String getCreditBank() {
		return _CreditBank;
	}

	public void setCreditBank(String CreditBank) {
		_CreditBank = CreditBank;
	}

	public String getCreditPaymentCode() {
		return _CreditPaymentCode;
	}

	public void setCreditPaymentCode(String CreditPaymentCode) {
		_CreditPaymentCode = CreditPaymentCode;
	}

	public String getCreditPaymentMessage() {
		return _CreditPaymentMessage;
	}

	public void setCreditPaymentMessage(String CreditPaymentMessage) {
		_CreditPaymentMessage = CreditPaymentMessage;
	}

	public int getReportSettlementGenerated() {
		return _ReportSettlementGenerated;
	}

	public void setReportSettlementGenerated(int ReportSettlementGenerated) {
		_ReportSettlementGenerated = ReportSettlementGenerated;
	}

	public long getCreditSettlementAttachmentId() {
		return _CreditSettlementAttachmentId;
	}

	public void setCreditSettlementAttachmentId(
		long CreditSettlementAttachmentId) {

		_CreditSettlementAttachmentId = CreditSettlementAttachmentId;
	}

	public long getUtmId() {
		return _UtmId;
	}

	public void setUtmId(long UtmId) {
		_UtmId = UtmId;
	}

	public int getSojern() {
		return _Sojern;
	}

	public void setSojern(int Sojern) {
		_Sojern = Sojern;
	}

	public int getInvolveAsia() {
		return _InvolveAsia;
	}

	public void setInvolveAsia(int InvolveAsia) {
		_InvolveAsia = InvolveAsia;
	}

	public int getAda() {
		return _Ada;
	}

	public void setAda(int Ada) {
		_Ada = Ada;
	}

	public int getActive() {
		return _Active;
	}

	public void setActive(int Active) {
		_Active = Active;
	}

	private long _paymentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _TransactionId;
	private String _SessionId;
	private long _LeadsId;
	private double _Amount;
	private double _Discount;
	private double _DiscountAmount;
	private String _PaymentStatus;
	private long _PaymentChannelId;
	private String _LinkAjaRefNum;
	private String _Tenor;
	private String _PaymentCode;
	private String _PaymentMessage;
	private String _CreditCardType;
	private Date _TransactionDateTime;
	private Date _PaymentDateTime;
	private String _Bank;
	private long _ManagedBy;
	private int _ReportGenerated;
	private int _DailyReportGenerated;
	private int _WeeklyReportGenerated;
	private int _MonthlyReportGenerated;
	private int _CheckStatusCounter;
	private long _UserCreditId;
	private String _CreditPaymentStatus;
	private String _CreditTransactionId;
	private Date _CreditPaymentDate;
	private long _CreditPaymentChannelId;
	private String _CreditBank;
	private String _CreditPaymentCode;
	private String _CreditPaymentMessage;
	private int _ReportSettlementGenerated;
	private long _CreditSettlementAttachmentId;
	private long _UtmId;
	private int _Sojern;
	private int _InvolveAsia;
	private int _Ada;
	private int _Active;

}