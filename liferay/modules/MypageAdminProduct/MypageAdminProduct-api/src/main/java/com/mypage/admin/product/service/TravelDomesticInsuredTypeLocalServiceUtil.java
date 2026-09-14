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

import com.mypage.admin.product.model.TravelDomesticInsuredType;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TravelDomesticInsuredType. This utility wraps
 * <code>com.mypage.admin.product.service.impl.TravelDomesticInsuredTypeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see TravelDomesticInsuredTypeLocalService
 * @generated
 */
public class TravelDomesticInsuredTypeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.TravelDomesticInsuredTypeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the travel domestic insured type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticInsuredTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticInsuredType the travel domestic insured type
	 * @return the travel domestic insured type that was added
	 */
	public static TravelDomesticInsuredType addTravelDomesticInsuredType(
		TravelDomesticInsuredType travelDomesticInsuredType) {

		return getService().addTravelDomesticInsuredType(
			travelDomesticInsuredType);
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
	 * Creates a new travel domestic insured type with the primary key. Does not add the travel domestic insured type to the database.
	 *
	 * @param travelDomesticInsuredTypeId the primary key for the new travel domestic insured type
	 * @return the new travel domestic insured type
	 */
	public static TravelDomesticInsuredType createTravelDomesticInsuredType(
		long travelDomesticInsuredTypeId) {

		return getService().createTravelDomesticInsuredType(
			travelDomesticInsuredTypeId);
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
	 * Deletes the travel domestic insured type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticInsuredTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticInsuredTypeId the primary key of the travel domestic insured type
	 * @return the travel domestic insured type that was removed
	 * @throws PortalException if a travel domestic insured type with the primary key could not be found
	 */
	public static TravelDomesticInsuredType deleteTravelDomesticInsuredType(
			long travelDomesticInsuredTypeId)
		throws PortalException {

		return getService().deleteTravelDomesticInsuredType(
			travelDomesticInsuredTypeId);
	}

	/**
	 * Deletes the travel domestic insured type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticInsuredTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticInsuredType the travel domestic insured type
	 * @return the travel domestic insured type that was removed
	 */
	public static TravelDomesticInsuredType deleteTravelDomesticInsuredType(
		TravelDomesticInsuredType travelDomesticInsuredType) {

		return getService().deleteTravelDomesticInsuredType(
			travelDomesticInsuredType);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticInsuredTypeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticInsuredTypeModelImpl</code>.
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

	public static TravelDomesticInsuredType fetchTravelDomesticInsuredType(
		long travelDomesticInsuredTypeId) {

		return getService().fetchTravelDomesticInsuredType(
			travelDomesticInsuredTypeId);
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
	 * Returns the travel domestic insured type with the primary key.
	 *
	 * @param travelDomesticInsuredTypeId the primary key of the travel domestic insured type
	 * @return the travel domestic insured type
	 * @throws PortalException if a travel domestic insured type with the primary key could not be found
	 */
	public static TravelDomesticInsuredType getTravelDomesticInsuredType(
			long travelDomesticInsuredTypeId)
		throws PortalException {

		return getService().getTravelDomesticInsuredType(
			travelDomesticInsuredTypeId);
	}

	/**
	 * Returns a range of all the travel domestic insured types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @return the range of travel domestic insured types
	 */
	public static List<TravelDomesticInsuredType> getTravelDomesticInsuredTypes(
		int start, int end) {

		return getService().getTravelDomesticInsuredTypes(start, end);
	}

	/**
	 * Returns the number of travel domestic insured types.
	 *
	 * @return the number of travel domestic insured types
	 */
	public static int getTravelDomesticInsuredTypesCount() {
		return getService().getTravelDomesticInsuredTypesCount();
	}

	/**
	 * Updates the travel domestic insured type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticInsuredTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticInsuredType the travel domestic insured type
	 * @return the travel domestic insured type that was updated
	 */
	public static TravelDomesticInsuredType updateTravelDomesticInsuredType(
		TravelDomesticInsuredType travelDomesticInsuredType) {

		return getService().updateTravelDomesticInsuredType(
			travelDomesticInsuredType);
	}

	public static TravelDomesticInsuredTypeLocalService getService() {
		return _service;
	}

	private static volatile TravelDomesticInsuredTypeLocalService _service;

}