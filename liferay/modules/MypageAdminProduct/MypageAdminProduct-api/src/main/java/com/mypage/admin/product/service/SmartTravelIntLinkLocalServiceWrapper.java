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
 * Provides a wrapper for {@link SmartTravelIntLinkLocalService}.
 *
 * @author Gositus Team
 * @see SmartTravelIntLinkLocalService
 * @generated
 */
public class SmartTravelIntLinkLocalServiceWrapper
	implements ServiceWrapper<SmartTravelIntLinkLocalService>,
			   SmartTravelIntLinkLocalService {

	public SmartTravelIntLinkLocalServiceWrapper(
		SmartTravelIntLinkLocalService smartTravelIntLinkLocalService) {

		_smartTravelIntLinkLocalService = smartTravelIntLinkLocalService;
	}

	@Override
	public com.mypage.admin.product.model.SmartTravelIntLink addLink(
			String linkType, String linkTitle, String linkHref)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartTravelIntLinkLocalService.addLink(
			linkType, linkTitle, linkHref);
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
	@Override
	public com.mypage.admin.product.model.SmartTravelIntLink
		addSmartTravelIntLink(
			com.mypage.admin.product.model.SmartTravelIntLink
				smartTravelIntLink) {

		return _smartTravelIntLinkLocalService.addSmartTravelIntLink(
			smartTravelIntLink);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartTravelIntLinkLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new smart travel int link with the primary key. Does not add the smart travel int link to the database.
	 *
	 * @param smartTravelIntLinkId the primary key for the new smart travel int link
	 * @return the new smart travel int link
	 */
	@Override
	public com.mypage.admin.product.model.SmartTravelIntLink
		createSmartTravelIntLink(long smartTravelIntLinkId) {

		return _smartTravelIntLinkLocalService.createSmartTravelIntLink(
			smartTravelIntLinkId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartTravelIntLinkLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public com.mypage.admin.product.model.SmartTravelIntLink
			deleteSmartTravelIntLink(long smartTravelIntLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartTravelIntLinkLocalService.deleteSmartTravelIntLink(
			smartTravelIntLinkId);
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
	@Override
	public com.mypage.admin.product.model.SmartTravelIntLink
		deleteSmartTravelIntLink(
			com.mypage.admin.product.model.SmartTravelIntLink
				smartTravelIntLink) {

		return _smartTravelIntLinkLocalService.deleteSmartTravelIntLink(
			smartTravelIntLink);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smartTravelIntLinkLocalService.dynamicQuery();
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

		return _smartTravelIntLinkLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _smartTravelIntLinkLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _smartTravelIntLinkLocalService.dynamicQuery(
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

		return _smartTravelIntLinkLocalService.dynamicQueryCount(dynamicQuery);
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

		return _smartTravelIntLinkLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.SmartTravelIntLink
		fetchSmartTravelIntLink(long smartTravelIntLinkId) {

		return _smartTravelIntLinkLocalService.fetchSmartTravelIntLink(
			smartTravelIntLinkId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smartTravelIntLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.mypage.admin.product.model.SmartTravelIntLink getByLinkType(
		String linkType) {

		return _smartTravelIntLinkLocalService.getByLinkType(linkType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smartTravelIntLinkLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartTravelIntLink>
		getLinks() {

		return _smartTravelIntLinkLocalService.getLinks();
	}

	@Override
	public int getLinksCount() {
		return _smartTravelIntLinkLocalService.getLinksCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartTravelIntLinkLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartTravelIntLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the smart travel int link with the primary key.
	 *
	 * @param smartTravelIntLinkId the primary key of the smart travel int link
	 * @return the smart travel int link
	 * @throws PortalException if a smart travel int link with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartTravelIntLink
			getSmartTravelIntLink(long smartTravelIntLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartTravelIntLinkLocalService.getSmartTravelIntLink(
			smartTravelIntLinkId);
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
	@Override
	public java.util.List<com.mypage.admin.product.model.SmartTravelIntLink>
		getSmartTravelIntLinks(int start, int end) {

		return _smartTravelIntLinkLocalService.getSmartTravelIntLinks(
			start, end);
	}

	/**
	 * Returns the number of smart travel int links.
	 *
	 * @return the number of smart travel int links
	 */
	@Override
	public int getSmartTravelIntLinksCount() {
		return _smartTravelIntLinkLocalService.getSmartTravelIntLinksCount();
	}

	@Override
	public com.mypage.admin.product.model.SmartTravelIntLink updateLink(
			long smartTravelIntLinkId, String linkType, String linkTitle,
			String linkHref)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartTravelIntLinkLocalService.updateLink(
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
	@Override
	public com.mypage.admin.product.model.SmartTravelIntLink
		updateSmartTravelIntLink(
			com.mypage.admin.product.model.SmartTravelIntLink
				smartTravelIntLink) {

		return _smartTravelIntLinkLocalService.updateSmartTravelIntLink(
			smartTravelIntLink);
	}

	@Override
	public SmartTravelIntLinkLocalService getWrappedService() {
		return _smartTravelIntLinkLocalService;
	}

	@Override
	public void setWrappedService(
		SmartTravelIntLinkLocalService smartTravelIntLinkLocalService) {

		_smartTravelIntLinkLocalService = smartTravelIntLinkLocalService;
	}

	private SmartTravelIntLinkLocalService _smartTravelIntLinkLocalService;

}