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
 * Provides a wrapper for {@link DetailSmartactiveLocalService}.
 *
 * @author Gositus
 * @see DetailSmartactiveLocalService
 * @generated
 */
public class DetailSmartactiveLocalServiceWrapper
	implements DetailSmartactiveLocalService,
			   ServiceWrapper<DetailSmartactiveLocalService> {

	public DetailSmartactiveLocalServiceWrapper(
		DetailSmartactiveLocalService detailSmartactiveLocalService) {

		_detailSmartactiveLocalService = detailSmartactiveLocalService;
	}

	@Override
	public com.mypage.leads.model.DetailSmartactive addDetail(
		long userId, long detailId,
		com.liferay.portal.kernel.json.JSONObject data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _detailSmartactiveLocalService.addDetail(
			userId, detailId, data, serviceContext);
	}

	/**
	 * Adds the detail smartactive to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailSmartactiveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailSmartactive the detail smartactive
	 * @return the detail smartactive that was added
	 */
	@Override
	public com.mypage.leads.model.DetailSmartactive addDetailSmartactive(
		com.mypage.leads.model.DetailSmartactive detailSmartactive) {

		return _detailSmartactiveLocalService.addDetailSmartactive(
			detailSmartactive);
	}

	/**
	 * Creates a new detail smartactive with the primary key. Does not add the detail smartactive to the database.
	 *
	 * @param DetailId the primary key for the new detail smartactive
	 * @return the new detail smartactive
	 */
	@Override
	public com.mypage.leads.model.DetailSmartactive createDetailSmartactive(
		long DetailId) {

		return _detailSmartactiveLocalService.createDetailSmartactive(DetailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailSmartactiveLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the detail smartactive from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailSmartactiveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailSmartactive the detail smartactive
	 * @return the detail smartactive that was removed
	 */
	@Override
	public com.mypage.leads.model.DetailSmartactive deleteDetailSmartactive(
		com.mypage.leads.model.DetailSmartactive detailSmartactive) {

		return _detailSmartactiveLocalService.deleteDetailSmartactive(
			detailSmartactive);
	}

	/**
	 * Deletes the detail smartactive with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailSmartactiveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param DetailId the primary key of the detail smartactive
	 * @return the detail smartactive that was removed
	 * @throws PortalException if a detail smartactive with the primary key could not be found
	 */
	@Override
	public com.mypage.leads.model.DetailSmartactive deleteDetailSmartactive(
			long DetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailSmartactiveLocalService.deleteDetailSmartactive(DetailId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailSmartactiveLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _detailSmartactiveLocalService.dynamicQuery();
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

		return _detailSmartactiveLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailSmartactiveModelImpl</code>.
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

		return _detailSmartactiveLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailSmartactiveModelImpl</code>.
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

		return _detailSmartactiveLocalService.dynamicQuery(
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

		return _detailSmartactiveLocalService.dynamicQueryCount(dynamicQuery);
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

		return _detailSmartactiveLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.leads.model.DetailSmartactive fetchDetailSmartactive(
		long DetailId) {

		return _detailSmartactiveLocalService.fetchDetailSmartactive(DetailId);
	}

	@Override
	public com.mypage.leads.model.DetailSmartactive findByLeadsId(
		long LeadsId) {

		return _detailSmartactiveLocalService.findByLeadsId(LeadsId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _detailSmartactiveLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the detail smartactive with the primary key.
	 *
	 * @param DetailId the primary key of the detail smartactive
	 * @return the detail smartactive
	 * @throws PortalException if a detail smartactive with the primary key could not be found
	 */
	@Override
	public com.mypage.leads.model.DetailSmartactive getDetailSmartactive(
			long DetailId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailSmartactiveLocalService.getDetailSmartactive(DetailId);
	}

	/**
	 * Returns a range of all the detail smartactives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailSmartactiveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail smartactives
	 * @param end the upper bound of the range of detail smartactives (not inclusive)
	 * @return the range of detail smartactives
	 */
	@Override
	public java.util.List<com.mypage.leads.model.DetailSmartactive>
		getDetailSmartactives(int start, int end) {

		return _detailSmartactiveLocalService.getDetailSmartactives(start, end);
	}

	/**
	 * Returns the number of detail smartactives.
	 *
	 * @return the number of detail smartactives
	 */
	@Override
	public int getDetailSmartactivesCount() {
		return _detailSmartactiveLocalService.getDetailSmartactivesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _detailSmartactiveLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _detailSmartactiveLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailSmartactiveLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the detail smartactive in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailSmartactiveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailSmartactive the detail smartactive
	 * @return the detail smartactive that was updated
	 */
	@Override
	public com.mypage.leads.model.DetailSmartactive updateDetailSmartactive(
		com.mypage.leads.model.DetailSmartactive detailSmartactive) {

		return _detailSmartactiveLocalService.updateDetailSmartactive(
			detailSmartactive);
	}

	@Override
	public DetailSmartactiveLocalService getWrappedService() {
		return _detailSmartactiveLocalService;
	}

	@Override
	public void setWrappedService(
		DetailSmartactiveLocalService detailSmartactiveLocalService) {

		_detailSmartactiveLocalService = detailSmartactiveLocalService;
	}

	private DetailSmartactiveLocalService _detailSmartactiveLocalService;

}