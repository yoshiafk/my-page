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

import com.mypage.admin.product.model.HealthSmePremi;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the health sme premi service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.HealthSmePremiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see HealthSmePremiPersistence
 * @generated
 */
public class HealthSmePremiUtil {

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
	public static void clearCache(HealthSmePremi healthSmePremi) {
		getPersistence().clearCache(healthSmePremi);
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
	public static Map<Serializable, HealthSmePremi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<HealthSmePremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HealthSmePremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HealthSmePremi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<HealthSmePremi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static HealthSmePremi update(HealthSmePremi healthSmePremi) {
		return getPersistence().update(healthSmePremi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static HealthSmePremi update(
		HealthSmePremi healthSmePremi, ServiceContext serviceContext) {

		return getPersistence().update(healthSmePremi, serviceContext);
	}

	/**
	 * Caches the health sme premi in the entity cache if it is enabled.
	 *
	 * @param healthSmePremi the health sme premi
	 */
	public static void cacheResult(HealthSmePremi healthSmePremi) {
		getPersistence().cacheResult(healthSmePremi);
	}

	/**
	 * Caches the health sme premis in the entity cache if it is enabled.
	 *
	 * @param healthSmePremis the health sme premis
	 */
	public static void cacheResult(List<HealthSmePremi> healthSmePremis) {
		getPersistence().cacheResult(healthSmePremis);
	}

	/**
	 * Creates a new health sme premi with the primary key. Does not add the health sme premi to the database.
	 *
	 * @param healthSmePremiId the primary key for the new health sme premi
	 * @return the new health sme premi
	 */
	public static HealthSmePremi create(long healthSmePremiId) {
		return getPersistence().create(healthSmePremiId);
	}

	/**
	 * Removes the health sme premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param healthSmePremiId the primary key of the health sme premi
	 * @return the health sme premi that was removed
	 * @throws NoSuchHealthSmePremiException if a health sme premi with the primary key could not be found
	 */
	public static HealthSmePremi remove(long healthSmePremiId)
		throws com.mypage.admin.product.exception.
			NoSuchHealthSmePremiException {

		return getPersistence().remove(healthSmePremiId);
	}

	public static HealthSmePremi updateImpl(HealthSmePremi healthSmePremi) {
		return getPersistence().updateImpl(healthSmePremi);
	}

	/**
	 * Returns the health sme premi with the primary key or throws a <code>NoSuchHealthSmePremiException</code> if it could not be found.
	 *
	 * @param healthSmePremiId the primary key of the health sme premi
	 * @return the health sme premi
	 * @throws NoSuchHealthSmePremiException if a health sme premi with the primary key could not be found
	 */
	public static HealthSmePremi findByPrimaryKey(long healthSmePremiId)
		throws com.mypage.admin.product.exception.
			NoSuchHealthSmePremiException {

		return getPersistence().findByPrimaryKey(healthSmePremiId);
	}

	/**
	 * Returns the health sme premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param healthSmePremiId the primary key of the health sme premi
	 * @return the health sme premi, or <code>null</code> if a health sme premi with the primary key could not be found
	 */
	public static HealthSmePremi fetchByPrimaryKey(long healthSmePremiId) {
		return getPersistence().fetchByPrimaryKey(healthSmePremiId);
	}

	/**
	 * Returns all the health sme premis.
	 *
	 * @return the health sme premis
	 */
	public static List<HealthSmePremi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the health sme premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme premis
	 * @param end the upper bound of the range of health sme premis (not inclusive)
	 * @return the range of health sme premis
	 */
	public static List<HealthSmePremi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the health sme premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme premis
	 * @param end the upper bound of the range of health sme premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of health sme premis
	 */
	public static List<HealthSmePremi> findAll(
		int start, int end,
		OrderByComparator<HealthSmePremi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the health sme premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme premis
	 * @param end the upper bound of the range of health sme premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of health sme premis
	 */
	public static List<HealthSmePremi> findAll(
		int start, int end, OrderByComparator<HealthSmePremi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the health sme premis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of health sme premis.
	 *
	 * @return the number of health sme premis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HealthSmePremiPersistence getPersistence() {
		return _persistence;
	}

	private static volatile HealthSmePremiPersistence _persistence;

}