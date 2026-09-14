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

import com.axa.payment.model.UserTransactionToken;
import com.axa.payment.service.base.UserTransactionTokenLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.axa.payment.model.UserTransactionToken",
	service = AopService.class
)
public class UserTransactionTokenLocalServiceImpl extends UserTransactionTokenLocalServiceBaseImpl {
	
	public UserTransactionToken updateToken(String policyNumber, String profileId, String invoiceNumber, String referenceNumber, 
											String fullName, String email, String phoneNumber, double amount, String channel, 
											String virtualAccount1, String virtualAccount2, String token, long expiresIn) {
		
		long userTrasactionTokenId = counterLocalService.increment();
		int isFound = userTransactionTokenPersistence.countBytoken(token);
		UserTransactionToken userTrasactionToken = isFound > 0 ? userTransactionTokenPersistence.findBytoken(token).get(0) : userTransactionTokenPersistence.create(userTrasactionTokenId);
		
		userTrasactionToken.setPolicyNumber(policyNumber);
		userTrasactionToken.setProfileId(profileId);
		if (Validator.isNotNull(invoiceNumber)) userTrasactionToken.setInvoiceNumber(invoiceNumber);
		if (Validator.isNotNull(referenceNumber)) userTrasactionToken.setReferenceNumber(referenceNumber);
		if (Validator.isNotNull(fullName)) userTrasactionToken.setFullName(fullName);
		if (Validator.isNotNull(email)) userTrasactionToken.setEmail(email);
		if (Validator.isNotNull(phoneNumber)) userTrasactionToken.setPhoneNumber(phoneNumber);
		if (amount > 0) userTrasactionToken.setAmount(amount);
		if (Validator.isNotNull(channel)) userTrasactionToken.setChannel(channel);
		if (Validator.isNotNull(virtualAccount1)) userTrasactionToken.setVirtualAccount1(virtualAccount1);
		if (Validator.isNotNull(virtualAccount2)) userTrasactionToken.setVirtualAccount2(virtualAccount2);
		userTrasactionToken.setToken(token);
		if (expiresIn > 0) userTrasactionToken.setTimestampExpiryToken(expiresIn);
		
		userTransactionTokenPersistence.update(userTrasactionToken);

		return userTrasactionToken;
	}
}