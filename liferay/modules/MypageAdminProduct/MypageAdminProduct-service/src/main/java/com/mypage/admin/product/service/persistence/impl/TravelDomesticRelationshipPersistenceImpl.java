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

import com.mypage.admin.product.exception.NoSuchTravelDomesticRelationshipException;
import com.mypage.admin.product.model.TravelDomesticRelationship;
import com.mypage.admin.product.model.impl.TravelDomesticRelationshipImpl;
import com.mypage.admin.product.model.impl.TravelDomesticRelationshipModelImpl;
import com.mypage.admin.product.service.persistence.TravelDomesticRelationshipPersistence;
import com.mypage.admin.product.service.persistence.TravelDomesticRelationshipUtil;
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
 * The persistence implementation for the travel domestic relationship service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = TravelDomesticRelationshipPersistence.class)
public class TravelDomesticRelationshipPersistenceImpl
	extends BasePersistenceImpl<TravelDomesticRelationship>
	implements TravelDomesticRelationshipPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TravelDomesticRelationshipUtil</code> to access the travel domestic relationship persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TravelDomesticRelationshipImpl.class.getName();

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
	 * Returns all the travel domestic relationships where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @return the matching travel domestic relationships
	 */
	@Override
	public List<TravelDomesticRelationship> findBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort) {

		return findBysearchInsuredType(
			travelDomesticRelationshipId, name, description, sort,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel domestic relationships where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticRelationshipModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @param start the lower bound of the range of travel domestic relationships
	 * @param end the upper bound of the range of travel domestic relationships (not inclusive)
	 * @return the range of matching travel domestic relationships
	 */
	@Override
	public List<TravelDomesticRelationship> findBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort, int start, int end) {

		return findBysearchInsuredType(
			travelDomesticRelationshipId, name, description, sort, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the travel domestic relationships where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticRelationshipModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @param start the lower bound of the range of travel domestic relationships
	 * @param end the upper bound of the range of travel domestic relationships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching travel domestic relationships
	 */
	@Override
	public List<TravelDomesticRelationship> findBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort, int start, int end,
		OrderByComparator<TravelDomesticRelationship> orderByComparator) {

		return findBysearchInsuredType(
			travelDomesticRelationshipId, name, description, sort, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic relationships where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticRelationshipModelImpl</code>.
	 * </p>
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @param start the lower bound of the range of travel domestic relationships
	 * @param end the upper bound of the range of travel domestic relationships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching travel domestic relationships
	 */
	@Override
	public List<TravelDomesticRelationship> findBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort, int start, int end,
		OrderByComparator<TravelDomesticRelationship> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");
		description = Objects.toString(description, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBysearchInsuredType;
				finderArgs = new Object[] {
					travelDomesticRelationshipId, name, description, sort
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchInsuredType;
			finderArgs = new Object[] {
				travelDomesticRelationshipId, name, description, sort, start,
				end, orderByComparator
			};
		}

		List<TravelDomesticRelationship> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticRelationship>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TravelDomesticRelationship travelDomesticRelationship :
						list) {

					if ((travelDomesticRelationshipId !=
							travelDomesticRelationship.
								getTravelDomesticRelationshipId()) ||
						!name.equals(travelDomesticRelationship.getName()) ||
						!description.equals(
							travelDomesticRelationship.getDescription()) ||
						(sort != travelDomesticRelationship.getSort())) {

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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_TRAVELDOMESTICRELATIONSHIP_WHERE);

			sb.append(
				_FINDER_COLUMN_SEARCHINSUREDTYPE_TRAVELDOMESTICRELATIONSHIPID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_NAME_2);
			}

			boolean bindDescription = false;

			if (description.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_DESCRIPTION_2);
			}

			sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_SORT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TravelDomesticRelationshipModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(travelDomesticRelationshipId);

				if (bindName) {
					queryPos.add(name);
				}

				if (bindDescription) {
					queryPos.add(description);
				}

				queryPos.add(sort);

				list = (List<TravelDomesticRelationship>)QueryUtil.list(
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
	 * Returns the first travel domestic relationship in the ordered set where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic relationship
	 * @throws NoSuchTravelDomesticRelationshipException if a matching travel domestic relationship could not be found
	 */
	@Override
	public TravelDomesticRelationship findBysearchInsuredType_First(
			long travelDomesticRelationshipId, String name, String description,
			int sort,
			OrderByComparator<TravelDomesticRelationship> orderByComparator)
		throws NoSuchTravelDomesticRelationshipException {

		TravelDomesticRelationship travelDomesticRelationship =
			fetchBysearchInsuredType_First(
				travelDomesticRelationshipId, name, description, sort,
				orderByComparator);

		if (travelDomesticRelationship != null) {
			return travelDomesticRelationship;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelDomesticRelationshipId=");
		sb.append(travelDomesticRelationshipId);

		sb.append(", name=");
		sb.append(name);

		sb.append(", description=");
		sb.append(description);

		sb.append(", sort=");
		sb.append(sort);

		sb.append("}");

		throw new NoSuchTravelDomesticRelationshipException(sb.toString());
	}

	/**
	 * Returns the first travel domestic relationship in the ordered set where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching travel domestic relationship, or <code>null</code> if a matching travel domestic relationship could not be found
	 */
	@Override
	public TravelDomesticRelationship fetchBysearchInsuredType_First(
		long travelDomesticRelationshipId, String name, String description,
		int sort,
		OrderByComparator<TravelDomesticRelationship> orderByComparator) {

		List<TravelDomesticRelationship> list = findBysearchInsuredType(
			travelDomesticRelationshipId, name, description, sort, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last travel domestic relationship in the ordered set where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic relationship
	 * @throws NoSuchTravelDomesticRelationshipException if a matching travel domestic relationship could not be found
	 */
	@Override
	public TravelDomesticRelationship findBysearchInsuredType_Last(
			long travelDomesticRelationshipId, String name, String description,
			int sort,
			OrderByComparator<TravelDomesticRelationship> orderByComparator)
		throws NoSuchTravelDomesticRelationshipException {

		TravelDomesticRelationship travelDomesticRelationship =
			fetchBysearchInsuredType_Last(
				travelDomesticRelationshipId, name, description, sort,
				orderByComparator);

		if (travelDomesticRelationship != null) {
			return travelDomesticRelationship;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("travelDomesticRelationshipId=");
		sb.append(travelDomesticRelationshipId);

		sb.append(", name=");
		sb.append(name);

		sb.append(", description=");
		sb.append(description);

		sb.append(", sort=");
		sb.append(sort);

		sb.append("}");

		throw new NoSuchTravelDomesticRelationshipException(sb.toString());
	}

	/**
	 * Returns the last travel domestic relationship in the ordered set where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching travel domestic relationship, or <code>null</code> if a matching travel domestic relationship could not be found
	 */
	@Override
	public TravelDomesticRelationship fetchBysearchInsuredType_Last(
		long travelDomesticRelationshipId, String name, String description,
		int sort,
		OrderByComparator<TravelDomesticRelationship> orderByComparator) {

		int count = countBysearchInsuredType(
			travelDomesticRelationshipId, name, description, sort);

		if (count == 0) {
			return null;
		}

		List<TravelDomesticRelationship> list = findBysearchInsuredType(
			travelDomesticRelationshipId, name, description, sort, count - 1,
			count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the travel domestic relationships where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63; from the database.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 */
	@Override
	public void removeBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort) {

		for (TravelDomesticRelationship travelDomesticRelationship :
				findBysearchInsuredType(
					travelDomesticRelationshipId, name, description, sort,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(travelDomesticRelationship);
		}
	}

	/**
	 * Returns the number of travel domestic relationships where travelDomesticRelationshipId = &#63; and name = &#63; and description = &#63; and sort = &#63;.
	 *
	 * @param travelDomesticRelationshipId the travel domestic relationship ID
	 * @param name the name
	 * @param description the description
	 * @param sort the sort
	 * @return the number of matching travel domestic relationships
	 */
	@Override
	public int countBysearchInsuredType(
		long travelDomesticRelationshipId, String name, String description,
		int sort) {

		name = Objects.toString(name, "");
		description = Objects.toString(description, "");

		FinderPath finderPath = _finderPathCountBysearchInsuredType;

		Object[] finderArgs = new Object[] {
			travelDomesticRelationshipId, name, description, sort
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_TRAVELDOMESTICRELATIONSHIP_WHERE);

			sb.append(
				_FINDER_COLUMN_SEARCHINSUREDTYPE_TRAVELDOMESTICRELATIONSHIPID_2);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_NAME_2);
			}

			boolean bindDescription = false;

			if (description.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_DESCRIPTION_2);
			}

			sb.append(_FINDER_COLUMN_SEARCHINSUREDTYPE_SORT_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(travelDomesticRelationshipId);

				if (bindName) {
					queryPos.add(name);
				}

				if (bindDescription) {
					queryPos.add(description);
				}

				queryPos.add(sort);

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
		_FINDER_COLUMN_SEARCHINSUREDTYPE_TRAVELDOMESTICRELATIONSHIPID_2 =
			"travelDomesticRelationship.travelDomesticRelationshipId = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHINSUREDTYPE_NAME_2 =
		"travelDomesticRelationship.name = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHINSUREDTYPE_NAME_3 =
		"(travelDomesticRelationship.name IS NULL OR travelDomesticRelationship.name = '') AND ";

	private static final String _FINDER_COLUMN_SEARCHINSUREDTYPE_DESCRIPTION_2 =
		"travelDomesticRelationship.description = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHINSUREDTYPE_DESCRIPTION_3 =
		"(travelDomesticRelationship.description IS NULL OR travelDomesticRelationship.description = '') AND ";

	private static final String _FINDER_COLUMN_SEARCHINSUREDTYPE_SORT_2 =
		"travelDomesticRelationship.sort = ?";

	public TravelDomesticRelationshipPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TravelDomesticRelationship.class);

		setModelImplClass(TravelDomesticRelationshipImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the travel domestic relationship in the entity cache if it is enabled.
	 *
	 * @param travelDomesticRelationship the travel domestic relationship
	 */
	@Override
	public void cacheResult(
		TravelDomesticRelationship travelDomesticRelationship) {

		entityCache.putResult(
			TravelDomesticRelationshipImpl.class,
			travelDomesticRelationship.getPrimaryKey(),
			travelDomesticRelationship);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the travel domestic relationships in the entity cache if it is enabled.
	 *
	 * @param travelDomesticRelationships the travel domestic relationships
	 */
	@Override
	public void cacheResult(
		List<TravelDomesticRelationship> travelDomesticRelationships) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (travelDomesticRelationships.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TravelDomesticRelationship travelDomesticRelationship :
				travelDomesticRelationships) {

			if (entityCache.getResult(
					TravelDomesticRelationshipImpl.class,
					travelDomesticRelationship.getPrimaryKey()) == null) {

				cacheResult(travelDomesticRelationship);
			}
		}
	}

	/**
	 * Clears the cache for all travel domestic relationships.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TravelDomesticRelationshipImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the travel domestic relationship.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		TravelDomesticRelationship travelDomesticRelationship) {

		entityCache.removeResult(
			TravelDomesticRelationshipImpl.class, travelDomesticRelationship);
	}

	@Override
	public void clearCache(
		List<TravelDomesticRelationship> travelDomesticRelationships) {

		for (TravelDomesticRelationship travelDomesticRelationship :
				travelDomesticRelationships) {

			entityCache.removeResult(
				TravelDomesticRelationshipImpl.class,
				travelDomesticRelationship);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				TravelDomesticRelationshipImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new travel domestic relationship with the primary key. Does not add the travel domestic relationship to the database.
	 *
	 * @param travelDomesticRelationshipId the primary key for the new travel domestic relationship
	 * @return the new travel domestic relationship
	 */
	@Override
	public TravelDomesticRelationship create(
		long travelDomesticRelationshipId) {

		TravelDomesticRelationship travelDomesticRelationship =
			new TravelDomesticRelationshipImpl();

		travelDomesticRelationship.setNew(true);
		travelDomesticRelationship.setPrimaryKey(travelDomesticRelationshipId);

		travelDomesticRelationship.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return travelDomesticRelationship;
	}

	/**
	 * Removes the travel domestic relationship with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param travelDomesticRelationshipId the primary key of the travel domestic relationship
	 * @return the travel domestic relationship that was removed
	 * @throws NoSuchTravelDomesticRelationshipException if a travel domestic relationship with the primary key could not be found
	 */
	@Override
	public TravelDomesticRelationship remove(long travelDomesticRelationshipId)
		throws NoSuchTravelDomesticRelationshipException {

		return remove((Serializable)travelDomesticRelationshipId);
	}

	/**
	 * Removes the travel domestic relationship with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the travel domestic relationship
	 * @return the travel domestic relationship that was removed
	 * @throws NoSuchTravelDomesticRelationshipException if a travel domestic relationship with the primary key could not be found
	 */
	@Override
	public TravelDomesticRelationship remove(Serializable primaryKey)
		throws NoSuchTravelDomesticRelationshipException {

		Session session = null;

		try {
			session = openSession();

			TravelDomesticRelationship travelDomesticRelationship =
				(TravelDomesticRelationship)session.get(
					TravelDomesticRelationshipImpl.class, primaryKey);

			if (travelDomesticRelationship == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTravelDomesticRelationshipException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(travelDomesticRelationship);
		}
		catch (NoSuchTravelDomesticRelationshipException
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
	protected TravelDomesticRelationship removeImpl(
		TravelDomesticRelationship travelDomesticRelationship) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(travelDomesticRelationship)) {
				travelDomesticRelationship =
					(TravelDomesticRelationship)session.get(
						TravelDomesticRelationshipImpl.class,
						travelDomesticRelationship.getPrimaryKeyObj());
			}

			if (travelDomesticRelationship != null) {
				session.delete(travelDomesticRelationship);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (travelDomesticRelationship != null) {
			clearCache(travelDomesticRelationship);
		}

		return travelDomesticRelationship;
	}

	@Override
	public TravelDomesticRelationship updateImpl(
		TravelDomesticRelationship travelDomesticRelationship) {

		boolean isNew = travelDomesticRelationship.isNew();

		if (!(travelDomesticRelationship instanceof
				TravelDomesticRelationshipModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(travelDomesticRelationship.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					travelDomesticRelationship);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in travelDomesticRelationship proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TravelDomesticRelationship implementation " +
					travelDomesticRelationship.getClass());
		}

		TravelDomesticRelationshipModelImpl
			travelDomesticRelationshipModelImpl =
				(TravelDomesticRelationshipModelImpl)travelDomesticRelationship;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (travelDomesticRelationship.getCreateDate() == null)) {
			if (serviceContext == null) {
				travelDomesticRelationship.setCreateDate(date);
			}
			else {
				travelDomesticRelationship.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!travelDomesticRelationshipModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				travelDomesticRelationship.setModifiedDate(date);
			}
			else {
				travelDomesticRelationship.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(travelDomesticRelationship);
			}
			else {
				travelDomesticRelationship =
					(TravelDomesticRelationship)session.merge(
						travelDomesticRelationship);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TravelDomesticRelationshipImpl.class,
			travelDomesticRelationshipModelImpl, false, true);

		if (isNew) {
			travelDomesticRelationship.setNew(false);
		}

		travelDomesticRelationship.resetOriginalValues();

		return travelDomesticRelationship;
	}

	/**
	 * Returns the travel domestic relationship with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the travel domestic relationship
	 * @return the travel domestic relationship
	 * @throws NoSuchTravelDomesticRelationshipException if a travel domestic relationship with the primary key could not be found
	 */
	@Override
	public TravelDomesticRelationship findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTravelDomesticRelationshipException {

		TravelDomesticRelationship travelDomesticRelationship =
			fetchByPrimaryKey(primaryKey);

		if (travelDomesticRelationship == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTravelDomesticRelationshipException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return travelDomesticRelationship;
	}

	/**
	 * Returns the travel domestic relationship with the primary key or throws a <code>NoSuchTravelDomesticRelationshipException</code> if it could not be found.
	 *
	 * @param travelDomesticRelationshipId the primary key of the travel domestic relationship
	 * @return the travel domestic relationship
	 * @throws NoSuchTravelDomesticRelationshipException if a travel domestic relationship with the primary key could not be found
	 */
	@Override
	public TravelDomesticRelationship findByPrimaryKey(
			long travelDomesticRelationshipId)
		throws NoSuchTravelDomesticRelationshipException {

		return findByPrimaryKey((Serializable)travelDomesticRelationshipId);
	}

	/**
	 * Returns the travel domestic relationship with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param travelDomesticRelationshipId the primary key of the travel domestic relationship
	 * @return the travel domestic relationship, or <code>null</code> if a travel domestic relationship with the primary key could not be found
	 */
	@Override
	public TravelDomesticRelationship fetchByPrimaryKey(
		long travelDomesticRelationshipId) {

		return fetchByPrimaryKey((Serializable)travelDomesticRelationshipId);
	}

	/**
	 * Returns all the travel domestic relationships.
	 *
	 * @return the travel domestic relationships
	 */
	@Override
	public List<TravelDomesticRelationship> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the travel domestic relationships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticRelationshipModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic relationships
	 * @param end the upper bound of the range of travel domestic relationships (not inclusive)
	 * @return the range of travel domestic relationships
	 */
	@Override
	public List<TravelDomesticRelationship> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the travel domestic relationships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticRelationshipModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic relationships
	 * @param end the upper bound of the range of travel domestic relationships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of travel domestic relationships
	 */
	@Override
	public List<TravelDomesticRelationship> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticRelationship> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the travel domestic relationships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TravelDomesticRelationshipModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic relationships
	 * @param end the upper bound of the range of travel domestic relationships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of travel domestic relationships
	 */
	@Override
	public List<TravelDomesticRelationship> findAll(
		int start, int end,
		OrderByComparator<TravelDomesticRelationship> orderByComparator,
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

		List<TravelDomesticRelationship> list = null;

		if (useFinderCache) {
			list = (List<TravelDomesticRelationship>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAVELDOMESTICRELATIONSHIP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAVELDOMESTICRELATIONSHIP;

				sql = sql.concat(
					TravelDomesticRelationshipModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TravelDomesticRelationship>)QueryUtil.list(
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
	 * Removes all the travel domestic relationships from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TravelDomesticRelationship travelDomesticRelationship :
				findAll()) {

			remove(travelDomesticRelationship);
		}
	}

	/**
	 * Returns the number of travel domestic relationships.
	 *
	 * @return the number of travel domestic relationships
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
					_SQL_COUNT_TRAVELDOMESTICRELATIONSHIP);

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
		return "travelDomesticRelationshipId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAVELDOMESTICRELATIONSHIP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TravelDomesticRelationshipModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the travel domestic relationship persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new TravelDomesticRelationshipModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name",
				TravelDomesticRelationship.class.getName()));

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
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {
				"travelDomesticRelationshipId", "name", "description", "sort"
			},
			true);

		_finderPathWithoutPaginationFindBysearchInsuredType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBysearchInsuredType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), Integer.class.getName()
			},
			new String[] {
				"travelDomesticRelationshipId", "name", "description", "sort"
			},
			true);

		_finderPathCountBysearchInsuredType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysearchInsuredType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), Integer.class.getName()
			},
			new String[] {
				"travelDomesticRelationshipId", "name", "description", "sort"
			},
			false);

		_setTravelDomesticRelationshipUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTravelDomesticRelationshipUtilPersistence(null);

		entityCache.removeCache(TravelDomesticRelationshipImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setTravelDomesticRelationshipUtilPersistence(
		TravelDomesticRelationshipPersistence
			travelDomesticRelationshipPersistence) {

		try {
			Field field = TravelDomesticRelationshipUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, travelDomesticRelationshipPersistence);
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

	private static final String _SQL_SELECT_TRAVELDOMESTICRELATIONSHIP =
		"SELECT travelDomesticRelationship FROM TravelDomesticRelationship travelDomesticRelationship";

	private static final String _SQL_SELECT_TRAVELDOMESTICRELATIONSHIP_WHERE =
		"SELECT travelDomesticRelationship FROM TravelDomesticRelationship travelDomesticRelationship WHERE ";

	private static final String _SQL_COUNT_TRAVELDOMESTICRELATIONSHIP =
		"SELECT COUNT(travelDomesticRelationship) FROM TravelDomesticRelationship travelDomesticRelationship";

	private static final String _SQL_COUNT_TRAVELDOMESTICRELATIONSHIP_WHERE =
		"SELECT COUNT(travelDomesticRelationship) FROM TravelDomesticRelationship travelDomesticRelationship WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"travelDomesticRelationship.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TravelDomesticRelationship exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TravelDomesticRelationship exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TravelDomesticRelationshipPersistenceImpl.class);

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

	private static class TravelDomesticRelationshipModelArgumentsResolver
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

			TravelDomesticRelationshipModelImpl
				travelDomesticRelationshipModelImpl =
					(TravelDomesticRelationshipModelImpl)baseModel;

			long columnBitmask =
				travelDomesticRelationshipModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					travelDomesticRelationshipModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						travelDomesticRelationshipModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					travelDomesticRelationshipModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			TravelDomesticRelationshipModelImpl
				travelDomesticRelationshipModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						travelDomesticRelationshipModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						travelDomesticRelationshipModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}