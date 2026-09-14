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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.ProductConfiguration;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProductConfiguration. This utility wraps
 * <code>com.mypage.admin.product.service.impl.ProductConfigurationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see ProductConfigurationLocalService
 * @generated
 */
public class ProductConfigurationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.ProductConfigurationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static ProductConfiguration addConfig(
		long productId, String productName, String productCode,
		double commission, double stampdutyIDR, double stampdutyUSD,
		double policyCostIDR, double policyCostUSD, int aclStatus,
		int aclGracePeriod, int webContentFolderId, String link, int isB2C,
		int isB2B, int isB2B2C, long iconFileEntryId, long imageFileEntryId,
		String ojkName, int pepEnable, long policyWordingEntryId,
		String metaTitle, String metaDescription, String metaKeywords) {

		return getService().addConfig(
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
	public static ProductConfiguration addProductConfiguration(
		ProductConfiguration productConfiguration) {

		return getService().addProductConfiguration(productConfiguration);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new product configuration with the primary key. Does not add the product configuration to the database.
	 *
	 * @param productId the primary key for the new product configuration
	 * @return the new product configuration
	 */
	public static ProductConfiguration createProductConfiguration(
		long productId) {

		return getService().createProductConfiguration(productId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static ProductConfiguration deleteProductConfiguration(
			long productId)
		throws PortalException {

		return getService().deleteProductConfiguration(productId);
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
	public static ProductConfiguration deleteProductConfiguration(
		ProductConfiguration productConfiguration) {

		return getService().deleteProductConfiguration(productConfiguration);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ProductConfiguration fetchProductConfiguration(
		long productId) {

		return getService().fetchProductConfiguration(productId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static ProductConfiguration getConfigByCode(String productCode) {
		return getService().getConfigByCode(productCode);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the product configuration with the primary key.
	 *
	 * @param productId the primary key of the product configuration
	 * @return the product configuration
	 * @throws PortalException if a product configuration with the primary key could not be found
	 */
	public static ProductConfiguration getProductConfiguration(long productId)
		throws PortalException {

		return getService().getProductConfiguration(productId);
	}

	public static List<ProductConfiguration> getProductConfigurations()
		throws com.mypage.admin.product.exception.
			NoSuchProductConfigurationException,
			   Exception {

		return getService().getProductConfigurations();
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
	public static List<ProductConfiguration> getProductConfigurations(
		int start, int end) {

		return getService().getProductConfigurations(start, end);
	}

	/**
	 * Returns the number of product configurations.
	 *
	 * @return the number of product configurations
	 */
	public static int getProductConfigurationsCount() {
		return getService().getProductConfigurationsCount();
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
	public static ProductConfiguration updateProductConfiguration(
		ProductConfiguration productConfiguration) {

		return getService().updateProductConfiguration(productConfiguration);
	}

	public static ProductConfigurationLocalService getService() {
		return _service;
	}

	private static volatile ProductConfigurationLocalService _service;

}