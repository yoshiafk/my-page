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

package com.axa.payment.service.impl;

import com.axa.payment.model.PaymentTransaction;
import com.axa.payment.service.base.PaymentTransactionLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.axa.payment.model.PaymentTransaction",
	service = AopService.class
)
public class PaymentTransactionLocalServiceImpl extends PaymentTransactionLocalServiceBaseImpl {
	public List<PaymentTransaction> getByPolicyProfile(String policyNumber, String profileId) {
		List<PaymentTransaction> trx = paymentTransactionPersistence.findBypolicyProfile(policyNumber, profileId)
									   .stream()
									   .sorted(Comparator.comparing(PaymentTransaction::getCreateDate).reversed())
									   .collect(Collectors.toList());

		return trx;
	}
	
	public int countByPolicyProfileInvoice(String policyNumber, String profileId, String invoiceNumber) {
		int trx = paymentTransactionPersistence.findBypolicyProfile(policyNumber, profileId)
				  .stream()
				  .filter(v -> v.getInvoiceNumber().equalsIgnoreCase(invoiceNumber))
				  .collect(Collectors.toList())
				  .size();

		return trx;
	}
	
	public PaymentTransaction getByInvoiceNumber(String invoiceNumber) {
		PaymentTransaction trx = paymentTransactionPersistence.findByinvoiceNumber(invoiceNumber).get(0);
		
	    return trx;
	}
	
	public List<PaymentTransaction> getByStatus(int limit) {
		DynamicQuery dynamicQuery = paymentTransactionLocalService.dynamicQuery();
	    dynamicQuery.addOrder(OrderFactoryUtil.asc("checkCounter"));
		
	    dynamicQuery.add(RestrictionsFactoryUtil.or(
    	    RestrictionsFactoryUtil.or(
    	        RestrictionsFactoryUtil.eq("status_", "pending"),
    	        RestrictionsFactoryUtil.eq("status_", "redirect")
    	    ),
    	    RestrictionsFactoryUtil.eq("status_", "timeout")
    	));
		
		TimeZone wibTimeZone = TimeZone.getTimeZone("Asia/Jakarta");
		Calendar calendar = Calendar.getInstance(wibTimeZone);
		calendar.add(Calendar.HOUR_OF_DAY, -24);
		Date currentDate = calendar.getTime();
		Instant instant = currentDate.toInstant();
		LocalDateTime localDateTime = instant.atZone(wibTimeZone.toZoneId()).toLocalDateTime();
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
		Instant instantDate = zonedDateTime.toInstant();
		Date yesterday = Date.from(instantDate);

	    dynamicQuery.add(RestrictionsFactoryUtil.ge("createDate", yesterday));
	    
	    dynamicQuery.setLimit(0, limit);
		
	    return paymentTransactionPersistence.findWithDynamicQuery(dynamicQuery);
	}
	
	public PaymentTransaction addTransaction(String policyNumber, String profileId, String invoiceNumber, String referenceNumber, 
											 String policyDueDate, double amount) {
		TimeZone wibTimeZone = TimeZone.getTimeZone("Asia/Jakarta");
		Calendar calendar = Calendar.getInstance(wibTimeZone);
		Date currentDate = calendar.getTime();
		Instant instant = currentDate.toInstant();
		LocalDateTime localDateTime = instant.atZone(wibTimeZone.toZoneId()).toLocalDateTime();
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
		Instant instantDate = zonedDateTime.toInstant();
		Date now = Date.from(instantDate);
		
		long paymentTransactionId = counterLocalService.increment();
		PaymentTransaction trx = paymentTransactionPersistence.create(paymentTransactionId);
		
		trx.setPolicyNumber(policyNumber);
		trx.setProfileId(profileId);
		trx.setInvoiceNumber(invoiceNumber);
		trx.setReferenceNumber(referenceNumber);
		trx.setPolicyDueDate(policyDueDate);
		trx.setAmount(amount);
		trx.setStatus_("PENDING");
		trx.setCreateDate(now);
		trx.setCreateBy("SYSTEM");
		trx.setModifiedDate(null);
		
		paymentTransactionPersistence.update(trx);
		
		return trx;
	}
	
	public PaymentTransaction updateTransactionMethodChannel(String invoiceNumber, String requestId, String paymentMethod, String paymentChannel) {
		TimeZone wibTimeZone = TimeZone.getTimeZone("Asia/Jakarta");
		Calendar calendar = Calendar.getInstance(wibTimeZone);
		Date currentDate = calendar.getTime();
		Instant instant = currentDate.toInstant();
		LocalDateTime localDateTime = instant.atZone(wibTimeZone.toZoneId()).toLocalDateTime();
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
		Instant instantDate = zonedDateTime.toInstant();
		Date now = Date.from(instantDate);
		
		PaymentTransaction trx = paymentTransactionPersistence.findByinvoiceNumber(invoiceNumber).get(0);
		
		trx.setRequestId(requestId);
		trx.setPaymentMethod(paymentMethod);
		trx.setPaymentChannel(paymentChannel);
		trx.setModifiedDate(now);
		trx.setModifiedBy("SYSTEM");
		
		paymentTransactionPersistence.update(trx);
		
		return trx;
	}
}