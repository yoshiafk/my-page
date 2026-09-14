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
 * Provides a wrapper for {@link DetailTlpLocalService}.
 *
 * @author Gositus
 * @see DetailTlpLocalService
 * @generated
 */
public class DetailTlpLocalServiceWrapper
	implements DetailTlpLocalService, ServiceWrapper<DetailTlpLocalService> {

	public DetailTlpLocalServiceWrapper(
		DetailTlpLocalService detailTlpLocalService) {

		_detailTlpLocalService = detailTlpLocalService;
	}

	/**
	 * Adds the detail tlp to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailTlpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailTlp the detail tlp
	 * @return the detail tlp that was added
	 */
	@Override
	public com.mypage.leads.model.DetailTlp addDetailTlp(
		com.mypage.leads.model.DetailTlp detailTlp) {

		return _detailTlpLocalService.addDetailTlp(detailTlp);
	}

	@Override
	public com.mypage.leads.model.DetailTlp addDetailTlp(
			long userId, long detailTlpId,
			com.liferay.portal.kernel.json.JSONObject data,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailTlpLocalService.addDetailTlp(
			userId, detailTlpId, data, serviceContext);
	}

	/**
	 * Creates a new detail tlp with the primary key. Does not add the detail tlp to the database.
	 *
	 * @param detailTlpId the primary key for the new detail tlp
	 * @return the new detail tlp
	 */
	@Override
	public com.mypage.leads.model.DetailTlp createDetailTlp(long detailTlpId) {
		return _detailTlpLocalService.createDetailTlp(detailTlpId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailTlpLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the detail tlp from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailTlpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailTlp the detail tlp
	 * @return the detail tlp that was removed
	 */
	@Override
	public com.mypage.leads.model.DetailTlp deleteDetailTlp(
		com.mypage.leads.model.DetailTlp detailTlp) {

		return _detailTlpLocalService.deleteDetailTlp(detailTlp);
	}

	/**
	 * Deletes the detail tlp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailTlpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailTlpId the primary key of the detail tlp
	 * @return the detail tlp that was removed
	 * @throws PortalException if a detail tlp with the primary key could not be found
	 */
	@Override
	public com.mypage.leads.model.DetailTlp deleteDetailTlp(long detailTlpId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailTlpLocalService.deleteDetailTlp(detailTlpId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailTlpLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _detailTlpLocalService.dynamicQuery();
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

		return _detailTlpLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailTlpModelImpl</code>.
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

		return _detailTlpLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailTlpModelImpl</code>.
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

		return _detailTlpLocalService.dynamicQuery(
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

		return _detailTlpLocalService.dynamicQueryCount(dynamicQuery);
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

		return _detailTlpLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.leads.model.DetailTlp fetchDetailTlp(long detailTlpId) {
		return _detailTlpLocalService.fetchDetailTlp(detailTlpId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _detailTlpLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the detail tlp with the primary key.
	 *
	 * @param detailTlpId the primary key of the detail tlp
	 * @return the detail tlp
	 * @throws PortalException if a detail tlp with the primary key could not be found
	 */
	@Override
	public com.mypage.leads.model.DetailTlp getDetailTlp(long detailTlpId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailTlpLocalService.getDetailTlp(detailTlpId);
	}

	/**
	 * Returns a range of all the detail tlps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @return the range of detail tlps
	 */
	@Override
	public java.util.List<com.mypage.leads.model.DetailTlp> getDetailTlps(
		int start, int end) {

		return _detailTlpLocalService.getDetailTlps(start, end);
	}

	/**
	 * Returns the number of detail tlps.
	 *
	 * @return the number of detail tlps
	 */
	@Override
	public int getDetailTlpsCount() {
		return _detailTlpLocalService.getDetailTlpsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _detailTlpLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _detailTlpLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailTlpLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the detail tlp in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailTlpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailTlp the detail tlp
	 * @return the detail tlp that was updated
	 */
	@Override
	public com.mypage.leads.model.DetailTlp updateDetailTlp(
		com.mypage.leads.model.DetailTlp detailTlp) {

		return _detailTlpLocalService.updateDetailTlp(detailTlp);
	}

	@Override
	public DetailTlpLocalService getWrappedService() {
		return _detailTlpLocalService;
	}

	@Override
	public void setWrappedService(DetailTlpLocalService detailTlpLocalService) {
		_detailTlpLocalService = detailTlpLocalService;
	}

	private DetailTlpLocalService _detailTlpLocalService;

}