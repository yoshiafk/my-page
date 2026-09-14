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

package com.mypage.user.service.persistence.impl;

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

import com.mypage.user.exception.NoSuchMypageUserTimelineException;
import com.mypage.user.model.MypageUserTimeline;
import com.mypage.user.model.impl.MypageUserTimelineImpl;
import com.mypage.user.model.impl.MypageUserTimelineModelImpl;
import com.mypage.user.service.persistence.MypageUserTimelinePersistence;
import com.mypage.user.service.persistence.MypageUserTimelineUtil;
import com.mypage.user.service.persistence.impl.constants.MPUPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
 * The persistence implementation for the mypage user timeline service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MypageUserTimelinePersistence.class)
public class MypageUserTimelinePersistenceImpl
	extends BasePersistenceImpl<MypageUserTimeline>
	implements MypageUserTimelinePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MypageUserTimelineUtil</code> to access the mypage user timeline persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MypageUserTimelineImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBygetByMypageUserId;
	private FinderPath _finderPathWithoutPaginationFindBygetByMypageUserId;
	private FinderPath _finderPathCountBygetByMypageUserId;

	/**
	 * Returns all the mypage user timelines where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching mypage user timelines
	 */
	@Override
	public List<MypageUserTimeline> findBygetByMypageUserId(long mypageUserId) {
		return findBygetByMypageUserId(
			mypageUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mypage user timelines where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user timelines
	 * @param end the upper bound of the range of mypage user timelines (not inclusive)
	 * @return the range of matching mypage user timelines
	 */
	@Override
	public List<MypageUserTimeline> findBygetByMypageUserId(
		long mypageUserId, int start, int end) {

		return findBygetByMypageUserId(mypageUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the mypage user timelines where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user timelines
	 * @param end the upper bound of the range of mypage user timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching mypage user timelines
	 */
	@Override
	public List<MypageUserTimeline> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MypageUserTimeline> orderByComparator) {

		return findBygetByMypageUserId(
			mypageUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mypage user timelines where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user timelines
	 * @param end the upper bound of the range of mypage user timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching mypage user timelines
	 */
	@Override
	public List<MypageUserTimeline> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MypageUserTimeline> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBygetByMypageUserId;
				finderArgs = new Object[] {mypageUserId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBygetByMypageUserId;
			finderArgs = new Object[] {
				mypageUserId, start, end, orderByComparator
			};
		}

		List<MypageUserTimeline> list = null;

		if (useFinderCache) {
			list = (List<MypageUserTimeline>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MypageUserTimeline mypageUserTimeline : list) {
					if (mypageUserId != mypageUserTimeline.getMypageUserId()) {
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

			sb.append(_SQL_SELECT_MYPAGEUSERTIMELINE_WHERE);

			sb.append(_FINDER_COLUMN_GETBYMYPAGEUSERID_MYPAGEUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MypageUserTimelineModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserId);

				list = (List<MypageUserTimeline>)QueryUtil.list(
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
	 * Returns the first mypage user timeline in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user timeline
	 * @throws NoSuchMypageUserTimelineException if a matching mypage user timeline could not be found
	 */
	@Override
	public MypageUserTimeline findBygetByMypageUserId_First(
			long mypageUserId,
			OrderByComparator<MypageUserTimeline> orderByComparator)
		throws NoSuchMypageUserTimelineException {

		MypageUserTimeline mypageUserTimeline = fetchBygetByMypageUserId_First(
			mypageUserId, orderByComparator);

		if (mypageUserTimeline != null) {
			return mypageUserTimeline;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserId=");
		sb.append(mypageUserId);

		sb.append("}");

		throw new NoSuchMypageUserTimelineException(sb.toString());
	}

	/**
	 * Returns the first mypage user timeline in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user timeline, or <code>null</code> if a matching mypage user timeline could not be found
	 */
	@Override
	public MypageUserTimeline fetchBygetByMypageUserId_First(
		long mypageUserId,
		OrderByComparator<MypageUserTimeline> orderByComparator) {

		List<MypageUserTimeline> list = findBygetByMypageUserId(
			mypageUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last mypage user timeline in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user timeline
	 * @throws NoSuchMypageUserTimelineException if a matching mypage user timeline could not be found
	 */
	@Override
	public MypageUserTimeline findBygetByMypageUserId_Last(
			long mypageUserId,
			OrderByComparator<MypageUserTimeline> orderByComparator)
		throws NoSuchMypageUserTimelineException {

		MypageUserTimeline mypageUserTimeline = fetchBygetByMypageUserId_Last(
			mypageUserId, orderByComparator);

		if (mypageUserTimeline != null) {
			return mypageUserTimeline;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserId=");
		sb.append(mypageUserId);

		sb.append("}");

		throw new NoSuchMypageUserTimelineException(sb.toString());
	}

	/**
	 * Returns the last mypage user timeline in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user timeline, or <code>null</code> if a matching mypage user timeline could not be found
	 */
	@Override
	public MypageUserTimeline fetchBygetByMypageUserId_Last(
		long mypageUserId,
		OrderByComparator<MypageUserTimeline> orderByComparator) {

		int count = countBygetByMypageUserId(mypageUserId);

		if (count == 0) {
			return null;
		}

		List<MypageUserTimeline> list = findBygetByMypageUserId(
			mypageUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the mypage user timelines before and after the current mypage user timeline in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserTimelineId the primary key of the current mypage user timeline
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next mypage user timeline
	 * @throws NoSuchMypageUserTimelineException if a mypage user timeline with the primary key could not be found
	 */
	@Override
	public MypageUserTimeline[] findBygetByMypageUserId_PrevAndNext(
			long mypageUserTimelineId, long mypageUserId,
			OrderByComparator<MypageUserTimeline> orderByComparator)
		throws NoSuchMypageUserTimelineException {

		MypageUserTimeline mypageUserTimeline = findByPrimaryKey(
			mypageUserTimelineId);

		Session session = null;

		try {
			session = openSession();

			MypageUserTimeline[] array = new MypageUserTimelineImpl[3];

			array[0] = getBygetByMypageUserId_PrevAndNext(
				session, mypageUserTimeline, mypageUserId, orderByComparator,
				true);

			array[1] = mypageUserTimeline;

			array[2] = getBygetByMypageUserId_PrevAndNext(
				session, mypageUserTimeline, mypageUserId, orderByComparator,
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

	protected MypageUserTimeline getBygetByMypageUserId_PrevAndNext(
		Session session, MypageUserTimeline mypageUserTimeline,
		long mypageUserId,
		OrderByComparator<MypageUserTimeline> orderByComparator,
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

		sb.append(_SQL_SELECT_MYPAGEUSERTIMELINE_WHERE);

		sb.append(_FINDER_COLUMN_GETBYMYPAGEUSERID_MYPAGEUSERID_2);

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
			sb.append(MypageUserTimelineModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(mypageUserId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						mypageUserTimeline)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MypageUserTimeline> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the mypage user timelines where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	@Override
	public void removeBygetByMypageUserId(long mypageUserId) {
		for (MypageUserTimeline mypageUserTimeline :
				findBygetByMypageUserId(
					mypageUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(mypageUserTimeline);
		}
	}

	/**
	 * Returns the number of mypage user timelines where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching mypage user timelines
	 */
	@Override
	public int countBygetByMypageUserId(long mypageUserId) {
		FinderPath finderPath = _finderPathCountBygetByMypageUserId;

		Object[] finderArgs = new Object[] {mypageUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MYPAGEUSERTIMELINE_WHERE);

			sb.append(_FINDER_COLUMN_GETBYMYPAGEUSERID_MYPAGEUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserId);

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
		_FINDER_COLUMN_GETBYMYPAGEUSERID_MYPAGEUSERID_2 =
			"mypageUserTimeline.mypageUserId = ?";

	public MypageUserTimelinePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("text", "text_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MypageUserTimeline.class);

		setModelImplClass(MypageUserTimelineImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the mypage user timeline in the entity cache if it is enabled.
	 *
	 * @param mypageUserTimeline the mypage user timeline
	 */
	@Override
	public void cacheResult(MypageUserTimeline mypageUserTimeline) {
		entityCache.putResult(
			MypageUserTimelineImpl.class, mypageUserTimeline.getPrimaryKey(),
			mypageUserTimeline);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the mypage user timelines in the entity cache if it is enabled.
	 *
	 * @param mypageUserTimelines the mypage user timelines
	 */
	@Override
	public void cacheResult(List<MypageUserTimeline> mypageUserTimelines) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (mypageUserTimelines.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MypageUserTimeline mypageUserTimeline : mypageUserTimelines) {
			if (entityCache.getResult(
					MypageUserTimelineImpl.class,
					mypageUserTimeline.getPrimaryKey()) == null) {

				cacheResult(mypageUserTimeline);
			}
		}
	}

	/**
	 * Clears the cache for all mypage user timelines.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MypageUserTimelineImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the mypage user timeline.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MypageUserTimeline mypageUserTimeline) {
		entityCache.removeResult(
			MypageUserTimelineImpl.class, mypageUserTimeline);
	}

	@Override
	public void clearCache(List<MypageUserTimeline> mypageUserTimelines) {
		for (MypageUserTimeline mypageUserTimeline : mypageUserTimelines) {
			entityCache.removeResult(
				MypageUserTimelineImpl.class, mypageUserTimeline);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MypageUserTimelineImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new mypage user timeline with the primary key. Does not add the mypage user timeline to the database.
	 *
	 * @param mypageUserTimelineId the primary key for the new mypage user timeline
	 * @return the new mypage user timeline
	 */
	@Override
	public MypageUserTimeline create(long mypageUserTimelineId) {
		MypageUserTimeline mypageUserTimeline = new MypageUserTimelineImpl();

		mypageUserTimeline.setNew(true);
		mypageUserTimeline.setPrimaryKey(mypageUserTimelineId);

		mypageUserTimeline.setCompanyId(CompanyThreadLocal.getCompanyId());

		return mypageUserTimeline;
	}

	/**
	 * Removes the mypage user timeline with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserTimelineId the primary key of the mypage user timeline
	 * @return the mypage user timeline that was removed
	 * @throws NoSuchMypageUserTimelineException if a mypage user timeline with the primary key could not be found
	 */
	@Override
	public MypageUserTimeline remove(long mypageUserTimelineId)
		throws NoSuchMypageUserTimelineException {

		return remove((Serializable)mypageUserTimelineId);
	}

	/**
	 * Removes the mypage user timeline with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mypage user timeline
	 * @return the mypage user timeline that was removed
	 * @throws NoSuchMypageUserTimelineException if a mypage user timeline with the primary key could not be found
	 */
	@Override
	public MypageUserTimeline remove(Serializable primaryKey)
		throws NoSuchMypageUserTimelineException {

		Session session = null;

		try {
			session = openSession();

			MypageUserTimeline mypageUserTimeline =
				(MypageUserTimeline)session.get(
					MypageUserTimelineImpl.class, primaryKey);

			if (mypageUserTimeline == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMypageUserTimelineException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(mypageUserTimeline);
		}
		catch (NoSuchMypageUserTimelineException noSuchEntityException) {
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
	protected MypageUserTimeline removeImpl(
		MypageUserTimeline mypageUserTimeline) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mypageUserTimeline)) {
				mypageUserTimeline = (MypageUserTimeline)session.get(
					MypageUserTimelineImpl.class,
					mypageUserTimeline.getPrimaryKeyObj());
			}

			if (mypageUserTimeline != null) {
				session.delete(mypageUserTimeline);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (mypageUserTimeline != null) {
			clearCache(mypageUserTimeline);
		}

		return mypageUserTimeline;
	}

	@Override
	public MypageUserTimeline updateImpl(
		MypageUserTimeline mypageUserTimeline) {

		boolean isNew = mypageUserTimeline.isNew();

		if (!(mypageUserTimeline instanceof MypageUserTimelineModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(mypageUserTimeline.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					mypageUserTimeline);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in mypageUserTimeline proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MypageUserTimeline implementation " +
					mypageUserTimeline.getClass());
		}

		MypageUserTimelineModelImpl mypageUserTimelineModelImpl =
			(MypageUserTimelineModelImpl)mypageUserTimeline;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (mypageUserTimeline.getCreateDate() == null)) {
			if (serviceContext == null) {
				mypageUserTimeline.setCreateDate(date);
			}
			else {
				mypageUserTimeline.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!mypageUserTimelineModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				mypageUserTimeline.setModifiedDate(date);
			}
			else {
				mypageUserTimeline.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(mypageUserTimeline);
			}
			else {
				mypageUserTimeline = (MypageUserTimeline)session.merge(
					mypageUserTimeline);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MypageUserTimelineImpl.class, mypageUserTimelineModelImpl, false,
			true);

		if (isNew) {
			mypageUserTimeline.setNew(false);
		}

		mypageUserTimeline.resetOriginalValues();

		return mypageUserTimeline;
	}

	/**
	 * Returns the mypage user timeline with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mypage user timeline
	 * @return the mypage user timeline
	 * @throws NoSuchMypageUserTimelineException if a mypage user timeline with the primary key could not be found
	 */
	@Override
	public MypageUserTimeline findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMypageUserTimelineException {

		MypageUserTimeline mypageUserTimeline = fetchByPrimaryKey(primaryKey);

		if (mypageUserTimeline == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMypageUserTimelineException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return mypageUserTimeline;
	}

	/**
	 * Returns the mypage user timeline with the primary key or throws a <code>NoSuchMypageUserTimelineException</code> if it could not be found.
	 *
	 * @param mypageUserTimelineId the primary key of the mypage user timeline
	 * @return the mypage user timeline
	 * @throws NoSuchMypageUserTimelineException if a mypage user timeline with the primary key could not be found
	 */
	@Override
	public MypageUserTimeline findByPrimaryKey(long mypageUserTimelineId)
		throws NoSuchMypageUserTimelineException {

		return findByPrimaryKey((Serializable)mypageUserTimelineId);
	}

	/**
	 * Returns the mypage user timeline with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserTimelineId the primary key of the mypage user timeline
	 * @return the mypage user timeline, or <code>null</code> if a mypage user timeline with the primary key could not be found
	 */
	@Override
	public MypageUserTimeline fetchByPrimaryKey(long mypageUserTimelineId) {
		return fetchByPrimaryKey((Serializable)mypageUserTimelineId);
	}

	/**
	 * Returns all the mypage user timelines.
	 *
	 * @return the mypage user timelines
	 */
	@Override
	public List<MypageUserTimeline> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mypage user timelines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user timelines
	 * @param end the upper bound of the range of mypage user timelines (not inclusive)
	 * @return the range of mypage user timelines
	 */
	@Override
	public List<MypageUserTimeline> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the mypage user timelines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user timelines
	 * @param end the upper bound of the range of mypage user timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage user timelines
	 */
	@Override
	public List<MypageUserTimeline> findAll(
		int start, int end,
		OrderByComparator<MypageUserTimeline> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mypage user timelines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user timelines
	 * @param end the upper bound of the range of mypage user timelines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage user timelines
	 */
	@Override
	public List<MypageUserTimeline> findAll(
		int start, int end,
		OrderByComparator<MypageUserTimeline> orderByComparator,
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

		List<MypageUserTimeline> list = null;

		if (useFinderCache) {
			list = (List<MypageUserTimeline>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MYPAGEUSERTIMELINE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MYPAGEUSERTIMELINE;

				sql = sql.concat(MypageUserTimelineModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MypageUserTimeline>)QueryUtil.list(
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
	 * Removes all the mypage user timelines from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MypageUserTimeline mypageUserTimeline : findAll()) {
			remove(mypageUserTimeline);
		}
	}

	/**
	 * Returns the number of mypage user timelines.
	 *
	 * @return the number of mypage user timelines
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
					_SQL_COUNT_MYPAGEUSERTIMELINE);

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
		return "mypageUserTimelineId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MYPAGEUSERTIMELINE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MypageUserTimelineModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the mypage user timeline persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new MypageUserTimelineModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MypageUserTimeline.class.getName()));

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

		_finderPathWithPaginationFindBygetByMypageUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygetByMypageUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"mypageUserId"}, true);

		_finderPathWithoutPaginationFindBygetByMypageUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBygetByMypageUserId", new String[] {Long.class.getName()},
			new String[] {"mypageUserId"}, true);

		_finderPathCountBygetByMypageUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBygetByMypageUserId", new String[] {Long.class.getName()},
			new String[] {"mypageUserId"}, false);

		_setMypageUserTimelineUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMypageUserTimelineUtilPersistence(null);

		entityCache.removeCache(MypageUserTimelineImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setMypageUserTimelineUtilPersistence(
		MypageUserTimelinePersistence mypageUserTimelinePersistence) {

		try {
			Field field = MypageUserTimelineUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, mypageUserTimelinePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MPUPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MPUPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MPUPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_MYPAGEUSERTIMELINE =
		"SELECT mypageUserTimeline FROM MypageUserTimeline mypageUserTimeline";

	private static final String _SQL_SELECT_MYPAGEUSERTIMELINE_WHERE =
		"SELECT mypageUserTimeline FROM MypageUserTimeline mypageUserTimeline WHERE ";

	private static final String _SQL_COUNT_MYPAGEUSERTIMELINE =
		"SELECT COUNT(mypageUserTimeline) FROM MypageUserTimeline mypageUserTimeline";

	private static final String _SQL_COUNT_MYPAGEUSERTIMELINE_WHERE =
		"SELECT COUNT(mypageUserTimeline) FROM MypageUserTimeline mypageUserTimeline WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "mypageUserTimeline.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MypageUserTimeline exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MypageUserTimeline exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MypageUserTimelinePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"text"});

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

	private static class MypageUserTimelineModelArgumentsResolver
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

			MypageUserTimelineModelImpl mypageUserTimelineModelImpl =
				(MypageUserTimelineModelImpl)baseModel;

			long columnBitmask = mypageUserTimelineModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					mypageUserTimelineModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						mypageUserTimelineModelImpl.getColumnBitmask(
							columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(MypageUserTimelinePersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					mypageUserTimelineModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			MypageUserTimelineModelImpl mypageUserTimelineModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						mypageUserTimelineModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = mypageUserTimelineModelImpl.getColumnValue(
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
				MypageUserTimelineModelImpl.getColumnBitmask("createDate");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}