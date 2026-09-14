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

import com.mypage.admin.product.model.ReferenceNumber;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the reference number service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.ReferenceNumberPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see ReferenceNumberPersistence
 * @generated
 */
public class ReferenceNumberUtil {

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
	public static void clearCache(ReferenceNumber referenceNumber) {
		getPersistence().clearCache(referenceNumber);
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
	public static Map<Serializable, ReferenceNumber> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ReferenceNumber> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ReferenceNumber> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ReferenceNumber> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ReferenceNumber> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ReferenceNumber update(ReferenceNumber referenceNumber) {
		return getPersistence().update(referenceNumber);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ReferenceNumber update(
		ReferenceNumber referenceNumber, ServiceContext serviceContext) {

		return getPersistence().update(referenceNumber, serviceContext);
	}

	/**
	 * Returns the reference number where userRole = &#63; and channel = &#63; and type = &#63; and productCode = &#63; and businessType = &#63; and currency = &#63; or throws a <code>NoSuchReferenceNumberException</code> if it could not be found.
	 *
	 * @param userRole the user role
	 * @param channel the channel
	 * @param type the type
	 * @param productCode the product code
	 * @param businessType the business type
	 * @param currency the currency
	 * @return the matching reference number
	 * @throws NoSuchReferenceNumberException if a matching reference number could not be found
	 */
	public static ReferenceNumber findBysearchReferenceNumber(
			String userRole, String channel, String type, String productCode,
			String businessType, String currency)
		throws com.mypage.admin.product.exception.
			NoSuchReferenceNumberException {

		return getPersistence().findBysearchReferenceNumber(
			userRole, channel, type, productCode, businessType, currency);
	}

	/**
	 * Returns the reference number where userRole = &#63; and channel = &#63; and type = &#63; and productCode = &#63; and businessType = &#63; and currency = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userRole the user role
	 * @param channel the channel
	 * @param type the type
	 * @param productCode the product code
	 * @param businessType the business type
	 * @param currency the currency
	 * @return the matching reference number, or <code>null</code> if a matching reference number could not be found
	 */
	public static ReferenceNumber fetchBysearchReferenceNumber(
		String userRole, String channel, String type, String productCode,
		String businessType, String currency) {

		return getPersistence().fetchBysearchReferenceNumber(
			userRole, channel, type, productCode, businessType, currency);
	}

	/**
	 * Returns the reference number where userRole = &#63; and channel = &#63; and type = &#63; and productCode = &#63; and businessType = &#63; and currency = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userRole the user role
	 * @param channel the channel
	 * @param type the type
	 * @param productCode the product code
	 * @param businessType the business type
	 * @param currency the currency
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching reference number, or <code>null</code> if a matching reference number could not be found
	 */
	public static ReferenceNumber fetchBysearchReferenceNumber(
		String userRole, String channel, String type, String productCode,
		String businessType, String currency, boolean useFinderCache) {

		return getPersistence().fetchBysearchReferenceNumber(
			userRole, channel, type, productCode, businessType, currency,
			useFinderCache);
	}

	/**
	 * Removes the reference number where userRole = &#63; and channel = &#63; and type = &#63; and productCode = &#63; and businessType = &#63; and currency = &#63; from the database.
	 *
	 * @param userRole the user role
	 * @param channel the channel
	 * @param type the type
	 * @param productCode the product code
	 * @param businessType the business type
	 * @param currency the currency
	 * @return the reference number that was removed
	 */
	public static ReferenceNumber removeBysearchReferenceNumber(
			String userRole, String channel, String type, String productCode,
			String businessType, String currency)
		throws com.mypage.admin.product.exception.
			NoSuchReferenceNumberException {

		return getPersistence().removeBysearchReferenceNumber(
			userRole, channel, type, productCode, businessType, currency);
	}

	/**
	 * Returns the number of reference numbers where userRole = &#63; and channel = &#63; and type = &#63; and productCode = &#63; and businessType = &#63; and currency = &#63;.
	 *
	 * @param userRole the user role
	 * @param channel the channel
	 * @param type the type
	 * @param productCode the product code
	 * @param businessType the business type
	 * @param currency the currency
	 * @return the number of matching reference numbers
	 */
	public static int countBysearchReferenceNumber(
		String userRole, String channel, String type, String productCode,
		String businessType, String currency) {

		return getPersistence().countBysearchReferenceNumber(
			userRole, channel, type, productCode, businessType, currency);
	}

	/**
	 * Caches the reference number in the entity cache if it is enabled.
	 *
	 * @param referenceNumber the reference number
	 */
	public static void cacheResult(ReferenceNumber referenceNumber) {
		getPersistence().cacheResult(referenceNumber);
	}

	/**
	 * Caches the reference numbers in the entity cache if it is enabled.
	 *
	 * @param referenceNumbers the reference numbers
	 */
	public static void cacheResult(List<ReferenceNumber> referenceNumbers) {
		getPersistence().cacheResult(referenceNumbers);
	}

	/**
	 * Creates a new reference number with the primary key. Does not add the reference number to the database.
	 *
	 * @param referenceNumberId the primary key for the new reference number
	 * @return the new reference number
	 */
	public static ReferenceNumber create(long referenceNumberId) {
		return getPersistence().create(referenceNumberId);
	}

	/**
	 * Removes the reference number with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param referenceNumberId the primary key of the reference number
	 * @return the reference number that was removed
	 * @throws NoSuchReferenceNumberException if a reference number with the primary key could not be found
	 */
	public static ReferenceNumber remove(long referenceNumberId)
		throws com.mypage.admin.product.exception.
			NoSuchReferenceNumberException {

		return getPersistence().remove(referenceNumberId);
	}

	public static ReferenceNumber updateImpl(ReferenceNumber referenceNumber) {
		return getPersistence().updateImpl(referenceNumber);
	}

	/**
	 * Returns the reference number with the primary key or throws a <code>NoSuchReferenceNumberException</code> if it could not be found.
	 *
	 * @param referenceNumberId the primary key of the reference number
	 * @return the reference number
	 * @throws NoSuchReferenceNumberException if a reference number with the primary key could not be found
	 */
	public static ReferenceNumber findByPrimaryKey(long referenceNumberId)
		throws com.mypage.admin.product.exception.
			NoSuchReferenceNumberException {

		return getPersistence().findByPrimaryKey(referenceNumberId);
	}

	/**
	 * Returns the reference number with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param referenceNumberId the primary key of the reference number
	 * @return the reference number, or <code>null</code> if a reference number with the primary key could not be found
	 */
	public static ReferenceNumber fetchByPrimaryKey(long referenceNumberId) {
		return getPersistence().fetchByPrimaryKey(referenceNumberId);
	}

	/**
	 * Returns all the reference numbers.
	 *
	 * @return the reference numbers
	 */
	public static List<ReferenceNumber> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the reference numbers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceNumberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference numbers
	 * @param end the upper bound of the range of reference numbers (not inclusive)
	 * @return the range of reference numbers
	 */
	public static List<ReferenceNumber> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the reference numbers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceNumberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference numbers
	 * @param end the upper bound of the range of reference numbers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of reference numbers
	 */
	public static List<ReferenceNumber> findAll(
		int start, int end,
		OrderByComparator<ReferenceNumber> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the reference numbers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceNumberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference numbers
	 * @param end the upper bound of the range of reference numbers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of reference numbers
	 */
	public static List<ReferenceNumber> findAll(
		int start, int end,
		OrderByComparator<ReferenceNumber> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the reference numbers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of reference numbers.
	 *
	 * @return the number of reference numbers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ReferenceNumberPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ReferenceNumberPersistence _persistence;

}