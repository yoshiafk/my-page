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
 * Provides a wrapper for {@link SmartActiveLinkLocalService}.
 *
 * @author Gositus Team
 * @see SmartActiveLinkLocalService
 * @generated
 */
public class SmartActiveLinkLocalServiceWrapper
	implements ServiceWrapper<SmartActiveLinkLocalService>,
			   SmartActiveLinkLocalService {

	public SmartActiveLinkLocalServiceWrapper(
		SmartActiveLinkLocalService smartActiveLinkLocalService) {

		_smartActiveLinkLocalService = smartActiveLinkLocalService;
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveLink addLink(
			String category, String title, String fileURL, long fileEntryId,
			int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveLinkLocalService.addLink(
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
	@Override
	public com.mypage.admin.product.model.SmartActiveLink addSmartActiveLink(
		com.mypage.admin.product.model.SmartActiveLink smartActiveLink) {

		return _smartActiveLinkLocalService.addSmartActiveLink(smartActiveLink);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveLinkLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new smart active link with the primary key. Does not add the smart active link to the database.
	 *
	 * @param smartActiveLinkId the primary key for the new smart active link
	 * @return the new smart active link
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveLink createSmartActiveLink(
		long smartActiveLinkId) {

		return _smartActiveLinkLocalService.createSmartActiveLink(
			smartActiveLinkId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveLinkLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public com.mypage.admin.product.model.SmartActiveLink deleteSmartActiveLink(
			long smartActiveLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveLinkLocalService.deleteSmartActiveLink(
			smartActiveLinkId);
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
	@Override
	public com.mypage.admin.product.model.SmartActiveLink deleteSmartActiveLink(
		com.mypage.admin.product.model.SmartActiveLink smartActiveLink) {

		return _smartActiveLinkLocalService.deleteSmartActiveLink(
			smartActiveLink);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smartActiveLinkLocalService.dynamicQuery();
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

		return _smartActiveLinkLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _smartActiveLinkLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _smartActiveLinkLocalService.dynamicQuery(
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

		return _smartActiveLinkLocalService.dynamicQueryCount(dynamicQuery);
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

		return _smartActiveLinkLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveLink fetchSmartActiveLink(
		long smartActiveLinkId) {

		return _smartActiveLinkLocalService.fetchSmartActiveLink(
			smartActiveLinkId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smartActiveLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveLink>
		getActiveLink() {

		return _smartActiveLinkLocalService.getActiveLink();
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveLink getByCategory(
		String category) {

		return _smartActiveLinkLocalService.getByCategory(category);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smartActiveLinkLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveLink>
		getLinks() {

		return _smartActiveLinkLocalService.getLinks();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveLink>
		getLinks(int start, int end) {

		return _smartActiveLinkLocalService.getLinks(start, end);
	}

	@Override
	public int getLinksCount() {
		return _smartActiveLinkLocalService.getLinksCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smartActiveLinkLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the smart active link with the primary key.
	 *
	 * @param smartActiveLinkId the primary key of the smart active link
	 * @return the smart active link
	 * @throws PortalException if a smart active link with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.SmartActiveLink getSmartActiveLink(
			long smartActiveLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveLinkLocalService.getSmartActiveLink(
			smartActiveLinkId);
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
	@Override
	public java.util.List<com.mypage.admin.product.model.SmartActiveLink>
		getSmartActiveLinks(int start, int end) {

		return _smartActiveLinkLocalService.getSmartActiveLinks(start, end);
	}

	/**
	 * Returns the number of smart active links.
	 *
	 * @return the number of smart active links
	 */
	@Override
	public int getSmartActiveLinksCount() {
		return _smartActiveLinkLocalService.getSmartActiveLinksCount();
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveLink setActive(
		long linkId, int active,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _smartActiveLinkLocalService.setActive(
			linkId, active, serviceContext);
	}

	@Override
	public com.mypage.admin.product.model.SmartActiveLink updateLink(
			long smartActiveLinkId, String category, String title,
			String fileURL, long fileEntryId, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smartActiveLinkLocalService.updateLink(
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
	@Override
	public com.mypage.admin.product.model.SmartActiveLink updateSmartActiveLink(
		com.mypage.admin.product.model.SmartActiveLink smartActiveLink) {

		return _smartActiveLinkLocalService.updateSmartActiveLink(
			smartActiveLink);
	}

	@Override
	public SmartActiveLinkLocalService getWrappedService() {
		return _smartActiveLinkLocalService;
	}

	@Override
	public void setWrappedService(
		SmartActiveLinkLocalService smartActiveLinkLocalService) {

		_smartActiveLinkLocalService = smartActiveLinkLocalService;
	}

	private SmartActiveLinkLocalService _smartActiveLinkLocalService;

}