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
 * Provides a wrapper for {@link TravelDomesticBenefitGroupLocalService}.
 *
 * @author Gositus Team
 * @see TravelDomesticBenefitGroupLocalService
 * @generated
 */
public class TravelDomesticBenefitGroupLocalServiceWrapper
	implements ServiceWrapper<TravelDomesticBenefitGroupLocalService>,
			   TravelDomesticBenefitGroupLocalService {

	public TravelDomesticBenefitGroupLocalServiceWrapper(
		TravelDomesticBenefitGroupLocalService
			travelDomesticBenefitGroupLocalService) {

		_travelDomesticBenefitGroupLocalService =
			travelDomesticBenefitGroupLocalService;
	}

	/**
	 * Adds the travel domestic benefit group to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticBenefitGroup the travel domestic benefit group
	 * @return the travel domestic benefit group that was added
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticBenefitGroup
		addTravelDomesticBenefitGroup(
			com.mypage.admin.product.model.TravelDomesticBenefitGroup
				travelDomesticBenefitGroup) {

		return _travelDomesticBenefitGroupLocalService.
			addTravelDomesticBenefitGroup(travelDomesticBenefitGroup);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticBenefitGroupLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new travel domestic benefit group with the primary key. Does not add the travel domestic benefit group to the database.
	 *
	 * @param travelDomesticBenefitGroupId the primary key for the new travel domestic benefit group
	 * @return the new travel domestic benefit group
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticBenefitGroup
		createTravelDomesticBenefitGroup(long travelDomesticBenefitGroupId) {

		return _travelDomesticBenefitGroupLocalService.
			createTravelDomesticBenefitGroup(travelDomesticBenefitGroupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticBenefitGroupLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the travel domestic benefit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticBenefitGroupId the primary key of the travel domestic benefit group
	 * @return the travel domestic benefit group that was removed
	 * @throws PortalException if a travel domestic benefit group with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticBenefitGroup
			deleteTravelDomesticBenefitGroup(long travelDomesticBenefitGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticBenefitGroupLocalService.
			deleteTravelDomesticBenefitGroup(travelDomesticBenefitGroupId);
	}

	/**
	 * Deletes the travel domestic benefit group from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticBenefitGroup the travel domestic benefit group
	 * @return the travel domestic benefit group that was removed
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticBenefitGroup
		deleteTravelDomesticBenefitGroup(
			com.mypage.admin.product.model.TravelDomesticBenefitGroup
				travelDomesticBenefitGroup) {

		return _travelDomesticBenefitGroupLocalService.
			deleteTravelDomesticBenefitGroup(travelDomesticBenefitGroup);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _travelDomesticBenefitGroupLocalService.dynamicQuery();
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

		return _travelDomesticBenefitGroupLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticBenefitGroupModelImpl</code>.
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

		return _travelDomesticBenefitGroupLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticBenefitGroupModelImpl</code>.
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

		return _travelDomesticBenefitGroupLocalService.dynamicQuery(
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

		return _travelDomesticBenefitGroupLocalService.dynamicQueryCount(
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

		return _travelDomesticBenefitGroupLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticBenefitGroup
		fetchTravelDomesticBenefitGroup(long travelDomesticBenefitGroupId) {

		return _travelDomesticBenefitGroupLocalService.
			fetchTravelDomesticBenefitGroup(travelDomesticBenefitGroupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _travelDomesticBenefitGroupLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _travelDomesticBenefitGroupLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _travelDomesticBenefitGroupLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticBenefitGroupLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the travel domestic benefit group with the primary key.
	 *
	 * @param travelDomesticBenefitGroupId the primary key of the travel domestic benefit group
	 * @return the travel domestic benefit group
	 * @throws PortalException if a travel domestic benefit group with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticBenefitGroup
			getTravelDomesticBenefitGroup(long travelDomesticBenefitGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticBenefitGroupLocalService.
			getTravelDomesticBenefitGroup(travelDomesticBenefitGroupId);
	}

	/**
	 * Returns a range of all the travel domestic benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @return the range of travel domestic benefit groups
	 */
	@Override
	public java.util.List
		<com.mypage.admin.product.model.TravelDomesticBenefitGroup>
			getTravelDomesticBenefitGroups(int start, int end) {

		return _travelDomesticBenefitGroupLocalService.
			getTravelDomesticBenefitGroups(start, end);
	}

	/**
	 * Returns the number of travel domestic benefit groups.
	 *
	 * @return the number of travel domestic benefit groups
	 */
	@Override
	public int getTravelDomesticBenefitGroupsCount() {
		return _travelDomesticBenefitGroupLocalService.
			getTravelDomesticBenefitGroupsCount();
	}

	/**
	 * Updates the travel domestic benefit group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticBenefitGroup the travel domestic benefit group
	 * @return the travel domestic benefit group that was updated
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticBenefitGroup
		updateTravelDomesticBenefitGroup(
			com.mypage.admin.product.model.TravelDomesticBenefitGroup
				travelDomesticBenefitGroup) {

		return _travelDomesticBenefitGroupLocalService.
			updateTravelDomesticBenefitGroup(travelDomesticBenefitGroup);
	}

	@Override
	public TravelDomesticBenefitGroupLocalService getWrappedService() {
		return _travelDomesticBenefitGroupLocalService;
	}

	@Override
	public void setWrappedService(
		TravelDomesticBenefitGroupLocalService
			travelDomesticBenefitGroupLocalService) {

		_travelDomesticBenefitGroupLocalService =
			travelDomesticBenefitGroupLocalService;
	}

	private TravelDomesticBenefitGroupLocalService
		_travelDomesticBenefitGroupLocalService;

}