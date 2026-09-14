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

package com.mypage.agencyportal.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.agencyportal.exception.NoSuchFAQCategoryException;
import com.mypage.agencyportal.model.FAQCategory;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the faq category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see FAQCategoryUtil
 * @generated
 */
@ProviderType
public interface FAQCategoryPersistence extends BasePersistence<FAQCategory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FAQCategoryUtil} to access the faq category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the faq category in the entity cache if it is enabled.
	 *
	 * @param faqCategory the faq category
	 */
	public void cacheResult(FAQCategory faqCategory);

	/**
	 * Caches the faq categories in the entity cache if it is enabled.
	 *
	 * @param faqCategories the faq categories
	 */
	public void cacheResult(java.util.List<FAQCategory> faqCategories);

	/**
	 * Creates a new faq category with the primary key. Does not add the faq category to the database.
	 *
	 * @param faqCategoryId the primary key for the new faq category
	 * @return the new faq category
	 */
	public FAQCategory create(long faqCategoryId);

	/**
	 * Removes the faq category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param faqCategoryId the primary key of the faq category
	 * @return the faq category that was removed
	 * @throws NoSuchFAQCategoryException if a faq category with the primary key could not be found
	 */
	public FAQCategory remove(long faqCategoryId)
		throws NoSuchFAQCategoryException;

	public FAQCategory updateImpl(FAQCategory faqCategory);

	/**
	 * Returns the faq category with the primary key or throws a <code>NoSuchFAQCategoryException</code> if it could not be found.
	 *
	 * @param faqCategoryId the primary key of the faq category
	 * @return the faq category
	 * @throws NoSuchFAQCategoryException if a faq category with the primary key could not be found
	 */
	public FAQCategory findByPrimaryKey(long faqCategoryId)
		throws NoSuchFAQCategoryException;

	/**
	 * Returns the faq category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param faqCategoryId the primary key of the faq category
	 * @return the faq category, or <code>null</code> if a faq category with the primary key could not be found
	 */
	public FAQCategory fetchByPrimaryKey(long faqCategoryId);

	/**
	 * Returns all the faq categories.
	 *
	 * @return the faq categories
	 */
	public java.util.List<FAQCategory> findAll();

	/**
	 * Returns a range of all the faq categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FAQCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faq categories
	 * @param end the upper bound of the range of faq categories (not inclusive)
	 * @return the range of faq categories
	 */
	public java.util.List<FAQCategory> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the faq categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FAQCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faq categories
	 * @param end the upper bound of the range of faq categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faq categories
	 */
	public java.util.List<FAQCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FAQCategory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faq categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FAQCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faq categories
	 * @param end the upper bound of the range of faq categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faq categories
	 */
	public java.util.List<FAQCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FAQCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the faq categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of faq categories.
	 *
	 * @return the number of faq categories
	 */
	public int countAll();

}