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

import com.mypage.admin.product.exception.NoSuchTravelDomesticPremiException;
import com.mypage.admin.product.model.TravelDomesticPremi;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the travel domestic premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see TravelDomesticPremiUtil
 * @generated
 */
@ProviderType
public interface TravelDomesticPremiPersistence
	extends BasePersistence<TravelDomesticPremi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TravelDomesticPremiUtil} to access the travel domestic premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @return the matching travel domestic premis
	 */
	public java.util.List<TravelDomesticPremi> findBysearchPremi(
		int duration, String plan, String insuredType);

	/**
	 * Returns a range of all the travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @return the range of matching travel domestic premis
	 */
	public java.util.List<TravelDomesticPremi> findBysearchPremi(
		int duration, String plan, String insuredType, int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic premis
	 */
	public java.util.List<TravelDomesticPremi> findBysearchPremi(
		int duration, String plan, String insuredType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPremi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic premis
	 */
	public java.util.List<TravelDomesticPremi> findBysearchPremi(
		int duration, String plan, String insuredType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPremi>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first travel domestic premi in the ordered set where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic premi
	 * @throws NoSuchTravelDomesticPremiException if a matching travel domestic premi could not be found
	 */
	public TravelDomesticPremi findBysearchPremi_First(
			int duration, String plan, String insuredType,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticPremi> orderByComparator)
		throws NoSuchTravelDomesticPremiException;

	/**
	 * Returns the first travel domestic premi in the ordered set where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic premi, or <code>null</code> if a matching travel domestic premi could not be found
	 */
	public TravelDomesticPremi fetchBysearchPremi_First(
		int duration, String plan, String insuredType,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPremi>
			orderByComparator);

	/**
	 * Returns the last travel domestic premi in the ordered set where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic premi
	 * @throws NoSuchTravelDomesticPremiException if a matching travel domestic premi could not be found
	 */
	public TravelDomesticPremi findBysearchPremi_Last(
			int duration, String plan, String insuredType,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticPremi> orderByComparator)
		throws NoSuchTravelDomesticPremiException;

	/**
	 * Returns the last travel domestic premi in the ordered set where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic premi, or <code>null</code> if a matching travel domestic premi could not be found
	 */
	public TravelDomesticPremi fetchBysearchPremi_Last(
		int duration, String plan, String insuredType,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPremi>
			orderByComparator);

	/**
	 * Returns the travel domestic premis before and after the current travel domestic premi in the ordered set where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param travelDomesticPremiId the primary key of the current travel domestic premi
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel domestic premi
	 * @throws NoSuchTravelDomesticPremiException if a travel domestic premi with the primary key could not be found
	 */
	public TravelDomesticPremi[] findBysearchPremi_PrevAndNext(
			long travelDomesticPremiId, int duration, String plan,
			String insuredType,
			com.liferay.portal.kernel.util.OrderByComparator
				<TravelDomesticPremi> orderByComparator)
		throws NoSuchTravelDomesticPremiException;

	/**
	 * Removes all the travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63; from the database.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 */
	public void removeBysearchPremi(
		int duration, String plan, String insuredType);

	/**
	 * Returns the number of travel domestic premis where duration = &#63; and plan = &#63; and insuredType = &#63;.
	 *
	 * @param duration the duration
	 * @param plan the plan
	 * @param insuredType the insured type
	 * @return the number of matching travel domestic premis
	 */
	public int countBysearchPremi(
		int duration, String plan, String insuredType);

	/**
	 * Caches the travel domestic premi in the entity cache if it is enabled.
	 *
	 * @param travelDomesticPremi the travel domestic premi
	 */
	public void cacheResult(TravelDomesticPremi travelDomesticPremi);

	/**
	 * Caches the travel domestic premis in the entity cache if it is enabled.
	 *
	 * @param travelDomesticPremis the travel domestic premis
	 */
	public void cacheResult(
		java.util.List<TravelDomesticPremi> travelDomesticPremis);

	/**
	 * Creates a new travel domestic premi with the primary key. Does not add the travel domestic premi to the database.
	 *
	 * @param travelDomesticPremiId the primary key for the new travel domestic premi
	 * @return the new travel domestic premi
	 */
	public TravelDomesticPremi create(long travelDomesticPremiId);

	/**
	 * Removes the travel domestic premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticPremiId the primary key of the travel domestic premi
	 * @return the travel domestic premi that was removed
	 * @throws NoSuchTravelDomesticPremiException if a travel domestic premi with the primary key could not be found
	 */
	public TravelDomesticPremi remove(long travelDomesticPremiId)
		throws NoSuchTravelDomesticPremiException;

	public TravelDomesticPremi updateImpl(
		TravelDomesticPremi travelDomesticPremi);

	/**
	 * Returns the travel domestic premi with the primary key or throws a <code>NoSuchTravelDomesticPremiException</code> if it could not be found.
	 *
	 * @param travelDomesticPremiId the primary key of the travel domestic premi
	 * @return the travel domestic premi
	 * @throws NoSuchTravelDomesticPremiException if a travel domestic premi with the primary key could not be found
	 */
	public TravelDomesticPremi findByPrimaryKey(long travelDomesticPremiId)
		throws NoSuchTravelDomesticPremiException;

	/**
	 * Returns the travel domestic premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticPremiId the primary key of the travel domestic premi
	 * @return the travel domestic premi, or <code>null</code> if a travel domestic premi with the primary key could not be found
	 */
	public TravelDomesticPremi fetchByPrimaryKey(long travelDomesticPremiId);

	/**
	 * Returns all the travel domestic premis.
	 *
	 * @return the travel domestic premis
	 */
	public java.util.List<TravelDomesticPremi> findAll();

	/**
	 * Returns a range of all the travel domestic premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @return the range of travel domestic premis
	 */
	public java.util.List<TravelDomesticPremi> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the travel domestic premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic premis
	 */
	public java.util.List<TravelDomesticPremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPremi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the travel domestic premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic premis
	 * @param end the upper bound of the range of travel domestic premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic premis
	 */
	public java.util.List<TravelDomesticPremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TravelDomesticPremi>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the travel domestic premis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of travel domestic premis.
	 *
	 * @return the number of travel domestic premis
	 */
	public int countAll();

}