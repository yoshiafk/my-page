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
import com.mypage.admin.product.model.Plan;
import com.mypage.admin.product.service.base.PlanLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
		property = "model.class.name=com.mypage.admin.product.model.Plan", 
		service = AopService.class
)
public class PlanLocalServiceImpl extends PlanLocalServiceBaseImpl {

	public Plan addPlan(String nameId, String nameEn, int sort, int active) throws PortalException {
		long planId = counterLocalService.increment();
		Plan plan = planPersistence.create(planId);

		plan.setNameId(nameId);
		plan.setNameEn(nameEn);
		plan.setSort(sort);
		plan.setActive(active);

		planPersistence.update(plan);
		return plan;
	}
	
	public Plan updatePlan(long planId, String nameId, String nameEn,int sort, int active) throws PortalException{
		
		Plan planUpdate = planPersistence.findByPrimaryKey(planId);
		
		planUpdate.setNameId(nameId);
		planUpdate.setNameEn(nameEn);
		planUpdate.setSort(sort);
		planUpdate.setActive(active);
		
		planPersistence.update(planUpdate);
		return planUpdate;
	}
	
	public List<Plan> getPlans(int start, int end){
		return planPersistence.findAll(start, end);
	}
	
	public List<Plan> getActivePlan(){
		List<Plan> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("sort"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);
		
		return list;
	}
	
	public List<Plan> getPlans(){
		return planPersistence.findAll();
	}
	
	public int getPlanCount() {
		return planPersistence.countAll();
	}
	
	public Plan setActive(long planId, int active, ServiceContext serviceContext) {
		Plan plan = null;
		
		try {
			plan = planPersistence.findByPrimaryKey(planId);
			Date now  = new Date();
			plan.setPlanId(planId);
			plan.setActive(active);
			plan.setModifiedDate(serviceContext.getModifiedDate(now));
			
			planPersistence.update(plan);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return plan;
		
	}
	
}