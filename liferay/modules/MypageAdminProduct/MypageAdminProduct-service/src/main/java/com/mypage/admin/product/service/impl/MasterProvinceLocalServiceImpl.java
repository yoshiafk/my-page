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
import com.mypage.admin.product.model.MasterProvince;
import com.mypage.admin.product.service.MasterProvinceLocalServiceUtil;
import com.mypage.admin.product.service.base.MasterProvinceLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.MasterProvince",
	service = AopService.class
)
public class MasterProvinceLocalServiceImpl
	extends MasterProvinceLocalServiceBaseImpl {
	
	public MasterProvince addMasterProvince(String name, int countryId, int active) throws PortalException {
		long provinceId = counterLocalService.increment();
		MasterProvince masterprovince = masterProvincePersistence.create(provinceId);

		masterprovince.setName(name);
		masterprovince.setCountryId(countryId);
		masterprovince.setActive(active);

		masterProvincePersistence.update(masterprovince);

		return masterprovince;
	}

	public MasterProvince updateMasterProvince(long masterProvinceId, String name, int countryId, int active)
			throws PortalException {
		MasterProvince masterprovince = masterProvincePersistence.findByPrimaryKey(masterProvinceId);

		masterprovince.setName(name);
		masterprovince.setCountryId(countryId);
		masterprovince.setActive(active);

		masterProvincePersistence.update(masterprovince);

		return masterprovince;
	}

	public MasterProvince setActive(long masterProvinceId, int active, ServiceContext serviceContext)
			throws PortalException {
		MasterProvince masterprovince = null;

		try {
			masterprovince = masterProvincePersistence.findByPrimaryKey(masterProvinceId);
			Date now = new Date();
			masterprovince.setActive(active);
			masterprovince.setModifiedDate(serviceContext.getModifiedDate(now));

			masterProvincePersistence.update(masterprovince);
		} catch (Exception e) {
			System.out.println(e);
		}

		return masterprovince;
	}

	public List<MasterProvince> getActiveProvinces() {
		List<MasterProvince> provinces = masterProvincePersistence.findByactiveProvinces(1);
		return provinces;
	}

	public List<MasterProvince> getMasterProvinceByname(String name) {
		DynamicQuery query = MasterProvinceLocalServiceUtil.dynamicQuery();
		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		conjunction.add(RestrictionsFactoryUtil.ilike("name", "%" + name + "%"));
		conjunction.add(RestrictionsFactoryUtil.eq("active", 1));
		query.add(conjunction);

		List<MasterProvince> provinces = MasterProvinceLocalServiceUtil.dynamicQuery(query);
		return provinces;
	}
}