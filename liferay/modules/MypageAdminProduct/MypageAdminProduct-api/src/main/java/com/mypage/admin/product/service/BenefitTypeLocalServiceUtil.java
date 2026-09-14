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

import com.mypage.admin.product.model.BenefitType;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for BenefitType. This utility wraps
 * <code>com.mypage.admin.product.service.impl.BenefitTypeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see BenefitTypeLocalService
 * @generated
 */
public class BenefitTypeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.BenefitTypeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the benefit type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitType the benefit type
	 * @return the benefit type that was added
	 */
	public static BenefitType addBenefitType(BenefitType benefitType) {
		return getService().addBenefitType(benefitType);
	}

	public static BenefitType addBenefitType(
			String nameId, String nameEn, int sort, int active)
		throws PortalException {

		return getService().addBenefitType(nameId, nameEn, sort, active);
	}

	/**
	 * Creates a new benefit type with the primary key. Does not add the benefit type to the database.
	 *
	 * @param benefitTypeId the primary key for the new benefit type
	 * @return the new benefit type
	 */
	public static BenefitType createBenefitType(long benefitTypeId) {
		return getService().createBenefitType(benefitTypeId);
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
	 * Deletes the benefit type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitType the benefit type
	 * @return the benefit type that was removed
	 */
	public static BenefitType deleteBenefitType(BenefitType benefitType) {
		return getService().deleteBenefitType(benefitType);
	}

	/**
	 * Deletes the benefit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitTypeId the primary key of the benefit type
	 * @return the benefit type that was removed
	 * @throws PortalException if a benefit type with the primary key could not be found
	 */
	public static BenefitType deleteBenefitType(long benefitTypeId)
		throws PortalException {

		return getService().deleteBenefitType(benefitTypeId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BenefitTypeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BenefitTypeModelImpl</code>.
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

	public static BenefitType fetchBenefitType(long benefitTypeId) {
		return getService().fetchBenefitType(benefitTypeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<BenefitType> getActiveBenefitType() {
		return getService().getActiveBenefitType();
	}

	public static List<BenefitType> getAllBenefitTypes() {
		return getService().getAllBenefitTypes();
	}

	/**
	 * Returns the benefit type with the primary key.
	 *
	 * @param benefitTypeId the primary key of the benefit type
	 * @return the benefit type
	 * @throws PortalException if a benefit type with the primary key could not be found
	 */
	public static BenefitType getBenefitType(long benefitTypeId)
		throws PortalException {

		return getService().getBenefitType(benefitTypeId);
	}

	public static List<BenefitType> getBenefitTypeAdditional() {
		return getService().getBenefitTypeAdditional();
	}

	public static List<BenefitType> getBenefitTypeByName(
		String nameId, String nameEn) {

		return getService().getBenefitTypeByName(nameId, nameEn);
	}

	public static List<BenefitType> getBenefitTypeBySort(int sort) {
		return getService().getBenefitTypeBySort(sort);
	}

	public static int getBenefitTypeCount() {
		return getService().getBenefitTypeCount();
	}

	public static List<BenefitType> getBenefitTypeMain() {
		return getService().getBenefitTypeMain();
	}

	public static List<BenefitType> getBenefitTypes() {
		return getService().getBenefitTypes();
	}

	/**
	 * Returns a range of all the benefit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.BenefitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of benefit types
	 * @param end the upper bound of the range of benefit types (not inclusive)
	 * @return the range of benefit types
	 */
	public static List<BenefitType> getBenefitTypes(int start, int end) {
		return getService().getBenefitTypes(start, end);
	}

	/**
	 * Returns the number of benefit types.
	 *
	 * @return the number of benefit types
	 */
	public static int getBenefitTypesCount() {
		return getService().getBenefitTypesCount();
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

	public static BenefitType setActive(
		long benefitTypeId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().setActive(benefitTypeId, active, serviceContext);
	}

	/**
	 * Updates the benefit type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitType the benefit type
	 * @return the benefit type that was updated
	 */
	public static BenefitType updateBenefitType(BenefitType benefitType) {
		return getService().updateBenefitType(benefitType);
	}

	public static BenefitType updateBenefitType(
			long benefitTypeId, String nameId, String nameEn, int sort,
			int active)
		throws PortalException {

		return getService().updateBenefitType(
			benefitTypeId, nameId, nameEn, sort, active);
	}

	public static BenefitTypeLocalService getService() {
		return _service;
	}

	private static volatile BenefitTypeLocalService _service;

}