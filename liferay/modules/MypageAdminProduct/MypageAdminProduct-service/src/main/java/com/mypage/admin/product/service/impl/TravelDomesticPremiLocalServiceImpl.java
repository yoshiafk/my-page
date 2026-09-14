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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.admin.product.exception.NoSuchTravelDomesticPremiException;
import com.mypage.admin.product.model.TravelDomesticPremi;
import com.mypage.admin.product.service.base.TravelDomesticPremiLocalServiceBaseImpl;
import com.mypage.admin.product.service.persistence.TravelDomesticPremiFinder;
import com.mypage.admin.product.service.persistence.TravelDomesticPremiUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.TravelDomesticPremi",
	service = AopService.class
)
public class TravelDomesticPremiLocalServiceImpl
	extends TravelDomesticPremiLocalServiceBaseImpl {
	
	public TravelDomesticPremi addTravelDomesticPremi(
			String plan, String insuredType, String currency, Long amount, int duration, int active) 
	{
		TravelDomesticPremi travelDomesticPremi;
		
		try {
			long id = counterLocalService.increment(TravelDomesticPremi.class.toString());
			travelDomesticPremi = travelDomesticPremiPersistence.create(id);
        } catch (SystemException e) {
            e.printStackTrace();
            return travelDomesticPremi = null;
        }
		
		travelDomesticPremi.setPlan(plan);
		travelDomesticPremi.setInsuredType(insuredType);
		travelDomesticPremi.setCurrency(currency);
		travelDomesticPremi.setAmount(amount);
		travelDomesticPremi.setDuration(duration);
		travelDomesticPremi.setActive(active);
		
		try {
			return travelDomesticPremiPersistence.update(travelDomesticPremi);
        } catch (SystemException e) {
            e.printStackTrace();

        }

		return travelDomesticPremi;
		
	}
	
	public TravelDomesticPremi updateTravelDomesticPremi(
			long travelDomesticPremiId, String plan, String insuredType, String currency, Long amount, int duration, int active) 
	{
		TravelDomesticPremi travelDomesticPremi;
		
		try {
			travelDomesticPremi = travelDomesticPremiPersistence.findByPrimaryKey(travelDomesticPremiId);
        } catch (SystemException | NoSuchTravelDomesticPremiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return travelDomesticPremi = null;
        }
		
		travelDomesticPremi.setPlan(plan);
		travelDomesticPremi.setInsuredType(insuredType);
		travelDomesticPremi.setCurrency(currency);
		travelDomesticPremi.setAmount(amount);
		travelDomesticPremi.setDuration(duration);
		travelDomesticPremi.setActive(active);
		
		try {
			return travelDomesticPremiPersistence.update(travelDomesticPremi);
        } catch (SystemException e) {
            e.printStackTrace();

        }

		return travelDomesticPremi;
		
	}
	
	public TravelDomesticPremi setActive(long travelDomesticPremiId, int active, ServiceContext serviceContext) {
		TravelDomesticPremi travelDomesticPremi;
		
		try {
			travelDomesticPremi = travelDomesticPremiPersistence.findByPrimaryKey(travelDomesticPremiId);
        } catch (SystemException | NoSuchTravelDomesticPremiException e) {
            e.printStackTrace();
            return travelDomesticPremi = null;
        }
		
		travelDomesticPremi.setActive(active);
		
		try {
			return travelDomesticPremiPersistence.update(travelDomesticPremi);
        } catch (SystemException e) {
            e.printStackTrace();

        }
		
		return travelDomesticPremi;
	}
	
	public List getPremis(int start, int end) {
		return _travelDomesticPremiFinder.getTravelDomesticPremis(start, end);
	}
	
	public List<TravelDomesticPremi> searchPremi(int duration, String plan, String insuredType) {
		return TravelDomesticPremiUtil.findBysearchPremi(duration, plan, insuredType);
	}
	
	@Reference
	TravelDomesticPremiFinder _travelDomesticPremiFinder;	
}