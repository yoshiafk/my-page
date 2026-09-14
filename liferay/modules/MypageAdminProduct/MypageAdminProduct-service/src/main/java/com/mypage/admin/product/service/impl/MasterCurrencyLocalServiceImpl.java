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
import com.mypage.admin.product.model.MasterCurrency;
import com.mypage.admin.product.service.base.MasterCurrencyLocalServiceBaseImpl;
import com.mypage.admin.product.service.persistence.MasterCurrencyPersistence;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.MasterCurrency",
	service = AopService.class
)
public class MasterCurrencyLocalServiceImpl
	extends MasterCurrencyLocalServiceBaseImpl {
	public MasterCurrency addMasterCurrency(String currencyName, double amount, int isDefault, int active)
			throws PortalException {
		long currencyId = counterLocalService.increment();
		MasterCurrency mastercurrency = masterCurrencyPersistence.create(currencyId);

		mastercurrency.setName(currencyName);
		mastercurrency.setAmount(amount);
		mastercurrency.setIsDefault(isDefault);
		mastercurrency.setActive(active);

		masterCurrencyPersistence.update(mastercurrency);

		return mastercurrency;
	}

	public MasterCurrency updateMasterCurrency(long currencyId, String currencyName, double amount, int isDefault,
			int active) throws PortalException {
		MasterCurrency mastercurrency = masterCurrencyPersistence.findByPrimaryKey(currencyId);

		mastercurrency.setCurrencyId(currencyId);
		mastercurrency.setName(currencyName);
		mastercurrency.setAmount(amount);
		mastercurrency.setIsDefault(isDefault);
		mastercurrency.setActive(active);

		masterCurrencyPersistence.update(mastercurrency);

		return mastercurrency;
	}

	public List<MasterCurrency> getMasterCurrencies() {
		return masterCurrencyPersistence.findAll();
	}

	public int getMasterCurrencyCount() {
		return masterCurrencyPersistence.countAll();
	}

	public MasterCurrency setActive(long currencyId, int active, ServiceContext serviceContext) throws PortalException {
		MasterCurrency masterCurrency = null;

		try {
			masterCurrency = masterCurrencyPersistence.findByPrimaryKey(currencyId);
			Date now = new Date();
			masterCurrency.setCurrencyId(currencyId);
			masterCurrency.setActive(active);
			masterCurrency.setModifiedDate(serviceContext.getModifiedDate(now));

			masterCurrencyPersistence.update(masterCurrency);
		} catch (Exception e) {
			System.out.println(e);
		}

		return masterCurrency;
	}

	public MasterCurrency searchCurrency(String _currency) {
		MasterCurrency currency = _masterCurrencyPersistence.fetchBysearchCurrency(_currency);

		return currency;
	}

	@Reference
	MasterCurrencyPersistence _masterCurrencyPersistence;	
}