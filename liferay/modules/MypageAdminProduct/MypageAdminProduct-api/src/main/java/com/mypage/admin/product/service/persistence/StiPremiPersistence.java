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

import com.mypage.admin.product.exception.NoSuchStiPremiException;
import com.mypage.admin.product.model.StiPremi;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sti premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see StiPremiUtil
 * @generated
 */
@ProviderType
public interface StiPremiPersistence extends BasePersistence<StiPremi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StiPremiUtil} to access the sti premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the sti premis where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @return the matching sti premis
	 */
	public java.util.List<StiPremi> findByCurrencyAndTravellerType(
		String currency, String travellerType);

	/**
	 * Returns a range of all the sti premis where currency = &#63; and travellerType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiPremiModelImpl</code>.
	 * </p>
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param start the lower bound of the range of sti premis
	 * @param end the upper bound of the range of sti premis (not inclusive)
	 * @return the range of matching sti premis
	 */
	public java.util.List<StiPremi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end);

	/**
	 * Returns an ordered range of all the sti premis where currency = &#63; and travellerType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiPremiModelImpl</code>.
	 * </p>
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param start the lower bound of the range of sti premis
	 * @param end the upper bound of the range of sti premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sti premis
	 */
	public java.util.List<StiPremi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StiPremi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sti premis where currency = &#63; and travellerType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiPremiModelImpl</code>.
	 * </p>
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param start the lower bound of the range of sti premis
	 * @param end the upper bound of the range of sti premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sti premis
	 */
	public java.util.List<StiPremi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StiPremi>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sti premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sti premi
	 * @throws NoSuchStiPremiException if a matching sti premi could not be found
	 */
	public StiPremi findByCurrencyAndTravellerType_First(
			String currency, String travellerType,
			com.liferay.portal.kernel.util.OrderByComparator<StiPremi>
				orderByComparator)
		throws NoSuchStiPremiException;

	/**
	 * Returns the first sti premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sti premi, or <code>null</code> if a matching sti premi could not be found
	 */
	public StiPremi fetchByCurrencyAndTravellerType_First(
		String currency, String travellerType,
		com.liferay.portal.kernel.util.OrderByComparator<StiPremi>
			orderByComparator);

	/**
	 * Returns the last sti premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sti premi
	 * @throws NoSuchStiPremiException if a matching sti premi could not be found
	 */
	public StiPremi findByCurrencyAndTravellerType_Last(
			String currency, String travellerType,
			com.liferay.portal.kernel.util.OrderByComparator<StiPremi>
				orderByComparator)
		throws NoSuchStiPremiException;

	/**
	 * Returns the last sti premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sti premi, or <code>null</code> if a matching sti premi could not be found
	 */
	public StiPremi fetchByCurrencyAndTravellerType_Last(
		String currency, String travellerType,
		com.liferay.portal.kernel.util.OrderByComparator<StiPremi>
			orderByComparator);

	/**
	 * Returns the sti premis before and after the current sti premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param premiId the primary key of the current sti premi
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sti premi
	 * @throws NoSuchStiPremiException if a sti premi with the primary key could not be found
	 */
	public StiPremi[] findByCurrencyAndTravellerType_PrevAndNext(
			long premiId, String currency, String travellerType,
			com.liferay.portal.kernel.util.OrderByComparator<StiPremi>
				orderByComparator)
		throws NoSuchStiPremiException;

	/**
	 * Removes all the sti premis where currency = &#63; and travellerType = &#63; from the database.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 */
	public void removeByCurrencyAndTravellerType(
		String currency, String travellerType);

	/**
	 * Returns the number of sti premis where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @return the number of matching sti premis
	 */
	public int countByCurrencyAndTravellerType(
		String currency, String travellerType);

	/**
	 * Caches the sti premi in the entity cache if it is enabled.
	 *
	 * @param stiPremi the sti premi
	 */
	public void cacheResult(StiPremi stiPremi);

	/**
	 * Caches the sti premis in the entity cache if it is enabled.
	 *
	 * @param stiPremis the sti premis
	 */
	public void cacheResult(java.util.List<StiPremi> stiPremis);

	/**
	 * Creates a new sti premi with the primary key. Does not add the sti premi to the database.
	 *
	 * @param premiId the primary key for the new sti premi
	 * @return the new sti premi
	 */
	public StiPremi create(long premiId);

	/**
	 * Removes the sti premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param premiId the primary key of the sti premi
	 * @return the sti premi that was removed
	 * @throws NoSuchStiPremiException if a sti premi with the primary key could not be found
	 */
	public StiPremi remove(long premiId) throws NoSuchStiPremiException;

	public StiPremi updateImpl(StiPremi stiPremi);

	/**
	 * Returns the sti premi with the primary key or throws a <code>NoSuchStiPremiException</code> if it could not be found.
	 *
	 * @param premiId the primary key of the sti premi
	 * @return the sti premi
	 * @throws NoSuchStiPremiException if a sti premi with the primary key could not be found
	 */
	public StiPremi findByPrimaryKey(long premiId)
		throws NoSuchStiPremiException;

	/**
	 * Returns the sti premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param premiId the primary key of the sti premi
	 * @return the sti premi, or <code>null</code> if a sti premi with the primary key could not be found
	 */
	public StiPremi fetchByPrimaryKey(long premiId);

	/**
	 * Returns all the sti premis.
	 *
	 * @return the sti premis
	 */
	public java.util.List<StiPremi> findAll();

	/**
	 * Returns a range of all the sti premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti premis
	 * @param end the upper bound of the range of sti premis (not inclusive)
	 * @return the range of sti premis
	 */
	public java.util.List<StiPremi> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the sti premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti premis
	 * @param end the upper bound of the range of sti premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sti premis
	 */
	public java.util.List<StiPremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StiPremi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sti premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StiPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sti premis
	 * @param end the upper bound of the range of sti premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sti premis
	 */
	public java.util.List<StiPremi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StiPremi>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sti premis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sti premis.
	 *
	 * @return the number of sti premis
	 */
	public int countAll();

}