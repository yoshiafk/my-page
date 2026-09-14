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

import com.mypage.admin.product.exception.NoSuchPremiException;
import com.mypage.admin.product.model.Premi;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PremiUtil
 * @generated
 */
@ProviderType
public interface PremiPersistence extends BasePersistence<Premi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PremiUtil} to access the premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the premis where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @return the matching premis
	 */
	public java.util.List<Premi> findByCurrencyAndTravellerType(
		String currency, String travellerType);

	/**
	 * Returns a range of all the premis where currency = &#63; and travellerType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PremiModelImpl</code>.
	 * </p>
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param start the lower bound of the range of premis
	 * @param end the upper bound of the range of premis (not inclusive)
	 * @return the range of matching premis
	 */
	public java.util.List<Premi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end);

	/**
	 * Returns an ordered range of all the premis where currency = &#63; and travellerType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PremiModelImpl</code>.
	 * </p>
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param start the lower bound of the range of premis
	 * @param end the upper bound of the range of premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching premis
	 */
	public java.util.List<Premi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Premi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the premis where currency = &#63; and travellerType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PremiModelImpl</code>.
	 * </p>
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param start the lower bound of the range of premis
	 * @param end the upper bound of the range of premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching premis
	 */
	public java.util.List<Premi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Premi>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching premi
	 * @throws NoSuchPremiException if a matching premi could not be found
	 */
	public Premi findByCurrencyAndTravellerType_First(
			String currency, String travellerType,
			com.liferay.portal.kernel.util.OrderByComparator<Premi>
				orderByComparator)
		throws NoSuchPremiException;

	/**
	 * Returns the first premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching premi, or <code>null</code> if a matching premi could not be found
	 */
	public Premi fetchByCurrencyAndTravellerType_First(
		String currency, String travellerType,
		com.liferay.portal.kernel.util.OrderByComparator<Premi>
			orderByComparator);

	/**
	 * Returns the last premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching premi
	 * @throws NoSuchPremiException if a matching premi could not be found
	 */
	public Premi findByCurrencyAndTravellerType_Last(
			String currency, String travellerType,
			com.liferay.portal.kernel.util.OrderByComparator<Premi>
				orderByComparator)
		throws NoSuchPremiException;

	/**
	 * Returns the last premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching premi, or <code>null</code> if a matching premi could not be found
	 */
	public Premi fetchByCurrencyAndTravellerType_Last(
		String currency, String travellerType,
		com.liferay.portal.kernel.util.OrderByComparator<Premi>
			orderByComparator);

	/**
	 * Returns the premis before and after the current premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param premiId the primary key of the current premi
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next premi
	 * @throws NoSuchPremiException if a premi with the primary key could not be found
	 */
	public Premi[] findByCurrencyAndTravellerType_PrevAndNext(
			long premiId, String currency, String travellerType,
			com.liferay.portal.kernel.util.OrderByComparator<Premi>
				orderByComparator)
		throws NoSuchPremiException;

	/**
	 * Removes all the premis where currency = &#63; and travellerType = &#63; from the database.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 */
	public void removeByCurrencyAndTravellerType(
		String currency, String travellerType);

	/**
	 * Returns the number of premis where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @return the number of matching premis
	 */
	public int countByCurrencyAndTravellerType(
		String currency, String travellerType);

	/**
	 * Caches the premi in the entity cache if it is enabled.
	 *
	 * @param premi the premi
	 */
	public void cacheResult(Premi premi);

	/**
	 * Caches the premis in the entity cache if it is enabled.
	 *
	 * @param premis the premis
	 */
	public void cacheResult(java.util.List<Premi> premis);

	/**
	 * Creates a new premi with the primary key. Does not add the premi to the database.
	 *
	 * @param premiId the primary key for the new premi
	 * @return the new premi
	 */
	public Premi create(long premiId);

	/**
	 * Removes the premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param premiId the primary key of the premi
	 * @return the premi that was removed
	 * @throws NoSuchPremiException if a premi with the primary key could not be found
	 */
	public Premi remove(long premiId) throws NoSuchPremiException;

	public Premi updateImpl(Premi premi);

	/**
	 * Returns the premi with the primary key or throws a <code>NoSuchPremiException</code> if it could not be found.
	 *
	 * @param premiId the primary key of the premi
	 * @return the premi
	 * @throws NoSuchPremiException if a premi with the primary key could not be found
	 */
	public Premi findByPrimaryKey(long premiId) throws NoSuchPremiException;

	/**
	 * Returns the premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param premiId the primary key of the premi
	 * @return the premi, or <code>null</code> if a premi with the primary key could not be found
	 */
	public Premi fetchByPrimaryKey(long premiId);

	/**
	 * Returns all the premis.
	 *
	 * @return the premis
	 */
	public java.util.List<Premi> findAll();

	/**
	 * Returns a range of all the premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of premis
	 * @param end the upper bound of the range of premis (not inclusive)
	 * @return the range of premis
	 */
	public java.util.List<Premi> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of premis
	 * @param end the upper bound of the range of premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of premis
	 */
	public java.util.List<Premi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Premi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of premis
	 * @param end the upper bound of the range of premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of premis
	 */
	public java.util.List<Premi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Premi>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the premis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of premis.
	 *
	 * @return the number of premis
	 */
	public int countAll();

}