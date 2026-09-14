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
 * Provides a wrapper for {@link MypageUserGracePeriodLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserGracePeriodLocalService
 * @generated
 */
public class MypageUserGracePeriodLocalServiceWrapper
	implements MypageUserGracePeriodLocalService,
			   ServiceWrapper<MypageUserGracePeriodLocalService> {

	public MypageUserGracePeriodLocalServiceWrapper(
		MypageUserGracePeriodLocalService mypageUserGracePeriodLocalService) {

		_mypageUserGracePeriodLocalService = mypageUserGracePeriodLocalService;
	}

	@Override
	public com.mypage.user.model.MypageUserGracePeriod addGracePeriod(
		long mypageUserId, String code, int value) {

		return _mypageUserGracePeriodLocalService.addGracePeriod(
			mypageUserId, code, value);
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
	@Override
	public com.mypage.user.model.MypageUserGracePeriod addMypageUserGracePeriod(
		com.mypage.user.model.MypageUserGracePeriod mypageUserGracePeriod) {

		return _mypageUserGracePeriodLocalService.addMypageUserGracePeriod(
			mypageUserGracePeriod);
	}

	/**
	 * Creates a new mypage user grace period with the primary key. Does not add the mypage user grace period to the database.
	 *
	 * @param mypageUserGracePeriodId the primary key for the new mypage user grace period
	 * @return the new mypage user grace period
	 */
	@Override
	public com.mypage.user.model.MypageUserGracePeriod
		createMypageUserGracePeriod(long mypageUserGracePeriodId) {

		return _mypageUserGracePeriodLocalService.createMypageUserGracePeriod(
			mypageUserGracePeriodId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserGracePeriodLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.mypage.user.model.MypageUserGracePeriod
			deleteMypageUserGracePeriod(long mypageUserGracePeriodId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserGracePeriodLocalService.deleteMypageUserGracePeriod(
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
	@Override
	public com.mypage.user.model.MypageUserGracePeriod
		deleteMypageUserGracePeriod(
			com.mypage.user.model.MypageUserGracePeriod mypageUserGracePeriod) {

		return _mypageUserGracePeriodLocalService.deleteMypageUserGracePeriod(
			mypageUserGracePeriod);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserGracePeriodLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mypageUserGracePeriodLocalService.dynamicQuery();
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

		return _mypageUserGracePeriodLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _mypageUserGracePeriodLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _mypageUserGracePeriodLocalService.dynamicQuery(
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

		return _mypageUserGracePeriodLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _mypageUserGracePeriodLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.user.model.MypageUserGracePeriod
		fetchMypageUserGracePeriod(long mypageUserGracePeriodId) {

		return _mypageUserGracePeriodLocalService.fetchMypageUserGracePeriod(
			mypageUserGracePeriodId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _mypageUserGracePeriodLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.user.model.MypageUserGracePeriod>
		getByMypageUserId(long mypageUserId) {

		return _mypageUserGracePeriodLocalService.getByMypageUserId(
			mypageUserId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _mypageUserGracePeriodLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the mypage user grace period with the primary key.
	 *
	 * @param mypageUserGracePeriodId the primary key of the mypage user grace period
	 * @return the mypage user grace period
	 * @throws PortalException if a mypage user grace period with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.MypageUserGracePeriod getMypageUserGracePeriod(
			long mypageUserGracePeriodId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserGracePeriodLocalService.getMypageUserGracePeriod(
			mypageUserGracePeriodId);
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
	@Override
	public java.util.List<com.mypage.user.model.MypageUserGracePeriod>
		getMypageUserGracePeriods(int start, int end) {

		return _mypageUserGracePeriodLocalService.getMypageUserGracePeriods(
			start, end);
	}

	/**
	 * Returns the number of mypage user grace periods.
	 *
	 * @return the number of mypage user grace periods
	 */
	@Override
	public int getMypageUserGracePeriodsCount() {
		return _mypageUserGracePeriodLocalService.
			getMypageUserGracePeriodsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mypageUserGracePeriodLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserGracePeriodLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public void removeByMypageUserId(long mypageUserId) {
		_mypageUserGracePeriodLocalService.removeByMypageUserId(mypageUserId);
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
	@Override
	public com.mypage.user.model.MypageUserGracePeriod
		updateMypageUserGracePeriod(
			com.mypage.user.model.MypageUserGracePeriod mypageUserGracePeriod) {

		return _mypageUserGracePeriodLocalService.updateMypageUserGracePeriod(
			mypageUserGracePeriod);
	}

	@Override
	public MypageUserGracePeriodLocalService getWrappedService() {
		return _mypageUserGracePeriodLocalService;
	}

	@Override
	public void setWrappedService(
		MypageUserGracePeriodLocalService mypageUserGracePeriodLocalService) {

		_mypageUserGracePeriodLocalService = mypageUserGracePeriodLocalService;
	}

	private MypageUserGracePeriodLocalService
		_mypageUserGracePeriodLocalService;

}