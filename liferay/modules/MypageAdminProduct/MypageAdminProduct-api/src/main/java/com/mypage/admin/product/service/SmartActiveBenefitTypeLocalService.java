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

import com.mypage.admin.product.model.SmartActiveBenefitType;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SmartActiveBenefitType. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Gositus Team
 * @see SmartActiveBenefitTypeLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SmartActiveBenefitTypeLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.SmartActiveBenefitTypeLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the smart active benefit type local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SmartActiveBenefitTypeLocalServiceUtil} if injection and service tracking are not available.
	 */
	public SmartActiveBenefitType addBenefitType(
			String nameId, String nameEn, int sort, int active)
		throws PortalException;

	/**
	 * Adds the smart active benefit type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitType the smart active benefit type
	 * @return the smart active benefit type that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SmartActiveBenefitType addSmartActiveBenefitType(
		SmartActiveBenefitType smartActiveBenefitType);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new smart active benefit type with the primary key. Does not add the smart active benefit type to the database.
	 *
	 * @param smartActiveBenefitTypeId the primary key for the new smart active benefit type
	 * @return the new smart active benefit type
	 */
	@Transactional(enabled = false)
	public SmartActiveBenefitType createSmartActiveBenefitType(
		long smartActiveBenefitTypeId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the smart active benefit type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitTypeId the primary key of the smart active benefit type
	 * @return the smart active benefit type that was removed
	 * @throws PortalException if a smart active benefit type with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public SmartActiveBenefitType deleteSmartActiveBenefitType(
			long smartActiveBenefitTypeId)
		throws PortalException;

	/**
	 * Deletes the smart active benefit type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitType the smart active benefit type
	 * @return the smart active benefit type that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public SmartActiveBenefitType deleteSmartActiveBenefitType(
		SmartActiveBenefitType smartActiveBenefitType);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitTypeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitTypeModelImpl</code>.
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
	public SmartActiveBenefitType fetchSmartActiveBenefitType(
		long smartActiveBenefitTypeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartActiveBenefitType> getActiveBenefitType();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartActiveBenefitType> getAllBenefitTypes();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartActiveBenefitType> getBenefitTypeAdditional();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartActiveBenefitType> getBenefitTypeByName(
		String nameId, String nameEn);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartActiveBenefitType> getBenefitTypeBySort(int sort);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartActiveBenefitType> getBenefitTypeMain();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartActiveBenefitType> getBenefitTypes();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartActiveBenefitType> getBenefitTypes(int start, int end);

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
	 * Returns the smart active benefit type with the primary key.
	 *
	 * @param smartActiveBenefitTypeId the primary key of the smart active benefit type
	 * @return the smart active benefit type
	 * @throws PortalException if a smart active benefit type with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SmartActiveBenefitType getSmartActiveBenefitType(
			long smartActiveBenefitTypeId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSmartActiveBenefitTypeCount();

	/**
	 * Returns a range of all the smart active benefit types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.SmartActiveBenefitTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of smart active benefit types
	 * @param end the upper bound of the range of smart active benefit types (not inclusive)
	 * @return the range of smart active benefit types
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SmartActiveBenefitType> getSmartActiveBenefitTypes(
		int start, int end);

	/**
	 * Returns the number of smart active benefit types.
	 *
	 * @return the number of smart active benefit types
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSmartActiveBenefitTypesCount();

	public SmartActiveBenefitType setActive(
		long benefitTypeId, int active, ServiceContext serviceContext);

	public SmartActiveBenefitType updateBenefitType(
			long benefitTypeId, String nameId, String nameEn, int sort,
			int active)
		throws PortalException;

	/**
	 * Updates the smart active benefit type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SmartActiveBenefitTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param smartActiveBenefitType the smart active benefit type
	 * @return the smart active benefit type that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SmartActiveBenefitType updateSmartActiveBenefitType(
		SmartActiveBenefitType smartActiveBenefitType);

}