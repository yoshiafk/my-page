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

import com.mypage.admin.product.model.SmartActiveOccupation;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SmartActiveOccupation. This utility wraps
 * <code>com.mypage.admin.product.service.impl.SmartActiveOccupationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see SmartActiveOccupationLocalService
 * @generated
 */
public class SmartActiveOccupationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.SmartActiveOccupationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SmartActiveOccupation addOccupation(
			String code, String nameId, String nameEn, long classRateId,
			int active)
		throws PortalException {

		return getService().addOccupation(
			code, nameId, nameEn, classRateId, active);
	}

	/**
	 * Adds the smart active occupation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveOccupationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveOccupation the smart active occupation
	 * @return the smart active occupation that was added
	 */
	public static SmartActiveOccupation addSmartActiveOccupation(
		SmartActiveOccupation smartActiveOccupation) {

		return getService().addSmartActiveOccupation(smartActiveOccupation);
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
	 * Creates a new smart active occupation with the primary key. Does not add the smart active occupation to the database.
	 *
	 * @param smartActiveOccupationId the primary key for the new smart active occupation
	 * @return the new smart active occupation
	 */
	public static SmartActiveOccupation createSmartActiveOccupation(
		long smartActiveOccupationId) {

		return getService().createSmartActiveOccupation(
			smartActiveOccupationId);
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
	 * Deletes the smart active occupation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveOccupationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveOccupationId the primary key of the smart active occupation
	 * @return the smart active occupation that was removed
	 * @throws PortalException if a smart active occupation with the primary key could not be found
	 */
	public static SmartActiveOccupation deleteSmartActiveOccupation(
			long smartActiveOccupationId)
		throws PortalException {

		return getService().deleteSmartActiveOccupation(
			smartActiveOccupationId);
	}

	/**
	 * Deletes the smart active occupation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveOccupationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveOccupation the smart active occupation
	 * @return the smart active occupation that was removed
	 */
	public static SmartActiveOccupation deleteSmartActiveOccupation(
		SmartActiveOccupation smartActiveOccupation) {

		return getService().deleteSmartActiveOccupation(smartActiveOccupation);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveOccupationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveOccupationModelImpl</code>.
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

	public static SmartActiveOccupation fetchSmartActiveOccupation(
		long smartActiveOccupationId) {

		return getService().fetchSmartActiveOccupation(smartActiveOccupationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<SmartActiveOccupation> getActiveOccupation() {
		return getService().getActiveOccupation();
	}

	public static SmartActiveOccupation getByCode(String code) {
		return getService().getByCode(code);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<SmartActiveOccupation> getOccupationByClassRate(
		long typeId) {

		return getService().getOccupationByClassRate(typeId);
	}

	public static int getOccupationCount() {
		return getService().getOccupationCount();
	}

	public static List<SmartActiveOccupation> getOccupations() {
		return getService().getOccupations();
	}

	public static List<SmartActiveOccupation> getOccupations(
		int start, int end) {

		return getService().getOccupations(start, end);
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
	 * Returns the smart active occupation with the primary key.
	 *
	 * @param smartActiveOccupationId the primary key of the smart active occupation
	 * @return the smart active occupation
	 * @throws PortalException if a smart active occupation with the primary key could not be found
	 */
	public static SmartActiveOccupation getSmartActiveOccupation(
			long smartActiveOccupationId)
		throws PortalException {

		return getService().getSmartActiveOccupation(smartActiveOccupationId);
	}

	/**
	 * Returns a range of all the smart active occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active occupations
	 * @param end the upper bound of the range of smart active occupations (not inclusive)
	 * @return the range of smart active occupations
	 */
	public static List<SmartActiveOccupation> getSmartActiveOccupations(
		int start, int end) {

		return getService().getSmartActiveOccupations(start, end);
	}

	/**
	 * Returns the number of smart active occupations.
	 *
	 * @return the number of smart active occupations
	 */
	public static int getSmartActiveOccupationsCount() {
		return getService().getSmartActiveOccupationsCount();
	}

	public static SmartActiveOccupation setActive(
			long occupationId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(occupationId, active, serviceContext);
	}

	public static SmartActiveOccupation updateOccupation(
			long occupationId, String code, String nameId, String nameEn,
			long classRateId, int active)
		throws PortalException {

		return getService().updateOccupation(
			occupationId, code, nameId, nameEn, classRateId, active);
	}

	/**
	 * Updates the smart active occupation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveOccupationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveOccupation the smart active occupation
	 * @return the smart active occupation that was updated
	 */
	public static SmartActiveOccupation updateSmartActiveOccupation(
		SmartActiveOccupation smartActiveOccupation) {

		return getService().updateSmartActiveOccupation(smartActiveOccupation);
	}

	public static SmartActiveOccupationLocalService getService() {
		return _service;
	}

	private static volatile SmartActiveOccupationLocalService _service;

}