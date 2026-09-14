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

package com.axa.payment.service.persistence.impl;

import com.axa.payment.exception.NoSuchPaymentTransactionException;
import com.axa.payment.model.PaymentTransaction;
import com.axa.payment.model.impl.PaymentTransactionImpl;
import com.axa.payment.model.impl.PaymentTransactionModelImpl;
import com.axa.payment.service.persistence.PaymentTransactionPersistence;
import com.axa.payment.service.persistence.PaymentTransactionUtil;
import com.axa.payment.service.persistence.impl.constants.XPPersistenceConstants;

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

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the payment transaction service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = PaymentTransactionPersistence.class)
public class PaymentTransactionPersistenceImpl
	extends BasePersistenceImpl<PaymentTransaction>
	implements PaymentTransactionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PaymentTransactionUtil</code> to access the payment transaction persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PaymentTransactionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBypolicyProfile;
	private FinderPath _finderPathWithoutPaginationFindBypolicyProfile;
	private FinderPath _finderPathCountBypolicyProfile;

	/**
	 * Returns all the payment transactions where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @return the matching payment transactions
	 */
	@Override
	public List<PaymentTransaction> findBypolicyProfile(
		String policyNumber, String profileId) {

		return findBypolicyProfile(
			policyNumber, profileId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the payment transactions where policyNumber = &#63; and profileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @return the range of matching payment transactions
	 */
	@Override
	public List<PaymentTransaction> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end) {

		return findBypolicyProfile(policyNumber, profileId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the payment transactions where policyNumber = &#63; and profileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching payment transactions
	 */
	@Override
	public List<PaymentTransaction> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end,
		OrderByComparator<PaymentTransaction> orderByComparator) {

		return findBypolicyProfile(
			policyNumber, profileId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the payment transactions where policyNumber = &#63; and profileId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching payment transactions
	 */
	@Override
	public List<PaymentTransaction> findBypolicyProfile(
		String policyNumber, String profileId, int start, int end,
		OrderByComparator<PaymentTransaction> orderByComparator,
		boolean useFinderCache) {

		policyNumber = Objects.toString(policyNumber, "");
		profileId = Objects.toString(profileId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBypolicyProfile;
				finderArgs = new Object[] {policyNumber, profileId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBypolicyProfile;
			finderArgs = new Object[] {
				policyNumber, profileId, start, end, orderByComparator
			};
		}

		List<PaymentTransaction> list = null;

		if (useFinderCache) {
			list = (List<PaymentTransaction>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PaymentTransaction paymentTransaction : list) {
					if (!policyNumber.equals(
							paymentTransaction.getPolicyNumber()) ||
						!profileId.equals(paymentTransaction.getProfileId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_PAYMENTTRANSACTION_WHERE);

			boolean bindPolicyNumber = false;

			if (policyNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYPROFILE_POLICYNUMBER_3);
			}
			else {
				bindPolicyNumber = true;

				sb.append(_FINDER_COLUMN_POLICYPROFILE_POLICYNUMBER_2);
			}

			boolean bindProfileId = false;

			if (profileId.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYPROFILE_PROFILEID_3);
			}
			else {
				bindProfileId = true;

				sb.append(_FINDER_COLUMN_POLICYPROFILE_PROFILEID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PaymentTransactionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPolicyNumber) {
					queryPos.add(policyNumber);
				}

				if (bindProfileId) {
					queryPos.add(profileId);
				}

				list = (List<PaymentTransaction>)QueryUtil.list(
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
	 * Returns the first payment transaction in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment transaction
	 * @throws NoSuchPaymentTransactionException if a matching payment transaction could not be found
	 */
	@Override
	public PaymentTransaction findBypolicyProfile_First(
			String policyNumber, String profileId,
			OrderByComparator<PaymentTransaction> orderByComparator)
		throws NoSuchPaymentTransactionException {

		PaymentTransaction paymentTransaction = fetchBypolicyProfile_First(
			policyNumber, profileId, orderByComparator);

		if (paymentTransaction != null) {
			return paymentTransaction;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNumber=");
		sb.append(policyNumber);

		sb.append(", profileId=");
		sb.append(profileId);

		sb.append("}");

		throw new NoSuchPaymentTransactionException(sb.toString());
	}

	/**
	 * Returns the first payment transaction in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment transaction, or <code>null</code> if a matching payment transaction could not be found
	 */
	@Override
	public PaymentTransaction fetchBypolicyProfile_First(
		String policyNumber, String profileId,
		OrderByComparator<PaymentTransaction> orderByComparator) {

		List<PaymentTransaction> list = findBypolicyProfile(
			policyNumber, profileId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last payment transaction in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment transaction
	 * @throws NoSuchPaymentTransactionException if a matching payment transaction could not be found
	 */
	@Override
	public PaymentTransaction findBypolicyProfile_Last(
			String policyNumber, String profileId,
			OrderByComparator<PaymentTransaction> orderByComparator)
		throws NoSuchPaymentTransactionException {

		PaymentTransaction paymentTransaction = fetchBypolicyProfile_Last(
			policyNumber, profileId, orderByComparator);

		if (paymentTransaction != null) {
			return paymentTransaction;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("policyNumber=");
		sb.append(policyNumber);

		sb.append(", profileId=");
		sb.append(profileId);

		sb.append("}");

		throw new NoSuchPaymentTransactionException(sb.toString());
	}

	/**
	 * Returns the last payment transaction in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment transaction, or <code>null</code> if a matching payment transaction could not be found
	 */
	@Override
	public PaymentTransaction fetchBypolicyProfile_Last(
		String policyNumber, String profileId,
		OrderByComparator<PaymentTransaction> orderByComparator) {

		int count = countBypolicyProfile(policyNumber, profileId);

		if (count == 0) {
			return null;
		}

		List<PaymentTransaction> list = findBypolicyProfile(
			policyNumber, profileId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the payment transactions before and after the current payment transaction in the ordered set where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param paymentTransactionId the primary key of the current payment transaction
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next payment transaction
	 * @throws NoSuchPaymentTransactionException if a payment transaction with the primary key could not be found
	 */
	@Override
	public PaymentTransaction[] findBypolicyProfile_PrevAndNext(
			long paymentTransactionId, String policyNumber, String profileId,
			OrderByComparator<PaymentTransaction> orderByComparator)
		throws NoSuchPaymentTransactionException {

		policyNumber = Objects.toString(policyNumber, "");
		profileId = Objects.toString(profileId, "");

		PaymentTransaction paymentTransaction = findByPrimaryKey(
			paymentTransactionId);

		Session session = null;

		try {
			session = openSession();

			PaymentTransaction[] array = new PaymentTransactionImpl[3];

			array[0] = getBypolicyProfile_PrevAndNext(
				session, paymentTransaction, policyNumber, profileId,
				orderByComparator, true);

			array[1] = paymentTransaction;

			array[2] = getBypolicyProfile_PrevAndNext(
				session, paymentTransaction, policyNumber, profileId,
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

	protected PaymentTransaction getBypolicyProfile_PrevAndNext(
		Session session, PaymentTransaction paymentTransaction,
		String policyNumber, String profileId,
		OrderByComparator<PaymentTransaction> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PAYMENTTRANSACTION_WHERE);

		boolean bindPolicyNumber = false;

		if (policyNumber.isEmpty()) {
			sb.append(_FINDER_COLUMN_POLICYPROFILE_POLICYNUMBER_3);
		}
		else {
			bindPolicyNumber = true;

			sb.append(_FINDER_COLUMN_POLICYPROFILE_POLICYNUMBER_2);
		}

		boolean bindProfileId = false;

		if (profileId.isEmpty()) {
			sb.append(_FINDER_COLUMN_POLICYPROFILE_PROFILEID_3);
		}
		else {
			bindProfileId = true;

			sb.append(_FINDER_COLUMN_POLICYPROFILE_PROFILEID_2);
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
			sb.append(PaymentTransactionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPolicyNumber) {
			queryPos.add(policyNumber);
		}

		if (bindProfileId) {
			queryPos.add(profileId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						paymentTransaction)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PaymentTransaction> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the payment transactions where policyNumber = &#63; and profileId = &#63; from the database.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 */
	@Override
	public void removeBypolicyProfile(String policyNumber, String profileId) {
		for (PaymentTransaction paymentTransaction :
				findBypolicyProfile(
					policyNumber, profileId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(paymentTransaction);
		}
	}

	/**
	 * Returns the number of payment transactions where policyNumber = &#63; and profileId = &#63;.
	 *
	 * @param policyNumber the policy number
	 * @param profileId the profile ID
	 * @return the number of matching payment transactions
	 */
	@Override
	public int countBypolicyProfile(String policyNumber, String profileId) {
		policyNumber = Objects.toString(policyNumber, "");
		profileId = Objects.toString(profileId, "");

		FinderPath finderPath = _finderPathCountBypolicyProfile;

		Object[] finderArgs = new Object[] {policyNumber, profileId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PAYMENTTRANSACTION_WHERE);

			boolean bindPolicyNumber = false;

			if (policyNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYPROFILE_POLICYNUMBER_3);
			}
			else {
				bindPolicyNumber = true;

				sb.append(_FINDER_COLUMN_POLICYPROFILE_POLICYNUMBER_2);
			}

			boolean bindProfileId = false;

			if (profileId.isEmpty()) {
				sb.append(_FINDER_COLUMN_POLICYPROFILE_PROFILEID_3);
			}
			else {
				bindProfileId = true;

				sb.append(_FINDER_COLUMN_POLICYPROFILE_PROFILEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPolicyNumber) {
					queryPos.add(policyNumber);
				}

				if (bindProfileId) {
					queryPos.add(profileId);
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

	private static final String _FINDER_COLUMN_POLICYPROFILE_POLICYNUMBER_2 =
		"paymentTransaction.policyNumber = ? AND ";

	private static final String _FINDER_COLUMN_POLICYPROFILE_POLICYNUMBER_3 =
		"(paymentTransaction.policyNumber IS NULL OR paymentTransaction.policyNumber = '') AND ";

	private static final String _FINDER_COLUMN_POLICYPROFILE_PROFILEID_2 =
		"paymentTransaction.profileId = ?";

	private static final String _FINDER_COLUMN_POLICYPROFILE_PROFILEID_3 =
		"(paymentTransaction.profileId IS NULL OR paymentTransaction.profileId = '')";

	private FinderPath _finderPathWithPaginationFindByinvoiceNumber;
	private FinderPath _finderPathWithoutPaginationFindByinvoiceNumber;
	private FinderPath _finderPathCountByinvoiceNumber;

	/**
	 * Returns all the payment transactions where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the matching payment transactions
	 */
	@Override
	public List<PaymentTransaction> findByinvoiceNumber(String invoiceNumber) {
		return findByinvoiceNumber(
			invoiceNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the payment transactions where invoiceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceNumber the invoice number
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @return the range of matching payment transactions
	 */
	@Override
	public List<PaymentTransaction> findByinvoiceNumber(
		String invoiceNumber, int start, int end) {

		return findByinvoiceNumber(invoiceNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the payment transactions where invoiceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceNumber the invoice number
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching payment transactions
	 */
	@Override
	public List<PaymentTransaction> findByinvoiceNumber(
		String invoiceNumber, int start, int end,
		OrderByComparator<PaymentTransaction> orderByComparator) {

		return findByinvoiceNumber(
			invoiceNumber, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the payment transactions where invoiceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceNumber the invoice number
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching payment transactions
	 */
	@Override
	public List<PaymentTransaction> findByinvoiceNumber(
		String invoiceNumber, int start, int end,
		OrderByComparator<PaymentTransaction> orderByComparator,
		boolean useFinderCache) {

		invoiceNumber = Objects.toString(invoiceNumber, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByinvoiceNumber;
				finderArgs = new Object[] {invoiceNumber};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByinvoiceNumber;
			finderArgs = new Object[] {
				invoiceNumber, start, end, orderByComparator
			};
		}

		List<PaymentTransaction> list = null;

		if (useFinderCache) {
			list = (List<PaymentTransaction>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PaymentTransaction paymentTransaction : list) {
					if (!invoiceNumber.equals(
							paymentTransaction.getInvoiceNumber())) {

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

			sb.append(_SQL_SELECT_PAYMENTTRANSACTION_WHERE);

			boolean bindInvoiceNumber = false;

			if (invoiceNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_3);
			}
			else {
				bindInvoiceNumber = true;

				sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PaymentTransactionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindInvoiceNumber) {
					queryPos.add(invoiceNumber);
				}

				list = (List<PaymentTransaction>)QueryUtil.list(
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
	 * Returns the first payment transaction in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment transaction
	 * @throws NoSuchPaymentTransactionException if a matching payment transaction could not be found
	 */
	@Override
	public PaymentTransaction findByinvoiceNumber_First(
			String invoiceNumber,
			OrderByComparator<PaymentTransaction> orderByComparator)
		throws NoSuchPaymentTransactionException {

		PaymentTransaction paymentTransaction = fetchByinvoiceNumber_First(
			invoiceNumber, orderByComparator);

		if (paymentTransaction != null) {
			return paymentTransaction;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("invoiceNumber=");
		sb.append(invoiceNumber);

		sb.append("}");

		throw new NoSuchPaymentTransactionException(sb.toString());
	}

	/**
	 * Returns the first payment transaction in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment transaction, or <code>null</code> if a matching payment transaction could not be found
	 */
	@Override
	public PaymentTransaction fetchByinvoiceNumber_First(
		String invoiceNumber,
		OrderByComparator<PaymentTransaction> orderByComparator) {

		List<PaymentTransaction> list = findByinvoiceNumber(
			invoiceNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last payment transaction in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment transaction
	 * @throws NoSuchPaymentTransactionException if a matching payment transaction could not be found
	 */
	@Override
	public PaymentTransaction findByinvoiceNumber_Last(
			String invoiceNumber,
			OrderByComparator<PaymentTransaction> orderByComparator)
		throws NoSuchPaymentTransactionException {

		PaymentTransaction paymentTransaction = fetchByinvoiceNumber_Last(
			invoiceNumber, orderByComparator);

		if (paymentTransaction != null) {
			return paymentTransaction;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("invoiceNumber=");
		sb.append(invoiceNumber);

		sb.append("}");

		throw new NoSuchPaymentTransactionException(sb.toString());
	}

	/**
	 * Returns the last payment transaction in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment transaction, or <code>null</code> if a matching payment transaction could not be found
	 */
	@Override
	public PaymentTransaction fetchByinvoiceNumber_Last(
		String invoiceNumber,
		OrderByComparator<PaymentTransaction> orderByComparator) {

		int count = countByinvoiceNumber(invoiceNumber);

		if (count == 0) {
			return null;
		}

		List<PaymentTransaction> list = findByinvoiceNumber(
			invoiceNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the payment transactions before and after the current payment transaction in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param paymentTransactionId the primary key of the current payment transaction
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next payment transaction
	 * @throws NoSuchPaymentTransactionException if a payment transaction with the primary key could not be found
	 */
	@Override
	public PaymentTransaction[] findByinvoiceNumber_PrevAndNext(
			long paymentTransactionId, String invoiceNumber,
			OrderByComparator<PaymentTransaction> orderByComparator)
		throws NoSuchPaymentTransactionException {

		invoiceNumber = Objects.toString(invoiceNumber, "");

		PaymentTransaction paymentTransaction = findByPrimaryKey(
			paymentTransactionId);

		Session session = null;

		try {
			session = openSession();

			PaymentTransaction[] array = new PaymentTransactionImpl[3];

			array[0] = getByinvoiceNumber_PrevAndNext(
				session, paymentTransaction, invoiceNumber, orderByComparator,
				true);

			array[1] = paymentTransaction;

			array[2] = getByinvoiceNumber_PrevAndNext(
				session, paymentTransaction, invoiceNumber, orderByComparator,
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

	protected PaymentTransaction getByinvoiceNumber_PrevAndNext(
		Session session, PaymentTransaction paymentTransaction,
		String invoiceNumber,
		OrderByComparator<PaymentTransaction> orderByComparator,
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

		sb.append(_SQL_SELECT_PAYMENTTRANSACTION_WHERE);

		boolean bindInvoiceNumber = false;

		if (invoiceNumber.isEmpty()) {
			sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_3);
		}
		else {
			bindInvoiceNumber = true;

			sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_2);
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
			sb.append(PaymentTransactionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindInvoiceNumber) {
			queryPos.add(invoiceNumber);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						paymentTransaction)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PaymentTransaction> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the payment transactions where invoiceNumber = &#63; from the database.
	 *
	 * @param invoiceNumber the invoice number
	 */
	@Override
	public void removeByinvoiceNumber(String invoiceNumber) {
		for (PaymentTransaction paymentTransaction :
				findByinvoiceNumber(
					invoiceNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(paymentTransaction);
		}
	}

	/**
	 * Returns the number of payment transactions where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the number of matching payment transactions
	 */
	@Override
	public int countByinvoiceNumber(String invoiceNumber) {
		invoiceNumber = Objects.toString(invoiceNumber, "");

		FinderPath finderPath = _finderPathCountByinvoiceNumber;

		Object[] finderArgs = new Object[] {invoiceNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PAYMENTTRANSACTION_WHERE);

			boolean bindInvoiceNumber = false;

			if (invoiceNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_3);
			}
			else {
				bindInvoiceNumber = true;

				sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindInvoiceNumber) {
					queryPos.add(invoiceNumber);
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

	private static final String _FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_2 =
		"paymentTransaction.invoiceNumber = ?";

	private static final String _FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_3 =
		"(paymentTransaction.invoiceNumber IS NULL OR paymentTransaction.invoiceNumber = '')";

	public PaymentTransactionPersistenceImpl() {
		setModelClass(PaymentTransaction.class);

		setModelImplClass(PaymentTransactionImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the payment transaction in the entity cache if it is enabled.
	 *
	 * @param paymentTransaction the payment transaction
	 */
	@Override
	public void cacheResult(PaymentTransaction paymentTransaction) {
		entityCache.putResult(
			PaymentTransactionImpl.class, paymentTransaction.getPrimaryKey(),
			paymentTransaction);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the payment transactions in the entity cache if it is enabled.
	 *
	 * @param paymentTransactions the payment transactions
	 */
	@Override
	public void cacheResult(List<PaymentTransaction> paymentTransactions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (paymentTransactions.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PaymentTransaction paymentTransaction : paymentTransactions) {
			if (entityCache.getResult(
					PaymentTransactionImpl.class,
					paymentTransaction.getPrimaryKey()) == null) {

				cacheResult(paymentTransaction);
			}
		}
	}

	/**
	 * Clears the cache for all payment transactions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PaymentTransactionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the payment transaction.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PaymentTransaction paymentTransaction) {
		entityCache.removeResult(
			PaymentTransactionImpl.class, paymentTransaction);
	}

	@Override
	public void clearCache(List<PaymentTransaction> paymentTransactions) {
		for (PaymentTransaction paymentTransaction : paymentTransactions) {
			entityCache.removeResult(
				PaymentTransactionImpl.class, paymentTransaction);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PaymentTransactionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new payment transaction with the primary key. Does not add the payment transaction to the database.
	 *
	 * @param paymentTransactionId the primary key for the new payment transaction
	 * @return the new payment transaction
	 */
	@Override
	public PaymentTransaction create(long paymentTransactionId) {
		PaymentTransaction paymentTransaction = new PaymentTransactionImpl();

		paymentTransaction.setNew(true);
		paymentTransaction.setPrimaryKey(paymentTransactionId);

		paymentTransaction.setCompanyId(CompanyThreadLocal.getCompanyId());

		return paymentTransaction;
	}

	/**
	 * Removes the payment transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param paymentTransactionId the primary key of the payment transaction
	 * @return the payment transaction that was removed
	 * @throws NoSuchPaymentTransactionException if a payment transaction with the primary key could not be found
	 */
	@Override
	public PaymentTransaction remove(long paymentTransactionId)
		throws NoSuchPaymentTransactionException {

		return remove((Serializable)paymentTransactionId);
	}

	/**
	 * Removes the payment transaction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the payment transaction
	 * @return the payment transaction that was removed
	 * @throws NoSuchPaymentTransactionException if a payment transaction with the primary key could not be found
	 */
	@Override
	public PaymentTransaction remove(Serializable primaryKey)
		throws NoSuchPaymentTransactionException {

		Session session = null;

		try {
			session = openSession();

			PaymentTransaction paymentTransaction =
				(PaymentTransaction)session.get(
					PaymentTransactionImpl.class, primaryKey);

			if (paymentTransaction == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPaymentTransactionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(paymentTransaction);
		}
		catch (NoSuchPaymentTransactionException noSuchEntityException) {
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
	protected PaymentTransaction removeImpl(
		PaymentTransaction paymentTransaction) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(paymentTransaction)) {
				paymentTransaction = (PaymentTransaction)session.get(
					PaymentTransactionImpl.class,
					paymentTransaction.getPrimaryKeyObj());
			}

			if (paymentTransaction != null) {
				session.delete(paymentTransaction);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (paymentTransaction != null) {
			clearCache(paymentTransaction);
		}

		return paymentTransaction;
	}

	@Override
	public PaymentTransaction updateImpl(
		PaymentTransaction paymentTransaction) {

		boolean isNew = paymentTransaction.isNew();

		if (!(paymentTransaction instanceof PaymentTransactionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(paymentTransaction.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					paymentTransaction);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in paymentTransaction proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PaymentTransaction implementation " +
					paymentTransaction.getClass());
		}

		PaymentTransactionModelImpl paymentTransactionModelImpl =
			(PaymentTransactionModelImpl)paymentTransaction;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (paymentTransaction.getCreateDate() == null)) {
			if (serviceContext == null) {
				paymentTransaction.setCreateDate(date);
			}
			else {
				paymentTransaction.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!paymentTransactionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				paymentTransaction.setModifiedDate(date);
			}
			else {
				paymentTransaction.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(paymentTransaction);
			}
			else {
				paymentTransaction = (PaymentTransaction)session.merge(
					paymentTransaction);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PaymentTransactionImpl.class, paymentTransactionModelImpl, false,
			true);

		if (isNew) {
			paymentTransaction.setNew(false);
		}

		paymentTransaction.resetOriginalValues();

		return paymentTransaction;
	}

	/**
	 * Returns the payment transaction with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the payment transaction
	 * @return the payment transaction
	 * @throws NoSuchPaymentTransactionException if a payment transaction with the primary key could not be found
	 */
	@Override
	public PaymentTransaction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPaymentTransactionException {

		PaymentTransaction paymentTransaction = fetchByPrimaryKey(primaryKey);

		if (paymentTransaction == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPaymentTransactionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return paymentTransaction;
	}

	/**
	 * Returns the payment transaction with the primary key or throws a <code>NoSuchPaymentTransactionException</code> if it could not be found.
	 *
	 * @param paymentTransactionId the primary key of the payment transaction
	 * @return the payment transaction
	 * @throws NoSuchPaymentTransactionException if a payment transaction with the primary key could not be found
	 */
	@Override
	public PaymentTransaction findByPrimaryKey(long paymentTransactionId)
		throws NoSuchPaymentTransactionException {

		return findByPrimaryKey((Serializable)paymentTransactionId);
	}

	/**
	 * Returns the payment transaction with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param paymentTransactionId the primary key of the payment transaction
	 * @return the payment transaction, or <code>null</code> if a payment transaction with the primary key could not be found
	 */
	@Override
	public PaymentTransaction fetchByPrimaryKey(long paymentTransactionId) {
		return fetchByPrimaryKey((Serializable)paymentTransactionId);
	}

	/**
	 * Returns all the payment transactions.
	 *
	 * @return the payment transactions
	 */
	@Override
	public List<PaymentTransaction> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the payment transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @return the range of payment transactions
	 */
	@Override
	public List<PaymentTransaction> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the payment transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of payment transactions
	 */
	@Override
	public List<PaymentTransaction> findAll(
		int start, int end,
		OrderByComparator<PaymentTransaction> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the payment transactions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentTransactionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment transactions
	 * @param end the upper bound of the range of payment transactions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of payment transactions
	 */
	@Override
	public List<PaymentTransaction> findAll(
		int start, int end,
		OrderByComparator<PaymentTransaction> orderByComparator,
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

		List<PaymentTransaction> list = null;

		if (useFinderCache) {
			list = (List<PaymentTransaction>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PAYMENTTRANSACTION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PAYMENTTRANSACTION;

				sql = sql.concat(PaymentTransactionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PaymentTransaction>)QueryUtil.list(
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
	 * Removes all the payment transactions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PaymentTransaction paymentTransaction : findAll()) {
			remove(paymentTransaction);
		}
	}

	/**
	 * Returns the number of payment transactions.
	 *
	 * @return the number of payment transactions
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
					_SQL_COUNT_PAYMENTTRANSACTION);

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
		return "paymentTransactionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PAYMENTTRANSACTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PaymentTransactionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the payment transaction persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new PaymentTransactionModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PaymentTransaction.class.getName()));

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

		_finderPathWithPaginationFindBypolicyProfile = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypolicyProfile",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"policyNumber", "profileId"}, true);

		_finderPathWithoutPaginationFindBypolicyProfile = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypolicyProfile",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"policyNumber", "profileId"}, true);

		_finderPathCountBypolicyProfile = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypolicyProfile",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"policyNumber", "profileId"}, false);

		_finderPathWithPaginationFindByinvoiceNumber = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByinvoiceNumber",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"invoiceNumber"}, true);

		_finderPathWithoutPaginationFindByinvoiceNumber = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByinvoiceNumber",
			new String[] {String.class.getName()},
			new String[] {"invoiceNumber"}, true);

		_finderPathCountByinvoiceNumber = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByinvoiceNumber",
			new String[] {String.class.getName()},
			new String[] {"invoiceNumber"}, false);

		_setPaymentTransactionUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPaymentTransactionUtilPersistence(null);

		entityCache.removeCache(PaymentTransactionImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPaymentTransactionUtilPersistence(
		PaymentTransactionPersistence paymentTransactionPersistence) {

		try {
			Field field = PaymentTransactionUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, paymentTransactionPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = XPPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = XPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = XPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_PAYMENTTRANSACTION =
		"SELECT paymentTransaction FROM PaymentTransaction paymentTransaction";

	private static final String _SQL_SELECT_PAYMENTTRANSACTION_WHERE =
		"SELECT paymentTransaction FROM PaymentTransaction paymentTransaction WHERE ";

	private static final String _SQL_COUNT_PAYMENTTRANSACTION =
		"SELECT COUNT(paymentTransaction) FROM PaymentTransaction paymentTransaction";

	private static final String _SQL_COUNT_PAYMENTTRANSACTION_WHERE =
		"SELECT COUNT(paymentTransaction) FROM PaymentTransaction paymentTransaction WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "paymentTransaction.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PaymentTransaction exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PaymentTransaction exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PaymentTransactionPersistenceImpl.class);

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

	private static class PaymentTransactionModelArgumentsResolver
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

			PaymentTransactionModelImpl paymentTransactionModelImpl =
				(PaymentTransactionModelImpl)baseModel;

			long columnBitmask = paymentTransactionModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					paymentTransactionModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						paymentTransactionModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					paymentTransactionModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PaymentTransactionModelImpl paymentTransactionModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						paymentTransactionModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = paymentTransactionModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}