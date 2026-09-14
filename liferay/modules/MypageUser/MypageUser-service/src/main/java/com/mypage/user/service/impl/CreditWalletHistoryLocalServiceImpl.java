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
import com.mypage.user.exception.NoSuchCreditWalletHistoryException;
import com.mypage.user.model.CreditWalletHistory;
import com.mypage.user.service.base.CreditWalletHistoryLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.mypage.user.model.CreditWalletHistory",
	service = AopService.class
)
public class CreditWalletHistoryLocalServiceImpl
	extends CreditWalletHistoryLocalServiceBaseImpl {
	public CreditWalletHistory addCreditWalletHistory(long mypageUserId, long creditWalletId, long leadsId, String operation, double amount, int active) {
		long creditWalletHistoryId = counterLocalService.increment();
		
		CreditWalletHistory creditWallet = creditWalletHistoryPersistence.create(creditWalletHistoryId);
		creditWallet.setMypageUserId(mypageUserId);
		creditWallet.setCreditWalletHistoryId(creditWalletHistoryId);
		creditWallet.setLeadsId(leadsId);
		creditWallet.setOperation(operation);
		creditWallet.setAmount(amount);
		creditWallet.setActive(active);
		return creditWalletHistoryPersistence.update(creditWallet);
	}
	
	public CreditWalletHistory updateCreditWalletHistory(long creditWalletHistoryId, long mypageUserId, long creditWalletId, long leadsId, String operation, double amount, int active) {
		CreditWalletHistory creditWallet = null;
		
		try {
			creditWallet = creditWalletHistoryPersistence.findByPrimaryKey(creditWalletHistoryId);
			creditWallet.setMypageUserId(mypageUserId);
			creditWallet.setCreditWalletHistoryId(creditWalletHistoryId);
			creditWallet.setLeadsId(leadsId);
			creditWallet.setOperation(operation);
			creditWallet.setAmount(amount);
			creditWallet.setActive(active);
		} catch (NoSuchCreditWalletHistoryException e) {
			e.printStackTrace();
		}
		
		return creditWalletHistoryPersistence.update(creditWallet);
	}
	
	public CreditWalletHistory setActive(long creditWalletHistoryId, int active) {
		CreditWalletHistory creditWallet = null;
		try {
			creditWallet = creditWalletHistoryPersistence.findByPrimaryKey(creditWalletHistoryId);
			creditWallet.setActive(active);
		} catch (NoSuchCreditWalletHistoryException e) {
			e.printStackTrace();
		}
		
		return creditWalletHistoryPersistence.update(creditWallet);
	}
}