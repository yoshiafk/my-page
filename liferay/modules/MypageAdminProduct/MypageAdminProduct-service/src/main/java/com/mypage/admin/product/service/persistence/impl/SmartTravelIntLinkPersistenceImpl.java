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
import com.liferay.portal.kernel.util.StringUtil;

import com.mypage.admin.product.exception.NoSuchSmartTravelIntLinkException;
import com.mypage.admin.product.model.SmartTravelIntLink;
import com.mypage.admin.product.model.impl.SmartTravelIntLinkImpl;
import com.mypage.admin.product.model.impl.SmartTravelIntLinkModelImpl;
import com.mypage.admin.product.service.persistence.SmartTravelIntLinkPersistence;
import com.mypage.admin.product.service.persistence.SmartTravelIntLinkUtil;
import com.mypage.admin.product.service.persistence.impl.constants.MPPersistenceConstants;

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
 * The persistence implementation for the smart travel int link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = SmartTravelIntLinkPersistence.class)
public class SmartTravelIntLinkPersistenceImpl
	extends BasePersistenceImpl<SmartTravelIntLink>
	implements SmartTravelIntLinkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SmartTravelIntLinkUtil</code> to access the smart travel int link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SmartTravelIntLinkImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByLinkType;
	private FinderPath _finderPathCountByLinkType;

	/**
	 * Returns the smart travel int link where linkType = &#63; or throws a <code>NoSuchSmartTravelIntLinkException</code> if it could not be found.
	 *
	 * @param linkType the link type
	 * @return the matching smart travel int link
	 * @throws NoSuchSmartTravelIntLinkException if a matching smart travel int link could not be found
	 */
	@Override
	public SmartTravelIntLink findByLinkType(String linkType)
		throws NoSuchSmartTravelIntLinkException {

		SmartTravelIntLink smartTravelIntLink = fetchByLinkType(linkType);

		if (smartTravelIntLink == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("linkType=");
			sb.append(linkType);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSmartTravelIntLinkException(sb.toString());
		}

		return smartTravelIntLink;
	}

	/**
	 * Returns the smart travel int link where linkType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param linkType the link type
	 * @return the matching smart travel int link, or <code>null</code> if a matching smart travel int link could not be found
	 */
	@Override
	public SmartTravelIntLink fetchByLinkType(String linkType) {
		return fetchByLinkType(linkType, true);
	}

	/**
	 * Returns the smart travel int link where linkType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param linkType the link type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching smart travel int link, or <code>null</code> if a matching smart travel int link could not be found
	 */
	@Override
	public SmartTravelIntLink fetchByLinkType(
		String linkType, boolean useFinderCache) {

		linkType = Objects.toString(linkType, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {linkType};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByLinkType, finderArgs, this);
		}

		if (result instanceof SmartTravelIntLink) {
			SmartTravelIntLink smartTravelIntLink = (SmartTravelIntLink)result;

			if (!Objects.equals(linkType, smartTravelIntLink.getLinkType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SMARTTRAVELINTLINK_WHERE);

			boolean bindLinkType = false;

			if (linkType.isEmpty()) {
				sb.append(_FINDER_COLUMN_LINKTYPE_LINKTYPE_3);
			}
			else {
				bindLinkType = true;

				sb.append(_FINDER_COLUMN_LINKTYPE_LINKTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLinkType) {
					queryPos.add(linkType);
				}

				List<SmartTravelIntLink> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByLinkType, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {linkType};
							}

							_log.warn(
								"SmartTravelIntLinkPersistenceImpl.fetchByLinkType(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SmartTravelIntLink smartTravelIntLink = list.get(0);

					result = smartTravelIntLink;

					cacheResult(smartTravelIntLink);
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
			return (SmartTravelIntLink)result;
		}
	}

	/**
	 * Removes the smart travel int link where linkType = &#63; from the database.
	 *
	 * @param linkType the link type
	 * @return the smart travel int link that was removed
	 */
	@Override
	public SmartTravelIntLink removeByLinkType(String linkType)
		throws NoSuchSmartTravelIntLinkException {

		SmartTravelIntLink smartTravelIntLink = findByLinkType(linkType);

		return remove(smartTravelIntLink);
	}

	/**
	 * Returns the number of smart travel int links where linkType = &#63;.
	 *
	 * @param linkType the link type
	 * @return the number of matching smart travel int links
	 */
	@Override
	public int countByLinkType(String linkType) {
		linkType = Objects.toString(linkType, "");

		FinderPath finderPath = _finderPathCountByLinkType;

		Object[] finderArgs = new Object[] {linkType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SMARTTRAVELINTLINK_WHERE);

			boolean bindLinkType = false;

			if (linkType.isEmpty()) {
				sb.append(_FINDER_COLUMN_LINKTYPE_LINKTYPE_3);
			}
			else {
				bindLinkType = true;

				sb.append(_FINDER_COLUMN_LINKTYPE_LINKTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLinkType) {
					queryPos.add(linkType);
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

	private static final String _FINDER_COLUMN_LINKTYPE_LINKTYPE_2 =
		"smartTravelIntLink.linkType = ?";

	private static final String _FINDER_COLUMN_LINKTYPE_LINKTYPE_3 =
		"(smartTravelIntLink.linkType IS NULL OR smartTravelIntLink.linkType = '')";

	public SmartTravelIntLinkPersistenceImpl() {
		setModelClass(SmartTravelIntLink.class);

		setModelImplClass(SmartTravelIntLinkImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the smart travel int link in the entity cache if it is enabled.
	 *
	 * @param smartTravelIntLink the smart travel int link
	 */
	@Override
	public void cacheResult(SmartTravelIntLink smartTravelIntLink) {
		entityCache.putResult(
			SmartTravelIntLinkImpl.class, smartTravelIntLink.getPrimaryKey(),
			smartTravelIntLink);

		finderCache.putResult(
			_finderPathFetchByLinkType,
			new Object[] {smartTravelIntLink.getLinkType()},
			smartTravelIntLink);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the smart travel int links in the entity cache if it is enabled.
	 *
	 * @param smartTravelIntLinks the smart travel int links
	 */
	@Override
	public void cacheResult(List<SmartTravelIntLink> smartTravelIntLinks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (smartTravelIntLinks.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SmartTravelIntLink smartTravelIntLink : smartTravelIntLinks) {
			if (entityCache.getResult(
					SmartTravelIntLinkImpl.class,
					smartTravelIntLink.getPrimaryKey()) == null) {

				cacheResult(smartTravelIntLink);
			}
		}
	}

	/**
	 * Clears the cache for all smart travel int links.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SmartTravelIntLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the smart travel int link.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SmartTravelIntLink smartTravelIntLink) {
		entityCache.removeResult(
			SmartTravelIntLinkImpl.class, smartTravelIntLink);
	}

	@Override
	public void clearCache(List<SmartTravelIntLink> smartTravelIntLinks) {
		for (SmartTravelIntLink smartTravelIntLink : smartTravelIntLinks) {
			entityCache.removeResult(
				SmartTravelIntLinkImpl.class, smartTravelIntLink);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SmartTravelIntLinkImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SmartTravelIntLinkModelImpl smartTravelIntLinkModelImpl) {

		Object[] args = new Object[] {
			smartTravelIntLinkModelImpl.getLinkType()
		};

		finderCache.putResult(
			_finderPathCountByLinkType, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByLinkType, args, smartTravelIntLinkModelImpl,
			false);
	}

	/**
	 * Creates a new smart travel int link with the primary key. Does not add the smart travel int link to the database.
	 *
	 * @param smartTravelIntLinkId the primary key for the new smart travel int link
	 * @return the new smart travel int link
	 */
	@Override
	public SmartTravelIntLink create(long smartTravelIntLinkId) {
		SmartTravelIntLink smartTravelIntLink = new SmartTravelIntLinkImpl();

		smartTravelIntLink.setNew(true);
		smartTravelIntLink.setPrimaryKey(smartTravelIntLinkId);

		smartTravelIntLink.setCompanyId(CompanyThreadLocal.getCompanyId());

		return smartTravelIntLink;
	}

	/**
	 * Removes the smart travel int link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smartTravelIntLinkId the primary key of the smart travel int link
	 * @return the smart travel int link that was removed
	 * @throws NoSuchSmartTravelIntLinkException if a smart travel int link with the primary key could not be found
	 */
	@Override
	public SmartTravelIntLink remove(long smartTravelIntLinkId)
		throws NoSuchSmartTravelIntLinkException {

		return remove((Serializable)smartTravelIntLinkId);
	}

	/**
	 * Removes the smart travel int link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the smart travel int link
	 * @return the smart travel int link that was removed
	 * @throws NoSuchSmartTravelIntLinkException if a smart travel int link with the primary key could not be found
	 */
	@Override
	public SmartTravelIntLink remove(Serializable primaryKey)
		throws NoSuchSmartTravelIntLinkException {

		Session session = null;

		try {
			session = openSession();

			SmartTravelIntLink smartTravelIntLink =
				(SmartTravelIntLink)session.get(
					SmartTravelIntLinkImpl.class, primaryKey);

			if (smartTravelIntLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSmartTravelIntLinkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(smartTravelIntLink);
		}
		catch (NoSuchSmartTravelIntLinkException noSuchEntityException) {
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
	protected SmartTravelIntLink removeImpl(
		SmartTravelIntLink smartTravelIntLink) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(smartTravelIntLink)) {
				smartTravelIntLink = (SmartTravelIntLink)session.get(
					SmartTravelIntLinkImpl.class,
					smartTravelIntLink.getPrimaryKeyObj());
			}

			if (smartTravelIntLink != null) {
				session.delete(smartTravelIntLink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (smartTravelIntLink != null) {
			clearCache(smartTravelIntLink);
		}

		return smartTravelIntLink;
	}

	@Override
	public SmartTravelIntLink updateImpl(
		SmartTravelIntLink smartTravelIntLink) {

		boolean isNew = smartTravelIntLink.isNew();

		if (!(smartTravelIntLink instanceof SmartTravelIntLinkModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(smartTravelIntLink.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					smartTravelIntLink);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in smartTravelIntLink proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SmartTravelIntLink implementation " +
					smartTravelIntLink.getClass());
		}

		SmartTravelIntLinkModelImpl smartTravelIntLinkModelImpl =
			(SmartTravelIntLinkModelImpl)smartTravelIntLink;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (smartTravelIntLink.getCreateDate() == null)) {
			if (serviceContext == null) {
				smartTravelIntLink.setCreateDate(date);
			}
			else {
				smartTravelIntLink.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!smartTravelIntLinkModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				smartTravelIntLink.setModifiedDate(date);
			}
			else {
				smartTravelIntLink.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(smartTravelIntLink);
			}
			else {
				smartTravelIntLink = (SmartTravelIntLink)session.merge(
					smartTravelIntLink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SmartTravelIntLinkImpl.class, smartTravelIntLinkModelImpl, false,
			true);

		cacheUniqueFindersCache(smartTravelIntLinkModelImpl);

		if (isNew) {
			smartTravelIntLink.setNew(false);
		}

		smartTravelIntLink.resetOriginalValues();

		return smartTravelIntLink;
	}

	/**
	 * Returns the smart travel int link with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the smart travel int link
	 * @return the smart travel int link
	 * @throws NoSuchSmartTravelIntLinkException if a smart travel int link with the primary key could not be found
	 */
	@Override
	public SmartTravelIntLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSmartTravelIntLinkException {

		SmartTravelIntLink smartTravelIntLink = fetchByPrimaryKey(primaryKey);

		if (smartTravelIntLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSmartTravelIntLinkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return smartTravelIntLink;
	}

	/**
	 * Returns the smart travel int link with the primary key or throws a <code>NoSuchSmartTravelIntLinkException</code> if it could not be found.
	 *
	 * @param smartTravelIntLinkId the primary key of the smart travel int link
	 * @return the smart travel int link
	 * @throws NoSuchSmartTravelIntLinkException if a smart travel int link with the primary key could not be found
	 */
	@Override
	public SmartTravelIntLink findByPrimaryKey(long smartTravelIntLinkId)
		throws NoSuchSmartTravelIntLinkException {

		return findByPrimaryKey((Serializable)smartTravelIntLinkId);
	}

	/**
	 * Returns the smart travel int link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smartTravelIntLinkId the primary key of the smart travel int link
	 * @return the smart travel int link, or <code>null</code> if a smart travel int link with the primary key could not be found
	 */
	@Override
	public SmartTravelIntLink fetchByPrimaryKey(long smartTravelIntLinkId) {
		return fetchByPrimaryKey((Serializable)smartTravelIntLinkId);
	}

	/**
	 * Returns all the smart travel int links.
	 *
	 * @return the smart travel int links
	 */
	@Override
	public List<SmartTravelIntLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the smart travel int links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartTravelIntLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart travel int links
	 * @param end the upper bound of the range of smart travel int links (not inclusive)
	 * @return the range of smart travel int links
	 */
	@Override
	public List<SmartTravelIntLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the smart travel int links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartTravelIntLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart travel int links
	 * @param end the upper bound of the range of smart travel int links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of smart travel int links
	 */
	@Override
	public List<SmartTravelIntLink> findAll(
		int start, int end,
		OrderByComparator<SmartTravelIntLink> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the smart travel int links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SmartTravelIntLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart travel int links
	 * @param end the upper bound of the range of smart travel int links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of smart travel int links
	 */
	@Override
	public List<SmartTravelIntLink> findAll(
		int start, int end,
		OrderByComparator<SmartTravelIntLink> orderByComparator,
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

		List<SmartTravelIntLink> list = null;

		if (useFinderCache) {
			list = (List<SmartTravelIntLink>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SMARTTRAVELINTLINK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SMARTTRAVELINTLINK;

				sql = sql.concat(SmartTravelIntLinkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SmartTravelIntLink>)QueryUtil.list(
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
	 * Removes all the smart travel int links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SmartTravelIntLink smartTravelIntLink : findAll()) {
			remove(smartTravelIntLink);
		}
	}

	/**
	 * Returns the number of smart travel int links.
	 *
	 * @return the number of smart travel int links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_SMARTTRAVELINTLINK);

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
		return "smartTravelIntLinkId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SMARTTRAVELINTLINK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SmartTravelIntLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the smart travel int link persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new SmartTravelIntLinkModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SmartTravelIntLink.class.getName()));

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

		_finderPathFetchByLinkType = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByLinkType",
			new String[] {String.class.getName()}, new String[] {"linkType"},
			true);

		_finderPathCountByLinkType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLinkType",
			new String[] {String.class.getName()}, new String[] {"linkType"},
			false);

		_setSmartTravelIntLinkUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSmartTravelIntLinkUtilPersistence(null);

		entityCache.removeCache(SmartTravelIntLinkImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setSmartTravelIntLinkUtilPersistence(
		SmartTravelIntLinkPersistence smartTravelIntLinkPersistence) {

		try {
			Field field = SmartTravelIntLinkUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, smartTravelIntLinkPersistence);
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

	private static final String _SQL_SELECT_SMARTTRAVELINTLINK =
		"SELECT smartTravelIntLink FROM SmartTravelIntLink smartTravelIntLink";

	private static final String _SQL_SELECT_SMARTTRAVELINTLINK_WHERE =
		"SELECT smartTravelIntLink FROM SmartTravelIntLink smartTravelIntLink WHERE ";

	private static final String _SQL_COUNT_SMARTTRAVELINTLINK =
		"SELECT COUNT(smartTravelIntLink) FROM SmartTravelIntLink smartTravelIntLink";

	private static final String _SQL_COUNT_SMARTTRAVELINTLINK_WHERE =
		"SELECT COUNT(smartTravelIntLink) FROM SmartTravelIntLink smartTravelIntLink WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "smartTravelIntLink.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SmartTravelIntLink exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SmartTravelIntLink exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SmartTravelIntLinkPersistenceImpl.class);

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

	private static class SmartTravelIntLinkModelArgumentsResolver
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

			SmartTravelIntLinkModelImpl smartTravelIntLinkModelImpl =
				(SmartTravelIntLinkModelImpl)baseModel;

			long columnBitmask = smartTravelIntLinkModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					smartTravelIntLinkModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						smartTravelIntLinkModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					smartTravelIntLinkModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SmartTravelIntLinkModelImpl smartTravelIntLinkModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						smartTravelIntLinkModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = smartTravelIntLinkModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}