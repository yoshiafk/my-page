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

import com.mypage.admin.product.exception.NoSuchStiPremiException;
import com.mypage.admin.product.model.StiPremi;
import com.mypage.admin.product.model.impl.StiPremiImpl;
import com.mypage.admin.product.model.impl.StiPremiModelImpl;
import com.mypage.admin.product.service.persistence.StiPremiPersistence;
import com.mypage.admin.product.service.persistence.StiPremiUtil;
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
 * The persistence implementation for the sti premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = StiPremiPersistence.class)
public class StiPremiPersistenceImpl
	extends BasePersistenceImpl<StiPremi> implements StiPremiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StiPremiUtil</code> to access the sti premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StiPremiImpl.class.getName();

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
	 * Returns all the sti premis where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @return the matching sti premis
	 */
	@Override
	public List<StiPremi> findByCurrencyAndTravellerType(
		String currency, String travellerType) {

		return findByCurrencyAndTravellerType(
			currency, travellerType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<StiPremi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end) {

		return findByCurrencyAndTravellerType(
			currency, travellerType, start, end, null);
	}

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
	@Override
	public List<StiPremi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end,
		OrderByComparator<StiPremi> orderByComparator) {

		return findByCurrencyAndTravellerType(
			currency, travellerType, start, end, orderByComparator, true);
	}

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
	@Override
	public List<StiPremi> findByCurrencyAndTravellerType(
		String currency, String travellerType, int start, int end,
		OrderByComparator<StiPremi> orderByComparator, boolean useFinderCache) {

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

		List<StiPremi> list = null;

		if (useFinderCache) {
			list = (List<StiPremi>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StiPremi stiPremi : list) {
					if (!currency.equals(stiPremi.getCurrency()) ||
						!travellerType.equals(stiPremi.getTravellerType())) {

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

			sb.append(_SQL_SELECT_STIPREMI_WHERE);

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
				sb.append(StiPremiModelImpl.ORDER_BY_JPQL);
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

				list = (List<StiPremi>)QueryUtil.list(
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
	 * Returns the first sti premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sti premi
	 * @throws NoSuchStiPremiException if a matching sti premi could not be found
	 */
	@Override
	public StiPremi findByCurrencyAndTravellerType_First(
			String currency, String travellerType,
			OrderByComparator<StiPremi> orderByComparator)
		throws NoSuchStiPremiException {

		StiPremi stiPremi = fetchByCurrencyAndTravellerType_First(
			currency, travellerType, orderByComparator);

		if (stiPremi != null) {
			return stiPremi;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("currency=");
		sb.append(currency);

		sb.append(", travellerType=");
		sb.append(travellerType);

		sb.append("}");

		throw new NoSuchStiPremiException(sb.toString());
	}

	/**
	 * Returns the first sti premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sti premi, or <code>null</code> if a matching sti premi could not be found
	 */
	@Override
	public StiPremi fetchByCurrencyAndTravellerType_First(
		String currency, String travellerType,
		OrderByComparator<StiPremi> orderByComparator) {

		List<StiPremi> list = findByCurrencyAndTravellerType(
			currency, travellerType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sti premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sti premi
	 * @throws NoSuchStiPremiException if a matching sti premi could not be found
	 */
	@Override
	public StiPremi findByCurrencyAndTravellerType_Last(
			String currency, String travellerType,
			OrderByComparator<StiPremi> orderByComparator)
		throws NoSuchStiPremiException {

		StiPremi stiPremi = fetchByCurrencyAndTravellerType_Last(
			currency, travellerType, orderByComparator);

		if (stiPremi != null) {
			return stiPremi;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("currency=");
		sb.append(currency);

		sb.append(", travellerType=");
		sb.append(travellerType);

		sb.append("}");

		throw new NoSuchStiPremiException(sb.toString());
	}

	/**
	 * Returns the last sti premi in the ordered set where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sti premi, or <code>null</code> if a matching sti premi could not be found
	 */
	@Override
	public StiPremi fetchByCurrencyAndTravellerType_Last(
		String currency, String travellerType,
		OrderByComparator<StiPremi> orderByComparator) {

		int count = countByCurrencyAndTravellerType(currency, travellerType);

		if (count == 0) {
			return null;
		}

		List<StiPremi> list = findByCurrencyAndTravellerType(
			currency, travellerType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public StiPremi[] findByCurrencyAndTravellerType_PrevAndNext(
			long premiId, String currency, String travellerType,
			OrderByComparator<StiPremi> orderByComparator)
		throws NoSuchStiPremiException {

		currency = Objects.toString(currency, "");
		travellerType = Objects.toString(travellerType, "");

		StiPremi stiPremi = findByPrimaryKey(premiId);

		Session session = null;

		try {
			session = openSession();

			StiPremi[] array = new StiPremiImpl[3];

			array[0] = getByCurrencyAndTravellerType_PrevAndNext(
				session, stiPremi, currency, travellerType, orderByComparator,
				true);

			array[1] = stiPremi;

			array[2] = getByCurrencyAndTravellerType_PrevAndNext(
				session, stiPremi, currency, travellerType, orderByComparator,
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

	protected StiPremi getByCurrencyAndTravellerType_PrevAndNext(
		Session session, StiPremi stiPremi, String currency,
		String travellerType, OrderByComparator<StiPremi> orderByComparator,
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

		sb.append(_SQL_SELECT_STIPREMI_WHERE);

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
			sb.append(StiPremiModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(stiPremi)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StiPremi> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sti premis where currency = &#63; and travellerType = &#63; from the database.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 */
	@Override
	public void removeByCurrencyAndTravellerType(
		String currency, String travellerType) {

		for (StiPremi stiPremi :
				findByCurrencyAndTravellerType(
					currency, travellerType, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(stiPremi);
		}
	}

	/**
	 * Returns the number of sti premis where currency = &#63; and travellerType = &#63;.
	 *
	 * @param currency the currency
	 * @param travellerType the traveller type
	 * @return the number of matching sti premis
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

			sb.append(_SQL_COUNT_STIPREMI_WHERE);

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
			"stiPremi.currency = ? AND ";

	private static final String
		_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_CURRENCY_3 =
			"(stiPremi.currency IS NULL OR stiPremi.currency = '') AND ";

	private static final String
		_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_TRAVELLERTYPE_2 =
			"stiPremi.travellerType = ?";

	private static final String
		_FINDER_COLUMN_CURRENCYANDTRAVELLERTYPE_TRAVELLERTYPE_3 =
			"(stiPremi.travellerType IS NULL OR stiPremi.travellerType = '')";

	public StiPremiPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("currency", "currency_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(StiPremi.class);

		setModelImplClass(StiPremiImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the sti premi in the entity cache if it is enabled.
	 *
	 * @param stiPremi the sti premi
	 */
	@Override
	public void cacheResult(StiPremi stiPremi) {
		entityCache.putResult(
			StiPremiImpl.class, stiPremi.getPrimaryKey(), stiPremi);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sti premis in the entity cache if it is enabled.
	 *
	 * @param stiPremis the sti premis
	 */
	@Override
	public void cacheResult(List<StiPremi> stiPremis) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (stiPremis.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (StiPremi stiPremi : stiPremis) {
			if (entityCache.getResult(
					StiPremiImpl.class, stiPremi.getPrimaryKey()) == null) {

				cacheResult(stiPremi);
			}
		}
	}

	/**
	 * Clears the cache for all sti premis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StiPremiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sti premi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StiPremi stiPremi) {
		entityCache.removeResult(StiPremiImpl.class, stiPremi);
	}

	@Override
	public void clearCache(List<StiPremi> stiPremis) {
		for (StiPremi stiPremi : stiPremis) {
			entityCache.removeResult(StiPremiImpl.class, stiPremi);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(StiPremiImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new sti premi with the primary key. Does not add the sti premi to the database.
	 *
	 * @param premiId the primary key for the new sti premi
	 * @return the new sti premi
	 */
	@Override
	public StiPremi create(long premiId) {
		StiPremi stiPremi = new StiPremiImpl();

		stiPremi.setNew(true);
		stiPremi.setPrimaryKey(premiId);

		stiPremi.setCompanyId(CompanyThreadLocal.getCompanyId());

		return stiPremi;
	}

	/**
	 * Removes the sti premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param premiId the primary key of the sti premi
	 * @return the sti premi that was removed
	 * @throws NoSuchStiPremiException if a sti premi with the primary key could not be found
	 */
	@Override
	public StiPremi remove(long premiId) throws NoSuchStiPremiException {
		return remove((Serializable)premiId);
	}

	/**
	 * Removes the sti premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sti premi
	 * @return the sti premi that was removed
	 * @throws NoSuchStiPremiException if a sti premi with the primary key could not be found
	 */
	@Override
	public StiPremi remove(Serializable primaryKey)
		throws NoSuchStiPremiException {

		Session session = null;

		try {
			session = openSession();

			StiPremi stiPremi = (StiPremi)session.get(
				StiPremiImpl.class, primaryKey);

			if (stiPremi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStiPremiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stiPremi);
		}
		catch (NoSuchStiPremiException noSuchEntityException) {
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
	protected StiPremi removeImpl(StiPremi stiPremi) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stiPremi)) {
				stiPremi = (StiPremi)session.get(
					StiPremiImpl.class, stiPremi.getPrimaryKeyObj());
			}

			if (stiPremi != null) {
				session.delete(stiPremi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stiPremi != null) {
			clearCache(stiPremi);
		}

		return stiPremi;
	}

	@Override
	public StiPremi updateImpl(StiPremi stiPremi) {
		boolean isNew = stiPremi.isNew();

		if (!(stiPremi instanceof StiPremiModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stiPremi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(stiPremi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stiPremi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StiPremi implementation " +
					stiPremi.getClass());
		}

		StiPremiModelImpl stiPremiModelImpl = (StiPremiModelImpl)stiPremi;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (stiPremi.getCreateDate() == null)) {
			if (serviceContext == null) {
				stiPremi.setCreateDate(date);
			}
			else {
				stiPremi.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!stiPremiModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				stiPremi.setModifiedDate(date);
			}
			else {
				stiPremi.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(stiPremi);
			}
			else {
				stiPremi = (StiPremi)session.merge(stiPremi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			StiPremiImpl.class, stiPremiModelImpl, false, true);

		if (isNew) {
			stiPremi.setNew(false);
		}

		stiPremi.resetOriginalValues();

		return stiPremi;
	}

	/**
	 * Returns the sti premi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sti premi
	 * @return the sti premi
	 * @throws NoSuchStiPremiException if a sti premi with the primary key could not be found
	 */
	@Override
	public StiPremi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStiPremiException {

		StiPremi stiPremi = fetchByPrimaryKey(primaryKey);

		if (stiPremi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStiPremiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stiPremi;
	}

	/**
	 * Returns the sti premi with the primary key or throws a <code>NoSuchStiPremiException</code> if it could not be found.
	 *
	 * @param premiId the primary key of the sti premi
	 * @return the sti premi
	 * @throws NoSuchStiPremiException if a sti premi with the primary key could not be found
	 */
	@Override
	public StiPremi findByPrimaryKey(long premiId)
		throws NoSuchStiPremiException {

		return findByPrimaryKey((Serializable)premiId);
	}

	/**
	 * Returns the sti premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param premiId the primary key of the sti premi
	 * @return the sti premi, or <code>null</code> if a sti premi with the primary key could not be found
	 */
	@Override
	public StiPremi fetchByPrimaryKey(long premiId) {
		return fetchByPrimaryKey((Serializable)premiId);
	}

	/**
	 * Returns all the sti premis.
	 *
	 * @return the sti premis
	 */
	@Override
	public List<StiPremi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<StiPremi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<StiPremi> findAll(
		int start, int end, OrderByComparator<StiPremi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<StiPremi> findAll(
		int start, int end, OrderByComparator<StiPremi> orderByComparator,
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

		List<StiPremi> list = null;

		if (useFinderCache) {
			list = (List<StiPremi>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STIPREMI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STIPREMI;

				sql = sql.concat(StiPremiModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StiPremi>)QueryUtil.list(
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
	 * Removes all the sti premis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StiPremi stiPremi : findAll()) {
			remove(stiPremi);
		}
	}

	/**
	 * Returns the number of sti premis.
	 *
	 * @return the number of sti premis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STIPREMI);

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
		return _SQL_SELECT_STIPREMI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StiPremiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sti premi persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new StiPremiModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", StiPremi.class.getName()));

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

		_setStiPremiUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setStiPremiUtilPersistence(null);

		entityCache.removeCache(StiPremiImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setStiPremiUtilPersistence(
		StiPremiPersistence stiPremiPersistence) {

		try {
			Field field = StiPremiUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, stiPremiPersistence);
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

	private static final String _SQL_SELECT_STIPREMI =
		"SELECT stiPremi FROM StiPremi stiPremi";

	private static final String _SQL_SELECT_STIPREMI_WHERE =
		"SELECT stiPremi FROM StiPremi stiPremi WHERE ";

	private static final String _SQL_COUNT_STIPREMI =
		"SELECT COUNT(stiPremi) FROM StiPremi stiPremi";

	private static final String _SQL_COUNT_STIPREMI_WHERE =
		"SELECT COUNT(stiPremi) FROM StiPremi stiPremi WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stiPremi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StiPremi exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No StiPremi exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StiPremiPersistenceImpl.class);

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

	private static class StiPremiModelArgumentsResolver
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

			StiPremiModelImpl stiPremiModelImpl = (StiPremiModelImpl)baseModel;

			long columnBitmask = stiPremiModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(stiPremiModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						stiPremiModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(stiPremiModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			StiPremiModelImpl stiPremiModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = stiPremiModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = stiPremiModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}