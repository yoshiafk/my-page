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

import com.mypage.user.model.MypageUserGroup;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for MypageUserGroup. This utility wraps
 * <code>com.mypage.user.service.impl.MypageUserGroupLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserGroupLocalService
 * @generated
 */
public class MypageUserGroupLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.user.service.impl.MypageUserGroupLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the mypage user group to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserGroup the mypage user group
	 * @return the mypage user group that was added
	 */
	public static MypageUserGroup addMypageUserGroup(
		MypageUserGroup mypageUserGroup) {

		return getService().addMypageUserGroup(mypageUserGroup);
	}

	public static MypageUserGroup addUserGroup(String name, int active)
		throws PortalException {

		return getService().addUserGroup(name, active);
	}

	/**
	 * Creates a new mypage user group with the primary key. Does not add the mypage user group to the database.
	 *
	 * @param mypageUserGroupId the primary key for the new mypage user group
	 * @return the new mypage user group
	 */
	public static MypageUserGroup createMypageUserGroup(
		long mypageUserGroupId) {

		return getService().createMypageUserGroup(mypageUserGroupId);
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
	 * Deletes the mypage user group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserGroupId the primary key of the mypage user group
	 * @return the mypage user group that was removed
	 * @throws PortalException if a mypage user group with the primary key could not be found
	 */
	public static MypageUserGroup deleteMypageUserGroup(long mypageUserGroupId)
		throws PortalException {

		return getService().deleteMypageUserGroup(mypageUserGroupId);
	}

	/**
	 * Deletes the mypage user group from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserGroup the mypage user group
	 * @return the mypage user group that was removed
	 */
	public static MypageUserGroup deleteMypageUserGroup(
		MypageUserGroup mypageUserGroup) {

		return getService().deleteMypageUserGroup(mypageUserGroup);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserGroupModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserGroupModelImpl</code>.
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

	public static MypageUserGroup fetchMypageUserGroup(long mypageUserGroupId) {
		return getService().fetchMypageUserGroup(mypageUserGroupId);
	}

	public static MypageUserGroup findBymypageUserGroupId(
			long mypageUserGroupId)
		throws com.mypage.user.exception.NoSuchMypageUserGroupException {

		return getService().findBymypageUserGroupId(mypageUserGroupId);
	}

	public static List<Long> findBymypageUserId(long mypageUserId) {
		return getService().findBymypageUserId(mypageUserId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<MypageUserGroup> getActiveGroup() {
		return getService().getActiveGroup();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the mypage user group with the primary key.
	 *
	 * @param mypageUserGroupId the primary key of the mypage user group
	 * @return the mypage user group
	 * @throws PortalException if a mypage user group with the primary key could not be found
	 */
	public static MypageUserGroup getMypageUserGroup(long mypageUserGroupId)
		throws PortalException {

		return getService().getMypageUserGroup(mypageUserGroupId);
	}

	/**
	 * Returns a range of all the mypage user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user groups
	 * @param end the upper bound of the range of mypage user groups (not inclusive)
	 * @return the range of mypage user groups
	 */
	public static List<MypageUserGroup> getMypageUserGroups(
		int start, int end) {

		return getService().getMypageUserGroups(start, end);
	}

	/**
	 * Returns the number of mypage user groups.
	 *
	 * @return the number of mypage user groups
	 */
	public static int getMypageUserGroupsCount() {
		return getService().getMypageUserGroupsCount();
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

	public static MypageUserGroup setActive(
			long mypageUserGroupId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			mypageUserGroupId, active, serviceContext);
	}

	/**
	 * Updates the mypage user group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserGroup the mypage user group
	 * @return the mypage user group that was updated
	 */
	public static MypageUserGroup updateMypageUserGroup(
		MypageUserGroup mypageUserGroup) {

		return getService().updateMypageUserGroup(mypageUserGroup);
	}

	public static MypageUserGroup updateUserGroup(
			long mypageUserGroupId, String name, int active)
		throws PortalException {

		return getService().updateUserGroup(mypageUserGroupId, name, active);
	}

	public static MypageUserGroupLocalService getService() {
		return _service;
	}

	private static volatile MypageUserGroupLocalService _service;

}