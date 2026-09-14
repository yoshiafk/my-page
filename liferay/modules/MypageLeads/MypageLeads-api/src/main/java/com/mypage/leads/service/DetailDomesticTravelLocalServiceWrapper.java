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

package com.mypage.leads.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DetailDomesticTravelLocalService}.
 *
 * @author Gositus
 * @see DetailDomesticTravelLocalService
 * @generated
 */
public class DetailDomesticTravelLocalServiceWrapper
	implements DetailDomesticTravelLocalService,
			   ServiceWrapper<DetailDomesticTravelLocalService> {

	public DetailDomesticTravelLocalServiceWrapper(
		DetailDomesticTravelLocalService detailDomesticTravelLocalService) {

		_detailDomesticTravelLocalService = detailDomesticTravelLocalService;
	}

	@Override
	public com.mypage.leads.model.DetailDomesticTravel addDetail(
		long userId, long detailId,
		com.liferay.portal.kernel.json.JSONObject data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _detailDomesticTravelLocalService.addDetail(
			userId, detailId, data, serviceContext);
	}

	/**
	 * Adds the detail domestic travel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailDomesticTravelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailDomesticTravel the detail domestic travel
	 * @return the detail domestic travel that was added
	 */
	@Override
	public com.mypage.leads.model.DetailDomesticTravel addDetailDomesticTravel(
		com.mypage.leads.model.DetailDomesticTravel detailDomesticTravel) {

		return _detailDomesticTravelLocalService.addDetailDomesticTravel(
			detailDomesticTravel);
	}

	/**
	 * Creates a new detail domestic travel with the primary key. Does not add the detail domestic travel to the database.
	 *
	 * @param detailDomesticTravelId the primary key for the new detail domestic travel
	 * @return the new detail domestic travel
	 */
	@Override
	public com.mypage.leads.model.DetailDomesticTravel
		createDetailDomesticTravel(long detailDomesticTravelId) {

		return _detailDomesticTravelLocalService.createDetailDomesticTravel(
			detailDomesticTravelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailDomesticTravelLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the detail domestic travel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailDomesticTravelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailDomesticTravel the detail domestic travel
	 * @return the detail domestic travel that was removed
	 */
	@Override
	public com.mypage.leads.model.DetailDomesticTravel
		deleteDetailDomesticTravel(
			com.mypage.leads.model.DetailDomesticTravel detailDomesticTravel) {

		return _detailDomesticTravelLocalService.deleteDetailDomesticTravel(
			detailDomesticTravel);
	}

	/**
	 * Deletes the detail domestic travel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailDomesticTravelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailDomesticTravelId the primary key of the detail domestic travel
	 * @return the detail domestic travel that was removed
	 * @throws PortalException if a detail domestic travel with the primary key could not be found
	 */
	@Override
	public com.mypage.leads.model.DetailDomesticTravel
			deleteDetailDomesticTravel(long detailDomesticTravelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailDomesticTravelLocalService.deleteDetailDomesticTravel(
			detailDomesticTravelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailDomesticTravelLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _detailDomesticTravelLocalService.dynamicQuery();
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

		return _detailDomesticTravelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailDomesticTravelModelImpl</code>.
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

		return _detailDomesticTravelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailDomesticTravelModelImpl</code>.
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

		return _detailDomesticTravelLocalService.dynamicQuery(
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

		return _detailDomesticTravelLocalService.dynamicQueryCount(
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

		return _detailDomesticTravelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.leads.model.DetailDomesticTravel
		fetchDetailDomesticTravel(long detailDomesticTravelId) {

		return _detailDomesticTravelLocalService.fetchDetailDomesticTravel(
			detailDomesticTravelId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _detailDomesticTravelLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the detail domestic travel with the primary key.
	 *
	 * @param detailDomesticTravelId the primary key of the detail domestic travel
	 * @return the detail domestic travel
	 * @throws PortalException if a detail domestic travel with the primary key could not be found
	 */
	@Override
	public com.mypage.leads.model.DetailDomesticTravel getDetailDomesticTravel(
			long detailDomesticTravelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailDomesticTravelLocalService.getDetailDomesticTravel(
			detailDomesticTravelId);
	}

	/**
	 * Returns a range of all the detail domestic travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailDomesticTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail domestic travels
	 * @param end the upper bound of the range of detail domestic travels (not inclusive)
	 * @return the range of detail domestic travels
	 */
	@Override
	public java.util.List<com.mypage.leads.model.DetailDomesticTravel>
		getDetailDomesticTravels(int start, int end) {

		return _detailDomesticTravelLocalService.getDetailDomesticTravels(
			start, end);
	}

	/**
	 * Returns the number of detail domestic travels.
	 *
	 * @return the number of detail domestic travels
	 */
	@Override
	public int getDetailDomesticTravelsCount() {
		return _detailDomesticTravelLocalService.
			getDetailDomesticTravelsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _detailDomesticTravelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _detailDomesticTravelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailDomesticTravelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public com.mypage.leads.model.DetailDomesticTravel searchByLeadsId(
		long LeadsId) {

		return _detailDomesticTravelLocalService.searchByLeadsId(LeadsId);
	}

	/**
	 * Updates the detail domestic travel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailDomesticTravelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailDomesticTravel the detail domestic travel
	 * @return the detail domestic travel that was updated
	 */
	@Override
	public com.mypage.leads.model.DetailDomesticTravel
		updateDetailDomesticTravel(
			com.mypage.leads.model.DetailDomesticTravel detailDomesticTravel) {

		return _detailDomesticTravelLocalService.updateDetailDomesticTravel(
			detailDomesticTravel);
	}

	@Override
	public DetailDomesticTravelLocalService getWrappedService() {
		return _detailDomesticTravelLocalService;
	}

	@Override
	public void setWrappedService(
		DetailDomesticTravelLocalService detailDomesticTravelLocalService) {

		_detailDomesticTravelLocalService = detailDomesticTravelLocalService;
	}

	private DetailDomesticTravelLocalService _detailDomesticTravelLocalService;

}