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
 * Provides a wrapper for {@link TravelInternationalPremiLocalService}.
 *
 * @author Gositus Team
 * @see TravelInternationalPremiLocalService
 * @generated
 */
public class TravelInternationalPremiLocalServiceWrapper
	implements ServiceWrapper<TravelInternationalPremiLocalService>,
			   TravelInternationalPremiLocalService {

	public TravelInternationalPremiLocalServiceWrapper(
		TravelInternationalPremiLocalService
			travelInternationalPremiLocalService) {

		_travelInternationalPremiLocalService =
			travelInternationalPremiLocalService;
	}

	@Override
	public com.mypage.admin.product.model.TravelInternationalPremi addPremi(
			long userId, long premiId, String packageType, String peopleType,
			int adultCount, int childrenCount, String currency,
			java.math.BigDecimal amount, int minDuration, int maxDuration,
			int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelInternationalPremiLocalService.addPremi(
			userId, premiId, packageType, peopleType, adultCount, childrenCount,
			currency, amount, minDuration, maxDuration, active, serviceContext);
	}

	/**
	 * Adds the travel international premi to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelInternationalPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelInternationalPremi the travel international premi
	 * @return the travel international premi that was added
	 */
	@Override
	public com.mypage.admin.product.model.TravelInternationalPremi
		addTravelInternationalPremi(
			com.mypage.admin.product.model.TravelInternationalPremi
				travelInternationalPremi) {

		return _travelInternationalPremiLocalService.
			addTravelInternationalPremi(travelInternationalPremi);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelInternationalPremiLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new travel international premi with the primary key. Does not add the travel international premi to the database.
	 *
	 * @param premiId the primary key for the new travel international premi
	 * @return the new travel international premi
	 */
	@Override
	public com.mypage.admin.product.model.TravelInternationalPremi
		createTravelInternationalPremi(long premiId) {

		return _travelInternationalPremiLocalService.
			createTravelInternationalPremi(premiId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelInternationalPremiLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the travel international premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelInternationalPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param premiId the primary key of the travel international premi
	 * @return the travel international premi that was removed
	 * @throws PortalException if a travel international premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelInternationalPremi
			deleteTravelInternationalPremi(long premiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelInternationalPremiLocalService.
			deleteTravelInternationalPremi(premiId);
	}

	/**
	 * Deletes the travel international premi from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelInternationalPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelInternationalPremi the travel international premi
	 * @return the travel international premi that was removed
	 */
	@Override
	public com.mypage.admin.product.model.TravelInternationalPremi
		deleteTravelInternationalPremi(
			com.mypage.admin.product.model.TravelInternationalPremi
				travelInternationalPremi) {

		return _travelInternationalPremiLocalService.
			deleteTravelInternationalPremi(travelInternationalPremi);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _travelInternationalPremiLocalService.dynamicQuery();
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

		return _travelInternationalPremiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelInternationalPremiModelImpl</code>.
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

		return _travelInternationalPremiLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelInternationalPremiModelImpl</code>.
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

		return _travelInternationalPremiLocalService.dynamicQuery(
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

		return _travelInternationalPremiLocalService.dynamicQueryCount(
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

		return _travelInternationalPremiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.TravelInternationalPremi
		fetchTravelInternationalPremi(long premiId) {

		return _travelInternationalPremiLocalService.
			fetchTravelInternationalPremi(premiId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _travelInternationalPremiLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _travelInternationalPremiLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _travelInternationalPremiLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelInternationalPremiLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public int getPremiCounts() {
		return _travelInternationalPremiLocalService.getPremiCounts();
	}

	/**
	 * Returns the travel international premi with the primary key.
	 *
	 * @param premiId the primary key of the travel international premi
	 * @return the travel international premi
	 * @throws PortalException if a travel international premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.TravelInternationalPremi
			getTravelInternationalPremi(long premiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelInternationalPremiLocalService.
			getTravelInternationalPremi(premiId);
	}

	/**
	 * Returns a range of all the travel international premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelInternationalPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel international premis
	 * @param end the upper bound of the range of travel international premis (not inclusive)
	 * @return the range of travel international premis
	 */
	@Override
	public java.util.List
		<com.mypage.admin.product.model.TravelInternationalPremi>
			getTravelInternationalPremis(int start, int end) {

		return _travelInternationalPremiLocalService.
			getTravelInternationalPremis(start, end);
	}

	/**
	 * Returns the number of travel international premis.
	 *
	 * @return the number of travel international premis
	 */
	@Override
	public int getTravelInternationalPremisCount() {
		return _travelInternationalPremiLocalService.
			getTravelInternationalPremisCount();
	}

	@Override
	public java.util.List
		<com.mypage.admin.product.model.TravelInternationalPremi> searchPremi(
			String packageType, String peopleType, String currency,
			int adultCount, int childrenCount, int minDuration,
			int maxDuration) {

		return _travelInternationalPremiLocalService.searchPremi(
			packageType, peopleType, currency, adultCount, childrenCount,
			minDuration, maxDuration);
	}

	@Override
	public com.mypage.admin.product.model.TravelInternationalPremi setActive(
			long userId, long premiId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _travelInternationalPremiLocalService.setActive(
			userId, premiId, active, serviceContext);
	}

	/**
	 * Updates the travel international premi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelInternationalPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelInternationalPremi the travel international premi
	 * @return the travel international premi that was updated
	 */
	@Override
	public com.mypage.admin.product.model.TravelInternationalPremi
		updateTravelInternationalPremi(
			com.mypage.admin.product.model.TravelInternationalPremi
				travelInternationalPremi) {

		return _travelInternationalPremiLocalService.
			updateTravelInternationalPremi(travelInternationalPremi);
	}

	@Override
	public TravelInternationalPremiLocalService getWrappedService() {
		return _travelInternationalPremiLocalService;
	}

	@Override
	public void setWrappedService(
		TravelInternationalPremiLocalService
			travelInternationalPremiLocalService) {

		_travelInternationalPremiLocalService =
			travelInternationalPremiLocalService;
	}

	private TravelInternationalPremiLocalService
		_travelInternationalPremiLocalService;

}