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

import com.mypage.admin.product.model.SmartHealthPremi;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SmartHealthPremi. This utility wraps
 * <code>com.mypage.admin.product.service.impl.SmartHealthPremiLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see SmartHealthPremiLocalService
 * @generated
 */
public class SmartHealthPremiLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.SmartHealthPremiLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Add Premi
	 */
	public static SmartHealthPremi addSmartHealthPremi(
			int age, String gender, String currency, double amount, long planId,
			int status)
		throws PortalException {

		return getService().addSmartHealthPremi(
			age, gender, currency, amount, planId, status);
	}

	/**
	 * Adds the smart health premi to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthPremi the smart health premi
	 * @return the smart health premi that was added
	 */
	public static SmartHealthPremi addSmartHealthPremi(
		SmartHealthPremi smartHealthPremi) {

		return getService().addSmartHealthPremi(smartHealthPremi);
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
	 * Creates a new smart health premi with the primary key. Does not add the smart health premi to the database.
	 *
	 * @param smartHealthPremiId the primary key for the new smart health premi
	 * @return the new smart health premi
	 */
	public static SmartHealthPremi createSmartHealthPremi(
		long smartHealthPremiId) {

		return getService().createSmartHealthPremi(smartHealthPremiId);
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
	 * Deletes the smart health premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthPremiId the primary key of the smart health premi
	 * @return the smart health premi that was removed
	 * @throws PortalException if a smart health premi with the primary key could not be found
	 */
	public static SmartHealthPremi deleteSmartHealthPremi(
			long smartHealthPremiId)
		throws PortalException {

		return getService().deleteSmartHealthPremi(smartHealthPremiId);
	}

	/**
	 * Deletes the smart health premi from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthPremi the smart health premi
	 * @return the smart health premi that was removed
	 */
	public static SmartHealthPremi deleteSmartHealthPremi(
		SmartHealthPremi smartHealthPremi) {

		return getService().deleteSmartHealthPremi(smartHealthPremi);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthPremiModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthPremiModelImpl</code>.
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

	public static SmartHealthPremi fetchSmartHealthPremi(
		long smartHealthPremiId) {

		return getService().fetchSmartHealthPremi(smartHealthPremiId);
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
	 * Returns the smart health premi with the primary key.
	 *
	 * @param smartHealthPremiId the primary key of the smart health premi
	 * @return the smart health premi
	 * @throws PortalException if a smart health premi with the primary key could not be found
	 */
	public static SmartHealthPremi getSmartHealthPremi(long smartHealthPremiId)
		throws PortalException {

		return getService().getSmartHealthPremi(smartHealthPremiId);
	}

	public static int getSmartHealthPremiCount() {
		return getService().getSmartHealthPremiCount();
	}

	/**
	 * Returns a range of all the smart health premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health premis
	 * @param end the upper bound of the range of smart health premis (not inclusive)
	 * @return the range of smart health premis
	 */
	public static List<SmartHealthPremi> getSmartHealthPremis(
		int start, int end) {

		return getService().getSmartHealthPremis(start, end);
	}

	/**
	 * Returns the number of smart health premis.
	 *
	 * @return the number of smart health premis
	 */
	public static int getSmartHealthPremisCount() {
		return getService().getSmartHealthPremisCount();
	}

	public static SmartHealthPremi setActive(
			long smartHealthPremiId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			smartHealthPremiId, status, serviceContext);
	}

	/**
	 * Update Premi
	 */
	public static SmartHealthPremi updateSmartHealthPremi(
			long smartHealthPremiId, int age, String gender, String currency,
			double amount, long planId, int status)
		throws PortalException {

		return getService().updateSmartHealthPremi(
			smartHealthPremiId, age, gender, currency, amount, planId, status);
	}

	/**
	 * Updates the smart health premi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthPremi the smart health premi
	 * @return the smart health premi that was updated
	 */
	public static SmartHealthPremi updateSmartHealthPremi(
		SmartHealthPremi smartHealthPremi) {

		return getService().updateSmartHealthPremi(smartHealthPremi);
	}

	public static SmartHealthPremiLocalService getService() {
		return _service;
	}

	private static volatile SmartHealthPremiLocalService _service;

}