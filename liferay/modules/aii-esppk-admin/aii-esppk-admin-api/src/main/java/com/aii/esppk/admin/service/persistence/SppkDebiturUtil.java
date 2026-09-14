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

package com.aii.esppk.admin.service.persistence;

import com.aii.esppk.admin.model.SppkDebitur;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the sppk debitur service. This utility wraps <code>com.aii.esppk.admin.service.persistence.impl.SppkDebiturPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see SppkDebiturPersistence
 * @generated
 */
public class SppkDebiturUtil {

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
	public static void clearCache(SppkDebitur sppkDebitur) {
		getPersistence().clearCache(sppkDebitur);
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
	public static Map<Serializable, SppkDebitur> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SppkDebitur> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SppkDebitur> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SppkDebitur> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SppkDebitur> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SppkDebitur update(SppkDebitur sppkDebitur) {
		return getPersistence().update(sppkDebitur);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SppkDebitur update(
		SppkDebitur sppkDebitur, ServiceContext serviceContext) {

		return getPersistence().update(sppkDebitur, serviceContext);
	}

	/**
	 * Caches the sppk debitur in the entity cache if it is enabled.
	 *
	 * @param sppkDebitur the sppk debitur
	 */
	public static void cacheResult(SppkDebitur sppkDebitur) {
		getPersistence().cacheResult(sppkDebitur);
	}

	/**
	 * Caches the sppk debiturs in the entity cache if it is enabled.
	 *
	 * @param sppkDebiturs the sppk debiturs
	 */
	public static void cacheResult(List<SppkDebitur> sppkDebiturs) {
		getPersistence().cacheResult(sppkDebiturs);
	}

	/**
	 * Creates a new sppk debitur with the primary key. Does not add the sppk debitur to the database.
	 *
	 * @param sppkDebiturId the primary key for the new sppk debitur
	 * @return the new sppk debitur
	 */
	public static SppkDebitur create(long sppkDebiturId) {
		return getPersistence().create(sppkDebiturId);
	}

	/**
	 * Removes the sppk debitur with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sppkDebiturId the primary key of the sppk debitur
	 * @return the sppk debitur that was removed
	 * @throws NoSuchSppkDebiturException if a sppk debitur with the primary key could not be found
	 */
	public static SppkDebitur remove(long sppkDebiturId)
		throws com.aii.esppk.admin.exception.NoSuchSppkDebiturException {

		return getPersistence().remove(sppkDebiturId);
	}

	public static SppkDebitur updateImpl(SppkDebitur sppkDebitur) {
		return getPersistence().updateImpl(sppkDebitur);
	}

	/**
	 * Returns the sppk debitur with the primary key or throws a <code>NoSuchSppkDebiturException</code> if it could not be found.
	 *
	 * @param sppkDebiturId the primary key of the sppk debitur
	 * @return the sppk debitur
	 * @throws NoSuchSppkDebiturException if a sppk debitur with the primary key could not be found
	 */
	public static SppkDebitur findByPrimaryKey(long sppkDebiturId)
		throws com.aii.esppk.admin.exception.NoSuchSppkDebiturException {

		return getPersistence().findByPrimaryKey(sppkDebiturId);
	}

	/**
	 * Returns the sppk debitur with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sppkDebiturId the primary key of the sppk debitur
	 * @return the sppk debitur, or <code>null</code> if a sppk debitur with the primary key could not be found
	 */
	public static SppkDebitur fetchByPrimaryKey(long sppkDebiturId) {
		return getPersistence().fetchByPrimaryKey(sppkDebiturId);
	}

	/**
	 * Returns all the sppk debiturs.
	 *
	 * @return the sppk debiturs
	 */
	public static List<SppkDebitur> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sppk debiturs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkDebiturModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sppk debiturs
	 * @param end the upper bound of the range of sppk debiturs (not inclusive)
	 * @return the range of sppk debiturs
	 */
	public static List<SppkDebitur> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sppk debiturs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkDebiturModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sppk debiturs
	 * @param end the upper bound of the range of sppk debiturs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sppk debiturs
	 */
	public static List<SppkDebitur> findAll(
		int start, int end, OrderByComparator<SppkDebitur> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sppk debiturs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkDebiturModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sppk debiturs
	 * @param end the upper bound of the range of sppk debiturs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sppk debiturs
	 */
	public static List<SppkDebitur> findAll(
		int start, int end, OrderByComparator<SppkDebitur> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sppk debiturs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sppk debiturs.
	 *
	 * @return the number of sppk debiturs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SppkDebiturPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SppkDebiturPersistence _persistence;

}