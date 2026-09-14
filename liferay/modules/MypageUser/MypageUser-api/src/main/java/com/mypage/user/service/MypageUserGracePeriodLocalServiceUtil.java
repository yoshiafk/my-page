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

import com.mypage.user.model.MypageUserGracePeriod;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for MypageUserGracePeriod. This utility wraps
 * <code>com.mypage.user.service.impl.MypageUserGracePeriodLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserGracePeriodLocalService
 * @generated
 */
public class MypageUserGracePeriodLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.user.service.impl.MypageUserGracePeriodLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static MypageUserGracePeriod addGracePeriod(
		long mypageUserId, String code, int value) {

		return getService().addGracePeriod(mypageUserId, code, value);
	}

	/**
	 * Adds the mypage user grace period to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserGracePeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserGracePeriod the mypage user grace period
	 * @return the mypage user grace period that was added
	 */
	public static MypageUserGracePeriod addMypageUserGracePeriod(
		MypageUserGracePeriod mypageUserGracePeriod) {

		return getService().addMypageUserGracePeriod(mypageUserGracePeriod);
	}

	/**
	 * Creates a new mypage user grace period with the primary key. Does not add the mypage user grace period to the database.
	 *
	 * @param mypageUserGracePeriodId the primary key for the new mypage user grace period
	 * @return the new mypage user grace period
	 */
	public static MypageUserGracePeriod createMypageUserGracePeriod(
		long mypageUserGracePeriodId) {

		return getService().createMypageUserGracePeriod(
			mypageUserGracePeriodId);
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
	 * Deletes the mypage user grace period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserGracePeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserGracePeriodId the primary key of the mypage user grace period
	 * @return the mypage user grace period that was removed
	 * @throws PortalException if a mypage user grace period with the primary key could not be found
	 */
	public static MypageUserGracePeriod deleteMypageUserGracePeriod(
			long mypageUserGracePeriodId)
		throws PortalException {

		return getService().deleteMypageUserGracePeriod(
			mypageUserGracePeriodId);
	}

	/**
	 * Deletes the mypage user grace period from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserGracePeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserGracePeriod the mypage user grace period
	 * @return the mypage user grace period that was removed
	 */
	public static MypageUserGracePeriod deleteMypageUserGracePeriod(
		MypageUserGracePeriod mypageUserGracePeriod) {

		return getService().deleteMypageUserGracePeriod(mypageUserGracePeriod);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserGracePeriodModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserGracePeriodModelImpl</code>.
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

	public static MypageUserGracePeriod fetchMypageUserGracePeriod(
		long mypageUserGracePeriodId) {

		return getService().fetchMypageUserGracePeriod(mypageUserGracePeriodId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<MypageUserGracePeriod> getByMypageUserId(
		long mypageUserId) {

		return getService().getByMypageUserId(mypageUserId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the mypage user grace period with the primary key.
	 *
	 * @param mypageUserGracePeriodId the primary key of the mypage user grace period
	 * @return the mypage user grace period
	 * @throws PortalException if a mypage user grace period with the primary key could not be found
	 */
	public static MypageUserGracePeriod getMypageUserGracePeriod(
			long mypageUserGracePeriodId)
		throws PortalException {

		return getService().getMypageUserGracePeriod(mypageUserGracePeriodId);
	}

	/**
	 * Returns a range of all the mypage user grace periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @return the range of mypage user grace periods
	 */
	public static List<MypageUserGracePeriod> getMypageUserGracePeriods(
		int start, int end) {

		return getService().getMypageUserGracePeriods(start, end);
	}

	/**
	 * Returns the number of mypage user grace periods.
	 *
	 * @return the number of mypage user grace periods
	 */
	public static int getMypageUserGracePeriodsCount() {
		return getService().getMypageUserGracePeriodsCount();
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
	 * Updates the mypage user grace period in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserGracePeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserGracePeriod the mypage user grace period
	 * @return the mypage user grace period that was updated
	 */
	public static MypageUserGracePeriod updateMypageUserGracePeriod(
		MypageUserGracePeriod mypageUserGracePeriod) {

		return getService().updateMypageUserGracePeriod(mypageUserGracePeriod);
	}

	public static MypageUserGracePeriodLocalService getService() {
		return _service;
	}

	private static volatile MypageUserGracePeriodLocalService _service;

}