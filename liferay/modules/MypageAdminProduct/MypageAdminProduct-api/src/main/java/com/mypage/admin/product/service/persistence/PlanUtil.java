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

import com.mypage.admin.product.model.Plan;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the plan service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.PlanPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PlanPersistence
 * @generated
 */
public class PlanUtil {

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
	public static void clearCache(Plan plan) {
		getPersistence().clearCache(plan);
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
	public static Map<Serializable, Plan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Plan> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Plan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Plan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Plan> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Plan update(Plan plan) {
		return getPersistence().update(plan);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Plan update(Plan plan, ServiceContext serviceContext) {
		return getPersistence().update(plan, serviceContext);
	}

	/**
	 * Caches the plan in the entity cache if it is enabled.
	 *
	 * @param plan the plan
	 */
	public static void cacheResult(Plan plan) {
		getPersistence().cacheResult(plan);
	}

	/**
	 * Caches the plans in the entity cache if it is enabled.
	 *
	 * @param plans the plans
	 */
	public static void cacheResult(List<Plan> plans) {
		getPersistence().cacheResult(plans);
	}

	/**
	 * Creates a new plan with the primary key. Does not add the plan to the database.
	 *
	 * @param planId the primary key for the new plan
	 * @return the new plan
	 */
	public static Plan create(long planId) {
		return getPersistence().create(planId);
	}

	/**
	 * Removes the plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param planId the primary key of the plan
	 * @return the plan that was removed
	 * @throws NoSuchPlanException if a plan with the primary key could not be found
	 */
	public static Plan remove(long planId)
		throws com.mypage.admin.product.exception.NoSuchPlanException {

		return getPersistence().remove(planId);
	}

	public static Plan updateImpl(Plan plan) {
		return getPersistence().updateImpl(plan);
	}

	/**
	 * Returns the plan with the primary key or throws a <code>NoSuchPlanException</code> if it could not be found.
	 *
	 * @param planId the primary key of the plan
	 * @return the plan
	 * @throws NoSuchPlanException if a plan with the primary key could not be found
	 */
	public static Plan findByPrimaryKey(long planId)
		throws com.mypage.admin.product.exception.NoSuchPlanException {

		return getPersistence().findByPrimaryKey(planId);
	}

	/**
	 * Returns the plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param planId the primary key of the plan
	 * @return the plan, or <code>null</code> if a plan with the primary key could not be found
	 */
	public static Plan fetchByPrimaryKey(long planId) {
		return getPersistence().fetchByPrimaryKey(planId);
	}

	/**
	 * Returns all the plans.
	 *
	 * @return the plans
	 */
	public static List<Plan> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of plans
	 * @param end the upper bound of the range of plans (not inclusive)
	 * @return the range of plans
	 */
	public static List<Plan> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of plans
	 * @param end the upper bound of the range of plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of plans
	 */
	public static List<Plan> findAll(
		int start, int end, OrderByComparator<Plan> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of plans
	 * @param end the upper bound of the range of plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of plans
	 */
	public static List<Plan> findAll(
		int start, int end, OrderByComparator<Plan> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the plans from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of plans.
	 *
	 * @return the number of plans
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PlanPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PlanPersistence _persistence;

}