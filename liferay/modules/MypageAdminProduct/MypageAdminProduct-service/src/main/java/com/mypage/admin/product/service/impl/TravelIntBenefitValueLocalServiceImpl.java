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
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.mypage.admin.product.model.TravelIntBenefitValue;
import com.mypage.admin.product.service.base.TravelIntBenefitValueLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.TravelIntBenefitValue",
	service = AopService.class
)
public class TravelIntBenefitValueLocalServiceImpl
	extends TravelIntBenefitValueLocalServiceBaseImpl {
	
	/**
	 * Add
	 */
	public TravelIntBenefitValue addTravelIntBenefitValue(long travelIntBenefitId, String currencyName,
			String packageType, String benefitValue, int active) throws PortalException {

		long travelIntBenefitValueId = counterLocalService.increment();
		TravelIntBenefitValue travelIntBenefitValue = travelIntBenefitValuePersistence.create(travelIntBenefitValueId);

		travelIntBenefitValue.setTravelIntBenefitId(travelIntBenefitId);
		travelIntBenefitValue.setCurrencyName(currencyName);
		travelIntBenefitValue.setPackageType(packageType);
		travelIntBenefitValue.setBenefitValue(benefitValue);
		travelIntBenefitValue.setActive(active);

		travelIntBenefitValuePersistence.update(travelIntBenefitValue);

		return travelIntBenefitValue;

	}

	/**
	 * Update
	 */
	public TravelIntBenefitValue updateTravelIntBenefitValue(long travelIntBenefitValueId, long travelIntBenefitId,
			String currencyName, String packageType, String benefitValue, int active) throws PortalException {

		TravelIntBenefitValue travelIntBenefitValue = travelIntBenefitValuePersistence
				.fetchByPrimaryKey(travelIntBenefitValueId);

		travelIntBenefitValue.setTravelIntBenefitValueId(travelIntBenefitValueId);
		travelIntBenefitValue.setTravelIntBenefitId(travelIntBenefitId);
		travelIntBenefitValue.setCurrencyName(currencyName);
		travelIntBenefitValue.setPackageType(packageType);
		travelIntBenefitValue.setBenefitValue(benefitValue);
		travelIntBenefitValue.setActive(active);

		travelIntBenefitValuePersistence.update(travelIntBenefitValue);

		return travelIntBenefitValue;
	}

	public List<TravelIntBenefitValue> getTravelIntBenefitValues(int start, int end) {
		return travelIntBenefitValuePersistence.findAll(start, end);
	}

	public List<TravelIntBenefitValue> getTravelIntBenefitValues() {
		return travelIntBenefitValuePersistence.findAll();
	}

	public int gettravelIntBenefitValueCount() {
		return travelIntBenefitValuePersistence.countAll();
	}

	public List<TravelIntBenefitValue> findByPackageType(String packageType) {
		return travelIntBenefitValuePersistence.findByPackageType(packageType);
	}

	public List<TravelIntBenefitValue> findByPackageTypeAndCurrencyName(long benefitParentId, String packageType,
			String currencyName) {
		DynamicQuery query = dynamicQuery();
		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		conjunction.add(RestrictionsFactoryUtil.eq("travelInternationalBenefitId", benefitParentId));
		conjunction.add(RestrictionsFactoryUtil.eq("packageType", packageType));
		conjunction.add(RestrictionsFactoryUtil.eq("currencyName", currencyName.toLowerCase()));
		query.add(conjunction);

		return dynamicQuery(query);
	}

}