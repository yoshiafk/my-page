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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.mypage.admin.product.exception.NoSuchTravelDomesticBenefitGroupException;
import com.mypage.admin.product.model.TravelDomesticBenefitGroup;
import com.mypage.admin.product.model.impl.TravelDomesticBenefitGroupImpl;
import com.mypage.admin.product.model.impl.TravelDomesticBenefitGroupModelImpl;
import com.mypage.admin.product.service.persistence.TravelDomesticBenefitGroupPersistence;
import com.mypage.admin.product.service.persistence.TravelDomesticBenefitGroupUtil;
import com.mypage.admin.product.service.persistence.impl.constants.MPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the travel domestic benefit group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = TravelDomesticBenefitGroupPersistence.class)
public class TravelDomesticBenefitGroupPersistenceImpl
	extends BasePersistenceImpl<TravelDomesticBenefitGroup>
	implements TravelDomesticBenefitGroupPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TravelDomesticBenefitGroupUtil</code> to access the travel domestic benefit group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TravelDomesticBenefitGroupImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath
		_finderPathWithPaginationFindBysearchTravelDomesticBenefitGroupId;
	private FinderPath
		_finderPathWithoutPaginationFindBysearchTravelDomesticBenefitGroupId;
	private FinderPath _finderPathCountBysearchTravelDomesticBenefitGroupId;

	/**
	 * Returns all the travel domestic benefit groups where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @return the matching travel domestic benefit groups
	 */
	@Override
	public List<TravelDomesticBenefitGroup>
		findBysearchTravelDomesticBenefitGroupId(
			long travelDomesticBenefitGroupId) {

		return findBysearchTravelDomesticBenefitGroupId(
			travelDomesticBenefitGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the travel domestic benefit groups where travelDomesticBenefitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @return the range of matching travel domestic benefit groups
	 */
	@Override
	public List<TravelDomesticBenefitGroup>
		findBysearchTravelDomesticBenefitGroupId(
			long travelDomesticBenefitGroupId, int start, int end) {

		return findBysearchTravelDomesticBenefitGroupId(
			travelDomesticBenefitGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefit groups where travelDomesticBenefitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic benefit groups
	 */
	@Override
	public List<TravelDomesticBenefitGroup>
		findBysearchTravelDomesticBenefitGroupId(
			long travelDomesticBenefitGroupId, int start, int end,
			OrderByComparator<TravelDomesticBenefitGroup> orderByComparator) {

		return findBysearchTravelDomesticBenefitGroupId(
			travelDomesticBenefitGroupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefit groups where travelDomesticBenefitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic benefit groups
	 */
	@Override
	public List<TravelDomesticBenefitGroup>
		findBysearchTravelDomesticBenefitGroupId(
			long travelDomesticBenefitGroupId, int start, int end,
			OrderByComparator<TravelDomesticBenefitGroup> orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBysearchTravelDomesticBenefitGroupId;
				finderArgs = new Object[] {travelDomesticBenefitGroupId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBysearchTravelDomesticBenefitGroupId;
			finderArgs = new Object[] {
				travelDomesticBenefitGroupId, start, end, orderByComparator
			};
		}

		List<TravelDomesticBenefitGroup> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticBenefitGroup>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelDomesticBenefitGroup travelDomesticBenefitGroup :
						list) {

					if (travelDomesticBenefitGroupId !=
							travelDomesticBenefitGroup.
								getTravelDomesticBenefitGroupId()) {

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

			sb.append(_SQL_SELECT_TRAVELDOMESTICBENEFITGROUP_WHERE);

			sb.append(
				_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITGROUPID_TRAVELDOMESTICBENEFITGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelDomesticBenefitGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(travelDomesticBenefitGroupId);

				list = (List<TravelDomesticBenefitGroup>)QueryUtil.list(
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
	 * Returns the first travel domestic benefit group in the ordered set where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit group
	 * @throws NoSuchTravelDomesticBenefitGroupException if a matching travel domestic benefit group could not be found
	 */
	@Override
	public TravelDomesticBenefitGroup
			findBysearchTravelDomesticBenefitGroupId_First(
				long travelDomesticBenefitGroupId,
				OrderByComparator<TravelDomesticBenefitGroup> orderByComparator)
		throws NoSuchTravelDomesticBenefitGroupException {

		TravelDomesticBenefitGroup travelDomesticBenefitGroup =
			fetchBysearchTravelDomesticBenefitGroupId_First(
				travelDomesticBenefitGroupId, orderByComparator);

		if (travelDomesticBenefitGroup != null) {
			return travelDomesticBenefitGroup;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelDomesticBenefitGroupId=");
		sb.append(travelDomesticBenefitGroupId);

		sb.append("}");

		throw new NoSuchTravelDomesticBenefitGroupException(sb.toString());
	}

	/**
	 * Returns the first travel domestic benefit group in the ordered set where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic benefit group, or <code>null</code> if a matching travel domestic benefit group could not be found
	 */
	@Override
	public TravelDomesticBenefitGroup
		fetchBysearchTravelDomesticBenefitGroupId_First(
			long travelDomesticBenefitGroupId,
			OrderByComparator<TravelDomesticBenefitGroup> orderByComparator) {

		List<TravelDomesticBenefitGroup> list =
			findBysearchTravelDomesticBenefitGroupId(
				travelDomesticBenefitGroupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel domestic benefit group in the ordered set where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit group
	 * @throws NoSuchTravelDomesticBenefitGroupException if a matching travel domestic benefit group could not be found
	 */
	@Override
	public TravelDomesticBenefitGroup
			findBysearchTravelDomesticBenefitGroupId_Last(
				long travelDomesticBenefitGroupId,
				OrderByComparator<TravelDomesticBenefitGroup> orderByComparator)
		throws NoSuchTravelDomesticBenefitGroupException {

		TravelDomesticBenefitGroup travelDomesticBenefitGroup =
			fetchBysearchTravelDomesticBenefitGroupId_Last(
				travelDomesticBenefitGroupId, orderByComparator);

		if (travelDomesticBenefitGroup != null) {
			return travelDomesticBenefitGroup;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelDomesticBenefitGroupId=");
		sb.append(travelDomesticBenefitGroupId);

		sb.append("}");

		throw new NoSuchTravelDomesticBenefitGroupException(sb.toString());
	}

	/**
	 * Returns the last travel domestic benefit group in the ordered set where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic benefit group, or <code>null</code> if a matching travel domestic benefit group could not be found
	 */
	@Override
	public TravelDomesticBenefitGroup
		fetchBysearchTravelDomesticBenefitGroupId_Last(
			long travelDomesticBenefitGroupId,
			OrderByComparator<TravelDomesticBenefitGroup> orderByComparator) {

		int count = countBysearchTravelDomesticBenefitGroupId(
			travelDomesticBenefitGroupId);

		if (count == 0) {
			return null;
		}

		List<TravelDomesticBenefitGroup> list =
			findBysearchTravelDomesticBenefitGroupId(
				travelDomesticBenefitGroupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the travel domestic benefit groups where travelDomesticBenefitGroupId = &#63; from the database.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 */
	@Override
	public void removeBysearchTravelDomesticBenefitGroupId(
		long travelDomesticBenefitGroupId) {

		for (TravelDomesticBenefitGroup travelDomesticBenefitGroup :
				findBysearchTravelDomesticBenefitGroupId(
					travelDomesticBenefitGroupId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(travelDomesticBenefitGroup);
		}
	}

	/**
	 * Returns the number of travel domestic benefit groups where travelDomesticBenefitGroupId = &#63;.
	 *
	 * @param travelDomesticBenefitGroupId the travel domestic benefit group ID
	 * @return the number of matching travel domestic benefit groups
	 */
	@Override
	public int countBysearchTravelDomesticBenefitGroupId(
		long travelDomesticBenefitGroupId) {

		FinderPath finderPath =
			_finderPathCountBysearchTravelDomesticBenefitGroupId;

		Object[] finderArgs = new Object[] {travelDomesticBenefitGroupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAVELDOMESTICBENEFITGROUP_WHERE);

			sb.append(
				_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITGROUPID_TRAVELDOMESTICBENEFITGROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(travelDomesticBenefitGroupId);

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
		_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITGROUPID_TRAVELDOMESTICBENEFITGROUPID_2 =
			"travelDomesticBenefitGroup.travelDomesticBenefitGroupId = ?";

	private FinderPath _finderPathFetchBysearchTravelDomesticBenefitGroupCode;
	private FinderPath _finderPathCountBysearchTravelDomesticBenefitGroupCode;

	/**
	 * Returns the travel domestic benefit group where code = &#63; or throws a <code>NoSuchTravelDomesticBenefitGroupException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching travel domestic benefit group
	 * @throws NoSuchTravelDomesticBenefitGroupException if a matching travel domestic benefit group could not be found
	 */
	@Override
	public TravelDomesticBenefitGroup
			findBysearchTravelDomesticBenefitGroupCode(String code)
		throws NoSuchTravelDomesticBenefitGroupException {

		TravelDomesticBenefitGroup travelDomesticBenefitGroup =
			fetchBysearchTravelDomesticBenefitGroupCode(code);

		if (travelDomesticBenefitGroup == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("code=");
			sb.append(code);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTravelDomesticBenefitGroupException(sb.toString());
		}

		return travelDomesticBenefitGroup;
	}

	/**
	 * Returns the travel domestic benefit group where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching travel domestic benefit group, or <code>null</code> if a matching travel domestic benefit group could not be found
	 */
	@Override
	public TravelDomesticBenefitGroup
		fetchBysearchTravelDomesticBenefitGroupCode(String code) {

		return fetchBysearchTravelDomesticBenefitGroupCode(code, true);
	}

	/**
	 * Returns the travel domestic benefit group where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching travel domestic benefit group, or <code>null</code> if a matching travel domestic benefit group could not be found
	 */
	@Override
	public TravelDomesticBenefitGroup
		fetchBysearchTravelDomesticBenefitGroupCode(
			String code, boolean useFinderCache) {

		code = Objects.toString(code, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {code};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBysearchTravelDomesticBenefitGroupCode,
				finderArgs, this);
		}

		if (result instanceof TravelDomesticBenefitGroup) {
			TravelDomesticBenefitGroup travelDomesticBenefitGroup =
				(TravelDomesticBenefitGroup)result;

			if (!Objects.equals(code, travelDomesticBenefitGroup.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_TRAVELDOMESTICBENEFITGROUP_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITGROUPCODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(
					_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITGROUPCODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
				}

				List<TravelDomesticBenefitGroup> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBysearchTravelDomesticBenefitGroupCode,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {code};
							}

							_log.warn(
								"TravelDomesticBenefitGroupPersistenceImpl.fetchBysearchTravelDomesticBenefitGroupCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TravelDomesticBenefitGroup travelDomesticBenefitGroup =
						list.get(0);

					result = travelDomesticBenefitGroup;

					cacheResult(travelDomesticBenefitGroup);
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
			return (TravelDomesticBenefitGroup)result;
		}
	}

	/**
	 * Removes the travel domestic benefit group where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the travel domestic benefit group that was removed
	 */
	@Override
	public TravelDomesticBenefitGroup
			removeBysearchTravelDomesticBenefitGroupCode(String code)
		throws NoSuchTravelDomesticBenefitGroupException {

		TravelDomesticBenefitGroup travelDomesticBenefitGroup =
			findBysearchTravelDomesticBenefitGroupCode(code);

		return remove(travelDomesticBenefitGroup);
	}

	/**
	 * Returns the number of travel domestic benefit groups where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching travel domestic benefit groups
	 */
	@Override
	public int countBysearchTravelDomesticBenefitGroupCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath =
			_finderPathCountBysearchTravelDomesticBenefitGroupCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAVELDOMESTICBENEFITGROUP_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITGROUPCODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(
					_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITGROUPCODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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
		_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITGROUPCODE_CODE_2 =
			"travelDomesticBenefitGroup.code = ?";

	private static final String
		_FINDER_COLUMN_SEARCHTRAVELDOMESTICBENEFITGROUPCODE_CODE_3 =
			"(travelDomesticBenefitGroup.code IS NULL OR travelDomesticBenefitGroup.code = '')";

	public TravelDomesticBenefitGroupPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TravelDomesticBenefitGroup.class);

		setModelImplClass(TravelDomesticBenefitGroupImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the travel domestic benefit group in the entity cache if it is enabled.
	 *
	 * @param travelDomesticBenefitGroup the travel domestic benefit group
	 */
	@Override
	public void cacheResult(
		TravelDomesticBenefitGroup travelDomesticBenefitGroup) {

		entityCache.putResult(
			TravelDomesticBenefitGroupImpl.class,
			travelDomesticBenefitGroup.getPrimaryKey(),
			travelDomesticBenefitGroup);

		finderCache.putResult(
			_finderPathFetchBysearchTravelDomesticBenefitGroupCode,
			new Object[] {travelDomesticBenefitGroup.getCode()},
			travelDomesticBenefitGroup);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the travel domestic benefit groups in the entity cache if it is enabled.
	 *
	 * @param travelDomesticBenefitGroups the travel domestic benefit groups
	 */
	@Override
	public void cacheResult(
		List<TravelDomesticBenefitGroup> travelDomesticBenefitGroups) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (travelDomesticBenefitGroups.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TravelDomesticBenefitGroup travelDomesticBenefitGroup :
				travelDomesticBenefitGroups) {

			if (entityCache.getResult(
					TravelDomesticBenefitGroupImpl.class,
					travelDomesticBenefitGroup.getPrimaryKey()) == null) {

				cacheResult(travelDomesticBenefitGroup);
			}
		}
	}

	/**
	 * Clears the cache for all travel domestic benefit groups.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TravelDomesticBenefitGroupImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the travel domestic benefit group.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		TravelDomesticBenefitGroup travelDomesticBenefitGroup) {

		entityCache.removeResult(
			TravelDomesticBenefitGroupImpl.class, travelDomesticBenefitGroup);
	}

	@Override
	public void clearCache(
		List<TravelDomesticBenefitGroup> travelDomesticBenefitGroups) {

		for (TravelDomesticBenefitGroup travelDomesticBenefitGroup :
				travelDomesticBenefitGroups) {

			entityCache.removeResult(
				TravelDomesticBenefitGroupImpl.class,
				travelDomesticBenefitGroup);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				TravelDomesticBenefitGroupImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TravelDomesticBenefitGroupModelImpl
			travelDomesticBenefitGroupModelImpl) {

		Object[] args = new Object[] {
			travelDomesticBenefitGroupModelImpl.getCode()
		};

		finderCache.putResult(
			_finderPathCountBysearchTravelDomesticBenefitGroupCode, args,
			Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBysearchTravelDomesticBenefitGroupCode, args,
			travelDomesticBenefitGroupModelImpl, false);
	}

	/**
	 * Creates a new travel domestic benefit group with the primary key. Does not add the travel domestic benefit group to the database.
	 *
	 * @param travelDomesticBenefitGroupId the primary key for the new travel domestic benefit group
	 * @return the new travel domestic benefit group
	 */
	@Override
	public TravelDomesticBenefitGroup create(
		long travelDomesticBenefitGroupId) {

		TravelDomesticBenefitGroup travelDomesticBenefitGroup =
			new TravelDomesticBenefitGroupImpl();

		travelDomesticBenefitGroup.setNew(true);
		travelDomesticBenefitGroup.setPrimaryKey(travelDomesticBenefitGroupId);

		return travelDomesticBenefitGroup;
	}

	/**
	 * Removes the travel domestic benefit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticBenefitGroupId the primary key of the travel domestic benefit group
	 * @return the travel domestic benefit group that was removed
	 * @throws NoSuchTravelDomesticBenefitGroupException if a travel domestic benefit group with the primary key could not be found
	 */
	@Override
	public TravelDomesticBenefitGroup remove(long travelDomesticBenefitGroupId)
		throws NoSuchTravelDomesticBenefitGroupException {

		return remove((Serializable)travelDomesticBenefitGroupId);
	}

	/**
	 * Removes the travel domestic benefit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the travel domestic benefit group
	 * @return the travel domestic benefit group that was removed
	 * @throws NoSuchTravelDomesticBenefitGroupException if a travel domestic benefit group with the primary key could not be found
	 */
	@Override
	public TravelDomesticBenefitGroup remove(Serializable primaryKey)
		throws NoSuchTravelDomesticBenefitGroupException {

		Session session = null;

		try {
			session = openSession();

			TravelDomesticBenefitGroup travelDomesticBenefitGroup =
				(TravelDomesticBenefitGroup)session.get(
					TravelDomesticBenefitGroupImpl.class, primaryKey);

			if (travelDomesticBenefitGroup == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTravelDomesticBenefitGroupException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(travelDomesticBenefitGroup);
		}
		catch (NoSuchTravelDomesticBenefitGroupException
					noSuchEntityException) {

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
	protected TravelDomesticBenefitGroup removeImpl(
		TravelDomesticBenefitGroup travelDomesticBenefitGroup) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(travelDomesticBenefitGroup)) {
				travelDomesticBenefitGroup =
					(TravelDomesticBenefitGroup)session.get(
						TravelDomesticBenefitGroupImpl.class,
						travelDomesticBenefitGroup.getPrimaryKeyObj());
			}

			if (travelDomesticBenefitGroup != null) {
				session.delete(travelDomesticBenefitGroup);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (travelDomesticBenefitGroup != null) {
			clearCache(travelDomesticBenefitGroup);
		}

		return travelDomesticBenefitGroup;
	}

	@Override
	public TravelDomesticBenefitGroup updateImpl(
		TravelDomesticBenefitGroup travelDomesticBenefitGroup) {

		boolean isNew = travelDomesticBenefitGroup.isNew();

		if (!(travelDomesticBenefitGroup instanceof
				TravelDomesticBenefitGroupModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(travelDomesticBenefitGroup.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					travelDomesticBenefitGroup);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in travelDomesticBenefitGroup proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TravelDomesticBenefitGroup implementation " +
					travelDomesticBenefitGroup.getClass());
		}

		TravelDomesticBenefitGroupModelImpl
			travelDomesticBenefitGroupModelImpl =
				(TravelDomesticBenefitGroupModelImpl)travelDomesticBenefitGroup;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(travelDomesticBenefitGroup);
			}
			else {
				travelDomesticBenefitGroup =
					(TravelDomesticBenefitGroup)session.merge(
						travelDomesticBenefitGroup);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TravelDomesticBenefitGroupImpl.class,
			travelDomesticBenefitGroupModelImpl, false, true);

		cacheUniqueFindersCache(travelDomesticBenefitGroupModelImpl);

		if (isNew) {
			travelDomesticBenefitGroup.setNew(false);
		}

		travelDomesticBenefitGroup.resetOriginalValues();

		return travelDomesticBenefitGroup;
	}

	/**
	 * Returns the travel domestic benefit group with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the travel domestic benefit group
	 * @return the travel domestic benefit group
	 * @throws NoSuchTravelDomesticBenefitGroupException if a travel domestic benefit group with the primary key could not be found
	 */
	@Override
	public TravelDomesticBenefitGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTravelDomesticBenefitGroupException {

		TravelDomesticBenefitGroup travelDomesticBenefitGroup =
			fetchByPrimaryKey(primaryKey);

		if (travelDomesticBenefitGroup == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTravelDomesticBenefitGroupException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return travelDomesticBenefitGroup;
	}

	/**
	 * Returns the travel domestic benefit group with the primary key or throws a <code>NoSuchTravelDomesticBenefitGroupException</code> if it could not be found.
	 *
	 * @param travelDomesticBenefitGroupId the primary key of the travel domestic benefit group
	 * @return the travel domestic benefit group
	 * @throws NoSuchTravelDomesticBenefitGroupException if a travel domestic benefit group with the primary key could not be found
	 */
	@Override
	public TravelDomesticBenefitGroup findByPrimaryKey(
			long travelDomesticBenefitGroupId)
		throws NoSuchTravelDomesticBenefitGroupException {

		return findByPrimaryKey((Serializable)travelDomesticBenefitGroupId);
	}

	/**
	 * Returns the travel domestic benefit group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticBenefitGroupId the primary key of the travel domestic benefit group
	 * @return the travel domestic benefit group, or <code>null</code> if a travel domestic benefit group with the primary key could not be found
	 */
	@Override
	public TravelDomesticBenefitGroup fetchByPrimaryKey(
		long travelDomesticBenefitGroupId) {

		return fetchByPrimaryKey((Serializable)travelDomesticBenefitGroupId);
	}

	/**
	 * Returns all the travel domestic benefit groups.
	 *
	 * @return the travel domestic benefit groups
	 */
	@Override
	public List<TravelDomesticBenefitGroup> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel domestic benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @return the range of travel domestic benefit groups
	 */
	@Override
	public List<TravelDomesticBenefitGroup> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic benefit groups
	 */
	@Override
	public List<TravelDomesticBenefitGroup> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticBenefitGroup> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic benefit groups
	 * @param end the upper bound of the range of travel domestic benefit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic benefit groups
	 */
	@Override
	public List<TravelDomesticBenefitGroup> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticBenefitGroup> orderByComparator,
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

		List<TravelDomesticBenefitGroup> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticBenefitGroup>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAVELDOMESTICBENEFITGROUP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAVELDOMESTICBENEFITGROUP;

				sql = sql.concat(
					TravelDomesticBenefitGroupModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TravelDomesticBenefitGroup>)QueryUtil.list(
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
	 * Removes all the travel domestic benefit groups from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TravelDomesticBenefitGroup travelDomesticBenefitGroup :
				findAll()) {

			remove(travelDomesticBenefitGroup);
		}
	}

	/**
	 * Returns the number of travel domestic benefit groups.
	 *
	 * @return the number of travel domestic benefit groups
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
					_SQL_COUNT_TRAVELDOMESTICBENEFITGROUP);

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
		return "travelDomesticBenefitGroupId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAVELDOMESTICBENEFITGROUP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TravelDomesticBenefitGroupModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the travel domestic benefit group persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new TravelDomesticBenefitGroupModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name",
				TravelDomesticBenefitGroup.class.getName()));

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

		_finderPathWithPaginationFindBysearchTravelDomesticBenefitGroupId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBysearchTravelDomesticBenefitGroupId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"travelDomesticBenefitGroupId"}, true);

		_finderPathWithoutPaginationFindBysearchTravelDomesticBenefitGroupId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBysearchTravelDomesticBenefitGroupId",
				new String[] {Long.class.getName()},
				new String[] {"travelDomesticBenefitGroupId"}, true);

		_finderPathCountBysearchTravelDomesticBenefitGroupId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countBysearchTravelDomesticBenefitGroupId",
				new String[] {Long.class.getName()},
				new String[] {"travelDomesticBenefitGroupId"}, false);

		_finderPathFetchBysearchTravelDomesticBenefitGroupCode =
			_createFinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchBysearchTravelDomesticBenefitGroupCode",
				new String[] {String.class.getName()}, new String[] {"code_"},
				true);

		_finderPathCountBysearchTravelDomesticBenefitGroupCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countBysearchTravelDomesticBenefitGroupCode",
				new String[] {String.class.getName()}, new String[] {"code_"},
				false);

		_setTravelDomesticBenefitGroupUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTravelDomesticBenefitGroupUtilPersistence(null);

		entityCache.removeCache(TravelDomesticBenefitGroupImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setTravelDomesticBenefitGroupUtilPersistence(
		TravelDomesticBenefitGroupPersistence
			travelDomesticBenefitGroupPersistence) {

		try {
			Field field = TravelDomesticBenefitGroupUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, travelDomesticBenefitGroupPersistence);
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

	private static final String _SQL_SELECT_TRAVELDOMESTICBENEFITGROUP =
		"SELECT travelDomesticBenefitGroup FROM TravelDomesticBenefitGroup travelDomesticBenefitGroup";

	private static final String _SQL_SELECT_TRAVELDOMESTICBENEFITGROUP_WHERE =
		"SELECT travelDomesticBenefitGroup FROM TravelDomesticBenefitGroup travelDomesticBenefitGroup WHERE ";

	private static final String _SQL_COUNT_TRAVELDOMESTICBENEFITGROUP =
		"SELECT COUNT(travelDomesticBenefitGroup) FROM TravelDomesticBenefitGroup travelDomesticBenefitGroup";

	private static final String _SQL_COUNT_TRAVELDOMESTICBENEFITGROUP_WHERE =
		"SELECT COUNT(travelDomesticBenefitGroup) FROM TravelDomesticBenefitGroup travelDomesticBenefitGroup WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"travelDomesticBenefitGroup.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TravelDomesticBenefitGroup exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TravelDomesticBenefitGroup exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TravelDomesticBenefitGroupPersistenceImpl.class);

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

	private static class TravelDomesticBenefitGroupModelArgumentsResolver
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

			TravelDomesticBenefitGroupModelImpl
				travelDomesticBenefitGroupModelImpl =
					(TravelDomesticBenefitGroupModelImpl)baseModel;

			long columnBitmask =
				travelDomesticBenefitGroupModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					travelDomesticBenefitGroupModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						travelDomesticBenefitGroupModelImpl.getColumnBitmask(
							columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(TravelDomesticBenefitGroupPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					travelDomesticBenefitGroupModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			TravelDomesticBenefitGroupModelImpl
				travelDomesticBenefitGroupModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						travelDomesticBenefitGroupModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						travelDomesticBenefitGroupModelImpl.getColumnValue(
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

			orderByColumnsBitmask |=
				TravelDomesticBenefitGroupModelImpl.getColumnBitmask("name");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}