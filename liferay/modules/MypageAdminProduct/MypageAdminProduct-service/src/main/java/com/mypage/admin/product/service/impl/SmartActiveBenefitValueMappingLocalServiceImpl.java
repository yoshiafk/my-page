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
import com.mypage.admin.product.exception.NoSuchSmartActiveBenefitValueMappingException;
import com.mypage.admin.product.model.SmartActiveBenefitValueMapping;
import com.mypage.admin.product.service.base.SmartActiveBenefitValueMappingLocalServiceBaseImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.SmartActiveBenefitValueMapping",
	service = AopService.class
)
public class SmartActiveBenefitValueMappingLocalServiceImpl extends SmartActiveBenefitValueMappingLocalServiceBaseImpl {
	
	public SmartActiveBenefitValueMapping addBenefitValueMapping(long benefitTypeId, long benefitId, long benefitValueId, String benefitValue, BigDecimal limitValue, int active)
			throws PortalException {
		
		long benefitValueMappingId = counterLocalService.increment();

		SmartActiveBenefitValueMapping benefitValueMapping = smartActiveBenefitValueMappingPersistence.create(benefitValueMappingId);

		benefitValueMapping.setSmartActiveBenefitTypeId(benefitTypeId);
		benefitValueMapping.setSmartActiveBenefitId(benefitId);
		benefitValueMapping.setSmartActiveBenefitValueId(benefitValueId);
		benefitValueMapping.setValue(benefitValue);
		benefitValueMapping.setLimitValue(limitValue);
		benefitValueMapping.setActive(active);
		

		smartActiveBenefitValueMappingPersistence.update(benefitValueMapping);

		return benefitValueMapping;
	}

	public SmartActiveBenefitValueMapping updateBenefitValueMapping(long benefitValueMappingId, long benefitTypeId, long benefitId, long benefitValueId, String benefitValue, BigDecimal limitValue, int active)
			throws PortalException {

		SmartActiveBenefitValueMapping benefitValueMapping = smartActiveBenefitValueMappingPersistence.findByPrimaryKey(benefitValueMappingId);

		benefitValueMapping.setSmartActiveBenefitTypeId(benefitTypeId);
		benefitValueMapping.setSmartActiveBenefitId(benefitId);
		benefitValueMapping.setSmartActiveBenefitValueId(benefitValueId);
		benefitValueMapping.setValue(benefitValue);
		benefitValueMapping.setLimitValue(limitValue);
		benefitValueMapping.setActive(active);

		smartActiveBenefitValueMappingPersistence.update(benefitValueMapping);

		return benefitValueMapping;
	}
	
	public List<SmartActiveBenefitValueMapping> getAllBenefitValueMappings() {
		return smartActiveBenefitValueMappingPersistence.findAll();
	}
	
	public List<SmartActiveBenefitValueMapping> getBenefitValueMappings(int start, int end) {
		return smartActiveBenefitValueMappingPersistence.findAll(start, end);
	}

	public List<SmartActiveBenefitValueMapping> getBenefitValueMapping() {
		List<SmartActiveBenefitValueMapping> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("smartActiveBenefitValueMappingId"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);

		return list;
	}

	public int getBenefitValueMappingCount() {
		return smartActiveBenefitValueMappingPersistence.countAll();
	}
	
	public List<SmartActiveBenefitValueMapping> getAllByBenefitValue(long benefitValueId) {
		List<SmartActiveBenefitValueMapping> benefitValueMappings = smartActiveBenefitValueMappingPersistence.findByBenefitValueId(benefitValueId);  
		return benefitValueMappings;
	}
	
	public SmartActiveBenefitValueMapping getBenefitValueMappingByBenefitIdAndBenefitValueId(long smartActiveBenefitId, long smartActiveBenefitValueId) {
		SmartActiveBenefitValueMapping _result = null;
		
		try {
			_result = smartActiveBenefitValueMappingPersistence.findByBenefitIdAndBenefitValueId(smartActiveBenefitId, smartActiveBenefitValueId);
		} catch (NoSuchSmartActiveBenefitValueMappingException e) {
			System.out.println(e.getMessage());
		}
		
		return _result;
	}

	public SmartActiveBenefitValueMapping setActive(long benefitValueMappingId, int active, ServiceContext serviceContext) throws PortalException {
		SmartActiveBenefitValueMapping benefitValueMapping = null;

		try {
			benefitValueMapping = smartActiveBenefitValueMappingPersistence.findByPrimaryKey(benefitValueMappingId);
			Date now = new Date();
			benefitValueMapping.setActive(active);
			benefitValueMapping.setModifiedDate(serviceContext.getModifiedDate(now));

			smartActiveBenefitValueMappingPersistence.update(benefitValueMapping);

		} catch (Exception e) {
			System.out.println(e);
		}

		return benefitValueMapping;
	}
}