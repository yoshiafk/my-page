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

import com.mypage.admin.product.model.TravelDomesticPlan;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for TravelDomesticPlan. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Gositus Team
 * @see TravelDomesticPlanLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TravelDomesticPlanLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.TravelDomesticPlanLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the travel domestic plan local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link TravelDomesticPlanLocalServiceUtil} if injection and service tracking are not available.
	 */
	public TravelDomesticPlan addTravelDomesticPlan(
		String name, String code, int toproTsi, int toproAtsi, int sort,
		int active);

	/**
	 * Adds the travel domestic plan to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticPlan the travel domestic plan
	 * @return the travel domestic plan that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TravelDomesticPlan addTravelDomesticPlan(
		TravelDomesticPlan travelDomesticPlan);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new travel domestic plan with the primary key. Does not add the travel domestic plan to the database.
	 *
	 * @param travelDomesticPlanId the primary key for the new travel domestic plan
	 * @return the new travel domestic plan
	 */
	@Transactional(enabled = false)
	public TravelDomesticPlan createTravelDomesticPlan(
		long travelDomesticPlanId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the travel domestic plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticPlanId the primary key of the travel domestic plan
	 * @return the travel domestic plan that was removed
	 * @throws PortalException if a travel domestic plan with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public TravelDomesticPlan deleteTravelDomesticPlan(
			long travelDomesticPlanId)
		throws PortalException;

	/**
	 * Deletes the travel domestic plan from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticPlan the travel domestic plan
	 * @return the travel domestic plan that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public TravelDomesticPlan deleteTravelDomesticPlan(
		TravelDomesticPlan travelDomesticPlan);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticPlanModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticPlanModelImpl</code>.
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
	public TravelDomesticPlan fetchTravelDomesticPlan(
		long travelDomesticPlanId);

	public TravelDomesticPlan findByCode(String code);

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
	 * Returns the travel domestic plan with the primary key.
	 *
	 * @param travelDomesticPlanId the primary key of the travel domestic plan
	 * @return the travel domestic plan
	 * @throws PortalException if a travel domestic plan with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TravelDomesticPlan getTravelDomesticPlan(long travelDomesticPlanId)
		throws PortalException;

	/**
	 * Returns a range of all the travel domestic plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.TravelDomesticPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of travel domestic plans
	 * @param end the upper bound of the range of travel domestic plans (not inclusive)
	 * @return the range of travel domestic plans
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TravelDomesticPlan> getTravelDomesticPlans(int start, int end);

	/**
	 * Returns the number of travel domestic plans.
	 *
	 * @return the number of travel domestic plans
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTravelDomesticPlansCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TravelDomesticPlan> searchByCode(String code);

	public TravelDomesticPlan setActive(
		long travelDomesticPlanId, int active, ServiceContext serviceContext);

	public TravelDomesticPlan updateTravelDomesticPlan(
		long travelDomesticPlanId, String name, String code, int toproTsi,
		int toproAtsi, int sort, int active);

	/**
	 * Updates the travel domestic plan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TravelDomesticPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param travelDomesticPlan the travel domestic plan
	 * @return the travel domestic plan that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TravelDomesticPlan updateTravelDomesticPlan(
		TravelDomesticPlan travelDomesticPlan);

}