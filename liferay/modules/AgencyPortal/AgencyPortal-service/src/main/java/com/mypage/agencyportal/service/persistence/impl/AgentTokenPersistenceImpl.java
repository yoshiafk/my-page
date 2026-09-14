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

import com.mypage.agencyportal.exception.NoSuchAgentTokenException;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.model.impl.AgentTokenImpl;
import com.mypage.agencyportal.model.impl.AgentTokenModelImpl;
import com.mypage.agencyportal.service.persistence.AgentTokenPersistence;
import com.mypage.agencyportal.service.persistence.AgentTokenUtil;
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
 * The persistence implementation for the agent token service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = AgentTokenPersistence.class)
public class AgentTokenPersistenceImpl
	extends BasePersistenceImpl<AgentToken> implements AgentTokenPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AgentTokenUtil</code> to access the agent token persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AgentTokenImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBydeptCode;
	private FinderPath _finderPathCountBydeptCode;

	/**
	 * Returns the agent token where deptCode = &#63; or throws a <code>NoSuchAgentTokenException</code> if it could not be found.
	 *
	 * @param deptCode the dept code
	 * @return the matching agent token
	 * @throws NoSuchAgentTokenException if a matching agent token could not be found
	 */
	@Override
	public AgentToken findBydeptCode(String deptCode)
		throws NoSuchAgentTokenException {

		AgentToken agentToken = fetchBydeptCode(deptCode);

		if (agentToken == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("deptCode=");
			sb.append(deptCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAgentTokenException(sb.toString());
		}

		return agentToken;
	}

	/**
	 * Returns the agent token where deptCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param deptCode the dept code
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	@Override
	public AgentToken fetchBydeptCode(String deptCode) {
		return fetchBydeptCode(deptCode, true);
	}

	/**
	 * Returns the agent token where deptCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param deptCode the dept code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	@Override
	public AgentToken fetchBydeptCode(String deptCode, boolean useFinderCache) {
		deptCode = Objects.toString(deptCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {deptCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBydeptCode, finderArgs, this);
		}

		if (result instanceof AgentToken) {
			AgentToken agentToken = (AgentToken)result;

			if (!Objects.equals(deptCode, agentToken.getDeptCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_AGENTTOKEN_WHERE);

			boolean bindDeptCode = false;

			if (deptCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_DEPTCODE_DEPTCODE_3);
			}
			else {
				bindDeptCode = true;

				sb.append(_FINDER_COLUMN_DEPTCODE_DEPTCODE_2);
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

				List<AgentToken> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBydeptCode, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {deptCode};
							}

							_log.warn(
								"AgentTokenPersistenceImpl.fetchBydeptCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AgentToken agentToken = list.get(0);

					result = agentToken;

					cacheResult(agentToken);
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
			return (AgentToken)result;
		}
	}

	/**
	 * Removes the agent token where deptCode = &#63; from the database.
	 *
	 * @param deptCode the dept code
	 * @return the agent token that was removed
	 */
	@Override
	public AgentToken removeBydeptCode(String deptCode)
		throws NoSuchAgentTokenException {

		AgentToken agentToken = findBydeptCode(deptCode);

		return remove(agentToken);
	}

	/**
	 * Returns the number of agent tokens where deptCode = &#63;.
	 *
	 * @param deptCode the dept code
	 * @return the number of matching agent tokens
	 */
	@Override
	public int countBydeptCode(String deptCode) {
		deptCode = Objects.toString(deptCode, "");

		FinderPath finderPath = _finderPathCountBydeptCode;

		Object[] finderArgs = new Object[] {deptCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTTOKEN_WHERE);

			boolean bindDeptCode = false;

			if (deptCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_DEPTCODE_DEPTCODE_3);
			}
			else {
				bindDeptCode = true;

				sb.append(_FINDER_COLUMN_DEPTCODE_DEPTCODE_2);
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

	private static final String _FINDER_COLUMN_DEPTCODE_DEPTCODE_2 =
		"agentToken.deptCode = ?";

	private static final String _FINDER_COLUMN_DEPTCODE_DEPTCODE_3 =
		"(agentToken.deptCode IS NULL OR agentToken.deptCode = '')";

	private FinderPath _finderPathFetchBytoken;
	private FinderPath _finderPathCountBytoken;

	/**
	 * Returns the agent token where token = &#63; or throws a <code>NoSuchAgentTokenException</code> if it could not be found.
	 *
	 * @param token the token
	 * @return the matching agent token
	 * @throws NoSuchAgentTokenException if a matching agent token could not be found
	 */
	@Override
	public AgentToken findBytoken(String token)
		throws NoSuchAgentTokenException {

		AgentToken agentToken = fetchBytoken(token);

		if (agentToken == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("token=");
			sb.append(token);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAgentTokenException(sb.toString());
		}

		return agentToken;
	}

	/**
	 * Returns the agent token where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param token the token
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	@Override
	public AgentToken fetchBytoken(String token) {
		return fetchBytoken(token, true);
	}

	/**
	 * Returns the agent token where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param token the token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	@Override
	public AgentToken fetchBytoken(String token, boolean useFinderCache) {
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

		if (result instanceof AgentToken) {
			AgentToken agentToken = (AgentToken)result;

			if (!Objects.equals(token, agentToken.getToken())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_AGENTTOKEN_WHERE);

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

				List<AgentToken> list = query.list();

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
								"AgentTokenPersistenceImpl.fetchBytoken(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AgentToken agentToken = list.get(0);

					result = agentToken;

					cacheResult(agentToken);
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
			return (AgentToken)result;
		}
	}

	/**
	 * Removes the agent token where token = &#63; from the database.
	 *
	 * @param token the token
	 * @return the agent token that was removed
	 */
	@Override
	public AgentToken removeBytoken(String token)
		throws NoSuchAgentTokenException {

		AgentToken agentToken = findBytoken(token);

		return remove(agentToken);
	}

	/**
	 * Returns the number of agent tokens where token = &#63;.
	 *
	 * @param token the token
	 * @return the number of matching agent tokens
	 */
	@Override
	public int countBytoken(String token) {
		token = Objects.toString(token, "");

		FinderPath finderPath = _finderPathCountBytoken;

		Object[] finderArgs = new Object[] {token};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTTOKEN_WHERE);

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
		"agentToken.token = ?";

	private static final String _FINDER_COLUMN_TOKEN_TOKEN_3 =
		"(agentToken.token IS NULL OR agentToken.token = '')";

	private FinderPath _finderPathFetchByapiRequestToken;
	private FinderPath _finderPathCountByapiRequestToken;

	/**
	 * Returns the agent token where apiRequestToken = &#63; or throws a <code>NoSuchAgentTokenException</code> if it could not be found.
	 *
	 * @param apiRequestToken the api request token
	 * @return the matching agent token
	 * @throws NoSuchAgentTokenException if a matching agent token could not be found
	 */
	@Override
	public AgentToken findByapiRequestToken(String apiRequestToken)
		throws NoSuchAgentTokenException {

		AgentToken agentToken = fetchByapiRequestToken(apiRequestToken);

		if (agentToken == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("apiRequestToken=");
			sb.append(apiRequestToken);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAgentTokenException(sb.toString());
		}

		return agentToken;
	}

	/**
	 * Returns the agent token where apiRequestToken = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param apiRequestToken the api request token
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	@Override
	public AgentToken fetchByapiRequestToken(String apiRequestToken) {
		return fetchByapiRequestToken(apiRequestToken, true);
	}

	/**
	 * Returns the agent token where apiRequestToken = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param apiRequestToken the api request token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching agent token, or <code>null</code> if a matching agent token could not be found
	 */
	@Override
	public AgentToken fetchByapiRequestToken(
		String apiRequestToken, boolean useFinderCache) {

		apiRequestToken = Objects.toString(apiRequestToken, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {apiRequestToken};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByapiRequestToken, finderArgs, this);
		}

		if (result instanceof AgentToken) {
			AgentToken agentToken = (AgentToken)result;

			if (!Objects.equals(
					apiRequestToken, agentToken.getApiRequestToken())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_AGENTTOKEN_WHERE);

			boolean bindApiRequestToken = false;

			if (apiRequestToken.isEmpty()) {
				sb.append(_FINDER_COLUMN_APIREQUESTTOKEN_APIREQUESTTOKEN_3);
			}
			else {
				bindApiRequestToken = true;

				sb.append(_FINDER_COLUMN_APIREQUESTTOKEN_APIREQUESTTOKEN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindApiRequestToken) {
					queryPos.add(apiRequestToken);
				}

				List<AgentToken> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByapiRequestToken, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {apiRequestToken};
							}

							_log.warn(
								"AgentTokenPersistenceImpl.fetchByapiRequestToken(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					AgentToken agentToken = list.get(0);

					result = agentToken;

					cacheResult(agentToken);
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
			return (AgentToken)result;
		}
	}

	/**
	 * Removes the agent token where apiRequestToken = &#63; from the database.
	 *
	 * @param apiRequestToken the api request token
	 * @return the agent token that was removed
	 */
	@Override
	public AgentToken removeByapiRequestToken(String apiRequestToken)
		throws NoSuchAgentTokenException {

		AgentToken agentToken = findByapiRequestToken(apiRequestToken);

		return remove(agentToken);
	}

	/**
	 * Returns the number of agent tokens where apiRequestToken = &#63;.
	 *
	 * @param apiRequestToken the api request token
	 * @return the number of matching agent tokens
	 */
	@Override
	public int countByapiRequestToken(String apiRequestToken) {
		apiRequestToken = Objects.toString(apiRequestToken, "");

		FinderPath finderPath = _finderPathCountByapiRequestToken;

		Object[] finderArgs = new Object[] {apiRequestToken};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENTTOKEN_WHERE);

			boolean bindApiRequestToken = false;

			if (apiRequestToken.isEmpty()) {
				sb.append(_FINDER_COLUMN_APIREQUESTTOKEN_APIREQUESTTOKEN_3);
			}
			else {
				bindApiRequestToken = true;

				sb.append(_FINDER_COLUMN_APIREQUESTTOKEN_APIREQUESTTOKEN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindApiRequestToken) {
					queryPos.add(apiRequestToken);
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
		_FINDER_COLUMN_APIREQUESTTOKEN_APIREQUESTTOKEN_2 =
			"agentToken.apiRequestToken = ?";

	private static final String
		_FINDER_COLUMN_APIREQUESTTOKEN_APIREQUESTTOKEN_3 =
			"(agentToken.apiRequestToken IS NULL OR agentToken.apiRequestToken = '')";

	public AgentTokenPersistenceImpl() {
		setModelClass(AgentToken.class);

		setModelImplClass(AgentTokenImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the agent token in the entity cache if it is enabled.
	 *
	 * @param agentToken the agent token
	 */
	@Override
	public void cacheResult(AgentToken agentToken) {
		entityCache.putResult(
			AgentTokenImpl.class, agentToken.getPrimaryKey(), agentToken);

		finderCache.putResult(
			_finderPathFetchBydeptCode, new Object[] {agentToken.getDeptCode()},
			agentToken);

		finderCache.putResult(
			_finderPathFetchBytoken, new Object[] {agentToken.getToken()},
			agentToken);

		finderCache.putResult(
			_finderPathFetchByapiRequestToken,
			new Object[] {agentToken.getApiRequestToken()}, agentToken);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the agent tokens in the entity cache if it is enabled.
	 *
	 * @param agentTokens the agent tokens
	 */
	@Override
	public void cacheResult(List<AgentToken> agentTokens) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (agentTokens.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AgentToken agentToken : agentTokens) {
			if (entityCache.getResult(
					AgentTokenImpl.class, agentToken.getPrimaryKey()) == null) {

				cacheResult(agentToken);
			}
		}
	}

	/**
	 * Clears the cache for all agent tokens.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AgentTokenImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the agent token.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AgentToken agentToken) {
		entityCache.removeResult(AgentTokenImpl.class, agentToken);
	}

	@Override
	public void clearCache(List<AgentToken> agentTokens) {
		for (AgentToken agentToken : agentTokens) {
			entityCache.removeResult(AgentTokenImpl.class, agentToken);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AgentTokenImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AgentTokenModelImpl agentTokenModelImpl) {

		Object[] args = new Object[] {agentTokenModelImpl.getDeptCode()};

		finderCache.putResult(
			_finderPathCountBydeptCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBydeptCode, args, agentTokenModelImpl, false);

		args = new Object[] {agentTokenModelImpl.getToken()};

		finderCache.putResult(
			_finderPathCountBytoken, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBytoken, args, agentTokenModelImpl, false);

		args = new Object[] {agentTokenModelImpl.getApiRequestToken()};

		finderCache.putResult(
			_finderPathCountByapiRequestToken, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByapiRequestToken, args, agentTokenModelImpl,
			false);
	}

	/**
	 * Creates a new agent token with the primary key. Does not add the agent token to the database.
	 *
	 * @param agentTokenId the primary key for the new agent token
	 * @return the new agent token
	 */
	@Override
	public AgentToken create(long agentTokenId) {
		AgentToken agentToken = new AgentTokenImpl();

		agentToken.setNew(true);
		agentToken.setPrimaryKey(agentTokenId);

		agentToken.setCompanyId(CompanyThreadLocal.getCompanyId());

		return agentToken;
	}

	/**
	 * Removes the agent token with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agentTokenId the primary key of the agent token
	 * @return the agent token that was removed
	 * @throws NoSuchAgentTokenException if a agent token with the primary key could not be found
	 */
	@Override
	public AgentToken remove(long agentTokenId)
		throws NoSuchAgentTokenException {

		return remove((Serializable)agentTokenId);
	}

	/**
	 * Removes the agent token with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the agent token
	 * @return the agent token that was removed
	 * @throws NoSuchAgentTokenException if a agent token with the primary key could not be found
	 */
	@Override
	public AgentToken remove(Serializable primaryKey)
		throws NoSuchAgentTokenException {

		Session session = null;

		try {
			session = openSession();

			AgentToken agentToken = (AgentToken)session.get(
				AgentTokenImpl.class, primaryKey);

			if (agentToken == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAgentTokenException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(agentToken);
		}
		catch (NoSuchAgentTokenException noSuchEntityException) {
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
	protected AgentToken removeImpl(AgentToken agentToken) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(agentToken)) {
				agentToken = (AgentToken)session.get(
					AgentTokenImpl.class, agentToken.getPrimaryKeyObj());
			}

			if (agentToken != null) {
				session.delete(agentToken);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (agentToken != null) {
			clearCache(agentToken);
		}

		return agentToken;
	}

	@Override
	public AgentToken updateImpl(AgentToken agentToken) {
		boolean isNew = agentToken.isNew();

		if (!(agentToken instanceof AgentTokenModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(agentToken.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(agentToken);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in agentToken proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AgentToken implementation " +
					agentToken.getClass());
		}

		AgentTokenModelImpl agentTokenModelImpl =
			(AgentTokenModelImpl)agentToken;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (agentToken.getCreateDate() == null)) {
			if (serviceContext == null) {
				agentToken.setCreateDate(date);
			}
			else {
				agentToken.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!agentTokenModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				agentToken.setModifiedDate(date);
			}
			else {
				agentToken.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(agentToken);
			}
			else {
				agentToken = (AgentToken)session.merge(agentToken);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AgentTokenImpl.class, agentTokenModelImpl, false, true);

		cacheUniqueFindersCache(agentTokenModelImpl);

		if (isNew) {
			agentToken.setNew(false);
		}

		agentToken.resetOriginalValues();

		return agentToken;
	}

	/**
	 * Returns the agent token with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the agent token
	 * @return the agent token
	 * @throws NoSuchAgentTokenException if a agent token with the primary key could not be found
	 */
	@Override
	public AgentToken findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAgentTokenException {

		AgentToken agentToken = fetchByPrimaryKey(primaryKey);

		if (agentToken == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAgentTokenException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return agentToken;
	}

	/**
	 * Returns the agent token with the primary key or throws a <code>NoSuchAgentTokenException</code> if it could not be found.
	 *
	 * @param agentTokenId the primary key of the agent token
	 * @return the agent token
	 * @throws NoSuchAgentTokenException if a agent token with the primary key could not be found
	 */
	@Override
	public AgentToken findByPrimaryKey(long agentTokenId)
		throws NoSuchAgentTokenException {

		return findByPrimaryKey((Serializable)agentTokenId);
	}

	/**
	 * Returns the agent token with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agentTokenId the primary key of the agent token
	 * @return the agent token, or <code>null</code> if a agent token with the primary key could not be found
	 */
	@Override
	public AgentToken fetchByPrimaryKey(long agentTokenId) {
		return fetchByPrimaryKey((Serializable)agentTokenId);
	}

	/**
	 * Returns all the agent tokens.
	 *
	 * @return the agent tokens
	 */
	@Override
	public List<AgentToken> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agent tokens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentTokenModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent tokens
	 * @param end the upper bound of the range of agent tokens (not inclusive)
	 * @return the range of agent tokens
	 */
	@Override
	public List<AgentToken> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the agent tokens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentTokenModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent tokens
	 * @param end the upper bound of the range of agent tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agent tokens
	 */
	@Override
	public List<AgentToken> findAll(
		int start, int end, OrderByComparator<AgentToken> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agent tokens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgentTokenModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agent tokens
	 * @param end the upper bound of the range of agent tokens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agent tokens
	 */
	@Override
	public List<AgentToken> findAll(
		int start, int end, OrderByComparator<AgentToken> orderByComparator,
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

		List<AgentToken> list = null;

		if (useFinderCache) {
			list = (List<AgentToken>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AGENTTOKEN);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AGENTTOKEN;

				sql = sql.concat(AgentTokenModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AgentToken>)QueryUtil.list(
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
	 * Removes all the agent tokens from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AgentToken agentToken : findAll()) {
			remove(agentToken);
		}
	}

	/**
	 * Returns the number of agent tokens.
	 *
	 * @return the number of agent tokens
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AGENTTOKEN);

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
		return "agentTokenId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AGENTTOKEN;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AgentTokenModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the agent token persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new AgentTokenModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", AgentToken.class.getName()));

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

		_finderPathFetchBydeptCode = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBydeptCode",
			new String[] {String.class.getName()}, new String[] {"deptCode"},
			true);

		_finderPathCountBydeptCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydeptCode",
			new String[] {String.class.getName()}, new String[] {"deptCode"},
			false);

		_finderPathFetchBytoken = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBytoken",
			new String[] {String.class.getName()}, new String[] {"token"},
			true);

		_finderPathCountBytoken = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytoken",
			new String[] {String.class.getName()}, new String[] {"token"},
			false);

		_finderPathFetchByapiRequestToken = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByapiRequestToken",
			new String[] {String.class.getName()},
			new String[] {"apiRequestToken"}, true);

		_finderPathCountByapiRequestToken = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByapiRequestToken",
			new String[] {String.class.getName()},
			new String[] {"apiRequestToken"}, false);

		_setAgentTokenUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAgentTokenUtilPersistence(null);

		entityCache.removeCache(AgentTokenImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setAgentTokenUtilPersistence(
		AgentTokenPersistence agentTokenPersistence) {

		try {
			Field field = AgentTokenUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, agentTokenPersistence);
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

	private static final String _SQL_SELECT_AGENTTOKEN =
		"SELECT agentToken FROM AgentToken agentToken";

	private static final String _SQL_SELECT_AGENTTOKEN_WHERE =
		"SELECT agentToken FROM AgentToken agentToken WHERE ";

	private static final String _SQL_COUNT_AGENTTOKEN =
		"SELECT COUNT(agentToken) FROM AgentToken agentToken";

	private static final String _SQL_COUNT_AGENTTOKEN_WHERE =
		"SELECT COUNT(agentToken) FROM AgentToken agentToken WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "agentToken.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AgentToken exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AgentToken exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AgentTokenPersistenceImpl.class);

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

	private static class AgentTokenModelArgumentsResolver
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

			AgentTokenModelImpl agentTokenModelImpl =
				(AgentTokenModelImpl)baseModel;

			long columnBitmask = agentTokenModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(agentTokenModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						agentTokenModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(agentTokenModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			AgentTokenModelImpl agentTokenModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = agentTokenModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = agentTokenModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}