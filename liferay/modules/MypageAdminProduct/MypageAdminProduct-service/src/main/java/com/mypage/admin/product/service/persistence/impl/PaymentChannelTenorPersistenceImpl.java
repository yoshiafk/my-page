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

import com.mypage.admin.product.exception.NoSuchPaymentChannelTenorException;
import com.mypage.admin.product.model.PaymentChannelTenor;
import com.mypage.admin.product.model.impl.PaymentChannelTenorImpl;
import com.mypage.admin.product.model.impl.PaymentChannelTenorModelImpl;
import com.mypage.admin.product.service.persistence.PaymentChannelTenorPersistence;
import com.mypage.admin.product.service.persistence.PaymentChannelTenorUtil;
import com.mypage.admin.product.service.persistence.impl.constants.MPPersistenceConstants;

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
 * The persistence implementation for the payment channel tenor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = PaymentChannelTenorPersistence.class)
public class PaymentChannelTenorPersistenceImpl
	extends BasePersistenceImpl<PaymentChannelTenor>
	implements PaymentChannelTenorPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PaymentChannelTenorUtil</code> to access the payment channel tenor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PaymentChannelTenorImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBysearchByPaymentChannelId;
	private FinderPath
		_finderPathWithoutPaginationFindBysearchByPaymentChannelId;
	private FinderPath _finderPathCountBysearchByPaymentChannelId;

	/**
	 * Returns all the payment channel tenors where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @return the matching payment channel tenors
	 */
	@Override
	public List<PaymentChannelTenor> findBysearchByPaymentChannelId(
		long paymentChannelId) {

		return findBysearchByPaymentChannelId(
			paymentChannelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the payment channel tenors where paymentChannelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelTenorModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param start the lower bound of the range of payment channel tenors
	 * @param end the upper bound of the range of payment channel tenors (not inclusive)
	 * @return the range of matching payment channel tenors
	 */
	@Override
	public List<PaymentChannelTenor> findBysearchByPaymentChannelId(
		long paymentChannelId, int start, int end) {

		return findBysearchByPaymentChannelId(
			paymentChannelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the payment channel tenors where paymentChannelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelTenorModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param start the lower bound of the range of payment channel tenors
	 * @param end the upper bound of the range of payment channel tenors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching payment channel tenors
	 */
	@Override
	public List<PaymentChannelTenor> findBysearchByPaymentChannelId(
		long paymentChannelId, int start, int end,
		OrderByComparator<PaymentChannelTenor> orderByComparator) {

		return findBysearchByPaymentChannelId(
			paymentChannelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the payment channel tenors where paymentChannelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelTenorModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param start the lower bound of the range of payment channel tenors
	 * @param end the upper bound of the range of payment channel tenors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching payment channel tenors
	 */
	@Override
	public List<PaymentChannelTenor> findBysearchByPaymentChannelId(
		long paymentChannelId, int start, int end,
		OrderByComparator<PaymentChannelTenor> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBysearchByPaymentChannelId;
				finderArgs = new Object[] {paymentChannelId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBysearchByPaymentChannelId;
			finderArgs = new Object[] {
				paymentChannelId, start, end, orderByComparator
			};
		}

		List<PaymentChannelTenor> list = null;

		if (useFinderCache) {
			list = (List<PaymentChannelTenor>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PaymentChannelTenor paymentChannelTenor : list) {
					if (paymentChannelId !=
							paymentChannelTenor.getPaymentChannelId()) {

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

			sb.append(_SQL_SELECT_PAYMENTCHANNELTENOR_WHERE);

			sb.append(
				_FINDER_COLUMN_SEARCHBYPAYMENTCHANNELID_PAYMENTCHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PaymentChannelTenorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(paymentChannelId);

				list = (List<PaymentChannelTenor>)QueryUtil.list(
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
	 * Returns the first payment channel tenor in the ordered set where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel tenor
	 * @throws NoSuchPaymentChannelTenorException if a matching payment channel tenor could not be found
	 */
	@Override
	public PaymentChannelTenor findBysearchByPaymentChannelId_First(
			long paymentChannelId,
			OrderByComparator<PaymentChannelTenor> orderByComparator)
		throws NoSuchPaymentChannelTenorException {

		PaymentChannelTenor paymentChannelTenor =
			fetchBysearchByPaymentChannelId_First(
				paymentChannelId, orderByComparator);

		if (paymentChannelTenor != null) {
			return paymentChannelTenor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("paymentChannelId=");
		sb.append(paymentChannelId);

		sb.append("}");

		throw new NoSuchPaymentChannelTenorException(sb.toString());
	}

	/**
	 * Returns the first payment channel tenor in the ordered set where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel tenor, or <code>null</code> if a matching payment channel tenor could not be found
	 */
	@Override
	public PaymentChannelTenor fetchBysearchByPaymentChannelId_First(
		long paymentChannelId,
		OrderByComparator<PaymentChannelTenor> orderByComparator) {

		List<PaymentChannelTenor> list = findBysearchByPaymentChannelId(
			paymentChannelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last payment channel tenor in the ordered set where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel tenor
	 * @throws NoSuchPaymentChannelTenorException if a matching payment channel tenor could not be found
	 */
	@Override
	public PaymentChannelTenor findBysearchByPaymentChannelId_Last(
			long paymentChannelId,
			OrderByComparator<PaymentChannelTenor> orderByComparator)
		throws NoSuchPaymentChannelTenorException {

		PaymentChannelTenor paymentChannelTenor =
			fetchBysearchByPaymentChannelId_Last(
				paymentChannelId, orderByComparator);

		if (paymentChannelTenor != null) {
			return paymentChannelTenor;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("paymentChannelId=");
		sb.append(paymentChannelId);

		sb.append("}");

		throw new NoSuchPaymentChannelTenorException(sb.toString());
	}

	/**
	 * Returns the last payment channel tenor in the ordered set where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel tenor, or <code>null</code> if a matching payment channel tenor could not be found
	 */
	@Override
	public PaymentChannelTenor fetchBysearchByPaymentChannelId_Last(
		long paymentChannelId,
		OrderByComparator<PaymentChannelTenor> orderByComparator) {

		int count = countBysearchByPaymentChannelId(paymentChannelId);

		if (count == 0) {
			return null;
		}

		List<PaymentChannelTenor> list = findBysearchByPaymentChannelId(
			paymentChannelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the payment channel tenors before and after the current payment channel tenor in the ordered set where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelTenorId the primary key of the current payment channel tenor
	 * @param paymentChannelId the payment channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next payment channel tenor
	 * @throws NoSuchPaymentChannelTenorException if a payment channel tenor with the primary key could not be found
	 */
	@Override
	public PaymentChannelTenor[] findBysearchByPaymentChannelId_PrevAndNext(
			long paymentChannelTenorId, long paymentChannelId,
			OrderByComparator<PaymentChannelTenor> orderByComparator)
		throws NoSuchPaymentChannelTenorException {

		PaymentChannelTenor paymentChannelTenor = findByPrimaryKey(
			paymentChannelTenorId);

		Session session = null;

		try {
			session = openSession();

			PaymentChannelTenor[] array = new PaymentChannelTenorImpl[3];

			array[0] = getBysearchByPaymentChannelId_PrevAndNext(
				session, paymentChannelTenor, paymentChannelId,
				orderByComparator, true);

			array[1] = paymentChannelTenor;

			array[2] = getBysearchByPaymentChannelId_PrevAndNext(
				session, paymentChannelTenor, paymentChannelId,
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

	protected PaymentChannelTenor getBysearchByPaymentChannelId_PrevAndNext(
		Session session, PaymentChannelTenor paymentChannelTenor,
		long paymentChannelId,
		OrderByComparator<PaymentChannelTenor> orderByComparator,
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

		sb.append(_SQL_SELECT_PAYMENTCHANNELTENOR_WHERE);

		sb.append(_FINDER_COLUMN_SEARCHBYPAYMENTCHANNELID_PAYMENTCHANNELID_2);

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
			sb.append(PaymentChannelTenorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(paymentChannelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						paymentChannelTenor)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PaymentChannelTenor> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the payment channel tenors where paymentChannelId = &#63; from the database.
	 *
	 * @param paymentChannelId the payment channel ID
	 */
	@Override
	public void removeBysearchByPaymentChannelId(long paymentChannelId) {
		for (PaymentChannelTenor paymentChannelTenor :
				findBysearchByPaymentChannelId(
					paymentChannelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(paymentChannelTenor);
		}
	}

	/**
	 * Returns the number of payment channel tenors where paymentChannelId = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @return the number of matching payment channel tenors
	 */
	@Override
	public int countBysearchByPaymentChannelId(long paymentChannelId) {
		FinderPath finderPath = _finderPathCountBysearchByPaymentChannelId;

		Object[] finderArgs = new Object[] {paymentChannelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PAYMENTCHANNELTENOR_WHERE);

			sb.append(
				_FINDER_COLUMN_SEARCHBYPAYMENTCHANNELID_PAYMENTCHANNELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(paymentChannelId);

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
		_FINDER_COLUMN_SEARCHBYPAYMENTCHANNELID_PAYMENTCHANNELID_2 =
			"paymentChannelTenor.paymentChannelId = ?";

	public PaymentChannelTenorPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PaymentChannelTenor.class);

		setModelImplClass(PaymentChannelTenorImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the payment channel tenor in the entity cache if it is enabled.
	 *
	 * @param paymentChannelTenor the payment channel tenor
	 */
	@Override
	public void cacheResult(PaymentChannelTenor paymentChannelTenor) {
		entityCache.putResult(
			PaymentChannelTenorImpl.class, paymentChannelTenor.getPrimaryKey(),
			paymentChannelTenor);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the payment channel tenors in the entity cache if it is enabled.
	 *
	 * @param paymentChannelTenors the payment channel tenors
	 */
	@Override
	public void cacheResult(List<PaymentChannelTenor> paymentChannelTenors) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (paymentChannelTenors.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PaymentChannelTenor paymentChannelTenor : paymentChannelTenors) {
			if (entityCache.getResult(
					PaymentChannelTenorImpl.class,
					paymentChannelTenor.getPrimaryKey()) == null) {

				cacheResult(paymentChannelTenor);
			}
		}
	}

	/**
	 * Clears the cache for all payment channel tenors.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PaymentChannelTenorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the payment channel tenor.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PaymentChannelTenor paymentChannelTenor) {
		entityCache.removeResult(
			PaymentChannelTenorImpl.class, paymentChannelTenor);
	}

	@Override
	public void clearCache(List<PaymentChannelTenor> paymentChannelTenors) {
		for (PaymentChannelTenor paymentChannelTenor : paymentChannelTenors) {
			entityCache.removeResult(
				PaymentChannelTenorImpl.class, paymentChannelTenor);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PaymentChannelTenorImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new payment channel tenor with the primary key. Does not add the payment channel tenor to the database.
	 *
	 * @param paymentChannelTenorId the primary key for the new payment channel tenor
	 * @return the new payment channel tenor
	 */
	@Override
	public PaymentChannelTenor create(long paymentChannelTenorId) {
		PaymentChannelTenor paymentChannelTenor = new PaymentChannelTenorImpl();

		paymentChannelTenor.setNew(true);
		paymentChannelTenor.setPrimaryKey(paymentChannelTenorId);

		paymentChannelTenor.setCompanyId(CompanyThreadLocal.getCompanyId());

		return paymentChannelTenor;
	}

	/**
	 * Removes the payment channel tenor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param paymentChannelTenorId the primary key of the payment channel tenor
	 * @return the payment channel tenor that was removed
	 * @throws NoSuchPaymentChannelTenorException if a payment channel tenor with the primary key could not be found
	 */
	@Override
	public PaymentChannelTenor remove(long paymentChannelTenorId)
		throws NoSuchPaymentChannelTenorException {

		return remove((Serializable)paymentChannelTenorId);
	}

	/**
	 * Removes the payment channel tenor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the payment channel tenor
	 * @return the payment channel tenor that was removed
	 * @throws NoSuchPaymentChannelTenorException if a payment channel tenor with the primary key could not be found
	 */
	@Override
	public PaymentChannelTenor remove(Serializable primaryKey)
		throws NoSuchPaymentChannelTenorException {

		Session session = null;

		try {
			session = openSession();

			PaymentChannelTenor paymentChannelTenor =
				(PaymentChannelTenor)session.get(
					PaymentChannelTenorImpl.class, primaryKey);

			if (paymentChannelTenor == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPaymentChannelTenorException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(paymentChannelTenor);
		}
		catch (NoSuchPaymentChannelTenorException noSuchEntityException) {
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
	protected PaymentChannelTenor removeImpl(
		PaymentChannelTenor paymentChannelTenor) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(paymentChannelTenor)) {
				paymentChannelTenor = (PaymentChannelTenor)session.get(
					PaymentChannelTenorImpl.class,
					paymentChannelTenor.getPrimaryKeyObj());
			}

			if (paymentChannelTenor != null) {
				session.delete(paymentChannelTenor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (paymentChannelTenor != null) {
			clearCache(paymentChannelTenor);
		}

		return paymentChannelTenor;
	}

	@Override
	public PaymentChannelTenor updateImpl(
		PaymentChannelTenor paymentChannelTenor) {

		boolean isNew = paymentChannelTenor.isNew();

		if (!(paymentChannelTenor instanceof PaymentChannelTenorModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(paymentChannelTenor.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					paymentChannelTenor);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in paymentChannelTenor proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PaymentChannelTenor implementation " +
					paymentChannelTenor.getClass());
		}

		PaymentChannelTenorModelImpl paymentChannelTenorModelImpl =
			(PaymentChannelTenorModelImpl)paymentChannelTenor;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (paymentChannelTenor.getCreateDate() == null)) {
			if (serviceContext == null) {
				paymentChannelTenor.setCreateDate(date);
			}
			else {
				paymentChannelTenor.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!paymentChannelTenorModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				paymentChannelTenor.setModifiedDate(date);
			}
			else {
				paymentChannelTenor.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(paymentChannelTenor);
			}
			else {
				paymentChannelTenor = (PaymentChannelTenor)session.merge(
					paymentChannelTenor);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PaymentChannelTenorImpl.class, paymentChannelTenorModelImpl, false,
			true);

		if (isNew) {
			paymentChannelTenor.setNew(false);
		}

		paymentChannelTenor.resetOriginalValues();

		return paymentChannelTenor;
	}

	/**
	 * Returns the payment channel tenor with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the payment channel tenor
	 * @return the payment channel tenor
	 * @throws NoSuchPaymentChannelTenorException if a payment channel tenor with the primary key could not be found
	 */
	@Override
	public PaymentChannelTenor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPaymentChannelTenorException {

		PaymentChannelTenor paymentChannelTenor = fetchByPrimaryKey(primaryKey);

		if (paymentChannelTenor == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPaymentChannelTenorException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return paymentChannelTenor;
	}

	/**
	 * Returns the payment channel tenor with the primary key or throws a <code>NoSuchPaymentChannelTenorException</code> if it could not be found.
	 *
	 * @param paymentChannelTenorId the primary key of the payment channel tenor
	 * @return the payment channel tenor
	 * @throws NoSuchPaymentChannelTenorException if a payment channel tenor with the primary key could not be found
	 */
	@Override
	public PaymentChannelTenor findByPrimaryKey(long paymentChannelTenorId)
		throws NoSuchPaymentChannelTenorException {

		return findByPrimaryKey((Serializable)paymentChannelTenorId);
	}

	/**
	 * Returns the payment channel tenor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param paymentChannelTenorId the primary key of the payment channel tenor
	 * @return the payment channel tenor, or <code>null</code> if a payment channel tenor with the primary key could not be found
	 */
	@Override
	public PaymentChannelTenor fetchByPrimaryKey(long paymentChannelTenorId) {
		return fetchByPrimaryKey((Serializable)paymentChannelTenorId);
	}

	/**
	 * Returns all the payment channel tenors.
	 *
	 * @return the payment channel tenors
	 */
	@Override
	public List<PaymentChannelTenor> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the payment channel tenors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelTenorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment channel tenors
	 * @param end the upper bound of the range of payment channel tenors (not inclusive)
	 * @return the range of payment channel tenors
	 */
	@Override
	public List<PaymentChannelTenor> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the payment channel tenors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelTenorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment channel tenors
	 * @param end the upper bound of the range of payment channel tenors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of payment channel tenors
	 */
	@Override
	public List<PaymentChannelTenor> findAll(
		int start, int end,
		OrderByComparator<PaymentChannelTenor> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the payment channel tenors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelTenorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment channel tenors
	 * @param end the upper bound of the range of payment channel tenors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of payment channel tenors
	 */
	@Override
	public List<PaymentChannelTenor> findAll(
		int start, int end,
		OrderByComparator<PaymentChannelTenor> orderByComparator,
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

		List<PaymentChannelTenor> list = null;

		if (useFinderCache) {
			list = (List<PaymentChannelTenor>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PAYMENTCHANNELTENOR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PAYMENTCHANNELTENOR;

				sql = sql.concat(PaymentChannelTenorModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PaymentChannelTenor>)QueryUtil.list(
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
	 * Removes all the payment channel tenors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PaymentChannelTenor paymentChannelTenor : findAll()) {
			remove(paymentChannelTenor);
		}
	}

	/**
	 * Returns the number of payment channel tenors.
	 *
	 * @return the number of payment channel tenors
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
					_SQL_COUNT_PAYMENTCHANNELTENOR);

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
		return "paymentChannelTenorId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PAYMENTCHANNELTENOR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PaymentChannelTenorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the payment channel tenor persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new PaymentChannelTenorModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PaymentChannelTenor.class.getName()));

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

		_finderPathWithPaginationFindBysearchByPaymentChannelId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBysearchByPaymentChannelId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"paymentChannelId"}, true);

		_finderPathWithoutPaginationFindBysearchByPaymentChannelId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBysearchByPaymentChannelId",
				new String[] {Long.class.getName()},
				new String[] {"paymentChannelId"}, true);

		_finderPathCountBysearchByPaymentChannelId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysearchByPaymentChannelId",
			new String[] {Long.class.getName()},
			new String[] {"paymentChannelId"}, false);

		_setPaymentChannelTenorUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPaymentChannelTenorUtilPersistence(null);

		entityCache.removeCache(PaymentChannelTenorImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPaymentChannelTenorUtilPersistence(
		PaymentChannelTenorPersistence paymentChannelTenorPersistence) {

		try {
			Field field = PaymentChannelTenorUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, paymentChannelTenorPersistence);
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

	private static final String _SQL_SELECT_PAYMENTCHANNELTENOR =
		"SELECT paymentChannelTenor FROM PaymentChannelTenor paymentChannelTenor";

	private static final String _SQL_SELECT_PAYMENTCHANNELTENOR_WHERE =
		"SELECT paymentChannelTenor FROM PaymentChannelTenor paymentChannelTenor WHERE ";

	private static final String _SQL_COUNT_PAYMENTCHANNELTENOR =
		"SELECT COUNT(paymentChannelTenor) FROM PaymentChannelTenor paymentChannelTenor";

	private static final String _SQL_COUNT_PAYMENTCHANNELTENOR_WHERE =
		"SELECT COUNT(paymentChannelTenor) FROM PaymentChannelTenor paymentChannelTenor WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "paymentChannelTenor.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PaymentChannelTenor exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PaymentChannelTenor exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PaymentChannelTenorPersistenceImpl.class);

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

	private static class PaymentChannelTenorModelArgumentsResolver
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

			PaymentChannelTenorModelImpl paymentChannelTenorModelImpl =
				(PaymentChannelTenorModelImpl)baseModel;

			long columnBitmask =
				paymentChannelTenorModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					paymentChannelTenorModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						paymentChannelTenorModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					paymentChannelTenorModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PaymentChannelTenorModelImpl paymentChannelTenorModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						paymentChannelTenorModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = paymentChannelTenorModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}