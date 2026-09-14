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
 * Provides a wrapper for {@link SmartActiveBenefitValueLocalService}.
 *
 * @author Gositus Team
 * @see SmartActiveBenefitValueLocalService
 * @generated
 */
public class SmartActiveBenefitValueLocalServiceWrapper
	implements ServiceWrapper<SmartActiveBenefitValueLocalService>,
			   SmartActiveBenefitValueLocalService {

	public SmartActiveBenefitValueLocalServiceWrapper(
		SmartActiveBenefitValueLocalService
			smartActiveBenefitValueLocalService) {

		_smartActiveBenefitValueLocalService =
			smartActiveBenefitValueLocalService;
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValue
			addBenefitValue(long value, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitValueLocalService.addBenefitValue(
			value, active);
	}

	/**
	 * Adds the smart active benefit value to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitValue the smart active benefit value
	 * @return the smart active benefit value that was added
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValue
		addSmartActiveBenefitValue(
			com.mypage.admin.product.model.SmartActiveBenefitValue
				smartActiveBenefitValue) {

		return _smartActiveBenefitValueLocalService.addSmartActiveBenefitValue(
			smartActiveBenefitValue);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitValueLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new smart active benefit value with the primary key. Does not add the smart active benefit value to the database.
	 *
	 * @param smartActiveBenefitValueId the primary key for the new smart active benefit value
	 * @return the new smart active benefit value
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValue
		createSmartActiveBenefitValue(long smartActiveBenefitValueId) {

		return _smartActiveBenefitValueLocalService.
			createSmartActiveBenefitValue(smartActiveBenefitValueId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitValueLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the smart active benefit value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitValueId the primary key of the smart active benefit value
	 * @return the smart active benefit value that was removed
	 * @throws PortalException if a smart active benefit value with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValue
			deleteSmartActiveBenefitValue(long smartActiveBenefitValueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitValueLocalService.
			deleteSmartActiveBenefitValue(smartActiveBenefitValueId);
	}

	/**
	 * Deletes the smart active benefit value from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitValue the smart active benefit value
	 * @return the smart active benefit value that was removed
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValue
		deleteSmartActiveBenefitValue(
			com.mypage.admin.product.model.SmartActiveBenefitValue
				smartActiveBenefitValue) {

		return _smartActiveBenefitValueLocalService.
			deleteSmartActiveBenefitValue(smartActiveBenefitValue);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smartActiveBenefitValueLocalService.dynamicQuery();
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

		return _smartActiveBenefitValueLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitValueModelImpl</code>.
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

		return _smartActiveBenefitValueLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitValueModelImpl</code>.
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

		return _smartActiveBenefitValueLocalService.dynamicQuery(
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

		return _smartActiveBenefitValueLocalService.dynamicQueryCount(
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

		return _smartActiveBenefitValueLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValue
		fetchSmartActiveBenefitValue(long smartActiveBenefitValueId) {

		return _smartActiveBenefitValueLocalService.
			fetchSmartActiveBenefitValue(smartActiveBenefitValueId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smartActiveBenefitValueLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValue
		getActiveBenefitByValue(long val) {

		return _smartActiveBenefitValueLocalService.getActiveBenefitByValue(
			val);
	}

	@Override
	public java.util.List
		<com.mypage.admin.product.model.SmartActiveBenefitValue>
			getActiveBenefitValue() {

		return _smartActiveBenefitValueLocalService.getActiveBenefitValue();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smartActiveBenefitValueLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartActiveBenefitValueLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitValueLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the smart active benefit value with the primary key.
	 *
	 * @param smartActiveBenefitValueId the primary key of the smart active benefit value
	 * @return the smart active benefit value
	 * @throws PortalException if a smart active benefit value with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValue
			getSmartActiveBenefitValue(long smartActiveBenefitValueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitValueLocalService.getSmartActiveBenefitValue(
			smartActiveBenefitValueId);
	}

	/**
	 * Returns a range of all the smart active benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit values
	 * @param end the upper bound of the range of smart active benefit values (not inclusive)
	 * @return the range of smart active benefit values
	 */
	@Override
	public java.util.List
		<com.mypage.admin.product.model.SmartActiveBenefitValue>
			getSmartActiveBenefitValues(int start, int end) {

		return _smartActiveBenefitValueLocalService.getSmartActiveBenefitValues(
			start, end);
	}

	/**
	 * Returns the number of smart active benefit values.
	 *
	 * @return the number of smart active benefit values
	 */
	@Override
	public int getSmartActiveBenefitValuesCount() {
		return _smartActiveBenefitValueLocalService.
			getSmartActiveBenefitValuesCount();
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValue setActive(
			long benefitValueId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitValueLocalService.setActive(
			benefitValueId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValue
			updateBenefitValue(long benefitValueId, long value, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveBenefitValueLocalService.updateBenefitValue(
			benefitValueId, value, active);
	}

	/**
	 * Updates the smart active benefit value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitValue the smart active benefit value
	 * @return the smart active benefit value that was updated
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveBenefitValue
		updateSmartActiveBenefitValue(
			com.mypage.admin.product.model.SmartActiveBenefitValue
				smartActiveBenefitValue) {

		return _smartActiveBenefitValueLocalService.
			updateSmartActiveBenefitValue(smartActiveBenefitValue);
	}

	@Override
	public SmartActiveBenefitValueLocalService getWrappedService() {
		return _smartActiveBenefitValueLocalService;
	}

	@Override
	public void setWrappedService(
		SmartActiveBenefitValueLocalService
			smartActiveBenefitValueLocalService) {

		_smartActiveBenefitValueLocalService =
			smartActiveBenefitValueLocalService;
	}

	private SmartActiveBenefitValueLocalService
		_smartActiveBenefitValueLocalService;

}