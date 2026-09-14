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

package com.mypage.user.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.user.model.CreditType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the credit type service. This utility wraps <code>com.mypage.user.service.persistence.impl.CreditTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CreditTypePersistence
 * @generated
 */
public class CreditTypeUtil {

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
	public static void clearCache(CreditType creditType) {
		getPersistence().clearCache(creditType);
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
	public static Map<Serializable, CreditType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CreditType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CreditType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CreditType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CreditType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CreditType update(CreditType creditType) {
		return getPersistence().update(creditType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CreditType update(
		CreditType creditType, ServiceContext serviceContext) {

		return getPersistence().update(creditType, serviceContext);
	}

	/**
	 * Returns the credit type where mypageUserId = &#63; or throws a <code>NoSuchCreditTypeException</code> if it could not be found.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching credit type
	 * @throws NoSuchCreditTypeException if a matching credit type could not be found
	 */
	public static CreditType findBygetByMypageUserId(long mypageUserId)
		throws com.mypage.user.exception.NoSuchCreditTypeException {

		return getPersistence().findBygetByMypageUserId(mypageUserId);
	}

	/**
	 * Returns the credit type where mypageUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching credit type, or <code>null</code> if a matching credit type could not be found
	 */
	public static CreditType fetchBygetByMypageUserId(long mypageUserId) {
		return getPersistence().fetchBygetByMypageUserId(mypageUserId);
	}

	/**
	 * Returns the credit type where mypageUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching credit type, or <code>null</code> if a matching credit type could not be found
	 */
	public static CreditType fetchBygetByMypageUserId(
		long mypageUserId, boolean useFinderCache) {

		return getPersistence().fetchBygetByMypageUserId(
			mypageUserId, useFinderCache);
	}

	/**
	 * Removes the credit type where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the credit type that was removed
	 */
	public static CreditType removeBygetByMypageUserId(long mypageUserId)
		throws com.mypage.user.exception.NoSuchCreditTypeException {

		return getPersistence().removeBygetByMypageUserId(mypageUserId);
	}

	/**
	 * Returns the number of credit types where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching credit types
	 */
	public static int countBygetByMypageUserId(long mypageUserId) {
		return getPersistence().countBygetByMypageUserId(mypageUserId);
	}

	/**
	 * Caches the credit type in the entity cache if it is enabled.
	 *
	 * @param creditType the credit type
	 */
	public static void cacheResult(CreditType creditType) {
		getPersistence().cacheResult(creditType);
	}

	/**
	 * Caches the credit types in the entity cache if it is enabled.
	 *
	 * @param creditTypes the credit types
	 */
	public static void cacheResult(List<CreditType> creditTypes) {
		getPersistence().cacheResult(creditTypes);
	}

	/**
	 * Creates a new credit type with the primary key. Does not add the credit type to the database.
	 *
	 * @param creditTypeId the primary key for the new credit type
	 * @return the new credit type
	 */
	public static CreditType create(long creditTypeId) {
		return getPersistence().create(creditTypeId);
	}

	/**
	 * Removes the credit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creditTypeId the primary key of the credit type
	 * @return the credit type that was removed
	 * @throws NoSuchCreditTypeException if a credit type with the primary key could not be found
	 */
	public static CreditType remove(long creditTypeId)
		throws com.mypage.user.exception.NoSuchCreditTypeException {

		return getPersistence().remove(creditTypeId);
	}

	public static CreditType updateImpl(CreditType creditType) {
		return getPersistence().updateImpl(creditType);
	}

	/**
	 * Returns the credit type with the primary key or throws a <code>NoSuchCreditTypeException</code> if it could not be found.
	 *
	 * @param creditTypeId the primary key of the credit type
	 * @return the credit type
	 * @throws NoSuchCreditTypeException if a credit type with the primary key could not be found
	 */
	public static CreditType findByPrimaryKey(long creditTypeId)
		throws com.mypage.user.exception.NoSuchCreditTypeException {

		return getPersistence().findByPrimaryKey(creditTypeId);
	}

	/**
	 * Returns the credit type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param creditTypeId the primary key of the credit type
	 * @return the credit type, or <code>null</code> if a credit type with the primary key could not be found
	 */
	public static CreditType fetchByPrimaryKey(long creditTypeId) {
		return getPersistence().fetchByPrimaryKey(creditTypeId);
	}

	/**
	 * Returns all the credit types.
	 *
	 * @return the credit types
	 */
	public static List<CreditType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the credit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit types
	 * @param end the upper bound of the range of credit types (not inclusive)
	 * @return the range of credit types
	 */
	public static List<CreditType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the credit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit types
	 * @param end the upper bound of the range of credit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of credit types
	 */
	public static List<CreditType> findAll(
		int start, int end, OrderByComparator<CreditType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the credit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit types
	 * @param end the upper bound of the range of credit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of credit types
	 */
	public static List<CreditType> findAll(
		int start, int end, OrderByComparator<CreditType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the credit types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of credit types.
	 *
	 * @return the number of credit types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CreditTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile CreditTypePersistence _persistence;

}