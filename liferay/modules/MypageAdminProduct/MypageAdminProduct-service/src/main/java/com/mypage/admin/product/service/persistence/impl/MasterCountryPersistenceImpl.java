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

import com.mypage.admin.product.exception.NoSuchMasterCountryException;
import com.mypage.admin.product.model.MasterCountry;
import com.mypage.admin.product.model.impl.MasterCountryImpl;
import com.mypage.admin.product.model.impl.MasterCountryModelImpl;
import com.mypage.admin.product.service.persistence.MasterCountryPersistence;
import com.mypage.admin.product.service.persistence.MasterCountryUtil;
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
 * The persistence implementation for the master country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = MasterCountryPersistence.class)
public class MasterCountryPersistenceImpl
	extends BasePersistenceImpl<MasterCountry>
	implements MasterCountryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MasterCountryUtil</code> to access the master country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MasterCountryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBycountryName;
	private FinderPath _finderPathWithoutPaginationFindBycountryName;
	private FinderPath _finderPathCountBycountryName;

	/**
	 * Returns all the master countries where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching master countries
	 */
	@Override
	public List<MasterCountry> findBycountryName(String name) {
		return findBycountryName(
			name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master countries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @return the range of matching master countries
	 */
	@Override
	public List<MasterCountry> findBycountryName(
		String name, int start, int end) {

		return findBycountryName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master countries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master countries
	 */
	@Override
	public List<MasterCountry> findBycountryName(
		String name, int start, int end,
		OrderByComparator<MasterCountry> orderByComparator) {

		return findBycountryName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master countries where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master countries
	 */
	@Override
	public List<MasterCountry> findBycountryName(
		String name, int start, int end,
		OrderByComparator<MasterCountry> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBycountryName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycountryName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<MasterCountry> list = null;

		if (useFinderCache) {
			list = (List<MasterCountry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MasterCountry masterCountry : list) {
					if (!name.equals(masterCountry.getName())) {
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

			sb.append(_SQL_SELECT_MASTERCOUNTRY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_COUNTRYNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_COUNTRYNAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MasterCountryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<MasterCountry>)QueryUtil.list(
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
	 * Returns the first master country in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master country
	 * @throws NoSuchMasterCountryException if a matching master country could not be found
	 */
	@Override
	public MasterCountry findBycountryName_First(
			String name, OrderByComparator<MasterCountry> orderByComparator)
		throws NoSuchMasterCountryException {

		MasterCountry masterCountry = fetchBycountryName_First(
			name, orderByComparator);

		if (masterCountry != null) {
			return masterCountry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchMasterCountryException(sb.toString());
	}

	/**
	 * Returns the first master country in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master country, or <code>null</code> if a matching master country could not be found
	 */
	@Override
	public MasterCountry fetchBycountryName_First(
		String name, OrderByComparator<MasterCountry> orderByComparator) {

		List<MasterCountry> list = findBycountryName(
			name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master country in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master country
	 * @throws NoSuchMasterCountryException if a matching master country could not be found
	 */
	@Override
	public MasterCountry findBycountryName_Last(
			String name, OrderByComparator<MasterCountry> orderByComparator)
		throws NoSuchMasterCountryException {

		MasterCountry masterCountry = fetchBycountryName_Last(
			name, orderByComparator);

		if (masterCountry != null) {
			return masterCountry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchMasterCountryException(sb.toString());
	}

	/**
	 * Returns the last master country in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master country, or <code>null</code> if a matching master country could not be found
	 */
	@Override
	public MasterCountry fetchBycountryName_Last(
		String name, OrderByComparator<MasterCountry> orderByComparator) {

		int count = countBycountryName(name);

		if (count == 0) {
			return null;
		}

		List<MasterCountry> list = findBycountryName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master countries before and after the current master country in the ordered set where name = &#63;.
	 *
	 * @param countryId the primary key of the current master country
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master country
	 * @throws NoSuchMasterCountryException if a master country with the primary key could not be found
	 */
	@Override
	public MasterCountry[] findBycountryName_PrevAndNext(
			long countryId, String name,
			OrderByComparator<MasterCountry> orderByComparator)
		throws NoSuchMasterCountryException {

		name = Objects.toString(name, "");

		MasterCountry masterCountry = findByPrimaryKey(countryId);

		Session session = null;

		try {
			session = openSession();

			MasterCountry[] array = new MasterCountryImpl[3];

			array[0] = getBycountryName_PrevAndNext(
				session, masterCountry, name, orderByComparator, true);

			array[1] = masterCountry;

			array[2] = getBycountryName_PrevAndNext(
				session, masterCountry, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterCountry getBycountryName_PrevAndNext(
		Session session, MasterCountry masterCountry, String name,
		OrderByComparator<MasterCountry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MASTERCOUNTRY_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_COUNTRYNAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_COUNTRYNAME_NAME_2);
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
			sb.append(MasterCountryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						masterCountry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MasterCountry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master countries where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeBycountryName(String name) {
		for (MasterCountry masterCountry :
				findBycountryName(
					name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(masterCountry);
		}
	}

	/**
	 * Returns the number of master countries where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching master countries
	 */
	@Override
	public int countBycountryName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountBycountryName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MASTERCOUNTRY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_COUNTRYNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_COUNTRYNAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
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

	private static final String _FINDER_COLUMN_COUNTRYNAME_NAME_2 =
		"masterCountry.name = ?";

	private static final String _FINDER_COLUMN_COUNTRYNAME_NAME_3 =
		"(masterCountry.name IS NULL OR masterCountry.name = '')";

	private FinderPath _finderPathWithPaginationFindByactiveCountries;
	private FinderPath _finderPathWithoutPaginationFindByactiveCountries;
	private FinderPath _finderPathCountByactiveCountries;

	/**
	 * Returns all the master countries where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @return the matching master countries
	 */
	@Override
	public List<MasterCountry> findByactiveCountries(
		Integer isSanctionCountry, Integer active) {

		return findByactiveCountries(
			isSanctionCountry, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the master countries where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @return the range of matching master countries
	 */
	@Override
	public List<MasterCountry> findByactiveCountries(
		Integer isSanctionCountry, Integer active, int start, int end) {

		return findByactiveCountries(
			isSanctionCountry, active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master countries where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master countries
	 */
	@Override
	public List<MasterCountry> findByactiveCountries(
		Integer isSanctionCountry, Integer active, int start, int end,
		OrderByComparator<MasterCountry> orderByComparator) {

		return findByactiveCountries(
			isSanctionCountry, active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master countries where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master countries
	 */
	@Override
	public List<MasterCountry> findByactiveCountries(
		Integer isSanctionCountry, Integer active, int start, int end,
		OrderByComparator<MasterCountry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByactiveCountries;
				finderArgs = new Object[] {isSanctionCountry, active};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByactiveCountries;
			finderArgs = new Object[] {
				isSanctionCountry, active, start, end, orderByComparator
			};
		}

		List<MasterCountry> list = null;

		if (useFinderCache) {
			list = (List<MasterCountry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MasterCountry masterCountry : list) {
					if (!Objects.equals(
							isSanctionCountry,
							masterCountry.getIsSanctionCountry()) ||
						!Objects.equals(active, masterCountry.getActive())) {

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

			sb.append(_SQL_SELECT_MASTERCOUNTRY_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVECOUNTRIES_ISSANCTIONCOUNTRY_2);

			sb.append(_FINDER_COLUMN_ACTIVECOUNTRIES_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MasterCountryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isSanctionCountry.intValue());

				queryPos.add(active.intValue());

				list = (List<MasterCountry>)QueryUtil.list(
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
	 * Returns the first master country in the ordered set where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master country
	 * @throws NoSuchMasterCountryException if a matching master country could not be found
	 */
	@Override
	public MasterCountry findByactiveCountries_First(
			Integer isSanctionCountry, Integer active,
			OrderByComparator<MasterCountry> orderByComparator)
		throws NoSuchMasterCountryException {

		MasterCountry masterCountry = fetchByactiveCountries_First(
			isSanctionCountry, active, orderByComparator);

		if (masterCountry != null) {
			return masterCountry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isSanctionCountry=");
		sb.append(isSanctionCountry);

		sb.append(", active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchMasterCountryException(sb.toString());
	}

	/**
	 * Returns the first master country in the ordered set where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master country, or <code>null</code> if a matching master country could not be found
	 */
	@Override
	public MasterCountry fetchByactiveCountries_First(
		Integer isSanctionCountry, Integer active,
		OrderByComparator<MasterCountry> orderByComparator) {

		List<MasterCountry> list = findByactiveCountries(
			isSanctionCountry, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master country in the ordered set where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master country
	 * @throws NoSuchMasterCountryException if a matching master country could not be found
	 */
	@Override
	public MasterCountry findByactiveCountries_Last(
			Integer isSanctionCountry, Integer active,
			OrderByComparator<MasterCountry> orderByComparator)
		throws NoSuchMasterCountryException {

		MasterCountry masterCountry = fetchByactiveCountries_Last(
			isSanctionCountry, active, orderByComparator);

		if (masterCountry != null) {
			return masterCountry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isSanctionCountry=");
		sb.append(isSanctionCountry);

		sb.append(", active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchMasterCountryException(sb.toString());
	}

	/**
	 * Returns the last master country in the ordered set where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master country, or <code>null</code> if a matching master country could not be found
	 */
	@Override
	public MasterCountry fetchByactiveCountries_Last(
		Integer isSanctionCountry, Integer active,
		OrderByComparator<MasterCountry> orderByComparator) {

		int count = countByactiveCountries(isSanctionCountry, active);

		if (count == 0) {
			return null;
		}

		List<MasterCountry> list = findByactiveCountries(
			isSanctionCountry, active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master countries before and after the current master country in the ordered set where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param countryId the primary key of the current master country
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master country
	 * @throws NoSuchMasterCountryException if a master country with the primary key could not be found
	 */
	@Override
	public MasterCountry[] findByactiveCountries_PrevAndNext(
			long countryId, Integer isSanctionCountry, Integer active,
			OrderByComparator<MasterCountry> orderByComparator)
		throws NoSuchMasterCountryException {

		MasterCountry masterCountry = findByPrimaryKey(countryId);

		Session session = null;

		try {
			session = openSession();

			MasterCountry[] array = new MasterCountryImpl[3];

			array[0] = getByactiveCountries_PrevAndNext(
				session, masterCountry, isSanctionCountry, active,
				orderByComparator, true);

			array[1] = masterCountry;

			array[2] = getByactiveCountries_PrevAndNext(
				session, masterCountry, isSanctionCountry, active,
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

	protected MasterCountry getByactiveCountries_PrevAndNext(
		Session session, MasterCountry masterCountry, Integer isSanctionCountry,
		Integer active, OrderByComparator<MasterCountry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_MASTERCOUNTRY_WHERE);

		sb.append(_FINDER_COLUMN_ACTIVECOUNTRIES_ISSANCTIONCOUNTRY_2);

		sb.append(_FINDER_COLUMN_ACTIVECOUNTRIES_ACTIVE_2);

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
			sb.append(MasterCountryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isSanctionCountry.intValue());

		queryPos.add(active.intValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						masterCountry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MasterCountry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master countries where isSanctionCountry = &#63; and active = &#63; from the database.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 */
	@Override
	public void removeByactiveCountries(
		Integer isSanctionCountry, Integer active) {

		for (MasterCountry masterCountry :
				findByactiveCountries(
					isSanctionCountry, active, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(masterCountry);
		}
	}

	/**
	 * Returns the number of master countries where isSanctionCountry = &#63; and active = &#63;.
	 *
	 * @param isSanctionCountry the is sanction country
	 * @param active the active
	 * @return the number of matching master countries
	 */
	@Override
	public int countByactiveCountries(
		Integer isSanctionCountry, Integer active) {

		FinderPath finderPath = _finderPathCountByactiveCountries;

		Object[] finderArgs = new Object[] {isSanctionCountry, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MASTERCOUNTRY_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVECOUNTRIES_ISSANCTIONCOUNTRY_2);

			sb.append(_FINDER_COLUMN_ACTIVECOUNTRIES_ACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isSanctionCountry.intValue());

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

	private static final String
		_FINDER_COLUMN_ACTIVECOUNTRIES_ISSANCTIONCOUNTRY_2 =
			"masterCountry.isSanctionCountry = ? AND ";

	private static final String _FINDER_COLUMN_ACTIVECOUNTRIES_ACTIVE_2 =
		"masterCountry.active = ? AND masterCountry.active=1 AND masterCountry.isSanctionCountry!=1";

	public MasterCountryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MasterCountry.class);

		setModelImplClass(MasterCountryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the master country in the entity cache if it is enabled.
	 *
	 * @param masterCountry the master country
	 */
	@Override
	public void cacheResult(MasterCountry masterCountry) {
		entityCache.putResult(
			MasterCountryImpl.class, masterCountry.getPrimaryKey(),
			masterCountry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the master countries in the entity cache if it is enabled.
	 *
	 * @param masterCountries the master countries
	 */
	@Override
	public void cacheResult(List<MasterCountry> masterCountries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (masterCountries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MasterCountry masterCountry : masterCountries) {
			if (entityCache.getResult(
					MasterCountryImpl.class, masterCountry.getPrimaryKey()) ==
						null) {

				cacheResult(masterCountry);
			}
		}
	}

	/**
	 * Clears the cache for all master countries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MasterCountryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the master country.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MasterCountry masterCountry) {
		entityCache.removeResult(MasterCountryImpl.class, masterCountry);
	}

	@Override
	public void clearCache(List<MasterCountry> masterCountries) {
		for (MasterCountry masterCountry : masterCountries) {
			entityCache.removeResult(MasterCountryImpl.class, masterCountry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MasterCountryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new master country with the primary key. Does not add the master country to the database.
	 *
	 * @param countryId the primary key for the new master country
	 * @return the new master country
	 */
	@Override
	public MasterCountry create(long countryId) {
		MasterCountry masterCountry = new MasterCountryImpl();

		masterCountry.setNew(true);
		masterCountry.setPrimaryKey(countryId);

		masterCountry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return masterCountry;
	}

	/**
	 * Removes the master country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param countryId the primary key of the master country
	 * @return the master country that was removed
	 * @throws NoSuchMasterCountryException if a master country with the primary key could not be found
	 */
	@Override
	public MasterCountry remove(long countryId)
		throws NoSuchMasterCountryException {

		return remove((Serializable)countryId);
	}

	/**
	 * Removes the master country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the master country
	 * @return the master country that was removed
	 * @throws NoSuchMasterCountryException if a master country with the primary key could not be found
	 */
	@Override
	public MasterCountry remove(Serializable primaryKey)
		throws NoSuchMasterCountryException {

		Session session = null;

		try {
			session = openSession();

			MasterCountry masterCountry = (MasterCountry)session.get(
				MasterCountryImpl.class, primaryKey);

			if (masterCountry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasterCountryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(masterCountry);
		}
		catch (NoSuchMasterCountryException noSuchEntityException) {
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
	protected MasterCountry removeImpl(MasterCountry masterCountry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(masterCountry)) {
				masterCountry = (MasterCountry)session.get(
					MasterCountryImpl.class, masterCountry.getPrimaryKeyObj());
			}

			if (masterCountry != null) {
				session.delete(masterCountry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (masterCountry != null) {
			clearCache(masterCountry);
		}

		return masterCountry;
	}

	@Override
	public MasterCountry updateImpl(MasterCountry masterCountry) {
		boolean isNew = masterCountry.isNew();

		if (!(masterCountry instanceof MasterCountryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(masterCountry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					masterCountry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in masterCountry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MasterCountry implementation " +
					masterCountry.getClass());
		}

		MasterCountryModelImpl masterCountryModelImpl =
			(MasterCountryModelImpl)masterCountry;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (masterCountry.getCreateDate() == null)) {
			if (serviceContext == null) {
				masterCountry.setCreateDate(date);
			}
			else {
				masterCountry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!masterCountryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				masterCountry.setModifiedDate(date);
			}
			else {
				masterCountry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(masterCountry);
			}
			else {
				masterCountry = (MasterCountry)session.merge(masterCountry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MasterCountryImpl.class, masterCountryModelImpl, false, true);

		if (isNew) {
			masterCountry.setNew(false);
		}

		masterCountry.resetOriginalValues();

		return masterCountry;
	}

	/**
	 * Returns the master country with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the master country
	 * @return the master country
	 * @throws NoSuchMasterCountryException if a master country with the primary key could not be found
	 */
	@Override
	public MasterCountry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMasterCountryException {

		MasterCountry masterCountry = fetchByPrimaryKey(primaryKey);

		if (masterCountry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasterCountryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return masterCountry;
	}

	/**
	 * Returns the master country with the primary key or throws a <code>NoSuchMasterCountryException</code> if it could not be found.
	 *
	 * @param countryId the primary key of the master country
	 * @return the master country
	 * @throws NoSuchMasterCountryException if a master country with the primary key could not be found
	 */
	@Override
	public MasterCountry findByPrimaryKey(long countryId)
		throws NoSuchMasterCountryException {

		return findByPrimaryKey((Serializable)countryId);
	}

	/**
	 * Returns the master country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param countryId the primary key of the master country
	 * @return the master country, or <code>null</code> if a master country with the primary key could not be found
	 */
	@Override
	public MasterCountry fetchByPrimaryKey(long countryId) {
		return fetchByPrimaryKey((Serializable)countryId);
	}

	/**
	 * Returns all the master countries.
	 *
	 * @return the master countries
	 */
	@Override
	public List<MasterCountry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @return the range of master countries
	 */
	@Override
	public List<MasterCountry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the master countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master countries
	 */
	@Override
	public List<MasterCountry> findAll(
		int start, int end,
		OrderByComparator<MasterCountry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCountryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master countries
	 * @param end the upper bound of the range of master countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master countries
	 */
	@Override
	public List<MasterCountry> findAll(
		int start, int end, OrderByComparator<MasterCountry> orderByComparator,
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

		List<MasterCountry> list = null;

		if (useFinderCache) {
			list = (List<MasterCountry>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MASTERCOUNTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MASTERCOUNTRY;

				sql = sql.concat(MasterCountryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MasterCountry>)QueryUtil.list(
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
	 * Removes all the master countries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MasterCountry masterCountry : findAll()) {
			remove(masterCountry);
		}
	}

	/**
	 * Returns the number of master countries.
	 *
	 * @return the number of master countries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MASTERCOUNTRY);

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
		return "countryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MASTERCOUNTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MasterCountryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the master country persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new MasterCountryModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MasterCountry.class.getName()));

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

		_finderPathWithPaginationFindBycountryName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycountryName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"name"}, true);

		_finderPathWithoutPaginationFindBycountryName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycountryName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountBycountryName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycountryName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_finderPathWithPaginationFindByactiveCountries = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByactiveCountries",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"isSanctionCountry", "active_"}, true);

		_finderPathWithoutPaginationFindByactiveCountries = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByactiveCountries",
			new String[] {Integer.class.getName(), Integer.class.getName()},
			new String[] {"isSanctionCountry", "active_"}, true);

		_finderPathCountByactiveCountries = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByactiveCountries",
			new String[] {Integer.class.getName(), Integer.class.getName()},
			new String[] {"isSanctionCountry", "active_"}, false);

		_setMasterCountryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMasterCountryUtilPersistence(null);

		entityCache.removeCache(MasterCountryImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setMasterCountryUtilPersistence(
		MasterCountryPersistence masterCountryPersistence) {

		try {
			Field field = MasterCountryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, masterCountryPersistence);
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

	private static final String _SQL_SELECT_MASTERCOUNTRY =
		"SELECT masterCountry FROM MasterCountry masterCountry";

	private static final String _SQL_SELECT_MASTERCOUNTRY_WHERE =
		"SELECT masterCountry FROM MasterCountry masterCountry WHERE ";

	private static final String _SQL_COUNT_MASTERCOUNTRY =
		"SELECT COUNT(masterCountry) FROM MasterCountry masterCountry";

	private static final String _SQL_COUNT_MASTERCOUNTRY_WHERE =
		"SELECT COUNT(masterCountry) FROM MasterCountry masterCountry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "masterCountry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MasterCountry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MasterCountry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MasterCountryPersistenceImpl.class);

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

	private static class MasterCountryModelArgumentsResolver
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

			MasterCountryModelImpl masterCountryModelImpl =
				(MasterCountryModelImpl)baseModel;

			long columnBitmask = masterCountryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(masterCountryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						masterCountryModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(MasterCountryPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(masterCountryModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			MasterCountryModelImpl masterCountryModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						masterCountryModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = masterCountryModelImpl.getColumnValue(
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

			orderByColumnsBitmask |= MasterCountryModelImpl.getColumnBitmask(
				"name");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}