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

import com.mypage.admin.product.exception.NoSuchPaymentChannelException;
import com.mypage.admin.product.model.PaymentChannel;
import com.mypage.admin.product.model.impl.PaymentChannelImpl;
import com.mypage.admin.product.model.impl.PaymentChannelModelImpl;
import com.mypage.admin.product.service.persistence.PaymentChannelPersistence;
import com.mypage.admin.product.service.persistence.PaymentChannelUtil;
import com.mypage.admin.product.service.persistence.impl.constants.MPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
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
 * The persistence implementation for the payment channel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = PaymentChannelPersistence.class)
public class PaymentChannelPersistenceImpl
	extends BasePersistenceImpl<PaymentChannel>
	implements PaymentChannelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PaymentChannelUtil</code> to access the payment channel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PaymentChannelImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBysearchByBank;
	private FinderPath _finderPathWithoutPaginationFindBysearchByBank;
	private FinderPath _finderPathCountBysearchByBank;

	/**
	 * Returns all the payment channels where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @return the matching payment channels
	 */
	@Override
	public List<PaymentChannel> findBysearchByBank(
		long masterBankId, Integer active) {

		return findBysearchByBank(
			masterBankId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the payment channels where masterBankId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @return the range of matching payment channels
	 */
	@Override
	public List<PaymentChannel> findBysearchByBank(
		long masterBankId, Integer active, int start, int end) {

		return findBysearchByBank(masterBankId, active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the payment channels where masterBankId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching payment channels
	 */
	@Override
	public List<PaymentChannel> findBysearchByBank(
		long masterBankId, Integer active, int start, int end,
		OrderByComparator<PaymentChannel> orderByComparator) {

		return findBysearchByBank(
			masterBankId, active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the payment channels where masterBankId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching payment channels
	 */
	@Override
	public List<PaymentChannel> findBysearchByBank(
		long masterBankId, Integer active, int start, int end,
		OrderByComparator<PaymentChannel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBysearchByBank;
				finderArgs = new Object[] {masterBankId, active};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchByBank;
			finderArgs = new Object[] {
				masterBankId, active, start, end, orderByComparator
			};
		}

		List<PaymentChannel> list = null;

		if (useFinderCache) {
			list = (List<PaymentChannel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PaymentChannel paymentChannel : list) {
					if ((masterBankId != paymentChannel.getMasterBankId()) ||
						!Objects.equals(active, paymentChannel.getActive())) {

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

			sb.append(_SQL_SELECT_PAYMENTCHANNEL_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYBANK_MASTERBANKID_2);

			sb.append(_FINDER_COLUMN_SEARCHBYBANK_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PaymentChannelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(masterBankId);

				queryPos.add(active.intValue());

				list = (List<PaymentChannel>)QueryUtil.list(
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
	 * Returns the first payment channel in the ordered set where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel
	 * @throws NoSuchPaymentChannelException if a matching payment channel could not be found
	 */
	@Override
	public PaymentChannel findBysearchByBank_First(
			long masterBankId, Integer active,
			OrderByComparator<PaymentChannel> orderByComparator)
		throws NoSuchPaymentChannelException {

		PaymentChannel paymentChannel = fetchBysearchByBank_First(
			masterBankId, active, orderByComparator);

		if (paymentChannel != null) {
			return paymentChannel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("masterBankId=");
		sb.append(masterBankId);

		sb.append(", active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchPaymentChannelException(sb.toString());
	}

	/**
	 * Returns the first payment channel in the ordered set where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel, or <code>null</code> if a matching payment channel could not be found
	 */
	@Override
	public PaymentChannel fetchBysearchByBank_First(
		long masterBankId, Integer active,
		OrderByComparator<PaymentChannel> orderByComparator) {

		List<PaymentChannel> list = findBysearchByBank(
			masterBankId, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last payment channel in the ordered set where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel
	 * @throws NoSuchPaymentChannelException if a matching payment channel could not be found
	 */
	@Override
	public PaymentChannel findBysearchByBank_Last(
			long masterBankId, Integer active,
			OrderByComparator<PaymentChannel> orderByComparator)
		throws NoSuchPaymentChannelException {

		PaymentChannel paymentChannel = fetchBysearchByBank_Last(
			masterBankId, active, orderByComparator);

		if (paymentChannel != null) {
			return paymentChannel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("masterBankId=");
		sb.append(masterBankId);

		sb.append(", active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchPaymentChannelException(sb.toString());
	}

	/**
	 * Returns the last payment channel in the ordered set where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel, or <code>null</code> if a matching payment channel could not be found
	 */
	@Override
	public PaymentChannel fetchBysearchByBank_Last(
		long masterBankId, Integer active,
		OrderByComparator<PaymentChannel> orderByComparator) {

		int count = countBysearchByBank(masterBankId, active);

		if (count == 0) {
			return null;
		}

		List<PaymentChannel> list = findBysearchByBank(
			masterBankId, active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the payment channels before and after the current payment channel in the ordered set where masterBankId = &#63; and active = &#63;.
	 *
	 * @param paymentChannelId the primary key of the current payment channel
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next payment channel
	 * @throws NoSuchPaymentChannelException if a payment channel with the primary key could not be found
	 */
	@Override
	public PaymentChannel[] findBysearchByBank_PrevAndNext(
			long paymentChannelId, long masterBankId, Integer active,
			OrderByComparator<PaymentChannel> orderByComparator)
		throws NoSuchPaymentChannelException {

		PaymentChannel paymentChannel = findByPrimaryKey(paymentChannelId);

		Session session = null;

		try {
			session = openSession();

			PaymentChannel[] array = new PaymentChannelImpl[3];

			array[0] = getBysearchByBank_PrevAndNext(
				session, paymentChannel, masterBankId, active,
				orderByComparator, true);

			array[1] = paymentChannel;

			array[2] = getBysearchByBank_PrevAndNext(
				session, paymentChannel, masterBankId, active,
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

	protected PaymentChannel getBysearchByBank_PrevAndNext(
		Session session, PaymentChannel paymentChannel, long masterBankId,
		Integer active, OrderByComparator<PaymentChannel> orderByComparator,
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

		sb.append(_SQL_SELECT_PAYMENTCHANNEL_WHERE);

		sb.append(_FINDER_COLUMN_SEARCHBYBANK_MASTERBANKID_2);

		sb.append(_FINDER_COLUMN_SEARCHBYBANK_ACTIVE_2);

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
			sb.append(PaymentChannelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(masterBankId);

		queryPos.add(active.intValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						paymentChannel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PaymentChannel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the payment channels where masterBankId = &#63; and active = &#63; from the database.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 */
	@Override
	public void removeBysearchByBank(long masterBankId, Integer active) {
		for (PaymentChannel paymentChannel :
				findBysearchByBank(
					masterBankId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(paymentChannel);
		}
	}

	/**
	 * Returns the number of payment channels where masterBankId = &#63; and active = &#63;.
	 *
	 * @param masterBankId the master bank ID
	 * @param active the active
	 * @return the number of matching payment channels
	 */
	@Override
	public int countBysearchByBank(long masterBankId, Integer active) {
		FinderPath finderPath = _finderPathCountBysearchByBank;

		Object[] finderArgs = new Object[] {masterBankId, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PAYMENTCHANNEL_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYBANK_MASTERBANKID_2);

			sb.append(_FINDER_COLUMN_SEARCHBYBANK_ACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(masterBankId);

				queryPos.add(active.intValue());

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

	private static final String _FINDER_COLUMN_SEARCHBYBANK_MASTERBANKID_2 =
		"paymentChannel.masterBankId = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHBYBANK_ACTIVE_2 =
		"paymentChannel.active = ?";

	private FinderPath _finderPathWithPaginationFindBysearchByIdAndCode;
	private FinderPath _finderPathWithoutPaginationFindBysearchByIdAndCode;
	private FinderPath _finderPathCountBysearchByIdAndCode;

	/**
	 * Returns all the payment channels where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @return the matching payment channels
	 */
	@Override
	public List<PaymentChannel> findBysearchByIdAndCode(
		long paymentChannelId, String code) {

		return findBysearchByIdAndCode(
			paymentChannelId, code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the payment channels where paymentChannelId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @return the range of matching payment channels
	 */
	@Override
	public List<PaymentChannel> findBysearchByIdAndCode(
		long paymentChannelId, String code, int start, int end) {

		return findBysearchByIdAndCode(
			paymentChannelId, code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the payment channels where paymentChannelId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching payment channels
	 */
	@Override
	public List<PaymentChannel> findBysearchByIdAndCode(
		long paymentChannelId, String code, int start, int end,
		OrderByComparator<PaymentChannel> orderByComparator) {

		return findBysearchByIdAndCode(
			paymentChannelId, code, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the payment channels where paymentChannelId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching payment channels
	 */
	@Override
	public List<PaymentChannel> findBysearchByIdAndCode(
		long paymentChannelId, String code, int start, int end,
		OrderByComparator<PaymentChannel> orderByComparator,
		boolean useFinderCache) {

		code = Objects.toString(code, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBysearchByIdAndCode;
				finderArgs = new Object[] {paymentChannelId, code};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchByIdAndCode;
			finderArgs = new Object[] {
				paymentChannelId, code, start, end, orderByComparator
			};
		}

		List<PaymentChannel> list = null;

		if (useFinderCache) {
			list = (List<PaymentChannel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PaymentChannel paymentChannel : list) {
					if ((paymentChannelId !=
							paymentChannel.getPaymentChannelId()) ||
						!code.equals(paymentChannel.getCode())) {

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

			sb.append(_SQL_SELECT_PAYMENTCHANNEL_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYIDANDCODE_PAYMENTCHANNELID_2);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHBYIDANDCODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_SEARCHBYIDANDCODE_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PaymentChannelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(paymentChannelId);

				if (bindCode) {
					queryPos.add(code);
				}

				list = (List<PaymentChannel>)QueryUtil.list(
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
	 * Returns the first payment channel in the ordered set where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel
	 * @throws NoSuchPaymentChannelException if a matching payment channel could not be found
	 */
	@Override
	public PaymentChannel findBysearchByIdAndCode_First(
			long paymentChannelId, String code,
			OrderByComparator<PaymentChannel> orderByComparator)
		throws NoSuchPaymentChannelException {

		PaymentChannel paymentChannel = fetchBysearchByIdAndCode_First(
			paymentChannelId, code, orderByComparator);

		if (paymentChannel != null) {
			return paymentChannel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("paymentChannelId=");
		sb.append(paymentChannelId);

		sb.append(", code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchPaymentChannelException(sb.toString());
	}

	/**
	 * Returns the first payment channel in the ordered set where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment channel, or <code>null</code> if a matching payment channel could not be found
	 */
	@Override
	public PaymentChannel fetchBysearchByIdAndCode_First(
		long paymentChannelId, String code,
		OrderByComparator<PaymentChannel> orderByComparator) {

		List<PaymentChannel> list = findBysearchByIdAndCode(
			paymentChannelId, code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last payment channel in the ordered set where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel
	 * @throws NoSuchPaymentChannelException if a matching payment channel could not be found
	 */
	@Override
	public PaymentChannel findBysearchByIdAndCode_Last(
			long paymentChannelId, String code,
			OrderByComparator<PaymentChannel> orderByComparator)
		throws NoSuchPaymentChannelException {

		PaymentChannel paymentChannel = fetchBysearchByIdAndCode_Last(
			paymentChannelId, code, orderByComparator);

		if (paymentChannel != null) {
			return paymentChannel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("paymentChannelId=");
		sb.append(paymentChannelId);

		sb.append(", code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchPaymentChannelException(sb.toString());
	}

	/**
	 * Returns the last payment channel in the ordered set where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment channel, or <code>null</code> if a matching payment channel could not be found
	 */
	@Override
	public PaymentChannel fetchBysearchByIdAndCode_Last(
		long paymentChannelId, String code,
		OrderByComparator<PaymentChannel> orderByComparator) {

		int count = countBysearchByIdAndCode(paymentChannelId, code);

		if (count == 0) {
			return null;
		}

		List<PaymentChannel> list = findBysearchByIdAndCode(
			paymentChannelId, code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the payment channels where paymentChannelId = &#63; and code = &#63; from the database.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 */
	@Override
	public void removeBysearchByIdAndCode(long paymentChannelId, String code) {
		for (PaymentChannel paymentChannel :
				findBysearchByIdAndCode(
					paymentChannelId, code, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(paymentChannel);
		}
	}

	/**
	 * Returns the number of payment channels where paymentChannelId = &#63; and code = &#63;.
	 *
	 * @param paymentChannelId the payment channel ID
	 * @param code the code
	 * @return the number of matching payment channels
	 */
	@Override
	public int countBysearchByIdAndCode(long paymentChannelId, String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountBysearchByIdAndCode;

		Object[] finderArgs = new Object[] {paymentChannelId, code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PAYMENTCHANNEL_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYIDANDCODE_PAYMENTCHANNELID_2);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHBYIDANDCODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_SEARCHBYIDANDCODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(paymentChannelId);

				if (bindCode) {
					queryPos.add(code);
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
		_FINDER_COLUMN_SEARCHBYIDANDCODE_PAYMENTCHANNELID_2 =
			"paymentChannel.paymentChannelId = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHBYIDANDCODE_CODE_2 =
		"paymentChannel.code = ?";

	private static final String _FINDER_COLUMN_SEARCHBYIDANDCODE_CODE_3 =
		"(paymentChannel.code IS NULL OR paymentChannel.code = '')";

	public PaymentChannelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PaymentChannel.class);

		setModelImplClass(PaymentChannelImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the payment channel in the entity cache if it is enabled.
	 *
	 * @param paymentChannel the payment channel
	 */
	@Override
	public void cacheResult(PaymentChannel paymentChannel) {
		entityCache.putResult(
			PaymentChannelImpl.class, paymentChannel.getPrimaryKey(),
			paymentChannel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the payment channels in the entity cache if it is enabled.
	 *
	 * @param paymentChannels the payment channels
	 */
	@Override
	public void cacheResult(List<PaymentChannel> paymentChannels) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (paymentChannels.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PaymentChannel paymentChannel : paymentChannels) {
			if (entityCache.getResult(
					PaymentChannelImpl.class, paymentChannel.getPrimaryKey()) ==
						null) {

				cacheResult(paymentChannel);
			}
		}
	}

	/**
	 * Clears the cache for all payment channels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PaymentChannelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the payment channel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PaymentChannel paymentChannel) {
		entityCache.removeResult(PaymentChannelImpl.class, paymentChannel);
	}

	@Override
	public void clearCache(List<PaymentChannel> paymentChannels) {
		for (PaymentChannel paymentChannel : paymentChannels) {
			entityCache.removeResult(PaymentChannelImpl.class, paymentChannel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PaymentChannelImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new payment channel with the primary key. Does not add the payment channel to the database.
	 *
	 * @param paymentChannelId the primary key for the new payment channel
	 * @return the new payment channel
	 */
	@Override
	public PaymentChannel create(long paymentChannelId) {
		PaymentChannel paymentChannel = new PaymentChannelImpl();

		paymentChannel.setNew(true);
		paymentChannel.setPrimaryKey(paymentChannelId);

		paymentChannel.setCompanyId(CompanyThreadLocal.getCompanyId());

		return paymentChannel;
	}

	/**
	 * Removes the payment channel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param paymentChannelId the primary key of the payment channel
	 * @return the payment channel that was removed
	 * @throws NoSuchPaymentChannelException if a payment channel with the primary key could not be found
	 */
	@Override
	public PaymentChannel remove(long paymentChannelId)
		throws NoSuchPaymentChannelException {

		return remove((Serializable)paymentChannelId);
	}

	/**
	 * Removes the payment channel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the payment channel
	 * @return the payment channel that was removed
	 * @throws NoSuchPaymentChannelException if a payment channel with the primary key could not be found
	 */
	@Override
	public PaymentChannel remove(Serializable primaryKey)
		throws NoSuchPaymentChannelException {

		Session session = null;

		try {
			session = openSession();

			PaymentChannel paymentChannel = (PaymentChannel)session.get(
				PaymentChannelImpl.class, primaryKey);

			if (paymentChannel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPaymentChannelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(paymentChannel);
		}
		catch (NoSuchPaymentChannelException noSuchEntityException) {
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
	protected PaymentChannel removeImpl(PaymentChannel paymentChannel) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(paymentChannel)) {
				paymentChannel = (PaymentChannel)session.get(
					PaymentChannelImpl.class,
					paymentChannel.getPrimaryKeyObj());
			}

			if (paymentChannel != null) {
				session.delete(paymentChannel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (paymentChannel != null) {
			clearCache(paymentChannel);
		}

		return paymentChannel;
	}

	@Override
	public PaymentChannel updateImpl(PaymentChannel paymentChannel) {
		boolean isNew = paymentChannel.isNew();

		if (!(paymentChannel instanceof PaymentChannelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(paymentChannel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					paymentChannel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in paymentChannel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PaymentChannel implementation " +
					paymentChannel.getClass());
		}

		PaymentChannelModelImpl paymentChannelModelImpl =
			(PaymentChannelModelImpl)paymentChannel;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (paymentChannel.getCreateDate() == null)) {
			if (serviceContext == null) {
				paymentChannel.setCreateDate(date);
			}
			else {
				paymentChannel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!paymentChannelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				paymentChannel.setModifiedDate(date);
			}
			else {
				paymentChannel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(paymentChannel);
			}
			else {
				paymentChannel = (PaymentChannel)session.merge(paymentChannel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PaymentChannelImpl.class, paymentChannelModelImpl, false, true);

		if (isNew) {
			paymentChannel.setNew(false);
		}

		paymentChannel.resetOriginalValues();

		return paymentChannel;
	}

	/**
	 * Returns the payment channel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the payment channel
	 * @return the payment channel
	 * @throws NoSuchPaymentChannelException if a payment channel with the primary key could not be found
	 */
	@Override
	public PaymentChannel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPaymentChannelException {

		PaymentChannel paymentChannel = fetchByPrimaryKey(primaryKey);

		if (paymentChannel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPaymentChannelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return paymentChannel;
	}

	/**
	 * Returns the payment channel with the primary key or throws a <code>NoSuchPaymentChannelException</code> if it could not be found.
	 *
	 * @param paymentChannelId the primary key of the payment channel
	 * @return the payment channel
	 * @throws NoSuchPaymentChannelException if a payment channel with the primary key could not be found
	 */
	@Override
	public PaymentChannel findByPrimaryKey(long paymentChannelId)
		throws NoSuchPaymentChannelException {

		return findByPrimaryKey((Serializable)paymentChannelId);
	}

	/**
	 * Returns the payment channel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param paymentChannelId the primary key of the payment channel
	 * @return the payment channel, or <code>null</code> if a payment channel with the primary key could not be found
	 */
	@Override
	public PaymentChannel fetchByPrimaryKey(long paymentChannelId) {
		return fetchByPrimaryKey((Serializable)paymentChannelId);
	}

	/**
	 * Returns all the payment channels.
	 *
	 * @return the payment channels
	 */
	@Override
	public List<PaymentChannel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the payment channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @return the range of payment channels
	 */
	@Override
	public List<PaymentChannel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the payment channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of payment channels
	 */
	@Override
	public List<PaymentChannel> findAll(
		int start, int end,
		OrderByComparator<PaymentChannel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the payment channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PaymentChannelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of payment channels
	 * @param end the upper bound of the range of payment channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of payment channels
	 */
	@Override
	public List<PaymentChannel> findAll(
		int start, int end, OrderByComparator<PaymentChannel> orderByComparator,
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

		List<PaymentChannel> list = null;

		if (useFinderCache) {
			list = (List<PaymentChannel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PAYMENTCHANNEL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PAYMENTCHANNEL;

				sql = sql.concat(PaymentChannelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PaymentChannel>)QueryUtil.list(
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
	 * Removes all the payment channels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PaymentChannel paymentChannel : findAll()) {
			remove(paymentChannel);
		}
	}

	/**
	 * Returns the number of payment channels.
	 *
	 * @return the number of payment channels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PAYMENTCHANNEL);

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
		return "paymentChannelId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PAYMENTCHANNEL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PaymentChannelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the payment channel persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PaymentChannelModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PaymentChannel.class.getName()));

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

		_finderPathWithPaginationFindBysearchByBank = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchByBank",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"masterBankId", "active_"}, true);

		_finderPathWithoutPaginationFindBysearchByBank = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysearchByBank",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"masterBankId", "active_"}, true);

		_finderPathCountBysearchByBank = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchByBank",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"masterBankId", "active_"}, false);

		_finderPathWithPaginationFindBysearchByIdAndCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchByIdAndCode",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"paymentChannelId", "code_"}, true);

		_finderPathWithoutPaginationFindBysearchByIdAndCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBysearchByIdAndCode",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"paymentChannelId", "code_"}, true);

		_finderPathCountBysearchByIdAndCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysearchByIdAndCode",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"paymentChannelId", "code_"}, false);

		_setPaymentChannelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPaymentChannelUtilPersistence(null);

		entityCache.removeCache(PaymentChannelImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPaymentChannelUtilPersistence(
		PaymentChannelPersistence paymentChannelPersistence) {

		try {
			Field field = PaymentChannelUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, paymentChannelPersistence);
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

	private static final String _SQL_SELECT_PAYMENTCHANNEL =
		"SELECT paymentChannel FROM PaymentChannel paymentChannel";

	private static final String _SQL_SELECT_PAYMENTCHANNEL_WHERE =
		"SELECT paymentChannel FROM PaymentChannel paymentChannel WHERE ";

	private static final String _SQL_COUNT_PAYMENTCHANNEL =
		"SELECT COUNT(paymentChannel) FROM PaymentChannel paymentChannel";

	private static final String _SQL_COUNT_PAYMENTCHANNEL_WHERE =
		"SELECT COUNT(paymentChannel) FROM PaymentChannel paymentChannel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "paymentChannel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PaymentChannel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PaymentChannel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PaymentChannelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"code", "active"});

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

	private static class PaymentChannelModelArgumentsResolver
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

			PaymentChannelModelImpl paymentChannelModelImpl =
				(PaymentChannelModelImpl)baseModel;

			long columnBitmask = paymentChannelModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					paymentChannelModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						paymentChannelModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					paymentChannelModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PaymentChannelModelImpl paymentChannelModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						paymentChannelModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = paymentChannelModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}