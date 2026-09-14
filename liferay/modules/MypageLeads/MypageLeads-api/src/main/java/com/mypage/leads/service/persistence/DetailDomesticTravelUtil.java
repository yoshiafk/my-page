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

import com.mypage.leads.model.DetailDomesticTravel;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the detail domestic travel service. This utility wraps <code>com.mypage.leads.service.persistence.impl.DetailDomesticTravelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see DetailDomesticTravelPersistence
 * @generated
 */
public class DetailDomesticTravelUtil {

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
	public static void clearCache(DetailDomesticTravel detailDomesticTravel) {
		getPersistence().clearCache(detailDomesticTravel);
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
	public static Map<Serializable, DetailDomesticTravel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DetailDomesticTravel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DetailDomesticTravel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DetailDomesticTravel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DetailDomesticTravel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DetailDomesticTravel update(
		DetailDomesticTravel detailDomesticTravel) {

		return getPersistence().update(detailDomesticTravel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DetailDomesticTravel update(
		DetailDomesticTravel detailDomesticTravel,
		ServiceContext serviceContext) {

		return getPersistence().update(detailDomesticTravel, serviceContext);
	}

	/**
	 * Returns the detail domestic travel where LeadsId = &#63; or throws a <code>NoSuchDetailDomesticTravelException</code> if it could not be found.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail domestic travel
	 * @throws NoSuchDetailDomesticTravelException if a matching detail domestic travel could not be found
	 */
	public static DetailDomesticTravel findBysearchByLeadsId(long LeadsId)
		throws com.mypage.leads.exception.NoSuchDetailDomesticTravelException {

		return getPersistence().findBysearchByLeadsId(LeadsId);
	}

	/**
	 * Returns the detail domestic travel where LeadsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail domestic travel, or <code>null</code> if a matching detail domestic travel could not be found
	 */
	public static DetailDomesticTravel fetchBysearchByLeadsId(long LeadsId) {
		return getPersistence().fetchBysearchByLeadsId(LeadsId);
	}

	/**
	 * Returns the detail domestic travel where LeadsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching detail domestic travel, or <code>null</code> if a matching detail domestic travel could not be found
	 */
	public static DetailDomesticTravel fetchBysearchByLeadsId(
		long LeadsId, boolean useFinderCache) {

		return getPersistence().fetchBysearchByLeadsId(LeadsId, useFinderCache);
	}

	/**
	 * Removes the detail domestic travel where LeadsId = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 * @return the detail domestic travel that was removed
	 */
	public static DetailDomesticTravel removeBysearchByLeadsId(long LeadsId)
		throws com.mypage.leads.exception.NoSuchDetailDomesticTravelException {

		return getPersistence().removeBysearchByLeadsId(LeadsId);
	}

	/**
	 * Returns the number of detail domestic travels where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the number of matching detail domestic travels
	 */
	public static int countBysearchByLeadsId(long LeadsId) {
		return getPersistence().countBysearchByLeadsId(LeadsId);
	}

	/**
	 * Caches the detail domestic travel in the entity cache if it is enabled.
	 *
	 * @param detailDomesticTravel the detail domestic travel
	 */
	public static void cacheResult(DetailDomesticTravel detailDomesticTravel) {
		getPersistence().cacheResult(detailDomesticTravel);
	}

	/**
	 * Caches the detail domestic travels in the entity cache if it is enabled.
	 *
	 * @param detailDomesticTravels the detail domestic travels
	 */
	public static void cacheResult(
		List<DetailDomesticTravel> detailDomesticTravels) {

		getPersistence().cacheResult(detailDomesticTravels);
	}

	/**
	 * Creates a new detail domestic travel with the primary key. Does not add the detail domestic travel to the database.
	 *
	 * @param detailDomesticTravelId the primary key for the new detail domestic travel
	 * @return the new detail domestic travel
	 */
	public static DetailDomesticTravel create(long detailDomesticTravelId) {
		return getPersistence().create(detailDomesticTravelId);
	}

	/**
	 * Removes the detail domestic travel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param detailDomesticTravelId the primary key of the detail domestic travel
	 * @return the detail domestic travel that was removed
	 * @throws NoSuchDetailDomesticTravelException if a detail domestic travel with the primary key could not be found
	 */
	public static DetailDomesticTravel remove(long detailDomesticTravelId)
		throws com.mypage.leads.exception.NoSuchDetailDomesticTravelException {

		return getPersistence().remove(detailDomesticTravelId);
	}

	public static DetailDomesticTravel updateImpl(
		DetailDomesticTravel detailDomesticTravel) {

		return getPersistence().updateImpl(detailDomesticTravel);
	}

	/**
	 * Returns the detail domestic travel with the primary key or throws a <code>NoSuchDetailDomesticTravelException</code> if it could not be found.
	 *
	 * @param detailDomesticTravelId the primary key of the detail domestic travel
	 * @return the detail domestic travel
	 * @throws NoSuchDetailDomesticTravelException if a detail domestic travel with the primary key could not be found
	 */
	public static DetailDomesticTravel findByPrimaryKey(
			long detailDomesticTravelId)
		throws com.mypage.leads.exception.NoSuchDetailDomesticTravelException {

		return getPersistence().findByPrimaryKey(detailDomesticTravelId);
	}

	/**
	 * Returns the detail domestic travel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param detailDomesticTravelId the primary key of the detail domestic travel
	 * @return the detail domestic travel, or <code>null</code> if a detail domestic travel with the primary key could not be found
	 */
	public static DetailDomesticTravel fetchByPrimaryKey(
		long detailDomesticTravelId) {

		return getPersistence().fetchByPrimaryKey(detailDomesticTravelId);
	}

	/**
	 * Returns all the detail domestic travels.
	 *
	 * @return the detail domestic travels
	 */
	public static List<DetailDomesticTravel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the detail domestic travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDomesticTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail domestic travels
	 * @param end the upper bound of the range of detail domestic travels (not inclusive)
	 * @return the range of detail domestic travels
	 */
	public static List<DetailDomesticTravel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the detail domestic travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDomesticTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail domestic travels
	 * @param end the upper bound of the range of detail domestic travels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail domestic travels
	 */
	public static List<DetailDomesticTravel> findAll(
		int start, int end,
		OrderByComparator<DetailDomesticTravel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the detail domestic travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDomesticTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail domestic travels
	 * @param end the upper bound of the range of detail domestic travels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail domestic travels
	 */
	public static List<DetailDomesticTravel> findAll(
		int start, int end,
		OrderByComparator<DetailDomesticTravel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the detail domestic travels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of detail domestic travels.
	 *
	 * @return the number of detail domestic travels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DetailDomesticTravelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DetailDomesticTravelPersistence _persistence;

}