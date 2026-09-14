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

package com.mypage.leads.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.leads.exception.NoSuchPaymentException;
import com.mypage.leads.model.Payment;
import com.mypage.leads.service.base.PaymentLocalServiceBaseImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus
 */
@Component(
	property = "model.class.name=com.mypage.leads.model.Payment",
	service = AopService.class
)
public class PaymentLocalServiceImpl extends PaymentLocalServiceBaseImpl {
	
	public Payment addPayment(long userId, long paymentId, JSONObject data,ServiceContext serviceContext) {
		Payment payment = null;
		
		try {
			if (paymentId == 0) {
				paymentId = counterLocalService.increment();
				payment = paymentPersistence.create(paymentId);
			} else {
				payment = paymentPersistence.findByPrimaryKey(paymentId);
			}

//			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			if(Validator.isNotNull(data.get("TransactionDateTime"))) {
				Date TransactionDateTime = sdf.parse(data.getString("TransactionDateTime"));
			    payment.setTransactionDateTime(TransactionDateTime);
			}
			if(Validator.isNotNull(data.get("PaymentDateTime"))) {
				Date PaymentDateTime = sdf.parse(data.getString("PaymentDateTime"));
			    payment.setPaymentDateTime(PaymentDateTime);
			}
			if(Validator.isNotNull(data.get("CreditPaymentDate"))) {
				Date CreditPaymentDate = sdf.parse(data.getString("CreditPaymentDate"));
			    payment.setCreditPaymentDate(CreditPaymentDate);
			}
			
			payment.setTransactionId(data.getString("TransactionId"));
			payment.setSessionId(data.getString("SessionId"));
			payment.setLeadsId(data.getLong("LeadsId"));
			payment.setAmount(data.getDouble("Amount"));
			payment.setDiscount(data.getInt("Discount"));
			payment.setDiscountAmount(data.getInt("DiscountAmount"));
			payment.setPaymentStatus(data.getString("PaymentStatus"));
			payment.setPaymentChannelId(data.getInt("PaymentChannelId"));
			payment.setLinkAjaRefNum(data.getString("LinkAjaRefNum"));
			payment.setTenor(data.getString("Tenor"));
			payment.setPaymentCode(data.getString("PaymentCode"));
			payment.setPaymentMessage(data.getString("PaymentMessage"));
			payment.setCreditCardType(data.getString("CreditCardType"));
			payment.setBank(data.getString("Bank"));
			payment.setManagedBy(data.getLong("ManagedBy"));
			payment.setReportGenerated(data.getInt("ReportGenerated"));
			payment.setDailyReportGenerated(data.getInt("DailyReportGenerated"));
			payment.setWeeklyReportGenerated(data.getInt("WeeklyReportGenerated"));
			payment.setMonthlyReportGenerated(data.getInt("MonthlyReportGenerated"));
			payment.setCheckStatusCounter(data.getInt("CheckStatusCounter"));
			payment.setLinkAjaRefNum(data.getString("LinkAjaRefNum"));
			payment.setReportSettlementGenerated(data.getInt("ReportSettlementGenerated"));
			payment.setUserCreditId(data.getLong("UserCreditId"));
			payment.setCreditPaymentStatus(data.getString("CreditPaymentStatus"));
			payment.setCreditTransactionId(data.getString("CreditTransactionId"));
			payment.setCreditBank(data.getString("CreditBank"));
			payment.setCreditPaymentCode(data.getString("CreditPaymentCode"));
			payment.setCreditPaymentChannelId(data.getLong("CreditPaymentChannelId"));
			payment.setCreditPaymentMessage(data.getString("CreditPaymentMessage"));
			payment.setUtmId(data.getLong("UtmId"));
			payment.setCreditPaymentChannelId(data.getLong("CreditPaymentChannelId"));
			payment.setSojern(data.getInt("Sojern"));
			payment.setInvolveAsia(data.getInt("InvolveAsia"));
			payment.setAda(data.getInt("Ada"));
			payment.setActive(data.getInt("Active"));
			
			if(userId > 0 && serviceContext != null) {
				long groupId = serviceContext.getScopeGroupId();
				User user = userLocalService.getUserById(userId);
				Date now = new Date();
				payment.setUserId(userId);
				payment.setGroupId(groupId);
				payment.setCompanyId(user.getCompanyId());
				payment.setUserName(user.getFullName());
				payment.setCreateDate(serviceContext.getCreateDate(now));
				payment.setModifiedDate(serviceContext.getModifiedDate(now));
				payment.setExpandoBridgeAttributes(serviceContext);
			}

			paymentPersistence.update(payment);
			
			return payment;
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		
		return payment;
	}
	
	public Payment setActive(long id, int active, ServiceContext serviceContext) throws PortalException {
		Payment payment = null;

		try {
			payment = paymentPersistence.findByPrimaryKey(id);
			Date now = new Date();
			payment.setActive(active);
			payment.setModifiedDate(serviceContext.getModifiedDate(now));

			paymentPersistence.update(payment);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}

		return payment;
	}
	
	public Payment findByLeadsId(long LeadsId)  {
		try {
			return paymentPersistence.findBysearchByLeadsId(LeadsId);
		} catch (NoSuchPaymentException e) {
            log.debug(e.getMessage());
		}
		return null;
	}
	
	public Payment findByTransactionId(String TransactionId)  {
		return paymentPersistence.fetchBysearchByTransactionId(TransactionId);
	}

    private static final Log log = LogFactoryUtil.getLog(PaymentLocalServiceImpl.class);
}