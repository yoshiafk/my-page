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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mypage.admin.product.model.PetPlan;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PetPlan. This utility wraps
 * <code>com.mypage.admin.product.service.impl.PetPlanLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Gositus Team
 * @see PetPlanLocalService
 * @generated
 */
public class PetPlanLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mypage.admin.product.service.impl.PetPlanLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the pet plan to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petPlan the pet plan
	 * @return the pet plan that was added
	 */
	public static PetPlan addPetPlan(PetPlan petPlan) {
		return getService().addPetPlan(petPlan);
	}

	/**
	 * Add new pet plan
	 *
	 * @param name
	 * @param limitDisability
	 * @param limitMedical
	 * @param limitThirdParty
	 * @param limitCustody
	 * @param benefit
	 * @param recommended
	 * @param customPlan
	 * @return
	 * @throws PortalException
	 */
	public static PetPlan addPetPlan(
			String name, long limitDisability, long limitMedical,
			long limitThirdParty, long limitCustody, String benefit,
			long pimcorePlanId, int recommended, int customPlan, int active)
		throws PortalException {

		return getService().addPetPlan(
			name, limitDisability, limitMedical, limitThirdParty, limitCustody,
			benefit, pimcorePlanId, recommended, customPlan, active);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new pet plan with the primary key. Does not add the pet plan to the database.
	 *
	 * @param petPlanId the primary key for the new pet plan
	 * @return the new pet plan
	 */
	public static PetPlan createPetPlan(long petPlanId) {
		return getService().createPetPlan(petPlanId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the pet plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petPlanId the primary key of the pet plan
	 * @return the pet plan that was removed
	 * @throws PortalException if a pet plan with the primary key could not be found
	 */
	public static PetPlan deletePetPlan(long petPlanId) throws PortalException {
		return getService().deletePetPlan(petPlanId);
	}

	/**
	 * Deletes the pet plan from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petPlan the pet plan
	 * @return the pet plan that was removed
	 */
	public static PetPlan deletePetPlan(PetPlan petPlan) {
		return getService().deletePetPlan(petPlan);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static PetPlan fetchPetPlan(long petPlanId) {
		return getService().fetchPetPlan(petPlanId);
	}

	/**
	 * Returns the pet plan matching the UUID and group.
	 *
	 * @param uuid the pet plan's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	public static PetPlan fetchPetPlanByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPetPlanByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the pet plan with the primary key.
	 *
	 * @param petPlanId the primary key of the pet plan
	 * @return the pet plan
	 * @throws PortalException if a pet plan with the primary key could not be found
	 */
	public static PetPlan getPetPlan(long petPlanId) throws PortalException {
		return getService().getPetPlan(petPlanId);
	}

	/**
	 * Returns the pet plan matching the UUID and group.
	 *
	 * @param uuid the pet plan's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pet plan
	 * @throws PortalException if a matching pet plan could not be found
	 */
	public static PetPlan getPetPlanByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getPetPlanByUuidAndGroupId(uuid, groupId);
	}

	public static List<PetPlan> getPetPlans() {
		return getService().getPetPlans();
	}

	/**
	 * Returns a range of all the pet plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.mypage.admin.product.model.impl.PetPlanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet plans
	 * @param end the upper bound of the range of pet plans (not inclusive)
	 * @return the range of pet plans
	 */
	public static List<PetPlan> getPetPlans(int start, int end) {
		return getService().getPetPlans(start, end);
	}

	/**
	 * Returns all the pet plans matching the UUID and company.
	 *
	 * @param uuid the UUID of the pet plans
	 * @param companyId the primary key of the company
	 * @return the matching pet plans, or an empty list if no matches were found
	 */
	public static List<PetPlan> getPetPlansByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getPetPlansByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of pet plans matching the UUID and company.
	 *
	 * @param uuid the UUID of the pet plans
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of pet plans
	 * @param end the upper bound of the range of pet plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching pet plans, or an empty list if no matches were found
	 */
	public static List<PetPlan> getPetPlansByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PetPlan> orderByComparator) {

		return getService().getPetPlansByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of pet plans.
	 *
	 * @return the number of pet plans
	 */
	public static int getPetPlansCount() {
		return getService().getPetPlansCount();
	}

	public static List<PetPlan> getRecommendedPlans() {
		return getService().getRecommendedPlans();
	}

	public static PetPlan searchPetPlanId(long petPlanId) {
		return getService().searchPetPlanId(petPlanId);
	}

	/**
	 * Set status for pet plan
	 *
	 * @param userId
	 * @param petPlanId
	 * @param active
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	public static PetPlan setActive(
			long userId, long petPlanId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().setActive(
			userId, petPlanId, active, serviceContext);
	}

	/**
	 * Edit existing pet plan
	 *
	 * @param petPlanId
	 * @param name
	 * @param limitDisability
	 * @param limitMedical
	 * @param limitThirdParty
	 * @param limitCustody
	 * @param benefit
	 * @param recommended
	 * @param customPlan
	 * @return
	 * @throws PortalException
	 */
	public static PetPlan updatePetPlan(
			long petPlanId, String name, long limitDisability,
			long limitMedical, long limitThirdParty, long limitCustody,
			String benefit, long pimcorePlanId, int recommended, int customPlan,
			int active)
		throws PortalException {

		return getService().updatePetPlan(
			petPlanId, name, limitDisability, limitMedical, limitThirdParty,
			limitCustody, benefit, pimcorePlanId, recommended, customPlan,
			active);
	}

	/**
	 * Updates the pet plan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetPlanLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petPlan the pet plan
	 * @return the pet plan that was updated
	 */
	public static PetPlan updatePetPlan(PetPlan petPlan) {
		return getService().updatePetPlan(petPlan);
	}

	public static PetPlanLocalService getService() {
		return _service;
	}

	private static volatile PetPlanLocalService _service;

}