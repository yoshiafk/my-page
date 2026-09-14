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

import com.mypage.admin.product.model.SmartHealthBenefit;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SmartHealthBenefit. This utility wraps
 * <code>com.mypage.admin.product.service.impl.SmartHealthBenefitLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see SmartHealthBenefitLocalService
 * @generated
 */
public class SmartHealthBenefitLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.SmartHealthBenefitLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the smart health benefit to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefit the smart health benefit
	 * @return the smart health benefit that was added
	 */
	public static SmartHealthBenefit addSmartHealthBenefit(
		SmartHealthBenefit smartHealthBenefit) {

		return getService().addSmartHealthBenefit(smartHealthBenefit);
	}

	/**
	 * Add Benefit
	 */
	public static SmartHealthBenefit addSmartHealthBenefit(
			String benefitTitle, String benefitContent,
			long smartHealthBenefitGroupId, long smartHealthPlanId, int active)
		throws PortalException {

		return getService().addSmartHealthBenefit(
			benefitTitle, benefitContent, smartHealthBenefitGroupId,
			smartHealthPlanId, active);
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
	 * Creates a new smart health benefit with the primary key. Does not add the smart health benefit to the database.
	 *
	 * @param smartHealthBenefitId the primary key for the new smart health benefit
	 * @return the new smart health benefit
	 */
	public static SmartHealthBenefit createSmartHealthBenefit(
		long smartHealthBenefitId) {

		return getService().createSmartHealthBenefit(smartHealthBenefitId);
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
	 * Deletes the smart health benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefitId the primary key of the smart health benefit
	 * @return the smart health benefit that was removed
	 * @throws PortalException if a smart health benefit with the primary key could not be found
	 */
	public static SmartHealthBenefit deleteSmartHealthBenefit(
			long smartHealthBenefitId)
		throws PortalException {

		return getService().deleteSmartHealthBenefit(smartHealthBenefitId);
	}

	/**
	 * Deletes the smart health benefit from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefit the smart health benefit
	 * @return the smart health benefit that was removed
	 */
	public static SmartHealthBenefit deleteSmartHealthBenefit(
		SmartHealthBenefit smartHealthBenefit) {

		return getService().deleteSmartHealthBenefit(smartHealthBenefit);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthBenefitModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthBenefitModelImpl</code>.
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

	public static SmartHealthBenefit fetchSmartHealthBenefit(
		long smartHealthBenefitId) {

		return getService().fetchSmartHealthBenefit(smartHealthBenefitId);
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
	 * Returns the smart health benefit with the primary key.
	 *
	 * @param smartHealthBenefitId the primary key of the smart health benefit
	 * @return the smart health benefit
	 * @throws PortalException if a smart health benefit with the primary key could not be found
	 */
	public static SmartHealthBenefit getSmartHealthBenefit(
			long smartHealthBenefitId)
		throws PortalException {

		return getService().getSmartHealthBenefit(smartHealthBenefitId);
	}

	public static int getSmartHealthBenefitCounts() {
		return getService().getSmartHealthBenefitCounts();
	}

	public static List<SmartHealthBenefit> getSmartHealthBenefits() {
		return getService().getSmartHealthBenefits();
	}

	/**
	 * Returns a range of all the smart health benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefits
	 * @param end the upper bound of the range of smart health benefits (not inclusive)
	 * @return the range of smart health benefits
	 */
	public static List<SmartHealthBenefit> getSmartHealthBenefits(
		int start, int end) {

		return getService().getSmartHealthBenefits(start, end);
	}

	/**
	 * Returns the number of smart health benefits.
	 *
	 * @return the number of smart health benefits
	 */
	public static int getSmartHealthBenefitsCount() {
		return getService().getSmartHealthBenefitsCount();
	}

	public static SmartHealthBenefit setActive(
			long smartHealthBenefitId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			smartHealthBenefitId, active, serviceContext);
	}

	/**
	 * Update Benefit
	 */
	public static SmartHealthBenefit updateSmartHealthBenefit(
			long smartHealthBenefitId, String benefitTitle,
			String benefitContent, long smartHealthBenefitGroupId,
			long smartHealthPlanId, int active)
		throws PortalException {

		return getService().updateSmartHealthBenefit(
			smartHealthBenefitId, benefitTitle, benefitContent,
			smartHealthBenefitGroupId, smartHealthPlanId, active);
	}

	/**
	 * Updates the smart health benefit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefit the smart health benefit
	 * @return the smart health benefit that was updated
	 */
	public static SmartHealthBenefit updateSmartHealthBenefit(
		SmartHealthBenefit smartHealthBenefit) {

		return getService().updateSmartHealthBenefit(smartHealthBenefit);
	}

	public static SmartHealthBenefitLocalService getService() {
		return _service;
	}

	private static volatile SmartHealthBenefitLocalService _service;

}