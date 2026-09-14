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
 * Provides a wrapper for {@link SmartActiveClassRateLocalService}.
 *
 * @author Gositus Team
 * @see SmartActiveClassRateLocalService
 * @generated
 */
public class SmartActiveClassRateLocalServiceWrapper
	implements ServiceWrapper<SmartActiveClassRateLocalService>,
			   SmartActiveClassRateLocalService {

	public SmartActiveClassRateLocalServiceWrapper(
		SmartActiveClassRateLocalService smartActiveClassRateLocalService) {

		_smartActiveClassRateLocalService = smartActiveClassRateLocalService;
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveClassRate addClassRate(
			String nameId, String nameEn, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveClassRateLocalService.addClassRate(
			nameId, nameEn, active);
	}

	/**
	 * Adds the smart active class rate to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveClassRateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveClassRate the smart active class rate
	 * @return the smart active class rate that was added
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveClassRate
		addSmartActiveClassRate(
			com.mypage.admin.product.model.SmartActiveClassRate
				smartActiveClassRate) {

		return _smartActiveClassRateLocalService.addSmartActiveClassRate(
			smartActiveClassRate);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveClassRateLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new smart active class rate with the primary key. Does not add the smart active class rate to the database.
	 *
	 * @param smartActiveClassRateId the primary key for the new smart active class rate
	 * @return the new smart active class rate
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveClassRate
		createSmartActiveClassRate(long smartActiveClassRateId) {

		return _smartActiveClassRateLocalService.createSmartActiveClassRate(
			smartActiveClassRateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveClassRateLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the smart active class rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveClassRateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveClassRateId the primary key of the smart active class rate
	 * @return the smart active class rate that was removed
	 * @throws PortalException if a smart active class rate with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveClassRate
			deleteSmartActiveClassRate(long smartActiveClassRateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveClassRateLocalService.deleteSmartActiveClassRate(
			smartActiveClassRateId);
	}

	/**
	 * Deletes the smart active class rate from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveClassRateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveClassRate the smart active class rate
	 * @return the smart active class rate that was removed
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveClassRate
		deleteSmartActiveClassRate(
			com.mypage.admin.product.model.SmartActiveClassRate
				smartActiveClassRate) {

		return _smartActiveClassRateLocalService.deleteSmartActiveClassRate(
			smartActiveClassRate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smartActiveClassRateLocalService.dynamicQuery();
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

		return _smartActiveClassRateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveClassRateModelImpl</code>.
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

		return _smartActiveClassRateLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveClassRateModelImpl</code>.
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

		return _smartActiveClassRateLocalService.dynamicQuery(
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

		return _smartActiveClassRateLocalService.dynamicQueryCount(
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

		return _smartActiveClassRateLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveClassRate
		fetchSmartActiveClassRate(long smartActiveClassRateId) {

		return _smartActiveClassRateLocalService.fetchSmartActiveClassRate(
			smartActiveClassRateId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smartActiveClassRateLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveClassRate>
		getActiveClassRate() {

		return _smartActiveClassRateLocalService.getActiveClassRate();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveClassRate>
		getAllClassRates() {

		return _smartActiveClassRateLocalService.getAllClassRates();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveClassRate>
		getClassRateByName(String nameId, String nameEn) {

		return _smartActiveClassRateLocalService.getClassRateByName(
			nameId, nameEn);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveClassRate>
		getClassRateBySort(int sort) {

		return _smartActiveClassRateLocalService.getClassRateBySort(sort);
	}

	@Override
	public long getClassRateIdByNameId(String nameId) {
		return _smartActiveClassRateLocalService.getClassRateIdByNameId(nameId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveClassRate>
		getClassRates() {

		return _smartActiveClassRateLocalService.getClassRates();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveClassRate>
		getClassRates(int start, int end) {

		return _smartActiveClassRateLocalService.getClassRates(start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smartActiveClassRateLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartActiveClassRateLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveClassRateLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the smart active class rate with the primary key.
	 *
	 * @param smartActiveClassRateId the primary key of the smart active class rate
	 * @return the smart active class rate
	 * @throws PortalException if a smart active class rate with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveClassRate
			getSmartActiveClassRate(long smartActiveClassRateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveClassRateLocalService.getSmartActiveClassRate(
			smartActiveClassRateId);
	}

	@Override
	public int getSmartActiveClassRateCount() {
		return _smartActiveClassRateLocalService.getSmartActiveClassRateCount();
	}

	/**
	 * Returns a range of all the smart active class rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveClassRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active class rates
	 * @param end the upper bound of the range of smart active class rates (not inclusive)
	 * @return the range of smart active class rates
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveClassRate>
		getSmartActiveClassRates(int start, int end) {

		return _smartActiveClassRateLocalService.getSmartActiveClassRates(
			start, end);
	}

	/**
	 * Returns the number of smart active class rates.
	 *
	 * @return the number of smart active class rates
	 */
	@Override
	public int getSmartActiveClassRatesCount() {
		return _smartActiveClassRateLocalService.
			getSmartActiveClassRatesCount();
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveClassRate setActive(
		long classRateId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _smartActiveClassRateLocalService.setActive(
			classRateId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveClassRate updateClassRate(
			long classRateId, String nameId, String nameEn, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveClassRateLocalService.updateClassRate(
			classRateId, nameId, nameEn, active);
	}

	/**
	 * Updates the smart active class rate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveClassRateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveClassRate the smart active class rate
	 * @return the smart active class rate that was updated
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveClassRate
		updateSmartActiveClassRate(
			com.mypage.admin.product.model.SmartActiveClassRate
				smartActiveClassRate) {

		return _smartActiveClassRateLocalService.updateSmartActiveClassRate(
			smartActiveClassRate);
	}

	@Override
	public SmartActiveClassRateLocalService getWrappedService() {
		return _smartActiveClassRateLocalService;
	}

	@Override
	public void setWrappedService(
		SmartActiveClassRateLocalService smartActiveClassRateLocalService) {

		_smartActiveClassRateLocalService = smartActiveClassRateLocalService;
	}

	private SmartActiveClassRateLocalService _smartActiveClassRateLocalService;

}