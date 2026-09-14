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

import com.mypage.admin.product.model.TravelDomesticInsuredType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the travel domestic insured type service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.TravelDomesticInsuredTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticInsuredTypePersistence
 * @generated
 */
public class TravelDomesticInsuredTypeUtil {

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
		TravelDomesticInsuredType travelDomesticInsuredType) {

		getPersistence().clearCache(travelDomesticInsuredType);
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
	public static Map<Serializable, TravelDomesticInsuredType>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TravelDomesticInsuredType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TravelDomesticInsuredType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TravelDomesticInsuredType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TravelDomesticInsuredType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TravelDomesticInsuredType update(
		TravelDomesticInsuredType travelDomesticInsuredType) {

		return getPersistence().update(travelDomesticInsuredType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TravelDomesticInsuredType update(
		TravelDomesticInsuredType travelDomesticInsuredType,
		ServiceContext serviceContext) {

		return getPersistence().update(
			travelDomesticInsuredType, serviceContext);
	}

	/**
	 * Returns all the travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @return the matching travel domestic insured types
	 */
	public static List<TravelDomesticInsuredType> findBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code) {

		return getPersistence().findBysearchInsuredType(
			travelDomesticInsuredTypeId, name, code);
	}

	/**
	 * Returns a range of all the travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @return the range of matching travel domestic insured types
	 */
	public static List<TravelDomesticInsuredType> findBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code, int start,
		int end) {

		return getPersistence().findBysearchInsuredType(
			travelDomesticInsuredTypeId, name, code, start, end);
	}

	/**
	 * Returns an ordered range of all the travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic insured types
	 */
	public static List<TravelDomesticInsuredType> findBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code, int start,
		int end,
		OrderByComparator<TravelDomesticInsuredType> orderByComparator) {

		return getPersistence().findBysearchInsuredType(
			travelDomesticInsuredTypeId, name, code, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic insured types
	 */
	public static List<TravelDomesticInsuredType> findBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code, int start,
		int end, OrderByComparator<TravelDomesticInsuredType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchInsuredType(
			travelDomesticInsuredTypeId, name, code, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first travel domestic insured type in the ordered set where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic insured type
	 * @throws NoSuchTravelDomesticInsuredTypeException if a matching travel domestic insured type could not be found
	 */
	public static TravelDomesticInsuredType findBysearchInsuredType_First(
			long travelDomesticInsuredTypeId, String name, String code,
			OrderByComparator<TravelDomesticInsuredType> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticInsuredTypeException {

		return getPersistence().findBysearchInsuredType_First(
			travelDomesticInsuredTypeId, name, code, orderByComparator);
	}

	/**
	 * Returns the first travel domestic insured type in the ordered set where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic insured type, or <code>null</code> if a matching travel domestic insured type could not be found
	 */
	public static TravelDomesticInsuredType fetchBysearchInsuredType_First(
		long travelDomesticInsuredTypeId, String name, String code,
		OrderByComparator<TravelDomesticInsuredType> orderByComparator) {

		return getPersistence().fetchBysearchInsuredType_First(
			travelDomesticInsuredTypeId, name, code, orderByComparator);
	}

	/**
	 * Returns the last travel domestic insured type in the ordered set where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic insured type
	 * @throws NoSuchTravelDomesticInsuredTypeException if a matching travel domestic insured type could not be found
	 */
	public static TravelDomesticInsuredType findBysearchInsuredType_Last(
			long travelDomesticInsuredTypeId, String name, String code,
			OrderByComparator<TravelDomesticInsuredType> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticInsuredTypeException {

		return getPersistence().findBysearchInsuredType_Last(
			travelDomesticInsuredTypeId, name, code, orderByComparator);
	}

	/**
	 * Returns the last travel domestic insured type in the ordered set where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic insured type, or <code>null</code> if a matching travel domestic insured type could not be found
	 */
	public static TravelDomesticInsuredType fetchBysearchInsuredType_Last(
		long travelDomesticInsuredTypeId, String name, String code,
		OrderByComparator<TravelDomesticInsuredType> orderByComparator) {

		return getPersistence().fetchBysearchInsuredType_Last(
			travelDomesticInsuredTypeId, name, code, orderByComparator);
	}

	/**
	 * Removes all the travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63; from the database.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 */
	public static void removeBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code) {

		getPersistence().removeBysearchInsuredType(
			travelDomesticInsuredTypeId, name, code);
	}

	/**
	 * Returns the number of travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @return the number of matching travel domestic insured types
	 */
	public static int countBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code) {

		return getPersistence().countBysearchInsuredType(
			travelDomesticInsuredTypeId, name, code);
	}

	/**
	 * Caches the travel domestic insured type in the entity cache if it is enabled.
	 *
	 * @param travelDomesticInsuredType the travel domestic insured type
	 */
	public static void cacheResult(
		TravelDomesticInsuredType travelDomesticInsuredType) {

		getPersistence().cacheResult(travelDomesticInsuredType);
	}

	/**
	 * Caches the travel domestic insured types in the entity cache if it is enabled.
	 *
	 * @param travelDomesticInsuredTypes the travel domestic insured types
	 */
	public static void cacheResult(
		List<TravelDomesticInsuredType> travelDomesticInsuredTypes) {

		getPersistence().cacheResult(travelDomesticInsuredTypes);
	}

	/**
	 * Creates a new travel domestic insured type with the primary key. Does not add the travel domestic insured type to the database.
	 *
	 * @param travelDomesticInsuredTypeId the primary key for the new travel domestic insured type
	 * @return the new travel domestic insured type
	 */
	public static TravelDomesticInsuredType create(
		long travelDomesticInsuredTypeId) {

		return getPersistence().create(travelDomesticInsuredTypeId);
	}

	/**
	 * Removes the travel domestic insured type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticInsuredTypeId the primary key of the travel domestic insured type
	 * @return the travel domestic insured type that was removed
	 * @throws NoSuchTravelDomesticInsuredTypeException if a travel domestic insured type with the primary key could not be found
	 */
	public static TravelDomesticInsuredType remove(
			long travelDomesticInsuredTypeId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticInsuredTypeException {

		return getPersistence().remove(travelDomesticInsuredTypeId);
	}

	public static TravelDomesticInsuredType updateImpl(
		TravelDomesticInsuredType travelDomesticInsuredType) {

		return getPersistence().updateImpl(travelDomesticInsuredType);
	}

	/**
	 * Returns the travel domestic insured type with the primary key or throws a <code>NoSuchTravelDomesticInsuredTypeException</code> if it could not be found.
	 *
	 * @param travelDomesticInsuredTypeId the primary key of the travel domestic insured type
	 * @return the travel domestic insured type
	 * @throws NoSuchTravelDomesticInsuredTypeException if a travel domestic insured type with the primary key could not be found
	 */
	public static TravelDomesticInsuredType findByPrimaryKey(
			long travelDomesticInsuredTypeId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelDomesticInsuredTypeException {

		return getPersistence().findByPrimaryKey(travelDomesticInsuredTypeId);
	}

	/**
	 * Returns the travel domestic insured type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticInsuredTypeId the primary key of the travel domestic insured type
	 * @return the travel domestic insured type, or <code>null</code> if a travel domestic insured type with the primary key could not be found
	 */
	public static TravelDomesticInsuredType fetchByPrimaryKey(
		long travelDomesticInsuredTypeId) {

		return getPersistence().fetchByPrimaryKey(travelDomesticInsuredTypeId);
	}

	/**
	 * Returns all the travel domestic insured types.
	 *
	 * @return the travel domestic insured types
	 */
	public static List<TravelDomesticInsuredType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the travel domestic insured types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @return the range of travel domestic insured types
	 */
	public static List<TravelDomesticInsuredType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the travel domestic insured types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic insured types
	 */
	public static List<TravelDomesticInsuredType> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticInsuredType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel domestic insured types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic insured types
	 */
	public static List<TravelDomesticInsuredType> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticInsuredType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the travel domestic insured types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of travel domestic insured types.
	 *
	 * @return the number of travel domestic insured types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TravelDomesticInsuredTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile TravelDomesticInsuredTypePersistence _persistence;

}