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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.TravelDomesticPlan;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the travel domestic plan service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.TravelDomesticPlanPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticPlanPersistence
 * @generated
 */
public class TravelDomesticPlanUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TravelDomesticPlan travelDomesticPlan) {
		getPersistence().clearCache(travelDomesticPlan);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TravelDomesticPlan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TravelDomesticPlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TravelDomesticPlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TravelDomesticPlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TravelDomesticPlan> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TravelDomesticPlan update(
		TravelDomesticPlan travelDomesticPlan) {

		return getPersistence().update(travelDomesticPlan);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TravelDomesticPlan update(
		TravelDomesticPlan travelDomesticPlan, ServiceContext serviceContext) {

		return getPersistence().update(travelDomesticPlan, serviceContext);
	}

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
	public static List<TravelDomesticPlan> findBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi) {

		return getPersistence().findBysearchPlan(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi);
	}

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
	public static List<TravelDomesticPlan> findBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi, int start, int end) {

		return getPersistence().findBysearchPlan(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi, start, end);
	}

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
	public static List<TravelDomesticPlan> findBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi, int start, int end,
		OrderByComparator<TravelDomesticPlan> orderByComparator) {

		return getPersistence().findBysearchPlan(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi, start, end,
			orderByComparator);
	}

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
	public static List<TravelDomesticPlan> findBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi, int start, int end,
		OrderByComparator<TravelDomesticPlan> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchPlan(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi, start, end,
			orderByComparator, useFinderCache);
	}

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
	public static TravelDomesticPlan findBysearchPlan_First(
			long travelDomesticPlanId, String name, String code, int toproTsi,
			int toproAtsi,
			OrderByComparator<TravelDomesticPlan> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticPlanException {

		return getPersistence().findBysearchPlan_First(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi,
			orderByComparator);
	}

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
	public static TravelDomesticPlan fetchBysearchPlan_First(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi,
		OrderByComparator<TravelDomesticPlan> orderByComparator) {

		return getPersistence().fetchBysearchPlan_First(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi,
			orderByComparator);
	}

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
	public static TravelDomesticPlan findBysearchPlan_Last(
			long travelDomesticPlanId, String name, String code, int toproTsi,
			int toproAtsi,
			OrderByComparator<TravelDomesticPlan> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticPlanException {

		return getPersistence().findBysearchPlan_Last(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi,
			orderByComparator);
	}

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
	public static TravelDomesticPlan fetchBysearchPlan_Last(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi,
		OrderByComparator<TravelDomesticPlan> orderByComparator) {

		return getPersistence().fetchBysearchPlan_Last(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi,
			orderByComparator);
	}

	/**
	 * Removes all the travel domestic plans where travelDomesticPlanId = &#63; and name = &#63; and code = &#63; and toproTsi = &#63; and toproAtsi = &#63; from the database.
	 *
	 * @param travelDomesticPlanId the travel domestic plan ID
	 * @param name the name
	 * @param code the code
	 * @param toproTsi the topro tsi
	 * @param toproAtsi the topro atsi
	 */
	public static void removeBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi) {

		getPersistence().removeBysearchPlan(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi);
	}

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
	public static int countBysearchPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi) {

		return getPersistence().countBysearchPlan(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi);
	}

	/**
	 * Returns all the travel domestic plans where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching travel domestic plans
	 */
	public static List<TravelDomesticPlan> findBysearchByCode(String code) {
		return getPersistence().findBysearchByCode(code);
	}

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
	public static List<TravelDomesticPlan> findBysearchByCode(
		String code, int start, int end) {

		return getPersistence().findBysearchByCode(code, start, end);
	}

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
	public static List<TravelDomesticPlan> findBysearchByCode(
		String code, int start, int end,
		OrderByComparator<TravelDomesticPlan> orderByComparator) {

		return getPersistence().findBysearchByCode(
			code, start, end, orderByComparator);
	}

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
	public static List<TravelDomesticPlan> findBysearchByCode(
		String code, int start, int end,
		OrderByComparator<TravelDomesticPlan> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first travel domestic plan in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a matching travel domestic plan could not be found
	 */
	public static TravelDomesticPlan findBysearchByCode_First(
			String code,
			OrderByComparator<TravelDomesticPlan> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticPlanException {

		return getPersistence().findBysearchByCode_First(
			code, orderByComparator);
	}

	/**
	 * Returns the first travel domestic plan in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic plan, or <code>null</code> if a matching travel domestic plan could not be found
	 */
	public static TravelDomesticPlan fetchBysearchByCode_First(
		String code, OrderByComparator<TravelDomesticPlan> orderByComparator) {

		return getPersistence().fetchBysearchByCode_First(
			code, orderByComparator);
	}

	/**
	 * Returns the last travel domestic plan in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a matching travel domestic plan could not be found
	 */
	public static TravelDomesticPlan findBysearchByCode_Last(
			String code,
			OrderByComparator<TravelDomesticPlan> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticPlanException {

		return getPersistence().findBysearchByCode_Last(
			code, orderByComparator);
	}

	/**
	 * Returns the last travel domestic plan in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic plan, or <code>null</code> if a matching travel domestic plan could not be found
	 */
	public static TravelDomesticPlan fetchBysearchByCode_Last(
		String code, OrderByComparator<TravelDomesticPlan> orderByComparator) {

		return getPersistence().fetchBysearchByCode_Last(
			code, orderByComparator);
	}

	/**
	 * Returns the travel domestic plans before and after the current travel domestic plan in the ordered set where code = &#63;.
	 *
	 * @param travelDomesticPlanId the primary key of the current travel domestic plan
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a travel domestic plan with the primary key could not be found
	 */
	public static TravelDomesticPlan[] findBysearchByCode_PrevAndNext(
			long travelDomesticPlanId, String code,
			OrderByComparator<TravelDomesticPlan> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticPlanException {

		return getPersistence().findBysearchByCode_PrevAndNext(
			travelDomesticPlanId, code, orderByComparator);
	}

	/**
	 * Removes all the travel domestic plans where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeBysearchByCode(String code) {
		getPersistence().removeBysearchByCode(code);
	}

	/**
	 * Returns the number of travel domestic plans where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching travel domestic plans
	 */
	public static int countBysearchByCode(String code) {
		return getPersistence().countBysearchByCode(code);
	}

	/**
	 * Returns the travel domestic plan where code = &#63; or throws a <code>NoSuchTravelDomesticPlanException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a matching travel domestic plan could not be found
	 */
	public static TravelDomesticPlan findByCode(String code)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticPlanException {

		return getPersistence().findByCode(code);
	}

	/**
	 * Returns the travel domestic plan where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching travel domestic plan, or <code>null</code> if a matching travel domestic plan could not be found
	 */
	public static TravelDomesticPlan fetchByCode(String code) {
		return getPersistence().fetchByCode(code);
	}

	/**
	 * Returns the travel domestic plan where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching travel domestic plan, or <code>null</code> if a matching travel domestic plan could not be found
	 */
	public static TravelDomesticPlan fetchByCode(
		String code, boolean useFinderCache) {

		return getPersistence().fetchByCode(code, useFinderCache);
	}

	/**
	 * Removes the travel domestic plan where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the travel domestic plan that was removed
	 */
	public static TravelDomesticPlan removeByCode(String code)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticPlanException {

		return getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of travel domestic plans where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching travel domestic plans
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Caches the travel domestic plan in the entity cache if it is enabled.
	 *
	 * @param travelDomesticPlan the travel domestic plan
	 */
	public static void cacheResult(TravelDomesticPlan travelDomesticPlan) {
		getPersistence().cacheResult(travelDomesticPlan);
	}

	/**
	 * Caches the travel domestic plans in the entity cache if it is enabled.
	 *
	 * @param travelDomesticPlans the travel domestic plans
	 */
	public static void cacheResult(
		List<TravelDomesticPlan> travelDomesticPlans) {

		getPersistence().cacheResult(travelDomesticPlans);
	}

	/**
	 * Creates a new travel domestic plan with the primary key. Does not add the travel domestic plan to the database.
	 *
	 * @param travelDomesticPlanId the primary key for the new travel domestic plan
	 * @return the new travel domestic plan
	 */
	public static TravelDomesticPlan create(long travelDomesticPlanId) {
		return getPersistence().create(travelDomesticPlanId);
	}

	/**
	 * Removes the travel domestic plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticPlanId the primary key of the travel domestic plan
	 * @return the travel domestic plan that was removed
	 * @throws NoSuchTravelDomesticPlanException if a travel domestic plan with the primary key could not be found
	 */
	public static TravelDomesticPlan remove(long travelDomesticPlanId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticPlanException {

		return getPersistence().remove(travelDomesticPlanId);
	}

	public static TravelDomesticPlan updateImpl(
		TravelDomesticPlan travelDomesticPlan) {

		return getPersistence().updateImpl(travelDomesticPlan);
	}

	/**
	 * Returns the travel domestic plan with the primary key or throws a <code>NoSuchTravelDomesticPlanException</code> if it could not be found.
	 *
	 * @param travelDomesticPlanId the primary key of the travel domestic plan
	 * @return the travel domestic plan
	 * @throws NoSuchTravelDomesticPlanException if a travel domestic plan with the primary key could not be found
	 */
	public static TravelDomesticPlan findByPrimaryKey(long travelDomesticPlanId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticPlanException {

		return getPersistence().findByPrimaryKey(travelDomesticPlanId);
	}

	/**
	 * Returns the travel domestic plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticPlanId the primary key of the travel domestic plan
	 * @return the travel domestic plan, or <code>null</code> if a travel domestic plan with the primary key could not be found
	 */
	public static TravelDomesticPlan fetchByPrimaryKey(
		long travelDomesticPlanId) {

		return getPersistence().fetchByPrimaryKey(travelDomesticPlanId);
	}

	/**
	 * Returns all the travel domestic plans.
	 *
	 * @return the travel domestic plans
	 */
	public static List<TravelDomesticPlan> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<TravelDomesticPlan> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<TravelDomesticPlan> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticPlan> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<TravelDomesticPlan> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticPlan> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the travel domestic plans from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of travel domestic plans.
	 *
	 * @return the number of travel domestic plans
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TravelDomesticPlanPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TravelDomesticPlanPersistence _persistence;

}