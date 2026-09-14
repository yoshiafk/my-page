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

package com.mypage.leads.service.persistence.impl;

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

import com.mypage.leads.exception.NoSuchPaymentException;
import com.mypage.leads.model.Payment;
import com.mypage.leads.model.impl.PaymentImpl;
import com.mypage.leads.model.impl.PaymentModelImpl;
import com.mypage.leads.service.persistence.PaymentPersistence;
import com.mypage.leads.service.persistence.PaymentUtil;
import com.mypage.leads.service.persistence.impl.constants.MPLPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
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
 * The persistence implementation for the payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @generated
 */
@Component(service = PaymentPersistence.class)
public class PaymentPersistenceImpl
	extends BasePersistenceImpl<Payment> implements PaymentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PaymentUtil</code> to access the payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PaymentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBysearchByLeadsId;
	private FinderPath _finderPathCountBysearchByLeadsId;

	/**
	 * Returns the payment where LeadsId = &#63; or throws a <code>NoSuchPaymentException</code> if it could not be found.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching payment
	 * @throws NoSuchPaymentException if a matching payment could not be found
	 */
	@Override
	public Payment findBysearchByLeadsId(long LeadsId)
		throws NoSuchPaymentException {

		Payment payment = fetchBysearchByLeadsId(LeadsId);

		if (payment == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("LeadsId=");
			sb.append(LeadsId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPaymentException(sb.toString());
		}

		return payment;
	}

	/**
	 * Returns the payment where LeadsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching payment, or <code>null</code> if a matching payment could not be found
	 */
	@Override
	public Payment fetchBysearchByLeadsId(long LeadsId) {
		return fetchBysearchByLeadsId(LeadsId, true);
	}

	/**
	 * Returns the payment where LeadsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching payment, or <code>null</code> if a matching payment could not be found
	 */
	@Override
	public Payment fetchBysearchByLeadsId(
		long LeadsId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {LeadsId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBysearchByLeadsId, finderArgs, this);
		}

		if (result instanceof Payment) {
			Payment payment = (Payment)result;

			if (LeadsId != payment.getLeadsId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PAYMENT_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYLEADSID_LEADSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(LeadsId);

				List<Payment> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBysearchByLeadsId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {LeadsId};
							}

							_log.warn(
								"PaymentPersistenceImpl.fetchBysearchByLeadsId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Payment payment = list.get(0);

					result = payment;

					cacheResult(payment);
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
			return (Payment)result;
		}
	}

	/**
	 * Removes the payment where LeadsId = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 * @return the payment that was removed
	 */
	@Override
	public Payment removeBysearchByLeadsId(long LeadsId)
		throws NoSuchPaymentException {

		Payment payment = findBysearchByLeadsId(LeadsId);

		return remove(payment);
	}

	/**
	 * Returns the number of payments where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the number of matching payments
	 */
	@Override
	public int countBysearchByLeadsId(long LeadsId) {
		FinderPath finderPath = _finderPathCountBysearchByLeadsId;

		Object[] finderArgs = new Object[] {LeadsId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PAYMENT_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYLEADSID_LEADSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(LeadsId);

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

	private static final String _FINDER_COLUMN_SEARCHBYLEADSID_LEADSID_2 =
		"payment.LeadsId = ?";

	private FinderPath _finderPathFetchBysearchByTransactionId;
	private FinderPath _finderPathCountBysearchByTransactionId;

	/**
	 * Returns the payment where TransactionId = &#63; or throws a <code>NoSuchPaymentException</code> if it could not be found.
	 *
	 * @param TransactionId the transaction ID
	 * @return the matching payment
	 * @throws NoSuchPaymentException if a matching payment could not be found
	 */
	@Override
	public Payment findBysearchByTransactionId(String TransactionId)
		throws NoSuchPaymentException {

		Payment payment = fetchBysearchByTransactionId(TransactionId);

		if (payment == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("TransactionId=");
			sb.append(TransactionId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPaymentException(sb.toString());
		}

		return payment;
	}

	/**
	 * Returns the payment where TransactionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param TransactionId the transaction ID
	 * @return the matching payment, or <code>null</code> if a matching payment could not be found
	 */
	@Override
	public Payment fetchBysearchByTransactionId(String TransactionId) {
		return fetchBysearchByTransactionId(TransactionId, true);
	}

	/**
	 * Returns the payment where TransactionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param TransactionId the transaction ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching payment, or <code>null</code> if a matching payment could not be found
	 */
	@Override
	public Payment fetchBysearchByTransactionId(
		String TransactionId, boolean useFinderCache) {

		TransactionId = Objects.toString(TransactionId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {TransactionId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBysearchByTransactionId, finderArgs, this);
		}

		if (result instanceof Payment) {
			Payment payment = (Payment)result;

			if (!Objects.equals(TransactionId, payment.getTransactionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PAYMENT_WHERE);

			boolean bindTransactionId = false;

			if (TransactionId.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHBYTRANSACTIONID_TRANSACTIONID_3);
			}
			else {
				bindTransactionId = true;

				sb.append(_FINDER_COLUMN_SEARCHBYTRANSACTIONID_TRANSACTIONID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTransactionId) {
					queryPos.add(TransactionId);
				}

				List<Payment> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBysearchByTransactionId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {TransactionId};
							}

							_log.warn(
								"PaymentPersistenceImpl.fetchBysearchByTransactionId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Payment payment = list.get(0);

					result = payment;

					cacheResult(payment);
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
			return (Payment)result;
		}
	}

	/**
	 * Removes the payment where TransactionId = &#63; from the database.
	 *
	 * @param TransactionId the transaction ID
	 * @return the payment that was removed
	 */
	@Override
	public Payment removeBysearchByTransactionId(String TransactionId)
		throws NoSuchPaymentException {

		Payment payment = findBysearchByTransactionId(TransactionId);

		return remove(payment);
	}

	/**
	 * Returns the number of payments where TransactionId = &#63;.
	 *
	 * @param TransactionId the transaction ID
	 * @return the number of matching payments
	 */
	@Override
	public int countBysearchByTransactionId(String TransactionId) {
		TransactionId = Objects.toString(TransactionId, "");

		FinderPath finderPath = _finderPathCountBysearchByTransactionId;

		Object[] finderArgs = new Object[] {TransactionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PAYMENT_WHERE);

			boolean bindTransactionId = false;

			if (TransactionId.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHBYTRANSACTIONID_TRANSACTIONID_3);
			}
			else {
				bindTransactionId = true;

				sb.append(_FINDER_COLUMN_SEARCHBYTRANSACTIONID_TRANSACTIONID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTransactionId) {
					queryPos.add(TransactionId);
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

	private static final String
		_FINDER_COLUMN_SEARCHBYTRANSACTIONID_TRANSACTIONID_2 =
			"payment.TransactionId = ?";

	private static final String
		_FINDER_COLUMN_SEARCHBYTRANSACTIONID_TRANSACTIONID_3 =
			"(payment.TransactionId IS NULL OR payment.TransactionId = '')";

	public PaymentPersistenceImpl() {
		setModelClass(Payment.class);

		setModelImplClass(PaymentImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the payment in the entity cache if it is enabled.
	 *
	 * @param payment the payment
	 */
	@Override
	public void cacheResult(Payment payment) {
		entityCache.putResult(
			PaymentImpl.class, payment.getPrimaryKey(), payment);

		finderCache.putResult(
			_finderPathFetchBysearchByLeadsId,
			new Object[] {payment.getLeadsId()}, payment);

		finderCache.putResult(
			_finderPathFetchBysearchByTransactionId,
			new Object[] {payment.getTransactionId()}, payment);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the payments in the entity cache if it is enabled.
	 *
	 * @param payments the payments
	 */
	@Override
	public void cacheResult(List<Payment> payments) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (payments.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Payment payment : payments) {
			if (entityCache.getResult(
					PaymentImpl.class, payment.getPrimaryKey()) == null) {

				cacheResult(payment);
			}
		}
	}

	/**
	 * Clears the cache for all payments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PaymentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the payment.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Payment payment) {
		entityCache.removeResult(PaymentImpl.class, payment);
	}

	@Override
	public void clearCache(List<Payment> payments) {
		for (Payment payment : payments) {
			entityCache.removeResult(PaymentImpl.class, payment);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PaymentImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(PaymentModelImpl paymentModelImpl) {
		Object[] args = new Object[] {paymentModelImpl.getLeadsId()};

		finderCache.putResult(
			_finderPathCountBysearchByLeadsId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBysearchByLeadsId, args, paymentModelImpl, false);

		args = new Object[] {paymentModelImpl.getTransactionId()};

		finderCache.putResult(
			_finderPathCountBysearchByTransactionId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchBysearchByTransactionId, args, paymentModelImpl,
			false);
	}

	/**
	 * Creates a new payment with the primary key. Does not add the payment to the database.
	 *
	 * @param paymentId the primary key for the new payment
	 * @return the new payment
	 */
	@Override
	public Payment create(long paymentId) {
		Payment payment = new PaymentImpl();

		payment.setNew(true);
		payment.setPrimaryKey(paymentId);

		payment.setCompanyId(CompanyThreadLocal.getCompanyId());

		return payment;
	}

	/**
	 * Removes the payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment that was removed
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	@Override
	public Payment remove(long paymentId) throws NoSuchPaymentException {
		return remove((Serializable)paymentId);
	}

	/**
	 * Removes the payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the payment
	 * @return the payment that was removed
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	@Override
	public Payment remove(Serializable primaryKey)
		throws NoSuchPaymentException {

		Session session = null;

		try {
			session = openSession();

			Payment payment = (Payment)session.get(
				PaymentImpl.class, primaryKey);

			if (payment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPaymentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(payment);
		}
		catch (NoSuchPaymentException noSuchEntityException) {
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
	protected Payment removeImpl(Payment payment) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(payment)) {
				payment = (Payment)session.get(
					PaymentImpl.class, payment.getPrimaryKeyObj());
			}

			if (payment != null) {
				session.delete(payment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (payment != null) {
			clearCache(payment);
		}

		return payment;
	}

	@Override
	public Payment updateImpl(Payment payment) {
		boolean isNew = payment.isNew();

		if (!(payment instanceof PaymentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(payment.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(payment);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in payment proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Payment implementation " +
					payment.getClass());
		}

		PaymentModelImpl paymentModelImpl = (PaymentModelImpl)payment;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (payment.getCreateDate() == null)) {
			if (serviceContext == null) {
				payment.setCreateDate(date);
			}
			else {
				payment.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!paymentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				payment.setModifiedDate(date);
			}
			else {
				payment.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(payment);
			}
			else {
				payment = (Payment)session.merge(payment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PaymentImpl.class, paymentModelImpl, false, true);

		cacheUniqueFindersCache(paymentModelImpl);

		if (isNew) {
			payment.setNew(false);
		}

		payment.resetOriginalValues();

		return payment;
	}

	/**
	 * Returns the payment with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the payment
	 * @return the payment
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	@Override
	public Payment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPaymentException {

		Payment payment = fetchByPrimaryKey(primaryKey);

		if (payment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPaymentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return payment;
	}

	/**
	 * Returns the payment with the primary key or throws a <code>NoSuchPaymentException</code> if it could not be found.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	@Override
	public Payment findByPrimaryKey(long paymentId)
		throws NoSuchPaymentException {

		return findByPrimaryKey((Serializable)paymentId);
	}

	/**
	 * Returns the payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment, or <code>null</code> if a payment with the primary key could not be found
	 */
	@Override
	public Payment fetchByPrimaryKey(long paymentId) {
		return fetchByPrimaryKey((Serializable)paymentId);
	}

	/**
	 * Returns all the payments.
	 *
	 * @return the payments
	 */
	@Override
	public List<Payment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @return the range of payments
	 */
	@Override
	public List<Payment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of payments
	 */
	@Override
	public List<Payment> findAll(
		int start, int end, OrderByComparator<Payment> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of payments
	 */
	@Override
	public List<Payment> findAll(
		int start, int end, OrderByComparator<Payment> orderByComparator,
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

		List<Payment> list = null;

		if (useFinderCache) {
			list = (List<Payment>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PAYMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PAYMENT;

				sql = sql.concat(PaymentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Payment>)QueryUtil.list(
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
	 * Removes all the payments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Payment payment : findAll()) {
			remove(payment);
		}
	}

	/**
	 * Returns the number of payments.
	 *
	 * @return the number of payments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PAYMENT);

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
		return "paymentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PAYMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PaymentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the payment persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PaymentModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Payment.class.getName()));

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

		_finderPathFetchBysearchByLeadsId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBysearchByLeadsId",
			new String[] {Long.class.getName()}, new String[] {"LeadsId"},
			true);

		_finderPathCountBysearchByLeadsId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchByLeadsId",
			new String[] {Long.class.getName()}, new String[] {"LeadsId"},
			false);

		_finderPathFetchBysearchByTransactionId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBysearchByTransactionId",
			new String[] {String.class.getName()},
			new String[] {"TransactionId"}, true);

		_finderPathCountBysearchByTransactionId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysearchByTransactionId",
			new String[] {String.class.getName()},
			new String[] {"TransactionId"}, false);

		_setPaymentUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPaymentUtilPersistence(null);

		entityCache.removeCache(PaymentImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPaymentUtilPersistence(
		PaymentPersistence paymentPersistence) {

		try {
			Field field = PaymentUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, paymentPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MPLPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MPLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MPLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_PAYMENT =
		"SELECT payment FROM Payment payment";

	private static final String _SQL_SELECT_PAYMENT_WHERE =
		"SELECT payment FROM Payment payment WHERE ";

	private static final String _SQL_COUNT_PAYMENT =
		"SELECT COUNT(payment) FROM Payment payment";

	private static final String _SQL_COUNT_PAYMENT_WHERE =
		"SELECT COUNT(payment) FROM Payment payment WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "payment.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Payment exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Payment exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PaymentPersistenceImpl.class);

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

	private static class PaymentModelArgumentsResolver
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

			PaymentModelImpl paymentModelImpl = (PaymentModelImpl)baseModel;

			long columnBitmask = paymentModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(paymentModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						paymentModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(paymentModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PaymentModelImpl paymentModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = paymentModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = paymentModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}