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

import com.mypage.user.exception.NoSuchUserRegistrationLiabilityException;
import com.mypage.user.model.UserRegistrationLiability;
import com.mypage.user.model.impl.UserRegistrationLiabilityImpl;
import com.mypage.user.model.impl.UserRegistrationLiabilityModelImpl;
import com.mypage.user.service.persistence.UserRegistrationLiabilityPersistence;
import com.mypage.user.service.persistence.UserRegistrationLiabilityUtil;
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
 * The persistence implementation for the user registration liability service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UserRegistrationLiabilityPersistence.class)
public class UserRegistrationLiabilityPersistenceImpl
	extends BasePersistenceImpl<UserRegistrationLiability>
	implements UserRegistrationLiabilityPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserRegistrationLiabilityUtil</code> to access the user registration liability persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserRegistrationLiabilityImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUserRegistrationId;
	private FinderPath _finderPathWithoutPaginationFindByUserRegistrationId;
	private FinderPath _finderPathCountByUserRegistrationId;

	/**
	 * Returns all the user registration liabilities where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the matching user registration liabilities
	 */
	@Override
	public List<UserRegistrationLiability> findByUserRegistrationId(
		long userRegistrationId) {

		return findByUserRegistrationId(
			userRegistrationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user registration liabilities where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationLiabilityModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration liabilities
	 * @param end the upper bound of the range of user registration liabilities (not inclusive)
	 * @return the range of matching user registration liabilities
	 */
	@Override
	public List<UserRegistrationLiability> findByUserRegistrationId(
		long userRegistrationId, int start, int end) {

		return findByUserRegistrationId(userRegistrationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user registration liabilities where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationLiabilityModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration liabilities
	 * @param end the upper bound of the range of user registration liabilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user registration liabilities
	 */
	@Override
	public List<UserRegistrationLiability> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		OrderByComparator<UserRegistrationLiability> orderByComparator) {

		return findByUserRegistrationId(
			userRegistrationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user registration liabilities where userRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationLiabilityModelImpl</code>.
	 * </p>
	 *
	 * @param userRegistrationId the user registration ID
	 * @param start the lower bound of the range of user registration liabilities
	 * @param end the upper bound of the range of user registration liabilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user registration liabilities
	 */
	@Override
	public List<UserRegistrationLiability> findByUserRegistrationId(
		long userRegistrationId, int start, int end,
		OrderByComparator<UserRegistrationLiability> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByUserRegistrationId;
				finderArgs = new Object[] {userRegistrationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserRegistrationId;
			finderArgs = new Object[] {
				userRegistrationId, start, end, orderByComparator
			};
		}

		List<UserRegistrationLiability> list = null;

		if (useFinderCache) {
			list = (List<UserRegistrationLiability>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserRegistrationLiability userRegistrationLiability :
						list) {

					if (userRegistrationId !=
							userRegistrationLiability.getUserRegistrationId()) {

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

			sb.append(_SQL_SELECT_USERREGISTRATIONLIABILITY_WHERE);

			sb.append(_FINDER_COLUMN_USERREGISTRATIONID_USERREGISTRATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserRegistrationLiabilityModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userRegistrationId);

				list = (List<UserRegistrationLiability>)QueryUtil.list(
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
	 * Returns the first user registration liability in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration liability
	 * @throws NoSuchUserRegistrationLiabilityException if a matching user registration liability could not be found
	 */
	@Override
	public UserRegistrationLiability findByUserRegistrationId_First(
			long userRegistrationId,
			OrderByComparator<UserRegistrationLiability> orderByComparator)
		throws NoSuchUserRegistrationLiabilityException {

		UserRegistrationLiability userRegistrationLiability =
			fetchByUserRegistrationId_First(
				userRegistrationId, orderByComparator);

		if (userRegistrationLiability != null) {
			return userRegistrationLiability;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userRegistrationId=");
		sb.append(userRegistrationId);

		sb.append("}");

		throw new NoSuchUserRegistrationLiabilityException(sb.toString());
	}

	/**
	 * Returns the first user registration liability in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration liability, or <code>null</code> if a matching user registration liability could not be found
	 */
	@Override
	public UserRegistrationLiability fetchByUserRegistrationId_First(
		long userRegistrationId,
		OrderByComparator<UserRegistrationLiability> orderByComparator) {

		List<UserRegistrationLiability> list = findByUserRegistrationId(
			userRegistrationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user registration liability in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration liability
	 * @throws NoSuchUserRegistrationLiabilityException if a matching user registration liability could not be found
	 */
	@Override
	public UserRegistrationLiability findByUserRegistrationId_Last(
			long userRegistrationId,
			OrderByComparator<UserRegistrationLiability> orderByComparator)
		throws NoSuchUserRegistrationLiabilityException {

		UserRegistrationLiability userRegistrationLiability =
			fetchByUserRegistrationId_Last(
				userRegistrationId, orderByComparator);

		if (userRegistrationLiability != null) {
			return userRegistrationLiability;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userRegistrationId=");
		sb.append(userRegistrationId);

		sb.append("}");

		throw new NoSuchUserRegistrationLiabilityException(sb.toString());
	}

	/**
	 * Returns the last user registration liability in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration liability, or <code>null</code> if a matching user registration liability could not be found
	 */
	@Override
	public UserRegistrationLiability fetchByUserRegistrationId_Last(
		long userRegistrationId,
		OrderByComparator<UserRegistrationLiability> orderByComparator) {

		int count = countByUserRegistrationId(userRegistrationId);

		if (count == 0) {
			return null;
		}

		List<UserRegistrationLiability> list = findByUserRegistrationId(
			userRegistrationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user registration liabilities before and after the current user registration liability in the ordered set where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationLiabilityId the primary key of the current user registration liability
	 * @param userRegistrationId the user registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user registration liability
	 * @throws NoSuchUserRegistrationLiabilityException if a user registration liability with the primary key could not be found
	 */
	@Override
	public UserRegistrationLiability[] findByUserRegistrationId_PrevAndNext(
			long userRegistrationLiabilityId, long userRegistrationId,
			OrderByComparator<UserRegistrationLiability> orderByComparator)
		throws NoSuchUserRegistrationLiabilityException {

		UserRegistrationLiability userRegistrationLiability = findByPrimaryKey(
			userRegistrationLiabilityId);

		Session session = null;

		try {
			session = openSession();

			UserRegistrationLiability[] array =
				new UserRegistrationLiabilityImpl[3];

			array[0] = getByUserRegistrationId_PrevAndNext(
				session, userRegistrationLiability, userRegistrationId,
				orderByComparator, true);

			array[1] = userRegistrationLiability;

			array[2] = getByUserRegistrationId_PrevAndNext(
				session, userRegistrationLiability, userRegistrationId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserRegistrationLiability getByUserRegistrationId_PrevAndNext(
		Session session, UserRegistrationLiability userRegistrationLiability,
		long userRegistrationId,
		OrderByComparator<UserRegistrationLiability> orderByComparator,
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

		sb.append(_SQL_SELECT_USERREGISTRATIONLIABILITY_WHERE);

		sb.append(_FINDER_COLUMN_USERREGISTRATIONID_USERREGISTRATIONID_2);

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
			sb.append(UserRegistrationLiabilityModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userRegistrationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						userRegistrationLiability)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserRegistrationLiability> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user registration liabilities where userRegistrationId = &#63; from the database.
	 *
	 * @param userRegistrationId the user registration ID
	 */
	@Override
	public void removeByUserRegistrationId(long userRegistrationId) {
		for (UserRegistrationLiability userRegistrationLiability :
				findByUserRegistrationId(
					userRegistrationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userRegistrationLiability);
		}
	}

	/**
	 * Returns the number of user registration liabilities where userRegistrationId = &#63;.
	 *
	 * @param userRegistrationId the user registration ID
	 * @return the number of matching user registration liabilities
	 */
	@Override
	public int countByUserRegistrationId(long userRegistrationId) {
		FinderPath finderPath = _finderPathCountByUserRegistrationId;

		Object[] finderArgs = new Object[] {userRegistrationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERREGISTRATIONLIABILITY_WHERE);

			sb.append(_FINDER_COLUMN_USERREGISTRATIONID_USERREGISTRATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userRegistrationId);

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
		_FINDER_COLUMN_USERREGISTRATIONID_USERREGISTRATIONID_2 =
			"userRegistrationLiability.userRegistrationId = ?";

	public UserRegistrationLiabilityPersistenceImpl() {
		setModelClass(UserRegistrationLiability.class);

		setModelImplClass(UserRegistrationLiabilityImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the user registration liability in the entity cache if it is enabled.
	 *
	 * @param userRegistrationLiability the user registration liability
	 */
	@Override
	public void cacheResult(
		UserRegistrationLiability userRegistrationLiability) {

		entityCache.putResult(
			UserRegistrationLiabilityImpl.class,
			userRegistrationLiability.getPrimaryKey(),
			userRegistrationLiability);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the user registration liabilities in the entity cache if it is enabled.
	 *
	 * @param userRegistrationLiabilities the user registration liabilities
	 */
	@Override
	public void cacheResult(
		List<UserRegistrationLiability> userRegistrationLiabilities) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (userRegistrationLiabilities.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UserRegistrationLiability userRegistrationLiability :
				userRegistrationLiabilities) {

			if (entityCache.getResult(
					UserRegistrationLiabilityImpl.class,
					userRegistrationLiability.getPrimaryKey()) == null) {

				cacheResult(userRegistrationLiability);
			}
		}
	}

	/**
	 * Clears the cache for all user registration liabilities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserRegistrationLiabilityImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user registration liability.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		UserRegistrationLiability userRegistrationLiability) {

		entityCache.removeResult(
			UserRegistrationLiabilityImpl.class, userRegistrationLiability);
	}

	@Override
	public void clearCache(
		List<UserRegistrationLiability> userRegistrationLiabilities) {

		for (UserRegistrationLiability userRegistrationLiability :
				userRegistrationLiabilities) {

			entityCache.removeResult(
				UserRegistrationLiabilityImpl.class, userRegistrationLiability);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				UserRegistrationLiabilityImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new user registration liability with the primary key. Does not add the user registration liability to the database.
	 *
	 * @param userRegistrationLiabilityId the primary key for the new user registration liability
	 * @return the new user registration liability
	 */
	@Override
	public UserRegistrationLiability create(long userRegistrationLiabilityId) {
		UserRegistrationLiability userRegistrationLiability =
			new UserRegistrationLiabilityImpl();

		userRegistrationLiability.setNew(true);
		userRegistrationLiability.setPrimaryKey(userRegistrationLiabilityId);

		userRegistrationLiability.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return userRegistrationLiability;
	}

	/**
	 * Removes the user registration liability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRegistrationLiabilityId the primary key of the user registration liability
	 * @return the user registration liability that was removed
	 * @throws NoSuchUserRegistrationLiabilityException if a user registration liability with the primary key could not be found
	 */
	@Override
	public UserRegistrationLiability remove(long userRegistrationLiabilityId)
		throws NoSuchUserRegistrationLiabilityException {

		return remove((Serializable)userRegistrationLiabilityId);
	}

	/**
	 * Removes the user registration liability with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user registration liability
	 * @return the user registration liability that was removed
	 * @throws NoSuchUserRegistrationLiabilityException if a user registration liability with the primary key could not be found
	 */
	@Override
	public UserRegistrationLiability remove(Serializable primaryKey)
		throws NoSuchUserRegistrationLiabilityException {

		Session session = null;

		try {
			session = openSession();

			UserRegistrationLiability userRegistrationLiability =
				(UserRegistrationLiability)session.get(
					UserRegistrationLiabilityImpl.class, primaryKey);

			if (userRegistrationLiability == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserRegistrationLiabilityException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userRegistrationLiability);
		}
		catch (NoSuchUserRegistrationLiabilityException noSuchEntityException) {
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
	protected UserRegistrationLiability removeImpl(
		UserRegistrationLiability userRegistrationLiability) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userRegistrationLiability)) {
				userRegistrationLiability =
					(UserRegistrationLiability)session.get(
						UserRegistrationLiabilityImpl.class,
						userRegistrationLiability.getPrimaryKeyObj());
			}

			if (userRegistrationLiability != null) {
				session.delete(userRegistrationLiability);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userRegistrationLiability != null) {
			clearCache(userRegistrationLiability);
		}

		return userRegistrationLiability;
	}

	@Override
	public UserRegistrationLiability updateImpl(
		UserRegistrationLiability userRegistrationLiability) {

		boolean isNew = userRegistrationLiability.isNew();

		if (!(userRegistrationLiability instanceof
				UserRegistrationLiabilityModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userRegistrationLiability.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					userRegistrationLiability);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userRegistrationLiability proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserRegistrationLiability implementation " +
					userRegistrationLiability.getClass());
		}

		UserRegistrationLiabilityModelImpl userRegistrationLiabilityModelImpl =
			(UserRegistrationLiabilityModelImpl)userRegistrationLiability;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (userRegistrationLiability.getCreateDate() == null)) {
			if (serviceContext == null) {
				userRegistrationLiability.setCreateDate(date);
			}
			else {
				userRegistrationLiability.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!userRegistrationLiabilityModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userRegistrationLiability.setModifiedDate(date);
			}
			else {
				userRegistrationLiability.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userRegistrationLiability);
			}
			else {
				userRegistrationLiability =
					(UserRegistrationLiability)session.merge(
						userRegistrationLiability);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UserRegistrationLiabilityImpl.class,
			userRegistrationLiabilityModelImpl, false, true);

		if (isNew) {
			userRegistrationLiability.setNew(false);
		}

		userRegistrationLiability.resetOriginalValues();

		return userRegistrationLiability;
	}

	/**
	 * Returns the user registration liability with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user registration liability
	 * @return the user registration liability
	 * @throws NoSuchUserRegistrationLiabilityException if a user registration liability with the primary key could not be found
	 */
	@Override
	public UserRegistrationLiability findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserRegistrationLiabilityException {

		UserRegistrationLiability userRegistrationLiability = fetchByPrimaryKey(
			primaryKey);

		if (userRegistrationLiability == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserRegistrationLiabilityException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userRegistrationLiability;
	}

	/**
	 * Returns the user registration liability with the primary key or throws a <code>NoSuchUserRegistrationLiabilityException</code> if it could not be found.
	 *
	 * @param userRegistrationLiabilityId the primary key of the user registration liability
	 * @return the user registration liability
	 * @throws NoSuchUserRegistrationLiabilityException if a user registration liability with the primary key could not be found
	 */
	@Override
	public UserRegistrationLiability findByPrimaryKey(
			long userRegistrationLiabilityId)
		throws NoSuchUserRegistrationLiabilityException {

		return findByPrimaryKey((Serializable)userRegistrationLiabilityId);
	}

	/**
	 * Returns the user registration liability with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRegistrationLiabilityId the primary key of the user registration liability
	 * @return the user registration liability, or <code>null</code> if a user registration liability with the primary key could not be found
	 */
	@Override
	public UserRegistrationLiability fetchByPrimaryKey(
		long userRegistrationLiabilityId) {

		return fetchByPrimaryKey((Serializable)userRegistrationLiabilityId);
	}

	/**
	 * Returns all the user registration liabilities.
	 *
	 * @return the user registration liabilities
	 */
	@Override
	public List<UserRegistrationLiability> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user registration liabilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationLiabilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration liabilities
	 * @param end the upper bound of the range of user registration liabilities (not inclusive)
	 * @return the range of user registration liabilities
	 */
	@Override
	public List<UserRegistrationLiability> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user registration liabilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationLiabilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration liabilities
	 * @param end the upper bound of the range of user registration liabilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user registration liabilities
	 */
	@Override
	public List<UserRegistrationLiability> findAll(
		int start, int end,
		OrderByComparator<UserRegistrationLiability> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user registration liabilities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRegistrationLiabilityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registration liabilities
	 * @param end the upper bound of the range of user registration liabilities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user registration liabilities
	 */
	@Override
	public List<UserRegistrationLiability> findAll(
		int start, int end,
		OrderByComparator<UserRegistrationLiability> orderByComparator,
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

		List<UserRegistrationLiability> list = null;

		if (useFinderCache) {
			list = (List<UserRegistrationLiability>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERREGISTRATIONLIABILITY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERREGISTRATIONLIABILITY;

				sql = sql.concat(
					UserRegistrationLiabilityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserRegistrationLiability>)QueryUtil.list(
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
	 * Removes all the user registration liabilities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserRegistrationLiability userRegistrationLiability : findAll()) {
			remove(userRegistrationLiability);
		}
	}

	/**
	 * Returns the number of user registration liabilities.
	 *
	 * @return the number of user registration liabilities
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
					_SQL_COUNT_USERREGISTRATIONLIABILITY);

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
		return "userRegistrationLiabilityId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERREGISTRATIONLIABILITY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserRegistrationLiabilityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user registration liability persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new UserRegistrationLiabilityModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", UserRegistrationLiability.class.getName()));

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

		_finderPathWithPaginationFindByUserRegistrationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserRegistrationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userRegistrationId"}, true);

		_finderPathWithoutPaginationFindByUserRegistrationId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByUserRegistrationId", new String[] {Long.class.getName()},
				new String[] {"userRegistrationId"}, true);

		_finderPathCountByUserRegistrationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserRegistrationId", new String[] {Long.class.getName()},
			new String[] {"userRegistrationId"}, false);

		_setUserRegistrationLiabilityUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setUserRegistrationLiabilityUtilPersistence(null);

		entityCache.removeCache(UserRegistrationLiabilityImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setUserRegistrationLiabilityUtilPersistence(
		UserRegistrationLiabilityPersistence
			userRegistrationLiabilityPersistence) {

		try {
			Field field = UserRegistrationLiabilityUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, userRegistrationLiabilityPersistence);
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

	private static final String _SQL_SELECT_USERREGISTRATIONLIABILITY =
		"SELECT userRegistrationLiability FROM UserRegistrationLiability userRegistrationLiability";

	private static final String _SQL_SELECT_USERREGISTRATIONLIABILITY_WHERE =
		"SELECT userRegistrationLiability FROM UserRegistrationLiability userRegistrationLiability WHERE ";

	private static final String _SQL_COUNT_USERREGISTRATIONLIABILITY =
		"SELECT COUNT(userRegistrationLiability) FROM UserRegistrationLiability userRegistrationLiability";

	private static final String _SQL_COUNT_USERREGISTRATIONLIABILITY_WHERE =
		"SELECT COUNT(userRegistrationLiability) FROM UserRegistrationLiability userRegistrationLiability WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"userRegistrationLiability.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserRegistrationLiability exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserRegistrationLiability exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserRegistrationLiabilityPersistenceImpl.class);

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

	private static class UserRegistrationLiabilityModelArgumentsResolver
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

			UserRegistrationLiabilityModelImpl
				userRegistrationLiabilityModelImpl =
					(UserRegistrationLiabilityModelImpl)baseModel;

			long columnBitmask =
				userRegistrationLiabilityModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					userRegistrationLiabilityModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						userRegistrationLiabilityModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					userRegistrationLiabilityModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			UserRegistrationLiabilityModelImpl
				userRegistrationLiabilityModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						userRegistrationLiabilityModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						userRegistrationLiabilityModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}