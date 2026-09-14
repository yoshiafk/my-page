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

package com.mypage.admin.product.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.HealthSmeTemplate;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the health sme template service. This utility wraps <code>com.mypage.admin.product.service.persistence.impl.HealthSmeTemplatePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see HealthSmeTemplatePersistence
 * @generated
 */
public class HealthSmeTemplateUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(HealthSmeTemplate healthSmeTemplate) {
		getPersistence().clearCache(healthSmeTemplate);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, HealthSmeTemplate> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<HealthSmeTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HealthSmeTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HealthSmeTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<HealthSmeTemplate> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static HealthSmeTemplate update(
		HealthSmeTemplate healthSmeTemplate) {

		return getPersistence().update(healthSmeTemplate);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static HealthSmeTemplate update(
		HealthSmeTemplate healthSmeTemplate, ServiceContext serviceContext) {

		return getPersistence().update(healthSmeTemplate, serviceContext);
	}

	/**
	 * Caches the health sme template in the entity cache if it is enabled.
	 *
	 * @param healthSmeTemplate the health sme template
	 */
	public static void cacheResult(HealthSmeTemplate healthSmeTemplate) {
		getPersistence().cacheResult(healthSmeTemplate);
	}

	/**
	 * Caches the health sme templates in the entity cache if it is enabled.
	 *
	 * @param healthSmeTemplates the health sme templates
	 */
	public static void cacheResult(List<HealthSmeTemplate> healthSmeTemplates) {
		getPersistence().cacheResult(healthSmeTemplates);
	}

	/**
	 * Creates a new health sme template with the primary key. Does not add the health sme template to the database.
	 *
	 * @param healthSmeTemplateId the primary key for the new health sme template
	 * @return the new health sme template
	 */
	public static HealthSmeTemplate create(long healthSmeTemplateId) {
		return getPersistence().create(healthSmeTemplateId);
	}

	/**
	 * Removes the health sme template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param healthSmeTemplateId the primary key of the health sme template
	 * @return the health sme template that was removed
	 * @throws NoSuchHealthSmeTemplateException if a health sme template with the primary key could not be found
	 */
	public static HealthSmeTemplate remove(long healthSmeTemplateId)
		throws com.mypage.admin.product.exception.
			NoSuchHealthSmeTemplateException {

		return getPersistence().remove(healthSmeTemplateId);
	}

	public static HealthSmeTemplate updateImpl(
		HealthSmeTemplate healthSmeTemplate) {

		return getPersistence().updateImpl(healthSmeTemplate);
	}

	/**
	 * Returns the health sme template with the primary key or throws a <code>NoSuchHealthSmeTemplateException</code> if it could not be found.
	 *
	 * @param healthSmeTemplateId the primary key of the health sme template
	 * @return the health sme template
	 * @throws NoSuchHealthSmeTemplateException if a health sme template with the primary key could not be found
	 */
	public static HealthSmeTemplate findByPrimaryKey(long healthSmeTemplateId)
		throws com.mypage.admin.product.exception.
			NoSuchHealthSmeTemplateException {

		return getPersistence().findByPrimaryKey(healthSmeTemplateId);
	}

	/**
	 * Returns the health sme template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param healthSmeTemplateId the primary key of the health sme template
	 * @return the health sme template, or <code>null</code> if a health sme template with the primary key could not be found
	 */
	public static HealthSmeTemplate fetchByPrimaryKey(
		long healthSmeTemplateId) {

		return getPersistence().fetchByPrimaryKey(healthSmeTemplateId);
	}

	/**
	 * Returns all the health sme templates.
	 *
	 * @return the health sme templates
	 */
	public static List<HealthSmeTemplate> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the health sme templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme templates
	 * @param end the upper bound of the range of health sme templates (not inclusive)
	 * @return the range of health sme templates
	 */
	public static List<HealthSmeTemplate> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the health sme templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme templates
	 * @param end the upper bound of the range of health sme templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of health sme templates
	 */
	public static List<HealthSmeTemplate> findAll(
		int start, int end,
		OrderByComparator<HealthSmeTemplate> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the health sme templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HealthSmeTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of health sme templates
	 * @param end the upper bound of the range of health sme templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of health sme templates
	 */
	public static List<HealthSmeTemplate> findAll(
		int start, int end,
		OrderByComparator<HealthSmeTemplate> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the health sme templates from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of health sme templates.
	 *
	 * @return the number of health sme templates
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HealthSmeTemplatePersistence getPersistence() {
		return _persistence;
	}

	private static volatile HealthSmeTemplatePersistence _persistence;

}