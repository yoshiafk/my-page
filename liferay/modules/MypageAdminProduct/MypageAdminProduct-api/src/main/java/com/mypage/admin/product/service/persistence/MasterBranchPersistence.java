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

import com.mypage.admin.product.exception.NoSuchMasterBranchException;
import com.mypage.admin.product.model.MasterBranch;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the master branch service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterBranchUtil
 * @generated
 */
@ProviderType
public interface MasterBranchPersistence extends BasePersistence<MasterBranch> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MasterBranchUtil} to access the master branch persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the master branches where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching master branches
	 */
	public java.util.List<MasterBranch> findBysearchByName(String name);

	/**
	 * Returns a range of all the master branches where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @return the range of matching master branches
	 */
	public java.util.List<MasterBranch> findBysearchByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the master branches where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master branches
	 */
	public java.util.List<MasterBranch> findBysearchByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterBranch>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master branches where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master branches
	 */
	public java.util.List<MasterBranch> findBysearchByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterBranch>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first master branch in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master branch
	 * @throws NoSuchMasterBranchException if a matching master branch could not be found
	 */
	public MasterBranch findBysearchByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<MasterBranch>
				orderByComparator)
		throws NoSuchMasterBranchException;

	/**
	 * Returns the first master branch in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master branch, or <code>null</code> if a matching master branch could not be found
	 */
	public MasterBranch fetchBysearchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<MasterBranch>
			orderByComparator);

	/**
	 * Returns the last master branch in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master branch
	 * @throws NoSuchMasterBranchException if a matching master branch could not be found
	 */
	public MasterBranch findBysearchByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<MasterBranch>
				orderByComparator)
		throws NoSuchMasterBranchException;

	/**
	 * Returns the last master branch in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master branch, or <code>null</code> if a matching master branch could not be found
	 */
	public MasterBranch fetchBysearchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<MasterBranch>
			orderByComparator);

	/**
	 * Returns the master branches before and after the current master branch in the ordered set where name = &#63;.
	 *
	 * @param masterBranchId the primary key of the current master branch
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master branch
	 * @throws NoSuchMasterBranchException if a master branch with the primary key could not be found
	 */
	public MasterBranch[] findBysearchByName_PrevAndNext(
			long masterBranchId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<MasterBranch>
				orderByComparator)
		throws NoSuchMasterBranchException;

	/**
	 * Removes all the master branches where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeBysearchByName(String name);

	/**
	 * Returns the number of master branches where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching master branches
	 */
	public int countBysearchByName(String name);

	/**
	 * Caches the master branch in the entity cache if it is enabled.
	 *
	 * @param masterBranch the master branch
	 */
	public void cacheResult(MasterBranch masterBranch);

	/**
	 * Caches the master branches in the entity cache if it is enabled.
	 *
	 * @param masterBranches the master branches
	 */
	public void cacheResult(java.util.List<MasterBranch> masterBranches);

	/**
	 * Creates a new master branch with the primary key. Does not add the master branch to the database.
	 *
	 * @param masterBranchId the primary key for the new master branch
	 * @return the new master branch
	 */
	public MasterBranch create(long masterBranchId);

	/**
	 * Removes the master branch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterBranchId the primary key of the master branch
	 * @return the master branch that was removed
	 * @throws NoSuchMasterBranchException if a master branch with the primary key could not be found
	 */
	public MasterBranch remove(long masterBranchId)
		throws NoSuchMasterBranchException;

	public MasterBranch updateImpl(MasterBranch masterBranch);

	/**
	 * Returns the master branch with the primary key or throws a <code>NoSuchMasterBranchException</code> if it could not be found.
	 *
	 * @param masterBranchId the primary key of the master branch
	 * @return the master branch
	 * @throws NoSuchMasterBranchException if a master branch with the primary key could not be found
	 */
	public MasterBranch findByPrimaryKey(long masterBranchId)
		throws NoSuchMasterBranchException;

	/**
	 * Returns the master branch with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterBranchId the primary key of the master branch
	 * @return the master branch, or <code>null</code> if a master branch with the primary key could not be found
	 */
	public MasterBranch fetchByPrimaryKey(long masterBranchId);

	/**
	 * Returns all the master branches.
	 *
	 * @return the master branches
	 */
	public java.util.List<MasterBranch> findAll();

	/**
	 * Returns a range of all the master branches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @return the range of master branches
	 */
	public java.util.List<MasterBranch> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the master branches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master branches
	 */
	public java.util.List<MasterBranch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterBranch>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master branches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBranchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master branches
	 * @param end the upper bound of the range of master branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master branches
	 */
	public java.util.List<MasterBranch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterBranch>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the master branches from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of master branches.
	 *
	 * @return the number of master branches
	 */
	public int countAll();

}