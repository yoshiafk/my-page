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

import com.mypage.admin.product.exception.NoSuchTravelIntBenefitException;
import com.mypage.admin.product.model.TravelIntBenefit;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the travel int benefit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelIntBenefitUtil
 * @generated
 */
@ProviderType
public interface TravelIntBenefitPersistence
	extends BasePersistence<TravelIntBenefit> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TravelIntBenefitUtil} to access the travel int benefit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the travel int benefit in the entity cache if it is enabled.
	 *
	 * @param travelIntBenefit the travel int benefit
	 */
	public void cacheResult(TravelIntBenefit travelIntBenefit);

	/**
	 * Caches the travel int benefits in the entity cache if it is enabled.
	 *
	 * @param travelIntBenefits the travel int benefits
	 */
	public void cacheResult(java.util.List<TravelIntBenefit> travelIntBenefits);

	/**
	 * Creates a new travel int benefit with the primary key. Does not add the travel int benefit to the database.
	 *
	 * @param travelIntBenefitId the primary key for the new travel int benefit
	 * @return the new travel int benefit
	 */
	public TravelIntBenefit create(long travelIntBenefitId);

	/**
	 * Removes the travel int benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelIntBenefitId the primary key of the travel int benefit
	 * @return the travel int benefit that was removed
	 * @throws NoSuchTravelIntBenefitException if a travel int benefit with the primary key could not be found
	 */
	public TravelIntBenefit remove(long travelIntBenefitId)
		throws NoSuchTravelIntBenefitException;

	public TravelIntBenefit updateImpl(TravelIntBenefit travelIntBenefit);

	/**
	 * Returns the travel int benefit with the primary key or throws a <code>NoSuchTravelIntBenefitException</code> if it could not be found.
	 *
	 * @param travelIntBenefitId the primary key of the travel int benefit
	 * @return the travel int benefit
	 * @throws NoSuchTravelIntBenefitException if a travel int benefit with the primary key could not be found
	 */
	public TravelIntBenefit findByPrimaryKey(long travelIntBenefitId)
		throws NoSuchTravelIntBenefitException;

	/**
	 * Returns the travel int benefit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelIntBenefitId the primary key of the travel int benefit
	 * @return the travel int benefit, or <code>null</code> if a travel int benefit with the primary key could not be found
	 */
	public TravelIntBenefit fetchByPrimaryKey(long travelIntBenefitId);

	/**
	 * Returns all the travel int benefits.
	 *
	 * @return the travel int benefits
	 */
	public java.util.List<TravelIntBenefit> findAll();

	/**
	 * Returns a range of all the travel int benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefits
	 * @param end the upper bound of the range of travel int benefits (not inclusive)
	 * @return the range of travel int benefits
	 */
	public java.util.List<TravelIntBenefit> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the travel int benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefits
	 * @param end the upper bound of the range of travel int benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel int benefits
	 */
	public java.util.List<TravelIntBenefit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelIntBenefit>
			orderByComparator);

	/**
	 * Returns an ordered range of all the travel int benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefits
	 * @param end the upper bound of the range of travel int benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel int benefits
	 */
	public java.util.List<TravelIntBenefit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelIntBenefit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the travel int benefits from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of travel int benefits.
	 *
	 * @return the number of travel int benefits
	 */
	public int countAll();

}