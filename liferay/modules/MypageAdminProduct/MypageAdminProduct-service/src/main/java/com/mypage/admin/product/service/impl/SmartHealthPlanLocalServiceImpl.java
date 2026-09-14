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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.admin.product.model.SmartHealthPlan;
import com.mypage.admin.product.service.base.SmartHealthPlanLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.SmartHealthPlan",
	service = AopService.class
)
public class SmartHealthPlanLocalServiceImpl
	extends SmartHealthPlanLocalServiceBaseImpl {
	
	/**
	 * Add Plan
	 */
	public SmartHealthPlan addSmartHealthPlan(String planName, String planGroup, int isRecommended, int active) throws PortalException {
		long smartHealthPlanId = counterLocalService.increment();
		SmartHealthPlan smartHealthPlan = smartHealthPlanPersistence.create(smartHealthPlanId);

		smartHealthPlan.setPlanName(planName);
		smartHealthPlan.setPlanGroup(planGroup);
		smartHealthPlan.setIsRecommended(isRecommended);
		smartHealthPlan.setActive(active);
		
		smartHealthPlanPersistence.update(smartHealthPlan);

		return smartHealthPlan;
	}
	
	/**
	 * Update Plan
	 */
	public SmartHealthPlan updateSmartHealthPlan(long smartHealthPlanId, String planName, String planGroup, int isRecommended, int active)
			throws PortalException {
		SmartHealthPlan smartHealthPlan = smartHealthPlanPersistence.findByPrimaryKey(smartHealthPlanId);

		smartHealthPlan.setSmartHealthPlanId(smartHealthPlanId);
		smartHealthPlan.setPlanName(planName);
		smartHealthPlan.setPlanGroup(planGroup);
		smartHealthPlan.setIsRecommended(isRecommended);
		smartHealthPlanPersistence.update(smartHealthPlan);

		return smartHealthPlan;
	}
	
	public SmartHealthPlan updateSmartHealthPlan(long smartHealthPlanId, int isRecommended) throws PortalException {
		SmartHealthPlan smartHealthPlan = smartHealthPlanPersistence.findByPrimaryKey(smartHealthPlanId);

		smartHealthPlan.setIsRecommended(isRecommended);

		smartHealthPlanPersistence.update(smartHealthPlan);

		return smartHealthPlan;
	}
	
	public void resetAllRecommendedStatus() throws PortalException {
		List<SmartHealthPlan> allPlans = smartHealthPlanPersistence.findAll();
		int recommended = 0;

		for (SmartHealthPlan plan : allPlans) {
			long currentId = plan.getSmartHealthPlanId();
			this.updateSmartHealthPlan(currentId, recommended);

		}
	}
	
	public List<SmartHealthPlan> getSmartHealthPlans() {
		return smartHealthPlanPersistence.findAll();
	}
	
	public int getSmartHealthPlansCount() {
		return smartHealthPlanPersistence.countAll();
	}
	
	public SmartHealthPlan setActive(long smartHealthPlanId, int active, ServiceContext serviceContext)
			throws PortalException {
		SmartHealthPlan smartHealthPlan = null;

		try {
			smartHealthPlan = smartHealthPlanPersistence.findByPrimaryKey(smartHealthPlanId);
			Date now = new Date();
			smartHealthPlan.setSmartHealthPlanId(smartHealthPlanId);
			smartHealthPlan.setActive(active);
			smartHealthPlan.setModifiedDate(serviceContext.getModifiedDate(now));

			smartHealthPlanPersistence.update(smartHealthPlan);
		} catch (Exception e) {
            log.debug(e.getMessage());
		}

		return smartHealthPlan;
	}

    private static final Log log = LogFactoryUtil.getLog(SmartHealthPlanLocalServiceImpl.class);
}