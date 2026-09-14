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

import com.mypage.admin.product.exception.NoSuchMasterOccupationCategoryException;
import com.mypage.admin.product.model.MasterOccupationCategory;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the master occupation category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterOccupationCategoryUtil
 * @generated
 */
@ProviderType
public interface MasterOccupationCategoryPersistence
	extends BasePersistence<MasterOccupationCategory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MasterOccupationCategoryUtil} to access the master occupation category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the master occupation categories where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching master occupation categories
	 */
	public java.util.List<MasterOccupationCategory> findBysearchByActive(
		Integer active);

	/**
	 * Returns a range of all the master occupation categories where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @return the range of matching master occupation categories
	 */
	public java.util.List<MasterOccupationCategory> findBysearchByActive(
		Integer active, int start, int end);

	/**
	 * Returns an ordered range of all the master occupation categories where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master occupation categories
	 */
	public java.util.List<MasterOccupationCategory> findBysearchByActive(
		Integer active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<MasterOccupationCategory> orderByComparator);

	/**
	 * Returns an ordered range of all the master occupation categories where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master occupation categories
	 */
	public java.util.List<MasterOccupationCategory> findBysearchByActive(
		Integer active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<MasterOccupationCategory> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first master occupation category in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation category
	 * @throws NoSuchMasterOccupationCategoryException if a matching master occupation category could not be found
	 */
	public MasterOccupationCategory findBysearchByActive_First(
			Integer active,
			com.liferay.portal.kernel.util.OrderByComparator
				<MasterOccupationCategory> orderByComparator)
		throws NoSuchMasterOccupationCategoryException;

	/**
	 * Returns the first master occupation category in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation category, or <code>null</code> if a matching master occupation category could not be found
	 */
	public MasterOccupationCategory fetchBysearchByActive_First(
		Integer active,
		com.liferay.portal.kernel.util.OrderByComparator
			<MasterOccupationCategory> orderByComparator);

	/**
	 * Returns the last master occupation category in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation category
	 * @throws NoSuchMasterOccupationCategoryException if a matching master occupation category could not be found
	 */
	public MasterOccupationCategory findBysearchByActive_Last(
			Integer active,
			com.liferay.portal.kernel.util.OrderByComparator
				<MasterOccupationCategory> orderByComparator)
		throws NoSuchMasterOccupationCategoryException;

	/**
	 * Returns the last master occupation category in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation category, or <code>null</code> if a matching master occupation category could not be found
	 */
	public MasterOccupationCategory fetchBysearchByActive_Last(
		Integer active,
		com.liferay.portal.kernel.util.OrderByComparator
			<MasterOccupationCategory> orderByComparator);

	/**
	 * Returns the master occupation categories before and after the current master occupation category in the ordered set where active = &#63;.
	 *
	 * @param masterOccupationCategoryId the primary key of the current master occupation category
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master occupation category
	 * @throws NoSuchMasterOccupationCategoryException if a master occupation category with the primary key could not be found
	 */
	public MasterOccupationCategory[] findBysearchByActive_PrevAndNext(
			long masterOccupationCategoryId, Integer active,
			com.liferay.portal.kernel.util.OrderByComparator
				<MasterOccupationCategory> orderByComparator)
		throws NoSuchMasterOccupationCategoryException;

	/**
	 * Removes all the master occupation categories where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeBysearchByActive(Integer active);

	/**
	 * Returns the number of master occupation categories where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching master occupation categories
	 */
	public int countBysearchByActive(Integer active);

	/**
	 * Returns the master occupation category where name = &#63; or throws a <code>NoSuchMasterOccupationCategoryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching master occupation category
	 * @throws NoSuchMasterOccupationCategoryException if a matching master occupation category could not be found
	 */
	public MasterOccupationCategory findBysearchName(String name)
		throws NoSuchMasterOccupationCategoryException;

	/**
	 * Returns the master occupation category where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching master occupation category, or <code>null</code> if a matching master occupation category could not be found
	 */
	public MasterOccupationCategory fetchBysearchName(String name);

	/**
	 * Returns the master occupation category where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching master occupation category, or <code>null</code> if a matching master occupation category could not be found
	 */
	public MasterOccupationCategory fetchBysearchName(
		String name, boolean useFinderCache);

	/**
	 * Removes the master occupation category where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the master occupation category that was removed
	 */
	public MasterOccupationCategory removeBysearchName(String name)
		throws NoSuchMasterOccupationCategoryException;

	/**
	 * Returns the number of master occupation categories where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching master occupation categories
	 */
	public int countBysearchName(String name);

	/**
	 * Caches the master occupation category in the entity cache if it is enabled.
	 *
	 * @param masterOccupationCategory the master occupation category
	 */
	public void cacheResult(MasterOccupationCategory masterOccupationCategory);

	/**
	 * Caches the master occupation categories in the entity cache if it is enabled.
	 *
	 * @param masterOccupationCategories the master occupation categories
	 */
	public void cacheResult(
		java.util.List<MasterOccupationCategory> masterOccupationCategories);

	/**
	 * Creates a new master occupation category with the primary key. Does not add the master occupation category to the database.
	 *
	 * @param masterOccupationCategoryId the primary key for the new master occupation category
	 * @return the new master occupation category
	 */
	public MasterOccupationCategory create(long masterOccupationCategoryId);

	/**
	 * Removes the master occupation category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterOccupationCategoryId the primary key of the master occupation category
	 * @return the master occupation category that was removed
	 * @throws NoSuchMasterOccupationCategoryException if a master occupation category with the primary key could not be found
	 */
	public MasterOccupationCategory remove(long masterOccupationCategoryId)
		throws NoSuchMasterOccupationCategoryException;

	public MasterOccupationCategory updateImpl(
		MasterOccupationCategory masterOccupationCategory);

	/**
	 * Returns the master occupation category with the primary key or throws a <code>NoSuchMasterOccupationCategoryException</code> if it could not be found.
	 *
	 * @param masterOccupationCategoryId the primary key of the master occupation category
	 * @return the master occupation category
	 * @throws NoSuchMasterOccupationCategoryException if a master occupation category with the primary key could not be found
	 */
	public MasterOccupationCategory findByPrimaryKey(
			long masterOccupationCategoryId)
		throws NoSuchMasterOccupationCategoryException;

	/**
	 * Returns the master occupation category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterOccupationCategoryId the primary key of the master occupation category
	 * @return the master occupation category, or <code>null</code> if a master occupation category with the primary key could not be found
	 */
	public MasterOccupationCategory fetchByPrimaryKey(
		long masterOccupationCategoryId);

	/**
	 * Returns all the master occupation categories.
	 *
	 * @return the master occupation categories
	 */
	public java.util.List<MasterOccupationCategory> findAll();

	/**
	 * Returns a range of all the master occupation categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @return the range of master occupation categories
	 */
	public java.util.List<MasterOccupationCategory> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the master occupation categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master occupation categories
	 */
	public java.util.List<MasterOccupationCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<MasterOccupationCategory> orderByComparator);

	/**
	 * Returns an ordered range of all the master occupation categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master occupation categories
	 */
	public java.util.List<MasterOccupationCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<MasterOccupationCategory> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the master occupation categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of master occupation categories.
	 *
	 * @return the number of master occupation categories
	 */
	public int countAll();

}