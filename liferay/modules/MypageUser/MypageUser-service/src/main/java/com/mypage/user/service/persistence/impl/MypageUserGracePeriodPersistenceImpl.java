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

import com.mypage.user.exception.NoSuchMypageUserGracePeriodException;
import com.mypage.user.model.MypageUserGracePeriod;
import com.mypage.user.model.impl.MypageUserGracePeriodImpl;
import com.mypage.user.model.impl.MypageUserGracePeriodModelImpl;
import com.mypage.user.service.persistence.MypageUserGracePeriodPersistence;
import com.mypage.user.service.persistence.MypageUserGracePeriodUtil;
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
 * The persistence implementation for the mypage user grace period service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MypageUserGracePeriodPersistence.class)
public class MypageUserGracePeriodPersistenceImpl
	extends BasePersistenceImpl<MypageUserGracePeriod>
	implements MypageUserGracePeriodPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MypageUserGracePeriodUtil</code> to access the mypage user grace period persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MypageUserGracePeriodImpl.class.getName();

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
	 * Returns all the mypage user grace periods where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching mypage user grace periods
	 */
	@Override
	public List<MypageUserGracePeriod> findBygetByMypageUserId(
		long mypageUserId) {

		return findBygetByMypageUserId(
			mypageUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mypage user grace periods where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @return the range of matching mypage user grace periods
	 */
	@Override
	public List<MypageUserGracePeriod> findBygetByMypageUserId(
		long mypageUserId, int start, int end) {

		return findBygetByMypageUserId(mypageUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the mypage user grace periods where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching mypage user grace periods
	 */
	@Override
	public List<MypageUserGracePeriod> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MypageUserGracePeriod> orderByComparator) {

		return findBygetByMypageUserId(
			mypageUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mypage user grace periods where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching mypage user grace periods
	 */
	@Override
	public List<MypageUserGracePeriod> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MypageUserGracePeriod> orderByComparator,
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

		List<MypageUserGracePeriod> list = null;

		if (useFinderCache) {
			list = (List<MypageUserGracePeriod>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MypageUserGracePeriod mypageUserGracePeriod : list) {
					if (mypageUserId !=
							mypageUserGracePeriod.getMypageUserId()) {

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

			sb.append(_SQL_SELECT_MYPAGEUSERGRACEPERIOD_WHERE);

			sb.append(_FINDER_COLUMN_GETBYMYPAGEUSERID_MYPAGEUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MypageUserGracePeriodModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserId);

				list = (List<MypageUserGracePeriod>)QueryUtil.list(
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
	 * Returns the first mypage user grace period in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user grace period
	 * @throws NoSuchMypageUserGracePeriodException if a matching mypage user grace period could not be found
	 */
	@Override
	public MypageUserGracePeriod findBygetByMypageUserId_First(
			long mypageUserId,
			OrderByComparator<MypageUserGracePeriod> orderByComparator)
		throws NoSuchMypageUserGracePeriodException {

		MypageUserGracePeriod mypageUserGracePeriod =
			fetchBygetByMypageUserId_First(mypageUserId, orderByComparator);

		if (mypageUserGracePeriod != null) {
			return mypageUserGracePeriod;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserId=");
		sb.append(mypageUserId);

		sb.append("}");

		throw new NoSuchMypageUserGracePeriodException(sb.toString());
	}

	/**
	 * Returns the first mypage user grace period in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user grace period, or <code>null</code> if a matching mypage user grace period could not be found
	 */
	@Override
	public MypageUserGracePeriod fetchBygetByMypageUserId_First(
		long mypageUserId,
		OrderByComparator<MypageUserGracePeriod> orderByComparator) {

		List<MypageUserGracePeriod> list = findBygetByMypageUserId(
			mypageUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last mypage user grace period in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user grace period
	 * @throws NoSuchMypageUserGracePeriodException if a matching mypage user grace period could not be found
	 */
	@Override
	public MypageUserGracePeriod findBygetByMypageUserId_Last(
			long mypageUserId,
			OrderByComparator<MypageUserGracePeriod> orderByComparator)
		throws NoSuchMypageUserGracePeriodException {

		MypageUserGracePeriod mypageUserGracePeriod =
			fetchBygetByMypageUserId_Last(mypageUserId, orderByComparator);

		if (mypageUserGracePeriod != null) {
			return mypageUserGracePeriod;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserId=");
		sb.append(mypageUserId);

		sb.append("}");

		throw new NoSuchMypageUserGracePeriodException(sb.toString());
	}

	/**
	 * Returns the last mypage user grace period in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user grace period, or <code>null</code> if a matching mypage user grace period could not be found
	 */
	@Override
	public MypageUserGracePeriod fetchBygetByMypageUserId_Last(
		long mypageUserId,
		OrderByComparator<MypageUserGracePeriod> orderByComparator) {

		int count = countBygetByMypageUserId(mypageUserId);

		if (count == 0) {
			return null;
		}

		List<MypageUserGracePeriod> list = findBygetByMypageUserId(
			mypageUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the mypage user grace periods before and after the current mypage user grace period in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserGracePeriodId the primary key of the current mypage user grace period
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next mypage user grace period
	 * @throws NoSuchMypageUserGracePeriodException if a mypage user grace period with the primary key could not be found
	 */
	@Override
	public MypageUserGracePeriod[] findBygetByMypageUserId_PrevAndNext(
			long mypageUserGracePeriodId, long mypageUserId,
			OrderByComparator<MypageUserGracePeriod> orderByComparator)
		throws NoSuchMypageUserGracePeriodException {

		MypageUserGracePeriod mypageUserGracePeriod = findByPrimaryKey(
			mypageUserGracePeriodId);

		Session session = null;

		try {
			session = openSession();

			MypageUserGracePeriod[] array = new MypageUserGracePeriodImpl[3];

			array[0] = getBygetByMypageUserId_PrevAndNext(
				session, mypageUserGracePeriod, mypageUserId, orderByComparator,
				true);

			array[1] = mypageUserGracePeriod;

			array[2] = getBygetByMypageUserId_PrevAndNext(
				session, mypageUserGracePeriod, mypageUserId, orderByComparator,
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

	protected MypageUserGracePeriod getBygetByMypageUserId_PrevAndNext(
		Session session, MypageUserGracePeriod mypageUserGracePeriod,
		long mypageUserId,
		OrderByComparator<MypageUserGracePeriod> orderByComparator,
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

		sb.append(_SQL_SELECT_MYPAGEUSERGRACEPERIOD_WHERE);

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
			sb.append(MypageUserGracePeriodModelImpl.ORDER_BY_JPQL);
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
						mypageUserGracePeriod)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MypageUserGracePeriod> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the mypage user grace periods where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	@Override
	public void removeBygetByMypageUserId(long mypageUserId) {
		for (MypageUserGracePeriod mypageUserGracePeriod :
				findBygetByMypageUserId(
					mypageUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(mypageUserGracePeriod);
		}
	}

	/**
	 * Returns the number of mypage user grace periods where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching mypage user grace periods
	 */
	@Override
	public int countBygetByMypageUserId(long mypageUserId) {
		FinderPath finderPath = _finderPathCountBygetByMypageUserId;

		Object[] finderArgs = new Object[] {mypageUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MYPAGEUSERGRACEPERIOD_WHERE);

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
			"mypageUserGracePeriod.mypageUserId = ?";

	public MypageUserGracePeriodPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MypageUserGracePeriod.class);

		setModelImplClass(MypageUserGracePeriodImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the mypage user grace period in the entity cache if it is enabled.
	 *
	 * @param mypageUserGracePeriod the mypage user grace period
	 */
	@Override
	public void cacheResult(MypageUserGracePeriod mypageUserGracePeriod) {
		entityCache.putResult(
			MypageUserGracePeriodImpl.class,
			mypageUserGracePeriod.getPrimaryKey(), mypageUserGracePeriod);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the mypage user grace periods in the entity cache if it is enabled.
	 *
	 * @param mypageUserGracePeriods the mypage user grace periods
	 */
	@Override
	public void cacheResult(
		List<MypageUserGracePeriod> mypageUserGracePeriods) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (mypageUserGracePeriods.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MypageUserGracePeriod mypageUserGracePeriod :
				mypageUserGracePeriods) {

			if (entityCache.getResult(
					MypageUserGracePeriodImpl.class,
					mypageUserGracePeriod.getPrimaryKey()) == null) {

				cacheResult(mypageUserGracePeriod);
			}
		}
	}

	/**
	 * Clears the cache for all mypage user grace periods.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MypageUserGracePeriodImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the mypage user grace period.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MypageUserGracePeriod mypageUserGracePeriod) {
		entityCache.removeResult(
			MypageUserGracePeriodImpl.class, mypageUserGracePeriod);
	}

	@Override
	public void clearCache(List<MypageUserGracePeriod> mypageUserGracePeriods) {
		for (MypageUserGracePeriod mypageUserGracePeriod :
				mypageUserGracePeriods) {

			entityCache.removeResult(
				MypageUserGracePeriodImpl.class, mypageUserGracePeriod);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				MypageUserGracePeriodImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new mypage user grace period with the primary key. Does not add the mypage user grace period to the database.
	 *
	 * @param mypageUserGracePeriodId the primary key for the new mypage user grace period
	 * @return the new mypage user grace period
	 */
	@Override
	public MypageUserGracePeriod create(long mypageUserGracePeriodId) {
		MypageUserGracePeriod mypageUserGracePeriod =
			new MypageUserGracePeriodImpl();

		mypageUserGracePeriod.setNew(true);
		mypageUserGracePeriod.setPrimaryKey(mypageUserGracePeriodId);

		mypageUserGracePeriod.setCompanyId(CompanyThreadLocal.getCompanyId());

		return mypageUserGracePeriod;
	}

	/**
	 * Removes the mypage user grace period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserGracePeriodId the primary key of the mypage user grace period
	 * @return the mypage user grace period that was removed
	 * @throws NoSuchMypageUserGracePeriodException if a mypage user grace period with the primary key could not be found
	 */
	@Override
	public MypageUserGracePeriod remove(long mypageUserGracePeriodId)
		throws NoSuchMypageUserGracePeriodException {

		return remove((Serializable)mypageUserGracePeriodId);
	}

	/**
	 * Removes the mypage user grace period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mypage user grace period
	 * @return the mypage user grace period that was removed
	 * @throws NoSuchMypageUserGracePeriodException if a mypage user grace period with the primary key could not be found
	 */
	@Override
	public MypageUserGracePeriod remove(Serializable primaryKey)
		throws NoSuchMypageUserGracePeriodException {

		Session session = null;

		try {
			session = openSession();

			MypageUserGracePeriod mypageUserGracePeriod =
				(MypageUserGracePeriod)session.get(
					MypageUserGracePeriodImpl.class, primaryKey);

			if (mypageUserGracePeriod == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMypageUserGracePeriodException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(mypageUserGracePeriod);
		}
		catch (NoSuchMypageUserGracePeriodException noSuchEntityException) {
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
	protected MypageUserGracePeriod removeImpl(
		MypageUserGracePeriod mypageUserGracePeriod) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mypageUserGracePeriod)) {
				mypageUserGracePeriod = (MypageUserGracePeriod)session.get(
					MypageUserGracePeriodImpl.class,
					mypageUserGracePeriod.getPrimaryKeyObj());
			}

			if (mypageUserGracePeriod != null) {
				session.delete(mypageUserGracePeriod);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (mypageUserGracePeriod != null) {
			clearCache(mypageUserGracePeriod);
		}

		return mypageUserGracePeriod;
	}

	@Override
	public MypageUserGracePeriod updateImpl(
		MypageUserGracePeriod mypageUserGracePeriod) {

		boolean isNew = mypageUserGracePeriod.isNew();

		if (!(mypageUserGracePeriod instanceof
				MypageUserGracePeriodModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(mypageUserGracePeriod.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					mypageUserGracePeriod);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in mypageUserGracePeriod proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MypageUserGracePeriod implementation " +
					mypageUserGracePeriod.getClass());
		}

		MypageUserGracePeriodModelImpl mypageUserGracePeriodModelImpl =
			(MypageUserGracePeriodModelImpl)mypageUserGracePeriod;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (mypageUserGracePeriod.getCreateDate() == null)) {
			if (serviceContext == null) {
				mypageUserGracePeriod.setCreateDate(date);
			}
			else {
				mypageUserGracePeriod.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!mypageUserGracePeriodModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				mypageUserGracePeriod.setModifiedDate(date);
			}
			else {
				mypageUserGracePeriod.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(mypageUserGracePeriod);
			}
			else {
				mypageUserGracePeriod = (MypageUserGracePeriod)session.merge(
					mypageUserGracePeriod);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MypageUserGracePeriodImpl.class, mypageUserGracePeriodModelImpl,
			false, true);

		if (isNew) {
			mypageUserGracePeriod.setNew(false);
		}

		mypageUserGracePeriod.resetOriginalValues();

		return mypageUserGracePeriod;
	}

	/**
	 * Returns the mypage user grace period with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mypage user grace period
	 * @return the mypage user grace period
	 * @throws NoSuchMypageUserGracePeriodException if a mypage user grace period with the primary key could not be found
	 */
	@Override
	public MypageUserGracePeriod findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMypageUserGracePeriodException {

		MypageUserGracePeriod mypageUserGracePeriod = fetchByPrimaryKey(
			primaryKey);

		if (mypageUserGracePeriod == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMypageUserGracePeriodException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return mypageUserGracePeriod;
	}

	/**
	 * Returns the mypage user grace period with the primary key or throws a <code>NoSuchMypageUserGracePeriodException</code> if it could not be found.
	 *
	 * @param mypageUserGracePeriodId the primary key of the mypage user grace period
	 * @return the mypage user grace period
	 * @throws NoSuchMypageUserGracePeriodException if a mypage user grace period with the primary key could not be found
	 */
	@Override
	public MypageUserGracePeriod findByPrimaryKey(long mypageUserGracePeriodId)
		throws NoSuchMypageUserGracePeriodException {

		return findByPrimaryKey((Serializable)mypageUserGracePeriodId);
	}

	/**
	 * Returns the mypage user grace period with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserGracePeriodId the primary key of the mypage user grace period
	 * @return the mypage user grace period, or <code>null</code> if a mypage user grace period with the primary key could not be found
	 */
	@Override
	public MypageUserGracePeriod fetchByPrimaryKey(
		long mypageUserGracePeriodId) {

		return fetchByPrimaryKey((Serializable)mypageUserGracePeriodId);
	}

	/**
	 * Returns all the mypage user grace periods.
	 *
	 * @return the mypage user grace periods
	 */
	@Override
	public List<MypageUserGracePeriod> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mypage user grace periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @return the range of mypage user grace periods
	 */
	@Override
	public List<MypageUserGracePeriod> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the mypage user grace periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage user grace periods
	 */
	@Override
	public List<MypageUserGracePeriod> findAll(
		int start, int end,
		OrderByComparator<MypageUserGracePeriod> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mypage user grace periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserGracePeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user grace periods
	 * @param end the upper bound of the range of mypage user grace periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage user grace periods
	 */
	@Override
	public List<MypageUserGracePeriod> findAll(
		int start, int end,
		OrderByComparator<MypageUserGracePeriod> orderByComparator,
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

		List<MypageUserGracePeriod> list = null;

		if (useFinderCache) {
			list = (List<MypageUserGracePeriod>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MYPAGEUSERGRACEPERIOD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MYPAGEUSERGRACEPERIOD;

				sql = sql.concat(MypageUserGracePeriodModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MypageUserGracePeriod>)QueryUtil.list(
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
	 * Removes all the mypage user grace periods from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MypageUserGracePeriod mypageUserGracePeriod : findAll()) {
			remove(mypageUserGracePeriod);
		}
	}

	/**
	 * Returns the number of mypage user grace periods.
	 *
	 * @return the number of mypage user grace periods
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
					_SQL_COUNT_MYPAGEUSERGRACEPERIOD);

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
		return "mypageUserGracePeriodId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MYPAGEUSERGRACEPERIOD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MypageUserGracePeriodModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the mypage user grace period persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new MypageUserGracePeriodModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MypageUserGracePeriod.class.getName()));

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

		_setMypageUserGracePeriodUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMypageUserGracePeriodUtilPersistence(null);

		entityCache.removeCache(MypageUserGracePeriodImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setMypageUserGracePeriodUtilPersistence(
		MypageUserGracePeriodPersistence mypageUserGracePeriodPersistence) {

		try {
			Field field = MypageUserGracePeriodUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, mypageUserGracePeriodPersistence);
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

	private static final String _SQL_SELECT_MYPAGEUSERGRACEPERIOD =
		"SELECT mypageUserGracePeriod FROM MypageUserGracePeriod mypageUserGracePeriod";

	private static final String _SQL_SELECT_MYPAGEUSERGRACEPERIOD_WHERE =
		"SELECT mypageUserGracePeriod FROM MypageUserGracePeriod mypageUserGracePeriod WHERE ";

	private static final String _SQL_COUNT_MYPAGEUSERGRACEPERIOD =
		"SELECT COUNT(mypageUserGracePeriod) FROM MypageUserGracePeriod mypageUserGracePeriod";

	private static final String _SQL_COUNT_MYPAGEUSERGRACEPERIOD_WHERE =
		"SELECT COUNT(mypageUserGracePeriod) FROM MypageUserGracePeriod mypageUserGracePeriod WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"mypageUserGracePeriod.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MypageUserGracePeriod exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MypageUserGracePeriod exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MypageUserGracePeriodPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"code"});

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

	private static class MypageUserGracePeriodModelArgumentsResolver
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

			MypageUserGracePeriodModelImpl mypageUserGracePeriodModelImpl =
				(MypageUserGracePeriodModelImpl)baseModel;

			long columnBitmask =
				mypageUserGracePeriodModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					mypageUserGracePeriodModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						mypageUserGracePeriodModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					mypageUserGracePeriodModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			MypageUserGracePeriodModelImpl mypageUserGracePeriodModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						mypageUserGracePeriodModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						mypageUserGracePeriodModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}