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

import com.mypage.admin.product.model.SmartActiveOccupation;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the smart active occupation service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.SmartActiveOccupationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveOccupationPersistence
 * @generated
 */
public class SmartActiveOccupationUtil {

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
	public static void clearCache(SmartActiveOccupation smartActiveOccupation) {
		getPersistence().clearCache(smartActiveOccupation);
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
	public static Map<Serializable, SmartActiveOccupation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SmartActiveOccupation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SmartActiveOccupation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SmartActiveOccupation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SmartActiveOccupation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SmartActiveOccupation update(
		SmartActiveOccupation smartActiveOccupation) {

		return getPersistence().update(smartActiveOccupation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SmartActiveOccupation update(
		SmartActiveOccupation smartActiveOccupation,
		ServiceContext serviceContext) {

		return getPersistence().update(smartActiveOccupation, serviceContext);
	}

	/**
	 * Returns the smart active occupation where code = &#63; or throws a <code>NoSuchSmartActiveOccupationException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching smart active occupation
	 * @throws NoSuchSmartActiveOccupationException if a matching smart active occupation could not be found
	 */
	public static SmartActiveOccupation findBycode(String code)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveOccupationException {

		return getPersistence().findBycode(code);
	}

	/**
	 * Returns the smart active occupation where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching smart active occupation, or <code>null</code> if a matching smart active occupation could not be found
	 */
	public static SmartActiveOccupation fetchBycode(String code) {
		return getPersistence().fetchBycode(code);
	}

	/**
	 * Returns the smart active occupation where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active occupation, or <code>null</code> if a matching smart active occupation could not be found
	 */
	public static SmartActiveOccupation fetchBycode(
		String code, boolean useFinderCache) {

		return getPersistence().fetchBycode(code, useFinderCache);
	}

	/**
	 * Removes the smart active occupation where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the smart active occupation that was removed
	 */
	public static SmartActiveOccupation removeBycode(String code)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveOccupationException {

		return getPersistence().removeBycode(code);
	}

	/**
	 * Returns the number of smart active occupations where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching smart active occupations
	 */
	public static int countBycode(String code) {
		return getPersistence().countBycode(code);
	}

	/**
	 * Caches the smart active occupation in the entity cache if it is enabled.
	 *
	 * @param smartActiveOccupation the smart active occupation
	 */
	public static void cacheResult(
		SmartActiveOccupation smartActiveOccupation) {

		getPersistence().cacheResult(smartActiveOccupation);
	}

	/**
	 * Caches the smart active occupations in the entity cache if it is enabled.
	 *
	 * @param smartActiveOccupations the smart active occupations
	 */
	public static void cacheResult(
		List<SmartActiveOccupation> smartActiveOccupations) {

		getPersistence().cacheResult(smartActiveOccupations);
	}

	/**
	 * Creates a new smart active occupation with the primary key. Does not add the smart active occupation to the database.
	 *
	 * @param smartActiveOccupationId the primary key for the new smart active occupation
	 * @return the new smart active occupation
	 */
	public static SmartActiveOccupation create(long smartActiveOccupationId) {
		return getPersistence().create(smartActiveOccupationId);
	}

	/**
	 * Removes the smart active occupation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveOccupationId the primary key of the smart active occupation
	 * @return the smart active occupation that was removed
	 * @throws NoSuchSmartActiveOccupationException if a smart active occupation with the primary key could not be found
	 */
	public static SmartActiveOccupation remove(long smartActiveOccupationId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveOccupationException {

		return getPersistence().remove(smartActiveOccupationId);
	}

	public static SmartActiveOccupation updateImpl(
		SmartActiveOccupation smartActiveOccupation) {

		return getPersistence().updateImpl(smartActiveOccupation);
	}

	/**
	 * Returns the smart active occupation with the primary key or throws a <code>NoSuchSmartActiveOccupationException</code> if it could not be found.
	 *
	 * @param smartActiveOccupationId the primary key of the smart active occupation
	 * @return the smart active occupation
	 * @throws NoSuchSmartActiveOccupationException if a smart active occupation with the primary key could not be found
	 */
	public static SmartActiveOccupation findByPrimaryKey(
			long smartActiveOccupationId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveOccupationException {

		return getPersistence().findByPrimaryKey(smartActiveOccupationId);
	}

	/**
	 * Returns the smart active occupation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveOccupationId the primary key of the smart active occupation
	 * @return the smart active occupation, or <code>null</code> if a smart active occupation with the primary key could not be found
	 */
	public static SmartActiveOccupation fetchByPrimaryKey(
		long smartActiveOccupationId) {

		return getPersistence().fetchByPrimaryKey(smartActiveOccupationId);
	}

	/**
	 * Returns all the smart active occupations.
	 *
	 * @return the smart active occupations
	 */
	public static List<SmartActiveOccupation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the smart active occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active occupations
	 * @param end the upper bound of the range of smart active occupations (not inclusive)
	 * @return the range of smart active occupations
	 */
	public static List<SmartActiveOccupation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the smart active occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active occupations
	 * @param end the upper bound of the range of smart active occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active occupations
	 */
	public static List<SmartActiveOccupation> findAll(
		int start, int end,
		OrderByComparator<SmartActiveOccupation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart active occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active occupations
	 * @param end the upper bound of the range of smart active occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active occupations
	 */
	public static List<SmartActiveOccupation> findAll(
		int start, int end,
		OrderByComparator<SmartActiveOccupation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the smart active occupations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of smart active occupations.
	 *
	 * @return the number of smart active occupations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SmartActiveOccupationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SmartActiveOccupationPersistence _persistence;

}