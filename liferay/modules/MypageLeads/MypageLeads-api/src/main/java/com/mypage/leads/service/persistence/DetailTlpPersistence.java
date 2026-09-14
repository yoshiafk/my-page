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

import com.mypage.leads.exception.NoSuchDetailTlpException;
import com.mypage.leads.model.DetailTlp;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the detail tlp service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see DetailTlpUtil
 * @generated
 */
@ProviderType
public interface DetailTlpPersistence extends BasePersistence<DetailTlp> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DetailTlpUtil} to access the detail tlp persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the detail tlps where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @return the matching detail tlps
	 */
	public java.util.List<DetailTlp> findByleadsId(long leadsId);

	/**
	 * Returns a range of all the detail tlps where leadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param leadsId the leads ID
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @return the range of matching detail tlps
	 */
	public java.util.List<DetailTlp> findByleadsId(
		long leadsId, int start, int end);

	/**
	 * Returns an ordered range of all the detail tlps where leadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param leadsId the leads ID
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching detail tlps
	 */
	public java.util.List<DetailTlp> findByleadsId(
		long leadsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DetailTlp>
			orderByComparator);

	/**
	 * Returns an ordered range of all the detail tlps where leadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param leadsId the leads ID
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching detail tlps
	 */
	public java.util.List<DetailTlp> findByleadsId(
		long leadsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DetailTlp>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first detail tlp in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching detail tlp
	 * @throws NoSuchDetailTlpException if a matching detail tlp could not be found
	 */
	public DetailTlp findByleadsId_First(
			long leadsId,
			com.liferay.portal.kernel.util.OrderByComparator<DetailTlp>
				orderByComparator)
		throws NoSuchDetailTlpException;

	/**
	 * Returns the first detail tlp in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching detail tlp, or <code>null</code> if a matching detail tlp could not be found
	 */
	public DetailTlp fetchByleadsId_First(
		long leadsId,
		com.liferay.portal.kernel.util.OrderByComparator<DetailTlp>
			orderByComparator);

	/**
	 * Returns the last detail tlp in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching detail tlp
	 * @throws NoSuchDetailTlpException if a matching detail tlp could not be found
	 */
	public DetailTlp findByleadsId_Last(
			long leadsId,
			com.liferay.portal.kernel.util.OrderByComparator<DetailTlp>
				orderByComparator)
		throws NoSuchDetailTlpException;

	/**
	 * Returns the last detail tlp in the ordered set where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching detail tlp, or <code>null</code> if a matching detail tlp could not be found
	 */
	public DetailTlp fetchByleadsId_Last(
		long leadsId,
		com.liferay.portal.kernel.util.OrderByComparator<DetailTlp>
			orderByComparator);

	/**
	 * Returns the detail tlps before and after the current detail tlp in the ordered set where leadsId = &#63;.
	 *
	 * @param detailTlpId the primary key of the current detail tlp
	 * @param leadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next detail tlp
	 * @throws NoSuchDetailTlpException if a detail tlp with the primary key could not be found
	 */
	public DetailTlp[] findByleadsId_PrevAndNext(
			long detailTlpId, long leadsId,
			com.liferay.portal.kernel.util.OrderByComparator<DetailTlp>
				orderByComparator)
		throws NoSuchDetailTlpException;

	/**
	 * Removes all the detail tlps where leadsId = &#63; from the database.
	 *
	 * @param leadsId the leads ID
	 */
	public void removeByleadsId(long leadsId);

	/**
	 * Returns the number of detail tlps where leadsId = &#63;.
	 *
	 * @param leadsId the leads ID
	 * @return the number of matching detail tlps
	 */
	public int countByleadsId(long leadsId);

	/**
	 * Caches the detail tlp in the entity cache if it is enabled.
	 *
	 * @param detailTlp the detail tlp
	 */
	public void cacheResult(DetailTlp detailTlp);

	/**
	 * Caches the detail tlps in the entity cache if it is enabled.
	 *
	 * @param detailTlps the detail tlps
	 */
	public void cacheResult(java.util.List<DetailTlp> detailTlps);

	/**
	 * Creates a new detail tlp with the primary key. Does not add the detail tlp to the database.
	 *
	 * @param detailTlpId the primary key for the new detail tlp
	 * @return the new detail tlp
	 */
	public DetailTlp create(long detailTlpId);

	/**
	 * Removes the detail tlp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param detailTlpId the primary key of the detail tlp
	 * @return the detail tlp that was removed
	 * @throws NoSuchDetailTlpException if a detail tlp with the primary key could not be found
	 */
	public DetailTlp remove(long detailTlpId) throws NoSuchDetailTlpException;

	public DetailTlp updateImpl(DetailTlp detailTlp);

	/**
	 * Returns the detail tlp with the primary key or throws a <code>NoSuchDetailTlpException</code> if it could not be found.
	 *
	 * @param detailTlpId the primary key of the detail tlp
	 * @return the detail tlp
	 * @throws NoSuchDetailTlpException if a detail tlp with the primary key could not be found
	 */
	public DetailTlp findByPrimaryKey(long detailTlpId)
		throws NoSuchDetailTlpException;

	/**
	 * Returns the detail tlp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param detailTlpId the primary key of the detail tlp
	 * @return the detail tlp, or <code>null</code> if a detail tlp with the primary key could not be found
	 */
	public DetailTlp fetchByPrimaryKey(long detailTlpId);

	/**
	 * Returns all the detail tlps.
	 *
	 * @return the detail tlps
	 */
	public java.util.List<DetailTlp> findAll();

	/**
	 * Returns a range of all the detail tlps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @return the range of detail tlps
	 */
	public java.util.List<DetailTlp> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the detail tlps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail tlps
	 */
	public java.util.List<DetailTlp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DetailTlp>
			orderByComparator);

	/**
	 * Returns an ordered range of all the detail tlps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailTlpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail tlps
	 * @param end the upper bound of the range of detail tlps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail tlps
	 */
	public java.util.List<DetailTlp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DetailTlp>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the detail tlps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of detail tlps.
	 *
	 * @return the number of detail tlps
	 */
	public int countAll();

}