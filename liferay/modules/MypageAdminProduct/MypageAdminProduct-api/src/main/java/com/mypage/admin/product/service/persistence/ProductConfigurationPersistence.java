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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.admin.product.exception.NoSuchProductConfigurationException;
import com.mypage.admin.product.model.ProductConfiguration;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the product configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see ProductConfigurationUtil
 * @generated
 */
@ProviderType
public interface ProductConfigurationPersistence
	extends BasePersistence<ProductConfiguration> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductConfigurationUtil} to access the product configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the product configuration where productCode = &#63; or throws a <code>NoSuchProductConfigurationException</code> if it could not be found.
	 *
	 * @param productCode the product code
	 * @return the matching product configuration
	 * @throws NoSuchProductConfigurationException if a matching product configuration could not be found
	 */
	public ProductConfiguration findByProductCode(String productCode)
		throws NoSuchProductConfigurationException;

	/**
	 * Returns the product configuration where productCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productCode the product code
	 * @return the matching product configuration, or <code>null</code> if a matching product configuration could not be found
	 */
	public ProductConfiguration fetchByProductCode(String productCode);

	/**
	 * Returns the product configuration where productCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productCode the product code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product configuration, or <code>null</code> if a matching product configuration could not be found
	 */
	public ProductConfiguration fetchByProductCode(
		String productCode, boolean useFinderCache);

	/**
	 * Removes the product configuration where productCode = &#63; from the database.
	 *
	 * @param productCode the product code
	 * @return the product configuration that was removed
	 */
	public ProductConfiguration removeByProductCode(String productCode)
		throws NoSuchProductConfigurationException;

	/**
	 * Returns the number of product configurations where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @return the number of matching product configurations
	 */
	public int countByProductCode(String productCode);

	/**
	 * Caches the product configuration in the entity cache if it is enabled.
	 *
	 * @param productConfiguration the product configuration
	 */
	public void cacheResult(ProductConfiguration productConfiguration);

	/**
	 * Caches the product configurations in the entity cache if it is enabled.
	 *
	 * @param productConfigurations the product configurations
	 */
	public void cacheResult(
		java.util.List<ProductConfiguration> productConfigurations);

	/**
	 * Creates a new product configuration with the primary key. Does not add the product configuration to the database.
	 *
	 * @param productId the primary key for the new product configuration
	 * @return the new product configuration
	 */
	public ProductConfiguration create(long productId);

	/**
	 * Removes the product configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the product configuration
	 * @return the product configuration that was removed
	 * @throws NoSuchProductConfigurationException if a product configuration with the primary key could not be found
	 */
	public ProductConfiguration remove(long productId)
		throws NoSuchProductConfigurationException;

	public ProductConfiguration updateImpl(
		ProductConfiguration productConfiguration);

	/**
	 * Returns the product configuration with the primary key or throws a <code>NoSuchProductConfigurationException</code> if it could not be found.
	 *
	 * @param productId the primary key of the product configuration
	 * @return the product configuration
	 * @throws NoSuchProductConfigurationException if a product configuration with the primary key could not be found
	 */
	public ProductConfiguration findByPrimaryKey(long productId)
		throws NoSuchProductConfigurationException;

	/**
	 * Returns the product configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productId the primary key of the product configuration
	 * @return the product configuration, or <code>null</code> if a product configuration with the primary key could not be found
	 */
	public ProductConfiguration fetchByPrimaryKey(long productId);

	/**
	 * Returns all the product configurations.
	 *
	 * @return the product configurations
	 */
	public java.util.List<ProductConfiguration> findAll();

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
	public java.util.List<ProductConfiguration> findAll(int start, int end);

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
	public java.util.List<ProductConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductConfiguration>
			orderByComparator);

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
	public java.util.List<ProductConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductConfiguration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the product configurations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of product configurations.
	 *
	 * @return the number of product configurations
	 */
	public int countAll();

}