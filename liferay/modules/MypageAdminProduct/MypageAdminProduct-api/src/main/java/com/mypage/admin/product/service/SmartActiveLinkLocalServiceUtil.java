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

import com.mypage.admin.product.model.SmartActiveLink;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SmartActiveLink. This utility wraps
 * <code>com.mypage.admin.product.service.impl.SmartActiveLinkLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see SmartActiveLinkLocalService
 * @generated
 */
public class SmartActiveLinkLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.SmartActiveLinkLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SmartActiveLink addLink(
			String category, String title, String fileURL, long fileEntryId,
			int active)
		throws PortalException {

		return getService().addLink(
			category, title, fileURL, fileEntryId, active);
	}

	/**
	 * Adds the smart active link to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveLink the smart active link
	 * @return the smart active link that was added
	 */
	public static SmartActiveLink addSmartActiveLink(
		SmartActiveLink smartActiveLink) {

		return getService().addSmartActiveLink(smartActiveLink);
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
	 * Creates a new smart active link with the primary key. Does not add the smart active link to the database.
	 *
	 * @param smartActiveLinkId the primary key for the new smart active link
	 * @return the new smart active link
	 */
	public static SmartActiveLink createSmartActiveLink(
		long smartActiveLinkId) {

		return getService().createSmartActiveLink(smartActiveLinkId);
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
	 * Deletes the smart active link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveLinkId the primary key of the smart active link
	 * @return the smart active link that was removed
	 * @throws PortalException if a smart active link with the primary key could not be found
	 */
	public static SmartActiveLink deleteSmartActiveLink(long smartActiveLinkId)
		throws PortalException {

		return getService().deleteSmartActiveLink(smartActiveLinkId);
	}

	/**
	 * Deletes the smart active link from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveLink the smart active link
	 * @return the smart active link that was removed
	 */
	public static SmartActiveLink deleteSmartActiveLink(
		SmartActiveLink smartActiveLink) {

		return getService().deleteSmartActiveLink(smartActiveLink);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveLinkModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveLinkModelImpl</code>.
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

	public static SmartActiveLink fetchSmartActiveLink(long smartActiveLinkId) {
		return getService().fetchSmartActiveLink(smartActiveLinkId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<SmartActiveLink> getActiveLink() {
		return getService().getActiveLink();
	}

	public static SmartActiveLink getByCategory(String category) {
		return getService().getByCategory(category);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<SmartActiveLink> getLinks() {
		return getService().getLinks();
	}

	public static List<SmartActiveLink> getLinks(int start, int end) {
		return getService().getLinks(start, end);
	}

	public static int getLinksCount() {
		return getService().getLinksCount();
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
	 * Returns the smart active link with the primary key.
	 *
	 * @param smartActiveLinkId the primary key of the smart active link
	 * @return the smart active link
	 * @throws PortalException if a smart active link with the primary key could not be found
	 */
	public static SmartActiveLink getSmartActiveLink(long smartActiveLinkId)
		throws PortalException {

		return getService().getSmartActiveLink(smartActiveLinkId);
	}

	/**
	 * Returns a range of all the smart active links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active links
	 * @param end the upper bound of the range of smart active links (not inclusive)
	 * @return the range of smart active links
	 */
	public static List<SmartActiveLink> getSmartActiveLinks(
		int start, int end) {

		return getService().getSmartActiveLinks(start, end);
	}

	/**
	 * Returns the number of smart active links.
	 *
	 * @return the number of smart active links
	 */
	public static int getSmartActiveLinksCount() {
		return getService().getSmartActiveLinksCount();
	}

	public static SmartActiveLink setActive(
		long linkId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().setActive(linkId, active, serviceContext);
	}

	public static SmartActiveLink updateLink(
			long smartActiveLinkId, String category, String title,
			String fileURL, long fileEntryId, int active)
		throws PortalException {

		return getService().updateLink(
			smartActiveLinkId, category, title, fileURL, fileEntryId, active);
	}

	/**
	 * Updates the smart active link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveLink the smart active link
	 * @return the smart active link that was updated
	 */
	public static SmartActiveLink updateSmartActiveLink(
		SmartActiveLink smartActiveLink) {

		return getService().updateSmartActiveLink(smartActiveLink);
	}

	public static SmartActiveLinkLocalService getService() {
		return _service;
	}

	private static volatile SmartActiveLinkLocalService _service;

}