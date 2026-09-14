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
 * Provides a wrapper for {@link TravelDomesticPlanLocalService}.
 *
 * @author Gositus Team
 * @see TravelDomesticPlanLocalService
 * @generated
 */
public class TravelDomesticPlanLocalServiceWrapper
	implements ServiceWrapper<TravelDomesticPlanLocalService>,
			   TravelDomesticPlanLocalService {

	public TravelDomesticPlanLocalServiceWrapper(
		TravelDomesticPlanLocalService travelDomesticPlanLocalService) {

		_travelDomesticPlanLocalService = travelDomesticPlanLocalService;
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticPlan
		addTravelDomesticPlan(
			String name, String code, int toproTsi, int toproAtsi, int sort,
			int active) {

		return _travelDomesticPlanLocalService.addTravelDomesticPlan(
			name, code, toproTsi, toproAtsi, sort, active);
	}

	/**
	 * Adds the travel domestic plan to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticPlan the travel domestic plan
	 * @return the travel domestic plan that was added
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticPlan
		addTravelDomesticPlan(
			com.mypage.admin.product.model.TravelDomesticPlan
				travelDomesticPlan) {

		return _travelDomesticPlanLocalService.addTravelDomesticPlan(
			travelDomesticPlan);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticPlanLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new travel domestic plan with the primary key. Does not add the travel domestic plan to the database.
	 *
	 * @param travelDomesticPlanId the primary key for the new travel domestic plan
	 * @return the new travel domestic plan
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticPlan
		createTravelDomesticPlan(long travelDomesticPlanId) {

		return _travelDomesticPlanLocalService.createTravelDomesticPlan(
			travelDomesticPlanId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticPlanLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the travel domestic plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticPlanId the primary key of the travel domestic plan
	 * @return the travel domestic plan that was removed
	 * @throws PortalException if a travel domestic plan with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticPlan
			deleteTravelDomesticPlan(long travelDomesticPlanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticPlanLocalService.deleteTravelDomesticPlan(
			travelDomesticPlanId);
	}

	/**
	 * Deletes the travel domestic plan from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticPlan the travel domestic plan
	 * @return the travel domestic plan that was removed
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticPlan
		deleteTravelDomesticPlan(
			com.mypage.admin.product.model.TravelDomesticPlan
				travelDomesticPlan) {

		return _travelDomesticPlanLocalService.deleteTravelDomesticPlan(
			travelDomesticPlan);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _travelDomesticPlanLocalService.dynamicQuery();
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

		return _travelDomesticPlanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticPlanModelImpl</code>.
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

		return _travelDomesticPlanLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticPlanModelImpl</code>.
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

		return _travelDomesticPlanLocalService.dynamicQuery(
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

		return _travelDomesticPlanLocalService.dynamicQueryCount(dynamicQuery);
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

		return _travelDomesticPlanLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticPlan
		fetchTravelDomesticPlan(long travelDomesticPlanId) {

		return _travelDomesticPlanLocalService.fetchTravelDomesticPlan(
			travelDomesticPlanId);
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticPlan findByCode(
		String code) {

		return _travelDomesticPlanLocalService.findByCode(code);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _travelDomesticPlanLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _travelDomesticPlanLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _travelDomesticPlanLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticPlanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the travel domestic plan with the primary key.
	 *
	 * @param travelDomesticPlanId the primary key of the travel domestic plan
	 * @return the travel domestic plan
	 * @throws PortalException if a travel domestic plan with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticPlan
			getTravelDomesticPlan(long travelDomesticPlanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticPlanLocalService.getTravelDomesticPlan(
			travelDomesticPlanId);
	}

	/**
	 * Returns a range of all the travel domestic plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @return the range of travel domestic plans
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.TravelDomesticPlan>
		getTravelDomesticPlans(int start, int end) {

		return _travelDomesticPlanLocalService.getTravelDomesticPlans(
			start, end);
	}

	/**
	 * Returns the number of travel domestic plans.
	 *
	 * @return the number of travel domestic plans
	 */
	@Override
	public int getTravelDomesticPlansCount() {
		return _travelDomesticPlanLocalService.getTravelDomesticPlansCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.TravelDomesticPlan>
		searchByCode(String code) {

		return _travelDomesticPlanLocalService.searchByCode(code);
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticPlan setActive(
		long travelDomesticPlanId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _travelDomesticPlanLocalService.setActive(
			travelDomesticPlanId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticPlan
		updateTravelDomesticPlan(
			long travelDomesticPlanId, String name, String code, int toproTsi,
			int toproAtsi, int sort, int active) {

		return _travelDomesticPlanLocalService.updateTravelDomesticPlan(
			travelDomesticPlanId, name, code, toproTsi, toproAtsi, sort,
			active);
	}

	/**
	 * Updates the travel domestic plan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticPlan the travel domestic plan
	 * @return the travel domestic plan that was updated
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticPlan
		updateTravelDomesticPlan(
			com.mypage.admin.product.model.TravelDomesticPlan
				travelDomesticPlan) {

		return _travelDomesticPlanLocalService.updateTravelDomesticPlan(
			travelDomesticPlan);
	}

	@Override
	public TravelDomesticPlanLocalService getWrappedService() {
		return _travelDomesticPlanLocalService;
	}

	@Override
	public void setWrappedService(
		TravelDomesticPlanLocalService travelDomesticPlanLocalService) {

		_travelDomesticPlanLocalService = travelDomesticPlanLocalService;
	}

	private TravelDomesticPlanLocalService _travelDomesticPlanLocalService;

}