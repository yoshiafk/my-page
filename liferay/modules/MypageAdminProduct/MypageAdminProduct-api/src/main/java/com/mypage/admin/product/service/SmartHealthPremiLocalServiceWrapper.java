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
 * Provides a wrapper for {@link SmartHealthPremiLocalService}.
 *
 * @author Gositus Team
 * @see SmartHealthPremiLocalService
 * @generated
 */
public class SmartHealthPremiLocalServiceWrapper
	implements ServiceWrapper<SmartHealthPremiLocalService>,
			   SmartHealthPremiLocalService {

	public SmartHealthPremiLocalServiceWrapper(
		SmartHealthPremiLocalService smartHealthPremiLocalService) {

		_smartHealthPremiLocalService = smartHealthPremiLocalService;
	}

	/**
	 * Add Premi
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthPremi addSmartHealthPremi(
			int age, String gender, String currency, double amount, long planId,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthPremiLocalService.addSmartHealthPremi(
			age, gender, currency, amount, planId, status);
	}

	/**
	 * Adds the smart health premi to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthPremi the smart health premi
	 * @return the smart health premi that was added
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthPremi addSmartHealthPremi(
		com.mypage.admin.product.model.SmartHealthPremi smartHealthPremi) {

		return _smartHealthPremiLocalService.addSmartHealthPremi(
			smartHealthPremi);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthPremiLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new smart health premi with the primary key. Does not add the smart health premi to the database.
	 *
	 * @param smartHealthPremiId the primary key for the new smart health premi
	 * @return the new smart health premi
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthPremi
		createSmartHealthPremi(long smartHealthPremiId) {

		return _smartHealthPremiLocalService.createSmartHealthPremi(
			smartHealthPremiId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthPremiLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the smart health premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthPremiId the primary key of the smart health premi
	 * @return the smart health premi that was removed
	 * @throws PortalException if a smart health premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthPremi
			deleteSmartHealthPremi(long smartHealthPremiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthPremiLocalService.deleteSmartHealthPremi(
			smartHealthPremiId);
	}

	/**
	 * Deletes the smart health premi from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthPremi the smart health premi
	 * @return the smart health premi that was removed
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthPremi
		deleteSmartHealthPremi(
			com.mypage.admin.product.model.SmartHealthPremi smartHealthPremi) {

		return _smartHealthPremiLocalService.deleteSmartHealthPremi(
			smartHealthPremi);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smartHealthPremiLocalService.dynamicQuery();
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

		return _smartHealthPremiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthPremiModelImpl</code>.
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

		return _smartHealthPremiLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthPremiModelImpl</code>.
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

		return _smartHealthPremiLocalService.dynamicQuery(
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

		return _smartHealthPremiLocalService.dynamicQueryCount(dynamicQuery);
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

		return _smartHealthPremiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.SmartHealthPremi
		fetchSmartHealthPremi(long smartHealthPremiId) {

		return _smartHealthPremiLocalService.fetchSmartHealthPremi(
			smartHealthPremiId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smartHealthPremiLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smartHealthPremiLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartHealthPremiLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthPremiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the smart health premi with the primary key.
	 *
	 * @param smartHealthPremiId the primary key of the smart health premi
	 * @return the smart health premi
	 * @throws PortalException if a smart health premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthPremi getSmartHealthPremi(
			long smartHealthPremiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthPremiLocalService.getSmartHealthPremi(
			smartHealthPremiId);
	}

	@Override
	public int getSmartHealthPremiCount() {
		return _smartHealthPremiLocalService.getSmartHealthPremiCount();
	}

	/**
	 * Returns a range of all the smart health premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health premis
	 * @param end the upper bound of the range of smart health premis (not inclusive)
	 * @return the range of smart health premis
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.SmartHealthPremi>
		getSmartHealthPremis(int start, int end) {

		return _smartHealthPremiLocalService.getSmartHealthPremis(start, end);
	}

	/**
	 * Returns the number of smart health premis.
	 *
	 * @return the number of smart health premis
	 */
	@Override
	public int getSmartHealthPremisCount() {
		return _smartHealthPremiLocalService.getSmartHealthPremisCount();
	}

	@Override
	public com.mypage.admin.product.model.SmartHealthPremi setActive(
			long smartHealthPremiId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthPremiLocalService.setActive(
			smartHealthPremiId, status, serviceContext);
	}

	/**
	 * Update Premi
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthPremi
			updateSmartHealthPremi(
				long smartHealthPremiId, int age, String gender,
				String currency, double amount, long planId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartHealthPremiLocalService.updateSmartHealthPremi(
			smartHealthPremiId, age, gender, currency, amount, planId, status);
	}

	/**
	 * Updates the smart health premi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthPremi the smart health premi
	 * @return the smart health premi that was updated
	 */
	@Override
	public com.mypage.admin.product.model.SmartHealthPremi
		updateSmartHealthPremi(
			com.mypage.admin.product.model.SmartHealthPremi smartHealthPremi) {

		return _smartHealthPremiLocalService.updateSmartHealthPremi(
			smartHealthPremi);
	}

	@Override
	public SmartHealthPremiLocalService getWrappedService() {
		return _smartHealthPremiLocalService;
	}

	@Override
	public void setWrappedService(
		SmartHealthPremiLocalService smartHealthPremiLocalService) {

		_smartHealthPremiLocalService = smartHealthPremiLocalService;
	}

	private SmartHealthPremiLocalService _smartHealthPremiLocalService;

}