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
import com.mypage.admin.product.model.MasterBank;
import com.mypage.admin.product.service.base.MasterBankLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.MasterBank",
	service = AopService.class
)
public class MasterBankLocalServiceImpl extends MasterBankLocalServiceBaseImpl {
	
	public MasterBank addMasterBank(String bankCode, String bankDesc, String name, String detail, String imageURL,
			long imageFileEntryId, int order, int active) throws PortalException {
		long bankId = counterLocalService.increment();
		MasterBank masterbank = masterBankPersistence.create(bankId);

		masterbank.setBankCode(bankCode);
		masterbank.setBankDesc(bankDesc);
		masterbank.setName(name);
		masterbank.setDetail(detail);
		masterbank.setImageURL(imageURL);
		masterbank.setImageFileEntryId(imageFileEntryId);
		masterbank.setOrder(order);
		masterbank.setActive(active);

		masterBankPersistence.update(masterbank);

		return masterbank;
	}

	public MasterBank updateMasterBank(long masterBankId, String bankCode, String bankDesc, String name, String detail,
			String imageURL, long imageFileEntryId, int order, int active, boolean isImport) throws PortalException {
		MasterBank masterbank = masterBankPersistence.findByPrimaryKey(masterBankId);

		masterbank.setBankCode(bankCode);
		masterbank.setBankDesc(bankDesc);
		masterbank.setName(name);
		masterbank.setDetail(detail);
		if (isImport != true) {
			masterbank.setImageURL(imageURL);
			masterbank.setImageFileEntryId(imageFileEntryId);
		}
		masterbank.setOrder(order);
		masterbank.setActive(active);

		masterBankPersistence.update(masterbank);

		return masterbank;
	}

	public MasterBank setActive(long masterBankId, int active, ServiceContext serviceContext) throws PortalException {
		MasterBank masterbank = null;

		try {
			masterbank = masterBankPersistence.findByPrimaryKey(masterBankId);
			Date now = new Date();
			masterbank.setActive(active);
			masterbank.setModifiedDate(serviceContext.getModifiedDate(now));

			masterBankPersistence.update(masterbank);
		} catch (Exception e) {
			System.out.println(e);
		}

		return masterbank;
	}

	public List<MasterBank> getActiveBanks() {
		List<MasterBank> banks = masterBankPersistence.findByactiveBanks(1);
		return banks;
	}

	public List<MasterBank> findByName(String name, int active) {
		List<MasterBank> banks = masterBankPersistence.findBysearchByName(name, active);
		return banks;
	}
}