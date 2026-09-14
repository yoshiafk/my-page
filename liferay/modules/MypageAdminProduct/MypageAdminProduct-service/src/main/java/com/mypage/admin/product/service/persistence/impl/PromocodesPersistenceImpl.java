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

package com.mypage.admin.product.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.mypage.admin.product.exception.NoSuchPromocodesException;
import com.mypage.admin.product.model.Promocodes;
import com.mypage.admin.product.model.impl.PromocodesImpl;
import com.mypage.admin.product.model.impl.PromocodesModelImpl;
import com.mypage.admin.product.service.persistence.PromocodesPersistence;
import com.mypage.admin.product.service.persistence.PromocodesUtil;
import com.mypage.admin.product.service.persistence.impl.constants.MPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the promocodes service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = PromocodesPersistence.class)
public class PromocodesPersistenceImpl
	extends BasePersistenceImpl<Promocodes> implements PromocodesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PromocodesUtil</code> to access the promocodes persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PromocodesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the promocodeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching promocodeses
	 */
	@Override
	public List<Promocodes> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Promocodes> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Promocodes> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Promocodes> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Promocodes> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Promocodes> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Promocodes> list = null;

		if (useFinderCache) {
			list = (List<Promocodes>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Promocodes promocodes : list) {
					if (!uuid.equals(promocodes.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PROMOCODES_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PromocodesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Promocodes>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first promocodes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	@Override
	public Promocodes findByUuid_First(
			String uuid, OrderByComparator<Promocodes> orderByComparator)
		throws NoSuchPromocodesException {

		Promocodes promocodes = fetchByUuid_First(uuid, orderByComparator);

		if (promocodes != null) {
			return promocodes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPromocodesException(sb.toString());
	}

	/**
	 * Returns the first promocodes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	@Override
	public Promocodes fetchByUuid_First(
		String uuid, OrderByComparator<Promocodes> orderByComparator) {

		List<Promocodes> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last promocodes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	@Override
	public Promocodes findByUuid_Last(
			String uuid, OrderByComparator<Promocodes> orderByComparator)
		throws NoSuchPromocodesException {

		Promocodes promocodes = fetchByUuid_Last(uuid, orderByComparator);

		if (promocodes != null) {
			return promocodes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPromocodesException(sb.toString());
	}

	/**
	 * Returns the last promocodes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	@Override
	public Promocodes fetchByUuid_Last(
		String uuid, OrderByComparator<Promocodes> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Promocodes> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Promocodes[] findByUuid_PrevAndNext(
			long promocodeId, String uuid,
			OrderByComparator<Promocodes> orderByComparator)
		throws NoSuchPromocodesException {

		uuid = Objects.toString(uuid, "");

		Promocodes promocodes = findByPrimaryKey(promocodeId);

		Session session = null;

		try {
			session = openSession();

			Promocodes[] array = new PromocodesImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, promocodes, uuid, orderByComparator, true);

			array[1] = promocodes;

			array[2] = getByUuid_PrevAndNext(
				session, promocodes, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Promocodes getByUuid_PrevAndNext(
		Session session, Promocodes promocodes, String uuid,
		OrderByComparator<Promocodes> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROMOCODES_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PromocodesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(promocodes)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Promocodes> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the promocodeses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Promocodes promocodes :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(promocodes);
		}
	}

	/**
	 * Returns the number of promocodeses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching promocodeses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROMOCODES_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"promocodes.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(promocodes.uuid IS NULL OR promocodes.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the promocodes where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPromocodesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	@Override
	public Promocodes findByUUID_G(String uuid, long groupId)
		throws NoSuchPromocodesException {

		Promocodes promocodes = fetchByUUID_G(uuid, groupId);

		if (promocodes == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPromocodesException(sb.toString());
		}

		return promocodes;
	}

	/**
	 * Returns the promocodes where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	@Override
	public Promocodes fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the promocodes where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	@Override
	public Promocodes fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Promocodes) {
			Promocodes promocodes = (Promocodes)result;

			if (!Objects.equals(uuid, promocodes.getUuid()) ||
				(groupId != promocodes.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROMOCODES_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Promocodes> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Promocodes promocodes = list.get(0);

					result = promocodes;

					cacheResult(promocodes);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Promocodes)result;
		}
	}

	/**
	 * Removes the promocodes where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the promocodes that was removed
	 */
	@Override
	public Promocodes removeByUUID_G(String uuid, long groupId)
		throws NoSuchPromocodesException {

		Promocodes promocodes = findByUUID_G(uuid, groupId);

		return remove(promocodes);
	}

	/**
	 * Returns the number of promocodeses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching promocodeses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROMOCODES_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"promocodes.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(promocodes.uuid IS NULL OR promocodes.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"promocodes.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the promocodeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching promocodeses
	 */
	@Override
	public List<Promocodes> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Promocodes> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Promocodes> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Promocodes> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Promocodes> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Promocodes> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Promocodes> list = null;

		if (useFinderCache) {
			list = (List<Promocodes>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Promocodes promocodes : list) {
					if (!uuid.equals(promocodes.getUuid()) ||
						(companyId != promocodes.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_PROMOCODES_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PromocodesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Promocodes>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Promocodes findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Promocodes> orderByComparator)
		throws NoSuchPromocodesException {

		Promocodes promocodes = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (promocodes != null) {
			return promocodes;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPromocodesException(sb.toString());
	}

	/**
	 * Returns the first promocodes in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	@Override
	public Promocodes fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Promocodes> orderByComparator) {

		List<Promocodes> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Promocodes findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Promocodes> orderByComparator)
		throws NoSuchPromocodesException {

		Promocodes promocodes = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (promocodes != null) {
			return promocodes;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPromocodesException(sb.toString());
	}

	/**
	 * Returns the last promocodes in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	@Override
	public Promocodes fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Promocodes> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Promocodes> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Promocodes[] findByUuid_C_PrevAndNext(
			long promocodeId, String uuid, long companyId,
			OrderByComparator<Promocodes> orderByComparator)
		throws NoSuchPromocodesException {

		uuid = Objects.toString(uuid, "");

		Promocodes promocodes = findByPrimaryKey(promocodeId);

		Session session = null;

		try {
			session = openSession();

			Promocodes[] array = new PromocodesImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, promocodes, uuid, companyId, orderByComparator, true);

			array[1] = promocodes;

			array[2] = getByUuid_C_PrevAndNext(
				session, promocodes, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Promocodes getByUuid_C_PrevAndNext(
		Session session, Promocodes promocodes, String uuid, long companyId,
		OrderByComparator<Promocodes> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PROMOCODES_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PromocodesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(promocodes)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Promocodes> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the promocodeses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Promocodes promocodes :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(promocodes);
		}
	}

	/**
	 * Returns the number of promocodeses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching promocodeses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROMOCODES_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"promocodes.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(promocodes.uuid IS NULL OR promocodes.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"promocodes.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBysearchPromocode;
	private FinderPath _finderPathWithoutPaginationFindBysearchPromocode;
	private FinderPath _finderPathCountBysearchPromocode;

	/**
	 * Returns all the promocodeses where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @return the matching promocodeses
	 */
	@Override
	public List<Promocodes> findBysearchPromocode(String promocode) {
		return findBysearchPromocode(
			promocode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Promocodes> findBysearchPromocode(
		String promocode, int start, int end) {

		return findBysearchPromocode(promocode, start, end, null);
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
	@Override
	public List<Promocodes> findBysearchPromocode(
		String promocode, int start, int end,
		OrderByComparator<Promocodes> orderByComparator) {

		return findBysearchPromocode(
			promocode, start, end, orderByComparator, true);
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
	@Override
	public List<Promocodes> findBysearchPromocode(
		String promocode, int start, int end,
		OrderByComparator<Promocodes> orderByComparator,
		boolean useFinderCache) {

		promocode = Objects.toString(promocode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBysearchPromocode;
				finderArgs = new Object[] {promocode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchPromocode;
			finderArgs = new Object[] {
				promocode, start, end, orderByComparator
			};
		}

		List<Promocodes> list = null;

		if (useFinderCache) {
			list = (List<Promocodes>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Promocodes promocodes : list) {
					if (!promocode.equals(promocodes.getPromocode())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PROMOCODES_WHERE);

			boolean bindPromocode = false;

			if (promocode.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHPROMOCODE_PROMOCODE_3);
			}
			else {
				bindPromocode = true;

				sb.append(_FINDER_COLUMN_SEARCHPROMOCODE_PROMOCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PromocodesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPromocode) {
					queryPos.add(promocode);
				}

				list = (List<Promocodes>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first promocodes in the ordered set where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	@Override
	public Promocodes findBysearchPromocode_First(
			String promocode, OrderByComparator<Promocodes> orderByComparator)
		throws NoSuchPromocodesException {

		Promocodes promocodes = fetchBysearchPromocode_First(
			promocode, orderByComparator);

		if (promocodes != null) {
			return promocodes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("promocode=");
		sb.append(promocode);

		sb.append("}");

		throw new NoSuchPromocodesException(sb.toString());
	}

	/**
	 * Returns the first promocodes in the ordered set where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	@Override
	public Promocodes fetchBysearchPromocode_First(
		String promocode, OrderByComparator<Promocodes> orderByComparator) {

		List<Promocodes> list = findBysearchPromocode(
			promocode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last promocodes in the ordered set where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes
	 * @throws NoSuchPromocodesException if a matching promocodes could not be found
	 */
	@Override
	public Promocodes findBysearchPromocode_Last(
			String promocode, OrderByComparator<Promocodes> orderByComparator)
		throws NoSuchPromocodesException {

		Promocodes promocodes = fetchBysearchPromocode_Last(
			promocode, orderByComparator);

		if (promocodes != null) {
			return promocodes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("promocode=");
		sb.append(promocode);

		sb.append("}");

		throw new NoSuchPromocodesException(sb.toString());
	}

	/**
	 * Returns the last promocodes in the ordered set where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promocodes, or <code>null</code> if a matching promocodes could not be found
	 */
	@Override
	public Promocodes fetchBysearchPromocode_Last(
		String promocode, OrderByComparator<Promocodes> orderByComparator) {

		int count = countBysearchPromocode(promocode);

		if (count == 0) {
			return null;
		}

		List<Promocodes> list = findBysearchPromocode(
			promocode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Promocodes[] findBysearchPromocode_PrevAndNext(
			long promocodeId, String promocode,
			OrderByComparator<Promocodes> orderByComparator)
		throws NoSuchPromocodesException {

		promocode = Objects.toString(promocode, "");

		Promocodes promocodes = findByPrimaryKey(promocodeId);

		Session session = null;

		try {
			session = openSession();

			Promocodes[] array = new PromocodesImpl[3];

			array[0] = getBysearchPromocode_PrevAndNext(
				session, promocodes, promocode, orderByComparator, true);

			array[1] = promocodes;

			array[2] = getBysearchPromocode_PrevAndNext(
				session, promocodes, promocode, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Promocodes getBysearchPromocode_PrevAndNext(
		Session session, Promocodes promocodes, String promocode,
		OrderByComparator<Promocodes> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROMOCODES_WHERE);

		boolean bindPromocode = false;

		if (promocode.isEmpty()) {
			sb.append(_FINDER_COLUMN_SEARCHPROMOCODE_PROMOCODE_3);
		}
		else {
			bindPromocode = true;

			sb.append(_FINDER_COLUMN_SEARCHPROMOCODE_PROMOCODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PromocodesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPromocode) {
			queryPos.add(promocode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(promocodes)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Promocodes> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the promocodeses where promocode = &#63; from the database.
	 *
	 * @param promocode the promocode
	 */
	@Override
	public void removeBysearchPromocode(String promocode) {
		for (Promocodes promocodes :
				findBysearchPromocode(
					promocode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(promocodes);
		}
	}

	/**
	 * Returns the number of promocodeses where promocode = &#63;.
	 *
	 * @param promocode the promocode
	 * @return the number of matching promocodeses
	 */
	@Override
	public int countBysearchPromocode(String promocode) {
		promocode = Objects.toString(promocode, "");

		FinderPath finderPath = _finderPathCountBysearchPromocode;

		Object[] finderArgs = new Object[] {promocode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROMOCODES_WHERE);

			boolean bindPromocode = false;

			if (promocode.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHPROMOCODE_PROMOCODE_3);
			}
			else {
				bindPromocode = true;

				sb.append(_FINDER_COLUMN_SEARCHPROMOCODE_PROMOCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPromocode) {
					queryPos.add(promocode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SEARCHPROMOCODE_PROMOCODE_2 =
		"promocodes.promocode = ?";

	private static final String _FINDER_COLUMN_SEARCHPROMOCODE_PROMOCODE_3 =
		"(promocodes.promocode IS NULL OR promocodes.promocode = '')";

	private FinderPath _finderPathWithPaginationFindBysearchB2CPromo;
	private FinderPath _finderPathWithPaginationCountBysearchB2CPromo;

	/**
	 * Returns all the promocodeses where promocode = &#63; and startDate &le; &#63; and endDate &ge; &#63; and products LIKE &#63;.
	 *
	 * @param promocode the promocode
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param products the products
	 * @return the matching promocodeses
	 */
	@Override
	public List<Promocodes> findBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products) {

		return findBysearchB2CPromo(
			promocode, startDate, endDate, products, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Promocodes> findBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products,
		int start, int end) {

		return findBysearchB2CPromo(
			promocode, startDate, endDate, products, start, end, null);
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
	@Override
	public List<Promocodes> findBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products,
		int start, int end, OrderByComparator<Promocodes> orderByComparator) {

		return findBysearchB2CPromo(
			promocode, startDate, endDate, products, start, end,
			orderByComparator, true);
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
	@Override
	public List<Promocodes> findBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products,
		int start, int end, OrderByComparator<Promocodes> orderByComparator,
		boolean useFinderCache) {

		promocode = Objects.toString(promocode, "");
		products = Objects.toString(products, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindBysearchB2CPromo;
		finderArgs = new Object[] {
			promocode, _getTime(startDate), _getTime(endDate), products, start,
			end, orderByComparator
		};

		List<Promocodes> list = null;

		if (useFinderCache) {
			list = (List<Promocodes>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Promocodes promocodes : list) {
					if (!promocode.equals(promocodes.getPromocode()) ||
						(startDate.getTime() < promocodes.getStartDate(
						).getTime()) ||
						(endDate.getTime() > promocodes.getEndDate(
						).getTime()) ||
						!StringUtil.wildcardMatches(
							promocodes.getProducts(), products, '_', '%', '\\',
							true)) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_PROMOCODES_WHERE);

			boolean bindPromocode = false;

			if (promocode.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_PROMOCODE_3);
			}
			else {
				bindPromocode = true;

				sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_PROMOCODE_2);
			}

			boolean bindStartDate = false;

			if (startDate == null) {
				sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_STARTDATE_2);
			}

			boolean bindEndDate = false;

			if (endDate == null) {
				sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_ENDDATE_2);
			}

			boolean bindProducts = false;

			if (products.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_PRODUCTS_3);
			}
			else {
				bindProducts = true;

				sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_PRODUCTS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PromocodesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPromocode) {
					queryPos.add(promocode);
				}

				if (bindStartDate) {
					queryPos.add(new Timestamp(startDate.getTime()));
				}

				if (bindEndDate) {
					queryPos.add(new Timestamp(endDate.getTime()));
				}

				if (bindProducts) {
					queryPos.add(products);
				}

				list = (List<Promocodes>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Promocodes findBysearchB2CPromo_First(
			String promocode, Date startDate, Date endDate, String products,
			OrderByComparator<Promocodes> orderByComparator)
		throws NoSuchPromocodesException {

		Promocodes promocodes = fetchBysearchB2CPromo_First(
			promocode, startDate, endDate, products, orderByComparator);

		if (promocodes != null) {
			return promocodes;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("promocode=");
		sb.append(promocode);

		sb.append(", startDate<=");
		sb.append(startDate);

		sb.append(", endDate>=");
		sb.append(endDate);

		sb.append(", productsLIKE");
		sb.append(products);

		sb.append("}");

		throw new NoSuchPromocodesException(sb.toString());
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
	@Override
	public Promocodes fetchBysearchB2CPromo_First(
		String promocode, Date startDate, Date endDate, String products,
		OrderByComparator<Promocodes> orderByComparator) {

		List<Promocodes> list = findBysearchB2CPromo(
			promocode, startDate, endDate, products, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Promocodes findBysearchB2CPromo_Last(
			String promocode, Date startDate, Date endDate, String products,
			OrderByComparator<Promocodes> orderByComparator)
		throws NoSuchPromocodesException {

		Promocodes promocodes = fetchBysearchB2CPromo_Last(
			promocode, startDate, endDate, products, orderByComparator);

		if (promocodes != null) {
			return promocodes;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("promocode=");
		sb.append(promocode);

		sb.append(", startDate<=");
		sb.append(startDate);

		sb.append(", endDate>=");
		sb.append(endDate);

		sb.append(", productsLIKE");
		sb.append(products);

		sb.append("}");

		throw new NoSuchPromocodesException(sb.toString());
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
	@Override
	public Promocodes fetchBysearchB2CPromo_Last(
		String promocode, Date startDate, Date endDate, String products,
		OrderByComparator<Promocodes> orderByComparator) {

		int count = countBysearchB2CPromo(
			promocode, startDate, endDate, products);

		if (count == 0) {
			return null;
		}

		List<Promocodes> list = findBysearchB2CPromo(
			promocode, startDate, endDate, products, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Promocodes[] findBysearchB2CPromo_PrevAndNext(
			long promocodeId, String promocode, Date startDate, Date endDate,
			String products, OrderByComparator<Promocodes> orderByComparator)
		throws NoSuchPromocodesException {

		promocode = Objects.toString(promocode, "");
		products = Objects.toString(products, "");

		Promocodes promocodes = findByPrimaryKey(promocodeId);

		Session session = null;

		try {
			session = openSession();

			Promocodes[] array = new PromocodesImpl[3];

			array[0] = getBysearchB2CPromo_PrevAndNext(
				session, promocodes, promocode, startDate, endDate, products,
				orderByComparator, true);

			array[1] = promocodes;

			array[2] = getBysearchB2CPromo_PrevAndNext(
				session, promocodes, promocode, startDate, endDate, products,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Promocodes getBysearchB2CPromo_PrevAndNext(
		Session session, Promocodes promocodes, String promocode,
		Date startDate, Date endDate, String products,
		OrderByComparator<Promocodes> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_PROMOCODES_WHERE);

		boolean bindPromocode = false;

		if (promocode.isEmpty()) {
			sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_PROMOCODE_3);
		}
		else {
			bindPromocode = true;

			sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_PROMOCODE_2);
		}

		boolean bindStartDate = false;

		if (startDate == null) {
			sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_STARTDATE_1);
		}
		else {
			bindStartDate = true;

			sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_STARTDATE_2);
		}

		boolean bindEndDate = false;

		if (endDate == null) {
			sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_ENDDATE_1);
		}
		else {
			bindEndDate = true;

			sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_ENDDATE_2);
		}

		boolean bindProducts = false;

		if (products.isEmpty()) {
			sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_PRODUCTS_3);
		}
		else {
			bindProducts = true;

			sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_PRODUCTS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PromocodesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPromocode) {
			queryPos.add(promocode);
		}

		if (bindStartDate) {
			queryPos.add(new Timestamp(startDate.getTime()));
		}

		if (bindEndDate) {
			queryPos.add(new Timestamp(endDate.getTime()));
		}

		if (bindProducts) {
			queryPos.add(products);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(promocodes)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Promocodes> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the promocodeses where promocode = &#63; and startDate &le; &#63; and endDate &ge; &#63; and products LIKE &#63; from the database.
	 *
	 * @param promocode the promocode
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param products the products
	 */
	@Override
	public void removeBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products) {

		for (Promocodes promocodes :
				findBysearchB2CPromo(
					promocode, startDate, endDate, products, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(promocodes);
		}
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
	@Override
	public int countBysearchB2CPromo(
		String promocode, Date startDate, Date endDate, String products) {

		promocode = Objects.toString(promocode, "");
		products = Objects.toString(products, "");

		FinderPath finderPath = _finderPathWithPaginationCountBysearchB2CPromo;

		Object[] finderArgs = new Object[] {
			promocode, _getTime(startDate), _getTime(endDate), products
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_PROMOCODES_WHERE);

			boolean bindPromocode = false;

			if (promocode.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_PROMOCODE_3);
			}
			else {
				bindPromocode = true;

				sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_PROMOCODE_2);
			}

			boolean bindStartDate = false;

			if (startDate == null) {
				sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_STARTDATE_2);
			}

			boolean bindEndDate = false;

			if (endDate == null) {
				sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_ENDDATE_2);
			}

			boolean bindProducts = false;

			if (products.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_PRODUCTS_3);
			}
			else {
				bindProducts = true;

				sb.append(_FINDER_COLUMN_SEARCHB2CPROMO_PRODUCTS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPromocode) {
					queryPos.add(promocode);
				}

				if (bindStartDate) {
					queryPos.add(new Timestamp(startDate.getTime()));
				}

				if (bindEndDate) {
					queryPos.add(new Timestamp(endDate.getTime()));
				}

				if (bindProducts) {
					queryPos.add(products);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SEARCHB2CPROMO_PROMOCODE_2 =
		"promocodes.promocode = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHB2CPROMO_PROMOCODE_3 =
		"(promocodes.promocode IS NULL OR promocodes.promocode = '') AND ";

	private static final String _FINDER_COLUMN_SEARCHB2CPROMO_STARTDATE_1 =
		"promocodes.startDate IS NULL AND ";

	private static final String _FINDER_COLUMN_SEARCHB2CPROMO_STARTDATE_2 =
		"promocodes.startDate <= ? AND ";

	private static final String _FINDER_COLUMN_SEARCHB2CPROMO_ENDDATE_1 =
		"promocodes.endDate IS NULL AND ";

	private static final String _FINDER_COLUMN_SEARCHB2CPROMO_ENDDATE_2 =
		"promocodes.endDate >= ? AND ";

	private static final String _FINDER_COLUMN_SEARCHB2CPROMO_PRODUCTS_2 =
		"promocodes.products LIKE ? AND promocodes.active=1";

	private static final String _FINDER_COLUMN_SEARCHB2CPROMO_PRODUCTS_3 =
		"(promocodes.products IS NULL OR promocodes.products LIKE '') AND promocodes.active=1";

	public PromocodesPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("limit", "limit_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Promocodes.class);

		setModelImplClass(PromocodesImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the promocodes in the entity cache if it is enabled.
	 *
	 * @param promocodes the promocodes
	 */
	@Override
	public void cacheResult(Promocodes promocodes) {
		entityCache.putResult(
			PromocodesImpl.class, promocodes.getPrimaryKey(), promocodes);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {promocodes.getUuid(), promocodes.getGroupId()},
			promocodes);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the promocodeses in the entity cache if it is enabled.
	 *
	 * @param promocodeses the promocodeses
	 */
	@Override
	public void cacheResult(List<Promocodes> promocodeses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (promocodeses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Promocodes promocodes : promocodeses) {
			if (entityCache.getResult(
					PromocodesImpl.class, promocodes.getPrimaryKey()) == null) {

				cacheResult(promocodes);
			}
		}
	}

	/**
	 * Clears the cache for all promocodeses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PromocodesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the promocodes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Promocodes promocodes) {
		entityCache.removeResult(PromocodesImpl.class, promocodes);
	}

	@Override
	public void clearCache(List<Promocodes> promocodeses) {
		for (Promocodes promocodes : promocodeses) {
			entityCache.removeResult(PromocodesImpl.class, promocodes);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PromocodesImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PromocodesModelImpl promocodesModelImpl) {

		Object[] args = new Object[] {
			promocodesModelImpl.getUuid(), promocodesModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, promocodesModelImpl, false);
	}

	/**
	 * Creates a new promocodes with the primary key. Does not add the promocodes to the database.
	 *
	 * @param promocodeId the primary key for the new promocodes
	 * @return the new promocodes
	 */
	@Override
	public Promocodes create(long promocodeId) {
		Promocodes promocodes = new PromocodesImpl();

		promocodes.setNew(true);
		promocodes.setPrimaryKey(promocodeId);

		String uuid = PortalUUIDUtil.generate();

		promocodes.setUuid(uuid);

		promocodes.setCompanyId(CompanyThreadLocal.getCompanyId());

		return promocodes;
	}

	/**
	 * Removes the promocodes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param promocodeId the primary key of the promocodes
	 * @return the promocodes that was removed
	 * @throws NoSuchPromocodesException if a promocodes with the primary key could not be found
	 */
	@Override
	public Promocodes remove(long promocodeId)
		throws NoSuchPromocodesException {

		return remove((Serializable)promocodeId);
	}

	/**
	 * Removes the promocodes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the promocodes
	 * @return the promocodes that was removed
	 * @throws NoSuchPromocodesException if a promocodes with the primary key could not be found
	 */
	@Override
	public Promocodes remove(Serializable primaryKey)
		throws NoSuchPromocodesException {

		Session session = null;

		try {
			session = openSession();

			Promocodes promocodes = (Promocodes)session.get(
				PromocodesImpl.class, primaryKey);

			if (promocodes == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPromocodesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(promocodes);
		}
		catch (NoSuchPromocodesException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Promocodes removeImpl(Promocodes promocodes) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(promocodes)) {
				promocodes = (Promocodes)session.get(
					PromocodesImpl.class, promocodes.getPrimaryKeyObj());
			}

			if (promocodes != null) {
				session.delete(promocodes);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (promocodes != null) {
			clearCache(promocodes);
		}

		return promocodes;
	}

	@Override
	public Promocodes updateImpl(Promocodes promocodes) {
		boolean isNew = promocodes.isNew();

		if (!(promocodes instanceof PromocodesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(promocodes.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(promocodes);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in promocodes proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Promocodes implementation " +
					promocodes.getClass());
		}

		PromocodesModelImpl promocodesModelImpl =
			(PromocodesModelImpl)promocodes;

		if (Validator.isNull(promocodes.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			promocodes.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (promocodes.getCreateDate() == null)) {
			if (serviceContext == null) {
				promocodes.setCreateDate(date);
			}
			else {
				promocodes.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!promocodesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				promocodes.setModifiedDate(date);
			}
			else {
				promocodes.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(promocodes);
			}
			else {
				promocodes = (Promocodes)session.merge(promocodes);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PromocodesImpl.class, promocodesModelImpl, false, true);

		cacheUniqueFindersCache(promocodesModelImpl);

		if (isNew) {
			promocodes.setNew(false);
		}

		promocodes.resetOriginalValues();

		return promocodes;
	}

	/**
	 * Returns the promocodes with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the promocodes
	 * @return the promocodes
	 * @throws NoSuchPromocodesException if a promocodes with the primary key could not be found
	 */
	@Override
	public Promocodes findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPromocodesException {

		Promocodes promocodes = fetchByPrimaryKey(primaryKey);

		if (promocodes == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPromocodesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return promocodes;
	}

	/**
	 * Returns the promocodes with the primary key or throws a <code>NoSuchPromocodesException</code> if it could not be found.
	 *
	 * @param promocodeId the primary key of the promocodes
	 * @return the promocodes
	 * @throws NoSuchPromocodesException if a promocodes with the primary key could not be found
	 */
	@Override
	public Promocodes findByPrimaryKey(long promocodeId)
		throws NoSuchPromocodesException {

		return findByPrimaryKey((Serializable)promocodeId);
	}

	/**
	 * Returns the promocodes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param promocodeId the primary key of the promocodes
	 * @return the promocodes, or <code>null</code> if a promocodes with the primary key could not be found
	 */
	@Override
	public Promocodes fetchByPrimaryKey(long promocodeId) {
		return fetchByPrimaryKey((Serializable)promocodeId);
	}

	/**
	 * Returns all the promocodeses.
	 *
	 * @return the promocodeses
	 */
	@Override
	public List<Promocodes> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Promocodes> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Promocodes> findAll(
		int start, int end, OrderByComparator<Promocodes> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Promocodes> findAll(
		int start, int end, OrderByComparator<Promocodes> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Promocodes> list = null;

		if (useFinderCache) {
			list = (List<Promocodes>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROMOCODES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROMOCODES;

				sql = sql.concat(PromocodesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Promocodes>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the promocodeses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Promocodes promocodes : findAll()) {
			remove(promocodes);
		}
	}

	/**
	 * Returns the number of promocodeses.
	 *
	 * @return the number of promocodeses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROMOCODES);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "promocodeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROMOCODES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PromocodesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the promocodes persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PromocodesModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Promocodes.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindBysearchPromocode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchPromocode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"promocode"}, true);

		_finderPathWithoutPaginationFindBysearchPromocode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysearchPromocode",
			new String[] {String.class.getName()}, new String[] {"promocode"},
			true);

		_finderPathCountBysearchPromocode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchPromocode",
			new String[] {String.class.getName()}, new String[] {"promocode"},
			false);

		_finderPathWithPaginationFindBysearchB2CPromo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchB2CPromo",
			new String[] {
				String.class.getName(), Date.class.getName(),
				Date.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"promocode", "startDate", "endDate", "products"},
			true);

		_finderPathWithPaginationCountBysearchB2CPromo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBysearchB2CPromo",
			new String[] {
				String.class.getName(), Date.class.getName(),
				Date.class.getName(), String.class.getName()
			},
			new String[] {"promocode", "startDate", "endDate", "products"},
			false);

		_setPromocodesUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPromocodesUtilPersistence(null);

		entityCache.removeCache(PromocodesImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPromocodesUtilPersistence(
		PromocodesPersistence promocodesPersistence) {

		try {
			Field field = PromocodesUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, promocodesPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MPPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_PROMOCODES =
		"SELECT promocodes FROM Promocodes promocodes";

	private static final String _SQL_SELECT_PROMOCODES_WHERE =
		"SELECT promocodes FROM Promocodes promocodes WHERE ";

	private static final String _SQL_COUNT_PROMOCODES =
		"SELECT COUNT(promocodes) FROM Promocodes promocodes";

	private static final String _SQL_COUNT_PROMOCODES_WHERE =
		"SELECT COUNT(promocodes) FROM Promocodes promocodes WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "promocodes.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Promocodes exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Promocodes exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PromocodesPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "limit", "active"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class PromocodesModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			PromocodesModelImpl promocodesModelImpl =
				(PromocodesModelImpl)baseModel;

			long columnBitmask = promocodesModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(promocodesModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						promocodesModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(PromocodesPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(promocodesModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PromocodesModelImpl promocodesModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = promocodesModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = promocodesModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}