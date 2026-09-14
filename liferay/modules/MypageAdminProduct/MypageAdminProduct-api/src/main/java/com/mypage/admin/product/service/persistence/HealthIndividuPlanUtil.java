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

import com.mypage.admin.product.model.HealthIndividuPlan;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the health individu plan service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.HealthIndividuPlanPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see HealthIndividuPlanPersistence
 * @generated
 */
public class HealthIndividuPlanUtil {

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
	public static void clearCache(HealthIndividuPlan healthIndividuPlan) {
		getPersistence().clearCache(healthIndividuPlan);
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
	public static Map<Serializable, HealthIndividuPlan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<HealthIndividuPlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HealthIndividuPlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HealthIndividuPlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<HealthIndividuPlan> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static HealthIndividuPlan update(
		HealthIndividuPlan healthIndividuPlan) {

		return getPersistence().update(healthIndividuPlan);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static HealthIndividuPlan update(
		HealthIndividuPlan healthIndividuPlan, ServiceContext serviceContext) {

		return getPersistence().update(healthIndividuPlan, serviceContext);
	}

	/**
	 * Caches the health individu plan in the entity cache if it is enabled.
	 *
	 * @param healthIndividuPlan the health individu plan
	 */
	public static void cacheResult(HealthIndividuPlan healthIndividuPlan) {
		getPersistence().cacheResult(healthIndividuPlan);
	}

	/**
	 * Caches the health individu plans in the entity cache if it is enabled.
	 *
	 * @param healthIndividuPlans the health individu plans
	 */
	public static void cacheResult(
		List<HealthIndividuPlan> healthIndividuPlans) {

		getPersistence().cacheResult(healthIndividuPlans);
	}

	/**
	 * Creates a new health individu plan with the primary key. Does not add the health individu plan to the database.
	 *
	 * @param healthIndividuPlanId the primary key for the new health individu plan
	 * @return the new health individu plan
	 */
	public static HealthIndividuPlan create(long healthIndividuPlanId) {
		return getPersistence().create(healthIndividuPlanId);
	}

	/**
	 * Removes the health individu plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param healthIndividuPlanId the primary key of the health individu plan
	 * @return the health individu plan that was removed
	 * @throws NoSuchHealthIndividuPlanException if a health individu plan with the primary key could not be found
	 */
	public static HealthIndividuPlan remove(long healthIndividuPlanId)
		throws com.mypage.admin.product.exception.
			NoSuchHealthIndividuPlanException {

		return getPersistence().remove(healthIndividuPlanId);
	}

	public static HealthIndividuPlan updateImpl(
		HealthIndividuPlan healthIndividuPlan) {

		return getPersistence().updateImpl(healthIndividuPlan);
	}

	/**
	 * Returns the health individu plan with the primary key or throws a <code>NoSuchHealthIndividuPlanException</code> if it could not be found.
	 *
	 * @param healthIndividuPlanId the primary key of the health individu plan
	 * @return the health individu plan
	 * @throws NoSuchHealthIndividuPlanException if a health individu plan with the primary key could not be found
	 */
	public static HealthIndividuPlan findByPrimaryKey(long healthIndividuPlanId)
		throws com.mypage.admin.product.exception.
			NoSuchHealthIndividuPlanException {

		return getPersistence().findByPrimaryKey(healthIndividuPlanId);
	}

	/**
	 * Returns the health individu plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param healthIndividuPlanId the primary key of the health individu plan
	 * @return the health individu plan, or <code>null</code> if a health individu plan with the primary key could not be found
	 */
	public static HealthIndividuPlan fetchByPrimaryKey(
		long healthIndividuPlanId) {

		return getPersistence().fetchByPrimaryKey(healthIndividuPlanId);
	}

	/**
	 * Returns all the health individu plans.
	 *
	 * @return the health individu plans
	 */
	public static List<HealthIndividuPlan> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the health individu plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu plans
	 * @param end the upper bound of the range of health individu plans (not inclusive)
	 * @return the range of health individu plans
	 */
	public static List<HealthIndividuPlan> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the health individu plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu plans
	 * @param end the upper bound of the range of health individu plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of health individu plans
	 */
	public static List<HealthIndividuPlan> findAll(
		int start, int end,
		OrderByComparator<HealthIndividuPlan> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the health individu plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthIndividuPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu plans
	 * @param end the upper bound of the range of health individu plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of health individu plans
	 */
	public static List<HealthIndividuPlan> findAll(
		int start, int end,
		OrderByComparator<HealthIndividuPlan> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the health individu plans from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of health individu plans.
	 *
	 * @return the number of health individu plans
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HealthIndividuPlanPersistence getPersistence() {
		return _persistence;
	}

	private static volatile HealthIndividuPlanPersistence _persistence;

}