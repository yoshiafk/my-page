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

import com.mypage.admin.product.model.SmartActiveBenefitType;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SmartActiveBenefitType. This utility wraps
 * <code>com.mypage.admin.product.service.impl.SmartActiveBenefitTypeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see SmartActiveBenefitTypeLocalService
 * @generated
 */
public class SmartActiveBenefitTypeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.SmartActiveBenefitTypeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SmartActiveBenefitType addBenefitType(
			String nameId, String nameEn, int sort, int active)
		throws PortalException {

		return getService().addBenefitType(nameId, nameEn, sort, active);
	}

	/**
	 * Adds the smart active benefit type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitType the smart active benefit type
	 * @return the smart active benefit type that was added
	 */
	public static SmartActiveBenefitType addSmartActiveBenefitType(
		SmartActiveBenefitType smartActiveBenefitType) {

		return getService().addSmartActiveBenefitType(smartActiveBenefitType);
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
	 * Creates a new smart active benefit type with the primary key. Does not add the smart active benefit type to the database.
	 *
	 * @param smartActiveBenefitTypeId the primary key for the new smart active benefit type
	 * @return the new smart active benefit type
	 */
	public static SmartActiveBenefitType createSmartActiveBenefitType(
		long smartActiveBenefitTypeId) {

		return getService().createSmartActiveBenefitType(
			smartActiveBenefitTypeId);
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
	 * Deletes the smart active benefit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitTypeId the primary key of the smart active benefit type
	 * @return the smart active benefit type that was removed
	 * @throws PortalException if a smart active benefit type with the primary key could not be found
	 */
	public static SmartActiveBenefitType deleteSmartActiveBenefitType(
			long smartActiveBenefitTypeId)
		throws PortalException {

		return getService().deleteSmartActiveBenefitType(
			smartActiveBenefitTypeId);
	}

	/**
	 * Deletes the smart active benefit type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitType the smart active benefit type
	 * @return the smart active benefit type that was removed
	 */
	public static SmartActiveBenefitType deleteSmartActiveBenefitType(
		SmartActiveBenefitType smartActiveBenefitType) {

		return getService().deleteSmartActiveBenefitType(
			smartActiveBenefitType);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitTypeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitTypeModelImpl</code>.
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

	public static SmartActiveBenefitType fetchSmartActiveBenefitType(
		long smartActiveBenefitTypeId) {

		return getService().fetchSmartActiveBenefitType(
			smartActiveBenefitTypeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<SmartActiveBenefitType> getActiveBenefitType() {
		return getService().getActiveBenefitType();
	}

	public static List<SmartActiveBenefitType> getAllBenefitTypes() {
		return getService().getAllBenefitTypes();
	}

	public static List<SmartActiveBenefitType> getBenefitTypeAdditional() {
		return getService().getBenefitTypeAdditional();
	}

	public static List<SmartActiveBenefitType> getBenefitTypeByName(
		String nameId, String nameEn) {

		return getService().getBenefitTypeByName(nameId, nameEn);
	}

	public static List<SmartActiveBenefitType> getBenefitTypeBySort(int sort) {
		return getService().getBenefitTypeBySort(sort);
	}

	public static List<SmartActiveBenefitType> getBenefitTypeMain() {
		return getService().getBenefitTypeMain();
	}

	public static List<SmartActiveBenefitType> getBenefitTypes() {
		return getService().getBenefitTypes();
	}

	public static List<SmartActiveBenefitType> getBenefitTypes(
		int start, int end) {

		return getService().getBenefitTypes(start, end);
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
	 * Returns the smart active benefit type with the primary key.
	 *
	 * @param smartActiveBenefitTypeId the primary key of the smart active benefit type
	 * @return the smart active benefit type
	 * @throws PortalException if a smart active benefit type with the primary key could not be found
	 */
	public static SmartActiveBenefitType getSmartActiveBenefitType(
			long smartActiveBenefitTypeId)
		throws PortalException {

		return getService().getSmartActiveBenefitType(smartActiveBenefitTypeId);
	}

	public static int getSmartActiveBenefitTypeCount() {
		return getService().getSmartActiveBenefitTypeCount();
	}

	/**
	 * Returns a range of all the smart active benefit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit types
	 * @param end the upper bound of the range of smart active benefit types (not inclusive)
	 * @return the range of smart active benefit types
	 */
	public static List<SmartActiveBenefitType> getSmartActiveBenefitTypes(
		int start, int end) {

		return getService().getSmartActiveBenefitTypes(start, end);
	}

	/**
	 * Returns the number of smart active benefit types.
	 *
	 * @return the number of smart active benefit types
	 */
	public static int getSmartActiveBenefitTypesCount() {
		return getService().getSmartActiveBenefitTypesCount();
	}

	public static SmartActiveBenefitType setActive(
		long benefitTypeId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().setActive(benefitTypeId, active, serviceContext);
	}

	public static SmartActiveBenefitType updateBenefitType(
			long benefitTypeId, String nameId, String nameEn, int sort,
			int active)
		throws PortalException {

		return getService().updateBenefitType(
			benefitTypeId, nameId, nameEn, sort, active);
	}

	/**
	 * Updates the smart active benefit type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitType the smart active benefit type
	 * @return the smart active benefit type that was updated
	 */
	public static SmartActiveBenefitType updateSmartActiveBenefitType(
		SmartActiveBenefitType smartActiveBenefitType) {

		return getService().updateSmartActiveBenefitType(
			smartActiveBenefitType);
	}

	public static SmartActiveBenefitTypeLocalService getService() {
		return _service;
	}

	private static volatile SmartActiveBenefitTypeLocalService _service;

}