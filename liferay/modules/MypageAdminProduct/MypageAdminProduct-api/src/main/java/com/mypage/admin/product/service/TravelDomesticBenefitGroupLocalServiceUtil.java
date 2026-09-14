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

import com.mypage.admin.product.model.TravelDomesticBenefitGroup;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TravelDomesticBenefitGroup. This utility wraps
 * <code>com.mypage.admin.product.service.impl.TravelDomesticBenefitGroupLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see TravelDomesticBenefitGroupLocalService
 * @generated
 */
public class TravelDomesticBenefitGroupLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.TravelDomesticBenefitGroupLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the travel domestic benefit group to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticBenefitGroup the travel domestic benefit group
	 * @return the travel domestic benefit group that was added
	 */
	public static TravelDomesticBenefitGroup addTravelDomesticBenefitGroup(
		TravelDomesticBenefitGroup travelDomesticBenefitGroup) {

		return getService().addTravelDomesticBenefitGroup(
			travelDomesticBenefitGroup);
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
	 * Creates a new travel domestic benefit group with the primary key. Does not add the travel domestic benefit group to the database.
	 *
	 * @param travelDomesticBenefitGroupId the primary key for the new travel domestic benefit group
	 * @return the new travel domestic benefit group
	 */
	public static TravelDomesticBenefitGroup createTravelDomesticBenefitGroup(
		long travelDomesticBenefitGroupId) {

		return getService().createTravelDomesticBenefitGroup(
			travelDomesticBenefitGroupId);
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
	 * Deletes the travel domestic benefit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticBenefitGroupId the primary key of the travel domestic benefit group
	 * @return the travel domestic benefit group that was removed
	 * @throws PortalException if a travel domestic benefit group with the primary key could not be found
	 */
	public static TravelDomesticBenefitGroup deleteTravelDomesticBenefitGroup(
			long travelDomesticBenefitGroupId)
		throws PortalException {

		return getService().deleteTravelDomesticBenefitGroup(
			travelDomesticBenefitGroupId);
	}

	/**
	 * Deletes the travel domestic benefit group from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticBenefitGroup the travel domestic benefit group
	 * @return the travel domestic benefit group that was removed
	 */
	public static TravelDomesticBenefitGroup deleteTravelDomesticBenefitGroup(
		TravelDomesticBenefitGroup travelDomesticBenefitGroup) {

		return getService().deleteTravelDomesticBenefitGroup(
			travelDomesticBenefitGroup);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticBenefitGroupModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticBenefitGroupModelImpl</code>.
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

	public static TravelDomesticBenefitGroup fetchTravelDomesticBenefitGroup(
		long travelDomesticBenefitGroupId) {

		return getService().fetchTravelDomesticBenefitGroup(
			travelDomesticBenefitGroupId);
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
	 * Returns the travel domestic benefit group with the primary key.
	 *
	 * @param travelDomesticBenefitGroupId the primary key of the travel domestic benefit group
	 * @return the travel domestic benefit group
	 * @throws PortalException if a travel domestic benefit group with the primary key could not be found
	 */
	public static TravelDomesticBenefitGroup getTravelDomesticBenefitGroup(
			long travelDomesticBenefitGroupId)
		throws PortalException {

		return getService().getTravelDomesticBenefitGroup(
			travelDomesticBenefitGroupId);
	}

	/**
	 * Returns a range of all the travel domestic benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @return the range of travel domestic benefit groups
	 */
	public static List<TravelDomesticBenefitGroup>
		getTravelDomesticBenefitGroups(int start, int end) {

		return getService().getTravelDomesticBenefitGroups(start, end);
	}

	/**
	 * Returns the number of travel domestic benefit groups.
	 *
	 * @return the number of travel domestic benefit groups
	 */
	public static int getTravelDomesticBenefitGroupsCount() {
		return getService().getTravelDomesticBenefitGroupsCount();
	}

	/**
	 * Updates the travel domestic benefit group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticBenefitGroup the travel domestic benefit group
	 * @return the travel domestic benefit group that was updated
	 */
	public static TravelDomesticBenefitGroup updateTravelDomesticBenefitGroup(
		TravelDomesticBenefitGroup travelDomesticBenefitGroup) {

		return getService().updateTravelDomesticBenefitGroup(
			travelDomesticBenefitGroup);
	}

	public static TravelDomesticBenefitGroupLocalService getService() {
		return _service;
	}

	private static volatile TravelDomesticBenefitGroupLocalService _service;

}