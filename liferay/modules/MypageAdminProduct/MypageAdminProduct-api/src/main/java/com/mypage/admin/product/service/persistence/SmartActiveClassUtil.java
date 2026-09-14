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

import com.mypage.admin.product.model.SmartActiveClass;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the smart active class service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.SmartActiveClassPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveClassPersistence
 * @generated
 */
public class SmartActiveClassUtil {

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
	public static void clearCache(SmartActiveClass smartActiveClass) {
		getPersistence().clearCache(smartActiveClass);
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
	public static Map<Serializable, SmartActiveClass> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SmartActiveClass> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SmartActiveClass> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SmartActiveClass> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SmartActiveClass> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SmartActiveClass update(SmartActiveClass smartActiveClass) {
		return getPersistence().update(smartActiveClass);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SmartActiveClass update(
		SmartActiveClass smartActiveClass, ServiceContext serviceContext) {

		return getPersistence().update(smartActiveClass, serviceContext);
	}

	/**
	 * Caches the smart active class in the entity cache if it is enabled.
	 *
	 * @param smartActiveClass the smart active class
	 */
	public static void cacheResult(SmartActiveClass smartActiveClass) {
		getPersistence().cacheResult(smartActiveClass);
	}

	/**
	 * Caches the smart active classes in the entity cache if it is enabled.
	 *
	 * @param smartActiveClasses the smart active classes
	 */
	public static void cacheResult(List<SmartActiveClass> smartActiveClasses) {
		getPersistence().cacheResult(smartActiveClasses);
	}

	/**
	 * Creates a new smart active class with the primary key. Does not add the smart active class to the database.
	 *
	 * @param smartActiveClassId the primary key for the new smart active class
	 * @return the new smart active class
	 */
	public static SmartActiveClass create(long smartActiveClassId) {
		return getPersistence().create(smartActiveClassId);
	}

	/**
	 * Removes the smart active class with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveClassId the primary key of the smart active class
	 * @return the smart active class that was removed
	 * @throws NoSuchSmartActiveClassException if a smart active class with the primary key could not be found
	 */
	public static SmartActiveClass remove(long smartActiveClassId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveClassException {

		return getPersistence().remove(smartActiveClassId);
	}

	public static SmartActiveClass updateImpl(
		SmartActiveClass smartActiveClass) {

		return getPersistence().updateImpl(smartActiveClass);
	}

	/**
	 * Returns the smart active class with the primary key or throws a <code>NoSuchSmartActiveClassException</code> if it could not be found.
	 *
	 * @param smartActiveClassId the primary key of the smart active class
	 * @return the smart active class
	 * @throws NoSuchSmartActiveClassException if a smart active class with the primary key could not be found
	 */
	public static SmartActiveClass findByPrimaryKey(long smartActiveClassId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartActiveClassException {

		return getPersistence().findByPrimaryKey(smartActiveClassId);
	}

	/**
	 * Returns the smart active class with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveClassId the primary key of the smart active class
	 * @return the smart active class, or <code>null</code> if a smart active class with the primary key could not be found
	 */
	public static SmartActiveClass fetchByPrimaryKey(long smartActiveClassId) {
		return getPersistence().fetchByPrimaryKey(smartActiveClassId);
	}

	/**
	 * Returns all the smart active classes.
	 *
	 * @return the smart active classes
	 */
	public static List<SmartActiveClass> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the smart active classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active classes
	 * @param end the upper bound of the range of smart active classes (not inclusive)
	 * @return the range of smart active classes
	 */
	public static List<SmartActiveClass> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the smart active classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active classes
	 * @param end the upper bound of the range of smart active classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active classes
	 */
	public static List<SmartActiveClass> findAll(
		int start, int end,
		OrderByComparator<SmartActiveClass> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the smart active classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveClassModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active classes
	 * @param end the upper bound of the range of smart active classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active classes
	 */
	public static List<SmartActiveClass> findAll(
		int start, int end,
		OrderByComparator<SmartActiveClass> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the smart active classes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of smart active classes.
	 *
	 * @return the number of smart active classes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SmartActiveClassPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SmartActiveClassPersistence _persistence;

}