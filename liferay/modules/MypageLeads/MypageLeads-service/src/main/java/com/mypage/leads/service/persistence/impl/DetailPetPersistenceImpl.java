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

import com.mypage.leads.exception.NoSuchDetailPetException;
import com.mypage.leads.model.DetailPet;
import com.mypage.leads.model.impl.DetailPetImpl;
import com.mypage.leads.model.impl.DetailPetModelImpl;
import com.mypage.leads.service.persistence.DetailPetPersistence;
import com.mypage.leads.service.persistence.DetailPetUtil;
import com.mypage.leads.service.persistence.impl.constants.MPLPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
 * The persistence implementation for the detail pet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus
 * @generated
 */
@Component(service = DetailPetPersistence.class)
public class DetailPetPersistenceImpl
	extends BasePersistenceImpl<DetailPet> implements DetailPetPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DetailPetUtil</code> to access the detail pet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DetailPetImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBysearchByLeadsId;
	private FinderPath _finderPathCountBysearchByLeadsId;

	/**
	 * Returns the detail pet where LeadsId = &#63; or throws a <code>NoSuchDetailPetException</code> if it could not be found.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail pet
	 * @throws NoSuchDetailPetException if a matching detail pet could not be found
	 */
	@Override
	public DetailPet findBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailPetException {

		DetailPet detailPet = fetchBysearchByLeadsId(LeadsId);

		if (detailPet == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("LeadsId=");
			sb.append(LeadsId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDetailPetException(sb.toString());
		}

		return detailPet;
	}

	/**
	 * Returns the detail pet where LeadsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @return the matching detail pet, or <code>null</code> if a matching detail pet could not be found
	 */
	@Override
	public DetailPet fetchBysearchByLeadsId(long LeadsId) {
		return fetchBysearchByLeadsId(LeadsId, true);
	}

	/**
	 * Returns the detail pet where LeadsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param LeadsId the leads ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching detail pet, or <code>null</code> if a matching detail pet could not be found
	 */
	@Override
	public DetailPet fetchBysearchByLeadsId(
		long LeadsId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {LeadsId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBysearchByLeadsId, finderArgs, this);
		}

		if (result instanceof DetailPet) {
			DetailPet detailPet = (DetailPet)result;

			if (LeadsId != detailPet.getLeadsId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DETAILPET_WHERE);

			sb.append(_FINDER_COLUMN_SEARCHBYLEADSID_LEADSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(LeadsId);

				List<DetailPet> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBysearchByLeadsId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {LeadsId};
							}

							_log.warn(
								"DetailPetPersistenceImpl.fetchBysearchByLeadsId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DetailPet detailPet = list.get(0);

					result = detailPet;

					cacheResult(detailPet);
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
			return (DetailPet)result;
		}
	}

	/**
	 * Removes the detail pet where LeadsId = &#63; from the database.
	 *
	 * @param LeadsId the leads ID
	 * @return the detail pet that was removed
	 */
	@Override
	public DetailPet removeBysearchByLeadsId(long LeadsId)
		throws NoSuchDetailPetException {

		DetailPet detailPet = findBysearchByLeadsId(LeadsId);

		return remove(detailPet);
	}

	/**
	 * Returns the number of detail pets where LeadsId = &#63;.
	 *
	 * @param LeadsId the leads ID
	 * @return the number of matching detail pets
	 */
	@Override
	public int countBysearchByLeadsId(long LeadsId) {
		FinderPath finderPath = _finderPathCountBysearchByLeadsId;

		Object[] finderArgs = new Object[] {LeadsId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DETAILPET_WHERE);

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
		"detailPet.LeadsId = ?";

	public DetailPetPersistenceImpl() {
		setModelClass(DetailPet.class);

		setModelImplClass(DetailPetImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the detail pet in the entity cache if it is enabled.
	 *
	 * @param detailPet the detail pet
	 */
	@Override
	public void cacheResult(DetailPet detailPet) {
		entityCache.putResult(
			DetailPetImpl.class, detailPet.getPrimaryKey(), detailPet);

		finderCache.putResult(
			_finderPathFetchBysearchByLeadsId,
			new Object[] {detailPet.getLeadsId()}, detailPet);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the detail pets in the entity cache if it is enabled.
	 *
	 * @param detailPets the detail pets
	 */
	@Override
	public void cacheResult(List<DetailPet> detailPets) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (detailPets.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DetailPet detailPet : detailPets) {
			if (entityCache.getResult(
					DetailPetImpl.class, detailPet.getPrimaryKey()) == null) {

				cacheResult(detailPet);
			}
		}
	}

	/**
	 * Clears the cache for all detail pets.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DetailPetImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the detail pet.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DetailPet detailPet) {
		entityCache.removeResult(DetailPetImpl.class, detailPet);
	}

	@Override
	public void clearCache(List<DetailPet> detailPets) {
		for (DetailPet detailPet : detailPets) {
			entityCache.removeResult(DetailPetImpl.class, detailPet);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DetailPetImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DetailPetModelImpl detailPetModelImpl) {

		Object[] args = new Object[] {detailPetModelImpl.getLeadsId()};

		finderCache.putResult(
			_finderPathCountBysearchByLeadsId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBysearchByLeadsId, args, detailPetModelImpl, false);
	}

	/**
	 * Creates a new detail pet with the primary key. Does not add the detail pet to the database.
	 *
	 * @param detailPetId the primary key for the new detail pet
	 * @return the new detail pet
	 */
	@Override
	public DetailPet create(long detailPetId) {
		DetailPet detailPet = new DetailPetImpl();

		detailPet.setNew(true);
		detailPet.setPrimaryKey(detailPetId);

		detailPet.setCompanyId(CompanyThreadLocal.getCompanyId());

		return detailPet;
	}

	/**
	 * Removes the detail pet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param detailPetId the primary key of the detail pet
	 * @return the detail pet that was removed
	 * @throws NoSuchDetailPetException if a detail pet with the primary key could not be found
	 */
	@Override
	public DetailPet remove(long detailPetId) throws NoSuchDetailPetException {
		return remove((Serializable)detailPetId);
	}

	/**
	 * Removes the detail pet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the detail pet
	 * @return the detail pet that was removed
	 * @throws NoSuchDetailPetException if a detail pet with the primary key could not be found
	 */
	@Override
	public DetailPet remove(Serializable primaryKey)
		throws NoSuchDetailPetException {

		Session session = null;

		try {
			session = openSession();

			DetailPet detailPet = (DetailPet)session.get(
				DetailPetImpl.class, primaryKey);

			if (detailPet == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDetailPetException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(detailPet);
		}
		catch (NoSuchDetailPetException noSuchEntityException) {
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
	protected DetailPet removeImpl(DetailPet detailPet) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(detailPet)) {
				detailPet = (DetailPet)session.get(
					DetailPetImpl.class, detailPet.getPrimaryKeyObj());
			}

			if (detailPet != null) {
				session.delete(detailPet);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (detailPet != null) {
			clearCache(detailPet);
		}

		return detailPet;
	}

	@Override
	public DetailPet updateImpl(DetailPet detailPet) {
		boolean isNew = detailPet.isNew();

		if (!(detailPet instanceof DetailPetModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(detailPet.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(detailPet);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in detailPet proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DetailPet implementation " +
					detailPet.getClass());
		}

		DetailPetModelImpl detailPetModelImpl = (DetailPetModelImpl)detailPet;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (detailPet.getCreateDate() == null)) {
			if (serviceContext == null) {
				detailPet.setCreateDate(date);
			}
			else {
				detailPet.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!detailPetModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				detailPet.setModifiedDate(date);
			}
			else {
				detailPet.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(detailPet);
			}
			else {
				detailPet = (DetailPet)session.merge(detailPet);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DetailPetImpl.class, detailPetModelImpl, false, true);

		cacheUniqueFindersCache(detailPetModelImpl);

		if (isNew) {
			detailPet.setNew(false);
		}

		detailPet.resetOriginalValues();

		return detailPet;
	}

	/**
	 * Returns the detail pet with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the detail pet
	 * @return the detail pet
	 * @throws NoSuchDetailPetException if a detail pet with the primary key could not be found
	 */
	@Override
	public DetailPet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDetailPetException {

		DetailPet detailPet = fetchByPrimaryKey(primaryKey);

		if (detailPet == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDetailPetException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return detailPet;
	}

	/**
	 * Returns the detail pet with the primary key or throws a <code>NoSuchDetailPetException</code> if it could not be found.
	 *
	 * @param detailPetId the primary key of the detail pet
	 * @return the detail pet
	 * @throws NoSuchDetailPetException if a detail pet with the primary key could not be found
	 */
	@Override
	public DetailPet findByPrimaryKey(long detailPetId)
		throws NoSuchDetailPetException {

		return findByPrimaryKey((Serializable)detailPetId);
	}

	/**
	 * Returns the detail pet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param detailPetId the primary key of the detail pet
	 * @return the detail pet, or <code>null</code> if a detail pet with the primary key could not be found
	 */
	@Override
	public DetailPet fetchByPrimaryKey(long detailPetId) {
		return fetchByPrimaryKey((Serializable)detailPetId);
	}

	/**
	 * Returns all the detail pets.
	 *
	 * @return the detail pets
	 */
	@Override
	public List<DetailPet> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the detail pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailPetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail pets
	 * @param end the upper bound of the range of detail pets (not inclusive)
	 * @return the range of detail pets
	 */
	@Override
	public List<DetailPet> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the detail pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailPetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail pets
	 * @param end the upper bound of the range of detail pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of detail pets
	 */
	@Override
	public List<DetailPet> findAll(
		int start, int end, OrderByComparator<DetailPet> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the detail pets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DetailPetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of detail pets
	 * @param end the upper bound of the range of detail pets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of detail pets
	 */
	@Override
	public List<DetailPet> findAll(
		int start, int end, OrderByComparator<DetailPet> orderByComparator,
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

		List<DetailPet> list = null;

		if (useFinderCache) {
			list = (List<DetailPet>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DETAILPET);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DETAILPET;

				sql = sql.concat(DetailPetModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DetailPet>)QueryUtil.list(
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
	 * Removes all the detail pets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DetailPet detailPet : findAll()) {
			remove(detailPet);
		}
	}

	/**
	 * Returns the number of detail pets.
	 *
	 * @return the number of detail pets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DETAILPET);

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
		return "detailPetId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DETAILPET;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DetailPetModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the detail pet persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new DetailPetModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DetailPet.class.getName()));

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

		_finderPathFetchBysearchByLeadsId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBysearchByLeadsId",
			new String[] {Long.class.getName()}, new String[] {"LeadsId"},
			true);

		_finderPathCountBysearchByLeadsId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysearchByLeadsId",
			new String[] {Long.class.getName()}, new String[] {"LeadsId"},
			false);

		_setDetailPetUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDetailPetUtilPersistence(null);

		entityCache.removeCache(DetailPetImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setDetailPetUtilPersistence(
		DetailPetPersistence detailPetPersistence) {

		try {
			Field field = DetailPetUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, detailPetPersistence);
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

	private static final String _SQL_SELECT_DETAILPET =
		"SELECT detailPet FROM DetailPet detailPet";

	private static final String _SQL_SELECT_DETAILPET_WHERE =
		"SELECT detailPet FROM DetailPet detailPet WHERE ";

	private static final String _SQL_COUNT_DETAILPET =
		"SELECT COUNT(detailPet) FROM DetailPet detailPet";

	private static final String _SQL_COUNT_DETAILPET_WHERE =
		"SELECT COUNT(detailPet) FROM DetailPet detailPet WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "detailPet.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DetailPet exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DetailPet exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DetailPetPersistenceImpl.class);

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

	private static class DetailPetModelArgumentsResolver
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

			DetailPetModelImpl detailPetModelImpl =
				(DetailPetModelImpl)baseModel;

			long columnBitmask = detailPetModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(detailPetModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						detailPetModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(detailPetModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			DetailPetModelImpl detailPetModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = detailPetModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = detailPetModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}