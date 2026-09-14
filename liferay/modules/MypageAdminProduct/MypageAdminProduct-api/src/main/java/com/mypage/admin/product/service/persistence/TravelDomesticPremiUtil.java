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

import com.mypage.admin.product.model.TravelDomesticPremi;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the travel domestic premi service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.TravelDomesticPremiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticPremiPersistence
 * @generated
 */
public class TravelDomesticPremiUtil {

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
	public static void clearCache(TravelDomesticPremi travelDomesticPremi) {
		getPersistence().clearCache(travelDomesticPremi);
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
	public static Map<Serializable, TravelDomesticPremi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TravelDomesticPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TravelDomesticPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TravelDomesticPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TravelDomesticPremi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TravelDomesticPremi update(
		TravelDomesticPremi travelDomesticPremi) {

		return getPersistence().update(travelDomesticPremi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TravelDomesticPremi update(
		TravelDomesticPremi travelDomesticPremi,
		ServiceContext serviceContext) {

		return getPersistence().update(travelDomesticPremi, serviceContext);
	}

	/**
	 * Returns all the travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @return the matching travel domestic premis
	 */
	public static List<TravelDomesticPremi> findBysearchPremi(
		int duration, String plan, String insuredType) {

		return getPersistence().findBysearchPremi(duration, plan, insuredType);
	}

	/**
	 * Returns a range of all the travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @return the range of matching travel domestic premis
	 */
	public static List<TravelDomesticPremi> findBysearchPremi(
		int duration, String plan, String insuredType, int start, int end) {

		return getPersistence().findBysearchPremi(
			duration, plan, insuredType, start, end);
	}

	/**
	 * Returns an ordered range of all the travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic premis
	 */
	public static List<TravelDomesticPremi> findBysearchPremi(
		int duration, String plan, String insuredType, int start, int end,
		OrderByComparator<TravelDomesticPremi> orderByComparator) {

		return getPersistence().findBysearchPremi(
			duration, plan, insuredType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic premis
	 */
	public static List<TravelDomesticPremi> findBysearchPremi(
		int duration, String plan, String insuredType, int start, int end,
		OrderByComparator<TravelDomesticPremi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchPremi(
			duration, plan, insuredType, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first travel domestic premi in the ordered set where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic premi
	 * @throws NoSuchTravelDomesticPremiException if a matching travel domestic premi could not be found
	 */
	public static TravelDomesticPremi findBysearchPremi_First(
			int duration, String plan, String insuredType,
			OrderByComparator<TravelDomesticPremi> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticPremiException {

		return getPersistence().findBysearchPremi_First(
			duration, plan, insuredType, orderByComparator);
	}

	/**
	 * Returns the first travel domestic premi in the ordered set where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic premi, or <code>null</code> if a matching travel domestic premi could not be found
	 */
	public static TravelDomesticPremi fetchBysearchPremi_First(
		int duration, String plan, String insuredType,
		OrderByComparator<TravelDomesticPremi> orderByComparator) {

		return getPersistence().fetchBysearchPremi_First(
			duration, plan, insuredType, orderByComparator);
	}

	/**
	 * Returns the last travel domestic premi in the ordered set where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic premi
	 * @throws NoSuchTravelDomesticPremiException if a matching travel domestic premi could not be found
	 */
	public static TravelDomesticPremi findBysearchPremi_Last(
			int duration, String plan, String insuredType,
			OrderByComparator<TravelDomesticPremi> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticPremiException {

		return getPersistence().findBysearchPremi_Last(
			duration, plan, insuredType, orderByComparator);
	}

	/**
	 * Returns the last travel domestic premi in the ordered set where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic premi, or <code>null</code> if a matching travel domestic premi could not be found
	 */
	public static TravelDomesticPremi fetchBysearchPremi_Last(
		int duration, String plan, String insuredType,
		OrderByComparator<TravelDomesticPremi> orderByComparator) {

		return getPersistence().fetchBysearchPremi_Last(
			duration, plan, insuredType, orderByComparator);
	}

	/**
	 * Returns the travel domestic premis before and after the current travel domestic premi in the ordered set where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param travelDomesticPremiId the primary key of the current travel domestic premi
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel domestic premi
	 * @throws NoSuchTravelDomesticPremiException if a travel domestic premi with the primary key could not be found
	 */
	public static TravelDomesticPremi[] findBysearchPremi_PrevAndNext(
			long travelDomesticPremiId, int duration, String plan,
			String insuredType,
			OrderByComparator<TravelDomesticPremi> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticPremiException {

		return getPersistence().findBysearchPremi_PrevAndNext(
			travelDomesticPremiId, duration, plan, insuredType,
			orderByComparator);
	}

	/**
	 * Removes all the travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63; from the database.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 */
	public static void removeBysearchPremi(
		int duration, String plan, String insuredType) {

		getPersistence().removeBysearchPremi(duration, plan, insuredType);
	}

	/**
	 * Returns the number of travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @return the number of matching travel domestic premis
	 */
	public static int countBysearchPremi(
		int duration, String plan, String insuredType) {

		return getPersistence().countBysearchPremi(duration, plan, insuredType);
	}

	/**
	 * Caches the travel domestic premi in the entity cache if it is enabled.
	 *
	 * @param travelDomesticPremi the travel domestic premi
	 */
	public static void cacheResult(TravelDomesticPremi travelDomesticPremi) {
		getPersistence().cacheResult(travelDomesticPremi);
	}

	/**
	 * Caches the travel domestic premis in the entity cache if it is enabled.
	 *
	 * @param travelDomesticPremis the travel domestic premis
	 */
	public static void cacheResult(
		List<TravelDomesticPremi> travelDomesticPremis) {

		getPersistence().cacheResult(travelDomesticPremis);
	}

	/**
	 * Creates a new travel domestic premi with the primary key. Does not add the travel domestic premi to the database.
	 *
	 * @param travelDomesticPremiId the primary key for the new travel domestic premi
	 * @return the new travel domestic premi
	 */
	public static TravelDomesticPremi create(long travelDomesticPremiId) {
		return getPersistence().create(travelDomesticPremiId);
	}

	/**
	 * Removes the travel domestic premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticPremiId the primary key of the travel domestic premi
	 * @return the travel domestic premi that was removed
	 * @throws NoSuchTravelDomesticPremiException if a travel domestic premi with the primary key could not be found
	 */
	public static TravelDomesticPremi remove(long travelDomesticPremiId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticPremiException {

		return getPersistence().remove(travelDomesticPremiId);
	}

	public static TravelDomesticPremi updateImpl(
		TravelDomesticPremi travelDomesticPremi) {

		return getPersistence().updateImpl(travelDomesticPremi);
	}

	/**
	 * Returns the travel domestic premi with the primary key or throws a <code>NoSuchTravelDomesticPremiException</code> if it could not be found.
	 *
	 * @param travelDomesticPremiId the primary key of the travel domestic premi
	 * @return the travel domestic premi
	 * @throws NoSuchTravelDomesticPremiException if a travel domestic premi with the primary key could not be found
	 */
	public static TravelDomesticPremi findByPrimaryKey(
			long travelDomesticPremiId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticPremiException {

		return getPersistence().findByPrimaryKey(travelDomesticPremiId);
	}

	/**
	 * Returns the travel domestic premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticPremiId the primary key of the travel domestic premi
	 * @return the travel domestic premi, or <code>null</code> if a travel domestic premi with the primary key could not be found
	 */
	public static TravelDomesticPremi fetchByPrimaryKey(
		long travelDomesticPremiId) {

		return getPersistence().fetchByPrimaryKey(travelDomesticPremiId);
	}

	/**
	 * Returns all the travel domestic premis.
	 *
	 * @return the travel domestic premis
	 */
	public static List<TravelDomesticPremi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the travel domestic premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @return the range of travel domestic premis
	 */
	public static List<TravelDomesticPremi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the travel domestic premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic premis
	 */
	public static List<TravelDomesticPremi> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticPremi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel domestic premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic premis
	 */
	public static List<TravelDomesticPremi> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticPremi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the travel domestic premis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of travel domestic premis.
	 *
	 * @return the number of travel domestic premis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TravelDomesticPremiPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TravelDomesticPremiPersistence _persistence;

}