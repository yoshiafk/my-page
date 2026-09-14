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

import com.mypage.leads.model.DetailInternationalTravel;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DetailInternationalTravel. This utility wraps
 * <code>com.mypage.leads.service.impl.DetailInternationalTravelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus
 * @see DetailInternationalTravelLocalService
 * @generated
 */
public class DetailInternationalTravelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.leads.service.impl.DetailInternationalTravelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static DetailInternationalTravel addDetail(
		long userId, long detailId,
		com.liferay.portal.kernel.json.JSONObject data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addDetail(userId, detailId, data, serviceContext);
	}

	public static DetailInternationalTravel addDetailData(
		long userId, long detailId, java.util.HashMap<String, Object> data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addDetailData(
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
	public static DetailInternationalTravel addDetailInternationalTravel(
		DetailInternationalTravel detailInternationalTravel) {

		return getService().addDetailInternationalTravel(
			detailInternationalTravel);
	}

	/**
	 * Creates a new detail international travel with the primary key. Does not add the detail international travel to the database.
	 *
	 * @param DetailId the primary key for the new detail international travel
	 * @return the new detail international travel
	 */
	public static DetailInternationalTravel createDetailInternationalTravel(
		long DetailId) {

		return getService().createDetailInternationalTravel(DetailId);
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
	 * Deletes the detail international travel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailInternationalTravelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailInternationalTravel the detail international travel
	 * @return the detail international travel that was removed
	 */
	public static DetailInternationalTravel deleteDetailInternationalTravel(
		DetailInternationalTravel detailInternationalTravel) {

		return getService().deleteDetailInternationalTravel(
			detailInternationalTravel);
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
	public static DetailInternationalTravel deleteDetailInternationalTravel(
			long DetailId)
		throws PortalException {

		return getService().deleteDetailInternationalTravel(DetailId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailInternationalTravelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailInternationalTravelModelImpl</code>.
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

	public static DetailInternationalTravel fetchDetailInternationalTravel(
		long DetailId) {

		return getService().fetchDetailInternationalTravel(DetailId);
	}

	public static DetailInternationalTravel findByLeadsId(long LeadsId) {
		return getService().findByLeadsId(LeadsId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the detail international travel with the primary key.
	 *
	 * @param DetailId the primary key of the detail international travel
	 * @return the detail international travel
	 * @throws PortalException if a detail international travel with the primary key could not be found
	 */
	public static DetailInternationalTravel getDetailInternationalTravel(
			long DetailId)
		throws PortalException {

		return getService().getDetailInternationalTravel(DetailId);
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
	public static List<DetailInternationalTravel> getDetailInternationalTravels(
		int start, int end) {

		return getService().getDetailInternationalTravels(start, end);
	}

	/**
	 * Returns the number of detail international travels.
	 *
	 * @return the number of detail international travels
	 */
	public static int getDetailInternationalTravelsCount() {
		return getService().getDetailInternationalTravelsCount();
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
	 * Updates the detail international travel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailInternationalTravelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailInternationalTravel the detail international travel
	 * @return the detail international travel that was updated
	 */
	public static DetailInternationalTravel updateDetailInternationalTravel(
		DetailInternationalTravel detailInternationalTravel) {

		return getService().updateDetailInternationalTravel(
			detailInternationalTravel);
	}

	public static DetailInternationalTravelLocalService getService() {
		return _service;
	}

	private static volatile DetailInternationalTravelLocalService _service;

}