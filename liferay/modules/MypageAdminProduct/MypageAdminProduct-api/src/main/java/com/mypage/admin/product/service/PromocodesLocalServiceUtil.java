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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.Promocodes;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Promocodes. This utility wraps
 * <code>com.mypage.admin.product.service.impl.PromocodesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see PromocodesLocalService
 * @generated
 */
public class PromocodesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.PromocodesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Promocodes addPromocodes(
			long promocodeId, com.liferay.portal.kernel.json.JSONObject data,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addPromocodes(promocodeId, data, serviceContext);
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
	public static Promocodes addPromocodes(Promocodes promocodes) {
		return getService().addPromocodes(promocodes);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new promocodes with the primary key. Does not add the promocodes to the database.
	 *
	 * @param promocodeId the primary key for the new promocodes
	 * @return the new promocodes
	 */
	public static Promocodes createPromocodes(long promocodeId) {
		return getService().createPromocodes(promocodeId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static Promocodes deletePromocodes(long promocodeId)
		throws PortalException {

		return getService().deletePromocodes(promocodeId);
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
	public static Promocodes deletePromocodes(Promocodes promocodes) {
		return getService().deletePromocodes(promocodes);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Promocodes fetchPromocodes(long promocodeId) {
		return getService().fetchPromocodes(promocodeId);
	}

	/**
	 * Returns the promocodes matching the UUID and group.
	 *
	 * @param uuid the promocodes's UUID
	 * @param groupId the primary key of the group
	 * @return the matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public static Promocodes fetchPromocodesByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPromocodesByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the promocodes with the primary key.
	 *
	 * @param promocodeId the primary key of the promocodes
	 * @return the promocodes
	 * @throws PortalException if a promocodes with the primary key could not be found
	 */
	public static Promocodes getPromocodes(long promocodeId)
		throws PortalException {

		return getService().getPromocodes(promocodeId);
	}

	/**
	 * Returns the promocodes matching the UUID and group.
	 *
	 * @param uuid the promocodes's UUID
	 * @param groupId the primary key of the group
	 * @return the matching promocodes
	 * @throws PortalException if a matching promocodes could not be found
	 */
	public static Promocodes getPromocodesByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getPromocodesByUuidAndGroupId(uuid, groupId);
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
	public static List<Promocodes> getPromocodeses(int start, int end) {
		return getService().getPromocodeses(start, end);
	}

	/**
	 * Returns all the promocodeses matching the UUID and company.
	 *
	 * @param uuid the UUID of the promocodeses
	 * @param companyId the primary key of the company
	 * @return the matching promocodeses, or an empty list if no matches were found
	 */
	public static List<Promocodes> getPromocodesesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getPromocodesesByUuidAndCompanyId(uuid, companyId);
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
	public static List<Promocodes> getPromocodesesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Promocodes> orderByComparator) {

		return getService().getPromocodesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of promocodeses.
	 *
	 * @return the number of promocodeses
	 */
	public static int getPromocodesesCount() {
		return getService().getPromocodesesCount();
	}

	public static List<Promocodes> searchB2CPromo(
		String promocode, java.util.Date startDate, java.util.Date endDate,
		String products) {

		return getService().searchB2CPromo(
			promocode, startDate, endDate, products);
	}

	public static Promocodes setActive(
			long userId, long promocodeId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			userId, promocodeId, active, serviceContext);
	}

	public static Promocodes updatePromocodes(
			long promocodeId, com.liferay.portal.kernel.json.JSONObject data)
		throws com.liferay.portal.kernel.json.JSONException, PortalException {

		return getService().updatePromocodes(promocodeId, data);
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
	public static Promocodes updatePromocodes(Promocodes promocodes) {
		return getService().updatePromocodes(promocodes);
	}

	public static PromocodesLocalService getService() {
		return _service;
	}

	private static volatile PromocodesLocalService _service;

}