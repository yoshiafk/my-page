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

import com.mypage.admin.product.model.TravelIntBenefitValue;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the travel int benefit value service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.TravelIntBenefitValuePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelIntBenefitValuePersistence
 * @generated
 */
public class TravelIntBenefitValueUtil {

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
	public static void clearCache(TravelIntBenefitValue travelIntBenefitValue) {
		getPersistence().clearCache(travelIntBenefitValue);
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
	public static Map<Serializable, TravelIntBenefitValue> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TravelIntBenefitValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TravelIntBenefitValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TravelIntBenefitValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TravelIntBenefitValue> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TravelIntBenefitValue update(
		TravelIntBenefitValue travelIntBenefitValue) {

		return getPersistence().update(travelIntBenefitValue);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TravelIntBenefitValue update(
		TravelIntBenefitValue travelIntBenefitValue,
		ServiceContext serviceContext) {

		return getPersistence().update(travelIntBenefitValue, serviceContext);
	}

	/**
	 * Returns all the travel int benefit values where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @return the matching travel int benefit values
	 */
	public static List<TravelIntBenefitValue> findByPackageType(
		String packageType) {

		return getPersistence().findByPackageType(packageType);
	}

	/**
	 * Returns a range of all the travel int benefit values where packageType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param packageType the package type
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @return the range of matching travel int benefit values
	 */
	public static List<TravelIntBenefitValue> findByPackageType(
		String packageType, int start, int end) {

		return getPersistence().findByPackageType(packageType, start, end);
	}

	/**
	 * Returns an ordered range of all the travel int benefit values where packageType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param packageType the package type
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel int benefit values
	 */
	public static List<TravelIntBenefitValue> findByPackageType(
		String packageType, int start, int end,
		OrderByComparator<TravelIntBenefitValue> orderByComparator) {

		return getPersistence().findByPackageType(
			packageType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel int benefit values where packageType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param packageType the package type
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel int benefit values
	 */
	public static List<TravelIntBenefitValue> findByPackageType(
		String packageType, int start, int end,
		OrderByComparator<TravelIntBenefitValue> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPackageType(
			packageType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first travel int benefit value in the ordered set where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel int benefit value
	 * @throws NoSuchTravelIntBenefitValueException if a matching travel int benefit value could not be found
	 */
	public static TravelIntBenefitValue findByPackageType_First(
			String packageType,
			OrderByComparator<TravelIntBenefitValue> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelIntBenefitValueException {

		return getPersistence().findByPackageType_First(
			packageType, orderByComparator);
	}

	/**
	 * Returns the first travel int benefit value in the ordered set where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel int benefit value, or <code>null</code> if a matching travel int benefit value could not be found
	 */
	public static TravelIntBenefitValue fetchByPackageType_First(
		String packageType,
		OrderByComparator<TravelIntBenefitValue> orderByComparator) {

		return getPersistence().fetchByPackageType_First(
			packageType, orderByComparator);
	}

	/**
	 * Returns the last travel int benefit value in the ordered set where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel int benefit value
	 * @throws NoSuchTravelIntBenefitValueException if a matching travel int benefit value could not be found
	 */
	public static TravelIntBenefitValue findByPackageType_Last(
			String packageType,
			OrderByComparator<TravelIntBenefitValue> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelIntBenefitValueException {

		return getPersistence().findByPackageType_Last(
			packageType, orderByComparator);
	}

	/**
	 * Returns the last travel int benefit value in the ordered set where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel int benefit value, or <code>null</code> if a matching travel int benefit value could not be found
	 */
	public static TravelIntBenefitValue fetchByPackageType_Last(
		String packageType,
		OrderByComparator<TravelIntBenefitValue> orderByComparator) {

		return getPersistence().fetchByPackageType_Last(
			packageType, orderByComparator);
	}

	/**
	 * Returns the travel int benefit values before and after the current travel int benefit value in the ordered set where packageType = &#63;.
	 *
	 * @param travelIntBenefitValueId the primary key of the current travel int benefit value
	 * @param packageType the package type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel int benefit value
	 * @throws NoSuchTravelIntBenefitValueException if a travel int benefit value with the primary key could not be found
	 */
	public static TravelIntBenefitValue[] findByPackageType_PrevAndNext(
			long travelIntBenefitValueId, String packageType,
			OrderByComparator<TravelIntBenefitValue> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelIntBenefitValueException {

		return getPersistence().findByPackageType_PrevAndNext(
			travelIntBenefitValueId, packageType, orderByComparator);
	}

	/**
	 * Removes all the travel int benefit values where packageType = &#63; from the database.
	 *
	 * @param packageType the package type
	 */
	public static void removeByPackageType(String packageType) {
		getPersistence().removeByPackageType(packageType);
	}

	/**
	 * Returns the number of travel int benefit values where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @return the number of matching travel int benefit values
	 */
	public static int countByPackageType(String packageType) {
		return getPersistence().countByPackageType(packageType);
	}

	/**
	 * Caches the travel int benefit value in the entity cache if it is enabled.
	 *
	 * @param travelIntBenefitValue the travel int benefit value
	 */
	public static void cacheResult(
		TravelIntBenefitValue travelIntBenefitValue) {

		getPersistence().cacheResult(travelIntBenefitValue);
	}

	/**
	 * Caches the travel int benefit values in the entity cache if it is enabled.
	 *
	 * @param travelIntBenefitValues the travel int benefit values
	 */
	public static void cacheResult(
		List<TravelIntBenefitValue> travelIntBenefitValues) {

		getPersistence().cacheResult(travelIntBenefitValues);
	}

	/**
	 * Creates a new travel int benefit value with the primary key. Does not add the travel int benefit value to the database.
	 *
	 * @param travelIntBenefitValueId the primary key for the new travel int benefit value
	 * @return the new travel int benefit value
	 */
	public static TravelIntBenefitValue create(long travelIntBenefitValueId) {
		return getPersistence().create(travelIntBenefitValueId);
	}

	/**
	 * Removes the travel int benefit value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelIntBenefitValueId the primary key of the travel int benefit value
	 * @return the travel int benefit value that was removed
	 * @throws NoSuchTravelIntBenefitValueException if a travel int benefit value with the primary key could not be found
	 */
	public static TravelIntBenefitValue remove(long travelIntBenefitValueId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelIntBenefitValueException {

		return getPersistence().remove(travelIntBenefitValueId);
	}

	public static TravelIntBenefitValue updateImpl(
		TravelIntBenefitValue travelIntBenefitValue) {

		return getPersistence().updateImpl(travelIntBenefitValue);
	}

	/**
	 * Returns the travel int benefit value with the primary key or throws a <code>NoSuchTravelIntBenefitValueException</code> if it could not be found.
	 *
	 * @param travelIntBenefitValueId the primary key of the travel int benefit value
	 * @return the travel int benefit value
	 * @throws NoSuchTravelIntBenefitValueException if a travel int benefit value with the primary key could not be found
	 */
	public static TravelIntBenefitValue findByPrimaryKey(
			long travelIntBenefitValueId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelIntBenefitValueException {

		return getPersistence().findByPrimaryKey(travelIntBenefitValueId);
	}

	/**
	 * Returns the travel int benefit value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelIntBenefitValueId the primary key of the travel int benefit value
	 * @return the travel int benefit value, or <code>null</code> if a travel int benefit value with the primary key could not be found
	 */
	public static TravelIntBenefitValue fetchByPrimaryKey(
		long travelIntBenefitValueId) {

		return getPersistence().fetchByPrimaryKey(travelIntBenefitValueId);
	}

	/**
	 * Returns all the travel int benefit values.
	 *
	 * @return the travel int benefit values
	 */
	public static List<TravelIntBenefitValue> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the travel int benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @return the range of travel int benefit values
	 */
	public static List<TravelIntBenefitValue> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the travel int benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel int benefit values
	 */
	public static List<TravelIntBenefitValue> findAll(
		int start, int end,
		OrderByComparator<TravelIntBenefitValue> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel int benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel int benefit values
	 */
	public static List<TravelIntBenefitValue> findAll(
		int start, int end,
		OrderByComparator<TravelIntBenefitValue> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the travel int benefit values from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of travel int benefit values.
	 *
	 * @return the number of travel int benefit values
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TravelIntBenefitValuePersistence getPersistence() {
		return _persistence;
	}

	private static volatile TravelIntBenefitValuePersistence _persistence;

}