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

package com.mypage.user.service.persistence.impl;

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
import com.liferay.portal.kernel.util.StringUtil;

import com.mypage.user.exception.NoSuchMypageUserException;
import com.mypage.user.model.MypageUser;
import com.mypage.user.model.impl.MypageUserImpl;
import com.mypage.user.model.impl.MypageUserModelImpl;
import com.mypage.user.service.persistence.MypageUserPersistence;
import com.mypage.user.service.persistence.MypageUserUtil;
import com.mypage.user.service.persistence.impl.constants.MPUPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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
 * The persistence implementation for the mypage user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MypageUserPersistence.class)
public class MypageUserPersistenceImpl
	extends BasePersistenceImpl<MypageUser> implements MypageUserPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MypageUserUtil</code> to access the mypage user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MypageUserImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBygetByLiferayUserId;
	private FinderPath _finderPathCountBygetByLiferayUserId;

	/**
	 * Returns the mypage user where liferayUserId = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	@Override
	public MypageUser findBygetByLiferayUserId(long liferayUserId)
		throws NoSuchMypageUserException {

		MypageUser mypageUser = fetchBygetByLiferayUserId(liferayUserId);

		if (mypageUser == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("liferayUserId=");
			sb.append(liferayUserId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMypageUserException(sb.toString());
		}

		return mypageUser;
	}

	/**
	 * Returns the mypage user where liferayUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	@Override
	public MypageUser fetchBygetByLiferayUserId(long liferayUserId) {
		return fetchBygetByLiferayUserId(liferayUserId, true);
	}

	/**
	 * Returns the mypage user where liferayUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param liferayUserId the liferay user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	@Override
	public MypageUser fetchBygetByLiferayUserId(
		long liferayUserId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {liferayUserId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBygetByLiferayUserId, finderArgs, this);
		}

		if (result instanceof MypageUser) {
			MypageUser mypageUser = (MypageUser)result;

			if (liferayUserId != mypageUser.getLiferayUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MYPAGEUSER_WHERE);

			sb.append(_FINDER_COLUMN_GETBYLIFERAYUSERID_LIFERAYUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(liferayUserId);

				List<MypageUser> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBygetByLiferayUserId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {liferayUserId};
							}

							_log.warn(
								"MypageUserPersistenceImpl.fetchBygetByLiferayUserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MypageUser mypageUser = list.get(0);

					result = mypageUser;

					cacheResult(mypageUser);
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
			return (MypageUser)result;
		}
	}

	/**
	 * Removes the mypage user where liferayUserId = &#63; from the database.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the mypage user that was removed
	 */
	@Override
	public MypageUser removeBygetByLiferayUserId(long liferayUserId)
		throws NoSuchMypageUserException {

		MypageUser mypageUser = findBygetByLiferayUserId(liferayUserId);

		return remove(mypageUser);
	}

	/**
	 * Returns the number of mypage users where liferayUserId = &#63;.
	 *
	 * @param liferayUserId the liferay user ID
	 * @return the number of matching mypage users
	 */
	@Override
	public int countBygetByLiferayUserId(long liferayUserId) {
		FinderPath finderPath = _finderPathCountBygetByLiferayUserId;

		Object[] finderArgs = new Object[] {liferayUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MYPAGEUSER_WHERE);

			sb.append(_FINDER_COLUMN_GETBYLIFERAYUSERID_LIFERAYUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(liferayUserId);

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
		_FINDER_COLUMN_GETBYLIFERAYUSERID_LIFERAYUSERID_2 =
			"mypageUser.liferayUserId = ?";

	private FinderPath _finderPathFetchBycreditWalletId;
	private FinderPath _finderPathCountBycreditWalletId;

	/**
	 * Returns the mypage user where creditWalletId = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	@Override
	public MypageUser findBycreditWalletId(long creditWalletId)
		throws NoSuchMypageUserException {

		MypageUser mypageUser = fetchBycreditWalletId(creditWalletId);

		if (mypageUser == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("creditWalletId=");
			sb.append(creditWalletId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMypageUserException(sb.toString());
		}

		return mypageUser;
	}

	/**
	 * Returns the mypage user where creditWalletId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	@Override
	public MypageUser fetchBycreditWalletId(long creditWalletId) {
		return fetchBycreditWalletId(creditWalletId, true);
	}

	/**
	 * Returns the mypage user where creditWalletId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	@Override
	public MypageUser fetchBycreditWalletId(
		long creditWalletId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {creditWalletId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBycreditWalletId, finderArgs, this);
		}

		if (result instanceof MypageUser) {
			MypageUser mypageUser = (MypageUser)result;

			if (creditWalletId != mypageUser.getCreditWalletId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MYPAGEUSER_WHERE);

			sb.append(_FINDER_COLUMN_CREDITWALLETID_CREDITWALLETID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(creditWalletId);

				List<MypageUser> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBycreditWalletId, finderArgs, list);
					}
				}
				else {
					MypageUser mypageUser = list.get(0);

					result = mypageUser;

					cacheResult(mypageUser);
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
			return (MypageUser)result;
		}
	}

	/**
	 * Removes the mypage user where creditWalletId = &#63; from the database.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the mypage user that was removed
	 */
	@Override
	public MypageUser removeBycreditWalletId(long creditWalletId)
		throws NoSuchMypageUserException {

		MypageUser mypageUser = findBycreditWalletId(creditWalletId);

		return remove(mypageUser);
	}

	/**
	 * Returns the number of mypage users where creditWalletId = &#63;.
	 *
	 * @param creditWalletId the credit wallet ID
	 * @return the number of matching mypage users
	 */
	@Override
	public int countBycreditWalletId(long creditWalletId) {
		FinderPath finderPath = _finderPathCountBycreditWalletId;

		Object[] finderArgs = new Object[] {creditWalletId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MYPAGEUSER_WHERE);

			sb.append(_FINDER_COLUMN_CREDITWALLETID_CREDITWALLETID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(creditWalletId);

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

	private static final String _FINDER_COLUMN_CREDITWALLETID_CREDITWALLETID_2 =
		"mypageUser.creditWalletId = ?";

	private FinderPath _finderPathFetchByPrettyUrl;
	private FinderPath _finderPathCountByPrettyUrl;

	/**
	 * Returns the mypage user where prettyUrl = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param prettyUrl the pretty url
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	@Override
	public MypageUser findByPrettyUrl(String prettyUrl)
		throws NoSuchMypageUserException {

		MypageUser mypageUser = fetchByPrettyUrl(prettyUrl);

		if (mypageUser == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("prettyUrl=");
			sb.append(prettyUrl);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMypageUserException(sb.toString());
		}

		return mypageUser;
	}

	/**
	 * Returns the mypage user where prettyUrl = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param prettyUrl the pretty url
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	@Override
	public MypageUser fetchByPrettyUrl(String prettyUrl) {
		return fetchByPrettyUrl(prettyUrl, true);
	}

	/**
	 * Returns the mypage user where prettyUrl = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param prettyUrl the pretty url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	@Override
	public MypageUser fetchByPrettyUrl(
		String prettyUrl, boolean useFinderCache) {

		prettyUrl = Objects.toString(prettyUrl, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {prettyUrl};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByPrettyUrl, finderArgs, this);
		}

		if (result instanceof MypageUser) {
			MypageUser mypageUser = (MypageUser)result;

			if (!Objects.equals(prettyUrl, mypageUser.getPrettyUrl())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MYPAGEUSER_WHERE);

			boolean bindPrettyUrl = false;

			if (prettyUrl.isEmpty()) {
				sb.append(_FINDER_COLUMN_PRETTYURL_PRETTYURL_3);
			}
			else {
				bindPrettyUrl = true;

				sb.append(_FINDER_COLUMN_PRETTYURL_PRETTYURL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPrettyUrl) {
					queryPos.add(prettyUrl);
				}

				List<MypageUser> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByPrettyUrl, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {prettyUrl};
							}

							_log.warn(
								"MypageUserPersistenceImpl.fetchByPrettyUrl(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MypageUser mypageUser = list.get(0);

					result = mypageUser;

					cacheResult(mypageUser);
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
			return (MypageUser)result;
		}
	}

	/**
	 * Removes the mypage user where prettyUrl = &#63; from the database.
	 *
	 * @param prettyUrl the pretty url
	 * @return the mypage user that was removed
	 */
	@Override
	public MypageUser removeByPrettyUrl(String prettyUrl)
		throws NoSuchMypageUserException {

		MypageUser mypageUser = findByPrettyUrl(prettyUrl);

		return remove(mypageUser);
	}

	/**
	 * Returns the number of mypage users where prettyUrl = &#63;.
	 *
	 * @param prettyUrl the pretty url
	 * @return the number of matching mypage users
	 */
	@Override
	public int countByPrettyUrl(String prettyUrl) {
		prettyUrl = Objects.toString(prettyUrl, "");

		FinderPath finderPath = _finderPathCountByPrettyUrl;

		Object[] finderArgs = new Object[] {prettyUrl};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MYPAGEUSER_WHERE);

			boolean bindPrettyUrl = false;

			if (prettyUrl.isEmpty()) {
				sb.append(_FINDER_COLUMN_PRETTYURL_PRETTYURL_3);
			}
			else {
				bindPrettyUrl = true;

				sb.append(_FINDER_COLUMN_PRETTYURL_PRETTYURL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPrettyUrl) {
					queryPos.add(prettyUrl);
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

	private static final String _FINDER_COLUMN_PRETTYURL_PRETTYURL_2 =
		"mypageUser.prettyUrl = ?";

	private static final String _FINDER_COLUMN_PRETTYURL_PRETTYURL_3 =
		"(mypageUser.prettyUrl IS NULL OR mypageUser.prettyUrl = '')";

	private FinderPath _finderPathFetchByAgentCode;
	private FinderPath _finderPathCountByAgentCode;

	/**
	 * Returns the mypage user where code = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	@Override
	public MypageUser findByAgentCode(String code)
		throws NoSuchMypageUserException {

		MypageUser mypageUser = fetchByAgentCode(code);

		if (mypageUser == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("code=");
			sb.append(code);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMypageUserException(sb.toString());
		}

		return mypageUser;
	}

	/**
	 * Returns the mypage user where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	@Override
	public MypageUser fetchByAgentCode(String code) {
		return fetchByAgentCode(code, true);
	}

	/**
	 * Returns the mypage user where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	@Override
	public MypageUser fetchByAgentCode(String code, boolean useFinderCache) {
		code = Objects.toString(code, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {code};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByAgentCode, finderArgs, this);
		}

		if (result instanceof MypageUser) {
			MypageUser mypageUser = (MypageUser)result;

			if (!Objects.equals(code, mypageUser.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MYPAGEUSER_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_AGENTCODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_AGENTCODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
				}

				List<MypageUser> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByAgentCode, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {code};
							}

							_log.warn(
								"MypageUserPersistenceImpl.fetchByAgentCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MypageUser mypageUser = list.get(0);

					result = mypageUser;

					cacheResult(mypageUser);
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
			return (MypageUser)result;
		}
	}

	/**
	 * Removes the mypage user where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the mypage user that was removed
	 */
	@Override
	public MypageUser removeByAgentCode(String code)
		throws NoSuchMypageUserException {

		MypageUser mypageUser = findByAgentCode(code);

		return remove(mypageUser);
	}

	/**
	 * Returns the number of mypage users where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching mypage users
	 */
	@Override
	public int countByAgentCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByAgentCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MYPAGEUSER_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_AGENTCODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_AGENTCODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_AGENTCODE_CODE_2 =
		"mypageUser.code = ?";

	private static final String _FINDER_COLUMN_AGENTCODE_CODE_3 =
		"(mypageUser.code IS NULL OR mypageUser.code = '')";

	private FinderPath _finderPathFetchByEmailAddress;
	private FinderPath _finderPathCountByEmailAddress;

	/**
	 * Returns the mypage user where email = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param email the email
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	@Override
	public MypageUser findByEmailAddress(String email)
		throws NoSuchMypageUserException {

		MypageUser mypageUser = fetchByEmailAddress(email);

		if (mypageUser == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("email=");
			sb.append(email);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMypageUserException(sb.toString());
		}

		return mypageUser;
	}

	/**
	 * Returns the mypage user where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	@Override
	public MypageUser fetchByEmailAddress(String email) {
		return fetchByEmailAddress(email, true);
	}

	/**
	 * Returns the mypage user where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	@Override
	public MypageUser fetchByEmailAddress(
		String email, boolean useFinderCache) {

		email = Objects.toString(email, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {email};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByEmailAddress, finderArgs, this);
		}

		if (result instanceof MypageUser) {
			MypageUser mypageUser = (MypageUser)result;

			if (!Objects.equals(email, mypageUser.getEmail())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MYPAGEUSER_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAIL_2);
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

				List<MypageUser> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByEmailAddress, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {email};
							}

							_log.warn(
								"MypageUserPersistenceImpl.fetchByEmailAddress(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MypageUser mypageUser = list.get(0);

					result = mypageUser;

					cacheResult(mypageUser);
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
			return (MypageUser)result;
		}
	}

	/**
	 * Removes the mypage user where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the mypage user that was removed
	 */
	@Override
	public MypageUser removeByEmailAddress(String email)
		throws NoSuchMypageUserException {

		MypageUser mypageUser = findByEmailAddress(email);

		return remove(mypageUser);
	}

	/**
	 * Returns the number of mypage users where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching mypage users
	 */
	@Override
	public int countByEmailAddress(String email) {
		email = Objects.toString(email, "");

		FinderPath finderPath = _finderPathCountByEmailAddress;

		Object[] finderArgs = new Object[] {email};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MYPAGEUSER_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAIL_2);
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

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAIL_2 =
		"mypageUser.email = ?";

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAIL_3 =
		"(mypageUser.email IS NULL OR mypageUser.email = '')";

	private FinderPath _finderPathFetchByDeptoreCode;
	private FinderPath _finderPathCountByDeptoreCode;

	/**
	 * Returns the mypage user where deptoreCode = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param deptoreCode the deptore code
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	@Override
	public MypageUser findByDeptoreCode(String deptoreCode)
		throws NoSuchMypageUserException {

		MypageUser mypageUser = fetchByDeptoreCode(deptoreCode);

		if (mypageUser == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("deptoreCode=");
			sb.append(deptoreCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMypageUserException(sb.toString());
		}

		return mypageUser;
	}

	/**
	 * Returns the mypage user where deptoreCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param deptoreCode the deptore code
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	@Override
	public MypageUser fetchByDeptoreCode(String deptoreCode) {
		return fetchByDeptoreCode(deptoreCode, true);
	}

	/**
	 * Returns the mypage user where deptoreCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param deptoreCode the deptore code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	@Override
	public MypageUser fetchByDeptoreCode(
		String deptoreCode, boolean useFinderCache) {

		deptoreCode = Objects.toString(deptoreCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {deptoreCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDeptoreCode, finderArgs, this);
		}

		if (result instanceof MypageUser) {
			MypageUser mypageUser = (MypageUser)result;

			if (!Objects.equals(deptoreCode, mypageUser.getDeptoreCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MYPAGEUSER_WHERE);

			boolean bindDeptoreCode = false;

			if (deptoreCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_DEPTORECODE_DEPTORECODE_3);
			}
			else {
				bindDeptoreCode = true;

				sb.append(_FINDER_COLUMN_DEPTORECODE_DEPTORECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDeptoreCode) {
					queryPos.add(deptoreCode);
				}

				List<MypageUser> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDeptoreCode, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {deptoreCode};
							}

							_log.warn(
								"MypageUserPersistenceImpl.fetchByDeptoreCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MypageUser mypageUser = list.get(0);

					result = mypageUser;

					cacheResult(mypageUser);
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
			return (MypageUser)result;
		}
	}

	/**
	 * Removes the mypage user where deptoreCode = &#63; from the database.
	 *
	 * @param deptoreCode the deptore code
	 * @return the mypage user that was removed
	 */
	@Override
	public MypageUser removeByDeptoreCode(String deptoreCode)
		throws NoSuchMypageUserException {

		MypageUser mypageUser = findByDeptoreCode(deptoreCode);

		return remove(mypageUser);
	}

	/**
	 * Returns the number of mypage users where deptoreCode = &#63;.
	 *
	 * @param deptoreCode the deptore code
	 * @return the number of matching mypage users
	 */
	@Override
	public int countByDeptoreCode(String deptoreCode) {
		deptoreCode = Objects.toString(deptoreCode, "");

		FinderPath finderPath = _finderPathCountByDeptoreCode;

		Object[] finderArgs = new Object[] {deptoreCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MYPAGEUSER_WHERE);

			boolean bindDeptoreCode = false;

			if (deptoreCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_DEPTORECODE_DEPTORECODE_3);
			}
			else {
				bindDeptoreCode = true;

				sb.append(_FINDER_COLUMN_DEPTORECODE_DEPTORECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDeptoreCode) {
					queryPos.add(deptoreCode);
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

	private static final String _FINDER_COLUMN_DEPTORECODE_DEPTORECODE_2 =
		"mypageUser.deptoreCode = ?";

	private static final String _FINDER_COLUMN_DEPTORECODE_DEPTORECODE_3 =
		"(mypageUser.deptoreCode IS NULL OR mypageUser.deptoreCode = '')";

	private FinderPath _finderPathFetchByRoleId;
	private FinderPath _finderPathCountByRoleId;

	/**
	 * Returns the mypage user where mypageUserRoleId = &#63; or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the matching mypage user
	 * @throws NoSuchMypageUserException if a matching mypage user could not be found
	 */
	@Override
	public MypageUser findByRoleId(long mypageUserRoleId)
		throws NoSuchMypageUserException {

		MypageUser mypageUser = fetchByRoleId(mypageUserRoleId);

		if (mypageUser == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("mypageUserRoleId=");
			sb.append(mypageUserRoleId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMypageUserException(sb.toString());
		}

		return mypageUser;
	}

	/**
	 * Returns the mypage user where mypageUserRoleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	@Override
	public MypageUser fetchByRoleId(long mypageUserRoleId) {
		return fetchByRoleId(mypageUserRoleId, true);
	}

	/**
	 * Returns the mypage user where mypageUserRoleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching mypage user, or <code>null</code> if a matching mypage user could not be found
	 */
	@Override
	public MypageUser fetchByRoleId(
		long mypageUserRoleId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {mypageUserRoleId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByRoleId, finderArgs, this);
		}

		if (result instanceof MypageUser) {
			MypageUser mypageUser = (MypageUser)result;

			if (mypageUserRoleId != mypageUser.getMypageUserRoleId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MYPAGEUSER_WHERE);

			sb.append(_FINDER_COLUMN_ROLEID_MYPAGEUSERROLEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserRoleId);

				List<MypageUser> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByRoleId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {mypageUserRoleId};
							}

							_log.warn(
								"MypageUserPersistenceImpl.fetchByRoleId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MypageUser mypageUser = list.get(0);

					result = mypageUser;

					cacheResult(mypageUser);
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
			return (MypageUser)result;
		}
	}

	/**
	 * Removes the mypage user where mypageUserRoleId = &#63; from the database.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the mypage user that was removed
	 */
	@Override
	public MypageUser removeByRoleId(long mypageUserRoleId)
		throws NoSuchMypageUserException {

		MypageUser mypageUser = findByRoleId(mypageUserRoleId);

		return remove(mypageUser);
	}

	/**
	 * Returns the number of mypage users where mypageUserRoleId = &#63;.
	 *
	 * @param mypageUserRoleId the mypage user role ID
	 * @return the number of matching mypage users
	 */
	@Override
	public int countByRoleId(long mypageUserRoleId) {
		FinderPath finderPath = _finderPathCountByRoleId;

		Object[] finderArgs = new Object[] {mypageUserRoleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MYPAGEUSER_WHERE);

			sb.append(_FINDER_COLUMN_ROLEID_MYPAGEUSERROLEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mypageUserRoleId);

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

	private static final String _FINDER_COLUMN_ROLEID_MYPAGEUSERROLEID_2 =
		"mypageUser.mypageUserRoleId = ?";

	public MypageUserPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MypageUser.class);

		setModelImplClass(MypageUserImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the mypage user in the entity cache if it is enabled.
	 *
	 * @param mypageUser the mypage user
	 */
	@Override
	public void cacheResult(MypageUser mypageUser) {
		entityCache.putResult(
			MypageUserImpl.class, mypageUser.getPrimaryKey(), mypageUser);

		finderCache.putResult(
			_finderPathFetchBygetByLiferayUserId,
			new Object[] {mypageUser.getLiferayUserId()}, mypageUser);

		finderCache.putResult(
			_finderPathFetchBycreditWalletId,
			new Object[] {mypageUser.getCreditWalletId()}, mypageUser);

		finderCache.putResult(
			_finderPathFetchByPrettyUrl,
			new Object[] {mypageUser.getPrettyUrl()}, mypageUser);

		finderCache.putResult(
			_finderPathFetchByAgentCode, new Object[] {mypageUser.getCode()},
			mypageUser);

		finderCache.putResult(
			_finderPathFetchByEmailAddress,
			new Object[] {mypageUser.getEmail()}, mypageUser);

		finderCache.putResult(
			_finderPathFetchByDeptoreCode,
			new Object[] {mypageUser.getDeptoreCode()}, mypageUser);

		finderCache.putResult(
			_finderPathFetchByRoleId,
			new Object[] {mypageUser.getMypageUserRoleId()}, mypageUser);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the mypage users in the entity cache if it is enabled.
	 *
	 * @param mypageUsers the mypage users
	 */
	@Override
	public void cacheResult(List<MypageUser> mypageUsers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (mypageUsers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MypageUser mypageUser : mypageUsers) {
			if (entityCache.getResult(
					MypageUserImpl.class, mypageUser.getPrimaryKey()) == null) {

				cacheResult(mypageUser);
			}
		}
	}

	/**
	 * Clears the cache for all mypage users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MypageUserImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the mypage user.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MypageUser mypageUser) {
		entityCache.removeResult(MypageUserImpl.class, mypageUser);
	}

	@Override
	public void clearCache(List<MypageUser> mypageUsers) {
		for (MypageUser mypageUser : mypageUsers) {
			entityCache.removeResult(MypageUserImpl.class, mypageUser);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MypageUserImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		MypageUserModelImpl mypageUserModelImpl) {

		Object[] args = new Object[] {mypageUserModelImpl.getLiferayUserId()};

		finderCache.putResult(
			_finderPathCountBygetByLiferayUserId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBygetByLiferayUserId, args, mypageUserModelImpl,
			false);

		args = new Object[] {mypageUserModelImpl.getCreditWalletId()};

		finderCache.putResult(
			_finderPathCountBycreditWalletId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBycreditWalletId, args, mypageUserModelImpl, false);

		args = new Object[] {mypageUserModelImpl.getPrettyUrl()};

		finderCache.putResult(
			_finderPathCountByPrettyUrl, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByPrettyUrl, args, mypageUserModelImpl, false);

		args = new Object[] {mypageUserModelImpl.getCode()};

		finderCache.putResult(
			_finderPathCountByAgentCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByAgentCode, args, mypageUserModelImpl, false);

		args = new Object[] {mypageUserModelImpl.getEmail()};

		finderCache.putResult(
			_finderPathCountByEmailAddress, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByEmailAddress, args, mypageUserModelImpl, false);

		args = new Object[] {mypageUserModelImpl.getDeptoreCode()};

		finderCache.putResult(
			_finderPathCountByDeptoreCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByDeptoreCode, args, mypageUserModelImpl, false);

		args = new Object[] {mypageUserModelImpl.getMypageUserRoleId()};

		finderCache.putResult(
			_finderPathCountByRoleId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByRoleId, args, mypageUserModelImpl, false);
	}

	/**
	 * Creates a new mypage user with the primary key. Does not add the mypage user to the database.
	 *
	 * @param mypageUserId the primary key for the new mypage user
	 * @return the new mypage user
	 */
	@Override
	public MypageUser create(long mypageUserId) {
		MypageUser mypageUser = new MypageUserImpl();

		mypageUser.setNew(true);
		mypageUser.setPrimaryKey(mypageUserId);

		mypageUser.setCompanyId(CompanyThreadLocal.getCompanyId());

		return mypageUser;
	}

	/**
	 * Removes the mypage user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mypageUserId the primary key of the mypage user
	 * @return the mypage user that was removed
	 * @throws NoSuchMypageUserException if a mypage user with the primary key could not be found
	 */
	@Override
	public MypageUser remove(long mypageUserId)
		throws NoSuchMypageUserException {

		return remove((Serializable)mypageUserId);
	}

	/**
	 * Removes the mypage user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mypage user
	 * @return the mypage user that was removed
	 * @throws NoSuchMypageUserException if a mypage user with the primary key could not be found
	 */
	@Override
	public MypageUser remove(Serializable primaryKey)
		throws NoSuchMypageUserException {

		Session session = null;

		try {
			session = openSession();

			MypageUser mypageUser = (MypageUser)session.get(
				MypageUserImpl.class, primaryKey);

			if (mypageUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMypageUserException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(mypageUser);
		}
		catch (NoSuchMypageUserException noSuchEntityException) {
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
	protected MypageUser removeImpl(MypageUser mypageUser) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mypageUser)) {
				mypageUser = (MypageUser)session.get(
					MypageUserImpl.class, mypageUser.getPrimaryKeyObj());
			}

			if (mypageUser != null) {
				session.delete(mypageUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (mypageUser != null) {
			clearCache(mypageUser);
		}

		return mypageUser;
	}

	@Override
	public MypageUser updateImpl(MypageUser mypageUser) {
		boolean isNew = mypageUser.isNew();

		if (!(mypageUser instanceof MypageUserModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(mypageUser.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(mypageUser);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in mypageUser proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MypageUser implementation " +
					mypageUser.getClass());
		}

		MypageUserModelImpl mypageUserModelImpl =
			(MypageUserModelImpl)mypageUser;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (mypageUser.getCreateDate() == null)) {
			if (serviceContext == null) {
				mypageUser.setCreateDate(date);
			}
			else {
				mypageUser.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!mypageUserModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				mypageUser.setModifiedDate(date);
			}
			else {
				mypageUser.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(mypageUser);
			}
			else {
				mypageUser = (MypageUser)session.merge(mypageUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MypageUserImpl.class, mypageUserModelImpl, false, true);

		cacheUniqueFindersCache(mypageUserModelImpl);

		if (isNew) {
			mypageUser.setNew(false);
		}

		mypageUser.resetOriginalValues();

		return mypageUser;
	}

	/**
	 * Returns the mypage user with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mypage user
	 * @return the mypage user
	 * @throws NoSuchMypageUserException if a mypage user with the primary key could not be found
	 */
	@Override
	public MypageUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMypageUserException {

		MypageUser mypageUser = fetchByPrimaryKey(primaryKey);

		if (mypageUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMypageUserException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return mypageUser;
	}

	/**
	 * Returns the mypage user with the primary key or throws a <code>NoSuchMypageUserException</code> if it could not be found.
	 *
	 * @param mypageUserId the primary key of the mypage user
	 * @return the mypage user
	 * @throws NoSuchMypageUserException if a mypage user with the primary key could not be found
	 */
	@Override
	public MypageUser findByPrimaryKey(long mypageUserId)
		throws NoSuchMypageUserException {

		return findByPrimaryKey((Serializable)mypageUserId);
	}

	/**
	 * Returns the mypage user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mypageUserId the primary key of the mypage user
	 * @return the mypage user, or <code>null</code> if a mypage user with the primary key could not be found
	 */
	@Override
	public MypageUser fetchByPrimaryKey(long mypageUserId) {
		return fetchByPrimaryKey((Serializable)mypageUserId);
	}

	/**
	 * Returns all the mypage users.
	 *
	 * @return the mypage users
	 */
	@Override
	public List<MypageUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the mypage users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage users
	 * @param end the upper bound of the range of mypage users (not inclusive)
	 * @return the range of mypage users
	 */
	@Override
	public List<MypageUser> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the mypage users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage users
	 * @param end the upper bound of the range of mypage users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of mypage users
	 */
	@Override
	public List<MypageUser> findAll(
		int start, int end, OrderByComparator<MypageUser> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the mypage users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MypageUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mypage users
	 * @param end the upper bound of the range of mypage users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of mypage users
	 */
	@Override
	public List<MypageUser> findAll(
		int start, int end, OrderByComparator<MypageUser> orderByComparator,
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

		List<MypageUser> list = null;

		if (useFinderCache) {
			list = (List<MypageUser>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MYPAGEUSER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MYPAGEUSER;

				sql = sql.concat(MypageUserModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MypageUser>)QueryUtil.list(
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
	 * Removes all the mypage users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MypageUser mypageUser : findAll()) {
			remove(mypageUser);
		}
	}

	/**
	 * Returns the number of mypage users.
	 *
	 * @return the number of mypage users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MYPAGEUSER);

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
		return "mypageUserId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MYPAGEUSER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MypageUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the mypage user persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new MypageUserModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", MypageUser.class.getName()));

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

		_finderPathFetchBygetByLiferayUserId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBygetByLiferayUserId",
			new String[] {Long.class.getName()}, new String[] {"liferayUserId"},
			true);

		_finderPathCountBygetByLiferayUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBygetByLiferayUserId", new String[] {Long.class.getName()},
			new String[] {"liferayUserId"}, false);

		_finderPathFetchBycreditWalletId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBycreditWalletId",
			new String[] {Long.class.getName()},
			new String[] {"creditWalletId"}, true);

		_finderPathCountBycreditWalletId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycreditWalletId",
			new String[] {Long.class.getName()},
			new String[] {"creditWalletId"}, false);

		_finderPathFetchByPrettyUrl = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByPrettyUrl",
			new String[] {String.class.getName()}, new String[] {"prettyUrl"},
			true);

		_finderPathCountByPrettyUrl = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPrettyUrl",
			new String[] {String.class.getName()}, new String[] {"prettyUrl"},
			false);

		_finderPathFetchByAgentCode = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByAgentCode",
			new String[] {String.class.getName()}, new String[] {"code_"},
			true);

		_finderPathCountByAgentCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAgentCode",
			new String[] {String.class.getName()}, new String[] {"code_"},
			false);

		_finderPathFetchByEmailAddress = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByEmailAddress",
			new String[] {String.class.getName()}, new String[] {"email"},
			true);

		_finderPathCountByEmailAddress = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmailAddress",
			new String[] {String.class.getName()}, new String[] {"email"},
			false);

		_finderPathFetchByDeptoreCode = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDeptoreCode",
			new String[] {String.class.getName()}, new String[] {"deptoreCode"},
			true);

		_finderPathCountByDeptoreCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDeptoreCode",
			new String[] {String.class.getName()}, new String[] {"deptoreCode"},
			false);

		_finderPathFetchByRoleId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByRoleId",
			new String[] {Long.class.getName()},
			new String[] {"mypageUserRoleId"}, true);

		_finderPathCountByRoleId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoleId",
			new String[] {Long.class.getName()},
			new String[] {"mypageUserRoleId"}, false);

		_setMypageUserUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMypageUserUtilPersistence(null);

		entityCache.removeCache(MypageUserImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setMypageUserUtilPersistence(
		MypageUserPersistence mypageUserPersistence) {

		try {
			Field field = MypageUserUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, mypageUserPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MPUPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MPUPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MPUPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_MYPAGEUSER =
		"SELECT mypageUser FROM MypageUser mypageUser";

	private static final String _SQL_SELECT_MYPAGEUSER_WHERE =
		"SELECT mypageUser FROM MypageUser mypageUser WHERE ";

	private static final String _SQL_COUNT_MYPAGEUSER =
		"SELECT COUNT(mypageUser) FROM MypageUser mypageUser";

	private static final String _SQL_COUNT_MYPAGEUSER_WHERE =
		"SELECT COUNT(mypageUser) FROM MypageUser mypageUser WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "mypageUser.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MypageUser exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MypageUser exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MypageUserPersistenceImpl.class);

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

	private static class MypageUserModelArgumentsResolver
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

			MypageUserModelImpl mypageUserModelImpl =
				(MypageUserModelImpl)baseModel;

			if (!checkColumn ||
				_hasModifiedColumns(mypageUserModelImpl, columnNames)) {

				return _getValue(mypageUserModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			MypageUserModelImpl mypageUserModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = mypageUserModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = mypageUserModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static boolean _hasModifiedColumns(
			MypageUserModelImpl mypageUserModelImpl, String[] columnNames) {

			if (columnNames.length == 0) {
				return false;
			}

			for (String columnName : columnNames) {
				if (!Objects.equals(
						mypageUserModelImpl.getColumnOriginalValue(columnName),
						mypageUserModelImpl.getColumnValue(columnName))) {

					return true;
				}
			}

			return false;
		}

	}

}