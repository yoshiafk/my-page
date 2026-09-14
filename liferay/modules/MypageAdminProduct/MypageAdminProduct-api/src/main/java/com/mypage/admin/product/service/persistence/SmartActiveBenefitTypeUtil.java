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

import com.mypage.admin.product.model.SmartActiveBenefitType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the smart active benefit type service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.SmartActiveBenefitTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveBenefitTypePersistence
 * @generated
 */
public class SmartActiveBenefitTypeUtil {

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
		SmartActiveBenefitType smartActiveBenefitType) {

		getPersistence().clearCache(smartActiveBenefitType);
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
	public static Map<Serializable, SmartActiveBenefitType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SmartActiveBenefitType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SmartActiveBenefitType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SmartActiveBenefitType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SmartActiveBenefitType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SmartActiveBenefitType update(
		SmartActiveBenefitType smartActiveBenefitType) {

		return getPersistence().update(smartActiveBenefitType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SmartActiveBenefitType update(
		SmartActiveBenefitType smartActiveBenefitType,
		ServiceContext serviceContext) {

		return getPersistence().update(smartActiveBenefitType, serviceContext);
	}

	/**
	 * Caches the smart active benefit type in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefitType the smart active benefit type
	 */
	public static void cacheResult(
		SmartActiveBenefitType smartActiveBenefitType) {

		getPersistence().cacheResult(smartActiveBenefitType);
	}

	/**
	 * Caches the smart active benefit types in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefitTypes the smart active benefit types
	 */
	public static void cacheResult(
		List<SmartActiveBenefitType> smartActiveBenefitTypes) {

		getPersistence().cacheResult(smartActiveBenefitTypes);
	}

	/**
	 * Creates a new smart active benefit type with the primary key. Does not add the smart active benefit type to the database.
	 *
	 * @param smartActiveBenefitTypeId the primary key for the new smart active benefit type
	 * @return the new smart active benefit type
	 */
	public static SmartActiveBenefitType create(long smartActiveBenefitTypeId) {
		return getPersistence().create(smartActiveBenefitTypeId);
	}

	/**
	 * Removes the smart active benefit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveBenefitTypeId the primary key of the smart active benefit type
	 * @return the smart active benefit type that was removed
	 * @throws NoSuchSmartActiveBenefitTypeException if a smart active benefit type with the primary key could not be found
	 */
	public static SmartActiveBenefitType remove(long smartActiveBenefitTypeId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveBenefitTypeException {

		return getPersistence().remove(smartActiveBenefitTypeId);
	}

	public static SmartActiveBenefitType updateImpl(
		SmartActiveBenefitType smartActiveBenefitType) {

		return getPersistence().updateImpl(smartActiveBenefitType);
	}

	/**
	 * Returns the smart active benefit type with the primary key or throws a <code>NoSuchSmartActiveBenefitTypeException</code> if it could not be found.
	 *
	 * @param smartActiveBenefitTypeId the primary key of the smart active benefit type
	 * @return the smart active benefit type
	 * @throws NoSuchSmartActiveBenefitTypeException if a smart active benefit type with the primary key could not be found
	 */
	public static SmartActiveBenefitType findByPrimaryKey(
			long smartActiveBenefitTypeId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveBenefitTypeException {

		return getPersistence().findByPrimaryKey(smartActiveBenefitTypeId);
	}

	/**
	 * Returns the smart active benefit type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveBenefitTypeId the primary key of the smart active benefit type
	 * @return the smart active benefit type, or <code>null</code> if a smart active benefit type with the primary key could not be found
	 */
	public static SmartActiveBenefitType fetchByPrimaryKey(
		long smartActiveBenefitTypeId) {

		return getPersistence().fetchByPrimaryKey(smartActiveBenefitTypeId);
	}

	/**
	 * Returns all the smart active benefit types.
	 *
	 * @return the smart active benefit types
	 */
	public static List<SmartActiveBenefitType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the smart active benefit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit types
	 * @param end the upper bound of the range of smart active benefit types (not inclusive)
	 * @return the range of smart active benefit types
	 */
	public static List<SmartActiveBenefitType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the smart active benefit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit types
	 * @param end the upper bound of the range of smart active benefit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active benefit types
	 */
	public static List<SmartActiveBenefitType> findAll(
		int start, int end,
		OrderByComparator<SmartActiveBenefitType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart active benefit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit types
	 * @param end the upper bound of the range of smart active benefit types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active benefit types
	 */
	public static List<SmartActiveBenefitType> findAll(
		int start, int end,
		OrderByComparator<SmartActiveBenefitType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the smart active benefit types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of smart active benefit types.
	 *
	 * @return the number of smart active benefit types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SmartActiveBenefitTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile SmartActiveBenefitTypePersistence _persistence;

}