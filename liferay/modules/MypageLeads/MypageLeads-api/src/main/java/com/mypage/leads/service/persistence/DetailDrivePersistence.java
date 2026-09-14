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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.leads.exception.NoSuchDetailDriveException;
import com.mypage.leads.model.DetailDrive;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the detail drive service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see DetailDriveUtil
 * @generated
 */
@ProviderType
public interface DetailDrivePersistence extends BasePersistence<DetailDrive> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DetailDriveUtil} to access the detail drive persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the detail drives where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @return the matching detail drives
	 */
	public java.util.List<DetailDrive> findByLeadsId(long leadsId);

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
	public java.util.List<DetailDrive> findByLeadsId(
		long leadsId, int start, int end);

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
	public java.util.List<DetailDrive> findByLeadsId(
		long leadsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DetailDrive>
			orderByComparator);

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
	public java.util.List<DetailDrive> findByLeadsId(
		long leadsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DetailDrive>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first detail drive in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching detail drive
	 * @throws NoSuchDetailDriveException if a matching detail drive could not be found
	 */
	public DetailDrive findByLeadsId_First(
			long leadsId,
			com.liferay.portal.kernel.util.OrderByComparator<DetailDrive>
				orderByComparator)
		throws NoSuchDetailDriveException;

	/**
	 * Returns the first detail drive in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching detail drive, or <code>null</code> if a matching detail drive could not be found
	 */
	public DetailDrive fetchByLeadsId_First(
		long leadsId,
		com.liferay.portal.kernel.util.OrderByComparator<DetailDrive>
			orderByComparator);

	/**
	 * Returns the last detail drive in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching detail drive
	 * @throws NoSuchDetailDriveException if a matching detail drive could not be found
	 */
	public DetailDrive findByLeadsId_Last(
			long leadsId,
			com.liferay.portal.kernel.util.OrderByComparator<DetailDrive>
				orderByComparator)
		throws NoSuchDetailDriveException;

	/**
	 * Returns the last detail drive in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching detail drive, or <code>null</code> if a matching detail drive could not be found
	 */
	public DetailDrive fetchByLeadsId_Last(
		long leadsId,
		com.liferay.portal.kernel.util.OrderByComparator<DetailDrive>
			orderByComparator);

	/**
	 * Returns the detail drives before and after the current detail drive in the ordered set where leadsId = &#63;.
	 *
	 * @param detailDriveId the primary key of the current detail drive
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next detail drive
	 * @throws NoSuchDetailDriveException if a detail drive with the primary key could not be found
	 */
	public DetailDrive[] findByLeadsId_PrevAndNext(
			long detailDriveId, long leadsId,
			com.liferay.portal.kernel.util.OrderByComparator<DetailDrive>
				orderByComparator)
		throws NoSuchDetailDriveException;

	/**
	 * Removes all the detail drives where leadsId = &#63; from the database.
	 *
	 * @param leadsId the leads ID
	 */
	public void removeByLeadsId(long leadsId);

	/**
	 * Returns the number of detail drives where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @return the number of matching detail drives
	 */
	public int countByLeadsId(long leadsId);

	/**
	 * Caches the detail drive in the entity cache if it is enabled.
	 *
	 * @param detailDrive the detail drive
	 */
	public void cacheResult(DetailDrive detailDrive);

	/**
	 * Caches the detail drives in the entity cache if it is enabled.
	 *
	 * @param detailDrives the detail drives
	 */
	public void cacheResult(java.util.List<DetailDrive> detailDrives);

	/**
	 * Creates a new detail drive with the primary key. Does not add the detail drive to the database.
	 *
	 * @param detailDriveId the primary key for the new detail drive
	 * @return the new detail drive
	 */
	public DetailDrive create(long detailDriveId);

	/**
	 * Removes the detail drive with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param detailDriveId the primary key of the detail drive
	 * @return the detail drive that was removed
	 * @throws NoSuchDetailDriveException if a detail drive with the primary key could not be found
	 */
	public DetailDrive remove(long detailDriveId)
		throws NoSuchDetailDriveException;

	public DetailDrive updateImpl(DetailDrive detailDrive);

	/**
	 * Returns the detail drive with the primary key or throws a <code>NoSuchDetailDriveException</code> if it could not be found.
	 *
	 * @param detailDriveId the primary key of the detail drive
	 * @return the detail drive
	 * @throws NoSuchDetailDriveException if a detail drive with the primary key could not be found
	 */
	public DetailDrive findByPrimaryKey(long detailDriveId)
		throws NoSuchDetailDriveException;

	/**
	 * Returns the detail drive with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param detailDriveId the primary key of the detail drive
	 * @return the detail drive, or <code>null</code> if a detail drive with the primary key could not be found
	 */
	public DetailDrive fetchByPrimaryKey(long detailDriveId);

	/**
	 * Returns all the detail drives.
	 *
	 * @return the detail drives
	 */
	public java.util.List<DetailDrive> findAll();

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
	public java.util.List<DetailDrive> findAll(int start, int end);

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
	public java.util.List<DetailDrive> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DetailDrive>
			orderByComparator);

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
	public java.util.List<DetailDrive> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DetailDrive>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the detail drives from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of detail drives.
	 *
	 * @return the number of detail drives
	 */
	public int countAll();

}