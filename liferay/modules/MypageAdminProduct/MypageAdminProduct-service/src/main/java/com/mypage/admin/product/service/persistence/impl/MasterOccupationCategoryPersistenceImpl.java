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

import com.mypage.admin.product.exception.NoSuchMasterOccupationCategoryException;
import com.mypage.admin.product.model.MasterOccupationCategory;
import com.mypage.admin.product.model.impl.MasterOccupationCategoryImpl;
import com.mypage.admin.product.model.impl.MasterOccupationCategoryModelImpl;
import com.mypage.admin.product.service.persistence.MasterOccupationCategoryPersistence;
import com.mypage.admin.product.service.persistence.MasterOccupationCategoryUtil;
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
 * The persistence implementation for the master occupation category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = MasterOccupationCategoryPersistence.class)
public class MasterOccupationCategoryPersistenceImpl
	extends BasePersistenceImpl<MasterOccupationCategory>
	implements MasterOccupationCategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MasterOccupationCategoryUtil</code> to access the master occupation category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MasterOccupationCategoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBysearchByActive;
	private FinderPath _finderPathWithoutPaginationFindBysearchByActive;
	private FinderPath _finderPathCountBysearchByActive;

	/**
	 * Returns all the master occupation categories where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching master occupation categories
	 */
	@Override
	public List<MasterOccupationCategory> findBysearchByActive(Integer active) {
		return findBysearchByActive(
			active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master occupation categories where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @return the range of matching master occupation categories
	 */
	@Override
	public List<MasterOccupationCategory> findBysearchByActive(
		Integer active, int start, int end) {

		return findBysearchByActive(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master occupation categories where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master occupation categories
	 */
	@Override
	public List<MasterOccupationCategory> findBysearchByActive(
		Integer active, int start, int end,
		OrderByComparator<MasterOccupationCategory> orderByComparator) {

		return findBysearchByActive(
			active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master occupation categories where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master occupation categories
	 */
	@Override
	public List<MasterOccupationCategory> findBysearchByActive(
		Integer active, int start, int end,
		OrderByComparator<MasterOccupationCategory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBysearchByActive;
				finderArgs = new Object[] {active};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchByActive;
			finderArgs = new Object[] {active, start, end, orderByComparator};
		}

		List<MasterOccupationCategory> list = null;

		if (useFinderCache) {
			list = (List<MasterOccupationCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MasterOccupationCategory masterOccupationCategory : list) {
					if (!Objects.equals(
							active, masterOccupationCategory.getActive())) {

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

			sb.append(_SQL_SELECT_MASTEROCCUPATIONCATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MasterOccupationCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(active.intValue());

				list = (List<MasterOccupationCategory>)QueryUtil.list(
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
	 * Returns the first master occupation category in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation category
	 * @throws NoSuchMasterOccupationCategoryException if a matching master occupation category could not be found
	 */
	@Override
	public MasterOccupationCategory findBysearchByActive_First(
			Integer active,
			OrderByComparator<MasterOccupationCategory> orderByComparator)
		throws NoSuchMasterOccupationCategoryException {

		MasterOccupationCategory masterOccupationCategory =
			fetchBysearchByActive_First(active, orderByComparator);

		if (masterOccupationCategory != null) {
			return masterOccupationCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchMasterOccupationCategoryException(sb.toString());
	}

	/**
	 * Returns the first master occupation category in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master occupation category, or <code>null</code> if a matching master occupation category could not be found
	 */
	@Override
	public MasterOccupationCategory fetchBysearchByActive_First(
		Integer active,
		OrderByComparator<MasterOccupationCategory> orderByComparator) {

		List<MasterOccupationCategory> list = findBysearchByActive(
			active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master occupation category in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation category
	 * @throws NoSuchMasterOccupationCategoryException if a matching master occupation category could not be found
	 */
	@Override
	public MasterOccupationCategory findBysearchByActive_Last(
			Integer active,
			OrderByComparator<MasterOccupationCategory> orderByComparator)
		throws NoSuchMasterOccupationCategoryException {

		MasterOccupationCategory masterOccupationCategory =
			fetchBysearchByActive_Last(active, orderByComparator);

		if (masterOccupationCategory != null) {
			return masterOccupationCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchMasterOccupationCategoryException(sb.toString());
	}

	/**
	 * Returns the last master occupation category in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master occupation category, or <code>null</code> if a matching master occupation category could not be found
	 */
	@Override
	public MasterOccupationCategory fetchBysearchByActive_Last(
		Integer active,
		OrderByComparator<MasterOccupationCategory> orderByComparator) {

		int count = countBysearchByActive(active);

		if (count == 0) {
			return null;
		}

		List<MasterOccupationCategory> list = findBysearchByActive(
			active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master occupation categories before and after the current master occupation category in the ordered set where active = &#63;.
	 *
	 * @param masterOccupationCategoryId the primary key of the current master occupation category
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master occupation category
	 * @throws NoSuchMasterOccupationCategoryException if a master occupation category with the primary key could not be found
	 */
	@Override
	public MasterOccupationCategory[] findBysearchByActive_PrevAndNext(
			long masterOccupationCategoryId, Integer active,
			OrderByComparator<MasterOccupationCategory> orderByComparator)
		throws NoSuchMasterOccupationCategoryException {

		MasterOccupationCategory masterOccupationCategory = findByPrimaryKey(
			masterOccupationCategoryId);

		Session session = null;

		try {
			session = openSession();

			MasterOccupationCategory[] array =
				new MasterOccupationCategoryImpl[3];

			array[0] = getBysearchByActive_PrevAndNext(
				session, masterOccupationCategory, active, orderByComparator,
				true);

			array[1] = masterOccupationCategory;

			array[2] = getBysearchByActive_PrevAndNext(
				session, masterOccupationCategory, active, orderByComparator,
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

	protected MasterOccupationCategory getBysearchByActive_PrevAndNext(
		Session session, MasterOccupationCategory masterOccupationCategory,
		Integer active,
		OrderByComparator<MasterOccupationCategory> orderByComparator,
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

		sb.append(_SQL_SELECT_MASTEROCCUPATIONCATEGORY_WHERE);

		sb.append(_FINDER_COLUMN_SEARCHBYACTIVE_ACTIVE_2);

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
			sb.append(MasterOccupationCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(active.intValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						masterOccupationCategory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MasterOccupationCategory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master occupation categories where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	@Override
	public void removeBysearchByActive(Integer active) {
		for (MasterOccupationCategory masterOccupationCategory :
				findBysearchByActive(
					active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(masterOccupationCategory);
		}
	}

	/**
	 * Returns the number of master occupation categories where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching master occupation categories
	 */
	@Override
	public int countBysearchByActive(Integer active) {
		FinderPath finderPath = _finderPathCountBysearchByActive;

		Object[] finderArgs = new Object[] {active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MASTEROCCUPATIONCATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYACTIVE_ACTIVE_2);

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

	private static final String _FINDER_COLUMN_SEARCHBYACTIVE_ACTIVE_2 =
		"masterOccupationCategory.active = ?";

	private FinderPath _finderPathFetchBysearchName;
	private FinderPath _finderPathCountBysearchName;

	/**
	 * Returns the master occupation category where name = &#63; or throws a <code>NoSuchMasterOccupationCategoryException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching master occupation category
	 * @throws NoSuchMasterOccupationCategoryException if a matching master occupation category could not be found
	 */
	@Override
	public MasterOccupationCategory findBysearchName(String name)
		throws NoSuchMasterOccupationCategoryException {

		MasterOccupationCategory masterOccupationCategory = fetchBysearchName(
			name);

		if (masterOccupationCategory == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMasterOccupationCategoryException(sb.toString());
		}

		return masterOccupationCategory;
	}

	/**
	 * Returns the master occupation category where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching master occupation category, or <code>null</code> if a matching master occupation category could not be found
	 */
	@Override
	public MasterOccupationCategory fetchBysearchName(String name) {
		return fetchBysearchName(name, true);
	}

	/**
	 * Returns the master occupation category where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching master occupation category, or <code>null</code> if a matching master occupation category could not be found
	 */
	@Override
	public MasterOccupationCategory fetchBysearchName(
		String name, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBysearchName, finderArgs, this);
		}

		if (result instanceof MasterOccupationCategory) {
			MasterOccupationCategory masterOccupationCategory =
				(MasterOccupationCategory)result;

			if (!Objects.equals(name, masterOccupationCategory.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MASTEROCCUPATIONCATEGORY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_SEARCHNAME_NAME_2);
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

				List<MasterOccupationCategory> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBysearchName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {name};
							}

							_log.warn(
								"MasterOccupationCategoryPersistenceImpl.fetchBysearchName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MasterOccupationCategory masterOccupationCategory =
						list.get(0);

					result = masterOccupationCategory;

					cacheResult(masterOccupationCategory);
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
			return (MasterOccupationCategory)result;
		}
	}

	/**
	 * Removes the master occupation category where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the master occupation category that was removed
	 */
	@Override
	public MasterOccupationCategory removeBysearchName(String name)
		throws NoSuchMasterOccupationCategoryException {

		MasterOccupationCategory masterOccupationCategory = findBysearchName(
			name);

		return remove(masterOccupationCategory);
	}

	/**
	 * Returns the number of master occupation categories where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching master occupation categories
	 */
	@Override
	public int countBysearchName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountBysearchName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MASTEROCCUPATIONCATEGORY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_SEARCHNAME_NAME_2);
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

	private static final String _FINDER_COLUMN_SEARCHNAME_NAME_2 =
		"masterOccupationCategory.name = ? AND masterOccupationCategory.active=1";

	private static final String _FINDER_COLUMN_SEARCHNAME_NAME_3 =
		"(masterOccupationCategory.name IS NULL OR masterOccupationCategory.name = '') AND masterOccupationCategory.active=1";

	public MasterOccupationCategoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MasterOccupationCategory.class);

		setModelImplClass(MasterOccupationCategoryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the master occupation category in the entity cache if it is enabled.
	 *
	 * @param masterOccupationCategory the master occupation category
	 */
	@Override
	public void cacheResult(MasterOccupationCategory masterOccupationCategory) {
		entityCache.putResult(
			MasterOccupationCategoryImpl.class,
			masterOccupationCategory.getPrimaryKey(), masterOccupationCategory);

		finderCache.putResult(
			_finderPathFetchBysearchName,
			new Object[] {masterOccupationCategory.getName()},
			masterOccupationCategory);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the master occupation categories in the entity cache if it is enabled.
	 *
	 * @param masterOccupationCategories the master occupation categories
	 */
	@Override
	public void cacheResult(
		List<MasterOccupationCategory> masterOccupationCategories) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (masterOccupationCategories.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MasterOccupationCategory masterOccupationCategory :
				masterOccupationCategories) {

			if (entityCache.getResult(
					MasterOccupationCategoryImpl.class,
					masterOccupationCategory.getPrimaryKey()) == null) {

				cacheResult(masterOccupationCategory);
			}
		}
	}

	/**
	 * Clears the cache for all master occupation categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MasterOccupationCategoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the master occupation category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MasterOccupationCategory masterOccupationCategory) {
		entityCache.removeResult(
			MasterOccupationCategoryImpl.class, masterOccupationCategory);
	}

	@Override
	public void clearCache(
		List<MasterOccupationCategory> masterOccupationCategories) {

		for (MasterOccupationCategory masterOccupationCategory :
				masterOccupationCategories) {

			entityCache.removeResult(
				MasterOccupationCategoryImpl.class, masterOccupationCategory);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				MasterOccupationCategoryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		MasterOccupationCategoryModelImpl masterOccupationCategoryModelImpl) {

		Object[] args = new Object[] {
			masterOccupationCategoryModelImpl.getName()
		};

		finderCache.putResult(
			_finderPathCountBysearchName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBysearchName, args,
			masterOccupationCategoryModelImpl, false);
	}

	/**
	 * Creates a new master occupation category with the primary key. Does not add the master occupation category to the database.
	 *
	 * @param masterOccupationCategoryId the primary key for the new master occupation category
	 * @return the new master occupation category
	 */
	@Override
	public MasterOccupationCategory create(long masterOccupationCategoryId) {
		MasterOccupationCategory masterOccupationCategory =
			new MasterOccupationCategoryImpl();

		masterOccupationCategory.setNew(true);
		masterOccupationCategory.setPrimaryKey(masterOccupationCategoryId);

		masterOccupationCategory.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return masterOccupationCategory;
	}

	/**
	 * Removes the master occupation category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterOccupationCategoryId the primary key of the master occupation category
	 * @return the master occupation category that was removed
	 * @throws NoSuchMasterOccupationCategoryException if a master occupation category with the primary key could not be found
	 */
	@Override
	public MasterOccupationCategory remove(long masterOccupationCategoryId)
		throws NoSuchMasterOccupationCategoryException {

		return remove((Serializable)masterOccupationCategoryId);
	}

	/**
	 * Removes the master occupation category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the master occupation category
	 * @return the master occupation category that was removed
	 * @throws NoSuchMasterOccupationCategoryException if a master occupation category with the primary key could not be found
	 */
	@Override
	public MasterOccupationCategory remove(Serializable primaryKey)
		throws NoSuchMasterOccupationCategoryException {

		Session session = null;

		try {
			session = openSession();

			MasterOccupationCategory masterOccupationCategory =
				(MasterOccupationCategory)session.get(
					MasterOccupationCategoryImpl.class, primaryKey);

			if (masterOccupationCategory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasterOccupationCategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(masterOccupationCategory);
		}
		catch (NoSuchMasterOccupationCategoryException noSuchEntityException) {
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
	protected MasterOccupationCategory removeImpl(
		MasterOccupationCategory masterOccupationCategory) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(masterOccupationCategory)) {
				masterOccupationCategory =
					(MasterOccupationCategory)session.get(
						MasterOccupationCategoryImpl.class,
						masterOccupationCategory.getPrimaryKeyObj());
			}

			if (masterOccupationCategory != null) {
				session.delete(masterOccupationCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (masterOccupationCategory != null) {
			clearCache(masterOccupationCategory);
		}

		return masterOccupationCategory;
	}

	@Override
	public MasterOccupationCategory updateImpl(
		MasterOccupationCategory masterOccupationCategory) {

		boolean isNew = masterOccupationCategory.isNew();

		if (!(masterOccupationCategory instanceof
				MasterOccupationCategoryModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(masterOccupationCategory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					masterOccupationCategory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in masterOccupationCategory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MasterOccupationCategory implementation " +
					masterOccupationCategory.getClass());
		}

		MasterOccupationCategoryModelImpl masterOccupationCategoryModelImpl =
			(MasterOccupationCategoryModelImpl)masterOccupationCategory;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (masterOccupationCategory.getCreateDate() == null)) {
			if (serviceContext == null) {
				masterOccupationCategory.setCreateDate(date);
			}
			else {
				masterOccupationCategory.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!masterOccupationCategoryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				masterOccupationCategory.setModifiedDate(date);
			}
			else {
				masterOccupationCategory.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(masterOccupationCategory);
			}
			else {
				masterOccupationCategory =
					(MasterOccupationCategory)session.merge(
						masterOccupationCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MasterOccupationCategoryImpl.class,
			masterOccupationCategoryModelImpl, false, true);

		cacheUniqueFindersCache(masterOccupationCategoryModelImpl);

		if (isNew) {
			masterOccupationCategory.setNew(false);
		}

		masterOccupationCategory.resetOriginalValues();

		return masterOccupationCategory;
	}

	/**
	 * Returns the master occupation category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the master occupation category
	 * @return the master occupation category
	 * @throws NoSuchMasterOccupationCategoryException if a master occupation category with the primary key could not be found
	 */
	@Override
	public MasterOccupationCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMasterOccupationCategoryException {

		MasterOccupationCategory masterOccupationCategory = fetchByPrimaryKey(
			primaryKey);

		if (masterOccupationCategory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasterOccupationCategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return masterOccupationCategory;
	}

	/**
	 * Returns the master occupation category with the primary key or throws a <code>NoSuchMasterOccupationCategoryException</code> if it could not be found.
	 *
	 * @param masterOccupationCategoryId the primary key of the master occupation category
	 * @return the master occupation category
	 * @throws NoSuchMasterOccupationCategoryException if a master occupation category with the primary key could not be found
	 */
	@Override
	public MasterOccupationCategory findByPrimaryKey(
			long masterOccupationCategoryId)
		throws NoSuchMasterOccupationCategoryException {

		return findByPrimaryKey((Serializable)masterOccupationCategoryId);
	}

	/**
	 * Returns the master occupation category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterOccupationCategoryId the primary key of the master occupation category
	 * @return the master occupation category, or <code>null</code> if a master occupation category with the primary key could not be found
	 */
	@Override
	public MasterOccupationCategory fetchByPrimaryKey(
		long masterOccupationCategoryId) {

		return fetchByPrimaryKey((Serializable)masterOccupationCategoryId);
	}

	/**
	 * Returns all the master occupation categories.
	 *
	 * @return the master occupation categories
	 */
	@Override
	public List<MasterOccupationCategory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master occupation categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @return the range of master occupation categories
	 */
	@Override
	public List<MasterOccupationCategory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the master occupation categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master occupation categories
	 */
	@Override
	public List<MasterOccupationCategory> findAll(
		int start, int end,
		OrderByComparator<MasterOccupationCategory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master occupation categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterOccupationCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master occupation categories
	 * @param end the upper bound of the range of master occupation categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master occupation categories
	 */
	@Override
	public List<MasterOccupationCategory> findAll(
		int start, int end,
		OrderByComparator<MasterOccupationCategory> orderByComparator,
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

		List<MasterOccupationCategory> list = null;

		if (useFinderCache) {
			list = (List<MasterOccupationCategory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MASTEROCCUPATIONCATEGORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MASTEROCCUPATIONCATEGORY;

				sql = sql.concat(
					MasterOccupationCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MasterOccupationCategory>)QueryUtil.list(
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
	 * Removes all the master occupation categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MasterOccupationCategory masterOccupationCategory : findAll()) {
			remove(masterOccupationCategory);
		}
	}

	/**
	 * Returns the number of master occupation categories.
	 *
	 * @return the number of master occupation categories
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
					_SQL_COUNT_MASTEROCCUPATIONCATEGORY);

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
		return "masterOccupationCategoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MASTEROCCUPATIONCATEGORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MasterOccupationCategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the master occupation category persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new MasterOccupationCategoryModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MasterOccupationCategory.class.getName()));

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

		_finderPathWithPaginationFindBysearchByActive = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchByActive",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"active_"}, true);

		_finderPathWithoutPaginationFindBysearchByActive = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysearchByActive",
			new String[] {Integer.class.getName()}, new String[] {"active_"},
			true);

		_finderPathCountBysearchByActive = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchByActive",
			new String[] {Integer.class.getName()}, new String[] {"active_"},
			false);

		_finderPathFetchBysearchName = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBysearchName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountBysearchName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_setMasterOccupationCategoryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMasterOccupationCategoryUtilPersistence(null);

		entityCache.removeCache(MasterOccupationCategoryImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setMasterOccupationCategoryUtilPersistence(
		MasterOccupationCategoryPersistence
			masterOccupationCategoryPersistence) {

		try {
			Field field = MasterOccupationCategoryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, masterOccupationCategoryPersistence);
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

	private static final String _SQL_SELECT_MASTEROCCUPATIONCATEGORY =
		"SELECT masterOccupationCategory FROM MasterOccupationCategory masterOccupationCategory";

	private static final String _SQL_SELECT_MASTEROCCUPATIONCATEGORY_WHERE =
		"SELECT masterOccupationCategory FROM MasterOccupationCategory masterOccupationCategory WHERE ";

	private static final String _SQL_COUNT_MASTEROCCUPATIONCATEGORY =
		"SELECT COUNT(masterOccupationCategory) FROM MasterOccupationCategory masterOccupationCategory";

	private static final String _SQL_COUNT_MASTEROCCUPATIONCATEGORY_WHERE =
		"SELECT COUNT(masterOccupationCategory) FROM MasterOccupationCategory masterOccupationCategory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"masterOccupationCategory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MasterOccupationCategory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MasterOccupationCategory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MasterOccupationCategoryPersistenceImpl.class);

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

	private static class MasterOccupationCategoryModelArgumentsResolver
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

			MasterOccupationCategoryModelImpl
				masterOccupationCategoryModelImpl =
					(MasterOccupationCategoryModelImpl)baseModel;

			long columnBitmask =
				masterOccupationCategoryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					masterOccupationCategoryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						masterOccupationCategoryModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					masterOccupationCategoryModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			MasterOccupationCategoryModelImpl masterOccupationCategoryModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						masterOccupationCategoryModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						masterOccupationCategoryModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}