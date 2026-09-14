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

import com.mypage.user.exception.NoSuchMypageUserLicensesException;
import com.mypage.user.model.MypageUserLicenses;
import com.mypage.user.model.impl.MypageUserLicensesImpl;
import com.mypage.user.model.impl.MypageUserLicensesModelImpl;
import com.mypage.user.service.persistence.MypageUserLicensesPersistence;
import com.mypage.user.service.persistence.MypageUserLicensesUtil;
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
 * The persistence implementation for the mypage user licenses service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MypageUserLicensesPersistence.class)
public class MypageUserLicensesPersistenceImpl
	extends BasePersistenceImpl<MypageUserLicenses>
	implements MypageUserLicensesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MypageUserLicensesUtil</code> to access the mypage user licenses persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MypageUserLicensesImpl.class.getName();

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
	 * Returns all the mypage user licenseses where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching mypage user licenseses
	 */
	@Override
	public List<MypageUserLicenses> findBygetByMypageUserId(long mypageUserId) {
		return findBygetByMypageUserId(
			mypageUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mypage user licenseses where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @return the range of matching mypage user licenseses
	 */
	@Override
	public List<MypageUserLicenses> findBygetByMypageUserId(
		long mypageUserId, int start, int end) {

		return findBygetByMypageUserId(mypageUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the mypage user licenseses where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching mypage user licenseses
	 */
	@Override
	public List<MypageUserLicenses> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MypageUserLicenses> orderByComparator) {

		return findBygetByMypageUserId(
			mypageUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mypage user licenseses where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching mypage user licenseses
	 */
	@Override
	public List<MypageUserLicenses> findBygetByMypageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<MypageUserLicenses> orderByComparator,
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

		List<MypageUserLicenses> list = null;

		if (useFinderCache) {
			list = (List<MypageUserLicenses>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MypageUserLicenses mypageUserLicenses : list) {
					if (mypageUserId != mypageUserLicenses.getMypageUserId()) {
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

			sb.append(_SQL_SELECT_MYPAGEUSERLICENSES_WHERE);

			sb.append(_FINDER_COLUMN_GETBYMYPAGEUSERID_MYPAGEUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MypageUserLicensesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserId);

				list = (List<MypageUserLicenses>)QueryUtil.list(
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
	 * Returns the first mypage user licenses in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user licenses
	 * @throws NoSuchMypageUserLicensesException if a matching mypage user licenses could not be found
	 */
	@Override
	public MypageUserLicenses findBygetByMypageUserId_First(
			long mypageUserId,
			OrderByComparator<MypageUserLicenses> orderByComparator)
		throws NoSuchMypageUserLicensesException {

		MypageUserLicenses mypageUserLicenses = fetchBygetByMypageUserId_First(
			mypageUserId, orderByComparator);

		if (mypageUserLicenses != null) {
			return mypageUserLicenses;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserId=");
		sb.append(mypageUserId);

		sb.append("}");

		throw new NoSuchMypageUserLicensesException(sb.toString());
	}

	/**
	 * Returns the first mypage user licenses in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mypage user licenses, or <code>null</code> if a matching mypage user licenses could not be found
	 */
	@Override
	public MypageUserLicenses fetchBygetByMypageUserId_First(
		long mypageUserId,
		OrderByComparator<MypageUserLicenses> orderByComparator) {

		List<MypageUserLicenses> list = findBygetByMypageUserId(
			mypageUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last mypage user licenses in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user licenses
	 * @throws NoSuchMypageUserLicensesException if a matching mypage user licenses could not be found
	 */
	@Override
	public MypageUserLicenses findBygetByMypageUserId_Last(
			long mypageUserId,
			OrderByComparator<MypageUserLicenses> orderByComparator)
		throws NoSuchMypageUserLicensesException {

		MypageUserLicenses mypageUserLicenses = fetchBygetByMypageUserId_Last(
			mypageUserId, orderByComparator);

		if (mypageUserLicenses != null) {
			return mypageUserLicenses;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserId=");
		sb.append(mypageUserId);

		sb.append("}");

		throw new NoSuchMypageUserLicensesException(sb.toString());
	}

	/**
	 * Returns the last mypage user licenses in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mypage user licenses, or <code>null</code> if a matching mypage user licenses could not be found
	 */
	@Override
	public MypageUserLicenses fetchBygetByMypageUserId_Last(
		long mypageUserId,
		OrderByComparator<MypageUserLicenses> orderByComparator) {

		int count = countBygetByMypageUserId(mypageUserId);

		if (count == 0) {
			return null;
		}

		List<MypageUserLicenses> list = findBygetByMypageUserId(
			mypageUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the mypage user licenseses before and after the current mypage user licenses in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserLicensesId the primary key of the current mypage user licenses
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next mypage user licenses
	 * @throws NoSuchMypageUserLicensesException if a mypage user licenses with the primary key could not be found
	 */
	@Override
	public MypageUserLicenses[] findBygetByMypageUserId_PrevAndNext(
			long mypageUserLicensesId, long mypageUserId,
			OrderByComparator<MypageUserLicenses> orderByComparator)
		throws NoSuchMypageUserLicensesException {

		MypageUserLicenses mypageUserLicenses = findByPrimaryKey(
			mypageUserLicensesId);

		Session session = null;

		try {
			session = openSession();

			MypageUserLicenses[] array = new MypageUserLicensesImpl[3];

			array[0] = getBygetByMypageUserId_PrevAndNext(
				session, mypageUserLicenses, mypageUserId, orderByComparator,
				true);

			array[1] = mypageUserLicenses;

			array[2] = getBygetByMypageUserId_PrevAndNext(
				session, mypageUserLicenses, mypageUserId, orderByComparator,
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

	protected MypageUserLicenses getBygetByMypageUserId_PrevAndNext(
		Session session, MypageUserLicenses mypageUserLicenses,
		long mypageUserId,
		OrderByComparator<MypageUserLicenses> orderByComparator,
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

		sb.append(_SQL_SELECT_MYPAGEUSERLICENSES_WHERE);

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
			sb.append(MypageUserLicensesModelImpl.ORDER_BY_JPQL);
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
						mypageUserLicenses)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MypageUserLicenses> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the mypage user licenseses where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	@Override
	public void removeBygetByMypageUserId(long mypageUserId) {
		for (MypageUserLicenses mypageUserLicenses :
				findBygetByMypageUserId(
					mypageUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(mypageUserLicenses);
		}
	}

	/**
	 * Returns the number of mypage user licenseses where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching mypage user licenseses
	 */
	@Override
	public int countBygetByMypageUserId(long mypageUserId) {
		FinderPath finderPath = _finderPathCountBygetByMypageUserId;

		Object[] finderArgs = new Object[] {mypageUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MYPAGEUSERLICENSES_WHERE);

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
			"mypageUserLicenses.mypageUserId = ?";

	public MypageUserLicensesPersistenceImpl() {
		setModelClass(MypageUserLicenses.class);

		setModelImplClass(MypageUserLicensesImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the mypage user licenses in the entity cache if it is enabled.
	 *
	 * @param mypageUserLicenses the mypage user licenses
	 */
	@Override
	public void cacheResult(MypageUserLicenses mypageUserLicenses) {
		entityCache.putResult(
			MypageUserLicensesImpl.class, mypageUserLicenses.getPrimaryKey(),
			mypageUserLicenses);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the mypage user licenseses in the entity cache if it is enabled.
	 *
	 * @param mypageUserLicenseses the mypage user licenseses
	 */
	@Override
	public void cacheResult(List<MypageUserLicenses> mypageUserLicenseses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (mypageUserLicenseses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MypageUserLicenses mypageUserLicenses : mypageUserLicenseses) {
			if (entityCache.getResult(
					MypageUserLicensesImpl.class,
					mypageUserLicenses.getPrimaryKey()) == null) {

				cacheResult(mypageUserLicenses);
			}
		}
	}

	/**
	 * Clears the cache for all mypage user licenseses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MypageUserLicensesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the mypage user licenses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MypageUserLicenses mypageUserLicenses) {
		entityCache.removeResult(
			MypageUserLicensesImpl.class, mypageUserLicenses);
	}

	@Override
	public void clearCache(List<MypageUserLicenses> mypageUserLicenseses) {
		for (MypageUserLicenses mypageUserLicenses : mypageUserLicenseses) {
			entityCache.removeResult(
				MypageUserLicensesImpl.class, mypageUserLicenses);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MypageUserLicensesImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new mypage user licenses with the primary key. Does not add the mypage user licenses to the database.
	 *
	 * @param mypageUserLicensesId the primary key for the new mypage user licenses
	 * @return the new mypage user licenses
	 */
	@Override
	public MypageUserLicenses create(long mypageUserLicensesId) {
		MypageUserLicenses mypageUserLicenses = new MypageUserLicensesImpl();

		mypageUserLicenses.setNew(true);
		mypageUserLicenses.setPrimaryKey(mypageUserLicensesId);

		mypageUserLicenses.setCompanyId(CompanyThreadLocal.getCompanyId());

		return mypageUserLicenses;
	}

	/**
	 * Removes the mypage user licenses with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserLicensesId the primary key of the mypage user licenses
	 * @return the mypage user licenses that was removed
	 * @throws NoSuchMypageUserLicensesException if a mypage user licenses with the primary key could not be found
	 */
	@Override
	public MypageUserLicenses remove(long mypageUserLicensesId)
		throws NoSuchMypageUserLicensesException {

		return remove((Serializable)mypageUserLicensesId);
	}

	/**
	 * Removes the mypage user licenses with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mypage user licenses
	 * @return the mypage user licenses that was removed
	 * @throws NoSuchMypageUserLicensesException if a mypage user licenses with the primary key could not be found
	 */
	@Override
	public MypageUserLicenses remove(Serializable primaryKey)
		throws NoSuchMypageUserLicensesException {

		Session session = null;

		try {
			session = openSession();

			MypageUserLicenses mypageUserLicenses =
				(MypageUserLicenses)session.get(
					MypageUserLicensesImpl.class, primaryKey);

			if (mypageUserLicenses == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMypageUserLicensesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(mypageUserLicenses);
		}
		catch (NoSuchMypageUserLicensesException noSuchEntityException) {
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
	protected MypageUserLicenses removeImpl(
		MypageUserLicenses mypageUserLicenses) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mypageUserLicenses)) {
				mypageUserLicenses = (MypageUserLicenses)session.get(
					MypageUserLicensesImpl.class,
					mypageUserLicenses.getPrimaryKeyObj());
			}

			if (mypageUserLicenses != null) {
				session.delete(mypageUserLicenses);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (mypageUserLicenses != null) {
			clearCache(mypageUserLicenses);
		}

		return mypageUserLicenses;
	}

	@Override
	public MypageUserLicenses updateImpl(
		MypageUserLicenses mypageUserLicenses) {

		boolean isNew = mypageUserLicenses.isNew();

		if (!(mypageUserLicenses instanceof MypageUserLicensesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(mypageUserLicenses.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					mypageUserLicenses);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in mypageUserLicenses proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MypageUserLicenses implementation " +
					mypageUserLicenses.getClass());
		}

		MypageUserLicensesModelImpl mypageUserLicensesModelImpl =
			(MypageUserLicensesModelImpl)mypageUserLicenses;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (mypageUserLicenses.getCreateDate() == null)) {
			if (serviceContext == null) {
				mypageUserLicenses.setCreateDate(date);
			}
			else {
				mypageUserLicenses.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!mypageUserLicensesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				mypageUserLicenses.setModifiedDate(date);
			}
			else {
				mypageUserLicenses.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(mypageUserLicenses);
			}
			else {
				mypageUserLicenses = (MypageUserLicenses)session.merge(
					mypageUserLicenses);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MypageUserLicensesImpl.class, mypageUserLicensesModelImpl, false,
			true);

		if (isNew) {
			mypageUserLicenses.setNew(false);
		}

		mypageUserLicenses.resetOriginalValues();

		return mypageUserLicenses;
	}

	/**
	 * Returns the mypage user licenses with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mypage user licenses
	 * @return the mypage user licenses
	 * @throws NoSuchMypageUserLicensesException if a mypage user licenses with the primary key could not be found
	 */
	@Override
	public MypageUserLicenses findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMypageUserLicensesException {

		MypageUserLicenses mypageUserLicenses = fetchByPrimaryKey(primaryKey);

		if (mypageUserLicenses == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMypageUserLicensesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return mypageUserLicenses;
	}

	/**
	 * Returns the mypage user licenses with the primary key or throws a <code>NoSuchMypageUserLicensesException</code> if it could not be found.
	 *
	 * @param mypageUserLicensesId the primary key of the mypage user licenses
	 * @return the mypage user licenses
	 * @throws NoSuchMypageUserLicensesException if a mypage user licenses with the primary key could not be found
	 */
	@Override
	public MypageUserLicenses findByPrimaryKey(long mypageUserLicensesId)
		throws NoSuchMypageUserLicensesException {

		return findByPrimaryKey((Serializable)mypageUserLicensesId);
	}

	/**
	 * Returns the mypage user licenses with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserLicensesId the primary key of the mypage user licenses
	 * @return the mypage user licenses, or <code>null</code> if a mypage user licenses with the primary key could not be found
	 */
	@Override
	public MypageUserLicenses fetchByPrimaryKey(long mypageUserLicensesId) {
		return fetchByPrimaryKey((Serializable)mypageUserLicensesId);
	}

	/**
	 * Returns all the mypage user licenseses.
	 *
	 * @return the mypage user licenseses
	 */
	@Override
	public List<MypageUserLicenses> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mypage user licenseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @return the range of mypage user licenseses
	 */
	@Override
	public List<MypageUserLicenses> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the mypage user licenseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage user licenseses
	 */
	@Override
	public List<MypageUserLicenses> findAll(
		int start, int end,
		OrderByComparator<MypageUserLicenses> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mypage user licenseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserLicensesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage user licenseses
	 * @param end the upper bound of the range of mypage user licenseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage user licenseses
	 */
	@Override
	public List<MypageUserLicenses> findAll(
		int start, int end,
		OrderByComparator<MypageUserLicenses> orderByComparator,
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

		List<MypageUserLicenses> list = null;

		if (useFinderCache) {
			list = (List<MypageUserLicenses>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MYPAGEUSERLICENSES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MYPAGEUSERLICENSES;

				sql = sql.concat(MypageUserLicensesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MypageUserLicenses>)QueryUtil.list(
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
	 * Removes all the mypage user licenseses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MypageUserLicenses mypageUserLicenses : findAll()) {
			remove(mypageUserLicenses);
		}
	}

	/**
	 * Returns the number of mypage user licenseses.
	 *
	 * @return the number of mypage user licenseses
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
					_SQL_COUNT_MYPAGEUSERLICENSES);

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
		return "mypageUserLicensesId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MYPAGEUSERLICENSES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MypageUserLicensesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the mypage user licenses persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new MypageUserLicensesModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MypageUserLicenses.class.getName()));

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

		_setMypageUserLicensesUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMypageUserLicensesUtilPersistence(null);

		entityCache.removeCache(MypageUserLicensesImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setMypageUserLicensesUtilPersistence(
		MypageUserLicensesPersistence mypageUserLicensesPersistence) {

		try {
			Field field = MypageUserLicensesUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, mypageUserLicensesPersistence);
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

	private static final String _SQL_SELECT_MYPAGEUSERLICENSES =
		"SELECT mypageUserLicenses FROM MypageUserLicenses mypageUserLicenses";

	private static final String _SQL_SELECT_MYPAGEUSERLICENSES_WHERE =
		"SELECT mypageUserLicenses FROM MypageUserLicenses mypageUserLicenses WHERE ";

	private static final String _SQL_COUNT_MYPAGEUSERLICENSES =
		"SELECT COUNT(mypageUserLicenses) FROM MypageUserLicenses mypageUserLicenses";

	private static final String _SQL_COUNT_MYPAGEUSERLICENSES_WHERE =
		"SELECT COUNT(mypageUserLicenses) FROM MypageUserLicenses mypageUserLicenses WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "mypageUserLicenses.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MypageUserLicenses exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MypageUserLicenses exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MypageUserLicensesPersistenceImpl.class);

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

	private static class MypageUserLicensesModelArgumentsResolver
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

			MypageUserLicensesModelImpl mypageUserLicensesModelImpl =
				(MypageUserLicensesModelImpl)baseModel;

			long columnBitmask = mypageUserLicensesModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					mypageUserLicensesModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						mypageUserLicensesModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					mypageUserLicensesModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			MypageUserLicensesModelImpl mypageUserLicensesModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						mypageUserLicensesModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = mypageUserLicensesModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}