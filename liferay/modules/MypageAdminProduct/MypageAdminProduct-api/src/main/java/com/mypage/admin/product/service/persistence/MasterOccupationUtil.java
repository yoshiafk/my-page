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

import com.mypage.admin.product.model.MasterOccupation;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the master occupation service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.MasterOccupationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterOccupationPersistence
 * @generated
 */
public class MasterOccupationUtil {

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
	public static void clearCache(MasterOccupation masterOccupation) {
		getPersistence().clearCache(masterOccupation);
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
	public static Map<Serializable, MasterOccupation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MasterOccupation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MasterOccupation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MasterOccupation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MasterOccupation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MasterOccupation update(MasterOccupation masterOccupation) {
		return getPersistence().update(masterOccupation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MasterOccupation update(
		MasterOccupation masterOccupation, ServiceContext serviceContext) {

		return getPersistence().update(masterOccupation, serviceContext);
	}

	/**
	 * Returns all the master occupations where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching master occupations
	 */
	public static List<MasterOccupation> findBysearchByActive(Integer active) {
		return getPersistence().findBysearchByActive(active);
	}

	/**
	 * Returns a range of all the master occupations where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @return the range of matching master occupations
	 */
	public static List<MasterOccupation> findBysearchByActive(
		Integer active, int start, int end) {

		return getPersistence().findBysearchByActive(active, start, end);
	}

	/**
	 * Returns an ordered range of all the master occupations where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master occupations
	 */
	public static List<MasterOccupation> findBysearchByActive(
		Integer active, int start, int end,
		OrderByComparator<MasterOccupation> orderByComparator) {

		return getPersistence().findBysearchByActive(
			active, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master occupations where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master occupations
	 */
	public static List<MasterOccupation> findBysearchByActive(
		Integer active, int start, int end,
		OrderByComparator<MasterOccupation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchByActive(
			active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first master occupation in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation
	 * @throws NoSuchMasterOccupationException if a matching master occupation could not be found
	 */
	public static MasterOccupation findBysearchByActive_First(
			Integer active,
			OrderByComparator<MasterOccupation> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationException {

		return getPersistence().findBysearchByActive_First(
			active, orderByComparator);
	}

	/**
	 * Returns the first master occupation in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation, or <code>null</code> if a matching master occupation could not be found
	 */
	public static MasterOccupation fetchBysearchByActive_First(
		Integer active, OrderByComparator<MasterOccupation> orderByComparator) {

		return getPersistence().fetchBysearchByActive_First(
			active, orderByComparator);
	}

	/**
	 * Returns the last master occupation in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation
	 * @throws NoSuchMasterOccupationException if a matching master occupation could not be found
	 */
	public static MasterOccupation findBysearchByActive_Last(
			Integer active,
			OrderByComparator<MasterOccupation> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationException {

		return getPersistence().findBysearchByActive_Last(
			active, orderByComparator);
	}

	/**
	 * Returns the last master occupation in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation, or <code>null</code> if a matching master occupation could not be found
	 */
	public static MasterOccupation fetchBysearchByActive_Last(
		Integer active, OrderByComparator<MasterOccupation> orderByComparator) {

		return getPersistence().fetchBysearchByActive_Last(
			active, orderByComparator);
	}

	/**
	 * Returns the master occupations before and after the current master occupation in the ordered set where active = &#63;.
	 *
	 * @param masterOccupationId the primary key of the current master occupation
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master occupation
	 * @throws NoSuchMasterOccupationException if a master occupation with the primary key could not be found
	 */
	public static MasterOccupation[] findBysearchByActive_PrevAndNext(
			long masterOccupationId, Integer active,
			OrderByComparator<MasterOccupation> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationException {

		return getPersistence().findBysearchByActive_PrevAndNext(
			masterOccupationId, active, orderByComparator);
	}

	/**
	 * Removes all the master occupations where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public static void removeBysearchByActive(Integer active) {
		getPersistence().removeBysearchByActive(active);
	}

	/**
	 * Returns the number of master occupations where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching master occupations
	 */
	public static int countBysearchByActive(Integer active) {
		return getPersistence().countBysearchByActive(active);
	}

	/**
	 * Returns all the master occupations where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @return the matching master occupations
	 */
	public static List<MasterOccupation>
		findBysearchByMasterOccupationCategoryId(
			long masterOccupationCategoryId) {

		return getPersistence().findBysearchByMasterOccupationCategoryId(
			masterOccupationCategoryId);
	}

	/**
	 * Returns a range of all the master occupations where masterOccupationCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @return the range of matching master occupations
	 */
	public static List<MasterOccupation>
		findBysearchByMasterOccupationCategoryId(
			long masterOccupationCategoryId, int start, int end) {

		return getPersistence().findBysearchByMasterOccupationCategoryId(
			masterOccupationCategoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the master occupations where masterOccupationCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master occupations
	 */
	public static List<MasterOccupation>
		findBysearchByMasterOccupationCategoryId(
			long masterOccupationCategoryId, int start, int end,
			OrderByComparator<MasterOccupation> orderByComparator) {

		return getPersistence().findBysearchByMasterOccupationCategoryId(
			masterOccupationCategoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master occupations where masterOccupationCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master occupations
	 */
	public static List<MasterOccupation>
		findBysearchByMasterOccupationCategoryId(
			long masterOccupationCategoryId, int start, int end,
			OrderByComparator<MasterOccupation> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findBysearchByMasterOccupationCategoryId(
			masterOccupationCategoryId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first master occupation in the ordered set where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation
	 * @throws NoSuchMasterOccupationException if a matching master occupation could not be found
	 */
	public static MasterOccupation
			findBysearchByMasterOccupationCategoryId_First(
				long masterOccupationCategoryId,
				OrderByComparator<MasterOccupation> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationException {

		return getPersistence().findBysearchByMasterOccupationCategoryId_First(
			masterOccupationCategoryId, orderByComparator);
	}

	/**
	 * Returns the first master occupation in the ordered set where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation, or <code>null</code> if a matching master occupation could not be found
	 */
	public static MasterOccupation
		fetchBysearchByMasterOccupationCategoryId_First(
			long masterOccupationCategoryId,
			OrderByComparator<MasterOccupation> orderByComparator) {

		return getPersistence().fetchBysearchByMasterOccupationCategoryId_First(
			masterOccupationCategoryId, orderByComparator);
	}

	/**
	 * Returns the last master occupation in the ordered set where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation
	 * @throws NoSuchMasterOccupationException if a matching master occupation could not be found
	 */
	public static MasterOccupation
			findBysearchByMasterOccupationCategoryId_Last(
				long masterOccupationCategoryId,
				OrderByComparator<MasterOccupation> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationException {

		return getPersistence().findBysearchByMasterOccupationCategoryId_Last(
			masterOccupationCategoryId, orderByComparator);
	}

	/**
	 * Returns the last master occupation in the ordered set where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation, or <code>null</code> if a matching master occupation could not be found
	 */
	public static MasterOccupation
		fetchBysearchByMasterOccupationCategoryId_Last(
			long masterOccupationCategoryId,
			OrderByComparator<MasterOccupation> orderByComparator) {

		return getPersistence().fetchBysearchByMasterOccupationCategoryId_Last(
			masterOccupationCategoryId, orderByComparator);
	}

	/**
	 * Returns the master occupations before and after the current master occupation in the ordered set where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationId the primary key of the current master occupation
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master occupation
	 * @throws NoSuchMasterOccupationException if a master occupation with the primary key could not be found
	 */
	public static MasterOccupation[]
			findBysearchByMasterOccupationCategoryId_PrevAndNext(
				long masterOccupationId, long masterOccupationCategoryId,
				OrderByComparator<MasterOccupation> orderByComparator)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationException {

		return getPersistence().
			findBysearchByMasterOccupationCategoryId_PrevAndNext(
				masterOccupationId, masterOccupationCategoryId,
				orderByComparator);
	}

	/**
	 * Removes all the master occupations where masterOccupationCategoryId = &#63; from the database.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 */
	public static void removeBysearchByMasterOccupationCategoryId(
		long masterOccupationCategoryId) {

		getPersistence().removeBysearchByMasterOccupationCategoryId(
			masterOccupationCategoryId);
	}

	/**
	 * Returns the number of master occupations where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @return the number of matching master occupations
	 */
	public static int countBysearchByMasterOccupationCategoryId(
		long masterOccupationCategoryId) {

		return getPersistence().countBysearchByMasterOccupationCategoryId(
			masterOccupationCategoryId);
	}

	/**
	 * Caches the master occupation in the entity cache if it is enabled.
	 *
	 * @param masterOccupation the master occupation
	 */
	public static void cacheResult(MasterOccupation masterOccupation) {
		getPersistence().cacheResult(masterOccupation);
	}

	/**
	 * Caches the master occupations in the entity cache if it is enabled.
	 *
	 * @param masterOccupations the master occupations
	 */
	public static void cacheResult(List<MasterOccupation> masterOccupations) {
		getPersistence().cacheResult(masterOccupations);
	}

	/**
	 * Creates a new master occupation with the primary key. Does not add the master occupation to the database.
	 *
	 * @param masterOccupationId the primary key for the new master occupation
	 * @return the new master occupation
	 */
	public static MasterOccupation create(long masterOccupationId) {
		return getPersistence().create(masterOccupationId);
	}

	/**
	 * Removes the master occupation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterOccupationId the primary key of the master occupation
	 * @return the master occupation that was removed
	 * @throws NoSuchMasterOccupationException if a master occupation with the primary key could not be found
	 */
	public static MasterOccupation remove(long masterOccupationId)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationException {

		return getPersistence().remove(masterOccupationId);
	}

	public static MasterOccupation updateImpl(
		MasterOccupation masterOccupation) {

		return getPersistence().updateImpl(masterOccupation);
	}

	/**
	 * Returns the master occupation with the primary key or throws a <code>NoSuchMasterOccupationException</code> if it could not be found.
	 *
	 * @param masterOccupationId the primary key of the master occupation
	 * @return the master occupation
	 * @throws NoSuchMasterOccupationException if a master occupation with the primary key could not be found
	 */
	public static MasterOccupation findByPrimaryKey(long masterOccupationId)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationException {

		return getPersistence().findByPrimaryKey(masterOccupationId);
	}

	/**
	 * Returns the master occupation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterOccupationId the primary key of the master occupation
	 * @return the master occupation, or <code>null</code> if a master occupation with the primary key could not be found
	 */
	public static MasterOccupation fetchByPrimaryKey(long masterOccupationId) {
		return getPersistence().fetchByPrimaryKey(masterOccupationId);
	}

	/**
	 * Returns all the master occupations.
	 *
	 * @return the master occupations
	 */
	public static List<MasterOccupation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the master occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @return the range of master occupations
	 */
	public static List<MasterOccupation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the master occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master occupations
	 */
	public static List<MasterOccupation> findAll(
		int start, int end,
		OrderByComparator<MasterOccupation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master occupations
	 */
	public static List<MasterOccupation> findAll(
		int start, int end,
		OrderByComparator<MasterOccupation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the master occupations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of master occupations.
	 *
	 * @return the number of master occupations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MasterOccupationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MasterOccupationPersistence _persistence;

}