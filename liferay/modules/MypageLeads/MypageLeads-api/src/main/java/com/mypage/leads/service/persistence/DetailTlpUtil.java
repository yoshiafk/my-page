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

import com.mypage.leads.model.DetailTlp;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the detail tlp service. This utility wraps <code>com.mypage.leads.service.persistence.impl.DetailTlpPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see DetailTlpPersistence
 * @generated
 */
public class DetailTlpUtil {

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
	public static void clearCache(DetailTlp detailTlp) {
		getPersistence().clearCache(detailTlp);
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
	public static Map<Serializable, DetailTlp> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DetailTlp> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DetailTlp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DetailTlp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DetailTlp> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DetailTlp update(DetailTlp detailTlp) {
		return getPersistence().update(detailTlp);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DetailTlp update(
		DetailTlp detailTlp, ServiceContext serviceContext) {

		return getPersistence().update(detailTlp, serviceContext);
	}

	/**
	 * Returns all the detail tlps where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @return the matching detail tlps
	 */
	public static List<DetailTlp> findByleadsId(long leadsId) {
		return getPersistence().findByleadsId(leadsId);
	}

	/**
	 * Returns a range of all the detail tlps where leadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param leadsId the leads ID
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @return the range of matching detail tlps
	 */
	public static List<DetailTlp> findByleadsId(
		long leadsId, int start, int end) {

		return getPersistence().findByleadsId(leadsId, start, end);
	}

	/**
	 * Returns an ordered range of all the detail tlps where leadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param leadsId the leads ID
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching detail tlps
	 */
	public static List<DetailTlp> findByleadsId(
		long leadsId, int start, int end,
		OrderByComparator<DetailTlp> orderByComparator) {

		return getPersistence().findByleadsId(
			leadsId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the detail tlps where leadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param leadsId the leads ID
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching detail tlps
	 */
	public static List<DetailTlp> findByleadsId(
		long leadsId, int start, int end,
		OrderByComparator<DetailTlp> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByleadsId(
			leadsId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first detail tlp in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching detail tlp
	 * @throws NoSuchDetailTlpException if a matching detail tlp could not be found
	 */
	public static DetailTlp findByleadsId_First(
			long leadsId, OrderByComparator<DetailTlp> orderByComparator)
		throws com.mypage.leads.exception.NoSuchDetailTlpException {

		return getPersistence().findByleadsId_First(leadsId, orderByComparator);
	}

	/**
	 * Returns the first detail tlp in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching detail tlp, or <code>null</code> if a matching detail tlp could not be found
	 */
	public static DetailTlp fetchByleadsId_First(
		long leadsId, OrderByComparator<DetailTlp> orderByComparator) {

		return getPersistence().fetchByleadsId_First(
			leadsId, orderByComparator);
	}

	/**
	 * Returns the last detail tlp in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching detail tlp
	 * @throws NoSuchDetailTlpException if a matching detail tlp could not be found
	 */
	public static DetailTlp findByleadsId_Last(
			long leadsId, OrderByComparator<DetailTlp> orderByComparator)
		throws com.mypage.leads.exception.NoSuchDetailTlpException {

		return getPersistence().findByleadsId_Last(leadsId, orderByComparator);
	}

	/**
	 * Returns the last detail tlp in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching detail tlp, or <code>null</code> if a matching detail tlp could not be found
	 */
	public static DetailTlp fetchByleadsId_Last(
		long leadsId, OrderByComparator<DetailTlp> orderByComparator) {

		return getPersistence().fetchByleadsId_Last(leadsId, orderByComparator);
	}

	/**
	 * Returns the detail tlps before and after the current detail tlp in the ordered set where leadsId = &#63;.
	 *
	 * @param detailTlpId the primary key of the current detail tlp
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next detail tlp
	 * @throws NoSuchDetailTlpException if a detail tlp with the primary key could not be found
	 */
	public static DetailTlp[] findByleadsId_PrevAndNext(
			long detailTlpId, long leadsId,
			OrderByComparator<DetailTlp> orderByComparator)
		throws com.mypage.leads.exception.NoSuchDetailTlpException {

		return getPersistence().findByleadsId_PrevAndNext(
			detailTlpId, leadsId, orderByComparator);
	}

	/**
	 * Removes all the detail tlps where leadsId = &#63; from the database.
	 *
	 * @param leadsId the leads ID
	 */
	public static void removeByleadsId(long leadsId) {
		getPersistence().removeByleadsId(leadsId);
	}

	/**
	 * Returns the number of detail tlps where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @return the number of matching detail tlps
	 */
	public static int countByleadsId(long leadsId) {
		return getPersistence().countByleadsId(leadsId);
	}

	/**
	 * Caches the detail tlp in the entity cache if it is enabled.
	 *
	 * @param detailTlp the detail tlp
	 */
	public static void cacheResult(DetailTlp detailTlp) {
		getPersistence().cacheResult(detailTlp);
	}

	/**
	 * Caches the detail tlps in the entity cache if it is enabled.
	 *
	 * @param detailTlps the detail tlps
	 */
	public static void cacheResult(List<DetailTlp> detailTlps) {
		getPersistence().cacheResult(detailTlps);
	}

	/**
	 * Creates a new detail tlp with the primary key. Does not add the detail tlp to the database.
	 *
	 * @param detailTlpId the primary key for the new detail tlp
	 * @return the new detail tlp
	 */
	public static DetailTlp create(long detailTlpId) {
		return getPersistence().create(detailTlpId);
	}

	/**
	 * Removes the detail tlp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param detailTlpId the primary key of the detail tlp
	 * @return the detail tlp that was removed
	 * @throws NoSuchDetailTlpException if a detail tlp with the primary key could not be found
	 */
	public static DetailTlp remove(long detailTlpId)
		throws com.mypage.leads.exception.NoSuchDetailTlpException {

		return getPersistence().remove(detailTlpId);
	}

	public static DetailTlp updateImpl(DetailTlp detailTlp) {
		return getPersistence().updateImpl(detailTlp);
	}

	/**
	 * Returns the detail tlp with the primary key or throws a <code>NoSuchDetailTlpException</code> if it could not be found.
	 *
	 * @param detailTlpId the primary key of the detail tlp
	 * @return the detail tlp
	 * @throws NoSuchDetailTlpException if a detail tlp with the primary key could not be found
	 */
	public static DetailTlp findByPrimaryKey(long detailTlpId)
		throws com.mypage.leads.exception.NoSuchDetailTlpException {

		return getPersistence().findByPrimaryKey(detailTlpId);
	}

	/**
	 * Returns the detail tlp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param detailTlpId the primary key of the detail tlp
	 * @return the detail tlp, or <code>null</code> if a detail tlp with the primary key could not be found
	 */
	public static DetailTlp fetchByPrimaryKey(long detailTlpId) {
		return getPersistence().fetchByPrimaryKey(detailTlpId);
	}

	/**
	 * Returns all the detail tlps.
	 *
	 * @return the detail tlps
	 */
	public static List<DetailTlp> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the detail tlps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @return the range of detail tlps
	 */
	public static List<DetailTlp> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the detail tlps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail tlps
	 */
	public static List<DetailTlp> findAll(
		int start, int end, OrderByComparator<DetailTlp> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the detail tlps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail tlps
	 */
	public static List<DetailTlp> findAll(
		int start, int end, OrderByComparator<DetailTlp> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the detail tlps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of detail tlps.
	 *
	 * @return the number of detail tlps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DetailTlpPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DetailTlpPersistence _persistence;

}