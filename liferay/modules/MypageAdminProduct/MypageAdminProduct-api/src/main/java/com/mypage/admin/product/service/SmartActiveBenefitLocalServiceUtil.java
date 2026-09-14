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

import com.mypage.admin.product.model.SmartActiveBenefit;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SmartActiveBenefit. This utility wraps
 * <code>com.mypage.admin.product.service.impl.SmartActiveBenefitLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see SmartActiveBenefitLocalService
 * @generated
 */
public class SmartActiveBenefitLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.SmartActiveBenefitLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SmartActiveBenefit addBenefit(
			String nameId, String nameEn, int sort, int active,
			long benefitTypeId, String benefitLimit, String externalCode,
			String benefitDescription)
		throws PortalException {

		return getService().addBenefit(
			nameId, nameEn, sort, active, benefitTypeId, benefitLimit,
			externalCode, benefitDescription);
	}

	/**
	 * Adds the smart active benefit to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefit the smart active benefit
	 * @return the smart active benefit that was added
	 */
	public static SmartActiveBenefit addSmartActiveBenefit(
		SmartActiveBenefit smartActiveBenefit) {

		return getService().addSmartActiveBenefit(smartActiveBenefit);
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
	 * Creates a new smart active benefit with the primary key. Does not add the smart active benefit to the database.
	 *
	 * @param smartActiveBenefitId the primary key for the new smart active benefit
	 * @return the new smart active benefit
	 */
	public static SmartActiveBenefit createSmartActiveBenefit(
		long smartActiveBenefitId) {

		return getService().createSmartActiveBenefit(smartActiveBenefitId);
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
	 * Deletes the smart active benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitId the primary key of the smart active benefit
	 * @return the smart active benefit that was removed
	 * @throws PortalException if a smart active benefit with the primary key could not be found
	 */
	public static SmartActiveBenefit deleteSmartActiveBenefit(
			long smartActiveBenefitId)
		throws PortalException {

		return getService().deleteSmartActiveBenefit(smartActiveBenefitId);
	}

	/**
	 * Deletes the smart active benefit from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefit the smart active benefit
	 * @return the smart active benefit that was removed
	 */
	public static SmartActiveBenefit deleteSmartActiveBenefit(
		SmartActiveBenefit smartActiveBenefit) {

		return getService().deleteSmartActiveBenefit(smartActiveBenefit);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitModelImpl</code>.
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

	public static SmartActiveBenefit fetchSmartActiveBenefit(
		long smartActiveBenefitId) {

		return getService().fetchSmartActiveBenefit(smartActiveBenefitId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<SmartActiveBenefit> getActiveBenefit() {
		return getService().getActiveBenefit();
	}

	public static List<SmartActiveBenefit> getBenefitByTypeId(long typeId) {
		return getService().getBenefitByTypeId(typeId);
	}

	public static int getBenefitCount() {
		return getService().getBenefitCount();
	}

	public static List<SmartActiveBenefit> getBenefits() {
		return getService().getBenefits();
	}

	public static List<SmartActiveBenefit> getBenefits(int start, int end) {
		return getService().getBenefits(start, end);
	}

	public static SmartActiveBenefit getByExternalCode(String externalCode) {
		return getService().getByExternalCode(externalCode);
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
	 * Returns the smart active benefit with the primary key.
	 *
	 * @param smartActiveBenefitId the primary key of the smart active benefit
	 * @return the smart active benefit
	 * @throws PortalException if a smart active benefit with the primary key could not be found
	 */
	public static SmartActiveBenefit getSmartActiveBenefit(
			long smartActiveBenefitId)
		throws PortalException {

		return getService().getSmartActiveBenefit(smartActiveBenefitId);
	}

	/**
	 * Returns a range of all the smart active benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefits
	 * @param end the upper bound of the range of smart active benefits (not inclusive)
	 * @return the range of smart active benefits
	 */
	public static List<SmartActiveBenefit> getSmartActiveBenefits(
		int start, int end) {

		return getService().getSmartActiveBenefits(start, end);
	}

	/**
	 * Returns the number of smart active benefits.
	 *
	 * @return the number of smart active benefits
	 */
	public static int getSmartActiveBenefitsCount() {
		return getService().getSmartActiveBenefitsCount();
	}

	public static SmartActiveBenefit setActive(
			long benefitId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(benefitId, active, serviceContext);
	}

	public static SmartActiveBenefit updateBenefit(
			long benefitId, long benefitTypeId, String nameId, String nameEn,
			int sort, int active, String benefitLimit, String externalCode,
			String benefitDescription)
		throws PortalException {

		return getService().updateBenefit(
			benefitId, benefitTypeId, nameId, nameEn, sort, active,
			benefitLimit, externalCode, benefitDescription);
	}

	/**
	 * Updates the smart active benefit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefit the smart active benefit
	 * @return the smart active benefit that was updated
	 */
	public static SmartActiveBenefit updateSmartActiveBenefit(
		SmartActiveBenefit smartActiveBenefit) {

		return getService().updateSmartActiveBenefit(smartActiveBenefit);
	}

	public static SmartActiveBenefitLocalService getService() {
		return _service;
	}

	private static volatile SmartActiveBenefitLocalService _service;

}