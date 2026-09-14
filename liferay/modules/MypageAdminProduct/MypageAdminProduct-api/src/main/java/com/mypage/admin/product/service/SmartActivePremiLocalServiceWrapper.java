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
 * Provides a wrapper for {@link SmartActivePremiLocalService}.
 *
 * @author Gositus Team
 * @see SmartActivePremiLocalService
 * @generated
 */
public class SmartActivePremiLocalServiceWrapper
	implements ServiceWrapper<SmartActivePremiLocalService>,
			   SmartActivePremiLocalService {

	public SmartActivePremiLocalServiceWrapper(
		SmartActivePremiLocalService smartActivePremiLocalService) {

		_smartActivePremiLocalService = smartActivePremiLocalService;
	}

	@Override
	public com.mypage.admin.product.model.SmartActivePremi addPremi(
			double rate, int active, long benefitId, long classRateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActivePremiLocalService.addPremi(
			rate, active, benefitId, classRateId);
	}

	/**
	 * Adds the smart active premi to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActivePremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActivePremi the smart active premi
	 * @return the smart active premi that was added
	 */
	@Override
	public com.mypage.admin.product.model.SmartActivePremi addSmartActivePremi(
		com.mypage.admin.product.model.SmartActivePremi smartActivePremi) {

		return _smartActivePremiLocalService.addSmartActivePremi(
			smartActivePremi);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActivePremiLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new smart active premi with the primary key. Does not add the smart active premi to the database.
	 *
	 * @param smartActivePremiId the primary key for the new smart active premi
	 * @return the new smart active premi
	 */
	@Override
	public com.mypage.admin.product.model.SmartActivePremi
		createSmartActivePremi(long smartActivePremiId) {

		return _smartActivePremiLocalService.createSmartActivePremi(
			smartActivePremiId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActivePremiLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the smart active premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActivePremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActivePremiId the primary key of the smart active premi
	 * @return the smart active premi that was removed
	 * @throws PortalException if a smart active premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActivePremi
			deleteSmartActivePremi(long smartActivePremiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActivePremiLocalService.deleteSmartActivePremi(
			smartActivePremiId);
	}

	/**
	 * Deletes the smart active premi from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActivePremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActivePremi the smart active premi
	 * @return the smart active premi that was removed
	 */
	@Override
	public com.mypage.admin.product.model.SmartActivePremi
		deleteSmartActivePremi(
			com.mypage.admin.product.model.SmartActivePremi smartActivePremi) {

		return _smartActivePremiLocalService.deleteSmartActivePremi(
			smartActivePremi);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smartActivePremiLocalService.dynamicQuery();
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

		return _smartActivePremiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActivePremiModelImpl</code>.
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

		return _smartActivePremiLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActivePremiModelImpl</code>.
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

		return _smartActivePremiLocalService.dynamicQuery(
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

		return _smartActivePremiLocalService.dynamicQueryCount(dynamicQuery);
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

		return _smartActivePremiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.SmartActivePremi
		fetchSmartActivePremi(long smartActivePremiId) {

		return _smartActivePremiLocalService.fetchSmartActivePremi(
			smartActivePremiId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smartActivePremiLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActivePremi>
		getActivePremi() {

		return _smartActivePremiLocalService.getActivePremi();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smartActivePremiLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartActivePremiLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActivePremiLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.mypage.admin.product.model.SmartActivePremi
		getPremiByBenefitAndClassRate(
			long smartActiveBenefitId, long smartActiveClassRateId) {

		return _smartActivePremiLocalService.getPremiByBenefitAndClassRate(
			smartActiveBenefitId, smartActiveClassRateId);
	}

	@Override
	public int getPremiCount() {
		return _smartActivePremiLocalService.getPremiCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActivePremi>
		getPremis() {

		return _smartActivePremiLocalService.getPremis();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActivePremi>
		getPremis(int start, int end) {

		return _smartActivePremiLocalService.getPremis(start, end);
	}

	/**
	 * Returns the smart active premi with the primary key.
	 *
	 * @param smartActivePremiId the primary key of the smart active premi
	 * @return the smart active premi
	 * @throws PortalException if a smart active premi with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActivePremi getSmartActivePremi(
			long smartActivePremiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActivePremiLocalService.getSmartActivePremi(
			smartActivePremiId);
	}

	/**
	 * Returns a range of all the smart active premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActivePremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active premis
	 * @param end the upper bound of the range of smart active premis (not inclusive)
	 * @return the range of smart active premis
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActivePremi>
		getSmartActivePremis(int start, int end) {

		return _smartActivePremiLocalService.getSmartActivePremis(start, end);
	}

	/**
	 * Returns the number of smart active premis.
	 *
	 * @return the number of smart active premis
	 */
	@Override
	public int getSmartActivePremisCount() {
		return _smartActivePremiLocalService.getSmartActivePremisCount();
	}

	@Override
	public com.mypage.admin.product.model.SmartActivePremi setActive(
		long premiId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _smartActivePremiLocalService.setActive(
			premiId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.SmartActivePremi updatePremi(
			long premiId, double rate, long benefitId, long classRateId,
			int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActivePremiLocalService.updatePremi(
			premiId, rate, benefitId, classRateId, active);
	}

	/**
	 * Updates the smart active premi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActivePremiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActivePremi the smart active premi
	 * @return the smart active premi that was updated
	 */
	@Override
	public com.mypage.admin.product.model.SmartActivePremi
		updateSmartActivePremi(
			com.mypage.admin.product.model.SmartActivePremi smartActivePremi) {

		return _smartActivePremiLocalService.updateSmartActivePremi(
			smartActivePremi);
	}

	@Override
	public SmartActivePremiLocalService getWrappedService() {
		return _smartActivePremiLocalService;
	}

	@Override
	public void setWrappedService(
		SmartActivePremiLocalService smartActivePremiLocalService) {

		_smartActivePremiLocalService = smartActivePremiLocalService;
	}

	private SmartActivePremiLocalService _smartActivePremiLocalService;

}