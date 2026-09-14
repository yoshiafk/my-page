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
 * Provides a wrapper for {@link MypageUserTimelineLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MypageUserTimelineLocalService
 * @generated
 */
public class MypageUserTimelineLocalServiceWrapper
	implements MypageUserTimelineLocalService,
			   ServiceWrapper<MypageUserTimelineLocalService> {

	public MypageUserTimelineLocalServiceWrapper(
		MypageUserTimelineLocalService mypageUserTimelineLocalService) {

		_mypageUserTimelineLocalService = mypageUserTimelineLocalService;
	}

	/**
	 * Adds the mypage user timeline to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserTimelineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserTimeline the mypage user timeline
	 * @return the mypage user timeline that was added
	 */
	@Override
	public com.mypage.user.model.MypageUserTimeline addMypageUserTimeline(
		com.mypage.user.model.MypageUserTimeline mypageUserTimeline) {

		return _mypageUserTimelineLocalService.addMypageUserTimeline(
			mypageUserTimeline);
	}

	@Override
	public com.mypage.user.model.MypageUserTimeline addTimeline(
		long mypageUserId, String text, long fileEntryId, String filePathUrl,
		String linkVideo) {

		return _mypageUserTimelineLocalService.addTimeline(
			mypageUserId, text, fileEntryId, filePathUrl, linkVideo);
	}

	/**
	 * Creates a new mypage user timeline with the primary key. Does not add the mypage user timeline to the database.
	 *
	 * @param mypageUserTimelineId the primary key for the new mypage user timeline
	 * @return the new mypage user timeline
	 */
	@Override
	public com.mypage.user.model.MypageUserTimeline createMypageUserTimeline(
		long mypageUserTimelineId) {

		return _mypageUserTimelineLocalService.createMypageUserTimeline(
			mypageUserTimelineId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserTimelineLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the mypage user timeline with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserTimelineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserTimelineId the primary key of the mypage user timeline
	 * @return the mypage user timeline that was removed
	 * @throws PortalException if a mypage user timeline with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.MypageUserTimeline deleteMypageUserTimeline(
			long mypageUserTimelineId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserTimelineLocalService.deleteMypageUserTimeline(
			mypageUserTimelineId);
	}

	/**
	 * Deletes the mypage user timeline from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserTimelineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserTimeline the mypage user timeline
	 * @return the mypage user timeline that was removed
	 */
	@Override
	public com.mypage.user.model.MypageUserTimeline deleteMypageUserTimeline(
		com.mypage.user.model.MypageUserTimeline mypageUserTimeline) {

		return _mypageUserTimelineLocalService.deleteMypageUserTimeline(
			mypageUserTimeline);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserTimelineLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mypageUserTimelineLocalService.dynamicQuery();
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

		return _mypageUserTimelineLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserTimelineModelImpl</code>.
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

		return _mypageUserTimelineLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserTimelineModelImpl</code>.
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

		return _mypageUserTimelineLocalService.dynamicQuery(
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

		return _mypageUserTimelineLocalService.dynamicQueryCount(dynamicQuery);
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

		return _mypageUserTimelineLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.user.model.MypageUserTimeline fetchMypageUserTimeline(
		long mypageUserTimelineId) {

		return _mypageUserTimelineLocalService.fetchMypageUserTimeline(
			mypageUserTimelineId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _mypageUserTimelineLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.user.model.MypageUserTimeline>
		getByMypageUserId(long mypageUserId) {

		return _mypageUserTimelineLocalService.getByMypageUserId(mypageUserId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _mypageUserTimelineLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the mypage user timeline with the primary key.
	 *
	 * @param mypageUserTimelineId the primary key of the mypage user timeline
	 * @return the mypage user timeline
	 * @throws PortalException if a mypage user timeline with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.MypageUserTimeline getMypageUserTimeline(
			long mypageUserTimelineId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserTimelineLocalService.getMypageUserTimeline(
			mypageUserTimelineId);
	}

	/**
	 * Returns a range of all the mypage user timelines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.MypageUserTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user timelines
	 * @param end the upper bound of the range of mypage user timelines (not inclusive)
	 * @return the range of mypage user timelines
	 */
	@Override
	public java.util.List<com.mypage.user.model.MypageUserTimeline>
		getMypageUserTimelines(int start, int end) {

		return _mypageUserTimelineLocalService.getMypageUserTimelines(
			start, end);
	}

	/**
	 * Returns the number of mypage user timelines.
	 *
	 * @return the number of mypage user timelines
	 */
	@Override
	public int getMypageUserTimelinesCount() {
		return _mypageUserTimelineLocalService.getMypageUserTimelinesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mypageUserTimelineLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mypageUserTimelineLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void removeByMypageUserId(long mypageUserId) {
		_mypageUserTimelineLocalService.removeByMypageUserId(mypageUserId);
	}

	/**
	 * Updates the mypage user timeline in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MypageUserTimelineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mypageUserTimeline the mypage user timeline
	 * @return the mypage user timeline that was updated
	 */
	@Override
	public com.mypage.user.model.MypageUserTimeline updateMypageUserTimeline(
		com.mypage.user.model.MypageUserTimeline mypageUserTimeline) {

		return _mypageUserTimelineLocalService.updateMypageUserTimeline(
			mypageUserTimeline);
	}

	@Override
	public MypageUserTimelineLocalService getWrappedService() {
		return _mypageUserTimelineLocalService;
	}

	@Override
	public void setWrappedService(
		MypageUserTimelineLocalService mypageUserTimelineLocalService) {

		_mypageUserTimelineLocalService = mypageUserTimelineLocalService;
	}

	private MypageUserTimelineLocalService _mypageUserTimelineLocalService;

}