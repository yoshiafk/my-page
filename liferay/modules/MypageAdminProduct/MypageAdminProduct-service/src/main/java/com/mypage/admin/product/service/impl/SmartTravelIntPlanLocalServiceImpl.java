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
import com.mypage.admin.product.model.SmartTravelIntPlan;
import com.mypage.admin.product.service.base.SmartTravelIntPlanLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.SmartTravelIntPlan",
	service = AopService.class
)
public class SmartTravelIntPlanLocalServiceImpl
	extends SmartTravelIntPlanLocalServiceBaseImpl {
	
	public SmartTravelIntPlan addPlan(String nameId, String nameEn, int sort, int active) throws PortalException {
		long planId = counterLocalService.increment();
		SmartTravelIntPlan plan = smartTravelIntPlanPersistence.create(planId);

		plan.setNameId(nameId);
		plan.setNameEn(nameEn);
		plan.setSort(sort);
		plan.setActive(active);

		smartTravelIntPlanPersistence.update(plan);
		return plan;
	}
	
	public SmartTravelIntPlan updatePlan(long planId, String nameId, String nameEn,int sort, int active) throws PortalException{
		
		SmartTravelIntPlan planUpdate = smartTravelIntPlanPersistence.findByPrimaryKey(planId);
		
		planUpdate.setNameId(nameId);
		planUpdate.setNameEn(nameEn);
		planUpdate.setSort(sort);
		planUpdate.setActive(active);
		
		smartTravelIntPlanPersistence.update(planUpdate);
		return planUpdate;
	}
	
	public List<SmartTravelIntPlan> getPlans(int start, int end){
		return smartTravelIntPlanPersistence.findAll(start, end);
	}
	
	public List<SmartTravelIntPlan> getActivePlan(){
		List<SmartTravelIntPlan> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("sort"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);
		
		return list;
	}
	
	public List<SmartTravelIntPlan> getPlans(){
		return smartTravelIntPlanPersistence.findAll();
	}
	
	public int getPlanCount() {
		return smartTravelIntPlanPersistence.countAll();
	}
	
	public SmartTravelIntPlan setActive(long planId, int active, ServiceContext serviceContext) {
		SmartTravelIntPlan plan = null;
		
		try {
			plan = smartTravelIntPlanPersistence.findByPrimaryKey(planId);
			Date now  = new Date();
			plan.setSmartTravelIntPlanId(planId);
			plan.setActive(active);
			plan.setModifiedDate(serviceContext.getModifiedDate(now));
			
			smartTravelIntPlanPersistence.update(plan);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return plan;
		
	}
}