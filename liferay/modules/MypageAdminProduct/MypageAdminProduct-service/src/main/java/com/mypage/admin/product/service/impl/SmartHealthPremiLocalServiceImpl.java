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
import com.mypage.admin.product.model.SmartHealthPremi;
import com.mypage.admin.product.service.base.SmartHealthPremiLocalServiceBaseImpl;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.SmartHealthPremi",
	service = AopService.class
)
public class SmartHealthPremiLocalServiceImpl
	extends SmartHealthPremiLocalServiceBaseImpl {
	
	/**
	 * Add Premi
	 */
	public SmartHealthPremi addSmartHealthPremi(int age, String gender, String currency, double amount, long planId, int status) throws PortalException {
		long smartHealthPremiId = counterLocalService.increment();
		SmartHealthPremi smartHealthPremi = smartHealthPremiPersistence.create(smartHealthPremiId);
		
		smartHealthPremi.setAge(age);
		smartHealthPremi.setGender(gender);
		smartHealthPremi.setCurrency(currency);
		smartHealthPremi.setAmount(amount);
		smartHealthPremi.setPlanId(planId);
		smartHealthPremi.setStatus(status);
		
		smartHealthPremiPersistence.update(smartHealthPremi);

		return smartHealthPremi;
	}
	
	/**
	 * Update Premi
	 */
	public SmartHealthPremi updateSmartHealthPremi(long smartHealthPremiId, int age, String gender, String currency,
			double amount, long planId, int status) throws PortalException {
		SmartHealthPremi smartHealthPremi = smartHealthPremiPersistence.findByPrimaryKey(smartHealthPremiId);

		smartHealthPremi.setSmartHealthPremiId(smartHealthPremiId);
		smartHealthPremi.setAge(age);
		smartHealthPremi.setGender(gender);
		smartHealthPremi.setCurrency(currency);
		smartHealthPremi.setAmount(amount);
		smartHealthPremi.setPlanId(planId);
		smartHealthPremi.setStatus(status);

		smartHealthPremiPersistence.update(smartHealthPremi);

		return smartHealthPremi;
	}

	public int getSmartHealthPremiCount() {
		return smartHealthPremiPersistence.countAll();
	}

	public SmartHealthPremi setActive(long smartHealthPremiId, int status, ServiceContext serviceContext)
			throws PortalException {
		SmartHealthPremi smartHealthPremi = null;

		try {
			smartHealthPremi = smartHealthPremiPersistence.findByPrimaryKey(smartHealthPremiId);
			Date now = new Date();
			smartHealthPremi.setSmartHealthPremiId(smartHealthPremiId);
			smartHealthPremi.setStatus(status);
			smartHealthPremi.setModifiedDate(serviceContext.getModifiedDate(now));

			smartHealthPremiPersistence.update(smartHealthPremi);
		} catch (Exception e) {
            log.debug(e.getMessage());
		}

		return smartHealthPremi;
	}

    private static final Log log = LogFactoryUtil.getLog(SmartHealthPremiLocalServiceImpl.class);
}