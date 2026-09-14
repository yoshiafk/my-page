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
import com.mypage.admin.product.exception.NoSuchPremiException;
import com.mypage.admin.product.model.Premi;
import com.mypage.admin.product.service.base.PremiLocalServiceBaseImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.Premi",
	service = AopService.class
)
public class PremiLocalServiceImpl extends PremiLocalServiceBaseImpl {
	
	public Premi addPremi(String travellerType, String currency, BigDecimal basic, BigDecimal additional, BigDecimal annual, int active, long benefitId, long planId) throws PortalException{
		long premiId = counterLocalService.increment();
		
		Premi premi = premiPersistence.create(premiId);
		
		
		premi.setTravellerType(travellerType);
		premi.setCurrency(currency);
		premi.setBasic(basic);
		premi.setAdditional(additional);
		premi.setAnnual(annual);
		premi.setBenefitId(benefitId);
		premi.setPlanId(planId);
		premi.setActive(active);
		
		premiPersistence.update(premi);
		return premi;
	}
	
	public Premi updatePremi(long premiId, long benefitId, long planId, String travellerType, String currency, BigDecimal basic, BigDecimal additional, BigDecimal annual, int active) throws PortalException{
		Premi premiUpdate =  premiPersistence.findByPrimaryKey(premiId);
		
		premiUpdate.setBenefitId(benefitId);
		premiUpdate.setPlanId(planId);
		premiUpdate.setTravellerType(travellerType);
		premiUpdate.setCurrency(currency);
		premiUpdate.setBasic(basic);
		premiUpdate.setAdditional(additional);
		premiUpdate.setAnnual(annual);
		premiUpdate.setActive(active);
		
		premiPersistence.update(premiUpdate);
		
		return premiUpdate;
	}
	
	public List<Premi> getPremis(int start, int end){
		return premiPersistence.findAll(start, end);
	}
	
	public List<Premi> getActivePremi(){
		List<Premi> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("sort"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);
		
		return list;
	}
	
	public List<Premi> getPremis(){
		return premiPersistence.findAll();
	}
	
	public int getPremiCount() {
		return premiPersistence.countAll();
	}
	
	public Premi setActive(long premiId, int active, ServiceContext serviceContext) {
		Premi premi = null;
		
		try {
			premi = premiPersistence.findByPrimaryKey(premiId);
			Date date = new Date();
			
			premi.setPremiId(premiId);
			premi.setActive(active);
			premi.setModifiedDate(serviceContext.getModifiedDate(date));
			
			premiPersistence.update(premi);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return premi;
	}
	
	public List<Premi> findByCurrencyAndTravellerType(String currency, String travellerType) {
		List<Premi> premis = null;
		try {
			premis = premiPersistence.findByCurrencyAndTravellerType(currency, travellerType);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return premis;
	}
	
}