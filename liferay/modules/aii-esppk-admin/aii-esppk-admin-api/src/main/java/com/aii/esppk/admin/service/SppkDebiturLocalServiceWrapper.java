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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SppkDebiturLocalService}.
 *
 * @author Gositus
 * @see SppkDebiturLocalService
 * @generated
 */
public class SppkDebiturLocalServiceWrapper
	implements ServiceWrapper<SppkDebiturLocalService>,
			   SppkDebiturLocalService {

	public SppkDebiturLocalServiceWrapper(
		SppkDebiturLocalService sppkDebiturLocalService) {

		_sppkDebiturLocalService = sppkDebiturLocalService;
	}

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
	@Override
	public com.aii.esppk.admin.model.SppkDebitur addSppkDebitur(
		com.aii.esppk.admin.model.SppkDebitur sppkDebitur) {

		return _sppkDebiturLocalService.addSppkDebitur(sppkDebitur);
	}

	@Override
	public com.aii.esppk.admin.model.SppkDebitur addSppkDebitur(
			String fullName, String birthPlace, java.util.Date birthDate,
			String idNumber, String occupation, String email,
			String phoneNumber, String gender, java.math.BigDecimal sumInsured,
			String product, String applicationNumber, String address,
			String submissionNumber)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkDebiturLocalService.addSppkDebitur(
			fullName, birthPlace, birthDate, idNumber, occupation, email,
			phoneNumber, gender, sumInsured, product, applicationNumber,
			address, submissionNumber);
	}

	@Override
	public int countFilterDebitur(
			com.liferay.portal.kernel.json.JSONObject data)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkDebiturLocalService.countFilterDebitur(data);
	}

	@Override
	public int countFilterMonitoring(
			com.liferay.portal.kernel.json.JSONObject data)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkDebiturLocalService.countFilterMonitoring(data);
	}

	@Override
	public int countTotalSppkDebitur() {
		return _sppkDebiturLocalService.countTotalSppkDebitur();
	}

	@Override
	public int countTotalSppkDebiturSubmitted() {
		return _sppkDebiturLocalService.countTotalSppkDebiturSubmitted();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkDebiturLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sppk debitur with the primary key. Does not add the sppk debitur to the database.
	 *
	 * @param sppkDebiturId the primary key for the new sppk debitur
	 * @return the new sppk debitur
	 */
	@Override
	public com.aii.esppk.admin.model.SppkDebitur createSppkDebitur(
		long sppkDebiturId) {

		return _sppkDebiturLocalService.createSppkDebitur(sppkDebiturId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkDebiturLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.aii.esppk.admin.model.SppkDebitur deleteSppkDebitur(
			long sppkDebiturId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkDebiturLocalService.deleteSppkDebitur(sppkDebiturId);
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
	@Override
	public com.aii.esppk.admin.model.SppkDebitur deleteSppkDebitur(
		com.aii.esppk.admin.model.SppkDebitur sppkDebitur) {

		return _sppkDebiturLocalService.deleteSppkDebitur(sppkDebitur);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sppkDebiturLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _sppkDebiturLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _sppkDebiturLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _sppkDebiturLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _sppkDebiturLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _sppkDebiturLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.aii.esppk.admin.model.SppkDebitur fetchSppkDebitur(
		long sppkDebiturId) {

		return _sppkDebiturLocalService.fetchSppkDebitur(sppkDebiturId);
	}

	@Override
	public java.util.List<com.aii.esppk.admin.model.SppkDebitur> filterDebitur(
			com.liferay.portal.kernel.json.JSONObject data, int start, int end,
			com.liferay.portal.kernel.json.JSONArray sortArray)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkDebiturLocalService.filterDebitur(
			data, start, end, sortArray);
	}

	@Override
	public java.util.List<com.aii.esppk.admin.model.SppkDebitur>
			filterMonitoring(
				com.liferay.portal.kernel.json.JSONObject data, int start,
				int end, com.liferay.portal.kernel.json.JSONArray sortArray)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkDebiturLocalService.filterMonitoring(
			data, start, end, sortArray);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _sppkDebiturLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _sppkDebiturLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sppkDebiturLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkDebiturLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sppk debitur with the primary key.
	 *
	 * @param sppkDebiturId the primary key of the sppk debitur
	 * @return the sppk debitur
	 * @throws PortalException if a sppk debitur with the primary key could not be found
	 */
	@Override
	public com.aii.esppk.admin.model.SppkDebitur getSppkDebitur(
			long sppkDebiturId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkDebiturLocalService.getSppkDebitur(sppkDebiturId);
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
	@Override
	public java.util.List<com.aii.esppk.admin.model.SppkDebitur>
		getSppkDebiturs(int start, int end) {

		return _sppkDebiturLocalService.getSppkDebiturs(start, end);
	}

	/**
	 * Returns the number of sppk debiturs.
	 *
	 * @return the number of sppk debiturs
	 */
	@Override
	public int getSppkDebitursCount() {
		return _sppkDebiturLocalService.getSppkDebitursCount();
	}

	@Override
	public com.aii.esppk.admin.model.SppkDebitur updateSppkDebitur(
			long sppkDebiturId, int esppkQ1, int esppkQ2, int esppkQ3,
			int agreeRiplay, int agreeStatement, int needAssistance,
			java.util.Date submitEsppkDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkDebiturLocalService.updateSppkDebitur(
			sppkDebiturId, esppkQ1, esppkQ2, esppkQ3, agreeRiplay,
			agreeStatement, needAssistance, submitEsppkDate);
	}

	@Override
	public com.aii.esppk.admin.model.SppkDebitur updateSppkDebitur(
			long sppkDebiturId, String esppkToken,
			java.util.Date esppkTokenExpiry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkDebiturLocalService.updateSppkDebitur(
			sppkDebiturId, esppkToken, esppkTokenExpiry);
	}

	@Override
	public com.aii.esppk.admin.model.SppkDebitur updateSppkDebitur(
			long sppkDebiturId, String fullName, String birthPlace,
			java.util.Date birthDate, String idNumber, String occupation,
			String email, String phoneNumber, String gender,
			java.math.BigDecimal sumInsured, String product,
			String applicationNumber, String address)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sppkDebiturLocalService.updateSppkDebitur(
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
	@Override
	public com.aii.esppk.admin.model.SppkDebitur updateSppkDebitur(
		com.aii.esppk.admin.model.SppkDebitur sppkDebitur) {

		return _sppkDebiturLocalService.updateSppkDebitur(sppkDebitur);
	}

	@Override
	public SppkDebiturLocalService getWrappedService() {
		return _sppkDebiturLocalService;
	}

	@Override
	public void setWrappedService(
		SppkDebiturLocalService sppkDebiturLocalService) {

		_sppkDebiturLocalService = sppkDebiturLocalService;
	}

	private SppkDebiturLocalService _sppkDebiturLocalService;

}