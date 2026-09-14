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

import com.mypage.admin.product.model.HealthSmeType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the health sme type service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.HealthSmeTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see HealthSmeTypePersistence
 * @generated
 */
public class HealthSmeTypeUtil {

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
	public static void clearCache(HealthSmeType healthSmeType) {
		getPersistence().clearCache(healthSmeType);
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
	public static Map<Serializable, HealthSmeType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<HealthSmeType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HealthSmeType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HealthSmeType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<HealthSmeType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static HealthSmeType update(HealthSmeType healthSmeType) {
		return getPersistence().update(healthSmeType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static HealthSmeType update(
		HealthSmeType healthSmeType, ServiceContext serviceContext) {

		return getPersistence().update(healthSmeType, serviceContext);
	}

	/**
	 * Caches the health sme type in the entity cache if it is enabled.
	 *
	 * @param healthSmeType the health sme type
	 */
	public static void cacheResult(HealthSmeType healthSmeType) {
		getPersistence().cacheResult(healthSmeType);
	}

	/**
	 * Caches the health sme types in the entity cache if it is enabled.
	 *
	 * @param healthSmeTypes the health sme types
	 */
	public static void cacheResult(List<HealthSmeType> healthSmeTypes) {
		getPersistence().cacheResult(healthSmeTypes);
	}

	/**
	 * Creates a new health sme type with the primary key. Does not add the health sme type to the database.
	 *
	 * @param healthSmeTypeId the primary key for the new health sme type
	 * @return the new health sme type
	 */
	public static HealthSmeType create(long healthSmeTypeId) {
		return getPersistence().create(healthSmeTypeId);
	}

	/**
	 * Removes the health sme type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param healthSmeTypeId the primary key of the health sme type
	 * @return the health sme type that was removed
	 * @throws NoSuchHealthSmeTypeException if a health sme type with the primary key could not be found
	 */
	public static HealthSmeType remove(long healthSmeTypeId)
		throws com.mypage.admin.product.exception.NoSuchHealthSmeTypeException {

		return getPersistence().remove(healthSmeTypeId);
	}

	public static HealthSmeType updateImpl(HealthSmeType healthSmeType) {
		return getPersistence().updateImpl(healthSmeType);
	}

	/**
	 * Returns the health sme type with the primary key or throws a <code>NoSuchHealthSmeTypeException</code> if it could not be found.
	 *
	 * @param healthSmeTypeId the primary key of the health sme type
	 * @return the health sme type
	 * @throws NoSuchHealthSmeTypeException if a health sme type with the primary key could not be found
	 */
	public static HealthSmeType findByPrimaryKey(long healthSmeTypeId)
		throws com.mypage.admin.product.exception.NoSuchHealthSmeTypeException {

		return getPersistence().findByPrimaryKey(healthSmeTypeId);
	}

	/**
	 * Returns the health sme type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param healthSmeTypeId the primary key of the health sme type
	 * @return the health sme type, or <code>null</code> if a health sme type with the primary key could not be found
	 */
	public static HealthSmeType fetchByPrimaryKey(long healthSmeTypeId) {
		return getPersistence().fetchByPrimaryKey(healthSmeTypeId);
	}

	/**
	 * Returns all the health sme types.
	 *
	 * @return the health sme types
	 */
	public static List<HealthSmeType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the health sme types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme types
	 * @param end the upper bound of the range of health sme types (not inclusive)
	 * @return the range of health sme types
	 */
	public static List<HealthSmeType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the health sme types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme types
	 * @param end the upper bound of the range of health sme types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of health sme types
	 */
	public static List<HealthSmeType> findAll(
		int start, int end,
		OrderByComparator<HealthSmeType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the health sme types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme types
	 * @param end the upper bound of the range of health sme types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of health sme types
	 */
	public static List<HealthSmeType> findAll(
		int start, int end, OrderByComparator<HealthSmeType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the health sme types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of health sme types.
	 *
	 * @return the number of health sme types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HealthSmeTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile HealthSmeTypePersistence _persistence;

}