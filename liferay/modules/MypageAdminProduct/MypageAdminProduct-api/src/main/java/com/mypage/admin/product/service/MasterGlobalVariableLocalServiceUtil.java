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

import com.mypage.admin.product.model.MasterGlobalVariable;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for MasterGlobalVariable. This utility wraps
 * <code>com.mypage.admin.product.service.impl.MasterGlobalVariableLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see MasterGlobalVariableLocalService
 * @generated
 */
public class MasterGlobalVariableLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.MasterGlobalVariableLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the master global variable to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterGlobalVariableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterGlobalVariable the master global variable
	 * @return the master global variable that was added
	 */
	public static MasterGlobalVariable addMasterGlobalVariable(
		MasterGlobalVariable masterGlobalVariable) {

		return getService().addMasterGlobalVariable(masterGlobalVariable);
	}

	public static MasterGlobalVariable addMasterGlobalVariable(
			String group, String name, String value, String imageURL,
			long imageFileEntryId, int active)
		throws PortalException {

		return getService().addMasterGlobalVariable(
			group, name, value, imageURL, imageFileEntryId, active);
	}

	/**
	 * Creates a new master global variable with the primary key. Does not add the master global variable to the database.
	 *
	 * @param masterGlobalVariableId the primary key for the new master global variable
	 * @return the new master global variable
	 */
	public static MasterGlobalVariable createMasterGlobalVariable(
		long masterGlobalVariableId) {

		return getService().createMasterGlobalVariable(masterGlobalVariableId);
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
	 * Deletes the master global variable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterGlobalVariableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterGlobalVariableId the primary key of the master global variable
	 * @return the master global variable that was removed
	 * @throws PortalException if a master global variable with the primary key could not be found
	 */
	public static MasterGlobalVariable deleteMasterGlobalVariable(
			long masterGlobalVariableId)
		throws PortalException {

		return getService().deleteMasterGlobalVariable(masterGlobalVariableId);
	}

	/**
	 * Deletes the master global variable from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterGlobalVariableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterGlobalVariable the master global variable
	 * @return the master global variable that was removed
	 */
	public static MasterGlobalVariable deleteMasterGlobalVariable(
		MasterGlobalVariable masterGlobalVariable) {

		return getService().deleteMasterGlobalVariable(masterGlobalVariable);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterGlobalVariableModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterGlobalVariableModelImpl</code>.
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

	public static MasterGlobalVariable fetchMasterGlobalVariable(
		long masterGlobalVariableId) {

		return getService().fetchMasterGlobalVariable(masterGlobalVariableId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<MasterGlobalVariable> getActiveGlobalVariableByGroup(
		String groupName) {

		return getService().getActiveGlobalVariableByGroup(groupName);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the master global variable with the primary key.
	 *
	 * @param masterGlobalVariableId the primary key of the master global variable
	 * @return the master global variable
	 * @throws PortalException if a master global variable with the primary key could not be found
	 */
	public static MasterGlobalVariable getMasterGlobalVariable(
			long masterGlobalVariableId)
		throws PortalException {

		return getService().getMasterGlobalVariable(masterGlobalVariableId);
	}

	/**
	 * Returns a range of all the master global variables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.MasterGlobalVariableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master global variables
	 * @param end the upper bound of the range of master global variables (not inclusive)
	 * @return the range of master global variables
	 */
	public static List<MasterGlobalVariable> getMasterGlobalVariables(
		int start, int end) {

		return getService().getMasterGlobalVariables(start, end);
	}

	/**
	 * Returns the number of master global variables.
	 *
	 * @return the number of master global variables
	 */
	public static int getMasterGlobalVariablesCount() {
		return getService().getMasterGlobalVariablesCount();
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

	public static MasterGlobalVariable setActive(
			long masterGlobalVariableId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			masterGlobalVariableId, active, serviceContext);
	}

	public static MasterGlobalVariable updateMasterGlobalVariable(
			long masterGlobalVariableId, String group, String name,
			String value, String imageURL, long imageFileEntryId, int active)
		throws PortalException {

		return getService().updateMasterGlobalVariable(
			masterGlobalVariableId, group, name, value, imageURL,
			imageFileEntryId, active);
	}

	/**
	 * Updates the master global variable in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MasterGlobalVariableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param masterGlobalVariable the master global variable
	 * @return the master global variable that was updated
	 */
	public static MasterGlobalVariable updateMasterGlobalVariable(
		MasterGlobalVariable masterGlobalVariable) {

		return getService().updateMasterGlobalVariable(masterGlobalVariable);
	}

	public static MasterGlobalVariableLocalService getService() {
		return _service;
	}

	private static volatile MasterGlobalVariableLocalService _service;

}