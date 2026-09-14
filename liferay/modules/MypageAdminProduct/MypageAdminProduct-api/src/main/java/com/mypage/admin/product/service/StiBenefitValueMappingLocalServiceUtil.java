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

import com.mypage.admin.product.model.StiBenefitValueMapping;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for StiBenefitValueMapping. This utility wraps
 * <code>com.mypage.admin.product.service.impl.StiBenefitValueMappingLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see StiBenefitValueMappingLocalService
 * @generated
 */
public class StiBenefitValueMappingLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.StiBenefitValueMappingLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the sti benefit value mapping to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stiBenefitValueMapping the sti benefit value mapping
	 * @return the sti benefit value mapping that was added
	 */
	public static StiBenefitValueMapping addStiBenefitValueMapping(
		StiBenefitValueMapping stiBenefitValueMapping) {

		return getService().addStiBenefitValueMapping(stiBenefitValueMapping);
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
	 * Creates a new sti benefit value mapping with the primary key. Does not add the sti benefit value mapping to the database.
	 *
	 * @param benefitValueMappingId the primary key for the new sti benefit value mapping
	 * @return the new sti benefit value mapping
	 */
	public static StiBenefitValueMapping createStiBenefitValueMapping(
		long benefitValueMappingId) {

		return getService().createStiBenefitValueMapping(benefitValueMappingId);
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
	 * Deletes the sti benefit value mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param benefitValueMappingId the primary key of the sti benefit value mapping
	 * @return the sti benefit value mapping that was removed
	 * @throws PortalException if a sti benefit value mapping with the primary key could not be found
	 */
	public static StiBenefitValueMapping deleteStiBenefitValueMapping(
			long benefitValueMappingId)
		throws PortalException {

		return getService().deleteStiBenefitValueMapping(benefitValueMappingId);
	}

	/**
	 * Deletes the sti benefit value mapping from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stiBenefitValueMapping the sti benefit value mapping
	 * @return the sti benefit value mapping that was removed
	 */
	public static StiBenefitValueMapping deleteStiBenefitValueMapping(
		StiBenefitValueMapping stiBenefitValueMapping) {

		return getService().deleteStiBenefitValueMapping(
			stiBenefitValueMapping);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.StiBenefitValueMappingModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.StiBenefitValueMappingModelImpl</code>.
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

	public static StiBenefitValueMapping fetchStiBenefitValueMapping(
		long benefitValueMappingId) {

		return getService().fetchStiBenefitValueMapping(benefitValueMappingId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<StiBenefitValueMapping> getActiveBenefitValueMapping() {
		return getService().getActiveBenefitValueMapping();
	}

	public static List<StiBenefitValueMapping>
		getAllBenefitValueMappingByBenefitType(long benefitTypeId) {

		return getService().getAllBenefitValueMappingByBenefitType(
			benefitTypeId);
	}

	public static List<StiBenefitValueMapping> getAllBenefitValueMappings() {
		return getService().getAllBenefitValueMappings();
	}

	public static List<StiBenefitValueMapping>
		getBenefitValueMappingByBenefitTypeAndBenefit(
			long benefitTypeId, long benefitId) {

		return getService().getBenefitValueMappingByBenefitTypeAndBenefit(
			benefitTypeId, benefitId);
	}

	public static StiBenefitValueMapping
		getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
			long benefitTypeId, long benefitId, long planId) {

		return getService().
			getBenefitValueMappingByBenefitTypeAndBenefitAndPlan(
				benefitTypeId, benefitId, planId);
	}

	public static int getBenefitValueMappingCount() {
		return getService().getBenefitValueMappingCount();
	}

	public static List<StiBenefitValueMapping> getBenefitValueMappings(
		int start, int end) {

		return getService().getBenefitValueMappings(start, end);
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
	 * Returns the sti benefit value mapping with the primary key.
	 *
	 * @param benefitValueMappingId the primary key of the sti benefit value mapping
	 * @return the sti benefit value mapping
	 * @throws PortalException if a sti benefit value mapping with the primary key could not be found
	 */
	public static StiBenefitValueMapping getStiBenefitValueMapping(
			long benefitValueMappingId)
		throws PortalException {

		return getService().getStiBenefitValueMapping(benefitValueMappingId);
	}

	/**
	 * Returns a range of all the sti benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.StiBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti benefit value mappings
	 * @param end the upper bound of the range of sti benefit value mappings (not inclusive)
	 * @return the range of sti benefit value mappings
	 */
	public static List<StiBenefitValueMapping> getStiBenefitValueMappings(
		int start, int end) {

		return getService().getStiBenefitValueMappings(start, end);
	}

	/**
	 * Returns the number of sti benefit value mappings.
	 *
	 * @return the number of sti benefit value mappings
	 */
	public static int getStiBenefitValueMappingsCount() {
		return getService().getStiBenefitValueMappingsCount();
	}

	public static StiBenefitValueMapping setActive(
			long benefitValueMappingId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			benefitValueMappingId, active, serviceContext);
	}

	/**
	 * Updates the sti benefit value mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stiBenefitValueMapping the sti benefit value mapping
	 * @return the sti benefit value mapping that was updated
	 */
	public static StiBenefitValueMapping updateStiBenefitValueMapping(
		StiBenefitValueMapping stiBenefitValueMapping) {

		return getService().updateStiBenefitValueMapping(
			stiBenefitValueMapping);
	}

	public static StiBenefitValueMappingLocalService getService() {
		return _service;
	}

	private static volatile StiBenefitValueMappingLocalService _service;

}