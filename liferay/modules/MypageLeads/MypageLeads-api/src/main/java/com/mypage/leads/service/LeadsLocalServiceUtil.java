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

package com.mypage.leads.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.leads.model.Leads;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Leads. This utility wraps
 * <code>com.mypage.leads.service.impl.LeadsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus
 * @see LeadsLocalService
 * @generated
 */
public class LeadsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.leads.service.impl.LeadsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the leads to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leads the leads
	 * @return the leads that was added
	 */
	public static Leads addLeads(Leads leads) {
		return getService().addLeads(leads);
	}

	public static Leads addLeads(
		long userId, long LeadsId,
		com.liferay.portal.kernel.json.JSONObject data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addLeads(userId, LeadsId, data, serviceContext);
	}

	/**
	 * Creates a new leads with the primary key. Does not add the leads to the database.
	 *
	 * @param LeadsId the primary key for the new leads
	 * @return the new leads
	 */
	public static Leads createLeads(long LeadsId) {
		return getService().createLeads(LeadsId);
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
	 * Deletes the leads from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leads the leads
	 * @return the leads that was removed
	 */
	public static Leads deleteLeads(Leads leads) {
		return getService().deleteLeads(leads);
	}

	/**
	 * Deletes the leads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param LeadsId the primary key of the leads
	 * @return the leads that was removed
	 * @throws PortalException if a leads with the primary key could not be found
	 */
	public static Leads deleteLeads(long LeadsId) throws PortalException {
		return getService().deleteLeads(LeadsId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.LeadsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.LeadsModelImpl</code>.
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

	public static Leads fetchLeads(long LeadsId) {
		return getService().fetchLeads(LeadsId);
	}

	public static List<Leads> findAllByMypageUserId(long mypageUserId)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getService().findAllByMypageUserId(mypageUserId);
	}

	public static Leads findByLeadId(long leadId)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getService().findByLeadId(leadId);
	}

	public static Leads findByToken(String Token) {
		return getService().findByToken(Token);
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
	 * Returns the leads with the primary key.
	 *
	 * @param LeadsId the primary key of the leads
	 * @return the leads
	 * @throws PortalException if a leads with the primary key could not be found
	 */
	public static Leads getLeads(long LeadsId) throws PortalException {
		return getService().getLeads(LeadsId);
	}

	/**
	 * Returns a range of all the leadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.leads.model.impl.LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @return the range of leadses
	 */
	public static List<Leads> getLeadses(int start, int end) {
		return getService().getLeadses(start, end);
	}

	/**
	 * Returns the number of leadses.
	 *
	 * @return the number of leadses
	 */
	public static int getLeadsesCount() {
		return getService().getLeadsesCount();
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

	public static Leads searchByIdPhoto(long idPhoto) {
		return getService().searchByIdPhoto(idPhoto);
	}

	public static List<Leads> searchByPromoCode(String PromoCode) {
		return getService().searchByPromoCode(PromoCode);
	}

	public static Leads searchByReferenceNumber(String ReferenceNumber) {
		return getService().searchByReferenceNumber(ReferenceNumber);
	}

	public static List<Leads> searchByToken(String Token) {
		return getService().searchByToken(Token);
	}

	public static Leads setActive(
			long id, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(id, active, serviceContext);
	}

	public static Leads setIdPhoto(long LeadsId, long idPhotoFileEntryId)
		throws Exception {

		return getService().setIdPhoto(LeadsId, idPhotoFileEntryId);
	}

	public static Leads setIdPhoto(
			long LeadsId, long idPhotoFileEntryId, String photoFileUrl)
		throws Exception {

		return getService().setIdPhoto(
			LeadsId, idPhotoFileEntryId, photoFileUrl);
	}

	public static Leads setLeadsType(long LeadsId, String LeadsType)
		throws Exception {

		return getService().setLeadsType(LeadsId, LeadsType);
	}

	public static Leads setReferenceNumber(long LeadsId, String referenceNumber)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return getService().setReferenceNumber(LeadsId, referenceNumber);
	}

	public static Leads setStatus(long leadsId, String status)
		throws Exception {

		return getService().setStatus(leadsId, status);
	}

	/**
	 * Updates the leads in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LeadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param leads the leads
	 * @return the leads that was updated
	 */
	public static Leads updateLeads(Leads leads) {
		return getService().updateLeads(leads);
	}

	public static Leads updateLeads(
		long userId, long LeadsId,
		com.liferay.portal.kernel.json.JSONObject data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateLeads(userId, LeadsId, data, serviceContext);
	}

	public static Leads updateLeadsData(
		long userId, long LeadsId, java.util.HashMap<String, Object> data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateLeadsData(
			userId, LeadsId, data, serviceContext);
	}

	public static LeadsLocalService getService() {
		return _service;
	}

	private static volatile LeadsLocalService _service;

}