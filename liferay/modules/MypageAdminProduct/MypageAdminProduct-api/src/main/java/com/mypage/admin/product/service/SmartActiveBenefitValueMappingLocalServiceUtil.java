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

import com.mypage.admin.product.model.SmartActiveBenefitValueMapping;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SmartActiveBenefitValueMapping. This utility wraps
 * <code>com.mypage.admin.product.service.impl.SmartActiveBenefitValueMappingLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see SmartActiveBenefitValueMappingLocalService
 * @generated
 */
public class SmartActiveBenefitValueMappingLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.SmartActiveBenefitValueMappingLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SmartActiveBenefitValueMapping addBenefitValueMapping(
			long benefitTypeId, long benefitId, long benefitValueId,
			String benefitValue, java.math.BigDecimal limitValue, int active)
		throws PortalException {

		return getService().addBenefitValueMapping(
			benefitTypeId, benefitId, benefitValueId, benefitValue, limitValue,
			active);
	}

	/**
	 * Adds the smart active benefit value mapping to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitValueMapping the smart active benefit value mapping
	 * @return the smart active benefit value mapping that was added
	 */
	public static SmartActiveBenefitValueMapping
		addSmartActiveBenefitValueMapping(
			SmartActiveBenefitValueMapping smartActiveBenefitValueMapping) {

		return getService().addSmartActiveBenefitValueMapping(
			smartActiveBenefitValueMapping);
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
	 * Creates a new smart active benefit value mapping with the primary key. Does not add the smart active benefit value mapping to the database.
	 *
	 * @param smartActiveBenefitValueMappingId the primary key for the new smart active benefit value mapping
	 * @return the new smart active benefit value mapping
	 */
	public static SmartActiveBenefitValueMapping
		createSmartActiveBenefitValueMapping(
			long smartActiveBenefitValueMappingId) {

		return getService().createSmartActiveBenefitValueMapping(
			smartActiveBenefitValueMappingId);
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
	 * Deletes the smart active benefit value mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitValueMappingId the primary key of the smart active benefit value mapping
	 * @return the smart active benefit value mapping that was removed
	 * @throws PortalException if a smart active benefit value mapping with the primary key could not be found
	 */
	public static SmartActiveBenefitValueMapping
			deleteSmartActiveBenefitValueMapping(
				long smartActiveBenefitValueMappingId)
		throws PortalException {

		return getService().deleteSmartActiveBenefitValueMapping(
			smartActiveBenefitValueMappingId);
	}

	/**
	 * Deletes the smart active benefit value mapping from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitValueMapping the smart active benefit value mapping
	 * @return the smart active benefit value mapping that was removed
	 */
	public static SmartActiveBenefitValueMapping
		deleteSmartActiveBenefitValueMapping(
			SmartActiveBenefitValueMapping smartActiveBenefitValueMapping) {

		return getService().deleteSmartActiveBenefitValueMapping(
			smartActiveBenefitValueMapping);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitValueMappingModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitValueMappingModelImpl</code>.
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

	public static SmartActiveBenefitValueMapping
		fetchSmartActiveBenefitValueMapping(
			long smartActiveBenefitValueMappingId) {

		return getService().fetchSmartActiveBenefitValueMapping(
			smartActiveBenefitValueMappingId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<SmartActiveBenefitValueMapping>
		getAllBenefitValueMappings() {

		return getService().getAllBenefitValueMappings();
	}

	public static List<SmartActiveBenefitValueMapping> getAllByBenefitValue(
		long benefitValueId) {

		return getService().getAllByBenefitValue(benefitValueId);
	}

	public static List<SmartActiveBenefitValueMapping>
		getBenefitValueMapping() {

		return getService().getBenefitValueMapping();
	}

	public static SmartActiveBenefitValueMapping
		getBenefitValueMappingByBenefitIdAndBenefitValueId(
			long smartActiveBenefitId, long smartActiveBenefitValueId) {

		return getService().getBenefitValueMappingByBenefitIdAndBenefitValueId(
			smartActiveBenefitId, smartActiveBenefitValueId);
	}

	public static int getBenefitValueMappingCount() {
		return getService().getBenefitValueMappingCount();
	}

	public static List<SmartActiveBenefitValueMapping> getBenefitValueMappings(
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
	 * Returns the smart active benefit value mapping with the primary key.
	 *
	 * @param smartActiveBenefitValueMappingId the primary key of the smart active benefit value mapping
	 * @return the smart active benefit value mapping
	 * @throws PortalException if a smart active benefit value mapping with the primary key could not be found
	 */
	public static SmartActiveBenefitValueMapping
			getSmartActiveBenefitValueMapping(
				long smartActiveBenefitValueMappingId)
		throws PortalException {

		return getService().getSmartActiveBenefitValueMapping(
			smartActiveBenefitValueMappingId);
	}

	/**
	 * Returns a range of all the smart active benefit value mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitValueMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit value mappings
	 * @param end the upper bound of the range of smart active benefit value mappings (not inclusive)
	 * @return the range of smart active benefit value mappings
	 */
	public static List<SmartActiveBenefitValueMapping>
		getSmartActiveBenefitValueMappings(int start, int end) {

		return getService().getSmartActiveBenefitValueMappings(start, end);
	}

	/**
	 * Returns the number of smart active benefit value mappings.
	 *
	 * @return the number of smart active benefit value mappings
	 */
	public static int getSmartActiveBenefitValueMappingsCount() {
		return getService().getSmartActiveBenefitValueMappingsCount();
	}

	public static SmartActiveBenefitValueMapping setActive(
			long benefitValueMappingId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			benefitValueMappingId, active, serviceContext);
	}

	public static SmartActiveBenefitValueMapping updateBenefitValueMapping(
			long benefitValueMappingId, long benefitTypeId, long benefitId,
			long benefitValueId, String benefitValue,
			java.math.BigDecimal limitValue, int active)
		throws PortalException {

		return getService().updateBenefitValueMapping(
			benefitValueMappingId, benefitTypeId, benefitId, benefitValueId,
			benefitValue, limitValue, active);
	}

	/**
	 * Updates the smart active benefit value mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitValueMappingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitValueMapping the smart active benefit value mapping
	 * @return the smart active benefit value mapping that was updated
	 */
	public static SmartActiveBenefitValueMapping
		updateSmartActiveBenefitValueMapping(
			SmartActiveBenefitValueMapping smartActiveBenefitValueMapping) {

		return getService().updateSmartActiveBenefitValueMapping(
			smartActiveBenefitValueMapping);
	}

	public static SmartActiveBenefitValueMappingLocalService getService() {
		return _service;
	}

	private static volatile SmartActiveBenefitValueMappingLocalService _service;

}