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

import com.mypage.leads.exception.NoSuchLeadsException;
import com.mypage.leads.model.Leads;
import com.mypage.leads.model.impl.LeadsImpl;
import com.mypage.leads.model.impl.LeadsModelImpl;
import com.mypage.leads.service.persistence.LeadsPersistence;
import com.mypage.leads.service.persistence.LeadsUtil;
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

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the leads service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @generated
 */
@Component(service = LeadsPersistence.class)
public class LeadsPersistenceImpl
	extends BasePersistenceImpl<Leads> implements LeadsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LeadsUtil</code> to access the leads persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LeadsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByfindByToken;
	private FinderPath _finderPathCountByfindByToken;

	/**
	 * Returns the leads where Token = &#63; or throws a <code>NoSuchLeadsException</code> if it could not be found.
	 *
	 * @param Token the token
	 * @return the matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	@Override
	public Leads findByfindByToken(String Token) throws NoSuchLeadsException {
		Leads leads = fetchByfindByToken(Token);

		if (leads == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("Token=");
			sb.append(Token);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLeadsException(sb.toString());
		}

		return leads;
	}

	/**
	 * Returns the leads where Token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param Token the token
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	@Override
	public Leads fetchByfindByToken(String Token) {
		return fetchByfindByToken(Token, true);
	}

	/**
	 * Returns the leads where Token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param Token the token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	@Override
	public Leads fetchByfindByToken(String Token, boolean useFinderCache) {
		Token = Objects.toString(Token, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {Token};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByfindByToken, finderArgs, this);
		}

		if (result instanceof Leads) {
			Leads leads = (Leads)result;

			if (!Objects.equals(Token, leads.getToken())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LEADS_WHERE);

			boolean bindToken = false;

			if (Token.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYTOKEN_TOKEN_3);
			}
			else {
				bindToken = true;

				sb.append(_FINDER_COLUMN_FINDBYTOKEN_TOKEN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindToken) {
					queryPos.add(Token);
				}

				List<Leads> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByfindByToken, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {Token};
							}

							_log.warn(
								"LeadsPersistenceImpl.fetchByfindByToken(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Leads leads = list.get(0);

					result = leads;

					cacheResult(leads);
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
			return (Leads)result;
		}
	}

	/**
	 * Removes the leads where Token = &#63; from the database.
	 *
	 * @param Token the token
	 * @return the leads that was removed
	 */
	@Override
	public Leads removeByfindByToken(String Token) throws NoSuchLeadsException {
		Leads leads = findByfindByToken(Token);

		return remove(leads);
	}

	/**
	 * Returns the number of leadses where Token = &#63;.
	 *
	 * @param Token the token
	 * @return the number of matching leadses
	 */
	@Override
	public int countByfindByToken(String Token) {
		Token = Objects.toString(Token, "");

		FinderPath finderPath = _finderPathCountByfindByToken;

		Object[] finderArgs = new Object[] {Token};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEADS_WHERE);

			boolean bindToken = false;

			if (Token.isEmpty()) {
				sb.append(_FINDER_COLUMN_FINDBYTOKEN_TOKEN_3);
			}
			else {
				bindToken = true;

				sb.append(_FINDER_COLUMN_FINDBYTOKEN_TOKEN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindToken) {
					queryPos.add(Token);
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

	private static final String _FINDER_COLUMN_FINDBYTOKEN_TOKEN_2 =
		"leads.Token = ?";

	private static final String _FINDER_COLUMN_FINDBYTOKEN_TOKEN_3 =
		"(leads.Token IS NULL OR leads.Token = '')";

	private FinderPath _finderPathFetchByfindByReferenceNumber;
	private FinderPath _finderPathCountByfindByReferenceNumber;

	/**
	 * Returns the leads where ReferenceNumber = &#63; or throws a <code>NoSuchLeadsException</code> if it could not be found.
	 *
	 * @param ReferenceNumber the reference number
	 * @return the matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	@Override
	public Leads findByfindByReferenceNumber(String ReferenceNumber)
		throws NoSuchLeadsException {

		Leads leads = fetchByfindByReferenceNumber(ReferenceNumber);

		if (leads == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("ReferenceNumber=");
			sb.append(ReferenceNumber);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLeadsException(sb.toString());
		}

		return leads;
	}

	/**
	 * Returns the leads where ReferenceNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ReferenceNumber the reference number
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	@Override
	public Leads fetchByfindByReferenceNumber(String ReferenceNumber) {
		return fetchByfindByReferenceNumber(ReferenceNumber, true);
	}

	/**
	 * Returns the leads where ReferenceNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ReferenceNumber the reference number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	@Override
	public Leads fetchByfindByReferenceNumber(
		String ReferenceNumber, boolean useFinderCache) {

		ReferenceNumber = Objects.toString(ReferenceNumber, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {ReferenceNumber};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByfindByReferenceNumber, finderArgs, this);
		}

		if (result instanceof Leads) {
			Leads leads = (Leads)result;

			if (!Objects.equals(ReferenceNumber, leads.getReferenceNumber())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LEADS_WHERE);

			boolean bindReferenceNumber = false;

			if (ReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FINDBYREFERENCENUMBER_REFERENCENUMBER_3);
			}
			else {
				bindReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_FINDBYREFERENCENUMBER_REFERENCENUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindReferenceNumber) {
					queryPos.add(ReferenceNumber);
				}

				List<Leads> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByfindByReferenceNumber, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {ReferenceNumber};
							}

							_log.warn(
								"LeadsPersistenceImpl.fetchByfindByReferenceNumber(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Leads leads = list.get(0);

					result = leads;

					cacheResult(leads);
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
			return (Leads)result;
		}
	}

	/**
	 * Removes the leads where ReferenceNumber = &#63; from the database.
	 *
	 * @param ReferenceNumber the reference number
	 * @return the leads that was removed
	 */
	@Override
	public Leads removeByfindByReferenceNumber(String ReferenceNumber)
		throws NoSuchLeadsException {

		Leads leads = findByfindByReferenceNumber(ReferenceNumber);

		return remove(leads);
	}

	/**
	 * Returns the number of leadses where ReferenceNumber = &#63;.
	 *
	 * @param ReferenceNumber the reference number
	 * @return the number of matching leadses
	 */
	@Override
	public int countByfindByReferenceNumber(String ReferenceNumber) {
		ReferenceNumber = Objects.toString(ReferenceNumber, "");

		FinderPath finderPath = _finderPathCountByfindByReferenceNumber;

		Object[] finderArgs = new Object[] {ReferenceNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEADS_WHERE);

			boolean bindReferenceNumber = false;

			if (ReferenceNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FINDBYREFERENCENUMBER_REFERENCENUMBER_3);
			}
			else {
				bindReferenceNumber = true;

				sb.append(
					_FINDER_COLUMN_FINDBYREFERENCENUMBER_REFERENCENUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindReferenceNumber) {
					queryPos.add(ReferenceNumber);
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
		_FINDER_COLUMN_FINDBYREFERENCENUMBER_REFERENCENUMBER_2 =
			"leads.ReferenceNumber = ?";

	private static final String
		_FINDER_COLUMN_FINDBYREFERENCENUMBER_REFERENCENUMBER_3 =
			"(leads.ReferenceNumber IS NULL OR leads.ReferenceNumber = '')";

	private FinderPath _finderPathWithPaginationFindBysearchByToken;
	private FinderPath _finderPathWithoutPaginationFindBysearchByToken;
	private FinderPath _finderPathCountBysearchByToken;

	/**
	 * Returns all the leadses where Token = &#63;.
	 *
	 * @param Token the token
	 * @return the matching leadses
	 */
	@Override
	public List<Leads> findBysearchByToken(String Token) {
		return findBysearchByToken(
			Token, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leadses where Token = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param Token the token
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @return the range of matching leadses
	 */
	@Override
	public List<Leads> findBysearchByToken(String Token, int start, int end) {
		return findBysearchByToken(Token, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leadses where Token = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param Token the token
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leadses
	 */
	@Override
	public List<Leads> findBysearchByToken(
		String Token, int start, int end,
		OrderByComparator<Leads> orderByComparator) {

		return findBysearchByToken(Token, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leadses where Token = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param Token the token
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leadses
	 */
	@Override
	public List<Leads> findBysearchByToken(
		String Token, int start, int end,
		OrderByComparator<Leads> orderByComparator, boolean useFinderCache) {

		Token = Objects.toString(Token, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBysearchByToken;
				finderArgs = new Object[] {Token};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchByToken;
			finderArgs = new Object[] {Token, start, end, orderByComparator};
		}

		List<Leads> list = null;

		if (useFinderCache) {
			list = (List<Leads>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Leads leads : list) {
					if (!Token.equals(leads.getToken())) {
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

			sb.append(_SQL_SELECT_LEADS_WHERE);

			boolean bindToken = false;

			if (Token.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHBYTOKEN_TOKEN_3);
			}
			else {
				bindToken = true;

				sb.append(_FINDER_COLUMN_SEARCHBYTOKEN_TOKEN_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeadsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindToken) {
					queryPos.add(Token);
				}

				list = (List<Leads>)QueryUtil.list(
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
	 * Returns the first leads in the ordered set where Token = &#63;.
	 *
	 * @param Token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	@Override
	public Leads findBysearchByToken_First(
			String Token, OrderByComparator<Leads> orderByComparator)
		throws NoSuchLeadsException {

		Leads leads = fetchBysearchByToken_First(Token, orderByComparator);

		if (leads != null) {
			return leads;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("Token=");
		sb.append(Token);

		sb.append("}");

		throw new NoSuchLeadsException(sb.toString());
	}

	/**
	 * Returns the first leads in the ordered set where Token = &#63;.
	 *
	 * @param Token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads, or <code>null</code> if a matching leads could not be found
	 */
	@Override
	public Leads fetchBysearchByToken_First(
		String Token, OrderByComparator<Leads> orderByComparator) {

		List<Leads> list = findBysearchByToken(Token, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leads in the ordered set where Token = &#63;.
	 *
	 * @param Token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	@Override
	public Leads findBysearchByToken_Last(
			String Token, OrderByComparator<Leads> orderByComparator)
		throws NoSuchLeadsException {

		Leads leads = fetchBysearchByToken_Last(Token, orderByComparator);

		if (leads != null) {
			return leads;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("Token=");
		sb.append(Token);

		sb.append("}");

		throw new NoSuchLeadsException(sb.toString());
	}

	/**
	 * Returns the last leads in the ordered set where Token = &#63;.
	 *
	 * @param Token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads, or <code>null</code> if a matching leads could not be found
	 */
	@Override
	public Leads fetchBysearchByToken_Last(
		String Token, OrderByComparator<Leads> orderByComparator) {

		int count = countBysearchByToken(Token);

		if (count == 0) {
			return null;
		}

		List<Leads> list = findBysearchByToken(
			Token, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leadses before and after the current leads in the ordered set where Token = &#63;.
	 *
	 * @param LeadsId the primary key of the current leads
	 * @param Token the token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leads
	 * @throws NoSuchLeadsException if a leads with the primary key could not be found
	 */
	@Override
	public Leads[] findBysearchByToken_PrevAndNext(
			long LeadsId, String Token,
			OrderByComparator<Leads> orderByComparator)
		throws NoSuchLeadsException {

		Token = Objects.toString(Token, "");

		Leads leads = findByPrimaryKey(LeadsId);

		Session session = null;

		try {
			session = openSession();

			Leads[] array = new LeadsImpl[3];

			array[0] = getBysearchByToken_PrevAndNext(
				session, leads, Token, orderByComparator, true);

			array[1] = leads;

			array[2] = getBysearchByToken_PrevAndNext(
				session, leads, Token, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Leads getBysearchByToken_PrevAndNext(
		Session session, Leads leads, String Token,
		OrderByComparator<Leads> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LEADS_WHERE);

		boolean bindToken = false;

		if (Token.isEmpty()) {
			sb.append(_FINDER_COLUMN_SEARCHBYTOKEN_TOKEN_3);
		}
		else {
			bindToken = true;

			sb.append(_FINDER_COLUMN_SEARCHBYTOKEN_TOKEN_2);
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
			sb.append(LeadsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindToken) {
			queryPos.add(Token);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(leads)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Leads> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leadses where Token = &#63; from the database.
	 *
	 * @param Token the token
	 */
	@Override
	public void removeBysearchByToken(String Token) {
		for (Leads leads :
				findBysearchByToken(
					Token, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leads);
		}
	}

	/**
	 * Returns the number of leadses where Token = &#63;.
	 *
	 * @param Token the token
	 * @return the number of matching leadses
	 */
	@Override
	public int countBysearchByToken(String Token) {
		Token = Objects.toString(Token, "");

		FinderPath finderPath = _finderPathCountBysearchByToken;

		Object[] finderArgs = new Object[] {Token};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEADS_WHERE);

			boolean bindToken = false;

			if (Token.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHBYTOKEN_TOKEN_3);
			}
			else {
				bindToken = true;

				sb.append(_FINDER_COLUMN_SEARCHBYTOKEN_TOKEN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindToken) {
					queryPos.add(Token);
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

	private static final String _FINDER_COLUMN_SEARCHBYTOKEN_TOKEN_2 =
		"leads.Token = ?";

	private static final String _FINDER_COLUMN_SEARCHBYTOKEN_TOKEN_3 =
		"(leads.Token IS NULL OR leads.Token = '')";

	private FinderPath _finderPathWithPaginationFindBysearchByPromoCode;
	private FinderPath _finderPathWithoutPaginationFindBysearchByPromoCode;
	private FinderPath _finderPathCountBysearchByPromoCode;

	/**
	 * Returns all the leadses where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @return the matching leadses
	 */
	@Override
	public List<Leads> findBysearchByPromoCode(String PromoCode) {
		return findBysearchByPromoCode(
			PromoCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leadses where PromoCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param PromoCode the promo code
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @return the range of matching leadses
	 */
	@Override
	public List<Leads> findBysearchByPromoCode(
		String PromoCode, int start, int end) {

		return findBysearchByPromoCode(PromoCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leadses where PromoCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param PromoCode the promo code
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leadses
	 */
	@Override
	public List<Leads> findBysearchByPromoCode(
		String PromoCode, int start, int end,
		OrderByComparator<Leads> orderByComparator) {

		return findBysearchByPromoCode(
			PromoCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leadses where PromoCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param PromoCode the promo code
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leadses
	 */
	@Override
	public List<Leads> findBysearchByPromoCode(
		String PromoCode, int start, int end,
		OrderByComparator<Leads> orderByComparator, boolean useFinderCache) {

		PromoCode = Objects.toString(PromoCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBysearchByPromoCode;
				finderArgs = new Object[] {PromoCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBysearchByPromoCode;
			finderArgs = new Object[] {
				PromoCode, start, end, orderByComparator
			};
		}

		List<Leads> list = null;

		if (useFinderCache) {
			list = (List<Leads>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Leads leads : list) {
					if (!PromoCode.equals(leads.getPromoCode())) {
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

			sb.append(_SQL_SELECT_LEADS_WHERE);

			boolean bindPromoCode = false;

			if (PromoCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHBYPROMOCODE_PROMOCODE_3);
			}
			else {
				bindPromoCode = true;

				sb.append(_FINDER_COLUMN_SEARCHBYPROMOCODE_PROMOCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeadsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPromoCode) {
					queryPos.add(PromoCode);
				}

				list = (List<Leads>)QueryUtil.list(
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
	 * Returns the first leads in the ordered set where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	@Override
	public Leads findBysearchByPromoCode_First(
			String PromoCode, OrderByComparator<Leads> orderByComparator)
		throws NoSuchLeadsException {

		Leads leads = fetchBysearchByPromoCode_First(
			PromoCode, orderByComparator);

		if (leads != null) {
			return leads;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("PromoCode=");
		sb.append(PromoCode);

		sb.append("}");

		throw new NoSuchLeadsException(sb.toString());
	}

	/**
	 * Returns the first leads in the ordered set where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads, or <code>null</code> if a matching leads could not be found
	 */
	@Override
	public Leads fetchBysearchByPromoCode_First(
		String PromoCode, OrderByComparator<Leads> orderByComparator) {

		List<Leads> list = findBysearchByPromoCode(
			PromoCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leads in the ordered set where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	@Override
	public Leads findBysearchByPromoCode_Last(
			String PromoCode, OrderByComparator<Leads> orderByComparator)
		throws NoSuchLeadsException {

		Leads leads = fetchBysearchByPromoCode_Last(
			PromoCode, orderByComparator);

		if (leads != null) {
			return leads;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("PromoCode=");
		sb.append(PromoCode);

		sb.append("}");

		throw new NoSuchLeadsException(sb.toString());
	}

	/**
	 * Returns the last leads in the ordered set where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads, or <code>null</code> if a matching leads could not be found
	 */
	@Override
	public Leads fetchBysearchByPromoCode_Last(
		String PromoCode, OrderByComparator<Leads> orderByComparator) {

		int count = countBysearchByPromoCode(PromoCode);

		if (count == 0) {
			return null;
		}

		List<Leads> list = findBysearchByPromoCode(
			PromoCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leadses before and after the current leads in the ordered set where PromoCode = &#63;.
	 *
	 * @param LeadsId the primary key of the current leads
	 * @param PromoCode the promo code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leads
	 * @throws NoSuchLeadsException if a leads with the primary key could not be found
	 */
	@Override
	public Leads[] findBysearchByPromoCode_PrevAndNext(
			long LeadsId, String PromoCode,
			OrderByComparator<Leads> orderByComparator)
		throws NoSuchLeadsException {

		PromoCode = Objects.toString(PromoCode, "");

		Leads leads = findByPrimaryKey(LeadsId);

		Session session = null;

		try {
			session = openSession();

			Leads[] array = new LeadsImpl[3];

			array[0] = getBysearchByPromoCode_PrevAndNext(
				session, leads, PromoCode, orderByComparator, true);

			array[1] = leads;

			array[2] = getBysearchByPromoCode_PrevAndNext(
				session, leads, PromoCode, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Leads getBysearchByPromoCode_PrevAndNext(
		Session session, Leads leads, String PromoCode,
		OrderByComparator<Leads> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LEADS_WHERE);

		boolean bindPromoCode = false;

		if (PromoCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_SEARCHBYPROMOCODE_PROMOCODE_3);
		}
		else {
			bindPromoCode = true;

			sb.append(_FINDER_COLUMN_SEARCHBYPROMOCODE_PROMOCODE_2);
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
			sb.append(LeadsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPromoCode) {
			queryPos.add(PromoCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(leads)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Leads> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leadses where PromoCode = &#63; from the database.
	 *
	 * @param PromoCode the promo code
	 */
	@Override
	public void removeBysearchByPromoCode(String PromoCode) {
		for (Leads leads :
				findBysearchByPromoCode(
					PromoCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leads);
		}
	}

	/**
	 * Returns the number of leadses where PromoCode = &#63;.
	 *
	 * @param PromoCode the promo code
	 * @return the number of matching leadses
	 */
	@Override
	public int countBysearchByPromoCode(String PromoCode) {
		PromoCode = Objects.toString(PromoCode, "");

		FinderPath finderPath = _finderPathCountBysearchByPromoCode;

		Object[] finderArgs = new Object[] {PromoCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEADS_WHERE);

			boolean bindPromoCode = false;

			if (PromoCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_SEARCHBYPROMOCODE_PROMOCODE_3);
			}
			else {
				bindPromoCode = true;

				sb.append(_FINDER_COLUMN_SEARCHBYPROMOCODE_PROMOCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPromoCode) {
					queryPos.add(PromoCode);
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

	private static final String _FINDER_COLUMN_SEARCHBYPROMOCODE_PROMOCODE_2 =
		"leads.PromoCode = ?";

	private static final String _FINDER_COLUMN_SEARCHBYPROMOCODE_PROMOCODE_3 =
		"(leads.PromoCode IS NULL OR leads.PromoCode = '')";

	private FinderPath _finderPathWithPaginationFindByMyPageUserId;
	private FinderPath _finderPathWithoutPaginationFindByMyPageUserId;
	private FinderPath _finderPathCountByMyPageUserId;

	/**
	 * Returns all the leadses where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the matching leadses
	 */
	@Override
	public List<Leads> findByMyPageUserId(long mypageUserId) {
		return findByMyPageUserId(
			mypageUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leadses where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @return the range of matching leadses
	 */
	@Override
	public List<Leads> findByMyPageUserId(
		long mypageUserId, int start, int end) {

		return findByMyPageUserId(mypageUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the leadses where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching leadses
	 */
	@Override
	public List<Leads> findByMyPageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<Leads> orderByComparator) {

		return findByMyPageUserId(
			mypageUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leadses where mypageUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param mypageUserId the mypage user ID
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching leadses
	 */
	@Override
	public List<Leads> findByMyPageUserId(
		long mypageUserId, int start, int end,
		OrderByComparator<Leads> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByMyPageUserId;
				finderArgs = new Object[] {mypageUserId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByMyPageUserId;
			finderArgs = new Object[] {
				mypageUserId, start, end, orderByComparator
			};
		}

		List<Leads> list = null;

		if (useFinderCache) {
			list = (List<Leads>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Leads leads : list) {
					if (mypageUserId != leads.getMypageUserId()) {
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

			sb.append(_SQL_SELECT_LEADS_WHERE);

			sb.append(_FINDER_COLUMN_MYPAGEUSERID_MYPAGEUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LeadsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserId);

				list = (List<Leads>)QueryUtil.list(
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
	 * Returns the first leads in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	@Override
	public Leads findByMyPageUserId_First(
			long mypageUserId, OrderByComparator<Leads> orderByComparator)
		throws NoSuchLeadsException {

		Leads leads = fetchByMyPageUserId_First(
			mypageUserId, orderByComparator);

		if (leads != null) {
			return leads;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserId=");
		sb.append(mypageUserId);

		sb.append("}");

		throw new NoSuchLeadsException(sb.toString());
	}

	/**
	 * Returns the first leads in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching leads, or <code>null</code> if a matching leads could not be found
	 */
	@Override
	public Leads fetchByMyPageUserId_First(
		long mypageUserId, OrderByComparator<Leads> orderByComparator) {

		List<Leads> list = findByMyPageUserId(
			mypageUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last leads in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	@Override
	public Leads findByMyPageUserId_Last(
			long mypageUserId, OrderByComparator<Leads> orderByComparator)
		throws NoSuchLeadsException {

		Leads leads = fetchByMyPageUserId_Last(mypageUserId, orderByComparator);

		if (leads != null) {
			return leads;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mypageUserId=");
		sb.append(mypageUserId);

		sb.append("}");

		throw new NoSuchLeadsException(sb.toString());
	}

	/**
	 * Returns the last leads in the ordered set where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching leads, or <code>null</code> if a matching leads could not be found
	 */
	@Override
	public Leads fetchByMyPageUserId_Last(
		long mypageUserId, OrderByComparator<Leads> orderByComparator) {

		int count = countByMyPageUserId(mypageUserId);

		if (count == 0) {
			return null;
		}

		List<Leads> list = findByMyPageUserId(
			mypageUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the leadses before and after the current leads in the ordered set where mypageUserId = &#63;.
	 *
	 * @param LeadsId the primary key of the current leads
	 * @param mypageUserId the mypage user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next leads
	 * @throws NoSuchLeadsException if a leads with the primary key could not be found
	 */
	@Override
	public Leads[] findByMyPageUserId_PrevAndNext(
			long LeadsId, long mypageUserId,
			OrderByComparator<Leads> orderByComparator)
		throws NoSuchLeadsException {

		Leads leads = findByPrimaryKey(LeadsId);

		Session session = null;

		try {
			session = openSession();

			Leads[] array = new LeadsImpl[3];

			array[0] = getByMyPageUserId_PrevAndNext(
				session, leads, mypageUserId, orderByComparator, true);

			array[1] = leads;

			array[2] = getByMyPageUserId_PrevAndNext(
				session, leads, mypageUserId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Leads getByMyPageUserId_PrevAndNext(
		Session session, Leads leads, long mypageUserId,
		OrderByComparator<Leads> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LEADS_WHERE);

		sb.append(_FINDER_COLUMN_MYPAGEUSERID_MYPAGEUSERID_2);

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
			sb.append(LeadsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(mypageUserId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(leads)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Leads> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the leadses where mypageUserId = &#63; from the database.
	 *
	 * @param mypageUserId the mypage user ID
	 */
	@Override
	public void removeByMyPageUserId(long mypageUserId) {
		for (Leads leads :
				findByMyPageUserId(
					mypageUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(leads);
		}
	}

	/**
	 * Returns the number of leadses where mypageUserId = &#63;.
	 *
	 * @param mypageUserId the mypage user ID
	 * @return the number of matching leadses
	 */
	@Override
	public int countByMyPageUserId(long mypageUserId) {
		FinderPath finderPath = _finderPathCountByMyPageUserId;

		Object[] finderArgs = new Object[] {mypageUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEADS_WHERE);

			sb.append(_FINDER_COLUMN_MYPAGEUSERID_MYPAGEUSERID_2);

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

	private static final String _FINDER_COLUMN_MYPAGEUSERID_MYPAGEUSERID_2 =
		"leads.mypageUserId = ?";

	private FinderPath _finderPathFetchByfindByLeadsParentId;
	private FinderPath _finderPathCountByfindByLeadsParentId;

	/**
	 * Returns the leads where LeadsParentId = &#63; or throws a <code>NoSuchLeadsException</code> if it could not be found.
	 *
	 * @param LeadsParentId the leads parent ID
	 * @return the matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	@Override
	public Leads findByfindByLeadsParentId(long LeadsParentId)
		throws NoSuchLeadsException {

		Leads leads = fetchByfindByLeadsParentId(LeadsParentId);

		if (leads == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("LeadsParentId=");
			sb.append(LeadsParentId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLeadsException(sb.toString());
		}

		return leads;
	}

	/**
	 * Returns the leads where LeadsParentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsParentId the leads parent ID
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	@Override
	public Leads fetchByfindByLeadsParentId(long LeadsParentId) {
		return fetchByfindByLeadsParentId(LeadsParentId, true);
	}

	/**
	 * Returns the leads where LeadsParentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsParentId the leads parent ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	@Override
	public Leads fetchByfindByLeadsParentId(
		long LeadsParentId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {LeadsParentId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByfindByLeadsParentId, finderArgs, this);
		}

		if (result instanceof Leads) {
			Leads leads = (Leads)result;

			if (LeadsParentId != leads.getLeadsParentId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LEADS_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYLEADSPARENTID_LEADSPARENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(LeadsParentId);

				List<Leads> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByfindByLeadsParentId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {LeadsParentId};
							}

							_log.warn(
								"LeadsPersistenceImpl.fetchByfindByLeadsParentId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Leads leads = list.get(0);

					result = leads;

					cacheResult(leads);
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
			return (Leads)result;
		}
	}

	/**
	 * Removes the leads where LeadsParentId = &#63; from the database.
	 *
	 * @param LeadsParentId the leads parent ID
	 * @return the leads that was removed
	 */
	@Override
	public Leads removeByfindByLeadsParentId(long LeadsParentId)
		throws NoSuchLeadsException {

		Leads leads = findByfindByLeadsParentId(LeadsParentId);

		return remove(leads);
	}

	/**
	 * Returns the number of leadses where LeadsParentId = &#63;.
	 *
	 * @param LeadsParentId the leads parent ID
	 * @return the number of matching leadses
	 */
	@Override
	public int countByfindByLeadsParentId(long LeadsParentId) {
		FinderPath finderPath = _finderPathCountByfindByLeadsParentId;

		Object[] finderArgs = new Object[] {LeadsParentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEADS_WHERE);

			sb.append(_FINDER_COLUMN_FINDBYLEADSPARENTID_LEADSPARENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(LeadsParentId);

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
		_FINDER_COLUMN_FINDBYLEADSPARENTID_LEADSPARENTID_2 =
			"leads.LeadsParentId = ?";

	private FinderPath _finderPathFetchByidPhotoFileEntryId;
	private FinderPath _finderPathCountByidPhotoFileEntryId;

	/**
	 * Returns the leads where idPhotoFileEntryId = &#63; or throws a <code>NoSuchLeadsException</code> if it could not be found.
	 *
	 * @param idPhotoFileEntryId the id photo file entry ID
	 * @return the matching leads
	 * @throws NoSuchLeadsException if a matching leads could not be found
	 */
	@Override
	public Leads findByidPhotoFileEntryId(long idPhotoFileEntryId)
		throws NoSuchLeadsException {

		Leads leads = fetchByidPhotoFileEntryId(idPhotoFileEntryId);

		if (leads == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("idPhotoFileEntryId=");
			sb.append(idPhotoFileEntryId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLeadsException(sb.toString());
		}

		return leads;
	}

	/**
	 * Returns the leads where idPhotoFileEntryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idPhotoFileEntryId the id photo file entry ID
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	@Override
	public Leads fetchByidPhotoFileEntryId(long idPhotoFileEntryId) {
		return fetchByidPhotoFileEntryId(idPhotoFileEntryId, true);
	}

	/**
	 * Returns the leads where idPhotoFileEntryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idPhotoFileEntryId the id photo file entry ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching leads, or <code>null</code> if a matching leads could not be found
	 */
	@Override
	public Leads fetchByidPhotoFileEntryId(
		long idPhotoFileEntryId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {idPhotoFileEntryId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByidPhotoFileEntryId, finderArgs, this);
		}

		if (result instanceof Leads) {
			Leads leads = (Leads)result;

			if (idPhotoFileEntryId != leads.getIdPhotoFileEntryId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LEADS_WHERE);

			sb.append(_FINDER_COLUMN_IDPHOTOFILEENTRYID_IDPHOTOFILEENTRYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(idPhotoFileEntryId);

				List<Leads> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByidPhotoFileEntryId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {idPhotoFileEntryId};
							}

							_log.warn(
								"LeadsPersistenceImpl.fetchByidPhotoFileEntryId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Leads leads = list.get(0);

					result = leads;

					cacheResult(leads);
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
			return (Leads)result;
		}
	}

	/**
	 * Removes the leads where idPhotoFileEntryId = &#63; from the database.
	 *
	 * @param idPhotoFileEntryId the id photo file entry ID
	 * @return the leads that was removed
	 */
	@Override
	public Leads removeByidPhotoFileEntryId(long idPhotoFileEntryId)
		throws NoSuchLeadsException {

		Leads leads = findByidPhotoFileEntryId(idPhotoFileEntryId);

		return remove(leads);
	}

	/**
	 * Returns the number of leadses where idPhotoFileEntryId = &#63;.
	 *
	 * @param idPhotoFileEntryId the id photo file entry ID
	 * @return the number of matching leadses
	 */
	@Override
	public int countByidPhotoFileEntryId(long idPhotoFileEntryId) {
		FinderPath finderPath = _finderPathCountByidPhotoFileEntryId;

		Object[] finderArgs = new Object[] {idPhotoFileEntryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LEADS_WHERE);

			sb.append(_FINDER_COLUMN_IDPHOTOFILEENTRYID_IDPHOTOFILEENTRYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(idPhotoFileEntryId);

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
		_FINDER_COLUMN_IDPHOTOFILEENTRYID_IDPHOTOFILEENTRYID_2 =
			"leads.idPhotoFileEntryId = ?";

	public LeadsPersistenceImpl() {
		setModelClass(Leads.class);

		setModelImplClass(LeadsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the leads in the entity cache if it is enabled.
	 *
	 * @param leads the leads
	 */
	@Override
	public void cacheResult(Leads leads) {
		entityCache.putResult(LeadsImpl.class, leads.getPrimaryKey(), leads);

		finderCache.putResult(
			_finderPathFetchByfindByToken, new Object[] {leads.getToken()},
			leads);

		finderCache.putResult(
			_finderPathFetchByfindByReferenceNumber,
			new Object[] {leads.getReferenceNumber()}, leads);

		finderCache.putResult(
			_finderPathFetchByfindByLeadsParentId,
			new Object[] {leads.getLeadsParentId()}, leads);

		finderCache.putResult(
			_finderPathFetchByidPhotoFileEntryId,
			new Object[] {leads.getIdPhotoFileEntryId()}, leads);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the leadses in the entity cache if it is enabled.
	 *
	 * @param leadses the leadses
	 */
	@Override
	public void cacheResult(List<Leads> leadses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (leadses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Leads leads : leadses) {
			if (entityCache.getResult(LeadsImpl.class, leads.getPrimaryKey()) ==
					null) {

				cacheResult(leads);
			}
		}
	}

	/**
	 * Clears the cache for all leadses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LeadsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leads.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Leads leads) {
		entityCache.removeResult(LeadsImpl.class, leads);
	}

	@Override
	public void clearCache(List<Leads> leadses) {
		for (Leads leads : leadses) {
			entityCache.removeResult(LeadsImpl.class, leads);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LeadsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(LeadsModelImpl leadsModelImpl) {
		Object[] args = new Object[] {leadsModelImpl.getToken()};

		finderCache.putResult(
			_finderPathCountByfindByToken, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByfindByToken, args, leadsModelImpl, false);

		args = new Object[] {leadsModelImpl.getReferenceNumber()};

		finderCache.putResult(
			_finderPathCountByfindByReferenceNumber, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByfindByReferenceNumber, args, leadsModelImpl,
			false);

		args = new Object[] {leadsModelImpl.getLeadsParentId()};

		finderCache.putResult(
			_finderPathCountByfindByLeadsParentId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByfindByLeadsParentId, args, leadsModelImpl, false);

		args = new Object[] {leadsModelImpl.getIdPhotoFileEntryId()};

		finderCache.putResult(
			_finderPathCountByidPhotoFileEntryId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByidPhotoFileEntryId, args, leadsModelImpl, false);
	}

	/**
	 * Creates a new leads with the primary key. Does not add the leads to the database.
	 *
	 * @param LeadsId the primary key for the new leads
	 * @return the new leads
	 */
	@Override
	public Leads create(long LeadsId) {
		Leads leads = new LeadsImpl();

		leads.setNew(true);
		leads.setPrimaryKey(LeadsId);

		leads.setCompanyId(CompanyThreadLocal.getCompanyId());

		return leads;
	}

	/**
	 * Removes the leads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param LeadsId the primary key of the leads
	 * @return the leads that was removed
	 * @throws NoSuchLeadsException if a leads with the primary key could not be found
	 */
	@Override
	public Leads remove(long LeadsId) throws NoSuchLeadsException {
		return remove((Serializable)LeadsId);
	}

	/**
	 * Removes the leads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leads
	 * @return the leads that was removed
	 * @throws NoSuchLeadsException if a leads with the primary key could not be found
	 */
	@Override
	public Leads remove(Serializable primaryKey) throws NoSuchLeadsException {
		Session session = null;

		try {
			session = openSession();

			Leads leads = (Leads)session.get(LeadsImpl.class, primaryKey);

			if (leads == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeadsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(leads);
		}
		catch (NoSuchLeadsException noSuchEntityException) {
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
	protected Leads removeImpl(Leads leads) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leads)) {
				leads = (Leads)session.get(
					LeadsImpl.class, leads.getPrimaryKeyObj());
			}

			if (leads != null) {
				session.delete(leads);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (leads != null) {
			clearCache(leads);
		}

		return leads;
	}

	@Override
	public Leads updateImpl(Leads leads) {
		boolean isNew = leads.isNew();

		if (!(leads instanceof LeadsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(leads.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(leads);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in leads proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Leads implementation " +
					leads.getClass());
		}

		LeadsModelImpl leadsModelImpl = (LeadsModelImpl)leads;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (leads.getCreateDate() == null)) {
			if (serviceContext == null) {
				leads.setCreateDate(date);
			}
			else {
				leads.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!leadsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				leads.setModifiedDate(date);
			}
			else {
				leads.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(leads);
			}
			else {
				leads = (Leads)session.merge(leads);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(LeadsImpl.class, leadsModelImpl, false, true);

		cacheUniqueFindersCache(leadsModelImpl);

		if (isNew) {
			leads.setNew(false);
		}

		leads.resetOriginalValues();

		return leads;
	}

	/**
	 * Returns the leads with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leads
	 * @return the leads
	 * @throws NoSuchLeadsException if a leads with the primary key could not be found
	 */
	@Override
	public Leads findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeadsException {

		Leads leads = fetchByPrimaryKey(primaryKey);

		if (leads == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeadsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return leads;
	}

	/**
	 * Returns the leads with the primary key or throws a <code>NoSuchLeadsException</code> if it could not be found.
	 *
	 * @param LeadsId the primary key of the leads
	 * @return the leads
	 * @throws NoSuchLeadsException if a leads with the primary key could not be found
	 */
	@Override
	public Leads findByPrimaryKey(long LeadsId) throws NoSuchLeadsException {
		return findByPrimaryKey((Serializable)LeadsId);
	}

	/**
	 * Returns the leads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param LeadsId the primary key of the leads
	 * @return the leads, or <code>null</code> if a leads with the primary key could not be found
	 */
	@Override
	public Leads fetchByPrimaryKey(long LeadsId) {
		return fetchByPrimaryKey((Serializable)LeadsId);
	}

	/**
	 * Returns all the leadses.
	 *
	 * @return the leadses
	 */
	@Override
	public List<Leads> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @return the range of leadses
	 */
	@Override
	public List<Leads> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leadses
	 */
	@Override
	public List<Leads> findAll(
		int start, int end, OrderByComparator<Leads> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the leadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LeadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of leadses
	 * @param end the upper bound of the range of leadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of leadses
	 */
	@Override
	public List<Leads> findAll(
		int start, int end, OrderByComparator<Leads> orderByComparator,
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

		List<Leads> list = null;

		if (useFinderCache) {
			list = (List<Leads>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LEADS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LEADS;

				sql = sql.concat(LeadsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Leads>)QueryUtil.list(
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
	 * Removes all the leadses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Leads leads : findAll()) {
			remove(leads);
		}
	}

	/**
	 * Returns the number of leadses.
	 *
	 * @return the number of leadses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LEADS);

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
		return "LeadsId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEADS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LeadsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the leads persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new LeadsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Leads.class.getName()));

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

		_finderPathFetchByfindByToken = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByfindByToken",
			new String[] {String.class.getName()}, new String[] {"Token"},
			true);

		_finderPathCountByfindByToken = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfindByToken",
			new String[] {String.class.getName()}, new String[] {"Token"},
			false);

		_finderPathFetchByfindByReferenceNumber = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByfindByReferenceNumber",
			new String[] {String.class.getName()},
			new String[] {"ReferenceNumber"}, true);

		_finderPathCountByfindByReferenceNumber = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindByReferenceNumber",
			new String[] {String.class.getName()},
			new String[] {"ReferenceNumber"}, false);

		_finderPathWithPaginationFindBysearchByToken = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchByToken",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"Token"}, true);

		_finderPathWithoutPaginationFindBysearchByToken = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysearchByToken",
			new String[] {String.class.getName()}, new String[] {"Token"},
			true);

		_finderPathCountBysearchByToken = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchByToken",
			new String[] {String.class.getName()}, new String[] {"Token"},
			false);

		_finderPathWithPaginationFindBysearchByPromoCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysearchByPromoCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"PromoCode"}, true);

		_finderPathWithoutPaginationFindBysearchByPromoCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBysearchByPromoCode", new String[] {String.class.getName()},
			new String[] {"PromoCode"}, true);

		_finderPathCountBysearchByPromoCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysearchByPromoCode", new String[] {String.class.getName()},
			new String[] {"PromoCode"}, false);

		_finderPathWithPaginationFindByMyPageUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMyPageUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"mypageUserId"}, true);

		_finderPathWithoutPaginationFindByMyPageUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMyPageUserId",
			new String[] {Long.class.getName()}, new String[] {"mypageUserId"},
			true);

		_finderPathCountByMyPageUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMyPageUserId",
			new String[] {Long.class.getName()}, new String[] {"mypageUserId"},
			false);

		_finderPathFetchByfindByLeadsParentId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByfindByLeadsParentId",
			new String[] {Long.class.getName()}, new String[] {"LeadsParentId"},
			true);

		_finderPathCountByfindByLeadsParentId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindByLeadsParentId", new String[] {Long.class.getName()},
			new String[] {"LeadsParentId"}, false);

		_finderPathFetchByidPhotoFileEntryId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByidPhotoFileEntryId",
			new String[] {Long.class.getName()},
			new String[] {"idPhotoFileEntryId"}, true);

		_finderPathCountByidPhotoFileEntryId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByidPhotoFileEntryId", new String[] {Long.class.getName()},
			new String[] {"idPhotoFileEntryId"}, false);

		_setLeadsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setLeadsUtilPersistence(null);

		entityCache.removeCache(LeadsImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setLeadsUtilPersistence(LeadsPersistence leadsPersistence) {
		try {
			Field field = LeadsUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, leadsPersistence);
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

	private static final String _SQL_SELECT_LEADS =
		"SELECT leads FROM Leads leads";

	private static final String _SQL_SELECT_LEADS_WHERE =
		"SELECT leads FROM Leads leads WHERE ";

	private static final String _SQL_COUNT_LEADS =
		"SELECT COUNT(leads) FROM Leads leads";

	private static final String _SQL_COUNT_LEADS_WHERE =
		"SELECT COUNT(leads) FROM Leads leads WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "leads.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Leads exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Leads exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LeadsPersistenceImpl.class);

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

	private static class LeadsModelArgumentsResolver
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

			LeadsModelImpl leadsModelImpl = (LeadsModelImpl)baseModel;

			if (!checkColumn ||
				_hasModifiedColumns(leadsModelImpl, columnNames)) {

				return _getValue(leadsModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			LeadsModelImpl leadsModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = leadsModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = leadsModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static boolean _hasModifiedColumns(
			LeadsModelImpl leadsModelImpl, String[] columnNames) {

			if (columnNames.length == 0) {
				return false;
			}

			for (String columnName : columnNames) {
				if (!Objects.equals(
						leadsModelImpl.getColumnOriginalValue(columnName),
						leadsModelImpl.getColumnValue(columnName))) {

					return true;
				}
			}

			return false;
		}

	}

}