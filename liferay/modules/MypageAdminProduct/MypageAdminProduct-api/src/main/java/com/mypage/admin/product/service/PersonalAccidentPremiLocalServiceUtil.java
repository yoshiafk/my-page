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

import com.mypage.admin.product.model.PersonalAccidentPremi;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PersonalAccidentPremi. This utility wraps
 * <code>com.mypage.admin.product.service.impl.PersonalAccidentPremiLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see PersonalAccidentPremiLocalService
 * @generated
 */
public class PersonalAccidentPremiLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.PersonalAccidentPremiLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the personal accident premi to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonalAccidentPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personalAccidentPremi the personal accident premi
	 * @return the personal accident premi that was added
	 */
	public static PersonalAccidentPremi addPersonalAccidentPremi(
		PersonalAccidentPremi personalAccidentPremi) {

		return getService().addPersonalAccidentPremi(personalAccidentPremi);
	}

	/**
	 * Add Premi
	 */
	public static PersonalAccidentPremi addPersonalAccidentPremi(
			String type, double amount, int active)
		throws PortalException {

		return getService().addPersonalAccidentPremi(type, amount, active);
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
	 * Creates a new personal accident premi with the primary key. Does not add the personal accident premi to the database.
	 *
	 * @param personalAccidentPremiId the primary key for the new personal accident premi
	 * @return the new personal accident premi
	 */
	public static PersonalAccidentPremi createPersonalAccidentPremi(
		long personalAccidentPremiId) {

		return getService().createPersonalAccidentPremi(
			personalAccidentPremiId);
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
	 * Deletes the personal accident premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonalAccidentPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personalAccidentPremiId the primary key of the personal accident premi
	 * @return the personal accident premi that was removed
	 * @throws PortalException if a personal accident premi with the primary key could not be found
	 */
	public static PersonalAccidentPremi deletePersonalAccidentPremi(
			long personalAccidentPremiId)
		throws PortalException {

		return getService().deletePersonalAccidentPremi(
			personalAccidentPremiId);
	}

	/**
	 * Deletes the personal accident premi from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonalAccidentPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personalAccidentPremi the personal accident premi
	 * @return the personal accident premi that was removed
	 */
	public static PersonalAccidentPremi deletePersonalAccidentPremi(
		PersonalAccidentPremi personalAccidentPremi) {

		return getService().deletePersonalAccidentPremi(personalAccidentPremi);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PersonalAccidentPremiModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PersonalAccidentPremiModelImpl</code>.
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

	public static PersonalAccidentPremi fetchPersonalAccidentPremi(
		long personalAccidentPremiId) {

		return getService().fetchPersonalAccidentPremi(personalAccidentPremiId);
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
	 * Returns the personal accident premi with the primary key.
	 *
	 * @param personalAccidentPremiId the primary key of the personal accident premi
	 * @return the personal accident premi
	 * @throws PortalException if a personal accident premi with the primary key could not be found
	 */
	public static PersonalAccidentPremi getPersonalAccidentPremi(
			long personalAccidentPremiId)
		throws PortalException {

		return getService().getPersonalAccidentPremi(personalAccidentPremiId);
	}

	public static int getPersonalAccidentPremiCount() {
		return getService().getPersonalAccidentPremiCount();
	}

	/**
	 * Returns a range of all the personal accident premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PersonalAccidentPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal accident premis
	 * @param end the upper bound of the range of personal accident premis (not inclusive)
	 * @return the range of personal accident premis
	 */
	public static List<PersonalAccidentPremi> getPersonalAccidentPremis(
		int start, int end) {

		return getService().getPersonalAccidentPremis(start, end);
	}

	/**
	 * Returns the number of personal accident premis.
	 *
	 * @return the number of personal accident premis
	 */
	public static int getPersonalAccidentPremisCount() {
		return getService().getPersonalAccidentPremisCount();
	}

	public static PersonalAccidentPremi setActive(
			long personalAccidentPremiId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			personalAccidentPremiId, active, serviceContext);
	}

	/**
	 * Update Premi
	 */
	public static PersonalAccidentPremi updatePersonalAccidentPremi(
			long personalAccidentPremiId, String type, double amount,
			int active)
		throws PortalException {

		return getService().updatePersonalAccidentPremi(
			personalAccidentPremiId, type, amount, active);
	}

	/**
	 * Updates the personal accident premi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonalAccidentPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personalAccidentPremi the personal accident premi
	 * @return the personal accident premi that was updated
	 */
	public static PersonalAccidentPremi updatePersonalAccidentPremi(
		PersonalAccidentPremi personalAccidentPremi) {

		return getService().updatePersonalAccidentPremi(personalAccidentPremi);
	}

	public static PersonalAccidentPremiLocalService getService() {
		return _service;
	}

	private static volatile PersonalAccidentPremiLocalService _service;

}