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
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.admin.product.exception.NoSuchTravelDomesticBenefitException;
import com.mypage.admin.product.model.TravelDomesticBenefit;
import com.mypage.admin.product.service.base.TravelDomesticBenefitLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.TravelDomesticBenefit",
	service = AopService.class
)
public class TravelDomesticBenefitLocalServiceImpl
	extends TravelDomesticBenefitLocalServiceBaseImpl {

    public TravelDomesticBenefit addTravelDomesticBenefit(
			String plan, String amount, String benefit, long benefitValue,
			String group, int sort, int active) 
    {
		TravelDomesticBenefit travelDomesticBenefit;

		try {
			long id = counterLocalService.increment(TravelDomesticBenefit.class.toString());
			travelDomesticBenefit = travelDomesticBenefitPersistence.create(id);
        } catch (SystemException e) {
            e.printStackTrace();
            return travelDomesticBenefit = null;
        }
		
		travelDomesticBenefit.setPlan(plan);
		travelDomesticBenefit.setAmount(amount);
		travelDomesticBenefit.setBenefit(benefit);
		travelDomesticBenefit.setBenefitValue(benefitValue);
		travelDomesticBenefit.setGroup(group);
		travelDomesticBenefit.setSort(sort);
		travelDomesticBenefit.setActive(active);
		
		try {
			return travelDomesticBenefitPersistence.update(travelDomesticBenefit);
        } catch (SystemException e) {
            e.printStackTrace();

        }

		return travelDomesticBenefit;	
	}
	
	public TravelDomesticBenefit updateTravelDomesticBenefit(
			long travelDomesticBenefitId, String plan, String amount, String benefit, long benefitValue,
			String group, int sort, int active) 
	{
		TravelDomesticBenefit travelDomesticBenefit;

		try {
			travelDomesticBenefit = travelDomesticBenefitPersistence.findByPrimaryKey(travelDomesticBenefitId);
        } catch (SystemException | NoSuchModelException e) {
            e.printStackTrace();
            return travelDomesticBenefit = null;
        }
		
		travelDomesticBenefit.setPlan(plan);
		travelDomesticBenefit.setAmount(amount);
		travelDomesticBenefit.setBenefit(benefit);
		travelDomesticBenefit.setBenefitValue(benefitValue);
		travelDomesticBenefit.setGroup(group);
		travelDomesticBenefit.setSort(sort);
		travelDomesticBenefit.setActive(active);
		
		try {
			return travelDomesticBenefitPersistence.update(travelDomesticBenefit);
        } catch (SystemException e) {
            e.printStackTrace();
        }

		return travelDomesticBenefit;	
	}
	
	public TravelDomesticBenefit setActive(long travelDomesticBenefitId, int active, ServiceContext serviceContext) {
		TravelDomesticBenefit travelDomesticBenefit;
		
		try {
			travelDomesticBenefit = travelDomesticBenefitPersistence.findByPrimaryKey(travelDomesticBenefitId);
        } catch (SystemException | NoSuchTravelDomesticBenefitException e) {
            e.printStackTrace();
            return travelDomesticBenefit = null;
        }
		
		travelDomesticBenefit.setActive(active);
		
		try {
			return travelDomesticBenefitPersistence.update(travelDomesticBenefit);
        } catch (SystemException e) {
            e.printStackTrace();

        }
		
		return travelDomesticBenefit;
	}
	
	public List<TravelDomesticBenefit> searchByPlan(String plan) {
		return travelDomesticBenefitPersistence.findBysearchTravelDomesticBenefitPlan(plan);
	}
}