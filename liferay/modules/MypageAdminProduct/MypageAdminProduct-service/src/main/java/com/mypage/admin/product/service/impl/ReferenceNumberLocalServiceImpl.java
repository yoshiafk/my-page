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

package com.mypage.admin.product.service.impl;

import com.liferay.portal.aop.AopService;
import com.mypage.admin.product.exception.NoSuchReferenceNumberException;
import com.mypage.admin.product.model.ReferenceNumber;
import com.mypage.admin.product.service.base.ReferenceNumberLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.ReferenceNumber",
	service = AopService.class
)
public class ReferenceNumberLocalServiceImpl
	extends ReferenceNumberLocalServiceBaseImpl {
	
	public ReferenceNumber addReferenceNumber(String userRole, String channel, String type, String productCode,
			String businessType, String currency, String prefix, int active) {
		long referenceNumberId = counterLocalService.increment();
		ReferenceNumber referenceNumber = referenceNumberPersistence.create(referenceNumberId);
		referenceNumber.setUserRole(userRole);
		referenceNumber.setChannel(channel);
		referenceNumber.setType(type);
		referenceNumber.setProductCode(productCode);
		referenceNumber.setBusinessType(businessType);
		referenceNumber.setCurrency(currency);
		referenceNumber.setPrefix(prefix);
		referenceNumber.setActive(active);

		referenceNumberPersistence.update(referenceNumber);

		return referenceNumber;
	}

	public ReferenceNumber updateReferenceNumber(long referenceNumberId, String userRole, String channel, String type,
			String productCode, String businessType, String currency, String prefix, int active)
			throws NoSuchReferenceNumberException {
		ReferenceNumber referenceNumber = referenceNumberPersistence.findByPrimaryKey(referenceNumberId);
		referenceNumber.setUserRole(userRole);
		referenceNumber.setChannel(channel);
		referenceNumber.setType(type);
		referenceNumber.setProductCode(productCode);
		referenceNumber.setBusinessType(businessType);
		referenceNumber.setCurrency(currency);
		referenceNumber.setPrefix(prefix);
		referenceNumber.setActive(active);

		referenceNumberPersistence.update(referenceNumber);

		return referenceNumber;
	}

	public ReferenceNumber setActive(long referenceNumberId, int active) throws NoSuchReferenceNumberException {
		ReferenceNumber referenceNumber = referenceNumberPersistence.findByPrimaryKey(referenceNumberId);
		referenceNumber.setActive(active);
		referenceNumberPersistence.update(referenceNumber);
		return referenceNumber;
	}

	public ReferenceNumber searchReferenceNumber(String userRole, String channel, String type, String productCode,
			String businessType, String currency) {
		return referenceNumberPersistence.fetchBysearchReferenceNumber(userRole, channel, type, productCode,
				businessType, currency);
	}
}