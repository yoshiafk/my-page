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

import com.mypage.admin.product.model.TravelDomesticBenefit;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the travel domestic benefit service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.TravelDomesticBenefitPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticBenefitPersistence
 * @generated
 */
public class TravelDomesticBenefitUtil {

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
	public static void clearCache(TravelDomesticBenefit travelDomesticBenefit) {
		getPersistence().clearCache(travelDomesticBenefit);
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
	public static Map<Serializable, TravelDomesticBenefit> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TravelDomesticBenefit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TravelDomesticBenefit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TravelDomesticBenefit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TravelDomesticBenefit update(
		TravelDomesticBenefit travelDomesticBenefit) {

		return getPersistence().update(travelDomesticBenefit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TravelDomesticBenefit update(
		TravelDomesticBenefit travelDomesticBenefit,
		ServiceContext serviceContext) {

		return getPersistence().update(travelDomesticBenefit, serviceContext);
	}

	/**
	 * Returns all the travel domestic benefits where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @return the matching travel domestic benefits
	 */
	public static List<TravelDomesticBenefit>
		findBysearchTravelDomesticBenefitId(long travelDomesticBenefitId) {

		return getPersistence().findBysearchTravelDomesticBenefitId(
			travelDomesticBenefitId);
	}

	/**
	 * Returns a range of all the travel domestic benefits where travelDomesticBenefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @return the range of matching travel domestic benefits
	 */
	public static List<TravelDomesticBenefit>
		findBysearchTravelDomesticBenefitId(
			long travelDomesticBenefitId, int start, int end) {

		return getPersistence().findBysearchTravelDomesticBenefitId(
			travelDomesticBenefitId, start, end);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefits where travelDomesticBenefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic benefits
	 */
	public static List<TravelDomesticBenefit>
		findBysearchTravelDomesticBenefitId(
			long travelDomesticBenefitId, int start, int end,
			OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		return getPersistence().findBysearchTravelDomesticBenefitId(
			travelDomesticBenefitId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefits where travelDomesticBenefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic benefits
	 */
	public static List<TravelDomesticBenefit>
		findBysearchTravelDomesticBenefitId(
			long travelDomesticBenefitId, int start, int end,
			OrderByComparator<TravelDomesticBenefit> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findBysearchTravelDomesticBenefitId(
			travelDomesticBenefitId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first travel domestic benefit in the ordered set where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	public static TravelDomesticBenefit
			findBysearchTravelDomesticBenefitId_First(
				long travelDomesticBenefitId,
				OrderByComparator<TravelDomesticBenefit> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticBenefitException {

		return getPersistence().findBysearchTravelDomesticBenefitId_First(
			travelDomesticBenefitId, orderByComparator);
	}

	/**
	 * Returns the first travel domestic benefit in the ordered set where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	public static TravelDomesticBenefit
		fetchBysearchTravelDomesticBenefitId_First(
			long travelDomesticBenefitId,
			OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		return getPersistence().fetchBysearchTravelDomesticBenefitId_First(
			travelDomesticBenefitId, orderByComparator);
	}

	/**
	 * Returns the last travel domestic benefit in the ordered set where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	public static TravelDomesticBenefit
			findBysearchTravelDomesticBenefitId_Last(
				long travelDomesticBenefitId,
				OrderByComparator<TravelDomesticBenefit> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticBenefitException {

		return getPersistence().findBysearchTravelDomesticBenefitId_Last(
			travelDomesticBenefitId, orderByComparator);
	}

	/**
	 * Returns the last travel domestic benefit in the ordered set where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	public static TravelDomesticBenefit
		fetchBysearchTravelDomesticBenefitId_Last(
			long travelDomesticBenefitId,
			OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		return getPersistence().fetchBysearchTravelDomesticBenefitId_Last(
			travelDomesticBenefitId, orderByComparator);
	}

	/**
	 * Removes all the travel domestic benefits where travelDomesticBenefitId = &#63; from the database.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 */
	public static void removeBysearchTravelDomesticBenefitId(
		long travelDomesticBenefitId) {

		getPersistence().removeBysearchTravelDomesticBenefitId(
			travelDomesticBenefitId);
	}

	/**
	 * Returns the number of travel domestic benefits where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @return the number of matching travel domestic benefits
	 */
	public static int countBysearchTravelDomesticBenefitId(
		long travelDomesticBenefitId) {

		return getPersistence().countBysearchTravelDomesticBenefitId(
			travelDomesticBenefitId);
	}

	/**
	 * Returns all the travel domestic benefits where plan = &#63;.
	 *
	 * @param plan the plan
	 * @return the matching travel domestic benefits
	 */
	public static List<TravelDomesticBenefit>
		findBysearchTravelDomesticBenefitPlan(String plan) {

		return getPersistence().findBysearchTravelDomesticBenefitPlan(plan);
	}

	/**
	 * Returns a range of all the travel domestic benefits where plan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param plan the plan
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @return the range of matching travel domestic benefits
	 */
	public static List<TravelDomesticBenefit>
		findBysearchTravelDomesticBenefitPlan(String plan, int start, int end) {

		return getPersistence().findBysearchTravelDomesticBenefitPlan(
			plan, start, end);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefits where plan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param plan the plan
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic benefits
	 */
	public static List<TravelDomesticBenefit>
		findBysearchTravelDomesticBenefitPlan(
			String plan, int start, int end,
			OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		return getPersistence().findBysearchTravelDomesticBenefitPlan(
			plan, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefits where plan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param plan the plan
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic benefits
	 */
	public static List<TravelDomesticBenefit>
		findBysearchTravelDomesticBenefitPlan(
			String plan, int start, int end,
			OrderByComparator<TravelDomesticBenefit> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findBysearchTravelDomesticBenefitPlan(
			plan, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first travel domestic benefit in the ordered set where plan = &#63;.
	 *
	 * @param plan the plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	public static TravelDomesticBenefit
			findBysearchTravelDomesticBenefitPlan_First(
				String plan,
				OrderByComparator<TravelDomesticBenefit> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticBenefitException {

		return getPersistence().findBysearchTravelDomesticBenefitPlan_First(
			plan, orderByComparator);
	}

	/**
	 * Returns the first travel domestic benefit in the ordered set where plan = &#63;.
	 *
	 * @param plan the plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	public static TravelDomesticBenefit
		fetchBysearchTravelDomesticBenefitPlan_First(
			String plan,
			OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		return getPersistence().fetchBysearchTravelDomesticBenefitPlan_First(
			plan, orderByComparator);
	}

	/**
	 * Returns the last travel domestic benefit in the ordered set where plan = &#63;.
	 *
	 * @param plan the plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	public static TravelDomesticBenefit
			findBysearchTravelDomesticBenefitPlan_Last(
				String plan,
				OrderByComparator<TravelDomesticBenefit> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticBenefitException {

		return getPersistence().findBysearchTravelDomesticBenefitPlan_Last(
			plan, orderByComparator);
	}

	/**
	 * Returns the last travel domestic benefit in the ordered set where plan = &#63;.
	 *
	 * @param plan the plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	public static TravelDomesticBenefit
		fetchBysearchTravelDomesticBenefitPlan_Last(
			String plan,
			OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		return getPersistence().fetchBysearchTravelDomesticBenefitPlan_Last(
			plan, orderByComparator);
	}

	/**
	 * Returns the travel domestic benefits before and after the current travel domestic benefit in the ordered set where plan = &#63;.
	 *
	 * @param travelDomesticBenefitId the primary key of the current travel domestic benefit
	 * @param plan the plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a travel domestic benefit with the primary key could not be found
	 */
	public static TravelDomesticBenefit[]
			findBysearchTravelDomesticBenefitPlan_PrevAndNext(
				long travelDomesticBenefitId, String plan,
				OrderByComparator<TravelDomesticBenefit> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticBenefitException {

		return getPersistence().
			findBysearchTravelDomesticBenefitPlan_PrevAndNext(
				travelDomesticBenefitId, plan, orderByComparator);
	}

	/**
	 * Removes all the travel domestic benefits where plan = &#63; from the database.
	 *
	 * @param plan the plan
	 */
	public static void removeBysearchTravelDomesticBenefitPlan(String plan) {
		getPersistence().removeBysearchTravelDomesticBenefitPlan(plan);
	}

	/**
	 * Returns the number of travel domestic benefits where plan = &#63;.
	 *
	 * @param plan the plan
	 * @return the number of matching travel domestic benefits
	 */
	public static int countBysearchTravelDomesticBenefitPlan(String plan) {
		return getPersistence().countBysearchTravelDomesticBenefitPlan(plan);
	}

	/**
	 * Returns all the travel domestic benefits where group = &#63;.
	 *
	 * @param group the group
	 * @return the matching travel domestic benefits
	 */
	public static List<TravelDomesticBenefit> findBysearchGroup(String group) {
		return getPersistence().findBysearchGroup(group);
	}

	/**
	 * Returns a range of all the travel domestic benefits where group = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param group the group
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @return the range of matching travel domestic benefits
	 */
	public static List<TravelDomesticBenefit> findBysearchGroup(
		String group, int start, int end) {

		return getPersistence().findBysearchGroup(group, start, end);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefits where group = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param group the group
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic benefits
	 */
	public static List<TravelDomesticBenefit> findBysearchGroup(
		String group, int start, int end,
		OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		return getPersistence().findBysearchGroup(
			group, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefits where group = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param group the group
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic benefits
	 */
	public static List<TravelDomesticBenefit> findBysearchGroup(
		String group, int start, int end,
		OrderByComparator<TravelDomesticBenefit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchGroup(
			group, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first travel domestic benefit in the ordered set where group = &#63;.
	 *
	 * @param group the group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	public static TravelDomesticBenefit findBysearchGroup_First(
			String group,
			OrderByComparator<TravelDomesticBenefit> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticBenefitException {

		return getPersistence().findBysearchGroup_First(
			group, orderByComparator);
	}

	/**
	 * Returns the first travel domestic benefit in the ordered set where group = &#63;.
	 *
	 * @param group the group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	public static TravelDomesticBenefit fetchBysearchGroup_First(
		String group,
		OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		return getPersistence().fetchBysearchGroup_First(
			group, orderByComparator);
	}

	/**
	 * Returns the last travel domestic benefit in the ordered set where group = &#63;.
	 *
	 * @param group the group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	public static TravelDomesticBenefit findBysearchGroup_Last(
			String group,
			OrderByComparator<TravelDomesticBenefit> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticBenefitException {

		return getPersistence().findBysearchGroup_Last(
			group, orderByComparator);
	}

	/**
	 * Returns the last travel domestic benefit in the ordered set where group = &#63;.
	 *
	 * @param group the group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	public static TravelDomesticBenefit fetchBysearchGroup_Last(
		String group,
		OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		return getPersistence().fetchBysearchGroup_Last(
			group, orderByComparator);
	}

	/**
	 * Returns the travel domestic benefits before and after the current travel domestic benefit in the ordered set where group = &#63;.
	 *
	 * @param travelDomesticBenefitId the primary key of the current travel domestic benefit
	 * @param group the group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a travel domestic benefit with the primary key could not be found
	 */
	public static TravelDomesticBenefit[] findBysearchGroup_PrevAndNext(
			long travelDomesticBenefitId, String group,
			OrderByComparator<TravelDomesticBenefit> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticBenefitException {

		return getPersistence().findBysearchGroup_PrevAndNext(
			travelDomesticBenefitId, group, orderByComparator);
	}

	/**
	 * Removes all the travel domestic benefits where group = &#63; from the database.
	 *
	 * @param group the group
	 */
	public static void removeBysearchGroup(String group) {
		getPersistence().removeBysearchGroup(group);
	}

	/**
	 * Returns the number of travel domestic benefits where group = &#63;.
	 *
	 * @param group the group
	 * @return the number of matching travel domestic benefits
	 */
	public static int countBysearchGroup(String group) {
		return getPersistence().countBysearchGroup(group);
	}

	/**
	 * Caches the travel domestic benefit in the entity cache if it is enabled.
	 *
	 * @param travelDomesticBenefit the travel domestic benefit
	 */
	public static void cacheResult(
		TravelDomesticBenefit travelDomesticBenefit) {

		getPersistence().cacheResult(travelDomesticBenefit);
	}

	/**
	 * Caches the travel domestic benefits in the entity cache if it is enabled.
	 *
	 * @param travelDomesticBenefits the travel domestic benefits
	 */
	public static void cacheResult(
		List<TravelDomesticBenefit> travelDomesticBenefits) {

		getPersistence().cacheResult(travelDomesticBenefits);
	}

	/**
	 * Creates a new travel domestic benefit with the primary key. Does not add the travel domestic benefit to the database.
	 *
	 * @param travelDomesticBenefitId the primary key for the new travel domestic benefit
	 * @return the new travel domestic benefit
	 */
	public static TravelDomesticBenefit create(long travelDomesticBenefitId) {
		return getPersistence().create(travelDomesticBenefitId);
	}

	/**
	 * Removes the travel domestic benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticBenefitId the primary key of the travel domestic benefit
	 * @return the travel domestic benefit that was removed
	 * @throws NoSuchTravelDomesticBenefitException if a travel domestic benefit with the primary key could not be found
	 */
	public static TravelDomesticBenefit remove(long travelDomesticBenefitId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticBenefitException {

		return getPersistence().remove(travelDomesticBenefitId);
	}

	public static TravelDomesticBenefit updateImpl(
		TravelDomesticBenefit travelDomesticBenefit) {

		return getPersistence().updateImpl(travelDomesticBenefit);
	}

	/**
	 * Returns the travel domestic benefit with the primary key or throws a <code>NoSuchTravelDomesticBenefitException</code> if it could not be found.
	 *
	 * @param travelDomesticBenefitId the primary key of the travel domestic benefit
	 * @return the travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a travel domestic benefit with the primary key could not be found
	 */
	public static TravelDomesticBenefit findByPrimaryKey(
			long travelDomesticBenefitId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticBenefitException {

		return getPersistence().findByPrimaryKey(travelDomesticBenefitId);
	}

	/**
	 * Returns the travel domestic benefit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticBenefitId the primary key of the travel domestic benefit
	 * @return the travel domestic benefit, or <code>null</code> if a travel domestic benefit with the primary key could not be found
	 */
	public static TravelDomesticBenefit fetchByPrimaryKey(
		long travelDomesticBenefitId) {

		return getPersistence().fetchByPrimaryKey(travelDomesticBenefitId);
	}

	/**
	 * Returns all the travel domestic benefits.
	 *
	 * @return the travel domestic benefits
	 */
	public static List<TravelDomesticBenefit> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the travel domestic benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @return the range of travel domestic benefits
	 */
	public static List<TravelDomesticBenefit> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic benefits
	 */
	public static List<TravelDomesticBenefit> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticBenefit> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic benefits
	 */
	public static List<TravelDomesticBenefit> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticBenefit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the travel domestic benefits from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of travel domestic benefits.
	 *
	 * @return the number of travel domestic benefits
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TravelDomesticBenefitPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TravelDomesticBenefitPersistence _persistence;

}