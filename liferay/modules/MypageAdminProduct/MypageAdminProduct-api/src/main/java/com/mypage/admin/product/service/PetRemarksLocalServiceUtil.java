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

import com.mypage.admin.product.model.PetRemarks;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PetRemarks. This utility wraps
 * <code>com.mypage.admin.product.service.impl.PetRemarksLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see PetRemarksLocalService
 * @generated
 */
public class PetRemarksLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.PetRemarksLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the pet remarks to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetRemarksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petRemarks the pet remarks
	 * @return the pet remarks that was added
	 */
	public static PetRemarks addPetRemarks(PetRemarks petRemarks) {
		return getService().addPetRemarks(petRemarks);
	}

	/**
	 * Add New Pet Remarks
	 *
	 * @param name
	 * @param code
	 * @return
	 * @throws PortalException
	 */
	public static PetRemarks addPetRemarks(String name, String code, int active)
		throws PortalException {

		return getService().addPetRemarks(name, code, active);
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
	 * Creates a new pet remarks with the primary key. Does not add the pet remarks to the database.
	 *
	 * @param petRemarksId the primary key for the new pet remarks
	 * @return the new pet remarks
	 */
	public static PetRemarks createPetRemarks(long petRemarksId) {
		return getService().createPetRemarks(petRemarksId);
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
	 * Deletes the pet remarks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetRemarksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petRemarksId the primary key of the pet remarks
	 * @return the pet remarks that was removed
	 * @throws PortalException if a pet remarks with the primary key could not be found
	 */
	public static PetRemarks deletePetRemarks(long petRemarksId)
		throws PortalException {

		return getService().deletePetRemarks(petRemarksId);
	}

	/**
	 * Deletes the pet remarks from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetRemarksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petRemarks the pet remarks
	 * @return the pet remarks that was removed
	 */
	public static PetRemarks deletePetRemarks(PetRemarks petRemarks) {
		return getService().deletePetRemarks(petRemarks);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetRemarksModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetRemarksModelImpl</code>.
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

	public static PetRemarks fetchPetRemarks(long petRemarksId) {
		return getService().fetchPetRemarks(petRemarksId);
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

	public static List<PetRemarks> getPetRemarks() {
		return getService().getPetRemarks();
	}

	/**
	 * Get Remarks List
	 */
	public static List<PetRemarks> getPetRemarks(int start, int end) {
		return getService().getPetRemarks(start, end);
	}

	/**
	 * Returns the pet remarks with the primary key.
	 *
	 * @param petRemarksId the primary key of the pet remarks
	 * @return the pet remarks
	 * @throws PortalException if a pet remarks with the primary key could not be found
	 */
	public static PetRemarks getPetRemarks(long petRemarksId)
		throws PortalException {

		return getService().getPetRemarks(petRemarksId);
	}

	/**
	 * Get Remarks Count
	 */
	public static int getPetRemarksCount() {
		return getService().getPetRemarksCount();
	}

	/**
	 * Returns a range of all the pet remarkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetRemarksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet remarkses
	 * @param end the upper bound of the range of pet remarkses (not inclusive)
	 * @return the range of pet remarkses
	 */
	public static List<PetRemarks> getPetRemarkses(int start, int end) {
		return getService().getPetRemarkses(start, end);
	}

	/**
	 * Returns the number of pet remarkses.
	 *
	 * @return the number of pet remarkses
	 */
	public static int getPetRemarksesCount() {
		return getService().getPetRemarksesCount();
	}

	public static PetRemarks setActive(
			long userId, long petRemarksId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			userId, petRemarksId, active, serviceContext);
	}

	/**
	 * Update Pet Remarks
	 *
	 * @param petRemarksId
	 * @param name
	 * @param code
	 * @return
	 * @throws PortalException
	 */
	public static PetRemarks updatePetRemarks(
			long petRemarksId, String name, String code, int active)
		throws PortalException {

		return getService().updatePetRemarks(petRemarksId, name, code, active);
	}

	/**
	 * Updates the pet remarks in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetRemarksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petRemarks the pet remarks
	 * @return the pet remarks that was updated
	 */
	public static PetRemarks updatePetRemarks(PetRemarks petRemarks) {
		return getService().updatePetRemarks(petRemarks);
	}

	public static PetRemarksLocalService getService() {
		return _service;
	}

	private static volatile PetRemarksLocalService _service;

}