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
 * Provides a wrapper for {@link TravelDomesticInsuredTypeLocalService}.
 *
 * @author Gositus Team
 * @see TravelDomesticInsuredTypeLocalService
 * @generated
 */
public class TravelDomesticInsuredTypeLocalServiceWrapper
	implements ServiceWrapper<TravelDomesticInsuredTypeLocalService>,
			   TravelDomesticInsuredTypeLocalService {

	public TravelDomesticInsuredTypeLocalServiceWrapper(
		TravelDomesticInsuredTypeLocalService
			travelDomesticInsuredTypeLocalService) {

		_travelDomesticInsuredTypeLocalService =
			travelDomesticInsuredTypeLocalService;
	}

	/**
	 * Adds the travel domestic insured type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticInsuredTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticInsuredType the travel domestic insured type
	 * @return the travel domestic insured type that was added
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticInsuredType
		addTravelDomesticInsuredType(
			com.mypage.admin.product.model.TravelDomesticInsuredType
				travelDomesticInsuredType) {

		return _travelDomesticInsuredTypeLocalService.
			addTravelDomesticInsuredType(travelDomesticInsuredType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticInsuredTypeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new travel domestic insured type with the primary key. Does not add the travel domestic insured type to the database.
	 *
	 * @param travelDomesticInsuredTypeId the primary key for the new travel domestic insured type
	 * @return the new travel domestic insured type
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticInsuredType
		createTravelDomesticInsuredType(long travelDomesticInsuredTypeId) {

		return _travelDomesticInsuredTypeLocalService.
			createTravelDomesticInsuredType(travelDomesticInsuredTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticInsuredTypeLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the travel domestic insured type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticInsuredTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticInsuredTypeId the primary key of the travel domestic insured type
	 * @return the travel domestic insured type that was removed
	 * @throws PortalException if a travel domestic insured type with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticInsuredType
			deleteTravelDomesticInsuredType(long travelDomesticInsuredTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticInsuredTypeLocalService.
			deleteTravelDomesticInsuredType(travelDomesticInsuredTypeId);
	}

	/**
	 * Deletes the travel domestic insured type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticInsuredTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticInsuredType the travel domestic insured type
	 * @return the travel domestic insured type that was removed
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticInsuredType
		deleteTravelDomesticInsuredType(
			com.mypage.admin.product.model.TravelDomesticInsuredType
				travelDomesticInsuredType) {

		return _travelDomesticInsuredTypeLocalService.
			deleteTravelDomesticInsuredType(travelDomesticInsuredType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _travelDomesticInsuredTypeLocalService.dynamicQuery();
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

		return _travelDomesticInsuredTypeLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticInsuredTypeModelImpl</code>.
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

		return _travelDomesticInsuredTypeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticInsuredTypeModelImpl</code>.
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

		return _travelDomesticInsuredTypeLocalService.dynamicQuery(
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

		return _travelDomesticInsuredTypeLocalService.dynamicQueryCount(
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

		return _travelDomesticInsuredTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticInsuredType
		fetchTravelDomesticInsuredType(long travelDomesticInsuredTypeId) {

		return _travelDomesticInsuredTypeLocalService.
			fetchTravelDomesticInsuredType(travelDomesticInsuredTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _travelDomesticInsuredTypeLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _travelDomesticInsuredTypeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _travelDomesticInsuredTypeLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticInsuredTypeLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the travel domestic insured type with the primary key.
	 *
	 * @param travelDomesticInsuredTypeId the primary key of the travel domestic insured type
	 * @return the travel domestic insured type
	 * @throws PortalException if a travel domestic insured type with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticInsuredType
			getTravelDomesticInsuredType(long travelDomesticInsuredTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticInsuredTypeLocalService.
			getTravelDomesticInsuredType(travelDomesticInsuredTypeId);
	}

	/**
	 * Returns a range of all the travel domestic insured types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @return the range of travel domestic insured types
	 */
	@Override
	public java.util.List
		<com.mypage.admin.product.model.TravelDomesticInsuredType>
			getTravelDomesticInsuredTypes(int start, int end) {

		return _travelDomesticInsuredTypeLocalService.
			getTravelDomesticInsuredTypes(start, end);
	}

	/**
	 * Returns the number of travel domestic insured types.
	 *
	 * @return the number of travel domestic insured types
	 */
	@Override
	public int getTravelDomesticInsuredTypesCount() {
		return _travelDomesticInsuredTypeLocalService.
			getTravelDomesticInsuredTypesCount();
	}

	/**
	 * Updates the travel domestic insured type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticInsuredTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticInsuredType the travel domestic insured type
	 * @return the travel domestic insured type that was updated
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticInsuredType
		updateTravelDomesticInsuredType(
			com.mypage.admin.product.model.TravelDomesticInsuredType
				travelDomesticInsuredType) {

		return _travelDomesticInsuredTypeLocalService.
			updateTravelDomesticInsuredType(travelDomesticInsuredType);
	}

	@Override
	public TravelDomesticInsuredTypeLocalService getWrappedService() {
		return _travelDomesticInsuredTypeLocalService;
	}

	@Override
	public void setWrappedService(
		TravelDomesticInsuredTypeLocalService
			travelDomesticInsuredTypeLocalService) {

		_travelDomesticInsuredTypeLocalService =
			travelDomesticInsuredTypeLocalService;
	}

	private TravelDomesticInsuredTypeLocalService
		_travelDomesticInsuredTypeLocalService;

}