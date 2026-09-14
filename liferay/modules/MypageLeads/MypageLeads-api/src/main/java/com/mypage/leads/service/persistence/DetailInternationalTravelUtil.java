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

package com.mypage.leads.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.leads.model.DetailInternationalTravel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the detail international travel service. This utility wraps <code>com.mypage.leads.service.persistence.impl.DetailInternationalTravelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see DetailInternationalTravelPersistence
 * @generated
 */
public class DetailInternationalTravelUtil {

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
	public static void clearCache(
		DetailInternationalTravel detailInternationalTravel) {

		getPersistence().clearCache(detailInternationalTravel);
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
	public static Map<Serializable, DetailInternationalTravel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DetailInternationalTravel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DetailInternationalTravel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DetailInternationalTravel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DetailInternationalTravel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DetailInternationalTravel update(
		DetailInternationalTravel detailInternationalTravel) {

		return getPersistence().update(detailInternationalTravel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DetailInternationalTravel update(
		DetailInternationalTravel detailInternationalTravel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			detailInternationalTravel, serviceContext);
	}

	/**
	 * Returns the detail international travel where LeadsId = &#63; or throws a <code>NoSuchDetailInternationalTravelException</code> if it could not be found.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail international travel
	 * @throws NoSuchDetailInternationalTravelException if a matching detail international travel could not be found
	 */
	public static DetailInternationalTravel findBysearchByLeadsId(long LeadsId)
		throws com.mypage.leads.exception.
			NoSuchDetailInternationalTravelException {

		return getPersistence().findBysearchByLeadsId(LeadsId);
	}

	/**
	 * Returns the detail international travel where LeadsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail international travel, or <code>null</code> if a matching detail international travel could not be found
	 */
	public static DetailInternationalTravel fetchBysearchByLeadsId(
		long LeadsId) {

		return getPersistence().fetchBysearchByLeadsId(LeadsId);
	}

	/**
	 * Returns the detail international travel where LeadsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching detail international travel, or <code>null</code> if a matching detail international travel could not be found
	 */
	public static DetailInternationalTravel fetchBysearchByLeadsId(
		long LeadsId, boolean useFinderCache) {

		return getPersistence().fetchBysearchByLeadsId(LeadsId, useFinderCache);
	}

	/**
	 * Removes the detail international travel where LeadsId = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 * @return the detail international travel that was removed
	 */
	public static DetailInternationalTravel removeBysearchByLeadsId(
			long LeadsId)
		throws com.mypage.leads.exception.
			NoSuchDetailInternationalTravelException {

		return getPersistence().removeBysearchByLeadsId(LeadsId);
	}

	/**
	 * Returns the number of detail international travels where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the number of matching detail international travels
	 */
	public static int countBysearchByLeadsId(long LeadsId) {
		return getPersistence().countBysearchByLeadsId(LeadsId);
	}

	/**
	 * Caches the detail international travel in the entity cache if it is enabled.
	 *
	 * @param detailInternationalTravel the detail international travel
	 */
	public static void cacheResult(
		DetailInternationalTravel detailInternationalTravel) {

		getPersistence().cacheResult(detailInternationalTravel);
	}

	/**
	 * Caches the detail international travels in the entity cache if it is enabled.
	 *
	 * @param detailInternationalTravels the detail international travels
	 */
	public static void cacheResult(
		List<DetailInternationalTravel> detailInternationalTravels) {

		getPersistence().cacheResult(detailInternationalTravels);
	}

	/**
	 * Creates a new detail international travel with the primary key. Does not add the detail international travel to the database.
	 *
	 * @param DetailId the primary key for the new detail international travel
	 * @return the new detail international travel
	 */
	public static DetailInternationalTravel create(long DetailId) {
		return getPersistence().create(DetailId);
	}

	/**
	 * Removes the detail international travel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param DetailId the primary key of the detail international travel
	 * @return the detail international travel that was removed
	 * @throws NoSuchDetailInternationalTravelException if a detail international travel with the primary key could not be found
	 */
	public static DetailInternationalTravel remove(long DetailId)
		throws com.mypage.leads.exception.
			NoSuchDetailInternationalTravelException {

		return getPersistence().remove(DetailId);
	}

	public static DetailInternationalTravel updateImpl(
		DetailInternationalTravel detailInternationalTravel) {

		return getPersistence().updateImpl(detailInternationalTravel);
	}

	/**
	 * Returns the detail international travel with the primary key or throws a <code>NoSuchDetailInternationalTravelException</code> if it could not be found.
	 *
	 * @param DetailId the primary key of the detail international travel
	 * @return the detail international travel
	 * @throws NoSuchDetailInternationalTravelException if a detail international travel with the primary key could not be found
	 */
	public static DetailInternationalTravel findByPrimaryKey(long DetailId)
		throws com.mypage.leads.exception.
			NoSuchDetailInternationalTravelException {

		return getPersistence().findByPrimaryKey(DetailId);
	}

	/**
	 * Returns the detail international travel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param DetailId the primary key of the detail international travel
	 * @return the detail international travel, or <code>null</code> if a detail international travel with the primary key could not be found
	 */
	public static DetailInternationalTravel fetchByPrimaryKey(long DetailId) {
		return getPersistence().fetchByPrimaryKey(DetailId);
	}

	/**
	 * Returns all the detail international travels.
	 *
	 * @return the detail international travels
	 */
	public static List<DetailInternationalTravel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the detail international travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailInternationalTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail international travels
	 * @param end the upper bound of the range of detail international travels (not inclusive)
	 * @return the range of detail international travels
	 */
	public static List<DetailInternationalTravel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the detail international travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailInternationalTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail international travels
	 * @param end the upper bound of the range of detail international travels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail international travels
	 */
	public static List<DetailInternationalTravel> findAll(
		int start, int end,
		OrderByComparator<DetailInternationalTravel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the detail international travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailInternationalTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail international travels
	 * @param end the upper bound of the range of detail international travels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail international travels
	 */
	public static List<DetailInternationalTravel> findAll(
		int start, int end,
		OrderByComparator<DetailInternationalTravel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the detail international travels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of detail international travels.
	 *
	 * @return the number of detail international travels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DetailInternationalTravelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DetailInternationalTravelPersistence _persistence;

}