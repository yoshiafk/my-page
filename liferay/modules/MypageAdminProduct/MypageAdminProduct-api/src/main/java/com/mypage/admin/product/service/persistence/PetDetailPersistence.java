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

import com.mypage.admin.product.exception.NoSuchPetDetailException;
import com.mypage.admin.product.model.PetDetail;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pet detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PetDetailUtil
 * @generated
 */
@ProviderType
public interface PetDetailPersistence extends BasePersistence<PetDetail> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PetDetailUtil} to access the pet detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the pet detail in the entity cache if it is enabled.
	 *
	 * @param petDetail the pet detail
	 */
	public void cacheResult(PetDetail petDetail);

	/**
	 * Caches the pet details in the entity cache if it is enabled.
	 *
	 * @param petDetails the pet details
	 */
	public void cacheResult(java.util.List<PetDetail> petDetails);

	/**
	 * Creates a new pet detail with the primary key. Does not add the pet detail to the database.
	 *
	 * @param petDetailId the primary key for the new pet detail
	 * @return the new pet detail
	 */
	public PetDetail create(long petDetailId);

	/**
	 * Removes the pet detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petDetailId the primary key of the pet detail
	 * @return the pet detail that was removed
	 * @throws NoSuchPetDetailException if a pet detail with the primary key could not be found
	 */
	public PetDetail remove(long petDetailId) throws NoSuchPetDetailException;

	public PetDetail updateImpl(PetDetail petDetail);

	/**
	 * Returns the pet detail with the primary key or throws a <code>NoSuchPetDetailException</code> if it could not be found.
	 *
	 * @param petDetailId the primary key of the pet detail
	 * @return the pet detail
	 * @throws NoSuchPetDetailException if a pet detail with the primary key could not be found
	 */
	public PetDetail findByPrimaryKey(long petDetailId)
		throws NoSuchPetDetailException;

	/**
	 * Returns the pet detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petDetailId the primary key of the pet detail
	 * @return the pet detail, or <code>null</code> if a pet detail with the primary key could not be found
	 */
	public PetDetail fetchByPrimaryKey(long petDetailId);

	/**
	 * Returns all the pet details.
	 *
	 * @return the pet details
	 */
	public java.util.List<PetDetail> findAll();

	/**
	 * Returns a range of all the pet details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet details
	 * @param end the upper bound of the range of pet details (not inclusive)
	 * @return the range of pet details
	 */
	public java.util.List<PetDetail> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pet details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet details
	 * @param end the upper bound of the range of pet details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pet details
	 */
	public java.util.List<PetDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetDetail>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pet details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetDetailModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet details
	 * @param end the upper bound of the range of pet details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pet details
	 */
	public java.util.List<PetDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetDetail>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pet details from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pet details.
	 *
	 * @return the number of pet details
	 */
	public int countAll();

}