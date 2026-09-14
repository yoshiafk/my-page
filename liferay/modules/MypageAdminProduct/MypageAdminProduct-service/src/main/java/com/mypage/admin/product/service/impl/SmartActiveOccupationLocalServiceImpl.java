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
import com.mypage.admin.product.exception.NoSuchSmartActiveOccupationException;
import com.mypage.admin.product.model.SmartActiveOccupation;
import com.mypage.admin.product.service.base.SmartActiveOccupationLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.SmartActiveOccupation",
	service = AopService.class
)
public class SmartActiveOccupationLocalServiceImpl extends SmartActiveOccupationLocalServiceBaseImpl {
	
	public SmartActiveOccupation addOccupation(String code, String nameId, String nameEn, long classRateId, int active) throws PortalException {
		long occupationId = counterLocalService.increment();
		SmartActiveOccupation occupation = smartActiveOccupationPersistence.create(occupationId);
		
		occupation.setCode(code);
		occupation.setNameId(nameId);
		occupation.setNameEn(nameEn);
		occupation.setActive(active);
		occupation.setSmartActiveClassRateId(classRateId);
		
		smartActiveOccupationPersistence.update(occupation);
		
		return occupation;
	}
	
	public SmartActiveOccupation updateOccupation(long occupationId, String code, String nameId, String nameEn, long classRateId, int active) throws PortalException{
		SmartActiveOccupation occupationUpdate = smartActiveOccupationPersistence.findByPrimaryKey(occupationId);
		
		occupationUpdate.setCode(code);
		occupationUpdate.setNameId(nameId);
		occupationUpdate.setNameEn(nameEn);
		occupationUpdate.setActive(active);
		occupationUpdate.setSmartActiveClassRateId(classRateId);
		
		smartActiveOccupationPersistence.update(occupationUpdate);
		
		return occupationUpdate;
	}
	
	public List<SmartActiveOccupation> getOccupations(int start, int end) {
		return smartActiveOccupationPersistence.findAll(start, end);
	}

	public List<SmartActiveOccupation> getActiveOccupation() {
		List<SmartActiveOccupation> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("smartActiveOccupationId"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);

		return list;
	}

	public List<SmartActiveOccupation> getOccupations() {
		return smartActiveOccupationPersistence.findAll();
	}

	public int getOccupationCount() {
		return smartActiveOccupationPersistence.countAll();
	}
	
	public SmartActiveOccupation getByCode(String code) {
		SmartActiveOccupation occupation = null;

		try {
			occupation = smartActiveOccupationPersistence.findBycode(code);
		} catch (NoSuchSmartActiveOccupationException e) {
			System.out.println(e.getMessage());
		}

		return occupation;
	}

	public SmartActiveOccupation setActive(long occupationId, int active, ServiceContext serviceContext) throws PortalException {
		SmartActiveOccupation occupation = null;

		try {
			occupation = smartActiveOccupationPersistence.findByPrimaryKey(occupationId);
			Date now = new Date();
			occupation.setActive(active);
			occupation.setModifiedDate(serviceContext.getModifiedDate(now));

			smartActiveOccupationPersistence.update(occupation);

		} catch (Exception e) {
			System.out.println(e);
		}

		return occupation;
	}

	public List<SmartActiveOccupation> getOccupationByClassRate(long typeId) {
	    List<SmartActiveOccupation> list = null;

	    DynamicQuery query = dynamicQuery();
	    query.addOrder(OrderFactoryUtil.asc("sort"));
	    query.add(PropertyFactoryUtil.forName("active").ge(1));
	    query.add(PropertyFactoryUtil.forName("smartActiveClassRateId").eq(typeId));
	    
	    // Menjalankan query
	    list = dynamicQuery(query);
	    
	    return list;
	}
}