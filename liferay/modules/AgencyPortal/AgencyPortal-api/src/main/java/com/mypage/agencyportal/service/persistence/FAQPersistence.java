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

import com.mypage.agencyportal.exception.NoSuchFAQException;
import com.mypage.agencyportal.model.FAQ;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the faq service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see FAQUtil
 * @generated
 */
@ProviderType
public interface FAQPersistence extends BasePersistence<FAQ> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FAQUtil} to access the faq persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the faqs where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching faqs
	 */
	public java.util.List<FAQ> findBycategory(String category);

	/**
	 * Returns a range of all the faqs where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FAQModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @return the range of matching faqs
	 */
	public java.util.List<FAQ> findBycategory(
		String category, int start, int end);

	/**
	 * Returns an ordered range of all the faqs where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FAQModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faqs
	 */
	public java.util.List<FAQ> findBycategory(
		String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FAQ>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faqs where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FAQModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faqs
	 */
	public java.util.List<FAQ> findBycategory(
		String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FAQ> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first faq in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq
	 * @throws NoSuchFAQException if a matching faq could not be found
	 */
	public FAQ findBycategory_First(
			String category,
			com.liferay.portal.kernel.util.OrderByComparator<FAQ>
				orderByComparator)
		throws NoSuchFAQException;

	/**
	 * Returns the first faq in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq, or <code>null</code> if a matching faq could not be found
	 */
	public FAQ fetchBycategory_First(
		String category,
		com.liferay.portal.kernel.util.OrderByComparator<FAQ>
			orderByComparator);

	/**
	 * Returns the last faq in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq
	 * @throws NoSuchFAQException if a matching faq could not be found
	 */
	public FAQ findBycategory_Last(
			String category,
			com.liferay.portal.kernel.util.OrderByComparator<FAQ>
				orderByComparator)
		throws NoSuchFAQException;

	/**
	 * Returns the last faq in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq, or <code>null</code> if a matching faq could not be found
	 */
	public FAQ fetchBycategory_Last(
		String category,
		com.liferay.portal.kernel.util.OrderByComparator<FAQ>
			orderByComparator);

	/**
	 * Returns the faqs before and after the current faq in the ordered set where category = &#63;.
	 *
	 * @param faqId the primary key of the current faq
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faq
	 * @throws NoSuchFAQException if a faq with the primary key could not be found
	 */
	public FAQ[] findBycategory_PrevAndNext(
			long faqId, String category,
			com.liferay.portal.kernel.util.OrderByComparator<FAQ>
				orderByComparator)
		throws NoSuchFAQException;

	/**
	 * Removes all the faqs where category = &#63; from the database.
	 *
	 * @param category the category
	 */
	public void removeBycategory(String category);

	/**
	 * Returns the number of faqs where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching faqs
	 */
	public int countBycategory(String category);

	/**
	 * Caches the faq in the entity cache if it is enabled.
	 *
	 * @param faq the faq
	 */
	public void cacheResult(FAQ faq);

	/**
	 * Caches the faqs in the entity cache if it is enabled.
	 *
	 * @param faqs the faqs
	 */
	public void cacheResult(java.util.List<FAQ> faqs);

	/**
	 * Creates a new faq with the primary key. Does not add the faq to the database.
	 *
	 * @param faqId the primary key for the new faq
	 * @return the new faq
	 */
	public FAQ create(long faqId);

	/**
	 * Removes the faq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param faqId the primary key of the faq
	 * @return the faq that was removed
	 * @throws NoSuchFAQException if a faq with the primary key could not be found
	 */
	public FAQ remove(long faqId) throws NoSuchFAQException;

	public FAQ updateImpl(FAQ faq);

	/**
	 * Returns the faq with the primary key or throws a <code>NoSuchFAQException</code> if it could not be found.
	 *
	 * @param faqId the primary key of the faq
	 * @return the faq
	 * @throws NoSuchFAQException if a faq with the primary key could not be found
	 */
	public FAQ findByPrimaryKey(long faqId) throws NoSuchFAQException;

	/**
	 * Returns the faq with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param faqId the primary key of the faq
	 * @return the faq, or <code>null</code> if a faq with the primary key could not be found
	 */
	public FAQ fetchByPrimaryKey(long faqId);

	/**
	 * Returns all the faqs.
	 *
	 * @return the faqs
	 */
	public java.util.List<FAQ> findAll();

	/**
	 * Returns a range of all the faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FAQModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @return the range of faqs
	 */
	public java.util.List<FAQ> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FAQModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faqs
	 */
	public java.util.List<FAQ> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FAQ>
			orderByComparator);

	/**
	 * Returns an ordered range of all the faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FAQModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faqs
	 */
	public java.util.List<FAQ> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FAQ> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the faqs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of faqs.
	 *
	 * @return the number of faqs
	 */
	public int countAll();

}