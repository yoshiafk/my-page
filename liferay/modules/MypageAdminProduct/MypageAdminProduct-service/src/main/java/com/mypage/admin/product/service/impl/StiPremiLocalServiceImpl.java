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
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.admin.product.model.StiPremi;
import com.mypage.admin.product.service.base.StiPremiLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.StiPremi",
	service = AopService.class
)
public class StiPremiLocalServiceImpl extends StiPremiLocalServiceBaseImpl {
	
	public List<StiPremi> getPremis(int start, int end){
		return stiPremiPersistence.findAll(start, end);
	}
	
	public List<StiPremi> getActivePremi(){
		List<StiPremi> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("sort"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);
		
		return list;
	}
	
	public List<StiPremi> getPremis(){
		return stiPremiPersistence.findAll();
	}
	
	public int getPremiCount() {
		return stiPremiPersistence.countAll();
	}
	
	public StiPremi setActive(long premiId, int active, ServiceContext serviceContext) {
		StiPremi premi = null;
		
		try {
			premi = stiPremiPersistence.findByPrimaryKey(premiId);
			Date date = new Date();
			
			premi.setPremiId(premiId);
			premi.setActive(active);
			premi.setModifiedDate(serviceContext.getModifiedDate(date));
			
			stiPremiPersistence.update(premi);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return premi;
	}
	
	public List<StiPremi> findByCurrencyAndTravellerType(String currency, String travellerType) {
		List<StiPremi> premis = null;
		try {
			premis = stiPremiPersistence.findByCurrencyAndTravellerType(currency, travellerType);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return premis;
	}
}