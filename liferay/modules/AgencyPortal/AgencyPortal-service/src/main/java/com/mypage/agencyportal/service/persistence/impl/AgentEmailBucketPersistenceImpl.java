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

package com.mypage.agencyportal.service.persistence.impl;

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

import com.mypage.agencyportal.exception.NoSuchAgentEmailBucketException;
import com.mypage.agencyportal.model.AgentEmailBucket;
import com.mypage.agencyportal.model.impl.AgentEmailBucketImpl;
import com.mypage.agencyportal.model.impl.AgentEmailBucketModelImpl;
import com.mypage.agencyportal.service.persistence.AgentEmailBucketPersistence;
import com.mypage.agencyportal.service.persistence.AgentEmailBucketUtil;
import com.mypage.agencyportal.service.persistence.impl.constants.APPersistenceConstants;

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
 * The persistence implementation for the agent email bucket service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = AgentEmailBucketPersistence.class)
public class AgentEmailBucketPersistenceImpl
	extends BasePersistenceImpl<AgentEmailBucket>
	implements AgentEmailBucketPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AgentEmailBucketUtil</code> to access the agent email bucket persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AgentEmailBucketImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBystatus;
	private FinderPath _finderPathWithoutPaginationFindBystatus;
	private FinderPath _finderPathCountBystatus;

	/**
	 * Returns all the agent email buckets where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @return the matching agent email buckets
	 */
	@Override
	public List<AgentEmailBucket> findBystatus(String status_) {
		return findBystatus(
			status_, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent email buckets where status_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentEmailBucketModelImpl</code>.
	 * </p>
	 *
	 * @param status_ the status_
	 * @param start the lower bound of the range of agent email buckets
	 * @param end the upper bound of the range of agent email buckets (not inclusive)
	 * @return the range of matching agent email buckets
	 */
	@Override
	public List<AgentEmailBucket> findBystatus(
		String status_, int start, int end) {

		return findBystatus(status_, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent email buckets where status_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentEmailBucketModelImpl</code>.
	 * </p>
	 *
	 * @param status_ the status_
	 * @param start the lower bound of the range of agent email buckets
	 * @param end the upper bound of the range of agent email buckets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agent email buckets
	 */
	@Override
	public List<AgentEmailBucket> findBystatus(
		String status_, int start, int end,
		OrderByComparator<AgentEmailBucket> orderByComparator) {

		return findBystatus(status_, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent email buckets where status_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentEmailBucketModelImpl</code>.
	 * </p>
	 *
	 * @param status_ the status_
	 * @param start the lower bound of the range of agent email buckets
	 * @param end the upper bound of the range of agent email buckets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agent email buckets
	 */
	@Override
	public List<AgentEmailBucket> findBystatus(
		String status_, int start, int end,
		OrderByComparator<AgentEmailBucket> orderByComparator,
		boolean useFinderCache) {

		status_ = Objects.toString(status_, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBystatus;
				finderArgs = new Object[] {status_};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBystatus;
			finderArgs = new Object[] {status_, start, end, orderByComparator};
		}

		List<AgentEmailBucket> list = null;

		if (useFinderCache) {
			list = (List<AgentEmailBucket>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgentEmailBucket agentEmailBucket : list) {
					if (!status_.equals(agentEmailBucket.getStatus_())) {
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

			sb.append(_SQL_SELECT_AGENTEMAILBUCKET_WHERE);

			boolean bindStatus_ = false;

			if (status_.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUS_STATUS__3);
			}
			else {
				bindStatus_ = true;

				sb.append(_FINDER_COLUMN_STATUS_STATUS__2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgentEmailBucketModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatus_) {
					queryPos.add(status_);
				}

				list = (List<AgentEmailBucket>)QueryUtil.list(
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
	 * Returns the first agent email bucket in the ordered set where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent email bucket
	 * @throws NoSuchAgentEmailBucketException if a matching agent email bucket could not be found
	 */
	@Override
	public AgentEmailBucket findBystatus_First(
			String status_,
			OrderByComparator<AgentEmailBucket> orderByComparator)
		throws NoSuchAgentEmailBucketException {

		AgentEmailBucket agentEmailBucket = fetchBystatus_First(
			status_, orderByComparator);

		if (agentEmailBucket != null) {
			return agentEmailBucket;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status_=");
		sb.append(status_);

		sb.append("}");

		throw new NoSuchAgentEmailBucketException(sb.toString());
	}

	/**
	 * Returns the first agent email bucket in the ordered set where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agent email bucket, or <code>null</code> if a matching agent email bucket could not be found
	 */
	@Override
	public AgentEmailBucket fetchBystatus_First(
		String status_, OrderByComparator<AgentEmailBucket> orderByComparator) {

		List<AgentEmailBucket> list = findBystatus(
			status_, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agent email bucket in the ordered set where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent email bucket
	 * @throws NoSuchAgentEmailBucketException if a matching agent email bucket could not be found
	 */
	@Override
	public AgentEmailBucket findBystatus_Last(
			String status_,
			OrderByComparator<AgentEmailBucket> orderByComparator)
		throws NoSuchAgentEmailBucketException {

		AgentEmailBucket agentEmailBucket = fetchBystatus_Last(
			status_, orderByComparator);

		if (agentEmailBucket != null) {
			return agentEmailBucket;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status_=");
		sb.append(status_);

		sb.append("}");

		throw new NoSuchAgentEmailBucketException(sb.toString());
	}

	/**
	 * Returns the last agent email bucket in the ordered set where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agent email bucket, or <code>null</code> if a matching agent email bucket could not be found
	 */
	@Override
	public AgentEmailBucket fetchBystatus_Last(
		String status_, OrderByComparator<AgentEmailBucket> orderByComparator) {

		int count = countBystatus(status_);

		if (count == 0) {
			return null;
		}

		List<AgentEmailBucket> list = findBystatus(
			status_, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agent email buckets before and after the current agent email bucket in the ordered set where status_ = &#63;.
	 *
	 * @param agentEmailBucketId the primary key of the current agent email bucket
	 * @param status_ the status_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agent email bucket
	 * @throws NoSuchAgentEmailBucketException if a agent email bucket with the primary key could not be found
	 */
	@Override
	public AgentEmailBucket[] findBystatus_PrevAndNext(
			long agentEmailBucketId, String status_,
			OrderByComparator<AgentEmailBucket> orderByComparator)
		throws NoSuchAgentEmailBucketException {

		status_ = Objects.toString(status_, "");

		AgentEmailBucket agentEmailBucket = findByPrimaryKey(
			agentEmailBucketId);

		Session session = null;

		try {
			session = openSession();

			AgentEmailBucket[] array = new AgentEmailBucketImpl[3];

			array[0] = getBystatus_PrevAndNext(
				session, agentEmailBucket, status_, orderByComparator, true);

			array[1] = agentEmailBucket;

			array[2] = getBystatus_PrevAndNext(
				session, agentEmailBucket, status_, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AgentEmailBucket getBystatus_PrevAndNext(
		Session session, AgentEmailBucket agentEmailBucket, String status_,
		OrderByComparator<AgentEmailBucket> orderByComparator,
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

		sb.append(_SQL_SELECT_AGENTEMAILBUCKET_WHERE);

		boolean bindStatus_ = false;

		if (status_.isEmpty()) {
			sb.append(_FINDER_COLUMN_STATUS_STATUS__3);
		}
		else {
			bindStatus_ = true;

			sb.append(_FINDER_COLUMN_STATUS_STATUS__2);
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
			sb.append(AgentEmailBucketModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStatus_) {
			queryPos.add(status_);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						agentEmailBucket)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgentEmailBucket> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agent email buckets where status_ = &#63; from the database.
	 *
	 * @param status_ the status_
	 */
	@Override
	public void removeBystatus(String status_) {
		for (AgentEmailBucket agentEmailBucket :
				findBystatus(
					status_, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(agentEmailBucket);
		}
	}

	/**
	 * Returns the number of agent email buckets where status_ = &#63;.
	 *
	 * @param status_ the status_
	 * @return the number of matching agent email buckets
	 */
	@Override
	public int countBystatus(String status_) {
		status_ = Objects.toString(status_, "");

		FinderPath finderPath = _finderPathCountBystatus;

		Object[] finderArgs = new Object[] {status_};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTEMAILBUCKET_WHERE);

			boolean bindStatus_ = false;

			if (status_.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUS_STATUS__3);
			}
			else {
				bindStatus_ = true;

				sb.append(_FINDER_COLUMN_STATUS_STATUS__2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatus_) {
					queryPos.add(status_);
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

	private static final String _FINDER_COLUMN_STATUS_STATUS__2 =
		"agentEmailBucket.status_ = ?";

	private static final String _FINDER_COLUMN_STATUS_STATUS__3 =
		"(agentEmailBucket.status_ IS NULL OR agentEmailBucket.status_ = '')";

	public AgentEmailBucketPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AgentEmailBucket.class);

		setModelImplClass(AgentEmailBucketImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the agent email bucket in the entity cache if it is enabled.
	 *
	 * @param agentEmailBucket the agent email bucket
	 */
	@Override
	public void cacheResult(AgentEmailBucket agentEmailBucket) {
		entityCache.putResult(
			AgentEmailBucketImpl.class, agentEmailBucket.getPrimaryKey(),
			agentEmailBucket);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the agent email buckets in the entity cache if it is enabled.
	 *
	 * @param agentEmailBuckets the agent email buckets
	 */
	@Override
	public void cacheResult(List<AgentEmailBucket> agentEmailBuckets) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (agentEmailBuckets.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AgentEmailBucket agentEmailBucket : agentEmailBuckets) {
			if (entityCache.getResult(
					AgentEmailBucketImpl.class,
					agentEmailBucket.getPrimaryKey()) == null) {

				cacheResult(agentEmailBucket);
			}
		}
	}

	/**
	 * Clears the cache for all agent email buckets.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AgentEmailBucketImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the agent email bucket.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AgentEmailBucket agentEmailBucket) {
		entityCache.removeResult(AgentEmailBucketImpl.class, agentEmailBucket);
	}

	@Override
	public void clearCache(List<AgentEmailBucket> agentEmailBuckets) {
		for (AgentEmailBucket agentEmailBucket : agentEmailBuckets) {
			entityCache.removeResult(
				AgentEmailBucketImpl.class, agentEmailBucket);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AgentEmailBucketImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new agent email bucket with the primary key. Does not add the agent email bucket to the database.
	 *
	 * @param agentEmailBucketId the primary key for the new agent email bucket
	 * @return the new agent email bucket
	 */
	@Override
	public AgentEmailBucket create(long agentEmailBucketId) {
		AgentEmailBucket agentEmailBucket = new AgentEmailBucketImpl();

		agentEmailBucket.setNew(true);
		agentEmailBucket.setPrimaryKey(agentEmailBucketId);

		agentEmailBucket.setCompanyId(CompanyThreadLocal.getCompanyId());

		return agentEmailBucket;
	}

	/**
	 * Removes the agent email bucket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentEmailBucketId the primary key of the agent email bucket
	 * @return the agent email bucket that was removed
	 * @throws NoSuchAgentEmailBucketException if a agent email bucket with the primary key could not be found
	 */
	@Override
	public AgentEmailBucket remove(long agentEmailBucketId)
		throws NoSuchAgentEmailBucketException {

		return remove((Serializable)agentEmailBucketId);
	}

	/**
	 * Removes the agent email bucket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the agent email bucket
	 * @return the agent email bucket that was removed
	 * @throws NoSuchAgentEmailBucketException if a agent email bucket with the primary key could not be found
	 */
	@Override
	public AgentEmailBucket remove(Serializable primaryKey)
		throws NoSuchAgentEmailBucketException {

		Session session = null;

		try {
			session = openSession();

			AgentEmailBucket agentEmailBucket = (AgentEmailBucket)session.get(
				AgentEmailBucketImpl.class, primaryKey);

			if (agentEmailBucket == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAgentEmailBucketException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(agentEmailBucket);
		}
		catch (NoSuchAgentEmailBucketException noSuchEntityException) {
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
	protected AgentEmailBucket removeImpl(AgentEmailBucket agentEmailBucket) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(agentEmailBucket)) {
				agentEmailBucket = (AgentEmailBucket)session.get(
					AgentEmailBucketImpl.class,
					agentEmailBucket.getPrimaryKeyObj());
			}

			if (agentEmailBucket != null) {
				session.delete(agentEmailBucket);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (agentEmailBucket != null) {
			clearCache(agentEmailBucket);
		}

		return agentEmailBucket;
	}

	@Override
	public AgentEmailBucket updateImpl(AgentEmailBucket agentEmailBucket) {
		boolean isNew = agentEmailBucket.isNew();

		if (!(agentEmailBucket instanceof AgentEmailBucketModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(agentEmailBucket.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					agentEmailBucket);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in agentEmailBucket proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AgentEmailBucket implementation " +
					agentEmailBucket.getClass());
		}

		AgentEmailBucketModelImpl agentEmailBucketModelImpl =
			(AgentEmailBucketModelImpl)agentEmailBucket;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (agentEmailBucket.getCreateDate() == null)) {
			if (serviceContext == null) {
				agentEmailBucket.setCreateDate(date);
			}
			else {
				agentEmailBucket.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!agentEmailBucketModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				agentEmailBucket.setModifiedDate(date);
			}
			else {
				agentEmailBucket.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(agentEmailBucket);
			}
			else {
				agentEmailBucket = (AgentEmailBucket)session.merge(
					agentEmailBucket);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AgentEmailBucketImpl.class, agentEmailBucketModelImpl, false, true);

		if (isNew) {
			agentEmailBucket.setNew(false);
		}

		agentEmailBucket.resetOriginalValues();

		return agentEmailBucket;
	}

	/**
	 * Returns the agent email bucket with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the agent email bucket
	 * @return the agent email bucket
	 * @throws NoSuchAgentEmailBucketException if a agent email bucket with the primary key could not be found
	 */
	@Override
	public AgentEmailBucket findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAgentEmailBucketException {

		AgentEmailBucket agentEmailBucket = fetchByPrimaryKey(primaryKey);

		if (agentEmailBucket == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAgentEmailBucketException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return agentEmailBucket;
	}

	/**
	 * Returns the agent email bucket with the primary key or throws a <code>NoSuchAgentEmailBucketException</code> if it could not be found.
	 *
	 * @param agentEmailBucketId the primary key of the agent email bucket
	 * @return the agent email bucket
	 * @throws NoSuchAgentEmailBucketException if a agent email bucket with the primary key could not be found
	 */
	@Override
	public AgentEmailBucket findByPrimaryKey(long agentEmailBucketId)
		throws NoSuchAgentEmailBucketException {

		return findByPrimaryKey((Serializable)agentEmailBucketId);
	}

	/**
	 * Returns the agent email bucket with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentEmailBucketId the primary key of the agent email bucket
	 * @return the agent email bucket, or <code>null</code> if a agent email bucket with the primary key could not be found
	 */
	@Override
	public AgentEmailBucket fetchByPrimaryKey(long agentEmailBucketId) {
		return fetchByPrimaryKey((Serializable)agentEmailBucketId);
	}

	/**
	 * Returns all the agent email buckets.
	 *
	 * @return the agent email buckets
	 */
	@Override
	public List<AgentEmailBucket> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent email buckets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentEmailBucketModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent email buckets
	 * @param end the upper bound of the range of agent email buckets (not inclusive)
	 * @return the range of agent email buckets
	 */
	@Override
	public List<AgentEmailBucket> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent email buckets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentEmailBucketModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent email buckets
	 * @param end the upper bound of the range of agent email buckets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agent email buckets
	 */
	@Override
	public List<AgentEmailBucket> findAll(
		int start, int end,
		OrderByComparator<AgentEmailBucket> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent email buckets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentEmailBucketModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent email buckets
	 * @param end the upper bound of the range of agent email buckets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agent email buckets
	 */
	@Override
	public List<AgentEmailBucket> findAll(
		int start, int end,
		OrderByComparator<AgentEmailBucket> orderByComparator,
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

		List<AgentEmailBucket> list = null;

		if (useFinderCache) {
			list = (List<AgentEmailBucket>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AGENTEMAILBUCKET);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AGENTEMAILBUCKET;

				sql = sql.concat(AgentEmailBucketModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AgentEmailBucket>)QueryUtil.list(
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
	 * Removes all the agent email buckets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AgentEmailBucket agentEmailBucket : findAll()) {
			remove(agentEmailBucket);
		}
	}

	/**
	 * Returns the number of agent email buckets.
	 *
	 * @return the number of agent email buckets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AGENTEMAILBUCKET);

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
		return "agentEmailBucketId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AGENTEMAILBUCKET;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AgentEmailBucketModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the agent email bucket persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new AgentEmailBucketModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", AgentEmailBucket.class.getName()));

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

		_finderPathWithPaginationFindBystatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status_"}, true);

		_finderPathWithoutPaginationFindBystatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] {String.class.getName()}, new String[] {"status_"},
			true);

		_finderPathCountBystatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] {String.class.getName()}, new String[] {"status_"},
			false);

		_setAgentEmailBucketUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAgentEmailBucketUtilPersistence(null);

		entityCache.removeCache(AgentEmailBucketImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setAgentEmailBucketUtilPersistence(
		AgentEmailBucketPersistence agentEmailBucketPersistence) {

		try {
			Field field = AgentEmailBucketUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, agentEmailBucketPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = APPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = APPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = APPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_AGENTEMAILBUCKET =
		"SELECT agentEmailBucket FROM AgentEmailBucket agentEmailBucket";

	private static final String _SQL_SELECT_AGENTEMAILBUCKET_WHERE =
		"SELECT agentEmailBucket FROM AgentEmailBucket agentEmailBucket WHERE ";

	private static final String _SQL_COUNT_AGENTEMAILBUCKET =
		"SELECT COUNT(agentEmailBucket) FROM AgentEmailBucket agentEmailBucket";

	private static final String _SQL_COUNT_AGENTEMAILBUCKET_WHERE =
		"SELECT COUNT(agentEmailBucket) FROM AgentEmailBucket agentEmailBucket WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "agentEmailBucket.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AgentEmailBucket exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AgentEmailBucket exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AgentEmailBucketPersistenceImpl.class);

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

	private static class AgentEmailBucketModelArgumentsResolver
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

			AgentEmailBucketModelImpl agentEmailBucketModelImpl =
				(AgentEmailBucketModelImpl)baseModel;

			long columnBitmask = agentEmailBucketModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					agentEmailBucketModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						agentEmailBucketModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					agentEmailBucketModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			AgentEmailBucketModelImpl agentEmailBucketModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						agentEmailBucketModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = agentEmailBucketModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}