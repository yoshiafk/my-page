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

package com.mypage.admin.product.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.admin.product.exception.NoSuchSmartActiveLinkException;
import com.mypage.admin.product.model.SmartActiveLink;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the smart active link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartActiveLinkUtil
 * @generated
 */
@ProviderType
public interface SmartActiveLinkPersistence
	extends BasePersistence<SmartActiveLink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SmartActiveLinkUtil} to access the smart active link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the smart active link where category = &#63; or throws a <code>NoSuchSmartActiveLinkException</code> if it could not be found.
	 *
	 * @param category the category
	 * @return the matching smart active link
	 * @throws NoSuchSmartActiveLinkException if a matching smart active link could not be found
	 */
	public SmartActiveLink findBycategory(String category)
		throws NoSuchSmartActiveLinkException;

	/**
	 * Returns the smart active link where category = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param category the category
	 * @return the matching smart active link, or <code>null</code> if a matching smart active link could not be found
	 */
	public SmartActiveLink fetchBycategory(String category);

	/**
	 * Returns the smart active link where category = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param category the category
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active link, or <code>null</code> if a matching smart active link could not be found
	 */
	public SmartActiveLink fetchBycategory(
		String category, boolean useFinderCache);

	/**
	 * Removes the smart active link where category = &#63; from the database.
	 *
	 * @param category the category
	 * @return the smart active link that was removed
	 */
	public SmartActiveLink removeBycategory(String category)
		throws NoSuchSmartActiveLinkException;

	/**
	 * Returns the number of smart active links where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching smart active links
	 */
	public int countBycategory(String category);

	/**
	 * Caches the smart active link in the entity cache if it is enabled.
	 *
	 * @param smartActiveLink the smart active link
	 */
	public void cacheResult(SmartActiveLink smartActiveLink);

	/**
	 * Caches the smart active links in the entity cache if it is enabled.
	 *
	 * @param smartActiveLinks the smart active links
	 */
	public void cacheResult(java.util.List<SmartActiveLink> smartActiveLinks);

	/**
	 * Creates a new smart active link with the primary key. Does not add the smart active link to the database.
	 *
	 * @param smartActiveLinkId the primary key for the new smart active link
	 * @return the new smart active link
	 */
	public SmartActiveLink create(long smartActiveLinkId);

	/**
	 * Removes the smart active link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveLinkId the primary key of the smart active link
	 * @return the smart active link that was removed
	 * @throws NoSuchSmartActiveLinkException if a smart active link with the primary key could not be found
	 */
	public SmartActiveLink remove(long smartActiveLinkId)
		throws NoSuchSmartActiveLinkException;

	public SmartActiveLink updateImpl(SmartActiveLink smartActiveLink);

	/**
	 * Returns the smart active link with the primary key or throws a <code>NoSuchSmartActiveLinkException</code> if it could not be found.
	 *
	 * @param smartActiveLinkId the primary key of the smart active link
	 * @return the smart active link
	 * @throws NoSuchSmartActiveLinkException if a smart active link with the primary key could not be found
	 */
	public SmartActiveLink findByPrimaryKey(long smartActiveLinkId)
		throws NoSuchSmartActiveLinkException;

	/**
	 * Returns the smart active link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveLinkId the primary key of the smart active link
	 * @return the smart active link, or <code>null</code> if a smart active link with the primary key could not be found
	 */
	public SmartActiveLink fetchByPrimaryKey(long smartActiveLinkId);

	/**
	 * Returns all the smart active links.
	 *
	 * @return the smart active links
	 */
	public java.util.List<SmartActiveLink> findAll();

	/**
	 * Returns a range of all the smart active links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active links
	 * @param end the upper bound of the range of smart active links (not inclusive)
	 * @return the range of smart active links
	 */
	public java.util.List<SmartActiveLink> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the smart active links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active links
	 * @param end the upper bound of the range of smart active links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active links
	 */
	public java.util.List<SmartActiveLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActiveLink>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smart active links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active links
	 * @param end the upper bound of the range of smart active links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active links
	 */
	public java.util.List<SmartActiveLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartActiveLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the smart active links from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of smart active links.
	 *
	 * @return the number of smart active links
	 */
	public int countAll();

}