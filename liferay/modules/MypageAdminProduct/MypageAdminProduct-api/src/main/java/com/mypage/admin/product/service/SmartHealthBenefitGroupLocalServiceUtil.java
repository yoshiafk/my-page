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

import com.mypage.admin.product.model.SmartHealthBenefitGroup;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SmartHealthBenefitGroup. This utility wraps
 * <code>com.mypage.admin.product.service.impl.SmartHealthBenefitGroupLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see SmartHealthBenefitGroupLocalService
 * @generated
 */
public class SmartHealthBenefitGroupLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.SmartHealthBenefitGroupLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the smart health benefit group to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefitGroup the smart health benefit group
	 * @return the smart health benefit group that was added
	 */
	public static SmartHealthBenefitGroup addSmartHealthBenefitGroup(
		SmartHealthBenefitGroup smartHealthBenefitGroup) {

		return getService().addSmartHealthBenefitGroup(smartHealthBenefitGroup);
	}

	/**
	 * Add Benefit Group
	 */
	public static SmartHealthBenefitGroup addSmartHealthBenefitGroup(
			String groupName, String groupDescription, String groupCode,
			int active)
		throws PortalException {

		return getService().addSmartHealthBenefitGroup(
			groupName, groupDescription, groupCode, active);
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
	 * Creates a new smart health benefit group with the primary key. Does not add the smart health benefit group to the database.
	 *
	 * @param smartHealthBenefitGroupId the primary key for the new smart health benefit group
	 * @return the new smart health benefit group
	 */
	public static SmartHealthBenefitGroup createSmartHealthBenefitGroup(
		long smartHealthBenefitGroupId) {

		return getService().createSmartHealthBenefitGroup(
			smartHealthBenefitGroupId);
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
	 * Deletes the smart health benefit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefitGroupId the primary key of the smart health benefit group
	 * @return the smart health benefit group that was removed
	 * @throws PortalException if a smart health benefit group with the primary key could not be found
	 */
	public static SmartHealthBenefitGroup deleteSmartHealthBenefitGroup(
			long smartHealthBenefitGroupId)
		throws PortalException {

		return getService().deleteSmartHealthBenefitGroup(
			smartHealthBenefitGroupId);
	}

	/**
	 * Deletes the smart health benefit group from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefitGroup the smart health benefit group
	 * @return the smart health benefit group that was removed
	 */
	public static SmartHealthBenefitGroup deleteSmartHealthBenefitGroup(
		SmartHealthBenefitGroup smartHealthBenefitGroup) {

		return getService().deleteSmartHealthBenefitGroup(
			smartHealthBenefitGroup);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthBenefitGroupModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthBenefitGroupModelImpl</code>.
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

	public static SmartHealthBenefitGroup fetchSmartHealthBenefitGroup(
		long smartHealthBenefitGroupId) {

		return getService().fetchSmartHealthBenefitGroup(
			smartHealthBenefitGroupId);
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
	 * Returns the smart health benefit group with the primary key.
	 *
	 * @param smartHealthBenefitGroupId the primary key of the smart health benefit group
	 * @return the smart health benefit group
	 * @throws PortalException if a smart health benefit group with the primary key could not be found
	 */
	public static SmartHealthBenefitGroup getSmartHealthBenefitGroup(
			long smartHealthBenefitGroupId)
		throws PortalException {

		return getService().getSmartHealthBenefitGroup(
			smartHealthBenefitGroupId);
	}

	public static int getSmartHealthBenefitGroupCounts() {
		return getService().getSmartHealthBenefitGroupCounts();
	}

	public static List<SmartHealthBenefitGroup> getSmartHealthBenefitGroups() {
		return getService().getSmartHealthBenefitGroups();
	}

	/**
	 * Returns a range of all the smart health benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefit groups
	 * @param end the upper bound of the range of smart health benefit groups (not inclusive)
	 * @return the range of smart health benefit groups
	 */
	public static List<SmartHealthBenefitGroup> getSmartHealthBenefitGroups(
		int start, int end) {

		return getService().getSmartHealthBenefitGroups(start, end);
	}

	/**
	 * Returns the number of smart health benefit groups.
	 *
	 * @return the number of smart health benefit groups
	 */
	public static int getSmartHealthBenefitGroupsCount() {
		return getService().getSmartHealthBenefitGroupsCount();
	}

	public static SmartHealthBenefitGroup setActive(
			long smartHealthBenefitGroupId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			smartHealthBenefitGroupId, active, serviceContext);
	}

	/**
	 * Update Benefit Group
	 */
	public static SmartHealthBenefitGroup updateSmartHealthBenefitGroup(
			long smartHealthBenefitGroupId, String groupName,
			String groupDescription, String groupCode, int active)
		throws PortalException {

		return getService().updateSmartHealthBenefitGroup(
			smartHealthBenefitGroupId, groupName, groupDescription, groupCode,
			active);
	}

	/**
	 * Updates the smart health benefit group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefitGroup the smart health benefit group
	 * @return the smart health benefit group that was updated
	 */
	public static SmartHealthBenefitGroup updateSmartHealthBenefitGroup(
		SmartHealthBenefitGroup smartHealthBenefitGroup) {

		return getService().updateSmartHealthBenefitGroup(
			smartHealthBenefitGroup);
	}

	public static SmartHealthBenefitGroupLocalService getService() {
		return _service;
	}

	private static volatile SmartHealthBenefitGroupLocalService _service;

}