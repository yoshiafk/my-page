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

import com.mypage.user.exception.NoSuchMypageUserWorkingHourException;
import com.mypage.user.model.MypageUserWorkingHour;
import com.mypage.user.model.impl.MypageUserWorkingHourImpl;
import com.mypage.user.model.impl.MypageUserWorkingHourModelImpl;
import com.mypage.user.service.persistence.MypageUserWorkingHourPersistence;
import com.mypage.user.service.persistence.MypageUserWorkingHourUtil;
import com.mypage.user.service.persistence.impl.constants.MPUPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
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
 * The persistence implementation for the mypage user working hour service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MypageUserWorkingHourPersistence.class)
public class MypageUserWorkingHourPersistenceImpl
	extends BasePersistenceImpl<MypageUserWorkingHour>
	implements MypageUserWorkingHourPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MypageUserWorkingHourUtil</code> to access the mypage user working hour persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MypageUserWorkingHourImpl.class.getName();

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
	 * Returns all the mypage user working hours where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching mypage user working hours
	 */
	@Override
	public List<MypageUserWorkingHour> findBygetByMypageUserId(
		long mypageUserId) {

		return findBygetByMypageUserId(
			mypageUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mypage user working hours where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @return the range of matching mypage user working hours
	 */
	@Override
	public List<MypageUserWorkingHour> findBygetByMypageUserId(
		long mypageUserId, int start, int end) {

		return findBygetByMypageUserId(mypageUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the mypage user working hours where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching mypage user working hours
	 */
	@Override
	public List<MypageUserWorkingHour> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MypageUserWorkingHour> orderByComparator) {

		return findBygetByMypageUserId(
			mypageUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mypage user working hours where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching mypage user working hours
	 */
	@Override
	public List<MypageUserWorkingHour> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MypageUserWorkingHour> orderByComparator,
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

		List<MypageUserWorkingHour> list = null;

		if (useFinderCache) {
			list = (List<MypageUserWorkingHour>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MypageUserWorkingHour mypageUserWorkingHour : list) {
					if (mypageUserId !=
							mypageUserWorkingHour.getMypageUserId()) {

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

			sb.append(_SQL_SELECT_MYPAGEUSERWORKINGHOUR_WHERE);

			sb.append(_FINDER_COLUMN_GETBYMYPAGEUSERID_MYPAGEUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MypageUserWorkingHourModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserId);

				list = (List<MypageUserWorkingHour>)QueryUtil.list(
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
	 * Returns the first mypage user working hour in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user working hour
	 * @throws NoSuchMypageUserWorkingHourException if a matching mypage user working hour could not be found
	 */
	@Override
	public MypageUserWorkingHour findBygetByMypageUserId_First(
			long mypageUserId,
			OrderByComparator<MypageUserWorkingHour> orderByComparator)
		throws NoSuchMypageUserWorkingHourException {

		MypageUserWorkingHour mypageUserWorkingHour =
			fetchBygetByMypageUserId_First(mypageUserId, orderByComparator);

		if (mypageUserWorkingHour != null) {
			return mypageUserWorkingHour;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserId=");
		sb.append(mypageUserId);

		sb.append("}");

		throw new NoSuchMypageUserWorkingHourException(sb.toString());
	}

	/**
	 * Returns the first mypage user working hour in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user working hour, or <code>null</code> if a matching mypage user working hour could not be found
	 */
	@Override
	public MypageUserWorkingHour fetchBygetByMypageUserId_First(
		long mypageUserId,
		OrderByComparator<MypageUserWorkingHour> orderByComparator) {

		List<MypageUserWorkingHour> list = findBygetByMypageUserId(
			mypageUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last mypage user working hour in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user working hour
	 * @throws NoSuchMypageUserWorkingHourException if a matching mypage user working hour could not be found
	 */
	@Override
	public MypageUserWorkingHour findBygetByMypageUserId_Last(
			long mypageUserId,
			OrderByComparator<MypageUserWorkingHour> orderByComparator)
		throws NoSuchMypageUserWorkingHourException {

		MypageUserWorkingHour mypageUserWorkingHour =
			fetchBygetByMypageUserId_Last(mypageUserId, orderByComparator);

		if (mypageUserWorkingHour != null) {
			return mypageUserWorkingHour;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserId=");
		sb.append(mypageUserId);

		sb.append("}");

		throw new NoSuchMypageUserWorkingHourException(sb.toString());
	}

	/**
	 * Returns the last mypage user working hour in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user working hour, or <code>null</code> if a matching mypage user working hour could not be found
	 */
	@Override
	public MypageUserWorkingHour fetchBygetByMypageUserId_Last(
		long mypageUserId,
		OrderByComparator<MypageUserWorkingHour> orderByComparator) {

		int count = countBygetByMypageUserId(mypageUserId);

		if (count == 0) {
			return null;
		}

		List<MypageUserWorkingHour> list = findBygetByMypageUserId(
			mypageUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the mypage user working hours before and after the current mypage user working hour in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserWorkingHourId the primary key of the current mypage user working hour
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next mypage user working hour
	 * @throws NoSuchMypageUserWorkingHourException if a mypage user working hour with the primary key could not be found
	 */
	@Override
	public MypageUserWorkingHour[] findBygetByMypageUserId_PrevAndNext(
			long mypageUserWorkingHourId, long mypageUserId,
			OrderByComparator<MypageUserWorkingHour> orderByComparator)
		throws NoSuchMypageUserWorkingHourException {

		MypageUserWorkingHour mypageUserWorkingHour = findByPrimaryKey(
			mypageUserWorkingHourId);

		Session session = null;

		try {
			session = openSession();

			MypageUserWorkingHour[] array = new MypageUserWorkingHourImpl[3];

			array[0] = getBygetByMypageUserId_PrevAndNext(
				session, mypageUserWorkingHour, mypageUserId, orderByComparator,
				true);

			array[1] = mypageUserWorkingHour;

			array[2] = getBygetByMypageUserId_PrevAndNext(
				session, mypageUserWorkingHour, mypageUserId, orderByComparator,
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

	protected MypageUserWorkingHour getBygetByMypageUserId_PrevAndNext(
		Session session, MypageUserWorkingHour mypageUserWorkingHour,
		long mypageUserId,
		OrderByComparator<MypageUserWorkingHour> orderByComparator,
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

		sb.append(_SQL_SELECT_MYPAGEUSERWORKINGHOUR_WHERE);

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
			sb.append(MypageUserWorkingHourModelImpl.ORDER_BY_JPQL);
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
						mypageUserWorkingHour)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MypageUserWorkingHour> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the mypage user working hours where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	@Override
	public void removeBygetByMypageUserId(long mypageUserId) {
		for (MypageUserWorkingHour mypageUserWorkingHour :
				findBygetByMypageUserId(
					mypageUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(mypageUserWorkingHour);
		}
	}

	/**
	 * Returns the number of mypage user working hours where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching mypage user working hours
	 */
	@Override
	public int countBygetByMypageUserId(long mypageUserId) {
		FinderPath finderPath = _finderPathCountBygetByMypageUserId;

		Object[] finderArgs = new Object[] {mypageUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MYPAGEUSERWORKINGHOUR_WHERE);

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
			"mypageUserWorkingHour.mypageUserId = ?";

	public MypageUserWorkingHourPersistenceImpl() {
		setModelClass(MypageUserWorkingHour.class);

		setModelImplClass(MypageUserWorkingHourImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the mypage user working hour in the entity cache if it is enabled.
	 *
	 * @param mypageUserWorkingHour the mypage user working hour
	 */
	@Override
	public void cacheResult(MypageUserWorkingHour mypageUserWorkingHour) {
		entityCache.putResult(
			MypageUserWorkingHourImpl.class,
			mypageUserWorkingHour.getPrimaryKey(), mypageUserWorkingHour);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the mypage user working hours in the entity cache if it is enabled.
	 *
	 * @param mypageUserWorkingHours the mypage user working hours
	 */
	@Override
	public void cacheResult(
		List<MypageUserWorkingHour> mypageUserWorkingHours) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (mypageUserWorkingHours.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MypageUserWorkingHour mypageUserWorkingHour :
				mypageUserWorkingHours) {

			if (entityCache.getResult(
					MypageUserWorkingHourImpl.class,
					mypageUserWorkingHour.getPrimaryKey()) == null) {

				cacheResult(mypageUserWorkingHour);
			}
		}
	}

	/**
	 * Clears the cache for all mypage user working hours.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MypageUserWorkingHourImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the mypage user working hour.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MypageUserWorkingHour mypageUserWorkingHour) {
		entityCache.removeResult(
			MypageUserWorkingHourImpl.class, mypageUserWorkingHour);
	}

	@Override
	public void clearCache(List<MypageUserWorkingHour> mypageUserWorkingHours) {
		for (MypageUserWorkingHour mypageUserWorkingHour :
				mypageUserWorkingHours) {

			entityCache.removeResult(
				MypageUserWorkingHourImpl.class, mypageUserWorkingHour);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				MypageUserWorkingHourImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new mypage user working hour with the primary key. Does not add the mypage user working hour to the database.
	 *
	 * @param mypageUserWorkingHourId the primary key for the new mypage user working hour
	 * @return the new mypage user working hour
	 */
	@Override
	public MypageUserWorkingHour create(long mypageUserWorkingHourId) {
		MypageUserWorkingHour mypageUserWorkingHour =
			new MypageUserWorkingHourImpl();

		mypageUserWorkingHour.setNew(true);
		mypageUserWorkingHour.setPrimaryKey(mypageUserWorkingHourId);

		mypageUserWorkingHour.setCompanyId(CompanyThreadLocal.getCompanyId());

		return mypageUserWorkingHour;
	}

	/**
	 * Removes the mypage user working hour with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserWorkingHourId the primary key of the mypage user working hour
	 * @return the mypage user working hour that was removed
	 * @throws NoSuchMypageUserWorkingHourException if a mypage user working hour with the primary key could not be found
	 */
	@Override
	public MypageUserWorkingHour remove(long mypageUserWorkingHourId)
		throws NoSuchMypageUserWorkingHourException {

		return remove((Serializable)mypageUserWorkingHourId);
	}

	/**
	 * Removes the mypage user working hour with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mypage user working hour
	 * @return the mypage user working hour that was removed
	 * @throws NoSuchMypageUserWorkingHourException if a mypage user working hour with the primary key could not be found
	 */
	@Override
	public MypageUserWorkingHour remove(Serializable primaryKey)
		throws NoSuchMypageUserWorkingHourException {

		Session session = null;

		try {
			session = openSession();

			MypageUserWorkingHour mypageUserWorkingHour =
				(MypageUserWorkingHour)session.get(
					MypageUserWorkingHourImpl.class, primaryKey);

			if (mypageUserWorkingHour == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMypageUserWorkingHourException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(mypageUserWorkingHour);
		}
		catch (NoSuchMypageUserWorkingHourException noSuchEntityException) {
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
	protected MypageUserWorkingHour removeImpl(
		MypageUserWorkingHour mypageUserWorkingHour) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mypageUserWorkingHour)) {
				mypageUserWorkingHour = (MypageUserWorkingHour)session.get(
					MypageUserWorkingHourImpl.class,
					mypageUserWorkingHour.getPrimaryKeyObj());
			}

			if (mypageUserWorkingHour != null) {
				session.delete(mypageUserWorkingHour);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (mypageUserWorkingHour != null) {
			clearCache(mypageUserWorkingHour);
		}

		return mypageUserWorkingHour;
	}

	@Override
	public MypageUserWorkingHour updateImpl(
		MypageUserWorkingHour mypageUserWorkingHour) {

		boolean isNew = mypageUserWorkingHour.isNew();

		if (!(mypageUserWorkingHour instanceof
				MypageUserWorkingHourModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(mypageUserWorkingHour.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					mypageUserWorkingHour);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in mypageUserWorkingHour proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MypageUserWorkingHour implementation " +
					mypageUserWorkingHour.getClass());
		}

		MypageUserWorkingHourModelImpl mypageUserWorkingHourModelImpl =
			(MypageUserWorkingHourModelImpl)mypageUserWorkingHour;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (mypageUserWorkingHour.getCreateDate() == null)) {
			if (serviceContext == null) {
				mypageUserWorkingHour.setCreateDate(date);
			}
			else {
				mypageUserWorkingHour.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!mypageUserWorkingHourModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				mypageUserWorkingHour.setModifiedDate(date);
			}
			else {
				mypageUserWorkingHour.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(mypageUserWorkingHour);
			}
			else {
				mypageUserWorkingHour = (MypageUserWorkingHour)session.merge(
					mypageUserWorkingHour);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MypageUserWorkingHourImpl.class, mypageUserWorkingHourModelImpl,
			false, true);

		if (isNew) {
			mypageUserWorkingHour.setNew(false);
		}

		mypageUserWorkingHour.resetOriginalValues();

		return mypageUserWorkingHour;
	}

	/**
	 * Returns the mypage user working hour with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mypage user working hour
	 * @return the mypage user working hour
	 * @throws NoSuchMypageUserWorkingHourException if a mypage user working hour with the primary key could not be found
	 */
	@Override
	public MypageUserWorkingHour findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMypageUserWorkingHourException {

		MypageUserWorkingHour mypageUserWorkingHour = fetchByPrimaryKey(
			primaryKey);

		if (mypageUserWorkingHour == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMypageUserWorkingHourException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return mypageUserWorkingHour;
	}

	/**
	 * Returns the mypage user working hour with the primary key or throws a <code>NoSuchMypageUserWorkingHourException</code> if it could not be found.
	 *
	 * @param mypageUserWorkingHourId the primary key of the mypage user working hour
	 * @return the mypage user working hour
	 * @throws NoSuchMypageUserWorkingHourException if a mypage user working hour with the primary key could not be found
	 */
	@Override
	public MypageUserWorkingHour findByPrimaryKey(long mypageUserWorkingHourId)
		throws NoSuchMypageUserWorkingHourException {

		return findByPrimaryKey((Serializable)mypageUserWorkingHourId);
	}

	/**
	 * Returns the mypage user working hour with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserWorkingHourId the primary key of the mypage user working hour
	 * @return the mypage user working hour, or <code>null</code> if a mypage user working hour with the primary key could not be found
	 */
	@Override
	public MypageUserWorkingHour fetchByPrimaryKey(
		long mypageUserWorkingHourId) {

		return fetchByPrimaryKey((Serializable)mypageUserWorkingHourId);
	}

	/**
	 * Returns all the mypage user working hours.
	 *
	 * @return the mypage user working hours
	 */
	@Override
	public List<MypageUserWorkingHour> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mypage user working hours.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @return the range of mypage user working hours
	 */
	@Override
	public List<MypageUserWorkingHour> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the mypage user working hours.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage user working hours
	 */
	@Override
	public List<MypageUserWorkingHour> findAll(
		int start, int end,
		OrderByComparator<MypageUserWorkingHour> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mypage user working hours.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserWorkingHourModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user working hours
	 * @param end the upper bound of the range of mypage user working hours (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage user working hours
	 */
	@Override
	public List<MypageUserWorkingHour> findAll(
		int start, int end,
		OrderByComparator<MypageUserWorkingHour> orderByComparator,
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

		List<MypageUserWorkingHour> list = null;

		if (useFinderCache) {
			list = (List<MypageUserWorkingHour>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MYPAGEUSERWORKINGHOUR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MYPAGEUSERWORKINGHOUR;

				sql = sql.concat(MypageUserWorkingHourModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MypageUserWorkingHour>)QueryUtil.list(
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
	 * Removes all the mypage user working hours from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MypageUserWorkingHour mypageUserWorkingHour : findAll()) {
			remove(mypageUserWorkingHour);
		}
	}

	/**
	 * Returns the number of mypage user working hours.
	 *
	 * @return the number of mypage user working hours
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
					_SQL_COUNT_MYPAGEUSERWORKINGHOUR);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "mypageUserWorkingHourId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MYPAGEUSERWORKINGHOUR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MypageUserWorkingHourModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the mypage user working hour persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new MypageUserWorkingHourModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MypageUserWorkingHour.class.getName()));

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

		_setMypageUserWorkingHourUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMypageUserWorkingHourUtilPersistence(null);

		entityCache.removeCache(MypageUserWorkingHourImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setMypageUserWorkingHourUtilPersistence(
		MypageUserWorkingHourPersistence mypageUserWorkingHourPersistence) {

		try {
			Field field = MypageUserWorkingHourUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, mypageUserWorkingHourPersistence);
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

	private static final String _SQL_SELECT_MYPAGEUSERWORKINGHOUR =
		"SELECT mypageUserWorkingHour FROM MypageUserWorkingHour mypageUserWorkingHour";

	private static final String _SQL_SELECT_MYPAGEUSERWORKINGHOUR_WHERE =
		"SELECT mypageUserWorkingHour FROM MypageUserWorkingHour mypageUserWorkingHour WHERE ";

	private static final String _SQL_COUNT_MYPAGEUSERWORKINGHOUR =
		"SELECT COUNT(mypageUserWorkingHour) FROM MypageUserWorkingHour mypageUserWorkingHour";

	private static final String _SQL_COUNT_MYPAGEUSERWORKINGHOUR_WHERE =
		"SELECT COUNT(mypageUserWorkingHour) FROM MypageUserWorkingHour mypageUserWorkingHour WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"mypageUserWorkingHour.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MypageUserWorkingHour exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MypageUserWorkingHour exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MypageUserWorkingHourPersistenceImpl.class);

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

	private static class MypageUserWorkingHourModelArgumentsResolver
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

			MypageUserWorkingHourModelImpl mypageUserWorkingHourModelImpl =
				(MypageUserWorkingHourModelImpl)baseModel;

			long columnBitmask =
				mypageUserWorkingHourModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					mypageUserWorkingHourModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						mypageUserWorkingHourModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					mypageUserWorkingHourModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			MypageUserWorkingHourModelImpl mypageUserWorkingHourModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						mypageUserWorkingHourModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						mypageUserWorkingHourModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}