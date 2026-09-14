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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Payment}.
 * </p>
 *
 * @author Gositus
 * @see Payment
 * @generated
 */
public class PaymentWrapper
	extends BaseModelWrapper<Payment>
	implements ModelWrapper<Payment>, Payment {

	public PaymentWrapper(Payment payment) {
		super(payment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("paymentId", getPaymentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("TransactionId", getTransactionId());
		attributes.put("SessionId", getSessionId());
		attributes.put("LeadsId", getLeadsId());
		attributes.put("Amount", getAmount());
		attributes.put("Discount", getDiscount());
		attributes.put("DiscountAmount", getDiscountAmount());
		attributes.put("PaymentStatus", getPaymentStatus());
		attributes.put("PaymentChannelId", getPaymentChannelId());
		attributes.put("LinkAjaRefNum", getLinkAjaRefNum());
		attributes.put("Tenor", getTenor());
		attributes.put("PaymentCode", getPaymentCode());
		attributes.put("PaymentMessage", getPaymentMessage());
		attributes.put("CreditCardType", getCreditCardType());
		attributes.put("TransactionDateTime", getTransactionDateTime());
		attributes.put("PaymentDateTime", getPaymentDateTime());
		attributes.put("Bank", getBank());
		attributes.put("ManagedBy", getManagedBy());
		attributes.put("ReportGenerated", getReportGenerated());
		attributes.put("DailyReportGenerated", getDailyReportGenerated());
		attributes.put("WeeklyReportGenerated", getWeeklyReportGenerated());
		attributes.put("MonthlyReportGenerated", getMonthlyReportGenerated());
		attributes.put("CheckStatusCounter", getCheckStatusCounter());
		attributes.put("UserCreditId", getUserCreditId());
		attributes.put("CreditPaymentStatus", getCreditPaymentStatus());
		attributes.put("CreditTransactionId", getCreditTransactionId());
		attributes.put("CreditPaymentDate", getCreditPaymentDate());
		attributes.put("CreditPaymentChannelId", getCreditPaymentChannelId());
		attributes.put("CreditBank", getCreditBank());
		attributes.put("CreditPaymentCode", getCreditPaymentCode());
		attributes.put("CreditPaymentMessage", getCreditPaymentMessage());
		attributes.put(
			"ReportSettlementGenerated", getReportSettlementGenerated());
		attributes.put(
			"CreditSettlementAttachmentId", getCreditSettlementAttachmentId());
		attributes.put("UtmId", getUtmId());
		attributes.put("Sojern", getSojern());
		attributes.put("InvolveAsia", getInvolveAsia());
		attributes.put("Ada", getAda());
		attributes.put("Active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long paymentId = (Long)attributes.get("paymentId");

		if (paymentId != null) {
			setPaymentId(paymentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String TransactionId = (String)attributes.get("TransactionId");

		if (TransactionId != null) {
			setTransactionId(TransactionId);
		}

		String SessionId = (String)attributes.get("SessionId");

		if (SessionId != null) {
			setSessionId(SessionId);
		}

		Long LeadsId = (Long)attributes.get("LeadsId");

		if (LeadsId != null) {
			setLeadsId(LeadsId);
		}

		Double Amount = (Double)attributes.get("Amount");

		if (Amount != null) {
			setAmount(Amount);
		}

		Double Discount = (Double)attributes.get("Discount");

		if (Discount != null) {
			setDiscount(Discount);
		}

		Double DiscountAmount = (Double)attributes.get("DiscountAmount");

		if (DiscountAmount != null) {
			setDiscountAmount(DiscountAmount);
		}

		String PaymentStatus = (String)attributes.get("PaymentStatus");

		if (PaymentStatus != null) {
			setPaymentStatus(PaymentStatus);
		}

		Long PaymentChannelId = (Long)attributes.get("PaymentChannelId");

		if (PaymentChannelId != null) {
			setPaymentChannelId(PaymentChannelId);
		}

		String LinkAjaRefNum = (String)attributes.get("LinkAjaRefNum");

		if (LinkAjaRefNum != null) {
			setLinkAjaRefNum(LinkAjaRefNum);
		}

		String Tenor = (String)attributes.get("Tenor");

		if (Tenor != null) {
			setTenor(Tenor);
		}

		String PaymentCode = (String)attributes.get("PaymentCode");

		if (PaymentCode != null) {
			setPaymentCode(PaymentCode);
		}

		String PaymentMessage = (String)attributes.get("PaymentMessage");

		if (PaymentMessage != null) {
			setPaymentMessage(PaymentMessage);
		}

		String CreditCardType = (String)attributes.get("CreditCardType");

		if (CreditCardType != null) {
			setCreditCardType(CreditCardType);
		}

		Date TransactionDateTime = (Date)attributes.get("TransactionDateTime");

		if (TransactionDateTime != null) {
			setTransactionDateTime(TransactionDateTime);
		}

		Date PaymentDateTime = (Date)attributes.get("PaymentDateTime");

		if (PaymentDateTime != null) {
			setPaymentDateTime(PaymentDateTime);
		}

		String Bank = (String)attributes.get("Bank");

		if (Bank != null) {
			setBank(Bank);
		}

		Long ManagedBy = (Long)attributes.get("ManagedBy");

		if (ManagedBy != null) {
			setManagedBy(ManagedBy);
		}

		Integer ReportGenerated = (Integer)attributes.get("ReportGenerated");

		if (ReportGenerated != null) {
			setReportGenerated(ReportGenerated);
		}

		Integer DailyReportGenerated = (Integer)attributes.get(
			"DailyReportGenerated");

		if (DailyReportGenerated != null) {
			setDailyReportGenerated(DailyReportGenerated);
		}

		Integer WeeklyReportGenerated = (Integer)attributes.get(
			"WeeklyReportGenerated");

		if (WeeklyReportGenerated != null) {
			setWeeklyReportGenerated(WeeklyReportGenerated);
		}

		Integer MonthlyReportGenerated = (Integer)attributes.get(
			"MonthlyReportGenerated");

		if (MonthlyReportGenerated != null) {
			setMonthlyReportGenerated(MonthlyReportGenerated);
		}

		Integer CheckStatusCounter = (Integer)attributes.get(
			"CheckStatusCounter");

		if (CheckStatusCounter != null) {
			setCheckStatusCounter(CheckStatusCounter);
		}

		Long UserCreditId = (Long)attributes.get("UserCreditId");

		if (UserCreditId != null) {
			setUserCreditId(UserCreditId);
		}

		String CreditPaymentStatus = (String)attributes.get(
			"CreditPaymentStatus");

		if (CreditPaymentStatus != null) {
			setCreditPaymentStatus(CreditPaymentStatus);
		}

		String CreditTransactionId = (String)attributes.get(
			"CreditTransactionId");

		if (CreditTransactionId != null) {
			setCreditTransactionId(CreditTransactionId);
		}

		Date CreditPaymentDate = (Date)attributes.get("CreditPaymentDate");

		if (CreditPaymentDate != null) {
			setCreditPaymentDate(CreditPaymentDate);
		}

		Long CreditPaymentChannelId = (Long)attributes.get(
			"CreditPaymentChannelId");

		if (CreditPaymentChannelId != null) {
			setCreditPaymentChannelId(CreditPaymentChannelId);
		}

		String CreditBank = (String)attributes.get("CreditBank");

		if (CreditBank != null) {
			setCreditBank(CreditBank);
		}

		String CreditPaymentCode = (String)attributes.get("CreditPaymentCode");

		if (CreditPaymentCode != null) {
			setCreditPaymentCode(CreditPaymentCode);
		}

		String CreditPaymentMessage = (String)attributes.get(
			"CreditPaymentMessage");

		if (CreditPaymentMessage != null) {
			setCreditPaymentMessage(CreditPaymentMessage);
		}

		Integer ReportSettlementGenerated = (Integer)attributes.get(
			"ReportSettlementGenerated");

		if (ReportSettlementGenerated != null) {
			setReportSettlementGenerated(ReportSettlementGenerated);
		}

		Long CreditSettlementAttachmentId = (Long)attributes.get(
			"CreditSettlementAttachmentId");

		if (CreditSettlementAttachmentId != null) {
			setCreditSettlementAttachmentId(CreditSettlementAttachmentId);
		}

		Long UtmId = (Long)attributes.get("UtmId");

		if (UtmId != null) {
			setUtmId(UtmId);
		}

		Integer Sojern = (Integer)attributes.get("Sojern");

		if (Sojern != null) {
			setSojern(Sojern);
		}

		Integer InvolveAsia = (Integer)attributes.get("InvolveAsia");

		if (InvolveAsia != null) {
			setInvolveAsia(InvolveAsia);
		}

		Integer Ada = (Integer)attributes.get("Ada");

		if (Ada != null) {
			setAda(Ada);
		}

		Integer Active = (Integer)attributes.get("Active");

		if (Active != null) {
			setActive(Active);
		}
	}

	/**
	 * Returns the active of this payment.
	 *
	 * @return the active of this payment
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the ada of this payment.
	 *
	 * @return the ada of this payment
	 */
	@Override
	public int getAda() {
		return model.getAda();
	}

	/**
	 * Returns the amount of this payment.
	 *
	 * @return the amount of this payment
	 */
	@Override
	public double getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the bank of this payment.
	 *
	 * @return the bank of this payment
	 */
	@Override
	public String getBank() {
		return model.getBank();
	}

	/**
	 * Returns the check status counter of this payment.
	 *
	 * @return the check status counter of this payment
	 */
	@Override
	public int getCheckStatusCounter() {
		return model.getCheckStatusCounter();
	}

	/**
	 * Returns the company ID of this payment.
	 *
	 * @return the company ID of this payment
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this payment.
	 *
	 * @return the create date of this payment
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the credit bank of this payment.
	 *
	 * @return the credit bank of this payment
	 */
	@Override
	public String getCreditBank() {
		return model.getCreditBank();
	}

	/**
	 * Returns the credit card type of this payment.
	 *
	 * @return the credit card type of this payment
	 */
	@Override
	public String getCreditCardType() {
		return model.getCreditCardType();
	}

	/**
	 * Returns the credit payment channel ID of this payment.
	 *
	 * @return the credit payment channel ID of this payment
	 */
	@Override
	public long getCreditPaymentChannelId() {
		return model.getCreditPaymentChannelId();
	}

	/**
	 * Returns the credit payment code of this payment.
	 *
	 * @return the credit payment code of this payment
	 */
	@Override
	public String getCreditPaymentCode() {
		return model.getCreditPaymentCode();
	}

	/**
	 * Returns the credit payment date of this payment.
	 *
	 * @return the credit payment date of this payment
	 */
	@Override
	public Date getCreditPaymentDate() {
		return model.getCreditPaymentDate();
	}

	/**
	 * Returns the credit payment message of this payment.
	 *
	 * @return the credit payment message of this payment
	 */
	@Override
	public String getCreditPaymentMessage() {
		return model.getCreditPaymentMessage();
	}

	/**
	 * Returns the credit payment status of this payment.
	 *
	 * @return the credit payment status of this payment
	 */
	@Override
	public String getCreditPaymentStatus() {
		return model.getCreditPaymentStatus();
	}

	/**
	 * Returns the credit settlement attachment ID of this payment.
	 *
	 * @return the credit settlement attachment ID of this payment
	 */
	@Override
	public long getCreditSettlementAttachmentId() {
		return model.getCreditSettlementAttachmentId();
	}

	/**
	 * Returns the credit transaction ID of this payment.
	 *
	 * @return the credit transaction ID of this payment
	 */
	@Override
	public String getCreditTransactionId() {
		return model.getCreditTransactionId();
	}

	/**
	 * Returns the daily report generated of this payment.
	 *
	 * @return the daily report generated of this payment
	 */
	@Override
	public int getDailyReportGenerated() {
		return model.getDailyReportGenerated();
	}

	/**
	 * Returns the discount of this payment.
	 *
	 * @return the discount of this payment
	 */
	@Override
	public double getDiscount() {
		return model.getDiscount();
	}

	/**
	 * Returns the discount amount of this payment.
	 *
	 * @return the discount amount of this payment
	 */
	@Override
	public double getDiscountAmount() {
		return model.getDiscountAmount();
	}

	/**
	 * Returns the group ID of this payment.
	 *
	 * @return the group ID of this payment
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the involve asia of this payment.
	 *
	 * @return the involve asia of this payment
	 */
	@Override
	public int getInvolveAsia() {
		return model.getInvolveAsia();
	}

	/**
	 * Returns the leads ID of this payment.
	 *
	 * @return the leads ID of this payment
	 */
	@Override
	public long getLeadsId() {
		return model.getLeadsId();
	}

	/**
	 * Returns the link aja ref num of this payment.
	 *
	 * @return the link aja ref num of this payment
	 */
	@Override
	public String getLinkAjaRefNum() {
		return model.getLinkAjaRefNum();
	}

	/**
	 * Returns the managed by of this payment.
	 *
	 * @return the managed by of this payment
	 */
	@Override
	public long getManagedBy() {
		return model.getManagedBy();
	}

	/**
	 * Returns the modified date of this payment.
	 *
	 * @return the modified date of this payment
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the monthly report generated of this payment.
	 *
	 * @return the monthly report generated of this payment
	 */
	@Override
	public int getMonthlyReportGenerated() {
		return model.getMonthlyReportGenerated();
	}

	/**
	 * Returns the payment channel ID of this payment.
	 *
	 * @return the payment channel ID of this payment
	 */
	@Override
	public long getPaymentChannelId() {
		return model.getPaymentChannelId();
	}

	/**
	 * Returns the payment code of this payment.
	 *
	 * @return the payment code of this payment
	 */
	@Override
	public String getPaymentCode() {
		return model.getPaymentCode();
	}

	/**
	 * Returns the payment date time of this payment.
	 *
	 * @return the payment date time of this payment
	 */
	@Override
	public Date getPaymentDateTime() {
		return model.getPaymentDateTime();
	}

	/**
	 * Returns the payment ID of this payment.
	 *
	 * @return the payment ID of this payment
	 */
	@Override
	public long getPaymentId() {
		return model.getPaymentId();
	}

	/**
	 * Returns the payment message of this payment.
	 *
	 * @return the payment message of this payment
	 */
	@Override
	public String getPaymentMessage() {
		return model.getPaymentMessage();
	}

	/**
	 * Returns the payment status of this payment.
	 *
	 * @return the payment status of this payment
	 */
	@Override
	public String getPaymentStatus() {
		return model.getPaymentStatus();
	}

	/**
	 * Returns the primary key of this payment.
	 *
	 * @return the primary key of this payment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the report generated of this payment.
	 *
	 * @return the report generated of this payment
	 */
	@Override
	public int getReportGenerated() {
		return model.getReportGenerated();
	}

	/**
	 * Returns the report settlement generated of this payment.
	 *
	 * @return the report settlement generated of this payment
	 */
	@Override
	public int getReportSettlementGenerated() {
		return model.getReportSettlementGenerated();
	}

	/**
	 * Returns the session ID of this payment.
	 *
	 * @return the session ID of this payment
	 */
	@Override
	public String getSessionId() {
		return model.getSessionId();
	}

	/**
	 * Returns the sojern of this payment.
	 *
	 * @return the sojern of this payment
	 */
	@Override
	public int getSojern() {
		return model.getSojern();
	}

	/**
	 * Returns the tenor of this payment.
	 *
	 * @return the tenor of this payment
	 */
	@Override
	public String getTenor() {
		return model.getTenor();
	}

	/**
	 * Returns the transaction date time of this payment.
	 *
	 * @return the transaction date time of this payment
	 */
	@Override
	public Date getTransactionDateTime() {
		return model.getTransactionDateTime();
	}

	/**
	 * Returns the transaction ID of this payment.
	 *
	 * @return the transaction ID of this payment
	 */
	@Override
	public String getTransactionId() {
		return model.getTransactionId();
	}

	/**
	 * Returns the user credit ID of this payment.
	 *
	 * @return the user credit ID of this payment
	 */
	@Override
	public long getUserCreditId() {
		return model.getUserCreditId();
	}

	/**
	 * Returns the user ID of this payment.
	 *
	 * @return the user ID of this payment
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this payment.
	 *
	 * @return the user name of this payment
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this payment.
	 *
	 * @return the user uuid of this payment
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the utm ID of this payment.
	 *
	 * @return the utm ID of this payment
	 */
	@Override
	public long getUtmId() {
		return model.getUtmId();
	}

	/**
	 * Returns the weekly report generated of this payment.
	 *
	 * @return the weekly report generated of this payment
	 */
	@Override
	public int getWeeklyReportGenerated() {
		return model.getWeeklyReportGenerated();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this payment.
	 *
	 * @param Active the active of this payment
	 */
	@Override
	public void setActive(int Active) {
		model.setActive(Active);
	}

	/**
	 * Sets the ada of this payment.
	 *
	 * @param Ada the ada of this payment
	 */
	@Override
	public void setAda(int Ada) {
		model.setAda(Ada);
	}

	/**
	 * Sets the amount of this payment.
	 *
	 * @param Amount the amount of this payment
	 */
	@Override
	public void setAmount(double Amount) {
		model.setAmount(Amount);
	}

	/**
	 * Sets the bank of this payment.
	 *
	 * @param Bank the bank of this payment
	 */
	@Override
	public void setBank(String Bank) {
		model.setBank(Bank);
	}

	/**
	 * Sets the check status counter of this payment.
	 *
	 * @param CheckStatusCounter the check status counter of this payment
	 */
	@Override
	public void setCheckStatusCounter(int CheckStatusCounter) {
		model.setCheckStatusCounter(CheckStatusCounter);
	}

	/**
	 * Sets the company ID of this payment.
	 *
	 * @param companyId the company ID of this payment
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this payment.
	 *
	 * @param createDate the create date of this payment
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the credit bank of this payment.
	 *
	 * @param CreditBank the credit bank of this payment
	 */
	@Override
	public void setCreditBank(String CreditBank) {
		model.setCreditBank(CreditBank);
	}

	/**
	 * Sets the credit card type of this payment.
	 *
	 * @param CreditCardType the credit card type of this payment
	 */
	@Override
	public void setCreditCardType(String CreditCardType) {
		model.setCreditCardType(CreditCardType);
	}

	/**
	 * Sets the credit payment channel ID of this payment.
	 *
	 * @param CreditPaymentChannelId the credit payment channel ID of this payment
	 */
	@Override
	public void setCreditPaymentChannelId(long CreditPaymentChannelId) {
		model.setCreditPaymentChannelId(CreditPaymentChannelId);
	}

	/**
	 * Sets the credit payment code of this payment.
	 *
	 * @param CreditPaymentCode the credit payment code of this payment
	 */
	@Override
	public void setCreditPaymentCode(String CreditPaymentCode) {
		model.setCreditPaymentCode(CreditPaymentCode);
	}

	/**
	 * Sets the credit payment date of this payment.
	 *
	 * @param CreditPaymentDate the credit payment date of this payment
	 */
	@Override
	public void setCreditPaymentDate(Date CreditPaymentDate) {
		model.setCreditPaymentDate(CreditPaymentDate);
	}

	/**
	 * Sets the credit payment message of this payment.
	 *
	 * @param CreditPaymentMessage the credit payment message of this payment
	 */
	@Override
	public void setCreditPaymentMessage(String CreditPaymentMessage) {
		model.setCreditPaymentMessage(CreditPaymentMessage);
	}

	/**
	 * Sets the credit payment status of this payment.
	 *
	 * @param CreditPaymentStatus the credit payment status of this payment
	 */
	@Override
	public void setCreditPaymentStatus(String CreditPaymentStatus) {
		model.setCreditPaymentStatus(CreditPaymentStatus);
	}

	/**
	 * Sets the credit settlement attachment ID of this payment.
	 *
	 * @param CreditSettlementAttachmentId the credit settlement attachment ID of this payment
	 */
	@Override
	public void setCreditSettlementAttachmentId(
		long CreditSettlementAttachmentId) {

		model.setCreditSettlementAttachmentId(CreditSettlementAttachmentId);
	}

	/**
	 * Sets the credit transaction ID of this payment.
	 *
	 * @param CreditTransactionId the credit transaction ID of this payment
	 */
	@Override
	public void setCreditTransactionId(String CreditTransactionId) {
		model.setCreditTransactionId(CreditTransactionId);
	}

	/**
	 * Sets the daily report generated of this payment.
	 *
	 * @param DailyReportGenerated the daily report generated of this payment
	 */
	@Override
	public void setDailyReportGenerated(int DailyReportGenerated) {
		model.setDailyReportGenerated(DailyReportGenerated);
	}

	/**
	 * Sets the discount of this payment.
	 *
	 * @param Discount the discount of this payment
	 */
	@Override
	public void setDiscount(double Discount) {
		model.setDiscount(Discount);
	}

	/**
	 * Sets the discount amount of this payment.
	 *
	 * @param DiscountAmount the discount amount of this payment
	 */
	@Override
	public void setDiscountAmount(double DiscountAmount) {
		model.setDiscountAmount(DiscountAmount);
	}

	/**
	 * Sets the group ID of this payment.
	 *
	 * @param groupId the group ID of this payment
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the involve asia of this payment.
	 *
	 * @param InvolveAsia the involve asia of this payment
	 */
	@Override
	public void setInvolveAsia(int InvolveAsia) {
		model.setInvolveAsia(InvolveAsia);
	}

	/**
	 * Sets the leads ID of this payment.
	 *
	 * @param LeadsId the leads ID of this payment
	 */
	@Override
	public void setLeadsId(long LeadsId) {
		model.setLeadsId(LeadsId);
	}

	/**
	 * Sets the link aja ref num of this payment.
	 *
	 * @param LinkAjaRefNum the link aja ref num of this payment
	 */
	@Override
	public void setLinkAjaRefNum(String LinkAjaRefNum) {
		model.setLinkAjaRefNum(LinkAjaRefNum);
	}

	/**
	 * Sets the managed by of this payment.
	 *
	 * @param ManagedBy the managed by of this payment
	 */
	@Override
	public void setManagedBy(long ManagedBy) {
		model.setManagedBy(ManagedBy);
	}

	/**
	 * Sets the modified date of this payment.
	 *
	 * @param modifiedDate the modified date of this payment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the monthly report generated of this payment.
	 *
	 * @param MonthlyReportGenerated the monthly report generated of this payment
	 */
	@Override
	public void setMonthlyReportGenerated(int MonthlyReportGenerated) {
		model.setMonthlyReportGenerated(MonthlyReportGenerated);
	}

	/**
	 * Sets the payment channel ID of this payment.
	 *
	 * @param PaymentChannelId the payment channel ID of this payment
	 */
	@Override
	public void setPaymentChannelId(long PaymentChannelId) {
		model.setPaymentChannelId(PaymentChannelId);
	}

	/**
	 * Sets the payment code of this payment.
	 *
	 * @param PaymentCode the payment code of this payment
	 */
	@Override
	public void setPaymentCode(String PaymentCode) {
		model.setPaymentCode(PaymentCode);
	}

	/**
	 * Sets the payment date time of this payment.
	 *
	 * @param PaymentDateTime the payment date time of this payment
	 */
	@Override
	public void setPaymentDateTime(Date PaymentDateTime) {
		model.setPaymentDateTime(PaymentDateTime);
	}

	/**
	 * Sets the payment ID of this payment.
	 *
	 * @param paymentId the payment ID of this payment
	 */
	@Override
	public void setPaymentId(long paymentId) {
		model.setPaymentId(paymentId);
	}

	/**
	 * Sets the payment message of this payment.
	 *
	 * @param PaymentMessage the payment message of this payment
	 */
	@Override
	public void setPaymentMessage(String PaymentMessage) {
		model.setPaymentMessage(PaymentMessage);
	}

	/**
	 * Sets the payment status of this payment.
	 *
	 * @param PaymentStatus the payment status of this payment
	 */
	@Override
	public void setPaymentStatus(String PaymentStatus) {
		model.setPaymentStatus(PaymentStatus);
	}

	/**
	 * Sets the primary key of this payment.
	 *
	 * @param primaryKey the primary key of this payment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the report generated of this payment.
	 *
	 * @param ReportGenerated the report generated of this payment
	 */
	@Override
	public void setReportGenerated(int ReportGenerated) {
		model.setReportGenerated(ReportGenerated);
	}

	/**
	 * Sets the report settlement generated of this payment.
	 *
	 * @param ReportSettlementGenerated the report settlement generated of this payment
	 */
	@Override
	public void setReportSettlementGenerated(int ReportSettlementGenerated) {
		model.setReportSettlementGenerated(ReportSettlementGenerated);
	}

	/**
	 * Sets the session ID of this payment.
	 *
	 * @param SessionId the session ID of this payment
	 */
	@Override
	public void setSessionId(String SessionId) {
		model.setSessionId(SessionId);
	}

	/**
	 * Sets the sojern of this payment.
	 *
	 * @param Sojern the sojern of this payment
	 */
	@Override
	public void setSojern(int Sojern) {
		model.setSojern(Sojern);
	}

	/**
	 * Sets the tenor of this payment.
	 *
	 * @param Tenor the tenor of this payment
	 */
	@Override
	public void setTenor(String Tenor) {
		model.setTenor(Tenor);
	}

	/**
	 * Sets the transaction date time of this payment.
	 *
	 * @param TransactionDateTime the transaction date time of this payment
	 */
	@Override
	public void setTransactionDateTime(Date TransactionDateTime) {
		model.setTransactionDateTime(TransactionDateTime);
	}

	/**
	 * Sets the transaction ID of this payment.
	 *
	 * @param TransactionId the transaction ID of this payment
	 */
	@Override
	public void setTransactionId(String TransactionId) {
		model.setTransactionId(TransactionId);
	}

	/**
	 * Sets the user credit ID of this payment.
	 *
	 * @param UserCreditId the user credit ID of this payment
	 */
	@Override
	public void setUserCreditId(long UserCreditId) {
		model.setUserCreditId(UserCreditId);
	}

	/**
	 * Sets the user ID of this payment.
	 *
	 * @param userId the user ID of this payment
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this payment.
	 *
	 * @param userName the user name of this payment
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this payment.
	 *
	 * @param userUuid the user uuid of this payment
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the utm ID of this payment.
	 *
	 * @param UtmId the utm ID of this payment
	 */
	@Override
	public void setUtmId(long UtmId) {
		model.setUtmId(UtmId);
	}

	/**
	 * Sets the weekly report generated of this payment.
	 *
	 * @param WeeklyReportGenerated the weekly report generated of this payment
	 */
	@Override
	public void setWeeklyReportGenerated(int WeeklyReportGenerated) {
		model.setWeeklyReportGenerated(WeeklyReportGenerated);
	}

	@Override
	protected PaymentWrapper wrap(Payment payment) {
		return new PaymentWrapper(payment);
	}

}