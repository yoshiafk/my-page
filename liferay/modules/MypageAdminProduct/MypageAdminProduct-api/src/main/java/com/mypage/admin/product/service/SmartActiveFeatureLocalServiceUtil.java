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

import com.mypage.admin.product.model.SmartActiveFeature;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SmartActiveFeature. This utility wraps
 * <code>com.mypage.admin.product.service.impl.SmartActiveFeatureLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see SmartActiveFeatureLocalService
 * @generated
 */
public class SmartActiveFeatureLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.SmartActiveFeatureLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SmartActiveFeature addFeature(
			String title, String description, String fileURL, long fileEntryId,
			int sort, int active)
		throws PortalException {

		return getService().addFeature(
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
	public static SmartActiveFeature addSmartActiveFeature(
		SmartActiveFeature smartActiveFeature) {

		return getService().addSmartActiveFeature(smartActiveFeature);
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
	 * Creates a new smart active feature with the primary key. Does not add the smart active feature to the database.
	 *
	 * @param smartActiveFeatureId the primary key for the new smart active feature
	 * @return the new smart active feature
	 */
	public static SmartActiveFeature createSmartActiveFeature(
		long smartActiveFeatureId) {

		return getService().createSmartActiveFeature(smartActiveFeatureId);
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
	public static SmartActiveFeature deleteSmartActiveFeature(
			long smartActiveFeatureId)
		throws PortalException {

		return getService().deleteSmartActiveFeature(smartActiveFeatureId);
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
	public static SmartActiveFeature deleteSmartActiveFeature(
		SmartActiveFeature smartActiveFeature) {

		return getService().deleteSmartActiveFeature(smartActiveFeature);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveFeatureModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveFeatureModelImpl</code>.
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

	public static SmartActiveFeature fetchSmartActiveFeature(
		long smartActiveFeatureId) {

		return getService().fetchSmartActiveFeature(smartActiveFeatureId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<SmartActiveFeature> getActiveFeature() {
		return getService().getActiveFeature();
	}

	public static List<SmartActiveFeature> getFeatures() {
		return getService().getFeatures();
	}

	public static List<SmartActiveFeature> getFeatures(int start, int end) {
		return getService().getFeatures(start, end);
	}

	public static int getFeaturesCount() {
		return getService().getFeaturesCount();
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
	 * Returns the smart active feature with the primary key.
	 *
	 * @param smartActiveFeatureId the primary key of the smart active feature
	 * @return the smart active feature
	 * @throws PortalException if a smart active feature with the primary key could not be found
	 */
	public static SmartActiveFeature getSmartActiveFeature(
			long smartActiveFeatureId)
		throws PortalException {

		return getService().getSmartActiveFeature(smartActiveFeatureId);
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
	public static List<SmartActiveFeature> getSmartActiveFeatures(
		int start, int end) {

		return getService().getSmartActiveFeatures(start, end);
	}

	/**
	 * Returns the number of smart active features.
	 *
	 * @return the number of smart active features
	 */
	public static int getSmartActiveFeaturesCount() {
		return getService().getSmartActiveFeaturesCount();
	}

	public static SmartActiveFeature setActive(
		long featureId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().setActive(featureId, active, serviceContext);
	}

	public static SmartActiveFeature updateFeature(
			long smartActiveFeatureId, String title, String description,
			String fileURL, long fileEntryId, int sort, int active)
		throws PortalException {

		return getService().updateFeature(
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
	public static SmartActiveFeature updateSmartActiveFeature(
		SmartActiveFeature smartActiveFeature) {

		return getService().updateSmartActiveFeature(smartActiveFeature);
	}

	public static SmartActiveFeatureLocalService getService() {
		return _service;
	}

	private static volatile SmartActiveFeatureLocalService _service;

}