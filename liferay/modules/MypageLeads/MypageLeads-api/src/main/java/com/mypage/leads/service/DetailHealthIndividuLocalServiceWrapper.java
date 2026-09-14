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
 * Provides a wrapper for {@link DetailHealthIndividuLocalService}.
 *
 * @author Gositus
 * @see DetailHealthIndividuLocalService
 * @generated
 */
public class DetailHealthIndividuLocalServiceWrapper
	implements DetailHealthIndividuLocalService,
			   ServiceWrapper<DetailHealthIndividuLocalService> {

	public DetailHealthIndividuLocalServiceWrapper(
		DetailHealthIndividuLocalService detailHealthIndividuLocalService) {

		_detailHealthIndividuLocalService = detailHealthIndividuLocalService;
	}

	@Override
	public com.mypage.leads.model.DetailHealthIndividu addDetail(
		long userId, long detailId,
		com.liferay.portal.kernel.json.JSONObject data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _detailHealthIndividuLocalService.addDetail(
			userId, detailId, data, serviceContext);
	}

	/**
	 * Adds the detail health individu to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailHealthIndividuLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailHealthIndividu the detail health individu
	 * @return the detail health individu that was added
	 */
	@Override
	public com.mypage.leads.model.DetailHealthIndividu addDetailHealthIndividu(
		com.mypage.leads.model.DetailHealthIndividu detailHealthIndividu) {

		return _detailHealthIndividuLocalService.addDetailHealthIndividu(
			detailHealthIndividu);
	}

	/**
	 * Creates a new detail health individu with the primary key. Does not add the detail health individu to the database.
	 *
	 * @param detailHealthIndividuId the primary key for the new detail health individu
	 * @return the new detail health individu
	 */
	@Override
	public com.mypage.leads.model.DetailHealthIndividu
		createDetailHealthIndividu(long detailHealthIndividuId) {

		return _detailHealthIndividuLocalService.createDetailHealthIndividu(
			detailHealthIndividuId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailHealthIndividuLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the detail health individu from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailHealthIndividuLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailHealthIndividu the detail health individu
	 * @return the detail health individu that was removed
	 */
	@Override
	public com.mypage.leads.model.DetailHealthIndividu
		deleteDetailHealthIndividu(
			com.mypage.leads.model.DetailHealthIndividu detailHealthIndividu) {

		return _detailHealthIndividuLocalService.deleteDetailHealthIndividu(
			detailHealthIndividu);
	}

	/**
	 * Deletes the detail health individu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailHealthIndividuLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailHealthIndividuId the primary key of the detail health individu
	 * @return the detail health individu that was removed
	 * @throws PortalException if a detail health individu with the primary key could not be found
	 */
	@Override
	public com.mypage.leads.model.DetailHealthIndividu
			deleteDetailHealthIndividu(long detailHealthIndividuId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailHealthIndividuLocalService.deleteDetailHealthIndividu(
			detailHealthIndividuId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailHealthIndividuLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _detailHealthIndividuLocalService.dynamicQuery();
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

		return _detailHealthIndividuLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailHealthIndividuModelImpl</code>.
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

		return _detailHealthIndividuLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailHealthIndividuModelImpl</code>.
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

		return _detailHealthIndividuLocalService.dynamicQuery(
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

		return _detailHealthIndividuLocalService.dynamicQueryCount(
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

		return _detailHealthIndividuLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.leads.model.DetailHealthIndividu
		fetchDetailHealthIndividu(long detailHealthIndividuId) {

		return _detailHealthIndividuLocalService.fetchDetailHealthIndividu(
			detailHealthIndividuId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _detailHealthIndividuLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the detail health individu with the primary key.
	 *
	 * @param detailHealthIndividuId the primary key of the detail health individu
	 * @return the detail health individu
	 * @throws PortalException if a detail health individu with the primary key could not be found
	 */
	@Override
	public com.mypage.leads.model.DetailHealthIndividu getDetailHealthIndividu(
			long detailHealthIndividuId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailHealthIndividuLocalService.getDetailHealthIndividu(
			detailHealthIndividuId);
	}

	/**
	 * Returns a range of all the detail health individus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailHealthIndividuModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail health individus
	 * @param end the upper bound of the range of detail health individus (not inclusive)
	 * @return the range of detail health individus
	 */
	@Override
	public java.util.List<com.mypage.leads.model.DetailHealthIndividu>
		getDetailHealthIndividus(int start, int end) {

		return _detailHealthIndividuLocalService.getDetailHealthIndividus(
			start, end);
	}

	/**
	 * Returns the number of detail health individus.
	 *
	 * @return the number of detail health individus
	 */
	@Override
	public int getDetailHealthIndividusCount() {
		return _detailHealthIndividuLocalService.
			getDetailHealthIndividusCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _detailHealthIndividuLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _detailHealthIndividuLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _detailHealthIndividuLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public com.mypage.leads.model.DetailHealthIndividu searchByLeadsId(
		long LeadsId) {

		return _detailHealthIndividuLocalService.searchByLeadsId(LeadsId);
	}

	/**
	 * Updates the detail health individu in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailHealthIndividuLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailHealthIndividu the detail health individu
	 * @return the detail health individu that was updated
	 */
	@Override
	public com.mypage.leads.model.DetailHealthIndividu
		updateDetailHealthIndividu(
			com.mypage.leads.model.DetailHealthIndividu detailHealthIndividu) {

		return _detailHealthIndividuLocalService.updateDetailHealthIndividu(
			detailHealthIndividu);
	}

	@Override
	public DetailHealthIndividuLocalService getWrappedService() {
		return _detailHealthIndividuLocalService;
	}

	@Override
	public void setWrappedService(
		DetailHealthIndividuLocalService detailHealthIndividuLocalService) {

		_detailHealthIndividuLocalService = detailHealthIndividuLocalService;
	}

	private DetailHealthIndividuLocalService _detailHealthIndividuLocalService;

}