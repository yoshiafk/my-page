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
import com.mypage.admin.product.model.PetPlan;
import com.mypage.admin.product.service.base.PetPlanLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.PetPlan",
	service = AopService.class
)
public class PetPlanLocalServiceImpl extends PetPlanLocalServiceBaseImpl {
	/**
	 * Add new pet plan
	 * 
	 * @param name
	 * @param limitDisability
	 * @param limitMedical
	 * @param limitThirdParty
	 * @param limitCustody
	 * @param benefit
	 * @param recommended
	 * @param customPlan
	 * @return
	 * @throws PortalException
	 */
	public PetPlan addPetPlan(String name, long limitDisability, long limitMedical, long limitThirdParty,
			long limitCustody, String benefit, long pimcorePlanId, int recommended, int customPlan, int active) throws PortalException {

		long petPlanId = counterLocalService.increment();
		PetPlan petplan = petPlanPersistence.create(petPlanId);

		petplan.setName(name.toUpperCase());
		petplan.setLimitDisability(limitDisability);
		petplan.setLimitMedical(limitMedical);
		petplan.setLimitThirdParty(limitThirdParty);
		petplan.setLimitCustody(limitCustody);
		petplan.setPimcorePlanId(pimcorePlanId);
		petplan.setBenefit(benefit);
		petplan.setRecommended(recommended);
		petplan.setCustomPlan(customPlan);
		petplan.setActive(active);

		petPlanPersistence.update(petplan);

		return petplan;
	}

	/**
	 * Edit existing pet plan
	 * 
	 * @param petPlanId
	 * @param name
	 * @param limitDisability
	 * @param limitMedical
	 * @param limitThirdParty
	 * @param limitCustody
	 * @param benefit
	 * @param recommended
	 * @param customPlan
	 * @return
	 * @throws PortalException
	 */
	public PetPlan updatePetPlan(long petPlanId, String name, long limitDisability, long limitMedical,
			long limitThirdParty, long limitCustody, String benefit, long pimcorePlanId, int recommended, int customPlan, int active)
			throws PortalException {
		PetPlan petplan = petPlanPersistence.findByPrimaryKey(petPlanId);

		petplan.setPetPlanId(petPlanId);
		petplan.setName(name.toUpperCase());
		petplan.setLimitDisability(limitDisability);
		petplan.setLimitMedical(limitMedical);
		petplan.setLimitThirdParty(limitThirdParty);
		petplan.setLimitCustody(limitCustody);
		petplan.setBenefit(benefit);
		petplan.setPimcorePlanId(pimcorePlanId);
		petplan.setRecommended(recommended);
		petplan.setCustomPlan(customPlan);
		petplan.setActive(active);

		petPlanPersistence.update(petplan);

		return petplan;

	}

	/**
	 * Get Plan List
	 * 
	 * @param start
	 * @param end
	 */
	public List<PetPlan> getPetPlans(int start, int end) {
		return petPlanPersistence.findAll(start, end);
	}

	public List<PetPlan> getPetPlans() {
		return petPlanPersistence.findAll();
	}

	/**
	 * Get Plans Count
	 */
	public int getPetPlansCount() {
		return petPlanPersistence.countAll();
	}
	
	public List<PetPlan> getRecommendedPlans() {
		return petPlanPersistence.findByrecommendedPlan(1);
	}

	/**
	 * Set status for pet plan
	 * @param userId
	 * @param petPlanId
	 * @param active
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	public PetPlan setActive(long userId, long petPlanId, int active, ServiceContext serviceContext)
			throws PortalException {
		PetPlan petplan = null;

		try {
			petplan = petPlanPersistence.findByPrimaryKey(petPlanId);
			Date now = new Date();
			petplan.setPetPlanId(petPlanId);
			petplan.setActive(active);
			petplan.setModifiedDate(serviceContext.getModifiedDate(now));

			petPlanPersistence.update(petplan);

		} catch (Exception e) {
            log.debug(e.getMessage());
		}

		return petplan;
	}
	
	public PetPlan searchPetPlanId(long petPlanId) {
		return petPlanPersistence.fetchBysearchPetPlanId(petPlanId);
	}

    private static final Log log = LogFactoryUtil.getLog(PetPlanLocalServiceImpl.class);
}