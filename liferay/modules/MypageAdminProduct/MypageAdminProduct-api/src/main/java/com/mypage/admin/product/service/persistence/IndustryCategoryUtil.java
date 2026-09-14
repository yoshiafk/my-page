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

import com.mypage.admin.product.model.IndustryCategory;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the industry category service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.IndustryCategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see IndustryCategoryPersistence
 * @generated
 */
public class IndustryCategoryUtil {

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
	public static void clearCache(IndustryCategory industryCategory) {
		getPersistence().clearCache(industryCategory);
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
	public static Map<Serializable, IndustryCategory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<IndustryCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<IndustryCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<IndustryCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<IndustryCategory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static IndustryCategory update(IndustryCategory industryCategory) {
		return getPersistence().update(industryCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static IndustryCategory update(
		IndustryCategory industryCategory, ServiceContext serviceContext) {

		return getPersistence().update(industryCategory, serviceContext);
	}

	/**
	 * Caches the industry category in the entity cache if it is enabled.
	 *
	 * @param industryCategory the industry category
	 */
	public static void cacheResult(IndustryCategory industryCategory) {
		getPersistence().cacheResult(industryCategory);
	}

	/**
	 * Caches the industry categories in the entity cache if it is enabled.
	 *
	 * @param industryCategories the industry categories
	 */
	public static void cacheResult(List<IndustryCategory> industryCategories) {
		getPersistence().cacheResult(industryCategories);
	}

	/**
	 * Creates a new industry category with the primary key. Does not add the industry category to the database.
	 *
	 * @param industryCategoryId the primary key for the new industry category
	 * @return the new industry category
	 */
	public static IndustryCategory create(long industryCategoryId) {
		return getPersistence().create(industryCategoryId);
	}

	/**
	 * Removes the industry category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param industryCategoryId the primary key of the industry category
	 * @return the industry category that was removed
	 * @throws NoSuchIndustryCategoryException if a industry category with the primary key could not be found
	 */
	public static IndustryCategory remove(long industryCategoryId)
		throws com.mypage.admin.product.exception.
			NoSuchIndustryCategoryException {

		return getPersistence().remove(industryCategoryId);
	}

	public static IndustryCategory updateImpl(
		IndustryCategory industryCategory) {

		return getPersistence().updateImpl(industryCategory);
	}

	/**
	 * Returns the industry category with the primary key or throws a <code>NoSuchIndustryCategoryException</code> if it could not be found.
	 *
	 * @param industryCategoryId the primary key of the industry category
	 * @return the industry category
	 * @throws NoSuchIndustryCategoryException if a industry category with the primary key could not be found
	 */
	public static IndustryCategory findByPrimaryKey(long industryCategoryId)
		throws com.mypage.admin.product.exception.
			NoSuchIndustryCategoryException {

		return getPersistence().findByPrimaryKey(industryCategoryId);
	}

	/**
	 * Returns the industry category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param industryCategoryId the primary key of the industry category
	 * @return the industry category, or <code>null</code> if a industry category with the primary key could not be found
	 */
	public static IndustryCategory fetchByPrimaryKey(long industryCategoryId) {
		return getPersistence().fetchByPrimaryKey(industryCategoryId);
	}

	/**
	 * Returns all the industry categories.
	 *
	 * @return the industry categories
	 */
	public static List<IndustryCategory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the industry categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of industry categories
	 * @param end the upper bound of the range of industry categories (not inclusive)
	 * @return the range of industry categories
	 */
	public static List<IndustryCategory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the industry categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of industry categories
	 * @param end the upper bound of the range of industry categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of industry categories
	 */
	public static List<IndustryCategory> findAll(
		int start, int end,
		OrderByComparator<IndustryCategory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the industry categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of industry categories
	 * @param end the upper bound of the range of industry categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of industry categories
	 */
	public static List<IndustryCategory> findAll(
		int start, int end,
		OrderByComparator<IndustryCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the industry categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of industry categories.
	 *
	 * @return the number of industry categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static IndustryCategoryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile IndustryCategoryPersistence _persistence;

}