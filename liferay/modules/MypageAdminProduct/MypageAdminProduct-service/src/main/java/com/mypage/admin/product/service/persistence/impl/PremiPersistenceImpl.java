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

import com.mypage.admin.product.exception.NoSuchPremiException;
import com.mypage.admin.product.model.Premi;
import com.mypage.admin.product.model.impl.PremiImpl;
import com.mypage.admin.product.model.impl.PremiModelImpl;
import com.mypage.admin.product.service.persistence.PremiPersistence;
import com.mypage.admin.product.service.persistence.PremiUtil;
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
 * The persistence implementation for the premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = PremiPersistence.class)
public class PremiPersistenceImpl
	extends BasePersistenceImpl<Premi> implements PremiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PremiUtil</code> to access the premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PremiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCurrencyAndTravellerType;
	private FinderPath
		_finderPathWithoutPaginationFindByCurrencyAndTravellerType;
	private FinderPath _finderPathCountByCurrencyAndTravellerType;

	/**
	 * Returns all the premis where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @return the matching premis
	 */
	@Override
	public List<Premi> findByCurrencyAndTravellerType(
		String currency, String travellerType) {

		return findByCurrencyAndTravellerType(
			currency, travellerType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<Premi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end) {

		return findByCurrencyAndTravellerType(
			currency, travellerType, start, end, null);
	}

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
	@Override
	public List<Premi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end,
		OrderByComparator<Premi> orderByComparator) {

		return findByCurrencyAndTravellerType(
			currency, travellerType, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Premi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end,
		OrderByComparator<Premi> orderByComparator, boolean useFinderCache) {

		currency = Objects.toString(currency, "");
		travellerType = Objects.toString(travellerType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCurrencyAndTravellerType;
				finderArgs = new Object[] {currency, travellerType};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByCurrencyAndTravellerType;
			finderArgs = new Object[] {
				currency, travellerType, start, end, orderByComparator
			};
		}

		List<Premi> list = null;

		if (useFinderCache) {
			list = (List<Premi>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Premi premi : list) {
					if (!currency.equals(premi.getCurrency()) ||
						!travellerType.equals(premi.getTravellerType())) {

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

			sb.append(_SQL_SELECT_PREMI_WHERE);

			boolean bindCurrency = false;

			if (currency.isEmpty()) {
				sb.append(_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_CURRENCY_3);
			}
			else {
				bindCurrency = true;

				sb.append(_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_CURRENCY_2);
			}

			boolean bindTravellerType = false;

			if (travellerType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_TRAVELLERTYPE_3);
			}
			else {
				bindTravellerType = true;

				sb.append(
					_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_TRAVELLERTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PremiModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCurrency) {
					queryPos.add(currency);
				}

				if (bindTravellerType) {
					queryPos.add(travellerType);
				}

				list = (List<Premi>)QueryUtil.list(
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
	 * Returns the first premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching premi
	 * @throws NoSuchPremiException if a matching premi could not be found
	 */
	@Override
	public Premi findByCurrencyAndTravellerType_First(
			String currency, String travellerType,
			OrderByComparator<Premi> orderByComparator)
		throws NoSuchPremiException {

		Premi premi = fetchByCurrencyAndTravellerType_First(
			currency, travellerType, orderByComparator);

		if (premi != null) {
			return premi;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("currency=");
		sb.append(currency);

		sb.append(", travellerType=");
		sb.append(travellerType);

		sb.append("}");

		throw new NoSuchPremiException(sb.toString());
	}

	/**
	 * Returns the first premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching premi, or <code>null</code> if a matching premi could not be found
	 */
	@Override
	public Premi fetchByCurrencyAndTravellerType_First(
		String currency, String travellerType,
		OrderByComparator<Premi> orderByComparator) {

		List<Premi> list = findByCurrencyAndTravellerType(
			currency, travellerType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching premi
	 * @throws NoSuchPremiException if a matching premi could not be found
	 */
	@Override
	public Premi findByCurrencyAndTravellerType_Last(
			String currency, String travellerType,
			OrderByComparator<Premi> orderByComparator)
		throws NoSuchPremiException {

		Premi premi = fetchByCurrencyAndTravellerType_Last(
			currency, travellerType, orderByComparator);

		if (premi != null) {
			return premi;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("currency=");
		sb.append(currency);

		sb.append(", travellerType=");
		sb.append(travellerType);

		sb.append("}");

		throw new NoSuchPremiException(sb.toString());
	}

	/**
	 * Returns the last premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching premi, or <code>null</code> if a matching premi could not be found
	 */
	@Override
	public Premi fetchByCurrencyAndTravellerType_Last(
		String currency, String travellerType,
		OrderByComparator<Premi> orderByComparator) {

		int count = countByCurrencyAndTravellerType(currency, travellerType);

		if (count == 0) {
			return null;
		}

		List<Premi> list = findByCurrencyAndTravellerType(
			currency, travellerType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Premi[] findByCurrencyAndTravellerType_PrevAndNext(
			long premiId, String currency, String travellerType,
			OrderByComparator<Premi> orderByComparator)
		throws NoSuchPremiException {

		currency = Objects.toString(currency, "");
		travellerType = Objects.toString(travellerType, "");

		Premi premi = findByPrimaryKey(premiId);

		Session session = null;

		try {
			session = openSession();

			Premi[] array = new PremiImpl[3];

			array[0] = getByCurrencyAndTravellerType_PrevAndNext(
				session, premi, currency, travellerType, orderByComparator,
				true);

			array[1] = premi;

			array[2] = getByCurrencyAndTravellerType_PrevAndNext(
				session, premi, currency, travellerType, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Premi getByCurrencyAndTravellerType_PrevAndNext(
		Session session, Premi premi, String currency, String travellerType,
		OrderByComparator<Premi> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PREMI_WHERE);

		boolean bindCurrency = false;

		if (currency.isEmpty()) {
			sb.append(_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_CURRENCY_3);
		}
		else {
			bindCurrency = true;

			sb.append(_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_CURRENCY_2);
		}

		boolean bindTravellerType = false;

		if (travellerType.isEmpty()) {
			sb.append(_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_TRAVELLERTYPE_3);
		}
		else {
			bindTravellerType = true;

			sb.append(_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_TRAVELLERTYPE_2);
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
			sb.append(PremiModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCurrency) {
			queryPos.add(currency);
		}

		if (bindTravellerType) {
			queryPos.add(travellerType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(premi)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Premi> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the premis where currency = &#63; and travellerType = &#63; from the database.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 */
	@Override
	public void removeByCurrencyAndTravellerType(
		String currency, String travellerType) {

		for (Premi premi :
				findByCurrencyAndTravellerType(
					currency, travellerType, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(premi);
		}
	}

	/**
	 * Returns the number of premis where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @return the number of matching premis
	 */
	@Override
	public int countByCurrencyAndTravellerType(
		String currency, String travellerType) {

		currency = Objects.toString(currency, "");
		travellerType = Objects.toString(travellerType, "");

		FinderPath finderPath = _finderPathCountByCurrencyAndTravellerType;

		Object[] finderArgs = new Object[] {currency, travellerType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PREMI_WHERE);

			boolean bindCurrency = false;

			if (currency.isEmpty()) {
				sb.append(_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_CURRENCY_3);
			}
			else {
				bindCurrency = true;

				sb.append(_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_CURRENCY_2);
			}

			boolean bindTravellerType = false;

			if (travellerType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_TRAVELLERTYPE_3);
			}
			else {
				bindTravellerType = true;

				sb.append(
					_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_TRAVELLERTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCurrency) {
					queryPos.add(currency);
				}

				if (bindTravellerType) {
					queryPos.add(travellerType);
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

	private static final String
		_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_CURRENCY_2 =
			"premi.currency = ? AND ";

	private static final String
		_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_CURRENCY_3 =
			"(premi.currency IS NULL OR premi.currency = '') AND ";

	private static final String
		_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_TRAVELLERTYPE_2 =
			"premi.travellerType = ?";

	private static final String
		_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_TRAVELLERTYPE_3 =
			"(premi.travellerType IS NULL OR premi.travellerType = '')";

	public PremiPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("currency", "currency_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Premi.class);

		setModelImplClass(PremiImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the premi in the entity cache if it is enabled.
	 *
	 * @param premi the premi
	 */
	@Override
	public void cacheResult(Premi premi) {
		entityCache.putResult(PremiImpl.class, premi.getPrimaryKey(), premi);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the premis in the entity cache if it is enabled.
	 *
	 * @param premis the premis
	 */
	@Override
	public void cacheResult(List<Premi> premis) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (premis.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Premi premi : premis) {
			if (entityCache.getResult(PremiImpl.class, premi.getPrimaryKey()) ==
					null) {

				cacheResult(premi);
			}
		}
	}

	/**
	 * Clears the cache for all premis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PremiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the premi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Premi premi) {
		entityCache.removeResult(PremiImpl.class, premi);
	}

	@Override
	public void clearCache(List<Premi> premis) {
		for (Premi premi : premis) {
			entityCache.removeResult(PremiImpl.class, premi);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PremiImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new premi with the primary key. Does not add the premi to the database.
	 *
	 * @param premiId the primary key for the new premi
	 * @return the new premi
	 */
	@Override
	public Premi create(long premiId) {
		Premi premi = new PremiImpl();

		premi.setNew(true);
		premi.setPrimaryKey(premiId);

		premi.setCompanyId(CompanyThreadLocal.getCompanyId());

		return premi;
	}

	/**
	 * Removes the premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param premiId the primary key of the premi
	 * @return the premi that was removed
	 * @throws NoSuchPremiException if a premi with the primary key could not be found
	 */
	@Override
	public Premi remove(long premiId) throws NoSuchPremiException {
		return remove((Serializable)premiId);
	}

	/**
	 * Removes the premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the premi
	 * @return the premi that was removed
	 * @throws NoSuchPremiException if a premi with the primary key could not be found
	 */
	@Override
	public Premi remove(Serializable primaryKey) throws NoSuchPremiException {
		Session session = null;

		try {
			session = openSession();

			Premi premi = (Premi)session.get(PremiImpl.class, primaryKey);

			if (premi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPremiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(premi);
		}
		catch (NoSuchPremiException noSuchEntityException) {
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
	protected Premi removeImpl(Premi premi) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(premi)) {
				premi = (Premi)session.get(
					PremiImpl.class, premi.getPrimaryKeyObj());
			}

			if (premi != null) {
				session.delete(premi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (premi != null) {
			clearCache(premi);
		}

		return premi;
	}

	@Override
	public Premi updateImpl(Premi premi) {
		boolean isNew = premi.isNew();

		if (!(premi instanceof PremiModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(premi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(premi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in premi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Premi implementation " +
					premi.getClass());
		}

		PremiModelImpl premiModelImpl = (PremiModelImpl)premi;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (premi.getCreateDate() == null)) {
			if (serviceContext == null) {
				premi.setCreateDate(date);
			}
			else {
				premi.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!premiModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				premi.setModifiedDate(date);
			}
			else {
				premi.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(premi);
			}
			else {
				premi = (Premi)session.merge(premi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PremiImpl.class, premiModelImpl, false, true);

		if (isNew) {
			premi.setNew(false);
		}

		premi.resetOriginalValues();

		return premi;
	}

	/**
	 * Returns the premi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the premi
	 * @return the premi
	 * @throws NoSuchPremiException if a premi with the primary key could not be found
	 */
	@Override
	public Premi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPremiException {

		Premi premi = fetchByPrimaryKey(primaryKey);

		if (premi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPremiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return premi;
	}

	/**
	 * Returns the premi with the primary key or throws a <code>NoSuchPremiException</code> if it could not be found.
	 *
	 * @param premiId the primary key of the premi
	 * @return the premi
	 * @throws NoSuchPremiException if a premi with the primary key could not be found
	 */
	@Override
	public Premi findByPrimaryKey(long premiId) throws NoSuchPremiException {
		return findByPrimaryKey((Serializable)premiId);
	}

	/**
	 * Returns the premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param premiId the primary key of the premi
	 * @return the premi, or <code>null</code> if a premi with the primary key could not be found
	 */
	@Override
	public Premi fetchByPrimaryKey(long premiId) {
		return fetchByPrimaryKey((Serializable)premiId);
	}

	/**
	 * Returns all the premis.
	 *
	 * @return the premis
	 */
	@Override
	public List<Premi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Premi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Premi> findAll(
		int start, int end, OrderByComparator<Premi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Premi> findAll(
		int start, int end, OrderByComparator<Premi> orderByComparator,
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

		List<Premi> list = null;

		if (useFinderCache) {
			list = (List<Premi>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PREMI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PREMI;

				sql = sql.concat(PremiModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Premi>)QueryUtil.list(
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
	 * Removes all the premis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Premi premi : findAll()) {
			remove(premi);
		}
	}

	/**
	 * Returns the number of premis.
	 *
	 * @return the number of premis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PREMI);

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
		return "premiId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PREMI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PremiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the premi persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PremiModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Premi.class.getName()));

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

		_finderPathWithPaginationFindByCurrencyAndTravellerType =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByCurrencyAndTravellerType",
				new String[] {
					String.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"currency_", "travellerType"}, true);

		_finderPathWithoutPaginationFindByCurrencyAndTravellerType =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByCurrencyAndTravellerType",
				new String[] {String.class.getName(), String.class.getName()},
				new String[] {"currency_", "travellerType"}, true);

		_finderPathCountByCurrencyAndTravellerType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCurrencyAndTravellerType",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"currency_", "travellerType"}, false);

		_setPremiUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPremiUtilPersistence(null);

		entityCache.removeCache(PremiImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPremiUtilPersistence(PremiPersistence premiPersistence) {
		try {
			Field field = PremiUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, premiPersistence);
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

	private static final String _SQL_SELECT_PREMI =
		"SELECT premi FROM Premi premi";

	private static final String _SQL_SELECT_PREMI_WHERE =
		"SELECT premi FROM Premi premi WHERE ";

	private static final String _SQL_COUNT_PREMI =
		"SELECT COUNT(premi) FROM Premi premi";

	private static final String _SQL_COUNT_PREMI_WHERE =
		"SELECT COUNT(premi) FROM Premi premi WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "premi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Premi exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Premi exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PremiPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"currency", "active"});

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

	private static class PremiModelArgumentsResolver
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

			PremiModelImpl premiModelImpl = (PremiModelImpl)baseModel;

			long columnBitmask = premiModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(premiModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= premiModelImpl.getColumnBitmask(
						columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(premiModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PremiModelImpl premiModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = premiModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = premiModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}