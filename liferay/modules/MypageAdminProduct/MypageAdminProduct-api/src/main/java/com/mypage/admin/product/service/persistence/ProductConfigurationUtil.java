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

import com.mypage.admin.product.model.ProductConfiguration;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the product configuration service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.ProductConfigurationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see ProductConfigurationPersistence
 * @generated
 */
public class ProductConfigurationUtil {

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
	public static void clearCache(ProductConfiguration productConfiguration) {
		getPersistence().clearCache(productConfiguration);
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
	public static Map<Serializable, ProductConfiguration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductConfiguration> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductConfiguration update(
		ProductConfiguration productConfiguration) {

		return getPersistence().update(productConfiguration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductConfiguration update(
		ProductConfiguration productConfiguration,
		ServiceContext serviceContext) {

		return getPersistence().update(productConfiguration, serviceContext);
	}

	/**
	 * Returns the product configuration where productCode = &#63; or throws a <code>NoSuchProductConfigurationException</code> if it could not be found.
	 *
	 * @param productCode the product code
	 * @return the matching product configuration
	 * @throws NoSuchProductConfigurationException if a matching product configuration could not be found
	 */
	public static ProductConfiguration findByProductCode(String productCode)
		throws com.mypage.admin.product.exception.
			NoSuchProductConfigurationException {

		return getPersistence().findByProductCode(productCode);
	}

	/**
	 * Returns the product configuration where productCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productCode the product code
	 * @return the matching product configuration, or <code>null</code> if a matching product configuration could not be found
	 */
	public static ProductConfiguration fetchByProductCode(String productCode) {
		return getPersistence().fetchByProductCode(productCode);
	}

	/**
	 * Returns the product configuration where productCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productCode the product code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product configuration, or <code>null</code> if a matching product configuration could not be found
	 */
	public static ProductConfiguration fetchByProductCode(
		String productCode, boolean useFinderCache) {

		return getPersistence().fetchByProductCode(productCode, useFinderCache);
	}

	/**
	 * Removes the product configuration where productCode = &#63; from the database.
	 *
	 * @param productCode the product code
	 * @return the product configuration that was removed
	 */
	public static ProductConfiguration removeByProductCode(String productCode)
		throws com.mypage.admin.product.exception.
			NoSuchProductConfigurationException {

		return getPersistence().removeByProductCode(productCode);
	}

	/**
	 * Returns the number of product configurations where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @return the number of matching product configurations
	 */
	public static int countByProductCode(String productCode) {
		return getPersistence().countByProductCode(productCode);
	}

	/**
	 * Caches the product configuration in the entity cache if it is enabled.
	 *
	 * @param productConfiguration the product configuration
	 */
	public static void cacheResult(ProductConfiguration productConfiguration) {
		getPersistence().cacheResult(productConfiguration);
	}

	/**
	 * Caches the product configurations in the entity cache if it is enabled.
	 *
	 * @param productConfigurations the product configurations
	 */
	public static void cacheResult(
		List<ProductConfiguration> productConfigurations) {

		getPersistence().cacheResult(productConfigurations);
	}

	/**
	 * Creates a new product configuration with the primary key. Does not add the product configuration to the database.
	 *
	 * @param productId the primary key for the new product configuration
	 * @return the new product configuration
	 */
	public static ProductConfiguration create(long productId) {
		return getPersistence().create(productId);
	}

	/**
	 * Removes the product configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the product configuration
	 * @return the product configuration that was removed
	 * @throws NoSuchProductConfigurationException if a product configuration with the primary key could not be found
	 */
	public static ProductConfiguration remove(long productId)
		throws com.mypage.admin.product.exception.
			NoSuchProductConfigurationException {

		return getPersistence().remove(productId);
	}

	public static ProductConfiguration updateImpl(
		ProductConfiguration productConfiguration) {

		return getPersistence().updateImpl(productConfiguration);
	}

	/**
	 * Returns the product configuration with the primary key or throws a <code>NoSuchProductConfigurationException</code> if it could not be found.
	 *
	 * @param productId the primary key of the product configuration
	 * @return the product configuration
	 * @throws NoSuchProductConfigurationException if a product configuration with the primary key could not be found
	 */
	public static ProductConfiguration findByPrimaryKey(long productId)
		throws com.mypage.admin.product.exception.
			NoSuchProductConfigurationException {

		return getPersistence().findByPrimaryKey(productId);
	}

	/**
	 * Returns the product configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productId the primary key of the product configuration
	 * @return the product configuration, or <code>null</code> if a product configuration with the primary key could not be found
	 */
	public static ProductConfiguration fetchByPrimaryKey(long productId) {
		return getPersistence().fetchByPrimaryKey(productId);
	}

	/**
	 * Returns all the product configurations.
	 *
	 * @return the product configurations
	 */
	public static List<ProductConfiguration> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the product configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product configurations
	 * @param end the upper bound of the range of product configurations (not inclusive)
	 * @return the range of product configurations
	 */
	public static List<ProductConfiguration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the product configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product configurations
	 * @param end the upper bound of the range of product configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product configurations
	 */
	public static List<ProductConfiguration> findAll(
		int start, int end,
		OrderByComparator<ProductConfiguration> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product configurations
	 * @param end the upper bound of the range of product configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product configurations
	 */
	public static List<ProductConfiguration> findAll(
		int start, int end,
		OrderByComparator<ProductConfiguration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the product configurations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of product configurations.
	 *
	 * @return the number of product configurations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductConfigurationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProductConfigurationPersistence _persistence;

}