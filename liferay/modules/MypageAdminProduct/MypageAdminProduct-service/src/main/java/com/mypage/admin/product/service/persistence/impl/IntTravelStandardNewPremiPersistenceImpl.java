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

import com.mypage.admin.product.exception.NoSuchIntTravelStandardNewPremiException;
import com.mypage.admin.product.model.IntTravelStandardNewPremi;
import com.mypage.admin.product.model.impl.IntTravelStandardNewPremiImpl;
import com.mypage.admin.product.model.impl.IntTravelStandardNewPremiModelImpl;
import com.mypage.admin.product.service.persistence.IntTravelStandardNewPremiPersistence;
import com.mypage.admin.product.service.persistence.IntTravelStandardNewPremiUtil;
import com.mypage.admin.product.service.persistence.impl.constants.MPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the int travel standard new premi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = IntTravelStandardNewPremiPersistence.class)
public class IntTravelStandardNewPremiPersistenceImpl
	extends BasePersistenceImpl<IntTravelStandardNewPremi>
	implements IntTravelStandardNewPremiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>IntTravelStandardNewPremiUtil</code> to access the int travel standard new premi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		IntTravelStandardNewPremiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBySpecificPremi;
	private FinderPath _finderPathCountBySpecificPremi;

	/**
	 * Returns the int travel standard new premi where travelType = &#63; and packageType = &#63; and peopleType = &#63; and currency = &#63; and mainInsured = &#63; and spouse = &#63; and child = &#63; or throws a <code>NoSuchIntTravelStandardNewPremiException</code> if it could not be found.
	 *
	 * @param travelType the travel type
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param mainInsured the main insured
	 * @param spouse the spouse
	 * @param child the child
	 * @return the matching int travel standard new premi
	 * @throws NoSuchIntTravelStandardNewPremiException if a matching int travel standard new premi could not be found
	 */
	@Override
	public IntTravelStandardNewPremi findBySpecificPremi(
			String travelType, String packageType, String peopleType,
			String currency, int mainInsured, int spouse, int child)
		throws NoSuchIntTravelStandardNewPremiException {

		IntTravelStandardNewPremi intTravelStandardNewPremi =
			fetchBySpecificPremi(
				travelType, packageType, peopleType, currency, mainInsured,
				spouse, child);

		if (intTravelStandardNewPremi == null) {
			StringBundler sb = new StringBundler(16);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("travelType=");
			sb.append(travelType);

			sb.append(", packageType=");
			sb.append(packageType);

			sb.append(", peopleType=");
			sb.append(peopleType);

			sb.append(", currency=");
			sb.append(currency);

			sb.append(", mainInsured=");
			sb.append(mainInsured);

			sb.append(", spouse=");
			sb.append(spouse);

			sb.append(", child=");
			sb.append(child);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchIntTravelStandardNewPremiException(sb.toString());
		}

		return intTravelStandardNewPremi;
	}

	/**
	 * Returns the int travel standard new premi where travelType = &#63; and packageType = &#63; and peopleType = &#63; and currency = &#63; and mainInsured = &#63; and spouse = &#63; and child = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param travelType the travel type
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param mainInsured the main insured
	 * @param spouse the spouse
	 * @param child the child
	 * @return the matching int travel standard new premi, or <code>null</code> if a matching int travel standard new premi could not be found
	 */
	@Override
	public IntTravelStandardNewPremi fetchBySpecificPremi(
		String travelType, String packageType, String peopleType,
		String currency, int mainInsured, int spouse, int child) {

		return fetchBySpecificPremi(
			travelType, packageType, peopleType, currency, mainInsured, spouse,
			child, true);
	}

	/**
	 * Returns the int travel standard new premi where travelType = &#63; and packageType = &#63; and peopleType = &#63; and currency = &#63; and mainInsured = &#63; and spouse = &#63; and child = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param travelType the travel type
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param mainInsured the main insured
	 * @param spouse the spouse
	 * @param child the child
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching int travel standard new premi, or <code>null</code> if a matching int travel standard new premi could not be found
	 */
	@Override
	public IntTravelStandardNewPremi fetchBySpecificPremi(
		String travelType, String packageType, String peopleType,
		String currency, int mainInsured, int spouse, int child,
		boolean useFinderCache) {

		travelType = Objects.toString(travelType, "");
		packageType = Objects.toString(packageType, "");
		peopleType = Objects.toString(peopleType, "");
		currency = Objects.toString(currency, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				travelType, packageType, peopleType, currency, mainInsured,
				spouse, child
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySpecificPremi, finderArgs, this);
		}

		if (result instanceof IntTravelStandardNewPremi) {
			IntTravelStandardNewPremi intTravelStandardNewPremi =
				(IntTravelStandardNewPremi)result;

			if (!Objects.equals(
					travelType, intTravelStandardNewPremi.getTravelType()) ||
				!Objects.equals(
					packageType, intTravelStandardNewPremi.getPackageType()) ||
				!Objects.equals(
					peopleType, intTravelStandardNewPremi.getPeopleType()) ||
				!Objects.equals(
					currency, intTravelStandardNewPremi.getCurrency()) ||
				(mainInsured != intTravelStandardNewPremi.getMainInsured()) ||
				(spouse != intTravelStandardNewPremi.getSpouse()) ||
				(child != intTravelStandardNewPremi.getChild())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(9);

			sb.append(_SQL_SELECT_INTTRAVELSTANDARDNEWPREMI_WHERE);

			boolean bindTravelType = false;

			if (travelType.isEmpty()) {
				sb.append(_FINDER_COLUMN_SPECIFICPREMI_TRAVELTYPE_3);
			}
			else {
				bindTravelType = true;

				sb.append(_FINDER_COLUMN_SPECIFICPREMI_TRAVELTYPE_2);
			}

			boolean bindPackageType = false;

			if (packageType.isEmpty()) {
				sb.append(_FINDER_COLUMN_SPECIFICPREMI_PACKAGETYPE_3);
			}
			else {
				bindPackageType = true;

				sb.append(_FINDER_COLUMN_SPECIFICPREMI_PACKAGETYPE_2);
			}

			boolean bindPeopleType = false;

			if (peopleType.isEmpty()) {
				sb.append(_FINDER_COLUMN_SPECIFICPREMI_PEOPLETYPE_3);
			}
			else {
				bindPeopleType = true;

				sb.append(_FINDER_COLUMN_SPECIFICPREMI_PEOPLETYPE_2);
			}

			boolean bindCurrency = false;

			if (currency.isEmpty()) {
				sb.append(_FINDER_COLUMN_SPECIFICPREMI_CURRENCY_3);
			}
			else {
				bindCurrency = true;

				sb.append(_FINDER_COLUMN_SPECIFICPREMI_CURRENCY_2);
			}

			sb.append(_FINDER_COLUMN_SPECIFICPREMI_MAININSURED_2);

			sb.append(_FINDER_COLUMN_SPECIFICPREMI_SPOUSE_2);

			sb.append(_FINDER_COLUMN_SPECIFICPREMI_CHILD_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTravelType) {
					queryPos.add(travelType);
				}

				if (bindPackageType) {
					queryPos.add(packageType);
				}

				if (bindPeopleType) {
					queryPos.add(peopleType);
				}

				if (bindCurrency) {
					queryPos.add(currency);
				}

				queryPos.add(mainInsured);

				queryPos.add(spouse);

				queryPos.add(child);

				List<IntTravelStandardNewPremi> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySpecificPremi, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									travelType, packageType, peopleType,
									currency, mainInsured, spouse, child
								};
							}

							_log.warn(
								"IntTravelStandardNewPremiPersistenceImpl.fetchBySpecificPremi(String, String, String, String, int, int, int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					IntTravelStandardNewPremi intTravelStandardNewPremi =
						list.get(0);

					result = intTravelStandardNewPremi;

					cacheResult(intTravelStandardNewPremi);
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
			return (IntTravelStandardNewPremi)result;
		}
	}

	/**
	 * Removes the int travel standard new premi where travelType = &#63; and packageType = &#63; and peopleType = &#63; and currency = &#63; and mainInsured = &#63; and spouse = &#63; and child = &#63; from the database.
	 *
	 * @param travelType the travel type
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param mainInsured the main insured
	 * @param spouse the spouse
	 * @param child the child
	 * @return the int travel standard new premi that was removed
	 */
	@Override
	public IntTravelStandardNewPremi removeBySpecificPremi(
			String travelType, String packageType, String peopleType,
			String currency, int mainInsured, int spouse, int child)
		throws NoSuchIntTravelStandardNewPremiException {

		IntTravelStandardNewPremi intTravelStandardNewPremi =
			findBySpecificPremi(
				travelType, packageType, peopleType, currency, mainInsured,
				spouse, child);

		return remove(intTravelStandardNewPremi);
	}

	/**
	 * Returns the number of int travel standard new premis where travelType = &#63; and packageType = &#63; and peopleType = &#63; and currency = &#63; and mainInsured = &#63; and spouse = &#63; and child = &#63;.
	 *
	 * @param travelType the travel type
	 * @param packageType the package type
	 * @param peopleType the people type
	 * @param currency the currency
	 * @param mainInsured the main insured
	 * @param spouse the spouse
	 * @param child the child
	 * @return the number of matching int travel standard new premis
	 */
	@Override
	public int countBySpecificPremi(
		String travelType, String packageType, String peopleType,
		String currency, int mainInsured, int spouse, int child) {

		travelType = Objects.toString(travelType, "");
		packageType = Objects.toString(packageType, "");
		peopleType = Objects.toString(peopleType, "");
		currency = Objects.toString(currency, "");

		FinderPath finderPath = _finderPathCountBySpecificPremi;

		Object[] finderArgs = new Object[] {
			travelType, packageType, peopleType, currency, mainInsured, spouse,
			child
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_SQL_COUNT_INTTRAVELSTANDARDNEWPREMI_WHERE);

			boolean bindTravelType = false;

			if (travelType.isEmpty()) {
				sb.append(_FINDER_COLUMN_SPECIFICPREMI_TRAVELTYPE_3);
			}
			else {
				bindTravelType = true;

				sb.append(_FINDER_COLUMN_SPECIFICPREMI_TRAVELTYPE_2);
			}

			boolean bindPackageType = false;

			if (packageType.isEmpty()) {
				sb.append(_FINDER_COLUMN_SPECIFICPREMI_PACKAGETYPE_3);
			}
			else {
				bindPackageType = true;

				sb.append(_FINDER_COLUMN_SPECIFICPREMI_PACKAGETYPE_2);
			}

			boolean bindPeopleType = false;

			if (peopleType.isEmpty()) {
				sb.append(_FINDER_COLUMN_SPECIFICPREMI_PEOPLETYPE_3);
			}
			else {
				bindPeopleType = true;

				sb.append(_FINDER_COLUMN_SPECIFICPREMI_PEOPLETYPE_2);
			}

			boolean bindCurrency = false;

			if (currency.isEmpty()) {
				sb.append(_FINDER_COLUMN_SPECIFICPREMI_CURRENCY_3);
			}
			else {
				bindCurrency = true;

				sb.append(_FINDER_COLUMN_SPECIFICPREMI_CURRENCY_2);
			}

			sb.append(_FINDER_COLUMN_SPECIFICPREMI_MAININSURED_2);

			sb.append(_FINDER_COLUMN_SPECIFICPREMI_SPOUSE_2);

			sb.append(_FINDER_COLUMN_SPECIFICPREMI_CHILD_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTravelType) {
					queryPos.add(travelType);
				}

				if (bindPackageType) {
					queryPos.add(packageType);
				}

				if (bindPeopleType) {
					queryPos.add(peopleType);
				}

				if (bindCurrency) {
					queryPos.add(currency);
				}

				queryPos.add(mainInsured);

				queryPos.add(spouse);

				queryPos.add(child);

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

	private static final String _FINDER_COLUMN_SPECIFICPREMI_TRAVELTYPE_2 =
		"intTravelStandardNewPremi.travelType = ? AND ";

	private static final String _FINDER_COLUMN_SPECIFICPREMI_TRAVELTYPE_3 =
		"(intTravelStandardNewPremi.travelType IS NULL OR intTravelStandardNewPremi.travelType = '') AND ";

	private static final String _FINDER_COLUMN_SPECIFICPREMI_PACKAGETYPE_2 =
		"intTravelStandardNewPremi.packageType = ? AND ";

	private static final String _FINDER_COLUMN_SPECIFICPREMI_PACKAGETYPE_3 =
		"(intTravelStandardNewPremi.packageType IS NULL OR intTravelStandardNewPremi.packageType = '') AND ";

	private static final String _FINDER_COLUMN_SPECIFICPREMI_PEOPLETYPE_2 =
		"intTravelStandardNewPremi.peopleType = ? AND ";

	private static final String _FINDER_COLUMN_SPECIFICPREMI_PEOPLETYPE_3 =
		"(intTravelStandardNewPremi.peopleType IS NULL OR intTravelStandardNewPremi.peopleType = '') AND ";

	private static final String _FINDER_COLUMN_SPECIFICPREMI_CURRENCY_2 =
		"intTravelStandardNewPremi.currency = ? AND ";

	private static final String _FINDER_COLUMN_SPECIFICPREMI_CURRENCY_3 =
		"(intTravelStandardNewPremi.currency IS NULL OR intTravelStandardNewPremi.currency = '') AND ";

	private static final String _FINDER_COLUMN_SPECIFICPREMI_MAININSURED_2 =
		"intTravelStandardNewPremi.mainInsured = ? AND ";

	private static final String _FINDER_COLUMN_SPECIFICPREMI_SPOUSE_2 =
		"intTravelStandardNewPremi.spouse = ? AND ";

	private static final String _FINDER_COLUMN_SPECIFICPREMI_CHILD_2 =
		"intTravelStandardNewPremi.child = ? AND intTravelStandardNewPremi.active=1";

	public IntTravelStandardNewPremiPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("currency", "currency_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(IntTravelStandardNewPremi.class);

		setModelImplClass(IntTravelStandardNewPremiImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the int travel standard new premi in the entity cache if it is enabled.
	 *
	 * @param intTravelStandardNewPremi the int travel standard new premi
	 */
	@Override
	public void cacheResult(
		IntTravelStandardNewPremi intTravelStandardNewPremi) {

		entityCache.putResult(
			IntTravelStandardNewPremiImpl.class,
			intTravelStandardNewPremi.getPrimaryKey(),
			intTravelStandardNewPremi);

		finderCache.putResult(
			_finderPathFetchBySpecificPremi,
			new Object[] {
				intTravelStandardNewPremi.getTravelType(),
				intTravelStandardNewPremi.getPackageType(),
				intTravelStandardNewPremi.getPeopleType(),
				intTravelStandardNewPremi.getCurrency(),
				intTravelStandardNewPremi.getMainInsured(),
				intTravelStandardNewPremi.getSpouse(),
				intTravelStandardNewPremi.getChild()
			},
			intTravelStandardNewPremi);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the int travel standard new premis in the entity cache if it is enabled.
	 *
	 * @param intTravelStandardNewPremis the int travel standard new premis
	 */
	@Override
	public void cacheResult(
		List<IntTravelStandardNewPremi> intTravelStandardNewPremis) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (intTravelStandardNewPremis.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (IntTravelStandardNewPremi intTravelStandardNewPremi :
				intTravelStandardNewPremis) {

			if (entityCache.getResult(
					IntTravelStandardNewPremiImpl.class,
					intTravelStandardNewPremi.getPrimaryKey()) == null) {

				cacheResult(intTravelStandardNewPremi);
			}
		}
	}

	/**
	 * Clears the cache for all int travel standard new premis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IntTravelStandardNewPremiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the int travel standard new premi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		IntTravelStandardNewPremi intTravelStandardNewPremi) {

		entityCache.removeResult(
			IntTravelStandardNewPremiImpl.class, intTravelStandardNewPremi);
	}

	@Override
	public void clearCache(
		List<IntTravelStandardNewPremi> intTravelStandardNewPremis) {

		for (IntTravelStandardNewPremi intTravelStandardNewPremi :
				intTravelStandardNewPremis) {

			entityCache.removeResult(
				IntTravelStandardNewPremiImpl.class, intTravelStandardNewPremi);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				IntTravelStandardNewPremiImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		IntTravelStandardNewPremiModelImpl intTravelStandardNewPremiModelImpl) {

		Object[] args = new Object[] {
			intTravelStandardNewPremiModelImpl.getTravelType(),
			intTravelStandardNewPremiModelImpl.getPackageType(),
			intTravelStandardNewPremiModelImpl.getPeopleType(),
			intTravelStandardNewPremiModelImpl.getCurrency(),
			intTravelStandardNewPremiModelImpl.getMainInsured(),
			intTravelStandardNewPremiModelImpl.getSpouse(),
			intTravelStandardNewPremiModelImpl.getChild()
		};

		finderCache.putResult(
			_finderPathCountBySpecificPremi, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBySpecificPremi, args,
			intTravelStandardNewPremiModelImpl, false);
	}

	/**
	 * Creates a new int travel standard new premi with the primary key. Does not add the int travel standard new premi to the database.
	 *
	 * @param intTravelStandardNewPremiId the primary key for the new int travel standard new premi
	 * @return the new int travel standard new premi
	 */
	@Override
	public IntTravelStandardNewPremi create(long intTravelStandardNewPremiId) {
		IntTravelStandardNewPremi intTravelStandardNewPremi =
			new IntTravelStandardNewPremiImpl();

		intTravelStandardNewPremi.setNew(true);
		intTravelStandardNewPremi.setPrimaryKey(intTravelStandardNewPremiId);

		intTravelStandardNewPremi.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return intTravelStandardNewPremi;
	}

	/**
	 * Removes the int travel standard new premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param intTravelStandardNewPremiId the primary key of the int travel standard new premi
	 * @return the int travel standard new premi that was removed
	 * @throws NoSuchIntTravelStandardNewPremiException if a int travel standard new premi with the primary key could not be found
	 */
	@Override
	public IntTravelStandardNewPremi remove(long intTravelStandardNewPremiId)
		throws NoSuchIntTravelStandardNewPremiException {

		return remove((Serializable)intTravelStandardNewPremiId);
	}

	/**
	 * Removes the int travel standard new premi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the int travel standard new premi
	 * @return the int travel standard new premi that was removed
	 * @throws NoSuchIntTravelStandardNewPremiException if a int travel standard new premi with the primary key could not be found
	 */
	@Override
	public IntTravelStandardNewPremi remove(Serializable primaryKey)
		throws NoSuchIntTravelStandardNewPremiException {

		Session session = null;

		try {
			session = openSession();

			IntTravelStandardNewPremi intTravelStandardNewPremi =
				(IntTravelStandardNewPremi)session.get(
					IntTravelStandardNewPremiImpl.class, primaryKey);

			if (intTravelStandardNewPremi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIntTravelStandardNewPremiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(intTravelStandardNewPremi);
		}
		catch (NoSuchIntTravelStandardNewPremiException noSuchEntityException) {
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
	protected IntTravelStandardNewPremi removeImpl(
		IntTravelStandardNewPremi intTravelStandardNewPremi) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(intTravelStandardNewPremi)) {
				intTravelStandardNewPremi =
					(IntTravelStandardNewPremi)session.get(
						IntTravelStandardNewPremiImpl.class,
						intTravelStandardNewPremi.getPrimaryKeyObj());
			}

			if (intTravelStandardNewPremi != null) {
				session.delete(intTravelStandardNewPremi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (intTravelStandardNewPremi != null) {
			clearCache(intTravelStandardNewPremi);
		}

		return intTravelStandardNewPremi;
	}

	@Override
	public IntTravelStandardNewPremi updateImpl(
		IntTravelStandardNewPremi intTravelStandardNewPremi) {

		boolean isNew = intTravelStandardNewPremi.isNew();

		if (!(intTravelStandardNewPremi instanceof
				IntTravelStandardNewPremiModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(intTravelStandardNewPremi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					intTravelStandardNewPremi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in intTravelStandardNewPremi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom IntTravelStandardNewPremi implementation " +
					intTravelStandardNewPremi.getClass());
		}

		IntTravelStandardNewPremiModelImpl intTravelStandardNewPremiModelImpl =
			(IntTravelStandardNewPremiModelImpl)intTravelStandardNewPremi;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (intTravelStandardNewPremi.getCreateDate() == null)) {
			if (serviceContext == null) {
				intTravelStandardNewPremi.setCreateDate(date);
			}
			else {
				intTravelStandardNewPremi.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!intTravelStandardNewPremiModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				intTravelStandardNewPremi.setModifiedDate(date);
			}
			else {
				intTravelStandardNewPremi.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(intTravelStandardNewPremi);
			}
			else {
				intTravelStandardNewPremi =
					(IntTravelStandardNewPremi)session.merge(
						intTravelStandardNewPremi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			IntTravelStandardNewPremiImpl.class,
			intTravelStandardNewPremiModelImpl, false, true);

		cacheUniqueFindersCache(intTravelStandardNewPremiModelImpl);

		if (isNew) {
			intTravelStandardNewPremi.setNew(false);
		}

		intTravelStandardNewPremi.resetOriginalValues();

		return intTravelStandardNewPremi;
	}

	/**
	 * Returns the int travel standard new premi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the int travel standard new premi
	 * @return the int travel standard new premi
	 * @throws NoSuchIntTravelStandardNewPremiException if a int travel standard new premi with the primary key could not be found
	 */
	@Override
	public IntTravelStandardNewPremi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIntTravelStandardNewPremiException {

		IntTravelStandardNewPremi intTravelStandardNewPremi = fetchByPrimaryKey(
			primaryKey);

		if (intTravelStandardNewPremi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIntTravelStandardNewPremiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return intTravelStandardNewPremi;
	}

	/**
	 * Returns the int travel standard new premi with the primary key or throws a <code>NoSuchIntTravelStandardNewPremiException</code> if it could not be found.
	 *
	 * @param intTravelStandardNewPremiId the primary key of the int travel standard new premi
	 * @return the int travel standard new premi
	 * @throws NoSuchIntTravelStandardNewPremiException if a int travel standard new premi with the primary key could not be found
	 */
	@Override
	public IntTravelStandardNewPremi findByPrimaryKey(
			long intTravelStandardNewPremiId)
		throws NoSuchIntTravelStandardNewPremiException {

		return findByPrimaryKey((Serializable)intTravelStandardNewPremiId);
	}

	/**
	 * Returns the int travel standard new premi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param intTravelStandardNewPremiId the primary key of the int travel standard new premi
	 * @return the int travel standard new premi, or <code>null</code> if a int travel standard new premi with the primary key could not be found
	 */
	@Override
	public IntTravelStandardNewPremi fetchByPrimaryKey(
		long intTravelStandardNewPremiId) {

		return fetchByPrimaryKey((Serializable)intTravelStandardNewPremiId);
	}

	/**
	 * Returns all the int travel standard new premis.
	 *
	 * @return the int travel standard new premis
	 */
	@Override
	public List<IntTravelStandardNewPremi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the int travel standard new premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IntTravelStandardNewPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of int travel standard new premis
	 * @param end the upper bound of the range of int travel standard new premis (not inclusive)
	 * @return the range of int travel standard new premis
	 */
	@Override
	public List<IntTravelStandardNewPremi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the int travel standard new premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IntTravelStandardNewPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of int travel standard new premis
	 * @param end the upper bound of the range of int travel standard new premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of int travel standard new premis
	 */
	@Override
	public List<IntTravelStandardNewPremi> findAll(
		int start, int end,
		OrderByComparator<IntTravelStandardNewPremi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the int travel standard new premis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IntTravelStandardNewPremiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of int travel standard new premis
	 * @param end the upper bound of the range of int travel standard new premis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of int travel standard new premis
	 */
	@Override
	public List<IntTravelStandardNewPremi> findAll(
		int start, int end,
		OrderByComparator<IntTravelStandardNewPremi> orderByComparator,
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

		List<IntTravelStandardNewPremi> list = null;

		if (useFinderCache) {
			list = (List<IntTravelStandardNewPremi>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_INTTRAVELSTANDARDNEWPREMI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_INTTRAVELSTANDARDNEWPREMI;

				sql = sql.concat(
					IntTravelStandardNewPremiModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<IntTravelStandardNewPremi>)QueryUtil.list(
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
	 * Removes all the int travel standard new premis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (IntTravelStandardNewPremi intTravelStandardNewPremi : findAll()) {
			remove(intTravelStandardNewPremi);
		}
	}

	/**
	 * Returns the number of int travel standard new premis.
	 *
	 * @return the number of int travel standard new premis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_INTTRAVELSTANDARDNEWPREMI);

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
		return "intTravelStandardNewPremiId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_INTTRAVELSTANDARDNEWPREMI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return IntTravelStandardNewPremiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the int travel standard new premi persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new IntTravelStandardNewPremiModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", IntTravelStandardNewPremi.class.getName()));

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

		_finderPathFetchBySpecificPremi = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBySpecificPremi",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			new String[] {
				"travelType", "packageType", "peopleType", "currency_",
				"mainInsured", "spouse", "child"
			},
			true);

		_finderPathCountBySpecificPremi = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySpecificPremi",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			new String[] {
				"travelType", "packageType", "peopleType", "currency_",
				"mainInsured", "spouse", "child"
			},
			false);

		_setIntTravelStandardNewPremiUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setIntTravelStandardNewPremiUtilPersistence(null);

		entityCache.removeCache(IntTravelStandardNewPremiImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setIntTravelStandardNewPremiUtilPersistence(
		IntTravelStandardNewPremiPersistence
			intTravelStandardNewPremiPersistence) {

		try {
			Field field = IntTravelStandardNewPremiUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, intTravelStandardNewPremiPersistence);
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

	private static final String _SQL_SELECT_INTTRAVELSTANDARDNEWPREMI =
		"SELECT intTravelStandardNewPremi FROM IntTravelStandardNewPremi intTravelStandardNewPremi";

	private static final String _SQL_SELECT_INTTRAVELSTANDARDNEWPREMI_WHERE =
		"SELECT intTravelStandardNewPremi FROM IntTravelStandardNewPremi intTravelStandardNewPremi WHERE ";

	private static final String _SQL_COUNT_INTTRAVELSTANDARDNEWPREMI =
		"SELECT COUNT(intTravelStandardNewPremi) FROM IntTravelStandardNewPremi intTravelStandardNewPremi";

	private static final String _SQL_COUNT_INTTRAVELSTANDARDNEWPREMI_WHERE =
		"SELECT COUNT(intTravelStandardNewPremi) FROM IntTravelStandardNewPremi intTravelStandardNewPremi WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"intTravelStandardNewPremi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No IntTravelStandardNewPremi exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No IntTravelStandardNewPremi exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		IntTravelStandardNewPremiPersistenceImpl.class);

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

	private static class IntTravelStandardNewPremiModelArgumentsResolver
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

			IntTravelStandardNewPremiModelImpl
				intTravelStandardNewPremiModelImpl =
					(IntTravelStandardNewPremiModelImpl)baseModel;

			long columnBitmask =
				intTravelStandardNewPremiModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					intTravelStandardNewPremiModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						intTravelStandardNewPremiModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					intTravelStandardNewPremiModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			IntTravelStandardNewPremiModelImpl
				intTravelStandardNewPremiModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						intTravelStandardNewPremiModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						intTravelStandardNewPremiModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}