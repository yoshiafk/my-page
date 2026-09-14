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

package com.mypage.user.service.impl;

import com.liferay.portal.aop.AopService;
import com.mypage.user.exception.NoSuchCreditWalletException;
import com.mypage.user.model.CreditWallet;
import com.mypage.user.service.base.CreditWalletLocalServiceBaseImpl;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.mypage.user.model.CreditWallet",
	service = AopService.class
)
public class CreditWalletLocalServiceImpl
	extends CreditWalletLocalServiceBaseImpl {
	
	public CreditWallet addCreditWallet(long creditTypeId, Date dateIssued, Date dateExpired, double amount, int active) {
		long creditWalletId = counterLocalService.increment();
		
		CreditWallet creditWallet = creditWalletPersistence.create(creditWalletId);
		creditWallet.setCreditTypeId(creditTypeId);
		creditWallet.setDateIssued(dateIssued);
		creditWallet.setDateExpired(dateExpired);
		creditWallet.setAmount(amount);
		creditWallet.setActive(active);
		
		return creditWalletPersistence.update(creditWallet);
	}
	
	public CreditWallet updateCreditWallet(long creditWalletId, long creditTypeId, Date dateIssued, Date dateExpired, double amount, int active) {
		CreditWallet creditWallet = null;
		
		try {
			creditWallet = creditWalletPersistence.findByPrimaryKey(creditWalletId);
			creditWallet.setCreditTypeId(creditTypeId);
			creditWallet.setDateIssued(dateIssued);
			creditWallet.setDateExpired(dateExpired);
			creditWallet.setAmount(amount);
			creditWallet.setActive(active);
		} catch (NoSuchCreditWalletException e) {
			e.printStackTrace();
		}
		
		return creditWalletPersistence.update(creditWallet);
	}
	
	public CreditWallet setActive(long creditWalletId, int active) {
		CreditWallet creditWallet = null;
		try {
			creditWallet = creditWalletPersistence.findByPrimaryKey(creditWalletId);
			creditWallet.setActive(active);
		} catch (NoSuchCreditWalletException e) {
			e.printStackTrace();
		}
		
		return creditWalletPersistence.update(creditWallet);
	}
}