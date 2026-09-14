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
import com.mypage.admin.product.model.PersonalAccidentPremi;
import com.mypage.admin.product.service.base.PersonalAccidentPremiLocalServiceBaseImpl;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.PersonalAccidentPremi",
	service = AopService.class
)
public class PersonalAccidentPremiLocalServiceImpl
	extends PersonalAccidentPremiLocalServiceBaseImpl {
	
	/**
	 * Add Premi
	 */
	public PersonalAccidentPremi addPersonalAccidentPremi(String type, double amount, int active) throws PortalException {
		long personalAccidentPremiId = counterLocalService.increment();
		PersonalAccidentPremi personalAccidentPremi = personalAccidentPremiPersistence.create(personalAccidentPremiId);
		
		personalAccidentPremi.setPremiType(type);
		personalAccidentPremi.setAmount(amount);
		personalAccidentPremi.setActive(active);
		
		personalAccidentPremiPersistence.update(personalAccidentPremi);

		return personalAccidentPremi;
	}
	
	/**
	 * Update Premi
	 */
	public PersonalAccidentPremi updatePersonalAccidentPremi(long personalAccidentPremiId, String type, double amount, int active) throws PortalException {
		PersonalAccidentPremi personalAccidentPremi = personalAccidentPremiPersistence.findByPrimaryKey(personalAccidentPremiId);

		personalAccidentPremi.setPremiType(type);
		personalAccidentPremi.setAmount(amount);
		personalAccidentPremi.setActive(active);

		personalAccidentPremiPersistence.update(personalAccidentPremi);

		return personalAccidentPremi;
	}

	public int getPersonalAccidentPremiCount() {
		return personalAccidentPremiPersistence.countAll();
	}

	public PersonalAccidentPremi setActive(long personalAccidentPremiId, int active, ServiceContext serviceContext)
			throws PortalException {
		PersonalAccidentPremi personalAccidentPremi = null;

		try {
			personalAccidentPremi = personalAccidentPremiPersistence.findByPrimaryKey(personalAccidentPremiId);
			Date now = new Date();
			
			personalAccidentPremi.setActive(active);
			personalAccidentPremi.setModifiedDate(serviceContext.getModifiedDate(now));

			personalAccidentPremiPersistence.update(personalAccidentPremi);
		} catch (Exception e) {
            log.debug(e.getMessage());
		}

		return personalAccidentPremi;
	}

    private static final Log log = LogFactoryUtil.getLog(PersonalAccidentPremiLocalServiceImpl.class);
}