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
import com.mypage.admin.product.exception.NoSuchSmartActiveBenefitValueException;
import com.mypage.admin.product.model.SmartActiveBenefitValue;
import com.mypage.admin.product.service.base.SmartActiveBenefitValueLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.SmartActiveBenefitValue",
	service = AopService.class
)
public class SmartActiveBenefitValueLocalServiceImpl extends SmartActiveBenefitValueLocalServiceBaseImpl {
	
	public SmartActiveBenefitValue addBenefitValue(long value, int active)
			throws PortalException {
		
		long benefitValueId = counterLocalService.increment();

		SmartActiveBenefitValue benefitValue = smartActiveBenefitValuePersistence.create(benefitValueId);

		benefitValue.setValue(value);
		benefitValue.setActive(active);
		

		smartActiveBenefitValuePersistence.update(benefitValue);

		return benefitValue;
	}

	public SmartActiveBenefitValue updateBenefitValue(long benefitValueId, long value, int active)
			throws PortalException {

		SmartActiveBenefitValue benefitValue = smartActiveBenefitValuePersistence.findByPrimaryKey(benefitValueId);

		benefitValue.setValue(value);
		benefitValue.setActive(active);

		smartActiveBenefitValuePersistence.update(benefitValue);

		return benefitValue;
	}
	
	public List<SmartActiveBenefitValue> getActiveBenefitValue(){
		List<SmartActiveBenefitValue> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("value"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);
		
		return list;
	}
	
	public SmartActiveBenefitValue getActiveBenefitByValue(long val) {
		SmartActiveBenefitValue _result = null;
		try {
			_result = smartActiveBenefitValuePersistence.findByValue(val);
			
		} catch (NoSuchSmartActiveBenefitValueException e) {
			System.out.println(e.getMessage());
		}
		
		return _result;
	}
	
	public SmartActiveBenefitValue setActive(long benefitValueId, int active, ServiceContext serviceContext) throws PortalException {
		SmartActiveBenefitValue benefitValue = null;

		try {
			benefitValue = smartActiveBenefitValuePersistence.findByPrimaryKey(benefitValueId);
			Date now = new Date();
			benefitValue.setActive(active);
			benefitValue.setModifiedDate(serviceContext.getModifiedDate(now));

			smartActiveBenefitValuePersistence.update(benefitValue);

		} catch (Exception e) {
			System.out.println(e);
		}

		return benefitValue;
	}
}