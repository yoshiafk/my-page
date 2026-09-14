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
 * Provides a wrapper for {@link TravelDomesticBenefitLocalService}.
 *
 * @author Gositus Team
 * @see TravelDomesticBenefitLocalService
 * @generated
 */
public class TravelDomesticBenefitLocalServiceWrapper
	implements ServiceWrapper<TravelDomesticBenefitLocalService>,
			   TravelDomesticBenefitLocalService {

	public TravelDomesticBenefitLocalServiceWrapper(
		TravelDomesticBenefitLocalService travelDomesticBenefitLocalService) {

		_travelDomesticBenefitLocalService = travelDomesticBenefitLocalService;
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticBenefit
		addTravelDomesticBenefit(
			String plan, String amount, String benefit, long benefitValue,
			String group, int sort, int active) {

		return _travelDomesticBenefitLocalService.addTravelDomesticBenefit(
			plan, amount, benefit, benefitValue, group, sort, active);
	}

	/**
	 * Adds the travel domestic benefit to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticBenefit the travel domestic benefit
	 * @return the travel domestic benefit that was added
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticBenefit
		addTravelDomesticBenefit(
			com.mypage.admin.product.model.TravelDomesticBenefit
				travelDomesticBenefit) {

		return _travelDomesticBenefitLocalService.addTravelDomesticBenefit(
			travelDomesticBenefit);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticBenefitLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new travel domestic benefit with the primary key. Does not add the travel domestic benefit to the database.
	 *
	 * @param travelDomesticBenefitId the primary key for the new travel domestic benefit
	 * @return the new travel domestic benefit
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticBenefit
		createTravelDomesticBenefit(long travelDomesticBenefitId) {

		return _travelDomesticBenefitLocalService.createTravelDomesticBenefit(
			travelDomesticBenefitId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticBenefitLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the travel domestic benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticBenefitId the primary key of the travel domestic benefit
	 * @return the travel domestic benefit that was removed
	 * @throws PortalException if a travel domestic benefit with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticBenefit
			deleteTravelDomesticBenefit(long travelDomesticBenefitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticBenefitLocalService.deleteTravelDomesticBenefit(
			travelDomesticBenefitId);
	}

	/**
	 * Deletes the travel domestic benefit from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticBenefit the travel domestic benefit
	 * @return the travel domestic benefit that was removed
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticBenefit
		deleteTravelDomesticBenefit(
			com.mypage.admin.product.model.TravelDomesticBenefit
				travelDomesticBenefit) {

		return _travelDomesticBenefitLocalService.deleteTravelDomesticBenefit(
			travelDomesticBenefit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _travelDomesticBenefitLocalService.dynamicQuery();
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

		return _travelDomesticBenefitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticBenefitModelImpl</code>.
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

		return _travelDomesticBenefitLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticBenefitModelImpl</code>.
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

		return _travelDomesticBenefitLocalService.dynamicQuery(
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

		return _travelDomesticBenefitLocalService.dynamicQueryCount(
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

		return _travelDomesticBenefitLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticBenefit
		fetchTravelDomesticBenefit(long travelDomesticBenefitId) {

		return _travelDomesticBenefitLocalService.fetchTravelDomesticBenefit(
			travelDomesticBenefitId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _travelDomesticBenefitLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _travelDomesticBenefitLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _travelDomesticBenefitLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticBenefitLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the travel domestic benefit with the primary key.
	 *
	 * @param travelDomesticBenefitId the primary key of the travel domestic benefit
	 * @return the travel domestic benefit
	 * @throws PortalException if a travel domestic benefit with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticBenefit
			getTravelDomesticBenefit(long travelDomesticBenefitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticBenefitLocalService.getTravelDomesticBenefit(
			travelDomesticBenefitId);
	}

	/**
	 * Returns a range of all the travel domestic benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @return the range of travel domestic benefits
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.TravelDomesticBenefit>
		getTravelDomesticBenefits(int start, int end) {

		return _travelDomesticBenefitLocalService.getTravelDomesticBenefits(
			start, end);
	}

	/**
	 * Returns the number of travel domestic benefits.
	 *
	 * @return the number of travel domestic benefits
	 */
	@Override
	public int getTravelDomesticBenefitsCount() {
		return _travelDomesticBenefitLocalService.
			getTravelDomesticBenefitsCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.TravelDomesticBenefit>
		searchByPlan(String plan) {

		return _travelDomesticBenefitLocalService.searchByPlan(plan);
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticBenefit setActive(
		long travelDomesticBenefitId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _travelDomesticBenefitLocalService.setActive(
			travelDomesticBenefitId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticBenefit
		updateTravelDomesticBenefit(
			long travelDomesticBenefitId, String plan, String amount,
			String benefit, long benefitValue, String group, int sort,
			int active) {

		return _travelDomesticBenefitLocalService.updateTravelDomesticBenefit(
			travelDomesticBenefitId, plan, amount, benefit, benefitValue, group,
			sort, active);
	}

	/**
	 * Updates the travel domestic benefit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticBenefit the travel domestic benefit
	 * @return the travel domestic benefit that was updated
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticBenefit
		updateTravelDomesticBenefit(
			com.mypage.admin.product.model.TravelDomesticBenefit
				travelDomesticBenefit) {

		return _travelDomesticBenefitLocalService.updateTravelDomesticBenefit(
			travelDomesticBenefit);
	}

	@Override
	public TravelDomesticBenefitLocalService getWrappedService() {
		return _travelDomesticBenefitLocalService;
	}

	@Override
	public void setWrappedService(
		TravelDomesticBenefitLocalService travelDomesticBenefitLocalService) {

		_travelDomesticBenefitLocalService = travelDomesticBenefitLocalService;
	}

	private TravelDomesticBenefitLocalService
		_travelDomesticBenefitLocalService;

}