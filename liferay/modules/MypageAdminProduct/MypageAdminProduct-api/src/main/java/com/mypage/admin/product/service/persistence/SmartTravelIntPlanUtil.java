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

import com.mypage.admin.product.model.SmartTravelIntPlan;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the smart travel int plan service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.SmartTravelIntPlanPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartTravelIntPlanPersistence
 * @generated
 */
public class SmartTravelIntPlanUtil {

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
	public static void clearCache(SmartTravelIntPlan smartTravelIntPlan) {
		getPersistence().clearCache(smartTravelIntPlan);
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
	public static Map<Serializable, SmartTravelIntPlan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SmartTravelIntPlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SmartTravelIntPlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SmartTravelIntPlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SmartTravelIntPlan> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SmartTravelIntPlan update(
		SmartTravelIntPlan smartTravelIntPlan) {

		return getPersistence().update(smartTravelIntPlan);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SmartTravelIntPlan update(
		SmartTravelIntPlan smartTravelIntPlan, ServiceContext serviceContext) {

		return getPersistence().update(smartTravelIntPlan, serviceContext);
	}

	/**
	 * Caches the smart travel int plan in the entity cache if it is enabled.
	 *
	 * @param smartTravelIntPlan the smart travel int plan
	 */
	public static void cacheResult(SmartTravelIntPlan smartTravelIntPlan) {
		getPersistence().cacheResult(smartTravelIntPlan);
	}

	/**
	 * Caches the smart travel int plans in the entity cache if it is enabled.
	 *
	 * @param smartTravelIntPlans the smart travel int plans
	 */
	public static void cacheResult(
		List<SmartTravelIntPlan> smartTravelIntPlans) {

		getPersistence().cacheResult(smartTravelIntPlans);
	}

	/**
	 * Creates a new smart travel int plan with the primary key. Does not add the smart travel int plan to the database.
	 *
	 * @param smartTravelIntPlanId the primary key for the new smart travel int plan
	 * @return the new smart travel int plan
	 */
	public static SmartTravelIntPlan create(long smartTravelIntPlanId) {
		return getPersistence().create(smartTravelIntPlanId);
	}

	/**
	 * Removes the smart travel int plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartTravelIntPlanId the primary key of the smart travel int plan
	 * @return the smart travel int plan that was removed
	 * @throws NoSuchSmartTravelIntPlanException if a smart travel int plan with the primary key could not be found
	 */
	public static SmartTravelIntPlan remove(long smartTravelIntPlanId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartTravelIntPlanException {

		return getPersistence().remove(smartTravelIntPlanId);
	}

	public static SmartTravelIntPlan updateImpl(
		SmartTravelIntPlan smartTravelIntPlan) {

		return getPersistence().updateImpl(smartTravelIntPlan);
	}

	/**
	 * Returns the smart travel int plan with the primary key or throws a <code>NoSuchSmartTravelIntPlanException</code> if it could not be found.
	 *
	 * @param smartTravelIntPlanId the primary key of the smart travel int plan
	 * @return the smart travel int plan
	 * @throws NoSuchSmartTravelIntPlanException if a smart travel int plan with the primary key could not be found
	 */
	public static SmartTravelIntPlan findByPrimaryKey(long smartTravelIntPlanId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartTravelIntPlanException {

		return getPersistence().findByPrimaryKey(smartTravelIntPlanId);
	}

	/**
	 * Returns the smart travel int plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartTravelIntPlanId the primary key of the smart travel int plan
	 * @return the smart travel int plan, or <code>null</code> if a smart travel int plan with the primary key could not be found
	 */
	public static SmartTravelIntPlan fetchByPrimaryKey(
		long smartTravelIntPlanId) {

		return getPersistence().fetchByPrimaryKey(smartTravelIntPlanId);
	}

	/**
	 * Returns all the smart travel int plans.
	 *
	 * @return the smart travel int plans
	 */
	public static List<SmartTravelIntPlan> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the smart travel int plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartTravelIntPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart travel int plans
	 * @param end the upper bound of the range of smart travel int plans (not inclusive)
	 * @return the range of smart travel int plans
	 */
	public static List<SmartTravelIntPlan> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the smart travel int plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartTravelIntPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart travel int plans
	 * @param end the upper bound of the range of smart travel int plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart travel int plans
	 */
	public static List<SmartTravelIntPlan> findAll(
		int start, int end,
		OrderByComparator<SmartTravelIntPlan> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart travel int plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartTravelIntPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart travel int plans
	 * @param end the upper bound of the range of smart travel int plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart travel int plans
	 */
	public static List<SmartTravelIntPlan> findAll(
		int start, int end,
		OrderByComparator<SmartTravelIntPlan> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the smart travel int plans from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of smart travel int plans.
	 *
	 * @return the number of smart travel int plans
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SmartTravelIntPlanPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SmartTravelIntPlanPersistence _persistence;

}