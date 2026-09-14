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
 * Provides a wrapper for {@link SmartActiveFeatureLocalService}.
 *
 * @author Gositus Team
 * @see SmartActiveFeatureLocalService
 * @generated
 */
public class SmartActiveFeatureLocalServiceWrapper
	implements ServiceWrapper<SmartActiveFeatureLocalService>,
			   SmartActiveFeatureLocalService {

	public SmartActiveFeatureLocalServiceWrapper(
		SmartActiveFeatureLocalService smartActiveFeatureLocalService) {

		_smartActiveFeatureLocalService = smartActiveFeatureLocalService;
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveFeature addFeature(
			String title, String description, String fileURL, long fileEntryId,
			int sort, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveFeatureLocalService.addFeature(
			title, description, fileURL, fileEntryId, sort, active);
	}

	/**
	 * Adds the smart active feature to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveFeatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveFeature the smart active feature
	 * @return the smart active feature that was added
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveFeature
		addSmartActiveFeature(
			com.mypage.admin.product.model.SmartActiveFeature
				smartActiveFeature) {

		return _smartActiveFeatureLocalService.addSmartActiveFeature(
			smartActiveFeature);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveFeatureLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new smart active feature with the primary key. Does not add the smart active feature to the database.
	 *
	 * @param smartActiveFeatureId the primary key for the new smart active feature
	 * @return the new smart active feature
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveFeature
		createSmartActiveFeature(long smartActiveFeatureId) {

		return _smartActiveFeatureLocalService.createSmartActiveFeature(
			smartActiveFeatureId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveFeatureLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the smart active feature with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveFeatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveFeatureId the primary key of the smart active feature
	 * @return the smart active feature that was removed
	 * @throws PortalException if a smart active feature with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveFeature
			deleteSmartActiveFeature(long smartActiveFeatureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveFeatureLocalService.deleteSmartActiveFeature(
			smartActiveFeatureId);
	}

	/**
	 * Deletes the smart active feature from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveFeatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveFeature the smart active feature
	 * @return the smart active feature that was removed
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveFeature
		deleteSmartActiveFeature(
			com.mypage.admin.product.model.SmartActiveFeature
				smartActiveFeature) {

		return _smartActiveFeatureLocalService.deleteSmartActiveFeature(
			smartActiveFeature);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smartActiveFeatureLocalService.dynamicQuery();
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

		return _smartActiveFeatureLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveFeatureModelImpl</code>.
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

		return _smartActiveFeatureLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveFeatureModelImpl</code>.
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

		return _smartActiveFeatureLocalService.dynamicQuery(
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

		return _smartActiveFeatureLocalService.dynamicQueryCount(dynamicQuery);
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

		return _smartActiveFeatureLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveFeature
		fetchSmartActiveFeature(long smartActiveFeatureId) {

		return _smartActiveFeatureLocalService.fetchSmartActiveFeature(
			smartActiveFeatureId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smartActiveFeatureLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveFeature>
		getActiveFeature() {

		return _smartActiveFeatureLocalService.getActiveFeature();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveFeature>
		getFeatures() {

		return _smartActiveFeatureLocalService.getFeatures();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveFeature>
		getFeatures(int start, int end) {

		return _smartActiveFeatureLocalService.getFeatures(start, end);
	}

	@Override
	public int getFeaturesCount() {
		return _smartActiveFeatureLocalService.getFeaturesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smartActiveFeatureLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartActiveFeatureLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveFeatureLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the smart active feature with the primary key.
	 *
	 * @param smartActiveFeatureId the primary key of the smart active feature
	 * @return the smart active feature
	 * @throws PortalException if a smart active feature with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveFeature
			getSmartActiveFeature(long smartActiveFeatureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveFeatureLocalService.getSmartActiveFeature(
			smartActiveFeatureId);
	}

	/**
	 * Returns a range of all the smart active features.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveFeatureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active features
	 * @param end the upper bound of the range of smart active features (not inclusive)
	 * @return the range of smart active features
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveFeature>
		getSmartActiveFeatures(int start, int end) {

		return _smartActiveFeatureLocalService.getSmartActiveFeatures(
			start, end);
	}

	/**
	 * Returns the number of smart active features.
	 *
	 * @return the number of smart active features
	 */
	@Override
	public int getSmartActiveFeaturesCount() {
		return _smartActiveFeatureLocalService.getSmartActiveFeaturesCount();
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveFeature setActive(
		long featureId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _smartActiveFeatureLocalService.setActive(
			featureId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveFeature updateFeature(
			long smartActiveFeatureId, String title, String description,
			String fileURL, long fileEntryId, int sort, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveFeatureLocalService.updateFeature(
			smartActiveFeatureId, title, description, fileURL, fileEntryId,
			sort, active);
	}

	/**
	 * Updates the smart active feature in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveFeatureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveFeature the smart active feature
	 * @return the smart active feature that was updated
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveFeature
		updateSmartActiveFeature(
			com.mypage.admin.product.model.SmartActiveFeature
				smartActiveFeature) {

		return _smartActiveFeatureLocalService.updateSmartActiveFeature(
			smartActiveFeature);
	}

	@Override
	public SmartActiveFeatureLocalService getWrappedService() {
		return _smartActiveFeatureLocalService;
	}

	@Override
	public void setWrappedService(
		SmartActiveFeatureLocalService smartActiveFeatureLocalService) {

		_smartActiveFeatureLocalService = smartActiveFeatureLocalService;
	}

	private SmartActiveFeatureLocalService _smartActiveFeatureLocalService;

}