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
 * Provides a wrapper for {@link PersonalAccidentPremiLocalService}.
 *
 * @author Gositus Team
 * @see PersonalAccidentPremiLocalService
 * @generated
 */
public class PersonalAccidentPremiLocalServiceWrapper
	implements PersonalAccidentPremiLocalService,
			   ServiceWrapper<PersonalAccidentPremiLocalService> {

	public PersonalAccidentPremiLocalServiceWrapper(
		PersonalAccidentPremiLocalService personalAccidentPremiLocalService) {

		_personalAccidentPremiLocalService = personalAccidentPremiLocalService;
	}

	/**
	 * Adds the personal accident premi to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonalAccidentPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personalAccidentPremi the personal accident premi
	 * @return the personal accident premi that was added
	 */
	@Override
	public com.mypage.admin.product.model.PersonalAccidentPremi
		addPersonalAccidentPremi(
			com.mypage.admin.product.model.PersonalAccidentPremi
				personalAccidentPremi) {

		return _personalAccidentPremiLocalService.addPersonalAccidentPremi(
			personalAccidentPremi);
	}

	/**
	 * Add Premi
	 */
	@Override
	public com.mypage.admin.product.model.PersonalAccidentPremi
			addPersonalAccidentPremi(String type, double amount, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personalAccidentPremiLocalService.addPersonalAccidentPremi(
			type, amount, active);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personalAccidentPremiLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new personal accident premi with the primary key. Does not add the personal accident premi to the database.
	 *
	 * @param personalAccidentPremiId the primary key for the new personal accident premi
	 * @return the new personal accident premi
	 */
	@Override
	public com.mypage.admin.product.model.PersonalAccidentPremi
		createPersonalAccidentPremi(long personalAccidentPremiId) {

		return _personalAccidentPremiLocalService.createPersonalAccidentPremi(
			personalAccidentPremiId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personalAccidentPremiLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the personal accident premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonalAccidentPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personalAccidentPremiId the primary key of the personal accident premi
	 * @return the personal accident premi that was removed
	 * @throws PortalException if a personal accident premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.PersonalAccidentPremi
			deletePersonalAccidentPremi(long personalAccidentPremiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personalAccidentPremiLocalService.deletePersonalAccidentPremi(
			personalAccidentPremiId);
	}

	/**
	 * Deletes the personal accident premi from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonalAccidentPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personalAccidentPremi the personal accident premi
	 * @return the personal accident premi that was removed
	 */
	@Override
	public com.mypage.admin.product.model.PersonalAccidentPremi
		deletePersonalAccidentPremi(
			com.mypage.admin.product.model.PersonalAccidentPremi
				personalAccidentPremi) {

		return _personalAccidentPremiLocalService.deletePersonalAccidentPremi(
			personalAccidentPremi);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _personalAccidentPremiLocalService.dynamicQuery();
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

		return _personalAccidentPremiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PersonalAccidentPremiModelImpl</code>.
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

		return _personalAccidentPremiLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PersonalAccidentPremiModelImpl</code>.
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

		return _personalAccidentPremiLocalService.dynamicQuery(
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

		return _personalAccidentPremiLocalService.dynamicQueryCount(
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

		return _personalAccidentPremiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.PersonalAccidentPremi
		fetchPersonalAccidentPremi(long personalAccidentPremiId) {

		return _personalAccidentPremiLocalService.fetchPersonalAccidentPremi(
			personalAccidentPremiId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _personalAccidentPremiLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _personalAccidentPremiLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _personalAccidentPremiLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personalAccidentPremiLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the personal accident premi with the primary key.
	 *
	 * @param personalAccidentPremiId the primary key of the personal accident premi
	 * @return the personal accident premi
	 * @throws PortalException if a personal accident premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.PersonalAccidentPremi
			getPersonalAccidentPremi(long personalAccidentPremiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personalAccidentPremiLocalService.getPersonalAccidentPremi(
			personalAccidentPremiId);
	}

	@Override
	public int getPersonalAccidentPremiCount() {
		return _personalAccidentPremiLocalService.
			getPersonalAccidentPremiCount();
	}

	/**
	 * Returns a range of all the personal accident premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PersonalAccidentPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of personal accident premis
	 * @param end the upper bound of the range of personal accident premis (not inclusive)
	 * @return the range of personal accident premis
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.PersonalAccidentPremi>
		getPersonalAccidentPremis(int start, int end) {

		return _personalAccidentPremiLocalService.getPersonalAccidentPremis(
			start, end);
	}

	/**
	 * Returns the number of personal accident premis.
	 *
	 * @return the number of personal accident premis
	 */
	@Override
	public int getPersonalAccidentPremisCount() {
		return _personalAccidentPremiLocalService.
			getPersonalAccidentPremisCount();
	}

	@Override
	public com.mypage.admin.product.model.PersonalAccidentPremi setActive(
			long personalAccidentPremiId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personalAccidentPremiLocalService.setActive(
			personalAccidentPremiId, active, serviceContext);
	}

	/**
	 * Update Premi
	 */
	@Override
	public com.mypage.admin.product.model.PersonalAccidentPremi
			updatePersonalAccidentPremi(
				long personalAccidentPremiId, String type, double amount,
				int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personalAccidentPremiLocalService.updatePersonalAccidentPremi(
			personalAccidentPremiId, type, amount, active);
	}

	/**
	 * Updates the personal accident premi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonalAccidentPremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personalAccidentPremi the personal accident premi
	 * @return the personal accident premi that was updated
	 */
	@Override
	public com.mypage.admin.product.model.PersonalAccidentPremi
		updatePersonalAccidentPremi(
			com.mypage.admin.product.model.PersonalAccidentPremi
				personalAccidentPremi) {

		return _personalAccidentPremiLocalService.updatePersonalAccidentPremi(
			personalAccidentPremi);
	}

	@Override
	public PersonalAccidentPremiLocalService getWrappedService() {
		return _personalAccidentPremiLocalService;
	}

	@Override
	public void setWrappedService(
		PersonalAccidentPremiLocalService personalAccidentPremiLocalService) {

		_personalAccidentPremiLocalService = personalAccidentPremiLocalService;
	}

	private PersonalAccidentPremiLocalService
		_personalAccidentPremiLocalService;

}