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

import com.mypage.admin.product.model.StiPremi;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for StiPremi. This utility wraps
 * <code>com.mypage.admin.product.service.impl.StiPremiLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see StiPremiLocalService
 * @generated
 */
public class StiPremiLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.StiPremiLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the sti premi to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stiPremi the sti premi
	 * @return the sti premi that was added
	 */
	public static StiPremi addStiPremi(StiPremi stiPremi) {
		return getService().addStiPremi(stiPremi);
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
	 * Creates a new sti premi with the primary key. Does not add the sti premi to the database.
	 *
	 * @param premiId the primary key for the new sti premi
	 * @return the new sti premi
	 */
	public static StiPremi createStiPremi(long premiId) {
		return getService().createStiPremi(premiId);
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
	 * Deletes the sti premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param premiId the primary key of the sti premi
	 * @return the sti premi that was removed
	 * @throws PortalException if a sti premi with the primary key could not be found
	 */
	public static StiPremi deleteStiPremi(long premiId) throws PortalException {
		return getService().deleteStiPremi(premiId);
	}

	/**
	 * Deletes the sti premi from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stiPremi the sti premi
	 * @return the sti premi that was removed
	 */
	public static StiPremi deleteStiPremi(StiPremi stiPremi) {
		return getService().deleteStiPremi(stiPremi);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.StiPremiModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.StiPremiModelImpl</code>.
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

	public static StiPremi fetchStiPremi(long premiId) {
		return getService().fetchStiPremi(premiId);
	}

	public static List<StiPremi> findByCurrencyAndTravellerType(
		String currency, String travellerType) {

		return getService().findByCurrencyAndTravellerType(
			currency, travellerType);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<StiPremi> getActivePremi() {
		return getService().getActivePremi();
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

	public static int getPremiCount() {
		return getService().getPremiCount();
	}

	public static List<StiPremi> getPremis() {
		return getService().getPremis();
	}

	public static List<StiPremi> getPremis(int start, int end) {
		return getService().getPremis(start, end);
	}

	/**
	 * Returns the sti premi with the primary key.
	 *
	 * @param premiId the primary key of the sti premi
	 * @return the sti premi
	 * @throws PortalException if a sti premi with the primary key could not be found
	 */
	public static StiPremi getStiPremi(long premiId) throws PortalException {
		return getService().getStiPremi(premiId);
	}

	/**
	 * Returns a range of all the sti premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.StiPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti premis
	 * @param end the upper bound of the range of sti premis (not inclusive)
	 * @return the range of sti premis
	 */
	public static List<StiPremi> getStiPremis(int start, int end) {
		return getService().getStiPremis(start, end);
	}

	/**
	 * Returns the number of sti premis.
	 *
	 * @return the number of sti premis
	 */
	public static int getStiPremisCount() {
		return getService().getStiPremisCount();
	}

	public static StiPremi setActive(
		long premiId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().setActive(premiId, active, serviceContext);
	}

	/**
	 * Updates the sti premi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StiPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stiPremi the sti premi
	 * @return the sti premi that was updated
	 */
	public static StiPremi updateStiPremi(StiPremi stiPremi) {
		return getService().updateStiPremi(stiPremi);
	}

	public static StiPremiLocalService getService() {
		return _service;
	}

	private static volatile StiPremiLocalService _service;

}