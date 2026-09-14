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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.leads.model.DetailDomesticTravel;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DetailDomesticTravel. This utility wraps
 * <code>com.mypage.leads.service.impl.DetailDomesticTravelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus
 * @see DetailDomesticTravelLocalService
 * @generated
 */
public class DetailDomesticTravelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.leads.service.impl.DetailDomesticTravelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static DetailDomesticTravel addDetail(
		long userId, long detailId,
		com.liferay.portal.kernel.json.JSONObject data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addDetail(userId, detailId, data, serviceContext);
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
	public static DetailDomesticTravel addDetailDomesticTravel(
		DetailDomesticTravel detailDomesticTravel) {

		return getService().addDetailDomesticTravel(detailDomesticTravel);
	}

	/**
	 * Creates a new detail domestic travel with the primary key. Does not add the detail domestic travel to the database.
	 *
	 * @param detailDomesticTravelId the primary key for the new detail domestic travel
	 * @return the new detail domestic travel
	 */
	public static DetailDomesticTravel createDetailDomesticTravel(
		long detailDomesticTravelId) {

		return getService().createDetailDomesticTravel(detailDomesticTravelId);
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
	 * Deletes the detail domestic travel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailDomesticTravelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailDomesticTravel the detail domestic travel
	 * @return the detail domestic travel that was removed
	 */
	public static DetailDomesticTravel deleteDetailDomesticTravel(
		DetailDomesticTravel detailDomesticTravel) {

		return getService().deleteDetailDomesticTravel(detailDomesticTravel);
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
	public static DetailDomesticTravel deleteDetailDomesticTravel(
			long detailDomesticTravelId)
		throws PortalException {

		return getService().deleteDetailDomesticTravel(detailDomesticTravelId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailDomesticTravelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailDomesticTravelModelImpl</code>.
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

	public static DetailDomesticTravel fetchDetailDomesticTravel(
		long detailDomesticTravelId) {

		return getService().fetchDetailDomesticTravel(detailDomesticTravelId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the detail domestic travel with the primary key.
	 *
	 * @param detailDomesticTravelId the primary key of the detail domestic travel
	 * @return the detail domestic travel
	 * @throws PortalException if a detail domestic travel with the primary key could not be found
	 */
	public static DetailDomesticTravel getDetailDomesticTravel(
			long detailDomesticTravelId)
		throws PortalException {

		return getService().getDetailDomesticTravel(detailDomesticTravelId);
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
	public static List<DetailDomesticTravel> getDetailDomesticTravels(
		int start, int end) {

		return getService().getDetailDomesticTravels(start, end);
	}

	/**
	 * Returns the number of detail domestic travels.
	 *
	 * @return the number of detail domestic travels
	 */
	public static int getDetailDomesticTravelsCount() {
		return getService().getDetailDomesticTravelsCount();
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

	public static DetailDomesticTravel searchByLeadsId(long LeadsId) {
		return getService().searchByLeadsId(LeadsId);
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
	public static DetailDomesticTravel updateDetailDomesticTravel(
		DetailDomesticTravel detailDomesticTravel) {

		return getService().updateDetailDomesticTravel(detailDomesticTravel);
	}

	public static DetailDomesticTravelLocalService getService() {
		return _service;
	}

	private static volatile DetailDomesticTravelLocalService _service;

}