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

import com.mypage.admin.product.model.ReferenceNumber;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ReferenceNumber. This utility wraps
 * <code>com.mypage.admin.product.service.impl.ReferenceNumberLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see ReferenceNumberLocalService
 * @generated
 */
public class ReferenceNumberLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.ReferenceNumberLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the reference number to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReferenceNumberLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param referenceNumber the reference number
	 * @return the reference number that was added
	 */
	public static ReferenceNumber addReferenceNumber(
		ReferenceNumber referenceNumber) {

		return getService().addReferenceNumber(referenceNumber);
	}

	public static ReferenceNumber addReferenceNumber(
		String userRole, String channel, String type, String productCode,
		String businessType, String currency, String prefix, int active) {

		return getService().addReferenceNumber(
			userRole, channel, type, productCode, businessType, currency,
			prefix, active);
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
	 * Creates a new reference number with the primary key. Does not add the reference number to the database.
	 *
	 * @param referenceNumberId the primary key for the new reference number
	 * @return the new reference number
	 */
	public static ReferenceNumber createReferenceNumber(
		long referenceNumberId) {

		return getService().createReferenceNumber(referenceNumberId);
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
	 * Deletes the reference number with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReferenceNumberLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param referenceNumberId the primary key of the reference number
	 * @return the reference number that was removed
	 * @throws PortalException if a reference number with the primary key could not be found
	 */
	public static ReferenceNumber deleteReferenceNumber(long referenceNumberId)
		throws PortalException {

		return getService().deleteReferenceNumber(referenceNumberId);
	}

	/**
	 * Deletes the reference number from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReferenceNumberLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param referenceNumber the reference number
	 * @return the reference number that was removed
	 */
	public static ReferenceNumber deleteReferenceNumber(
		ReferenceNumber referenceNumber) {

		return getService().deleteReferenceNumber(referenceNumber);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.ReferenceNumberModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.ReferenceNumberModelImpl</code>.
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

	public static ReferenceNumber fetchReferenceNumber(long referenceNumberId) {
		return getService().fetchReferenceNumber(referenceNumberId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the reference number with the primary key.
	 *
	 * @param referenceNumberId the primary key of the reference number
	 * @return the reference number
	 * @throws PortalException if a reference number with the primary key could not be found
	 */
	public static ReferenceNumber getReferenceNumber(long referenceNumberId)
		throws PortalException {

		return getService().getReferenceNumber(referenceNumberId);
	}

	/**
	 * Returns a range of all the reference numbers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.ReferenceNumberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference numbers
	 * @param end the upper bound of the range of reference numbers (not inclusive)
	 * @return the range of reference numbers
	 */
	public static List<ReferenceNumber> getReferenceNumbers(
		int start, int end) {

		return getService().getReferenceNumbers(start, end);
	}

	/**
	 * Returns the number of reference numbers.
	 *
	 * @return the number of reference numbers
	 */
	public static int getReferenceNumbersCount() {
		return getService().getReferenceNumbersCount();
	}

	public static ReferenceNumber searchReferenceNumber(
		String userRole, String channel, String type, String productCode,
		String businessType, String currency) {

		return getService().searchReferenceNumber(
			userRole, channel, type, productCode, businessType, currency);
	}

	public static ReferenceNumber setActive(long referenceNumberId, int active)
		throws com.mypage.admin.product.exception.
			NoSuchReferenceNumberException {

		return getService().setActive(referenceNumberId, active);
	}

	public static ReferenceNumber updateReferenceNumber(
			long referenceNumberId, String userRole, String channel,
			String type, String productCode, String businessType,
			String currency, String prefix, int active)
		throws com.mypage.admin.product.exception.
			NoSuchReferenceNumberException {

		return getService().updateReferenceNumber(
			referenceNumberId, userRole, channel, type, productCode,
			businessType, currency, prefix, active);
	}

	/**
	 * Updates the reference number in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReferenceNumberLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param referenceNumber the reference number
	 * @return the reference number that was updated
	 */
	public static ReferenceNumber updateReferenceNumber(
		ReferenceNumber referenceNumber) {

		return getService().updateReferenceNumber(referenceNumber);
	}

	public static ReferenceNumberLocalService getService() {
		return _service;
	}

	private static volatile ReferenceNumberLocalService _service;

}