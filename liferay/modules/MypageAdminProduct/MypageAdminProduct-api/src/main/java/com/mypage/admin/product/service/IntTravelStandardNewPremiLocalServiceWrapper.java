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
 * Provides a wrapper for {@link IntTravelStandardNewPremiLocalService}.
 *
 * @author Gositus Team
 * @see IntTravelStandardNewPremiLocalService
 * @generated
 */
public class IntTravelStandardNewPremiLocalServiceWrapper
	implements IntTravelStandardNewPremiLocalService,
			   ServiceWrapper<IntTravelStandardNewPremiLocalService> {

	public IntTravelStandardNewPremiLocalServiceWrapper(
		IntTravelStandardNewPremiLocalService
			intTravelStandardNewPremiLocalService) {

		_intTravelStandardNewPremiLocalService =
			intTravelStandardNewPremiLocalService;
	}

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
	@Override
	public com.mypage.admin.product.model.IntTravelStandardNewPremi
		addIntTravelStandardNewPremi(
			com.mypage.admin.product.model.IntTravelStandardNewPremi
				intTravelStandardNewPremi) {

		return _intTravelStandardNewPremiLocalService.
			addIntTravelStandardNewPremi(intTravelStandardNewPremi);
	}

	@Override
	public com.mypage.admin.product.model.IntTravelStandardNewPremi
			addIntTravelStandardNewPremi(
				String travelType, String packageType, String peopleType,
				int mainInsured, int spouse, int child, String currency,
				java.math.BigDecimal amount,
				java.math.BigDecimal additionalPrice, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _intTravelStandardNewPremiLocalService.
			addIntTravelStandardNewPremi(
				travelType, packageType, peopleType, mainInsured, spouse, child,
				currency, amount, additionalPrice, active);
	}

	/**
	 * Creates a new int travel standard new premi with the primary key. Does not add the int travel standard new premi to the database.
	 *
	 * @param intTravelStandardNewPremiId the primary key for the new int travel standard new premi
	 * @return the new int travel standard new premi
	 */
	@Override
	public com.mypage.admin.product.model.IntTravelStandardNewPremi
		createIntTravelStandardNewPremi(long intTravelStandardNewPremiId) {

		return _intTravelStandardNewPremiLocalService.
			createIntTravelStandardNewPremi(intTravelStandardNewPremiId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _intTravelStandardNewPremiLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.mypage.admin.product.model.IntTravelStandardNewPremi
		deleteIntTravelStandardNewPremi(
			com.mypage.admin.product.model.IntTravelStandardNewPremi
				intTravelStandardNewPremi) {

		return _intTravelStandardNewPremiLocalService.
			deleteIntTravelStandardNewPremi(intTravelStandardNewPremi);
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
	@Override
	public com.mypage.admin.product.model.IntTravelStandardNewPremi
			deleteIntTravelStandardNewPremi(long intTravelStandardNewPremiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _intTravelStandardNewPremiLocalService.
			deleteIntTravelStandardNewPremi(intTravelStandardNewPremiId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _intTravelStandardNewPremiLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _intTravelStandardNewPremiLocalService.dynamicQuery();
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

		return _intTravelStandardNewPremiLocalService.dynamicQuery(
			dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _intTravelStandardNewPremiLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _intTravelStandardNewPremiLocalService.dynamicQuery(
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

		return _intTravelStandardNewPremiLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _intTravelStandardNewPremiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.IntTravelStandardNewPremi
		fetchIntTravelStandardNewPremi(long intTravelStandardNewPremiId) {

		return _intTravelStandardNewPremiLocalService.
			fetchIntTravelStandardNewPremi(intTravelStandardNewPremiId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _intTravelStandardNewPremiLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _intTravelStandardNewPremiLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the int travel standard new premi with the primary key.
	 *
	 * @param intTravelStandardNewPremiId the primary key of the int travel standard new premi
	 * @return the int travel standard new premi
	 * @throws PortalException if a int travel standard new premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.IntTravelStandardNewPremi
			getIntTravelStandardNewPremi(long intTravelStandardNewPremiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _intTravelStandardNewPremiLocalService.
			getIntTravelStandardNewPremi(intTravelStandardNewPremiId);
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
	@Override
	public java.util.List
		<com.mypage.admin.product.model.IntTravelStandardNewPremi>
			getIntTravelStandardNewPremis(int start, int end) {

		return _intTravelStandardNewPremiLocalService.
			getIntTravelStandardNewPremis(start, end);
	}

	/**
	 * Returns the number of int travel standard new premis.
	 *
	 * @return the number of int travel standard new premis
	 */
	@Override
	public int getIntTravelStandardNewPremisCount() {
		return _intTravelStandardNewPremiLocalService.
			getIntTravelStandardNewPremisCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _intTravelStandardNewPremiLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _intTravelStandardNewPremiLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public java.util.List
		<com.mypage.admin.product.model.IntTravelStandardNewPremi> getPremis() {

		return _intTravelStandardNewPremiLocalService.getPremis();
	}

	@Override
	public java.util.List
		<com.mypage.admin.product.model.IntTravelStandardNewPremi> getPremis(
			int start, int end) {

		return _intTravelStandardNewPremiLocalService.getPremis(start, end);
	}

	@Override
	public int getPremisCount() {
		return _intTravelStandardNewPremiLocalService.getPremisCount();
	}

	@Override
	public com.mypage.admin.product.model.IntTravelStandardNewPremi
		searchSpesificPremi(
			String travelType, String packageType, String peopleType,
			String currency, int mainInsured, int spouse, int child) {

		return _intTravelStandardNewPremiLocalService.searchSpesificPremi(
			travelType, packageType, peopleType, currency, mainInsured, spouse,
			child);
	}

	@Override
	public com.mypage.admin.product.model.IntTravelStandardNewPremi setActive(
			long intTravelStandardNewPremiId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _intTravelStandardNewPremiLocalService.setActive(
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
	@Override
	public com.mypage.admin.product.model.IntTravelStandardNewPremi
		updateIntTravelStandardNewPremi(
			com.mypage.admin.product.model.IntTravelStandardNewPremi
				intTravelStandardNewPremi) {

		return _intTravelStandardNewPremiLocalService.
			updateIntTravelStandardNewPremi(intTravelStandardNewPremi);
	}

	@Override
	public com.mypage.admin.product.model.IntTravelStandardNewPremi
			updateIntTravelStandardNewPremi(
				long intTravelStandardNewPremiId, String travelType,
				String packageType, String peopleType, int mainInsured,
				int spouse, int child, String currency,
				java.math.BigDecimal amount,
				java.math.BigDecimal additionalPrice, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _intTravelStandardNewPremiLocalService.
			updateIntTravelStandardNewPremi(
				intTravelStandardNewPremiId, travelType, packageType,
				peopleType, mainInsured, spouse, child, currency, amount,
				additionalPrice, active);
	}

	@Override
	public IntTravelStandardNewPremiLocalService getWrappedService() {
		return _intTravelStandardNewPremiLocalService;
	}

	@Override
	public void setWrappedService(
		IntTravelStandardNewPremiLocalService
			intTravelStandardNewPremiLocalService) {

		_intTravelStandardNewPremiLocalService =
			intTravelStandardNewPremiLocalService;
	}

	private IntTravelStandardNewPremiLocalService
		_intTravelStandardNewPremiLocalService;

}