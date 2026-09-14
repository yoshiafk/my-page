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
import com.liferay.portal.kernel.util.StringUtil;

import com.mypage.admin.product.exception.NoSuchSmartActiveLinkException;
import com.mypage.admin.product.model.SmartActiveLink;
import com.mypage.admin.product.model.impl.SmartActiveLinkImpl;
import com.mypage.admin.product.model.impl.SmartActiveLinkModelImpl;
import com.mypage.admin.product.service.persistence.SmartActiveLinkPersistence;
import com.mypage.admin.product.service.persistence.SmartActiveLinkUtil;
import com.mypage.admin.product.service.persistence.impl.constants.MPPersistenceConstants;

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
 * The persistence implementation for the smart active link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = SmartActiveLinkPersistence.class)
public class SmartActiveLinkPersistenceImpl
	extends BasePersistenceImpl<SmartActiveLink>
	implements SmartActiveLinkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SmartActiveLinkUtil</code> to access the smart active link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SmartActiveLinkImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBycategory;
	private FinderPath _finderPathCountBycategory;

	/**
	 * Returns the smart active link where category = &#63; or throws a <code>NoSuchSmartActiveLinkException</code> if it could not be found.
	 *
	 * @param category the category
	 * @return the matching smart active link
	 * @throws NoSuchSmartActiveLinkException if a matching smart active link could not be found
	 */
	@Override
	public SmartActiveLink findBycategory(String category)
		throws NoSuchSmartActiveLinkException {

		SmartActiveLink smartActiveLink = fetchBycategory(category);

		if (smartActiveLink == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("category=");
			sb.append(category);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSmartActiveLinkException(sb.toString());
		}

		return smartActiveLink;
	}

	/**
	 * Returns the smart active link where category = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param category the category
	 * @return the matching smart active link, or <code>null</code> if a matching smart active link could not be found
	 */
	@Override
	public SmartActiveLink fetchBycategory(String category) {
		return fetchBycategory(category, true);
	}

	/**
	 * Returns the smart active link where category = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param category the category
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart active link, or <code>null</code> if a matching smart active link could not be found
	 */
	@Override
	public SmartActiveLink fetchBycategory(
		String category, boolean useFinderCache) {

		category = Objects.toString(category, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {category};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBycategory, finderArgs, this);
		}

		if (result instanceof SmartActiveLink) {
			SmartActiveLink smartActiveLink = (SmartActiveLink)result;

			if (!Objects.equals(category, smartActiveLink.getCategory())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SMARTACTIVELINK_WHERE);

			boolean bindCategory = false;

			if (category.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCategory) {
					queryPos.add(category);
				}

				List<SmartActiveLink> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBycategory, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {category};
							}

							_log.warn(
								"SmartActiveLinkPersistenceImpl.fetchBycategory(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SmartActiveLink smartActiveLink = list.get(0);

					result = smartActiveLink;

					cacheResult(smartActiveLink);
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
			return (SmartActiveLink)result;
		}
	}

	/**
	 * Removes the smart active link where category = &#63; from the database.
	 *
	 * @param category the category
	 * @return the smart active link that was removed
	 */
	@Override
	public SmartActiveLink removeBycategory(String category)
		throws NoSuchSmartActiveLinkException {

		SmartActiveLink smartActiveLink = findBycategory(category);

		return remove(smartActiveLink);
	}

	/**
	 * Returns the number of smart active links where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching smart active links
	 */
	@Override
	public int countBycategory(String category) {
		category = Objects.toString(category, "");

		FinderPath finderPath = _finderPathCountBycategory;

		Object[] finderArgs = new Object[] {category};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SMARTACTIVELINK_WHERE);

			boolean bindCategory = false;

			if (category.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCategory) {
					queryPos.add(category);
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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_2 =
		"smartActiveLink.category = ?";

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_3 =
		"(smartActiveLink.category IS NULL OR smartActiveLink.category = '')";

	public SmartActiveLinkPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SmartActiveLink.class);

		setModelImplClass(SmartActiveLinkImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the smart active link in the entity cache if it is enabled.
	 *
	 * @param smartActiveLink the smart active link
	 */
	@Override
	public void cacheResult(SmartActiveLink smartActiveLink) {
		entityCache.putResult(
			SmartActiveLinkImpl.class, smartActiveLink.getPrimaryKey(),
			smartActiveLink);

		finderCache.putResult(
			_finderPathFetchBycategory,
			new Object[] {smartActiveLink.getCategory()}, smartActiveLink);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the smart active links in the entity cache if it is enabled.
	 *
	 * @param smartActiveLinks the smart active links
	 */
	@Override
	public void cacheResult(List<SmartActiveLink> smartActiveLinks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (smartActiveLinks.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SmartActiveLink smartActiveLink : smartActiveLinks) {
			if (entityCache.getResult(
					SmartActiveLinkImpl.class,
					smartActiveLink.getPrimaryKey()) == null) {

				cacheResult(smartActiveLink);
			}
		}
	}

	/**
	 * Clears the cache for all smart active links.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SmartActiveLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the smart active link.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SmartActiveLink smartActiveLink) {
		entityCache.removeResult(SmartActiveLinkImpl.class, smartActiveLink);
	}

	@Override
	public void clearCache(List<SmartActiveLink> smartActiveLinks) {
		for (SmartActiveLink smartActiveLink : smartActiveLinks) {
			entityCache.removeResult(
				SmartActiveLinkImpl.class, smartActiveLink);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SmartActiveLinkImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SmartActiveLinkModelImpl smartActiveLinkModelImpl) {

		Object[] args = new Object[] {smartActiveLinkModelImpl.getCategory()};

		finderCache.putResult(
			_finderPathCountBycategory, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBycategory, args, smartActiveLinkModelImpl, false);
	}

	/**
	 * Creates a new smart active link with the primary key. Does not add the smart active link to the database.
	 *
	 * @param smartActiveLinkId the primary key for the new smart active link
	 * @return the new smart active link
	 */
	@Override
	public SmartActiveLink create(long smartActiveLinkId) {
		SmartActiveLink smartActiveLink = new SmartActiveLinkImpl();

		smartActiveLink.setNew(true);
		smartActiveLink.setPrimaryKey(smartActiveLinkId);

		smartActiveLink.setCompanyId(CompanyThreadLocal.getCompanyId());

		return smartActiveLink;
	}

	/**
	 * Removes the smart active link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartActiveLinkId the primary key of the smart active link
	 * @return the smart active link that was removed
	 * @throws NoSuchSmartActiveLinkException if a smart active link with the primary key could not be found
	 */
	@Override
	public SmartActiveLink remove(long smartActiveLinkId)
		throws NoSuchSmartActiveLinkException {

		return remove((Serializable)smartActiveLinkId);
	}

	/**
	 * Removes the smart active link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the smart active link
	 * @return the smart active link that was removed
	 * @throws NoSuchSmartActiveLinkException if a smart active link with the primary key could not be found
	 */
	@Override
	public SmartActiveLink remove(Serializable primaryKey)
		throws NoSuchSmartActiveLinkException {

		Session session = null;

		try {
			session = openSession();

			SmartActiveLink smartActiveLink = (SmartActiveLink)session.get(
				SmartActiveLinkImpl.class, primaryKey);

			if (smartActiveLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSmartActiveLinkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(smartActiveLink);
		}
		catch (NoSuchSmartActiveLinkException noSuchEntityException) {
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
	protected SmartActiveLink removeImpl(SmartActiveLink smartActiveLink) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(smartActiveLink)) {
				smartActiveLink = (SmartActiveLink)session.get(
					SmartActiveLinkImpl.class,
					smartActiveLink.getPrimaryKeyObj());
			}

			if (smartActiveLink != null) {
				session.delete(smartActiveLink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (smartActiveLink != null) {
			clearCache(smartActiveLink);
		}

		return smartActiveLink;
	}

	@Override
	public SmartActiveLink updateImpl(SmartActiveLink smartActiveLink) {
		boolean isNew = smartActiveLink.isNew();

		if (!(smartActiveLink instanceof SmartActiveLinkModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(smartActiveLink.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					smartActiveLink);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in smartActiveLink proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SmartActiveLink implementation " +
					smartActiveLink.getClass());
		}

		SmartActiveLinkModelImpl smartActiveLinkModelImpl =
			(SmartActiveLinkModelImpl)smartActiveLink;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (smartActiveLink.getCreateDate() == null)) {
			if (serviceContext == null) {
				smartActiveLink.setCreateDate(date);
			}
			else {
				smartActiveLink.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!smartActiveLinkModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				smartActiveLink.setModifiedDate(date);
			}
			else {
				smartActiveLink.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(smartActiveLink);
			}
			else {
				smartActiveLink = (SmartActiveLink)session.merge(
					smartActiveLink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SmartActiveLinkImpl.class, smartActiveLinkModelImpl, false, true);

		cacheUniqueFindersCache(smartActiveLinkModelImpl);

		if (isNew) {
			smartActiveLink.setNew(false);
		}

		smartActiveLink.resetOriginalValues();

		return smartActiveLink;
	}

	/**
	 * Returns the smart active link with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the smart active link
	 * @return the smart active link
	 * @throws NoSuchSmartActiveLinkException if a smart active link with the primary key could not be found
	 */
	@Override
	public SmartActiveLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSmartActiveLinkException {

		SmartActiveLink smartActiveLink = fetchByPrimaryKey(primaryKey);

		if (smartActiveLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSmartActiveLinkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return smartActiveLink;
	}

	/**
	 * Returns the smart active link with the primary key or throws a <code>NoSuchSmartActiveLinkException</code> if it could not be found.
	 *
	 * @param smartActiveLinkId the primary key of the smart active link
	 * @return the smart active link
	 * @throws NoSuchSmartActiveLinkException if a smart active link with the primary key could not be found
	 */
	@Override
	public SmartActiveLink findByPrimaryKey(long smartActiveLinkId)
		throws NoSuchSmartActiveLinkException {

		return findByPrimaryKey((Serializable)smartActiveLinkId);
	}

	/**
	 * Returns the smart active link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartActiveLinkId the primary key of the smart active link
	 * @return the smart active link, or <code>null</code> if a smart active link with the primary key could not be found
	 */
	@Override
	public SmartActiveLink fetchByPrimaryKey(long smartActiveLinkId) {
		return fetchByPrimaryKey((Serializable)smartActiveLinkId);
	}

	/**
	 * Returns all the smart active links.
	 *
	 * @return the smart active links
	 */
	@Override
	public List<SmartActiveLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smart active links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active links
	 * @param end the upper bound of the range of smart active links (not inclusive)
	 * @return the range of smart active links
	 */
	@Override
	public List<SmartActiveLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart active links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active links
	 * @param end the upper bound of the range of smart active links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart active links
	 */
	@Override
	public List<SmartActiveLink> findAll(
		int start, int end,
		OrderByComparator<SmartActiveLink> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart active links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartActiveLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active links
	 * @param end the upper bound of the range of smart active links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart active links
	 */
	@Override
	public List<SmartActiveLink> findAll(
		int start, int end,
		OrderByComparator<SmartActiveLink> orderByComparator,
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

		List<SmartActiveLink> list = null;

		if (useFinderCache) {
			list = (List<SmartActiveLink>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SMARTACTIVELINK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SMARTACTIVELINK;

				sql = sql.concat(SmartActiveLinkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SmartActiveLink>)QueryUtil.list(
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
	 * Removes all the smart active links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SmartActiveLink smartActiveLink : findAll()) {
			remove(smartActiveLink);
		}
	}

	/**
	 * Returns the number of smart active links.
	 *
	 * @return the number of smart active links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SMARTACTIVELINK);

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
		return "smartActiveLinkId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SMARTACTIVELINK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SmartActiveLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the smart active link persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SmartActiveLinkModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SmartActiveLink.class.getName()));

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

		_finderPathFetchBycategory = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBycategory",
			new String[] {String.class.getName()}, new String[] {"category"},
			true);

		_finderPathCountBycategory = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycategory",
			new String[] {String.class.getName()}, new String[] {"category"},
			false);

		_setSmartActiveLinkUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSmartActiveLinkUtilPersistence(null);

		entityCache.removeCache(SmartActiveLinkImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setSmartActiveLinkUtilPersistence(
		SmartActiveLinkPersistence smartActiveLinkPersistence) {

		try {
			Field field = SmartActiveLinkUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, smartActiveLinkPersistence);
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

	private static final String _SQL_SELECT_SMARTACTIVELINK =
		"SELECT smartActiveLink FROM SmartActiveLink smartActiveLink";

	private static final String _SQL_SELECT_SMARTACTIVELINK_WHERE =
		"SELECT smartActiveLink FROM SmartActiveLink smartActiveLink WHERE ";

	private static final String _SQL_COUNT_SMARTACTIVELINK =
		"SELECT COUNT(smartActiveLink) FROM SmartActiveLink smartActiveLink";

	private static final String _SQL_COUNT_SMARTACTIVELINK_WHERE =
		"SELECT COUNT(smartActiveLink) FROM SmartActiveLink smartActiveLink WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "smartActiveLink.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SmartActiveLink exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SmartActiveLink exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SmartActiveLinkPersistenceImpl.class);

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

	private static class SmartActiveLinkModelArgumentsResolver
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

			SmartActiveLinkModelImpl smartActiveLinkModelImpl =
				(SmartActiveLinkModelImpl)baseModel;

			long columnBitmask = smartActiveLinkModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					smartActiveLinkModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						smartActiveLinkModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					smartActiveLinkModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SmartActiveLinkModelImpl smartActiveLinkModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						smartActiveLinkModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = smartActiveLinkModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}