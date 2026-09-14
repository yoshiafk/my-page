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

import com.mypage.admin.product.model.SmartTravelIntLink;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SmartTravelIntLink. This utility wraps
 * <code>com.mypage.admin.product.service.impl.SmartTravelIntLinkLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see SmartTravelIntLinkLocalService
 * @generated
 */
public class SmartTravelIntLinkLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.SmartTravelIntLinkLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SmartTravelIntLink addLink(
			String linkType, String linkTitle, String linkHref)
		throws PortalException {

		return getService().addLink(linkType, linkTitle, linkHref);
	}

	/**
	 * Adds the smart travel int link to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartTravelIntLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartTravelIntLink the smart travel int link
	 * @return the smart travel int link that was added
	 */
	public static SmartTravelIntLink addSmartTravelIntLink(
		SmartTravelIntLink smartTravelIntLink) {

		return getService().addSmartTravelIntLink(smartTravelIntLink);
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
	 * Creates a new smart travel int link with the primary key. Does not add the smart travel int link to the database.
	 *
	 * @param smartTravelIntLinkId the primary key for the new smart travel int link
	 * @return the new smart travel int link
	 */
	public static SmartTravelIntLink createSmartTravelIntLink(
		long smartTravelIntLinkId) {

		return getService().createSmartTravelIntLink(smartTravelIntLinkId);
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
	 * Deletes the smart travel int link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartTravelIntLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartTravelIntLinkId the primary key of the smart travel int link
	 * @return the smart travel int link that was removed
	 * @throws PortalException if a smart travel int link with the primary key could not be found
	 */
	public static SmartTravelIntLink deleteSmartTravelIntLink(
			long smartTravelIntLinkId)
		throws PortalException {

		return getService().deleteSmartTravelIntLink(smartTravelIntLinkId);
	}

	/**
	 * Deletes the smart travel int link from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartTravelIntLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartTravelIntLink the smart travel int link
	 * @return the smart travel int link that was removed
	 */
	public static SmartTravelIntLink deleteSmartTravelIntLink(
		SmartTravelIntLink smartTravelIntLink) {

		return getService().deleteSmartTravelIntLink(smartTravelIntLink);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartTravelIntLinkModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartTravelIntLinkModelImpl</code>.
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

	public static SmartTravelIntLink fetchSmartTravelIntLink(
		long smartTravelIntLinkId) {

		return getService().fetchSmartTravelIntLink(smartTravelIntLinkId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static SmartTravelIntLink getByLinkType(String linkType) {
		return getService().getByLinkType(linkType);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static List<SmartTravelIntLink> getLinks() {
		return getService().getLinks();
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
	 * Returns the smart travel int link with the primary key.
	 *
	 * @param smartTravelIntLinkId the primary key of the smart travel int link
	 * @return the smart travel int link
	 * @throws PortalException if a smart travel int link with the primary key could not be found
	 */
	public static SmartTravelIntLink getSmartTravelIntLink(
			long smartTravelIntLinkId)
		throws PortalException {

		return getService().getSmartTravelIntLink(smartTravelIntLinkId);
	}

	/**
	 * Returns a range of all the smart travel int links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartTravelIntLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart travel int links
	 * @param end the upper bound of the range of smart travel int links (not inclusive)
	 * @return the range of smart travel int links
	 */
	public static List<SmartTravelIntLink> getSmartTravelIntLinks(
		int start, int end) {

		return getService().getSmartTravelIntLinks(start, end);
	}

	/**
	 * Returns the number of smart travel int links.
	 *
	 * @return the number of smart travel int links
	 */
	public static int getSmartTravelIntLinksCount() {
		return getService().getSmartTravelIntLinksCount();
	}

	public static SmartTravelIntLink updateLink(
			long smartTravelIntLinkId, String linkType, String linkTitle,
			String linkHref)
		throws PortalException {

		return getService().updateLink(
			smartTravelIntLinkId, linkType, linkTitle, linkHref);
	}

	/**
	 * Updates the smart travel int link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartTravelIntLinkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartTravelIntLink the smart travel int link
	 * @return the smart travel int link that was updated
	 */
	public static SmartTravelIntLink updateSmartTravelIntLink(
		SmartTravelIntLink smartTravelIntLink) {

		return getService().updateSmartTravelIntLink(smartTravelIntLink);
	}

	public static SmartTravelIntLinkLocalService getService() {
		return _service;
	}

	private static volatile SmartTravelIntLinkLocalService _service;

}