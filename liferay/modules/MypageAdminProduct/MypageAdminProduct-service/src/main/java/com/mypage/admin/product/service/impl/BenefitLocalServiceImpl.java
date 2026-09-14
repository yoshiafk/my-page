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
import com.mypage.admin.product.model.Benefit;
import com.mypage.admin.product.service.base.BenefitLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(property = "model.class.name=com.mypage.admin.product.model.Benefit", service = AopService.class)
public class BenefitLocalServiceImpl extends BenefitLocalServiceBaseImpl {

	public Benefit addBenefit(String nameId, String nameEn, int sort, int active, long benefitTypeId, String planName, String benefitValue, String externalCode, String benefitDescription)
			throws PortalException {
		
		long benefitId = counterLocalService.increment();

		Benefit benefit = benefitPersistence.create(benefitId);

		benefit.setNameId(nameId);
		benefit.setNameEn(nameEn);
		benefit.setSort(sort);
		benefit.setBenefitTypeId(benefitTypeId);
		benefit.setActive(active);
		
		benefit.setPlanName(planName);
		benefit.setBenefitValue(benefitValue);
		benefit.setExternalCode(externalCode);
		benefit.setBenefitDescription(benefitDescription);
		

		benefitPersistence.update(benefit);

		return benefit;
	}

	public Benefit updateBenefit(long benefitId, long benefitTypeId, String nameId, String nameEn, int sort, int active, String planName, String benefitValue, String externalCode, String benefitDescription)
			throws PortalException {

		Benefit benefit = benefitPersistence.findByPrimaryKey(benefitId);

		benefit.setBenefitId(benefitId);
		benefit.setNameId(nameId);
		benefit.setNameEn(nameEn);
		benefit.setSort(sort);
		benefit.setBenefitTypeId(benefitTypeId);
		benefit.setActive(active);
		
		benefit.setPlanName(planName);
		benefit.setBenefitValue(benefitValue);
		benefit.setExternalCode(externalCode);
		
		benefit.setBenefitDescription(benefitDescription);

		benefitPersistence.update(benefit);

		return benefit;
	}
	
	public List<Benefit> getBenefits(int start, int end) {
		return benefitPersistence.findAll(start, end);
	}

	public List<Benefit> getActiveBenefit() {
		List<Benefit> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("sort"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);

		return list;
	}

	public List<Benefit> getBenefits() {
		return benefitPersistence.findAll();
	}

	public int getBenefitCount() {
		return benefitPersistence.countAll();
	}

	public Benefit setActive(long benefitId, int active, ServiceContext serviceContext) throws PortalException {
		Benefit benefit = null;

		try {
			benefit = benefitPersistence.findByPrimaryKey(benefitId);
			Date now = new Date();
			benefit.setBenefitId(benefitId);
			benefit.setActive(active);
			benefit.setModifiedDate(serviceContext.getModifiedDate(now));

			benefitPersistence.update(benefit);

		} catch (Exception e) {
			System.out.println(e);
		}

		return benefit;
	}
	
	
	public List<Benefit> getBenefitByPlan(String plan, long typeId) {
	    List<Benefit> list = null;

	    DynamicQuery query = dynamicQuery();
	    query.addOrder(OrderFactoryUtil.asc("sort"));
	    query.add(PropertyFactoryUtil.forName("active").ge(1));
	    query.add(PropertyFactoryUtil.forName("planName").eq(plan));
	    query.add(PropertyFactoryUtil.forName("benefitTypeId").eq(typeId));
	    
	    // Menjalankan query
	    list = dynamicQuery(query);
	    
	    return list;
	}

	public List<Benefit> getBenefitByTypeId(long typeId) {
	    List<Benefit> list = null;

	    DynamicQuery query = dynamicQuery();
	    query.addOrder(OrderFactoryUtil.asc("sort"));
	    query.add(PropertyFactoryUtil.forName("active").ge(1));
	    query.add(PropertyFactoryUtil.forName("benefitTypeId").eq(typeId));
	    
	    // Menjalankan query
	    list = dynamicQuery(query);
	    
	    return list;
	}
	
}