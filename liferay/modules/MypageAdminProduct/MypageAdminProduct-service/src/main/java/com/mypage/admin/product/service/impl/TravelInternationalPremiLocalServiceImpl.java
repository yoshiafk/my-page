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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.admin.product.model.TravelInternationalPremi;
import com.mypage.admin.product.service.base.TravelInternationalPremiLocalServiceBaseImpl;
import com.mypage.admin.product.service.persistence.TravelInternationalPremiPersistence;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.TravelInternationalPremi",
	service = AopService.class
)
public class TravelInternationalPremiLocalServiceImpl
	extends TravelInternationalPremiLocalServiceBaseImpl {
	
	public TravelInternationalPremi addPremi(long userId, long premiId, String packageType, String peopleType,
			int adultCount, int childrenCount, String currency, BigDecimal amount, int minDuration, int maxDuration, int active,
			ServiceContext serviceContext) throws PortalException {
		TravelInternationalPremi premi = null;
		
		try {
			if (premiId == 0) {
				premiId = counterLocalService.increment();
				premi = travelInternationalPremiPersistence.create(premiId);
			} else {
				premi = travelInternationalPremiPersistence.findByPrimaryKey(premiId);
			}

			long groupId = serviceContext.getScopeGroupId();
			User user = userLocalService.getUserById(userId);
			Date now = new Date();

			premi.setPremiId(premiId);
			premi.setPackageType(packageType);
			premi.setPeopleType(peopleType);
			premi.setAdultCount(adultCount);
			premi.setChildrenCount(childrenCount);
			premi.setCurrency(currency);
			premi.setAmount(amount);
			premi.setMinDuration(minDuration);
			premi.setMaxDuration(maxDuration);
			premi.setActive(active);

//			premi.setUuid(serviceContext.getUuid());
			premi.setUserId(userId);
			premi.setGroupId(groupId);
			premi.setCompanyId(user.getCompanyId());
			premi.setUserName(user.getFullName());
			premi.setCreateDate(serviceContext.getCreateDate(now));
			premi.setModifiedDate(serviceContext.getModifiedDate(now));
			premi.setExpandoBridgeAttributes(serviceContext);

			travelInternationalPremiPersistence.update(premi);
			
		} catch (Exception e) {
			// TODO: handle exception
            log.debug(e.getMessage());
		}
		
		return premi;
	}

	public TravelInternationalPremi setActive(long userId, long premiId, int active, ServiceContext serviceContext) throws PortalException {
		TravelInternationalPremi premi = null;
		
		try {
			premi = travelInternationalPremiPersistence.findByPrimaryKey(premiId);
			Date now = new Date();
			premi.setPremiId(premiId);
			premi.setActive(active);
			premi.setModifiedDate(serviceContext.getModifiedDate(now));

			travelInternationalPremiPersistence.update(premi);
			
		} catch (Exception e) {
            log.debug(e.getMessage());
		}
		
		return premi;	
	}
	
	public List<TravelInternationalPremi> searchPremi(String packageType, String peopleType, String currency, int adultCount, int childrenCount, int minDuration, int maxDuration) {
		List<TravelInternationalPremi> premi = _travelInternationalPremiPersistence.findBygetActivePackage(packageType, peopleType, currency.toLowerCase(), adultCount, childrenCount, minDuration, maxDuration);
		return premi;
	}
	
	public int getPremiCounts() {
		return travelInternationalPremiPersistence.countAll();
	}

    private static final Log log = LogFactoryUtil.getLog(TravelInternationalPremiLocalServiceImpl.class);
	
	@Reference 
	TravelInternationalPremiPersistence _travelInternationalPremiPersistence;	
}