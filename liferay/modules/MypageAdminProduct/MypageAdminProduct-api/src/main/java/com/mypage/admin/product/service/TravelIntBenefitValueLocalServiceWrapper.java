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
 * Provides a wrapper for {@link TravelIntBenefitValueLocalService}.
 *
 * @author Gositus Team
 * @see TravelIntBenefitValueLocalService
 * @generated
 */
public class TravelIntBenefitValueLocalServiceWrapper
	implements ServiceWrapper<TravelIntBenefitValueLocalService>,
			   TravelIntBenefitValueLocalService {

	public TravelIntBenefitValueLocalServiceWrapper(
		TravelIntBenefitValueLocalService travelIntBenefitValueLocalService) {

		_travelIntBenefitValueLocalService = travelIntBenefitValueLocalService;
	}

	/**
	 * Add
	 */
	@Override
	public com.mypage.admin.product.model.TravelIntBenefitValue
			addTravelIntBenefitValue(
				long travelIntBenefitId, String currencyName,
				String packageType, String benefitValue, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelIntBenefitValueLocalService.addTravelIntBenefitValue(
			travelIntBenefitId, currencyName, packageType, benefitValue,
			active);
	}

	/**
	 * Adds the travel int benefit value to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelIntBenefitValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelIntBenefitValue the travel int benefit value
	 * @return the travel int benefit value that was added
	 */
	@Override
	public com.mypage.admin.product.model.TravelIntBenefitValue
		addTravelIntBenefitValue(
			com.mypage.admin.product.model.TravelIntBenefitValue
				travelIntBenefitValue) {

		return _travelIntBenefitValueLocalService.addTravelIntBenefitValue(
			travelIntBenefitValue);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelIntBenefitValueLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new travel int benefit value with the primary key. Does not add the travel int benefit value to the database.
	 *
	 * @param travelIntBenefitValueId the primary key for the new travel int benefit value
	 * @return the new travel int benefit value
	 */
	@Override
	public com.mypage.admin.product.model.TravelIntBenefitValue
		createTravelIntBenefitValue(long travelIntBenefitValueId) {

		return _travelIntBenefitValueLocalService.createTravelIntBenefitValue(
			travelIntBenefitValueId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelIntBenefitValueLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the travel int benefit value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelIntBenefitValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelIntBenefitValueId the primary key of the travel int benefit value
	 * @return the travel int benefit value that was removed
	 * @throws PortalException if a travel int benefit value with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelIntBenefitValue
			deleteTravelIntBenefitValue(long travelIntBenefitValueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelIntBenefitValueLocalService.deleteTravelIntBenefitValue(
			travelIntBenefitValueId);
	}

	/**
	 * Deletes the travel int benefit value from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelIntBenefitValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelIntBenefitValue the travel int benefit value
	 * @return the travel int benefit value that was removed
	 */
	@Override
	public com.mypage.admin.product.model.TravelIntBenefitValue
		deleteTravelIntBenefitValue(
			com.mypage.admin.product.model.TravelIntBenefitValue
				travelIntBenefitValue) {

		return _travelIntBenefitValueLocalService.deleteTravelIntBenefitValue(
			travelIntBenefitValue);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _travelIntBenefitValueLocalService.dynamicQuery();
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

		return _travelIntBenefitValueLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelIntBenefitValueModelImpl</code>.
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

		return _travelIntBenefitValueLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelIntBenefitValueModelImpl</code>.
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

		return _travelIntBenefitValueLocalService.dynamicQuery(
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

		return _travelIntBenefitValueLocalService.dynamicQueryCount(
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

		return _travelIntBenefitValueLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.TravelIntBenefitValue
		fetchTravelIntBenefitValue(long travelIntBenefitValueId) {

		return _travelIntBenefitValueLocalService.fetchTravelIntBenefitValue(
			travelIntBenefitValueId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.TravelIntBenefitValue>
		findByPackageType(String packageType) {

		return _travelIntBenefitValueLocalService.findByPackageType(
			packageType);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.TravelIntBenefitValue>
		findByPackageTypeAndCurrencyName(
			long benefitParentId, String packageType, String currencyName) {

		return _travelIntBenefitValueLocalService.
			findByPackageTypeAndCurrencyName(
				benefitParentId, packageType, currencyName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _travelIntBenefitValueLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _travelIntBenefitValueLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _travelIntBenefitValueLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelIntBenefitValueLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the travel int benefit value with the primary key.
	 *
	 * @param travelIntBenefitValueId the primary key of the travel int benefit value
	 * @return the travel int benefit value
	 * @throws PortalException if a travel int benefit value with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelIntBenefitValue
			getTravelIntBenefitValue(long travelIntBenefitValueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelIntBenefitValueLocalService.getTravelIntBenefitValue(
			travelIntBenefitValueId);
	}

	@Override
	public int gettravelIntBenefitValueCount() {
		return _travelIntBenefitValueLocalService.
			gettravelIntBenefitValueCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.TravelIntBenefitValue>
		getTravelIntBenefitValues() {

		return _travelIntBenefitValueLocalService.getTravelIntBenefitValues();
	}

	/**
	 * Returns a range of all the travel int benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @return the range of travel int benefit values
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.TravelIntBenefitValue>
		getTravelIntBenefitValues(int start, int end) {

		return _travelIntBenefitValueLocalService.getTravelIntBenefitValues(
			start, end);
	}

	/**
	 * Returns the number of travel int benefit values.
	 *
	 * @return the number of travel int benefit values
	 */
	@Override
	public int getTravelIntBenefitValuesCount() {
		return _travelIntBenefitValueLocalService.
			getTravelIntBenefitValuesCount();
	}

	/**
	 * Update
	 */
	@Override
	public com.mypage.admin.product.model.TravelIntBenefitValue
			updateTravelIntBenefitValue(
				long travelIntBenefitValueId, long travelIntBenefitId,
				String currencyName, String packageType, String benefitValue,
				int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelIntBenefitValueLocalService.updateTravelIntBenefitValue(
			travelIntBenefitValueId, travelIntBenefitId, currencyName,
			packageType, benefitValue, active);
	}

	/**
	 * Updates the travel int benefit value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelIntBenefitValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelIntBenefitValue the travel int benefit value
	 * @return the travel int benefit value that was updated
	 */
	@Override
	public com.mypage.admin.product.model.TravelIntBenefitValue
		updateTravelIntBenefitValue(
			com.mypage.admin.product.model.TravelIntBenefitValue
				travelIntBenefitValue) {

		return _travelIntBenefitValueLocalService.updateTravelIntBenefitValue(
			travelIntBenefitValue);
	}

	@Override
	public TravelIntBenefitValueLocalService getWrappedService() {
		return _travelIntBenefitValueLocalService;
	}

	@Override
	public void setWrappedService(
		TravelIntBenefitValueLocalService travelIntBenefitValueLocalService) {

		_travelIntBenefitValueLocalService = travelIntBenefitValueLocalService;
	}

	private TravelIntBenefitValueLocalService
		_travelIntBenefitValueLocalService;

}