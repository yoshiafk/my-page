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

import com.mypage.admin.product.exception.NoSuchSmartTravelIntLinkException;
import com.mypage.admin.product.model.SmartTravelIntLink;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the smart travel int link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartTravelIntLinkUtil
 * @generated
 */
@ProviderType
public interface SmartTravelIntLinkPersistence
	extends BasePersistence<SmartTravelIntLink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SmartTravelIntLinkUtil} to access the smart travel int link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the smart travel int link where linkType = &#63; or throws a <code>NoSuchSmartTravelIntLinkException</code> if it could not be found.
	 *
	 * @param linkType the link type
	 * @return the matching smart travel int link
	 * @throws NoSuchSmartTravelIntLinkException if a matching smart travel int link could not be found
	 */
	public SmartTravelIntLink findByLinkType(String linkType)
		throws NoSuchSmartTravelIntLinkException;

	/**
	 * Returns the smart travel int link where linkType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param linkType the link type
	 * @return the matching smart travel int link, or <code>null</code> if a matching smart travel int link could not be found
	 */
	public SmartTravelIntLink fetchByLinkType(String linkType);

	/**
	 * Returns the smart travel int link where linkType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param linkType the link type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart travel int link, or <code>null</code> if a matching smart travel int link could not be found
	 */
	public SmartTravelIntLink fetchByLinkType(
		String linkType, boolean useFinderCache);

	/**
	 * Removes the smart travel int link where linkType = &#63; from the database.
	 *
	 * @param linkType the link type
	 * @return the smart travel int link that was removed
	 */
	public SmartTravelIntLink removeByLinkType(String linkType)
		throws NoSuchSmartTravelIntLinkException;

	/**
	 * Returns the number of smart travel int links where linkType = &#63;.
	 *
	 * @param linkType the link type
	 * @return the number of matching smart travel int links
	 */
	public int countByLinkType(String linkType);

	/**
	 * Caches the smart travel int link in the entity cache if it is enabled.
	 *
	 * @param smartTravelIntLink the smart travel int link
	 */
	public void cacheResult(SmartTravelIntLink smartTravelIntLink);

	/**
	 * Caches the smart travel int links in the entity cache if it is enabled.
	 *
	 * @param smartTravelIntLinks the smart travel int links
	 */
	public void cacheResult(
		java.util.List<SmartTravelIntLink> smartTravelIntLinks);

	/**
	 * Creates a new smart travel int link with the primary key. Does not add the smart travel int link to the database.
	 *
	 * @param smartTravelIntLinkId the primary key for the new smart travel int link
	 * @return the new smart travel int link
	 */
	public SmartTravelIntLink create(long smartTravelIntLinkId);

	/**
	 * Removes the smart travel int link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartTravelIntLinkId the primary key of the smart travel int link
	 * @return the smart travel int link that was removed
	 * @throws NoSuchSmartTravelIntLinkException if a smart travel int link with the primary key could not be found
	 */
	public SmartTravelIntLink remove(long smartTravelIntLinkId)
		throws NoSuchSmartTravelIntLinkException;

	public SmartTravelIntLink updateImpl(SmartTravelIntLink smartTravelIntLink);

	/**
	 * Returns the smart travel int link with the primary key or throws a <code>NoSuchSmartTravelIntLinkException</code> if it could not be found.
	 *
	 * @param smartTravelIntLinkId the primary key of the smart travel int link
	 * @return the smart travel int link
	 * @throws NoSuchSmartTravelIntLinkException if a smart travel int link with the primary key could not be found
	 */
	public SmartTravelIntLink findByPrimaryKey(long smartTravelIntLinkId)
		throws NoSuchSmartTravelIntLinkException;

	/**
	 * Returns the smart travel int link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartTravelIntLinkId the primary key of the smart travel int link
	 * @return the smart travel int link, or <code>null</code> if a smart travel int link with the primary key could not be found
	 */
	public SmartTravelIntLink fetchByPrimaryKey(long smartTravelIntLinkId);

	/**
	 * Returns all the smart travel int links.
	 *
	 * @return the smart travel int links
	 */
	public java.util.List<SmartTravelIntLink> findAll();

	/**
	 * Returns a range of all the smart travel int links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartTravelIntLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart travel int links
	 * @param end the upper bound of the range of smart travel int links (not inclusive)
	 * @return the range of smart travel int links
	 */
	public java.util.List<SmartTravelIntLink> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the smart travel int links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartTravelIntLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart travel int links
	 * @param end the upper bound of the range of smart travel int links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart travel int links
	 */
	public java.util.List<SmartTravelIntLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartTravelIntLink>
			orderByComparator);

	/**
	 * Returns an ordered range of all the smart travel int links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartTravelIntLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart travel int links
	 * @param end the upper bound of the range of smart travel int links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart travel int links
	 */
	public java.util.List<SmartTravelIntLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SmartTravelIntLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the smart travel int links from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of smart travel int links.
	 *
	 * @return the number of smart travel int links
	 */
	public int countAll();

}