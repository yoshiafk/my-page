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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PremiLocalService}.
 *
 * @author Gositus Team
 * @see PremiLocalService
 * @generated
 */
public class PremiLocalServiceWrapper
	implements PremiLocalService, ServiceWrapper<PremiLocalService> {

	public PremiLocalServiceWrapper(PremiLocalService premiLocalService) {
		_premiLocalService = premiLocalService;
	}

	/**
	 * Adds the premi to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param premi the premi
	 * @return the premi that was added
	 */
	@Override
	public com.mypage.admin.product.model.Premi addPremi(
		com.mypage.admin.product.model.Premi premi) {

		return _premiLocalService.addPremi(premi);
	}

	@Override
	public com.mypage.admin.product.model.Premi addPremi(
			String travellerType, String currency, java.math.BigDecimal basic,
			java.math.BigDecimal additional, java.math.BigDecimal annual,
			int active, long benefitId, long planId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _premiLocalService.addPremi(
			travellerType, currency, basic, additional, annual, active,
			benefitId, planId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _premiLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new premi with the primary key. Does not add the premi to the database.
	 *
	 * @param premiId the primary key for the new premi
	 * @return the new premi
	 */
	@Override
	public com.mypage.admin.product.model.Premi createPremi(long premiId) {
		return _premiLocalService.createPremi(premiId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _premiLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param premiId the primary key of the premi
	 * @return the premi that was removed
	 * @throws PortalException if a premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.Premi deletePremi(long premiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _premiLocalService.deletePremi(premiId);
	}

	/**
	 * Deletes the premi from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param premi the premi
	 * @return the premi that was removed
	 */
	@Override
	public com.mypage.admin.product.model.Premi deletePremi(
		com.mypage.admin.product.model.Premi premi) {

		return _premiLocalService.deletePremi(premi);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _premiLocalService.dynamicQuery();
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

		return _premiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PremiModelImpl</code>.
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

		return _premiLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PremiModelImpl</code>.
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

		return _premiLocalService.dynamicQuery(
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

		return _premiLocalService.dynamicQueryCount(dynamicQuery);
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

		return _premiLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.Premi fetchPremi(long premiId) {
		return _premiLocalService.fetchPremi(premiId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.Premi>
		findByCurrencyAndTravellerType(String currency, String travellerType) {

		return _premiLocalService.findByCurrencyAndTravellerType(
			currency, travellerType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _premiLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.Premi>
		getActivePremi() {

		return _premiLocalService.getActivePremi();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _premiLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _premiLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _premiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the premi with the primary key.
	 *
	 * @param premiId the primary key of the premi
	 * @return the premi
	 * @throws PortalException if a premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.Premi getPremi(long premiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _premiLocalService.getPremi(premiId);
	}

	@Override
	public int getPremiCount() {
		return _premiLocalService.getPremiCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.Premi> getPremis() {
		return _premiLocalService.getPremis();
	}

	/**
	 * Returns a range of all the premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of premis
	 * @param end the upper bound of the range of premis (not inclusive)
	 * @return the range of premis
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.Premi> getPremis(
		int start, int end) {

		return _premiLocalService.getPremis(start, end);
	}

	/**
	 * Returns the number of premis.
	 *
	 * @return the number of premis
	 */
	@Override
	public int getPremisCount() {
		return _premiLocalService.getPremisCount();
	}

	@Override
	public com.mypage.admin.product.model.Premi setActive(
		long premiId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _premiLocalService.setActive(premiId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.Premi updatePremi(
			long premiId, long benefitId, long planId, String travellerType,
			String currency, java.math.BigDecimal basic,
			java.math.BigDecimal additional, java.math.BigDecimal annual,
			int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _premiLocalService.updatePremi(
			premiId, benefitId, planId, travellerType, currency, basic,
			additional, annual, active);
	}

	/**
	 * Updates the premi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param premi the premi
	 * @return the premi that was updated
	 */
	@Override
	public com.mypage.admin.product.model.Premi updatePremi(
		com.mypage.admin.product.model.Premi premi) {

		return _premiLocalService.updatePremi(premi);
	}

	@Override
	public PremiLocalService getWrappedService() {
		return _premiLocalService;
	}

	@Override
	public void setWrappedService(PremiLocalService premiLocalService) {
		_premiLocalService = premiLocalService;
	}

	private PremiLocalService _premiLocalService;

}