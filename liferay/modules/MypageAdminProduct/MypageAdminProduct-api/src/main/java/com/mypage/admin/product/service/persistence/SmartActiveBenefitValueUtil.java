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

import com.mypage.admin.product.model.SmartActiveBenefitValue;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the smart active benefit value service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.SmartActiveBenefitValuePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveBenefitValuePersistence
 * @generated
 */
public class SmartActiveBenefitValueUtil {

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
		SmartActiveBenefitValue smartActiveBenefitValue) {

		getPersistence().clearCache(smartActiveBenefitValue);
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
	public static Map<Serializable, SmartActiveBenefitValue> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SmartActiveBenefitValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SmartActiveBenefitValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SmartActiveBenefitValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SmartActiveBenefitValue> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SmartActiveBenefitValue update(
		SmartActiveBenefitValue smartActiveBenefitValue) {

		return getPersistence().update(smartActiveBenefitValue);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SmartActiveBenefitValue update(
		SmartActiveBenefitValue smartActiveBenefitValue,
		ServiceContext serviceContext) {

		return getPersistence().update(smartActiveBenefitValue, serviceContext);
	}

	/**
	 * Returns the smart active benefit value where value = &#63; or throws a <code>NoSuchSmartActiveBenefitValueException</code> if it could not be found.
	 *
	 * @param value the value
	 * @return the matching smart active benefit value
	 * @throws NoSuchSmartActiveBenefitValueException if a matching smart active benefit value could not be found
	 */
	public static SmartActiveBenefitValue findByValue(long value)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveBenefitValueException {

		return getPersistence().findByValue(value);
	}

	/**
	 * Returns the smart active benefit value where value = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param value the value
	 * @return the matching smart active benefit value, or <code>null</code> if a matching smart active benefit value could not be found
	 */
	public static SmartActiveBenefitValue fetchByValue(long value) {
		return getPersistence().fetchByValue(value);
	}

	/**
	 * Returns the smart active benefit value where value = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param value the value
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active benefit value, or <code>null</code> if a matching smart active benefit value could not be found
	 */
	public static SmartActiveBenefitValue fetchByValue(
		long value, boolean useFinderCache) {

		return getPersistence().fetchByValue(value, useFinderCache);
	}

	/**
	 * Removes the smart active benefit value where value = &#63; from the database.
	 *
	 * @param value the value
	 * @return the smart active benefit value that was removed
	 */
	public static SmartActiveBenefitValue removeByValue(long value)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveBenefitValueException {

		return getPersistence().removeByValue(value);
	}

	/**
	 * Returns the number of smart active benefit values where value = &#63;.
	 *
	 * @param value the value
	 * @return the number of matching smart active benefit values
	 */
	public static int countByValue(long value) {
		return getPersistence().countByValue(value);
	}

	/**
	 * Caches the smart active benefit value in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefitValue the smart active benefit value
	 */
	public static void cacheResult(
		SmartActiveBenefitValue smartActiveBenefitValue) {

		getPersistence().cacheResult(smartActiveBenefitValue);
	}

	/**
	 * Caches the smart active benefit values in the entity cache if it is enabled.
	 *
	 * @param smartActiveBenefitValues the smart active benefit values
	 */
	public static void cacheResult(
		List<SmartActiveBenefitValue> smartActiveBenefitValues) {

		getPersistence().cacheResult(smartActiveBenefitValues);
	}

	/**
	 * Creates a new smart active benefit value with the primary key. Does not add the smart active benefit value to the database.
	 *
	 * @param smartActiveBenefitValueId the primary key for the new smart active benefit value
	 * @return the new smart active benefit value
	 */
	public static SmartActiveBenefitValue create(
		long smartActiveBenefitValueId) {

		return getPersistence().create(smartActiveBenefitValueId);
	}

	/**
	 * Removes the smart active benefit value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveBenefitValueId the primary key of the smart active benefit value
	 * @return the smart active benefit value that was removed
	 * @throws NoSuchSmartActiveBenefitValueException if a smart active benefit value with the primary key could not be found
	 */
	public static SmartActiveBenefitValue remove(long smartActiveBenefitValueId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveBenefitValueException {

		return getPersistence().remove(smartActiveBenefitValueId);
	}

	public static SmartActiveBenefitValue updateImpl(
		SmartActiveBenefitValue smartActiveBenefitValue) {

		return getPersistence().updateImpl(smartActiveBenefitValue);
	}

	/**
	 * Returns the smart active benefit value with the primary key or throws a <code>NoSuchSmartActiveBenefitValueException</code> if it could not be found.
	 *
	 * @param smartActiveBenefitValueId the primary key of the smart active benefit value
	 * @return the smart active benefit value
	 * @throws NoSuchSmartActiveBenefitValueException if a smart active benefit value with the primary key could not be found
	 */
	public static SmartActiveBenefitValue findByPrimaryKey(
			long smartActiveBenefitValueId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveBenefitValueException {

		return getPersistence().findByPrimaryKey(smartActiveBenefitValueId);
	}

	/**
	 * Returns the smart active benefit value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveBenefitValueId the primary key of the smart active benefit value
	 * @return the smart active benefit value, or <code>null</code> if a smart active benefit value with the primary key could not be found
	 */
	public static SmartActiveBenefitValue fetchByPrimaryKey(
		long smartActiveBenefitValueId) {

		return getPersistence().fetchByPrimaryKey(smartActiveBenefitValueId);
	}

	/**
	 * Returns all the smart active benefit values.
	 *
	 * @return the smart active benefit values
	 */
	public static List<SmartActiveBenefitValue> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the smart active benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit values
	 * @param end the upper bound of the range of smart active benefit values (not inclusive)
	 * @return the range of smart active benefit values
	 */
	public static List<SmartActiveBenefitValue> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the smart active benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit values
	 * @param end the upper bound of the range of smart active benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active benefit values
	 */
	public static List<SmartActiveBenefitValue> findAll(
		int start, int end,
		OrderByComparator<SmartActiveBenefitValue> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart active benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit values
	 * @param end the upper bound of the range of smart active benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active benefit values
	 */
	public static List<SmartActiveBenefitValue> findAll(
		int start, int end,
		OrderByComparator<SmartActiveBenefitValue> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the smart active benefit values from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of smart active benefit values.
	 *
	 * @return the number of smart active benefit values
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SmartActiveBenefitValuePersistence getPersistence() {
		return _persistence;
	}

	private static volatile SmartActiveBenefitValuePersistence _persistence;

}