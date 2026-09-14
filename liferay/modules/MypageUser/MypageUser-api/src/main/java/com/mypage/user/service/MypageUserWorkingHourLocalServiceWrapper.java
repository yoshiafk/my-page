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
 * Provides a wrapper for {@link MypageUserWorkingHourLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserWorkingHourLocalService
 * @generated
 */
public class MypageUserWorkingHourLocalServiceWrapper
	implements MypageUserWorkingHourLocalService,
			   ServiceWrapper<MypageUserWorkingHourLocalService> {

	public MypageUserWorkingHourLocalServiceWrapper(
		MypageUserWorkingHourLocalService mypageUserWorkingHourLocalService) {

		_mypageUserWorkingHourLocalService = mypageUserWorkingHourLocalService;
	}

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
	@Override
	public com.mypage.user.model.MypageUserWorkingHour addMypageUserWorkingHour(
		com.mypage.user.model.MypageUserWorkingHour mypageUserWorkingHour) {

		return _mypageUserWorkingHourLocalService.addMypageUserWorkingHour(
			mypageUserWorkingHour);
	}

	@Override
	public com.mypage.user.model.MypageUserWorkingHour addWorkingHour(
		long mypageUserId, String day, String startTime, String endTime,
		int status) {

		return _mypageUserWorkingHourLocalService.addWorkingHour(
			mypageUserId, day, startTime, endTime, status);
	}

	/**
	 * Creates a new mypage user working hour with the primary key. Does not add the mypage user working hour to the database.
	 *
	 * @param mypageUserWorkingHourId the primary key for the new mypage user working hour
	 * @return the new mypage user working hour
	 */
	@Override
	public com.mypage.user.model.MypageUserWorkingHour
		createMypageUserWorkingHour(long mypageUserWorkingHourId) {

		return _mypageUserWorkingHourLocalService.createMypageUserWorkingHour(
			mypageUserWorkingHourId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserWorkingHourLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.mypage.user.model.MypageUserWorkingHour
			deleteMypageUserWorkingHour(long mypageUserWorkingHourId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserWorkingHourLocalService.deleteMypageUserWorkingHour(
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
	@Override
	public com.mypage.user.model.MypageUserWorkingHour
		deleteMypageUserWorkingHour(
			com.mypage.user.model.MypageUserWorkingHour mypageUserWorkingHour) {

		return _mypageUserWorkingHourLocalService.deleteMypageUserWorkingHour(
			mypageUserWorkingHour);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserWorkingHourLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mypageUserWorkingHourLocalService.dynamicQuery();
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

		return _mypageUserWorkingHourLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _mypageUserWorkingHourLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _mypageUserWorkingHourLocalService.dynamicQuery(
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

		return _mypageUserWorkingHourLocalService.dynamicQueryCount(
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

		return _mypageUserWorkingHourLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.user.model.MypageUserWorkingHour
		fetchMypageUserWorkingHour(long mypageUserWorkingHourId) {

		return _mypageUserWorkingHourLocalService.fetchMypageUserWorkingHour(
			mypageUserWorkingHourId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _mypageUserWorkingHourLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.user.model.MypageUserWorkingHour>
		getByMypageUserId(long mypageUserId) {

		return _mypageUserWorkingHourLocalService.getByMypageUserId(
			mypageUserId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _mypageUserWorkingHourLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the mypage user working hour with the primary key.
	 *
	 * @param mypageUserWorkingHourId the primary key of the mypage user working hour
	 * @return the mypage user working hour
	 * @throws PortalException if a mypage user working hour with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.MypageUserWorkingHour getMypageUserWorkingHour(
			long mypageUserWorkingHourId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserWorkingHourLocalService.getMypageUserWorkingHour(
			mypageUserWorkingHourId);
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
	@Override
	public java.util.List<com.mypage.user.model.MypageUserWorkingHour>
		getMypageUserWorkingHours(int start, int end) {

		return _mypageUserWorkingHourLocalService.getMypageUserWorkingHours(
			start, end);
	}

	/**
	 * Returns the number of mypage user working hours.
	 *
	 * @return the number of mypage user working hours
	 */
	@Override
	public int getMypageUserWorkingHoursCount() {
		return _mypageUserWorkingHourLocalService.
			getMypageUserWorkingHoursCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mypageUserWorkingHourLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserWorkingHourLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public void removeByMypageUserId(long mypageUserId) {
		_mypageUserWorkingHourLocalService.removeByMypageUserId(mypageUserId);
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
	@Override
	public com.mypage.user.model.MypageUserWorkingHour
		updateMypageUserWorkingHour(
			com.mypage.user.model.MypageUserWorkingHour mypageUserWorkingHour) {

		return _mypageUserWorkingHourLocalService.updateMypageUserWorkingHour(
			mypageUserWorkingHour);
	}

	@Override
	public MypageUserWorkingHourLocalService getWrappedService() {
		return _mypageUserWorkingHourLocalService;
	}

	@Override
	public void setWrappedService(
		MypageUserWorkingHourLocalService mypageUserWorkingHourLocalService) {

		_mypageUserWorkingHourLocalService = mypageUserWorkingHourLocalService;
	}

	private MypageUserWorkingHourLocalService
		_mypageUserWorkingHourLocalService;

}