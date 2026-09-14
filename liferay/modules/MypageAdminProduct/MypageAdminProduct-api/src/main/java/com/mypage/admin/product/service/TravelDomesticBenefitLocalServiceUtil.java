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

import com.mypage.admin.product.model.TravelDomesticBenefit;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TravelDomesticBenefit. This utility wraps
 * <code>com.mypage.admin.product.service.impl.TravelDomesticBenefitLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see TravelDomesticBenefitLocalService
 * @generated
 */
public class TravelDomesticBenefitLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.TravelDomesticBenefitLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static TravelDomesticBenefit addTravelDomesticBenefit(
		String plan, String amount, String benefit, long benefitValue,
		String group, int sort, int active) {

		return getService().addTravelDomesticBenefit(
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
	public static TravelDomesticBenefit addTravelDomesticBenefit(
		TravelDomesticBenefit travelDomesticBenefit) {

		return getService().addTravelDomesticBenefit(travelDomesticBenefit);
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
	 * Creates a new travel domestic benefit with the primary key. Does not add the travel domestic benefit to the database.
	 *
	 * @param travelDomesticBenefitId the primary key for the new travel domestic benefit
	 * @return the new travel domestic benefit
	 */
	public static TravelDomesticBenefit createTravelDomesticBenefit(
		long travelDomesticBenefitId) {

		return getService().createTravelDomesticBenefit(
			travelDomesticBenefitId);
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
	public static TravelDomesticBenefit deleteTravelDomesticBenefit(
			long travelDomesticBenefitId)
		throws PortalException {

		return getService().deleteTravelDomesticBenefit(
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
	public static TravelDomesticBenefit deleteTravelDomesticBenefit(
		TravelDomesticBenefit travelDomesticBenefit) {

		return getService().deleteTravelDomesticBenefit(travelDomesticBenefit);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticBenefitModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticBenefitModelImpl</code>.
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

	public static TravelDomesticBenefit fetchTravelDomesticBenefit(
		long travelDomesticBenefitId) {

		return getService().fetchTravelDomesticBenefit(travelDomesticBenefitId);
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
	 * Returns the travel domestic benefit with the primary key.
	 *
	 * @param travelDomesticBenefitId the primary key of the travel domestic benefit
	 * @return the travel domestic benefit
	 * @throws PortalException if a travel domestic benefit with the primary key could not be found
	 */
	public static TravelDomesticBenefit getTravelDomesticBenefit(
			long travelDomesticBenefitId)
		throws PortalException {

		return getService().getTravelDomesticBenefit(travelDomesticBenefitId);
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
	public static List<TravelDomesticBenefit> getTravelDomesticBenefits(
		int start, int end) {

		return getService().getTravelDomesticBenefits(start, end);
	}

	/**
	 * Returns the number of travel domestic benefits.
	 *
	 * @return the number of travel domestic benefits
	 */
	public static int getTravelDomesticBenefitsCount() {
		return getService().getTravelDomesticBenefitsCount();
	}

	public static List<TravelDomesticBenefit> searchByPlan(String plan) {
		return getService().searchByPlan(plan);
	}

	public static TravelDomesticBenefit setActive(
		long travelDomesticBenefitId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().setActive(
			travelDomesticBenefitId, active, serviceContext);
	}

	public static TravelDomesticBenefit updateTravelDomesticBenefit(
		long travelDomesticBenefitId, String plan, String amount,
		String benefit, long benefitValue, String group, int sort, int active) {

		return getService().updateTravelDomesticBenefit(
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
	public static TravelDomesticBenefit updateTravelDomesticBenefit(
		TravelDomesticBenefit travelDomesticBenefit) {

		return getService().updateTravelDomesticBenefit(travelDomesticBenefit);
	}

	public static TravelDomesticBenefitLocalService getService() {
		return _service;
	}

	private static volatile TravelDomesticBenefitLocalService _service;

}