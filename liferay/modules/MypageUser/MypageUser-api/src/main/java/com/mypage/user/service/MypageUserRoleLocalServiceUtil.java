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

import com.mypage.user.model.MypageUserRole;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for MypageUserRole. This utility wraps
 * <code>com.mypage.user.service.impl.MypageUserRoleLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserRoleLocalService
 * @generated
 */
public class MypageUserRoleLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.user.service.impl.MypageUserRoleLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the mypage user role to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserRole the mypage user role
	 * @return the mypage user role that was added
	 */
	public static MypageUserRole addMypageUserRole(
		MypageUserRole mypageUserRole) {

		return getService().addMypageUserRole(mypageUserRole);
	}

	public static MypageUserRole addUserRole(String name, int active)
		throws PortalException {

		return getService().addUserRole(name, active);
	}

	/**
	 * Creates a new mypage user role with the primary key. Does not add the mypage user role to the database.
	 *
	 * @param mypageUserRoleId the primary key for the new mypage user role
	 * @return the new mypage user role
	 */
	public static MypageUserRole createMypageUserRole(long mypageUserRoleId) {
		return getService().createMypageUserRole(mypageUserRoleId);
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
	 * Deletes the mypage user role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserRoleId the primary key of the mypage user role
	 * @return the mypage user role that was removed
	 * @throws PortalException if a mypage user role with the primary key could not be found
	 */
	public static MypageUserRole deleteMypageUserRole(long mypageUserRoleId)
		throws PortalException {

		return getService().deleteMypageUserRole(mypageUserRoleId);
	}

	/**
	 * Deletes the mypage user role from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserRole the mypage user role
	 * @return the mypage user role that was removed
	 */
	public static MypageUserRole deleteMypageUserRole(
		MypageUserRole mypageUserRole) {

		return getService().deleteMypageUserRole(mypageUserRole);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserRoleModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserRoleModelImpl</code>.
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

	public static MypageUserRole fetchMypageUserRole(long mypageUserRoleId) {
		return getService().fetchMypageUserRole(mypageUserRoleId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<MypageUserRole> getActiveRole() {
		return getService().getActiveRole();
	}

	public static MypageUserRole getByName(String name) {
		return getService().getByName(name);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the mypage user role with the primary key.
	 *
	 * @param mypageUserRoleId the primary key of the mypage user role
	 * @return the mypage user role
	 * @throws PortalException if a mypage user role with the primary key could not be found
	 */
	public static MypageUserRole getMypageUserRole(long mypageUserRoleId)
		throws PortalException {

		return getService().getMypageUserRole(mypageUserRoleId);
	}

	/**
	 * Returns a range of all the mypage user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserRoleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user roles
	 * @param end the upper bound of the range of mypage user roles (not inclusive)
	 * @return the range of mypage user roles
	 */
	public static List<MypageUserRole> getMypageUserRoles(int start, int end) {
		return getService().getMypageUserRoles(start, end);
	}

	/**
	 * Returns the number of mypage user roles.
	 *
	 * @return the number of mypage user roles
	 */
	public static int getMypageUserRolesCount() {
		return getService().getMypageUserRolesCount();
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

	public static MypageUserRole setActive(
			long mypageUserRoleId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(mypageUserRoleId, active, serviceContext);
	}

	/**
	 * Updates the mypage user role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserRoleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserRole the mypage user role
	 * @return the mypage user role that was updated
	 */
	public static MypageUserRole updateMypageUserRole(
		MypageUserRole mypageUserRole) {

		return getService().updateMypageUserRole(mypageUserRole);
	}

	public static MypageUserRole updateUserRole(
			long mypageUserRoleId, String name, int active)
		throws PortalException {

		return getService().updateUserRole(mypageUserRoleId, name, active);
	}

	public static MypageUserRoleLocalService getService() {
		return _service;
	}

	private static volatile MypageUserRoleLocalService _service;

}