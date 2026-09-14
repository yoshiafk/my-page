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

package com.mypage.admin.product.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.admin.product.exception.NoSuchHealthIndividuPlanException;
import com.mypage.admin.product.model.HealthIndividuPlan;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the health individu plan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see HealthIndividuPlanUtil
 * @generated
 */
@ProviderType
public interface HealthIndividuPlanPersistence
	extends BasePersistence<HealthIndividuPlan> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HealthIndividuPlanUtil} to access the health individu plan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the health individu plan in the entity cache if it is enabled.
	 *
	 * @param healthIndividuPlan the health individu plan
	 */
	public void cacheResult(HealthIndividuPlan healthIndividuPlan);

	/**
	 * Caches the health individu plans in the entity cache if it is enabled.
	 *
	 * @param healthIndividuPlans the health individu plans
	 */
	public void cacheResult(
		java.util.List<HealthIndividuPlan> healthIndividuPlans);

	/**
	 * Creates a new health individu plan with the primary key. Does not add the health individu plan to the database.
	 *
	 * @param healthIndividuPlanId the primary key for the new health individu plan
	 * @return the new health individu plan
	 */
	public HealthIndividuPlan create(long healthIndividuPlanId);

	/**
	 * Removes the health individu plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param healthIndividuPlanId the primary key of the health individu plan
	 * @return the health individu plan that was removed
	 * @throws NoSuchHealthIndividuPlanException if a health individu plan with the primary key could not be found
	 */
	public HealthIndividuPlan remove(long healthIndividuPlanId)
		throws NoSuchHealthIndividuPlanException;

	public HealthIndividuPlan updateImpl(HealthIndividuPlan healthIndividuPlan);

	/**
	 * Returns the health individu plan with the primary key or throws a <code>NoSuchHealthIndividuPlanException</code> if it could not be found.
	 *
	 * @param healthIndividuPlanId the primary key of the health individu plan
	 * @return the health individu plan
	 * @throws NoSuchHealthIndividuPlanException if a health individu plan with the primary key could not be found
	 */
	public HealthIndividuPlan findByPrimaryKey(long healthIndividuPlanId)
		throws NoSuchHealthIndividuPlanException;

	/**
	 * Returns the health individu plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param healthIndividuPlanId the primary key of the health individu plan
	 * @return the health individu plan, or <code>null</code> if a health individu plan with the primary key could not be found
	 */
	public HealthIndividuPlan fetchByPrimaryKey(long healthIndividuPlanId);

	/**
	 * Returns all the health individu plans.
	 *
	 * @return the health individu plans
	 */
	public java.util.List<HealthIndividuPlan> findAll();

	/**
	 * Returns a range of all the health individu plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu plans
	 * @param end the upper bound of the range of health individu plans (not inclusive)
	 * @return the range of health individu plans
	 */
	public java.util.List<HealthIndividuPlan> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the health individu plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu plans
	 * @param end the upper bound of the range of health individu plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of health individu plans
	 */
	public java.util.List<HealthIndividuPlan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HealthIndividuPlan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the health individu plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu plans
	 * @param end the upper bound of the range of health individu plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of health individu plans
	 */
	public java.util.List<HealthIndividuPlan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HealthIndividuPlan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the health individu plans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of health individu plans.
	 *
	 * @return the number of health individu plans
	 */
	public int countAll();

}