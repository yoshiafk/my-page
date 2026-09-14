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

import com.mypage.admin.product.model.TravelIntBenefit;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the travel int benefit service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.TravelIntBenefitPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelIntBenefitPersistence
 * @generated
 */
public class TravelIntBenefitUtil {

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
	public static void clearCache(TravelIntBenefit travelIntBenefit) {
		getPersistence().clearCache(travelIntBenefit);
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
	public static Map<Serializable, TravelIntBenefit> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TravelIntBenefit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TravelIntBenefit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TravelIntBenefit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TravelIntBenefit> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TravelIntBenefit update(TravelIntBenefit travelIntBenefit) {
		return getPersistence().update(travelIntBenefit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TravelIntBenefit update(
		TravelIntBenefit travelIntBenefit, ServiceContext serviceContext) {

		return getPersistence().update(travelIntBenefit, serviceContext);
	}

	/**
	 * Caches the travel int benefit in the entity cache if it is enabled.
	 *
	 * @param travelIntBenefit the travel int benefit
	 */
	public static void cacheResult(TravelIntBenefit travelIntBenefit) {
		getPersistence().cacheResult(travelIntBenefit);
	}

	/**
	 * Caches the travel int benefits in the entity cache if it is enabled.
	 *
	 * @param travelIntBenefits the travel int benefits
	 */
	public static void cacheResult(List<TravelIntBenefit> travelIntBenefits) {
		getPersistence().cacheResult(travelIntBenefits);
	}

	/**
	 * Creates a new travel int benefit with the primary key. Does not add the travel int benefit to the database.
	 *
	 * @param travelIntBenefitId the primary key for the new travel int benefit
	 * @return the new travel int benefit
	 */
	public static TravelIntBenefit create(long travelIntBenefitId) {
		return getPersistence().create(travelIntBenefitId);
	}

	/**
	 * Removes the travel int benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelIntBenefitId the primary key of the travel int benefit
	 * @return the travel int benefit that was removed
	 * @throws NoSuchTravelIntBenefitException if a travel int benefit with the primary key could not be found
	 */
	public static TravelIntBenefit remove(long travelIntBenefitId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelIntBenefitException {

		return getPersistence().remove(travelIntBenefitId);
	}

	public static TravelIntBenefit updateImpl(
		TravelIntBenefit travelIntBenefit) {

		return getPersistence().updateImpl(travelIntBenefit);
	}

	/**
	 * Returns the travel int benefit with the primary key or throws a <code>NoSuchTravelIntBenefitException</code> if it could not be found.
	 *
	 * @param travelIntBenefitId the primary key of the travel int benefit
	 * @return the travel int benefit
	 * @throws NoSuchTravelIntBenefitException if a travel int benefit with the primary key could not be found
	 */
	public static TravelIntBenefit findByPrimaryKey(long travelIntBenefitId)
		throws com.mypage.admin.product.exception.
			NoSuchTravelIntBenefitException {

		return getPersistence().findByPrimaryKey(travelIntBenefitId);
	}

	/**
	 * Returns the travel int benefit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelIntBenefitId the primary key of the travel int benefit
	 * @return the travel int benefit, or <code>null</code> if a travel int benefit with the primary key could not be found
	 */
	public static TravelIntBenefit fetchByPrimaryKey(long travelIntBenefitId) {
		return getPersistence().fetchByPrimaryKey(travelIntBenefitId);
	}

	/**
	 * Returns all the travel int benefits.
	 *
	 * @return the travel int benefits
	 */
	public static List<TravelIntBenefit> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the travel int benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefits
	 * @param end the upper bound of the range of travel int benefits (not inclusive)
	 * @return the range of travel int benefits
	 */
	public static List<TravelIntBenefit> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the travel int benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefits
	 * @param end the upper bound of the range of travel int benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel int benefits
	 */
	public static List<TravelIntBenefit> findAll(
		int start, int end,
		OrderByComparator<TravelIntBenefit> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the travel int benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefits
	 * @param end the upper bound of the range of travel int benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel int benefits
	 */
	public static List<TravelIntBenefit> findAll(
		int start, int end,
		OrderByComparator<TravelIntBenefit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the travel int benefits from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of travel int benefits.
	 *
	 * @return the number of travel int benefits
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TravelIntBenefitPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TravelIntBenefitPersistence _persistence;

}