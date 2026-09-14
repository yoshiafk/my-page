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

import com.mypage.admin.product.exception.NoSuchTravelDomesticInsuredTypeException;
import com.mypage.admin.product.model.TravelDomesticInsuredType;
import com.mypage.admin.product.model.impl.TravelDomesticInsuredTypeImpl;
import com.mypage.admin.product.model.impl.TravelDomesticInsuredTypeModelImpl;
import com.mypage.admin.product.service.persistence.TravelDomesticInsuredTypePersistence;
import com.mypage.admin.product.service.persistence.TravelDomesticInsuredTypeUtil;
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
 * The persistence implementation for the travel domestic insured type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = TravelDomesticInsuredTypePersistence.class)
public class TravelDomesticInsuredTypePersistenceImpl
	extends BasePersistenceImpl<TravelDomesticInsuredType>
	implements TravelDomesticInsuredTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TravelDomesticInsuredTypeUtil</code> to access the travel domestic insured type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TravelDomesticInsuredTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBysearchInsuredType;
	private FinderPath _finderPathWithoutPaginationFindBysearchInsuredType;
	private FinderPath _finderPathCountBysearchInsuredType;

	/**
	 * Returns all the travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @return the matching travel domestic insured types
	 */
	@Override
	public List<TravelDomesticInsuredType> findBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code) {

		return findBysearchInsuredType(
			travelDomesticInsuredTypeId, name, code, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @return the range of matching travel domestic insured types
	 */
	@Override
	public List<TravelDomesticInsuredType> findBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code, int start,
		int end) {

		return findBysearchInsuredType(
			travelDomesticInsuredTypeId, name, code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic insured types
	 */
	@Override
	public List<TravelDomesticInsuredType> findBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code, int start,
		int end,
		OrderByComparator<TravelDomesticInsuredType> orderByComparator) {

		return findBysearchInsuredType(
			travelDomesticInsuredTypeId, name, code, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic insured types
	 */
	@Override
	public List<TravelDomesticInsuredType> findBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code, int start,
		int end, OrderByComparator<TravelDomesticInsuredType> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");
		code = Objects.toString(code, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBysearchInsuredType;
				finderArgs = new Object[] {
					travelDomesticInsuredTypeId, name, code
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchInsuredType;
			finderArgs = new Object[] {
				travelDomesticInsuredTypeId, name, code, start, end,
				orderByComparator
			};
		}

		List<TravelDomesticInsuredType> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticInsuredType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelDomesticInsuredType travelDomesticInsuredType :
						list) {

					if ((travelDomesticInsuredTypeId !=
							travelDomesticInsuredType.
								getTravelDomesticInsuredTypeId()) ||
						!name.equals(travelDomesticInsuredType.getName()) ||
						!code.equals(travelDomesticInsuredType.getCode())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_TRAVELDOMESTICINSUREDTYPE_WHERE);

			sb.append(
				_FINDER_COLUMN_SEARCHINSUREDTYPE_TRAVELDOMESTICINSUREDTYPEID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_NAME_2);
			}

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelDomesticInsuredTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(travelDomesticInsuredTypeId);

				if (bindName) {
					queryPos.add(name);
				}

				if (bindCode) {
					queryPos.add(code);
				}

				list = (List<TravelDomesticInsuredType>)QueryUtil.list(
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
	 * Returns the first travel domestic insured type in the ordered set where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic insured type
	 * @throws NoSuchTravelDomesticInsuredTypeException if a matching travel domestic insured type could not be found
	 */
	@Override
	public TravelDomesticInsuredType findBysearchInsuredType_First(
			long travelDomesticInsuredTypeId, String name, String code,
			OrderByComparator<TravelDomesticInsuredType> orderByComparator)
		throws NoSuchTravelDomesticInsuredTypeException {

		TravelDomesticInsuredType travelDomesticInsuredType =
			fetchBysearchInsuredType_First(
				travelDomesticInsuredTypeId, name, code, orderByComparator);

		if (travelDomesticInsuredType != null) {
			return travelDomesticInsuredType;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelDomesticInsuredTypeId=");
		sb.append(travelDomesticInsuredTypeId);

		sb.append(", name=");
		sb.append(name);

		sb.append(", code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchTravelDomesticInsuredTypeException(sb.toString());
	}

	/**
	 * Returns the first travel domestic insured type in the ordered set where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic insured type, or <code>null</code> if a matching travel domestic insured type could not be found
	 */
	@Override
	public TravelDomesticInsuredType fetchBysearchInsuredType_First(
		long travelDomesticInsuredTypeId, String name, String code,
		OrderByComparator<TravelDomesticInsuredType> orderByComparator) {

		List<TravelDomesticInsuredType> list = findBysearchInsuredType(
			travelDomesticInsuredTypeId, name, code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel domestic insured type in the ordered set where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic insured type
	 * @throws NoSuchTravelDomesticInsuredTypeException if a matching travel domestic insured type could not be found
	 */
	@Override
	public TravelDomesticInsuredType findBysearchInsuredType_Last(
			long travelDomesticInsuredTypeId, String name, String code,
			OrderByComparator<TravelDomesticInsuredType> orderByComparator)
		throws NoSuchTravelDomesticInsuredTypeException {

		TravelDomesticInsuredType travelDomesticInsuredType =
			fetchBysearchInsuredType_Last(
				travelDomesticInsuredTypeId, name, code, orderByComparator);

		if (travelDomesticInsuredType != null) {
			return travelDomesticInsuredType;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelDomesticInsuredTypeId=");
		sb.append(travelDomesticInsuredTypeId);

		sb.append(", name=");
		sb.append(name);

		sb.append(", code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchTravelDomesticInsuredTypeException(sb.toString());
	}

	/**
	 * Returns the last travel domestic insured type in the ordered set where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic insured type, or <code>null</code> if a matching travel domestic insured type could not be found
	 */
	@Override
	public TravelDomesticInsuredType fetchBysearchInsuredType_Last(
		long travelDomesticInsuredTypeId, String name, String code,
		OrderByComparator<TravelDomesticInsuredType> orderByComparator) {

		int count = countBysearchInsuredType(
			travelDomesticInsuredTypeId, name, code);

		if (count == 0) {
			return null;
		}

		List<TravelDomesticInsuredType> list = findBysearchInsuredType(
			travelDomesticInsuredTypeId, name, code, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63; from the database.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 */
	@Override
	public void removeBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code) {

		for (TravelDomesticInsuredType travelDomesticInsuredType :
				findBysearchInsuredType(
					travelDomesticInsuredTypeId, name, code, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(travelDomesticInsuredType);
		}
	}

	/**
	 * Returns the number of travel domestic insured types where travelDomesticInsuredTypeId = &#63; and name = &#63; and code = &#63;.
	 *
	 * @param travelDomesticInsuredTypeId the travel domestic insured type ID
	 * @param name the name
	 * @param code the code
	 * @return the number of matching travel domestic insured types
	 */
	@Override
	public int countBysearchInsuredType(
		long travelDomesticInsuredTypeId, String name, String code) {

		name = Objects.toString(name, "");
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountBysearchInsuredType;

		Object[] finderArgs = new Object[] {
			travelDomesticInsuredTypeId, name, code
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_TRAVELDOMESTICINSUREDTYPE_WHERE);

			sb.append(
				_FINDER_COLUMN_SEARCHINSUREDTYPE_TRAVELDOMESTICINSUREDTYPEID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_NAME_2);
			}

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(travelDomesticInsuredTypeId);

				if (bindName) {
					queryPos.add(name);
				}

				if (bindCode) {
					queryPos.add(code);
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
		_FINDER_COLUMN_SEARCHINSUREDTYPE_TRAVELDOMESTICINSUREDTYPEID_2 =
			"travelDomesticInsuredType.travelDomesticInsuredTypeId = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHINSUREDTYPE_NAME_2 =
		"travelDomesticInsuredType.name = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHINSUREDTYPE_NAME_3 =
		"(travelDomesticInsuredType.name IS NULL OR travelDomesticInsuredType.name = '') AND ";

	private static final String _FINDER_COLUMN_SEARCHINSUREDTYPE_CODE_2 =
		"travelDomesticInsuredType.code = ?";

	private static final String _FINDER_COLUMN_SEARCHINSUREDTYPE_CODE_3 =
		"(travelDomesticInsuredType.code IS NULL OR travelDomesticInsuredType.code = '')";

	public TravelDomesticInsuredTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TravelDomesticInsuredType.class);

		setModelImplClass(TravelDomesticInsuredTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the travel domestic insured type in the entity cache if it is enabled.
	 *
	 * @param travelDomesticInsuredType the travel domestic insured type
	 */
	@Override
	public void cacheResult(
		TravelDomesticInsuredType travelDomesticInsuredType) {

		entityCache.putResult(
			TravelDomesticInsuredTypeImpl.class,
			travelDomesticInsuredType.getPrimaryKey(),
			travelDomesticInsuredType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the travel domestic insured types in the entity cache if it is enabled.
	 *
	 * @param travelDomesticInsuredTypes the travel domestic insured types
	 */
	@Override
	public void cacheResult(
		List<TravelDomesticInsuredType> travelDomesticInsuredTypes) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (travelDomesticInsuredTypes.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TravelDomesticInsuredType travelDomesticInsuredType :
				travelDomesticInsuredTypes) {

			if (entityCache.getResult(
					TravelDomesticInsuredTypeImpl.class,
					travelDomesticInsuredType.getPrimaryKey()) == null) {

				cacheResult(travelDomesticInsuredType);
			}
		}
	}

	/**
	 * Clears the cache for all travel domestic insured types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TravelDomesticInsuredTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the travel domestic insured type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		TravelDomesticInsuredType travelDomesticInsuredType) {

		entityCache.removeResult(
			TravelDomesticInsuredTypeImpl.class, travelDomesticInsuredType);
	}

	@Override
	public void clearCache(
		List<TravelDomesticInsuredType> travelDomesticInsuredTypes) {

		for (TravelDomesticInsuredType travelDomesticInsuredType :
				travelDomesticInsuredTypes) {

			entityCache.removeResult(
				TravelDomesticInsuredTypeImpl.class, travelDomesticInsuredType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				TravelDomesticInsuredTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new travel domestic insured type with the primary key. Does not add the travel domestic insured type to the database.
	 *
	 * @param travelDomesticInsuredTypeId the primary key for the new travel domestic insured type
	 * @return the new travel domestic insured type
	 */
	@Override
	public TravelDomesticInsuredType create(long travelDomesticInsuredTypeId) {
		TravelDomesticInsuredType travelDomesticInsuredType =
			new TravelDomesticInsuredTypeImpl();

		travelDomesticInsuredType.setNew(true);
		travelDomesticInsuredType.setPrimaryKey(travelDomesticInsuredTypeId);

		travelDomesticInsuredType.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return travelDomesticInsuredType;
	}

	/**
	 * Removes the travel domestic insured type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticInsuredTypeId the primary key of the travel domestic insured type
	 * @return the travel domestic insured type that was removed
	 * @throws NoSuchTravelDomesticInsuredTypeException if a travel domestic insured type with the primary key could not be found
	 */
	@Override
	public TravelDomesticInsuredType remove(long travelDomesticInsuredTypeId)
		throws NoSuchTravelDomesticInsuredTypeException {

		return remove((Serializable)travelDomesticInsuredTypeId);
	}

	/**
	 * Removes the travel domestic insured type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the travel domestic insured type
	 * @return the travel domestic insured type that was removed
	 * @throws NoSuchTravelDomesticInsuredTypeException if a travel domestic insured type with the primary key could not be found
	 */
	@Override
	public TravelDomesticInsuredType remove(Serializable primaryKey)
		throws NoSuchTravelDomesticInsuredTypeException {

		Session session = null;

		try {
			session = openSession();

			TravelDomesticInsuredType travelDomesticInsuredType =
				(TravelDomesticInsuredType)session.get(
					TravelDomesticInsuredTypeImpl.class, primaryKey);

			if (travelDomesticInsuredType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTravelDomesticInsuredTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(travelDomesticInsuredType);
		}
		catch (NoSuchTravelDomesticInsuredTypeException noSuchEntityException) {
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
	protected TravelDomesticInsuredType removeImpl(
		TravelDomesticInsuredType travelDomesticInsuredType) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(travelDomesticInsuredType)) {
				travelDomesticInsuredType =
					(TravelDomesticInsuredType)session.get(
						TravelDomesticInsuredTypeImpl.class,
						travelDomesticInsuredType.getPrimaryKeyObj());
			}

			if (travelDomesticInsuredType != null) {
				session.delete(travelDomesticInsuredType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (travelDomesticInsuredType != null) {
			clearCache(travelDomesticInsuredType);
		}

		return travelDomesticInsuredType;
	}

	@Override
	public TravelDomesticInsuredType updateImpl(
		TravelDomesticInsuredType travelDomesticInsuredType) {

		boolean isNew = travelDomesticInsuredType.isNew();

		if (!(travelDomesticInsuredType instanceof
				TravelDomesticInsuredTypeModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(travelDomesticInsuredType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					travelDomesticInsuredType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in travelDomesticInsuredType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TravelDomesticInsuredType implementation " +
					travelDomesticInsuredType.getClass());
		}

		TravelDomesticInsuredTypeModelImpl travelDomesticInsuredTypeModelImpl =
			(TravelDomesticInsuredTypeModelImpl)travelDomesticInsuredType;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (travelDomesticInsuredType.getCreateDate() == null)) {
			if (serviceContext == null) {
				travelDomesticInsuredType.setCreateDate(date);
			}
			else {
				travelDomesticInsuredType.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!travelDomesticInsuredTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				travelDomesticInsuredType.setModifiedDate(date);
			}
			else {
				travelDomesticInsuredType.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(travelDomesticInsuredType);
			}
			else {
				travelDomesticInsuredType =
					(TravelDomesticInsuredType)session.merge(
						travelDomesticInsuredType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TravelDomesticInsuredTypeImpl.class,
			travelDomesticInsuredTypeModelImpl, false, true);

		if (isNew) {
			travelDomesticInsuredType.setNew(false);
		}

		travelDomesticInsuredType.resetOriginalValues();

		return travelDomesticInsuredType;
	}

	/**
	 * Returns the travel domestic insured type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the travel domestic insured type
	 * @return the travel domestic insured type
	 * @throws NoSuchTravelDomesticInsuredTypeException if a travel domestic insured type with the primary key could not be found
	 */
	@Override
	public TravelDomesticInsuredType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTravelDomesticInsuredTypeException {

		TravelDomesticInsuredType travelDomesticInsuredType = fetchByPrimaryKey(
			primaryKey);

		if (travelDomesticInsuredType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTravelDomesticInsuredTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return travelDomesticInsuredType;
	}

	/**
	 * Returns the travel domestic insured type with the primary key or throws a <code>NoSuchTravelDomesticInsuredTypeException</code> if it could not be found.
	 *
	 * @param travelDomesticInsuredTypeId the primary key of the travel domestic insured type
	 * @return the travel domestic insured type
	 * @throws NoSuchTravelDomesticInsuredTypeException if a travel domestic insured type with the primary key could not be found
	 */
	@Override
	public TravelDomesticInsuredType findByPrimaryKey(
			long travelDomesticInsuredTypeId)
		throws NoSuchTravelDomesticInsuredTypeException {

		return findByPrimaryKey((Serializable)travelDomesticInsuredTypeId);
	}

	/**
	 * Returns the travel domestic insured type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticInsuredTypeId the primary key of the travel domestic insured type
	 * @return the travel domestic insured type, or <code>null</code> if a travel domestic insured type with the primary key could not be found
	 */
	@Override
	public TravelDomesticInsuredType fetchByPrimaryKey(
		long travelDomesticInsuredTypeId) {

		return fetchByPrimaryKey((Serializable)travelDomesticInsuredTypeId);
	}

	/**
	 * Returns all the travel domestic insured types.
	 *
	 * @return the travel domestic insured types
	 */
	@Override
	public List<TravelDomesticInsuredType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel domestic insured types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @return the range of travel domestic insured types
	 */
	@Override
	public List<TravelDomesticInsuredType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel domestic insured types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic insured types
	 */
	@Override
	public List<TravelDomesticInsuredType> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticInsuredType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic insured types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticInsuredTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic insured types
	 * @param end the upper bound of the range of travel domestic insured types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic insured types
	 */
	@Override
	public List<TravelDomesticInsuredType> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticInsuredType> orderByComparator,
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

		List<TravelDomesticInsuredType> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticInsuredType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAVELDOMESTICINSUREDTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAVELDOMESTICINSUREDTYPE;

				sql = sql.concat(
					TravelDomesticInsuredTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TravelDomesticInsuredType>)QueryUtil.list(
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
	 * Removes all the travel domestic insured types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TravelDomesticInsuredType travelDomesticInsuredType : findAll()) {
			remove(travelDomesticInsuredType);
		}
	}

	/**
	 * Returns the number of travel domestic insured types.
	 *
	 * @return the number of travel domestic insured types
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
					_SQL_COUNT_TRAVELDOMESTICINSUREDTYPE);

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
		return "travelDomesticInsuredTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAVELDOMESTICINSUREDTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TravelDomesticInsuredTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the travel domestic insured type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new TravelDomesticInsuredTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", TravelDomesticInsuredType.class.getName()));

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

		_finderPathWithPaginationFindBysearchInsuredType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchInsuredType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"travelDomesticInsuredTypeId", "name", "code_"},
			true);

		_finderPathWithoutPaginationFindBysearchInsuredType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBysearchInsuredType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"travelDomesticInsuredTypeId", "name", "code_"},
			true);

		_finderPathCountBysearchInsuredType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysearchInsuredType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"travelDomesticInsuredTypeId", "name", "code_"},
			false);

		_setTravelDomesticInsuredTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTravelDomesticInsuredTypeUtilPersistence(null);

		entityCache.removeCache(TravelDomesticInsuredTypeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setTravelDomesticInsuredTypeUtilPersistence(
		TravelDomesticInsuredTypePersistence
			travelDomesticInsuredTypePersistence) {

		try {
			Field field = TravelDomesticInsuredTypeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, travelDomesticInsuredTypePersistence);
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

	private static final String _SQL_SELECT_TRAVELDOMESTICINSUREDTYPE =
		"SELECT travelDomesticInsuredType FROM TravelDomesticInsuredType travelDomesticInsuredType";

	private static final String _SQL_SELECT_TRAVELDOMESTICINSUREDTYPE_WHERE =
		"SELECT travelDomesticInsuredType FROM TravelDomesticInsuredType travelDomesticInsuredType WHERE ";

	private static final String _SQL_COUNT_TRAVELDOMESTICINSUREDTYPE =
		"SELECT COUNT(travelDomesticInsuredType) FROM TravelDomesticInsuredType travelDomesticInsuredType";

	private static final String _SQL_COUNT_TRAVELDOMESTICINSUREDTYPE_WHERE =
		"SELECT COUNT(travelDomesticInsuredType) FROM TravelDomesticInsuredType travelDomesticInsuredType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"travelDomesticInsuredType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TravelDomesticInsuredType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TravelDomesticInsuredType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TravelDomesticInsuredTypePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"code", "active"});

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

	private static class TravelDomesticInsuredTypeModelArgumentsResolver
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

			TravelDomesticInsuredTypeModelImpl
				travelDomesticInsuredTypeModelImpl =
					(TravelDomesticInsuredTypeModelImpl)baseModel;

			long columnBitmask =
				travelDomesticInsuredTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					travelDomesticInsuredTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						travelDomesticInsuredTypeModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					travelDomesticInsuredTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			TravelDomesticInsuredTypeModelImpl
				travelDomesticInsuredTypeModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						travelDomesticInsuredTypeModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						travelDomesticInsuredTypeModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}