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

import com.mypage.admin.product.exception.NoSuchMasterCurrencyException;
import com.mypage.admin.product.model.MasterCurrency;
import com.mypage.admin.product.model.impl.MasterCurrencyImpl;
import com.mypage.admin.product.model.impl.MasterCurrencyModelImpl;
import com.mypage.admin.product.service.persistence.MasterCurrencyPersistence;
import com.mypage.admin.product.service.persistence.MasterCurrencyUtil;
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
 * The persistence implementation for the master currency service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = MasterCurrencyPersistence.class)
public class MasterCurrencyPersistenceImpl
	extends BasePersistenceImpl<MasterCurrency>
	implements MasterCurrencyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MasterCurrencyUtil</code> to access the master currency persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MasterCurrencyImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBycurrencyName;
	private FinderPath _finderPathWithoutPaginationFindBycurrencyName;
	private FinderPath _finderPathCountBycurrencyName;

	/**
	 * Returns all the master currencies where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching master currencies
	 */
	@Override
	public List<MasterCurrency> findBycurrencyName(String name) {
		return findBycurrencyName(
			name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master currencies where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @return the range of matching master currencies
	 */
	@Override
	public List<MasterCurrency> findBycurrencyName(
		String name, int start, int end) {

		return findBycurrencyName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master currencies where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master currencies
	 */
	@Override
	public List<MasterCurrency> findBycurrencyName(
		String name, int start, int end,
		OrderByComparator<MasterCurrency> orderByComparator) {

		return findBycurrencyName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master currencies where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master currencies
	 */
	@Override
	public List<MasterCurrency> findBycurrencyName(
		String name, int start, int end,
		OrderByComparator<MasterCurrency> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBycurrencyName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycurrencyName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<MasterCurrency> list = null;

		if (useFinderCache) {
			list = (List<MasterCurrency>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MasterCurrency masterCurrency : list) {
					if (!name.equals(masterCurrency.getName())) {
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

			sb.append(_SQL_SELECT_MASTERCURRENCY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_CURRENCYNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_CURRENCYNAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MasterCurrencyModelImpl.ORDER_BY_JPQL);
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

				list = (List<MasterCurrency>)QueryUtil.list(
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
	 * Returns the first master currency in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master currency
	 * @throws NoSuchMasterCurrencyException if a matching master currency could not be found
	 */
	@Override
	public MasterCurrency findBycurrencyName_First(
			String name, OrderByComparator<MasterCurrency> orderByComparator)
		throws NoSuchMasterCurrencyException {

		MasterCurrency masterCurrency = fetchBycurrencyName_First(
			name, orderByComparator);

		if (masterCurrency != null) {
			return masterCurrency;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchMasterCurrencyException(sb.toString());
	}

	/**
	 * Returns the first master currency in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master currency, or <code>null</code> if a matching master currency could not be found
	 */
	@Override
	public MasterCurrency fetchBycurrencyName_First(
		String name, OrderByComparator<MasterCurrency> orderByComparator) {

		List<MasterCurrency> list = findBycurrencyName(
			name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master currency in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master currency
	 * @throws NoSuchMasterCurrencyException if a matching master currency could not be found
	 */
	@Override
	public MasterCurrency findBycurrencyName_Last(
			String name, OrderByComparator<MasterCurrency> orderByComparator)
		throws NoSuchMasterCurrencyException {

		MasterCurrency masterCurrency = fetchBycurrencyName_Last(
			name, orderByComparator);

		if (masterCurrency != null) {
			return masterCurrency;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchMasterCurrencyException(sb.toString());
	}

	/**
	 * Returns the last master currency in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master currency, or <code>null</code> if a matching master currency could not be found
	 */
	@Override
	public MasterCurrency fetchBycurrencyName_Last(
		String name, OrderByComparator<MasterCurrency> orderByComparator) {

		int count = countBycurrencyName(name);

		if (count == 0) {
			return null;
		}

		List<MasterCurrency> list = findBycurrencyName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master currencies before and after the current master currency in the ordered set where name = &#63;.
	 *
	 * @param currencyId the primary key of the current master currency
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master currency
	 * @throws NoSuchMasterCurrencyException if a master currency with the primary key could not be found
	 */
	@Override
	public MasterCurrency[] findBycurrencyName_PrevAndNext(
			long currencyId, String name,
			OrderByComparator<MasterCurrency> orderByComparator)
		throws NoSuchMasterCurrencyException {

		name = Objects.toString(name, "");

		MasterCurrency masterCurrency = findByPrimaryKey(currencyId);

		Session session = null;

		try {
			session = openSession();

			MasterCurrency[] array = new MasterCurrencyImpl[3];

			array[0] = getBycurrencyName_PrevAndNext(
				session, masterCurrency, name, orderByComparator, true);

			array[1] = masterCurrency;

			array[2] = getBycurrencyName_PrevAndNext(
				session, masterCurrency, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterCurrency getBycurrencyName_PrevAndNext(
		Session session, MasterCurrency masterCurrency, String name,
		OrderByComparator<MasterCurrency> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MASTERCURRENCY_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_CURRENCYNAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_CURRENCYNAME_NAME_2);
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
			sb.append(MasterCurrencyModelImpl.ORDER_BY_JPQL);
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
						masterCurrency)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MasterCurrency> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master currencies where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeBycurrencyName(String name) {
		for (MasterCurrency masterCurrency :
				findBycurrencyName(
					name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(masterCurrency);
		}
	}

	/**
	 * Returns the number of master currencies where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching master currencies
	 */
	@Override
	public int countBycurrencyName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountBycurrencyName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MASTERCURRENCY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_CURRENCYNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_CURRENCYNAME_NAME_2);
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

	private static final String _FINDER_COLUMN_CURRENCYNAME_NAME_2 =
		"masterCurrency.name = ?";

	private static final String _FINDER_COLUMN_CURRENCYNAME_NAME_3 =
		"(masterCurrency.name IS NULL OR masterCurrency.name = '')";

	private FinderPath _finderPathFetchBysearchCurrency;
	private FinderPath _finderPathCountBysearchCurrency;

	/**
	 * Returns the master currency where name = &#63; or throws a <code>NoSuchMasterCurrencyException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching master currency
	 * @throws NoSuchMasterCurrencyException if a matching master currency could not be found
	 */
	@Override
	public MasterCurrency findBysearchCurrency(String name)
		throws NoSuchMasterCurrencyException {

		MasterCurrency masterCurrency = fetchBysearchCurrency(name);

		if (masterCurrency == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMasterCurrencyException(sb.toString());
		}

		return masterCurrency;
	}

	/**
	 * Returns the master currency where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching master currency, or <code>null</code> if a matching master currency could not be found
	 */
	@Override
	public MasterCurrency fetchBysearchCurrency(String name) {
		return fetchBysearchCurrency(name, true);
	}

	/**
	 * Returns the master currency where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching master currency, or <code>null</code> if a matching master currency could not be found
	 */
	@Override
	public MasterCurrency fetchBysearchCurrency(
		String name, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBysearchCurrency, finderArgs, this);
		}

		if (result instanceof MasterCurrency) {
			MasterCurrency masterCurrency = (MasterCurrency)result;

			if (!Objects.equals(name, masterCurrency.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MASTERCURRENCY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHCURRENCY_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_SEARCHCURRENCY_NAME_2);
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

				List<MasterCurrency> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBysearchCurrency, finderArgs, list);
					}
				}
				else {
					MasterCurrency masterCurrency = list.get(0);

					result = masterCurrency;

					cacheResult(masterCurrency);
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
			return (MasterCurrency)result;
		}
	}

	/**
	 * Removes the master currency where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the master currency that was removed
	 */
	@Override
	public MasterCurrency removeBysearchCurrency(String name)
		throws NoSuchMasterCurrencyException {

		MasterCurrency masterCurrency = findBysearchCurrency(name);

		return remove(masterCurrency);
	}

	/**
	 * Returns the number of master currencies where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching master currencies
	 */
	@Override
	public int countBysearchCurrency(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountBysearchCurrency;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MASTERCURRENCY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHCURRENCY_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_SEARCHCURRENCY_NAME_2);
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

	private static final String _FINDER_COLUMN_SEARCHCURRENCY_NAME_2 =
		"masterCurrency.name = ?";

	private static final String _FINDER_COLUMN_SEARCHCURRENCY_NAME_3 =
		"(masterCurrency.name IS NULL OR masterCurrency.name = '')";

	public MasterCurrencyPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MasterCurrency.class);

		setModelImplClass(MasterCurrencyImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the master currency in the entity cache if it is enabled.
	 *
	 * @param masterCurrency the master currency
	 */
	@Override
	public void cacheResult(MasterCurrency masterCurrency) {
		entityCache.putResult(
			MasterCurrencyImpl.class, masterCurrency.getPrimaryKey(),
			masterCurrency);

		finderCache.putResult(
			_finderPathFetchBysearchCurrency,
			new Object[] {masterCurrency.getName()}, masterCurrency);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the master currencies in the entity cache if it is enabled.
	 *
	 * @param masterCurrencies the master currencies
	 */
	@Override
	public void cacheResult(List<MasterCurrency> masterCurrencies) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (masterCurrencies.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MasterCurrency masterCurrency : masterCurrencies) {
			if (entityCache.getResult(
					MasterCurrencyImpl.class, masterCurrency.getPrimaryKey()) ==
						null) {

				cacheResult(masterCurrency);
			}
		}
	}

	/**
	 * Clears the cache for all master currencies.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MasterCurrencyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the master currency.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MasterCurrency masterCurrency) {
		entityCache.removeResult(MasterCurrencyImpl.class, masterCurrency);
	}

	@Override
	public void clearCache(List<MasterCurrency> masterCurrencies) {
		for (MasterCurrency masterCurrency : masterCurrencies) {
			entityCache.removeResult(MasterCurrencyImpl.class, masterCurrency);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MasterCurrencyImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		MasterCurrencyModelImpl masterCurrencyModelImpl) {

		Object[] args = new Object[] {masterCurrencyModelImpl.getName()};

		finderCache.putResult(
			_finderPathCountBysearchCurrency, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBysearchCurrency, args, masterCurrencyModelImpl,
			false);
	}

	/**
	 * Creates a new master currency with the primary key. Does not add the master currency to the database.
	 *
	 * @param currencyId the primary key for the new master currency
	 * @return the new master currency
	 */
	@Override
	public MasterCurrency create(long currencyId) {
		MasterCurrency masterCurrency = new MasterCurrencyImpl();

		masterCurrency.setNew(true);
		masterCurrency.setPrimaryKey(currencyId);

		masterCurrency.setCompanyId(CompanyThreadLocal.getCompanyId());

		return masterCurrency;
	}

	/**
	 * Removes the master currency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param currencyId the primary key of the master currency
	 * @return the master currency that was removed
	 * @throws NoSuchMasterCurrencyException if a master currency with the primary key could not be found
	 */
	@Override
	public MasterCurrency remove(long currencyId)
		throws NoSuchMasterCurrencyException {

		return remove((Serializable)currencyId);
	}

	/**
	 * Removes the master currency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the master currency
	 * @return the master currency that was removed
	 * @throws NoSuchMasterCurrencyException if a master currency with the primary key could not be found
	 */
	@Override
	public MasterCurrency remove(Serializable primaryKey)
		throws NoSuchMasterCurrencyException {

		Session session = null;

		try {
			session = openSession();

			MasterCurrency masterCurrency = (MasterCurrency)session.get(
				MasterCurrencyImpl.class, primaryKey);

			if (masterCurrency == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasterCurrencyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(masterCurrency);
		}
		catch (NoSuchMasterCurrencyException noSuchEntityException) {
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
	protected MasterCurrency removeImpl(MasterCurrency masterCurrency) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(masterCurrency)) {
				masterCurrency = (MasterCurrency)session.get(
					MasterCurrencyImpl.class,
					masterCurrency.getPrimaryKeyObj());
			}

			if (masterCurrency != null) {
				session.delete(masterCurrency);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (masterCurrency != null) {
			clearCache(masterCurrency);
		}

		return masterCurrency;
	}

	@Override
	public MasterCurrency updateImpl(MasterCurrency masterCurrency) {
		boolean isNew = masterCurrency.isNew();

		if (!(masterCurrency instanceof MasterCurrencyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(masterCurrency.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					masterCurrency);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in masterCurrency proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MasterCurrency implementation " +
					masterCurrency.getClass());
		}

		MasterCurrencyModelImpl masterCurrencyModelImpl =
			(MasterCurrencyModelImpl)masterCurrency;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (masterCurrency.getCreateDate() == null)) {
			if (serviceContext == null) {
				masterCurrency.setCreateDate(date);
			}
			else {
				masterCurrency.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!masterCurrencyModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				masterCurrency.setModifiedDate(date);
			}
			else {
				masterCurrency.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(masterCurrency);
			}
			else {
				masterCurrency = (MasterCurrency)session.merge(masterCurrency);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MasterCurrencyImpl.class, masterCurrencyModelImpl, false, true);

		cacheUniqueFindersCache(masterCurrencyModelImpl);

		if (isNew) {
			masterCurrency.setNew(false);
		}

		masterCurrency.resetOriginalValues();

		return masterCurrency;
	}

	/**
	 * Returns the master currency with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the master currency
	 * @return the master currency
	 * @throws NoSuchMasterCurrencyException if a master currency with the primary key could not be found
	 */
	@Override
	public MasterCurrency findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMasterCurrencyException {

		MasterCurrency masterCurrency = fetchByPrimaryKey(primaryKey);

		if (masterCurrency == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasterCurrencyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return masterCurrency;
	}

	/**
	 * Returns the master currency with the primary key or throws a <code>NoSuchMasterCurrencyException</code> if it could not be found.
	 *
	 * @param currencyId the primary key of the master currency
	 * @return the master currency
	 * @throws NoSuchMasterCurrencyException if a master currency with the primary key could not be found
	 */
	@Override
	public MasterCurrency findByPrimaryKey(long currencyId)
		throws NoSuchMasterCurrencyException {

		return findByPrimaryKey((Serializable)currencyId);
	}

	/**
	 * Returns the master currency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param currencyId the primary key of the master currency
	 * @return the master currency, or <code>null</code> if a master currency with the primary key could not be found
	 */
	@Override
	public MasterCurrency fetchByPrimaryKey(long currencyId) {
		return fetchByPrimaryKey((Serializable)currencyId);
	}

	/**
	 * Returns all the master currencies.
	 *
	 * @return the master currencies
	 */
	@Override
	public List<MasterCurrency> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @return the range of master currencies
	 */
	@Override
	public List<MasterCurrency> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the master currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master currencies
	 */
	@Override
	public List<MasterCurrency> findAll(
		int start, int end,
		OrderByComparator<MasterCurrency> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterCurrencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master currencies
	 * @param end the upper bound of the range of master currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master currencies
	 */
	@Override
	public List<MasterCurrency> findAll(
		int start, int end, OrderByComparator<MasterCurrency> orderByComparator,
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

		List<MasterCurrency> list = null;

		if (useFinderCache) {
			list = (List<MasterCurrency>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MASTERCURRENCY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MASTERCURRENCY;

				sql = sql.concat(MasterCurrencyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MasterCurrency>)QueryUtil.list(
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
	 * Removes all the master currencies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MasterCurrency masterCurrency : findAll()) {
			remove(masterCurrency);
		}
	}

	/**
	 * Returns the number of master currencies.
	 *
	 * @return the number of master currencies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MASTERCURRENCY);

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
		return "currencyId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MASTERCURRENCY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MasterCurrencyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the master currency persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new MasterCurrencyModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MasterCurrency.class.getName()));

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

		_finderPathWithPaginationFindBycurrencyName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycurrencyName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"name"}, true);

		_finderPathWithoutPaginationFindBycurrencyName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycurrencyName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountBycurrencyName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycurrencyName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_finderPathFetchBysearchCurrency = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBysearchCurrency",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountBysearchCurrency = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchCurrency",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_setMasterCurrencyUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMasterCurrencyUtilPersistence(null);

		entityCache.removeCache(MasterCurrencyImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setMasterCurrencyUtilPersistence(
		MasterCurrencyPersistence masterCurrencyPersistence) {

		try {
			Field field = MasterCurrencyUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, masterCurrencyPersistence);
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

	private static final String _SQL_SELECT_MASTERCURRENCY =
		"SELECT masterCurrency FROM MasterCurrency masterCurrency";

	private static final String _SQL_SELECT_MASTERCURRENCY_WHERE =
		"SELECT masterCurrency FROM MasterCurrency masterCurrency WHERE ";

	private static final String _SQL_COUNT_MASTERCURRENCY =
		"SELECT COUNT(masterCurrency) FROM MasterCurrency masterCurrency";

	private static final String _SQL_COUNT_MASTERCURRENCY_WHERE =
		"SELECT COUNT(masterCurrency) FROM MasterCurrency masterCurrency WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "masterCurrency.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MasterCurrency exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MasterCurrency exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MasterCurrencyPersistenceImpl.class);

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

	private static class MasterCurrencyModelArgumentsResolver
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

			MasterCurrencyModelImpl masterCurrencyModelImpl =
				(MasterCurrencyModelImpl)baseModel;

			long columnBitmask = masterCurrencyModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					masterCurrencyModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						masterCurrencyModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(MasterCurrencyPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					masterCurrencyModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			MasterCurrencyModelImpl masterCurrencyModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						masterCurrencyModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = masterCurrencyModelImpl.getColumnValue(
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