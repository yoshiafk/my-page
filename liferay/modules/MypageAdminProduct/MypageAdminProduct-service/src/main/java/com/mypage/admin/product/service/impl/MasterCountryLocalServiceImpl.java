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
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.admin.product.model.MasterCountry;
import com.mypage.admin.product.service.MasterCountryLocalServiceUtil;
import com.mypage.admin.product.service.base.MasterCountryLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.MasterCountry",
	service = AopService.class
)
public class MasterCountryLocalServiceImpl
	extends MasterCountryLocalServiceBaseImpl {
	public MasterCountry addMasterCountry(String name, int isPlatinum, int isGold, int isSpecialAsia, int isSchengen,
			int isSanctionCountry, int active) throws PortalException {
		long countryId = counterLocalService.increment();
		MasterCountry mastercountry = masterCountryPersistence.create(countryId);

		mastercountry.setName(name);
		mastercountry.setIsPlatinum(isPlatinum);
		mastercountry.setIsGold(isGold);
		mastercountry.setIsSpecialAsia(isSpecialAsia);
		mastercountry.setIsSchengen(isSchengen);
		mastercountry.setIsSanctionCountry(isSanctionCountry);
		mastercountry.setActive(active);

		masterCountryPersistence.update(mastercountry);

		return mastercountry;
	}

	public MasterCountry updateMasterCountry(long countryId, String name, int isPlatinum, int isGold, int isSpecialAsia,
			int isSchengen, int isSanctionCountry, int active) throws PortalException {
		MasterCountry mastercountry = masterCountryPersistence.findByPrimaryKey(countryId);

		mastercountry.setCountryId(countryId);
		mastercountry.setName(name);
		mastercountry.setIsPlatinum(isPlatinum);
		mastercountry.setIsGold(isGold);
		mastercountry.setIsSpecialAsia(isSpecialAsia);
		mastercountry.setIsSchengen(isSchengen);
		mastercountry.setIsSanctionCountry(isSanctionCountry);
		mastercountry.setActive(active);

		masterCountryPersistence.update(mastercountry);

		return mastercountry;
	}

	public MasterCountry updateMasterCountry(long countryId, String name, int isPlatinum, int isGold, int isSpecialAsia,
			int isSchengen, int isSanctionCountry) throws PortalException {
		MasterCountry mastercountry = masterCountryPersistence.findByPrimaryKey(countryId);

		mastercountry.setCountryId(countryId);
		mastercountry.setName(name);
		mastercountry.setIsPlatinum(isPlatinum);
		mastercountry.setIsGold(isGold);
		mastercountry.setIsSpecialAsia(isSpecialAsia);
		mastercountry.setIsSchengen(isSchengen);
		mastercountry.setIsSanctionCountry(isSanctionCountry);

		masterCountryPersistence.update(mastercountry);

		return mastercountry;
	}

	public List<MasterCountry> getMasterCountries() {
		return masterCountryPersistence.findAll();
	}

	public int getMasterCountryCount() {
		return masterCountryPersistence.countAll();
	}

	public MasterCountry setActive(long countryId, int active, ServiceContext serviceContext) throws PortalException {
		MasterCountry masterCountry = null;

		try {
			masterCountry = masterCountryPersistence.findByPrimaryKey(countryId);
			Date now = new Date();
			masterCountry.setCountryId(countryId);
			masterCountry.setActive(active);
			masterCountry.setModifiedDate(serviceContext.getModifiedDate(now));

			masterCountryPersistence.update(masterCountry);
		} catch (Exception e) {
			System.out.println(e);
		}

		return masterCountry;
	}

	public List<MasterCountry> getActiveCountries() {
		List<MasterCountry> countries = masterCountryPersistence.findByactiveCountries(0, 1, 0,
				masterCountryPersistence.countByactiveCountries(0, 1));
		return countries;
	}

	public List<MasterCountry> getMasterCountryByname(String name) {
		DynamicQuery query = MasterCountryLocalServiceUtil.dynamicQuery();
		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + name + "%"));
		conjunction.add(RestrictionsFactoryUtil.eq("active", 1));
		query.add(conjunction);

		List<MasterCountry> countries = MasterCountryLocalServiceUtil.dynamicQuery(query);
		return countries;
	}	
}