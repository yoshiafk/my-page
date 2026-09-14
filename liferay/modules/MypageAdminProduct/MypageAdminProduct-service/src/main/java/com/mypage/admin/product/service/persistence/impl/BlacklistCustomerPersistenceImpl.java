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

import com.mypage.admin.product.exception.NoSuchBlacklistCustomerException;
import com.mypage.admin.product.model.BlacklistCustomer;
import com.mypage.admin.product.model.impl.BlacklistCustomerImpl;
import com.mypage.admin.product.model.impl.BlacklistCustomerModelImpl;
import com.mypage.admin.product.service.persistence.BlacklistCustomerPersistence;
import com.mypage.admin.product.service.persistence.BlacklistCustomerUtil;
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
 * The persistence implementation for the blacklist customer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = BlacklistCustomerPersistence.class)
public class BlacklistCustomerPersistenceImpl
	extends BasePersistenceImpl<BlacklistCustomer>
	implements BlacklistCustomerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BlacklistCustomerUtil</code> to access the blacklist customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BlacklistCustomerImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByfirstName;
	private FinderPath _finderPathWithoutPaginationFindByfirstName;
	private FinderPath _finderPathCountByfirstName;

	/**
	 * Returns all the blacklist customers where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findByfirstName(String firstName) {
		return findByfirstName(
			firstName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the blacklist customers where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findByfirstName(
		String firstName, int start, int end) {

		return findByfirstName(firstName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the blacklist customers where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findByfirstName(
		String firstName, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return findByfirstName(firstName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the blacklist customers where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findByfirstName(
		String firstName, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator,
		boolean useFinderCache) {

		firstName = Objects.toString(firstName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfirstName;
				finderArgs = new Object[] {firstName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfirstName;
			finderArgs = new Object[] {
				firstName, start, end, orderByComparator
			};
		}

		List<BlacklistCustomer> list = null;

		if (useFinderCache) {
			list = (List<BlacklistCustomer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BlacklistCustomer blacklistCustomer : list) {
					if (!firstName.equals(blacklistCustomer.getFirstName())) {
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

			sb.append(_SQL_SELECT_BLACKLISTCUSTOMER_WHERE);

			boolean bindFirstName = false;

			if (firstName.isEmpty()) {
				sb.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				sb.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BlacklistCustomerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFirstName) {
					queryPos.add(firstName);
				}

				list = (List<BlacklistCustomer>)QueryUtil.list(
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
	 * Returns the first blacklist customer in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer findByfirstName_First(
			String firstName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		BlacklistCustomer blacklistCustomer = fetchByfirstName_First(
			firstName, orderByComparator);

		if (blacklistCustomer != null) {
			return blacklistCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("firstName=");
		sb.append(firstName);

		sb.append("}");

		throw new NoSuchBlacklistCustomerException(sb.toString());
	}

	/**
	 * Returns the first blacklist customer in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer fetchByfirstName_First(
		String firstName,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		List<BlacklistCustomer> list = findByfirstName(
			firstName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last blacklist customer in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer findByfirstName_Last(
			String firstName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		BlacklistCustomer blacklistCustomer = fetchByfirstName_Last(
			firstName, orderByComparator);

		if (blacklistCustomer != null) {
			return blacklistCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("firstName=");
		sb.append(firstName);

		sb.append("}");

		throw new NoSuchBlacklistCustomerException(sb.toString());
	}

	/**
	 * Returns the last blacklist customer in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer fetchByfirstName_Last(
		String firstName,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		int count = countByfirstName(firstName);

		if (count == 0) {
			return null;
		}

		List<BlacklistCustomer> list = findByfirstName(
			firstName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where firstName = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	@Override
	public BlacklistCustomer[] findByfirstName_PrevAndNext(
			long blacklistCustomerId, String firstName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		firstName = Objects.toString(firstName, "");

		BlacklistCustomer blacklistCustomer = findByPrimaryKey(
			blacklistCustomerId);

		Session session = null;

		try {
			session = openSession();

			BlacklistCustomer[] array = new BlacklistCustomerImpl[3];

			array[0] = getByfirstName_PrevAndNext(
				session, blacklistCustomer, firstName, orderByComparator, true);

			array[1] = blacklistCustomer;

			array[2] = getByfirstName_PrevAndNext(
				session, blacklistCustomer, firstName, orderByComparator,
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

	protected BlacklistCustomer getByfirstName_PrevAndNext(
		Session session, BlacklistCustomer blacklistCustomer, String firstName,
		OrderByComparator<BlacklistCustomer> orderByComparator,
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

		sb.append(_SQL_SELECT_BLACKLISTCUSTOMER_WHERE);

		boolean bindFirstName = false;

		if (firstName.isEmpty()) {
			sb.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
		}
		else {
			bindFirstName = true;

			sb.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
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
			sb.append(BlacklistCustomerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindFirstName) {
			queryPos.add(firstName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						blacklistCustomer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BlacklistCustomer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the blacklist customers where firstName = &#63; from the database.
	 *
	 * @param firstName the first name
	 */
	@Override
	public void removeByfirstName(String firstName) {
		for (BlacklistCustomer blacklistCustomer :
				findByfirstName(
					firstName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(blacklistCustomer);
		}
	}

	/**
	 * Returns the number of blacklist customers where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the number of matching blacklist customers
	 */
	@Override
	public int countByfirstName(String firstName) {
		firstName = Objects.toString(firstName, "");

		FinderPath finderPath = _finderPathCountByfirstName;

		Object[] finderArgs = new Object[] {firstName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BLACKLISTCUSTOMER_WHERE);

			boolean bindFirstName = false;

			if (firstName.isEmpty()) {
				sb.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				sb.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFirstName) {
					queryPos.add(firstName);
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

	private static final String _FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2 =
		"blacklistCustomer.firstName = ?";

	private static final String _FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3 =
		"(blacklistCustomer.firstName IS NULL OR blacklistCustomer.firstName = '')";

	private FinderPath _finderPathWithPaginationFindBymiddleName;
	private FinderPath _finderPathWithoutPaginationFindBymiddleName;
	private FinderPath _finderPathCountBymiddleName;

	/**
	 * Returns all the blacklist customers where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @return the matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findBymiddleName(String middleName) {
		return findBymiddleName(
			middleName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the blacklist customers where middleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param middleName the middle name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findBymiddleName(
		String middleName, int start, int end) {

		return findBymiddleName(middleName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the blacklist customers where middleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param middleName the middle name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findBymiddleName(
		String middleName, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return findBymiddleName(
			middleName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the blacklist customers where middleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param middleName the middle name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findBymiddleName(
		String middleName, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator,
		boolean useFinderCache) {

		middleName = Objects.toString(middleName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBymiddleName;
				finderArgs = new Object[] {middleName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBymiddleName;
			finderArgs = new Object[] {
				middleName, start, end, orderByComparator
			};
		}

		List<BlacklistCustomer> list = null;

		if (useFinderCache) {
			list = (List<BlacklistCustomer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BlacklistCustomer blacklistCustomer : list) {
					if (!middleName.equals(blacklistCustomer.getMiddleName())) {
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

			sb.append(_SQL_SELECT_BLACKLISTCUSTOMER_WHERE);

			boolean bindMiddleName = false;

			if (middleName.isEmpty()) {
				sb.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_3);
			}
			else {
				bindMiddleName = true;

				sb.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BlacklistCustomerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMiddleName) {
					queryPos.add(middleName);
				}

				list = (List<BlacklistCustomer>)QueryUtil.list(
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
	 * Returns the first blacklist customer in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer findBymiddleName_First(
			String middleName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		BlacklistCustomer blacklistCustomer = fetchBymiddleName_First(
			middleName, orderByComparator);

		if (blacklistCustomer != null) {
			return blacklistCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("middleName=");
		sb.append(middleName);

		sb.append("}");

		throw new NoSuchBlacklistCustomerException(sb.toString());
	}

	/**
	 * Returns the first blacklist customer in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer fetchBymiddleName_First(
		String middleName,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		List<BlacklistCustomer> list = findBymiddleName(
			middleName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last blacklist customer in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer findBymiddleName_Last(
			String middleName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		BlacklistCustomer blacklistCustomer = fetchBymiddleName_Last(
			middleName, orderByComparator);

		if (blacklistCustomer != null) {
			return blacklistCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("middleName=");
		sb.append(middleName);

		sb.append("}");

		throw new NoSuchBlacklistCustomerException(sb.toString());
	}

	/**
	 * Returns the last blacklist customer in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer fetchBymiddleName_Last(
		String middleName,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		int count = countBymiddleName(middleName);

		if (count == 0) {
			return null;
		}

		List<BlacklistCustomer> list = findBymiddleName(
			middleName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where middleName = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	@Override
	public BlacklistCustomer[] findBymiddleName_PrevAndNext(
			long blacklistCustomerId, String middleName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		middleName = Objects.toString(middleName, "");

		BlacklistCustomer blacklistCustomer = findByPrimaryKey(
			blacklistCustomerId);

		Session session = null;

		try {
			session = openSession();

			BlacklistCustomer[] array = new BlacklistCustomerImpl[3];

			array[0] = getBymiddleName_PrevAndNext(
				session, blacklistCustomer, middleName, orderByComparator,
				true);

			array[1] = blacklistCustomer;

			array[2] = getBymiddleName_PrevAndNext(
				session, blacklistCustomer, middleName, orderByComparator,
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

	protected BlacklistCustomer getBymiddleName_PrevAndNext(
		Session session, BlacklistCustomer blacklistCustomer, String middleName,
		OrderByComparator<BlacklistCustomer> orderByComparator,
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

		sb.append(_SQL_SELECT_BLACKLISTCUSTOMER_WHERE);

		boolean bindMiddleName = false;

		if (middleName.isEmpty()) {
			sb.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_3);
		}
		else {
			bindMiddleName = true;

			sb.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_2);
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
			sb.append(BlacklistCustomerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindMiddleName) {
			queryPos.add(middleName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						blacklistCustomer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BlacklistCustomer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the blacklist customers where middleName = &#63; from the database.
	 *
	 * @param middleName the middle name
	 */
	@Override
	public void removeBymiddleName(String middleName) {
		for (BlacklistCustomer blacklistCustomer :
				findBymiddleName(
					middleName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(blacklistCustomer);
		}
	}

	/**
	 * Returns the number of blacklist customers where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @return the number of matching blacklist customers
	 */
	@Override
	public int countBymiddleName(String middleName) {
		middleName = Objects.toString(middleName, "");

		FinderPath finderPath = _finderPathCountBymiddleName;

		Object[] finderArgs = new Object[] {middleName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BLACKLISTCUSTOMER_WHERE);

			boolean bindMiddleName = false;

			if (middleName.isEmpty()) {
				sb.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_3);
			}
			else {
				bindMiddleName = true;

				sb.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMiddleName) {
					queryPos.add(middleName);
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

	private static final String _FINDER_COLUMN_MIDDLENAME_MIDDLENAME_2 =
		"blacklistCustomer.middleName = ?";

	private static final String _FINDER_COLUMN_MIDDLENAME_MIDDLENAME_3 =
		"(blacklistCustomer.middleName IS NULL OR blacklistCustomer.middleName = '')";

	private FinderPath _finderPathWithPaginationFindBylastName;
	private FinderPath _finderPathWithoutPaginationFindBylastName;
	private FinderPath _finderPathCountBylastName;

	/**
	 * Returns all the blacklist customers where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findBylastName(String lastName) {
		return findBylastName(
			lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the blacklist customers where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findBylastName(
		String lastName, int start, int end) {

		return findBylastName(lastName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the blacklist customers where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findBylastName(
		String lastName, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return findBylastName(lastName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the blacklist customers where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findBylastName(
		String lastName, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator,
		boolean useFinderCache) {

		lastName = Objects.toString(lastName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBylastName;
				finderArgs = new Object[] {lastName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBylastName;
			finderArgs = new Object[] {lastName, start, end, orderByComparator};
		}

		List<BlacklistCustomer> list = null;

		if (useFinderCache) {
			list = (List<BlacklistCustomer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BlacklistCustomer blacklistCustomer : list) {
					if (!lastName.equals(blacklistCustomer.getLastName())) {
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

			sb.append(_SQL_SELECT_BLACKLISTCUSTOMER_WHERE);

			boolean bindLastName = false;

			if (lastName.isEmpty()) {
				sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BlacklistCustomerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLastName) {
					queryPos.add(lastName);
				}

				list = (List<BlacklistCustomer>)QueryUtil.list(
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
	 * Returns the first blacklist customer in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer findBylastName_First(
			String lastName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		BlacklistCustomer blacklistCustomer = fetchBylastName_First(
			lastName, orderByComparator);

		if (blacklistCustomer != null) {
			return blacklistCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lastName=");
		sb.append(lastName);

		sb.append("}");

		throw new NoSuchBlacklistCustomerException(sb.toString());
	}

	/**
	 * Returns the first blacklist customer in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer fetchBylastName_First(
		String lastName,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		List<BlacklistCustomer> list = findBylastName(
			lastName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last blacklist customer in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer findBylastName_Last(
			String lastName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		BlacklistCustomer blacklistCustomer = fetchBylastName_Last(
			lastName, orderByComparator);

		if (blacklistCustomer != null) {
			return blacklistCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lastName=");
		sb.append(lastName);

		sb.append("}");

		throw new NoSuchBlacklistCustomerException(sb.toString());
	}

	/**
	 * Returns the last blacklist customer in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer fetchBylastName_Last(
		String lastName,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		int count = countBylastName(lastName);

		if (count == 0) {
			return null;
		}

		List<BlacklistCustomer> list = findBylastName(
			lastName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where lastName = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	@Override
	public BlacklistCustomer[] findBylastName_PrevAndNext(
			long blacklistCustomerId, String lastName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		lastName = Objects.toString(lastName, "");

		BlacklistCustomer blacklistCustomer = findByPrimaryKey(
			blacklistCustomerId);

		Session session = null;

		try {
			session = openSession();

			BlacklistCustomer[] array = new BlacklistCustomerImpl[3];

			array[0] = getBylastName_PrevAndNext(
				session, blacklistCustomer, lastName, orderByComparator, true);

			array[1] = blacklistCustomer;

			array[2] = getBylastName_PrevAndNext(
				session, blacklistCustomer, lastName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BlacklistCustomer getBylastName_PrevAndNext(
		Session session, BlacklistCustomer blacklistCustomer, String lastName,
		OrderByComparator<BlacklistCustomer> orderByComparator,
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

		sb.append(_SQL_SELECT_BLACKLISTCUSTOMER_WHERE);

		boolean bindLastName = false;

		if (lastName.isEmpty()) {
			sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
		}
		else {
			bindLastName = true;

			sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
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
			sb.append(BlacklistCustomerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindLastName) {
			queryPos.add(lastName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						blacklistCustomer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BlacklistCustomer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the blacklist customers where lastName = &#63; from the database.
	 *
	 * @param lastName the last name
	 */
	@Override
	public void removeBylastName(String lastName) {
		for (BlacklistCustomer blacklistCustomer :
				findBylastName(
					lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(blacklistCustomer);
		}
	}

	/**
	 * Returns the number of blacklist customers where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the number of matching blacklist customers
	 */
	@Override
	public int countBylastName(String lastName) {
		lastName = Objects.toString(lastName, "");

		FinderPath finderPath = _finderPathCountBylastName;

		Object[] finderArgs = new Object[] {lastName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BLACKLISTCUSTOMER_WHERE);

			boolean bindLastName = false;

			if (lastName.isEmpty()) {
				sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLastName) {
					queryPos.add(lastName);
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

	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_2 =
		"blacklistCustomer.lastName = ?";

	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_3 =
		"(blacklistCustomer.lastName IS NULL OR blacklistCustomer.lastName = '')";

	private FinderPath _finderPathWithPaginationFindByktp;
	private FinderPath _finderPathWithoutPaginationFindByktp;
	private FinderPath _finderPathCountByktp;

	/**
	 * Returns all the blacklist customers where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @return the matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findByktp(String ktp) {
		return findByktp(ktp, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the blacklist customers where ktp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param ktp the ktp
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findByktp(String ktp, int start, int end) {
		return findByktp(ktp, start, end, null);
	}

	/**
	 * Returns an ordered range of all the blacklist customers where ktp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param ktp the ktp
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findByktp(
		String ktp, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return findByktp(ktp, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the blacklist customers where ktp = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param ktp the ktp
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findByktp(
		String ktp, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator,
		boolean useFinderCache) {

		ktp = Objects.toString(ktp, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByktp;
				finderArgs = new Object[] {ktp};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByktp;
			finderArgs = new Object[] {ktp, start, end, orderByComparator};
		}

		List<BlacklistCustomer> list = null;

		if (useFinderCache) {
			list = (List<BlacklistCustomer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BlacklistCustomer blacklistCustomer : list) {
					if (!ktp.equals(blacklistCustomer.getKtp())) {
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

			sb.append(_SQL_SELECT_BLACKLISTCUSTOMER_WHERE);

			boolean bindKtp = false;

			if (ktp.isEmpty()) {
				sb.append(_FINDER_COLUMN_KTP_KTP_3);
			}
			else {
				bindKtp = true;

				sb.append(_FINDER_COLUMN_KTP_KTP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BlacklistCustomerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindKtp) {
					queryPos.add(ktp);
				}

				list = (List<BlacklistCustomer>)QueryUtil.list(
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
	 * Returns the first blacklist customer in the ordered set where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer findByktp_First(
			String ktp, OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		BlacklistCustomer blacklistCustomer = fetchByktp_First(
			ktp, orderByComparator);

		if (blacklistCustomer != null) {
			return blacklistCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ktp=");
		sb.append(ktp);

		sb.append("}");

		throw new NoSuchBlacklistCustomerException(sb.toString());
	}

	/**
	 * Returns the first blacklist customer in the ordered set where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer fetchByktp_First(
		String ktp, OrderByComparator<BlacklistCustomer> orderByComparator) {

		List<BlacklistCustomer> list = findByktp(ktp, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last blacklist customer in the ordered set where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer findByktp_Last(
			String ktp, OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		BlacklistCustomer blacklistCustomer = fetchByktp_Last(
			ktp, orderByComparator);

		if (blacklistCustomer != null) {
			return blacklistCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ktp=");
		sb.append(ktp);

		sb.append("}");

		throw new NoSuchBlacklistCustomerException(sb.toString());
	}

	/**
	 * Returns the last blacklist customer in the ordered set where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer fetchByktp_Last(
		String ktp, OrderByComparator<BlacklistCustomer> orderByComparator) {

		int count = countByktp(ktp);

		if (count == 0) {
			return null;
		}

		List<BlacklistCustomer> list = findByktp(
			ktp, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where ktp = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param ktp the ktp
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	@Override
	public BlacklistCustomer[] findByktp_PrevAndNext(
			long blacklistCustomerId, String ktp,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		ktp = Objects.toString(ktp, "");

		BlacklistCustomer blacklistCustomer = findByPrimaryKey(
			blacklistCustomerId);

		Session session = null;

		try {
			session = openSession();

			BlacklistCustomer[] array = new BlacklistCustomerImpl[3];

			array[0] = getByktp_PrevAndNext(
				session, blacklistCustomer, ktp, orderByComparator, true);

			array[1] = blacklistCustomer;

			array[2] = getByktp_PrevAndNext(
				session, blacklistCustomer, ktp, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BlacklistCustomer getByktp_PrevAndNext(
		Session session, BlacklistCustomer blacklistCustomer, String ktp,
		OrderByComparator<BlacklistCustomer> orderByComparator,
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

		sb.append(_SQL_SELECT_BLACKLISTCUSTOMER_WHERE);

		boolean bindKtp = false;

		if (ktp.isEmpty()) {
			sb.append(_FINDER_COLUMN_KTP_KTP_3);
		}
		else {
			bindKtp = true;

			sb.append(_FINDER_COLUMN_KTP_KTP_2);
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
			sb.append(BlacklistCustomerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindKtp) {
			queryPos.add(ktp);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						blacklistCustomer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BlacklistCustomer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the blacklist customers where ktp = &#63; from the database.
	 *
	 * @param ktp the ktp
	 */
	@Override
	public void removeByktp(String ktp) {
		for (BlacklistCustomer blacklistCustomer :
				findByktp(ktp, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(blacklistCustomer);
		}
	}

	/**
	 * Returns the number of blacklist customers where ktp = &#63;.
	 *
	 * @param ktp the ktp
	 * @return the number of matching blacklist customers
	 */
	@Override
	public int countByktp(String ktp) {
		ktp = Objects.toString(ktp, "");

		FinderPath finderPath = _finderPathCountByktp;

		Object[] finderArgs = new Object[] {ktp};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BLACKLISTCUSTOMER_WHERE);

			boolean bindKtp = false;

			if (ktp.isEmpty()) {
				sb.append(_FINDER_COLUMN_KTP_KTP_3);
			}
			else {
				bindKtp = true;

				sb.append(_FINDER_COLUMN_KTP_KTP_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindKtp) {
					queryPos.add(ktp);
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

	private static final String _FINDER_COLUMN_KTP_KTP_2 =
		"blacklistCustomer.ktp = ?";

	private static final String _FINDER_COLUMN_KTP_KTP_3 =
		"(blacklistCustomer.ktp IS NULL OR blacklistCustomer.ktp = '')";

	private FinderPath _finderPathWithPaginationFindBykitas;
	private FinderPath _finderPathWithoutPaginationFindBykitas;
	private FinderPath _finderPathCountBykitas;

	/**
	 * Returns all the blacklist customers where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @return the matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findBykitas(String kitas) {
		return findBykitas(kitas, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the blacklist customers where kitas = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param kitas the kitas
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findBykitas(
		String kitas, int start, int end) {

		return findBykitas(kitas, start, end, null);
	}

	/**
	 * Returns an ordered range of all the blacklist customers where kitas = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param kitas the kitas
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findBykitas(
		String kitas, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return findBykitas(kitas, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the blacklist customers where kitas = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param kitas the kitas
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findBykitas(
		String kitas, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator,
		boolean useFinderCache) {

		kitas = Objects.toString(kitas, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBykitas;
				finderArgs = new Object[] {kitas};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBykitas;
			finderArgs = new Object[] {kitas, start, end, orderByComparator};
		}

		List<BlacklistCustomer> list = null;

		if (useFinderCache) {
			list = (List<BlacklistCustomer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BlacklistCustomer blacklistCustomer : list) {
					if (!kitas.equals(blacklistCustomer.getKitas())) {
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

			sb.append(_SQL_SELECT_BLACKLISTCUSTOMER_WHERE);

			boolean bindKitas = false;

			if (kitas.isEmpty()) {
				sb.append(_FINDER_COLUMN_KITAS_KITAS_3);
			}
			else {
				bindKitas = true;

				sb.append(_FINDER_COLUMN_KITAS_KITAS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BlacklistCustomerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindKitas) {
					queryPos.add(kitas);
				}

				list = (List<BlacklistCustomer>)QueryUtil.list(
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
	 * Returns the first blacklist customer in the ordered set where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer findBykitas_First(
			String kitas,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		BlacklistCustomer blacklistCustomer = fetchBykitas_First(
			kitas, orderByComparator);

		if (blacklistCustomer != null) {
			return blacklistCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("kitas=");
		sb.append(kitas);

		sb.append("}");

		throw new NoSuchBlacklistCustomerException(sb.toString());
	}

	/**
	 * Returns the first blacklist customer in the ordered set where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer fetchBykitas_First(
		String kitas, OrderByComparator<BlacklistCustomer> orderByComparator) {

		List<BlacklistCustomer> list = findBykitas(
			kitas, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last blacklist customer in the ordered set where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer findBykitas_Last(
			String kitas,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		BlacklistCustomer blacklistCustomer = fetchBykitas_Last(
			kitas, orderByComparator);

		if (blacklistCustomer != null) {
			return blacklistCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("kitas=");
		sb.append(kitas);

		sb.append("}");

		throw new NoSuchBlacklistCustomerException(sb.toString());
	}

	/**
	 * Returns the last blacklist customer in the ordered set where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer fetchBykitas_Last(
		String kitas, OrderByComparator<BlacklistCustomer> orderByComparator) {

		int count = countBykitas(kitas);

		if (count == 0) {
			return null;
		}

		List<BlacklistCustomer> list = findBykitas(
			kitas, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where kitas = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param kitas the kitas
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	@Override
	public BlacklistCustomer[] findBykitas_PrevAndNext(
			long blacklistCustomerId, String kitas,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		kitas = Objects.toString(kitas, "");

		BlacklistCustomer blacklistCustomer = findByPrimaryKey(
			blacklistCustomerId);

		Session session = null;

		try {
			session = openSession();

			BlacklistCustomer[] array = new BlacklistCustomerImpl[3];

			array[0] = getBykitas_PrevAndNext(
				session, blacklistCustomer, kitas, orderByComparator, true);

			array[1] = blacklistCustomer;

			array[2] = getBykitas_PrevAndNext(
				session, blacklistCustomer, kitas, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BlacklistCustomer getBykitas_PrevAndNext(
		Session session, BlacklistCustomer blacklistCustomer, String kitas,
		OrderByComparator<BlacklistCustomer> orderByComparator,
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

		sb.append(_SQL_SELECT_BLACKLISTCUSTOMER_WHERE);

		boolean bindKitas = false;

		if (kitas.isEmpty()) {
			sb.append(_FINDER_COLUMN_KITAS_KITAS_3);
		}
		else {
			bindKitas = true;

			sb.append(_FINDER_COLUMN_KITAS_KITAS_2);
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
			sb.append(BlacklistCustomerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindKitas) {
			queryPos.add(kitas);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						blacklistCustomer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BlacklistCustomer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the blacklist customers where kitas = &#63; from the database.
	 *
	 * @param kitas the kitas
	 */
	@Override
	public void removeBykitas(String kitas) {
		for (BlacklistCustomer blacklistCustomer :
				findBykitas(
					kitas, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(blacklistCustomer);
		}
	}

	/**
	 * Returns the number of blacklist customers where kitas = &#63;.
	 *
	 * @param kitas the kitas
	 * @return the number of matching blacklist customers
	 */
	@Override
	public int countBykitas(String kitas) {
		kitas = Objects.toString(kitas, "");

		FinderPath finderPath = _finderPathCountBykitas;

		Object[] finderArgs = new Object[] {kitas};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BLACKLISTCUSTOMER_WHERE);

			boolean bindKitas = false;

			if (kitas.isEmpty()) {
				sb.append(_FINDER_COLUMN_KITAS_KITAS_3);
			}
			else {
				bindKitas = true;

				sb.append(_FINDER_COLUMN_KITAS_KITAS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindKitas) {
					queryPos.add(kitas);
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

	private static final String _FINDER_COLUMN_KITAS_KITAS_2 =
		"blacklistCustomer.kitas = ?";

	private static final String _FINDER_COLUMN_KITAS_KITAS_3 =
		"(blacklistCustomer.kitas IS NULL OR blacklistCustomer.kitas = '')";

	private FinderPath _finderPathWithPaginationFindByemail;
	private FinderPath _finderPathWithoutPaginationFindByemail;
	private FinderPath _finderPathCountByemail;

	/**
	 * Returns all the blacklist customers where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findByemail(String email) {
		return findByemail(email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the blacklist customers where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findByemail(
		String email, int start, int end) {

		return findByemail(email, start, end, null);
	}

	/**
	 * Returns an ordered range of all the blacklist customers where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findByemail(
		String email, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return findByemail(email, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the blacklist customers where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findByemail(
		String email, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator,
		boolean useFinderCache) {

		email = Objects.toString(email, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByemail;
				finderArgs = new Object[] {email};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByemail;
			finderArgs = new Object[] {email, start, end, orderByComparator};
		}

		List<BlacklistCustomer> list = null;

		if (useFinderCache) {
			list = (List<BlacklistCustomer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BlacklistCustomer blacklistCustomer : list) {
					if (!email.equals(blacklistCustomer.getEmail())) {
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

			sb.append(_SQL_SELECT_BLACKLISTCUSTOMER_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BlacklistCustomerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
				}

				list = (List<BlacklistCustomer>)QueryUtil.list(
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
	 * Returns the first blacklist customer in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer findByemail_First(
			String email,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		BlacklistCustomer blacklistCustomer = fetchByemail_First(
			email, orderByComparator);

		if (blacklistCustomer != null) {
			return blacklistCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("email=");
		sb.append(email);

		sb.append("}");

		throw new NoSuchBlacklistCustomerException(sb.toString());
	}

	/**
	 * Returns the first blacklist customer in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer fetchByemail_First(
		String email, OrderByComparator<BlacklistCustomer> orderByComparator) {

		List<BlacklistCustomer> list = findByemail(
			email, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last blacklist customer in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer findByemail_Last(
			String email,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		BlacklistCustomer blacklistCustomer = fetchByemail_Last(
			email, orderByComparator);

		if (blacklistCustomer != null) {
			return blacklistCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("email=");
		sb.append(email);

		sb.append("}");

		throw new NoSuchBlacklistCustomerException(sb.toString());
	}

	/**
	 * Returns the last blacklist customer in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer fetchByemail_Last(
		String email, OrderByComparator<BlacklistCustomer> orderByComparator) {

		int count = countByemail(email);

		if (count == 0) {
			return null;
		}

		List<BlacklistCustomer> list = findByemail(
			email, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where email = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	@Override
	public BlacklistCustomer[] findByemail_PrevAndNext(
			long blacklistCustomerId, String email,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		email = Objects.toString(email, "");

		BlacklistCustomer blacklistCustomer = findByPrimaryKey(
			blacklistCustomerId);

		Session session = null;

		try {
			session = openSession();

			BlacklistCustomer[] array = new BlacklistCustomerImpl[3];

			array[0] = getByemail_PrevAndNext(
				session, blacklistCustomer, email, orderByComparator, true);

			array[1] = blacklistCustomer;

			array[2] = getByemail_PrevAndNext(
				session, blacklistCustomer, email, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BlacklistCustomer getByemail_PrevAndNext(
		Session session, BlacklistCustomer blacklistCustomer, String email,
		OrderByComparator<BlacklistCustomer> orderByComparator,
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

		sb.append(_SQL_SELECT_BLACKLISTCUSTOMER_WHERE);

		boolean bindEmail = false;

		if (email.isEmpty()) {
			sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
		}
		else {
			bindEmail = true;

			sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
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
			sb.append(BlacklistCustomerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEmail) {
			queryPos.add(email);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						blacklistCustomer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BlacklistCustomer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the blacklist customers where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	@Override
	public void removeByemail(String email) {
		for (BlacklistCustomer blacklistCustomer :
				findByemail(
					email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(blacklistCustomer);
		}
	}

	/**
	 * Returns the number of blacklist customers where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching blacklist customers
	 */
	@Override
	public int countByemail(String email) {
		email = Objects.toString(email, "");

		FinderPath finderPath = _finderPathCountByemail;

		Object[] finderArgs = new Object[] {email};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BLACKLISTCUSTOMER_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
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

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 =
		"blacklistCustomer.email = ?";

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 =
		"(blacklistCustomer.email IS NULL OR blacklistCustomer.email = '')";

	private FinderPath _finderPathWithPaginationFindByfullName;
	private FinderPath _finderPathWithoutPaginationFindByfullName;
	private FinderPath _finderPathCountByfullName;

	/**
	 * Returns all the blacklist customers where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findByfullName(String fullName) {
		return findByfullName(
			fullName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the blacklist customers where fullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findByfullName(
		String fullName, int start, int end) {

		return findByfullName(fullName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the blacklist customers where fullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findByfullName(
		String fullName, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return findByfullName(fullName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the blacklist customers where fullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findByfullName(
		String fullName, int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator,
		boolean useFinderCache) {

		fullName = Objects.toString(fullName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfullName;
				finderArgs = new Object[] {fullName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfullName;
			finderArgs = new Object[] {fullName, start, end, orderByComparator};
		}

		List<BlacklistCustomer> list = null;

		if (useFinderCache) {
			list = (List<BlacklistCustomer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BlacklistCustomer blacklistCustomer : list) {
					if (!fullName.equals(blacklistCustomer.getFullName())) {
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

			sb.append(_SQL_SELECT_BLACKLISTCUSTOMER_WHERE);

			boolean bindFullName = false;

			if (fullName.isEmpty()) {
				sb.append(_FINDER_COLUMN_FULLNAME_FULLNAME_3);
			}
			else {
				bindFullName = true;

				sb.append(_FINDER_COLUMN_FULLNAME_FULLNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BlacklistCustomerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFullName) {
					queryPos.add(fullName);
				}

				list = (List<BlacklistCustomer>)QueryUtil.list(
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
	 * Returns the first blacklist customer in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer findByfullName_First(
			String fullName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		BlacklistCustomer blacklistCustomer = fetchByfullName_First(
			fullName, orderByComparator);

		if (blacklistCustomer != null) {
			return blacklistCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fullName=");
		sb.append(fullName);

		sb.append("}");

		throw new NoSuchBlacklistCustomerException(sb.toString());
	}

	/**
	 * Returns the first blacklist customer in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer fetchByfullName_First(
		String fullName,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		List<BlacklistCustomer> list = findByfullName(
			fullName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last blacklist customer in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer findByfullName_Last(
			String fullName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		BlacklistCustomer blacklistCustomer = fetchByfullName_Last(
			fullName, orderByComparator);

		if (blacklistCustomer != null) {
			return blacklistCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fullName=");
		sb.append(fullName);

		sb.append("}");

		throw new NoSuchBlacklistCustomerException(sb.toString());
	}

	/**
	 * Returns the last blacklist customer in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blacklist customer, or <code>null</code> if a matching blacklist customer could not be found
	 */
	@Override
	public BlacklistCustomer fetchByfullName_Last(
		String fullName,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		int count = countByfullName(fullName);

		if (count == 0) {
			return null;
		}

		List<BlacklistCustomer> list = findByfullName(
			fullName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the blacklist customers before and after the current blacklist customer in the ordered set where fullName = &#63;.
	 *
	 * @param blacklistCustomerId the primary key of the current blacklist customer
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	@Override
	public BlacklistCustomer[] findByfullName_PrevAndNext(
			long blacklistCustomerId, String fullName,
			OrderByComparator<BlacklistCustomer> orderByComparator)
		throws NoSuchBlacklistCustomerException {

		fullName = Objects.toString(fullName, "");

		BlacklistCustomer blacklistCustomer = findByPrimaryKey(
			blacklistCustomerId);

		Session session = null;

		try {
			session = openSession();

			BlacklistCustomer[] array = new BlacklistCustomerImpl[3];

			array[0] = getByfullName_PrevAndNext(
				session, blacklistCustomer, fullName, orderByComparator, true);

			array[1] = blacklistCustomer;

			array[2] = getByfullName_PrevAndNext(
				session, blacklistCustomer, fullName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BlacklistCustomer getByfullName_PrevAndNext(
		Session session, BlacklistCustomer blacklistCustomer, String fullName,
		OrderByComparator<BlacklistCustomer> orderByComparator,
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

		sb.append(_SQL_SELECT_BLACKLISTCUSTOMER_WHERE);

		boolean bindFullName = false;

		if (fullName.isEmpty()) {
			sb.append(_FINDER_COLUMN_FULLNAME_FULLNAME_3);
		}
		else {
			bindFullName = true;

			sb.append(_FINDER_COLUMN_FULLNAME_FULLNAME_2);
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
			sb.append(BlacklistCustomerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindFullName) {
			queryPos.add(fullName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						blacklistCustomer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BlacklistCustomer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the blacklist customers where fullName = &#63; from the database.
	 *
	 * @param fullName the full name
	 */
	@Override
	public void removeByfullName(String fullName) {
		for (BlacklistCustomer blacklistCustomer :
				findByfullName(
					fullName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(blacklistCustomer);
		}
	}

	/**
	 * Returns the number of blacklist customers where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the number of matching blacklist customers
	 */
	@Override
	public int countByfullName(String fullName) {
		fullName = Objects.toString(fullName, "");

		FinderPath finderPath = _finderPathCountByfullName;

		Object[] finderArgs = new Object[] {fullName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BLACKLISTCUSTOMER_WHERE);

			boolean bindFullName = false;

			if (fullName.isEmpty()) {
				sb.append(_FINDER_COLUMN_FULLNAME_FULLNAME_3);
			}
			else {
				bindFullName = true;

				sb.append(_FINDER_COLUMN_FULLNAME_FULLNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFullName) {
					queryPos.add(fullName);
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

	private static final String _FINDER_COLUMN_FULLNAME_FULLNAME_2 =
		"blacklistCustomer.fullName = ?";

	private static final String _FINDER_COLUMN_FULLNAME_FULLNAME_3 =
		"(blacklistCustomer.fullName IS NULL OR blacklistCustomer.fullName = '')";

	public BlacklistCustomerPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(BlacklistCustomer.class);

		setModelImplClass(BlacklistCustomerImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the blacklist customer in the entity cache if it is enabled.
	 *
	 * @param blacklistCustomer the blacklist customer
	 */
	@Override
	public void cacheResult(BlacklistCustomer blacklistCustomer) {
		entityCache.putResult(
			BlacklistCustomerImpl.class, blacklistCustomer.getPrimaryKey(),
			blacklistCustomer);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the blacklist customers in the entity cache if it is enabled.
	 *
	 * @param blacklistCustomers the blacklist customers
	 */
	@Override
	public void cacheResult(List<BlacklistCustomer> blacklistCustomers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (blacklistCustomers.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BlacklistCustomer blacklistCustomer : blacklistCustomers) {
			if (entityCache.getResult(
					BlacklistCustomerImpl.class,
					blacklistCustomer.getPrimaryKey()) == null) {

				cacheResult(blacklistCustomer);
			}
		}
	}

	/**
	 * Clears the cache for all blacklist customers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BlacklistCustomerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the blacklist customer.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BlacklistCustomer blacklistCustomer) {
		entityCache.removeResult(
			BlacklistCustomerImpl.class, blacklistCustomer);
	}

	@Override
	public void clearCache(List<BlacklistCustomer> blacklistCustomers) {
		for (BlacklistCustomer blacklistCustomer : blacklistCustomers) {
			entityCache.removeResult(
				BlacklistCustomerImpl.class, blacklistCustomer);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BlacklistCustomerImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new blacklist customer with the primary key. Does not add the blacklist customer to the database.
	 *
	 * @param blacklistCustomerId the primary key for the new blacklist customer
	 * @return the new blacklist customer
	 */
	@Override
	public BlacklistCustomer create(long blacklistCustomerId) {
		BlacklistCustomer blacklistCustomer = new BlacklistCustomerImpl();

		blacklistCustomer.setNew(true);
		blacklistCustomer.setPrimaryKey(blacklistCustomerId);

		blacklistCustomer.setCompanyId(CompanyThreadLocal.getCompanyId());

		return blacklistCustomer;
	}

	/**
	 * Removes the blacklist customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param blacklistCustomerId the primary key of the blacklist customer
	 * @return the blacklist customer that was removed
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	@Override
	public BlacklistCustomer remove(long blacklistCustomerId)
		throws NoSuchBlacklistCustomerException {

		return remove((Serializable)blacklistCustomerId);
	}

	/**
	 * Removes the blacklist customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the blacklist customer
	 * @return the blacklist customer that was removed
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	@Override
	public BlacklistCustomer remove(Serializable primaryKey)
		throws NoSuchBlacklistCustomerException {

		Session session = null;

		try {
			session = openSession();

			BlacklistCustomer blacklistCustomer =
				(BlacklistCustomer)session.get(
					BlacklistCustomerImpl.class, primaryKey);

			if (blacklistCustomer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBlacklistCustomerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(blacklistCustomer);
		}
		catch (NoSuchBlacklistCustomerException noSuchEntityException) {
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
	protected BlacklistCustomer removeImpl(
		BlacklistCustomer blacklistCustomer) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(blacklistCustomer)) {
				blacklistCustomer = (BlacklistCustomer)session.get(
					BlacklistCustomerImpl.class,
					blacklistCustomer.getPrimaryKeyObj());
			}

			if (blacklistCustomer != null) {
				session.delete(blacklistCustomer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (blacklistCustomer != null) {
			clearCache(blacklistCustomer);
		}

		return blacklistCustomer;
	}

	@Override
	public BlacklistCustomer updateImpl(BlacklistCustomer blacklistCustomer) {
		boolean isNew = blacklistCustomer.isNew();

		if (!(blacklistCustomer instanceof BlacklistCustomerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(blacklistCustomer.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					blacklistCustomer);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in blacklistCustomer proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BlacklistCustomer implementation " +
					blacklistCustomer.getClass());
		}

		BlacklistCustomerModelImpl blacklistCustomerModelImpl =
			(BlacklistCustomerModelImpl)blacklistCustomer;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (blacklistCustomer.getCreateDate() == null)) {
			if (serviceContext == null) {
				blacklistCustomer.setCreateDate(date);
			}
			else {
				blacklistCustomer.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!blacklistCustomerModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				blacklistCustomer.setModifiedDate(date);
			}
			else {
				blacklistCustomer.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(blacklistCustomer);
			}
			else {
				blacklistCustomer = (BlacklistCustomer)session.merge(
					blacklistCustomer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BlacklistCustomerImpl.class, blacklistCustomerModelImpl, false,
			true);

		if (isNew) {
			blacklistCustomer.setNew(false);
		}

		blacklistCustomer.resetOriginalValues();

		return blacklistCustomer;
	}

	/**
	 * Returns the blacklist customer with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the blacklist customer
	 * @return the blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	@Override
	public BlacklistCustomer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBlacklistCustomerException {

		BlacklistCustomer blacklistCustomer = fetchByPrimaryKey(primaryKey);

		if (blacklistCustomer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBlacklistCustomerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return blacklistCustomer;
	}

	/**
	 * Returns the blacklist customer with the primary key or throws a <code>NoSuchBlacklistCustomerException</code> if it could not be found.
	 *
	 * @param blacklistCustomerId the primary key of the blacklist customer
	 * @return the blacklist customer
	 * @throws NoSuchBlacklistCustomerException if a blacklist customer with the primary key could not be found
	 */
	@Override
	public BlacklistCustomer findByPrimaryKey(long blacklistCustomerId)
		throws NoSuchBlacklistCustomerException {

		return findByPrimaryKey((Serializable)blacklistCustomerId);
	}

	/**
	 * Returns the blacklist customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param blacklistCustomerId the primary key of the blacklist customer
	 * @return the blacklist customer, or <code>null</code> if a blacklist customer with the primary key could not be found
	 */
	@Override
	public BlacklistCustomer fetchByPrimaryKey(long blacklistCustomerId) {
		return fetchByPrimaryKey((Serializable)blacklistCustomerId);
	}

	/**
	 * Returns all the blacklist customers.
	 *
	 * @return the blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the blacklist customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @return the range of blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the blacklist customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findAll(
		int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the blacklist customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlacklistCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blacklist customers
	 * @param end the upper bound of the range of blacklist customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of blacklist customers
	 */
	@Override
	public List<BlacklistCustomer> findAll(
		int start, int end,
		OrderByComparator<BlacklistCustomer> orderByComparator,
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

		List<BlacklistCustomer> list = null;

		if (useFinderCache) {
			list = (List<BlacklistCustomer>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BLACKLISTCUSTOMER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BLACKLISTCUSTOMER;

				sql = sql.concat(BlacklistCustomerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BlacklistCustomer>)QueryUtil.list(
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
	 * Removes all the blacklist customers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BlacklistCustomer blacklistCustomer : findAll()) {
			remove(blacklistCustomer);
		}
	}

	/**
	 * Returns the number of blacklist customers.
	 *
	 * @return the number of blacklist customers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BLACKLISTCUSTOMER);

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
		return "blacklistCustomerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BLACKLISTCUSTOMER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BlacklistCustomerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the blacklist customer persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new BlacklistCustomerModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", BlacklistCustomer.class.getName()));

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

		_finderPathWithPaginationFindByfirstName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfirstName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"firstName"}, true);

		_finderPathWithoutPaginationFindByfirstName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfirstName",
			new String[] {String.class.getName()}, new String[] {"firstName"},
			true);

		_finderPathCountByfirstName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfirstName",
			new String[] {String.class.getName()}, new String[] {"firstName"},
			false);

		_finderPathWithPaginationFindBymiddleName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymiddleName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"middleName"}, true);

		_finderPathWithoutPaginationFindBymiddleName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymiddleName",
			new String[] {String.class.getName()}, new String[] {"middleName"},
			true);

		_finderPathCountBymiddleName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymiddleName",
			new String[] {String.class.getName()}, new String[] {"middleName"},
			false);

		_finderPathWithPaginationFindBylastName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylastName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"lastName"}, true);

		_finderPathWithoutPaginationFindBylastName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylastName",
			new String[] {String.class.getName()}, new String[] {"lastName"},
			true);

		_finderPathCountBylastName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylastName",
			new String[] {String.class.getName()}, new String[] {"lastName"},
			false);

		_finderPathWithPaginationFindByktp = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByktp",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ktp"}, true);

		_finderPathWithoutPaginationFindByktp = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByktp",
			new String[] {String.class.getName()}, new String[] {"ktp"}, true);

		_finderPathCountByktp = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByktp",
			new String[] {String.class.getName()}, new String[] {"ktp"}, false);

		_finderPathWithPaginationFindBykitas = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBykitas",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"kitas"}, true);

		_finderPathWithoutPaginationFindBykitas = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBykitas",
			new String[] {String.class.getName()}, new String[] {"kitas"},
			true);

		_finderPathCountBykitas = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBykitas",
			new String[] {String.class.getName()}, new String[] {"kitas"},
			false);

		_finderPathWithPaginationFindByemail = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemail",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"email"}, true);

		_finderPathWithoutPaginationFindByemail = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemail",
			new String[] {String.class.getName()}, new String[] {"email"},
			true);

		_finderPathCountByemail = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemail",
			new String[] {String.class.getName()}, new String[] {"email"},
			false);

		_finderPathWithPaginationFindByfullName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfullName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"fullName"}, true);

		_finderPathWithoutPaginationFindByfullName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfullName",
			new String[] {String.class.getName()}, new String[] {"fullName"},
			true);

		_finderPathCountByfullName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfullName",
			new String[] {String.class.getName()}, new String[] {"fullName"},
			false);

		_setBlacklistCustomerUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBlacklistCustomerUtilPersistence(null);

		entityCache.removeCache(BlacklistCustomerImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setBlacklistCustomerUtilPersistence(
		BlacklistCustomerPersistence blacklistCustomerPersistence) {

		try {
			Field field = BlacklistCustomerUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, blacklistCustomerPersistence);
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

	private static final String _SQL_SELECT_BLACKLISTCUSTOMER =
		"SELECT blacklistCustomer FROM BlacklistCustomer blacklistCustomer";

	private static final String _SQL_SELECT_BLACKLISTCUSTOMER_WHERE =
		"SELECT blacklistCustomer FROM BlacklistCustomer blacklistCustomer WHERE ";

	private static final String _SQL_COUNT_BLACKLISTCUSTOMER =
		"SELECT COUNT(blacklistCustomer) FROM BlacklistCustomer blacklistCustomer";

	private static final String _SQL_COUNT_BLACKLISTCUSTOMER_WHERE =
		"SELECT COUNT(blacklistCustomer) FROM BlacklistCustomer blacklistCustomer WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "blacklistCustomer.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BlacklistCustomer exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BlacklistCustomer exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BlacklistCustomerPersistenceImpl.class);

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

	private static class BlacklistCustomerModelArgumentsResolver
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

			BlacklistCustomerModelImpl blacklistCustomerModelImpl =
				(BlacklistCustomerModelImpl)baseModel;

			long columnBitmask = blacklistCustomerModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					blacklistCustomerModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						blacklistCustomerModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					blacklistCustomerModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			BlacklistCustomerModelImpl blacklistCustomerModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						blacklistCustomerModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = blacklistCustomerModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}