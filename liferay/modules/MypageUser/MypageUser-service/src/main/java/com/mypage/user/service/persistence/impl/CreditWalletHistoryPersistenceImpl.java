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

import com.mypage.user.exception.NoSuchCreditWalletHistoryException;
import com.mypage.user.model.CreditWalletHistory;
import com.mypage.user.model.impl.CreditWalletHistoryImpl;
import com.mypage.user.model.impl.CreditWalletHistoryModelImpl;
import com.mypage.user.service.persistence.CreditWalletHistoryPersistence;
import com.mypage.user.service.persistence.CreditWalletHistoryUtil;
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
 * The persistence implementation for the credit wallet history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CreditWalletHistoryPersistence.class)
public class CreditWalletHistoryPersistenceImpl
	extends BasePersistenceImpl<CreditWalletHistory>
	implements CreditWalletHistoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CreditWalletHistoryUtil</code> to access the credit wallet history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CreditWalletHistoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBygetCreditWalletId;
	private FinderPath _finderPathWithoutPaginationFindBygetCreditWalletId;
	private FinderPath _finderPathCountBygetCreditWalletId;

	/**
	 * Returns all the credit wallet histories where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the matching credit wallet histories
	 */
	@Override
	public List<CreditWalletHistory> findBygetCreditWalletId(
		long creditWalletId) {

		return findBygetCreditWalletId(
			creditWalletId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit wallet histories where creditWalletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @return the range of matching credit wallet histories
	 */
	@Override
	public List<CreditWalletHistory> findBygetCreditWalletId(
		long creditWalletId, int start, int end) {

		return findBygetCreditWalletId(creditWalletId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit wallet histories where creditWalletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching credit wallet histories
	 */
	@Override
	public List<CreditWalletHistory> findBygetCreditWalletId(
		long creditWalletId, int start, int end,
		OrderByComparator<CreditWalletHistory> orderByComparator) {

		return findBygetCreditWalletId(
			creditWalletId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the credit wallet histories where creditWalletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching credit wallet histories
	 */
	@Override
	public List<CreditWalletHistory> findBygetCreditWalletId(
		long creditWalletId, int start, int end,
		OrderByComparator<CreditWalletHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBygetCreditWalletId;
				finderArgs = new Object[] {creditWalletId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBygetCreditWalletId;
			finderArgs = new Object[] {
				creditWalletId, start, end, orderByComparator
			};
		}

		List<CreditWalletHistory> list = null;

		if (useFinderCache) {
			list = (List<CreditWalletHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CreditWalletHistory creditWalletHistory : list) {
					if (creditWalletId !=
							creditWalletHistory.getCreditWalletId()) {

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

			sb.append(_SQL_SELECT_CREDITWALLETHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_GETCREDITWALLETID_CREDITWALLETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CreditWalletHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(creditWalletId);

				list = (List<CreditWalletHistory>)QueryUtil.list(
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
	 * Returns the first credit wallet history in the ordered set where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit wallet history
	 * @throws NoSuchCreditWalletHistoryException if a matching credit wallet history could not be found
	 */
	@Override
	public CreditWalletHistory findBygetCreditWalletId_First(
			long creditWalletId,
			OrderByComparator<CreditWalletHistory> orderByComparator)
		throws NoSuchCreditWalletHistoryException {

		CreditWalletHistory creditWalletHistory =
			fetchBygetCreditWalletId_First(creditWalletId, orderByComparator);

		if (creditWalletHistory != null) {
			return creditWalletHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("creditWalletId=");
		sb.append(creditWalletId);

		sb.append("}");

		throw new NoSuchCreditWalletHistoryException(sb.toString());
	}

	/**
	 * Returns the first credit wallet history in the ordered set where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit wallet history, or <code>null</code> if a matching credit wallet history could not be found
	 */
	@Override
	public CreditWalletHistory fetchBygetCreditWalletId_First(
		long creditWalletId,
		OrderByComparator<CreditWalletHistory> orderByComparator) {

		List<CreditWalletHistory> list = findBygetCreditWalletId(
			creditWalletId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last credit wallet history in the ordered set where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit wallet history
	 * @throws NoSuchCreditWalletHistoryException if a matching credit wallet history could not be found
	 */
	@Override
	public CreditWalletHistory findBygetCreditWalletId_Last(
			long creditWalletId,
			OrderByComparator<CreditWalletHistory> orderByComparator)
		throws NoSuchCreditWalletHistoryException {

		CreditWalletHistory creditWalletHistory = fetchBygetCreditWalletId_Last(
			creditWalletId, orderByComparator);

		if (creditWalletHistory != null) {
			return creditWalletHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("creditWalletId=");
		sb.append(creditWalletId);

		sb.append("}");

		throw new NoSuchCreditWalletHistoryException(sb.toString());
	}

	/**
	 * Returns the last credit wallet history in the ordered set where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit wallet history, or <code>null</code> if a matching credit wallet history could not be found
	 */
	@Override
	public CreditWalletHistory fetchBygetCreditWalletId_Last(
		long creditWalletId,
		OrderByComparator<CreditWalletHistory> orderByComparator) {

		int count = countBygetCreditWalletId(creditWalletId);

		if (count == 0) {
			return null;
		}

		List<CreditWalletHistory> list = findBygetCreditWalletId(
			creditWalletId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the credit wallet histories before and after the current credit wallet history in the ordered set where creditWalletId = &#63;.
	 *
	 * @param creditWalletHistoryId the primary key of the current credit wallet history
	 * @param creditWalletId the credit wallet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next credit wallet history
	 * @throws NoSuchCreditWalletHistoryException if a credit wallet history with the primary key could not be found
	 */
	@Override
	public CreditWalletHistory[] findBygetCreditWalletId_PrevAndNext(
			long creditWalletHistoryId, long creditWalletId,
			OrderByComparator<CreditWalletHistory> orderByComparator)
		throws NoSuchCreditWalletHistoryException {

		CreditWalletHistory creditWalletHistory = findByPrimaryKey(
			creditWalletHistoryId);

		Session session = null;

		try {
			session = openSession();

			CreditWalletHistory[] array = new CreditWalletHistoryImpl[3];

			array[0] = getBygetCreditWalletId_PrevAndNext(
				session, creditWalletHistory, creditWalletId, orderByComparator,
				true);

			array[1] = creditWalletHistory;

			array[2] = getBygetCreditWalletId_PrevAndNext(
				session, creditWalletHistory, creditWalletId, orderByComparator,
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

	protected CreditWalletHistory getBygetCreditWalletId_PrevAndNext(
		Session session, CreditWalletHistory creditWalletHistory,
		long creditWalletId,
		OrderByComparator<CreditWalletHistory> orderByComparator,
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

		sb.append(_SQL_SELECT_CREDITWALLETHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_GETCREDITWALLETID_CREDITWALLETID_2);

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
			sb.append(CreditWalletHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(creditWalletId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						creditWalletHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CreditWalletHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the credit wallet histories where creditWalletId = &#63; from the database.
	 *
	 * @param creditWalletId the credit wallet ID
	 */
	@Override
	public void removeBygetCreditWalletId(long creditWalletId) {
		for (CreditWalletHistory creditWalletHistory :
				findBygetCreditWalletId(
					creditWalletId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(creditWalletHistory);
		}
	}

	/**
	 * Returns the number of credit wallet histories where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the number of matching credit wallet histories
	 */
	@Override
	public int countBygetCreditWalletId(long creditWalletId) {
		FinderPath finderPath = _finderPathCountBygetCreditWalletId;

		Object[] finderArgs = new Object[] {creditWalletId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CREDITWALLETHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_GETCREDITWALLETID_CREDITWALLETID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(creditWalletId);

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
		_FINDER_COLUMN_GETCREDITWALLETID_CREDITWALLETID_2 =
			"creditWalletHistory.creditWalletId = ?";

	public CreditWalletHistoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CreditWalletHistory.class);

		setModelImplClass(CreditWalletHistoryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the credit wallet history in the entity cache if it is enabled.
	 *
	 * @param creditWalletHistory the credit wallet history
	 */
	@Override
	public void cacheResult(CreditWalletHistory creditWalletHistory) {
		entityCache.putResult(
			CreditWalletHistoryImpl.class, creditWalletHistory.getPrimaryKey(),
			creditWalletHistory);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the credit wallet histories in the entity cache if it is enabled.
	 *
	 * @param creditWalletHistories the credit wallet histories
	 */
	@Override
	public void cacheResult(List<CreditWalletHistory> creditWalletHistories) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (creditWalletHistories.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CreditWalletHistory creditWalletHistory : creditWalletHistories) {
			if (entityCache.getResult(
					CreditWalletHistoryImpl.class,
					creditWalletHistory.getPrimaryKey()) == null) {

				cacheResult(creditWalletHistory);
			}
		}
	}

	/**
	 * Clears the cache for all credit wallet histories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CreditWalletHistoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the credit wallet history.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CreditWalletHistory creditWalletHistory) {
		entityCache.removeResult(
			CreditWalletHistoryImpl.class, creditWalletHistory);
	}

	@Override
	public void clearCache(List<CreditWalletHistory> creditWalletHistories) {
		for (CreditWalletHistory creditWalletHistory : creditWalletHistories) {
			entityCache.removeResult(
				CreditWalletHistoryImpl.class, creditWalletHistory);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CreditWalletHistoryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new credit wallet history with the primary key. Does not add the credit wallet history to the database.
	 *
	 * @param creditWalletHistoryId the primary key for the new credit wallet history
	 * @return the new credit wallet history
	 */
	@Override
	public CreditWalletHistory create(long creditWalletHistoryId) {
		CreditWalletHistory creditWalletHistory = new CreditWalletHistoryImpl();

		creditWalletHistory.setNew(true);
		creditWalletHistory.setPrimaryKey(creditWalletHistoryId);

		creditWalletHistory.setCompanyId(CompanyThreadLocal.getCompanyId());

		return creditWalletHistory;
	}

	/**
	 * Removes the credit wallet history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creditWalletHistoryId the primary key of the credit wallet history
	 * @return the credit wallet history that was removed
	 * @throws NoSuchCreditWalletHistoryException if a credit wallet history with the primary key could not be found
	 */
	@Override
	public CreditWalletHistory remove(long creditWalletHistoryId)
		throws NoSuchCreditWalletHistoryException {

		return remove((Serializable)creditWalletHistoryId);
	}

	/**
	 * Removes the credit wallet history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the credit wallet history
	 * @return the credit wallet history that was removed
	 * @throws NoSuchCreditWalletHistoryException if a credit wallet history with the primary key could not be found
	 */
	@Override
	public CreditWalletHistory remove(Serializable primaryKey)
		throws NoSuchCreditWalletHistoryException {

		Session session = null;

		try {
			session = openSession();

			CreditWalletHistory creditWalletHistory =
				(CreditWalletHistory)session.get(
					CreditWalletHistoryImpl.class, primaryKey);

			if (creditWalletHistory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCreditWalletHistoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(creditWalletHistory);
		}
		catch (NoSuchCreditWalletHistoryException noSuchEntityException) {
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
	protected CreditWalletHistory removeImpl(
		CreditWalletHistory creditWalletHistory) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(creditWalletHistory)) {
				creditWalletHistory = (CreditWalletHistory)session.get(
					CreditWalletHistoryImpl.class,
					creditWalletHistory.getPrimaryKeyObj());
			}

			if (creditWalletHistory != null) {
				session.delete(creditWalletHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (creditWalletHistory != null) {
			clearCache(creditWalletHistory);
		}

		return creditWalletHistory;
	}

	@Override
	public CreditWalletHistory updateImpl(
		CreditWalletHistory creditWalletHistory) {

		boolean isNew = creditWalletHistory.isNew();

		if (!(creditWalletHistory instanceof CreditWalletHistoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(creditWalletHistory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					creditWalletHistory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in creditWalletHistory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CreditWalletHistory implementation " +
					creditWalletHistory.getClass());
		}

		CreditWalletHistoryModelImpl creditWalletHistoryModelImpl =
			(CreditWalletHistoryModelImpl)creditWalletHistory;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (creditWalletHistory.getCreateDate() == null)) {
			if (serviceContext == null) {
				creditWalletHistory.setCreateDate(date);
			}
			else {
				creditWalletHistory.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!creditWalletHistoryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				creditWalletHistory.setModifiedDate(date);
			}
			else {
				creditWalletHistory.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(creditWalletHistory);
			}
			else {
				creditWalletHistory = (CreditWalletHistory)session.merge(
					creditWalletHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CreditWalletHistoryImpl.class, creditWalletHistoryModelImpl, false,
			true);

		if (isNew) {
			creditWalletHistory.setNew(false);
		}

		creditWalletHistory.resetOriginalValues();

		return creditWalletHistory;
	}

	/**
	 * Returns the credit wallet history with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the credit wallet history
	 * @return the credit wallet history
	 * @throws NoSuchCreditWalletHistoryException if a credit wallet history with the primary key could not be found
	 */
	@Override
	public CreditWalletHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCreditWalletHistoryException {

		CreditWalletHistory creditWalletHistory = fetchByPrimaryKey(primaryKey);

		if (creditWalletHistory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCreditWalletHistoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return creditWalletHistory;
	}

	/**
	 * Returns the credit wallet history with the primary key or throws a <code>NoSuchCreditWalletHistoryException</code> if it could not be found.
	 *
	 * @param creditWalletHistoryId the primary key of the credit wallet history
	 * @return the credit wallet history
	 * @throws NoSuchCreditWalletHistoryException if a credit wallet history with the primary key could not be found
	 */
	@Override
	public CreditWalletHistory findByPrimaryKey(long creditWalletHistoryId)
		throws NoSuchCreditWalletHistoryException {

		return findByPrimaryKey((Serializable)creditWalletHistoryId);
	}

	/**
	 * Returns the credit wallet history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param creditWalletHistoryId the primary key of the credit wallet history
	 * @return the credit wallet history, or <code>null</code> if a credit wallet history with the primary key could not be found
	 */
	@Override
	public CreditWalletHistory fetchByPrimaryKey(long creditWalletHistoryId) {
		return fetchByPrimaryKey((Serializable)creditWalletHistoryId);
	}

	/**
	 * Returns all the credit wallet histories.
	 *
	 * @return the credit wallet histories
	 */
	@Override
	public List<CreditWalletHistory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit wallet histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @return the range of credit wallet histories
	 */
	@Override
	public List<CreditWalletHistory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit wallet histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of credit wallet histories
	 */
	@Override
	public List<CreditWalletHistory> findAll(
		int start, int end,
		OrderByComparator<CreditWalletHistory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the credit wallet histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreditWalletHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit wallet histories
	 * @param end the upper bound of the range of credit wallet histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of credit wallet histories
	 */
	@Override
	public List<CreditWalletHistory> findAll(
		int start, int end,
		OrderByComparator<CreditWalletHistory> orderByComparator,
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

		List<CreditWalletHistory> list = null;

		if (useFinderCache) {
			list = (List<CreditWalletHistory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CREDITWALLETHISTORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CREDITWALLETHISTORY;

				sql = sql.concat(CreditWalletHistoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CreditWalletHistory>)QueryUtil.list(
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
	 * Removes all the credit wallet histories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CreditWalletHistory creditWalletHistory : findAll()) {
			remove(creditWalletHistory);
		}
	}

	/**
	 * Returns the number of credit wallet histories.
	 *
	 * @return the number of credit wallet histories
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
					_SQL_COUNT_CREDITWALLETHISTORY);

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
		return "creditWalletHistoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CREDITWALLETHISTORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CreditWalletHistoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the credit wallet history persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new CreditWalletHistoryModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CreditWalletHistory.class.getName()));

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

		_finderPathWithPaginationFindBygetCreditWalletId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygetCreditWalletId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"creditWalletId"}, true);

		_finderPathWithoutPaginationFindBygetCreditWalletId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBygetCreditWalletId", new String[] {Long.class.getName()},
			new String[] {"creditWalletId"}, true);

		_finderPathCountBygetCreditWalletId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBygetCreditWalletId", new String[] {Long.class.getName()},
			new String[] {"creditWalletId"}, false);

		_setCreditWalletHistoryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCreditWalletHistoryUtilPersistence(null);

		entityCache.removeCache(CreditWalletHistoryImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setCreditWalletHistoryUtilPersistence(
		CreditWalletHistoryPersistence creditWalletHistoryPersistence) {

		try {
			Field field = CreditWalletHistoryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, creditWalletHistoryPersistence);
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

	private static final String _SQL_SELECT_CREDITWALLETHISTORY =
		"SELECT creditWalletHistory FROM CreditWalletHistory creditWalletHistory";

	private static final String _SQL_SELECT_CREDITWALLETHISTORY_WHERE =
		"SELECT creditWalletHistory FROM CreditWalletHistory creditWalletHistory WHERE ";

	private static final String _SQL_COUNT_CREDITWALLETHISTORY =
		"SELECT COUNT(creditWalletHistory) FROM CreditWalletHistory creditWalletHistory";

	private static final String _SQL_COUNT_CREDITWALLETHISTORY_WHERE =
		"SELECT COUNT(creditWalletHistory) FROM CreditWalletHistory creditWalletHistory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "creditWalletHistory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CreditWalletHistory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CreditWalletHistory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CreditWalletHistoryPersistenceImpl.class);

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

	private static class CreditWalletHistoryModelArgumentsResolver
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

			CreditWalletHistoryModelImpl creditWalletHistoryModelImpl =
				(CreditWalletHistoryModelImpl)baseModel;

			long columnBitmask =
				creditWalletHistoryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					creditWalletHistoryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						creditWalletHistoryModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					creditWalletHistoryModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			CreditWalletHistoryModelImpl creditWalletHistoryModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						creditWalletHistoryModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = creditWalletHistoryModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}