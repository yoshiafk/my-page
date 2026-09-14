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

import com.mypage.admin.product.exception.NoSuchMasterBankException;
import com.mypage.admin.product.model.MasterBank;
import com.mypage.admin.product.model.impl.MasterBankImpl;
import com.mypage.admin.product.model.impl.MasterBankModelImpl;
import com.mypage.admin.product.service.persistence.MasterBankPersistence;
import com.mypage.admin.product.service.persistence.MasterBankUtil;
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
 * The persistence implementation for the master bank service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = MasterBankPersistence.class)
public class MasterBankPersistenceImpl
	extends BasePersistenceImpl<MasterBank> implements MasterBankPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MasterBankUtil</code> to access the master bank persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MasterBankImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByactiveBanks;
	private FinderPath _finderPathWithoutPaginationFindByactiveBanks;
	private FinderPath _finderPathCountByactiveBanks;

	/**
	 * Returns all the master banks where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching master banks
	 */
	@Override
	public List<MasterBank> findByactiveBanks(Integer active) {
		return findByactiveBanks(
			active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master banks where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @return the range of matching master banks
	 */
	@Override
	public List<MasterBank> findByactiveBanks(
		Integer active, int start, int end) {

		return findByactiveBanks(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master banks where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master banks
	 */
	@Override
	public List<MasterBank> findByactiveBanks(
		Integer active, int start, int end,
		OrderByComparator<MasterBank> orderByComparator) {

		return findByactiveBanks(active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master banks where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master banks
	 */
	@Override
	public List<MasterBank> findByactiveBanks(
		Integer active, int start, int end,
		OrderByComparator<MasterBank> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByactiveBanks;
				finderArgs = new Object[] {active};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByactiveBanks;
			finderArgs = new Object[] {active, start, end, orderByComparator};
		}

		List<MasterBank> list = null;

		if (useFinderCache) {
			list = (List<MasterBank>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MasterBank masterBank : list) {
					if (!Objects.equals(active, masterBank.getActive())) {
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

			sb.append(_SQL_SELECT_MASTERBANK_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVEBANKS_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MasterBankModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(active.intValue());

				list = (List<MasterBank>)QueryUtil.list(
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
	 * Returns the first master bank in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master bank
	 * @throws NoSuchMasterBankException if a matching master bank could not be found
	 */
	@Override
	public MasterBank findByactiveBanks_First(
			Integer active, OrderByComparator<MasterBank> orderByComparator)
		throws NoSuchMasterBankException {

		MasterBank masterBank = fetchByactiveBanks_First(
			active, orderByComparator);

		if (masterBank != null) {
			return masterBank;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchMasterBankException(sb.toString());
	}

	/**
	 * Returns the first master bank in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master bank, or <code>null</code> if a matching master bank could not be found
	 */
	@Override
	public MasterBank fetchByactiveBanks_First(
		Integer active, OrderByComparator<MasterBank> orderByComparator) {

		List<MasterBank> list = findByactiveBanks(
			active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master bank in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master bank
	 * @throws NoSuchMasterBankException if a matching master bank could not be found
	 */
	@Override
	public MasterBank findByactiveBanks_Last(
			Integer active, OrderByComparator<MasterBank> orderByComparator)
		throws NoSuchMasterBankException {

		MasterBank masterBank = fetchByactiveBanks_Last(
			active, orderByComparator);

		if (masterBank != null) {
			return masterBank;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchMasterBankException(sb.toString());
	}

	/**
	 * Returns the last master bank in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master bank, or <code>null</code> if a matching master bank could not be found
	 */
	@Override
	public MasterBank fetchByactiveBanks_Last(
		Integer active, OrderByComparator<MasterBank> orderByComparator) {

		int count = countByactiveBanks(active);

		if (count == 0) {
			return null;
		}

		List<MasterBank> list = findByactiveBanks(
			active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master banks before and after the current master bank in the ordered set where active = &#63;.
	 *
	 * @param masterBankId the primary key of the current master bank
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master bank
	 * @throws NoSuchMasterBankException if a master bank with the primary key could not be found
	 */
	@Override
	public MasterBank[] findByactiveBanks_PrevAndNext(
			long masterBankId, Integer active,
			OrderByComparator<MasterBank> orderByComparator)
		throws NoSuchMasterBankException {

		MasterBank masterBank = findByPrimaryKey(masterBankId);

		Session session = null;

		try {
			session = openSession();

			MasterBank[] array = new MasterBankImpl[3];

			array[0] = getByactiveBanks_PrevAndNext(
				session, masterBank, active, orderByComparator, true);

			array[1] = masterBank;

			array[2] = getByactiveBanks_PrevAndNext(
				session, masterBank, active, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterBank getByactiveBanks_PrevAndNext(
		Session session, MasterBank masterBank, Integer active,
		OrderByComparator<MasterBank> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MASTERBANK_WHERE);

		sb.append(_FINDER_COLUMN_ACTIVEBANKS_ACTIVE_2);

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
			sb.append(MasterBankModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(active.intValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(masterBank)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MasterBank> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master banks where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	@Override
	public void removeByactiveBanks(Integer active) {
		for (MasterBank masterBank :
				findByactiveBanks(
					active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(masterBank);
		}
	}

	/**
	 * Returns the number of master banks where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching master banks
	 */
	@Override
	public int countByactiveBanks(Integer active) {
		FinderPath finderPath = _finderPathCountByactiveBanks;

		Object[] finderArgs = new Object[] {active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MASTERBANK_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVEBANKS_ACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_ACTIVEBANKS_ACTIVE_2 =
		"masterBank.active = ?";

	private FinderPath _finderPathWithPaginationFindBysearchByName;
	private FinderPath _finderPathWithoutPaginationFindBysearchByName;
	private FinderPath _finderPathCountBysearchByName;

	/**
	 * Returns all the master banks where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @return the matching master banks
	 */
	@Override
	public List<MasterBank> findBysearchByName(String name, Integer active) {
		return findBysearchByName(
			name, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master banks where name = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @return the range of matching master banks
	 */
	@Override
	public List<MasterBank> findBysearchByName(
		String name, Integer active, int start, int end) {

		return findBysearchByName(name, active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master banks where name = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master banks
	 */
	@Override
	public List<MasterBank> findBysearchByName(
		String name, Integer active, int start, int end,
		OrderByComparator<MasterBank> orderByComparator) {

		return findBysearchByName(
			name, active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master banks where name = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param active the active
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master banks
	 */
	@Override
	public List<MasterBank> findBysearchByName(
		String name, Integer active, int start, int end,
		OrderByComparator<MasterBank> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBysearchByName;
				finderArgs = new Object[] {name, active};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchByName;
			finderArgs = new Object[] {
				name, active, start, end, orderByComparator
			};
		}

		List<MasterBank> list = null;

		if (useFinderCache) {
			list = (List<MasterBank>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MasterBank masterBank : list) {
					if (!name.equals(masterBank.getName()) ||
						!Objects.equals(active, masterBank.getActive())) {

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

			sb.append(_SQL_SELECT_MASTERBANK_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHBYNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_SEARCHBYNAME_NAME_2);
			}

			sb.append(_FINDER_COLUMN_SEARCHBYNAME_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MasterBankModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				queryPos.add(active.intValue());

				list = (List<MasterBank>)QueryUtil.list(
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
	 * Returns the first master bank in the ordered set where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master bank
	 * @throws NoSuchMasterBankException if a matching master bank could not be found
	 */
	@Override
	public MasterBank findBysearchByName_First(
			String name, Integer active,
			OrderByComparator<MasterBank> orderByComparator)
		throws NoSuchMasterBankException {

		MasterBank masterBank = fetchBysearchByName_First(
			name, active, orderByComparator);

		if (masterBank != null) {
			return masterBank;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append(", active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchMasterBankException(sb.toString());
	}

	/**
	 * Returns the first master bank in the ordered set where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master bank, or <code>null</code> if a matching master bank could not be found
	 */
	@Override
	public MasterBank fetchBysearchByName_First(
		String name, Integer active,
		OrderByComparator<MasterBank> orderByComparator) {

		List<MasterBank> list = findBysearchByName(
			name, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master bank in the ordered set where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master bank
	 * @throws NoSuchMasterBankException if a matching master bank could not be found
	 */
	@Override
	public MasterBank findBysearchByName_Last(
			String name, Integer active,
			OrderByComparator<MasterBank> orderByComparator)
		throws NoSuchMasterBankException {

		MasterBank masterBank = fetchBysearchByName_Last(
			name, active, orderByComparator);

		if (masterBank != null) {
			return masterBank;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append(", active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchMasterBankException(sb.toString());
	}

	/**
	 * Returns the last master bank in the ordered set where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master bank, or <code>null</code> if a matching master bank could not be found
	 */
	@Override
	public MasterBank fetchBysearchByName_Last(
		String name, Integer active,
		OrderByComparator<MasterBank> orderByComparator) {

		int count = countBysearchByName(name, active);

		if (count == 0) {
			return null;
		}

		List<MasterBank> list = findBysearchByName(
			name, active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master banks before and after the current master bank in the ordered set where name = &#63; and active = &#63;.
	 *
	 * @param masterBankId the primary key of the current master bank
	 * @param name the name
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master bank
	 * @throws NoSuchMasterBankException if a master bank with the primary key could not be found
	 */
	@Override
	public MasterBank[] findBysearchByName_PrevAndNext(
			long masterBankId, String name, Integer active,
			OrderByComparator<MasterBank> orderByComparator)
		throws NoSuchMasterBankException {

		name = Objects.toString(name, "");

		MasterBank masterBank = findByPrimaryKey(masterBankId);

		Session session = null;

		try {
			session = openSession();

			MasterBank[] array = new MasterBankImpl[3];

			array[0] = getBysearchByName_PrevAndNext(
				session, masterBank, name, active, orderByComparator, true);

			array[1] = masterBank;

			array[2] = getBysearchByName_PrevAndNext(
				session, masterBank, name, active, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterBank getBysearchByName_PrevAndNext(
		Session session, MasterBank masterBank, String name, Integer active,
		OrderByComparator<MasterBank> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_MASTERBANK_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_SEARCHBYNAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_SEARCHBYNAME_NAME_2);
		}

		sb.append(_FINDER_COLUMN_SEARCHBYNAME_ACTIVE_2);

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
			sb.append(MasterBankModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		queryPos.add(active.intValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(masterBank)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MasterBank> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master banks where name = &#63; and active = &#63; from the database.
	 *
	 * @param name the name
	 * @param active the active
	 */
	@Override
	public void removeBysearchByName(String name, Integer active) {
		for (MasterBank masterBank :
				findBysearchByName(
					name, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(masterBank);
		}
	}

	/**
	 * Returns the number of master banks where name = &#63; and active = &#63;.
	 *
	 * @param name the name
	 * @param active the active
	 * @return the number of matching master banks
	 */
	@Override
	public int countBysearchByName(String name, Integer active) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountBysearchByName;

		Object[] finderArgs = new Object[] {name, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MASTERBANK_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHBYNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_SEARCHBYNAME_NAME_2);
			}

			sb.append(_FINDER_COLUMN_SEARCHBYNAME_ACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

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

	private static final String _FINDER_COLUMN_SEARCHBYNAME_NAME_2 =
		"masterBank.name = ? AND ";

	private static final String _FINDER_COLUMN_SEARCHBYNAME_NAME_3 =
		"(masterBank.name IS NULL OR masterBank.name = '') AND ";

	private static final String _FINDER_COLUMN_SEARCHBYNAME_ACTIVE_2 =
		"masterBank.active = ?";

	public MasterBankPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("order", "order_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MasterBank.class);

		setModelImplClass(MasterBankImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the master bank in the entity cache if it is enabled.
	 *
	 * @param masterBank the master bank
	 */
	@Override
	public void cacheResult(MasterBank masterBank) {
		entityCache.putResult(
			MasterBankImpl.class, masterBank.getPrimaryKey(), masterBank);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the master banks in the entity cache if it is enabled.
	 *
	 * @param masterBanks the master banks
	 */
	@Override
	public void cacheResult(List<MasterBank> masterBanks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (masterBanks.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MasterBank masterBank : masterBanks) {
			if (entityCache.getResult(
					MasterBankImpl.class, masterBank.getPrimaryKey()) == null) {

				cacheResult(masterBank);
			}
		}
	}

	/**
	 * Clears the cache for all master banks.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MasterBankImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the master bank.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MasterBank masterBank) {
		entityCache.removeResult(MasterBankImpl.class, masterBank);
	}

	@Override
	public void clearCache(List<MasterBank> masterBanks) {
		for (MasterBank masterBank : masterBanks) {
			entityCache.removeResult(MasterBankImpl.class, masterBank);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MasterBankImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new master bank with the primary key. Does not add the master bank to the database.
	 *
	 * @param masterBankId the primary key for the new master bank
	 * @return the new master bank
	 */
	@Override
	public MasterBank create(long masterBankId) {
		MasterBank masterBank = new MasterBankImpl();

		masterBank.setNew(true);
		masterBank.setPrimaryKey(masterBankId);

		masterBank.setCompanyId(CompanyThreadLocal.getCompanyId());

		return masterBank;
	}

	/**
	 * Removes the master bank with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterBankId the primary key of the master bank
	 * @return the master bank that was removed
	 * @throws NoSuchMasterBankException if a master bank with the primary key could not be found
	 */
	@Override
	public MasterBank remove(long masterBankId)
		throws NoSuchMasterBankException {

		return remove((Serializable)masterBankId);
	}

	/**
	 * Removes the master bank with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the master bank
	 * @return the master bank that was removed
	 * @throws NoSuchMasterBankException if a master bank with the primary key could not be found
	 */
	@Override
	public MasterBank remove(Serializable primaryKey)
		throws NoSuchMasterBankException {

		Session session = null;

		try {
			session = openSession();

			MasterBank masterBank = (MasterBank)session.get(
				MasterBankImpl.class, primaryKey);

			if (masterBank == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasterBankException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(masterBank);
		}
		catch (NoSuchMasterBankException noSuchEntityException) {
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
	protected MasterBank removeImpl(MasterBank masterBank) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(masterBank)) {
				masterBank = (MasterBank)session.get(
					MasterBankImpl.class, masterBank.getPrimaryKeyObj());
			}

			if (masterBank != null) {
				session.delete(masterBank);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (masterBank != null) {
			clearCache(masterBank);
		}

		return masterBank;
	}

	@Override
	public MasterBank updateImpl(MasterBank masterBank) {
		boolean isNew = masterBank.isNew();

		if (!(masterBank instanceof MasterBankModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(masterBank.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(masterBank);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in masterBank proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MasterBank implementation " +
					masterBank.getClass());
		}

		MasterBankModelImpl masterBankModelImpl =
			(MasterBankModelImpl)masterBank;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (masterBank.getCreateDate() == null)) {
			if (serviceContext == null) {
				masterBank.setCreateDate(date);
			}
			else {
				masterBank.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!masterBankModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				masterBank.setModifiedDate(date);
			}
			else {
				masterBank.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(masterBank);
			}
			else {
				masterBank = (MasterBank)session.merge(masterBank);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MasterBankImpl.class, masterBankModelImpl, false, true);

		if (isNew) {
			masterBank.setNew(false);
		}

		masterBank.resetOriginalValues();

		return masterBank;
	}

	/**
	 * Returns the master bank with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the master bank
	 * @return the master bank
	 * @throws NoSuchMasterBankException if a master bank with the primary key could not be found
	 */
	@Override
	public MasterBank findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMasterBankException {

		MasterBank masterBank = fetchByPrimaryKey(primaryKey);

		if (masterBank == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasterBankException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return masterBank;
	}

	/**
	 * Returns the master bank with the primary key or throws a <code>NoSuchMasterBankException</code> if it could not be found.
	 *
	 * @param masterBankId the primary key of the master bank
	 * @return the master bank
	 * @throws NoSuchMasterBankException if a master bank with the primary key could not be found
	 */
	@Override
	public MasterBank findByPrimaryKey(long masterBankId)
		throws NoSuchMasterBankException {

		return findByPrimaryKey((Serializable)masterBankId);
	}

	/**
	 * Returns the master bank with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterBankId the primary key of the master bank
	 * @return the master bank, or <code>null</code> if a master bank with the primary key could not be found
	 */
	@Override
	public MasterBank fetchByPrimaryKey(long masterBankId) {
		return fetchByPrimaryKey((Serializable)masterBankId);
	}

	/**
	 * Returns all the master banks.
	 *
	 * @return the master banks
	 */
	@Override
	public List<MasterBank> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master banks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @return the range of master banks
	 */
	@Override
	public List<MasterBank> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the master banks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master banks
	 */
	@Override
	public List<MasterBank> findAll(
		int start, int end, OrderByComparator<MasterBank> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master banks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterBankModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master banks
	 * @param end the upper bound of the range of master banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master banks
	 */
	@Override
	public List<MasterBank> findAll(
		int start, int end, OrderByComparator<MasterBank> orderByComparator,
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

		List<MasterBank> list = null;

		if (useFinderCache) {
			list = (List<MasterBank>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MASTERBANK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MASTERBANK;

				sql = sql.concat(MasterBankModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MasterBank>)QueryUtil.list(
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
	 * Removes all the master banks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MasterBank masterBank : findAll()) {
			remove(masterBank);
		}
	}

	/**
	 * Returns the number of master banks.
	 *
	 * @return the number of master banks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MASTERBANK);

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
		return "masterBankId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MASTERBANK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MasterBankModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the master bank persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new MasterBankModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MasterBank.class.getName()));

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

		_finderPathWithPaginationFindByactiveBanks = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByactiveBanks",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"active_"}, true);

		_finderPathWithoutPaginationFindByactiveBanks = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByactiveBanks",
			new String[] {Integer.class.getName()}, new String[] {"active_"},
			true);

		_finderPathCountByactiveBanks = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByactiveBanks",
			new String[] {Integer.class.getName()}, new String[] {"active_"},
			false);

		_finderPathWithPaginationFindBysearchByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchByName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"name", "active_"}, true);

		_finderPathWithoutPaginationFindBysearchByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysearchByName",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"name", "active_"}, true);

		_finderPathCountBysearchByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchByName",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"name", "active_"}, false);

		_setMasterBankUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMasterBankUtilPersistence(null);

		entityCache.removeCache(MasterBankImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setMasterBankUtilPersistence(
		MasterBankPersistence masterBankPersistence) {

		try {
			Field field = MasterBankUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, masterBankPersistence);
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

	private static final String _SQL_SELECT_MASTERBANK =
		"SELECT masterBank FROM MasterBank masterBank";

	private static final String _SQL_SELECT_MASTERBANK_WHERE =
		"SELECT masterBank FROM MasterBank masterBank WHERE ";

	private static final String _SQL_COUNT_MASTERBANK =
		"SELECT COUNT(masterBank) FROM MasterBank masterBank";

	private static final String _SQL_COUNT_MASTERBANK_WHERE =
		"SELECT COUNT(masterBank) FROM MasterBank masterBank WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "masterBank.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MasterBank exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MasterBank exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MasterBankPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"order", "active"});

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

	private static class MasterBankModelArgumentsResolver
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

			MasterBankModelImpl masterBankModelImpl =
				(MasterBankModelImpl)baseModel;

			long columnBitmask = masterBankModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(masterBankModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						masterBankModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(masterBankModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			MasterBankModelImpl masterBankModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = masterBankModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = masterBankModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}