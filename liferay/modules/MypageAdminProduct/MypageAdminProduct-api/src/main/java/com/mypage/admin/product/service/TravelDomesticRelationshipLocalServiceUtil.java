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

import com.mypage.admin.product.model.TravelDomesticRelationship;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TravelDomesticRelationship. This utility wraps
 * <code>com.mypage.admin.product.service.impl.TravelDomesticRelationshipLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see TravelDomesticRelationshipLocalService
 * @generated
 */
public class TravelDomesticRelationshipLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.TravelDomesticRelationshipLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the travel domestic relationship to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticRelationshipLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticRelationship the travel domestic relationship
	 * @return the travel domestic relationship that was added
	 */
	public static TravelDomesticRelationship addTravelDomesticRelationship(
		TravelDomesticRelationship travelDomesticRelationship) {

		return getService().addTravelDomesticRelationship(
			travelDomesticRelationship);
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
	 * Creates a new travel domestic relationship with the primary key. Does not add the travel domestic relationship to the database.
	 *
	 * @param travelDomesticRelationshipId the primary key for the new travel domestic relationship
	 * @return the new travel domestic relationship
	 */
	public static TravelDomesticRelationship createTravelDomesticRelationship(
		long travelDomesticRelationshipId) {

		return getService().createTravelDomesticRelationship(
			travelDomesticRelationshipId);
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
	 * Deletes the travel domestic relationship with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticRelationshipLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticRelationshipId the primary key of the travel domestic relationship
	 * @return the travel domestic relationship that was removed
	 * @throws PortalException if a travel domestic relationship with the primary key could not be found
	 */
	public static TravelDomesticRelationship deleteTravelDomesticRelationship(
			long travelDomesticRelationshipId)
		throws PortalException {

		return getService().deleteTravelDomesticRelationship(
			travelDomesticRelationshipId);
	}

	/**
	 * Deletes the travel domestic relationship from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticRelationshipLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticRelationship the travel domestic relationship
	 * @return the travel domestic relationship that was removed
	 */
	public static TravelDomesticRelationship deleteTravelDomesticRelationship(
		TravelDomesticRelationship travelDomesticRelationship) {

		return getService().deleteTravelDomesticRelationship(
			travelDomesticRelationship);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticRelationshipModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticRelationshipModelImpl</code>.
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

	public static TravelDomesticRelationship fetchTravelDomesticRelationship(
		long travelDomesticRelationshipId) {

		return getService().fetchTravelDomesticRelationship(
			travelDomesticRelationshipId);
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
	 * Returns the travel domestic relationship with the primary key.
	 *
	 * @param travelDomesticRelationshipId the primary key of the travel domestic relationship
	 * @return the travel domestic relationship
	 * @throws PortalException if a travel domestic relationship with the primary key could not be found
	 */
	public static TravelDomesticRelationship getTravelDomesticRelationship(
			long travelDomesticRelationshipId)
		throws PortalException {

		return getService().getTravelDomesticRelationship(
			travelDomesticRelationshipId);
	}

	/**
	 * Returns a range of all the travel domestic relationships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticRelationshipModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic relationships
	 * @param end the upper bound of the range of travel domestic relationships (not inclusive)
	 * @return the range of travel domestic relationships
	 */
	public static List<TravelDomesticRelationship>
		getTravelDomesticRelationships(int start, int end) {

		return getService().getTravelDomesticRelationships(start, end);
	}

	/**
	 * Returns the number of travel domestic relationships.
	 *
	 * @return the number of travel domestic relationships
	 */
	public static int getTravelDomesticRelationshipsCount() {
		return getService().getTravelDomesticRelationshipsCount();
	}

	/**
	 * Updates the travel domestic relationship in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticRelationshipLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticRelationship the travel domestic relationship
	 * @return the travel domestic relationship that was updated
	 */
	public static TravelDomesticRelationship updateTravelDomesticRelationship(
		TravelDomesticRelationship travelDomesticRelationship) {

		return getService().updateTravelDomesticRelationship(
			travelDomesticRelationship);
	}

	public static TravelDomesticRelationshipLocalService getService() {
		return _service;
	}

	private static volatile TravelDomesticRelationshipLocalService _service;

}