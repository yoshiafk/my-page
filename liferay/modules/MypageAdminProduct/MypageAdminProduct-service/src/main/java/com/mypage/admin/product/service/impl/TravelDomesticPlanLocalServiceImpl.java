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
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.admin.product.exception.NoSuchTravelDomesticPlanException;
import com.mypage.admin.product.model.TravelDomesticBenefit;
import com.mypage.admin.product.model.TravelDomesticPlan;
import com.mypage.admin.product.service.base.TravelDomesticPlanLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.TravelDomesticPlan",
	service = AopService.class
)
public class TravelDomesticPlanLocalServiceImpl
	extends TravelDomesticPlanLocalServiceBaseImpl {
	
	public TravelDomesticPlan addTravelDomesticPlan(
			String name, String code, int toproTsi, int toproAtsi, int sort, int active) 
    {
		TravelDomesticPlan travelDomesticPlan;

		try {
			long id = counterLocalService.increment(TravelDomesticBenefit.class.toString());
			travelDomesticPlan = travelDomesticPlanPersistence.create(id);
        } catch (SystemException e) {
            // TODO Auto-generated catch block
            log.debug(e.getMessage());
            return travelDomesticPlan = null;
        }
		
		travelDomesticPlan.setName(name);
		travelDomesticPlan.setCode(code);
		travelDomesticPlan.setToproTsi(toproTsi);
		travelDomesticPlan.setToproAtsi(toproAtsi);
		travelDomesticPlan.setSort(sort);
		travelDomesticPlan.setActive(active);
		
		try {
			return travelDomesticPlanPersistence.update(travelDomesticPlan);
        } catch (SystemException e) {
            log.debug(e.getMessage());

        }

		return travelDomesticPlan;	
	}
	
	public TravelDomesticPlan updateTravelDomesticPlan(
			long travelDomesticPlanId, String name, String code, int toproTsi, int toproAtsi, int sort, int active) 
	{
		TravelDomesticPlan travelDomesticPlan;

		try {
			travelDomesticPlan = travelDomesticPlanPersistence.findByPrimaryKey(travelDomesticPlanId);
        } catch (SystemException | NoSuchModelException e) {
            // TODO Auto-generated catch block
            log.debug(e.getMessage());
            return travelDomesticPlan = null;
        }
		
		travelDomesticPlan.setName(name);
		travelDomesticPlan.setCode(code);
		travelDomesticPlan.setToproTsi(toproTsi);
		travelDomesticPlan.setToproAtsi(toproAtsi);
		travelDomesticPlan.setSort(sort);
		travelDomesticPlan.setActive(active);
		
		try {
			return travelDomesticPlanPersistence.update(travelDomesticPlan);
        } catch (SystemException e) {
            log.debug(e.getMessage());
        }

		return travelDomesticPlan;	
	}
	
	public TravelDomesticPlan setActive(long travelDomesticPlanId, int active, ServiceContext serviceContext) {
		TravelDomesticPlan travelDomesticPlan;
		
		try {
			travelDomesticPlan = travelDomesticPlanPersistence.findByPrimaryKey(travelDomesticPlanId);
        } catch (SystemException | NoSuchTravelDomesticPlanException e) {
            // TODO Auto-generated catch block
            log.debug(e.getMessage());
            return travelDomesticPlan = null;
        }
		
		travelDomesticPlan.setActive(active);
		
		try {
			return travelDomesticPlanPersistence.update(travelDomesticPlan);
        } catch (SystemException e) {
            log.debug(e.getMessage());

        }
		
		return travelDomesticPlan;
	}
	
	public List<TravelDomesticPlan> searchByCode(String code) {
		return travelDomesticPlanPersistence.findBysearchByCode(code);
	}
	
	public TravelDomesticPlan findByCode(String code) {
		TravelDomesticPlan travelDomesticPlan = null;
		try {
			travelDomesticPlan = travelDomesticPlanPersistence.findByCode(code);
		} catch (Exception e) {
            log.debug(e.getMessage());
		}
		return travelDomesticPlan; 
	}

    private static final Log log = LogFactoryUtil.getLog(TravelDomesticPlanLocalServiceImpl.class);
}