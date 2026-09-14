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
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.admin.product.model.SmartActiveClassRate;
import com.mypage.admin.product.service.base.SmartActiveClassRateLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.SmartActiveClassRate",
	service = AopService.class
)
public class SmartActiveClassRateLocalServiceImpl extends SmartActiveClassRateLocalServiceBaseImpl {
	
	public SmartActiveClassRate addClassRate(String nameId, String nameEn, int active)throws PortalException {
		long classRateId = counterLocalService.increment();
		SmartActiveClassRate classRate = smartActiveClassRatePersistence.create(classRateId);
		
		classRate.setNameId(nameId);
		classRate.setNameEn(nameEn);
		classRate.setActive(active);
		
		smartActiveClassRatePersistence.update(classRate);
		
		return classRate;
	}
	
	public SmartActiveClassRate updateClassRate(long classRateId, String nameId, String nameEn, int active) throws PortalException{
		SmartActiveClassRate classRateUpdate = smartActiveClassRatePersistence.findByPrimaryKey(classRateId);
		
		classRateUpdate.setNameId(nameId);
		classRateUpdate.setNameEn(nameEn);
		classRateUpdate.setActive(active);
		
		smartActiveClassRatePersistence.update(classRateUpdate);
		
		return classRateUpdate;
	}
	
	public List<SmartActiveClassRate> getAllClassRates(){
		return smartActiveClassRatePersistence.findAll();
	}
	
	public List<SmartActiveClassRate> getClassRates(int start ,int end){
		return smartActiveClassRatePersistence.findAll(start, end);
	}
	
	public List<SmartActiveClassRate> getActiveClassRate(){
		List<SmartActiveClassRate> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("smartActiveClassRateId"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);
		
		return list;
	}
	
	public long getClassRateIdByNameId(String nameId) {
		DynamicQuery dynamicQuery = smartActiveClassRateLocalService.dynamicQuery();
		
		dynamicQuery.add(RestrictionsFactoryUtil.ilike("nameId", nameId));
		
	    List<SmartActiveClassRate> data = smartActiveClassRatePersistence.findWithDynamicQuery(dynamicQuery);
	    long classRateId = data.size() > 0 ? data.get(0).getSmartActiveClassRateId() : 0;
	    
	    return classRateId;
	}
	
	public List<SmartActiveClassRate> getClassRateByName(String nameId, String nameEn) {
	    List<SmartActiveClassRate> list = null;
	    
	    DynamicQuery query = dynamicQuery();
	    
	    Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
	    
	    disjunction.add(PropertyFactoryUtil.forName("nameId").eq(nameId));
	    disjunction.add(PropertyFactoryUtil.forName("nameEn").eq(nameEn));
	    
	    query.add(disjunction);
	    
	    query.add(PropertyFactoryUtil.forName("active").ge(1));
	    
	    list = dynamicQuery(query);
	    
	    return list;
	}
	
	public List<SmartActiveClassRate> getClassRateBySort(int sort) {
	    List<SmartActiveClassRate> list = null;
	    
	    DynamicQuery query = dynamicQuery();
	    query.add(PropertyFactoryUtil.forName("active").ge(1));
	    
	    //by sort
	    query.add(PropertyFactoryUtil.forName("sort").ne(sort));
	    
	    list = dynamicQuery(query);
	    
	    return list;
	}
	
	public List<SmartActiveClassRate> getClassRates() {
		return smartActiveClassRatePersistence.findAll();
	}
	
	public int getSmartActiveClassRateCount() {
		return smartActiveClassRatePersistence.countAll();
	}
	
	public SmartActiveClassRate setActive(long classRateId, int active, ServiceContext serviceContext) {
		SmartActiveClassRate classRate = null;
		
		try {
			classRate = smartActiveClassRatePersistence.findByPrimaryKey(classRateId);
			Date now = new Date();
			
			classRate.setActive(active);
			classRate.setModifiedDate(serviceContext.getModifiedDate(now));
			
			smartActiveClassRatePersistence.update(classRate);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return classRate;
	}
}