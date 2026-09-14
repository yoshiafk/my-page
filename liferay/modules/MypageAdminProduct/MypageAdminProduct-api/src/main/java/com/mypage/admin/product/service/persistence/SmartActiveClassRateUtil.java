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

import com.mypage.admin.product.model.SmartActiveClassRate;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the smart active class rate service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.SmartActiveClassRatePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveClassRatePersistence
 * @generated
 */
public class SmartActiveClassRateUtil {

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
	public static void clearCache(SmartActiveClassRate smartActiveClassRate) {
		getPersistence().clearCache(smartActiveClassRate);
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
	public static Map<Serializable, SmartActiveClassRate> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SmartActiveClassRate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SmartActiveClassRate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SmartActiveClassRate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SmartActiveClassRate> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SmartActiveClassRate update(
		SmartActiveClassRate smartActiveClassRate) {

		return getPersistence().update(smartActiveClassRate);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SmartActiveClassRate update(
		SmartActiveClassRate smartActiveClassRate,
		ServiceContext serviceContext) {

		return getPersistence().update(smartActiveClassRate, serviceContext);
	}

	/**
	 * Caches the smart active class rate in the entity cache if it is enabled.
	 *
	 * @param smartActiveClassRate the smart active class rate
	 */
	public static void cacheResult(SmartActiveClassRate smartActiveClassRate) {
		getPersistence().cacheResult(smartActiveClassRate);
	}

	/**
	 * Caches the smart active class rates in the entity cache if it is enabled.
	 *
	 * @param smartActiveClassRates the smart active class rates
	 */
	public static void cacheResult(
		List<SmartActiveClassRate> smartActiveClassRates) {

		getPersistence().cacheResult(smartActiveClassRates);
	}

	/**
	 * Creates a new smart active class rate with the primary key. Does not add the smart active class rate to the database.
	 *
	 * @param smartActiveClassRateId the primary key for the new smart active class rate
	 * @return the new smart active class rate
	 */
	public static SmartActiveClassRate create(long smartActiveClassRateId) {
		return getPersistence().create(smartActiveClassRateId);
	}

	/**
	 * Removes the smart active class rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveClassRateId the primary key of the smart active class rate
	 * @return the smart active class rate that was removed
	 * @throws NoSuchSmartActiveClassRateException if a smart active class rate with the primary key could not be found
	 */
	public static SmartActiveClassRate remove(long smartActiveClassRateId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveClassRateException {

		return getPersistence().remove(smartActiveClassRateId);
	}

	public static SmartActiveClassRate updateImpl(
		SmartActiveClassRate smartActiveClassRate) {

		return getPersistence().updateImpl(smartActiveClassRate);
	}

	/**
	 * Returns the smart active class rate with the primary key or throws a <code>NoSuchSmartActiveClassRateException</code> if it could not be found.
	 *
	 * @param smartActiveClassRateId the primary key of the smart active class rate
	 * @return the smart active class rate
	 * @throws NoSuchSmartActiveClassRateException if a smart active class rate with the primary key could not be found
	 */
	public static SmartActiveClassRate findByPrimaryKey(
			long smartActiveClassRateId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveClassRateException {

		return getPersistence().findByPrimaryKey(smartActiveClassRateId);
	}

	/**
	 * Returns the smart active class rate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveClassRateId the primary key of the smart active class rate
	 * @return the smart active class rate, or <code>null</code> if a smart active class rate with the primary key could not be found
	 */
	public static SmartActiveClassRate fetchByPrimaryKey(
		long smartActiveClassRateId) {

		return getPersistence().fetchByPrimaryKey(smartActiveClassRateId);
	}

	/**
	 * Returns all the smart active class rates.
	 *
	 * @return the smart active class rates
	 */
	public static List<SmartActiveClassRate> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the smart active class rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active class rates
	 * @param end the upper bound of the range of smart active class rates (not inclusive)
	 * @return the range of smart active class rates
	 */
	public static List<SmartActiveClassRate> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the smart active class rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active class rates
	 * @param end the upper bound of the range of smart active class rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active class rates
	 */
	public static List<SmartActiveClassRate> findAll(
		int start, int end,
		OrderByComparator<SmartActiveClassRate> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart active class rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active class rates
	 * @param end the upper bound of the range of smart active class rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active class rates
	 */
	public static List<SmartActiveClassRate> findAll(
		int start, int end,
		OrderByComparator<SmartActiveClassRate> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the smart active class rates from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of smart active class rates.
	 *
	 * @return the number of smart active class rates
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SmartActiveClassRatePersistence getPersistence() {
		return _persistence;
	}

	private static volatile SmartActiveClassRatePersistence _persistence;

}