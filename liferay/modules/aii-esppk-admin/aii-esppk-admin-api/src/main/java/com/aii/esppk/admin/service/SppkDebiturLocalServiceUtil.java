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

package com.aii.esppk.admin.service;

import com.aii.esppk.admin.model.SppkDebitur;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SppkDebitur. This utility wraps
 * <code>com.aii.esppk.admin.service.impl.SppkDebiturLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus
 * @see SppkDebiturLocalService
 * @generated
 */
public class SppkDebiturLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.aii.esppk.admin.service.impl.SppkDebiturLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the sppk debitur to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SppkDebiturLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sppkDebitur the sppk debitur
	 * @return the sppk debitur that was added
	 */
	public static SppkDebitur addSppkDebitur(SppkDebitur sppkDebitur) {
		return getService().addSppkDebitur(sppkDebitur);
	}

	public static SppkDebitur addSppkDebitur(
			String fullName, String birthPlace, java.util.Date birthDate,
			String idNumber, String occupation, String email,
			String phoneNumber, String gender, java.math.BigDecimal sumInsured,
			String product, String applicationNumber, String address,
			String submissionNumber)
		throws PortalException {

		return getService().addSppkDebitur(
			fullName, birthPlace, birthDate, idNumber, occupation, email,
			phoneNumber, gender, sumInsured, product, applicationNumber,
			address, submissionNumber);
	}

	public static int countFilterDebitur(
			com.liferay.portal.kernel.json.JSONObject data)
		throws PortalException {

		return getService().countFilterDebitur(data);
	}

	public static int countFilterMonitoring(
			com.liferay.portal.kernel.json.JSONObject data)
		throws PortalException {

		return getService().countFilterMonitoring(data);
	}

	public static int countTotalSppkDebitur() {
		return getService().countTotalSppkDebitur();
	}

	public static int countTotalSppkDebiturSubmitted() {
		return getService().countTotalSppkDebiturSubmitted();
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
	 * Creates a new sppk debitur with the primary key. Does not add the sppk debitur to the database.
	 *
	 * @param sppkDebiturId the primary key for the new sppk debitur
	 * @return the new sppk debitur
	 */
	public static SppkDebitur createSppkDebitur(long sppkDebiturId) {
		return getService().createSppkDebitur(sppkDebiturId);
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
	 * Deletes the sppk debitur with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SppkDebiturLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sppkDebiturId the primary key of the sppk debitur
	 * @return the sppk debitur that was removed
	 * @throws PortalException if a sppk debitur with the primary key could not be found
	 */
	public static SppkDebitur deleteSppkDebitur(long sppkDebiturId)
		throws PortalException {

		return getService().deleteSppkDebitur(sppkDebiturId);
	}

	/**
	 * Deletes the sppk debitur from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SppkDebiturLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sppkDebitur the sppk debitur
	 * @return the sppk debitur that was removed
	 */
	public static SppkDebitur deleteSppkDebitur(SppkDebitur sppkDebitur) {
		return getService().deleteSppkDebitur(sppkDebitur);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aii.esppk.admin.model.impl.SppkDebiturModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aii.esppk.admin.model.impl.SppkDebiturModelImpl</code>.
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

	public static SppkDebitur fetchSppkDebitur(long sppkDebiturId) {
		return getService().fetchSppkDebitur(sppkDebiturId);
	}

	public static List<SppkDebitur> filterDebitur(
			com.liferay.portal.kernel.json.JSONObject data, int start, int end,
			com.liferay.portal.kernel.json.JSONArray sortArray)
		throws PortalException {

		return getService().filterDebitur(data, start, end, sortArray);
	}

	public static List<SppkDebitur> filterMonitoring(
			com.liferay.portal.kernel.json.JSONObject data, int start, int end,
			com.liferay.portal.kernel.json.JSONArray sortArray)
		throws PortalException {

		return getService().filterMonitoring(data, start, end, sortArray);
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
	 * Returns the sppk debitur with the primary key.
	 *
	 * @param sppkDebiturId the primary key of the sppk debitur
	 * @return the sppk debitur
	 * @throws PortalException if a sppk debitur with the primary key could not be found
	 */
	public static SppkDebitur getSppkDebitur(long sppkDebiturId)
		throws PortalException {

		return getService().getSppkDebitur(sppkDebiturId);
	}

	/**
	 * Returns a range of all the sppk debiturs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.aii.esppk.admin.model.impl.SppkDebiturModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sppk debiturs
	 * @param end the upper bound of the range of sppk debiturs (not inclusive)
	 * @return the range of sppk debiturs
	 */
	public static List<SppkDebitur> getSppkDebiturs(int start, int end) {
		return getService().getSppkDebiturs(start, end);
	}

	/**
	 * Returns the number of sppk debiturs.
	 *
	 * @return the number of sppk debiturs
	 */
	public static int getSppkDebitursCount() {
		return getService().getSppkDebitursCount();
	}

	public static SppkDebitur updateSppkDebitur(
			long sppkDebiturId, int esppkQ1, int esppkQ2, int esppkQ3,
			int agreeRiplay, int agreeStatement, int needAssistance,
			java.util.Date submitEsppkDate)
		throws PortalException {

		return getService().updateSppkDebitur(
			sppkDebiturId, esppkQ1, esppkQ2, esppkQ3, agreeRiplay,
			agreeStatement, needAssistance, submitEsppkDate);
	}

	public static SppkDebitur updateSppkDebitur(
			long sppkDebiturId, String esppkToken,
			java.util.Date esppkTokenExpiry)
		throws PortalException {

		return getService().updateSppkDebitur(
			sppkDebiturId, esppkToken, esppkTokenExpiry);
	}

	public static SppkDebitur updateSppkDebitur(
			long sppkDebiturId, String fullName, String birthPlace,
			java.util.Date birthDate, String idNumber, String occupation,
			String email, String phoneNumber, String gender,
			java.math.BigDecimal sumInsured, String product,
			String applicationNumber, String address)
		throws PortalException {

		return getService().updateSppkDebitur(
			sppkDebiturId, fullName, birthPlace, birthDate, idNumber,
			occupation, email, phoneNumber, gender, sumInsured, product,
			applicationNumber, address);
	}

	/**
	 * Updates the sppk debitur in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SppkDebiturLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sppkDebitur the sppk debitur
	 * @return the sppk debitur that was updated
	 */
	public static SppkDebitur updateSppkDebitur(SppkDebitur sppkDebitur) {
		return getService().updateSppkDebitur(sppkDebitur);
	}

	public static SppkDebiturLocalService getService() {
		return _service;
	}

	private static volatile SppkDebiturLocalService _service;

}