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

package com.mypage.agencyportal.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FAQCategoryLocalService}.
 *
 * @author Gositus Team
 * @see FAQCategoryLocalService
 * @generated
 */
public class FAQCategoryLocalServiceWrapper
	implements FAQCategoryLocalService,
			   ServiceWrapper<FAQCategoryLocalService> {

	public FAQCategoryLocalServiceWrapper(
		FAQCategoryLocalService faqCategoryLocalService) {

		_faqCategoryLocalService = faqCategoryLocalService;
	}

	/**
	 * Adds the faq category to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FAQCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param faqCategory the faq category
	 * @return the faq category that was added
	 */
	@Override
	public com.mypage.agencyportal.model.FAQCategory addFAQCategory(
		com.mypage.agencyportal.model.FAQCategory faqCategory) {

		return _faqCategoryLocalService.addFAQCategory(faqCategory);
	}

	/**
	 * Creates a new faq category with the primary key. Does not add the faq category to the database.
	 *
	 * @param faqCategoryId the primary key for the new faq category
	 * @return the new faq category
	 */
	@Override
	public com.mypage.agencyportal.model.FAQCategory createFAQCategory(
		long faqCategoryId) {

		return _faqCategoryLocalService.createFAQCategory(faqCategoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqCategoryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the faq category from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FAQCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param faqCategory the faq category
	 * @return the faq category that was removed
	 */
	@Override
	public com.mypage.agencyportal.model.FAQCategory deleteFAQCategory(
		com.mypage.agencyportal.model.FAQCategory faqCategory) {

		return _faqCategoryLocalService.deleteFAQCategory(faqCategory);
	}

	/**
	 * Deletes the faq category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FAQCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param faqCategoryId the primary key of the faq category
	 * @return the faq category that was removed
	 * @throws PortalException if a faq category with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.FAQCategory deleteFAQCategory(
			long faqCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqCategoryLocalService.deleteFAQCategory(faqCategoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqCategoryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _faqCategoryLocalService.dynamicQuery();
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

		return _faqCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.FAQCategoryModelImpl</code>.
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

		return _faqCategoryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.FAQCategoryModelImpl</code>.
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

		return _faqCategoryLocalService.dynamicQuery(
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

		return _faqCategoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _faqCategoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mypage.agencyportal.model.FAQCategory fetchFAQCategory(
		long faqCategoryId) {

		return _faqCategoryLocalService.fetchFAQCategory(faqCategoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _faqCategoryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the faq categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.FAQCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faq categories
	 * @param end the upper bound of the range of faq categories (not inclusive)
	 * @return the range of faq categories
	 */
	@Override
	public java.util.List<com.mypage.agencyportal.model.FAQCategory>
		getFAQCategories(int start, int end) {

		return _faqCategoryLocalService.getFAQCategories(start, end);
	}

	/**
	 * Returns the number of faq categories.
	 *
	 * @return the number of faq categories
	 */
	@Override
	public int getFAQCategoriesCount() {
		return _faqCategoryLocalService.getFAQCategoriesCount();
	}

	/**
	 * Returns the faq category with the primary key.
	 *
	 * @param faqCategoryId the primary key of the faq category
	 * @return the faq category
	 * @throws PortalException if a faq category with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.FAQCategory getFAQCategory(
			long faqCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqCategoryLocalService.getFAQCategory(faqCategoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _faqCategoryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _faqCategoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the faq category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FAQCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param faqCategory the faq category
	 * @return the faq category that was updated
	 */
	@Override
	public com.mypage.agencyportal.model.FAQCategory updateFAQCategory(
		com.mypage.agencyportal.model.FAQCategory faqCategory) {

		return _faqCategoryLocalService.updateFAQCategory(faqCategory);
	}

	@Override
	public FAQCategoryLocalService getWrappedService() {
		return _faqCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		FAQCategoryLocalService faqCategoryLocalService) {

		_faqCategoryLocalService = faqCategoryLocalService;
	}

	private FAQCategoryLocalService _faqCategoryLocalService;

}