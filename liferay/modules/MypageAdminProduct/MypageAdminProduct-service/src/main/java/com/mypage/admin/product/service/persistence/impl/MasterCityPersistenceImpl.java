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

import com.mypage.admin.product.exception.NoSuchMasterCityException;
import com.mypage.admin.product.model.MasterCity;
import com.mypage.admin.product.model.impl.MasterCityImpl;
import com.mypage.admin.product.model.impl.MasterCityModelImpl;
import com.mypage.admin.product.service.persistence.MasterCityPersistence;
import com.mypage.admin.product.service.persistence.MasterCityUtil;
import com.mypage.admin.product.service.persistence.impl.constants.MPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the master city service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = MasterCityPersistence.class)
public class MasterCityPersistenceImpl
	extends BasePersistenceImpl<MasterCity> implements MasterCityPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MasterCityUtil</code> to access the master city persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MasterCityImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByactiveCities;
	private FinderPath _finderPathWithoutPaginationFindByactiveCities;
	private FinderPath _finderPathCountByactiveCities;

	/**
	 * Returns all the master cities where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching master cities
	 */
	@Override
	public List<MasterCity> findByactiveCities(Integer active) {
		return findByactiveCities(
			active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master cities where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @return the range of matching master cities
	 */
	@Override
	public List<MasterCity> findByactiveCities(
		Integer active, int start, int end) {

		return findByactiveCities(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master cities where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master cities
	 */
	@Override
	public List<MasterCity> findByactiveCities(
		Integer active, int start, int end,
		OrderByComparator<MasterCity> orderByComparator) {

		return findByactiveCities(active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master cities where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master cities
	 */
	@Override
	public List<MasterCity> findByactiveCities(
		Integer active, int start, int end,
		OrderByComparator<MasterCity> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByactiveCities;
				finderArgs = new Object[] {active};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByactiveCities;
			finderArgs = new Object[] {active, start, end, orderByComparator};
		}

		List<MasterCity> list = null;

		if (useFinderCache) {
			list = (List<MasterCity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MasterCity masterCity : list) {
					if (!Objects.equals(active, masterCity.getActive())) {
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

			sb.append(_SQL_SELECT_MASTERCITY_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVECITIES_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MasterCityModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(active.intValue());

				list = (List<MasterCity>)QueryUtil.list(
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
	 * Returns the first master city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master city
	 * @throws NoSuchMasterCityException if a matching master city could not be found
	 */
	@Override
	public MasterCity findByactiveCities_First(
			Integer active, OrderByComparator<MasterCity> orderByComparator)
		throws NoSuchMasterCityException {

		MasterCity masterCity = fetchByactiveCities_First(
			active, orderByComparator);

		if (masterCity != null) {
			return masterCity;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchMasterCityException(sb.toString());
	}

	/**
	 * Returns the first master city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master city, or <code>null</code> if a matching master city could not be found
	 */
	@Override
	public MasterCity fetchByactiveCities_First(
		Integer active, OrderByComparator<MasterCity> orderByComparator) {

		List<MasterCity> list = findByactiveCities(
			active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master city
	 * @throws NoSuchMasterCityException if a matching master city could not be found
	 */
	@Override
	public MasterCity findByactiveCities_Last(
			Integer active, OrderByComparator<MasterCity> orderByComparator)
		throws NoSuchMasterCityException {

		MasterCity masterCity = fetchByactiveCities_Last(
			active, orderByComparator);

		if (masterCity != null) {
			return masterCity;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchMasterCityException(sb.toString());
	}

	/**
	 * Returns the last master city in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master city, or <code>null</code> if a matching master city could not be found
	 */
	@Override
	public MasterCity fetchByactiveCities_Last(
		Integer active, OrderByComparator<MasterCity> orderByComparator) {

		int count = countByactiveCities(active);

		if (count == 0) {
			return null;
		}

		List<MasterCity> list = findByactiveCities(
			active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master cities before and after the current master city in the ordered set where active = &#63;.
	 *
	 * @param masterCityId the primary key of the current master city
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master city
	 * @throws NoSuchMasterCityException if a master city with the primary key could not be found
	 */
	@Override
	public MasterCity[] findByactiveCities_PrevAndNext(
			long masterCityId, Integer active,
			OrderByComparator<MasterCity> orderByComparator)
		throws NoSuchMasterCityException {

		MasterCity masterCity = findByPrimaryKey(masterCityId);

		Session session = null;

		try {
			session = openSession();

			MasterCity[] array = new MasterCityImpl[3];

			array[0] = getByactiveCities_PrevAndNext(
				session, masterCity, active, orderByComparator, true);

			array[1] = masterCity;

			array[2] = getByactiveCities_PrevAndNext(
				session, masterCity, active, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterCity getByactiveCities_PrevAndNext(
		Session session, MasterCity masterCity, Integer active,
		OrderByComparator<MasterCity> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MASTERCITY_WHERE);

		sb.append(_FINDER_COLUMN_ACTIVECITIES_ACTIVE_2);

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
			sb.append(MasterCityModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(active.intValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(masterCity)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MasterCity> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master cities where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	@Override
	public void removeByactiveCities(Integer active) {
		for (MasterCity masterCity :
				findByactiveCities(
					active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(masterCity);
		}
	}

	/**
	 * Returns the number of master cities where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching master cities
	 */
	@Override
	public int countByactiveCities(Integer active) {
		FinderPath finderPath = _finderPathCountByactiveCities;

		Object[] finderArgs = new Object[] {active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MASTERCITY_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVECITIES_ACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(active.intValue());

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

	private static final String _FINDER_COLUMN_ACTIVECITIES_ACTIVE_2 =
		"masterCity.active = ?";

	private FinderPath _finderPathWithPaginationFindBysearchByProvinceId;
	private FinderPath _finderPathWithoutPaginationFindBysearchByProvinceId;
	private FinderPath _finderPathCountBysearchByProvinceId;

	/**
	 * Returns all the master cities where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @return the matching master cities
	 */
	@Override
	public List<MasterCity> findBysearchByProvinceId(long provinceId) {
		return findBysearchByProvinceId(
			provinceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master cities where provinceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param provinceId the province ID
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @return the range of matching master cities
	 */
	@Override
	public List<MasterCity> findBysearchByProvinceId(
		long provinceId, int start, int end) {

		return findBysearchByProvinceId(provinceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master cities where provinceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param provinceId the province ID
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master cities
	 */
	@Override
	public List<MasterCity> findBysearchByProvinceId(
		long provinceId, int start, int end,
		OrderByComparator<MasterCity> orderByComparator) {

		return findBysearchByProvinceId(
			provinceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master cities where provinceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param provinceId the province ID
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master cities
	 */
	@Override
	public List<MasterCity> findBysearchByProvinceId(
		long provinceId, int start, int end,
		OrderByComparator<MasterCity> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBysearchByProvinceId;
				finderArgs = new Object[] {provinceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchByProvinceId;
			finderArgs = new Object[] {
				provinceId, start, end, orderByComparator
			};
		}

		List<MasterCity> list = null;

		if (useFinderCache) {
			list = (List<MasterCity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MasterCity masterCity : list) {
					if (provinceId != masterCity.getProvinceId()) {
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

			sb.append(_SQL_SELECT_MASTERCITY_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYPROVINCEID_PROVINCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MasterCityModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(provinceId);

				list = (List<MasterCity>)QueryUtil.list(
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
	 * Returns the first master city in the ordered set where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master city
	 * @throws NoSuchMasterCityException if a matching master city could not be found
	 */
	@Override
	public MasterCity findBysearchByProvinceId_First(
			long provinceId, OrderByComparator<MasterCity> orderByComparator)
		throws NoSuchMasterCityException {

		MasterCity masterCity = fetchBysearchByProvinceId_First(
			provinceId, orderByComparator);

		if (masterCity != null) {
			return masterCity;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("provinceId=");
		sb.append(provinceId);

		sb.append("}");

		throw new NoSuchMasterCityException(sb.toString());
	}

	/**
	 * Returns the first master city in the ordered set where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master city, or <code>null</code> if a matching master city could not be found
	 */
	@Override
	public MasterCity fetchBysearchByProvinceId_First(
		long provinceId, OrderByComparator<MasterCity> orderByComparator) {

		List<MasterCity> list = findBysearchByProvinceId(
			provinceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master city in the ordered set where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master city
	 * @throws NoSuchMasterCityException if a matching master city could not be found
	 */
	@Override
	public MasterCity findBysearchByProvinceId_Last(
			long provinceId, OrderByComparator<MasterCity> orderByComparator)
		throws NoSuchMasterCityException {

		MasterCity masterCity = fetchBysearchByProvinceId_Last(
			provinceId, orderByComparator);

		if (masterCity != null) {
			return masterCity;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("provinceId=");
		sb.append(provinceId);

		sb.append("}");

		throw new NoSuchMasterCityException(sb.toString());
	}

	/**
	 * Returns the last master city in the ordered set where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master city, or <code>null</code> if a matching master city could not be found
	 */
	@Override
	public MasterCity fetchBysearchByProvinceId_Last(
		long provinceId, OrderByComparator<MasterCity> orderByComparator) {

		int count = countBysearchByProvinceId(provinceId);

		if (count == 0) {
			return null;
		}

		List<MasterCity> list = findBysearchByProvinceId(
			provinceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master cities before and after the current master city in the ordered set where provinceId = &#63;.
	 *
	 * @param masterCityId the primary key of the current master city
	 * @param provinceId the province ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master city
	 * @throws NoSuchMasterCityException if a master city with the primary key could not be found
	 */
	@Override
	public MasterCity[] findBysearchByProvinceId_PrevAndNext(
			long masterCityId, long provinceId,
			OrderByComparator<MasterCity> orderByComparator)
		throws NoSuchMasterCityException {

		MasterCity masterCity = findByPrimaryKey(masterCityId);

		Session session = null;

		try {
			session = openSession();

			MasterCity[] array = new MasterCityImpl[3];

			array[0] = getBysearchByProvinceId_PrevAndNext(
				session, masterCity, provinceId, orderByComparator, true);

			array[1] = masterCity;

			array[2] = getBysearchByProvinceId_PrevAndNext(
				session, masterCity, provinceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterCity getBysearchByProvinceId_PrevAndNext(
		Session session, MasterCity masterCity, long provinceId,
		OrderByComparator<MasterCity> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MASTERCITY_WHERE);

		sb.append(_FINDER_COLUMN_SEARCHBYPROVINCEID_PROVINCEID_2);

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
			sb.append(MasterCityModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(provinceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(masterCity)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MasterCity> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master cities where provinceId = &#63; from the database.
	 *
	 * @param provinceId the province ID
	 */
	@Override
	public void removeBysearchByProvinceId(long provinceId) {
		for (MasterCity masterCity :
				findBysearchByProvinceId(
					provinceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(masterCity);
		}
	}

	/**
	 * Returns the number of master cities where provinceId = &#63;.
	 *
	 * @param provinceId the province ID
	 * @return the number of matching master cities
	 */
	@Override
	public int countBysearchByProvinceId(long provinceId) {
		FinderPath finderPath = _finderPathCountBysearchByProvinceId;

		Object[] finderArgs = new Object[] {provinceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MASTERCITY_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYPROVINCEID_PROVINCEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(provinceId);

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

	private static final String _FINDER_COLUMN_SEARCHBYPROVINCEID_PROVINCEID_2 =
		"masterCity.provinceId = ?";

	public MasterCityPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MasterCity.class);

		setModelImplClass(MasterCityImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the master city in the entity cache if it is enabled.
	 *
	 * @param masterCity the master city
	 */
	@Override
	public void cacheResult(MasterCity masterCity) {
		entityCache.putResult(
			MasterCityImpl.class, masterCity.getPrimaryKey(), masterCity);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the master cities in the entity cache if it is enabled.
	 *
	 * @param masterCities the master cities
	 */
	@Override
	public void cacheResult(List<MasterCity> masterCities) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (masterCities.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MasterCity masterCity : masterCities) {
			if (entityCache.getResult(
					MasterCityImpl.class, masterCity.getPrimaryKey()) == null) {

				cacheResult(masterCity);
			}
		}
	}

	/**
	 * Clears the cache for all master cities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MasterCityImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the master city.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MasterCity masterCity) {
		entityCache.removeResult(MasterCityImpl.class, masterCity);
	}

	@Override
	public void clearCache(List<MasterCity> masterCities) {
		for (MasterCity masterCity : masterCities) {
			entityCache.removeResult(MasterCityImpl.class, masterCity);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MasterCityImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new master city with the primary key. Does not add the master city to the database.
	 *
	 * @param masterCityId the primary key for the new master city
	 * @return the new master city
	 */
	@Override
	public MasterCity create(long masterCityId) {
		MasterCity masterCity = new MasterCityImpl();

		masterCity.setNew(true);
		masterCity.setPrimaryKey(masterCityId);

		masterCity.setCompanyId(CompanyThreadLocal.getCompanyId());

		return masterCity;
	}

	/**
	 * Removes the master city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterCityId the primary key of the master city
	 * @return the master city that was removed
	 * @throws NoSuchMasterCityException if a master city with the primary key could not be found
	 */
	@Override
	public MasterCity remove(long masterCityId)
		throws NoSuchMasterCityException {

		return remove((Serializable)masterCityId);
	}

	/**
	 * Removes the master city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the master city
	 * @return the master city that was removed
	 * @throws NoSuchMasterCityException if a master city with the primary key could not be found
	 */
	@Override
	public MasterCity remove(Serializable primaryKey)
		throws NoSuchMasterCityException {

		Session session = null;

		try {
			session = openSession();

			MasterCity masterCity = (MasterCity)session.get(
				MasterCityImpl.class, primaryKey);

			if (masterCity == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasterCityException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(masterCity);
		}
		catch (NoSuchMasterCityException noSuchEntityException) {
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
	protected MasterCity removeImpl(MasterCity masterCity) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(masterCity)) {
				masterCity = (MasterCity)session.get(
					MasterCityImpl.class, masterCity.getPrimaryKeyObj());
			}

			if (masterCity != null) {
				session.delete(masterCity);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (masterCity != null) {
			clearCache(masterCity);
		}

		return masterCity;
	}

	@Override
	public MasterCity updateImpl(MasterCity masterCity) {
		boolean isNew = masterCity.isNew();

		if (!(masterCity instanceof MasterCityModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(masterCity.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(masterCity);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in masterCity proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MasterCity implementation " +
					masterCity.getClass());
		}

		MasterCityModelImpl masterCityModelImpl =
			(MasterCityModelImpl)masterCity;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (masterCity.getCreateDate() == null)) {
			if (serviceContext == null) {
				masterCity.setCreateDate(date);
			}
			else {
				masterCity.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!masterCityModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				masterCity.setModifiedDate(date);
			}
			else {
				masterCity.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(masterCity);
			}
			else {
				masterCity = (MasterCity)session.merge(masterCity);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MasterCityImpl.class, masterCityModelImpl, false, true);

		if (isNew) {
			masterCity.setNew(false);
		}

		masterCity.resetOriginalValues();

		return masterCity;
	}

	/**
	 * Returns the master city with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the master city
	 * @return the master city
	 * @throws NoSuchMasterCityException if a master city with the primary key could not be found
	 */
	@Override
	public MasterCity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMasterCityException {

		MasterCity masterCity = fetchByPrimaryKey(primaryKey);

		if (masterCity == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasterCityException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return masterCity;
	}

	/**
	 * Returns the master city with the primary key or throws a <code>NoSuchMasterCityException</code> if it could not be found.
	 *
	 * @param masterCityId the primary key of the master city
	 * @return the master city
	 * @throws NoSuchMasterCityException if a master city with the primary key could not be found
	 */
	@Override
	public MasterCity findByPrimaryKey(long masterCityId)
		throws NoSuchMasterCityException {

		return findByPrimaryKey((Serializable)masterCityId);
	}

	/**
	 * Returns the master city with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterCityId the primary key of the master city
	 * @return the master city, or <code>null</code> if a master city with the primary key could not be found
	 */
	@Override
	public MasterCity fetchByPrimaryKey(long masterCityId) {
		return fetchByPrimaryKey((Serializable)masterCityId);
	}

	/**
	 * Returns all the master cities.
	 *
	 * @return the master cities
	 */
	@Override
	public List<MasterCity> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @return the range of master cities
	 */
	@Override
	public List<MasterCity> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the master cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master cities
	 */
	@Override
	public List<MasterCity> findAll(
		int start, int end, OrderByComparator<MasterCity> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master cities
	 * @param end the upper bound of the range of master cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master cities
	 */
	@Override
	public List<MasterCity> findAll(
		int start, int end, OrderByComparator<MasterCity> orderByComparator,
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

		List<MasterCity> list = null;

		if (useFinderCache) {
			list = (List<MasterCity>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MASTERCITY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MASTERCITY;

				sql = sql.concat(MasterCityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MasterCity>)QueryUtil.list(
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
	 * Removes all the master cities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MasterCity masterCity : findAll()) {
			remove(masterCity);
		}
	}

	/**
	 * Returns the number of master cities.
	 *
	 * @return the number of master cities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MASTERCITY);

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
		return "masterCityId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MASTERCITY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MasterCityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the master city persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new MasterCityModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MasterCity.class.getName()));

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

		_finderPathWithPaginationFindByactiveCities = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByactiveCities",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"active_"}, true);

		_finderPathWithoutPaginationFindByactiveCities = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByactiveCities",
			new String[] {Integer.class.getName()}, new String[] {"active_"},
			true);

		_finderPathCountByactiveCities = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByactiveCities",
			new String[] {Integer.class.getName()}, new String[] {"active_"},
			false);

		_finderPathWithPaginationFindBysearchByProvinceId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchByProvinceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"provinceId"}, true);

		_finderPathWithoutPaginationFindBysearchByProvinceId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBysearchByProvinceId", new String[] {Long.class.getName()},
				new String[] {"provinceId"}, true);

		_finderPathCountBysearchByProvinceId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysearchByProvinceId", new String[] {Long.class.getName()},
			new String[] {"provinceId"}, false);

		_setMasterCityUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMasterCityUtilPersistence(null);

		entityCache.removeCache(MasterCityImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setMasterCityUtilPersistence(
		MasterCityPersistence masterCityPersistence) {

		try {
			Field field = MasterCityUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, masterCityPersistence);
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

	private static final String _SQL_SELECT_MASTERCITY =
		"SELECT masterCity FROM MasterCity masterCity";

	private static final String _SQL_SELECT_MASTERCITY_WHERE =
		"SELECT masterCity FROM MasterCity masterCity WHERE ";

	private static final String _SQL_COUNT_MASTERCITY =
		"SELECT COUNT(masterCity) FROM MasterCity masterCity";

	private static final String _SQL_COUNT_MASTERCITY_WHERE =
		"SELECT COUNT(masterCity) FROM MasterCity masterCity WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "masterCity.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MasterCity exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MasterCity exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MasterCityPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"active"});

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

	private static class MasterCityModelArgumentsResolver
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

			MasterCityModelImpl masterCityModelImpl =
				(MasterCityModelImpl)baseModel;

			long columnBitmask = masterCityModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(masterCityModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						masterCityModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(MasterCityPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(masterCityModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			MasterCityModelImpl masterCityModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = masterCityModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = masterCityModelImpl.getColumnValue(
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

			orderByColumnsBitmask |= MasterCityModelImpl.getColumnBitmask(
				"name");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}