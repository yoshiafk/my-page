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
 * Provides a wrapper for {@link ReferenceNumberLocalService}.
 *
 * @author Gositus Team
 * @see ReferenceNumberLocalService
 * @generated
 */
public class ReferenceNumberLocalServiceWrapper
	implements ReferenceNumberLocalService,
			   ServiceWrapper<ReferenceNumberLocalService> {

	public ReferenceNumberLocalServiceWrapper(
		ReferenceNumberLocalService referenceNumberLocalService) {

		_referenceNumberLocalService = referenceNumberLocalService;
	}

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
	@Override
	public com.mypage.admin.product.model.ReferenceNumber addReferenceNumber(
		com.mypage.admin.product.model.ReferenceNumber referenceNumber) {

		return _referenceNumberLocalService.addReferenceNumber(referenceNumber);
	}

	@Override
	public com.mypage.admin.product.model.ReferenceNumber addReferenceNumber(
		String userRole, String channel, String type, String productCode,
		String businessType, String currency, String prefix, int active) {

		return _referenceNumberLocalService.addReferenceNumber(
			userRole, channel, type, productCode, businessType, currency,
			prefix, active);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _referenceNumberLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new reference number with the primary key. Does not add the reference number to the database.
	 *
	 * @param referenceNumberId the primary key for the new reference number
	 * @return the new reference number
	 */
	@Override
	public com.mypage.admin.product.model.ReferenceNumber createReferenceNumber(
		long referenceNumberId) {

		return _referenceNumberLocalService.createReferenceNumber(
			referenceNumberId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _referenceNumberLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public com.mypage.admin.product.model.ReferenceNumber deleteReferenceNumber(
			long referenceNumberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _referenceNumberLocalService.deleteReferenceNumber(
			referenceNumberId);
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
	@Override
	public com.mypage.admin.product.model.ReferenceNumber deleteReferenceNumber(
		com.mypage.admin.product.model.ReferenceNumber referenceNumber) {

		return _referenceNumberLocalService.deleteReferenceNumber(
			referenceNumber);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _referenceNumberLocalService.dynamicQuery();
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

		return _referenceNumberLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _referenceNumberLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _referenceNumberLocalService.dynamicQuery(
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

		return _referenceNumberLocalService.dynamicQueryCount(dynamicQuery);
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

		return _referenceNumberLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.ReferenceNumber fetchReferenceNumber(
		long referenceNumberId) {

		return _referenceNumberLocalService.fetchReferenceNumber(
			referenceNumberId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _referenceNumberLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _referenceNumberLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _referenceNumberLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _referenceNumberLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the reference number with the primary key.
	 *
	 * @param referenceNumberId the primary key of the reference number
	 * @return the reference number
	 * @throws PortalException if a reference number with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.ReferenceNumber getReferenceNumber(
			long referenceNumberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _referenceNumberLocalService.getReferenceNumber(
			referenceNumberId);
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
	@Override
	public java.util.List<com.mypage.admin.product.model.ReferenceNumber>
		getReferenceNumbers(int start, int end) {

		return _referenceNumberLocalService.getReferenceNumbers(start, end);
	}

	/**
	 * Returns the number of reference numbers.
	 *
	 * @return the number of reference numbers
	 */
	@Override
	public int getReferenceNumbersCount() {
		return _referenceNumberLocalService.getReferenceNumbersCount();
	}

	@Override
	public com.mypage.admin.product.model.ReferenceNumber searchReferenceNumber(
		String userRole, String channel, String type, String productCode,
		String businessType, String currency) {

		return _referenceNumberLocalService.searchReferenceNumber(
			userRole, channel, type, productCode, businessType, currency);
	}

	@Override
	public com.mypage.admin.product.model.ReferenceNumber setActive(
			long referenceNumberId, int active)
		throws com.mypage.admin.product.exception.
			NoSuchReferenceNumberException {

		return _referenceNumberLocalService.setActive(
			referenceNumberId, active);
	}

	@Override
	public com.mypage.admin.product.model.ReferenceNumber updateReferenceNumber(
			long referenceNumberId, String userRole, String channel,
			String type, String productCode, String businessType,
			String currency, String prefix, int active)
		throws com.mypage.admin.product.exception.
			NoSuchReferenceNumberException {

		return _referenceNumberLocalService.updateReferenceNumber(
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
	@Override
	public com.mypage.admin.product.model.ReferenceNumber updateReferenceNumber(
		com.mypage.admin.product.model.ReferenceNumber referenceNumber) {

		return _referenceNumberLocalService.updateReferenceNumber(
			referenceNumber);
	}

	@Override
	public ReferenceNumberLocalService getWrappedService() {
		return _referenceNumberLocalService;
	}

	@Override
	public void setWrappedService(
		ReferenceNumberLocalService referenceNumberLocalService) {

		_referenceNumberLocalService = referenceNumberLocalService;
	}

	private ReferenceNumberLocalService _referenceNumberLocalService;

}