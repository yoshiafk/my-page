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
import com.mypage.admin.product.exception.NoSuchIntTravelStandardNewPremiException;
import com.mypage.admin.product.model.IntTravelStandardNewPremi;
import com.mypage.admin.product.service.base.IntTravelStandardNewPremiLocalServiceBaseImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(property = "model.class.name=com.mypage.admin.product.model.IntTravelStandardNewPremi", service = AopService.class)
public class IntTravelStandardNewPremiLocalServiceImpl extends IntTravelStandardNewPremiLocalServiceBaseImpl {

	public IntTravelStandardNewPremi addIntTravelStandardNewPremi(String travelType, String packageType,
			String peopleType, int mainInsured, int spouse, int child, String currency, BigDecimal amount,
			BigDecimal additionalPrice, int active) throws PortalException {
		long intTravelStandardNewPremiId = counterLocalService.increment();
		IntTravelStandardNewPremi intTravelStandardNewPremi = intTravelStandardNewPremiPersistence
				.create(intTravelStandardNewPremiId);

		intTravelStandardNewPremi.setTravelType(travelType);
		intTravelStandardNewPremi.setPackageType(packageType);
		intTravelStandardNewPremi.setPeopleType(peopleType);
		intTravelStandardNewPremi.setMainInsured(mainInsured);
		intTravelStandardNewPremi.setSpouse(spouse);
		intTravelStandardNewPremi.setChild(child);
		intTravelStandardNewPremi.setCurrency(currency);
		intTravelStandardNewPremi.setAmount(amount);
		intTravelStandardNewPremi.setAdditionalPrice(additionalPrice);
		intTravelStandardNewPremi.setActive(active);

		intTravelStandardNewPremiPersistence.update(intTravelStandardNewPremi);

		return intTravelStandardNewPremi;
	}

	/*
	 * Update
	 */
	public IntTravelStandardNewPremi updateIntTravelStandardNewPremi(long intTravelStandardNewPremiId,
			String travelType, String packageType, String peopleType, int mainInsured, int spouse, int child,
			String currency, BigDecimal amount, BigDecimal additionalPrice, int active) throws PortalException {
		IntTravelStandardNewPremi intTravelStandardNewPremi = intTravelStandardNewPremiPersistence
				.findByPrimaryKey(intTravelStandardNewPremiId);

		intTravelStandardNewPremi.setIntTravelStandardNewPremiId(intTravelStandardNewPremiId);
		intTravelStandardNewPremi.setTravelType(travelType);
		intTravelStandardNewPremi.setPackageType(packageType);
		intTravelStandardNewPremi.setPeopleType(peopleType);
		intTravelStandardNewPremi.setMainInsured(mainInsured);
		intTravelStandardNewPremi.setSpouse(spouse);
		intTravelStandardNewPremi.setChild(child);
		intTravelStandardNewPremi.setCurrency(currency);
		intTravelStandardNewPremi.setAmount(amount);
		intTravelStandardNewPremi.setAdditionalPrice(additionalPrice);
		intTravelStandardNewPremi.setActive(active);

		intTravelStandardNewPremiPersistence.update(intTravelStandardNewPremi);

		return intTravelStandardNewPremi;
	}

	public List<IntTravelStandardNewPremi> getPremis(int start, int end) {
		return intTravelStandardNewPremiPersistence.findAll(start, end);
	}

	public List<IntTravelStandardNewPremi> getPremis() {
		return intTravelStandardNewPremiPersistence.findAll();
	}

	public int getPremisCount() {
		return intTravelStandardNewPremiPersistence.countAll();
	}

	public IntTravelStandardNewPremi searchSpesificPremi(String travelType, String packageType, String peopleType,
			String currency, int mainInsured, int spouse, int child) {
		IntTravelStandardNewPremi _premi = null;

		try {
			_premi = intTravelStandardNewPremiPersistence.findBySpecificPremi(travelType, packageType, peopleType,
					currency, mainInsured, spouse, child);
		} catch (NoSuchIntTravelStandardNewPremiException e) {
			e.printStackTrace();
		}

		return _premi;
	}

	public IntTravelStandardNewPremi setActive(long intTravelStandardNewPremiId, int active,
			ServiceContext serviceContext) throws PortalException {
		IntTravelStandardNewPremi intTravelStandardNewPremi = null;

		try {
			intTravelStandardNewPremi = intTravelStandardNewPremiPersistence
					.findByPrimaryKey(intTravelStandardNewPremiId);
			Date now = new Date();
			intTravelStandardNewPremi.setIntTravelStandardNewPremiId(intTravelStandardNewPremiId);
			intTravelStandardNewPremi.setActive(active);
			intTravelStandardNewPremi.setModifiedDate(serviceContext.getModifiedDate(now));

			intTravelStandardNewPremiPersistence.update(intTravelStandardNewPremi);
		} catch (NoSuchIntTravelStandardNewPremiException e) {
			e.printStackTrace();
		}

		return intTravelStandardNewPremi;
	}

}