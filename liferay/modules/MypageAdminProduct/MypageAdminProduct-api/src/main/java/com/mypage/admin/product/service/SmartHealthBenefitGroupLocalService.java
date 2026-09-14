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

package com.mypage.admin.product.service;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.SmartHealthBenefitGroup;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SmartHealthBenefitGroup. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Gositus Team
 * @see SmartHealthBenefitGroupLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SmartHealthBenefitGroupLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.SmartHealthBenefitGroupLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the smart health benefit group local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SmartHealthBenefitGroupLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the smart health benefit group to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefitGroup the smart health benefit group
	 * @return the smart health benefit group that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SmartHealthBenefitGroup addSmartHealthBenefitGroup(
		SmartHealthBenefitGroup smartHealthBenefitGroup);

	/**
	 * Add Benefit Group
	 */
	public SmartHealthBenefitGroup addSmartHealthBenefitGroup(
			String groupName, String groupDescription, String groupCode,
			int active)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new smart health benefit group with the primary key. Does not add the smart health benefit group to the database.
	 *
	 * @param smartHealthBenefitGroupId the primary key for the new smart health benefit group
	 * @return the new smart health benefit group
	 */
	@Transactional(enabled = false)
	public SmartHealthBenefitGroup createSmartHealthBenefitGroup(
		long smartHealthBenefitGroupId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the smart health benefit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefitGroupId the primary key of the smart health benefit group
	 * @return the smart health benefit group that was removed
	 * @throws PortalException if a smart health benefit group with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public SmartHealthBenefitGroup deleteSmartHealthBenefitGroup(
			long smartHealthBenefitGroupId)
		throws PortalException;

	/**
	 * Deletes the smart health benefit group from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefitGroup the smart health benefit group
	 * @return the smart health benefit group that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public SmartHealthBenefitGroup deleteSmartHealthBenefitGroup(
		SmartHealthBenefitGroup smartHealthBenefitGroup);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SmartHealthBenefitGroup fetchSmartHealthBenefitGroup(
		long smartHealthBenefitGroupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the smart health benefit group with the primary key.
	 *
	 * @param smartHealthBenefitGroupId the primary key of the smart health benefit group
	 * @return the smart health benefit group
	 * @throws PortalException if a smart health benefit group with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SmartHealthBenefitGroup getSmartHealthBenefitGroup(
			long smartHealthBenefitGroupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSmartHealthBenefitGroupCounts();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartHealthBenefitGroup> getSmartHealthBenefitGroups();

	/**
	 * Returns a range of all the smart health benefit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartHealthBenefitGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart health benefit groups
	 * @param end the upper bound of the range of smart health benefit groups (not inclusive)
	 * @return the range of smart health benefit groups
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartHealthBenefitGroup> getSmartHealthBenefitGroups(
		int start, int end);

	/**
	 * Returns the number of smart health benefit groups.
	 *
	 * @return the number of smart health benefit groups
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSmartHealthBenefitGroupsCount();

	public SmartHealthBenefitGroup setActive(
			long smartHealthBenefitGroupId, int active,
			ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Update Benefit Group
	 */
	public SmartHealthBenefitGroup updateSmartHealthBenefitGroup(
			long smartHealthBenefitGroupId, String groupName,
			String groupDescription, String groupCode, int active)
		throws PortalException;

	/**
	 * Updates the smart health benefit group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartHealthBenefitGroupLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartHealthBenefitGroup the smart health benefit group
	 * @return the smart health benefit group that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SmartHealthBenefitGroup updateSmartHealthBenefitGroup(
		SmartHealthBenefitGroup smartHealthBenefitGroup);

}