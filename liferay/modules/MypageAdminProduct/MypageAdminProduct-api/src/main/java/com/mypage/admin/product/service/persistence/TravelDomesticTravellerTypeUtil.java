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

import com.mypage.admin.product.model.TravelDomesticTravellerType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the travel domestic traveller type service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.TravelDomesticTravellerTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticTravellerTypePersistence
 * @generated
 */
public class TravelDomesticTravellerTypeUtil {

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
		TravelDomesticTravellerType travelDomesticTravellerType) {

		getPersistence().clearCache(travelDomesticTravellerType);
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
	public static Map<Serializable, TravelDomesticTravellerType>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TravelDomesticTravellerType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TravelDomesticTravellerType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TravelDomesticTravellerType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TravelDomesticTravellerType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TravelDomesticTravellerType update(
		TravelDomesticTravellerType travelDomesticTravellerType) {

		return getPersistence().update(travelDomesticTravellerType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TravelDomesticTravellerType update(
		TravelDomesticTravellerType travelDomesticTravellerType,
		ServiceContext serviceContext) {

		return getPersistence().update(
			travelDomesticTravellerType, serviceContext);
	}

	/**
	 * Returns all the travel domestic traveller types where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @return the matching travel domestic traveller types
	 */
	public static List<TravelDomesticTravellerType> findBysearchTravellerTypeId(
		long travellerTypeId) {

		return getPersistence().findBysearchTravellerTypeId(travellerTypeId);
	}

	/**
	 * Returns a range of all the travel domestic traveller types where travellerTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @return the range of matching travel domestic traveller types
	 */
	public static List<TravelDomesticTravellerType> findBysearchTravellerTypeId(
		long travellerTypeId, int start, int end) {

		return getPersistence().findBysearchTravellerTypeId(
			travellerTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the travel domestic traveller types where travellerTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic traveller types
	 */
	public static List<TravelDomesticTravellerType> findBysearchTravellerTypeId(
		long travellerTypeId, int start, int end,
		OrderByComparator<TravelDomesticTravellerType> orderByComparator) {

		return getPersistence().findBysearchTravellerTypeId(
			travellerTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel domestic traveller types where travellerTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic traveller types
	 */
	public static List<TravelDomesticTravellerType> findBysearchTravellerTypeId(
		long travellerTypeId, int start, int end,
		OrderByComparator<TravelDomesticTravellerType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchTravellerTypeId(
			travellerTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first travel domestic traveller type in the ordered set where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic traveller type
	 * @throws NoSuchTravelDomesticTravellerTypeException if a matching travel domestic traveller type could not be found
	 */
	public static TravelDomesticTravellerType findBysearchTravellerTypeId_First(
			long travellerTypeId,
			OrderByComparator<TravelDomesticTravellerType> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticTravellerTypeException {

		return getPersistence().findBysearchTravellerTypeId_First(
			travellerTypeId, orderByComparator);
	}

	/**
	 * Returns the first travel domestic traveller type in the ordered set where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic traveller type, or <code>null</code> if a matching travel domestic traveller type could not be found
	 */
	public static TravelDomesticTravellerType
		fetchBysearchTravellerTypeId_First(
			long travellerTypeId,
			OrderByComparator<TravelDomesticTravellerType> orderByComparator) {

		return getPersistence().fetchBysearchTravellerTypeId_First(
			travellerTypeId, orderByComparator);
	}

	/**
	 * Returns the last travel domestic traveller type in the ordered set where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic traveller type
	 * @throws NoSuchTravelDomesticTravellerTypeException if a matching travel domestic traveller type could not be found
	 */
	public static TravelDomesticTravellerType findBysearchTravellerTypeId_Last(
			long travellerTypeId,
			OrderByComparator<TravelDomesticTravellerType> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticTravellerTypeException {

		return getPersistence().findBysearchTravellerTypeId_Last(
			travellerTypeId, orderByComparator);
	}

	/**
	 * Returns the last travel domestic traveller type in the ordered set where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic traveller type, or <code>null</code> if a matching travel domestic traveller type could not be found
	 */
	public static TravelDomesticTravellerType fetchBysearchTravellerTypeId_Last(
		long travellerTypeId,
		OrderByComparator<TravelDomesticTravellerType> orderByComparator) {

		return getPersistence().fetchBysearchTravellerTypeId_Last(
			travellerTypeId, orderByComparator);
	}

	/**
	 * Removes all the travel domestic traveller types where travellerTypeId = &#63; from the database.
	 *
	 * @param travellerTypeId the traveller type ID
	 */
	public static void removeBysearchTravellerTypeId(long travellerTypeId) {
		getPersistence().removeBysearchTravellerTypeId(travellerTypeId);
	}

	/**
	 * Returns the number of travel domestic traveller types where travellerTypeId = &#63;.
	 *
	 * @param travellerTypeId the traveller type ID
	 * @return the number of matching travel domestic traveller types
	 */
	public static int countBysearchTravellerTypeId(long travellerTypeId) {
		return getPersistence().countBysearchTravellerTypeId(travellerTypeId);
	}

	/**
	 * Caches the travel domestic traveller type in the entity cache if it is enabled.
	 *
	 * @param travelDomesticTravellerType the travel domestic traveller type
	 */
	public static void cacheResult(
		TravelDomesticTravellerType travelDomesticTravellerType) {

		getPersistence().cacheResult(travelDomesticTravellerType);
	}

	/**
	 * Caches the travel domestic traveller types in the entity cache if it is enabled.
	 *
	 * @param travelDomesticTravellerTypes the travel domestic traveller types
	 */
	public static void cacheResult(
		List<TravelDomesticTravellerType> travelDomesticTravellerTypes) {

		getPersistence().cacheResult(travelDomesticTravellerTypes);
	}

	/**
	 * Creates a new travel domestic traveller type with the primary key. Does not add the travel domestic traveller type to the database.
	 *
	 * @param travellerTypeId the primary key for the new travel domestic traveller type
	 * @return the new travel domestic traveller type
	 */
	public static TravelDomesticTravellerType create(long travellerTypeId) {
		return getPersistence().create(travellerTypeId);
	}

	/**
	 * Removes the travel domestic traveller type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travellerTypeId the primary key of the travel domestic traveller type
	 * @return the travel domestic traveller type that was removed
	 * @throws NoSuchTravelDomesticTravellerTypeException if a travel domestic traveller type with the primary key could not be found
	 */
	public static TravelDomesticTravellerType remove(long travellerTypeId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticTravellerTypeException {

		return getPersistence().remove(travellerTypeId);
	}

	public static TravelDomesticTravellerType updateImpl(
		TravelDomesticTravellerType travelDomesticTravellerType) {

		return getPersistence().updateImpl(travelDomesticTravellerType);
	}

	/**
	 * Returns the travel domestic traveller type with the primary key or throws a <code>NoSuchTravelDomesticTravellerTypeException</code> if it could not be found.
	 *
	 * @param travellerTypeId the primary key of the travel domestic traveller type
	 * @return the travel domestic traveller type
	 * @throws NoSuchTravelDomesticTravellerTypeException if a travel domestic traveller type with the primary key could not be found
	 */
	public static TravelDomesticTravellerType findByPrimaryKey(
			long travellerTypeId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticTravellerTypeException {

		return getPersistence().findByPrimaryKey(travellerTypeId);
	}

	/**
	 * Returns the travel domestic traveller type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travellerTypeId the primary key of the travel domestic traveller type
	 * @return the travel domestic traveller type, or <code>null</code> if a travel domestic traveller type with the primary key could not be found
	 */
	public static TravelDomesticTravellerType fetchByPrimaryKey(
		long travellerTypeId) {

		return getPersistence().fetchByPrimaryKey(travellerTypeId);
	}

	/**
	 * Returns all the travel domestic traveller types.
	 *
	 * @return the travel domestic traveller types
	 */
	public static List<TravelDomesticTravellerType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the travel domestic traveller types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @return the range of travel domestic traveller types
	 */
	public static List<TravelDomesticTravellerType> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the travel domestic traveller types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic traveller types
	 */
	public static List<TravelDomesticTravellerType> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticTravellerType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel domestic traveller types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic traveller types
	 */
	public static List<TravelDomesticTravellerType> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticTravellerType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the travel domestic traveller types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of travel domestic traveller types.
	 *
	 * @return the number of travel domestic traveller types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TravelDomesticTravellerTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile TravelDomesticTravellerTypePersistence _persistence;

}