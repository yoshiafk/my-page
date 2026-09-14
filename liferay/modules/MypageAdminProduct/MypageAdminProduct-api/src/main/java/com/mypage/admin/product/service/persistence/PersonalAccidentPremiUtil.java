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

import com.mypage.admin.product.model.PersonalAccidentPremi;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the personal accident premi service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.PersonalAccidentPremiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PersonalAccidentPremiPersistence
 * @generated
 */
public class PersonalAccidentPremiUtil {

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
	public static void clearCache(PersonalAccidentPremi personalAccidentPremi) {
		getPersistence().clearCache(personalAccidentPremi);
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
	public static Map<Serializable, PersonalAccidentPremi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PersonalAccidentPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PersonalAccidentPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PersonalAccidentPremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PersonalAccidentPremi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PersonalAccidentPremi update(
		PersonalAccidentPremi personalAccidentPremi) {

		return getPersistence().update(personalAccidentPremi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PersonalAccidentPremi update(
		PersonalAccidentPremi personalAccidentPremi,
		ServiceContext serviceContext) {

		return getPersistence().update(personalAccidentPremi, serviceContext);
	}

	/**
	 * Caches the personal accident premi in the entity cache if it is enabled.
	 *
	 * @param personalAccidentPremi the personal accident premi
	 */
	public static void cacheResult(
		PersonalAccidentPremi personalAccidentPremi) {

		getPersistence().cacheResult(personalAccidentPremi);
	}

	/**
	 * Caches the personal accident premis in the entity cache if it is enabled.
	 *
	 * @param personalAccidentPremis the personal accident premis
	 */
	public static void cacheResult(
		List<PersonalAccidentPremi> personalAccidentPremis) {

		getPersistence().cacheResult(personalAccidentPremis);
	}

	/**
	 * Creates a new personal accident premi with the primary key. Does not add the personal accident premi to the database.
	 *
	 * @param personalAccidentPremiId the primary key for the new personal accident premi
	 * @return the new personal accident premi
	 */
	public static PersonalAccidentPremi create(long personalAccidentPremiId) {
		return getPersistence().create(personalAccidentPremiId);
	}

	/**
	 * Removes the personal accident premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personalAccidentPremiId the primary key of the personal accident premi
	 * @return the personal accident premi that was removed
	 * @throws NoSuchPersonalAccidentPremiException if a personal accident premi with the primary key could not be found
	 */
	public static PersonalAccidentPremi remove(long personalAccidentPremiId)
		throws com.mypage.admin.product.exception.
			NoSuchPersonalAccidentPremiException {

		return getPersistence().remove(personalAccidentPremiId);
	}

	public static PersonalAccidentPremi updateImpl(
		PersonalAccidentPremi personalAccidentPremi) {

		return getPersistence().updateImpl(personalAccidentPremi);
	}

	/**
	 * Returns the personal accident premi with the primary key or throws a <code>NoSuchPersonalAccidentPremiException</code> if it could not be found.
	 *
	 * @param personalAccidentPremiId the primary key of the personal accident premi
	 * @return the personal accident premi
	 * @throws NoSuchPersonalAccidentPremiException if a personal accident premi with the primary key could not be found
	 */
	public static PersonalAccidentPremi findByPrimaryKey(
			long personalAccidentPremiId)
		throws com.mypage.admin.product.exception.
			NoSuchPersonalAccidentPremiException {

		return getPersistence().findByPrimaryKey(personalAccidentPremiId);
	}

	/**
	 * Returns the personal accident premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personalAccidentPremiId the primary key of the personal accident premi
	 * @return the personal accident premi, or <code>null</code> if a personal accident premi with the primary key could not be found
	 */
	public static PersonalAccidentPremi fetchByPrimaryKey(
		long personalAccidentPremiId) {

		return getPersistence().fetchByPrimaryKey(personalAccidentPremiId);
	}

	/**
	 * Returns all the personal accident premis.
	 *
	 * @return the personal accident premis
	 */
	public static List<PersonalAccidentPremi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the personal accident premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalAccidentPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal accident premis
	 * @param end the upper bound of the range of personal accident premis (not inclusive)
	 * @return the range of personal accident premis
	 */
	public static List<PersonalAccidentPremi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the personal accident premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalAccidentPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal accident premis
	 * @param end the upper bound of the range of personal accident premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of personal accident premis
	 */
	public static List<PersonalAccidentPremi> findAll(
		int start, int end,
		OrderByComparator<PersonalAccidentPremi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the personal accident premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonalAccidentPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal accident premis
	 * @param end the upper bound of the range of personal accident premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of personal accident premis
	 */
	public static List<PersonalAccidentPremi> findAll(
		int start, int end,
		OrderByComparator<PersonalAccidentPremi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the personal accident premis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of personal accident premis.
	 *
	 * @return the number of personal accident premis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PersonalAccidentPremiPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PersonalAccidentPremiPersistence _persistence;

}