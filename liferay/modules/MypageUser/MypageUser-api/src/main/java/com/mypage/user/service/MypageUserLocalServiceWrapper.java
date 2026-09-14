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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MypageUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserLocalService
 * @generated
 */
public class MypageUserLocalServiceWrapper
	implements MypageUserLocalService, ServiceWrapper<MypageUserLocalService> {

	public MypageUserLocalServiceWrapper(
		MypageUserLocalService mypageUserLocalService) {

		_mypageUserLocalService = mypageUserLocalService;
	}

	@Override
	public com.mypage.user.model.MypageUser addMypageUser(
			long mypageUserId, com.liferay.portal.kernel.json.JSONObject data,
			long userId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.text.ParseException {

		return _mypageUserLocalService.addMypageUser(
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
	@Override
	public com.mypage.user.model.MypageUser addMypageUser(
		com.mypage.user.model.MypageUser mypageUser) {

		return _mypageUserLocalService.addMypageUser(mypageUser);
	}

	@Override
	public com.mypage.user.model.MypageUser addMypageUserForAgencyPortal(
		com.liferay.portal.kernel.json.JSONObject data) {

		return _mypageUserLocalService.addMypageUserForAgencyPortal(data);
	}

	@Override
	public long authenticateForBasic(String email, String password) {
		return _mypageUserLocalService.authenticateForBasic(email, password);
	}

	/**
	 * Creates a new mypage user with the primary key. Does not add the mypage user to the database.
	 *
	 * @param mypageUserId the primary key for the new mypage user
	 * @return the new mypage user
	 */
	@Override
	public com.mypage.user.model.MypageUser createMypageUser(
		long mypageUserId) {

		return _mypageUserLocalService.createMypageUser(mypageUserId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.mypage.user.model.MypageUser deleteMypageUser(long mypageUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserLocalService.deleteMypageUser(mypageUserId);
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
	@Override
	public com.mypage.user.model.MypageUser deleteMypageUser(
		com.mypage.user.model.MypageUser mypageUser) {

		return _mypageUserLocalService.deleteMypageUser(mypageUser);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mypageUserLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _mypageUserLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _mypageUserLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _mypageUserLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _mypageUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _mypageUserLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.user.model.MypageUser fetchMypageUser(long mypageUserId) {
		return _mypageUserLocalService.fetchMypageUser(mypageUserId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _mypageUserLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.mypage.user.model.MypageUser getByAgentCode(String code) {
		return _mypageUserLocalService.getByAgentCode(code);
	}

	@Override
	public com.mypage.user.model.MypageUser getByDeptoreCode(
		String deptoreCode) {

		return _mypageUserLocalService.getByDeptoreCode(deptoreCode);
	}

	@Override
	public com.mypage.user.model.MypageUser getByLiferayUserId(
		long liferayUserId) {

		return _mypageUserLocalService.getByLiferayUserId(liferayUserId);
	}

	@Override
	public com.mypage.user.model.MypageUser getByPrettyUrl(String prettyUrl) {
		return _mypageUserLocalService.getByPrettyUrl(prettyUrl);
	}

	@Override
	public java.util.List<com.mypage.user.model.MypageUser> getByRoleId(
		long roleId) {

		return _mypageUserLocalService.getByRoleId(roleId);
	}

	@Override
	public com.mypage.user.model.MypageUser getByToken(String token) {
		return _mypageUserLocalService.getByToken(token);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _mypageUserLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.User>
		getJoinMypageUser() {

		return _mypageUserLocalService.getJoinMypageUser();
	}

	/**
	 * Returns the mypage user with the primary key.
	 *
	 * @param mypageUserId the primary key of the mypage user
	 * @return the mypage user
	 * @throws PortalException if a mypage user with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.MypageUser getMypageUser(long mypageUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserLocalService.getMypageUser(mypageUserId);
	}

	@Override
	public java.util.List<com.mypage.user.model.MypageUser> getMypageUsers() {
		return _mypageUserLocalService.getMypageUsers();
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
	@Override
	public java.util.List<com.mypage.user.model.MypageUser> getMypageUsers(
		int start, int end) {

		return _mypageUserLocalService.getMypageUsers(start, end);
	}

	/**
	 * Returns the number of mypage users.
	 *
	 * @return the number of mypage users
	 */
	@Override
	public int getMypageUsersCount() {
		return _mypageUserLocalService.getMypageUsersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mypageUserLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.user.model.MypageUser getUserByEmail(String email) {
		return _mypageUserLocalService.getUserByEmail(email);
	}

	@Override
	public com.mypage.user.model.MypageUser setActive(
			long id, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserLocalService.setActive(id, active, serviceContext);
	}

	@Override
	public com.mypage.user.model.MypageUser updateAgentFromDashboard(
			long liferayUserId, com.liferay.portal.kernel.json.JSONObject data)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.json.JSONException {

		return _mypageUserLocalService.updateAgentFromDashboard(
			liferayUserId, data);
	}

	@Override
	public com.mypage.user.model.MypageUser updateClub(
			String deptoreCode, String club,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserLocalService.updateClub(
			deptoreCode, club, serviceContext);
	}

	@Override
	public com.mypage.user.model.MypageUser updateCounterById(
		long userId, int counter) {

		return _mypageUserLocalService.updateCounterById(userId, counter);
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
	@Override
	public com.mypage.user.model.MypageUser updateMypageUser(
		com.mypage.user.model.MypageUser mypageUser) {

		return _mypageUserLocalService.updateMypageUser(mypageUser);
	}

	@Override
	public com.mypage.user.model.MypageUser updateProfileImage(
			long liferayUserId, long fileEntryId, String profileImageURL)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserLocalService.updateProfileImage(
			liferayUserId, fileEntryId, profileImageURL);
	}

	@Override
	public com.mypage.user.model.MypageUser updateStatusById(
		long userId, String status) {

		return _mypageUserLocalService.updateStatusById(userId, status);
	}

	@Override
	public com.mypage.user.model.MypageUser updateTempCodeById(
		long userId, String token, int expiresIn) {

		return _mypageUserLocalService.updateTempCodeById(
			userId, token, expiresIn);
	}

	@Override
	public MypageUserLocalService getWrappedService() {
		return _mypageUserLocalService;
	}

	@Override
	public void setWrappedService(
		MypageUserLocalService mypageUserLocalService) {

		_mypageUserLocalService = mypageUserLocalService;
	}

	private MypageUserLocalService _mypageUserLocalService;

}