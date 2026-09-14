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

import com.mypage.admin.product.model.IntTravelStandardNewPremi;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for IntTravelStandardNewPremi. This utility wraps
 * <code>com.mypage.admin.product.service.impl.IntTravelStandardNewPremiLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see IntTravelStandardNewPremiLocalService
 * @generated
 */
public class IntTravelStandardNewPremiLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.IntTravelStandardNewPremiLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the int travel standard new premi to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IntTravelStandardNewPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param intTravelStandardNewPremi the int travel standard new premi
	 * @return the int travel standard new premi that was added
	 */
	public static IntTravelStandardNewPremi addIntTravelStandardNewPremi(
		IntTravelStandardNewPremi intTravelStandardNewPremi) {

		return getService().addIntTravelStandardNewPremi(
			intTravelStandardNewPremi);
	}

	public static IntTravelStandardNewPremi addIntTravelStandardNewPremi(
			String travelType, String packageType, String peopleType,
			int mainInsured, int spouse, int child, String currency,
			java.math.BigDecimal amount, java.math.BigDecimal additionalPrice,
			int active)
		throws PortalException {

		return getService().addIntTravelStandardNewPremi(
			travelType, packageType, peopleType, mainInsured, spouse, child,
			currency, amount, additionalPrice, active);
	}

	/**
	 * Creates a new int travel standard new premi with the primary key. Does not add the int travel standard new premi to the database.
	 *
	 * @param intTravelStandardNewPremiId the primary key for the new int travel standard new premi
	 * @return the new int travel standard new premi
	 */
	public static IntTravelStandardNewPremi createIntTravelStandardNewPremi(
		long intTravelStandardNewPremiId) {

		return getService().createIntTravelStandardNewPremi(
			intTravelStandardNewPremiId);
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
	 * Deletes the int travel standard new premi from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IntTravelStandardNewPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param intTravelStandardNewPremi the int travel standard new premi
	 * @return the int travel standard new premi that was removed
	 */
	public static IntTravelStandardNewPremi deleteIntTravelStandardNewPremi(
		IntTravelStandardNewPremi intTravelStandardNewPremi) {

		return getService().deleteIntTravelStandardNewPremi(
			intTravelStandardNewPremi);
	}

	/**
	 * Deletes the int travel standard new premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IntTravelStandardNewPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param intTravelStandardNewPremiId the primary key of the int travel standard new premi
	 * @return the int travel standard new premi that was removed
	 * @throws PortalException if a int travel standard new premi with the primary key could not be found
	 */
	public static IntTravelStandardNewPremi deleteIntTravelStandardNewPremi(
			long intTravelStandardNewPremiId)
		throws PortalException {

		return getService().deleteIntTravelStandardNewPremi(
			intTravelStandardNewPremiId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.IntTravelStandardNewPremiModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.IntTravelStandardNewPremiModelImpl</code>.
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

	public static IntTravelStandardNewPremi fetchIntTravelStandardNewPremi(
		long intTravelStandardNewPremiId) {

		return getService().fetchIntTravelStandardNewPremi(
			intTravelStandardNewPremiId);
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
	 * Returns the int travel standard new premi with the primary key.
	 *
	 * @param intTravelStandardNewPremiId the primary key of the int travel standard new premi
	 * @return the int travel standard new premi
	 * @throws PortalException if a int travel standard new premi with the primary key could not be found
	 */
	public static IntTravelStandardNewPremi getIntTravelStandardNewPremi(
			long intTravelStandardNewPremiId)
		throws PortalException {

		return getService().getIntTravelStandardNewPremi(
			intTravelStandardNewPremiId);
	}

	/**
	 * Returns a range of all the int travel standard new premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.IntTravelStandardNewPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of int travel standard new premis
	 * @param end the upper bound of the range of int travel standard new premis (not inclusive)
	 * @return the range of int travel standard new premis
	 */
	public static List<IntTravelStandardNewPremi> getIntTravelStandardNewPremis(
		int start, int end) {

		return getService().getIntTravelStandardNewPremis(start, end);
	}

	/**
	 * Returns the number of int travel standard new premis.
	 *
	 * @return the number of int travel standard new premis
	 */
	public static int getIntTravelStandardNewPremisCount() {
		return getService().getIntTravelStandardNewPremisCount();
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

	public static List<IntTravelStandardNewPremi> getPremis() {
		return getService().getPremis();
	}

	public static List<IntTravelStandardNewPremi> getPremis(
		int start, int end) {

		return getService().getPremis(start, end);
	}

	public static int getPremisCount() {
		return getService().getPremisCount();
	}

	public static IntTravelStandardNewPremi searchSpesificPremi(
		String travelType, String packageType, String peopleType,
		String currency, int mainInsured, int spouse, int child) {

		return getService().searchSpesificPremi(
			travelType, packageType, peopleType, currency, mainInsured, spouse,
			child);
	}

	public static IntTravelStandardNewPremi setActive(
			long intTravelStandardNewPremiId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			intTravelStandardNewPremiId, active, serviceContext);
	}

	/**
	 * Updates the int travel standard new premi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IntTravelStandardNewPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param intTravelStandardNewPremi the int travel standard new premi
	 * @return the int travel standard new premi that was updated
	 */
	public static IntTravelStandardNewPremi updateIntTravelStandardNewPremi(
		IntTravelStandardNewPremi intTravelStandardNewPremi) {

		return getService().updateIntTravelStandardNewPremi(
			intTravelStandardNewPremi);
	}

	public static IntTravelStandardNewPremi updateIntTravelStandardNewPremi(
			long intTravelStandardNewPremiId, String travelType,
			String packageType, String peopleType, int mainInsured, int spouse,
			int child, String currency, java.math.BigDecimal amount,
			java.math.BigDecimal additionalPrice, int active)
		throws PortalException {

		return getService().updateIntTravelStandardNewPremi(
			intTravelStandardNewPremiId, travelType, packageType, peopleType,
			mainInsured, spouse, child, currency, amount, additionalPrice,
			active);
	}

	public static IntTravelStandardNewPremiLocalService getService() {
		return _service;
	}

	private static volatile IntTravelStandardNewPremiLocalService _service;

}