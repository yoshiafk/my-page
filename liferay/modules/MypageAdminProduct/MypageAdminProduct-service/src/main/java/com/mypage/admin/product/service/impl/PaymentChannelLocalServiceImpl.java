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
import com.mypage.admin.product.model.PaymentChannel;
import com.mypage.admin.product.service.base.PaymentChannelLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.PaymentChannel",
	service = AopService.class
)
public class PaymentChannelLocalServiceImpl
	extends PaymentChannelLocalServiceBaseImpl {
	
	public PaymentChannel addPaymentChannel(String code, String name, Double minPayment, Double maxPayment,
			String description, long masterBankId, String mdrAxa, String mdrUser, String pgFeePct, String pgFeeAmt,
			long imageFileEntryId, String imageURL, int utmOnly, String mallId, String sharedKey, int active)
			throws PortalException {
		long paymentChannelId = counterLocalService.increment();
		PaymentChannel paymentchannel = paymentChannelPersistence.create(paymentChannelId);

		paymentchannel.setCode(code);
		paymentchannel.setName(name);
		paymentchannel.setMinPayment(minPayment);
		paymentchannel.setMaxPayment(maxPayment);
		paymentchannel.setDescription(description);
		paymentchannel.setMasterBankId(masterBankId);
		paymentchannel.setMdrAxa(mdrAxa);
		paymentchannel.setMdrUser(mdrUser);
		paymentchannel.setPgFeePct(pgFeePct);
		paymentchannel.setPgFeeAmt(pgFeeAmt);
		paymentchannel.setImageFileEntryId(imageFileEntryId);
		paymentchannel.setImageURL(imageURL);
		paymentchannel.setUtmOnly(utmOnly);
		paymentchannel.setMallId(mallId);
		paymentchannel.setSharedKey(sharedKey);
		paymentchannel.setActive(active);

		paymentChannelPersistence.update(paymentchannel);

		return paymentchannel;
	}

	public PaymentChannel updatePaymentChannel(long paymentChannelId, String code, String name, Double minPayment,
			Double maxPayment, String description, long masterBankId, String mdrAxa, String mdrUser, String pgFeePct,
			String pgFeeAmt, long imageFileEntryId, String imageURL, int utmOnly, String mallId, String sharedKey,
			int active, boolean isImport) throws PortalException {
		PaymentChannel paymentchannel = paymentChannelPersistence.findByPrimaryKey(paymentChannelId);

		paymentchannel.setCode(code);
		paymentchannel.setName(name);
		paymentchannel.setMinPayment(minPayment);
		paymentchannel.setMaxPayment(maxPayment);
		paymentchannel.setDescription(description);
		paymentchannel.setMasterBankId(masterBankId);
		paymentchannel.setMdrAxa(mdrAxa);
		paymentchannel.setMdrUser(mdrUser);
		paymentchannel.setPgFeePct(pgFeePct);
		paymentchannel.setPgFeeAmt(pgFeeAmt);
		if (isImport != true) {
			paymentchannel.setImageFileEntryId(imageFileEntryId);
			paymentchannel.setImageURL(imageURL);
		}
		paymentchannel.setUtmOnly(utmOnly);
		paymentchannel.setMallId(mallId);
		paymentchannel.setSharedKey(sharedKey);
		paymentchannel.setActive(active);

		paymentChannelPersistence.update(paymentchannel);

		return paymentchannel;
	}

	public PaymentChannel setActive(long paymentChannelId, int active, ServiceContext serviceContext)
			throws PortalException {
		PaymentChannel paymentchannel = null;

		try {
			paymentchannel = paymentChannelPersistence.findByPrimaryKey(paymentChannelId);
			Date now = new Date();
			paymentchannel.setActive(active);
			paymentchannel.setModifiedDate(serviceContext.getModifiedDate(now));

			paymentChannelPersistence.update(paymentchannel);
		} catch (Exception e) {
			System.out.println(e);
		}

		return paymentchannel;
	}

	public List<PaymentChannel> findByBank(long masterBankId, int active) {
		return paymentChannelPersistence.findBysearchByBank(masterBankId, active);
	}

	public List<PaymentChannel> findBysearchByIdAndCode(long paymentChannelId, String code) {
		return paymentChannelPersistence.findBysearchByIdAndCode(paymentChannelId, code);
	}
}