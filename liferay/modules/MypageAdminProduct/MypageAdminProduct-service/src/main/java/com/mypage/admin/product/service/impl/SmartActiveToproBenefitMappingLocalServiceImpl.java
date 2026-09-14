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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.admin.product.model.SmartActiveToproBenefitMapping;
import com.mypage.admin.product.service.base.SmartActiveToproBenefitMappingLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.SmartActiveToproBenefitMapping",
	service = AopService.class
)
public class SmartActiveToproBenefitMappingLocalServiceImpl extends SmartActiveToproBenefitMappingLocalServiceBaseImpl {
	public SmartActiveToproBenefitMapping addToproBenefitMapping(long toproId, String listBenefitId, int active)
			throws PortalException {
		
		long toproBenefitMappingId = counterLocalService.increment();

		SmartActiveToproBenefitMapping toproBenefitMapping = smartActiveToproBenefitMappingPersistence.create(toproBenefitMappingId);

		toproBenefitMapping.setSmartActiveToproId(toproId);
		toproBenefitMapping.setListBenefitId(listBenefitId);
		toproBenefitMapping.setActive(active);
		

		smartActiveToproBenefitMappingPersistence.update(toproBenefitMapping);

		return toproBenefitMapping;
	}

	public SmartActiveToproBenefitMapping updateToproBenefitMapping(long toproBenefitMappingId, long toproId, String listBenefitId, int active)
			throws PortalException {

		SmartActiveToproBenefitMapping toproBenefitMapping = smartActiveToproBenefitMappingPersistence.findByPrimaryKey(toproBenefitMappingId);

		toproBenefitMapping.setSmartActiveToproId(toproId);
		toproBenefitMapping.setListBenefitId(listBenefitId);
		toproBenefitMapping.setActive(active);

		smartActiveToproBenefitMappingPersistence.update(toproBenefitMapping);

		return toproBenefitMapping;
	}
	
	public List<SmartActiveToproBenefitMapping> getAllToproBenefitMappings() {
		return smartActiveToproBenefitMappingPersistence.findAll();
	}
	
	public List<SmartActiveToproBenefitMapping> getToproBenefitMappings(int start, int end) {
		return smartActiveToproBenefitMappingPersistence.findAll(start, end);
	}

	public List<SmartActiveToproBenefitMapping> getToproBenefitMapping() {
		List<SmartActiveToproBenefitMapping> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("smartActiveToproBenefitMappingId"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);

		return list;
	}

	public int getToproBenefitMappingCount() {
		return smartActiveToproBenefitMappingPersistence.countAll();
	}

	public SmartActiveToproBenefitMapping setActive(long toproBenefitMappingId, int active, ServiceContext serviceContext) throws PortalException {
		SmartActiveToproBenefitMapping toproBenefitMapping = null;

		try {
			toproBenefitMapping = smartActiveToproBenefitMappingPersistence.findByPrimaryKey(toproBenefitMappingId);
			Date now = new Date();
			toproBenefitMapping.setActive(active);
			toproBenefitMapping.setModifiedDate(serviceContext.getModifiedDate(now));

			smartActiveToproBenefitMappingPersistence.update(toproBenefitMapping);

		} catch (Exception e) {
			System.out.println(e);
		}

		return toproBenefitMapping;
	}
}