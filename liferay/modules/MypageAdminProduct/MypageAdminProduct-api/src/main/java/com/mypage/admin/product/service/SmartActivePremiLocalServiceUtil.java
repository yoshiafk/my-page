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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.SmartActivePremi;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SmartActivePremi. This utility wraps
 * <code>com.mypage.admin.product.service.impl.SmartActivePremiLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see SmartActivePremiLocalService
 * @generated
 */
public class SmartActivePremiLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.SmartActivePremiLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SmartActivePremi addPremi(
			double rate, int active, long benefitId, long classRateId)
		throws PortalException {

		return getService().addPremi(rate, active, benefitId, classRateId);
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
	public static SmartActivePremi addSmartActivePremi(
		SmartActivePremi smartActivePremi) {

		return getService().addSmartActivePremi(smartActivePremi);
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
	 * Creates a new smart active premi with the primary key. Does not add the smart active premi to the database.
	 *
	 * @param smartActivePremiId the primary key for the new smart active premi
	 * @return the new smart active premi
	 */
	public static SmartActivePremi createSmartActivePremi(
		long smartActivePremiId) {

		return getService().createSmartActivePremi(smartActivePremiId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static SmartActivePremi deleteSmartActivePremi(
			long smartActivePremiId)
		throws PortalException {

		return getService().deleteSmartActivePremi(smartActivePremiId);
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
	public static SmartActivePremi deleteSmartActivePremi(
		SmartActivePremi smartActivePremi) {

		return getService().deleteSmartActivePremi(smartActivePremi);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActivePremiModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActivePremiModelImpl</code>.
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

	public static SmartActivePremi fetchSmartActivePremi(
		long smartActivePremiId) {

		return getService().fetchSmartActivePremi(smartActivePremiId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<SmartActivePremi> getActivePremi() {
		return getService().getActivePremi();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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

	public static SmartActivePremi getPremiByBenefitAndClassRate(
		long smartActiveBenefitId, long smartActiveClassRateId) {

		return getService().getPremiByBenefitAndClassRate(
			smartActiveBenefitId, smartActiveClassRateId);
	}

	public static int getPremiCount() {
		return getService().getPremiCount();
	}

	public static List<SmartActivePremi> getPremis() {
		return getService().getPremis();
	}

	public static List<SmartActivePremi> getPremis(int start, int end) {
		return getService().getPremis(start, end);
	}

	/**
	 * Returns the smart active premi with the primary key.
	 *
	 * @param smartActivePremiId the primary key of the smart active premi
	 * @return the smart active premi
	 * @throws PortalException if a smart active premi with the primary key could not be found
	 */
	public static SmartActivePremi getSmartActivePremi(long smartActivePremiId)
		throws PortalException {

		return getService().getSmartActivePremi(smartActivePremiId);
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
	public static List<SmartActivePremi> getSmartActivePremis(
		int start, int end) {

		return getService().getSmartActivePremis(start, end);
	}

	/**
	 * Returns the number of smart active premis.
	 *
	 * @return the number of smart active premis
	 */
	public static int getSmartActivePremisCount() {
		return getService().getSmartActivePremisCount();
	}

	public static SmartActivePremi setActive(
		long premiId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().setActive(premiId, active, serviceContext);
	}

	public static SmartActivePremi updatePremi(
			long premiId, double rate, long benefitId, long classRateId,
			int active)
		throws PortalException {

		return getService().updatePremi(
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
	public static SmartActivePremi updateSmartActivePremi(
		SmartActivePremi smartActivePremi) {

		return getService().updateSmartActivePremi(smartActivePremi);
	}

	public static SmartActivePremiLocalService getService() {
		return _service;
	}

	private static volatile SmartActivePremiLocalService _service;

}