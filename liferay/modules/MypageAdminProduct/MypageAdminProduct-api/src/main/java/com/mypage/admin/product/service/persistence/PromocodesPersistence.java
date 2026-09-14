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

import com.mypage.admin.product.exception.NoSuchPromocodesException;
import com.mypage.admin.product.model.Promocodes;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the promocodes service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PromocodesUtil
 * @generated
 */
@ProviderType
public interface PromocodesPersistence extends BasePersistence<Promocodes> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PromocodesUtil} to access the promocodes persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the promocodeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching promocodeses
	 */
	public java.util.List<Promocodes> findByUuid(String uuid);

	/**
	 * Returns a range of all the promocodeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PromocodesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of promocodeses
	 * @param end the upper bound of the range of promocodeses (not inclusive)
	 * @return the range of matching promocodeses
	 */
	public java.util.List<Promocodes> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the promocodeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PromocodesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of promocodeses
	 * @param end the upper bound of the range of promocodeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching promocodeses
	 */
	public java.util.List<Promocodes> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator);

	/**
	 * Returns an ordered range of all the promocodeses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PromocodesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of promocodeses
	 * @param end the upper bound of the range of promocodeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching promocodeses
	 */
	public java.util.List<Promocodes> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first promocodes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	public Promocodes findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
				orderByComparator)
		throws NoSuchPromocodesException;

	/**
	 * Returns the first promocodes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public Promocodes fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator);

	/**
	 * Returns the last promocodes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	public Promocodes findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
				orderByComparator)
		throws NoSuchPromocodesException;

	/**
	 * Returns the last promocodes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public Promocodes fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator);

	/**
	 * Returns the promocodeses before and after the current promocodes in the ordered set where uuid = &#63;.
	 *
	 * @param promocodeId the primary key of the current promocodes
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next promocodes
	 * @throws NoSuchPromocodesException if a promocodes with the primary key could not be found
	 */
	public Promocodes[] findByUuid_PrevAndNext(
			long promocodeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
				orderByComparator)
		throws NoSuchPromocodesException;

	/**
	 * Removes all the promocodeses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of promocodeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching promocodeses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the promocodes where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPromocodesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	public Promocodes findByUUID_G(String uuid, long groupId)
		throws NoSuchPromocodesException;

	/**
	 * Returns the promocodes where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public Promocodes fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the promocodes where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public Promocodes fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the promocodes where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the promocodes that was removed
	 */
	public Promocodes removeByUUID_G(String uuid, long groupId)
		throws NoSuchPromocodesException;

	/**
	 * Returns the number of promocodeses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching promocodeses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the promocodeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching promocodeses
	 */
	public java.util.List<Promocodes> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the promocodeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PromocodesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of promocodeses
	 * @param end the upper bound of the range of promocodeses (not inclusive)
	 * @return the range of matching promocodeses
	 */
	public java.util.List<Promocodes> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the promocodeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PromocodesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of promocodeses
	 * @param end the upper bound of the range of promocodeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching promocodeses
	 */
	public java.util.List<Promocodes> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator);

	/**
	 * Returns an ordered range of all the promocodeses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PromocodesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of promocodeses
	 * @param end the upper bound of the range of promocodeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching promocodeses
	 */
	public java.util.List<Promocodes> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first promocodes in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	public Promocodes findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
				orderByComparator)
		throws NoSuchPromocodesException;

	/**
	 * Returns the first promocodes in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public Promocodes fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator);

	/**
	 * Returns the last promocodes in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	public Promocodes findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
				orderByComparator)
		throws NoSuchPromocodesException;

	/**
	 * Returns the last promocodes in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public Promocodes fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator);

	/**
	 * Returns the promocodeses before and after the current promocodes in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param promocodeId the primary key of the current promocodes
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next promocodes
	 * @throws NoSuchPromocodesException if a promocodes with the primary key could not be found
	 */
	public Promocodes[] findByUuid_C_PrevAndNext(
			long promocodeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
				orderByComparator)
		throws NoSuchPromocodesException;

	/**
	 * Removes all the promocodeses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of promocodeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching promocodeses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the promocodeses where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @return the matching promocodeses
	 */
	public java.util.List<Promocodes> findBysearchPromocode(String promocode);

	/**
	 * Returns a range of all the promocodeses where promocode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PromocodesModelImpl</code>.
	 * </p>
	 *
	 * @param promocode the promocode
	 * @param start the lower bound of the range of promocodeses
	 * @param end the upper bound of the range of promocodeses (not inclusive)
	 * @return the range of matching promocodeses
	 */
	public java.util.List<Promocodes> findBysearchPromocode(
		String promocode, int start, int end);

	/**
	 * Returns an ordered range of all the promocodeses where promocode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PromocodesModelImpl</code>.
	 * </p>
	 *
	 * @param promocode the promocode
	 * @param start the lower bound of the range of promocodeses
	 * @param end the upper bound of the range of promocodeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching promocodeses
	 */
	public java.util.List<Promocodes> findBysearchPromocode(
		String promocode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator);

	/**
	 * Returns an ordered range of all the promocodeses where promocode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PromocodesModelImpl</code>.
	 * </p>
	 *
	 * @param promocode the promocode
	 * @param start the lower bound of the range of promocodeses
	 * @param end the upper bound of the range of promocodeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching promocodeses
	 */
	public java.util.List<Promocodes> findBysearchPromocode(
		String promocode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first promocodes in the ordered set where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	public Promocodes findBysearchPromocode_First(
			String promocode,
			com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
				orderByComparator)
		throws NoSuchPromocodesException;

	/**
	 * Returns the first promocodes in the ordered set where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public Promocodes fetchBysearchPromocode_First(
		String promocode,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator);

	/**
	 * Returns the last promocodes in the ordered set where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	public Promocodes findBysearchPromocode_Last(
			String promocode,
			com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
				orderByComparator)
		throws NoSuchPromocodesException;

	/**
	 * Returns the last promocodes in the ordered set where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public Promocodes fetchBysearchPromocode_Last(
		String promocode,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator);

	/**
	 * Returns the promocodeses before and after the current promocodes in the ordered set where promocode = &#63;.
	 *
	 * @param promocodeId the primary key of the current promocodes
	 * @param promocode the promocode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next promocodes
	 * @throws NoSuchPromocodesException if a promocodes with the primary key could not be found
	 */
	public Promocodes[] findBysearchPromocode_PrevAndNext(
			long promocodeId, String promocode,
			com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
				orderByComparator)
		throws NoSuchPromocodesException;

	/**
	 * Removes all the promocodeses where promocode = &#63; from the database.
	 *
	 * @param promocode the promocode
	 */
	public void removeBysearchPromocode(String promocode);

	/**
	 * Returns the number of promocodeses where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @return the number of matching promocodeses
	 */
	public int countBysearchPromocode(String promocode);

	/**
	 * Returns all the promocodeses where promocode = &#63; and startDate &le; &#63; and endDate &ge; &#63; and products LIKE &#63;.
	 *
	 * @param promocode the promocode
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param products the products
	 * @return the matching promocodeses
	 */
	public java.util.List<Promocodes> findBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products);

	/**
	 * Returns a range of all the promocodeses where promocode = &#63; and startDate &le; &#63; and endDate &ge; &#63; and products LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PromocodesModelImpl</code>.
	 * </p>
	 *
	 * @param promocode the promocode
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param products the products
	 * @param start the lower bound of the range of promocodeses
	 * @param end the upper bound of the range of promocodeses (not inclusive)
	 * @return the range of matching promocodeses
	 */
	public java.util.List<Promocodes> findBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products,
		int start, int end);

	/**
	 * Returns an ordered range of all the promocodeses where promocode = &#63; and startDate &le; &#63; and endDate &ge; &#63; and products LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PromocodesModelImpl</code>.
	 * </p>
	 *
	 * @param promocode the promocode
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param products the products
	 * @param start the lower bound of the range of promocodeses
	 * @param end the upper bound of the range of promocodeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching promocodeses
	 */
	public java.util.List<Promocodes> findBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator);

	/**
	 * Returns an ordered range of all the promocodeses where promocode = &#63; and startDate &le; &#63; and endDate &ge; &#63; and products LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PromocodesModelImpl</code>.
	 * </p>
	 *
	 * @param promocode the promocode
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param products the products
	 * @param start the lower bound of the range of promocodeses
	 * @param end the upper bound of the range of promocodeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching promocodeses
	 */
	public java.util.List<Promocodes> findBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first promocodes in the ordered set where promocode = &#63; and startDate &le; &#63; and endDate &ge; &#63; and products LIKE &#63;.
	 *
	 * @param promocode the promocode
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param products the products
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	public Promocodes findBysearchB2CPromo_First(
			String promocode, Date startDate, Date endDate, String products,
			com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
				orderByComparator)
		throws NoSuchPromocodesException;

	/**
	 * Returns the first promocodes in the ordered set where promocode = &#63; and startDate &le; &#63; and endDate &ge; &#63; and products LIKE &#63;.
	 *
	 * @param promocode the promocode
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param products the products
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public Promocodes fetchBysearchB2CPromo_First(
		String promocode, Date startDate, Date endDate, String products,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator);

	/**
	 * Returns the last promocodes in the ordered set where promocode = &#63; and startDate &le; &#63; and endDate &ge; &#63; and products LIKE &#63;.
	 *
	 * @param promocode the promocode
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param products the products
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	public Promocodes findBysearchB2CPromo_Last(
			String promocode, Date startDate, Date endDate, String products,
			com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
				orderByComparator)
		throws NoSuchPromocodesException;

	/**
	 * Returns the last promocodes in the ordered set where promocode = &#63; and startDate &le; &#63; and endDate &ge; &#63; and products LIKE &#63;.
	 *
	 * @param promocode the promocode
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param products the products
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public Promocodes fetchBysearchB2CPromo_Last(
		String promocode, Date startDate, Date endDate, String products,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator);

	/**
	 * Returns the promocodeses before and after the current promocodes in the ordered set where promocode = &#63; and startDate &le; &#63; and endDate &ge; &#63; and products LIKE &#63;.
	 *
	 * @param promocodeId the primary key of the current promocodes
	 * @param promocode the promocode
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param products the products
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next promocodes
	 * @throws NoSuchPromocodesException if a promocodes with the primary key could not be found
	 */
	public Promocodes[] findBysearchB2CPromo_PrevAndNext(
			long promocodeId, String promocode, Date startDate, Date endDate,
			String products,
			com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
				orderByComparator)
		throws NoSuchPromocodesException;

	/**
	 * Removes all the promocodeses where promocode = &#63; and startDate &le; &#63; and endDate &ge; &#63; and products LIKE &#63; from the database.
	 *
	 * @param promocode the promocode
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param products the products
	 */
	public void removeBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products);

	/**
	 * Returns the number of promocodeses where promocode = &#63; and startDate &le; &#63; and endDate &ge; &#63; and products LIKE &#63;.
	 *
	 * @param promocode the promocode
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param products the products
	 * @return the number of matching promocodeses
	 */
	public int countBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products);

	/**
	 * Caches the promocodes in the entity cache if it is enabled.
	 *
	 * @param promocodes the promocodes
	 */
	public void cacheResult(Promocodes promocodes);

	/**
	 * Caches the promocodeses in the entity cache if it is enabled.
	 *
	 * @param promocodeses the promocodeses
	 */
	public void cacheResult(java.util.List<Promocodes> promocodeses);

	/**
	 * Creates a new promocodes with the primary key. Does not add the promocodes to the database.
	 *
	 * @param promocodeId the primary key for the new promocodes
	 * @return the new promocodes
	 */
	public Promocodes create(long promocodeId);

	/**
	 * Removes the promocodes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param promocodeId the primary key of the promocodes
	 * @return the promocodes that was removed
	 * @throws NoSuchPromocodesException if a promocodes with the primary key could not be found
	 */
	public Promocodes remove(long promocodeId) throws NoSuchPromocodesException;

	public Promocodes updateImpl(Promocodes promocodes);

	/**
	 * Returns the promocodes with the primary key or throws a <code>NoSuchPromocodesException</code> if it could not be found.
	 *
	 * @param promocodeId the primary key of the promocodes
	 * @return the promocodes
	 * @throws NoSuchPromocodesException if a promocodes with the primary key could not be found
	 */
	public Promocodes findByPrimaryKey(long promocodeId)
		throws NoSuchPromocodesException;

	/**
	 * Returns the promocodes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param promocodeId the primary key of the promocodes
	 * @return the promocodes, or <code>null</code> if a promocodes with the primary key could not be found
	 */
	public Promocodes fetchByPrimaryKey(long promocodeId);

	/**
	 * Returns all the promocodeses.
	 *
	 * @return the promocodeses
	 */
	public java.util.List<Promocodes> findAll();

	/**
	 * Returns a range of all the promocodeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PromocodesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of promocodeses
	 * @param end the upper bound of the range of promocodeses (not inclusive)
	 * @return the range of promocodeses
	 */
	public java.util.List<Promocodes> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the promocodeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PromocodesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of promocodeses
	 * @param end the upper bound of the range of promocodeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of promocodeses
	 */
	public java.util.List<Promocodes> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator);

	/**
	 * Returns an ordered range of all the promocodeses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PromocodesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of promocodeses
	 * @param end the upper bound of the range of promocodeses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of promocodeses
	 */
	public java.util.List<Promocodes> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Promocodes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the promocodeses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of promocodeses.
	 *
	 * @return the number of promocodeses
	 */
	public int countAll();

}