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

import com.mypage.admin.product.model.SmartHealthPlan;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the smart health plan service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.SmartHealthPlanPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartHealthPlanPersistence
 * @generated
 */
public class SmartHealthPlanUtil {

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
	public static void clearCache(SmartHealthPlan smartHealthPlan) {
		getPersistence().clearCache(smartHealthPlan);
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
	public static Map<Serializable, SmartHealthPlan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SmartHealthPlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SmartHealthPlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SmartHealthPlan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SmartHealthPlan> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SmartHealthPlan update(SmartHealthPlan smartHealthPlan) {
		return getPersistence().update(smartHealthPlan);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SmartHealthPlan update(
		SmartHealthPlan smartHealthPlan, ServiceContext serviceContext) {

		return getPersistence().update(smartHealthPlan, serviceContext);
	}

	/**
	 * Returns the smart health plan where planName = &#63; or throws a <code>NoSuchSmartHealthPlanException</code> if it could not be found.
	 *
	 * @param planName the plan name
	 * @return the matching smart health plan
	 * @throws NoSuchSmartHealthPlanException if a matching smart health plan could not be found
	 */
	public static SmartHealthPlan findByplanName(String planName)
		throws com.mypage.admin.product.exception.
			NoSuchSmartHealthPlanException {

		return getPersistence().findByplanName(planName);
	}

	/**
	 * Returns the smart health plan where planName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param planName the plan name
	 * @return the matching smart health plan, or <code>null</code> if a matching smart health plan could not be found
	 */
	public static SmartHealthPlan fetchByplanName(String planName) {
		return getPersistence().fetchByplanName(planName);
	}

	/**
	 * Returns the smart health plan where planName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param planName the plan name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart health plan, or <code>null</code> if a matching smart health plan could not be found
	 */
	public static SmartHealthPlan fetchByplanName(
		String planName, boolean useFinderCache) {

		return getPersistence().fetchByplanName(planName, useFinderCache);
	}

	/**
	 * Removes the smart health plan where planName = &#63; from the database.
	 *
	 * @param planName the plan name
	 * @return the smart health plan that was removed
	 */
	public static SmartHealthPlan removeByplanName(String planName)
		throws com.mypage.admin.product.exception.
			NoSuchSmartHealthPlanException {

		return getPersistence().removeByplanName(planName);
	}

	/**
	 * Returns the number of smart health plans where planName = &#63;.
	 *
	 * @param planName the plan name
	 * @return the number of matching smart health plans
	 */
	public static int countByplanName(String planName) {
		return getPersistence().countByplanName(planName);
	}

	/**
	 * Returns all the smart health plans where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @return the matching smart health plans
	 */
	public static List<SmartHealthPlan> findByplanGroup(String planGroup) {
		return getPersistence().findByplanGroup(planGroup);
	}

	/**
	 * Returns a range of all the smart health plans where planGroup = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param planGroup the plan group
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @return the range of matching smart health plans
	 */
	public static List<SmartHealthPlan> findByplanGroup(
		String planGroup, int start, int end) {

		return getPersistence().findByplanGroup(planGroup, start, end);
	}

	/**
	 * Returns an ordered range of all the smart health plans where planGroup = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param planGroup the plan group
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smart health plans
	 */
	public static List<SmartHealthPlan> findByplanGroup(
		String planGroup, int start, int end,
		OrderByComparator<SmartHealthPlan> orderByComparator) {

		return getPersistence().findByplanGroup(
			planGroup, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart health plans where planGroup = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param planGroup the plan group
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smart health plans
	 */
	public static List<SmartHealthPlan> findByplanGroup(
		String planGroup, int start, int end,
		OrderByComparator<SmartHealthPlan> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByplanGroup(
			planGroup, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first smart health plan in the ordered set where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart health plan
	 * @throws NoSuchSmartHealthPlanException if a matching smart health plan could not be found
	 */
	public static SmartHealthPlan findByplanGroup_First(
			String planGroup,
			OrderByComparator<SmartHealthPlan> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchSmartHealthPlanException {

		return getPersistence().findByplanGroup_First(
			planGroup, orderByComparator);
	}

	/**
	 * Returns the first smart health plan in the ordered set where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart health plan, or <code>null</code> if a matching smart health plan could not be found
	 */
	public static SmartHealthPlan fetchByplanGroup_First(
		String planGroup,
		OrderByComparator<SmartHealthPlan> orderByComparator) {

		return getPersistence().fetchByplanGroup_First(
			planGroup, orderByComparator);
	}

	/**
	 * Returns the last smart health plan in the ordered set where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart health plan
	 * @throws NoSuchSmartHealthPlanException if a matching smart health plan could not be found
	 */
	public static SmartHealthPlan findByplanGroup_Last(
			String planGroup,
			OrderByComparator<SmartHealthPlan> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchSmartHealthPlanException {

		return getPersistence().findByplanGroup_Last(
			planGroup, orderByComparator);
	}

	/**
	 * Returns the last smart health plan in the ordered set where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart health plan, or <code>null</code> if a matching smart health plan could not be found
	 */
	public static SmartHealthPlan fetchByplanGroup_Last(
		String planGroup,
		OrderByComparator<SmartHealthPlan> orderByComparator) {

		return getPersistence().fetchByplanGroup_Last(
			planGroup, orderByComparator);
	}

	/**
	 * Returns the smart health plans before and after the current smart health plan in the ordered set where planGroup = &#63;.
	 *
	 * @param smartHealthPlanId the primary key of the current smart health plan
	 * @param planGroup the plan group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next smart health plan
	 * @throws NoSuchSmartHealthPlanException if a smart health plan with the primary key could not be found
	 */
	public static SmartHealthPlan[] findByplanGroup_PrevAndNext(
			long smartHealthPlanId, String planGroup,
			OrderByComparator<SmartHealthPlan> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchSmartHealthPlanException {

		return getPersistence().findByplanGroup_PrevAndNext(
			smartHealthPlanId, planGroup, orderByComparator);
	}

	/**
	 * Removes all the smart health plans where planGroup = &#63; from the database.
	 *
	 * @param planGroup the plan group
	 */
	public static void removeByplanGroup(String planGroup) {
		getPersistence().removeByplanGroup(planGroup);
	}

	/**
	 * Returns the number of smart health plans where planGroup = &#63;.
	 *
	 * @param planGroup the plan group
	 * @return the number of matching smart health plans
	 */
	public static int countByplanGroup(String planGroup) {
		return getPersistence().countByplanGroup(planGroup);
	}

	/**
	 * Caches the smart health plan in the entity cache if it is enabled.
	 *
	 * @param smartHealthPlan the smart health plan
	 */
	public static void cacheResult(SmartHealthPlan smartHealthPlan) {
		getPersistence().cacheResult(smartHealthPlan);
	}

	/**
	 * Caches the smart health plans in the entity cache if it is enabled.
	 *
	 * @param smartHealthPlans the smart health plans
	 */
	public static void cacheResult(List<SmartHealthPlan> smartHealthPlans) {
		getPersistence().cacheResult(smartHealthPlans);
	}

	/**
	 * Creates a new smart health plan with the primary key. Does not add the smart health plan to the database.
	 *
	 * @param smartHealthPlanId the primary key for the new smart health plan
	 * @return the new smart health plan
	 */
	public static SmartHealthPlan create(long smartHealthPlanId) {
		return getPersistence().create(smartHealthPlanId);
	}

	/**
	 * Removes the smart health plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartHealthPlanId the primary key of the smart health plan
	 * @return the smart health plan that was removed
	 * @throws NoSuchSmartHealthPlanException if a smart health plan with the primary key could not be found
	 */
	public static SmartHealthPlan remove(long smartHealthPlanId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartHealthPlanException {

		return getPersistence().remove(smartHealthPlanId);
	}

	public static SmartHealthPlan updateImpl(SmartHealthPlan smartHealthPlan) {
		return getPersistence().updateImpl(smartHealthPlan);
	}

	/**
	 * Returns the smart health plan with the primary key or throws a <code>NoSuchSmartHealthPlanException</code> if it could not be found.
	 *
	 * @param smartHealthPlanId the primary key of the smart health plan
	 * @return the smart health plan
	 * @throws NoSuchSmartHealthPlanException if a smart health plan with the primary key could not be found
	 */
	public static SmartHealthPlan findByPrimaryKey(long smartHealthPlanId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartHealthPlanException {

		return getPersistence().findByPrimaryKey(smartHealthPlanId);
	}

	/**
	 * Returns the smart health plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartHealthPlanId the primary key of the smart health plan
	 * @return the smart health plan, or <code>null</code> if a smart health plan with the primary key could not be found
	 */
	public static SmartHealthPlan fetchByPrimaryKey(long smartHealthPlanId) {
		return getPersistence().fetchByPrimaryKey(smartHealthPlanId);
	}

	/**
	 * Returns all the smart health plans.
	 *
	 * @return the smart health plans
	 */
	public static List<SmartHealthPlan> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the smart health plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @return the range of smart health plans
	 */
	public static List<SmartHealthPlan> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the smart health plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart health plans
	 */
	public static List<SmartHealthPlan> findAll(
		int start, int end,
		OrderByComparator<SmartHealthPlan> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart health plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart health plans
	 */
	public static List<SmartHealthPlan> findAll(
		int start, int end,
		OrderByComparator<SmartHealthPlan> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the smart health plans from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of smart health plans.
	 *
	 * @return the number of smart health plans
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SmartHealthPlanPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SmartHealthPlanPersistence _persistence;

}