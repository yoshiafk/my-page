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

import com.mypage.admin.product.model.SmartActiveTopro;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SmartActiveTopro. This utility wraps
 * <code>com.mypage.admin.product.service.impl.SmartActiveToproLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see SmartActiveToproLocalService
 * @generated
 */
public class SmartActiveToproLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.SmartActiveToproLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static SmartActiveTopro addSmartActiveTopro(
		SmartActiveTopro smartActiveTopro) {

		return getService().addSmartActiveTopro(smartActiveTopro);
	}

	public static SmartActiveTopro addTopro(
			String topro, String description, String annotations,
			long benefitValueId, String toc, int active)
		throws PortalException {

		return getService().addTopro(
			topro, description, annotations, benefitValueId, toc, active);
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
	 * Creates a new smart active topro with the primary key. Does not add the smart active topro to the database.
	 *
	 * @param smartActiveToproId the primary key for the new smart active topro
	 * @return the new smart active topro
	 */
	public static SmartActiveTopro createSmartActiveTopro(
		long smartActiveToproId) {

		return getService().createSmartActiveTopro(smartActiveToproId);
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
	public static SmartActiveTopro deleteSmartActiveTopro(
			long smartActiveToproId)
		throws PortalException {

		return getService().deleteSmartActiveTopro(smartActiveToproId);
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
	public static SmartActiveTopro deleteSmartActiveTopro(
		SmartActiveTopro smartActiveTopro) {

		return getService().deleteSmartActiveTopro(smartActiveTopro);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveToproModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveToproModelImpl</code>.
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

	public static SmartActiveTopro fetchSmartActiveTopro(
		long smartActiveToproId) {

		return getService().fetchSmartActiveTopro(smartActiveToproId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<SmartActiveTopro> getActiveTopro() {
		return getService().getActiveTopro();
	}

	public static SmartActiveTopro getByTopro(String topro) {
		return getService().getByTopro(topro);
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

	/**
	 * Returns the smart active topro with the primary key.
	 *
	 * @param smartActiveToproId the primary key of the smart active topro
	 * @return the smart active topro
	 * @throws PortalException if a smart active topro with the primary key could not be found
	 */
	public static SmartActiveTopro getSmartActiveTopro(long smartActiveToproId)
		throws PortalException {

		return getService().getSmartActiveTopro(smartActiveToproId);
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
	public static List<SmartActiveTopro> getSmartActiveTopros(
		int start, int end) {

		return getService().getSmartActiveTopros(start, end);
	}

	/**
	 * Returns the number of smart active topros.
	 *
	 * @return the number of smart active topros
	 */
	public static int getSmartActiveToprosCount() {
		return getService().getSmartActiveToprosCount();
	}

	public static SmartActiveTopro getToproByBenefitValue(long benefitValueId) {
		return getService().getToproByBenefitValue(benefitValueId);
	}

	public static int getToproCount() {
		return getService().getToproCount();
	}

	public static List<SmartActiveTopro> getTopros() {
		return getService().getTopros();
	}

	public static List<SmartActiveTopro> getTopros(int start, int end) {
		return getService().getTopros(start, end);
	}

	public static SmartActiveTopro setActive(
			long toproId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(toproId, active, serviceContext);
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
	public static SmartActiveTopro updateSmartActiveTopro(
		SmartActiveTopro smartActiveTopro) {

		return getService().updateSmartActiveTopro(smartActiveTopro);
	}

	public static SmartActiveTopro updateTopro(
			long toproId, String topro, String description, String annotations,
			long benefitValueId, String toc, int active)
		throws PortalException {

		return getService().updateTopro(
			toproId, topro, description, annotations, benefitValueId, toc,
			active);
	}

	public static SmartActiveToproLocalService getService() {
		return _service;
	}

	private static volatile SmartActiveToproLocalService _service;

}