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

import com.mypage.leads.model.DetailHealthIndividu;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DetailHealthIndividu. This utility wraps
 * <code>com.mypage.leads.service.impl.DetailHealthIndividuLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus
 * @see DetailHealthIndividuLocalService
 * @generated
 */
public class DetailHealthIndividuLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.leads.service.impl.DetailHealthIndividuLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static DetailHealthIndividu addDetail(
		long userId, long detailId,
		com.liferay.portal.kernel.json.JSONObject data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addDetail(userId, detailId, data, serviceContext);
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
	public static DetailHealthIndividu addDetailHealthIndividu(
		DetailHealthIndividu detailHealthIndividu) {

		return getService().addDetailHealthIndividu(detailHealthIndividu);
	}

	/**
	 * Creates a new detail health individu with the primary key. Does not add the detail health individu to the database.
	 *
	 * @param detailHealthIndividuId the primary key for the new detail health individu
	 * @return the new detail health individu
	 */
	public static DetailHealthIndividu createDetailHealthIndividu(
		long detailHealthIndividuId) {

		return getService().createDetailHealthIndividu(detailHealthIndividuId);
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
	 * Deletes the detail health individu from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DetailHealthIndividuLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param detailHealthIndividu the detail health individu
	 * @return the detail health individu that was removed
	 */
	public static DetailHealthIndividu deleteDetailHealthIndividu(
		DetailHealthIndividu detailHealthIndividu) {

		return getService().deleteDetailHealthIndividu(detailHealthIndividu);
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
	public static DetailHealthIndividu deleteDetailHealthIndividu(
			long detailHealthIndividuId)
		throws PortalException {

		return getService().deleteDetailHealthIndividu(detailHealthIndividuId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailHealthIndividuModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.DetailHealthIndividuModelImpl</code>.
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

	public static DetailHealthIndividu fetchDetailHealthIndividu(
		long detailHealthIndividuId) {

		return getService().fetchDetailHealthIndividu(detailHealthIndividuId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the detail health individu with the primary key.
	 *
	 * @param detailHealthIndividuId the primary key of the detail health individu
	 * @return the detail health individu
	 * @throws PortalException if a detail health individu with the primary key could not be found
	 */
	public static DetailHealthIndividu getDetailHealthIndividu(
			long detailHealthIndividuId)
		throws PortalException {

		return getService().getDetailHealthIndividu(detailHealthIndividuId);
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
	public static List<DetailHealthIndividu> getDetailHealthIndividus(
		int start, int end) {

		return getService().getDetailHealthIndividus(start, end);
	}

	/**
	 * Returns the number of detail health individus.
	 *
	 * @return the number of detail health individus
	 */
	public static int getDetailHealthIndividusCount() {
		return getService().getDetailHealthIndividusCount();
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

	public static DetailHealthIndividu searchByLeadsId(long LeadsId) {
		return getService().searchByLeadsId(LeadsId);
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
	public static DetailHealthIndividu updateDetailHealthIndividu(
		DetailHealthIndividu detailHealthIndividu) {

		return getService().updateDetailHealthIndividu(detailHealthIndividu);
	}

	public static DetailHealthIndividuLocalService getService() {
		return _service;
	}

	private static volatile DetailHealthIndividuLocalService _service;

}