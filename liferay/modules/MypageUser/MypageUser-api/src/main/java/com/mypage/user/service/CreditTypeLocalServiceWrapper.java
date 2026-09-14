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

package com.mypage.user.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CreditTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CreditTypeLocalService
 * @generated
 */
public class CreditTypeLocalServiceWrapper
	implements CreditTypeLocalService, ServiceWrapper<CreditTypeLocalService> {

	public CreditTypeLocalServiceWrapper(
		CreditTypeLocalService creditTypeLocalService) {

		_creditTypeLocalService = creditTypeLocalService;
	}

	/**
	 * Adds the credit type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CreditTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param creditType the credit type
	 * @return the credit type that was added
	 */
	@Override
	public com.mypage.user.model.CreditType addCreditType(
		com.mypage.user.model.CreditType creditType) {

		return _creditTypeLocalService.addCreditType(creditType);
	}

	@Override
	public com.mypage.user.model.CreditType addCreditType(
		String name, String agentType, Double limit, int overrideGracePeriod,
		int nettPremiAllowed, int active) {

		return _creditTypeLocalService.addCreditType(
			name, agentType, limit, overrideGracePeriod, nettPremiAllowed,
			active);
	}

	/**
	 * Creates a new credit type with the primary key. Does not add the credit type to the database.
	 *
	 * @param creditTypeId the primary key for the new credit type
	 * @return the new credit type
	 */
	@Override
	public com.mypage.user.model.CreditType createCreditType(
		long creditTypeId) {

		return _creditTypeLocalService.createCreditType(creditTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creditTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the credit type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CreditTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param creditType the credit type
	 * @return the credit type that was removed
	 */
	@Override
	public com.mypage.user.model.CreditType deleteCreditType(
		com.mypage.user.model.CreditType creditType) {

		return _creditTypeLocalService.deleteCreditType(creditType);
	}

	/**
	 * Deletes the credit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CreditTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param creditTypeId the primary key of the credit type
	 * @return the credit type that was removed
	 * @throws PortalException if a credit type with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.CreditType deleteCreditType(long creditTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creditTypeLocalService.deleteCreditType(creditTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creditTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _creditTypeLocalService.dynamicQuery();
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

		return _creditTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.CreditTypeModelImpl</code>.
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

		return _creditTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.CreditTypeModelImpl</code>.
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

		return _creditTypeLocalService.dynamicQuery(
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

		return _creditTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _creditTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.user.model.CreditType fetchCreditType(long creditTypeId) {
		return _creditTypeLocalService.fetchCreditType(creditTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _creditTypeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the credit type with the primary key.
	 *
	 * @param creditTypeId the primary key of the credit type
	 * @return the credit type
	 * @throws PortalException if a credit type with the primary key could not be found
	 */
	@Override
	public com.mypage.user.model.CreditType getCreditType(long creditTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creditTypeLocalService.getCreditType(creditTypeId);
	}

	/**
	 * Returns a range of all the credit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.user.model.impl.CreditTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit types
	 * @param end the upper bound of the range of credit types (not inclusive)
	 * @return the range of credit types
	 */
	@Override
	public java.util.List<com.mypage.user.model.CreditType> getCreditTypes(
		int start, int end) {

		return _creditTypeLocalService.getCreditTypes(start, end);
	}

	/**
	 * Returns the number of credit types.
	 *
	 * @return the number of credit types
	 */
	@Override
	public int getCreditTypesCount() {
		return _creditTypeLocalService.getCreditTypesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _creditTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _creditTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _creditTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.user.model.CreditType setActive(
		long creditTypeId, int active) {

		return _creditTypeLocalService.setActive(creditTypeId, active);
	}

	/**
	 * Updates the credit type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CreditTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param creditType the credit type
	 * @return the credit type that was updated
	 */
	@Override
	public com.mypage.user.model.CreditType updateCreditType(
		com.mypage.user.model.CreditType creditType) {

		return _creditTypeLocalService.updateCreditType(creditType);
	}

	@Override
	public com.mypage.user.model.CreditType updateCreditType(
		long creditTypeId, String name, String agentType, Double limit,
		int overrideGracePeriod, int nettPremiAllowed, int active) {

		return _creditTypeLocalService.updateCreditType(
			creditTypeId, name, agentType, limit, overrideGracePeriod,
			nettPremiAllowed, active);
	}

	@Override
	public CreditTypeLocalService getWrappedService() {
		return _creditTypeLocalService;
	}

	@Override
	public void setWrappedService(
		CreditTypeLocalService creditTypeLocalService) {

		_creditTypeLocalService = creditTypeLocalService;
	}

	private CreditTypeLocalService _creditTypeLocalService;

}