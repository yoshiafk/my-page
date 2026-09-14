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
import com.mypage.admin.product.exception.NoSuchSmartActiveToproException;
import com.mypage.admin.product.model.SmartActiveTopro;
import com.mypage.admin.product.service.base.SmartActiveToproLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.SmartActiveTopro",
	service = AopService.class
)
public class SmartActiveToproLocalServiceImpl extends SmartActiveToproLocalServiceBaseImpl {
	
	public SmartActiveTopro addTopro(String topro, String description, String annotations, long benefitValueId, String toc, int active) throws PortalException {
		long toproId = counterLocalService.increment();
		SmartActiveTopro toproPersistence = smartActiveToproPersistence.create(toproId);
		
		toproPersistence.setTopro(topro);
		toproPersistence.setDescription(description);
		toproPersistence.setAnnotations(annotations);
		toproPersistence.setSmartActiveBenefitValueId(benefitValueId);
		toproPersistence.setToc(toc);
		toproPersistence.setActive(active);
		
		smartActiveToproPersistence.update(toproPersistence);
		
		return toproPersistence;
	}
	
	public SmartActiveTopro updateTopro(long toproId, String topro, String description, String annotations, long benefitValueId, String toc, int active) throws PortalException{
		SmartActiveTopro toproPersistence = smartActiveToproPersistence.findByPrimaryKey(toproId);
		
		toproPersistence.setTopro(topro);
		toproPersistence.setDescription(description);
		toproPersistence.setAnnotations(annotations);
		toproPersistence.setSmartActiveBenefitValueId(benefitValueId);
		toproPersistence.setToc(toc);
		toproPersistence.setActive(active);
		
		smartActiveToproPersistence.update(toproPersistence);
		
		return toproPersistence;
	}
	
	public List<SmartActiveTopro> getTopros(int start, int end) {
		return smartActiveToproPersistence.findAll(start, end);
	}

	public List<SmartActiveTopro> getActiveTopro() {
		List<SmartActiveTopro> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("topro"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);

		return list;
	}

	public List<SmartActiveTopro> getTopros() {
		return smartActiveToproPersistence.findAll();
	}

	public int getToproCount() {
		return smartActiveToproPersistence.countAll();
	}
	
	public SmartActiveTopro getByTopro(String topro) {
		SmartActiveTopro data = null;

		try {
			data = smartActiveToproPersistence.findBytopro(topro);
		} catch (NoSuchSmartActiveToproException e) {
			System.out.println(e.getMessage());
		}

		return data;
	}

	public SmartActiveTopro setActive(long toproId, int active, ServiceContext serviceContext) throws PortalException {
		SmartActiveTopro topro = null;

		try {
			topro = smartActiveToproPersistence.findByPrimaryKey(toproId);
			Date now = new Date();
			topro.setActive(active);
			topro.setModifiedDate(serviceContext.getModifiedDate(now));

			smartActiveToproPersistence.update(topro);

		} catch (Exception e) {
			System.out.println(e);
		}

		return topro;
	}
	
	public SmartActiveTopro getToproByBenefitValue(long benefitValueId) {
		SmartActiveTopro data = null;

		try {
			data = smartActiveToproPersistence.findByBenefitValueId(benefitValueId);
		} catch (NoSuchSmartActiveToproException e) {
			System.out.println(e.getMessage());
		}

		return data;
	}
}