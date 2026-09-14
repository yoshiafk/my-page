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
import com.mypage.admin.product.exception.NoSuchSmartActivePremiException;
import com.mypage.admin.product.model.SmartActivePremi;
import com.mypage.admin.product.service.base.SmartActivePremiLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.SmartActivePremi",
	service = AopService.class
)
public class SmartActivePremiLocalServiceImpl extends SmartActivePremiLocalServiceBaseImpl {
	
	public SmartActivePremi addPremi(double rate, int active, long benefitId, long classRateId) throws PortalException{
		long premiId = counterLocalService.increment();
		
		SmartActivePremi premi = smartActivePremiPersistence.create(premiId);
		
		premi.setRate(rate);
		premi.setSmartActiveBenefitId(benefitId);
		premi.setSmartActiveClassRateId(classRateId);
		premi.setActive(active);
		
		smartActivePremiPersistence.update(premi);
		
		return premi;
	}
	
	public SmartActivePremi updatePremi(long premiId, double rate, long benefitId, long classRateId, int active) throws PortalException{
		SmartActivePremi premiUpdate =  smartActivePremiPersistence.findByPrimaryKey(premiId);
		
		premiUpdate.setRate(rate);
		premiUpdate.setSmartActiveBenefitId(benefitId);
		premiUpdate.setSmartActiveClassRateId(classRateId);
		premiUpdate.setActive(active);
		
		smartActivePremiPersistence.update(premiUpdate);
		
		return premiUpdate;
	}
	
	public SmartActivePremi getPremiByBenefitAndClassRate(long smartActiveBenefitId, long smartActiveClassRateId) {
		SmartActivePremi premi = null;
		try {
			premi = smartActivePremiPersistence.findByBenefitIdAndClassId(smartActiveBenefitId, smartActiveClassRateId);
		} catch (NoSuchSmartActivePremiException e) {
			e.printStackTrace();
		}
		
		return premi;
	}
	
	public List<SmartActivePremi> getPremis(int start, int end){
		return smartActivePremiPersistence.findAll(start, end);
	}
	
	public List<SmartActivePremi> getActivePremi(){
		List<SmartActivePremi> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("smartActivePremiId"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);
		
		return list;
	}
	
	public List<SmartActivePremi> getPremis(){
		return smartActivePremiPersistence.findAll();
	}
	
	public int getPremiCount() {
		return smartActivePremiPersistence.countAll();
	}
	
	public SmartActivePremi setActive(long premiId, int active, ServiceContext serviceContext) {
		SmartActivePremi premi = null;
		
		try {
			premi = smartActivePremiPersistence.findByPrimaryKey(premiId);
			Date date = new Date();
			
			premi.setActive(active);
			premi.setModifiedDate(serviceContext.getModifiedDate(date));
			
			smartActivePremiPersistence.update(premi);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return premi;
	}
}