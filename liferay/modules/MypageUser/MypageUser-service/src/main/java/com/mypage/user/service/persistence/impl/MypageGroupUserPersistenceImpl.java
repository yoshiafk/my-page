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
import com.liferay.portal.kernel.util.StringUtil;

import com.mypage.user.exception.NoSuchMypageGroupUserException;
import com.mypage.user.model.MypageGroupUser;
import com.mypage.user.model.impl.MypageGroupUserImpl;
import com.mypage.user.model.impl.MypageGroupUserModelImpl;
import com.mypage.user.service.persistence.MypageGroupUserPersistence;
import com.mypage.user.service.persistence.MypageGroupUserUtil;
import com.mypage.user.service.persistence.impl.constants.MPUPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the mypage group user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MypageGroupUserPersistence.class)
public class MypageGroupUserPersistenceImpl
	extends BasePersistenceImpl<MypageGroupUser>
	implements MypageGroupUserPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MypageGroupUserUtil</code> to access the mypage group user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MypageGroupUserImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBymypageGroupId;
	private FinderPath _finderPathWithoutPaginationFindBymypageGroupId;
	private FinderPath _finderPathCountBymypageGroupId;

	/**
	 * Returns all the mypage group users where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @return the matching mypage group users
	 */
	@Override
	public List<MypageGroupUser> findBymypageGroupId(long mypageGroupId) {
		return findBymypageGroupId(
			mypageGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mypage group users where mypageGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageGroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param start the lower bound of the range of mypage group users
	 * @param end the upper bound of the range of mypage group users (not inclusive)
	 * @return the range of matching mypage group users
	 */
	@Override
	public List<MypageGroupUser> findBymypageGroupId(
		long mypageGroupId, int start, int end) {

		return findBymypageGroupId(mypageGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the mypage group users where mypageGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageGroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param start the lower bound of the range of mypage group users
	 * @param end the upper bound of the range of mypage group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching mypage group users
	 */
	@Override
	public List<MypageGroupUser> findBymypageGroupId(
		long mypageGroupId, int start, int end,
		OrderByComparator<MypageGroupUser> orderByComparator) {

		return findBymypageGroupId(
			mypageGroupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mypage group users where mypageGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageGroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param start the lower bound of the range of mypage group users
	 * @param end the upper bound of the range of mypage group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching mypage group users
	 */
	@Override
	public List<MypageGroupUser> findBymypageGroupId(
		long mypageGroupId, int start, int end,
		OrderByComparator<MypageGroupUser> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBymypageGroupId;
				finderArgs = new Object[] {mypageGroupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBymypageGroupId;
			finderArgs = new Object[] {
				mypageGroupId, start, end, orderByComparator
			};
		}

		List<MypageGroupUser> list = null;

		if (useFinderCache) {
			list = (List<MypageGroupUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MypageGroupUser mypageGroupUser : list) {
					if (mypageGroupId != mypageGroupUser.getMypageGroupId()) {
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

			sb.append(_SQL_SELECT_MYPAGEGROUPUSER_WHERE);

			sb.append(_FINDER_COLUMN_MYPAGEGROUPID_MYPAGEGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MypageGroupUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageGroupId);

				list = (List<MypageGroupUser>)QueryUtil.list(
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
	 * Returns the first mypage group user in the ordered set where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage group user
	 * @throws NoSuchMypageGroupUserException if a matching mypage group user could not be found
	 */
	@Override
	public MypageGroupUser findBymypageGroupId_First(
			long mypageGroupId,
			OrderByComparator<MypageGroupUser> orderByComparator)
		throws NoSuchMypageGroupUserException {

		MypageGroupUser mypageGroupUser = fetchBymypageGroupId_First(
			mypageGroupId, orderByComparator);

		if (mypageGroupUser != null) {
			return mypageGroupUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageGroupId=");
		sb.append(mypageGroupId);

		sb.append("}");

		throw new NoSuchMypageGroupUserException(sb.toString());
	}

	/**
	 * Returns the first mypage group user in the ordered set where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage group user, or <code>null</code> if a matching mypage group user could not be found
	 */
	@Override
	public MypageGroupUser fetchBymypageGroupId_First(
		long mypageGroupId,
		OrderByComparator<MypageGroupUser> orderByComparator) {

		List<MypageGroupUser> list = findBymypageGroupId(
			mypageGroupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last mypage group user in the ordered set where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage group user
	 * @throws NoSuchMypageGroupUserException if a matching mypage group user could not be found
	 */
	@Override
	public MypageGroupUser findBymypageGroupId_Last(
			long mypageGroupId,
			OrderByComparator<MypageGroupUser> orderByComparator)
		throws NoSuchMypageGroupUserException {

		MypageGroupUser mypageGroupUser = fetchBymypageGroupId_Last(
			mypageGroupId, orderByComparator);

		if (mypageGroupUser != null) {
			return mypageGroupUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageGroupId=");
		sb.append(mypageGroupId);

		sb.append("}");

		throw new NoSuchMypageGroupUserException(sb.toString());
	}

	/**
	 * Returns the last mypage group user in the ordered set where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage group user, or <code>null</code> if a matching mypage group user could not be found
	 */
	@Override
	public MypageGroupUser fetchBymypageGroupId_Last(
		long mypageGroupId,
		OrderByComparator<MypageGroupUser> orderByComparator) {

		int count = countBymypageGroupId(mypageGroupId);

		if (count == 0) {
			return null;
		}

		List<MypageGroupUser> list = findBymypageGroupId(
			mypageGroupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the mypage group users before and after the current mypage group user in the ordered set where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupUserId the primary key of the current mypage group user
	 * @param mypageGroupId the mypage group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next mypage group user
	 * @throws NoSuchMypageGroupUserException if a mypage group user with the primary key could not be found
	 */
	@Override
	public MypageGroupUser[] findBymypageGroupId_PrevAndNext(
			long mypageGroupUserId, long mypageGroupId,
			OrderByComparator<MypageGroupUser> orderByComparator)
		throws NoSuchMypageGroupUserException {

		MypageGroupUser mypageGroupUser = findByPrimaryKey(mypageGroupUserId);

		Session session = null;

		try {
			session = openSession();

			MypageGroupUser[] array = new MypageGroupUserImpl[3];

			array[0] = getBymypageGroupId_PrevAndNext(
				session, mypageGroupUser, mypageGroupId, orderByComparator,
				true);

			array[1] = mypageGroupUser;

			array[2] = getBymypageGroupId_PrevAndNext(
				session, mypageGroupUser, mypageGroupId, orderByComparator,
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

	protected MypageGroupUser getBymypageGroupId_PrevAndNext(
		Session session, MypageGroupUser mypageGroupUser, long mypageGroupId,
		OrderByComparator<MypageGroupUser> orderByComparator,
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

		sb.append(_SQL_SELECT_MYPAGEGROUPUSER_WHERE);

		sb.append(_FINDER_COLUMN_MYPAGEGROUPID_MYPAGEGROUPID_2);

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
			sb.append(MypageGroupUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(mypageGroupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						mypageGroupUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MypageGroupUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the mypage group users where mypageGroupId = &#63; from the database.
	 *
	 * @param mypageGroupId the mypage group ID
	 */
	@Override
	public void removeBymypageGroupId(long mypageGroupId) {
		for (MypageGroupUser mypageGroupUser :
				findBymypageGroupId(
					mypageGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(mypageGroupUser);
		}
	}

	/**
	 * Returns the number of mypage group users where mypageGroupId = &#63;.
	 *
	 * @param mypageGroupId the mypage group ID
	 * @return the number of matching mypage group users
	 */
	@Override
	public int countBymypageGroupId(long mypageGroupId) {
		FinderPath finderPath = _finderPathCountBymypageGroupId;

		Object[] finderArgs = new Object[] {mypageGroupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MYPAGEGROUPUSER_WHERE);

			sb.append(_FINDER_COLUMN_MYPAGEGROUPID_MYPAGEGROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageGroupId);

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

	private static final String _FINDER_COLUMN_MYPAGEGROUPID_MYPAGEGROUPID_2 =
		"mypageGroupUser.mypageGroupId = ?";

	private FinderPath _finderPathFetchBymypageUserId;
	private FinderPath _finderPathCountBymypageUserId;

	/**
	 * Returns the mypage group user where mypageUserId = &#63; or throws a <code>NoSuchMypageGroupUserException</code> if it could not be found.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching mypage group user
	 * @throws NoSuchMypageGroupUserException if a matching mypage group user could not be found
	 */
	@Override
	public MypageGroupUser findBymypageUserId(long mypageUserId)
		throws NoSuchMypageGroupUserException {

		MypageGroupUser mypageGroupUser = fetchBymypageUserId(mypageUserId);

		if (mypageGroupUser == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("mypageUserId=");
			sb.append(mypageUserId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMypageGroupUserException(sb.toString());
		}

		return mypageGroupUser;
	}

	/**
	 * Returns the mypage group user where mypageUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching mypage group user, or <code>null</code> if a matching mypage group user could not be found
	 */
	@Override
	public MypageGroupUser fetchBymypageUserId(long mypageUserId) {
		return fetchBymypageUserId(mypageUserId, true);
	}

	/**
	 * Returns the mypage group user where mypageUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage group user, or <code>null</code> if a matching mypage group user could not be found
	 */
	@Override
	public MypageGroupUser fetchBymypageUserId(
		long mypageUserId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {mypageUserId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBymypageUserId, finderArgs, this);
		}

		if (result instanceof MypageGroupUser) {
			MypageGroupUser mypageGroupUser = (MypageGroupUser)result;

			if (mypageUserId != mypageGroupUser.getMypageUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MYPAGEGROUPUSER_WHERE);

			sb.append(_FINDER_COLUMN_MYPAGEUSERID_MYPAGEUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserId);

				List<MypageGroupUser> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBymypageUserId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {mypageUserId};
							}

							_log.warn(
								"MypageGroupUserPersistenceImpl.fetchBymypageUserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MypageGroupUser mypageGroupUser = list.get(0);

					result = mypageGroupUser;

					cacheResult(mypageGroupUser);
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
			return (MypageGroupUser)result;
		}
	}

	/**
	 * Removes the mypage group user where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the mypage group user that was removed
	 */
	@Override
	public MypageGroupUser removeBymypageUserId(long mypageUserId)
		throws NoSuchMypageGroupUserException {

		MypageGroupUser mypageGroupUser = findBymypageUserId(mypageUserId);

		return remove(mypageGroupUser);
	}

	/**
	 * Returns the number of mypage group users where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching mypage group users
	 */
	@Override
	public int countBymypageUserId(long mypageUserId) {
		FinderPath finderPath = _finderPathCountBymypageUserId;

		Object[] finderArgs = new Object[] {mypageUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MYPAGEGROUPUSER_WHERE);

			sb.append(_FINDER_COLUMN_MYPAGEUSERID_MYPAGEUSERID_2);

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

	private static final String _FINDER_COLUMN_MYPAGEUSERID_MYPAGEUSERID_2 =
		"mypageGroupUser.mypageUserId = ?";

	public MypageGroupUserPersistenceImpl() {
		setModelClass(MypageGroupUser.class);

		setModelImplClass(MypageGroupUserImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the mypage group user in the entity cache if it is enabled.
	 *
	 * @param mypageGroupUser the mypage group user
	 */
	@Override
	public void cacheResult(MypageGroupUser mypageGroupUser) {
		entityCache.putResult(
			MypageGroupUserImpl.class, mypageGroupUser.getPrimaryKey(),
			mypageGroupUser);

		finderCache.putResult(
			_finderPathFetchBymypageUserId,
			new Object[] {mypageGroupUser.getMypageUserId()}, mypageGroupUser);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the mypage group users in the entity cache if it is enabled.
	 *
	 * @param mypageGroupUsers the mypage group users
	 */
	@Override
	public void cacheResult(List<MypageGroupUser> mypageGroupUsers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (mypageGroupUsers.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MypageGroupUser mypageGroupUser : mypageGroupUsers) {
			if (entityCache.getResult(
					MypageGroupUserImpl.class,
					mypageGroupUser.getPrimaryKey()) == null) {

				cacheResult(mypageGroupUser);
			}
		}
	}

	/**
	 * Clears the cache for all mypage group users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MypageGroupUserImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the mypage group user.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MypageGroupUser mypageGroupUser) {
		entityCache.removeResult(MypageGroupUserImpl.class, mypageGroupUser);
	}

	@Override
	public void clearCache(List<MypageGroupUser> mypageGroupUsers) {
		for (MypageGroupUser mypageGroupUser : mypageGroupUsers) {
			entityCache.removeResult(
				MypageGroupUserImpl.class, mypageGroupUser);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MypageGroupUserImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		MypageGroupUserModelImpl mypageGroupUserModelImpl) {

		Object[] args = new Object[] {
			mypageGroupUserModelImpl.getMypageUserId()
		};

		finderCache.putResult(
			_finderPathCountBymypageUserId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBymypageUserId, args, mypageGroupUserModelImpl,
			false);
	}

	/**
	 * Creates a new mypage group user with the primary key. Does not add the mypage group user to the database.
	 *
	 * @param mypageGroupUserId the primary key for the new mypage group user
	 * @return the new mypage group user
	 */
	@Override
	public MypageGroupUser create(long mypageGroupUserId) {
		MypageGroupUser mypageGroupUser = new MypageGroupUserImpl();

		mypageGroupUser.setNew(true);
		mypageGroupUser.setPrimaryKey(mypageGroupUserId);

		mypageGroupUser.setCompanyId(CompanyThreadLocal.getCompanyId());

		return mypageGroupUser;
	}

	/**
	 * Removes the mypage group user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageGroupUserId the primary key of the mypage group user
	 * @return the mypage group user that was removed
	 * @throws NoSuchMypageGroupUserException if a mypage group user with the primary key could not be found
	 */
	@Override
	public MypageGroupUser remove(long mypageGroupUserId)
		throws NoSuchMypageGroupUserException {

		return remove((Serializable)mypageGroupUserId);
	}

	/**
	 * Removes the mypage group user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mypage group user
	 * @return the mypage group user that was removed
	 * @throws NoSuchMypageGroupUserException if a mypage group user with the primary key could not be found
	 */
	@Override
	public MypageGroupUser remove(Serializable primaryKey)
		throws NoSuchMypageGroupUserException {

		Session session = null;

		try {
			session = openSession();

			MypageGroupUser mypageGroupUser = (MypageGroupUser)session.get(
				MypageGroupUserImpl.class, primaryKey);

			if (mypageGroupUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMypageGroupUserException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(mypageGroupUser);
		}
		catch (NoSuchMypageGroupUserException noSuchEntityException) {
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
	protected MypageGroupUser removeImpl(MypageGroupUser mypageGroupUser) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mypageGroupUser)) {
				mypageGroupUser = (MypageGroupUser)session.get(
					MypageGroupUserImpl.class,
					mypageGroupUser.getPrimaryKeyObj());
			}

			if (mypageGroupUser != null) {
				session.delete(mypageGroupUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (mypageGroupUser != null) {
			clearCache(mypageGroupUser);
		}

		return mypageGroupUser;
	}

	@Override
	public MypageGroupUser updateImpl(MypageGroupUser mypageGroupUser) {
		boolean isNew = mypageGroupUser.isNew();

		if (!(mypageGroupUser instanceof MypageGroupUserModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(mypageGroupUser.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					mypageGroupUser);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in mypageGroupUser proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MypageGroupUser implementation " +
					mypageGroupUser.getClass());
		}

		MypageGroupUserModelImpl mypageGroupUserModelImpl =
			(MypageGroupUserModelImpl)mypageGroupUser;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (mypageGroupUser.getCreateDate() == null)) {
			if (serviceContext == null) {
				mypageGroupUser.setCreateDate(date);
			}
			else {
				mypageGroupUser.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!mypageGroupUserModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				mypageGroupUser.setModifiedDate(date);
			}
			else {
				mypageGroupUser.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(mypageGroupUser);
			}
			else {
				mypageGroupUser = (MypageGroupUser)session.merge(
					mypageGroupUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MypageGroupUserImpl.class, mypageGroupUserModelImpl, false, true);

		cacheUniqueFindersCache(mypageGroupUserModelImpl);

		if (isNew) {
			mypageGroupUser.setNew(false);
		}

		mypageGroupUser.resetOriginalValues();

		return mypageGroupUser;
	}

	/**
	 * Returns the mypage group user with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mypage group user
	 * @return the mypage group user
	 * @throws NoSuchMypageGroupUserException if a mypage group user with the primary key could not be found
	 */
	@Override
	public MypageGroupUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMypageGroupUserException {

		MypageGroupUser mypageGroupUser = fetchByPrimaryKey(primaryKey);

		if (mypageGroupUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMypageGroupUserException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return mypageGroupUser;
	}

	/**
	 * Returns the mypage group user with the primary key or throws a <code>NoSuchMypageGroupUserException</code> if it could not be found.
	 *
	 * @param mypageGroupUserId the primary key of the mypage group user
	 * @return the mypage group user
	 * @throws NoSuchMypageGroupUserException if a mypage group user with the primary key could not be found
	 */
	@Override
	public MypageGroupUser findByPrimaryKey(long mypageGroupUserId)
		throws NoSuchMypageGroupUserException {

		return findByPrimaryKey((Serializable)mypageGroupUserId);
	}

	/**
	 * Returns the mypage group user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageGroupUserId the primary key of the mypage group user
	 * @return the mypage group user, or <code>null</code> if a mypage group user with the primary key could not be found
	 */
	@Override
	public MypageGroupUser fetchByPrimaryKey(long mypageGroupUserId) {
		return fetchByPrimaryKey((Serializable)mypageGroupUserId);
	}

	/**
	 * Returns all the mypage group users.
	 *
	 * @return the mypage group users
	 */
	@Override
	public List<MypageGroupUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mypage group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageGroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage group users
	 * @param end the upper bound of the range of mypage group users (not inclusive)
	 * @return the range of mypage group users
	 */
	@Override
	public List<MypageGroupUser> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the mypage group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageGroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage group users
	 * @param end the upper bound of the range of mypage group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage group users
	 */
	@Override
	public List<MypageGroupUser> findAll(
		int start, int end,
		OrderByComparator<MypageGroupUser> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mypage group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageGroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage group users
	 * @param end the upper bound of the range of mypage group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage group users
	 */
	@Override
	public List<MypageGroupUser> findAll(
		int start, int end,
		OrderByComparator<MypageGroupUser> orderByComparator,
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

		List<MypageGroupUser> list = null;

		if (useFinderCache) {
			list = (List<MypageGroupUser>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MYPAGEGROUPUSER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MYPAGEGROUPUSER;

				sql = sql.concat(MypageGroupUserModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MypageGroupUser>)QueryUtil.list(
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
	 * Removes all the mypage group users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MypageGroupUser mypageGroupUser : findAll()) {
			remove(mypageGroupUser);
		}
	}

	/**
	 * Returns the number of mypage group users.
	 *
	 * @return the number of mypage group users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MYPAGEGROUPUSER);

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
		return "mypageGroupUserId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MYPAGEGROUPUSER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MypageGroupUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the mypage group user persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new MypageGroupUserModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MypageGroupUser.class.getName()));

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

		_finderPathWithPaginationFindBymypageGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymypageGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"mypageGroupId"}, true);

		_finderPathWithoutPaginationFindBymypageGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymypageGroupId",
			new String[] {Long.class.getName()}, new String[] {"mypageGroupId"},
			true);

		_finderPathCountBymypageGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymypageGroupId",
			new String[] {Long.class.getName()}, new String[] {"mypageGroupId"},
			false);

		_finderPathFetchBymypageUserId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBymypageUserId",
			new String[] {Long.class.getName()}, new String[] {"mypageUserId"},
			true);

		_finderPathCountBymypageUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymypageUserId",
			new String[] {Long.class.getName()}, new String[] {"mypageUserId"},
			false);

		_setMypageGroupUserUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMypageGroupUserUtilPersistence(null);

		entityCache.removeCache(MypageGroupUserImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setMypageGroupUserUtilPersistence(
		MypageGroupUserPersistence mypageGroupUserPersistence) {

		try {
			Field field = MypageGroupUserUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, mypageGroupUserPersistence);
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

	private static final String _SQL_SELECT_MYPAGEGROUPUSER =
		"SELECT mypageGroupUser FROM MypageGroupUser mypageGroupUser";

	private static final String _SQL_SELECT_MYPAGEGROUPUSER_WHERE =
		"SELECT mypageGroupUser FROM MypageGroupUser mypageGroupUser WHERE ";

	private static final String _SQL_COUNT_MYPAGEGROUPUSER =
		"SELECT COUNT(mypageGroupUser) FROM MypageGroupUser mypageGroupUser";

	private static final String _SQL_COUNT_MYPAGEGROUPUSER_WHERE =
		"SELECT COUNT(mypageGroupUser) FROM MypageGroupUser mypageGroupUser WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "mypageGroupUser.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MypageGroupUser exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MypageGroupUser exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MypageGroupUserPersistenceImpl.class);

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

	private static class MypageGroupUserModelArgumentsResolver
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

			MypageGroupUserModelImpl mypageGroupUserModelImpl =
				(MypageGroupUserModelImpl)baseModel;

			long columnBitmask = mypageGroupUserModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					mypageGroupUserModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						mypageGroupUserModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					mypageGroupUserModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			MypageGroupUserModelImpl mypageGroupUserModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						mypageGroupUserModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = mypageGroupUserModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}