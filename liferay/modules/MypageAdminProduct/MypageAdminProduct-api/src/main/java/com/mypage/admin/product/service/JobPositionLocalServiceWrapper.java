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

package com.mypage.admin.product.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JobPositionLocalService}.
 *
 * @author Gositus Team
 * @see JobPositionLocalService
 * @generated
 */
public class JobPositionLocalServiceWrapper
	implements JobPositionLocalService,
			   ServiceWrapper<JobPositionLocalService> {

	public JobPositionLocalServiceWrapper(
		JobPositionLocalService jobPositionLocalService) {

		_jobPositionLocalService = jobPositionLocalService;
	}

	/**
	 * Adds the job position to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobPositionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobPosition the job position
	 * @return the job position that was added
	 */
	@Override
	public com.mypage.admin.product.model.JobPosition addJobPosition(
		com.mypage.admin.product.model.JobPosition jobPosition) {

		return _jobPositionLocalService.addJobPosition(jobPosition);
	}

	@Override
	public com.mypage.admin.product.model.JobPosition addJobPosition(
			String name, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobPositionLocalService.addJobPosition(name, active);
	}

	/**
	 * Creates a new job position with the primary key. Does not add the job position to the database.
	 *
	 * @param jobPositionId the primary key for the new job position
	 * @return the new job position
	 */
	@Override
	public com.mypage.admin.product.model.JobPosition createJobPosition(
		long jobPositionId) {

		return _jobPositionLocalService.createJobPosition(jobPositionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobPositionLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the job position from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobPositionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobPosition the job position
	 * @return the job position that was removed
	 */
	@Override
	public com.mypage.admin.product.model.JobPosition deleteJobPosition(
		com.mypage.admin.product.model.JobPosition jobPosition) {

		return _jobPositionLocalService.deleteJobPosition(jobPosition);
	}

	/**
	 * Deletes the job position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobPositionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobPositionId the primary key of the job position
	 * @return the job position that was removed
	 * @throws PortalException if a job position with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.JobPosition deleteJobPosition(
			long jobPositionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobPositionLocalService.deleteJobPosition(jobPositionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobPositionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jobPositionLocalService.dynamicQuery();
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

		return _jobPositionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.JobPositionModelImpl</code>.
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

		return _jobPositionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.JobPositionModelImpl</code>.
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

		return _jobPositionLocalService.dynamicQuery(
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

		return _jobPositionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _jobPositionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.JobPosition fetchJobPosition(
		long jobPositionId) {

		return _jobPositionLocalService.fetchJobPosition(jobPositionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _jobPositionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _jobPositionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the job position with the primary key.
	 *
	 * @param jobPositionId the primary key of the job position
	 * @return the job position
	 * @throws PortalException if a job position with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.JobPosition getJobPosition(
			long jobPositionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobPositionLocalService.getJobPosition(jobPositionId);
	}

	@Override
	public int getJobPositionCount() {
		return _jobPositionLocalService.getJobPositionCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.JobPosition>
		getJobPositions() {

		return _jobPositionLocalService.getJobPositions();
	}

	/**
	 * Returns a range of all the job positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.JobPositionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job positions
	 * @param end the upper bound of the range of job positions (not inclusive)
	 * @return the range of job positions
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.JobPosition>
		getJobPositions(int start, int end) {

		return _jobPositionLocalService.getJobPositions(start, end);
	}

	/**
	 * Returns the number of job positions.
	 *
	 * @return the number of job positions
	 */
	@Override
	public int getJobPositionsCount() {
		return _jobPositionLocalService.getJobPositionsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _jobPositionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobPositionLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.admin.product.model.JobPosition setActive(
			long jobPositionId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobPositionLocalService.setActive(
			jobPositionId, active, serviceContext);
	}

	/**
	 * Updates the job position in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobPositionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobPosition the job position
	 * @return the job position that was updated
	 */
	@Override
	public com.mypage.admin.product.model.JobPosition updateJobPosition(
		com.mypage.admin.product.model.JobPosition jobPosition) {

		return _jobPositionLocalService.updateJobPosition(jobPosition);
	}

	@Override
	public com.mypage.admin.product.model.JobPosition updateJobPosition(
			long jobPositionId, String name, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobPositionLocalService.updateJobPosition(
			jobPositionId, name, active);
	}

	@Override
	public JobPositionLocalService getWrappedService() {
		return _jobPositionLocalService;
	}

	@Override
	public void setWrappedService(
		JobPositionLocalService jobPositionLocalService) {

		_jobPositionLocalService = jobPositionLocalService;
	}

	private JobPositionLocalService _jobPositionLocalService;

}