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

import com.mypage.user.model.MypageGroupUser;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for MypageGroupUser. This utility wraps
 * <code>com.mypage.user.service.impl.MypageGroupUserLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MypageGroupUserLocalService
 * @generated
 */
public class MypageGroupUserLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.user.service.impl.MypageGroupUserLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static MypageGroupUser addGroupUser(
			long mypageGroupId, List<Long> mypageUserId)
		throws PortalException {

		return getService().addGroupUser(mypageGroupId, mypageUserId);
	}

	/**
	 * Adds the mypage group user to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageGroupUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageGroupUser the mypage group user
	 * @return the mypage group user that was added
	 */
	public static MypageGroupUser addMypageGroupUser(
		MypageGroupUser mypageGroupUser) {

		return getService().addMypageGroupUser(mypageGroupUser);
	}

	/**
	 * Creates a new mypage group user with the primary key. Does not add the mypage group user to the database.
	 *
	 * @param mypageGroupUserId the primary key for the new mypage group user
	 * @return the new mypage group user
	 */
	public static MypageGroupUser createMypageGroupUser(
		long mypageGroupUserId) {

		return getService().createMypageGroupUser(mypageGroupUserId);
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
	 * Deletes the mypage group user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageGroupUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageGroupUserId the primary key of the mypage group user
	 * @return the mypage group user that was removed
	 * @throws PortalException if a mypage group user with the primary key could not be found
	 */
	public static MypageGroupUser deleteMypageGroupUser(long mypageGroupUserId)
		throws PortalException {

		return getService().deleteMypageGroupUser(mypageGroupUserId);
	}

	/**
	 * Deletes the mypage group user from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageGroupUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageGroupUser the mypage group user
	 * @return the mypage group user that was removed
	 */
	public static MypageGroupUser deleteMypageGroupUser(
		MypageGroupUser mypageGroupUser) {

		return getService().deleteMypageGroupUser(mypageGroupUser);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageGroupUserModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageGroupUserModelImpl</code>.
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

	public static MypageGroupUser fetchMypageGroupUser(long mypageGroupUserId) {
		return getService().fetchMypageGroupUser(mypageGroupUserId);
	}

	public static List<com.mypage.user.model.MypageUser> findBymypageGroupId(
		long mypageGroupId) {

		return getService().findBymypageGroupId(mypageGroupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<com.mypage.user.model.MypageUserGroup> getActiveGroup() {
		return getService().getActiveGroup();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the mypage group user with the primary key.
	 *
	 * @param mypageGroupUserId the primary key of the mypage group user
	 * @return the mypage group user
	 * @throws PortalException if a mypage group user with the primary key could not be found
	 */
	public static MypageGroupUser getMypageGroupUser(long mypageGroupUserId)
		throws PortalException {

		return getService().getMypageGroupUser(mypageGroupUserId);
	}

	/**
	 * Returns a range of all the mypage group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageGroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage group users
	 * @param end the upper bound of the range of mypage group users (not inclusive)
	 * @return the range of mypage group users
	 */
	public static List<MypageGroupUser> getMypageGroupUsers(
		int start, int end) {

		return getService().getMypageGroupUsers(start, end);
	}

	/**
	 * Returns the number of mypage group users.
	 *
	 * @return the number of mypage group users
	 */
	public static int getMypageGroupUsersCount() {
		return getService().getMypageGroupUsersCount();
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

	public static MypageGroupUser removeGroupUser(
			long mypageGroupId, List<Long> mypageUserId)
		throws PortalException {

		return getService().removeGroupUser(mypageGroupId, mypageUserId);
	}

	/**
	 * Updates the mypage group user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageGroupUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageGroupUser the mypage group user
	 * @return the mypage group user that was updated
	 */
	public static MypageGroupUser updateMypageGroupUser(
		MypageGroupUser mypageGroupUser) {

		return getService().updateMypageGroupUser(mypageGroupUser);
	}

	public static MypageGroupUserLocalService getService() {
		return _service;
	}

	private static volatile MypageGroupUserLocalService _service;

}