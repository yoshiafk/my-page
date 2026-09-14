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

package com.mypage.leads.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.leads.model.DetailDrive;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the detail drive service. This utility wraps <code>com.mypage.leads.service.persistence.impl.DetailDrivePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see DetailDrivePersistence
 * @generated
 */
public class DetailDriveUtil {

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
	public static void clearCache(DetailDrive detailDrive) {
		getPersistence().clearCache(detailDrive);
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
	public static Map<Serializable, DetailDrive> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DetailDrive> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DetailDrive> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DetailDrive> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DetailDrive> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DetailDrive update(DetailDrive detailDrive) {
		return getPersistence().update(detailDrive);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DetailDrive update(
		DetailDrive detailDrive, ServiceContext serviceContext) {

		return getPersistence().update(detailDrive, serviceContext);
	}

	/**
	 * Returns all the detail drives where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @return the matching detail drives
	 */
	public static List<DetailDrive> findByLeadsId(long leadsId) {
		return getPersistence().findByLeadsId(leadsId);
	}

	/**
	 * Returns a range of all the detail drives where leadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDriveModelImpl</code>.
	 * </p>
	 *
	 * @param leadsId the leads ID
	 * @param start the lower bound of the range of detail drives
	 * @param end the upper bound of the range of detail drives (not inclusive)
	 * @return the range of matching detail drives
	 */
	public static List<DetailDrive> findByLeadsId(
		long leadsId, int start, int end) {

		return getPersistence().findByLeadsId(leadsId, start, end);
	}

	/**
	 * Returns an ordered range of all the detail drives where leadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDriveModelImpl</code>.
	 * </p>
	 *
	 * @param leadsId the leads ID
	 * @param start the lower bound of the range of detail drives
	 * @param end the upper bound of the range of detail drives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching detail drives
	 */
	public static List<DetailDrive> findByLeadsId(
		long leadsId, int start, int end,
		OrderByComparator<DetailDrive> orderByComparator) {

		return getPersistence().findByLeadsId(
			leadsId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the detail drives where leadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDriveModelImpl</code>.
	 * </p>
	 *
	 * @param leadsId the leads ID
	 * @param start the lower bound of the range of detail drives
	 * @param end the upper bound of the range of detail drives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching detail drives
	 */
	public static List<DetailDrive> findByLeadsId(
		long leadsId, int start, int end,
		OrderByComparator<DetailDrive> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLeadsId(
			leadsId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first detail drive in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching detail drive
	 * @throws NoSuchDetailDriveException if a matching detail drive could not be found
	 */
	public static DetailDrive findByLeadsId_First(
			long leadsId, OrderByComparator<DetailDrive> orderByComparator)
		throws com.mypage.leads.exception.NoSuchDetailDriveException {

		return getPersistence().findByLeadsId_First(leadsId, orderByComparator);
	}

	/**
	 * Returns the first detail drive in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching detail drive, or <code>null</code> if a matching detail drive could not be found
	 */
	public static DetailDrive fetchByLeadsId_First(
		long leadsId, OrderByComparator<DetailDrive> orderByComparator) {

		return getPersistence().fetchByLeadsId_First(
			leadsId, orderByComparator);
	}

	/**
	 * Returns the last detail drive in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching detail drive
	 * @throws NoSuchDetailDriveException if a matching detail drive could not be found
	 */
	public static DetailDrive findByLeadsId_Last(
			long leadsId, OrderByComparator<DetailDrive> orderByComparator)
		throws com.mypage.leads.exception.NoSuchDetailDriveException {

		return getPersistence().findByLeadsId_Last(leadsId, orderByComparator);
	}

	/**
	 * Returns the last detail drive in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching detail drive, or <code>null</code> if a matching detail drive could not be found
	 */
	public static DetailDrive fetchByLeadsId_Last(
		long leadsId, OrderByComparator<DetailDrive> orderByComparator) {

		return getPersistence().fetchByLeadsId_Last(leadsId, orderByComparator);
	}

	/**
	 * Returns the detail drives before and after the current detail drive in the ordered set where leadsId = &#63;.
	 *
	 * @param detailDriveId the primary key of the current detail drive
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next detail drive
	 * @throws NoSuchDetailDriveException if a detail drive with the primary key could not be found
	 */
	public static DetailDrive[] findByLeadsId_PrevAndNext(
			long detailDriveId, long leadsId,
			OrderByComparator<DetailDrive> orderByComparator)
		throws com.mypage.leads.exception.NoSuchDetailDriveException {

		return getPersistence().findByLeadsId_PrevAndNext(
			detailDriveId, leadsId, orderByComparator);
	}

	/**
	 * Removes all the detail drives where leadsId = &#63; from the database.
	 *
	 * @param leadsId the leads ID
	 */
	public static void removeByLeadsId(long leadsId) {
		getPersistence().removeByLeadsId(leadsId);
	}

	/**
	 * Returns the number of detail drives where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @return the number of matching detail drives
	 */
	public static int countByLeadsId(long leadsId) {
		return getPersistence().countByLeadsId(leadsId);
	}

	/**
	 * Caches the detail drive in the entity cache if it is enabled.
	 *
	 * @param detailDrive the detail drive
	 */
	public static void cacheResult(DetailDrive detailDrive) {
		getPersistence().cacheResult(detailDrive);
	}

	/**
	 * Caches the detail drives in the entity cache if it is enabled.
	 *
	 * @param detailDrives the detail drives
	 */
	public static void cacheResult(List<DetailDrive> detailDrives) {
		getPersistence().cacheResult(detailDrives);
	}

	/**
	 * Creates a new detail drive with the primary key. Does not add the detail drive to the database.
	 *
	 * @param detailDriveId the primary key for the new detail drive
	 * @return the new detail drive
	 */
	public static DetailDrive create(long detailDriveId) {
		return getPersistence().create(detailDriveId);
	}

	/**
	 * Removes the detail drive with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param detailDriveId the primary key of the detail drive
	 * @return the detail drive that was removed
	 * @throws NoSuchDetailDriveException if a detail drive with the primary key could not be found
	 */
	public static DetailDrive remove(long detailDriveId)
		throws com.mypage.leads.exception.NoSuchDetailDriveException {

		return getPersistence().remove(detailDriveId);
	}

	public static DetailDrive updateImpl(DetailDrive detailDrive) {
		return getPersistence().updateImpl(detailDrive);
	}

	/**
	 * Returns the detail drive with the primary key or throws a <code>NoSuchDetailDriveException</code> if it could not be found.
	 *
	 * @param detailDriveId the primary key of the detail drive
	 * @return the detail drive
	 * @throws NoSuchDetailDriveException if a detail drive with the primary key could not be found
	 */
	public static DetailDrive findByPrimaryKey(long detailDriveId)
		throws com.mypage.leads.exception.NoSuchDetailDriveException {

		return getPersistence().findByPrimaryKey(detailDriveId);
	}

	/**
	 * Returns the detail drive with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param detailDriveId the primary key of the detail drive
	 * @return the detail drive, or <code>null</code> if a detail drive with the primary key could not be found
	 */
	public static DetailDrive fetchByPrimaryKey(long detailDriveId) {
		return getPersistence().fetchByPrimaryKey(detailDriveId);
	}

	/**
	 * Returns all the detail drives.
	 *
	 * @return the detail drives
	 */
	public static List<DetailDrive> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the detail drives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDriveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail drives
	 * @param end the upper bound of the range of detail drives (not inclusive)
	 * @return the range of detail drives
	 */
	public static List<DetailDrive> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the detail drives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDriveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail drives
	 * @param end the upper bound of the range of detail drives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail drives
	 */
	public static List<DetailDrive> findAll(
		int start, int end, OrderByComparator<DetailDrive> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the detail drives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailDriveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail drives
	 * @param end the upper bound of the range of detail drives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail drives
	 */
	public static List<DetailDrive> findAll(
		int start, int end, OrderByComparator<DetailDrive> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the detail drives from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of detail drives.
	 *
	 * @return the number of detail drives
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DetailDrivePersistence getPersistence() {
		return _persistence;
	}

	private static volatile DetailDrivePersistence _persistence;

}