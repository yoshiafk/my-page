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

import com.mypage.admin.product.exception.NoSuchPetRateException;
import com.mypage.admin.product.model.PetRate;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pet rate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PetRateUtil
 * @generated
 */
@ProviderType
public interface PetRatePersistence extends BasePersistence<PetRate> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PetRateUtil} to access the pet rate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the pet rates where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @return the matching pet rates
	 */
	public java.util.List<PetRate> findByPlan(long petPlan);

	/**
	 * Returns a range of all the pet rates where petPlan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param petPlan the pet plan
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @return the range of matching pet rates
	 */
	public java.util.List<PetRate> findByPlan(long petPlan, int start, int end);

	/**
	 * Returns an ordered range of all the pet rates where petPlan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param petPlan the pet plan
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet rates
	 */
	public java.util.List<PetRate> findByPlan(
		long petPlan, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetRate>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pet rates where petPlan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param petPlan the pet plan
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet rates
	 */
	public java.util.List<PetRate> findByPlan(
		long petPlan, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetRate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet rate in the ordered set where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet rate
	 * @throws NoSuchPetRateException if a matching pet rate could not be found
	 */
	public PetRate findByPlan_First(
			long petPlan,
			com.liferay.portal.kernel.util.OrderByComparator<PetRate>
				orderByComparator)
		throws NoSuchPetRateException;

	/**
	 * Returns the first pet rate in the ordered set where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet rate, or <code>null</code> if a matching pet rate could not be found
	 */
	public PetRate fetchByPlan_First(
		long petPlan,
		com.liferay.portal.kernel.util.OrderByComparator<PetRate>
			orderByComparator);

	/**
	 * Returns the last pet rate in the ordered set where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet rate
	 * @throws NoSuchPetRateException if a matching pet rate could not be found
	 */
	public PetRate findByPlan_Last(
			long petPlan,
			com.liferay.portal.kernel.util.OrderByComparator<PetRate>
				orderByComparator)
		throws NoSuchPetRateException;

	/**
	 * Returns the last pet rate in the ordered set where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet rate, or <code>null</code> if a matching pet rate could not be found
	 */
	public PetRate fetchByPlan_Last(
		long petPlan,
		com.liferay.portal.kernel.util.OrderByComparator<PetRate>
			orderByComparator);

	/**
	 * Returns the pet rates before and after the current pet rate in the ordered set where petPlan = &#63;.
	 *
	 * @param petRateId the primary key of the current pet rate
	 * @param petPlan the pet plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet rate
	 * @throws NoSuchPetRateException if a pet rate with the primary key could not be found
	 */
	public PetRate[] findByPlan_PrevAndNext(
			long petRateId, long petPlan,
			com.liferay.portal.kernel.util.OrderByComparator<PetRate>
				orderByComparator)
		throws NoSuchPetRateException;

	/**
	 * Removes all the pet rates where petPlan = &#63; from the database.
	 *
	 * @param petPlan the pet plan
	 */
	public void removeByPlan(long petPlan);

	/**
	 * Returns the number of pet rates where petPlan = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @return the number of matching pet rates
	 */
	public int countByPlan(long petPlan);

	/**
	 * Returns the pet rate where petPlan = &#63; and petRemarks = &#63; or throws a <code>NoSuchPetRateException</code> if it could not be found.
	 *
	 * @param petPlan the pet plan
	 * @param petRemarks the pet remarks
	 * @return the matching pet rate
	 * @throws NoSuchPetRateException if a matching pet rate could not be found
	 */
	public PetRate findBysearchByPetPlanAndPetRemarks(
			long petPlan, long petRemarks)
		throws NoSuchPetRateException;

	/**
	 * Returns the pet rate where petPlan = &#63; and petRemarks = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param petPlan the pet plan
	 * @param petRemarks the pet remarks
	 * @return the matching pet rate, or <code>null</code> if a matching pet rate could not be found
	 */
	public PetRate fetchBysearchByPetPlanAndPetRemarks(
		long petPlan, long petRemarks);

	/**
	 * Returns the pet rate where petPlan = &#63; and petRemarks = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param petPlan the pet plan
	 * @param petRemarks the pet remarks
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet rate, or <code>null</code> if a matching pet rate could not be found
	 */
	public PetRate fetchBysearchByPetPlanAndPetRemarks(
		long petPlan, long petRemarks, boolean useFinderCache);

	/**
	 * Removes the pet rate where petPlan = &#63; and petRemarks = &#63; from the database.
	 *
	 * @param petPlan the pet plan
	 * @param petRemarks the pet remarks
	 * @return the pet rate that was removed
	 */
	public PetRate removeBysearchByPetPlanAndPetRemarks(
			long petPlan, long petRemarks)
		throws NoSuchPetRateException;

	/**
	 * Returns the number of pet rates where petPlan = &#63; and petRemarks = &#63;.
	 *
	 * @param petPlan the pet plan
	 * @param petRemarks the pet remarks
	 * @return the number of matching pet rates
	 */
	public int countBysearchByPetPlanAndPetRemarks(
		long petPlan, long petRemarks);

	/**
	 * Caches the pet rate in the entity cache if it is enabled.
	 *
	 * @param petRate the pet rate
	 */
	public void cacheResult(PetRate petRate);

	/**
	 * Caches the pet rates in the entity cache if it is enabled.
	 *
	 * @param petRates the pet rates
	 */
	public void cacheResult(java.util.List<PetRate> petRates);

	/**
	 * Creates a new pet rate with the primary key. Does not add the pet rate to the database.
	 *
	 * @param petRateId the primary key for the new pet rate
	 * @return the new pet rate
	 */
	public PetRate create(long petRateId);

	/**
	 * Removes the pet rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petRateId the primary key of the pet rate
	 * @return the pet rate that was removed
	 * @throws NoSuchPetRateException if a pet rate with the primary key could not be found
	 */
	public PetRate remove(long petRateId) throws NoSuchPetRateException;

	public PetRate updateImpl(PetRate petRate);

	/**
	 * Returns the pet rate with the primary key or throws a <code>NoSuchPetRateException</code> if it could not be found.
	 *
	 * @param petRateId the primary key of the pet rate
	 * @return the pet rate
	 * @throws NoSuchPetRateException if a pet rate with the primary key could not be found
	 */
	public PetRate findByPrimaryKey(long petRateId)
		throws NoSuchPetRateException;

	/**
	 * Returns the pet rate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petRateId the primary key of the pet rate
	 * @return the pet rate, or <code>null</code> if a pet rate with the primary key could not be found
	 */
	public PetRate fetchByPrimaryKey(long petRateId);

	/**
	 * Returns all the pet rates.
	 *
	 * @return the pet rates
	 */
	public java.util.List<PetRate> findAll();

	/**
	 * Returns a range of all the pet rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @return the range of pet rates
	 */
	public java.util.List<PetRate> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pet rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pet rates
	 */
	public java.util.List<PetRate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetRate>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pet rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetRateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet rates
	 * @param end the upper bound of the range of pet rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pet rates
	 */
	public java.util.List<PetRate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetRate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pet rates from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pet rates.
	 *
	 * @return the number of pet rates
	 */
	public int countAll();

}