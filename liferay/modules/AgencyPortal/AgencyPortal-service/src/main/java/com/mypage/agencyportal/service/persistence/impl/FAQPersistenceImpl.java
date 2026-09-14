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
import com.liferay.portal.kernel.util.SetUtil;

import com.mypage.agencyportal.exception.NoSuchFAQException;
import com.mypage.agencyportal.model.FAQ;
import com.mypage.agencyportal.model.impl.FAQImpl;
import com.mypage.agencyportal.model.impl.FAQModelImpl;
import com.mypage.agencyportal.service.persistence.FAQPersistence;
import com.mypage.agencyportal.service.persistence.FAQUtil;
import com.mypage.agencyportal.service.persistence.impl.constants.APPersistenceConstants;

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
 * The persistence implementation for the faq service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @generated
 */
@Component(service = FAQPersistence.class)
public class FAQPersistenceImpl
	extends BasePersistenceImpl<FAQ> implements FAQPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FAQUtil</code> to access the faq persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FAQImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBycategory;
	private FinderPath _finderPathWithoutPaginationFindBycategory;
	private FinderPath _finderPathCountBycategory;

	/**
	 * Returns all the faqs where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching faqs
	 */
	@Override
	public List<FAQ> findBycategory(String category) {
		return findBycategory(
			category, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faqs where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FAQModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @return the range of matching faqs
	 */
	@Override
	public List<FAQ> findBycategory(String category, int start, int end) {
		return findBycategory(category, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faqs where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FAQModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faqs
	 */
	@Override
	public List<FAQ> findBycategory(
		String category, int start, int end,
		OrderByComparator<FAQ> orderByComparator) {

		return findBycategory(category, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faqs where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FAQModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faqs
	 */
	@Override
	public List<FAQ> findBycategory(
		String category, int start, int end,
		OrderByComparator<FAQ> orderByComparator, boolean useFinderCache) {

		category = Objects.toString(category, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBycategory;
				finderArgs = new Object[] {category};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycategory;
			finderArgs = new Object[] {category, start, end, orderByComparator};
		}

		List<FAQ> list = null;

		if (useFinderCache) {
			list = (List<FAQ>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FAQ faq : list) {
					if (!category.equals(faq.getCategory())) {
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

			sb.append(_SQL_SELECT_FAQ_WHERE);

			boolean bindCategory = false;

			if (category.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FAQModelImpl.ORDER_BY_JPQL);
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

				list = (List<FAQ>)QueryUtil.list(
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
	 * Returns the first faq in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq
	 * @throws NoSuchFAQException if a matching faq could not be found
	 */
	@Override
	public FAQ findBycategory_First(
			String category, OrderByComparator<FAQ> orderByComparator)
		throws NoSuchFAQException {

		FAQ faq = fetchBycategory_First(category, orderByComparator);

		if (faq != null) {
			return faq;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("category=");
		sb.append(category);

		sb.append("}");

		throw new NoSuchFAQException(sb.toString());
	}

	/**
	 * Returns the first faq in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq, or <code>null</code> if a matching faq could not be found
	 */
	@Override
	public FAQ fetchBycategory_First(
		String category, OrderByComparator<FAQ> orderByComparator) {

		List<FAQ> list = findBycategory(category, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faq in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq
	 * @throws NoSuchFAQException if a matching faq could not be found
	 */
	@Override
	public FAQ findBycategory_Last(
			String category, OrderByComparator<FAQ> orderByComparator)
		throws NoSuchFAQException {

		FAQ faq = fetchBycategory_Last(category, orderByComparator);

		if (faq != null) {
			return faq;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("category=");
		sb.append(category);

		sb.append("}");

		throw new NoSuchFAQException(sb.toString());
	}

	/**
	 * Returns the last faq in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq, or <code>null</code> if a matching faq could not be found
	 */
	@Override
	public FAQ fetchBycategory_Last(
		String category, OrderByComparator<FAQ> orderByComparator) {

		int count = countBycategory(category);

		if (count == 0) {
			return null;
		}

		List<FAQ> list = findBycategory(
			category, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faqs before and after the current faq in the ordered set where category = &#63;.
	 *
	 * @param faqId the primary key of the current faq
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faq
	 * @throws NoSuchFAQException if a faq with the primary key could not be found
	 */
	@Override
	public FAQ[] findBycategory_PrevAndNext(
			long faqId, String category,
			OrderByComparator<FAQ> orderByComparator)
		throws NoSuchFAQException {

		category = Objects.toString(category, "");

		FAQ faq = findByPrimaryKey(faqId);

		Session session = null;

		try {
			session = openSession();

			FAQ[] array = new FAQImpl[3];

			array[0] = getBycategory_PrevAndNext(
				session, faq, category, orderByComparator, true);

			array[1] = faq;

			array[2] = getBycategory_PrevAndNext(
				session, faq, category, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FAQ getBycategory_PrevAndNext(
		Session session, FAQ faq, String category,
		OrderByComparator<FAQ> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FAQ_WHERE);

		boolean bindCategory = false;

		if (category.isEmpty()) {
			sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
		}
		else {
			bindCategory = true;

			sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
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
			sb.append(FAQModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCategory) {
			queryPos.add(category);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(faq)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FAQ> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faqs where category = &#63; from the database.
	 *
	 * @param category the category
	 */
	@Override
	public void removeBycategory(String category) {
		for (FAQ faq :
				findBycategory(
					category, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(faq);
		}
	}

	/**
	 * Returns the number of faqs where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching faqs
	 */
	@Override
	public int countBycategory(String category) {
		category = Objects.toString(category, "");

		FinderPath finderPath = _finderPathCountBycategory;

		Object[] finderArgs = new Object[] {category};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FAQ_WHERE);

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
		"faq.category = ?";

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_3 =
		"(faq.category IS NULL OR faq.category = '')";

	public FAQPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FAQ.class);

		setModelImplClass(FAQImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the faq in the entity cache if it is enabled.
	 *
	 * @param faq the faq
	 */
	@Override
	public void cacheResult(FAQ faq) {
		entityCache.putResult(FAQImpl.class, faq.getPrimaryKey(), faq);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the faqs in the entity cache if it is enabled.
	 *
	 * @param faqs the faqs
	 */
	@Override
	public void cacheResult(List<FAQ> faqs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (faqs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FAQ faq : faqs) {
			if (entityCache.getResult(FAQImpl.class, faq.getPrimaryKey()) ==
					null) {

				cacheResult(faq);
			}
		}
	}

	/**
	 * Clears the cache for all faqs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FAQImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the faq.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FAQ faq) {
		entityCache.removeResult(FAQImpl.class, faq);
	}

	@Override
	public void clearCache(List<FAQ> faqs) {
		for (FAQ faq : faqs) {
			entityCache.removeResult(FAQImpl.class, faq);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FAQImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new faq with the primary key. Does not add the faq to the database.
	 *
	 * @param faqId the primary key for the new faq
	 * @return the new faq
	 */
	@Override
	public FAQ create(long faqId) {
		FAQ faq = new FAQImpl();

		faq.setNew(true);
		faq.setPrimaryKey(faqId);

		faq.setCompanyId(CompanyThreadLocal.getCompanyId());

		return faq;
	}

	/**
	 * Removes the faq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param faqId the primary key of the faq
	 * @return the faq that was removed
	 * @throws NoSuchFAQException if a faq with the primary key could not be found
	 */
	@Override
	public FAQ remove(long faqId) throws NoSuchFAQException {
		return remove((Serializable)faqId);
	}

	/**
	 * Removes the faq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the faq
	 * @return the faq that was removed
	 * @throws NoSuchFAQException if a faq with the primary key could not be found
	 */
	@Override
	public FAQ remove(Serializable primaryKey) throws NoSuchFAQException {
		Session session = null;

		try {
			session = openSession();

			FAQ faq = (FAQ)session.get(FAQImpl.class, primaryKey);

			if (faq == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFAQException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(faq);
		}
		catch (NoSuchFAQException noSuchEntityException) {
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
	protected FAQ removeImpl(FAQ faq) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(faq)) {
				faq = (FAQ)session.get(FAQImpl.class, faq.getPrimaryKeyObj());
			}

			if (faq != null) {
				session.delete(faq);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (faq != null) {
			clearCache(faq);
		}

		return faq;
	}

	@Override
	public FAQ updateImpl(FAQ faq) {
		boolean isNew = faq.isNew();

		if (!(faq instanceof FAQModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(faq.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(faq);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in faq proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FAQ implementation " +
					faq.getClass());
		}

		FAQModelImpl faqModelImpl = (FAQModelImpl)faq;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (faq.getCreateDate() == null)) {
			if (serviceContext == null) {
				faq.setCreateDate(date);
			}
			else {
				faq.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!faqModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				faq.setModifiedDate(date);
			}
			else {
				faq.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(faq);
			}
			else {
				faq = (FAQ)session.merge(faq);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(FAQImpl.class, faqModelImpl, false, true);

		if (isNew) {
			faq.setNew(false);
		}

		faq.resetOriginalValues();

		return faq;
	}

	/**
	 * Returns the faq with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the faq
	 * @return the faq
	 * @throws NoSuchFAQException if a faq with the primary key could not be found
	 */
	@Override
	public FAQ findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFAQException {

		FAQ faq = fetchByPrimaryKey(primaryKey);

		if (faq == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFAQException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return faq;
	}

	/**
	 * Returns the faq with the primary key or throws a <code>NoSuchFAQException</code> if it could not be found.
	 *
	 * @param faqId the primary key of the faq
	 * @return the faq
	 * @throws NoSuchFAQException if a faq with the primary key could not be found
	 */
	@Override
	public FAQ findByPrimaryKey(long faqId) throws NoSuchFAQException {
		return findByPrimaryKey((Serializable)faqId);
	}

	/**
	 * Returns the faq with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param faqId the primary key of the faq
	 * @return the faq, or <code>null</code> if a faq with the primary key could not be found
	 */
	@Override
	public FAQ fetchByPrimaryKey(long faqId) {
		return fetchByPrimaryKey((Serializable)faqId);
	}

	/**
	 * Returns all the faqs.
	 *
	 * @return the faqs
	 */
	@Override
	public List<FAQ> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FAQModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @return the range of faqs
	 */
	@Override
	public List<FAQ> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FAQModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faqs
	 */
	@Override
	public List<FAQ> findAll(
		int start, int end, OrderByComparator<FAQ> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FAQModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faqs
	 */
	@Override
	public List<FAQ> findAll(
		int start, int end, OrderByComparator<FAQ> orderByComparator,
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

		List<FAQ> list = null;

		if (useFinderCache) {
			list = (List<FAQ>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FAQ);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FAQ;

				sql = sql.concat(FAQModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FAQ>)QueryUtil.list(
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
	 * Removes all the faqs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FAQ faq : findAll()) {
			remove(faq);
		}
	}

	/**
	 * Returns the number of faqs.
	 *
	 * @return the number of faqs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FAQ);

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
		return "faqId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FAQ;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FAQModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the faq persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new FAQModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", FAQ.class.getName()));

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

		_finderPathWithPaginationFindBycategory = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycategory",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"category"}, true);

		_finderPathWithoutPaginationFindBycategory = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycategory",
			new String[] {String.class.getName()}, new String[] {"category"},
			true);

		_finderPathCountBycategory = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycategory",
			new String[] {String.class.getName()}, new String[] {"category"},
			false);

		_setFAQUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFAQUtilPersistence(null);

		entityCache.removeCache(FAQImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setFAQUtilPersistence(FAQPersistence faqPersistence) {
		try {
			Field field = FAQUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, faqPersistence);
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

	private static final String _SQL_SELECT_FAQ = "SELECT faq FROM FAQ faq";

	private static final String _SQL_SELECT_FAQ_WHERE =
		"SELECT faq FROM FAQ faq WHERE ";

	private static final String _SQL_COUNT_FAQ =
		"SELECT COUNT(faq) FROM FAQ faq";

	private static final String _SQL_COUNT_FAQ_WHERE =
		"SELECT COUNT(faq) FROM FAQ faq WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "faq.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FAQ exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FAQ exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FAQPersistenceImpl.class);

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

	private static class FAQModelArgumentsResolver
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

			FAQModelImpl faqModelImpl = (FAQModelImpl)baseModel;

			long columnBitmask = faqModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(faqModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= faqModelImpl.getColumnBitmask(
						columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(faqModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			FAQModelImpl faqModelImpl, String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = faqModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = faqModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}