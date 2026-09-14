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
import com.mypage.admin.product.model.SmartHealthBenefit;
import com.mypage.admin.product.service.base.SmartHealthBenefitLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(property = "model.class.name=com.mypage.admin.product.model.SmartHealthBenefit", service = AopService.class)
public class SmartHealthBenefitLocalServiceImpl extends SmartHealthBenefitLocalServiceBaseImpl {

	/**
	 * Add Benefit
	 */
	public SmartHealthBenefit addSmartHealthBenefit(String benefitTitle, String benefitContent,
			long smartHealthBenefitGroupId, long smartHealthPlanId, int active) throws PortalException {
		long smartHealthBenefitId = counterLocalService.increment();
		SmartHealthBenefit smartHealthBenefit = smartHealthBenefitPersistence.create(smartHealthBenefitId);

		smartHealthBenefit.setBenefitTitle(benefitTitle);
		smartHealthBenefit.setBenefitContent(benefitContent);
		smartHealthBenefit.setSmartHealthBenefitGroupId(smartHealthBenefitGroupId);
		smartHealthBenefit.setSmartHealthPlanId(smartHealthPlanId);
		smartHealthBenefit.setActive(active);

		smartHealthBenefitPersistence.update(smartHealthBenefit);

		return smartHealthBenefit;
	}

	/**
	 * Update Benefit
	 */
	public SmartHealthBenefit updateSmartHealthBenefit(long smartHealthBenefitId, String benefitTitle,
			String benefitContent, long smartHealthBenefitGroupId, long smartHealthPlanId, int active)
			throws PortalException {
		SmartHealthBenefit smartHealthBenefit = smartHealthBenefitPersistence.findByPrimaryKey(smartHealthBenefitId);

		smartHealthBenefit.setSmartHealthBenefitId(smartHealthBenefitId);
		smartHealthBenefit.setBenefitTitle(benefitTitle);
		smartHealthBenefit.setBenefitContent(benefitContent);
		smartHealthBenefit.setSmartHealthBenefitGroupId(smartHealthBenefitGroupId);
		smartHealthBenefit.setSmartHealthPlanId(smartHealthPlanId);
		smartHealthBenefit.setActive(active);

		smartHealthBenefitPersistence.update(smartHealthBenefit);

		return smartHealthBenefit;
	}

	public List<SmartHealthBenefit> getSmartHealthBenefits() {
		return smartHealthBenefitPersistence.findAll();
	}

	public int getSmartHealthBenefitCounts() {
		return smartHealthBenefitPersistence.countAll();
	}

	public SmartHealthBenefit setActive(long smartHealthBenefitId, int active, ServiceContext serviceContext)
			throws PortalException {
		SmartHealthBenefit smartHealthBenefit = null;

		try {
			smartHealthBenefit = smartHealthBenefitPersistence.findByPrimaryKey(smartHealthBenefitId);
			Date now = new Date();
			smartHealthBenefit.setSmartHealthBenefitId(smartHealthBenefitId);
			smartHealthBenefit.setActive(active);
			smartHealthBenefit.setModifiedDate(serviceContext.getModifiedDate(now));

			smartHealthBenefitPersistence.update(smartHealthBenefit);
		} catch (Exception e) {
            log.debug(e.getMessage());
		}

		return smartHealthBenefit;
	}

    private static final Log log = LogFactoryUtil.getLog(SmartHealthBenefitLocalServiceImpl.class);
}