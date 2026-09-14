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

import com.mypage.admin.product.model.SmartHealthPlan;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SmartHealthPlan. This utility wraps
 * <code>com.mypage.admin.product.service.impl.SmartHealthPlanLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see SmartHealthPlanLocalService
 * @generated
 */
public class SmartHealthPlanLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.SmartHealthPlanLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the smart health plan to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthPlan the smart health plan
	 * @return the smart health plan that was added
	 */
	public static SmartHealthPlan addSmartHealthPlan(
		SmartHealthPlan smartHealthPlan) {

		return getService().addSmartHealthPlan(smartHealthPlan);
	}

	/**
	 * Add Plan
	 */
	public static SmartHealthPlan addSmartHealthPlan(
			String planName, String planGroup, int isRecommended, int active)
		throws PortalException {

		return getService().addSmartHealthPlan(
			planName, planGroup, isRecommended, active);
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
	 * Creates a new smart health plan with the primary key. Does not add the smart health plan to the database.
	 *
	 * @param smartHealthPlanId the primary key for the new smart health plan
	 * @return the new smart health plan
	 */
	public static SmartHealthPlan createSmartHealthPlan(
		long smartHealthPlanId) {

		return getService().createSmartHealthPlan(smartHealthPlanId);
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
	 * Deletes the smart health plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthPlanId the primary key of the smart health plan
	 * @return the smart health plan that was removed
	 * @throws PortalException if a smart health plan with the primary key could not be found
	 */
	public static SmartHealthPlan deleteSmartHealthPlan(long smartHealthPlanId)
		throws PortalException {

		return getService().deleteSmartHealthPlan(smartHealthPlanId);
	}

	/**
	 * Deletes the smart health plan from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthPlan the smart health plan
	 * @return the smart health plan that was removed
	 */
	public static SmartHealthPlan deleteSmartHealthPlan(
		SmartHealthPlan smartHealthPlan) {

		return getService().deleteSmartHealthPlan(smartHealthPlan);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthPlanModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthPlanModelImpl</code>.
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

	public static SmartHealthPlan fetchSmartHealthPlan(long smartHealthPlanId) {
		return getService().fetchSmartHealthPlan(smartHealthPlanId);
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
	 * Returns the smart health plan with the primary key.
	 *
	 * @param smartHealthPlanId the primary key of the smart health plan
	 * @return the smart health plan
	 * @throws PortalException if a smart health plan with the primary key could not be found
	 */
	public static SmartHealthPlan getSmartHealthPlan(long smartHealthPlanId)
		throws PortalException {

		return getService().getSmartHealthPlan(smartHealthPlanId);
	}

	public static List<SmartHealthPlan> getSmartHealthPlans() {
		return getService().getSmartHealthPlans();
	}

	/**
	 * Returns a range of all the smart health plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health plans
	 * @param end the upper bound of the range of smart health plans (not inclusive)
	 * @return the range of smart health plans
	 */
	public static List<SmartHealthPlan> getSmartHealthPlans(
		int start, int end) {

		return getService().getSmartHealthPlans(start, end);
	}

	/**
	 * Returns the number of smart health plans.
	 *
	 * @return the number of smart health plans
	 */
	public static int getSmartHealthPlansCount() {
		return getService().getSmartHealthPlansCount();
	}

	public static void resetAllRecommendedStatus() throws PortalException {
		getService().resetAllRecommendedStatus();
	}

	public static SmartHealthPlan setActive(
			long smartHealthPlanId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			smartHealthPlanId, active, serviceContext);
	}

	public static SmartHealthPlan updateSmartHealthPlan(
			long smartHealthPlanId, int isRecommended)
		throws PortalException {

		return getService().updateSmartHealthPlan(
			smartHealthPlanId, isRecommended);
	}

	/**
	 * Update Plan
	 */
	public static SmartHealthPlan updateSmartHealthPlan(
			long smartHealthPlanId, String planName, String planGroup,
			int isRecommended, int active)
		throws PortalException {

		return getService().updateSmartHealthPlan(
			smartHealthPlanId, planName, planGroup, isRecommended, active);
	}

	/**
	 * Updates the smart health plan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthPlan the smart health plan
	 * @return the smart health plan that was updated
	 */
	public static SmartHealthPlan updateSmartHealthPlan(
		SmartHealthPlan smartHealthPlan) {

		return getService().updateSmartHealthPlan(smartHealthPlan);
	}

	public static SmartHealthPlanLocalService getService() {
		return _service;
	}

	private static volatile SmartHealthPlanLocalService _service;

}