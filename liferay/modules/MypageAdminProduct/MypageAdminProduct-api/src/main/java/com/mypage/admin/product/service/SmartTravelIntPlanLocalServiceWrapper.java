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
 * Provides a wrapper for {@link SmartTravelIntPlanLocalService}.
 *
 * @author Gositus Team
 * @see SmartTravelIntPlanLocalService
 * @generated
 */
public class SmartTravelIntPlanLocalServiceWrapper
	implements ServiceWrapper<SmartTravelIntPlanLocalService>,
			   SmartTravelIntPlanLocalService {

	public SmartTravelIntPlanLocalServiceWrapper(
		SmartTravelIntPlanLocalService smartTravelIntPlanLocalService) {

		_smartTravelIntPlanLocalService = smartTravelIntPlanLocalService;
	}

	@Override
	public com.mypage.admin.product.model.SmartTravelIntPlan addPlan(
			String nameId, String nameEn, int sort, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartTravelIntPlanLocalService.addPlan(
			nameId, nameEn, sort, active);
	}

	/**
	 * Adds the smart travel int plan to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartTravelIntPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartTravelIntPlan the smart travel int plan
	 * @return the smart travel int plan that was added
	 */
	@Override
	public com.mypage.admin.product.model.SmartTravelIntPlan
		addSmartTravelIntPlan(
			com.mypage.admin.product.model.SmartTravelIntPlan
				smartTravelIntPlan) {

		return _smartTravelIntPlanLocalService.addSmartTravelIntPlan(
			smartTravelIntPlan);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartTravelIntPlanLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new smart travel int plan with the primary key. Does not add the smart travel int plan to the database.
	 *
	 * @param smartTravelIntPlanId the primary key for the new smart travel int plan
	 * @return the new smart travel int plan
	 */
	@Override
	public com.mypage.admin.product.model.SmartTravelIntPlan
		createSmartTravelIntPlan(long smartTravelIntPlanId) {

		return _smartTravelIntPlanLocalService.createSmartTravelIntPlan(
			smartTravelIntPlanId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartTravelIntPlanLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the smart travel int plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartTravelIntPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartTravelIntPlanId the primary key of the smart travel int plan
	 * @return the smart travel int plan that was removed
	 * @throws PortalException if a smart travel int plan with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartTravelIntPlan
			deleteSmartTravelIntPlan(long smartTravelIntPlanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartTravelIntPlanLocalService.deleteSmartTravelIntPlan(
			smartTravelIntPlanId);
	}

	/**
	 * Deletes the smart travel int plan from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartTravelIntPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartTravelIntPlan the smart travel int plan
	 * @return the smart travel int plan that was removed
	 */
	@Override
	public com.mypage.admin.product.model.SmartTravelIntPlan
		deleteSmartTravelIntPlan(
			com.mypage.admin.product.model.SmartTravelIntPlan
				smartTravelIntPlan) {

		return _smartTravelIntPlanLocalService.deleteSmartTravelIntPlan(
			smartTravelIntPlan);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smartTravelIntPlanLocalService.dynamicQuery();
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

		return _smartTravelIntPlanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartTravelIntPlanModelImpl</code>.
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

		return _smartTravelIntPlanLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartTravelIntPlanModelImpl</code>.
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

		return _smartTravelIntPlanLocalService.dynamicQuery(
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

		return _smartTravelIntPlanLocalService.dynamicQueryCount(dynamicQuery);
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

		return _smartTravelIntPlanLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.SmartTravelIntPlan
		fetchSmartTravelIntPlan(long smartTravelIntPlanId) {

		return _smartTravelIntPlanLocalService.fetchSmartTravelIntPlan(
			smartTravelIntPlanId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smartTravelIntPlanLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartTravelIntPlan>
		getActivePlan() {

		return _smartTravelIntPlanLocalService.getActivePlan();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smartTravelIntPlanLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartTravelIntPlanLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartTravelIntPlanLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int getPlanCount() {
		return _smartTravelIntPlanLocalService.getPlanCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartTravelIntPlan>
		getPlans() {

		return _smartTravelIntPlanLocalService.getPlans();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartTravelIntPlan>
		getPlans(int start, int end) {

		return _smartTravelIntPlanLocalService.getPlans(start, end);
	}

	/**
	 * Returns the smart travel int plan with the primary key.
	 *
	 * @param smartTravelIntPlanId the primary key of the smart travel int plan
	 * @return the smart travel int plan
	 * @throws PortalException if a smart travel int plan with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartTravelIntPlan
			getSmartTravelIntPlan(long smartTravelIntPlanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartTravelIntPlanLocalService.getSmartTravelIntPlan(
			smartTravelIntPlanId);
	}

	/**
	 * Returns a range of all the smart travel int plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartTravelIntPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart travel int plans
	 * @param end the upper bound of the range of smart travel int plans (not inclusive)
	 * @return the range of smart travel int plans
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.SmartTravelIntPlan>
		getSmartTravelIntPlans(int start, int end) {

		return _smartTravelIntPlanLocalService.getSmartTravelIntPlans(
			start, end);
	}

	/**
	 * Returns the number of smart travel int plans.
	 *
	 * @return the number of smart travel int plans
	 */
	@Override
	public int getSmartTravelIntPlansCount() {
		return _smartTravelIntPlanLocalService.getSmartTravelIntPlansCount();
	}

	@Override
	public com.mypage.admin.product.model.SmartTravelIntPlan setActive(
		long planId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _smartTravelIntPlanLocalService.setActive(
			planId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.SmartTravelIntPlan updatePlan(
			long planId, String nameId, String nameEn, int sort, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartTravelIntPlanLocalService.updatePlan(
			planId, nameId, nameEn, sort, active);
	}

	/**
	 * Updates the smart travel int plan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartTravelIntPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartTravelIntPlan the smart travel int plan
	 * @return the smart travel int plan that was updated
	 */
	@Override
	public com.mypage.admin.product.model.SmartTravelIntPlan
		updateSmartTravelIntPlan(
			com.mypage.admin.product.model.SmartTravelIntPlan
				smartTravelIntPlan) {

		return _smartTravelIntPlanLocalService.updateSmartTravelIntPlan(
			smartTravelIntPlan);
	}

	@Override
	public SmartTravelIntPlanLocalService getWrappedService() {
		return _smartTravelIntPlanLocalService;
	}

	@Override
	public void setWrappedService(
		SmartTravelIntPlanLocalService smartTravelIntPlanLocalService) {

		_smartTravelIntPlanLocalService = smartTravelIntPlanLocalService;
	}

	private SmartTravelIntPlanLocalService _smartTravelIntPlanLocalService;

}