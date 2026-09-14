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
 * Provides a wrapper for {@link TravelDomesticTravellerTypeLocalService}.
 *
 * @author Gositus Team
 * @see TravelDomesticTravellerTypeLocalService
 * @generated
 */
public class TravelDomesticTravellerTypeLocalServiceWrapper
	implements ServiceWrapper<TravelDomesticTravellerTypeLocalService>,
			   TravelDomesticTravellerTypeLocalService {

	public TravelDomesticTravellerTypeLocalServiceWrapper(
		TravelDomesticTravellerTypeLocalService
			travelDomesticTravellerTypeLocalService) {

		_travelDomesticTravellerTypeLocalService =
			travelDomesticTravellerTypeLocalService;
	}

	/**
	 * Adds the travel domestic traveller type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticTravellerTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticTravellerType the travel domestic traveller type
	 * @return the travel domestic traveller type that was added
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticTravellerType
		addTravelDomesticTravellerType(
			com.mypage.admin.product.model.TravelDomesticTravellerType
				travelDomesticTravellerType) {

		return _travelDomesticTravellerTypeLocalService.
			addTravelDomesticTravellerType(travelDomesticTravellerType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticTravellerTypeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new travel domestic traveller type with the primary key. Does not add the travel domestic traveller type to the database.
	 *
	 * @param travellerTypeId the primary key for the new travel domestic traveller type
	 * @return the new travel domestic traveller type
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticTravellerType
		createTravelDomesticTravellerType(long travellerTypeId) {

		return _travelDomesticTravellerTypeLocalService.
			createTravelDomesticTravellerType(travellerTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticTravellerTypeLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the travel domestic traveller type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticTravellerTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travellerTypeId the primary key of the travel domestic traveller type
	 * @return the travel domestic traveller type that was removed
	 * @throws PortalException if a travel domestic traveller type with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticTravellerType
			deleteTravelDomesticTravellerType(long travellerTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticTravellerTypeLocalService.
			deleteTravelDomesticTravellerType(travellerTypeId);
	}

	/**
	 * Deletes the travel domestic traveller type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticTravellerTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticTravellerType the travel domestic traveller type
	 * @return the travel domestic traveller type that was removed
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticTravellerType
		deleteTravelDomesticTravellerType(
			com.mypage.admin.product.model.TravelDomesticTravellerType
				travelDomesticTravellerType) {

		return _travelDomesticTravellerTypeLocalService.
			deleteTravelDomesticTravellerType(travelDomesticTravellerType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _travelDomesticTravellerTypeLocalService.dynamicQuery();
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

		return _travelDomesticTravellerTypeLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticTravellerTypeModelImpl</code>.
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

		return _travelDomesticTravellerTypeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticTravellerTypeModelImpl</code>.
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

		return _travelDomesticTravellerTypeLocalService.dynamicQuery(
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

		return _travelDomesticTravellerTypeLocalService.dynamicQueryCount(
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

		return _travelDomesticTravellerTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticTravellerType
		fetchTravelDomesticTravellerType(long travellerTypeId) {

		return _travelDomesticTravellerTypeLocalService.
			fetchTravelDomesticTravellerType(travellerTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _travelDomesticTravellerTypeLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _travelDomesticTravellerTypeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _travelDomesticTravellerTypeLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticTravellerTypeLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the travel domestic traveller type with the primary key.
	 *
	 * @param travellerTypeId the primary key of the travel domestic traveller type
	 * @return the travel domestic traveller type
	 * @throws PortalException if a travel domestic traveller type with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticTravellerType
			getTravelDomesticTravellerType(long travellerTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticTravellerTypeLocalService.
			getTravelDomesticTravellerType(travellerTypeId);
	}

	/**
	 * Returns a range of all the travel domestic traveller types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticTravellerTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic traveller types
	 * @param end the upper bound of the range of travel domestic traveller types (not inclusive)
	 * @return the range of travel domestic traveller types
	 */
	@Override
	public java.util.List
		<com.mypage.admin.product.model.TravelDomesticTravellerType>
			getTravelDomesticTravellerTypes(int start, int end) {

		return _travelDomesticTravellerTypeLocalService.
			getTravelDomesticTravellerTypes(start, end);
	}

	/**
	 * Returns the number of travel domestic traveller types.
	 *
	 * @return the number of travel domestic traveller types
	 */
	@Override
	public int getTravelDomesticTravellerTypesCount() {
		return _travelDomesticTravellerTypeLocalService.
			getTravelDomesticTravellerTypesCount();
	}

	/**
	 * Updates the travel domestic traveller type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticTravellerTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticTravellerType the travel domestic traveller type
	 * @return the travel domestic traveller type that was updated
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticTravellerType
		updateTravelDomesticTravellerType(
			com.mypage.admin.product.model.TravelDomesticTravellerType
				travelDomesticTravellerType) {

		return _travelDomesticTravellerTypeLocalService.
			updateTravelDomesticTravellerType(travelDomesticTravellerType);
	}

	@Override
	public TravelDomesticTravellerTypeLocalService getWrappedService() {
		return _travelDomesticTravellerTypeLocalService;
	}

	@Override
	public void setWrappedService(
		TravelDomesticTravellerTypeLocalService
			travelDomesticTravellerTypeLocalService) {

		_travelDomesticTravellerTypeLocalService =
			travelDomesticTravellerTypeLocalService;
	}

	private TravelDomesticTravellerTypeLocalService
		_travelDomesticTravellerTypeLocalService;

}