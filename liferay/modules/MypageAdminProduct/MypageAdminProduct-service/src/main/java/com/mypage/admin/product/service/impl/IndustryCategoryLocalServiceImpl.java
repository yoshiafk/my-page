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
import com.mypage.admin.product.model.IndustryCategory;
import com.mypage.admin.product.service.base.IndustryCategoryLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.IndustryCategory",
	service = AopService.class
)
public class IndustryCategoryLocalServiceImpl
	extends IndustryCategoryLocalServiceBaseImpl {
	public IndustryCategory addIndustryCategory(String name, int active) throws PortalException {
		long industryCategoryId = counterLocalService.increment();
		IndustryCategory industrycategory = industryCategoryPersistence.create(industryCategoryId);

		industrycategory.setName(name);
		industrycategory.setActive(active);

		industryCategoryPersistence.update(industrycategory);

		return industrycategory;
	}

	public IndustryCategory updateIndustryCategory(long industryCategoryId, String name, int active)
			throws PortalException {
		IndustryCategory industryCategory = industryCategoryPersistence.findByPrimaryKey(industryCategoryId);

		industryCategory.setIndustryCategoryId(industryCategoryId);
		industryCategory.setName(name);
		industryCategory.setActive(active);

		industryCategoryPersistence.update(industryCategory);

		return industryCategory;
	}

	public List<IndustryCategory> getIndustryCategories(int start, int end) {
		return industryCategoryPersistence.findAll(start, end);
	}

	public List<IndustryCategory> getActiveIndustryCategories() {
		List<IndustryCategory> entriesResult = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("name"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		entriesResult = dynamicQuery(query);

//		for(IndustryCategory item : entriesResult) {
//			System.out.println(item.getName());
//		}

//		return industryCategoryPersistence.findAll();
		return entriesResult;
	}

	public List<IndustryCategory> getIndustryCategories() {
		return industryCategoryPersistence.findAll();
	}

	public int getIndustryCategoryCount() {
		return industryCategoryPersistence.countAll();
	}

	public IndustryCategory setActive(long industryCategoryId, int active, ServiceContext serviceContext)
			throws PortalException {
		IndustryCategory industryCategory = null;

		try {
			industryCategory = industryCategoryPersistence.findByPrimaryKey(industryCategoryId);
			Date now = new Date();
			industryCategory.setIndustryCategoryId(industryCategoryId);
			industryCategory.setActive(active);
			industryCategory.setModifiedDate(serviceContext.getModifiedDate(now));

			industryCategoryPersistence.update(industryCategory);
		} catch (Exception e) {
			System.out.println(e);
		}

		return industryCategory;
	}	
}