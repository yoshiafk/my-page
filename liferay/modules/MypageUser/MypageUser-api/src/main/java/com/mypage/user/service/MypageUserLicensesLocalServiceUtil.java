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

package com.mypage.user.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.user.model.MypageUserLicenses;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for MypageUserLicenses. This utility wraps
 * <code>com.mypage.user.service.impl.MypageUserLicensesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserLicensesLocalService
 * @generated
 */
public class MypageUserLicensesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.user.service.impl.MypageUserLicensesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static MypageUserLicenses addMypageUserLicense(
		long mypageUserId, long productId) {

		return getService().addMypageUserLicense(mypageUserId, productId);
	}

	/**
	 * Adds the mypage user licenses to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserLicensesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserLicenses the mypage user licenses
	 * @return the mypage user licenses that was added
	 */
	public static MypageUserLicenses addMypageUserLicenses(
		MypageUserLicenses mypageUserLicenses) {

		return getService().addMypageUserLicenses(mypageUserLicenses);
	}

	/**
	 * Creates a new mypage user licenses with the primary key. Does not add the mypage user licenses to the database.
	 *
	 * @param mypageUserLicensesId the primary key for the new mypage user licenses
	 * @return the new mypage user licenses
	 */
	public static MypageUserLicenses createMypageUserLicenses(
		long mypageUserLicensesId) {

		return getService().createMypageUserLicenses(mypageUserLicensesId);
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
	 * Deletes the mypage user licenses with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserLicensesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserLicensesId the primary key of the mypage user licenses
	 * @return the mypage user licenses that was removed
	 * @throws PortalException if a mypage user licenses with the primary key could not be found
	 */
	public static MypageUserLicenses deleteMypageUserLicenses(
			long mypageUserLicensesId)
		throws PortalException {

		return getService().deleteMypageUserLicenses(mypageUserLicensesId);
	}

	/**
	 * Deletes the mypage user licenses from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserLicensesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserLicenses the mypage user licenses
	 * @return the mypage user licenses that was removed
	 */
	public static MypageUserLicenses deleteMypageUserLicenses(
		MypageUserLicenses mypageUserLicenses) {

		return getService().deleteMypageUserLicenses(mypageUserLicenses);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserLicensesModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserLicensesModelImpl</code>.
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

	public static MypageUserLicenses fetchMypageUserLicenses(
		long mypageUserLicensesId) {

		return getService().fetchMypageUserLicenses(mypageUserLicensesId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<MypageUserLicenses> getByMypageUserId(
		long mypageUserId) {

		return getService().getByMypageUserId(mypageUserId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the mypage user licenses with the primary key.
	 *
	 * @param mypageUserLicensesId the primary key of the mypage user licenses
	 * @return the mypage user licenses
	 * @throws PortalException if a mypage user licenses with the primary key could not be found
	 */
	public static MypageUserLicenses getMypageUserLicenses(
			long mypageUserLicensesId)
		throws PortalException {

		return getService().getMypageUserLicenses(mypageUserLicensesId);
	}

	/**
	 * Returns a range of all the mypage user licenseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @return the range of mypage user licenseses
	 */
	public static List<MypageUserLicenses> getMypageUserLicenseses(
		int start, int end) {

		return getService().getMypageUserLicenseses(start, end);
	}

	/**
	 * Returns the number of mypage user licenseses.
	 *
	 * @return the number of mypage user licenseses
	 */
	public static int getMypageUserLicensesesCount() {
		return getService().getMypageUserLicensesesCount();
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

	public static void removeByMypageUserId(long mypageUserId) {
		getService().removeByMypageUserId(mypageUserId);
	}

	/**
	 * Updates the mypage user licenses in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserLicensesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserLicenses the mypage user licenses
	 * @return the mypage user licenses that was updated
	 */
	public static MypageUserLicenses updateMypageUserLicenses(
		MypageUserLicenses mypageUserLicenses) {

		return getService().updateMypageUserLicenses(mypageUserLicenses);
	}

	public static MypageUserLicensesLocalService getService() {
		return _service;
	}

	private static volatile MypageUserLicensesLocalService _service;

}