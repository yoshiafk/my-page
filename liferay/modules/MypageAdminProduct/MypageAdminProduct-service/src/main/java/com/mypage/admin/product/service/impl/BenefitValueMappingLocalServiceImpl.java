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
import com.mypage.admin.product.exception.NoSuchBenefitValueMappingException;
import com.mypage.admin.product.model.BenefitValueMapping;
import com.mypage.admin.product.service.base.BenefitValueMappingLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.BenefitValueMapping",
	service = AopService.class
)
public class BenefitValueMappingLocalServiceImpl
	extends BenefitValueMappingLocalServiceBaseImpl {
	
	public BenefitValueMapping addBenefitValueMapping(long benefitTypeId, long benefitId, long planId, String benefitValue, String benefitValueUSD, int sort, int active)
			throws PortalException {
		
		long benefitValueMappingId = counterLocalService.increment();

		BenefitValueMapping benefitValueMapping = benefitValueMappingPersistence.create(benefitValueMappingId);

		benefitValueMapping.setBenefitTypeId(benefitTypeId);
		benefitValueMapping.setBenefitId(benefitId);
		benefitValueMapping.setPlanId(planId);
		benefitValueMapping.setBenefitValue(benefitValue);
		benefitValueMapping.setBenefitValueUSD(benefitValueUSD);
		benefitValueMapping.setSort(sort);
		benefitValueMapping.setActive(active);
		

		benefitValueMappingPersistence.update(benefitValueMapping);

		return benefitValueMapping;
	}

	public BenefitValueMapping updateBenefit(long benefitValueMappingId, long benefitTypeId, long benefitId, long planId, String benefitValue, String benefitValueUSD, int sort, int active)
			throws PortalException {

		BenefitValueMapping benefitValueMapping = benefitValueMappingPersistence.findByPrimaryKey(benefitValueMappingId);

		benefitValueMapping.setBenefitTypeId(benefitTypeId);
		benefitValueMapping.setBenefitId(benefitId);
		benefitValueMapping.setPlanId(planId);
		benefitValueMapping.setBenefitValue(benefitValue);
		benefitValueMapping.setBenefitValueUSD(benefitValueUSD);
		benefitValueMapping.setSort(sort);
		benefitValueMapping.setActive(active);

		benefitValueMappingPersistence.update(benefitValueMapping);

		return benefitValueMapping;
	}
	
	public List<BenefitValueMapping> getAllBenefitValueMappings() {
		return benefitValueMappingPersistence.findAll();
	}
	
	public List<BenefitValueMapping> getBenefitValueMappings(int start, int end) {
		return benefitValueMappingPersistence.findAll(start, end);
	}

	public List<BenefitValueMapping> getActiveBenefitValueMapping() {
		List<BenefitValueMapping> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("sort"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);

		return list;
	}

	public int getBenefitValueMappingCount() {
		return benefitValueMappingPersistence.countAll();
	}
	
	public List<BenefitValueMapping> getAllBenefitValueMappingByBenefitType(long benefitTypeId) {
		List<BenefitValueMapping> benefitValueMappings = benefitValueMappingPersistence.findByBenefitTypeId(benefitTypeId);  
		return benefitValueMappings;
	}
	
	public List<BenefitValueMapping> getBenefitValueMappingByBenefitTypeAndBenefit(long benefitTypeId, long benefitId) {
		List<BenefitValueMapping> benefitValueMapping = null;
		try {
			benefitValueMapping = benefitValueMappingPersistence.findByBenefitTypeIdAndBenefitId(benefitTypeId, benefitId);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return benefitValueMapping;
	}
	
	public BenefitValueMapping getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(long benefitTypeId, long benefitId, long planId) {
		BenefitValueMapping benefitValueMapping = null;
		try {
			benefitValueMapping = benefitValueMappingPersistence.findByBenefitTypeIdAndBenefitIdAndPlanId(benefitTypeId, benefitId, planId);
		} catch (NoSuchBenefitValueMappingException e) {
			System.out.println(e.getMessage());
		}

		return benefitValueMapping;
	}

	public BenefitValueMapping setActive(long benefitValueMappingId, int active, ServiceContext serviceContext) throws PortalException {
		BenefitValueMapping benefitValueMapping = null;

		try {
			benefitValueMapping = benefitValueMappingPersistence.findByPrimaryKey(benefitValueMappingId);
			Date now = new Date();
			benefitValueMapping.setBenefitValueMappingId(benefitValueMappingId);
			benefitValueMapping.setActive(active);
			benefitValueMapping.setModifiedDate(serviceContext.getModifiedDate(now));

			benefitValueMappingPersistence.update(benefitValueMapping);

		} catch (Exception e) {
			System.out.println(e);
		}

		return benefitValueMapping;
	}
}