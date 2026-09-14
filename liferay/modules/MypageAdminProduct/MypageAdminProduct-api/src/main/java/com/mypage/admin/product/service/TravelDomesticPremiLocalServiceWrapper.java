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
 * Provides a wrapper for {@link TravelDomesticPremiLocalService}.
 *
 * @author Gositus Team
 * @see TravelDomesticPremiLocalService
 * @generated
 */
public class TravelDomesticPremiLocalServiceWrapper
	implements ServiceWrapper<TravelDomesticPremiLocalService>,
			   TravelDomesticPremiLocalService {

	public TravelDomesticPremiLocalServiceWrapper(
		TravelDomesticPremiLocalService travelDomesticPremiLocalService) {

		_travelDomesticPremiLocalService = travelDomesticPremiLocalService;
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticPremi
		addTravelDomesticPremi(
			String plan, String insuredType, String currency, Long amount,
			int duration, int active) {

		return _travelDomesticPremiLocalService.addTravelDomesticPremi(
			plan, insuredType, currency, amount, duration, active);
	}

	/**
	 * Adds the travel domestic premi to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticPremi the travel domestic premi
	 * @return the travel domestic premi that was added
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticPremi
		addTravelDomesticPremi(
			com.mypage.admin.product.model.TravelDomesticPremi
				travelDomesticPremi) {

		return _travelDomesticPremiLocalService.addTravelDomesticPremi(
			travelDomesticPremi);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticPremiLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new travel domestic premi with the primary key. Does not add the travel domestic premi to the database.
	 *
	 * @param travelDomesticPremiId the primary key for the new travel domestic premi
	 * @return the new travel domestic premi
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticPremi
		createTravelDomesticPremi(long travelDomesticPremiId) {

		return _travelDomesticPremiLocalService.createTravelDomesticPremi(
			travelDomesticPremiId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticPremiLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the travel domestic premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticPremiId the primary key of the travel domestic premi
	 * @return the travel domestic premi that was removed
	 * @throws PortalException if a travel domestic premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticPremi
			deleteTravelDomesticPremi(long travelDomesticPremiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticPremiLocalService.deleteTravelDomesticPremi(
			travelDomesticPremiId);
	}

	/**
	 * Deletes the travel domestic premi from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticPremi the travel domestic premi
	 * @return the travel domestic premi that was removed
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticPremi
		deleteTravelDomesticPremi(
			com.mypage.admin.product.model.TravelDomesticPremi
				travelDomesticPremi) {

		return _travelDomesticPremiLocalService.deleteTravelDomesticPremi(
			travelDomesticPremi);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _travelDomesticPremiLocalService.dynamicQuery();
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

		return _travelDomesticPremiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticPremiModelImpl</code>.
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

		return _travelDomesticPremiLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticPremiModelImpl</code>.
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

		return _travelDomesticPremiLocalService.dynamicQuery(
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

		return _travelDomesticPremiLocalService.dynamicQueryCount(dynamicQuery);
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

		return _travelDomesticPremiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticPremi
		fetchTravelDomesticPremi(long travelDomesticPremiId) {

		return _travelDomesticPremiLocalService.fetchTravelDomesticPremi(
			travelDomesticPremiId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _travelDomesticPremiLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _travelDomesticPremiLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _travelDomesticPremiLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticPremiLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public java.util.List getPremis(int start, int end) {
		return _travelDomesticPremiLocalService.getPremis(start, end);
	}

	/**
	 * Returns the travel domestic premi with the primary key.
	 *
	 * @param travelDomesticPremiId the primary key of the travel domestic premi
	 * @return the travel domestic premi
	 * @throws PortalException if a travel domestic premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticPremi
			getTravelDomesticPremi(long travelDomesticPremiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelDomesticPremiLocalService.getTravelDomesticPremi(
			travelDomesticPremiId);
	}

	/**
	 * Returns a range of all the travel domestic premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @return the range of travel domestic premis
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.TravelDomesticPremi>
		getTravelDomesticPremis(int start, int end) {

		return _travelDomesticPremiLocalService.getTravelDomesticPremis(
			start, end);
	}

	/**
	 * Returns the number of travel domestic premis.
	 *
	 * @return the number of travel domestic premis
	 */
	@Override
	public int getTravelDomesticPremisCount() {
		return _travelDomesticPremiLocalService.getTravelDomesticPremisCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.TravelDomesticPremi>
		searchPremi(int duration, String plan, String insuredType) {

		return _travelDomesticPremiLocalService.searchPremi(
			duration, plan, insuredType);
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticPremi setActive(
		long travelDomesticPremiId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _travelDomesticPremiLocalService.setActive(
			travelDomesticPremiId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.TravelDomesticPremi
		updateTravelDomesticPremi(
			long travelDomesticPremiId, String plan, String insuredType,
			String currency, Long amount, int duration, int active) {

		return _travelDomesticPremiLocalService.updateTravelDomesticPremi(
			travelDomesticPremiId, plan, insuredType, currency, amount,
			duration, active);
	}

	/**
	 * Updates the travel domestic premi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticPremi the travel domestic premi
	 * @return the travel domestic premi that was updated
	 */
	@Override
	public com.mypage.admin.product.model.TravelDomesticPremi
		updateTravelDomesticPremi(
			com.mypage.admin.product.model.TravelDomesticPremi
				travelDomesticPremi) {

		return _travelDomesticPremiLocalService.updateTravelDomesticPremi(
			travelDomesticPremi);
	}

	@Override
	public TravelDomesticPremiLocalService getWrappedService() {
		return _travelDomesticPremiLocalService;
	}

	@Override
	public void setWrappedService(
		TravelDomesticPremiLocalService travelDomesticPremiLocalService) {

		_travelDomesticPremiLocalService = travelDomesticPremiLocalService;
	}

	private TravelDomesticPremiLocalService _travelDomesticPremiLocalService;

}