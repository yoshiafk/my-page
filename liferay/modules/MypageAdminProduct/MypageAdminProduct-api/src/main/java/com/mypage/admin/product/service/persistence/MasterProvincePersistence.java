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

import com.mypage.admin.product.exception.NoSuchMasterProvinceException;
import com.mypage.admin.product.model.MasterProvince;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the master province service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterProvinceUtil
 * @generated
 */
@ProviderType
public interface MasterProvincePersistence
	extends BasePersistence<MasterProvince> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MasterProvinceUtil} to access the master province persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the master provinces where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching master provinces
	 */
	public java.util.List<MasterProvince> findByactiveProvinces(Integer active);

	/**
	 * Returns a range of all the master provinces where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @return the range of matching master provinces
	 */
	public java.util.List<MasterProvince> findByactiveProvinces(
		Integer active, int start, int end);

	/**
	 * Returns an ordered range of all the master provinces where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master provinces
	 */
	public java.util.List<MasterProvince> findByactiveProvinces(
		Integer active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterProvince>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master provinces where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master provinces
	 */
	public java.util.List<MasterProvince> findByactiveProvinces(
		Integer active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterProvince>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first master province in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master province
	 * @throws NoSuchMasterProvinceException if a matching master province could not be found
	 */
	public MasterProvince findByactiveProvinces_First(
			Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterProvince>
				orderByComparator)
		throws NoSuchMasterProvinceException;

	/**
	 * Returns the first master province in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master province, or <code>null</code> if a matching master province could not be found
	 */
	public MasterProvince fetchByactiveProvinces_First(
		Integer active,
		com.liferay.portal.kernel.util.OrderByComparator<MasterProvince>
			orderByComparator);

	/**
	 * Returns the last master province in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master province
	 * @throws NoSuchMasterProvinceException if a matching master province could not be found
	 */
	public MasterProvince findByactiveProvinces_Last(
			Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterProvince>
				orderByComparator)
		throws NoSuchMasterProvinceException;

	/**
	 * Returns the last master province in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master province, or <code>null</code> if a matching master province could not be found
	 */
	public MasterProvince fetchByactiveProvinces_Last(
		Integer active,
		com.liferay.portal.kernel.util.OrderByComparator<MasterProvince>
			orderByComparator);

	/**
	 * Returns the master provinces before and after the current master province in the ordered set where active = &#63;.
	 *
	 * @param masterProvinceId the primary key of the current master province
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master province
	 * @throws NoSuchMasterProvinceException if a master province with the primary key could not be found
	 */
	public MasterProvince[] findByactiveProvinces_PrevAndNext(
			long masterProvinceId, Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterProvince>
				orderByComparator)
		throws NoSuchMasterProvinceException;

	/**
	 * Removes all the master provinces where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeByactiveProvinces(Integer active);

	/**
	 * Returns the number of master provinces where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching master provinces
	 */
	public int countByactiveProvinces(Integer active);

	/**
	 * Caches the master province in the entity cache if it is enabled.
	 *
	 * @param masterProvince the master province
	 */
	public void cacheResult(MasterProvince masterProvince);

	/**
	 * Caches the master provinces in the entity cache if it is enabled.
	 *
	 * @param masterProvinces the master provinces
	 */
	public void cacheResult(java.util.List<MasterProvince> masterProvinces);

	/**
	 * Creates a new master province with the primary key. Does not add the master province to the database.
	 *
	 * @param masterProvinceId the primary key for the new master province
	 * @return the new master province
	 */
	public MasterProvince create(long masterProvinceId);

	/**
	 * Removes the master province with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterProvinceId the primary key of the master province
	 * @return the master province that was removed
	 * @throws NoSuchMasterProvinceException if a master province with the primary key could not be found
	 */
	public MasterProvince remove(long masterProvinceId)
		throws NoSuchMasterProvinceException;

	public MasterProvince updateImpl(MasterProvince masterProvince);

	/**
	 * Returns the master province with the primary key or throws a <code>NoSuchMasterProvinceException</code> if it could not be found.
	 *
	 * @param masterProvinceId the primary key of the master province
	 * @return the master province
	 * @throws NoSuchMasterProvinceException if a master province with the primary key could not be found
	 */
	public MasterProvince findByPrimaryKey(long masterProvinceId)
		throws NoSuchMasterProvinceException;

	/**
	 * Returns the master province with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterProvinceId the primary key of the master province
	 * @return the master province, or <code>null</code> if a master province with the primary key could not be found
	 */
	public MasterProvince fetchByPrimaryKey(long masterProvinceId);

	/**
	 * Returns all the master provinces.
	 *
	 * @return the master provinces
	 */
	public java.util.List<MasterProvince> findAll();

	/**
	 * Returns a range of all the master provinces.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @return the range of master provinces
	 */
	public java.util.List<MasterProvince> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the master provinces.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master provinces
	 */
	public java.util.List<MasterProvince> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterProvince>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master provinces.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterProvinceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master provinces
	 * @param end the upper bound of the range of master provinces (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master provinces
	 */
	public java.util.List<MasterProvince> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterProvince>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the master provinces from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of master provinces.
	 *
	 * @return the number of master provinces
	 */
	public int countAll();

}