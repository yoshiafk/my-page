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

import com.mypage.user.model.MypageUser;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for MypageUser. This utility wraps
 * <code>com.mypage.user.service.impl.MypageUserLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserLocalService
 * @generated
 */
public class MypageUserLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.user.service.impl.MypageUserLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static MypageUser addMypageUser(
			long mypageUserId, com.liferay.portal.kernel.json.JSONObject data,
			long userId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws java.text.ParseException, PortalException {

		return getService().addMypageUser(
			mypageUserId, data, userId, serviceContext);
	}

	/**
	 * Adds the mypage user to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUser the mypage user
	 * @return the mypage user that was added
	 */
	public static MypageUser addMypageUser(MypageUser mypageUser) {
		return getService().addMypageUser(mypageUser);
	}

	public static MypageUser addMypageUserForAgencyPortal(
		com.liferay.portal.kernel.json.JSONObject data) {

		return getService().addMypageUserForAgencyPortal(data);
	}

	public static long authenticateForBasic(String email, String password) {
		return getService().authenticateForBasic(email, password);
	}

	/**
	 * Creates a new mypage user with the primary key. Does not add the mypage user to the database.
	 *
	 * @param mypageUserId the primary key for the new mypage user
	 * @return the new mypage user
	 */
	public static MypageUser createMypageUser(long mypageUserId) {
		return getService().createMypageUser(mypageUserId);
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
	 * Deletes the mypage user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserId the primary key of the mypage user
	 * @return the mypage user that was removed
	 * @throws PortalException if a mypage user with the primary key could not be found
	 */
	public static MypageUser deleteMypageUser(long mypageUserId)
		throws PortalException {

		return getService().deleteMypageUser(mypageUserId);
	}

	/**
	 * Deletes the mypage user from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUser the mypage user
	 * @return the mypage user that was removed
	 */
	public static MypageUser deleteMypageUser(MypageUser mypageUser) {
		return getService().deleteMypageUser(mypageUser);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserModelImpl</code>.
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

	public static MypageUser fetchMypageUser(long mypageUserId) {
		return getService().fetchMypageUser(mypageUserId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static MypageUser getByAgentCode(String code) {
		return getService().getByAgentCode(code);
	}

	public static MypageUser getByDeptoreCode(String deptoreCode) {
		return getService().getByDeptoreCode(deptoreCode);
	}

	public static MypageUser getByLiferayUserId(long liferayUserId) {
		return getService().getByLiferayUserId(liferayUserId);
	}

	public static MypageUser getByPrettyUrl(String prettyUrl) {
		return getService().getByPrettyUrl(prettyUrl);
	}

	public static List<MypageUser> getByRoleId(long roleId) {
		return getService().getByRoleId(roleId);
	}

	public static MypageUser getByToken(String token) {
		return getService().getByToken(token);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<com.liferay.portal.kernel.model.User>
		getJoinMypageUser() {

		return getService().getJoinMypageUser();
	}

	/**
	 * Returns the mypage user with the primary key.
	 *
	 * @param mypageUserId the primary key of the mypage user
	 * @return the mypage user
	 * @throws PortalException if a mypage user with the primary key could not be found
	 */
	public static MypageUser getMypageUser(long mypageUserId)
		throws PortalException {

		return getService().getMypageUser(mypageUserId);
	}

	public static List<MypageUser> getMypageUsers() {
		return getService().getMypageUsers();
	}

	/**
	 * Returns a range of all the mypage users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage users
	 * @param end the upper bound of the range of mypage users (not inclusive)
	 * @return the range of mypage users
	 */
	public static List<MypageUser> getMypageUsers(int start, int end) {
		return getService().getMypageUsers(start, end);
	}

	/**
	 * Returns the number of mypage users.
	 *
	 * @return the number of mypage users
	 */
	public static int getMypageUsersCount() {
		return getService().getMypageUsersCount();
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

	public static MypageUser getUserByEmail(String email) {
		return getService().getUserByEmail(email);
	}

	public static MypageUser setActive(
			long id, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(id, active, serviceContext);
	}

	public static MypageUser updateAgentFromDashboard(
			long liferayUserId, com.liferay.portal.kernel.json.JSONObject data)
		throws com.liferay.portal.kernel.json.JSONException, PortalException {

		return getService().updateAgentFromDashboard(liferayUserId, data);
	}

	public static MypageUser updateClub(
			String deptoreCode, String club,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateClub(deptoreCode, club, serviceContext);
	}

	public static MypageUser updateCounterById(long userId, int counter) {
		return getService().updateCounterById(userId, counter);
	}

	/**
	 * Updates the mypage user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUser the mypage user
	 * @return the mypage user that was updated
	 */
	public static MypageUser updateMypageUser(MypageUser mypageUser) {
		return getService().updateMypageUser(mypageUser);
	}

	public static MypageUser updateProfileImage(
			long liferayUserId, long fileEntryId, String profileImageURL)
		throws PortalException {

		return getService().updateProfileImage(
			liferayUserId, fileEntryId, profileImageURL);
	}

	public static MypageUser updateStatusById(long userId, String status) {
		return getService().updateStatusById(userId, status);
	}

	public static MypageUser updateTempCodeById(
		long userId, String token, int expiresIn) {

		return getService().updateTempCodeById(userId, token, expiresIn);
	}

	public static MypageUserLocalService getService() {
		return _service;
	}

	private static volatile MypageUserLocalService _service;

}