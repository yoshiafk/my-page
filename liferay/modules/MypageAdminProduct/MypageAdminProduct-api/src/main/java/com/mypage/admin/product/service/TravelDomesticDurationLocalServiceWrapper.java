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
 * Provides a wrapper for {@link TravelDomesticDurationLocalService}.
 *
 * @author Gositus Team
 * @see TravelDomesticDurationLocalService
 * @generated
 */
public class TravelDomesticDurationLocalServiceWrapper
	implements ServiceWrapper<TravelDomesticDurationLocalService>,
			   TravelDomesticDurationLocalService {

	public TravelDomesticDurationLocalServiceWrapper(
		TravelDomesticDurationLocalService travelDomesticDurationLocalService) {

		_travelDomesticDurationLocalService =
			travelDomesticDurationLocalService;
	}

	/**
	 * Adds the travel domestic duration to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticDurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticDuration the travel domestic duration
	 * @return the travel domestic duration that was added
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticDuration
		addTravelDomesticDuration(
			com.mypage.admin.product.model.TravelDomesticDuration
				travelDomesticDuration) {

		return _travelDomesticDurationLocalService.addTravelDomesticDuration(
			travelDomesticDuration);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticDurationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new travel domestic duration with the primary key. Does not add the travel domestic duration to the database.
	 *
	 * @param travelDomesticDurationId the primary key for the new travel domestic duration
	 * @return the new travel domestic duration
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticDuration
		createTravelDomesticDuration(long travelDomesticDurationId) {

		return _travelDomesticDurationLocalService.createTravelDomesticDuration(
			travelDomesticDurationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticDurationLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the travel domestic duration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticDurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticDurationId the primary key of the travel domestic duration
	 * @return the travel domestic duration that was removed
	 * @throws PortalException if a travel domestic duration with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticDuration
			deleteTravelDomesticDuration(long travelDomesticDurationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticDurationLocalService.deleteTravelDomesticDuration(
			travelDomesticDurationId);
	}

	/**
	 * Deletes the travel domestic duration from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticDurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticDuration the travel domestic duration
	 * @return the travel domestic duration that was removed
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticDuration
		deleteTravelDomesticDuration(
			com.mypage.admin.product.model.TravelDomesticDuration
				travelDomesticDuration) {

		return _travelDomesticDurationLocalService.deleteTravelDomesticDuration(
			travelDomesticDuration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _travelDomesticDurationLocalService.dynamicQuery();
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

		return _travelDomesticDurationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticDurationModelImpl</code>.
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

		return _travelDomesticDurationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticDurationModelImpl</code>.
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

		return _travelDomesticDurationLocalService.dynamicQuery(
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

		return _travelDomesticDurationLocalService.dynamicQueryCount(
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

		return _travelDomesticDurationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticDuration
		fetchTravelDomesticDuration(long travelDomesticDurationId) {

		return _travelDomesticDurationLocalService.fetchTravelDomesticDuration(
			travelDomesticDurationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _travelDomesticDurationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _travelDomesticDurationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _travelDomesticDurationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticDurationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the travel domestic duration with the primary key.
	 *
	 * @param travelDomesticDurationId the primary key of the travel domestic duration
	 * @return the travel domestic duration
	 * @throws PortalException if a travel domestic duration with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticDuration
			getTravelDomesticDuration(long travelDomesticDurationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticDurationLocalService.getTravelDomesticDuration(
			travelDomesticDurationId);
	}

	/**
	 * Returns a range of all the travel domestic durations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticDurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic durations
	 * @param end the upper bound of the range of travel domestic durations (not inclusive)
	 * @return the range of travel domestic durations
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.TravelDomesticDuration>
		getTravelDomesticDurations(int start, int end) {

		return _travelDomesticDurationLocalService.getTravelDomesticDurations(
			start, end);
	}

	/**
	 * Returns the number of travel domestic durations.
	 *
	 * @return the number of travel domestic durations
	 */
	@Override
	public int getTravelDomesticDurationsCount() {
		return _travelDomesticDurationLocalService.
			getTravelDomesticDurationsCount();
	}

	/**
	 * Updates the travel domestic duration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticDurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticDuration the travel domestic duration
	 * @return the travel domestic duration that was updated
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticDuration
		updateTravelDomesticDuration(
			com.mypage.admin.product.model.TravelDomesticDuration
				travelDomesticDuration) {

		return _travelDomesticDurationLocalService.updateTravelDomesticDuration(
			travelDomesticDuration);
	}

	@Override
	public TravelDomesticDurationLocalService getWrappedService() {
		return _travelDomesticDurationLocalService;
	}

	@Override
	public void setWrappedService(
		TravelDomesticDurationLocalService travelDomesticDurationLocalService) {

		_travelDomesticDurationLocalService =
			travelDomesticDurationLocalService;
	}

	private TravelDomesticDurationLocalService
		_travelDomesticDurationLocalService;

}