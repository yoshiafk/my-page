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

import com.mypage.admin.product.model.CompanyType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the company type service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.CompanyTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see CompanyTypePersistence
 * @generated
 */
public class CompanyTypeUtil {

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
	public static void clearCache(CompanyType companyType) {
		getPersistence().clearCache(companyType);
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
	public static Map<Serializable, CompanyType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CompanyType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CompanyType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CompanyType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CompanyType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CompanyType update(CompanyType companyType) {
		return getPersistence().update(companyType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CompanyType update(
		CompanyType companyType, ServiceContext serviceContext) {

		return getPersistence().update(companyType, serviceContext);
	}

	/**
	 * Caches the company type in the entity cache if it is enabled.
	 *
	 * @param companyType the company type
	 */
	public static void cacheResult(CompanyType companyType) {
		getPersistence().cacheResult(companyType);
	}

	/**
	 * Caches the company types in the entity cache if it is enabled.
	 *
	 * @param companyTypes the company types
	 */
	public static void cacheResult(List<CompanyType> companyTypes) {
		getPersistence().cacheResult(companyTypes);
	}

	/**
	 * Creates a new company type with the primary key. Does not add the company type to the database.
	 *
	 * @param companyTypeId the primary key for the new company type
	 * @return the new company type
	 */
	public static CompanyType create(long companyTypeId) {
		return getPersistence().create(companyTypeId);
	}

	/**
	 * Removes the company type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param companyTypeId the primary key of the company type
	 * @return the company type that was removed
	 * @throws NoSuchCompanyTypeException if a company type with the primary key could not be found
	 */
	public static CompanyType remove(long companyTypeId)
		throws com.mypage.admin.product.exception.NoSuchCompanyTypeException {

		return getPersistence().remove(companyTypeId);
	}

	public static CompanyType updateImpl(CompanyType companyType) {
		return getPersistence().updateImpl(companyType);
	}

	/**
	 * Returns the company type with the primary key or throws a <code>NoSuchCompanyTypeException</code> if it could not be found.
	 *
	 * @param companyTypeId the primary key of the company type
	 * @return the company type
	 * @throws NoSuchCompanyTypeException if a company type with the primary key could not be found
	 */
	public static CompanyType findByPrimaryKey(long companyTypeId)
		throws com.mypage.admin.product.exception.NoSuchCompanyTypeException {

		return getPersistence().findByPrimaryKey(companyTypeId);
	}

	/**
	 * Returns the company type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param companyTypeId the primary key of the company type
	 * @return the company type, or <code>null</code> if a company type with the primary key could not be found
	 */
	public static CompanyType fetchByPrimaryKey(long companyTypeId) {
		return getPersistence().fetchByPrimaryKey(companyTypeId);
	}

	/**
	 * Returns all the company types.
	 *
	 * @return the company types
	 */
	public static List<CompanyType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the company types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of company types
	 * @param end the upper bound of the range of company types (not inclusive)
	 * @return the range of company types
	 */
	public static List<CompanyType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the company types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of company types
	 * @param end the upper bound of the range of company types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of company types
	 */
	public static List<CompanyType> findAll(
		int start, int end, OrderByComparator<CompanyType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the company types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompanyTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of company types
	 * @param end the upper bound of the range of company types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of company types
	 */
	public static List<CompanyType> findAll(
		int start, int end, OrderByComparator<CompanyType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the company types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of company types.
	 *
	 * @return the number of company types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CompanyTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile CompanyTypePersistence _persistence;

}