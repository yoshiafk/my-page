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
import com.mypage.admin.product.model.TravelIntBenefit;
import com.mypage.admin.product.service.base.TravelIntBenefitLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.TravelIntBenefit",
	service = AopService.class
)
public class TravelIntBenefitLocalServiceImpl
	extends TravelIntBenefitLocalServiceBaseImpl {
	
	/**
	 * Add
	 */
	public TravelIntBenefit addTravelIntBenefit(String benefitName, int active) throws PortalException {

		long travelIntBenefitId = counterLocalService.increment();
		TravelIntBenefit travelIntBenefit = travelIntBenefitPersistence.create(travelIntBenefitId);

		travelIntBenefit.setBenefitName(benefitName);
		travelIntBenefit.setActive(active);

		travelIntBenefitPersistence.update(travelIntBenefit);

		return travelIntBenefit;
	}

	public TravelIntBenefit updateTravelIntBenefit(long travelIntBenefitId, String benefitName, int active)
			throws PortalException {
		TravelIntBenefit travelIntBenefit = travelIntBenefitPersistence.fetchByPrimaryKey(travelIntBenefitId);

		travelIntBenefit.setTravelIntBenefitId(travelIntBenefitId);
		travelIntBenefit.setBenefitName(benefitName);
		travelIntBenefit.setActive(active);

		travelIntBenefitPersistence.update(travelIntBenefit);

		return travelIntBenefit;
	}

	public List<TravelIntBenefit> getTravelIntBenefits(int start, int end) {
		return travelIntBenefitPersistence.findAll(start, end);
	}

	public List<TravelIntBenefit> getTravelIntBenefits() {
		return travelIntBenefitPersistence.findAll();
	}

	public int getTravelIntBenefitCount() {
		return travelIntBenefitPersistence.countAll();
	}

	public TravelIntBenefit setActive(long userId, long travelIntBenefitId, int active, ServiceContext serviceContext)
			throws PortalException {
		TravelIntBenefit travelIntBenefit = null;

		try {
			travelIntBenefit = travelIntBenefitPersistence.findByPrimaryKey(travelIntBenefitId);
			Date now = new Date();
			travelIntBenefit.setTravelIntBenefitId(travelIntBenefitId);
			travelIntBenefit.setActive(active);
			travelIntBenefit.setModifiedDate(serviceContext.getModifiedDate(now));

			travelIntBenefitPersistence.update(travelIntBenefit);

		} catch (Exception e) {
            log.debug(e.getMessage());
		}

		return travelIntBenefit;
	}

    private static final Log log = LogFactoryUtil.getLog(TravelIntBenefitLocalServiceImpl.class);
}