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

import com.mypage.leads.exception.NoSuchDetailPetException;
import com.mypage.leads.model.DetailPet;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the detail pet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @see DetailPetUtil
 * @generated
 */
@ProviderType
public interface DetailPetPersistence extends BasePersistence<DetailPet> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DetailPetUtil} to access the detail pet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the detail pet where LeadsId = &#63; or throws a <code>NoSuchDetailPetException</code> if it could not be found.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail pet
	 * @throws NoSuchDetailPetException if a matching detail pet could not be found
	 */
	public DetailPet findBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailPetException;

	/**
	 * Returns the detail pet where LeadsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail pet, or <code>null</code> if a matching detail pet could not be found
	 */
	public DetailPet fetchBysearchByLeadsId(long LeadsId);

	/**
	 * Returns the detail pet where LeadsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching detail pet, or <code>null</code> if a matching detail pet could not be found
	 */
	public DetailPet fetchBysearchByLeadsId(
		long LeadsId, boolean useFinderCache);

	/**
	 * Removes the detail pet where LeadsId = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 * @return the detail pet that was removed
	 */
	public DetailPet removeBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailPetException;

	/**
	 * Returns the number of detail pets where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the number of matching detail pets
	 */
	public int countBysearchByLeadsId(long LeadsId);

	/**
	 * Caches the detail pet in the entity cache if it is enabled.
	 *
	 * @param detailPet the detail pet
	 */
	public void cacheResult(DetailPet detailPet);

	/**
	 * Caches the detail pets in the entity cache if it is enabled.
	 *
	 * @param detailPets the detail pets
	 */
	public void cacheResult(java.util.List<DetailPet> detailPets);

	/**
	 * Creates a new detail pet with the primary key. Does not add the detail pet to the database.
	 *
	 * @param detailPetId the primary key for the new detail pet
	 * @return the new detail pet
	 */
	public DetailPet create(long detailPetId);

	/**
	 * Removes the detail pet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param detailPetId the primary key of the detail pet
	 * @return the detail pet that was removed
	 * @throws NoSuchDetailPetException if a detail pet with the primary key could not be found
	 */
	public DetailPet remove(long detailPetId) throws NoSuchDetailPetException;

	public DetailPet updateImpl(DetailPet detailPet);

	/**
	 * Returns the detail pet with the primary key or throws a <code>NoSuchDetailPetException</code> if it could not be found.
	 *
	 * @param detailPetId the primary key of the detail pet
	 * @return the detail pet
	 * @throws NoSuchDetailPetException if a detail pet with the primary key could not be found
	 */
	public DetailPet findByPrimaryKey(long detailPetId)
		throws NoSuchDetailPetException;

	/**
	 * Returns the detail pet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param detailPetId the primary key of the detail pet
	 * @return the detail pet, or <code>null</code> if a detail pet with the primary key could not be found
	 */
	public DetailPet fetchByPrimaryKey(long detailPetId);

	/**
	 * Returns all the detail pets.
	 *
	 * @return the detail pets
	 */
	public java.util.List<DetailPet> findAll();

	/**
	 * Returns a range of all the detail pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailPetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail pets
	 * @param end the upper bound of the range of detail pets (not inclusive)
	 * @return the range of detail pets
	 */
	public java.util.List<DetailPet> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the detail pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailPetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail pets
	 * @param end the upper bound of the range of detail pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail pets
	 */
	public java.util.List<DetailPet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DetailPet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the detail pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailPetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail pets
	 * @param end the upper bound of the range of detail pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail pets
	 */
	public java.util.List<DetailPet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DetailPet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the detail pets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of detail pets.
	 *
	 * @return the number of detail pets
	 */
	public int countAll();

}