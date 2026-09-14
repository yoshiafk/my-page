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

import com.mypage.admin.product.exception.NoSuchSmartTravelIntPlanException;
import com.mypage.admin.product.model.SmartTravelIntPlan;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the smart travel int plan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartTravelIntPlanUtil
 * @generated
 */
@ProviderType
public interface SmartTravelIntPlanPersistence
	extends BasePersistence<SmartTravelIntPlan> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SmartTravelIntPlanUtil} to access the smart travel int plan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the smart travel int plan in the entity cache if it is enabled.
	 *
	 * @param smartTravelIntPlan the smart travel int plan
	 */
	public void cacheResult(SmartTravelIntPlan smartTravelIntPlan);

	/**
	 * Caches the smart travel int plans in the entity cache if it is enabled.
	 *
	 * @param smartTravelIntPlans the smart travel int plans
	 */
	public void cacheResult(
		java.util.List<SmartTravelIntPlan> smartTravelIntPlans);

	/**
	 * Creates a new smart travel int plan with the primary key. Does not add the smart travel int plan to the database.
	 *
	 * @param smartTravelIntPlanId the primary key for the new smart travel int plan
	 * @return the new smart travel int plan
	 */
	public SmartTravelIntPlan create(long smartTravelIntPlanId);

	/**
	 * Removes the smart travel int plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartTravelIntPlanId the primary key of the smart travel int plan
	 * @return the smart travel int plan that was removed
	 * @throws NoSuchSmartTravelIntPlanException if a smart travel int plan with the primary key could not be found
	 */
	public SmartTravelIntPlan remove(long smartTravelIntPlanId)
		throws NoSuchSmartTravelIntPlanException;

	public SmartTravelIntPlan updateImpl(SmartTravelIntPlan smartTravelIntPlan);

	/**
	 * Returns the smart travel int plan with the primary key or throws a <code>NoSuchSmartTravelIntPlanException</code> if it could not be found.
	 *
	 * @param smartTravelIntPlanId the primary key of the smart travel int plan
	 * @return the smart travel int plan
	 * @throws NoSuchSmartTravelIntPlanException if a smart travel int plan with the primary key could not be found
	 */
	public SmartTravelIntPlan findByPrimaryKey(long smartTravelIntPlanId)
		throws NoSuchSmartTravelIntPlanException;

	/**
	 * Returns the smart travel int plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartTravelIntPlanId the primary key of the smart travel int plan
	 * @return the smart travel int plan, or <code>null</code> if a smart travel int plan with the primary key could not be found
	 */
	public SmartTravelIntPlan fetchByPrimaryKey(long smartTravelIntPlanId);

	/**
	 * Returns all the smart travel int plans.
	 *
	 * @return the smart travel int plans
	 */
	public java.util.List<SmartTravelIntPlan> findAll();

	/**
	 * Returns a range of all the smart travel int plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartTravelIntPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart travel int plans
	 * @param end the upper bound of the range of smart travel int plans (not inclusive)
	 * @return the range of smart travel int plans
	 */
	public java.util.List<SmartTravelIntPlan> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the smart travel int plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartTravelIntPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart travel int plans
	 * @param end the upper bound of the range of smart travel int plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart travel int plans
	 */
	public java.util.List<SmartTravelIntPlan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartTravelIntPlan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smart travel int plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartTravelIntPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart travel int plans
	 * @param end the upper bound of the range of smart travel int plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart travel int plans
	 */
	public java.util.List<SmartTravelIntPlan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartTravelIntPlan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the smart travel int plans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of smart travel int plans.
	 *
	 * @return the number of smart travel int plans
	 */
	public int countAll();

}