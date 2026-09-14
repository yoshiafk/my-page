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

import com.mypage.leads.exception.NoSuchCustomerException;
import com.mypage.leads.model.Customer;
import com.mypage.leads.model.impl.CustomerImpl;
import com.mypage.leads.model.impl.CustomerModelImpl;
import com.mypage.leads.service.persistence.CustomerPersistence;
import com.mypage.leads.service.persistence.CustomerUtil;
import com.mypage.leads.service.persistence.impl.constants.MPLPersistenceConstants;

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
 * The persistence implementation for the customer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @generated
 */
@Component(service = CustomerPersistence.class)
public class CustomerPersistenceImpl
	extends BasePersistenceImpl<Customer> implements CustomerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CustomerUtil</code> to access the customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CustomerImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBysearchByLeadsId;
	private FinderPath _finderPathWithoutPaginationFindBysearchByLeadsId;
	private FinderPath _finderPathCountBysearchByLeadsId;

	/**
	 * Returns all the customers where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching customers
	 */
	@Override
	public List<Customer> findBysearchByLeadsId(long LeadsId) {
		return findBysearchByLeadsId(
			LeadsId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the customers where LeadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param LeadsId the leads ID
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @return the range of matching customers
	 */
	@Override
	public List<Customer> findBysearchByLeadsId(
		long LeadsId, int start, int end) {

		return findBysearchByLeadsId(LeadsId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the customers where LeadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param LeadsId the leads ID
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching customers
	 */
	@Override
	public List<Customer> findBysearchByLeadsId(
		long LeadsId, int start, int end,
		OrderByComparator<Customer> orderByComparator) {

		return findBysearchByLeadsId(
			LeadsId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the customers where LeadsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param LeadsId the leads ID
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching customers
	 */
	@Override
	public List<Customer> findBysearchByLeadsId(
		long LeadsId, int start, int end,
		OrderByComparator<Customer> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBysearchByLeadsId;
				finderArgs = new Object[] {LeadsId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchByLeadsId;
			finderArgs = new Object[] {LeadsId, start, end, orderByComparator};
		}

		List<Customer> list = null;

		if (useFinderCache) {
			list = (List<Customer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Customer customer : list) {
					if (LeadsId != customer.getLeadsId()) {
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

			sb.append(_SQL_SELECT_CUSTOMER_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYLEADSID_LEADSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CustomerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(LeadsId);

				list = (List<Customer>)QueryUtil.list(
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
	 * Returns the first customer in the ordered set where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	@Override
	public Customer findBysearchByLeadsId_First(
			long LeadsId, OrderByComparator<Customer> orderByComparator)
		throws NoSuchCustomerException {

		Customer customer = fetchBysearchByLeadsId_First(
			LeadsId, orderByComparator);

		if (customer != null) {
			return customer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("LeadsId=");
		sb.append(LeadsId);

		sb.append("}");

		throw new NoSuchCustomerException(sb.toString());
	}

	/**
	 * Returns the first customer in the ordered set where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer, or <code>null</code> if a matching customer could not be found
	 */
	@Override
	public Customer fetchBysearchByLeadsId_First(
		long LeadsId, OrderByComparator<Customer> orderByComparator) {

		List<Customer> list = findBysearchByLeadsId(
			LeadsId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last customer in the ordered set where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	@Override
	public Customer findBysearchByLeadsId_Last(
			long LeadsId, OrderByComparator<Customer> orderByComparator)
		throws NoSuchCustomerException {

		Customer customer = fetchBysearchByLeadsId_Last(
			LeadsId, orderByComparator);

		if (customer != null) {
			return customer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("LeadsId=");
		sb.append(LeadsId);

		sb.append("}");

		throw new NoSuchCustomerException(sb.toString());
	}

	/**
	 * Returns the last customer in the ordered set where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer, or <code>null</code> if a matching customer could not be found
	 */
	@Override
	public Customer fetchBysearchByLeadsId_Last(
		long LeadsId, OrderByComparator<Customer> orderByComparator) {

		int count = countBysearchByLeadsId(LeadsId);

		if (count == 0) {
			return null;
		}

		List<Customer> list = findBysearchByLeadsId(
			LeadsId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the customers before and after the current customer in the ordered set where LeadsId = &#63;.
	 *
	 * @param customerId the primary key of the current customer
	 * @param LeadsId the leads ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next customer
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	@Override
	public Customer[] findBysearchByLeadsId_PrevAndNext(
			long customerId, long LeadsId,
			OrderByComparator<Customer> orderByComparator)
		throws NoSuchCustomerException {

		Customer customer = findByPrimaryKey(customerId);

		Session session = null;

		try {
			session = openSession();

			Customer[] array = new CustomerImpl[3];

			array[0] = getBysearchByLeadsId_PrevAndNext(
				session, customer, LeadsId, orderByComparator, true);

			array[1] = customer;

			array[2] = getBysearchByLeadsId_PrevAndNext(
				session, customer, LeadsId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Customer getBysearchByLeadsId_PrevAndNext(
		Session session, Customer customer, long LeadsId,
		OrderByComparator<Customer> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CUSTOMER_WHERE);

		sb.append(_FINDER_COLUMN_SEARCHBYLEADSID_LEADSID_2);

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
			sb.append(CustomerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(LeadsId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(customer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Customer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the customers where LeadsId = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 */
	@Override
	public void removeBysearchByLeadsId(long LeadsId) {
		for (Customer customer :
				findBysearchByLeadsId(
					LeadsId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(customer);
		}
	}

	/**
	 * Returns the number of customers where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the number of matching customers
	 */
	@Override
	public int countBysearchByLeadsId(long LeadsId) {
		FinderPath finderPath = _finderPathCountBysearchByLeadsId;

		Object[] finderArgs = new Object[] {LeadsId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CUSTOMER_WHERE);

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
		"customer.LeadsId = ?";

	private FinderPath
		_finderPathWithPaginationFindBysearchByLeadsIdAndProductCode;
	private FinderPath
		_finderPathWithoutPaginationFindBysearchByLeadsIdAndProductCode;
	private FinderPath _finderPathCountBysearchByLeadsIdAndProductCode;

	/**
	 * Returns all the customers where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @return the matching customers
	 */
	@Override
	public List<Customer> findBysearchByLeadsIdAndProductCode(
		long LeadsId, String ProductCode) {

		return findBysearchByLeadsIdAndProductCode(
			LeadsId, ProductCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the customers where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @return the range of matching customers
	 */
	@Override
	public List<Customer> findBysearchByLeadsIdAndProductCode(
		long LeadsId, String ProductCode, int start, int end) {

		return findBysearchByLeadsIdAndProductCode(
			LeadsId, ProductCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the customers where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching customers
	 */
	@Override
	public List<Customer> findBysearchByLeadsIdAndProductCode(
		long LeadsId, String ProductCode, int start, int end,
		OrderByComparator<Customer> orderByComparator) {

		return findBysearchByLeadsIdAndProductCode(
			LeadsId, ProductCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the customers where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching customers
	 */
	@Override
	public List<Customer> findBysearchByLeadsIdAndProductCode(
		long LeadsId, String ProductCode, int start, int end,
		OrderByComparator<Customer> orderByComparator, boolean useFinderCache) {

		ProductCode = Objects.toString(ProductCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBysearchByLeadsIdAndProductCode;
				finderArgs = new Object[] {LeadsId, ProductCode};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBysearchByLeadsIdAndProductCode;
			finderArgs = new Object[] {
				LeadsId, ProductCode, start, end, orderByComparator
			};
		}

		List<Customer> list = null;

		if (useFinderCache) {
			list = (List<Customer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Customer customer : list) {
					if ((LeadsId != customer.getLeadsId()) ||
						!ProductCode.equals(customer.getProductCode())) {

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

			sb.append(_SQL_SELECT_CUSTOMER_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYLEADSIDANDPRODUCTCODE_LEADSID_2);

			boolean bindProductCode = false;

			if (ProductCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SEARCHBYLEADSIDANDPRODUCTCODE_PRODUCTCODE_3);
			}
			else {
				bindProductCode = true;

				sb.append(
					_FINDER_COLUMN_SEARCHBYLEADSIDANDPRODUCTCODE_PRODUCTCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CustomerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(LeadsId);

				if (bindProductCode) {
					queryPos.add(ProductCode);
				}

				list = (List<Customer>)QueryUtil.list(
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
	 * Returns the first customer in the ordered set where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	@Override
	public Customer findBysearchByLeadsIdAndProductCode_First(
			long LeadsId, String ProductCode,
			OrderByComparator<Customer> orderByComparator)
		throws NoSuchCustomerException {

		Customer customer = fetchBysearchByLeadsIdAndProductCode_First(
			LeadsId, ProductCode, orderByComparator);

		if (customer != null) {
			return customer;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("LeadsId=");
		sb.append(LeadsId);

		sb.append(", ProductCode=");
		sb.append(ProductCode);

		sb.append("}");

		throw new NoSuchCustomerException(sb.toString());
	}

	/**
	 * Returns the first customer in the ordered set where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer, or <code>null</code> if a matching customer could not be found
	 */
	@Override
	public Customer fetchBysearchByLeadsIdAndProductCode_First(
		long LeadsId, String ProductCode,
		OrderByComparator<Customer> orderByComparator) {

		List<Customer> list = findBysearchByLeadsIdAndProductCode(
			LeadsId, ProductCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last customer in the ordered set where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer
	 * @throws NoSuchCustomerException if a matching customer could not be found
	 */
	@Override
	public Customer findBysearchByLeadsIdAndProductCode_Last(
			long LeadsId, String ProductCode,
			OrderByComparator<Customer> orderByComparator)
		throws NoSuchCustomerException {

		Customer customer = fetchBysearchByLeadsIdAndProductCode_Last(
			LeadsId, ProductCode, orderByComparator);

		if (customer != null) {
			return customer;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("LeadsId=");
		sb.append(LeadsId);

		sb.append(", ProductCode=");
		sb.append(ProductCode);

		sb.append("}");

		throw new NoSuchCustomerException(sb.toString());
	}

	/**
	 * Returns the last customer in the ordered set where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer, or <code>null</code> if a matching customer could not be found
	 */
	@Override
	public Customer fetchBysearchByLeadsIdAndProductCode_Last(
		long LeadsId, String ProductCode,
		OrderByComparator<Customer> orderByComparator) {

		int count = countBysearchByLeadsIdAndProductCode(LeadsId, ProductCode);

		if (count == 0) {
			return null;
		}

		List<Customer> list = findBysearchByLeadsIdAndProductCode(
			LeadsId, ProductCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the customers before and after the current customer in the ordered set where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * @param customerId the primary key of the current customer
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next customer
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	@Override
	public Customer[] findBysearchByLeadsIdAndProductCode_PrevAndNext(
			long customerId, long LeadsId, String ProductCode,
			OrderByComparator<Customer> orderByComparator)
		throws NoSuchCustomerException {

		ProductCode = Objects.toString(ProductCode, "");

		Customer customer = findByPrimaryKey(customerId);

		Session session = null;

		try {
			session = openSession();

			Customer[] array = new CustomerImpl[3];

			array[0] = getBysearchByLeadsIdAndProductCode_PrevAndNext(
				session, customer, LeadsId, ProductCode, orderByComparator,
				true);

			array[1] = customer;

			array[2] = getBysearchByLeadsIdAndProductCode_PrevAndNext(
				session, customer, LeadsId, ProductCode, orderByComparator,
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

	protected Customer getBysearchByLeadsIdAndProductCode_PrevAndNext(
		Session session, Customer customer, long LeadsId, String ProductCode,
		OrderByComparator<Customer> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CUSTOMER_WHERE);

		sb.append(_FINDER_COLUMN_SEARCHBYLEADSIDANDPRODUCTCODE_LEADSID_2);

		boolean bindProductCode = false;

		if (ProductCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_SEARCHBYLEADSIDANDPRODUCTCODE_PRODUCTCODE_3);
		}
		else {
			bindProductCode = true;

			sb.append(
				_FINDER_COLUMN_SEARCHBYLEADSIDANDPRODUCTCODE_PRODUCTCODE_2);
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
			sb.append(CustomerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(LeadsId);

		if (bindProductCode) {
			queryPos.add(ProductCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(customer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Customer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the customers where LeadsId = &#63; and ProductCode = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 */
	@Override
	public void removeBysearchByLeadsIdAndProductCode(
		long LeadsId, String ProductCode) {

		for (Customer customer :
				findBysearchByLeadsIdAndProductCode(
					LeadsId, ProductCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(customer);
		}
	}

	/**
	 * Returns the number of customers where LeadsId = &#63; and ProductCode = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @param ProductCode the product code
	 * @return the number of matching customers
	 */
	@Override
	public int countBysearchByLeadsIdAndProductCode(
		long LeadsId, String ProductCode) {

		ProductCode = Objects.toString(ProductCode, "");

		FinderPath finderPath = _finderPathCountBysearchByLeadsIdAndProductCode;

		Object[] finderArgs = new Object[] {LeadsId, ProductCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CUSTOMER_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYLEADSIDANDPRODUCTCODE_LEADSID_2);

			boolean bindProductCode = false;

			if (ProductCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SEARCHBYLEADSIDANDPRODUCTCODE_PRODUCTCODE_3);
			}
			else {
				bindProductCode = true;

				sb.append(
					_FINDER_COLUMN_SEARCHBYLEADSIDANDPRODUCTCODE_PRODUCTCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(LeadsId);

				if (bindProductCode) {
					queryPos.add(ProductCode);
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
		_FINDER_COLUMN_SEARCHBYLEADSIDANDPRODUCTCODE_LEADSID_2 =
			"customer.LeadsId = ? AND ";

	private static final String
		_FINDER_COLUMN_SEARCHBYLEADSIDANDPRODUCTCODE_PRODUCTCODE_2 =
			"customer.ProductCode = ?";

	private static final String
		_FINDER_COLUMN_SEARCHBYLEADSIDANDPRODUCTCODE_PRODUCTCODE_3 =
			"(customer.ProductCode IS NULL OR customer.ProductCode = '')";

	public CustomerPersistenceImpl() {
		setModelClass(Customer.class);

		setModelImplClass(CustomerImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the customer in the entity cache if it is enabled.
	 *
	 * @param customer the customer
	 */
	@Override
	public void cacheResult(Customer customer) {
		entityCache.putResult(
			CustomerImpl.class, customer.getPrimaryKey(), customer);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the customers in the entity cache if it is enabled.
	 *
	 * @param customers the customers
	 */
	@Override
	public void cacheResult(List<Customer> customers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (customers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Customer customer : customers) {
			if (entityCache.getResult(
					CustomerImpl.class, customer.getPrimaryKey()) == null) {

				cacheResult(customer);
			}
		}
	}

	/**
	 * Clears the cache for all customers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CustomerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the customer.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Customer customer) {
		entityCache.removeResult(CustomerImpl.class, customer);
	}

	@Override
	public void clearCache(List<Customer> customers) {
		for (Customer customer : customers) {
			entityCache.removeResult(CustomerImpl.class, customer);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CustomerImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new customer with the primary key. Does not add the customer to the database.
	 *
	 * @param customerId the primary key for the new customer
	 * @return the new customer
	 */
	@Override
	public Customer create(long customerId) {
		Customer customer = new CustomerImpl();

		customer.setNew(true);
		customer.setPrimaryKey(customerId);

		customer.setCompanyId(CompanyThreadLocal.getCompanyId());

		return customer;
	}

	/**
	 * Removes the customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer that was removed
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	@Override
	public Customer remove(long customerId) throws NoSuchCustomerException {
		return remove((Serializable)customerId);
	}

	/**
	 * Removes the customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the customer
	 * @return the customer that was removed
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	@Override
	public Customer remove(Serializable primaryKey)
		throws NoSuchCustomerException {

		Session session = null;

		try {
			session = openSession();

			Customer customer = (Customer)session.get(
				CustomerImpl.class, primaryKey);

			if (customer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustomerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(customer);
		}
		catch (NoSuchCustomerException noSuchEntityException) {
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
	protected Customer removeImpl(Customer customer) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(customer)) {
				customer = (Customer)session.get(
					CustomerImpl.class, customer.getPrimaryKeyObj());
			}

			if (customer != null) {
				session.delete(customer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (customer != null) {
			clearCache(customer);
		}

		return customer;
	}

	@Override
	public Customer updateImpl(Customer customer) {
		boolean isNew = customer.isNew();

		if (!(customer instanceof CustomerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(customer.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(customer);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in customer proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Customer implementation " +
					customer.getClass());
		}

		CustomerModelImpl customerModelImpl = (CustomerModelImpl)customer;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (customer.getCreateDate() == null)) {
			if (serviceContext == null) {
				customer.setCreateDate(date);
			}
			else {
				customer.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!customerModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				customer.setModifiedDate(date);
			}
			else {
				customer.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(customer);
			}
			else {
				customer = (Customer)session.merge(customer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CustomerImpl.class, customerModelImpl, false, true);

		if (isNew) {
			customer.setNew(false);
		}

		customer.resetOriginalValues();

		return customer;
	}

	/**
	 * Returns the customer with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the customer
	 * @return the customer
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	@Override
	public Customer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustomerException {

		Customer customer = fetchByPrimaryKey(primaryKey);

		if (customer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustomerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return customer;
	}

	/**
	 * Returns the customer with the primary key or throws a <code>NoSuchCustomerException</code> if it could not be found.
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer
	 * @throws NoSuchCustomerException if a customer with the primary key could not be found
	 */
	@Override
	public Customer findByPrimaryKey(long customerId)
		throws NoSuchCustomerException {

		return findByPrimaryKey((Serializable)customerId);
	}

	/**
	 * Returns the customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customerId the primary key of the customer
	 * @return the customer, or <code>null</code> if a customer with the primary key could not be found
	 */
	@Override
	public Customer fetchByPrimaryKey(long customerId) {
		return fetchByPrimaryKey((Serializable)customerId);
	}

	/**
	 * Returns all the customers.
	 *
	 * @return the customers
	 */
	@Override
	public List<Customer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @return the range of customers
	 */
	@Override
	public List<Customer> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of customers
	 */
	@Override
	public List<Customer> findAll(
		int start, int end, OrderByComparator<Customer> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customers
	 * @param end the upper bound of the range of customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of customers
	 */
	@Override
	public List<Customer> findAll(
		int start, int end, OrderByComparator<Customer> orderByComparator,
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

		List<Customer> list = null;

		if (useFinderCache) {
			list = (List<Customer>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CUSTOMER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOMER;

				sql = sql.concat(CustomerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Customer>)QueryUtil.list(
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
	 * Removes all the customers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Customer customer : findAll()) {
			remove(customer);
		}
	}

	/**
	 * Returns the number of customers.
	 *
	 * @return the number of customers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CUSTOMER);

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
		return "customerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CUSTOMER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CustomerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the customer persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CustomerModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Customer.class.getName()));

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

		_finderPathWithPaginationFindBysearchByLeadsId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchByLeadsId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"LeadsId"}, true);

		_finderPathWithoutPaginationFindBysearchByLeadsId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysearchByLeadsId",
			new String[] {Long.class.getName()}, new String[] {"LeadsId"},
			true);

		_finderPathCountBysearchByLeadsId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchByLeadsId",
			new String[] {Long.class.getName()}, new String[] {"LeadsId"},
			false);

		_finderPathWithPaginationFindBysearchByLeadsIdAndProductCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBysearchByLeadsIdAndProductCode",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"LeadsId", "ProductCode"}, true);

		_finderPathWithoutPaginationFindBysearchByLeadsIdAndProductCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBysearchByLeadsIdAndProductCode",
				new String[] {Long.class.getName(), String.class.getName()},
				new String[] {"LeadsId", "ProductCode"}, true);

		_finderPathCountBysearchByLeadsIdAndProductCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysearchByLeadsIdAndProductCode",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"LeadsId", "ProductCode"}, false);

		_setCustomerUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCustomerUtilPersistence(null);

		entityCache.removeCache(CustomerImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setCustomerUtilPersistence(
		CustomerPersistence customerPersistence) {

		try {
			Field field = CustomerUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, customerPersistence);
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

	private static final String _SQL_SELECT_CUSTOMER =
		"SELECT customer FROM Customer customer";

	private static final String _SQL_SELECT_CUSTOMER_WHERE =
		"SELECT customer FROM Customer customer WHERE ";

	private static final String _SQL_COUNT_CUSTOMER =
		"SELECT COUNT(customer) FROM Customer customer";

	private static final String _SQL_COUNT_CUSTOMER_WHERE =
		"SELECT COUNT(customer) FROM Customer customer WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "customer.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Customer exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Customer exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CustomerPersistenceImpl.class);

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

	private static class CustomerModelArgumentsResolver
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

			CustomerModelImpl customerModelImpl = (CustomerModelImpl)baseModel;

			long columnBitmask = customerModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(customerModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						customerModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(customerModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			CustomerModelImpl customerModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = customerModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = customerModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}