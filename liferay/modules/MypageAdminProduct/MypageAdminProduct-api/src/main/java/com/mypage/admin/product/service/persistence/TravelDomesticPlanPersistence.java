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

import com.mypage.admin.product.exception.NoSuchTravelDomesticPlanException;
import com.mypage.admin.product.model.TravelDomesticPlan;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the travel domestic plan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticPlanUtil
 * @generated
 */
@ProviderType
public interface TravelDomesticPlanPersistence
	extends BasePersistence<TravelDomesticPlan> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TravelDomesticPlanUtil} to access the travel domestic plan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the travel domestic plans where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @return the matching travel domestic plans
	 */
	public java.util.List<TravelDomesticPlan> findBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi);

	/**
	 * Returns a range of all the travel domestic plans where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @return the range of matching travel domestic plans
	 */
	public java.util.List<TravelDomesticPlan> findBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi, int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic plans where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic plans
	 */
	public java.util.List<TravelDomesticPlan> findBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPlan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic plans where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic plans
	 */
	public java.util.List<TravelDomesticPlan> findBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPlan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel domestic plan in the ordered set where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a matching travel domestic plan could not be found
	 */
	public TravelDomesticPlan findBysearchPlan_First(
			long travelDomesticPlanId, String name, String code, int toproTsi,
			int toproAtsi,
			com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPlan>
				orderByComparator)
		throws NoSuchTravelDomesticPlanException;

	/**
	 * Returns the first travel domestic plan in the ordered set where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic plan, or <code>null</code> if a matching travel domestic plan could not be found
	 */
	public TravelDomesticPlan fetchBysearchPlan_First(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPlan>
			orderByComparator);

	/**
	 * Returns the last travel domestic plan in the ordered set where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a matching travel domestic plan could not be found
	 */
	public TravelDomesticPlan findBysearchPlan_Last(
			long travelDomesticPlanId, String name, String code, int toproTsi,
			int toproAtsi,
			com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPlan>
				orderByComparator)
		throws NoSuchTravelDomesticPlanException;

	/**
	 * Returns the last travel domestic plan in the ordered set where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic plan, or <code>null</code> if a matching travel domestic plan could not be found
	 */
	public TravelDomesticPlan fetchBysearchPlan_Last(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPlan>
			orderByComparator);

	/**
	 * Removes all the travel domestic plans where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63; from the database.
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 */
	public void removeBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi);

	/**
	 * Returns the number of travel domestic plans where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63;.
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 * @return the number of matching travel domestic plans
	 */
	public int countBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi);

	/**
	 * Returns all the travel domestic plans where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching travel domestic plans
	 */
	public java.util.List<TravelDomesticPlan> findBysearchByCode(String code);

	/**
	 * Returns a range of all the travel domestic plans where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @return the range of matching travel domestic plans
	 */
	public java.util.List<TravelDomesticPlan> findBysearchByCode(
		String code, int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic plans where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic plans
	 */
	public java.util.List<TravelDomesticPlan> findBysearchByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPlan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic plans where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic plans
	 */
	public java.util.List<TravelDomesticPlan> findBysearchByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPlan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel domestic plan in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a matching travel domestic plan could not be found
	 */
	public TravelDomesticPlan findBysearchByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPlan>
				orderByComparator)
		throws NoSuchTravelDomesticPlanException;

	/**
	 * Returns the first travel domestic plan in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic plan, or <code>null</code> if a matching travel domestic plan could not be found
	 */
	public TravelDomesticPlan fetchBysearchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPlan>
			orderByComparator);

	/**
	 * Returns the last travel domestic plan in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a matching travel domestic plan could not be found
	 */
	public TravelDomesticPlan findBysearchByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPlan>
				orderByComparator)
		throws NoSuchTravelDomesticPlanException;

	/**
	 * Returns the last travel domestic plan in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic plan, or <code>null</code> if a matching travel domestic plan could not be found
	 */
	public TravelDomesticPlan fetchBysearchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPlan>
			orderByComparator);

	/**
	 * Returns the travel domestic plans before and after the current travel domestic plan in the ordered set where code = &#63;.
	 *
	 * @param travelDomesticPlanId the primary key of the current travel domestic plan
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a travel domestic plan with the primary key could not be found
	 */
	public TravelDomesticPlan[] findBysearchByCode_PrevAndNext(
			long travelDomesticPlanId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPlan>
				orderByComparator)
		throws NoSuchTravelDomesticPlanException;

	/**
	 * Removes all the travel domestic plans where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeBysearchByCode(String code);

	/**
	 * Returns the number of travel domestic plans where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching travel domestic plans
	 */
	public int countBysearchByCode(String code);

	/**
	 * Returns the travel domestic plan where code = &#63; or throws a <code>NoSuchTravelDomesticPlanException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a matching travel domestic plan could not be found
	 */
	public TravelDomesticPlan findByCode(String code)
		throws NoSuchTravelDomesticPlanException;

	/**
	 * Returns the travel domestic plan where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching travel domestic plan, or <code>null</code> if a matching travel domestic plan could not be found
	 */
	public TravelDomesticPlan fetchByCode(String code);

	/**
	 * Returns the travel domestic plan where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching travel domestic plan, or <code>null</code> if a matching travel domestic plan could not be found
	 */
	public TravelDomesticPlan fetchByCode(String code, boolean useFinderCache);

	/**
	 * Removes the travel domestic plan where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the travel domestic plan that was removed
	 */
	public TravelDomesticPlan removeByCode(String code)
		throws NoSuchTravelDomesticPlanException;

	/**
	 * Returns the number of travel domestic plans where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching travel domestic plans
	 */
	public int countByCode(String code);

	/**
	 * Caches the travel domestic plan in the entity cache if it is enabled.
	 *
	 * @param travelDomesticPlan the travel domestic plan
	 */
	public void cacheResult(TravelDomesticPlan travelDomesticPlan);

	/**
	 * Caches the travel domestic plans in the entity cache if it is enabled.
	 *
	 * @param travelDomesticPlans the travel domestic plans
	 */
	public void cacheResult(
		java.util.List<TravelDomesticPlan> travelDomesticPlans);

	/**
	 * Creates a new travel domestic plan with the primary key. Does not add the travel domestic plan to the database.
	 *
	 * @param travelDomesticPlanId the primary key for the new travel domestic plan
	 * @return the new travel domestic plan
	 */
	public TravelDomesticPlan create(long travelDomesticPlanId);

	/**
	 * Removes the travel domestic plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticPlanId the primary key of the travel domestic plan
	 * @return the travel domestic plan that was removed
	 * @throws NoSuchTravelDomesticPlanException if a travel domestic plan with the primary key could not be found
	 */
	public TravelDomesticPlan remove(long travelDomesticPlanId)
		throws NoSuchTravelDomesticPlanException;

	public TravelDomesticPlan updateImpl(TravelDomesticPlan travelDomesticPlan);

	/**
	 * Returns the travel domestic plan with the primary key or throws a <code>NoSuchTravelDomesticPlanException</code> if it could not be found.
	 *
	 * @param travelDomesticPlanId the primary key of the travel domestic plan
	 * @return the travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a travel domestic plan with the primary key could not be found
	 */
	public TravelDomesticPlan findByPrimaryKey(long travelDomesticPlanId)
		throws NoSuchTravelDomesticPlanException;

	/**
	 * Returns the travel domestic plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticPlanId the primary key of the travel domestic plan
	 * @return the travel domestic plan, or <code>null</code> if a travel domestic plan with the primary key could not be found
	 */
	public TravelDomesticPlan fetchByPrimaryKey(long travelDomesticPlanId);

	/**
	 * Returns all the travel domestic plans.
	 *
	 * @return the travel domestic plans
	 */
	public java.util.List<TravelDomesticPlan> findAll();

	/**
	 * Returns a range of all the travel domestic plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @return the range of travel domestic plans
	 */
	public java.util.List<TravelDomesticPlan> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic plans
	 */
	public java.util.List<TravelDomesticPlan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPlan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic plans
	 */
	public java.util.List<TravelDomesticPlan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPlan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the travel domestic plans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of travel domestic plans.
	 *
	 * @return the number of travel domestic plans
	 */
	public int countAll();

}