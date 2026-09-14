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
 * Provides a wrapper for {@link HealthIndividuPlanLocalService}.
 *
 * @author Gositus Team
 * @see HealthIndividuPlanLocalService
 * @generated
 */
public class HealthIndividuPlanLocalServiceWrapper
	implements HealthIndividuPlanLocalService,
			   ServiceWrapper<HealthIndividuPlanLocalService> {

	public HealthIndividuPlanLocalServiceWrapper(
		HealthIndividuPlanLocalService healthIndividuPlanLocalService) {

		_healthIndividuPlanLocalService = healthIndividuPlanLocalService;
	}

	/**
	 * Adds the health individu plan to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HealthIndividuPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param healthIndividuPlan the health individu plan
	 * @return the health individu plan that was added
	 */
	@Override
	public com.mypage.admin.product.model.HealthIndividuPlan
		addHealthIndividuPlan(
			com.mypage.admin.product.model.HealthIndividuPlan
				healthIndividuPlan) {

		return _healthIndividuPlanLocalService.addHealthIndividuPlan(
			healthIndividuPlan);
	}

	/**
	 * Creates a new health individu plan with the primary key. Does not add the health individu plan to the database.
	 *
	 * @param healthIndividuPlanId the primary key for the new health individu plan
	 * @return the new health individu plan
	 */
	@Override
	public com.mypage.admin.product.model.HealthIndividuPlan
		createHealthIndividuPlan(long healthIndividuPlanId) {

		return _healthIndividuPlanLocalService.createHealthIndividuPlan(
			healthIndividuPlanId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthIndividuPlanLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the health individu plan from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HealthIndividuPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param healthIndividuPlan the health individu plan
	 * @return the health individu plan that was removed
	 */
	@Override
	public com.mypage.admin.product.model.HealthIndividuPlan
		deleteHealthIndividuPlan(
			com.mypage.admin.product.model.HealthIndividuPlan
				healthIndividuPlan) {

		return _healthIndividuPlanLocalService.deleteHealthIndividuPlan(
			healthIndividuPlan);
	}

	/**
	 * Deletes the health individu plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HealthIndividuPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param healthIndividuPlanId the primary key of the health individu plan
	 * @return the health individu plan that was removed
	 * @throws PortalException if a health individu plan with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.HealthIndividuPlan
			deleteHealthIndividuPlan(long healthIndividuPlanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthIndividuPlanLocalService.deleteHealthIndividuPlan(
			healthIndividuPlanId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthIndividuPlanLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _healthIndividuPlanLocalService.dynamicQuery();
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

		return _healthIndividuPlanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.HealthIndividuPlanModelImpl</code>.
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

		return _healthIndividuPlanLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.HealthIndividuPlanModelImpl</code>.
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

		return _healthIndividuPlanLocalService.dynamicQuery(
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

		return _healthIndividuPlanLocalService.dynamicQueryCount(dynamicQuery);
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

		return _healthIndividuPlanLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.HealthIndividuPlan
		fetchHealthIndividuPlan(long healthIndividuPlanId) {

		return _healthIndividuPlanLocalService.fetchHealthIndividuPlan(
			healthIndividuPlanId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _healthIndividuPlanLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the health individu plan with the primary key.
	 *
	 * @param healthIndividuPlanId the primary key of the health individu plan
	 * @return the health individu plan
	 * @throws PortalException if a health individu plan with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.HealthIndividuPlan
			getHealthIndividuPlan(long healthIndividuPlanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthIndividuPlanLocalService.getHealthIndividuPlan(
			healthIndividuPlanId);
	}

	/**
	 * Returns a range of all the health individu plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.HealthIndividuPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health individu plans
	 * @param end the upper bound of the range of health individu plans (not inclusive)
	 * @return the range of health individu plans
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.HealthIndividuPlan>
		getHealthIndividuPlans(int start, int end) {

		return _healthIndividuPlanLocalService.getHealthIndividuPlans(
			start, end);
	}

	/**
	 * Returns the number of health individu plans.
	 *
	 * @return the number of health individu plans
	 */
	@Override
	public int getHealthIndividuPlansCount() {
		return _healthIndividuPlanLocalService.getHealthIndividuPlansCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _healthIndividuPlanLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _healthIndividuPlanLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _healthIndividuPlanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the health individu plan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HealthIndividuPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param healthIndividuPlan the health individu plan
	 * @return the health individu plan that was updated
	 */
	@Override
	public com.mypage.admin.product.model.HealthIndividuPlan
		updateHealthIndividuPlan(
			com.mypage.admin.product.model.HealthIndividuPlan
				healthIndividuPlan) {

		return _healthIndividuPlanLocalService.updateHealthIndividuPlan(
			healthIndividuPlan);
	}

	@Override
	public HealthIndividuPlanLocalService getWrappedService() {
		return _healthIndividuPlanLocalService;
	}

	@Override
	public void setWrappedService(
		HealthIndividuPlanLocalService healthIndividuPlanLocalService) {

		_healthIndividuPlanLocalService = healthIndividuPlanLocalService;
	}

	private HealthIndividuPlanLocalService _healthIndividuPlanLocalService;

}