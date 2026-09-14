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
 * Provides a wrapper for {@link SmartHealthPlanLocalService}.
 *
 * @author Gositus Team
 * @see SmartHealthPlanLocalService
 * @generated
 */
public class SmartHealthPlanLocalServiceWrapper
	implements ServiceWrapper<SmartHealthPlanLocalService>,
			   SmartHealthPlanLocalService {

	public SmartHealthPlanLocalServiceWrapper(
		SmartHealthPlanLocalService smartHealthPlanLocalService) {

		_smartHealthPlanLocalService = smartHealthPlanLocalService;
	}

	/**
	 * Adds the smart health plan to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthPlan the smart health plan
	 * @return the smart health plan that was added
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthPlan addSmartHealthPlan(
		com.mypage.admin.product.model.SmartHealthPlan smartHealthPlan) {

		return _smartHealthPlanLocalService.addSmartHealthPlan(smartHealthPlan);
	}

	/**
	 * Add Plan
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthPlan addSmartHealthPlan(
			String planName, String planGroup, int isRecommended, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthPlanLocalService.addSmartHealthPlan(
			planName, planGroup, isRecommended, active);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthPlanLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new smart health plan with the primary key. Does not add the smart health plan to the database.
	 *
	 * @param smartHealthPlanId the primary key for the new smart health plan
	 * @return the new smart health plan
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthPlan createSmartHealthPlan(
		long smartHealthPlanId) {

		return _smartHealthPlanLocalService.createSmartHealthPlan(
			smartHealthPlanId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthPlanLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the smart health plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthPlanId the primary key of the smart health plan
	 * @return the smart health plan that was removed
	 * @throws PortalException if a smart health plan with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthPlan deleteSmartHealthPlan(
			long smartHealthPlanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthPlanLocalService.deleteSmartHealthPlan(
			smartHealthPlanId);
	}

	/**
	 * Deletes the smart health plan from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthPlan the smart health plan
	 * @return the smart health plan that was removed
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthPlan deleteSmartHealthPlan(
		com.mypage.admin.product.model.SmartHealthPlan smartHealthPlan) {

		return _smartHealthPlanLocalService.deleteSmartHealthPlan(
			smartHealthPlan);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smartHealthPlanLocalService.dynamicQuery();
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

		return _smartHealthPlanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthPlanModelImpl</code>.
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

		return _smartHealthPlanLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthPlanModelImpl</code>.
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

		return _smartHealthPlanLocalService.dynamicQuery(
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

		return _smartHealthPlanLocalService.dynamicQueryCount(dynamicQuery);
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

		return _smartHealthPlanLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.SmartHealthPlan fetchSmartHealthPlan(
		long smartHealthPlanId) {

		return _smartHealthPlanLocalService.fetchSmartHealthPlan(
			smartHealthPlanId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smartHealthPlanLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smartHealthPlanLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartHealthPlanLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthPlanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the smart health plan with the primary key.
	 *
	 * @param smartHealthPlanId the primary key of the smart health plan
	 * @return the smart health plan
	 * @throws PortalException if a smart health plan with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthPlan getSmartHealthPlan(
			long smartHealthPlanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthPlanLocalService.getSmartHealthPlan(
			smartHealthPlanId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartHealthPlan>
		getSmartHealthPlans() {

		return _smartHealthPlanLocalService.getSmartHealthPlans();
	}

	/**
	 * Returns a range of all the smart health plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @return the range of smart health plans
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.SmartHealthPlan>
		getSmartHealthPlans(int start, int end) {

		return _smartHealthPlanLocalService.getSmartHealthPlans(start, end);
	}

	/**
	 * Returns the number of smart health plans.
	 *
	 * @return the number of smart health plans
	 */
	@Override
	public int getSmartHealthPlansCount() {
		return _smartHealthPlanLocalService.getSmartHealthPlansCount();
	}

	@Override
	public void resetAllRecommendedStatus()
		throws com.liferay.portal.kernel.exception.PortalException {

		_smartHealthPlanLocalService.resetAllRecommendedStatus();
	}

	@Override
	public com.mypage.admin.product.model.SmartHealthPlan setActive(
			long smartHealthPlanId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthPlanLocalService.setActive(
			smartHealthPlanId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.SmartHealthPlan updateSmartHealthPlan(
			long smartHealthPlanId, int isRecommended)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthPlanLocalService.updateSmartHealthPlan(
			smartHealthPlanId, isRecommended);
	}

	/**
	 * Update Plan
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthPlan updateSmartHealthPlan(
			long smartHealthPlanId, String planName, String planGroup,
			int isRecommended, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthPlanLocalService.updateSmartHealthPlan(
			smartHealthPlanId, planName, planGroup, isRecommended, active);
	}

	/**
	 * Updates the smart health plan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthPlan the smart health plan
	 * @return the smart health plan that was updated
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthPlan updateSmartHealthPlan(
		com.mypage.admin.product.model.SmartHealthPlan smartHealthPlan) {

		return _smartHealthPlanLocalService.updateSmartHealthPlan(
			smartHealthPlan);
	}

	@Override
	public SmartHealthPlanLocalService getWrappedService() {
		return _smartHealthPlanLocalService;
	}

	@Override
	public void setWrappedService(
		SmartHealthPlanLocalService smartHealthPlanLocalService) {

		_smartHealthPlanLocalService = smartHealthPlanLocalService;
	}

	private SmartHealthPlanLocalService _smartHealthPlanLocalService;

}