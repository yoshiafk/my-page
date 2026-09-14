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

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SppkDebitur. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Gositus
 * @see SppkDebiturLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SppkDebiturLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.aii.esppk.admin.service.impl.SppkDebiturLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the sppk debitur local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SppkDebiturLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public SppkDebitur addSppkDebitur(SppkDebitur sppkDebitur);

	public SppkDebitur addSppkDebitur(
			String fullName, String birthPlace, Date birthDate, String idNumber,
			String occupation, String email, String phoneNumber, String gender,
			BigDecimal sumInsured, String product, String applicationNumber,
			String address, String submissionNumber)
		throws PortalException;

	public int countFilterDebitur(JSONObject data) throws PortalException;

	public int countFilterMonitoring(JSONObject data) throws PortalException;

	public int countTotalSppkDebitur();

	public int countTotalSppkDebiturSubmitted();

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new sppk debitur with the primary key. Does not add the sppk debitur to the database.
	 *
	 * @param sppkDebiturId the primary key for the new sppk debitur
	 * @return the new sppk debitur
	 */
	@Transactional(enabled = false)
	public SppkDebitur createSppkDebitur(long sppkDebiturId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public SppkDebitur deleteSppkDebitur(long sppkDebiturId)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public SppkDebitur deleteSppkDebitur(SppkDebitur sppkDebitur);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SppkDebitur fetchSppkDebitur(long sppkDebiturId);

	public List<SppkDebitur> filterDebitur(
			JSONObject data, int start, int end, JSONArray sortArray)
		throws PortalException;

	public List<SppkDebitur> filterMonitoring(
			JSONObject data, int start, int end, JSONArray sortArray)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the sppk debitur with the primary key.
	 *
	 * @param sppkDebiturId the primary key of the sppk debitur
	 * @return the sppk debitur
	 * @throws PortalException if a sppk debitur with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SppkDebitur getSppkDebitur(long sppkDebiturId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SppkDebitur> getSppkDebiturs(int start, int end);

	/**
	 * Returns the number of sppk debiturs.
	 *
	 * @return the number of sppk debiturs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSppkDebitursCount();

	public SppkDebitur updateSppkDebitur(
			long sppkDebiturId, int esppkQ1, int esppkQ2, int esppkQ3,
			int agreeRiplay, int agreeStatement, int needAssistance,
			Date submitEsppkDate)
		throws PortalException;

	public SppkDebitur updateSppkDebitur(
			long sppkDebiturId, String esppkToken, Date esppkTokenExpiry)
		throws PortalException;

	public SppkDebitur updateSppkDebitur(
			long sppkDebiturId, String fullName, String birthPlace,
			Date birthDate, String idNumber, String occupation, String email,
			String phoneNumber, String gender, BigDecimal sumInsured,
			String product, String applicationNumber, String address)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public SppkDebitur updateSppkDebitur(SppkDebitur sppkDebitur);

}