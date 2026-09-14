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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.admin.product.model.PaymentChannelTenor;
import com.mypage.admin.product.service.base.PaymentChannelTenorLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.PaymentChannelTenor",
	service = AopService.class
)
public class PaymentChannelTenorLocalServiceImpl
	extends PaymentChannelTenorLocalServiceBaseImpl {
	
	public PaymentChannelTenor addPaymentChannelTenor(long paymentChannelId, String promoid, String tenor,
			String tenorid, String acquirer, int active) throws PortalException {
		long paymentChannelTenorId = counterLocalService.increment();
		PaymentChannelTenor pmTenor = paymentChannelTenorPersistence.create(paymentChannelTenorId);

		pmTenor.setPaymentChannelId(paymentChannelId);
		pmTenor.setPromoid(promoid);
		pmTenor.setTenor(tenor);
		pmTenor.setTenorid(tenorid);
		pmTenor.setAcquirer(acquirer);
		pmTenor.setActive(active);

		paymentChannelTenorPersistence.update(pmTenor);

		return pmTenor;
	}

	public PaymentChannelTenor updatePaymentChannelTenor(long paymentChannelTenorId, long paymentChannelId,
			String promoid, String tenor, String tenorid, String acquirer, int active) throws PortalException {
		PaymentChannelTenor pmTenor = paymentChannelTenorPersistence.findByPrimaryKey(paymentChannelTenorId);

		pmTenor.setPaymentChannelId(paymentChannelId);
		pmTenor.setPromoid(promoid);
		pmTenor.setTenor(tenor);
		pmTenor.setTenorid(tenorid);
		pmTenor.setAcquirer(acquirer);
		pmTenor.setActive(active);

		paymentChannelTenorPersistence.update(pmTenor);

		return pmTenor;
	}

	public PaymentChannelTenor setActive(long paymentChannelTenorId, int active, ServiceContext serviceContext)
			throws PortalException {
		PaymentChannelTenor pmTenor = null;

		try {
			pmTenor = paymentChannelTenorPersistence.findByPrimaryKey(paymentChannelTenorId);
			Date now = new Date();
			pmTenor.setActive(active);
			pmTenor.setModifiedDate(serviceContext.getModifiedDate(now));

			paymentChannelTenorPersistence.update(pmTenor);
		} catch (Exception e) {
			System.out.println(e);
		}

		return pmTenor;
	}

	public void removeByPaymentChannelId(long paymentChannelId) {
		paymentChannelTenorPersistence.removeBysearchByPaymentChannelId(paymentChannelId);
	}

	public List<PaymentChannelTenor> findBysearchByPaymentChannelId(long paymentChannelId) {
		return paymentChannelTenorPersistence.findBysearchByPaymentChannelId(paymentChannelId);
	}
}