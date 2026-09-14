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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mypage.admin.product.exception.NoSuchHealthSmeTemplateException;
import com.mypage.admin.product.model.HealthSmeTemplate;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the health sme template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gositus Team
 * @see HealthSmeTemplateUtil
 * @generated
 */
@ProviderType
public interface HealthSmeTemplatePersistence
	extends BasePersistence<HealthSmeTemplate> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HealthSmeTemplateUtil} to access the health sme template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the health sme template in the entity cache if it is enabled.
	 *
	 * @param healthSmeTemplate the health sme template
	 */
	public void cacheResult(HealthSmeTemplate healthSmeTemplate);

	/**
	 * Caches the health sme templates in the entity cache if it is enabled.
	 *
	 * @param healthSmeTemplates the health sme templates
	 */
	public void cacheResult(
		java.util.List<HealthSmeTemplate> healthSmeTemplates);

	/**
	 * Creates a new health sme template with the primary key. Does not add the health sme template to the database.
	 *
	 * @param healthSmeTemplateId the primary key for the new health sme template
	 * @return the new health sme template
	 */
	public HealthSmeTemplate create(long healthSmeTemplateId);

	/**
	 * Removes the health sme template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param healthSmeTemplateId the primary key of the health sme template
	 * @return the health sme template that was removed
	 * @throws NoSuchHealthSmeTemplateException if a health sme template with the primary key could not be found
	 */
	public HealthSmeTemplate remove(long healthSmeTemplateId)
		throws NoSuchHealthSmeTemplateException;

	public HealthSmeTemplate updateImpl(HealthSmeTemplate healthSmeTemplate);

	/**
	 * Returns the health sme template with the primary key or throws a <code>NoSuchHealthSmeTemplateException</code> if it could not be found.
	 *
	 * @param healthSmeTemplateId the primary key of the health sme template
	 * @return the health sme template
	 * @throws NoSuchHealthSmeTemplateException if a health sme template with the primary key could not be found
	 */
	public HealthSmeTemplate findByPrimaryKey(long healthSmeTemplateId)
		throws NoSuchHealthSmeTemplateException;

	/**
	 * Returns the health sme template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param healthSmeTemplateId the primary key of the health sme template
	 * @return the health sme template, or <code>null</code> if a health sme template with the primary key could not be found
	 */
	public HealthSmeTemplate fetchByPrimaryKey(long healthSmeTemplateId);

	/**
	 * Returns all the health sme templates.
	 *
	 * @return the health sme templates
	 */
	public java.util.List<HealthSmeTemplate> findAll();

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
	public java.util.List<HealthSmeTemplate> findAll(int start, int end);

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
	public java.util.List<HealthSmeTemplate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HealthSmeTemplate>
			orderByComparator);

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
	public java.util.List<HealthSmeTemplate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HealthSmeTemplate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the health sme templates from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of health sme templates.
	 *
	 * @return the number of health sme templates
	 */
	public int countAll();

}