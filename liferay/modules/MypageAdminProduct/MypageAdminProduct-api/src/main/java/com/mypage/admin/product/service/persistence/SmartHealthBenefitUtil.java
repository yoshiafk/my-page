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

import com.mypage.admin.product.model.SmartHealthBenefit;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the smart health benefit service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.SmartHealthBenefitPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartHealthBenefitPersistence
 * @generated
 */
public class SmartHealthBenefitUtil {

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
	public static void clearCache(SmartHealthBenefit smartHealthBenefit) {
		getPersistence().clearCache(smartHealthBenefit);
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
	public static Map<Serializable, SmartHealthBenefit> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SmartHealthBenefit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SmartHealthBenefit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SmartHealthBenefit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SmartHealthBenefit> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SmartHealthBenefit update(
		SmartHealthBenefit smartHealthBenefit) {

		return getPersistence().update(smartHealthBenefit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SmartHealthBenefit update(
		SmartHealthBenefit smartHealthBenefit, ServiceContext serviceContext) {

		return getPersistence().update(smartHealthBenefit, serviceContext);
	}

	/**
	 * Returns all the smart health benefits where smartHealthPlanId = &#63;.
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @return the matching smart health benefits
	 */
	public static List<SmartHealthBenefit> findBysmartHealthPlanId(
		long smartHealthPlanId) {

		return getPersistence().findBysmartHealthPlanId(smartHealthPlanId);
	}

	/**
	 * Returns a range of all the smart health benefits where smartHealthPlanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @param start the lower bound of the range of smart health benefits
	 * @param end the upper bound of the range of smart health benefits (not inclusive)
	 * @return the range of matching smart health benefits
	 */
	public static List<SmartHealthBenefit> findBysmartHealthPlanId(
		long smartHealthPlanId, int start, int end) {

		return getPersistence().findBysmartHealthPlanId(
			smartHealthPlanId, start, end);
	}

	/**
	 * Returns an ordered range of all the smart health benefits where smartHealthPlanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @param start the lower bound of the range of smart health benefits
	 * @param end the upper bound of the range of smart health benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching smart health benefits
	 */
	public static List<SmartHealthBenefit> findBysmartHealthPlanId(
		long smartHealthPlanId, int start, int end,
		OrderByComparator<SmartHealthBenefit> orderByComparator) {

		return getPersistence().findBysmartHealthPlanId(
			smartHealthPlanId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart health benefits where smartHealthPlanId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @param start the lower bound of the range of smart health benefits
	 * @param end the upper bound of the range of smart health benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching smart health benefits
	 */
	public static List<SmartHealthBenefit> findBysmartHealthPlanId(
		long smartHealthPlanId, int start, int end,
		OrderByComparator<SmartHealthBenefit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysmartHealthPlanId(
			smartHealthPlanId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first smart health benefit in the ordered set where smartHealthPlanId = &#63;.
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart health benefit
	 * @throws NoSuchSmartHealthBenefitException if a matching smart health benefit could not be found
	 */
	public static SmartHealthBenefit findBysmartHealthPlanId_First(
			long smartHealthPlanId,
			OrderByComparator<SmartHealthBenefit> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchSmartHealthBenefitException {

		return getPersistence().findBysmartHealthPlanId_First(
			smartHealthPlanId, orderByComparator);
	}

	/**
	 * Returns the first smart health benefit in the ordered set where smartHealthPlanId = &#63;.
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching smart health benefit, or <code>null</code> if a matching smart health benefit could not be found
	 */
	public static SmartHealthBenefit fetchBysmartHealthPlanId_First(
		long smartHealthPlanId,
		OrderByComparator<SmartHealthBenefit> orderByComparator) {

		return getPersistence().fetchBysmartHealthPlanId_First(
			smartHealthPlanId, orderByComparator);
	}

	/**
	 * Returns the last smart health benefit in the ordered set where smartHealthPlanId = &#63;.
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart health benefit
	 * @throws NoSuchSmartHealthBenefitException if a matching smart health benefit could not be found
	 */
	public static SmartHealthBenefit findBysmartHealthPlanId_Last(
			long smartHealthPlanId,
			OrderByComparator<SmartHealthBenefit> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchSmartHealthBenefitException {

		return getPersistence().findBysmartHealthPlanId_Last(
			smartHealthPlanId, orderByComparator);
	}

	/**
	 * Returns the last smart health benefit in the ordered set where smartHealthPlanId = &#63;.
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching smart health benefit, or <code>null</code> if a matching smart health benefit could not be found
	 */
	public static SmartHealthBenefit fetchBysmartHealthPlanId_Last(
		long smartHealthPlanId,
		OrderByComparator<SmartHealthBenefit> orderByComparator) {

		return getPersistence().fetchBysmartHealthPlanId_Last(
			smartHealthPlanId, orderByComparator);
	}

	/**
	 * Returns the smart health benefits before and after the current smart health benefit in the ordered set where smartHealthPlanId = &#63;.
	 *
	 * @param smartHealthBenefitId the primary key of the current smart health benefit
	 * @param smartHealthPlanId the smart health plan ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next smart health benefit
	 * @throws NoSuchSmartHealthBenefitException if a smart health benefit with the primary key could not be found
	 */
	public static SmartHealthBenefit[] findBysmartHealthPlanId_PrevAndNext(
			long smartHealthBenefitId, long smartHealthPlanId,
			OrderByComparator<SmartHealthBenefit> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchSmartHealthBenefitException {

		return getPersistence().findBysmartHealthPlanId_PrevAndNext(
			smartHealthBenefitId, smartHealthPlanId, orderByComparator);
	}

	/**
	 * Removes all the smart health benefits where smartHealthPlanId = &#63; from the database.
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 */
	public static void removeBysmartHealthPlanId(long smartHealthPlanId) {
		getPersistence().removeBysmartHealthPlanId(smartHealthPlanId);
	}

	/**
	 * Returns the number of smart health benefits where smartHealthPlanId = &#63;.
	 *
	 * @param smartHealthPlanId the smart health plan ID
	 * @return the number of matching smart health benefits
	 */
	public static int countBysmartHealthPlanId(long smartHealthPlanId) {
		return getPersistence().countBysmartHealthPlanId(smartHealthPlanId);
	}

	/**
	 * Caches the smart health benefit in the entity cache if it is enabled.
	 *
	 * @param smartHealthBenefit the smart health benefit
	 */
	public static void cacheResult(SmartHealthBenefit smartHealthBenefit) {
		getPersistence().cacheResult(smartHealthBenefit);
	}

	/**
	 * Caches the smart health benefits in the entity cache if it is enabled.
	 *
	 * @param smartHealthBenefits the smart health benefits
	 */
	public static void cacheResult(
		List<SmartHealthBenefit> smartHealthBenefits) {

		getPersistence().cacheResult(smartHealthBenefits);
	}

	/**
	 * Creates a new smart health benefit with the primary key. Does not add the smart health benefit to the database.
	 *
	 * @param smartHealthBenefitId the primary key for the new smart health benefit
	 * @return the new smart health benefit
	 */
	public static SmartHealthBenefit create(long smartHealthBenefitId) {
		return getPersistence().create(smartHealthBenefitId);
	}

	/**
	 * Removes the smart health benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartHealthBenefitId the primary key of the smart health benefit
	 * @return the smart health benefit that was removed
	 * @throws NoSuchSmartHealthBenefitException if a smart health benefit with the primary key could not be found
	 */
	public static SmartHealthBenefit remove(long smartHealthBenefitId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartHealthBenefitException {

		return getPersistence().remove(smartHealthBenefitId);
	}

	public static SmartHealthBenefit updateImpl(
		SmartHealthBenefit smartHealthBenefit) {

		return getPersistence().updateImpl(smartHealthBenefit);
	}

	/**
	 * Returns the smart health benefit with the primary key or throws a <code>NoSuchSmartHealthBenefitException</code> if it could not be found.
	 *
	 * @param smartHealthBenefitId the primary key of the smart health benefit
	 * @return the smart health benefit
	 * @throws NoSuchSmartHealthBenefitException if a smart health benefit with the primary key could not be found
	 */
	public static SmartHealthBenefit findByPrimaryKey(long smartHealthBenefitId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartHealthBenefitException {

		return getPersistence().findByPrimaryKey(smartHealthBenefitId);
	}

	/**
	 * Returns the smart health benefit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartHealthBenefitId the primary key of the smart health benefit
	 * @return the smart health benefit, or <code>null</code> if a smart health benefit with the primary key could not be found
	 */
	public static SmartHealthBenefit fetchByPrimaryKey(
		long smartHealthBenefitId) {

		return getPersistence().fetchByPrimaryKey(smartHealthBenefitId);
	}

	/**
	 * Returns all the smart health benefits.
	 *
	 * @return the smart health benefits
	 */
	public static List<SmartHealthBenefit> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the smart health benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefits
	 * @param end the upper bound of the range of smart health benefits (not inclusive)
	 * @return the range of smart health benefits
	 */
	public static List<SmartHealthBenefit> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the smart health benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefits
	 * @param end the upper bound of the range of smart health benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart health benefits
	 */
	public static List<SmartHealthBenefit> findAll(
		int start, int end,
		OrderByComparator<SmartHealthBenefit> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart health benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartHealthBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefits
	 * @param end the upper bound of the range of smart health benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart health benefits
	 */
	public static List<SmartHealthBenefit> findAll(
		int start, int end,
		OrderByComparator<SmartHealthBenefit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the smart health benefits from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of smart health benefits.
	 *
	 * @return the number of smart health benefits
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SmartHealthBenefitPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SmartHealthBenefitPersistence _persistence;

}