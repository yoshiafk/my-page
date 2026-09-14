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
 * Provides a wrapper for {@link FAQLocalService}.
 *
 * @author Gositus Team
 * @see FAQLocalService
 * @generated
 */
public class FAQLocalServiceWrapper
	implements FAQLocalService, ServiceWrapper<FAQLocalService> {

	public FAQLocalServiceWrapper(FAQLocalService faqLocalService) {
		_faqLocalService = faqLocalService;
	}

	/**
	 * Adds the faq to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FAQLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param faq the faq
	 * @return the faq that was added
	 */
	@Override
	public com.mypage.agencyportal.model.FAQ addFAQ(
		com.mypage.agencyportal.model.FAQ faq) {

		return _faqLocalService.addFAQ(faq);
	}

	/**
	 * Creates a new faq with the primary key. Does not add the faq to the database.
	 *
	 * @param faqId the primary key for the new faq
	 * @return the new faq
	 */
	@Override
	public com.mypage.agencyportal.model.FAQ createFAQ(long faqId) {
		return _faqLocalService.createFAQ(faqId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the faq from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FAQLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param faq the faq
	 * @return the faq that was removed
	 */
	@Override
	public com.mypage.agencyportal.model.FAQ deleteFAQ(
		com.mypage.agencyportal.model.FAQ faq) {

		return _faqLocalService.deleteFAQ(faq);
	}

	/**
	 * Deletes the faq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FAQLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param faqId the primary key of the faq
	 * @return the faq that was removed
	 * @throws PortalException if a faq with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.FAQ deleteFAQ(long faqId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqLocalService.deleteFAQ(faqId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _faqLocalService.dynamicQuery();
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

		return _faqLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.FAQModelImpl</code>.
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

		return _faqLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.FAQModelImpl</code>.
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

		return _faqLocalService.dynamicQuery(
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

		return _faqLocalService.dynamicQueryCount(dynamicQuery);
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

		return _faqLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.mypage.agencyportal.model.FAQ fetchFAQ(long faqId) {
		return _faqLocalService.fetchFAQ(faqId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _faqLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the faq with the primary key.
	 *
	 * @param faqId the primary key of the faq
	 * @return the faq
	 * @throws PortalException if a faq with the primary key could not be found
	 */
	@Override
	public com.mypage.agencyportal.model.FAQ getFAQ(long faqId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqLocalService.getFAQ(faqId);
	}

	/**
	 * Returns a range of all the faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.agencyportal.model.impl.FAQModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @return the range of faqs
	 */
	@Override
	public java.util.List<com.mypage.agencyportal.model.FAQ> getFAQs(
		int start, int end) {

		return _faqLocalService.getFAQs(start, end);
	}

	/**
	 * Returns the number of faqs.
	 *
	 * @return the number of faqs
	 */
	@Override
	public int getFAQsCount() {
		return _faqLocalService.getFAQsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _faqLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _faqLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the faq in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FAQLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param faq the faq
	 * @return the faq that was updated
	 */
	@Override
	public com.mypage.agencyportal.model.FAQ updateFAQ(
		com.mypage.agencyportal.model.FAQ faq) {

		return _faqLocalService.updateFAQ(faq);
	}

	@Override
	public FAQLocalService getWrappedService() {
		return _faqLocalService;
	}

	@Override
	public void setWrappedService(FAQLocalService faqLocalService) {
		_faqLocalService = faqLocalService;
	}

	private FAQLocalService _faqLocalService;

}