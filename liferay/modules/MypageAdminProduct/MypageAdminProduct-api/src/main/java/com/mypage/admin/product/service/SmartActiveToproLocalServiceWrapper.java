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
 * Provides a wrapper for {@link SmartActiveToproLocalService}.
 *
 * @author Gositus Team
 * @see SmartActiveToproLocalService
 * @generated
 */
public class SmartActiveToproLocalServiceWrapper
	implements ServiceWrapper<SmartActiveToproLocalService>,
			   SmartActiveToproLocalService {

	public SmartActiveToproLocalServiceWrapper(
		SmartActiveToproLocalService smartActiveToproLocalService) {

		_smartActiveToproLocalService = smartActiveToproLocalService;
	}

	/**
	 * Adds the smart active topro to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveToproLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveTopro the smart active topro
	 * @return the smart active topro that was added
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveTopro addSmartActiveTopro(
		com.mypage.admin.product.model.SmartActiveTopro smartActiveTopro) {

		return _smartActiveToproLocalService.addSmartActiveTopro(
			smartActiveTopro);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveTopro addTopro(
			String topro, String description, String annotations,
			long benefitValueId, String toc, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveToproLocalService.addTopro(
			topro, description, annotations, benefitValueId, toc, active);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveToproLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new smart active topro with the primary key. Does not add the smart active topro to the database.
	 *
	 * @param smartActiveToproId the primary key for the new smart active topro
	 * @return the new smart active topro
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveTopro
		createSmartActiveTopro(long smartActiveToproId) {

		return _smartActiveToproLocalService.createSmartActiveTopro(
			smartActiveToproId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveToproLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the smart active topro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveToproLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveToproId the primary key of the smart active topro
	 * @return the smart active topro that was removed
	 * @throws PortalException if a smart active topro with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveTopro
			deleteSmartActiveTopro(long smartActiveToproId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveToproLocalService.deleteSmartActiveTopro(
			smartActiveToproId);
	}

	/**
	 * Deletes the smart active topro from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveToproLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveTopro the smart active topro
	 * @return the smart active topro that was removed
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveTopro
		deleteSmartActiveTopro(
			com.mypage.admin.product.model.SmartActiveTopro smartActiveTopro) {

		return _smartActiveToproLocalService.deleteSmartActiveTopro(
			smartActiveTopro);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smartActiveToproLocalService.dynamicQuery();
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

		return _smartActiveToproLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveToproModelImpl</code>.
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

		return _smartActiveToproLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveToproModelImpl</code>.
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

		return _smartActiveToproLocalService.dynamicQuery(
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

		return _smartActiveToproLocalService.dynamicQueryCount(dynamicQuery);
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

		return _smartActiveToproLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveTopro
		fetchSmartActiveTopro(long smartActiveToproId) {

		return _smartActiveToproLocalService.fetchSmartActiveTopro(
			smartActiveToproId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smartActiveToproLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveTopro>
		getActiveTopro() {

		return _smartActiveToproLocalService.getActiveTopro();
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveTopro getByTopro(
		String topro) {

		return _smartActiveToproLocalService.getByTopro(topro);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smartActiveToproLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartActiveToproLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveToproLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the smart active topro with the primary key.
	 *
	 * @param smartActiveToproId the primary key of the smart active topro
	 * @return the smart active topro
	 * @throws PortalException if a smart active topro with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveTopro getSmartActiveTopro(
			long smartActiveToproId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveToproLocalService.getSmartActiveTopro(
			smartActiveToproId);
	}

	/**
	 * Returns a range of all the smart active topros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveToproModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active topros
	 * @param end the upper bound of the range of smart active topros (not inclusive)
	 * @return the range of smart active topros
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveTopro>
		getSmartActiveTopros(int start, int end) {

		return _smartActiveToproLocalService.getSmartActiveTopros(start, end);
	}

	/**
	 * Returns the number of smart active topros.
	 *
	 * @return the number of smart active topros
	 */
	@Override
	public int getSmartActiveToprosCount() {
		return _smartActiveToproLocalService.getSmartActiveToprosCount();
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveTopro
		getToproByBenefitValue(long benefitValueId) {

		return _smartActiveToproLocalService.getToproByBenefitValue(
			benefitValueId);
	}

	@Override
	public int getToproCount() {
		return _smartActiveToproLocalService.getToproCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveTopro>
		getTopros() {

		return _smartActiveToproLocalService.getTopros();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveTopro>
		getTopros(int start, int end) {

		return _smartActiveToproLocalService.getTopros(start, end);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveTopro setActive(
			long toproId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveToproLocalService.setActive(
			toproId, active, serviceContext);
	}

	/**
	 * Updates the smart active topro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveToproLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveTopro the smart active topro
	 * @return the smart active topro that was updated
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveTopro
		updateSmartActiveTopro(
			com.mypage.admin.product.model.SmartActiveTopro smartActiveTopro) {

		return _smartActiveToproLocalService.updateSmartActiveTopro(
			smartActiveTopro);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveTopro updateTopro(
			long toproId, String topro, String description, String annotations,
			long benefitValueId, String toc, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveToproLocalService.updateTopro(
			toproId, topro, description, annotations, benefitValueId, toc,
			active);
	}

	@Override
	public SmartActiveToproLocalService getWrappedService() {
		return _smartActiveToproLocalService;
	}

	@Override
	public void setWrappedService(
		SmartActiveToproLocalService smartActiveToproLocalService) {

		_smartActiveToproLocalService = smartActiveToproLocalService;
	}

	private SmartActiveToproLocalService _smartActiveToproLocalService;

}