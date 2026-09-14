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

import com.mypage.user.model.MypageUserWorkingHour;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for MypageUserWorkingHour. This utility wraps
 * <code>com.mypage.user.service.impl.MypageUserWorkingHourLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserWorkingHourLocalService
 * @generated
 */
public class MypageUserWorkingHourLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.user.service.impl.MypageUserWorkingHourLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the mypage user working hour to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserWorkingHourLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserWorkingHour the mypage user working hour
	 * @return the mypage user working hour that was added
	 */
	public static MypageUserWorkingHour addMypageUserWorkingHour(
		MypageUserWorkingHour mypageUserWorkingHour) {

		return getService().addMypageUserWorkingHour(mypageUserWorkingHour);
	}

	public static MypageUserWorkingHour addWorkingHour(
		long mypageUserId, String day, String startTime, String endTime,
		int status) {

		return getService().addWorkingHour(
			mypageUserId, day, startTime, endTime, status);
	}

	/**
	 * Creates a new mypage user working hour with the primary key. Does not add the mypage user working hour to the database.
	 *
	 * @param mypageUserWorkingHourId the primary key for the new mypage user working hour
	 * @return the new mypage user working hour
	 */
	public static MypageUserWorkingHour createMypageUserWorkingHour(
		long mypageUserWorkingHourId) {

		return getService().createMypageUserWorkingHour(
			mypageUserWorkingHourId);
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
	 * Deletes the mypage user working hour with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserWorkingHourLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserWorkingHourId the primary key of the mypage user working hour
	 * @return the mypage user working hour that was removed
	 * @throws PortalException if a mypage user working hour with the primary key could not be found
	 */
	public static MypageUserWorkingHour deleteMypageUserWorkingHour(
			long mypageUserWorkingHourId)
		throws PortalException {

		return getService().deleteMypageUserWorkingHour(
			mypageUserWorkingHourId);
	}

	/**
	 * Deletes the mypage user working hour from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserWorkingHourLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserWorkingHour the mypage user working hour
	 * @return the mypage user working hour that was removed
	 */
	public static MypageUserWorkingHour deleteMypageUserWorkingHour(
		MypageUserWorkingHour mypageUserWorkingHour) {

		return getService().deleteMypageUserWorkingHour(mypageUserWorkingHour);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserWorkingHourModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserWorkingHourModelImpl</code>.
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

	public static MypageUserWorkingHour fetchMypageUserWorkingHour(
		long mypageUserWorkingHourId) {

		return getService().fetchMypageUserWorkingHour(mypageUserWorkingHourId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<MypageUserWorkingHour> getByMypageUserId(
		long mypageUserId) {

		return getService().getByMypageUserId(mypageUserId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the mypage user working hour with the primary key.
	 *
	 * @param mypageUserWorkingHourId the primary key of the mypage user working hour
	 * @return the mypage user working hour
	 * @throws PortalException if a mypage user working hour with the primary key could not be found
	 */
	public static MypageUserWorkingHour getMypageUserWorkingHour(
			long mypageUserWorkingHourId)
		throws PortalException {

		return getService().getMypageUserWorkingHour(mypageUserWorkingHourId);
	}

	/**
	 * Returns a range of all the mypage user working hours.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @return the range of mypage user working hours
	 */
	public static List<MypageUserWorkingHour> getMypageUserWorkingHours(
		int start, int end) {

		return getService().getMypageUserWorkingHours(start, end);
	}

	/**
	 * Returns the number of mypage user working hours.
	 *
	 * @return the number of mypage user working hours
	 */
	public static int getMypageUserWorkingHoursCount() {
		return getService().getMypageUserWorkingHoursCount();
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
	 * Updates the mypage user working hour in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserWorkingHourLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserWorkingHour the mypage user working hour
	 * @return the mypage user working hour that was updated
	 */
	public static MypageUserWorkingHour updateMypageUserWorkingHour(
		MypageUserWorkingHour mypageUserWorkingHour) {

		return getService().updateMypageUserWorkingHour(mypageUserWorkingHour);
	}

	public static MypageUserWorkingHourLocalService getService() {
		return _service;
	}

	private static volatile MypageUserWorkingHourLocalService _service;

}