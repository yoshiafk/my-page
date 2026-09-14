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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.TravelIntBenefitValue;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TravelIntBenefitValue. This utility wraps
 * <code>com.mypage.admin.product.service.impl.TravelIntBenefitValueLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see TravelIntBenefitValueLocalService
 * @generated
 */
public class TravelIntBenefitValueLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.TravelIntBenefitValueLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Add
	 */
	public static TravelIntBenefitValue addTravelIntBenefitValue(
			long travelIntBenefitId, String currencyName, String packageType,
			String benefitValue, int active)
		throws PortalException {

		return getService().addTravelIntBenefitValue(
			travelIntBenefitId, currencyName, packageType, benefitValue,
			active);
	}

	/**
	 * Adds the travel int benefit value to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelIntBenefitValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelIntBenefitValue the travel int benefit value
	 * @return the travel int benefit value that was added
	 */
	public static TravelIntBenefitValue addTravelIntBenefitValue(
		TravelIntBenefitValue travelIntBenefitValue) {

		return getService().addTravelIntBenefitValue(travelIntBenefitValue);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new travel int benefit value with the primary key. Does not add the travel int benefit value to the database.
	 *
	 * @param travelIntBenefitValueId the primary key for the new travel int benefit value
	 * @return the new travel int benefit value
	 */
	public static TravelIntBenefitValue createTravelIntBenefitValue(
		long travelIntBenefitValueId) {

		return getService().createTravelIntBenefitValue(
			travelIntBenefitValueId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the travel int benefit value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelIntBenefitValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelIntBenefitValueId the primary key of the travel int benefit value
	 * @return the travel int benefit value that was removed
	 * @throws PortalException if a travel int benefit value with the primary key could not be found
	 */
	public static TravelIntBenefitValue deleteTravelIntBenefitValue(
			long travelIntBenefitValueId)
		throws PortalException {

		return getService().deleteTravelIntBenefitValue(
			travelIntBenefitValueId);
	}

	/**
	 * Deletes the travel int benefit value from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelIntBenefitValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelIntBenefitValue the travel int benefit value
	 * @return the travel int benefit value that was removed
	 */
	public static TravelIntBenefitValue deleteTravelIntBenefitValue(
		TravelIntBenefitValue travelIntBenefitValue) {

		return getService().deleteTravelIntBenefitValue(travelIntBenefitValue);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static TravelIntBenefitValue fetchTravelIntBenefitValue(
		long travelIntBenefitValueId) {

		return getService().fetchTravelIntBenefitValue(travelIntBenefitValueId);
	}

	public static List<TravelIntBenefitValue> findByPackageType(
		String packageType) {

		return getService().findByPackageType(packageType);
	}

	public static List<TravelIntBenefitValue> findByPackageTypeAndCurrencyName(
		long benefitParentId, String packageType, String currencyName) {

		return getService().findByPackageTypeAndCurrencyName(
			benefitParentId, packageType, currencyName);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the travel int benefit value with the primary key.
	 *
	 * @param travelIntBenefitValueId the primary key of the travel int benefit value
	 * @return the travel int benefit value
	 * @throws PortalException if a travel int benefit value with the primary key could not be found
	 */
	public static TravelIntBenefitValue getTravelIntBenefitValue(
			long travelIntBenefitValueId)
		throws PortalException {

		return getService().getTravelIntBenefitValue(travelIntBenefitValueId);
	}

	public static int gettravelIntBenefitValueCount() {
		return getService().gettravelIntBenefitValueCount();
	}

	public static List<TravelIntBenefitValue> getTravelIntBenefitValues() {
		return getService().getTravelIntBenefitValues();
	}

	/**
	 * Returns a range of all the travel int benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @return the range of travel int benefit values
	 */
	public static List<TravelIntBenefitValue> getTravelIntBenefitValues(
		int start, int end) {

		return getService().getTravelIntBenefitValues(start, end);
	}

	/**
	 * Returns the number of travel int benefit values.
	 *
	 * @return the number of travel int benefit values
	 */
	public static int getTravelIntBenefitValuesCount() {
		return getService().getTravelIntBenefitValuesCount();
	}

	/**
	 * Update
	 */
	public static TravelIntBenefitValue updateTravelIntBenefitValue(
			long travelIntBenefitValueId, long travelIntBenefitId,
			String currencyName, String packageType, String benefitValue,
			int active)
		throws PortalException {

		return getService().updateTravelIntBenefitValue(
			travelIntBenefitValueId, travelIntBenefitId, currencyName,
			packageType, benefitValue, active);
	}

	/**
	 * Updates the travel int benefit value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelIntBenefitValueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelIntBenefitValue the travel int benefit value
	 * @return the travel int benefit value that was updated
	 */
	public static TravelIntBenefitValue updateTravelIntBenefitValue(
		TravelIntBenefitValue travelIntBenefitValue) {

		return getService().updateTravelIntBenefitValue(travelIntBenefitValue);
	}

	public static TravelIntBenefitValueLocalService getService() {
		return _service;
	}

	private static volatile TravelIntBenefitValueLocalService _service;

}