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
 * Provides a wrapper for {@link TravelDomesticRelationshipLocalService}.
 *
 * @author Gositus Team
 * @see TravelDomesticRelationshipLocalService
 * @generated
 */
public class TravelDomesticRelationshipLocalServiceWrapper
	implements ServiceWrapper<TravelDomesticRelationshipLocalService>,
			   TravelDomesticRelationshipLocalService {

	public TravelDomesticRelationshipLocalServiceWrapper(
		TravelDomesticRelationshipLocalService
			travelDomesticRelationshipLocalService) {

		_travelDomesticRelationshipLocalService =
			travelDomesticRelationshipLocalService;
	}

	/**
	 * Adds the travel domestic relationship to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticRelationshipLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticRelationship the travel domestic relationship
	 * @return the travel domestic relationship that was added
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticRelationship
		addTravelDomesticRelationship(
			com.mypage.admin.product.model.TravelDomesticRelationship
				travelDomesticRelationship) {

		return _travelDomesticRelationshipLocalService.
			addTravelDomesticRelationship(travelDomesticRelationship);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticRelationshipLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new travel domestic relationship with the primary key. Does not add the travel domestic relationship to the database.
	 *
	 * @param travelDomesticRelationshipId the primary key for the new travel domestic relationship
	 * @return the new travel domestic relationship
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticRelationship
		createTravelDomesticRelationship(long travelDomesticRelationshipId) {

		return _travelDomesticRelationshipLocalService.
			createTravelDomesticRelationship(travelDomesticRelationshipId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticRelationshipLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the travel domestic relationship with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticRelationshipLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticRelationshipId the primary key of the travel domestic relationship
	 * @return the travel domestic relationship that was removed
	 * @throws PortalException if a travel domestic relationship with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticRelationship
			deleteTravelDomesticRelationship(long travelDomesticRelationshipId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticRelationshipLocalService.
			deleteTravelDomesticRelationship(travelDomesticRelationshipId);
	}

	/**
	 * Deletes the travel domestic relationship from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticRelationshipLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticRelationship the travel domestic relationship
	 * @return the travel domestic relationship that was removed
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticRelationship
		deleteTravelDomesticRelationship(
			com.mypage.admin.product.model.TravelDomesticRelationship
				travelDomesticRelationship) {

		return _travelDomesticRelationshipLocalService.
			deleteTravelDomesticRelationship(travelDomesticRelationship);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _travelDomesticRelationshipLocalService.dynamicQuery();
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

		return _travelDomesticRelationshipLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticRelationshipModelImpl</code>.
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

		return _travelDomesticRelationshipLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticRelationshipModelImpl</code>.
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

		return _travelDomesticRelationshipLocalService.dynamicQuery(
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

		return _travelDomesticRelationshipLocalService.dynamicQueryCount(
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

		return _travelDomesticRelationshipLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticRelationship
		fetchTravelDomesticRelationship(long travelDomesticRelationshipId) {

		return _travelDomesticRelationshipLocalService.
			fetchTravelDomesticRelationship(travelDomesticRelationshipId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _travelDomesticRelationshipLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _travelDomesticRelationshipLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _travelDomesticRelationshipLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticRelationshipLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the travel domestic relationship with the primary key.
	 *
	 * @param travelDomesticRelationshipId the primary key of the travel domestic relationship
	 * @return the travel domestic relationship
	 * @throws PortalException if a travel domestic relationship with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticRelationship
			getTravelDomesticRelationship(long travelDomesticRelationshipId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticRelationshipLocalService.
			getTravelDomesticRelationship(travelDomesticRelationshipId);
	}

	/**
	 * Returns a range of all the travel domestic relationships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticRelationshipModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic relationships
	 * @param end the upper bound of the range of travel domestic relationships (not inclusive)
	 * @return the range of travel domestic relationships
	 */
	@Override
	public java.util.List
		<com.mypage.admin.product.model.TravelDomesticRelationship>
			getTravelDomesticRelationships(int start, int end) {

		return _travelDomesticRelationshipLocalService.
			getTravelDomesticRelationships(start, end);
	}

	/**
	 * Returns the number of travel domestic relationships.
	 *
	 * @return the number of travel domestic relationships
	 */
	@Override
	public int getTravelDomesticRelationshipsCount() {
		return _travelDomesticRelationshipLocalService.
			getTravelDomesticRelationshipsCount();
	}

	/**
	 * Updates the travel domestic relationship in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticRelationshipLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticRelationship the travel domestic relationship
	 * @return the travel domestic relationship that was updated
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticRelationship
		updateTravelDomesticRelationship(
			com.mypage.admin.product.model.TravelDomesticRelationship
				travelDomesticRelationship) {

		return _travelDomesticRelationshipLocalService.
			updateTravelDomesticRelationship(travelDomesticRelationship);
	}

	@Override
	public TravelDomesticRelationshipLocalService getWrappedService() {
		return _travelDomesticRelationshipLocalService;
	}

	@Override
	public void setWrappedService(
		TravelDomesticRelationshipLocalService
			travelDomesticRelationshipLocalService) {

		_travelDomesticRelationshipLocalService =
			travelDomesticRelationshipLocalService;
	}

	private TravelDomesticRelationshipLocalService
		_travelDomesticRelationshipLocalService;

}