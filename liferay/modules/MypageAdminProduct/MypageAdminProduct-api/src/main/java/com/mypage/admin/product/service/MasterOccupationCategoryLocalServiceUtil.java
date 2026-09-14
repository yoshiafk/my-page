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

import com.mypage.admin.product.model.MasterOccupationCategory;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for MasterOccupationCategory. This utility wraps
 * <code>com.mypage.admin.product.service.impl.MasterOccupationCategoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see MasterOccupationCategoryLocalService
 * @generated
 */
public class MasterOccupationCategoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.MasterOccupationCategoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the master occupation category to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterOccupationCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterOccupationCategory the master occupation category
	 * @return the master occupation category that was added
	 */
	public static MasterOccupationCategory addMasterOccupationCategory(
		MasterOccupationCategory masterOccupationCategory) {

		return getService().addMasterOccupationCategory(
			masterOccupationCategory);
	}

	public static MasterOccupationCategory addMasterOccupationCategory(
		String name, int active) {

		return getService().addMasterOccupationCategory(name, active);
	}

	/**
	 * Creates a new master occupation category with the primary key. Does not add the master occupation category to the database.
	 *
	 * @param masterOccupationCategoryId the primary key for the new master occupation category
	 * @return the new master occupation category
	 */
	public static MasterOccupationCategory createMasterOccupationCategory(
		long masterOccupationCategoryId) {

		return getService().createMasterOccupationCategory(
			masterOccupationCategoryId);
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
	 * Deletes the master occupation category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterOccupationCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterOccupationCategoryId the primary key of the master occupation category
	 * @return the master occupation category that was removed
	 * @throws PortalException if a master occupation category with the primary key could not be found
	 */
	public static MasterOccupationCategory deleteMasterOccupationCategory(
			long masterOccupationCategoryId)
		throws PortalException {

		return getService().deleteMasterOccupationCategory(
			masterOccupationCategoryId);
	}

	/**
	 * Deletes the master occupation category from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterOccupationCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterOccupationCategory the master occupation category
	 * @return the master occupation category that was removed
	 */
	public static MasterOccupationCategory deleteMasterOccupationCategory(
		MasterOccupationCategory masterOccupationCategory) {

		return getService().deleteMasterOccupationCategory(
			masterOccupationCategory);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterOccupationCategoryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterOccupationCategoryModelImpl</code>.
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

	public static MasterOccupationCategory fetchMasterOccupationCategory(
		long masterOccupationCategoryId) {

		return getService().fetchMasterOccupationCategory(
			masterOccupationCategoryId);
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
	 * Returns a range of all the master occupation categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @return the range of master occupation categories
	 */
	public static List<MasterOccupationCategory> getMasterOccupationCategories(
		int start, int end) {

		return getService().getMasterOccupationCategories(start, end);
	}

	/**
	 * Returns the number of master occupation categories.
	 *
	 * @return the number of master occupation categories
	 */
	public static int getMasterOccupationCategoriesCount() {
		return getService().getMasterOccupationCategoriesCount();
	}

	/**
	 * Returns the master occupation category with the primary key.
	 *
	 * @param masterOccupationCategoryId the primary key of the master occupation category
	 * @return the master occupation category
	 * @throws PortalException if a master occupation category with the primary key could not be found
	 */
	public static MasterOccupationCategory getMasterOccupationCategory(
			long masterOccupationCategoryId)
		throws PortalException {

		return getService().getMasterOccupationCategory(
			masterOccupationCategoryId);
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

	public static List<MasterOccupationCategory> searchByActive(int active) {
		return getService().searchByActive(active);
	}

	public static MasterOccupationCategory searchByName(String name) {
		return getService().searchByName(name);
	}

	public static MasterOccupationCategory setActive(
		long masterOccupationCategoryId, int active) {

		return getService().setActive(masterOccupationCategoryId, active);
	}

	public static MasterOccupationCategory updateMasterOccupationCategory(
			long masterOccupationCategoryId, String name, int active)
		throws com.mypage.admin.product.exception.
			NoSuchMasterOccupationCategoryException {

		return getService().updateMasterOccupationCategory(
			masterOccupationCategoryId, name, active);
	}

	/**
	 * Updates the master occupation category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterOccupationCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterOccupationCategory the master occupation category
	 * @return the master occupation category that was updated
	 */
	public static MasterOccupationCategory updateMasterOccupationCategory(
		MasterOccupationCategory masterOccupationCategory) {

		return getService().updateMasterOccupationCategory(
			masterOccupationCategory);
	}

	public static MasterOccupationCategoryLocalService getService() {
		return _service;
	}

	private static volatile MasterOccupationCategoryLocalService _service;

}