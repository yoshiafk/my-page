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

import com.mypage.admin.product.model.PetRate;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the pet rate service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.PetRatePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PetRatePersistence
 * @generated
 */
public class PetRateUtil {

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
	public static void clearCache(PetRate petRate) {
		getPersistence().clearCache(petRate);
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
	public static Map<Serializable, PetRate> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PetRate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PetRate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PetRate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PetRate> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PetRate update(PetRate petRate) {
		return getPersistence().update(petRate);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PetRate update(
		PetRate petRate, ServiceContext serviceContext) {

		return getPersistence().update(petRate, serviceContext);
	}

	/**
	 * Returns all the pet rates where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @return the matching pet rates
	 */
	public static List<PetRate> findByPlan(long petPlan) {
		return getPersistence().findByPlan(petPlan);
	}

	/**
	 * Returns a range of all the pet rates where petPlan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param petPlan the pet plan
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @return the range of matching pet rates
	 */
	public static List<PetRate> findByPlan(long petPlan, int start, int end) {
		return getPersistence().findByPlan(petPlan, start, end);
	}

	/**
	 * Returns an ordered range of all the pet rates where petPlan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param petPlan the pet plan
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet rates
	 */
	public static List<PetRate> findByPlan(
		long petPlan, int start, int end,
		OrderByComparator<PetRate> orderByComparator) {

		return getPersistence().findByPlan(
			petPlan, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet rates where petPlan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param petPlan the pet plan
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet rates
	 */
	public static List<PetRate> findByPlan(
		long petPlan, int start, int end,
		OrderByComparator<PetRate> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByPlan(
			petPlan, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pet rate in the ordered set where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet rate
	 * @throws NoSuchPetRateException if a matching pet rate could not be found
	 */
	public static PetRate findByPlan_First(
			long petPlan, OrderByComparator<PetRate> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetRateException {

		return getPersistence().findByPlan_First(petPlan, orderByComparator);
	}

	/**
	 * Returns the first pet rate in the ordered set where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet rate, or <code>null</code> if a matching pet rate could not be found
	 */
	public static PetRate fetchByPlan_First(
		long petPlan, OrderByComparator<PetRate> orderByComparator) {

		return getPersistence().fetchByPlan_First(petPlan, orderByComparator);
	}

	/**
	 * Returns the last pet rate in the ordered set where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet rate
	 * @throws NoSuchPetRateException if a matching pet rate could not be found
	 */
	public static PetRate findByPlan_Last(
			long petPlan, OrderByComparator<PetRate> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetRateException {

		return getPersistence().findByPlan_Last(petPlan, orderByComparator);
	}

	/**
	 * Returns the last pet rate in the ordered set where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet rate, or <code>null</code> if a matching pet rate could not be found
	 */
	public static PetRate fetchByPlan_Last(
		long petPlan, OrderByComparator<PetRate> orderByComparator) {

		return getPersistence().fetchByPlan_Last(petPlan, orderByComparator);
	}

	/**
	 * Returns the pet rates before and after the current pet rate in the ordered set where petPlan = &#63;.
	 *
	 * @param petRateId the primary key of the current pet rate
	 * @param petPlan the pet plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet rate
	 * @throws NoSuchPetRateException if a pet rate with the primary key could not be found
	 */
	public static PetRate[] findByPlan_PrevAndNext(
			long petRateId, long petPlan,
			OrderByComparator<PetRate> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPetRateException {

		return getPersistence().findByPlan_PrevAndNext(
			petRateId, petPlan, orderByComparator);
	}

	/**
	 * Removes all the pet rates where petPlan = &#63; from the database.
	 *
	 * @param petPlan the pet plan
	 */
	public static void removeByPlan(long petPlan) {
		getPersistence().removeByPlan(petPlan);
	}

	/**
	 * Returns the number of pet rates where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @return the number of matching pet rates
	 */
	public static int countByPlan(long petPlan) {
		return getPersistence().countByPlan(petPlan);
	}

	/**
	 * Returns the pet rate where petPlan = &#63; and petRemarks = &#63; or throws a <code>NoSuchPetRateException</code> if it could not be found.
	 *
	 * @param petPlan the pet plan
	 * @param petRemarks the pet remarks
	 * @return the matching pet rate
	 * @throws NoSuchPetRateException if a matching pet rate could not be found
	 */
	public static PetRate findBysearchByPetPlanAndPetRemarks(
			long petPlan, long petRemarks)
		throws com.mypage.admin.product.exception.NoSuchPetRateException {

		return getPersistence().findBysearchByPetPlanAndPetRemarks(
			petPlan, petRemarks);
	}

	/**
	 * Returns the pet rate where petPlan = &#63; and petRemarks = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param petPlan the pet plan
	 * @param petRemarks the pet remarks
	 * @return the matching pet rate, or <code>null</code> if a matching pet rate could not be found
	 */
	public static PetRate fetchBysearchByPetPlanAndPetRemarks(
		long petPlan, long petRemarks) {

		return getPersistence().fetchBysearchByPetPlanAndPetRemarks(
			petPlan, petRemarks);
	}

	/**
	 * Returns the pet rate where petPlan = &#63; and petRemarks = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param petPlan the pet plan
	 * @param petRemarks the pet remarks
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet rate, or <code>null</code> if a matching pet rate could not be found
	 */
	public static PetRate fetchBysearchByPetPlanAndPetRemarks(
		long petPlan, long petRemarks, boolean useFinderCache) {

		return getPersistence().fetchBysearchByPetPlanAndPetRemarks(
			petPlan, petRemarks, useFinderCache);
	}

	/**
	 * Removes the pet rate where petPlan = &#63; and petRemarks = &#63; from the database.
	 *
	 * @param petPlan the pet plan
	 * @param petRemarks the pet remarks
	 * @return the pet rate that was removed
	 */
	public static PetRate removeBysearchByPetPlanAndPetRemarks(
			long petPlan, long petRemarks)
		throws com.mypage.admin.product.exception.NoSuchPetRateException {

		return getPersistence().removeBysearchByPetPlanAndPetRemarks(
			petPlan, petRemarks);
	}

	/**
	 * Returns the number of pet rates where petPlan = &#63; and petRemarks = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @param petRemarks the pet remarks
	 * @return the number of matching pet rates
	 */
	public static int countBysearchByPetPlanAndPetRemarks(
		long petPlan, long petRemarks) {

		return getPersistence().countBysearchByPetPlanAndPetRemarks(
			petPlan, petRemarks);
	}

	/**
	 * Caches the pet rate in the entity cache if it is enabled.
	 *
	 * @param petRate the pet rate
	 */
	public static void cacheResult(PetRate petRate) {
		getPersistence().cacheResult(petRate);
	}

	/**
	 * Caches the pet rates in the entity cache if it is enabled.
	 *
	 * @param petRates the pet rates
	 */
	public static void cacheResult(List<PetRate> petRates) {
		getPersistence().cacheResult(petRates);
	}

	/**
	 * Creates a new pet rate with the primary key. Does not add the pet rate to the database.
	 *
	 * @param petRateId the primary key for the new pet rate
	 * @return the new pet rate
	 */
	public static PetRate create(long petRateId) {
		return getPersistence().create(petRateId);
	}

	/**
	 * Removes the pet rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petRateId the primary key of the pet rate
	 * @return the pet rate that was removed
	 * @throws NoSuchPetRateException if a pet rate with the primary key could not be found
	 */
	public static PetRate remove(long petRateId)
		throws com.mypage.admin.product.exception.NoSuchPetRateException {

		return getPersistence().remove(petRateId);
	}

	public static PetRate updateImpl(PetRate petRate) {
		return getPersistence().updateImpl(petRate);
	}

	/**
	 * Returns the pet rate with the primary key or throws a <code>NoSuchPetRateException</code> if it could not be found.
	 *
	 * @param petRateId the primary key of the pet rate
	 * @return the pet rate
	 * @throws NoSuchPetRateException if a pet rate with the primary key could not be found
	 */
	public static PetRate findByPrimaryKey(long petRateId)
		throws com.mypage.admin.product.exception.NoSuchPetRateException {

		return getPersistence().findByPrimaryKey(petRateId);
	}

	/**
	 * Returns the pet rate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petRateId the primary key of the pet rate
	 * @return the pet rate, or <code>null</code> if a pet rate with the primary key could not be found
	 */
	public static PetRate fetchByPrimaryKey(long petRateId) {
		return getPersistence().fetchByPrimaryKey(petRateId);
	}

	/**
	 * Returns all the pet rates.
	 *
	 * @return the pet rates
	 */
	public static List<PetRate> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pet rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @return the range of pet rates
	 */
	public static List<PetRate> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pet rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pet rates
	 */
	public static List<PetRate> findAll(
		int start, int end, OrderByComparator<PetRate> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pet rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pet rates
	 */
	public static List<PetRate> findAll(
		int start, int end, OrderByComparator<PetRate> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pet rates from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pet rates.
	 *
	 * @return the number of pet rates
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PetRatePersistence getPersistence() {
		return _persistence;
	}

	private static volatile PetRatePersistence _persistence;

}