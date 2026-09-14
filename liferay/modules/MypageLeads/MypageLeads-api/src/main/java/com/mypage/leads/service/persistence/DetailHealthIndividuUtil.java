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

import com.mypage.leads.model.DetailHealthIndividu;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the detail health individu service. This utility wraps <code>com.mypage.leads.service.persistence.impl.DetailHealthIndividuPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see DetailHealthIndividuPersistence
 * @generated
 */
public class DetailHealthIndividuUtil {

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
	public static void clearCache(DetailHealthIndividu detailHealthIndividu) {
		getPersistence().clearCache(detailHealthIndividu);
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
	public static Map<Serializable, DetailHealthIndividu> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DetailHealthIndividu> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DetailHealthIndividu> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DetailHealthIndividu> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DetailHealthIndividu> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DetailHealthIndividu update(
		DetailHealthIndividu detailHealthIndividu) {

		return getPersistence().update(detailHealthIndividu);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DetailHealthIndividu update(
		DetailHealthIndividu detailHealthIndividu,
		ServiceContext serviceContext) {

		return getPersistence().update(detailHealthIndividu, serviceContext);
	}

	/**
	 * Returns the detail health individu where LeadsId = &#63; or throws a <code>NoSuchDetailHealthIndividuException</code> if it could not be found.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail health individu
	 * @throws NoSuchDetailHealthIndividuException if a matching detail health individu could not be found
	 */
	public static DetailHealthIndividu findBysearchByLeadsId(long LeadsId)
		throws com.mypage.leads.exception.NoSuchDetailHealthIndividuException {

		return getPersistence().findBysearchByLeadsId(LeadsId);
	}

	/**
	 * Returns the detail health individu where LeadsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail health individu, or <code>null</code> if a matching detail health individu could not be found
	 */
	public static DetailHealthIndividu fetchBysearchByLeadsId(long LeadsId) {
		return getPersistence().fetchBysearchByLeadsId(LeadsId);
	}

	/**
	 * Returns the detail health individu where LeadsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching detail health individu, or <code>null</code> if a matching detail health individu could not be found
	 */
	public static DetailHealthIndividu fetchBysearchByLeadsId(
		long LeadsId, boolean useFinderCache) {

		return getPersistence().fetchBysearchByLeadsId(LeadsId, useFinderCache);
	}

	/**
	 * Removes the detail health individu where LeadsId = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 * @return the detail health individu that was removed
	 */
	public static DetailHealthIndividu removeBysearchByLeadsId(long LeadsId)
		throws com.mypage.leads.exception.NoSuchDetailHealthIndividuException {

		return getPersistence().removeBysearchByLeadsId(LeadsId);
	}

	/**
	 * Returns the number of detail health individus where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the number of matching detail health individus
	 */
	public static int countBysearchByLeadsId(long LeadsId) {
		return getPersistence().countBysearchByLeadsId(LeadsId);
	}

	/**
	 * Caches the detail health individu in the entity cache if it is enabled.
	 *
	 * @param detailHealthIndividu the detail health individu
	 */
	public static void cacheResult(DetailHealthIndividu detailHealthIndividu) {
		getPersistence().cacheResult(detailHealthIndividu);
	}

	/**
	 * Caches the detail health individus in the entity cache if it is enabled.
	 *
	 * @param detailHealthIndividus the detail health individus
	 */
	public static void cacheResult(
		List<DetailHealthIndividu> detailHealthIndividus) {

		getPersistence().cacheResult(detailHealthIndividus);
	}

	/**
	 * Creates a new detail health individu with the primary key. Does not add the detail health individu to the database.
	 *
	 * @param detailHealthIndividuId the primary key for the new detail health individu
	 * @return the new detail health individu
	 */
	public static DetailHealthIndividu create(long detailHealthIndividuId) {
		return getPersistence().create(detailHealthIndividuId);
	}

	/**
	 * Removes the detail health individu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param detailHealthIndividuId the primary key of the detail health individu
	 * @return the detail health individu that was removed
	 * @throws NoSuchDetailHealthIndividuException if a detail health individu with the primary key could not be found
	 */
	public static DetailHealthIndividu remove(long detailHealthIndividuId)
		throws com.mypage.leads.exception.NoSuchDetailHealthIndividuException {

		return getPersistence().remove(detailHealthIndividuId);
	}

	public static DetailHealthIndividu updateImpl(
		DetailHealthIndividu detailHealthIndividu) {

		return getPersistence().updateImpl(detailHealthIndividu);
	}

	/**
	 * Returns the detail health individu with the primary key or throws a <code>NoSuchDetailHealthIndividuException</code> if it could not be found.
	 *
	 * @param detailHealthIndividuId the primary key of the detail health individu
	 * @return the detail health individu
	 * @throws NoSuchDetailHealthIndividuException if a detail health individu with the primary key could not be found
	 */
	public static DetailHealthIndividu findByPrimaryKey(
			long detailHealthIndividuId)
		throws com.mypage.leads.exception.NoSuchDetailHealthIndividuException {

		return getPersistence().findByPrimaryKey(detailHealthIndividuId);
	}

	/**
	 * Returns the detail health individu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param detailHealthIndividuId the primary key of the detail health individu
	 * @return the detail health individu, or <code>null</code> if a detail health individu with the primary key could not be found
	 */
	public static DetailHealthIndividu fetchByPrimaryKey(
		long detailHealthIndividuId) {

		return getPersistence().fetchByPrimaryKey(detailHealthIndividuId);
	}

	/**
	 * Returns all the detail health individus.
	 *
	 * @return the detail health individus
	 */
	public static List<DetailHealthIndividu> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the detail health individus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailHealthIndividuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail health individus
	 * @param end the upper bound of the range of detail health individus (not inclusive)
	 * @return the range of detail health individus
	 */
	public static List<DetailHealthIndividu> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the detail health individus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailHealthIndividuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail health individus
	 * @param end the upper bound of the range of detail health individus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail health individus
	 */
	public static List<DetailHealthIndividu> findAll(
		int start, int end,
		OrderByComparator<DetailHealthIndividu> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the detail health individus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailHealthIndividuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail health individus
	 * @param end the upper bound of the range of detail health individus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail health individus
	 */
	public static List<DetailHealthIndividu> findAll(
		int start, int end,
		OrderByComparator<DetailHealthIndividu> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the detail health individus from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of detail health individus.
	 *
	 * @return the number of detail health individus
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DetailHealthIndividuPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DetailHealthIndividuPersistence _persistence;

}