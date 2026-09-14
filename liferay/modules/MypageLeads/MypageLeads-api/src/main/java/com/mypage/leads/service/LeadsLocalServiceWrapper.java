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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LeadsLocalService}.
 *
 * @author Gositus
 * @see LeadsLocalService
 * @generated
 */
public class LeadsLocalServiceWrapper
	implements LeadsLocalService, ServiceWrapper<LeadsLocalService> {

	public LeadsLocalServiceWrapper(LeadsLocalService leadsLocalService) {
		_leadsLocalService = leadsLocalService;
	}

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
	@Override
	public com.mypage.leads.model.Leads addLeads(
		com.mypage.leads.model.Leads leads) {

		return _leadsLocalService.addLeads(leads);
	}

	@Override
	public com.mypage.leads.model.Leads addLeads(
		long userId, long LeadsId,
		com.liferay.portal.kernel.json.JSONObject data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _leadsLocalService.addLeads(
			userId, LeadsId, data, serviceContext);
	}

	/**
	 * Creates a new leads with the primary key. Does not add the leads to the database.
	 *
	 * @param LeadsId the primary key for the new leads
	 * @return the new leads
	 */
	@Override
	public com.mypage.leads.model.Leads createLeads(long LeadsId) {
		return _leadsLocalService.createLeads(LeadsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leadsLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.mypage.leads.model.Leads deleteLeads(
		com.mypage.leads.model.Leads leads) {

		return _leadsLocalService.deleteLeads(leads);
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
	@Override
	public com.mypage.leads.model.Leads deleteLeads(long LeadsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leadsLocalService.deleteLeads(LeadsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leadsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leadsLocalService.dynamicQuery();
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

		return _leadsLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _leadsLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _leadsLocalService.dynamicQuery(
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

		return _leadsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _leadsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.mypage.leads.model.Leads fetchLeads(long LeadsId) {
		return _leadsLocalService.fetchLeads(LeadsId);
	}

	@Override
	public java.util.List<com.mypage.leads.model.Leads> findAllByMypageUserId(
			long mypageUserId)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return _leadsLocalService.findAllByMypageUserId(mypageUserId);
	}

	@Override
	public com.mypage.leads.model.Leads findByLeadId(long leadId)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return _leadsLocalService.findByLeadId(leadId);
	}

	@Override
	public com.mypage.leads.model.Leads findByToken(String Token) {
		return _leadsLocalService.findByToken(Token);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _leadsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _leadsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the leads with the primary key.
	 *
	 * @param LeadsId the primary key of the leads
	 * @return the leads
	 * @throws PortalException if a leads with the primary key could not be found
	 */
	@Override
	public com.mypage.leads.model.Leads getLeads(long LeadsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leadsLocalService.getLeads(LeadsId);
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
	@Override
	public java.util.List<com.mypage.leads.model.Leads> getLeadses(
		int start, int end) {

		return _leadsLocalService.getLeadses(start, end);
	}

	/**
	 * Returns the number of leadses.
	 *
	 * @return the number of leadses
	 */
	@Override
	public int getLeadsesCount() {
		return _leadsLocalService.getLeadsesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leadsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leadsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.leads.model.Leads searchByIdPhoto(long idPhoto) {
		return _leadsLocalService.searchByIdPhoto(idPhoto);
	}

	@Override
	public java.util.List<com.mypage.leads.model.Leads> searchByPromoCode(
		String PromoCode) {

		return _leadsLocalService.searchByPromoCode(PromoCode);
	}

	@Override
	public com.mypage.leads.model.Leads searchByReferenceNumber(
		String ReferenceNumber) {

		return _leadsLocalService.searchByReferenceNumber(ReferenceNumber);
	}

	@Override
	public java.util.List<com.mypage.leads.model.Leads> searchByToken(
		String Token) {

		return _leadsLocalService.searchByToken(Token);
	}

	@Override
	public com.mypage.leads.model.Leads setActive(
			long id, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _leadsLocalService.setActive(id, active, serviceContext);
	}

	@Override
	public com.mypage.leads.model.Leads setIdPhoto(
			long LeadsId, long idPhotoFileEntryId)
		throws Exception {

		return _leadsLocalService.setIdPhoto(LeadsId, idPhotoFileEntryId);
	}

	@Override
	public com.mypage.leads.model.Leads setIdPhoto(
			long LeadsId, long idPhotoFileEntryId, String photoFileUrl)
		throws Exception {

		return _leadsLocalService.setIdPhoto(
			LeadsId, idPhotoFileEntryId, photoFileUrl);
	}

	@Override
	public com.mypage.leads.model.Leads setLeadsType(
			long LeadsId, String LeadsType)
		throws Exception {

		return _leadsLocalService.setLeadsType(LeadsId, LeadsType);
	}

	@Override
	public com.mypage.leads.model.Leads setReferenceNumber(
			long LeadsId, String referenceNumber)
		throws com.mypage.leads.exception.NoSuchLeadsException {

		return _leadsLocalService.setReferenceNumber(LeadsId, referenceNumber);
	}

	@Override
	public com.mypage.leads.model.Leads setStatus(long leadsId, String status)
		throws Exception {

		return _leadsLocalService.setStatus(leadsId, status);
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
	@Override
	public com.mypage.leads.model.Leads updateLeads(
		com.mypage.leads.model.Leads leads) {

		return _leadsLocalService.updateLeads(leads);
	}

	@Override
	public com.mypage.leads.model.Leads updateLeads(
		long userId, long LeadsId,
		com.liferay.portal.kernel.json.JSONObject data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _leadsLocalService.updateLeads(
			userId, LeadsId, data, serviceContext);
	}

	@Override
	public com.mypage.leads.model.Leads updateLeadsData(
		long userId, long LeadsId, java.util.HashMap<String, Object> data,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _leadsLocalService.updateLeadsData(
			userId, LeadsId, data, serviceContext);
	}

	@Override
	public LeadsLocalService getWrappedService() {
		return _leadsLocalService;
	}

	@Override
	public void setWrappedService(LeadsLocalService leadsLocalService) {
		_leadsLocalService = leadsLocalService;
	}

	private LeadsLocalService _leadsLocalService;

}