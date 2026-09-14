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

import com.mypage.admin.product.exception.NoSuchSmartHealthPlanException;
import com.mypage.admin.product.model.SmartHealthPlan;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the smart health plan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartHealthPlanUtil
 * @generated
 */
@ProviderType
public interface SmartHealthPlanPersistence
	extends BasePersistence<SmartHealthPlan> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SmartHealthPlanUtil} to access the smart health plan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the smart health plan where planName = &#63; or throws a <code>NoSuchSmartHealthPlanException</code> if it could not be found.
	 *
	 * @param planName the plan name
	 * @return the matching smart health plan
	 * @throws NoSuchSmartHealthPlanException if a matching smart health plan could not be found
	 */
	public SmartHealthPlan findByplanName(String planName)
		throws NoSuchSmartHealthPlanException;

	/**
	 * Returns the smart health plan where planName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param planName the plan name
	 * @return the matching smart health plan, or <code>null</code> if a matching smart health plan could not be found
	 */
	public SmartHealthPlan fetchByplanName(String planName);

	/**
	 * Returns the smart health plan where planName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param planName the plan name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart health plan, or <code>null</code> if a matching smart health plan could not be found
	 */
	public SmartHealthPlan fetchByplanName(
		String planName, boolean useFinderCache);

	/**
	 * Removes the smart health plan where planName = &#63; from the database.
	 *
	 * @param planName the plan name
	 * @return the smart health plan that was removed
	 */
	public SmartHealthPlan removeByplanName(String planName)
		throws NoSuchSmartHealthPlanException;

	/**
	 * Returns the number of smart health plans where planName = &#63;.
	 *
	 * @param planName the plan name
	 * @return the number of matching smart health plans
	 */
	public int countByplanName(String planName);

	/**
	 * Returns all the smart health plans where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @return the matching smart health plans
	 */
	public java.util.List<SmartHealthPlan> findByplanGroup(String planGroup);

	/**
	 * Returns a range of all the smart health plans where planGroup = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param planGroup the plan group
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @return the range of matching smart health plans
	 */
	public java.util.List<SmartHealthPlan> findByplanGroup(
		String planGroup, int start, int end);

	/**
	 * Returns an ordered range of all the smart health plans where planGroup = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param planGroup the plan group
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smart health plans
	 */
	public java.util.List<SmartHealthPlan> findByplanGroup(
		String planGroup, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartHealthPlan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smart health plans where planGroup = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param planGroup the plan group
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smart health plans
	 */
	public java.util.List<SmartHealthPlan> findByplanGroup(
		String planGroup, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartHealthPlan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first smart health plan in the ordered set where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart health plan
	 * @throws NoSuchSmartHealthPlanException if a matching smart health plan could not be found
	 */
	public SmartHealthPlan findByplanGroup_First(
			String planGroup,
			com.liferay.portal.kernel.util.OrderByComparator<SmartHealthPlan>
				orderByComparator)
		throws NoSuchSmartHealthPlanException;

	/**
	 * Returns the first smart health plan in the ordered set where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart health plan, or <code>null</code> if a matching smart health plan could not be found
	 */
	public SmartHealthPlan fetchByplanGroup_First(
		String planGroup,
		com.liferay.portal.kernel.util.OrderByComparator<SmartHealthPlan>
			orderByComparator);

	/**
	 * Returns the last smart health plan in the ordered set where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart health plan
	 * @throws NoSuchSmartHealthPlanException if a matching smart health plan could not be found
	 */
	public SmartHealthPlan findByplanGroup_Last(
			String planGroup,
			com.liferay.portal.kernel.util.OrderByComparator<SmartHealthPlan>
				orderByComparator)
		throws NoSuchSmartHealthPlanException;

	/**
	 * Returns the last smart health plan in the ordered set where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart health plan, or <code>null</code> if a matching smart health plan could not be found
	 */
	public SmartHealthPlan fetchByplanGroup_Last(
		String planGroup,
		com.liferay.portal.kernel.util.OrderByComparator<SmartHealthPlan>
			orderByComparator);

	/**
	 * Returns the smart health plans before and after the current smart health plan in the ordered set where planGroup = &#63;.
	 *
	 * @param smartHealthPlanId the primary key of the current smart health plan
	 * @param planGroup the plan group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next smart health plan
	 * @throws NoSuchSmartHealthPlanException if a smart health plan with the primary key could not be found
	 */
	public SmartHealthPlan[] findByplanGroup_PrevAndNext(
			long smartHealthPlanId, String planGroup,
			com.liferay.portal.kernel.util.OrderByComparator<SmartHealthPlan>
				orderByComparator)
		throws NoSuchSmartHealthPlanException;

	/**
	 * Removes all the smart health plans where planGroup = &#63; from the database.
	 *
	 * @param planGroup the plan group
	 */
	public void removeByplanGroup(String planGroup);

	/**
	 * Returns the number of smart health plans where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @return the number of matching smart health plans
	 */
	public int countByplanGroup(String planGroup);

	/**
	 * Caches the smart health plan in the entity cache if it is enabled.
	 *
	 * @param smartHealthPlan the smart health plan
	 */
	public void cacheResult(SmartHealthPlan smartHealthPlan);

	/**
	 * Caches the smart health plans in the entity cache if it is enabled.
	 *
	 * @param smartHealthPlans the smart health plans
	 */
	public void cacheResult(java.util.List<SmartHealthPlan> smartHealthPlans);

	/**
	 * Creates a new smart health plan with the primary key. Does not add the smart health plan to the database.
	 *
	 * @param smartHealthPlanId the primary key for the new smart health plan
	 * @return the new smart health plan
	 */
	public SmartHealthPlan create(long smartHealthPlanId);

	/**
	 * Removes the smart health plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartHealthPlanId the primary key of the smart health plan
	 * @return the smart health plan that was removed
	 * @throws NoSuchSmartHealthPlanException if a smart health plan with the primary key could not be found
	 */
	public SmartHealthPlan remove(long smartHealthPlanId)
		throws NoSuchSmartHealthPlanException;

	public SmartHealthPlan updateImpl(SmartHealthPlan smartHealthPlan);

	/**
	 * Returns the smart health plan with the primary key or throws a <code>NoSuchSmartHealthPlanException</code> if it could not be found.
	 *
	 * @param smartHealthPlanId the primary key of the smart health plan
	 * @return the smart health plan
	 * @throws NoSuchSmartHealthPlanException if a smart health plan with the primary key could not be found
	 */
	public SmartHealthPlan findByPrimaryKey(long smartHealthPlanId)
		throws NoSuchSmartHealthPlanException;

	/**
	 * Returns the smart health plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartHealthPlanId the primary key of the smart health plan
	 * @return the smart health plan, or <code>null</code> if a smart health plan with the primary key could not be found
	 */
	public SmartHealthPlan fetchByPrimaryKey(long smartHealthPlanId);

	/**
	 * Returns all the smart health plans.
	 *
	 * @return the smart health plans
	 */
	public java.util.List<SmartHealthPlan> findAll();

	/**
	 * Returns a range of all the smart health plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @return the range of smart health plans
	 */
	public java.util.List<SmartHealthPlan> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the smart health plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart health plans
	 */
	public java.util.List<SmartHealthPlan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartHealthPlan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smart health plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart health plans
	 */
	public java.util.List<SmartHealthPlan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartHealthPlan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the smart health plans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of smart health plans.
	 *
	 * @return the number of smart health plans
	 */
	public int countAll();

}