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
 * Provides a wrapper for {@link PromocodesLocalService}.
 *
 * @author Gositus Team
 * @see PromocodesLocalService
 * @generated
 */
public class PromocodesLocalServiceWrapper
	implements PromocodesLocalService, ServiceWrapper<PromocodesLocalService> {

	public PromocodesLocalServiceWrapper(
		PromocodesLocalService promocodesLocalService) {

		_promocodesLocalService = promocodesLocalService;
	}

	@Override
	public com.mypage.admin.product.model.Promocodes addPromocodes(
			long promocodeId, com.liferay.portal.kernel.json.JSONObject data,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _promocodesLocalService.addPromocodes(
			promocodeId, data, serviceContext);
	}

	/**
	 * Adds the promocodes to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PromocodesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param promocodes the promocodes
	 * @return the promocodes that was added
	 */
	@Override
	public com.mypage.admin.product.model.Promocodes addPromocodes(
		com.mypage.admin.product.model.Promocodes promocodes) {

		return _promocodesLocalService.addPromocodes(promocodes);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _promocodesLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new promocodes with the primary key. Does not add the promocodes to the database.
	 *
	 * @param promocodeId the primary key for the new promocodes
	 * @return the new promocodes
	 */
	@Override
	public com.mypage.admin.product.model.Promocodes createPromocodes(
		long promocodeId) {

		return _promocodesLocalService.createPromocodes(promocodeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _promocodesLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the promocodes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PromocodesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param promocodeId the primary key of the promocodes
	 * @return the promocodes that was removed
	 * @throws PortalException if a promocodes with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.Promocodes deletePromocodes(
			long promocodeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _promocodesLocalService.deletePromocodes(promocodeId);
	}

	/**
	 * Deletes the promocodes from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PromocodesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param promocodes the promocodes
	 * @return the promocodes that was removed
	 */
	@Override
	public com.mypage.admin.product.model.Promocodes deletePromocodes(
		com.mypage.admin.product.model.Promocodes promocodes) {

		return _promocodesLocalService.deletePromocodes(promocodes);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _promocodesLocalService.dynamicQuery();
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

		return _promocodesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PromocodesModelImpl</code>.
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

		return _promocodesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PromocodesModelImpl</code>.
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

		return _promocodesLocalService.dynamicQuery(
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

		return _promocodesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _promocodesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.Promocodes fetchPromocodes(
		long promocodeId) {

		return _promocodesLocalService.fetchPromocodes(promocodeId);
	}

	/**
	 * Returns the promocodes matching the UUID and group.
	 *
	 * @param uuid the promocodes's UUID
	 * @param groupId the primary key of the group
	 * @return the matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	@Override
	public com.mypage.admin.product.model.Promocodes
		fetchPromocodesByUuidAndGroupId(String uuid, long groupId) {

		return _promocodesLocalService.fetchPromocodesByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _promocodesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _promocodesLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _promocodesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _promocodesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _promocodesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the promocodes with the primary key.
	 *
	 * @param promocodeId the primary key of the promocodes
	 * @return the promocodes
	 * @throws PortalException if a promocodes with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.Promocodes getPromocodes(
			long promocodeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _promocodesLocalService.getPromocodes(promocodeId);
	}

	/**
	 * Returns the promocodes matching the UUID and group.
	 *
	 * @param uuid the promocodes's UUID
	 * @param groupId the primary key of the group
	 * @return the matching promocodes
	 * @throws PortalException if a matching promocodes could not be found
	 */
	@Override
	public com.mypage.admin.product.model.Promocodes
			getPromocodesByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _promocodesLocalService.getPromocodesByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the promocodeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PromocodesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of promocodeses
	 * @param end the upper bound of the range of promocodeses (not inclusive)
	 * @return the range of promocodeses
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.Promocodes>
		getPromocodeses(int start, int end) {

		return _promocodesLocalService.getPromocodeses(start, end);
	}

	/**
	 * Returns all the promocodeses matching the UUID and company.
	 *
	 * @param uuid the UUID of the promocodeses
	 * @param companyId the primary key of the company
	 * @return the matching promocodeses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.Promocodes>
		getPromocodesesByUuidAndCompanyId(String uuid, long companyId) {

		return _promocodesLocalService.getPromocodesesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of promocodeses matching the UUID and company.
	 *
	 * @param uuid the UUID of the promocodeses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of promocodeses
	 * @param end the upper bound of the range of promocodeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching promocodeses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.Promocodes>
		getPromocodesesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.mypage.admin.product.model.Promocodes> orderByComparator) {

		return _promocodesLocalService.getPromocodesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of promocodeses.
	 *
	 * @return the number of promocodeses
	 */
	@Override
	public int getPromocodesesCount() {
		return _promocodesLocalService.getPromocodesesCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.Promocodes>
		searchB2CPromo(
			String promocode, java.util.Date startDate, java.util.Date endDate,
			String products) {

		return _promocodesLocalService.searchB2CPromo(
			promocode, startDate, endDate, products);
	}

	@Override
	public com.mypage.admin.product.model.Promocodes setActive(
			long userId, long promocodeId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _promocodesLocalService.setActive(
			userId, promocodeId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.Promocodes updatePromocodes(
			long promocodeId, com.liferay.portal.kernel.json.JSONObject data)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.json.JSONException {

		return _promocodesLocalService.updatePromocodes(promocodeId, data);
	}

	/**
	 * Updates the promocodes in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PromocodesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param promocodes the promocodes
	 * @return the promocodes that was updated
	 */
	@Override
	public com.mypage.admin.product.model.Promocodes updatePromocodes(
		com.mypage.admin.product.model.Promocodes promocodes) {

		return _promocodesLocalService.updatePromocodes(promocodes);
	}

	@Override
	public PromocodesLocalService getWrappedService() {
		return _promocodesLocalService;
	}

	@Override
	public void setWrappedService(
		PromocodesLocalService promocodesLocalService) {

		_promocodesLocalService = promocodesLocalService;
	}

	private PromocodesLocalService _promocodesLocalService;

}