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

import com.mypage.admin.product.exception.NoSuchTravelDomesticBenefitException;
import com.mypage.admin.product.model.TravelDomesticBenefit;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the travel domestic benefit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticBenefitUtil
 * @generated
 */
@ProviderType
public interface TravelDomesticBenefitPersistence
	extends BasePersistence<TravelDomesticBenefit> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TravelDomesticBenefitUtil} to access the travel domestic benefit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the travel domestic benefits where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @return the matching travel domestic benefits
	 */
	public java.util.List<TravelDomesticBenefit>
		findBysearchTravelDomesticBenefitId(long travelDomesticBenefitId);

	/**
	 * Returns a range of all the travel domestic benefits where travelDomesticBenefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @return the range of matching travel domestic benefits
	 */
	public java.util.List<TravelDomesticBenefit>
		findBysearchTravelDomesticBenefitId(
			long travelDomesticBenefitId, int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic benefits where travelDomesticBenefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic benefits
	 */
	public java.util.List<TravelDomesticBenefit>
		findBysearchTravelDomesticBenefitId(
			long travelDomesticBenefitId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticBenefit> orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic benefits where travelDomesticBenefitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic benefits
	 */
	public java.util.List<TravelDomesticBenefit>
		findBysearchTravelDomesticBenefitId(
			long travelDomesticBenefitId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticBenefit> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first travel domestic benefit in the ordered set where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	public TravelDomesticBenefit findBysearchTravelDomesticBenefitId_First(
			long travelDomesticBenefitId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticBenefit> orderByComparator)
		throws NoSuchTravelDomesticBenefitException;

	/**
	 * Returns the first travel domestic benefit in the ordered set where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	public TravelDomesticBenefit fetchBysearchTravelDomesticBenefitId_First(
		long travelDomesticBenefitId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticBenefit>
			orderByComparator);

	/**
	 * Returns the last travel domestic benefit in the ordered set where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	public TravelDomesticBenefit findBysearchTravelDomesticBenefitId_Last(
			long travelDomesticBenefitId,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticBenefit> orderByComparator)
		throws NoSuchTravelDomesticBenefitException;

	/**
	 * Returns the last travel domestic benefit in the ordered set where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	public TravelDomesticBenefit fetchBysearchTravelDomesticBenefitId_Last(
		long travelDomesticBenefitId,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticBenefit>
			orderByComparator);

	/**
	 * Removes all the travel domestic benefits where travelDomesticBenefitId = &#63; from the database.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 */
	public void removeBysearchTravelDomesticBenefitId(
		long travelDomesticBenefitId);

	/**
	 * Returns the number of travel domestic benefits where travelDomesticBenefitId = &#63;.
	 *
	 * @param travelDomesticBenefitId the travel domestic benefit ID
	 * @return the number of matching travel domestic benefits
	 */
	public int countBysearchTravelDomesticBenefitId(
		long travelDomesticBenefitId);

	/**
	 * Returns all the travel domestic benefits where plan = &#63;.
	 *
	 * @param plan the plan
	 * @return the matching travel domestic benefits
	 */
	public java.util.List<TravelDomesticBenefit>
		findBysearchTravelDomesticBenefitPlan(String plan);

	/**
	 * Returns a range of all the travel domestic benefits where plan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param plan the plan
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @return the range of matching travel domestic benefits
	 */
	public java.util.List<TravelDomesticBenefit>
		findBysearchTravelDomesticBenefitPlan(String plan, int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic benefits where plan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param plan the plan
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic benefits
	 */
	public java.util.List<TravelDomesticBenefit>
		findBysearchTravelDomesticBenefitPlan(
			String plan, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticBenefit> orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic benefits where plan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param plan the plan
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic benefits
	 */
	public java.util.List<TravelDomesticBenefit>
		findBysearchTravelDomesticBenefitPlan(
			String plan, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticBenefit> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first travel domestic benefit in the ordered set where plan = &#63;.
	 *
	 * @param plan the plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	public TravelDomesticBenefit findBysearchTravelDomesticBenefitPlan_First(
			String plan,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticBenefit> orderByComparator)
		throws NoSuchTravelDomesticBenefitException;

	/**
	 * Returns the first travel domestic benefit in the ordered set where plan = &#63;.
	 *
	 * @param plan the plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	public TravelDomesticBenefit fetchBysearchTravelDomesticBenefitPlan_First(
		String plan,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticBenefit>
			orderByComparator);

	/**
	 * Returns the last travel domestic benefit in the ordered set where plan = &#63;.
	 *
	 * @param plan the plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	public TravelDomesticBenefit findBysearchTravelDomesticBenefitPlan_Last(
			String plan,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticBenefit> orderByComparator)
		throws NoSuchTravelDomesticBenefitException;

	/**
	 * Returns the last travel domestic benefit in the ordered set where plan = &#63;.
	 *
	 * @param plan the plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	public TravelDomesticBenefit fetchBysearchTravelDomesticBenefitPlan_Last(
		String plan,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticBenefit>
			orderByComparator);

	/**
	 * Returns the travel domestic benefits before and after the current travel domestic benefit in the ordered set where plan = &#63;.
	 *
	 * @param travelDomesticBenefitId the primary key of the current travel domestic benefit
	 * @param plan the plan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a travel domestic benefit with the primary key could not be found
	 */
	public TravelDomesticBenefit[]
			findBysearchTravelDomesticBenefitPlan_PrevAndNext(
				long travelDomesticBenefitId, String plan,
				com.liferay.portal.kernel.util.OrderByComparator
					<TravelDomesticBenefit> orderByComparator)
		throws NoSuchTravelDomesticBenefitException;

	/**
	 * Removes all the travel domestic benefits where plan = &#63; from the database.
	 *
	 * @param plan the plan
	 */
	public void removeBysearchTravelDomesticBenefitPlan(String plan);

	/**
	 * Returns the number of travel domestic benefits where plan = &#63;.
	 *
	 * @param plan the plan
	 * @return the number of matching travel domestic benefits
	 */
	public int countBysearchTravelDomesticBenefitPlan(String plan);

	/**
	 * Returns all the travel domestic benefits where group = &#63;.
	 *
	 * @param group the group
	 * @return the matching travel domestic benefits
	 */
	public java.util.List<TravelDomesticBenefit> findBysearchGroup(
		String group);

	/**
	 * Returns a range of all the travel domestic benefits where group = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param group the group
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @return the range of matching travel domestic benefits
	 */
	public java.util.List<TravelDomesticBenefit> findBysearchGroup(
		String group, int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic benefits where group = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param group the group
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic benefits
	 */
	public java.util.List<TravelDomesticBenefit> findBysearchGroup(
		String group, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticBenefit>
			orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic benefits where group = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param group the group
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic benefits
	 */
	public java.util.List<TravelDomesticBenefit> findBysearchGroup(
		String group, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticBenefit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel domestic benefit in the ordered set where group = &#63;.
	 *
	 * @param group the group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	public TravelDomesticBenefit findBysearchGroup_First(
			String group,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticBenefit> orderByComparator)
		throws NoSuchTravelDomesticBenefitException;

	/**
	 * Returns the first travel domestic benefit in the ordered set where group = &#63;.
	 *
	 * @param group the group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	public TravelDomesticBenefit fetchBysearchGroup_First(
		String group,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticBenefit>
			orderByComparator);

	/**
	 * Returns the last travel domestic benefit in the ordered set where group = &#63;.
	 *
	 * @param group the group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a matching travel domestic benefit could not be found
	 */
	public TravelDomesticBenefit findBysearchGroup_Last(
			String group,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticBenefit> orderByComparator)
		throws NoSuchTravelDomesticBenefitException;

	/**
	 * Returns the last travel domestic benefit in the ordered set where group = &#63;.
	 *
	 * @param group the group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit, or <code>null</code> if a matching travel domestic benefit could not be found
	 */
	public TravelDomesticBenefit fetchBysearchGroup_Last(
		String group,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticBenefit>
			orderByComparator);

	/**
	 * Returns the travel domestic benefits before and after the current travel domestic benefit in the ordered set where group = &#63;.
	 *
	 * @param travelDomesticBenefitId the primary key of the current travel domestic benefit
	 * @param group the group
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a travel domestic benefit with the primary key could not be found
	 */
	public TravelDomesticBenefit[] findBysearchGroup_PrevAndNext(
			long travelDomesticBenefitId, String group,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticBenefit> orderByComparator)
		throws NoSuchTravelDomesticBenefitException;

	/**
	 * Removes all the travel domestic benefits where group = &#63; from the database.
	 *
	 * @param group the group
	 */
	public void removeBysearchGroup(String group);

	/**
	 * Returns the number of travel domestic benefits where group = &#63;.
	 *
	 * @param group the group
	 * @return the number of matching travel domestic benefits
	 */
	public int countBysearchGroup(String group);

	/**
	 * Caches the travel domestic benefit in the entity cache if it is enabled.
	 *
	 * @param travelDomesticBenefit the travel domestic benefit
	 */
	public void cacheResult(TravelDomesticBenefit travelDomesticBenefit);

	/**
	 * Caches the travel domestic benefits in the entity cache if it is enabled.
	 *
	 * @param travelDomesticBenefits the travel domestic benefits
	 */
	public void cacheResult(
		java.util.List<TravelDomesticBenefit> travelDomesticBenefits);

	/**
	 * Creates a new travel domestic benefit with the primary key. Does not add the travel domestic benefit to the database.
	 *
	 * @param travelDomesticBenefitId the primary key for the new travel domestic benefit
	 * @return the new travel domestic benefit
	 */
	public TravelDomesticBenefit create(long travelDomesticBenefitId);

	/**
	 * Removes the travel domestic benefit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticBenefitId the primary key of the travel domestic benefit
	 * @return the travel domestic benefit that was removed
	 * @throws NoSuchTravelDomesticBenefitException if a travel domestic benefit with the primary key could not be found
	 */
	public TravelDomesticBenefit remove(long travelDomesticBenefitId)
		throws NoSuchTravelDomesticBenefitException;

	public TravelDomesticBenefit updateImpl(
		TravelDomesticBenefit travelDomesticBenefit);

	/**
	 * Returns the travel domestic benefit with the primary key or throws a <code>NoSuchTravelDomesticBenefitException</code> if it could not be found.
	 *
	 * @param travelDomesticBenefitId the primary key of the travel domestic benefit
	 * @return the travel domestic benefit
	 * @throws NoSuchTravelDomesticBenefitException if a travel domestic benefit with the primary key could not be found
	 */
	public TravelDomesticBenefit findByPrimaryKey(long travelDomesticBenefitId)
		throws NoSuchTravelDomesticBenefitException;

	/**
	 * Returns the travel domestic benefit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticBenefitId the primary key of the travel domestic benefit
	 * @return the travel domestic benefit, or <code>null</code> if a travel domestic benefit with the primary key could not be found
	 */
	public TravelDomesticBenefit fetchByPrimaryKey(
		long travelDomesticBenefitId);

	/**
	 * Returns all the travel domestic benefits.
	 *
	 * @return the travel domestic benefits
	 */
	public java.util.List<TravelDomesticBenefit> findAll();

	/**
	 * Returns a range of all the travel domestic benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @return the range of travel domestic benefits
	 */
	public java.util.List<TravelDomesticBenefit> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic benefits
	 */
	public java.util.List<TravelDomesticBenefit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticBenefit>
			orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic benefits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefits
	 * @param end the upper bound of the range of travel domestic benefits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic benefits
	 */
	public java.util.List<TravelDomesticBenefit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticBenefit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the travel domestic benefits from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of travel domestic benefits.
	 *
	 * @return the number of travel domestic benefits
	 */
	public int countAll();

}