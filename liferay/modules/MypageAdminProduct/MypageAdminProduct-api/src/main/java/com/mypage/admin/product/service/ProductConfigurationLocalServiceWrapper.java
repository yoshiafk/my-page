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

package com.mypage.admin.product.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductConfigurationLocalService}.
 *
 * @author Gositus Team
 * @see ProductConfigurationLocalService
 * @generated
 */
public class ProductConfigurationLocalServiceWrapper
	implements ProductConfigurationLocalService,
			   ServiceWrapper<ProductConfigurationLocalService> {

	public ProductConfigurationLocalServiceWrapper(
		ProductConfigurationLocalService productConfigurationLocalService) {

		_productConfigurationLocalService = productConfigurationLocalService;
	}

	@Override
	public com.mypage.admin.product.model.ProductConfiguration addConfig(
		long productId, String productName, String productCode,
		double commission, double stampdutyIDR, double stampdutyUSD,
		double policyCostIDR, double policyCostUSD, int aclStatus,
		int aclGracePeriod, int webContentFolderId, String link, int isB2C,
		int isB2B, int isB2B2C, long iconFileEntryId, long imageFileEntryId,
		String ojkName, int pepEnable, long policyWordingEntryId,
		String metaTitle, String metaDescription, String metaKeywords) {

		return _productConfigurationLocalService.addConfig(
			productId, productName, productCode, commission, stampdutyIDR,
			stampdutyUSD, policyCostIDR, policyCostUSD, aclStatus,
			aclGracePeriod, webContentFolderId, link, isB2C, isB2B, isB2B2C,
			iconFileEntryId, imageFileEntryId, ojkName, pepEnable,
			policyWordingEntryId, metaTitle, metaDescription, metaKeywords);
	}

	/**
	 * Adds the product configuration to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductConfigurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productConfiguration the product configuration
	 * @return the product configuration that was added
	 */
	@Override
	public com.mypage.admin.product.model.ProductConfiguration
		addProductConfiguration(
			com.mypage.admin.product.model.ProductConfiguration
				productConfiguration) {

		return _productConfigurationLocalService.addProductConfiguration(
			productConfiguration);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productConfigurationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new product configuration with the primary key. Does not add the product configuration to the database.
	 *
	 * @param productId the primary key for the new product configuration
	 * @return the new product configuration
	 */
	@Override
	public com.mypage.admin.product.model.ProductConfiguration
		createProductConfiguration(long productId) {

		return _productConfigurationLocalService.createProductConfiguration(
			productId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productConfigurationLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the product configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductConfigurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productId the primary key of the product configuration
	 * @return the product configuration that was removed
	 * @throws PortalException if a product configuration with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.ProductConfiguration
			deleteProductConfiguration(long productId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productConfigurationLocalService.deleteProductConfiguration(
			productId);
	}

	/**
	 * Deletes the product configuration from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductConfigurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productConfiguration the product configuration
	 * @return the product configuration that was removed
	 */
	@Override
	public com.mypage.admin.product.model.ProductConfiguration
		deleteProductConfiguration(
			com.mypage.admin.product.model.ProductConfiguration
				productConfiguration) {

		return _productConfigurationLocalService.deleteProductConfiguration(
			productConfiguration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productConfigurationLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productConfigurationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.ProductConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _productConfigurationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.ProductConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _productConfigurationLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productConfigurationLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _productConfigurationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.ProductConfiguration
		fetchProductConfiguration(long productId) {

		return _productConfigurationLocalService.fetchProductConfiguration(
			productId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productConfigurationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.mypage.admin.product.model.ProductConfiguration getConfigByCode(
		String productCode) {

		return _productConfigurationLocalService.getConfigByCode(productCode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productConfigurationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productConfigurationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productConfigurationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the product configuration with the primary key.
	 *
	 * @param productId the primary key of the product configuration
	 * @return the product configuration
	 * @throws PortalException if a product configuration with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.ProductConfiguration
			getProductConfiguration(long productId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productConfigurationLocalService.getProductConfiguration(
			productId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.ProductConfiguration>
			getProductConfigurations()
		throws com.mypage.admin.product.exception.
			NoSuchProductConfigurationException,
			   Exception {

		return _productConfigurationLocalService.getProductConfigurations();
	}

	/**
	 * Returns a range of all the product configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.ProductConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product configurations
	 * @param end the upper bound of the range of product configurations (not inclusive)
	 * @return the range of product configurations
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.ProductConfiguration>
		getProductConfigurations(int start, int end) {

		return _productConfigurationLocalService.getProductConfigurations(
			start, end);
	}

	/**
	 * Returns the number of product configurations.
	 *
	 * @return the number of product configurations
	 */
	@Override
	public int getProductConfigurationsCount() {
		return _productConfigurationLocalService.
			getProductConfigurationsCount();
	}

	/**
	 * Updates the product configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductConfigurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productConfiguration the product configuration
	 * @return the product configuration that was updated
	 */
	@Override
	public com.mypage.admin.product.model.ProductConfiguration
		updateProductConfiguration(
			com.mypage.admin.product.model.ProductConfiguration
				productConfiguration) {

		return _productConfigurationLocalService.updateProductConfiguration(
			productConfiguration);
	}

	@Override
	public ProductConfigurationLocalService getWrappedService() {
		return _productConfigurationLocalService;
	}

	@Override
	public void setWrappedService(
		ProductConfigurationLocalService productConfigurationLocalService) {

		_productConfigurationLocalService = productConfigurationLocalService;
	}

	private ProductConfigurationLocalService _productConfigurationLocalService;

}