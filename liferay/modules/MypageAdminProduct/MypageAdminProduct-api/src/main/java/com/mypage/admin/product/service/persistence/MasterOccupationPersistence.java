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

import com.mypage.admin.product.exception.NoSuchMasterOccupationException;
import com.mypage.admin.product.model.MasterOccupation;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the master occupation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see MasterOccupationUtil
 * @generated
 */
@ProviderType
public interface MasterOccupationPersistence
	extends BasePersistence<MasterOccupation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MasterOccupationUtil} to access the master occupation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the master occupations where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching master occupations
	 */
	public java.util.List<MasterOccupation> findBysearchByActive(
		Integer active);

	/**
	 * Returns a range of all the master occupations where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @return the range of matching master occupations
	 */
	public java.util.List<MasterOccupation> findBysearchByActive(
		Integer active, int start, int end);

	/**
	 * Returns an ordered range of all the master occupations where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master occupations
	 */
	public java.util.List<MasterOccupation> findBysearchByActive(
		Integer active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterOccupation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master occupations where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master occupations
	 */
	public java.util.List<MasterOccupation> findBysearchByActive(
		Integer active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterOccupation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first master occupation in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation
	 * @throws NoSuchMasterOccupationException if a matching master occupation could not be found
	 */
	public MasterOccupation findBysearchByActive_First(
			Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterOccupation>
				orderByComparator)
		throws NoSuchMasterOccupationException;

	/**
	 * Returns the first master occupation in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation, or <code>null</code> if a matching master occupation could not be found
	 */
	public MasterOccupation fetchBysearchByActive_First(
		Integer active,
		com.liferay.portal.kernel.util.OrderByComparator<MasterOccupation>
			orderByComparator);

	/**
	 * Returns the last master occupation in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation
	 * @throws NoSuchMasterOccupationException if a matching master occupation could not be found
	 */
	public MasterOccupation findBysearchByActive_Last(
			Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterOccupation>
				orderByComparator)
		throws NoSuchMasterOccupationException;

	/**
	 * Returns the last master occupation in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation, or <code>null</code> if a matching master occupation could not be found
	 */
	public MasterOccupation fetchBysearchByActive_Last(
		Integer active,
		com.liferay.portal.kernel.util.OrderByComparator<MasterOccupation>
			orderByComparator);

	/**
	 * Returns the master occupations before and after the current master occupation in the ordered set where active = &#63;.
	 *
	 * @param masterOccupationId the primary key of the current master occupation
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master occupation
	 * @throws NoSuchMasterOccupationException if a master occupation with the primary key could not be found
	 */
	public MasterOccupation[] findBysearchByActive_PrevAndNext(
			long masterOccupationId, Integer active,
			com.liferay.portal.kernel.util.OrderByComparator<MasterOccupation>
				orderByComparator)
		throws NoSuchMasterOccupationException;

	/**
	 * Removes all the master occupations where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeBysearchByActive(Integer active);

	/**
	 * Returns the number of master occupations where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching master occupations
	 */
	public int countBysearchByActive(Integer active);

	/**
	 * Returns all the master occupations where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @return the matching master occupations
	 */
	public java.util.List<MasterOccupation>
		findBysearchByMasterOccupationCategoryId(
			long masterOccupationCategoryId);

	/**
	 * Returns a range of all the master occupations where masterOccupationCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @return the range of matching master occupations
	 */
	public java.util.List<MasterOccupation>
		findBysearchByMasterOccupationCategoryId(
			long masterOccupationCategoryId, int start, int end);

	/**
	 * Returns an ordered range of all the master occupations where masterOccupationCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master occupations
	 */
	public java.util.List<MasterOccupation>
		findBysearchByMasterOccupationCategoryId(
			long masterOccupationCategoryId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<MasterOccupation>
				orderByComparator);

	/**
	 * Returns an ordered range of all the master occupations where masterOccupationCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master occupations
	 */
	public java.util.List<MasterOccupation>
		findBysearchByMasterOccupationCategoryId(
			long masterOccupationCategoryId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<MasterOccupation>
				orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first master occupation in the ordered set where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation
	 * @throws NoSuchMasterOccupationException if a matching master occupation could not be found
	 */
	public MasterOccupation findBysearchByMasterOccupationCategoryId_First(
			long masterOccupationCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<MasterOccupation>
				orderByComparator)
		throws NoSuchMasterOccupationException;

	/**
	 * Returns the first master occupation in the ordered set where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation, or <code>null</code> if a matching master occupation could not be found
	 */
	public MasterOccupation fetchBysearchByMasterOccupationCategoryId_First(
		long masterOccupationCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<MasterOccupation>
			orderByComparator);

	/**
	 * Returns the last master occupation in the ordered set where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation
	 * @throws NoSuchMasterOccupationException if a matching master occupation could not be found
	 */
	public MasterOccupation findBysearchByMasterOccupationCategoryId_Last(
			long masterOccupationCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<MasterOccupation>
				orderByComparator)
		throws NoSuchMasterOccupationException;

	/**
	 * Returns the last master occupation in the ordered set where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation, or <code>null</code> if a matching master occupation could not be found
	 */
	public MasterOccupation fetchBysearchByMasterOccupationCategoryId_Last(
		long masterOccupationCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<MasterOccupation>
			orderByComparator);

	/**
	 * Returns the master occupations before and after the current master occupation in the ordered set where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationId the primary key of the current master occupation
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master occupation
	 * @throws NoSuchMasterOccupationException if a master occupation with the primary key could not be found
	 */
	public MasterOccupation[]
			findBysearchByMasterOccupationCategoryId_PrevAndNext(
				long masterOccupationId, long masterOccupationCategoryId,
				com.liferay.portal.kernel.util.OrderByComparator
					<MasterOccupation> orderByComparator)
		throws NoSuchMasterOccupationException;

	/**
	 * Removes all the master occupations where masterOccupationCategoryId = &#63; from the database.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 */
	public void removeBysearchByMasterOccupationCategoryId(
		long masterOccupationCategoryId);

	/**
	 * Returns the number of master occupations where masterOccupationCategoryId = &#63;.
	 *
	 * @param masterOccupationCategoryId the master occupation category ID
	 * @return the number of matching master occupations
	 */
	public int countBysearchByMasterOccupationCategoryId(
		long masterOccupationCategoryId);

	/**
	 * Caches the master occupation in the entity cache if it is enabled.
	 *
	 * @param masterOccupation the master occupation
	 */
	public void cacheResult(MasterOccupation masterOccupation);

	/**
	 * Caches the master occupations in the entity cache if it is enabled.
	 *
	 * @param masterOccupations the master occupations
	 */
	public void cacheResult(java.util.List<MasterOccupation> masterOccupations);

	/**
	 * Creates a new master occupation with the primary key. Does not add the master occupation to the database.
	 *
	 * @param masterOccupationId the primary key for the new master occupation
	 * @return the new master occupation
	 */
	public MasterOccupation create(long masterOccupationId);

	/**
	 * Removes the master occupation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterOccupationId the primary key of the master occupation
	 * @return the master occupation that was removed
	 * @throws NoSuchMasterOccupationException if a master occupation with the primary key could not be found
	 */
	public MasterOccupation remove(long masterOccupationId)
		throws NoSuchMasterOccupationException;

	public MasterOccupation updateImpl(MasterOccupation masterOccupation);

	/**
	 * Returns the master occupation with the primary key or throws a <code>NoSuchMasterOccupationException</code> if it could not be found.
	 *
	 * @param masterOccupationId the primary key of the master occupation
	 * @return the master occupation
	 * @throws NoSuchMasterOccupationException if a master occupation with the primary key could not be found
	 */
	public MasterOccupation findByPrimaryKey(long masterOccupationId)
		throws NoSuchMasterOccupationException;

	/**
	 * Returns the master occupation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterOccupationId the primary key of the master occupation
	 * @return the master occupation, or <code>null</code> if a master occupation with the primary key could not be found
	 */
	public MasterOccupation fetchByPrimaryKey(long masterOccupationId);

	/**
	 * Returns all the master occupations.
	 *
	 * @return the master occupations
	 */
	public java.util.List<MasterOccupation> findAll();

	/**
	 * Returns a range of all the master occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @return the range of master occupations
	 */
	public java.util.List<MasterOccupation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the master occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master occupations
	 */
	public java.util.List<MasterOccupation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterOccupation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the master occupations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupations
	 * @param end the upper bound of the range of master occupations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master occupations
	 */
	public java.util.List<MasterOccupation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterOccupation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the master occupations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of master occupations.
	 *
	 * @return the number of master occupations
	 */
	public int countAll();

}