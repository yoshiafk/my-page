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

import com.mypage.admin.product.model.IntTravelStandardNewPremi;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the int travel standard new premi service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.IntTravelStandardNewPremiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see IntTravelStandardNewPremiPersistence
 * @generated
 */
public class IntTravelStandardNewPremiUtil {

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
	public static void clearCache(
		IntTravelStandardNewPremi intTravelStandardNewPremi) {

		getPersistence().clearCache(intTravelStandardNewPremi);
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
	public static Map<Serializable, IntTravelStandardNewPremi>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<IntTravelStandardNewPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<IntTravelStandardNewPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<IntTravelStandardNewPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<IntTravelStandardNewPremi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static IntTravelStandardNewPremi update(
		IntTravelStandardNewPremi intTravelStandardNewPremi) {

		return getPersistence().update(intTravelStandardNewPremi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static IntTravelStandardNewPremi update(
		IntTravelStandardNewPremi intTravelStandardNewPremi,
		ServiceContext serviceContext) {

		return getPersistence().update(
			intTravelStandardNewPremi, serviceContext);
	}

	/**
	 * Returns the int travel standard new premi where travelType = &#63; and packageType = &#63; and peopleType = &#63; and currency = &#63; and mainInsured = &#63; and spouse = &#63; and child = &#63; or throws a <code>NoSuchIntTravelStandardNewPremiException</code> if it could not be found.
	 *
	 * @param travelType the travel type
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param mainInsured the main insured
	 * @param spouse the spouse
	 * @param child the child
	 * @return the matching int travel standard new premi
	 * @throws NoSuchIntTravelStandardNewPremiException if a matching int travel standard new premi could not be found
	 */
	public static IntTravelStandardNewPremi findBySpecificPremi(
			String travelType, String packageType, String peopleType,
			String currency, int mainInsured, int spouse, int child)
		throws com.mypage.admin.product.exception.
			NoSuchIntTravelStandardNewPremiException {

		return getPersistence().findBySpecificPremi(
			travelType, packageType, peopleType, currency, mainInsured, spouse,
			child);
	}

	/**
	 * Returns the int travel standard new premi where travelType = &#63; and packageType = &#63; and peopleType = &#63; and currency = &#63; and mainInsured = &#63; and spouse = &#63; and child = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param travelType the travel type
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param mainInsured the main insured
	 * @param spouse the spouse
	 * @param child the child
	 * @return the matching int travel standard new premi, or <code>null</code> if a matching int travel standard new premi could not be found
	 */
	public static IntTravelStandardNewPremi fetchBySpecificPremi(
		String travelType, String packageType, String peopleType,
		String currency, int mainInsured, int spouse, int child) {

		return getPersistence().fetchBySpecificPremi(
			travelType, packageType, peopleType, currency, mainInsured, spouse,
			child);
	}

	/**
	 * Returns the int travel standard new premi where travelType = &#63; and packageType = &#63; and peopleType = &#63; and currency = &#63; and mainInsured = &#63; and spouse = &#63; and child = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param travelType the travel type
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param mainInsured the main insured
	 * @param spouse the spouse
	 * @param child the child
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching int travel standard new premi, or <code>null</code> if a matching int travel standard new premi could not be found
	 */
	public static IntTravelStandardNewPremi fetchBySpecificPremi(
		String travelType, String packageType, String peopleType,
		String currency, int mainInsured, int spouse, int child,
		boolean useFinderCache) {

		return getPersistence().fetchBySpecificPremi(
			travelType, packageType, peopleType, currency, mainInsured, spouse,
			child, useFinderCache);
	}

	/**
	 * Removes the int travel standard new premi where travelType = &#63; and packageType = &#63; and peopleType = &#63; and currency = &#63; and mainInsured = &#63; and spouse = &#63; and child = &#63; from the database.
	 *
	 * @param travelType the travel type
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param mainInsured the main insured
	 * @param spouse the spouse
	 * @param child the child
	 * @return the int travel standard new premi that was removed
	 */
	public static IntTravelStandardNewPremi removeBySpecificPremi(
			String travelType, String packageType, String peopleType,
			String currency, int mainInsured, int spouse, int child)
		throws com.mypage.admin.product.exception.
			NoSuchIntTravelStandardNewPremiException {

		return getPersistence().removeBySpecificPremi(
			travelType, packageType, peopleType, currency, mainInsured, spouse,
			child);
	}

	/**
	 * Returns the number of int travel standard new premis where travelType = &#63; and packageType = &#63; and peopleType = &#63; and currency = &#63; and mainInsured = &#63; and spouse = &#63; and child = &#63;.
	 *
	 * @param travelType the travel type
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param mainInsured the main insured
	 * @param spouse the spouse
	 * @param child the child
	 * @return the number of matching int travel standard new premis
	 */
	public static int countBySpecificPremi(
		String travelType, String packageType, String peopleType,
		String currency, int mainInsured, int spouse, int child) {

		return getPersistence().countBySpecificPremi(
			travelType, packageType, peopleType, currency, mainInsured, spouse,
			child);
	}

	/**
	 * Caches the int travel standard new premi in the entity cache if it is enabled.
	 *
	 * @param intTravelStandardNewPremi the int travel standard new premi
	 */
	public static void cacheResult(
		IntTravelStandardNewPremi intTravelStandardNewPremi) {

		getPersistence().cacheResult(intTravelStandardNewPremi);
	}

	/**
	 * Caches the int travel standard new premis in the entity cache if it is enabled.
	 *
	 * @param intTravelStandardNewPremis the int travel standard new premis
	 */
	public static void cacheResult(
		List<IntTravelStandardNewPremi> intTravelStandardNewPremis) {

		getPersistence().cacheResult(intTravelStandardNewPremis);
	}

	/**
	 * Creates a new int travel standard new premi with the primary key. Does not add the int travel standard new premi to the database.
	 *
	 * @param intTravelStandardNewPremiId the primary key for the new int travel standard new premi
	 * @return the new int travel standard new premi
	 */
	public static IntTravelStandardNewPremi create(
		long intTravelStandardNewPremiId) {

		return getPersistence().create(intTravelStandardNewPremiId);
	}

	/**
	 * Removes the int travel standard new premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param intTravelStandardNewPremiId the primary key of the int travel standard new premi
	 * @return the int travel standard new premi that was removed
	 * @throws NoSuchIntTravelStandardNewPremiException if a int travel standard new premi with the primary key could not be found
	 */
	public static IntTravelStandardNewPremi remove(
			long intTravelStandardNewPremiId)
		throws com.mypage.admin.product.exception.
			NoSuchIntTravelStandardNewPremiException {

		return getPersistence().remove(intTravelStandardNewPremiId);
	}

	public static IntTravelStandardNewPremi updateImpl(
		IntTravelStandardNewPremi intTravelStandardNewPremi) {

		return getPersistence().updateImpl(intTravelStandardNewPremi);
	}

	/**
	 * Returns the int travel standard new premi with the primary key or throws a <code>NoSuchIntTravelStandardNewPremiException</code> if it could not be found.
	 *
	 * @param intTravelStandardNewPremiId the primary key of the int travel standard new premi
	 * @return the int travel standard new premi
	 * @throws NoSuchIntTravelStandardNewPremiException if a int travel standard new premi with the primary key could not be found
	 */
	public static IntTravelStandardNewPremi findByPrimaryKey(
			long intTravelStandardNewPremiId)
		throws com.mypage.admin.product.exception.
			NoSuchIntTravelStandardNewPremiException {

		return getPersistence().findByPrimaryKey(intTravelStandardNewPremiId);
	}

	/**
	 * Returns the int travel standard new premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param intTravelStandardNewPremiId the primary key of the int travel standard new premi
	 * @return the int travel standard new premi, or <code>null</code> if a int travel standard new premi with the primary key could not be found
	 */
	public static IntTravelStandardNewPremi fetchByPrimaryKey(
		long intTravelStandardNewPremiId) {

		return getPersistence().fetchByPrimaryKey(intTravelStandardNewPremiId);
	}

	/**
	 * Returns all the int travel standard new premis.
	 *
	 * @return the int travel standard new premis
	 */
	public static List<IntTravelStandardNewPremi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the int travel standard new premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IntTravelStandardNewPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of int travel standard new premis
	 * @param end the upper bound of the range of int travel standard new premis (not inclusive)
	 * @return the range of int travel standard new premis
	 */
	public static List<IntTravelStandardNewPremi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the int travel standard new premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IntTravelStandardNewPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of int travel standard new premis
	 * @param end the upper bound of the range of int travel standard new premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of int travel standard new premis
	 */
	public static List<IntTravelStandardNewPremi> findAll(
		int start, int end,
		OrderByComparator<IntTravelStandardNewPremi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the int travel standard new premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IntTravelStandardNewPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of int travel standard new premis
	 * @param end the upper bound of the range of int travel standard new premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of int travel standard new premis
	 */
	public static List<IntTravelStandardNewPremi> findAll(
		int start, int end,
		OrderByComparator<IntTravelStandardNewPremi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the int travel standard new premis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of int travel standard new premis.
	 *
	 * @return the number of int travel standard new premis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static IntTravelStandardNewPremiPersistence getPersistence() {
		return _persistence;
	}

	private static volatile IntTravelStandardNewPremiPersistence _persistence;

}