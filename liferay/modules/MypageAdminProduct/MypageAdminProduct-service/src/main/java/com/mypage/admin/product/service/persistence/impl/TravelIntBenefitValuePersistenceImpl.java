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

import com.mypage.admin.product.exception.NoSuchTravelIntBenefitValueException;
import com.mypage.admin.product.model.TravelIntBenefitValue;
import com.mypage.admin.product.model.impl.TravelIntBenefitValueImpl;
import com.mypage.admin.product.model.impl.TravelIntBenefitValueModelImpl;
import com.mypage.admin.product.service.persistence.TravelIntBenefitValuePersistence;
import com.mypage.admin.product.service.persistence.TravelIntBenefitValueUtil;
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
 * The persistence implementation for the travel int benefit value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = TravelIntBenefitValuePersistence.class)
public class TravelIntBenefitValuePersistenceImpl
	extends BasePersistenceImpl<TravelIntBenefitValue>
	implements TravelIntBenefitValuePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TravelIntBenefitValueUtil</code> to access the travel int benefit value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TravelIntBenefitValueImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByPackageType;
	private FinderPath _finderPathWithoutPaginationFindByPackageType;
	private FinderPath _finderPathCountByPackageType;

	/**
	 * Returns all the travel int benefit values where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @return the matching travel int benefit values
	 */
	@Override
	public List<TravelIntBenefitValue> findByPackageType(String packageType) {
		return findByPackageType(
			packageType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel int benefit values where packageType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param packageType the package type
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @return the range of matching travel int benefit values
	 */
	@Override
	public List<TravelIntBenefitValue> findByPackageType(
		String packageType, int start, int end) {

		return findByPackageType(packageType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel int benefit values where packageType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param packageType the package type
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel int benefit values
	 */
	@Override
	public List<TravelIntBenefitValue> findByPackageType(
		String packageType, int start, int end,
		OrderByComparator<TravelIntBenefitValue> orderByComparator) {

		return findByPackageType(
			packageType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel int benefit values where packageType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param packageType the package type
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel int benefit values
	 */
	@Override
	public List<TravelIntBenefitValue> findByPackageType(
		String packageType, int start, int end,
		OrderByComparator<TravelIntBenefitValue> orderByComparator,
		boolean useFinderCache) {

		packageType = Objects.toString(packageType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPackageType;
				finderArgs = new Object[] {packageType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPackageType;
			finderArgs = new Object[] {
				packageType, start, end, orderByComparator
			};
		}

		List<TravelIntBenefitValue> list = null;

		if (useFinderCache) {
			list = (List<TravelIntBenefitValue>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelIntBenefitValue travelIntBenefitValue : list) {
					if (!packageType.equals(
							travelIntBenefitValue.getPackageType())) {

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

			sb.append(_SQL_SELECT_TRAVELINTBENEFITVALUE_WHERE);

			boolean bindPackageType = false;

			if (packageType.isEmpty()) {
				sb.append(_FINDER_COLUMN_PACKAGETYPE_PACKAGETYPE_3);
			}
			else {
				bindPackageType = true;

				sb.append(_FINDER_COLUMN_PACKAGETYPE_PACKAGETYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelIntBenefitValueModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPackageType) {
					queryPos.add(packageType);
				}

				list = (List<TravelIntBenefitValue>)QueryUtil.list(
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
	 * Returns the first travel int benefit value in the ordered set where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel int benefit value
	 * @throws NoSuchTravelIntBenefitValueException if a matching travel int benefit value could not be found
	 */
	@Override
	public TravelIntBenefitValue findByPackageType_First(
			String packageType,
			OrderByComparator<TravelIntBenefitValue> orderByComparator)
		throws NoSuchTravelIntBenefitValueException {

		TravelIntBenefitValue travelIntBenefitValue = fetchByPackageType_First(
			packageType, orderByComparator);

		if (travelIntBenefitValue != null) {
			return travelIntBenefitValue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("packageType=");
		sb.append(packageType);

		sb.append("}");

		throw new NoSuchTravelIntBenefitValueException(sb.toString());
	}

	/**
	 * Returns the first travel int benefit value in the ordered set where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel int benefit value, or <code>null</code> if a matching travel int benefit value could not be found
	 */
	@Override
	public TravelIntBenefitValue fetchByPackageType_First(
		String packageType,
		OrderByComparator<TravelIntBenefitValue> orderByComparator) {

		List<TravelIntBenefitValue> list = findByPackageType(
			packageType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel int benefit value in the ordered set where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel int benefit value
	 * @throws NoSuchTravelIntBenefitValueException if a matching travel int benefit value could not be found
	 */
	@Override
	public TravelIntBenefitValue findByPackageType_Last(
			String packageType,
			OrderByComparator<TravelIntBenefitValue> orderByComparator)
		throws NoSuchTravelIntBenefitValueException {

		TravelIntBenefitValue travelIntBenefitValue = fetchByPackageType_Last(
			packageType, orderByComparator);

		if (travelIntBenefitValue != null) {
			return travelIntBenefitValue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("packageType=");
		sb.append(packageType);

		sb.append("}");

		throw new NoSuchTravelIntBenefitValueException(sb.toString());
	}

	/**
	 * Returns the last travel int benefit value in the ordered set where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel int benefit value, or <code>null</code> if a matching travel int benefit value could not be found
	 */
	@Override
	public TravelIntBenefitValue fetchByPackageType_Last(
		String packageType,
		OrderByComparator<TravelIntBenefitValue> orderByComparator) {

		int count = countByPackageType(packageType);

		if (count == 0) {
			return null;
		}

		List<TravelIntBenefitValue> list = findByPackageType(
			packageType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the travel int benefit values before and after the current travel int benefit value in the ordered set where packageType = &#63;.
	 *
	 * @param travelIntBenefitValueId the primary key of the current travel int benefit value
	 * @param packageType the package type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next travel int benefit value
	 * @throws NoSuchTravelIntBenefitValueException if a travel int benefit value with the primary key could not be found
	 */
	@Override
	public TravelIntBenefitValue[] findByPackageType_PrevAndNext(
			long travelIntBenefitValueId, String packageType,
			OrderByComparator<TravelIntBenefitValue> orderByComparator)
		throws NoSuchTravelIntBenefitValueException {

		packageType = Objects.toString(packageType, "");

		TravelIntBenefitValue travelIntBenefitValue = findByPrimaryKey(
			travelIntBenefitValueId);

		Session session = null;

		try {
			session = openSession();

			TravelIntBenefitValue[] array = new TravelIntBenefitValueImpl[3];

			array[0] = getByPackageType_PrevAndNext(
				session, travelIntBenefitValue, packageType, orderByComparator,
				true);

			array[1] = travelIntBenefitValue;

			array[2] = getByPackageType_PrevAndNext(
				session, travelIntBenefitValue, packageType, orderByComparator,
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

	protected TravelIntBenefitValue getByPackageType_PrevAndNext(
		Session session, TravelIntBenefitValue travelIntBenefitValue,
		String packageType,
		OrderByComparator<TravelIntBenefitValue> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRAVELINTBENEFITVALUE_WHERE);

		boolean bindPackageType = false;

		if (packageType.isEmpty()) {
			sb.append(_FINDER_COLUMN_PACKAGETYPE_PACKAGETYPE_3);
		}
		else {
			bindPackageType = true;

			sb.append(_FINDER_COLUMN_PACKAGETYPE_PACKAGETYPE_2);
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
			sb.append(TravelIntBenefitValueModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPackageType) {
			queryPos.add(packageType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						travelIntBenefitValue)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TravelIntBenefitValue> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the travel int benefit values where packageType = &#63; from the database.
	 *
	 * @param packageType the package type
	 */
	@Override
	public void removeByPackageType(String packageType) {
		for (TravelIntBenefitValue travelIntBenefitValue :
				findByPackageType(
					packageType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(travelIntBenefitValue);
		}
	}

	/**
	 * Returns the number of travel int benefit values where packageType = &#63;.
	 *
	 * @param packageType the package type
	 * @return the number of matching travel int benefit values
	 */
	@Override
	public int countByPackageType(String packageType) {
		packageType = Objects.toString(packageType, "");

		FinderPath finderPath = _finderPathCountByPackageType;

		Object[] finderArgs = new Object[] {packageType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAVELINTBENEFITVALUE_WHERE);

			boolean bindPackageType = false;

			if (packageType.isEmpty()) {
				sb.append(_FINDER_COLUMN_PACKAGETYPE_PACKAGETYPE_3);
			}
			else {
				bindPackageType = true;

				sb.append(_FINDER_COLUMN_PACKAGETYPE_PACKAGETYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPackageType) {
					queryPos.add(packageType);
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

	private static final String _FINDER_COLUMN_PACKAGETYPE_PACKAGETYPE_2 =
		"travelIntBenefitValue.packageType = ?";

	private static final String _FINDER_COLUMN_PACKAGETYPE_PACKAGETYPE_3 =
		"(travelIntBenefitValue.packageType IS NULL OR travelIntBenefitValue.packageType = '')";

	public TravelIntBenefitValuePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TravelIntBenefitValue.class);

		setModelImplClass(TravelIntBenefitValueImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the travel int benefit value in the entity cache if it is enabled.
	 *
	 * @param travelIntBenefitValue the travel int benefit value
	 */
	@Override
	public void cacheResult(TravelIntBenefitValue travelIntBenefitValue) {
		entityCache.putResult(
			TravelIntBenefitValueImpl.class,
			travelIntBenefitValue.getPrimaryKey(), travelIntBenefitValue);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the travel int benefit values in the entity cache if it is enabled.
	 *
	 * @param travelIntBenefitValues the travel int benefit values
	 */
	@Override
	public void cacheResult(
		List<TravelIntBenefitValue> travelIntBenefitValues) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (travelIntBenefitValues.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TravelIntBenefitValue travelIntBenefitValue :
				travelIntBenefitValues) {

			if (entityCache.getResult(
					TravelIntBenefitValueImpl.class,
					travelIntBenefitValue.getPrimaryKey()) == null) {

				cacheResult(travelIntBenefitValue);
			}
		}
	}

	/**
	 * Clears the cache for all travel int benefit values.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TravelIntBenefitValueImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the travel int benefit value.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TravelIntBenefitValue travelIntBenefitValue) {
		entityCache.removeResult(
			TravelIntBenefitValueImpl.class, travelIntBenefitValue);
	}

	@Override
	public void clearCache(List<TravelIntBenefitValue> travelIntBenefitValues) {
		for (TravelIntBenefitValue travelIntBenefitValue :
				travelIntBenefitValues) {

			entityCache.removeResult(
				TravelIntBenefitValueImpl.class, travelIntBenefitValue);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				TravelIntBenefitValueImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new travel int benefit value with the primary key. Does not add the travel int benefit value to the database.
	 *
	 * @param travelIntBenefitValueId the primary key for the new travel int benefit value
	 * @return the new travel int benefit value
	 */
	@Override
	public TravelIntBenefitValue create(long travelIntBenefitValueId) {
		TravelIntBenefitValue travelIntBenefitValue =
			new TravelIntBenefitValueImpl();

		travelIntBenefitValue.setNew(true);
		travelIntBenefitValue.setPrimaryKey(travelIntBenefitValueId);

		travelIntBenefitValue.setCompanyId(CompanyThreadLocal.getCompanyId());

		return travelIntBenefitValue;
	}

	/**
	 * Removes the travel int benefit value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelIntBenefitValueId the primary key of the travel int benefit value
	 * @return the travel int benefit value that was removed
	 * @throws NoSuchTravelIntBenefitValueException if a travel int benefit value with the primary key could not be found
	 */
	@Override
	public TravelIntBenefitValue remove(long travelIntBenefitValueId)
		throws NoSuchTravelIntBenefitValueException {

		return remove((Serializable)travelIntBenefitValueId);
	}

	/**
	 * Removes the travel int benefit value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the travel int benefit value
	 * @return the travel int benefit value that was removed
	 * @throws NoSuchTravelIntBenefitValueException if a travel int benefit value with the primary key could not be found
	 */
	@Override
	public TravelIntBenefitValue remove(Serializable primaryKey)
		throws NoSuchTravelIntBenefitValueException {

		Session session = null;

		try {
			session = openSession();

			TravelIntBenefitValue travelIntBenefitValue =
				(TravelIntBenefitValue)session.get(
					TravelIntBenefitValueImpl.class, primaryKey);

			if (travelIntBenefitValue == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTravelIntBenefitValueException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(travelIntBenefitValue);
		}
		catch (NoSuchTravelIntBenefitValueException noSuchEntityException) {
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
	protected TravelIntBenefitValue removeImpl(
		TravelIntBenefitValue travelIntBenefitValue) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(travelIntBenefitValue)) {
				travelIntBenefitValue = (TravelIntBenefitValue)session.get(
					TravelIntBenefitValueImpl.class,
					travelIntBenefitValue.getPrimaryKeyObj());
			}

			if (travelIntBenefitValue != null) {
				session.delete(travelIntBenefitValue);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (travelIntBenefitValue != null) {
			clearCache(travelIntBenefitValue);
		}

		return travelIntBenefitValue;
	}

	@Override
	public TravelIntBenefitValue updateImpl(
		TravelIntBenefitValue travelIntBenefitValue) {

		boolean isNew = travelIntBenefitValue.isNew();

		if (!(travelIntBenefitValue instanceof
				TravelIntBenefitValueModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(travelIntBenefitValue.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					travelIntBenefitValue);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in travelIntBenefitValue proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TravelIntBenefitValue implementation " +
					travelIntBenefitValue.getClass());
		}

		TravelIntBenefitValueModelImpl travelIntBenefitValueModelImpl =
			(TravelIntBenefitValueModelImpl)travelIntBenefitValue;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (travelIntBenefitValue.getCreateDate() == null)) {
			if (serviceContext == null) {
				travelIntBenefitValue.setCreateDate(date);
			}
			else {
				travelIntBenefitValue.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!travelIntBenefitValueModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				travelIntBenefitValue.setModifiedDate(date);
			}
			else {
				travelIntBenefitValue.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(travelIntBenefitValue);
			}
			else {
				travelIntBenefitValue = (TravelIntBenefitValue)session.merge(
					travelIntBenefitValue);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TravelIntBenefitValueImpl.class, travelIntBenefitValueModelImpl,
			false, true);

		if (isNew) {
			travelIntBenefitValue.setNew(false);
		}

		travelIntBenefitValue.resetOriginalValues();

		return travelIntBenefitValue;
	}

	/**
	 * Returns the travel int benefit value with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the travel int benefit value
	 * @return the travel int benefit value
	 * @throws NoSuchTravelIntBenefitValueException if a travel int benefit value with the primary key could not be found
	 */
	@Override
	public TravelIntBenefitValue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTravelIntBenefitValueException {

		TravelIntBenefitValue travelIntBenefitValue = fetchByPrimaryKey(
			primaryKey);

		if (travelIntBenefitValue == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTravelIntBenefitValueException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return travelIntBenefitValue;
	}

	/**
	 * Returns the travel int benefit value with the primary key or throws a <code>NoSuchTravelIntBenefitValueException</code> if it could not be found.
	 *
	 * @param travelIntBenefitValueId the primary key of the travel int benefit value
	 * @return the travel int benefit value
	 * @throws NoSuchTravelIntBenefitValueException if a travel int benefit value with the primary key could not be found
	 */
	@Override
	public TravelIntBenefitValue findByPrimaryKey(long travelIntBenefitValueId)
		throws NoSuchTravelIntBenefitValueException {

		return findByPrimaryKey((Serializable)travelIntBenefitValueId);
	}

	/**
	 * Returns the travel int benefit value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelIntBenefitValueId the primary key of the travel int benefit value
	 * @return the travel int benefit value, or <code>null</code> if a travel int benefit value with the primary key could not be found
	 */
	@Override
	public TravelIntBenefitValue fetchByPrimaryKey(
		long travelIntBenefitValueId) {

		return fetchByPrimaryKey((Serializable)travelIntBenefitValueId);
	}

	/**
	 * Returns all the travel int benefit values.
	 *
	 * @return the travel int benefit values
	 */
	@Override
	public List<TravelIntBenefitValue> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel int benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @return the range of travel int benefit values
	 */
	@Override
	public List<TravelIntBenefitValue> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel int benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel int benefit values
	 */
	@Override
	public List<TravelIntBenefitValue> findAll(
		int start, int end,
		OrderByComparator<TravelIntBenefitValue> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel int benefit values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelIntBenefitValueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel int benefit values
	 * @param end the upper bound of the range of travel int benefit values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel int benefit values
	 */
	@Override
	public List<TravelIntBenefitValue> findAll(
		int start, int end,
		OrderByComparator<TravelIntBenefitValue> orderByComparator,
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

		List<TravelIntBenefitValue> list = null;

		if (useFinderCache) {
			list = (List<TravelIntBenefitValue>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAVELINTBENEFITVALUE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAVELINTBENEFITVALUE;

				sql = sql.concat(TravelIntBenefitValueModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TravelIntBenefitValue>)QueryUtil.list(
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
	 * Removes all the travel int benefit values from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TravelIntBenefitValue travelIntBenefitValue : findAll()) {
			remove(travelIntBenefitValue);
		}
	}

	/**
	 * Returns the number of travel int benefit values.
	 *
	 * @return the number of travel int benefit values
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
					_SQL_COUNT_TRAVELINTBENEFITVALUE);

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
		return "travelIntBenefitValueId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAVELINTBENEFITVALUE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TravelIntBenefitValueModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the travel int benefit value persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new TravelIntBenefitValueModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", TravelIntBenefitValue.class.getName()));

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

		_finderPathWithPaginationFindByPackageType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPackageType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"packageType"}, true);

		_finderPathWithoutPaginationFindByPackageType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPackageType",
			new String[] {String.class.getName()}, new String[] {"packageType"},
			true);

		_finderPathCountByPackageType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPackageType",
			new String[] {String.class.getName()}, new String[] {"packageType"},
			false);

		_setTravelIntBenefitValueUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTravelIntBenefitValueUtilPersistence(null);

		entityCache.removeCache(TravelIntBenefitValueImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setTravelIntBenefitValueUtilPersistence(
		TravelIntBenefitValuePersistence travelIntBenefitValuePersistence) {

		try {
			Field field = TravelIntBenefitValueUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, travelIntBenefitValuePersistence);
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

	private static final String _SQL_SELECT_TRAVELINTBENEFITVALUE =
		"SELECT travelIntBenefitValue FROM TravelIntBenefitValue travelIntBenefitValue";

	private static final String _SQL_SELECT_TRAVELINTBENEFITVALUE_WHERE =
		"SELECT travelIntBenefitValue FROM TravelIntBenefitValue travelIntBenefitValue WHERE ";

	private static final String _SQL_COUNT_TRAVELINTBENEFITVALUE =
		"SELECT COUNT(travelIntBenefitValue) FROM TravelIntBenefitValue travelIntBenefitValue";

	private static final String _SQL_COUNT_TRAVELINTBENEFITVALUE_WHERE =
		"SELECT COUNT(travelIntBenefitValue) FROM TravelIntBenefitValue travelIntBenefitValue WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"travelIntBenefitValue.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TravelIntBenefitValue exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TravelIntBenefitValue exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TravelIntBenefitValuePersistenceImpl.class);

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

	private static class TravelIntBenefitValueModelArgumentsResolver
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

			TravelIntBenefitValueModelImpl travelIntBenefitValueModelImpl =
				(TravelIntBenefitValueModelImpl)baseModel;

			long columnBitmask =
				travelIntBenefitValueModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					travelIntBenefitValueModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						travelIntBenefitValueModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					travelIntBenefitValueModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			TravelIntBenefitValueModelImpl travelIntBenefitValueModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						travelIntBenefitValueModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						travelIntBenefitValueModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}