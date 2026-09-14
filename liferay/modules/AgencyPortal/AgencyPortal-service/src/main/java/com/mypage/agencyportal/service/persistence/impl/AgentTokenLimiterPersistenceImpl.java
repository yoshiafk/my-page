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

package com.mypage.agencyportal.service.persistence.impl;

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

import com.mypage.agencyportal.exception.NoSuchAgentTokenLimiterException;
import com.mypage.agencyportal.model.AgentTokenLimiter;
import com.mypage.agencyportal.model.impl.AgentTokenLimiterImpl;
import com.mypage.agencyportal.model.impl.AgentTokenLimiterModelImpl;
import com.mypage.agencyportal.service.persistence.AgentTokenLimiterPersistence;
import com.mypage.agencyportal.service.persistence.AgentTokenLimiterUtil;
import com.mypage.agencyportal.service.persistence.impl.constants.APPersistenceConstants;

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
 * The persistence implementation for the agent token limiter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = AgentTokenLimiterPersistence.class)
public class AgentTokenLimiterPersistenceImpl
	extends BasePersistenceImpl<AgentTokenLimiter>
	implements AgentTokenLimiterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AgentTokenLimiterUtil</code> to access the agent token limiter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AgentTokenLimiterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBytoken;
	private FinderPath _finderPathCountBytoken;

	/**
	 * Returns the agent token limiter where token = &#63; or throws a <code>NoSuchAgentTokenLimiterException</code> if it could not be found.
	 *
	 * @param token the token
	 * @return the matching agent token limiter
	 * @throws NoSuchAgentTokenLimiterException if a matching agent token limiter could not be found
	 */
	@Override
	public AgentTokenLimiter findBytoken(String token)
		throws NoSuchAgentTokenLimiterException {

		AgentTokenLimiter agentTokenLimiter = fetchBytoken(token);

		if (agentTokenLimiter == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("token=");
			sb.append(token);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAgentTokenLimiterException(sb.toString());
		}

		return agentTokenLimiter;
	}

	/**
	 * Returns the agent token limiter where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param token the token
	 * @return the matching agent token limiter, or <code>null</code> if a matching agent token limiter could not be found
	 */
	@Override
	public AgentTokenLimiter fetchBytoken(String token) {
		return fetchBytoken(token, true);
	}

	/**
	 * Returns the agent token limiter where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param token the token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching agent token limiter, or <code>null</code> if a matching agent token limiter could not be found
	 */
	@Override
	public AgentTokenLimiter fetchBytoken(
		String token, boolean useFinderCache) {

		token = Objects.toString(token, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {token};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBytoken, finderArgs, this);
		}

		if (result instanceof AgentTokenLimiter) {
			AgentTokenLimiter agentTokenLimiter = (AgentTokenLimiter)result;

			if (!Objects.equals(token, agentTokenLimiter.getToken())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_AGENTTOKENLIMITER_WHERE);

			boolean bindToken = false;

			if (token.isEmpty()) {
				sb.append(_FINDER_COLUMN_TOKEN_TOKEN_3);
			}
			else {
				bindToken = true;

				sb.append(_FINDER_COLUMN_TOKEN_TOKEN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindToken) {
					queryPos.add(token);
				}

				List<AgentTokenLimiter> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBytoken, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {token};
							}

							_log.warn(
								"AgentTokenLimiterPersistenceImpl.fetchBytoken(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AgentTokenLimiter agentTokenLimiter = list.get(0);

					result = agentTokenLimiter;

					cacheResult(agentTokenLimiter);
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
			return (AgentTokenLimiter)result;
		}
	}

	/**
	 * Removes the agent token limiter where token = &#63; from the database.
	 *
	 * @param token the token
	 * @return the agent token limiter that was removed
	 */
	@Override
	public AgentTokenLimiter removeBytoken(String token)
		throws NoSuchAgentTokenLimiterException {

		AgentTokenLimiter agentTokenLimiter = findBytoken(token);

		return remove(agentTokenLimiter);
	}

	/**
	 * Returns the number of agent token limiters where token = &#63;.
	 *
	 * @param token the token
	 * @return the number of matching agent token limiters
	 */
	@Override
	public int countBytoken(String token) {
		token = Objects.toString(token, "");

		FinderPath finderPath = _finderPathCountBytoken;

		Object[] finderArgs = new Object[] {token};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTTOKENLIMITER_WHERE);

			boolean bindToken = false;

			if (token.isEmpty()) {
				sb.append(_FINDER_COLUMN_TOKEN_TOKEN_3);
			}
			else {
				bindToken = true;

				sb.append(_FINDER_COLUMN_TOKEN_TOKEN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindToken) {
					queryPos.add(token);
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

	private static final String _FINDER_COLUMN_TOKEN_TOKEN_2 =
		"agentTokenLimiter.token = ?";

	private static final String _FINDER_COLUMN_TOKEN_TOKEN_3 =
		"(agentTokenLimiter.token IS NULL OR agentTokenLimiter.token = '')";

	private FinderPath _finderPathFetchBydeptCodeAndTokenType;
	private FinderPath _finderPathCountBydeptCodeAndTokenType;

	/**
	 * Returns the agent token limiter where deptCode = &#63; and tokenType = &#63; or throws a <code>NoSuchAgentTokenLimiterException</code> if it could not be found.
	 *
	 * @param deptCode the dept code
	 * @param tokenType the token type
	 * @return the matching agent token limiter
	 * @throws NoSuchAgentTokenLimiterException if a matching agent token limiter could not be found
	 */
	@Override
	public AgentTokenLimiter findBydeptCodeAndTokenType(
			String deptCode, String tokenType)
		throws NoSuchAgentTokenLimiterException {

		AgentTokenLimiter agentTokenLimiter = fetchBydeptCodeAndTokenType(
			deptCode, tokenType);

		if (agentTokenLimiter == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("deptCode=");
			sb.append(deptCode);

			sb.append(", tokenType=");
			sb.append(tokenType);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAgentTokenLimiterException(sb.toString());
		}

		return agentTokenLimiter;
	}

	/**
	 * Returns the agent token limiter where deptCode = &#63; and tokenType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param deptCode the dept code
	 * @param tokenType the token type
	 * @return the matching agent token limiter, or <code>null</code> if a matching agent token limiter could not be found
	 */
	@Override
	public AgentTokenLimiter fetchBydeptCodeAndTokenType(
		String deptCode, String tokenType) {

		return fetchBydeptCodeAndTokenType(deptCode, tokenType, true);
	}

	/**
	 * Returns the agent token limiter where deptCode = &#63; and tokenType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param deptCode the dept code
	 * @param tokenType the token type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching agent token limiter, or <code>null</code> if a matching agent token limiter could not be found
	 */
	@Override
	public AgentTokenLimiter fetchBydeptCodeAndTokenType(
		String deptCode, String tokenType, boolean useFinderCache) {

		deptCode = Objects.toString(deptCode, "");
		tokenType = Objects.toString(tokenType, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {deptCode, tokenType};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBydeptCodeAndTokenType, finderArgs, this);
		}

		if (result instanceof AgentTokenLimiter) {
			AgentTokenLimiter agentTokenLimiter = (AgentTokenLimiter)result;

			if (!Objects.equals(deptCode, agentTokenLimiter.getDeptCode()) ||
				!Objects.equals(tokenType, agentTokenLimiter.getTokenType())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_AGENTTOKENLIMITER_WHERE);

			boolean bindDeptCode = false;

			if (deptCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_DEPTCODEANDTOKENTYPE_DEPTCODE_3);
			}
			else {
				bindDeptCode = true;

				sb.append(_FINDER_COLUMN_DEPTCODEANDTOKENTYPE_DEPTCODE_2);
			}

			boolean bindTokenType = false;

			if (tokenType.isEmpty()) {
				sb.append(_FINDER_COLUMN_DEPTCODEANDTOKENTYPE_TOKENTYPE_3);
			}
			else {
				bindTokenType = true;

				sb.append(_FINDER_COLUMN_DEPTCODEANDTOKENTYPE_TOKENTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDeptCode) {
					queryPos.add(deptCode);
				}

				if (bindTokenType) {
					queryPos.add(tokenType);
				}

				List<AgentTokenLimiter> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBydeptCodeAndTokenType, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {deptCode, tokenType};
							}

							_log.warn(
								"AgentTokenLimiterPersistenceImpl.fetchBydeptCodeAndTokenType(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AgentTokenLimiter agentTokenLimiter = list.get(0);

					result = agentTokenLimiter;

					cacheResult(agentTokenLimiter);
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
			return (AgentTokenLimiter)result;
		}
	}

	/**
	 * Removes the agent token limiter where deptCode = &#63; and tokenType = &#63; from the database.
	 *
	 * @param deptCode the dept code
	 * @param tokenType the token type
	 * @return the agent token limiter that was removed
	 */
	@Override
	public AgentTokenLimiter removeBydeptCodeAndTokenType(
			String deptCode, String tokenType)
		throws NoSuchAgentTokenLimiterException {

		AgentTokenLimiter agentTokenLimiter = findBydeptCodeAndTokenType(
			deptCode, tokenType);

		return remove(agentTokenLimiter);
	}

	/**
	 * Returns the number of agent token limiters where deptCode = &#63; and tokenType = &#63;.
	 *
	 * @param deptCode the dept code
	 * @param tokenType the token type
	 * @return the number of matching agent token limiters
	 */
	@Override
	public int countBydeptCodeAndTokenType(String deptCode, String tokenType) {
		deptCode = Objects.toString(deptCode, "");
		tokenType = Objects.toString(tokenType, "");

		FinderPath finderPath = _finderPathCountBydeptCodeAndTokenType;

		Object[] finderArgs = new Object[] {deptCode, tokenType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AGENTTOKENLIMITER_WHERE);

			boolean bindDeptCode = false;

			if (deptCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_DEPTCODEANDTOKENTYPE_DEPTCODE_3);
			}
			else {
				bindDeptCode = true;

				sb.append(_FINDER_COLUMN_DEPTCODEANDTOKENTYPE_DEPTCODE_2);
			}

			boolean bindTokenType = false;

			if (tokenType.isEmpty()) {
				sb.append(_FINDER_COLUMN_DEPTCODEANDTOKENTYPE_TOKENTYPE_3);
			}
			else {
				bindTokenType = true;

				sb.append(_FINDER_COLUMN_DEPTCODEANDTOKENTYPE_TOKENTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDeptCode) {
					queryPos.add(deptCode);
				}

				if (bindTokenType) {
					queryPos.add(tokenType);
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

	private static final String _FINDER_COLUMN_DEPTCODEANDTOKENTYPE_DEPTCODE_2 =
		"agentTokenLimiter.deptCode = ? AND ";

	private static final String _FINDER_COLUMN_DEPTCODEANDTOKENTYPE_DEPTCODE_3 =
		"(agentTokenLimiter.deptCode IS NULL OR agentTokenLimiter.deptCode = '') AND ";

	private static final String
		_FINDER_COLUMN_DEPTCODEANDTOKENTYPE_TOKENTYPE_2 =
			"agentTokenLimiter.tokenType = ?";

	private static final String
		_FINDER_COLUMN_DEPTCODEANDTOKENTYPE_TOKENTYPE_3 =
			"(agentTokenLimiter.tokenType IS NULL OR agentTokenLimiter.tokenType = '')";

	public AgentTokenLimiterPersistenceImpl() {
		setModelClass(AgentTokenLimiter.class);

		setModelImplClass(AgentTokenLimiterImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the agent token limiter in the entity cache if it is enabled.
	 *
	 * @param agentTokenLimiter the agent token limiter
	 */
	@Override
	public void cacheResult(AgentTokenLimiter agentTokenLimiter) {
		entityCache.putResult(
			AgentTokenLimiterImpl.class, agentTokenLimiter.getPrimaryKey(),
			agentTokenLimiter);

		finderCache.putResult(
			_finderPathFetchBytoken,
			new Object[] {agentTokenLimiter.getToken()}, agentTokenLimiter);

		finderCache.putResult(
			_finderPathFetchBydeptCodeAndTokenType,
			new Object[] {
				agentTokenLimiter.getDeptCode(),
				agentTokenLimiter.getTokenType()
			},
			agentTokenLimiter);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the agent token limiters in the entity cache if it is enabled.
	 *
	 * @param agentTokenLimiters the agent token limiters
	 */
	@Override
	public void cacheResult(List<AgentTokenLimiter> agentTokenLimiters) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (agentTokenLimiters.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AgentTokenLimiter agentTokenLimiter : agentTokenLimiters) {
			if (entityCache.getResult(
					AgentTokenLimiterImpl.class,
					agentTokenLimiter.getPrimaryKey()) == null) {

				cacheResult(agentTokenLimiter);
			}
		}
	}

	/**
	 * Clears the cache for all agent token limiters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AgentTokenLimiterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the agent token limiter.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AgentTokenLimiter agentTokenLimiter) {
		entityCache.removeResult(
			AgentTokenLimiterImpl.class, agentTokenLimiter);
	}

	@Override
	public void clearCache(List<AgentTokenLimiter> agentTokenLimiters) {
		for (AgentTokenLimiter agentTokenLimiter : agentTokenLimiters) {
			entityCache.removeResult(
				AgentTokenLimiterImpl.class, agentTokenLimiter);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AgentTokenLimiterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AgentTokenLimiterModelImpl agentTokenLimiterModelImpl) {

		Object[] args = new Object[] {agentTokenLimiterModelImpl.getToken()};

		finderCache.putResult(
			_finderPathCountBytoken, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBytoken, args, agentTokenLimiterModelImpl, false);

		args = new Object[] {
			agentTokenLimiterModelImpl.getDeptCode(),
			agentTokenLimiterModelImpl.getTokenType()
		};

		finderCache.putResult(
			_finderPathCountBydeptCodeAndTokenType, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchBydeptCodeAndTokenType, args,
			agentTokenLimiterModelImpl, false);
	}

	/**
	 * Creates a new agent token limiter with the primary key. Does not add the agent token limiter to the database.
	 *
	 * @param agentTokenLimiterId the primary key for the new agent token limiter
	 * @return the new agent token limiter
	 */
	@Override
	public AgentTokenLimiter create(long agentTokenLimiterId) {
		AgentTokenLimiter agentTokenLimiter = new AgentTokenLimiterImpl();

		agentTokenLimiter.setNew(true);
		agentTokenLimiter.setPrimaryKey(agentTokenLimiterId);

		agentTokenLimiter.setCompanyId(CompanyThreadLocal.getCompanyId());

		return agentTokenLimiter;
	}

	/**
	 * Removes the agent token limiter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentTokenLimiterId the primary key of the agent token limiter
	 * @return the agent token limiter that was removed
	 * @throws NoSuchAgentTokenLimiterException if a agent token limiter with the primary key could not be found
	 */
	@Override
	public AgentTokenLimiter remove(long agentTokenLimiterId)
		throws NoSuchAgentTokenLimiterException {

		return remove((Serializable)agentTokenLimiterId);
	}

	/**
	 * Removes the agent token limiter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the agent token limiter
	 * @return the agent token limiter that was removed
	 * @throws NoSuchAgentTokenLimiterException if a agent token limiter with the primary key could not be found
	 */
	@Override
	public AgentTokenLimiter remove(Serializable primaryKey)
		throws NoSuchAgentTokenLimiterException {

		Session session = null;

		try {
			session = openSession();

			AgentTokenLimiter agentTokenLimiter =
				(AgentTokenLimiter)session.get(
					AgentTokenLimiterImpl.class, primaryKey);

			if (agentTokenLimiter == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAgentTokenLimiterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(agentTokenLimiter);
		}
		catch (NoSuchAgentTokenLimiterException noSuchEntityException) {
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
	protected AgentTokenLimiter removeImpl(
		AgentTokenLimiter agentTokenLimiter) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(agentTokenLimiter)) {
				agentTokenLimiter = (AgentTokenLimiter)session.get(
					AgentTokenLimiterImpl.class,
					agentTokenLimiter.getPrimaryKeyObj());
			}

			if (agentTokenLimiter != null) {
				session.delete(agentTokenLimiter);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (agentTokenLimiter != null) {
			clearCache(agentTokenLimiter);
		}

		return agentTokenLimiter;
	}

	@Override
	public AgentTokenLimiter updateImpl(AgentTokenLimiter agentTokenLimiter) {
		boolean isNew = agentTokenLimiter.isNew();

		if (!(agentTokenLimiter instanceof AgentTokenLimiterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(agentTokenLimiter.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					agentTokenLimiter);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in agentTokenLimiter proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AgentTokenLimiter implementation " +
					agentTokenLimiter.getClass());
		}

		AgentTokenLimiterModelImpl agentTokenLimiterModelImpl =
			(AgentTokenLimiterModelImpl)agentTokenLimiter;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (agentTokenLimiter.getCreateDate() == null)) {
			if (serviceContext == null) {
				agentTokenLimiter.setCreateDate(date);
			}
			else {
				agentTokenLimiter.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!agentTokenLimiterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				agentTokenLimiter.setModifiedDate(date);
			}
			else {
				agentTokenLimiter.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(agentTokenLimiter);
			}
			else {
				agentTokenLimiter = (AgentTokenLimiter)session.merge(
					agentTokenLimiter);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AgentTokenLimiterImpl.class, agentTokenLimiterModelImpl, false,
			true);

		cacheUniqueFindersCache(agentTokenLimiterModelImpl);

		if (isNew) {
			agentTokenLimiter.setNew(false);
		}

		agentTokenLimiter.resetOriginalValues();

		return agentTokenLimiter;
	}

	/**
	 * Returns the agent token limiter with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the agent token limiter
	 * @return the agent token limiter
	 * @throws NoSuchAgentTokenLimiterException if a agent token limiter with the primary key could not be found
	 */
	@Override
	public AgentTokenLimiter findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAgentTokenLimiterException {

		AgentTokenLimiter agentTokenLimiter = fetchByPrimaryKey(primaryKey);

		if (agentTokenLimiter == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAgentTokenLimiterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return agentTokenLimiter;
	}

	/**
	 * Returns the agent token limiter with the primary key or throws a <code>NoSuchAgentTokenLimiterException</code> if it could not be found.
	 *
	 * @param agentTokenLimiterId the primary key of the agent token limiter
	 * @return the agent token limiter
	 * @throws NoSuchAgentTokenLimiterException if a agent token limiter with the primary key could not be found
	 */
	@Override
	public AgentTokenLimiter findByPrimaryKey(long agentTokenLimiterId)
		throws NoSuchAgentTokenLimiterException {

		return findByPrimaryKey((Serializable)agentTokenLimiterId);
	}

	/**
	 * Returns the agent token limiter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentTokenLimiterId the primary key of the agent token limiter
	 * @return the agent token limiter, or <code>null</code> if a agent token limiter with the primary key could not be found
	 */
	@Override
	public AgentTokenLimiter fetchByPrimaryKey(long agentTokenLimiterId) {
		return fetchByPrimaryKey((Serializable)agentTokenLimiterId);
	}

	/**
	 * Returns all the agent token limiters.
	 *
	 * @return the agent token limiters
	 */
	@Override
	public List<AgentTokenLimiter> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent token limiters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentTokenLimiterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent token limiters
	 * @param end the upper bound of the range of agent token limiters (not inclusive)
	 * @return the range of agent token limiters
	 */
	@Override
	public List<AgentTokenLimiter> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent token limiters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentTokenLimiterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent token limiters
	 * @param end the upper bound of the range of agent token limiters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agent token limiters
	 */
	@Override
	public List<AgentTokenLimiter> findAll(
		int start, int end,
		OrderByComparator<AgentTokenLimiter> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent token limiters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentTokenLimiterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent token limiters
	 * @param end the upper bound of the range of agent token limiters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agent token limiters
	 */
	@Override
	public List<AgentTokenLimiter> findAll(
		int start, int end,
		OrderByComparator<AgentTokenLimiter> orderByComparator,
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

		List<AgentTokenLimiter> list = null;

		if (useFinderCache) {
			list = (List<AgentTokenLimiter>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AGENTTOKENLIMITER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AGENTTOKENLIMITER;

				sql = sql.concat(AgentTokenLimiterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AgentTokenLimiter>)QueryUtil.list(
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
	 * Removes all the agent token limiters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AgentTokenLimiter agentTokenLimiter : findAll()) {
			remove(agentTokenLimiter);
		}
	}

	/**
	 * Returns the number of agent token limiters.
	 *
	 * @return the number of agent token limiters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AGENTTOKENLIMITER);

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
		return "agentTokenLimiterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AGENTTOKENLIMITER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AgentTokenLimiterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the agent token limiter persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new AgentTokenLimiterModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", AgentTokenLimiter.class.getName()));

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

		_finderPathFetchBytoken = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBytoken",
			new String[] {String.class.getName()}, new String[] {"token"},
			true);

		_finderPathCountBytoken = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytoken",
			new String[] {String.class.getName()}, new String[] {"token"},
			false);

		_finderPathFetchBydeptCodeAndTokenType = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBydeptCodeAndTokenType",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"deptCode", "tokenType"}, true);

		_finderPathCountBydeptCodeAndTokenType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydeptCodeAndTokenType",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"deptCode", "tokenType"}, false);

		_setAgentTokenLimiterUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAgentTokenLimiterUtilPersistence(null);

		entityCache.removeCache(AgentTokenLimiterImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setAgentTokenLimiterUtilPersistence(
		AgentTokenLimiterPersistence agentTokenLimiterPersistence) {

		try {
			Field field = AgentTokenLimiterUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, agentTokenLimiterPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = APPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = APPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = APPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_AGENTTOKENLIMITER =
		"SELECT agentTokenLimiter FROM AgentTokenLimiter agentTokenLimiter";

	private static final String _SQL_SELECT_AGENTTOKENLIMITER_WHERE =
		"SELECT agentTokenLimiter FROM AgentTokenLimiter agentTokenLimiter WHERE ";

	private static final String _SQL_COUNT_AGENTTOKENLIMITER =
		"SELECT COUNT(agentTokenLimiter) FROM AgentTokenLimiter agentTokenLimiter";

	private static final String _SQL_COUNT_AGENTTOKENLIMITER_WHERE =
		"SELECT COUNT(agentTokenLimiter) FROM AgentTokenLimiter agentTokenLimiter WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "agentTokenLimiter.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AgentTokenLimiter exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AgentTokenLimiter exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AgentTokenLimiterPersistenceImpl.class);

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

	private static class AgentTokenLimiterModelArgumentsResolver
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

			AgentTokenLimiterModelImpl agentTokenLimiterModelImpl =
				(AgentTokenLimiterModelImpl)baseModel;

			long columnBitmask = agentTokenLimiterModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					agentTokenLimiterModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						agentTokenLimiterModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					agentTokenLimiterModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			AgentTokenLimiterModelImpl agentTokenLimiterModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						agentTokenLimiterModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = agentTokenLimiterModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}