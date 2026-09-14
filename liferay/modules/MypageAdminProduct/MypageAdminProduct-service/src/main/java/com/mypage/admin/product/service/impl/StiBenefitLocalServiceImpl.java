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
import com.mypage.admin.product.model.StiBenefit;
import com.mypage.admin.product.service.base.StiBenefitLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(property = "model.class.name=com.mypage.admin.product.model.StiBenefit", service = AopService.class)
public class StiBenefitLocalServiceImpl extends StiBenefitLocalServiceBaseImpl {
	public List<StiBenefit> getBenefits(int start, int end) {
		return stiBenefitPersistence.findAll(start, end);
	}

	public List<StiBenefit> getActiveBenefit() {
		List<StiBenefit> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("sort"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);

		return list;
	}

	public List<StiBenefit> getBenefits() {
		return stiBenefitPersistence.findAll();
	}

	public int getBenefitCount() {
		return stiBenefitPersistence.countAll();
	}

	public StiBenefit setActive(long benefitId, int active, ServiceContext serviceContext) throws PortalException {
		StiBenefit benefit = null;

		try {
			benefit = stiBenefitPersistence.findByPrimaryKey(benefitId);
			Date now = new Date();
			benefit.setBenefitId(benefitId);
			benefit.setActive(active);
			benefit.setModifiedDate(serviceContext.getModifiedDate(now));

			stiBenefitPersistence.update(benefit);

		} catch (Exception e) {
			System.out.println(e);
		}

		return benefit;
	}

	public List<StiBenefit> getBenefitByPlan(String plan, long typeId) {
		List<StiBenefit> list = null;

		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("sort"));
		query.add(PropertyFactoryUtil.forName("active").ge(1));
		query.add(PropertyFactoryUtil.forName("planName").eq(plan));
		query.add(PropertyFactoryUtil.forName("benefitTypeId").eq(typeId));

		// Menjalankan query
		list = dynamicQuery(query);

		return list;
	}

	public List<StiBenefit> getBenefitByTypeId(long typeId) {
		List<StiBenefit> list = null;

		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("sort"));
		query.add(PropertyFactoryUtil.forName("active").ge(1));
		query.add(PropertyFactoryUtil.forName("benefitTypeId").eq(typeId));

		// Menjalankan query
		list = dynamicQuery(query);

		return list;
	}

}