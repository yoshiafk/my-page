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

import com.mypage.admin.product.model.HealthSmeFacility;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the health sme facility service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.HealthSmeFacilityPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see HealthSmeFacilityPersistence
 * @generated
 */
public class HealthSmeFacilityUtil {

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
	public static void clearCache(HealthSmeFacility healthSmeFacility) {
		getPersistence().clearCache(healthSmeFacility);
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
	public static Map<Serializable, HealthSmeFacility> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<HealthSmeFacility> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HealthSmeFacility> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HealthSmeFacility> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<HealthSmeFacility> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static HealthSmeFacility update(
		HealthSmeFacility healthSmeFacility) {

		return getPersistence().update(healthSmeFacility);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static HealthSmeFacility update(
		HealthSmeFacility healthSmeFacility, ServiceContext serviceContext) {

		return getPersistence().update(healthSmeFacility, serviceContext);
	}

	/**
	 * Caches the health sme facility in the entity cache if it is enabled.
	 *
	 * @param healthSmeFacility the health sme facility
	 */
	public static void cacheResult(HealthSmeFacility healthSmeFacility) {
		getPersistence().cacheResult(healthSmeFacility);
	}

	/**
	 * Caches the health sme facilities in the entity cache if it is enabled.
	 *
	 * @param healthSmeFacilities the health sme facilities
	 */
	public static void cacheResult(
		List<HealthSmeFacility> healthSmeFacilities) {

		getPersistence().cacheResult(healthSmeFacilities);
	}

	/**
	 * Creates a new health sme facility with the primary key. Does not add the health sme facility to the database.
	 *
	 * @param healthSmeFacilityId the primary key for the new health sme facility
	 * @return the new health sme facility
	 */
	public static HealthSmeFacility create(long healthSmeFacilityId) {
		return getPersistence().create(healthSmeFacilityId);
	}

	/**
	 * Removes the health sme facility with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param healthSmeFacilityId the primary key of the health sme facility
	 * @return the health sme facility that was removed
	 * @throws NoSuchHealthSmeFacilityException if a health sme facility with the primary key could not be found
	 */
	public static HealthSmeFacility remove(long healthSmeFacilityId)
		throws com.mypage.admin.product.exception.
			NoSuchHealthSmeFacilityException {

		return getPersistence().remove(healthSmeFacilityId);
	}

	public static HealthSmeFacility updateImpl(
		HealthSmeFacility healthSmeFacility) {

		return getPersistence().updateImpl(healthSmeFacility);
	}

	/**
	 * Returns the health sme facility with the primary key or throws a <code>NoSuchHealthSmeFacilityException</code> if it could not be found.
	 *
	 * @param healthSmeFacilityId the primary key of the health sme facility
	 * @return the health sme facility
	 * @throws NoSuchHealthSmeFacilityException if a health sme facility with the primary key could not be found
	 */
	public static HealthSmeFacility findByPrimaryKey(long healthSmeFacilityId)
		throws com.mypage.admin.product.exception.
			NoSuchHealthSmeFacilityException {

		return getPersistence().findByPrimaryKey(healthSmeFacilityId);
	}

	/**
	 * Returns the health sme facility with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param healthSmeFacilityId the primary key of the health sme facility
	 * @return the health sme facility, or <code>null</code> if a health sme facility with the primary key could not be found
	 */
	public static HealthSmeFacility fetchByPrimaryKey(
		long healthSmeFacilityId) {

		return getPersistence().fetchByPrimaryKey(healthSmeFacilityId);
	}

	/**
	 * Returns all the health sme facilities.
	 *
	 * @return the health sme facilities
	 */
	public static List<HealthSmeFacility> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the health sme facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeFacilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme facilities
	 * @param end the upper bound of the range of health sme facilities (not inclusive)
	 * @return the range of health sme facilities
	 */
	public static List<HealthSmeFacility> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the health sme facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeFacilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme facilities
	 * @param end the upper bound of the range of health sme facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of health sme facilities
	 */
	public static List<HealthSmeFacility> findAll(
		int start, int end,
		OrderByComparator<HealthSmeFacility> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the health sme facilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeFacilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme facilities
	 * @param end the upper bound of the range of health sme facilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of health sme facilities
	 */
	public static List<HealthSmeFacility> findAll(
		int start, int end,
		OrderByComparator<HealthSmeFacility> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the health sme facilities from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of health sme facilities.
	 *
	 * @return the number of health sme facilities
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HealthSmeFacilityPersistence getPersistence() {
		return _persistence;
	}

	private static volatile HealthSmeFacilityPersistence _persistence;

}