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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.SmartTravelIntLink;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the smart travel int link service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.SmartTravelIntLinkPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see SmartTravelIntLinkPersistence
 * @generated
 */
public class SmartTravelIntLinkUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(SmartTravelIntLink smartTravelIntLink) {
		getPersistence().clearCache(smartTravelIntLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, SmartTravelIntLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SmartTravelIntLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SmartTravelIntLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SmartTravelIntLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SmartTravelIntLink> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SmartTravelIntLink update(
		SmartTravelIntLink smartTravelIntLink) {

		return getPersistence().update(smartTravelIntLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SmartTravelIntLink update(
		SmartTravelIntLink smartTravelIntLink, ServiceContext serviceContext) {

		return getPersistence().update(smartTravelIntLink, serviceContext);
	}

	/**
	 * Returns the smart travel int link where linkType = &#63; or throws a <code>NoSuchSmartTravelIntLinkException</code> if it could not be found.
	 *
	 * @param linkType the link type
	 * @return the matching smart travel int link
	 * @throws NoSuchSmartTravelIntLinkException if a matching smart travel int link could not be found
	 */
	public static SmartTravelIntLink findByLinkType(String linkType)
		throws com.mypage.admin.product.exception.
			NoSuchSmartTravelIntLinkException {

		return getPersistence().findByLinkType(linkType);
	}

	/**
	 * Returns the smart travel int link where linkType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param linkType the link type
	 * @return the matching smart travel int link, or <code>null</code> if a matching smart travel int link could not be found
	 */
	public static SmartTravelIntLink fetchByLinkType(String linkType) {
		return getPersistence().fetchByLinkType(linkType);
	}

	/**
	 * Returns the smart travel int link where linkType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param linkType the link type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart travel int link, or <code>null</code> if a matching smart travel int link could not be found
	 */
	public static SmartTravelIntLink fetchByLinkType(
		String linkType, boolean useFinderCache) {

		return getPersistence().fetchByLinkType(linkType, useFinderCache);
	}

	/**
	 * Removes the smart travel int link where linkType = &#63; from the database.
	 *
	 * @param linkType the link type
	 * @return the smart travel int link that was removed
	 */
	public static SmartTravelIntLink removeByLinkType(String linkType)
		throws com.mypage.admin.product.exception.
			NoSuchSmartTravelIntLinkException {

		return getPersistence().removeByLinkType(linkType);
	}

	/**
	 * Returns the number of smart travel int links where linkType = &#63;.
	 *
	 * @param linkType the link type
	 * @return the number of matching smart travel int links
	 */
	public static int countByLinkType(String linkType) {
		return getPersistence().countByLinkType(linkType);
	}

	/**
	 * Caches the smart travel int link in the entity cache if it is enabled.
	 *
	 * @param smartTravelIntLink the smart travel int link
	 */
	public static void cacheResult(SmartTravelIntLink smartTravelIntLink) {
		getPersistence().cacheResult(smartTravelIntLink);
	}

	/**
	 * Caches the smart travel int links in the entity cache if it is enabled.
	 *
	 * @param smartTravelIntLinks the smart travel int links
	 */
	public static void cacheResult(
		List<SmartTravelIntLink> smartTravelIntLinks) {

		getPersistence().cacheResult(smartTravelIntLinks);
	}

	/**
	 * Creates a new smart travel int link with the primary key. Does not add the smart travel int link to the database.
	 *
	 * @param smartTravelIntLinkId the primary key for the new smart travel int link
	 * @return the new smart travel int link
	 */
	public static SmartTravelIntLink create(long smartTravelIntLinkId) {
		return getPersistence().create(smartTravelIntLinkId);
	}

	/**
	 * Removes the smart travel int link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartTravelIntLinkId the primary key of the smart travel int link
	 * @return the smart travel int link that was removed
	 * @throws NoSuchSmartTravelIntLinkException if a smart travel int link with the primary key could not be found
	 */
	public static SmartTravelIntLink remove(long smartTravelIntLinkId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartTravelIntLinkException {

		return getPersistence().remove(smartTravelIntLinkId);
	}

	public static SmartTravelIntLink updateImpl(
		SmartTravelIntLink smartTravelIntLink) {

		return getPersistence().updateImpl(smartTravelIntLink);
	}

	/**
	 * Returns the smart travel int link with the primary key or throws a <code>NoSuchSmartTravelIntLinkException</code> if it could not be found.
	 *
	 * @param smartTravelIntLinkId the primary key of the smart travel int link
	 * @return the smart travel int link
	 * @throws NoSuchSmartTravelIntLinkException if a smart travel int link with the primary key could not be found
	 */
	public static SmartTravelIntLink findByPrimaryKey(long smartTravelIntLinkId)
		throws com.mypage.admin.product.exception.
			NoSuchSmartTravelIntLinkException {

		return getPersistence().findByPrimaryKey(smartTravelIntLinkId);
	}

	/**
	 * Returns the smart travel int link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartTravelIntLinkId the primary key of the smart travel int link
	 * @return the smart travel int link, or <code>null</code> if a smart travel int link with the primary key could not be found
	 */
	public static SmartTravelIntLink fetchByPrimaryKey(
		long smartTravelIntLinkId) {

		return getPersistence().fetchByPrimaryKey(smartTravelIntLinkId);
	}

	/**
	 * Returns all the smart travel int links.
	 *
	 * @return the smart travel int links
	 */
	public static List<SmartTravelIntLink> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<SmartTravelIntLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<SmartTravelIntLink> findAll(
		int start, int end,
		OrderByComparator<SmartTravelIntLink> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<SmartTravelIntLink> findAll(
		int start, int end,
		OrderByComparator<SmartTravelIntLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the smart travel int links from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of smart travel int links.
	 *
	 * @return the number of smart travel int links
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SmartTravelIntLinkPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SmartTravelIntLinkPersistence _persistence;

}