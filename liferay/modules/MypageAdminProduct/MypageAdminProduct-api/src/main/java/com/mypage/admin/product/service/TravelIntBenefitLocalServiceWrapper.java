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
 * Provides a wrapper for {@link TravelIntBenefitLocalService}.
 *
 * @author Gositus Team
 * @see TravelIntBenefitLocalService
 * @generated
 */
public class TravelIntBenefitLocalServiceWrapper
	implements ServiceWrapper<TravelIntBenefitLocalService>,
			   TravelIntBenefitLocalService {

	public TravelIntBenefitLocalServiceWrapper(
		TravelIntBenefitLocalService travelIntBenefitLocalService) {

		_travelIntBenefitLocalService = travelIntBenefitLocalService;
	}

	/**
	 * Add
	 */
	@Override
	public com.mypage.admin.product.model.TravelIntBenefit addTravelIntBenefit(
			String benefitName, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelIntBenefitLocalService.addTravelIntBenefit(
			benefitName, active);
	}

	/**
	 * Adds the travel int benefit to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelIntBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelIntBenefit the travel int benefit
	 * @return the travel int benefit that was added
	 */
	@Override
	public com.mypage.admin.product.model.TravelIntBenefit addTravelIntBenefit(
		com.mypage.admin.product.model.TravelIntBenefit travelIntBenefit) {

		return _travelIntBenefitLocalService.addTravelIntBenefit(
			travelIntBenefit);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelIntBenefitLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new travel int benefit with the primary key. Does not add the travel int benefit to the database.
	 *
	 * @param travelIntBenefitId the primary key for the new travel int benefit
	 * @return the new travel int benefit
	 */
	@Override
	public com.mypage.admin.product.model.TravelIntBenefit
		createTravelIntBenefit(long travelIntBenefitId) {

		return _travelIntBenefitLocalService.createTravelIntBenefit(
			travelIntBenefitId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelIntBenefitLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the travel int benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelIntBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelIntBenefitId the primary key of the travel int benefit
	 * @return the travel int benefit that was removed
	 * @throws PortalException if a travel int benefit with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelIntBenefit
			deleteTravelIntBenefit(long travelIntBenefitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelIntBenefitLocalService.deleteTravelIntBenefit(
			travelIntBenefitId);
	}

	/**
	 * Deletes the travel int benefit from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelIntBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelIntBenefit the travel int benefit
	 * @return the travel int benefit that was removed
	 */
	@Override
	public com.mypage.admin.product.model.TravelIntBenefit
		deleteTravelIntBenefit(
			com.mypage.admin.product.model.TravelIntBenefit travelIntBenefit) {

		return _travelIntBenefitLocalService.deleteTravelIntBenefit(
			travelIntBenefit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _travelIntBenefitLocalService.dynamicQuery();
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

		return _travelIntBenefitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelIntBenefitModelImpl</code>.
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

		return _travelIntBenefitLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelIntBenefitModelImpl</code>.
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

		return _travelIntBenefitLocalService.dynamicQuery(
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

		return _travelIntBenefitLocalService.dynamicQueryCount(dynamicQuery);
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

		return _travelIntBenefitLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.TravelIntBenefit
		fetchTravelIntBenefit(long travelIntBenefitId) {

		return _travelIntBenefitLocalService.fetchTravelIntBenefit(
			travelIntBenefitId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _travelIntBenefitLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _travelIntBenefitLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _travelIntBenefitLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelIntBenefitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the travel int benefit with the primary key.
	 *
	 * @param travelIntBenefitId the primary key of the travel int benefit
	 * @return the travel int benefit
	 * @throws PortalException if a travel int benefit with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelIntBenefit getTravelIntBenefit(
			long travelIntBenefitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelIntBenefitLocalService.getTravelIntBenefit(
			travelIntBenefitId);
	}

	@Override
	public int getTravelIntBenefitCount() {
		return _travelIntBenefitLocalService.getTravelIntBenefitCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.TravelIntBenefit>
		getTravelIntBenefits() {

		return _travelIntBenefitLocalService.getTravelIntBenefits();
	}

	/**
	 * Returns a range of all the travel int benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelIntBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefits
	 * @param end the upper bound of the range of travel int benefits (not inclusive)
	 * @return the range of travel int benefits
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.TravelIntBenefit>
		getTravelIntBenefits(int start, int end) {

		return _travelIntBenefitLocalService.getTravelIntBenefits(start, end);
	}

	/**
	 * Returns the number of travel int benefits.
	 *
	 * @return the number of travel int benefits
	 */
	@Override
	public int getTravelIntBenefitsCount() {
		return _travelIntBenefitLocalService.getTravelIntBenefitsCount();
	}

	@Override
	public com.mypage.admin.product.model.TravelIntBenefit setActive(
			long userId, long travelIntBenefitId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelIntBenefitLocalService.setActive(
			userId, travelIntBenefitId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.TravelIntBenefit
			updateTravelIntBenefit(
				long travelIntBenefitId, String benefitName, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelIntBenefitLocalService.updateTravelIntBenefit(
			travelIntBenefitId, benefitName, active);
	}

	/**
	 * Updates the travel int benefit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelIntBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelIntBenefit the travel int benefit
	 * @return the travel int benefit that was updated
	 */
	@Override
	public com.mypage.admin.product.model.TravelIntBenefit
		updateTravelIntBenefit(
			com.mypage.admin.product.model.TravelIntBenefit travelIntBenefit) {

		return _travelIntBenefitLocalService.updateTravelIntBenefit(
			travelIntBenefit);
	}

	@Override
	public TravelIntBenefitLocalService getWrappedService() {
		return _travelIntBenefitLocalService;
	}

	@Override
	public void setWrappedService(
		TravelIntBenefitLocalService travelIntBenefitLocalService) {

		_travelIntBenefitLocalService = travelIntBenefitLocalService;
	}

	private TravelIntBenefitLocalService _travelIntBenefitLocalService;

}