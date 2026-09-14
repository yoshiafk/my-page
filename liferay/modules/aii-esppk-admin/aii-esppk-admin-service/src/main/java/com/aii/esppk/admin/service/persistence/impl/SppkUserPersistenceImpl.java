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

package com.aii.esppk.admin.service.persistence.impl;

import com.aii.esppk.admin.exception.NoSuchSppkUserException;
import com.aii.esppk.admin.model.SppkUser;
import com.aii.esppk.admin.model.impl.SppkUserImpl;
import com.aii.esppk.admin.model.impl.SppkUserModelImpl;
import com.aii.esppk.admin.service.persistence.SppkUserPersistence;
import com.aii.esppk.admin.service.persistence.SppkUserUtil;
import com.aii.esppk.admin.service.persistence.impl.constants.MSPPKPersistenceConstants;

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
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the sppk user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @generated
 */
@Component(service = SppkUserPersistence.class)
public class SppkUserPersistenceImpl
	extends BasePersistenceImpl<SppkUser> implements SppkUserPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SppkUserUtil</code> to access the sppk user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SppkUserImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBysppkLoginCode;
	private FinderPath _finderPathCountBysppkLoginCode;

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; or throws a <code>NoSuchSppkUserException</code> if it could not be found.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @return the matching sppk user
	 * @throws NoSuchSppkUserException if a matching sppk user could not be found
	 */
	@Override
	public SppkUser findBysppkLoginCode(String sppkLoginCode)
		throws NoSuchSppkUserException {

		SppkUser sppkUser = fetchBysppkLoginCode(sppkLoginCode);

		if (sppkUser == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("sppkLoginCode=");
			sb.append(sppkLoginCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSppkUserException(sb.toString());
		}

		return sppkUser;
	}

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	@Override
	public SppkUser fetchBysppkLoginCode(String sppkLoginCode) {
		return fetchBysppkLoginCode(sppkLoginCode, true);
	}

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	@Override
	public SppkUser fetchBysppkLoginCode(
		String sppkLoginCode, boolean useFinderCache) {

		sppkLoginCode = Objects.toString(sppkLoginCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {sppkLoginCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBysppkLoginCode, finderArgs, this);
		}

		if (result instanceof SppkUser) {
			SppkUser sppkUser = (SppkUser)result;

			if (!Objects.equals(sppkLoginCode, sppkUser.getSppkLoginCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SPPKUSER_WHERE);

			boolean bindSppkLoginCode = false;

			if (sppkLoginCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_SPPKLOGINCODE_SPPKLOGINCODE_3);
			}
			else {
				bindSppkLoginCode = true;

				sb.append(_FINDER_COLUMN_SPPKLOGINCODE_SPPKLOGINCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSppkLoginCode) {
					queryPos.add(sppkLoginCode);
				}

				List<SppkUser> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBysppkLoginCode, finderArgs, list);
					}
				}
				else {
					SppkUser sppkUser = list.get(0);

					result = sppkUser;

					cacheResult(sppkUser);
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
			return (SppkUser)result;
		}
	}

	/**
	 * Removes the sppk user where sppkLoginCode = &#63; from the database.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @return the sppk user that was removed
	 */
	@Override
	public SppkUser removeBysppkLoginCode(String sppkLoginCode)
		throws NoSuchSppkUserException {

		SppkUser sppkUser = findBysppkLoginCode(sppkLoginCode);

		return remove(sppkUser);
	}

	/**
	 * Returns the number of sppk users where sppkLoginCode = &#63;.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @return the number of matching sppk users
	 */
	@Override
	public int countBysppkLoginCode(String sppkLoginCode) {
		sppkLoginCode = Objects.toString(sppkLoginCode, "");

		FinderPath finderPath = _finderPathCountBysppkLoginCode;

		Object[] finderArgs = new Object[] {sppkLoginCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SPPKUSER_WHERE);

			boolean bindSppkLoginCode = false;

			if (sppkLoginCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_SPPKLOGINCODE_SPPKLOGINCODE_3);
			}
			else {
				bindSppkLoginCode = true;

				sb.append(_FINDER_COLUMN_SPPKLOGINCODE_SPPKLOGINCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSppkLoginCode) {
					queryPos.add(sppkLoginCode);
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

	private static final String _FINDER_COLUMN_SPPKLOGINCODE_SPPKLOGINCODE_2 =
		"sppkUser.sppkLoginCode = ?";

	private static final String _FINDER_COLUMN_SPPKLOGINCODE_SPPKLOGINCODE_3 =
		"(sppkUser.sppkLoginCode IS NULL OR sppkUser.sppkLoginCode = '')";

	private FinderPath _finderPathFetchBysppkLoginCodeAndPassword;
	private FinderPath _finderPathCountBysppkLoginCodeAndPassword;

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; and password = &#63; or throws a <code>NoSuchSppkUserException</code> if it could not be found.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param password the password
	 * @return the matching sppk user
	 * @throws NoSuchSppkUserException if a matching sppk user could not be found
	 */
	@Override
	public SppkUser findBysppkLoginCodeAndPassword(
			String sppkLoginCode, String password)
		throws NoSuchSppkUserException {

		SppkUser sppkUser = fetchBysppkLoginCodeAndPassword(
			sppkLoginCode, password);

		if (sppkUser == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("sppkLoginCode=");
			sb.append(sppkLoginCode);

			sb.append(", password=");
			sb.append(password);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSppkUserException(sb.toString());
		}

		return sppkUser;
	}

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; and password = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param password the password
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	@Override
	public SppkUser fetchBysppkLoginCodeAndPassword(
		String sppkLoginCode, String password) {

		return fetchBysppkLoginCodeAndPassword(sppkLoginCode, password, true);
	}

	/**
	 * Returns the sppk user where sppkLoginCode = &#63; and password = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param password the password
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	@Override
	public SppkUser fetchBysppkLoginCodeAndPassword(
		String sppkLoginCode, String password, boolean useFinderCache) {

		sppkLoginCode = Objects.toString(sppkLoginCode, "");
		password = Objects.toString(password, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {sppkLoginCode, password};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBysppkLoginCodeAndPassword, finderArgs, this);
		}

		if (result instanceof SppkUser) {
			SppkUser sppkUser = (SppkUser)result;

			if (!Objects.equals(sppkLoginCode, sppkUser.getSppkLoginCode()) ||
				!Objects.equals(password, sppkUser.getPassword())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SPPKUSER_WHERE);

			boolean bindSppkLoginCode = false;

			if (sppkLoginCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SPPKLOGINCODEANDPASSWORD_SPPKLOGINCODE_3);
			}
			else {
				bindSppkLoginCode = true;

				sb.append(
					_FINDER_COLUMN_SPPKLOGINCODEANDPASSWORD_SPPKLOGINCODE_2);
			}

			boolean bindPassword = false;

			if (password.isEmpty()) {
				sb.append(_FINDER_COLUMN_SPPKLOGINCODEANDPASSWORD_PASSWORD_3);
			}
			else {
				bindPassword = true;

				sb.append(_FINDER_COLUMN_SPPKLOGINCODEANDPASSWORD_PASSWORD_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSppkLoginCode) {
					queryPos.add(sppkLoginCode);
				}

				if (bindPassword) {
					queryPos.add(password);
				}

				List<SppkUser> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBysppkLoginCodeAndPassword,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									sppkLoginCode, password
								};
							}

							_log.warn(
								"SppkUserPersistenceImpl.fetchBysppkLoginCodeAndPassword(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SppkUser sppkUser = list.get(0);

					result = sppkUser;

					cacheResult(sppkUser);
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
			return (SppkUser)result;
		}
	}

	/**
	 * Removes the sppk user where sppkLoginCode = &#63; and password = &#63; from the database.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param password the password
	 * @return the sppk user that was removed
	 */
	@Override
	public SppkUser removeBysppkLoginCodeAndPassword(
			String sppkLoginCode, String password)
		throws NoSuchSppkUserException {

		SppkUser sppkUser = findBysppkLoginCodeAndPassword(
			sppkLoginCode, password);

		return remove(sppkUser);
	}

	/**
	 * Returns the number of sppk users where sppkLoginCode = &#63; and password = &#63;.
	 *
	 * @param sppkLoginCode the sppk login code
	 * @param password the password
	 * @return the number of matching sppk users
	 */
	@Override
	public int countBysppkLoginCodeAndPassword(
		String sppkLoginCode, String password) {

		sppkLoginCode = Objects.toString(sppkLoginCode, "");
		password = Objects.toString(password, "");

		FinderPath finderPath = _finderPathCountBysppkLoginCodeAndPassword;

		Object[] finderArgs = new Object[] {sppkLoginCode, password};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SPPKUSER_WHERE);

			boolean bindSppkLoginCode = false;

			if (sppkLoginCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SPPKLOGINCODEANDPASSWORD_SPPKLOGINCODE_3);
			}
			else {
				bindSppkLoginCode = true;

				sb.append(
					_FINDER_COLUMN_SPPKLOGINCODEANDPASSWORD_SPPKLOGINCODE_2);
			}

			boolean bindPassword = false;

			if (password.isEmpty()) {
				sb.append(_FINDER_COLUMN_SPPKLOGINCODEANDPASSWORD_PASSWORD_3);
			}
			else {
				bindPassword = true;

				sb.append(_FINDER_COLUMN_SPPKLOGINCODEANDPASSWORD_PASSWORD_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSppkLoginCode) {
					queryPos.add(sppkLoginCode);
				}

				if (bindPassword) {
					queryPos.add(password);
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
		_FINDER_COLUMN_SPPKLOGINCODEANDPASSWORD_SPPKLOGINCODE_2 =
			"sppkUser.sppkLoginCode = ? AND ";

	private static final String
		_FINDER_COLUMN_SPPKLOGINCODEANDPASSWORD_SPPKLOGINCODE_3 =
			"(sppkUser.sppkLoginCode IS NULL OR sppkUser.sppkLoginCode = '') AND ";

	private static final String
		_FINDER_COLUMN_SPPKLOGINCODEANDPASSWORD_PASSWORD_2 =
			"sppkUser.password = ?";

	private static final String
		_FINDER_COLUMN_SPPKLOGINCODEANDPASSWORD_PASSWORD_3 =
			"(sppkUser.password IS NULL OR sppkUser.password = '')";

	private FinderPath _finderPathWithPaginationFindByfullName;
	private FinderPath _finderPathWithPaginationCountByfullName;

	/**
	 * Returns all the sppk users where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @return the matching sppk users
	 */
	@Override
	public List<SppkUser> findByfullName(String fullName) {
		return findByfullName(
			fullName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sppk users where fullName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkUserModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of sppk users
	 * @param end the upper bound of the range of sppk users (not inclusive)
	 * @return the range of matching sppk users
	 */
	@Override
	public List<SppkUser> findByfullName(String fullName, int start, int end) {
		return findByfullName(fullName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sppk users where fullName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkUserModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of sppk users
	 * @param end the upper bound of the range of sppk users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sppk users
	 */
	@Override
	public List<SppkUser> findByfullName(
		String fullName, int start, int end,
		OrderByComparator<SppkUser> orderByComparator) {

		return findByfullName(fullName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sppk users where fullName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkUserModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of sppk users
	 * @param end the upper bound of the range of sppk users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sppk users
	 */
	@Override
	public List<SppkUser> findByfullName(
		String fullName, int start, int end,
		OrderByComparator<SppkUser> orderByComparator, boolean useFinderCache) {

		fullName = Objects.toString(fullName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByfullName;
		finderArgs = new Object[] {fullName, start, end, orderByComparator};

		List<SppkUser> list = null;

		if (useFinderCache) {
			list = (List<SppkUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SppkUser sppkUser : list) {
					if (!StringUtil.wildcardMatches(
							sppkUser.getFullName(), fullName, '_', '%', '\\',
							true)) {

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

			sb.append(_SQL_SELECT_SPPKUSER_WHERE);

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
				sb.append(SppkUserModelImpl.ORDER_BY_JPQL);
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

				list = (List<SppkUser>)QueryUtil.list(
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
	 * Returns the first sppk user in the ordered set where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sppk user
	 * @throws NoSuchSppkUserException if a matching sppk user could not be found
	 */
	@Override
	public SppkUser findByfullName_First(
			String fullName, OrderByComparator<SppkUser> orderByComparator)
		throws NoSuchSppkUserException {

		SppkUser sppkUser = fetchByfullName_First(fullName, orderByComparator);

		if (sppkUser != null) {
			return sppkUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fullNameLIKE");
		sb.append(fullName);

		sb.append("}");

		throw new NoSuchSppkUserException(sb.toString());
	}

	/**
	 * Returns the first sppk user in the ordered set where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	@Override
	public SppkUser fetchByfullName_First(
		String fullName, OrderByComparator<SppkUser> orderByComparator) {

		List<SppkUser> list = findByfullName(fullName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sppk user in the ordered set where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sppk user
	 * @throws NoSuchSppkUserException if a matching sppk user could not be found
	 */
	@Override
	public SppkUser findByfullName_Last(
			String fullName, OrderByComparator<SppkUser> orderByComparator)
		throws NoSuchSppkUserException {

		SppkUser sppkUser = fetchByfullName_Last(fullName, orderByComparator);

		if (sppkUser != null) {
			return sppkUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fullNameLIKE");
		sb.append(fullName);

		sb.append("}");

		throw new NoSuchSppkUserException(sb.toString());
	}

	/**
	 * Returns the last sppk user in the ordered set where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	@Override
	public SppkUser fetchByfullName_Last(
		String fullName, OrderByComparator<SppkUser> orderByComparator) {

		int count = countByfullName(fullName);

		if (count == 0) {
			return null;
		}

		List<SppkUser> list = findByfullName(
			fullName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sppk users before and after the current sppk user in the ordered set where fullName LIKE &#63;.
	 *
	 * @param sppkUserId the primary key of the current sppk user
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sppk user
	 * @throws NoSuchSppkUserException if a sppk user with the primary key could not be found
	 */
	@Override
	public SppkUser[] findByfullName_PrevAndNext(
			long sppkUserId, String fullName,
			OrderByComparator<SppkUser> orderByComparator)
		throws NoSuchSppkUserException {

		fullName = Objects.toString(fullName, "");

		SppkUser sppkUser = findByPrimaryKey(sppkUserId);

		Session session = null;

		try {
			session = openSession();

			SppkUser[] array = new SppkUserImpl[3];

			array[0] = getByfullName_PrevAndNext(
				session, sppkUser, fullName, orderByComparator, true);

			array[1] = sppkUser;

			array[2] = getByfullName_PrevAndNext(
				session, sppkUser, fullName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SppkUser getByfullName_PrevAndNext(
		Session session, SppkUser sppkUser, String fullName,
		OrderByComparator<SppkUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SPPKUSER_WHERE);

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
			sb.append(SppkUserModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(sppkUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SppkUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sppk users where fullName LIKE &#63; from the database.
	 *
	 * @param fullName the full name
	 */
	@Override
	public void removeByfullName(String fullName) {
		for (SppkUser sppkUser :
				findByfullName(
					fullName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sppkUser);
		}
	}

	/**
	 * Returns the number of sppk users where fullName LIKE &#63;.
	 *
	 * @param fullName the full name
	 * @return the number of matching sppk users
	 */
	@Override
	public int countByfullName(String fullName) {
		fullName = Objects.toString(fullName, "");

		FinderPath finderPath = _finderPathWithPaginationCountByfullName;

		Object[] finderArgs = new Object[] {fullName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SPPKUSER_WHERE);

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
		"sppkUser.fullName LIKE ?";

	private static final String _FINDER_COLUMN_FULLNAME_FULLNAME_3 =
		"(sppkUser.fullName IS NULL OR sppkUser.fullName LIKE '')";

	private FinderPath _finderPathFetchByemailAndOtpCode;
	private FinderPath _finderPathCountByemailAndOtpCode;

	/**
	 * Returns the sppk user where email = &#63; and otpCode = &#63; or throws a <code>NoSuchSppkUserException</code> if it could not be found.
	 *
	 * @param email the email
	 * @param otpCode the otp code
	 * @return the matching sppk user
	 * @throws NoSuchSppkUserException if a matching sppk user could not be found
	 */
	@Override
	public SppkUser findByemailAndOtpCode(String email, String otpCode)
		throws NoSuchSppkUserException {

		SppkUser sppkUser = fetchByemailAndOtpCode(email, otpCode);

		if (sppkUser == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("email=");
			sb.append(email);

			sb.append(", otpCode=");
			sb.append(otpCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSppkUserException(sb.toString());
		}

		return sppkUser;
	}

	/**
	 * Returns the sppk user where email = &#63; and otpCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @param otpCode the otp code
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	@Override
	public SppkUser fetchByemailAndOtpCode(String email, String otpCode) {
		return fetchByemailAndOtpCode(email, otpCode, true);
	}

	/**
	 * Returns the sppk user where email = &#63; and otpCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param otpCode the otp code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sppk user, or <code>null</code> if a matching sppk user could not be found
	 */
	@Override
	public SppkUser fetchByemailAndOtpCode(
		String email, String otpCode, boolean useFinderCache) {

		email = Objects.toString(email, "");
		otpCode = Objects.toString(otpCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {email, otpCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByemailAndOtpCode, finderArgs, this);
		}

		if (result instanceof SppkUser) {
			SppkUser sppkUser = (SppkUser)result;

			if (!Objects.equals(email, sppkUser.getEmail()) ||
				!Objects.equals(otpCode, sppkUser.getOtpCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SPPKUSER_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAILANDOTPCODE_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAILANDOTPCODE_EMAIL_2);
			}

			boolean bindOtpCode = false;

			if (otpCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAILANDOTPCODE_OTPCODE_3);
			}
			else {
				bindOtpCode = true;

				sb.append(_FINDER_COLUMN_EMAILANDOTPCODE_OTPCODE_2);
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

				if (bindOtpCode) {
					queryPos.add(otpCode);
				}

				List<SppkUser> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByemailAndOtpCode, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {email, otpCode};
							}

							_log.warn(
								"SppkUserPersistenceImpl.fetchByemailAndOtpCode(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SppkUser sppkUser = list.get(0);

					result = sppkUser;

					cacheResult(sppkUser);
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
			return (SppkUser)result;
		}
	}

	/**
	 * Removes the sppk user where email = &#63; and otpCode = &#63; from the database.
	 *
	 * @param email the email
	 * @param otpCode the otp code
	 * @return the sppk user that was removed
	 */
	@Override
	public SppkUser removeByemailAndOtpCode(String email, String otpCode)
		throws NoSuchSppkUserException {

		SppkUser sppkUser = findByemailAndOtpCode(email, otpCode);

		return remove(sppkUser);
	}

	/**
	 * Returns the number of sppk users where email = &#63; and otpCode = &#63;.
	 *
	 * @param email the email
	 * @param otpCode the otp code
	 * @return the number of matching sppk users
	 */
	@Override
	public int countByemailAndOtpCode(String email, String otpCode) {
		email = Objects.toString(email, "");
		otpCode = Objects.toString(otpCode, "");

		FinderPath finderPath = _finderPathCountByemailAndOtpCode;

		Object[] finderArgs = new Object[] {email, otpCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SPPKUSER_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAILANDOTPCODE_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAILANDOTPCODE_EMAIL_2);
			}

			boolean bindOtpCode = false;

			if (otpCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAILANDOTPCODE_OTPCODE_3);
			}
			else {
				bindOtpCode = true;

				sb.append(_FINDER_COLUMN_EMAILANDOTPCODE_OTPCODE_2);
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

				if (bindOtpCode) {
					queryPos.add(otpCode);
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

	private static final String _FINDER_COLUMN_EMAILANDOTPCODE_EMAIL_2 =
		"sppkUser.email = ? AND ";

	private static final String _FINDER_COLUMN_EMAILANDOTPCODE_EMAIL_3 =
		"(sppkUser.email IS NULL OR sppkUser.email = '') AND ";

	private static final String _FINDER_COLUMN_EMAILANDOTPCODE_OTPCODE_2 =
		"sppkUser.otpCode = ?";

	private static final String _FINDER_COLUMN_EMAILANDOTPCODE_OTPCODE_3 =
		"(sppkUser.otpCode IS NULL OR sppkUser.otpCode = '')";

	public SppkUserPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("password", "password_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SppkUser.class);

		setModelImplClass(SppkUserImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the sppk user in the entity cache if it is enabled.
	 *
	 * @param sppkUser the sppk user
	 */
	@Override
	public void cacheResult(SppkUser sppkUser) {
		entityCache.putResult(
			SppkUserImpl.class, sppkUser.getPrimaryKey(), sppkUser);

		finderCache.putResult(
			_finderPathFetchBysppkLoginCode,
			new Object[] {sppkUser.getSppkLoginCode()}, sppkUser);

		finderCache.putResult(
			_finderPathFetchBysppkLoginCodeAndPassword,
			new Object[] {sppkUser.getSppkLoginCode(), sppkUser.getPassword()},
			sppkUser);

		finderCache.putResult(
			_finderPathFetchByemailAndOtpCode,
			new Object[] {sppkUser.getEmail(), sppkUser.getOtpCode()},
			sppkUser);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sppk users in the entity cache if it is enabled.
	 *
	 * @param sppkUsers the sppk users
	 */
	@Override
	public void cacheResult(List<SppkUser> sppkUsers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (sppkUsers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SppkUser sppkUser : sppkUsers) {
			if (entityCache.getResult(
					SppkUserImpl.class, sppkUser.getPrimaryKey()) == null) {

				cacheResult(sppkUser);
			}
		}
	}

	/**
	 * Clears the cache for all sppk users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SppkUserImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sppk user.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SppkUser sppkUser) {
		entityCache.removeResult(SppkUserImpl.class, sppkUser);
	}

	@Override
	public void clearCache(List<SppkUser> sppkUsers) {
		for (SppkUser sppkUser : sppkUsers) {
			entityCache.removeResult(SppkUserImpl.class, sppkUser);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SppkUserImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SppkUserModelImpl sppkUserModelImpl) {

		Object[] args = new Object[] {sppkUserModelImpl.getSppkLoginCode()};

		finderCache.putResult(
			_finderPathCountBysppkLoginCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBysppkLoginCode, args, sppkUserModelImpl, false);

		args = new Object[] {
			sppkUserModelImpl.getSppkLoginCode(),
			sppkUserModelImpl.getPassword()
		};

		finderCache.putResult(
			_finderPathCountBysppkLoginCodeAndPassword, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchBysppkLoginCodeAndPassword, args, sppkUserModelImpl,
			false);

		args = new Object[] {
			sppkUserModelImpl.getEmail(), sppkUserModelImpl.getOtpCode()
		};

		finderCache.putResult(
			_finderPathCountByemailAndOtpCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByemailAndOtpCode, args, sppkUserModelImpl, false);
	}

	/**
	 * Creates a new sppk user with the primary key. Does not add the sppk user to the database.
	 *
	 * @param sppkUserId the primary key for the new sppk user
	 * @return the new sppk user
	 */
	@Override
	public SppkUser create(long sppkUserId) {
		SppkUser sppkUser = new SppkUserImpl();

		sppkUser.setNew(true);
		sppkUser.setPrimaryKey(sppkUserId);

		sppkUser.setCompanyId(CompanyThreadLocal.getCompanyId());

		return sppkUser;
	}

	/**
	 * Removes the sppk user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sppkUserId the primary key of the sppk user
	 * @return the sppk user that was removed
	 * @throws NoSuchSppkUserException if a sppk user with the primary key could not be found
	 */
	@Override
	public SppkUser remove(long sppkUserId) throws NoSuchSppkUserException {
		return remove((Serializable)sppkUserId);
	}

	/**
	 * Removes the sppk user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sppk user
	 * @return the sppk user that was removed
	 * @throws NoSuchSppkUserException if a sppk user with the primary key could not be found
	 */
	@Override
	public SppkUser remove(Serializable primaryKey)
		throws NoSuchSppkUserException {

		Session session = null;

		try {
			session = openSession();

			SppkUser sppkUser = (SppkUser)session.get(
				SppkUserImpl.class, primaryKey);

			if (sppkUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSppkUserException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(sppkUser);
		}
		catch (NoSuchSppkUserException noSuchEntityException) {
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
	protected SppkUser removeImpl(SppkUser sppkUser) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sppkUser)) {
				sppkUser = (SppkUser)session.get(
					SppkUserImpl.class, sppkUser.getPrimaryKeyObj());
			}

			if (sppkUser != null) {
				session.delete(sppkUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (sppkUser != null) {
			clearCache(sppkUser);
		}

		return sppkUser;
	}

	@Override
	public SppkUser updateImpl(SppkUser sppkUser) {
		boolean isNew = sppkUser.isNew();

		if (!(sppkUser instanceof SppkUserModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(sppkUser.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(sppkUser);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in sppkUser proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SppkUser implementation " +
					sppkUser.getClass());
		}

		SppkUserModelImpl sppkUserModelImpl = (SppkUserModelImpl)sppkUser;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (sppkUser.getCreateDate() == null)) {
			if (serviceContext == null) {
				sppkUser.setCreateDate(date);
			}
			else {
				sppkUser.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!sppkUserModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				sppkUser.setModifiedDate(date);
			}
			else {
				sppkUser.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(sppkUser);
			}
			else {
				sppkUser = (SppkUser)session.merge(sppkUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SppkUserImpl.class, sppkUserModelImpl, false, true);

		cacheUniqueFindersCache(sppkUserModelImpl);

		if (isNew) {
			sppkUser.setNew(false);
		}

		sppkUser.resetOriginalValues();

		return sppkUser;
	}

	/**
	 * Returns the sppk user with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sppk user
	 * @return the sppk user
	 * @throws NoSuchSppkUserException if a sppk user with the primary key could not be found
	 */
	@Override
	public SppkUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSppkUserException {

		SppkUser sppkUser = fetchByPrimaryKey(primaryKey);

		if (sppkUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSppkUserException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return sppkUser;
	}

	/**
	 * Returns the sppk user with the primary key or throws a <code>NoSuchSppkUserException</code> if it could not be found.
	 *
	 * @param sppkUserId the primary key of the sppk user
	 * @return the sppk user
	 * @throws NoSuchSppkUserException if a sppk user with the primary key could not be found
	 */
	@Override
	public SppkUser findByPrimaryKey(long sppkUserId)
		throws NoSuchSppkUserException {

		return findByPrimaryKey((Serializable)sppkUserId);
	}

	/**
	 * Returns the sppk user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sppkUserId the primary key of the sppk user
	 * @return the sppk user, or <code>null</code> if a sppk user with the primary key could not be found
	 */
	@Override
	public SppkUser fetchByPrimaryKey(long sppkUserId) {
		return fetchByPrimaryKey((Serializable)sppkUserId);
	}

	/**
	 * Returns all the sppk users.
	 *
	 * @return the sppk users
	 */
	@Override
	public List<SppkUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sppk users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sppk users
	 * @param end the upper bound of the range of sppk users (not inclusive)
	 * @return the range of sppk users
	 */
	@Override
	public List<SppkUser> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sppk users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sppk users
	 * @param end the upper bound of the range of sppk users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sppk users
	 */
	@Override
	public List<SppkUser> findAll(
		int start, int end, OrderByComparator<SppkUser> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sppk users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SppkUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sppk users
	 * @param end the upper bound of the range of sppk users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sppk users
	 */
	@Override
	public List<SppkUser> findAll(
		int start, int end, OrderByComparator<SppkUser> orderByComparator,
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

		List<SppkUser> list = null;

		if (useFinderCache) {
			list = (List<SppkUser>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SPPKUSER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SPPKUSER;

				sql = sql.concat(SppkUserModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SppkUser>)QueryUtil.list(
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
	 * Removes all the sppk users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SppkUser sppkUser : findAll()) {
			remove(sppkUser);
		}
	}

	/**
	 * Returns the number of sppk users.
	 *
	 * @return the number of sppk users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SPPKUSER);

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
		return "sppkUserId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SPPKUSER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SppkUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sppk user persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new SppkUserModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SppkUser.class.getName()));

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

		_finderPathFetchBysppkLoginCode = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBysppkLoginCode",
			new String[] {String.class.getName()},
			new String[] {"sppkLoginCode"}, true);

		_finderPathCountBysppkLoginCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysppkLoginCode",
			new String[] {String.class.getName()},
			new String[] {"sppkLoginCode"}, false);

		_finderPathFetchBysppkLoginCodeAndPassword = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBysppkLoginCodeAndPassword",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"sppkLoginCode", "password_"}, true);

		_finderPathCountBysppkLoginCodeAndPassword = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysppkLoginCodeAndPassword",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"sppkLoginCode", "password_"}, false);

		_finderPathWithPaginationFindByfullName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfullName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"fullName"}, true);

		_finderPathWithPaginationCountByfullName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByfullName",
			new String[] {String.class.getName()}, new String[] {"fullName"},
			false);

		_finderPathFetchByemailAndOtpCode = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByemailAndOtpCode",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"email", "otpCode"}, true);

		_finderPathCountByemailAndOtpCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemailAndOtpCode",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"email", "otpCode"}, false);

		_setSppkUserUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSppkUserUtilPersistence(null);

		entityCache.removeCache(SppkUserImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setSppkUserUtilPersistence(
		SppkUserPersistence sppkUserPersistence) {

		try {
			Field field = SppkUserUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, sppkUserPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MSPPKPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MSPPKPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MSPPKPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_SPPKUSER =
		"SELECT sppkUser FROM SppkUser sppkUser";

	private static final String _SQL_SELECT_SPPKUSER_WHERE =
		"SELECT sppkUser FROM SppkUser sppkUser WHERE ";

	private static final String _SQL_COUNT_SPPKUSER =
		"SELECT COUNT(sppkUser) FROM SppkUser sppkUser";

	private static final String _SQL_COUNT_SPPKUSER_WHERE =
		"SELECT COUNT(sppkUser) FROM SppkUser sppkUser WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "sppkUser.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SppkUser exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SppkUser exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SppkUserPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"password", "active"});

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

	private static class SppkUserModelArgumentsResolver
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

			SppkUserModelImpl sppkUserModelImpl = (SppkUserModelImpl)baseModel;

			long columnBitmask = sppkUserModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(sppkUserModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						sppkUserModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(sppkUserModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SppkUserModelImpl sppkUserModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = sppkUserModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = sppkUserModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}