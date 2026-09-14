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

import com.mypage.leads.model.DetailSmartactive;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DetailSmartactive. This utility wraps
 * <code>com.mypage.leads.service.impl.DetailSmartactiveLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus
 * @see DetailSmartactiveLocalService
 * @generated
 */
public class DetailSmartactiveLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.leads.service.impl.DetailSmartactiveLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static DetailSmartactive addDetail(
		long userId, long detailId,
		com.liferay.portal.kernel.json.JSONObject data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addDetail(userId, detailId, data, serviceContext);
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
	public static DetailSmartactive addDetailSmartactive(
		DetailSmartactive detailSmartactive) {

		return getService().addDetailSmartactive(detailSmartactive);
	}

	/**
	 * Creates a new detail smartactive with the primary key. Does not add the detail smartactive to the database.
	 *
	 * @param DetailId the primary key for the new detail smartactive
	 * @return the new detail smartactive
	 */
	public static DetailSmartactive createDetailSmartactive(long DetailId) {
		return getService().createDetailSmartactive(DetailId);
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
	 * Deletes the detail smartactive from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailSmartactiveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailSmartactive the detail smartactive
	 * @return the detail smartactive that was removed
	 */
	public static DetailSmartactive deleteDetailSmartactive(
		DetailSmartactive detailSmartactive) {

		return getService().deleteDetailSmartactive(detailSmartactive);
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
	public static DetailSmartactive deleteDetailSmartactive(long DetailId)
		throws PortalException {

		return getService().deleteDetailSmartactive(DetailId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailSmartactiveModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailSmartactiveModelImpl</code>.
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

	public static DetailSmartactive fetchDetailSmartactive(long DetailId) {
		return getService().fetchDetailSmartactive(DetailId);
	}

	public static DetailSmartactive findByLeadsId(long LeadsId) {
		return getService().findByLeadsId(LeadsId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the detail smartactive with the primary key.
	 *
	 * @param DetailId the primary key of the detail smartactive
	 * @return the detail smartactive
	 * @throws PortalException if a detail smartactive with the primary key could not be found
	 */
	public static DetailSmartactive getDetailSmartactive(long DetailId)
		throws PortalException {

		return getService().getDetailSmartactive(DetailId);
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
	public static List<DetailSmartactive> getDetailSmartactives(
		int start, int end) {

		return getService().getDetailSmartactives(start, end);
	}

	/**
	 * Returns the number of detail smartactives.
	 *
	 * @return the number of detail smartactives
	 */
	public static int getDetailSmartactivesCount() {
		return getService().getDetailSmartactivesCount();
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
	 * Updates the detail smartactive in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailSmartactiveLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailSmartactive the detail smartactive
	 * @return the detail smartactive that was updated
	 */
	public static DetailSmartactive updateDetailSmartactive(
		DetailSmartactive detailSmartactive) {

		return getService().updateDetailSmartactive(detailSmartactive);
	}

	public static DetailSmartactiveLocalService getService() {
		return _service;
	}

	private static volatile DetailSmartactiveLocalService _service;

}