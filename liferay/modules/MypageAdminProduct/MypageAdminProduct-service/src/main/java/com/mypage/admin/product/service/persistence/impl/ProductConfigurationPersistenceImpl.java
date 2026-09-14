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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.mypage.admin.product.exception.NoSuchProductConfigurationException;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.model.impl.ProductConfigurationImpl;
import com.mypage.admin.product.model.impl.ProductConfigurationModelImpl;
import com.mypage.admin.product.service.persistence.ProductConfigurationPersistence;
import com.mypage.admin.product.service.persistence.ProductConfigurationUtil;
import com.mypage.admin.product.service.persistence.impl.constants.MPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the product configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = ProductConfigurationPersistence.class)
public class ProductConfigurationPersistenceImpl
	extends BasePersistenceImpl<ProductConfiguration>
	implements ProductConfigurationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductConfigurationUtil</code> to access the product configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductConfigurationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByProductCode;
	private FinderPath _finderPathCountByProductCode;

	/**
	 * Returns the product configuration where productCode = &#63; or throws a <code>NoSuchProductConfigurationException</code> if it could not be found.
	 *
	 * @param productCode the product code
	 * @return the matching product configuration
	 * @throws NoSuchProductConfigurationException if a matching product configuration could not be found
	 */
	@Override
	public ProductConfiguration findByProductCode(String productCode)
		throws NoSuchProductConfigurationException {

		ProductConfiguration productConfiguration = fetchByProductCode(
			productCode);

		if (productConfiguration == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("productCode=");
			sb.append(productCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProductConfigurationException(sb.toString());
		}

		return productConfiguration;
	}

	/**
	 * Returns the product configuration where productCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productCode the product code
	 * @return the matching product configuration, or <code>null</code> if a matching product configuration could not be found
	 */
	@Override
	public ProductConfiguration fetchByProductCode(String productCode) {
		return fetchByProductCode(productCode, true);
	}

	/**
	 * Returns the product configuration where productCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productCode the product code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product configuration, or <code>null</code> if a matching product configuration could not be found
	 */
	@Override
	public ProductConfiguration fetchByProductCode(
		String productCode, boolean useFinderCache) {

		productCode = Objects.toString(productCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {productCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProductCode, finderArgs, this);
		}

		if (result instanceof ProductConfiguration) {
			ProductConfiguration productConfiguration =
				(ProductConfiguration)result;

			if (!Objects.equals(
					productCode, productConfiguration.getProductCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PRODUCTCONFIGURATION_WHERE);

			boolean bindProductCode = false;

			if (productCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_3);
			}
			else {
				bindProductCode = true;

				sb.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProductCode) {
					queryPos.add(productCode);
				}

				List<ProductConfiguration> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProductCode, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {productCode};
							}

							_log.warn(
								"ProductConfigurationPersistenceImpl.fetchByProductCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProductConfiguration productConfiguration = list.get(0);

					result = productConfiguration;

					cacheResult(productConfiguration);
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
			return (ProductConfiguration)result;
		}
	}

	/**
	 * Removes the product configuration where productCode = &#63; from the database.
	 *
	 * @param productCode the product code
	 * @return the product configuration that was removed
	 */
	@Override
	public ProductConfiguration removeByProductCode(String productCode)
		throws NoSuchProductConfigurationException {

		ProductConfiguration productConfiguration = findByProductCode(
			productCode);

		return remove(productConfiguration);
	}

	/**
	 * Returns the number of product configurations where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @return the number of matching product configurations
	 */
	@Override
	public int countByProductCode(String productCode) {
		productCode = Objects.toString(productCode, "");

		FinderPath finderPath = _finderPathCountByProductCode;

		Object[] finderArgs = new Object[] {productCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTCONFIGURATION_WHERE);

			boolean bindProductCode = false;

			if (productCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_3);
			}
			else {
				bindProductCode = true;

				sb.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProductCode) {
					queryPos.add(productCode);
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

	private static final String _FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_2 =
		"productConfiguration.productCode = ?";

	private static final String _FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_3 =
		"(productConfiguration.productCode IS NULL OR productConfiguration.productCode = '')";

	public ProductConfigurationPersistenceImpl() {
		setModelClass(ProductConfiguration.class);

		setModelImplClass(ProductConfigurationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the product configuration in the entity cache if it is enabled.
	 *
	 * @param productConfiguration the product configuration
	 */
	@Override
	public void cacheResult(ProductConfiguration productConfiguration) {
		entityCache.putResult(
			ProductConfigurationImpl.class,
			productConfiguration.getPrimaryKey(), productConfiguration);

		finderCache.putResult(
			_finderPathFetchByProductCode,
			new Object[] {productConfiguration.getProductCode()},
			productConfiguration);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the product configurations in the entity cache if it is enabled.
	 *
	 * @param productConfigurations the product configurations
	 */
	@Override
	public void cacheResult(List<ProductConfiguration> productConfigurations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (productConfigurations.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProductConfiguration productConfiguration :
				productConfigurations) {

			if (entityCache.getResult(
					ProductConfigurationImpl.class,
					productConfiguration.getPrimaryKey()) == null) {

				cacheResult(productConfiguration);
			}
		}
	}

	/**
	 * Clears the cache for all product configurations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductConfigurationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the product configuration.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductConfiguration productConfiguration) {
		entityCache.removeResult(
			ProductConfigurationImpl.class, productConfiguration);
	}

	@Override
	public void clearCache(List<ProductConfiguration> productConfigurations) {
		for (ProductConfiguration productConfiguration :
				productConfigurations) {

			entityCache.removeResult(
				ProductConfigurationImpl.class, productConfiguration);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProductConfigurationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProductConfigurationModelImpl productConfigurationModelImpl) {

		Object[] args = new Object[] {
			productConfigurationModelImpl.getProductCode()
		};

		finderCache.putResult(
			_finderPathCountByProductCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByProductCode, args, productConfigurationModelImpl,
			false);
	}

	/**
	 * Creates a new product configuration with the primary key. Does not add the product configuration to the database.
	 *
	 * @param productId the primary key for the new product configuration
	 * @return the new product configuration
	 */
	@Override
	public ProductConfiguration create(long productId) {
		ProductConfiguration productConfiguration =
			new ProductConfigurationImpl();

		productConfiguration.setNew(true);
		productConfiguration.setPrimaryKey(productId);

		return productConfiguration;
	}

	/**
	 * Removes the product configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the product configuration
	 * @return the product configuration that was removed
	 * @throws NoSuchProductConfigurationException if a product configuration with the primary key could not be found
	 */
	@Override
	public ProductConfiguration remove(long productId)
		throws NoSuchProductConfigurationException {

		return remove((Serializable)productId);
	}

	/**
	 * Removes the product configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product configuration
	 * @return the product configuration that was removed
	 * @throws NoSuchProductConfigurationException if a product configuration with the primary key could not be found
	 */
	@Override
	public ProductConfiguration remove(Serializable primaryKey)
		throws NoSuchProductConfigurationException {

		Session session = null;

		try {
			session = openSession();

			ProductConfiguration productConfiguration =
				(ProductConfiguration)session.get(
					ProductConfigurationImpl.class, primaryKey);

			if (productConfiguration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductConfigurationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productConfiguration);
		}
		catch (NoSuchProductConfigurationException noSuchEntityException) {
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
	protected ProductConfiguration removeImpl(
		ProductConfiguration productConfiguration) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productConfiguration)) {
				productConfiguration = (ProductConfiguration)session.get(
					ProductConfigurationImpl.class,
					productConfiguration.getPrimaryKeyObj());
			}

			if (productConfiguration != null) {
				session.delete(productConfiguration);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productConfiguration != null) {
			clearCache(productConfiguration);
		}

		return productConfiguration;
	}

	@Override
	public ProductConfiguration updateImpl(
		ProductConfiguration productConfiguration) {

		boolean isNew = productConfiguration.isNew();

		if (!(productConfiguration instanceof ProductConfigurationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(productConfiguration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					productConfiguration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in productConfiguration proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProductConfiguration implementation " +
					productConfiguration.getClass());
		}

		ProductConfigurationModelImpl productConfigurationModelImpl =
			(ProductConfigurationModelImpl)productConfiguration;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(productConfiguration);
			}
			else {
				productConfiguration = (ProductConfiguration)session.merge(
					productConfiguration);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProductConfigurationImpl.class, productConfigurationModelImpl,
			false, true);

		cacheUniqueFindersCache(productConfigurationModelImpl);

		if (isNew) {
			productConfiguration.setNew(false);
		}

		productConfiguration.resetOriginalValues();

		return productConfiguration;
	}

	/**
	 * Returns the product configuration with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product configuration
	 * @return the product configuration
	 * @throws NoSuchProductConfigurationException if a product configuration with the primary key could not be found
	 */
	@Override
	public ProductConfiguration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductConfigurationException {

		ProductConfiguration productConfiguration = fetchByPrimaryKey(
			primaryKey);

		if (productConfiguration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductConfigurationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productConfiguration;
	}

	/**
	 * Returns the product configuration with the primary key or throws a <code>NoSuchProductConfigurationException</code> if it could not be found.
	 *
	 * @param productId the primary key of the product configuration
	 * @return the product configuration
	 * @throws NoSuchProductConfigurationException if a product configuration with the primary key could not be found
	 */
	@Override
	public ProductConfiguration findByPrimaryKey(long productId)
		throws NoSuchProductConfigurationException {

		return findByPrimaryKey((Serializable)productId);
	}

	/**
	 * Returns the product configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productId the primary key of the product configuration
	 * @return the product configuration, or <code>null</code> if a product configuration with the primary key could not be found
	 */
	@Override
	public ProductConfiguration fetchByPrimaryKey(long productId) {
		return fetchByPrimaryKey((Serializable)productId);
	}

	/**
	 * Returns all the product configurations.
	 *
	 * @return the product configurations
	 */
	@Override
	public List<ProductConfiguration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product configurations
	 * @param end the upper bound of the range of product configurations (not inclusive)
	 * @return the range of product configurations
	 */
	@Override
	public List<ProductConfiguration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product configurations
	 * @param end the upper bound of the range of product configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product configurations
	 */
	@Override
	public List<ProductConfiguration> findAll(
		int start, int end,
		OrderByComparator<ProductConfiguration> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product configurations
	 * @param end the upper bound of the range of product configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product configurations
	 */
	@Override
	public List<ProductConfiguration> findAll(
		int start, int end,
		OrderByComparator<ProductConfiguration> orderByComparator,
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

		List<ProductConfiguration> list = null;

		if (useFinderCache) {
			list = (List<ProductConfiguration>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRODUCTCONFIGURATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTCONFIGURATION;

				sql = sql.concat(ProductConfigurationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProductConfiguration>)QueryUtil.list(
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
	 * Removes all the product configurations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductConfiguration productConfiguration : findAll()) {
			remove(productConfiguration);
		}
	}

	/**
	 * Returns the number of product configurations.
	 *
	 * @return the number of product configurations
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
					_SQL_COUNT_PRODUCTCONFIGURATION);

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
		return "productId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRODUCTCONFIGURATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductConfigurationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the product configuration persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ProductConfigurationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ProductConfiguration.class.getName()));

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

		_finderPathFetchByProductCode = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByProductCode",
			new String[] {String.class.getName()}, new String[] {"productCode"},
			true);

		_finderPathCountByProductCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProductCode",
			new String[] {String.class.getName()}, new String[] {"productCode"},
			false);

		_setProductConfigurationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProductConfigurationUtilPersistence(null);

		entityCache.removeCache(ProductConfigurationImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setProductConfigurationUtilPersistence(
		ProductConfigurationPersistence productConfigurationPersistence) {

		try {
			Field field = ProductConfigurationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, productConfigurationPersistence);
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

	private static final String _SQL_SELECT_PRODUCTCONFIGURATION =
		"SELECT productConfiguration FROM ProductConfiguration productConfiguration";

	private static final String _SQL_SELECT_PRODUCTCONFIGURATION_WHERE =
		"SELECT productConfiguration FROM ProductConfiguration productConfiguration WHERE ";

	private static final String _SQL_COUNT_PRODUCTCONFIGURATION =
		"SELECT COUNT(productConfiguration) FROM ProductConfiguration productConfiguration";

	private static final String _SQL_COUNT_PRODUCTCONFIGURATION_WHERE =
		"SELECT COUNT(productConfiguration) FROM ProductConfiguration productConfiguration WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"productConfiguration.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductConfiguration exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProductConfiguration exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductConfigurationPersistenceImpl.class);

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

	private static class ProductConfigurationModelArgumentsResolver
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

			ProductConfigurationModelImpl productConfigurationModelImpl =
				(ProductConfigurationModelImpl)baseModel;

			long columnBitmask =
				productConfigurationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					productConfigurationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						productConfigurationModelImpl.getColumnBitmask(
							columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(ProductConfigurationPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					productConfigurationModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			ProductConfigurationModelImpl productConfigurationModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						productConfigurationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = productConfigurationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |=
				ProductConfigurationModelImpl.getColumnBitmask("productCode");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}