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
 * Provides a wrapper for {@link DetailInternationalTravelLocalService}.
 *
 * @author Gositus
 * @see DetailInternationalTravelLocalService
 * @generated
 */
public class DetailInternationalTravelLocalServiceWrapper
	implements DetailInternationalTravelLocalService,
			   ServiceWrapper<DetailInternationalTravelLocalService> {

	public DetailInternationalTravelLocalServiceWrapper(
		DetailInternationalTravelLocalService
			detailInternationalTravelLocalService) {

		_detailInternationalTravelLocalService =
			detailInternationalTravelLocalService;
	}

	@Override
	public com.mypage.leads.model.DetailInternationalTravel addDetail(
		long userId, long detailId,
		com.liferay.portal.kernel.json.JSONObject data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _detailInternationalTravelLocalService.addDetail(
			userId, detailId, data, serviceContext);
	}

	@Override
	public com.mypage.leads.model.DetailInternationalTravel addDetailData(
		long userId, long detailId, java.util.HashMap<String, Object> data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _detailInternationalTravelLocalService.addDetailData(
			userId, detailId, data, serviceContext);
	}

	/**
	 * Adds the detail international travel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailInternationalTravelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailInternationalTravel the detail international travel
	 * @return the detail international travel that was added
	 */
	@Override
	public com.mypage.leads.model.DetailInternationalTravel
		addDetailInternationalTravel(
			com.mypage.leads.model.DetailInternationalTravel
				detailInternationalTravel) {

		return _detailInternationalTravelLocalService.
			addDetailInternationalTravel(detailInternationalTravel);
	}

	/**
	 * Creates a new detail international travel with the primary key. Does not add the detail international travel to the database.
	 *
	 * @param DetailId the primary key for the new detail international travel
	 * @return the new detail international travel
	 */
	@Override
	public com.mypage.leads.model.DetailInternationalTravel
		createDetailInternationalTravel(long DetailId) {

		return _detailInternationalTravelLocalService.
			createDetailInternationalTravel(DetailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailInternationalTravelLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the detail international travel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailInternationalTravelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailInternationalTravel the detail international travel
	 * @return the detail international travel that was removed
	 */
	@Override
	public com.mypage.leads.model.DetailInternationalTravel
		deleteDetailInternationalTravel(
			com.mypage.leads.model.DetailInternationalTravel
				detailInternationalTravel) {

		return _detailInternationalTravelLocalService.
			deleteDetailInternationalTravel(detailInternationalTravel);
	}

	/**
	 * Deletes the detail international travel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailInternationalTravelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param DetailId the primary key of the detail international travel
	 * @return the detail international travel that was removed
	 * @throws PortalException if a detail international travel with the primary key could not be found
	 */
	@Override
	public com.mypage.leads.model.DetailInternationalTravel
			deleteDetailInternationalTravel(long DetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailInternationalTravelLocalService.
			deleteDetailInternationalTravel(DetailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailInternationalTravelLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _detailInternationalTravelLocalService.dynamicQuery();
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

		return _detailInternationalTravelLocalService.dynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailInternationalTravelModelImpl</code>.
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

		return _detailInternationalTravelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailInternationalTravelModelImpl</code>.
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

		return _detailInternationalTravelLocalService.dynamicQuery(
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

		return _detailInternationalTravelLocalService.dynamicQueryCount(
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

		return _detailInternationalTravelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.leads.model.DetailInternationalTravel
		fetchDetailInternationalTravel(long DetailId) {

		return _detailInternationalTravelLocalService.
			fetchDetailInternationalTravel(DetailId);
	}

	@Override
	public com.mypage.leads.model.DetailInternationalTravel findByLeadsId(
		long LeadsId) {

		return _detailInternationalTravelLocalService.findByLeadsId(LeadsId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _detailInternationalTravelLocalService.
			getActionableDynamicQuery();
	}

	/**
	 * Returns the detail international travel with the primary key.
	 *
	 * @param DetailId the primary key of the detail international travel
	 * @return the detail international travel
	 * @throws PortalException if a detail international travel with the primary key could not be found
	 */
	@Override
	public com.mypage.leads.model.DetailInternationalTravel
			getDetailInternationalTravel(long DetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailInternationalTravelLocalService.
			getDetailInternationalTravel(DetailId);
	}

	/**
	 * Returns a range of all the detail international travels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailInternationalTravelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail international travels
	 * @param end the upper bound of the range of detail international travels (not inclusive)
	 * @return the range of detail international travels
	 */
	@Override
	public java.util.List<com.mypage.leads.model.DetailInternationalTravel>
		getDetailInternationalTravels(int start, int end) {

		return _detailInternationalTravelLocalService.
			getDetailInternationalTravels(start, end);
	}

	/**
	 * Returns the number of detail international travels.
	 *
	 * @return the number of detail international travels
	 */
	@Override
	public int getDetailInternationalTravelsCount() {
		return _detailInternationalTravelLocalService.
			getDetailInternationalTravelsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _detailInternationalTravelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _detailInternationalTravelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailInternationalTravelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the detail international travel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailInternationalTravelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailInternationalTravel the detail international travel
	 * @return the detail international travel that was updated
	 */
	@Override
	public com.mypage.leads.model.DetailInternationalTravel
		updateDetailInternationalTravel(
			com.mypage.leads.model.DetailInternationalTravel
				detailInternationalTravel) {

		return _detailInternationalTravelLocalService.
			updateDetailInternationalTravel(detailInternationalTravel);
	}

	@Override
	public DetailInternationalTravelLocalService getWrappedService() {
		return _detailInternationalTravelLocalService;
	}

	@Override
	public void setWrappedService(
		DetailInternationalTravelLocalService
			detailInternationalTravelLocalService) {

		_detailInternationalTravelLocalService =
			detailInternationalTravelLocalService;
	}

	private DetailInternationalTravelLocalService
		_detailInternationalTravelLocalService;

}