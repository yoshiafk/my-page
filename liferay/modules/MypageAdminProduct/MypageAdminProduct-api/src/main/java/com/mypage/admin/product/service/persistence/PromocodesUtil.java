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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.Promocodes;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the promocodes service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.PromocodesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see PromocodesPersistence
 * @generated
 */
public class PromocodesUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Promocodes promocodes) {
		getPersistence().clearCache(promocodes);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Promocodes> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Promocodes> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Promocodes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Promocodes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Promocodes> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Promocodes update(Promocodes promocodes) {
		return getPersistence().update(promocodes);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Promocodes update(
		Promocodes promocodes, ServiceContext serviceContext) {

		return getPersistence().update(promocodes, serviceContext);
	}

	/**
	 * Returns all the promocodeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching promocodeses
	 */
	public static List<Promocodes> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Promocodes> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Promocodes> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Promocodes> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Promocodes> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Promocodes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first promocodes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	public static Promocodes findByUuid_First(
			String uuid, OrderByComparator<Promocodes> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPromocodesException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first promocodes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public static Promocodes fetchByUuid_First(
		String uuid, OrderByComparator<Promocodes> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last promocodes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	public static Promocodes findByUuid_Last(
			String uuid, OrderByComparator<Promocodes> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPromocodesException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last promocodes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public static Promocodes fetchByUuid_Last(
		String uuid, OrderByComparator<Promocodes> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the promocodeses before and after the current promocodes in the ordered set where uuid = &#63;.
	 *
	 * @param promocodeId the primary key of the current promocodes
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next promocodes
	 * @throws NoSuchPromocodesException if a promocodes with the primary key could not be found
	 */
	public static Promocodes[] findByUuid_PrevAndNext(
			long promocodeId, String uuid,
			OrderByComparator<Promocodes> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPromocodesException {

		return getPersistence().findByUuid_PrevAndNext(
			promocodeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the promocodeses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of promocodeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching promocodeses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the promocodes where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPromocodesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	public static Promocodes findByUUID_G(String uuid, long groupId)
		throws com.mypage.admin.product.exception.NoSuchPromocodesException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the promocodes where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public static Promocodes fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the promocodes where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public static Promocodes fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the promocodes where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the promocodes that was removed
	 */
	public static Promocodes removeByUUID_G(String uuid, long groupId)
		throws com.mypage.admin.product.exception.NoSuchPromocodesException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of promocodeses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching promocodeses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the promocodeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching promocodeses
	 */
	public static List<Promocodes> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<Promocodes> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<Promocodes> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Promocodes> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<Promocodes> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Promocodes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first promocodes in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	public static Promocodes findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Promocodes> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPromocodesException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first promocodes in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public static Promocodes fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Promocodes> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last promocodes in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	public static Promocodes findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Promocodes> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPromocodesException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last promocodes in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public static Promocodes fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Promocodes> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static Promocodes[] findByUuid_C_PrevAndNext(
			long promocodeId, String uuid, long companyId,
			OrderByComparator<Promocodes> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPromocodesException {

		return getPersistence().findByUuid_C_PrevAndNext(
			promocodeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the promocodeses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of promocodeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching promocodeses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the promocodeses where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @return the matching promocodeses
	 */
	public static List<Promocodes> findBysearchPromocode(String promocode) {
		return getPersistence().findBysearchPromocode(promocode);
	}

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
	public static List<Promocodes> findBysearchPromocode(
		String promocode, int start, int end) {

		return getPersistence().findBysearchPromocode(promocode, start, end);
	}

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
	public static List<Promocodes> findBysearchPromocode(
		String promocode, int start, int end,
		OrderByComparator<Promocodes> orderByComparator) {

		return getPersistence().findBysearchPromocode(
			promocode, start, end, orderByComparator);
	}

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
	public static List<Promocodes> findBysearchPromocode(
		String promocode, int start, int end,
		OrderByComparator<Promocodes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchPromocode(
			promocode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first promocodes in the ordered set where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	public static Promocodes findBysearchPromocode_First(
			String promocode, OrderByComparator<Promocodes> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPromocodesException {

		return getPersistence().findBysearchPromocode_First(
			promocode, orderByComparator);
	}

	/**
	 * Returns the first promocodes in the ordered set where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public static Promocodes fetchBysearchPromocode_First(
		String promocode, OrderByComparator<Promocodes> orderByComparator) {

		return getPersistence().fetchBysearchPromocode_First(
			promocode, orderByComparator);
	}

	/**
	 * Returns the last promocodes in the ordered set where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	public static Promocodes findBysearchPromocode_Last(
			String promocode, OrderByComparator<Promocodes> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPromocodesException {

		return getPersistence().findBysearchPromocode_Last(
			promocode, orderByComparator);
	}

	/**
	 * Returns the last promocodes in the ordered set where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	public static Promocodes fetchBysearchPromocode_Last(
		String promocode, OrderByComparator<Promocodes> orderByComparator) {

		return getPersistence().fetchBysearchPromocode_Last(
			promocode, orderByComparator);
	}

	/**
	 * Returns the promocodeses before and after the current promocodes in the ordered set where promocode = &#63;.
	 *
	 * @param promocodeId the primary key of the current promocodes
	 * @param promocode the promocode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next promocodes
	 * @throws NoSuchPromocodesException if a promocodes with the primary key could not be found
	 */
	public static Promocodes[] findBysearchPromocode_PrevAndNext(
			long promocodeId, String promocode,
			OrderByComparator<Promocodes> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPromocodesException {

		return getPersistence().findBysearchPromocode_PrevAndNext(
			promocodeId, promocode, orderByComparator);
	}

	/**
	 * Removes all the promocodeses where promocode = &#63; from the database.
	 *
	 * @param promocode the promocode
	 */
	public static void removeBysearchPromocode(String promocode) {
		getPersistence().removeBysearchPromocode(promocode);
	}

	/**
	 * Returns the number of promocodeses where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @return the number of matching promocodeses
	 */
	public static int countBysearchPromocode(String promocode) {
		return getPersistence().countBysearchPromocode(promocode);
	}

	/**
	 * Returns all the promocodeses where promocode = &#63; and startDate &le; &#63; and endDate &ge; &#63; and products LIKE &#63;.
	 *
	 * @param promocode the promocode
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param products the products
	 * @return the matching promocodeses
	 */
	public static List<Promocodes> findBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products) {

		return getPersistence().findBysearchB2CPromo(
			promocode, startDate, endDate, products);
	}

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
	public static List<Promocodes> findBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products,
		int start, int end) {

		return getPersistence().findBysearchB2CPromo(
			promocode, startDate, endDate, products, start, end);
	}

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
	public static List<Promocodes> findBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products,
		int start, int end, OrderByComparator<Promocodes> orderByComparator) {

		return getPersistence().findBysearchB2CPromo(
			promocode, startDate, endDate, products, start, end,
			orderByComparator);
	}

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
	public static List<Promocodes> findBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products,
		int start, int end, OrderByComparator<Promocodes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysearchB2CPromo(
			promocode, startDate, endDate, products, start, end,
			orderByComparator, useFinderCache);
	}

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
	public static Promocodes findBysearchB2CPromo_First(
			String promocode, Date startDate, Date endDate, String products,
			OrderByComparator<Promocodes> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPromocodesException {

		return getPersistence().findBysearchB2CPromo_First(
			promocode, startDate, endDate, products, orderByComparator);
	}

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
	public static Promocodes fetchBysearchB2CPromo_First(
		String promocode, Date startDate, Date endDate, String products,
		OrderByComparator<Promocodes> orderByComparator) {

		return getPersistence().fetchBysearchB2CPromo_First(
			promocode, startDate, endDate, products, orderByComparator);
	}

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
	public static Promocodes findBysearchB2CPromo_Last(
			String promocode, Date startDate, Date endDate, String products,
			OrderByComparator<Promocodes> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPromocodesException {

		return getPersistence().findBysearchB2CPromo_Last(
			promocode, startDate, endDate, products, orderByComparator);
	}

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
	public static Promocodes fetchBysearchB2CPromo_Last(
		String promocode, Date startDate, Date endDate, String products,
		OrderByComparator<Promocodes> orderByComparator) {

		return getPersistence().fetchBysearchB2CPromo_Last(
			promocode, startDate, endDate, products, orderByComparator);
	}

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
	public static Promocodes[] findBysearchB2CPromo_PrevAndNext(
			long promocodeId, String promocode, Date startDate, Date endDate,
			String products, OrderByComparator<Promocodes> orderByComparator)
		throws com.mypage.admin.product.exception.NoSuchPromocodesException {

		return getPersistence().findBysearchB2CPromo_PrevAndNext(
			promocodeId, promocode, startDate, endDate, products,
			orderByComparator);
	}

	/**
	 * Removes all the promocodeses where promocode = &#63; and startDate &le; &#63; and endDate &ge; &#63; and products LIKE &#63; from the database.
	 *
	 * @param promocode the promocode
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param products the products
	 */
	public static void removeBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products) {

		getPersistence().removeBysearchB2CPromo(
			promocode, startDate, endDate, products);
	}

	/**
	 * Returns the number of promocodeses where promocode = &#63; and startDate &le; &#63; and endDate &ge; &#63; and products LIKE &#63;.
	 *
	 * @param promocode the promocode
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param products the products
	 * @return the number of matching promocodeses
	 */
	public static int countBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products) {

		return getPersistence().countBysearchB2CPromo(
			promocode, startDate, endDate, products);
	}

	/**
	 * Caches the promocodes in the entity cache if it is enabled.
	 *
	 * @param promocodes the promocodes
	 */
	public static void cacheResult(Promocodes promocodes) {
		getPersistence().cacheResult(promocodes);
	}

	/**
	 * Caches the promocodeses in the entity cache if it is enabled.
	 *
	 * @param promocodeses the promocodeses
	 */
	public static void cacheResult(List<Promocodes> promocodeses) {
		getPersistence().cacheResult(promocodeses);
	}

	/**
	 * Creates a new promocodes with the primary key. Does not add the promocodes to the database.
	 *
	 * @param promocodeId the primary key for the new promocodes
	 * @return the new promocodes
	 */
	public static Promocodes create(long promocodeId) {
		return getPersistence().create(promocodeId);
	}

	/**
	 * Removes the promocodes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param promocodeId the primary key of the promocodes
	 * @return the promocodes that was removed
	 * @throws NoSuchPromocodesException if a promocodes with the primary key could not be found
	 */
	public static Promocodes remove(long promocodeId)
		throws com.mypage.admin.product.exception.NoSuchPromocodesException {

		return getPersistence().remove(promocodeId);
	}

	public static Promocodes updateImpl(Promocodes promocodes) {
		return getPersistence().updateImpl(promocodes);
	}

	/**
	 * Returns the promocodes with the primary key or throws a <code>NoSuchPromocodesException</code> if it could not be found.
	 *
	 * @param promocodeId the primary key of the promocodes
	 * @return the promocodes
	 * @throws NoSuchPromocodesException if a promocodes with the primary key could not be found
	 */
	public static Promocodes findByPrimaryKey(long promocodeId)
		throws com.mypage.admin.product.exception.NoSuchPromocodesException {

		return getPersistence().findByPrimaryKey(promocodeId);
	}

	/**
	 * Returns the promocodes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param promocodeId the primary key of the promocodes
	 * @return the promocodes, or <code>null</code> if a promocodes with the primary key could not be found
	 */
	public static Promocodes fetchByPrimaryKey(long promocodeId) {
		return getPersistence().fetchByPrimaryKey(promocodeId);
	}

	/**
	 * Returns all the promocodeses.
	 *
	 * @return the promocodeses
	 */
	public static List<Promocodes> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Promocodes> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Promocodes> findAll(
		int start, int end, OrderByComparator<Promocodes> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Promocodes> findAll(
		int start, int end, OrderByComparator<Promocodes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the promocodeses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of promocodeses.
	 *
	 * @return the number of promocodeses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PromocodesPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PromocodesPersistence _persistence;

}