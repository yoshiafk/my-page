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
 * Provides a wrapper for {@link StiPremiLocalService}.
 *
 * @author Gositus Team
 * @see StiPremiLocalService
 * @generated
 */
public class StiPremiLocalServiceWrapper
	implements ServiceWrapper<StiPremiLocalService>, StiPremiLocalService {

	public StiPremiLocalServiceWrapper(
		StiPremiLocalService stiPremiLocalService) {

		_stiPremiLocalService = stiPremiLocalService;
	}

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
	@Override
	public com.mypage.admin.product.model.StiPremi addStiPremi(
		com.mypage.admin.product.model.StiPremi stiPremi) {

		return _stiPremiLocalService.addStiPremi(stiPremi);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stiPremiLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sti premi with the primary key. Does not add the sti premi to the database.
	 *
	 * @param premiId the primary key for the new sti premi
	 * @return the new sti premi
	 */
	@Override
	public com.mypage.admin.product.model.StiPremi createStiPremi(
		long premiId) {

		return _stiPremiLocalService.createStiPremi(premiId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stiPremiLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.mypage.admin.product.model.StiPremi deleteStiPremi(long premiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stiPremiLocalService.deleteStiPremi(premiId);
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
	@Override
	public com.mypage.admin.product.model.StiPremi deleteStiPremi(
		com.mypage.admin.product.model.StiPremi stiPremi) {

		return _stiPremiLocalService.deleteStiPremi(stiPremi);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stiPremiLocalService.dynamicQuery();
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

		return _stiPremiLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _stiPremiLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _stiPremiLocalService.dynamicQuery(
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

		return _stiPremiLocalService.dynamicQueryCount(dynamicQuery);
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

		return _stiPremiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.StiPremi fetchStiPremi(long premiId) {
		return _stiPremiLocalService.fetchStiPremi(premiId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.StiPremi>
		findByCurrencyAndTravellerType(String currency, String travellerType) {

		return _stiPremiLocalService.findByCurrencyAndTravellerType(
			currency, travellerType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stiPremiLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.StiPremi>
		getActivePremi() {

		return _stiPremiLocalService.getActivePremi();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stiPremiLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stiPremiLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stiPremiLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int getPremiCount() {
		return _stiPremiLocalService.getPremiCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.StiPremi> getPremis() {
		return _stiPremiLocalService.getPremis();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.StiPremi> getPremis(
		int start, int end) {

		return _stiPremiLocalService.getPremis(start, end);
	}

	/**
	 * Returns the sti premi with the primary key.
	 *
	 * @param premiId the primary key of the sti premi
	 * @return the sti premi
	 * @throws PortalException if a sti premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.StiPremi getStiPremi(long premiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stiPremiLocalService.getStiPremi(premiId);
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
	@Override
	public java.util.List<com.mypage.admin.product.model.StiPremi> getStiPremis(
		int start, int end) {

		return _stiPremiLocalService.getStiPremis(start, end);
	}

	/**
	 * Returns the number of sti premis.
	 *
	 * @return the number of sti premis
	 */
	@Override
	public int getStiPremisCount() {
		return _stiPremiLocalService.getStiPremisCount();
	}

	@Override
	public com.mypage.admin.product.model.StiPremi setActive(
		long premiId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _stiPremiLocalService.setActive(premiId, active, serviceContext);
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
	@Override
	public com.mypage.admin.product.model.StiPremi updateStiPremi(
		com.mypage.admin.product.model.StiPremi stiPremi) {

		return _stiPremiLocalService.updateStiPremi(stiPremi);
	}

	@Override
	public StiPremiLocalService getWrappedService() {
		return _stiPremiLocalService;
	}

	@Override
	public void setWrappedService(StiPremiLocalService stiPremiLocalService) {
		_stiPremiLocalService = stiPremiLocalService;
	}

	private StiPremiLocalService _stiPremiLocalService;

}