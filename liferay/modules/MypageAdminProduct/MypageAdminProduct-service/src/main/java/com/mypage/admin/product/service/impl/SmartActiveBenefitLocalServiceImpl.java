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
import com.mypage.admin.product.exception.NoSuchSmartActiveBenefitException;
import com.mypage.admin.product.model.SmartActiveBenefit;
import com.mypage.admin.product.service.base.SmartActiveBenefitLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.SmartActiveBenefit",
	service = AopService.class
)
public class SmartActiveBenefitLocalServiceImpl extends SmartActiveBenefitLocalServiceBaseImpl {
	
	public SmartActiveBenefit addBenefit(String nameId, String nameEn, int sort, int active, long benefitTypeId, String benefitLimit, String externalCode, String benefitDescription)
			throws PortalException {
		
		long benefitId = counterLocalService.increment();

		SmartActiveBenefit benefit = smartActiveBenefitPersistence.create(benefitId);

		benefit.setNameId(nameId);
		benefit.setNameEn(nameEn);
		benefit.setSort(sort);
		benefit.setSmartActiveBenefitTypeId(benefitTypeId);
		benefit.setActive(active);
		benefit.setLimit_(benefitLimit);
		benefit.setExternalCode(externalCode);
		benefit.setDescription(benefitDescription);

		smartActiveBenefitPersistence.update(benefit);

		return benefit;
	}

	public SmartActiveBenefit updateBenefit(long benefitId, long benefitTypeId, String nameId, String nameEn, int sort, int active, String benefitLimit, String externalCode, String benefitDescription)
			throws PortalException {

		SmartActiveBenefit benefit = smartActiveBenefitPersistence.findByPrimaryKey(benefitId);

		benefit.setNameId(nameId);
		benefit.setNameEn(nameEn);
		benefit.setSort(sort);
		benefit.setSmartActiveBenefitTypeId(benefitTypeId);
		benefit.setActive(active);
		benefit.setLimit_(benefitLimit);
		benefit.setExternalCode(externalCode);
		benefit.setDescription(benefitDescription);

		smartActiveBenefitPersistence.update(benefit);

		return benefit;
	}
	
	public List<SmartActiveBenefit> getBenefits(int start, int end) {
		return smartActiveBenefitPersistence.findAll(start, end);
	}

	public List<SmartActiveBenefit> getActiveBenefit() {
		List<SmartActiveBenefit> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("sort"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);

		return list;
	}

	public List<SmartActiveBenefit> getBenefits() {
		return smartActiveBenefitPersistence.findAll();
	}

	public int getBenefitCount() {
		return smartActiveBenefitPersistence.countAll();
	}
	
	public SmartActiveBenefit getByExternalCode(String externalCode) {
		SmartActiveBenefit data = null;

		try {
			data = smartActiveBenefitPersistence.findByExternalCode(externalCode);
		} catch (NoSuchSmartActiveBenefitException e) {
			System.out.println(e.getMessage());
		}

		return data;
	}

	public SmartActiveBenefit setActive(long benefitId, int active, ServiceContext serviceContext) throws PortalException {
		SmartActiveBenefit benefit = null;

		try {
			benefit = smartActiveBenefitPersistence.findByPrimaryKey(benefitId);
			Date now = new Date();
			benefit.setActive(active);
			benefit.setModifiedDate(serviceContext.getModifiedDate(now));

			smartActiveBenefitPersistence.update(benefit);

		} catch (Exception e) {
			System.out.println(e);
		}

		return benefit;
	}

	public List<SmartActiveBenefit> getBenefitByTypeId(long typeId) {
	    List<SmartActiveBenefit> list = null;

	    DynamicQuery query = dynamicQuery();
	    query.addOrder(OrderFactoryUtil.asc("sort"));
	    query.add(PropertyFactoryUtil.forName("active").ge(1));
	    query.add(PropertyFactoryUtil.forName("smartActiveBenefitTypeId").eq(typeId));
	    
	    // Menjalankan query
	    list = dynamicQuery(query);
	    
	    return list;
	}
}