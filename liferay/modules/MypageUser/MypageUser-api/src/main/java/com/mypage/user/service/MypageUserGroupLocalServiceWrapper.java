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
 * Provides a wrapper for {@link MypageUserGroupLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserGroupLocalService
 * @generated
 */
public class MypageUserGroupLocalServiceWrapper
	implements MypageUserGroupLocalService,
			   ServiceWrapper<MypageUserGroupLocalService> {

	public MypageUserGroupLocalServiceWrapper(
		MypageUserGroupLocalService mypageUserGroupLocalService) {

		_mypageUserGroupLocalService = mypageUserGroupLocalService;
	}

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
	@Override
	public com.mypage.user.model.MypageUserGroup addMypageUserGroup(
		com.mypage.user.model.MypageUserGroup mypageUserGroup) {

		return _mypageUserGroupLocalService.addMypageUserGroup(mypageUserGroup);
	}

	@Override
	public com.mypage.user.model.MypageUserGroup addUserGroup(
			String name, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserGroupLocalService.addUserGroup(name, active);
	}

	/**
	 * Creates a new mypage user group with the primary key. Does not add the mypage user group to the database.
	 *
	 * @param mypageUserGroupId the primary key for the new mypage user group
	 * @return the new mypage user group
	 */
	@Override
	public com.mypage.user.model.MypageUserGroup createMypageUserGroup(
		long mypageUserGroupId) {

		return _mypageUserGroupLocalService.createMypageUserGroup(
			mypageUserGroupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserGroupLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.mypage.user.model.MypageUserGroup deleteMypageUserGroup(
			long mypageUserGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserGroupLocalService.deleteMypageUserGroup(
			mypageUserGroupId);
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
	@Override
	public com.mypage.user.model.MypageUserGroup deleteMypageUserGroup(
		com.mypage.user.model.MypageUserGroup mypageUserGroup) {

		return _mypageUserGroupLocalService.deleteMypageUserGroup(
			mypageUserGroup);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserGroupLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mypageUserGroupLocalService.dynamicQuery();
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

		return _mypageUserGroupLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _mypageUserGroupLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _mypageUserGroupLocalService.dynamicQuery(
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

		return _mypageUserGroupLocalService.dynamicQueryCount(dynamicQuery);
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

		return _mypageUserGroupLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.user.model.MypageUserGroup fetchMypageUserGroup(
		long mypageUserGroupId) {

		return _mypageUserGroupLocalService.fetchMypageUserGroup(
			mypageUserGroupId);
	}

	@Override
	public com.mypage.user.model.MypageUserGroup findBymypageUserGroupId(
			long mypageUserGroupId)
		throws com.mypage.user.exception.NoSuchMypageUserGroupException {

		return _mypageUserGroupLocalService.findBymypageUserGroupId(
			mypageUserGroupId);
	}

	@Override
	public java.util.List<Long> findBymypageUserId(long mypageUserId) {
		return _mypageUserGroupLocalService.findBymypageUserId(mypageUserId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _mypageUserGroupLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.user.model.MypageUserGroup>
		getActiveGroup() {

		return _mypageUserGroupLocalService.getActiveGroup();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _mypageUserGroupLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the mypage user group with the primary key.
	 *
	 * @param mypageUserGroupId the primary key of the mypage user group
	 * @return the mypage user group
	 * @throws PortalException if a mypage user group with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.MypageUserGroup getMypageUserGroup(
			long mypageUserGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserGroupLocalService.getMypageUserGroup(
			mypageUserGroupId);
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
	@Override
	public java.util.List<com.mypage.user.model.MypageUserGroup>
		getMypageUserGroups(int start, int end) {

		return _mypageUserGroupLocalService.getMypageUserGroups(start, end);
	}

	/**
	 * Returns the number of mypage user groups.
	 *
	 * @return the number of mypage user groups
	 */
	@Override
	public int getMypageUserGroupsCount() {
		return _mypageUserGroupLocalService.getMypageUserGroupsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mypageUserGroupLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.user.model.MypageUserGroup setActive(
			long mypageUserGroupId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserGroupLocalService.setActive(
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
	@Override
	public com.mypage.user.model.MypageUserGroup updateMypageUserGroup(
		com.mypage.user.model.MypageUserGroup mypageUserGroup) {

		return _mypageUserGroupLocalService.updateMypageUserGroup(
			mypageUserGroup);
	}

	@Override
	public com.mypage.user.model.MypageUserGroup updateUserGroup(
			long mypageUserGroupId, String name, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserGroupLocalService.updateUserGroup(
			mypageUserGroupId, name, active);
	}

	@Override
	public MypageUserGroupLocalService getWrappedService() {
		return _mypageUserGroupLocalService;
	}

	@Override
	public void setWrappedService(
		MypageUserGroupLocalService mypageUserGroupLocalService) {

		_mypageUserGroupLocalService = mypageUserGroupLocalService;
	}

	private MypageUserGroupLocalService _mypageUserGroupLocalService;

}