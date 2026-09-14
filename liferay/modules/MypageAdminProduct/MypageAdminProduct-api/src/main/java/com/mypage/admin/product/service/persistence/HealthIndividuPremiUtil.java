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

import com.mypage.admin.product.model.HealthIndividuPremi;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the health individu premi service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.HealthIndividuPremiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see HealthIndividuPremiPersistence
 * @generated
 */
public class HealthIndividuPremiUtil {

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
	public static void clearCache(HealthIndividuPremi healthIndividuPremi) {
		getPersistence().clearCache(healthIndividuPremi);
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
	public static Map<Serializable, HealthIndividuPremi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<HealthIndividuPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HealthIndividuPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HealthIndividuPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<HealthIndividuPremi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static HealthIndividuPremi update(
		HealthIndividuPremi healthIndividuPremi) {

		return getPersistence().update(healthIndividuPremi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static HealthIndividuPremi update(
		HealthIndividuPremi healthIndividuPremi,
		ServiceContext serviceContext) {

		return getPersistence().update(healthIndividuPremi, serviceContext);
	}

	/**
	 * Returns the health individu premi where planId = &#63; and age = &#63; or throws a <code>NoSuchHealthIndividuPremiException</code> if it could not be found.
	 *
	 * @param planId the plan ID
	 * @param age the age
	 * @return the matching health individu premi
	 * @throws NoSuchHealthIndividuPremiException if a matching health individu premi could not be found
	 */
	public static HealthIndividuPremi findBysearchByPlanIdAndAge(
			long planId, int age)
		throws com.mypage.admin.product.exception.
			NoSuchHealthIndividuPremiException {

		return getPersistence().findBysearchByPlanIdAndAge(planId, age);
	}

	/**
	 * Returns the health individu premi where planId = &#63; and age = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param planId the plan ID
	 * @param age the age
	 * @return the matching health individu premi, or <code>null</code> if a matching health individu premi could not be found
	 */
	public static HealthIndividuPremi fetchBysearchByPlanIdAndAge(
		long planId, int age) {

		return getPersistence().fetchBysearchByPlanIdAndAge(planId, age);
	}

	/**
	 * Returns the health individu premi where planId = &#63; and age = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param planId the plan ID
	 * @param age the age
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching health individu premi, or <code>null</code> if a matching health individu premi could not be found
	 */
	public static HealthIndividuPremi fetchBysearchByPlanIdAndAge(
		long planId, int age, boolean useFinderCache) {

		return getPersistence().fetchBysearchByPlanIdAndAge(
			planId, age, useFinderCache);
	}

	/**
	 * Removes the health individu premi where planId = &#63; and age = &#63; from the database.
	 *
	 * @param planId the plan ID
	 * @param age the age
	 * @return the health individu premi that was removed
	 */
	public static HealthIndividuPremi removeBysearchByPlanIdAndAge(
			long planId, int age)
		throws com.mypage.admin.product.exception.
			NoSuchHealthIndividuPremiException {

		return getPersistence().removeBysearchByPlanIdAndAge(planId, age);
	}

	/**
	 * Returns the number of health individu premis where planId = &#63; and age = &#63;.
	 *
	 * @param planId the plan ID
	 * @param age the age
	 * @return the number of matching health individu premis
	 */
	public static int countBysearchByPlanIdAndAge(long planId, int age) {
		return getPersistence().countBysearchByPlanIdAndAge(planId, age);
	}

	/**
	 * Caches the health individu premi in the entity cache if it is enabled.
	 *
	 * @param healthIndividuPremi the health individu premi
	 */
	public static void cacheResult(HealthIndividuPremi healthIndividuPremi) {
		getPersistence().cacheResult(healthIndividuPremi);
	}

	/**
	 * Caches the health individu premis in the entity cache if it is enabled.
	 *
	 * @param healthIndividuPremis the health individu premis
	 */
	public static void cacheResult(
		List<HealthIndividuPremi> healthIndividuPremis) {

		getPersistence().cacheResult(healthIndividuPremis);
	}

	/**
	 * Creates a new health individu premi with the primary key. Does not add the health individu premi to the database.
	 *
	 * @param healthIndividuPremiId the primary key for the new health individu premi
	 * @return the new health individu premi
	 */
	public static HealthIndividuPremi create(long healthIndividuPremiId) {
		return getPersistence().create(healthIndividuPremiId);
	}

	/**
	 * Removes the health individu premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param healthIndividuPremiId the primary key of the health individu premi
	 * @return the health individu premi that was removed
	 * @throws NoSuchHealthIndividuPremiException if a health individu premi with the primary key could not be found
	 */
	public static HealthIndividuPremi remove(long healthIndividuPremiId)
		throws com.mypage.admin.product.exception.
			NoSuchHealthIndividuPremiException {

		return getPersistence().remove(healthIndividuPremiId);
	}

	public static HealthIndividuPremi updateImpl(
		HealthIndividuPremi healthIndividuPremi) {

		return getPersistence().updateImpl(healthIndividuPremi);
	}

	/**
	 * Returns the health individu premi with the primary key or throws a <code>NoSuchHealthIndividuPremiException</code> if it could not be found.
	 *
	 * @param healthIndividuPremiId the primary key of the health individu premi
	 * @return the health individu premi
	 * @throws NoSuchHealthIndividuPremiException if a health individu premi with the primary key could not be found
	 */
	public static HealthIndividuPremi findByPrimaryKey(
			long healthIndividuPremiId)
		throws com.mypage.admin.product.exception.
			NoSuchHealthIndividuPremiException {

		return getPersistence().findByPrimaryKey(healthIndividuPremiId);
	}

	/**
	 * Returns the health individu premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param healthIndividuPremiId the primary key of the health individu premi
	 * @return the health individu premi, or <code>null</code> if a health individu premi with the primary key could not be found
	 */
	public static HealthIndividuPremi fetchByPrimaryKey(
		long healthIndividuPremiId) {

		return getPersistence().fetchByPrimaryKey(healthIndividuPremiId);
	}

	/**
	 * Returns all the health individu premis.
	 *
	 * @return the health individu premis
	 */
	public static List<HealthIndividuPremi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the health individu premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu premis
	 * @param end the upper bound of the range of health individu premis (not inclusive)
	 * @return the range of health individu premis
	 */
	public static List<HealthIndividuPremi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the health individu premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu premis
	 * @param end the upper bound of the range of health individu premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of health individu premis
	 */
	public static List<HealthIndividuPremi> findAll(
		int start, int end,
		OrderByComparator<HealthIndividuPremi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the health individu premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu premis
	 * @param end the upper bound of the range of health individu premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of health individu premis
	 */
	public static List<HealthIndividuPremi> findAll(
		int start, int end,
		OrderByComparator<HealthIndividuPremi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the health individu premis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of health individu premis.
	 *
	 * @return the number of health individu premis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HealthIndividuPremiPersistence getPersistence() {
		return _persistence;
	}

	private static volatile HealthIndividuPremiPersistence _persistence;

}