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
import com.mypage.admin.product.exception.NoSuchStiBenefitValueMappingException;
import com.mypage.admin.product.model.StiBenefitValueMapping;
import com.mypage.admin.product.service.base.StiBenefitValueMappingLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.StiBenefitValueMapping",
	service = AopService.class
)
public class StiBenefitValueMappingLocalServiceImpl
	extends StiBenefitValueMappingLocalServiceBaseImpl {
	
	public List<StiBenefitValueMapping> getAllBenefitValueMappings() {
		return stiBenefitValueMappingPersistence.findAll();
	}
	
	public List<StiBenefitValueMapping> getBenefitValueMappings(int start, int end) {
		return stiBenefitValueMappingPersistence.findAll(start, end);
	}

	public List<StiBenefitValueMapping> getActiveBenefitValueMapping() {
		List<StiBenefitValueMapping> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("sort"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);

		return list;
	}

	public int getBenefitValueMappingCount() {
		return stiBenefitValueMappingPersistence.countAll();
	}
	
	public List<StiBenefitValueMapping> getAllBenefitValueMappingByBenefitType(long benefitTypeId) {
		List<StiBenefitValueMapping> benefitValueMappings = stiBenefitValueMappingPersistence.findByBenefitTypeId(benefitTypeId);  
		return benefitValueMappings;
	}
	
	public List<StiBenefitValueMapping> getBenefitValueMappingByBenefitTypeAndBenefit(long benefitTypeId, long benefitId) {
		List<StiBenefitValueMapping> benefitValueMapping = null;
		try {
			benefitValueMapping = stiBenefitValueMappingPersistence.findByBenefitTypeIdAndBenefitId(benefitTypeId, benefitId);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return benefitValueMapping;
	}
	
	public StiBenefitValueMapping getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(long benefitTypeId, long benefitId, long planId) {
		StiBenefitValueMapping benefitValueMapping = null;
		try {
			benefitValueMapping = stiBenefitValueMappingPersistence.findByBenefitTypeIdAndBenefitIdAndPlanId(benefitTypeId, benefitId, planId);
		} catch (NoSuchStiBenefitValueMappingException e) {
			System.out.println(e.getMessage());
		}

		return benefitValueMapping;
	}

	public StiBenefitValueMapping setActive(long benefitValueMappingId, int active, ServiceContext serviceContext) throws PortalException {
		StiBenefitValueMapping benefitValueMapping = null;

		try {
			benefitValueMapping = stiBenefitValueMappingPersistence.findByPrimaryKey(benefitValueMappingId);
			Date now = new Date();
			benefitValueMapping.setBenefitValueMappingId(benefitValueMappingId);
			benefitValueMapping.setActive(active);
			benefitValueMapping.setModifiedDate(serviceContext.getModifiedDate(now));

			stiBenefitValueMappingPersistence.update(benefitValueMapping);

		} catch (Exception e) {
			System.out.println(e);
		}

		return benefitValueMapping;
	}
}