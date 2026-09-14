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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PetPlanLocalService}.
 *
 * @author Gositus Team
 * @see PetPlanLocalService
 * @generated
 */
public class PetPlanLocalServiceWrapper
	implements PetPlanLocalService, ServiceWrapper<PetPlanLocalService> {

	public PetPlanLocalServiceWrapper(PetPlanLocalService petPlanLocalService) {
		_petPlanLocalService = petPlanLocalService;
	}

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
	@Override
	public com.mypage.admin.product.model.PetPlan addPetPlan(
		com.mypage.admin.product.model.PetPlan petPlan) {

		return _petPlanLocalService.addPetPlan(petPlan);
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
	@Override
	public com.mypage.admin.product.model.PetPlan addPetPlan(
			String name, long limitDisability, long limitMedical,
			long limitThirdParty, long limitCustody, String benefit,
			long pimcorePlanId, int recommended, int customPlan, int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petPlanLocalService.addPetPlan(
			name, limitDisability, limitMedical, limitThirdParty, limitCustody,
			benefit, pimcorePlanId, recommended, customPlan, active);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petPlanLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new pet plan with the primary key. Does not add the pet plan to the database.
	 *
	 * @param petPlanId the primary key for the new pet plan
	 * @return the new pet plan
	 */
	@Override
	public com.mypage.admin.product.model.PetPlan createPetPlan(
		long petPlanId) {

		return _petPlanLocalService.createPetPlan(petPlanId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petPlanLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.mypage.admin.product.model.PetPlan deletePetPlan(long petPlanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petPlanLocalService.deletePetPlan(petPlanId);
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
	@Override
	public com.mypage.admin.product.model.PetPlan deletePetPlan(
		com.mypage.admin.product.model.PetPlan petPlan) {

		return _petPlanLocalService.deletePetPlan(petPlan);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _petPlanLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _petPlanLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _petPlanLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _petPlanLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _petPlanLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _petPlanLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.mypage.admin.product.model.PetPlan fetchPetPlan(long petPlanId) {
		return _petPlanLocalService.fetchPetPlan(petPlanId);
	}

	/**
	 * Returns the pet plan matching the UUID and group.
	 *
	 * @param uuid the pet plan's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pet plan, or <code>null</code> if a matching pet plan could not be found
	 */
	@Override
	public com.mypage.admin.product.model.PetPlan fetchPetPlanByUuidAndGroupId(
		String uuid, long groupId) {

		return _petPlanLocalService.fetchPetPlanByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _petPlanLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _petPlanLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _petPlanLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _petPlanLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petPlanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the pet plan with the primary key.
	 *
	 * @param petPlanId the primary key of the pet plan
	 * @return the pet plan
	 * @throws PortalException if a pet plan with the primary key could not be found
	 */
	@Override
	public com.mypage.admin.product.model.PetPlan getPetPlan(long petPlanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petPlanLocalService.getPetPlan(petPlanId);
	}

	/**
	 * Returns the pet plan matching the UUID and group.
	 *
	 * @param uuid the pet plan's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pet plan
	 * @throws PortalException if a matching pet plan could not be found
	 */
	@Override
	public com.mypage.admin.product.model.PetPlan getPetPlanByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petPlanLocalService.getPetPlanByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.PetPlan>
		getPetPlans() {

		return _petPlanLocalService.getPetPlans();
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
	@Override
	public java.util.List<com.mypage.admin.product.model.PetPlan> getPetPlans(
		int start, int end) {

		return _petPlanLocalService.getPetPlans(start, end);
	}

	/**
	 * Returns all the pet plans matching the UUID and company.
	 *
	 * @param uuid the UUID of the pet plans
	 * @param companyId the primary key of the company
	 * @return the matching pet plans, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.mypage.admin.product.model.PetPlan>
		getPetPlansByUuidAndCompanyId(String uuid, long companyId) {

		return _petPlanLocalService.getPetPlansByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.mypage.admin.product.model.PetPlan>
		getPetPlansByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.mypage.admin.product.model.PetPlan> orderByComparator) {

		return _petPlanLocalService.getPetPlansByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of pet plans.
	 *
	 * @return the number of pet plans
	 */
	@Override
	public int getPetPlansCount() {
		return _petPlanLocalService.getPetPlansCount();
	}

	@Override
	public java.util.List<com.mypage.admin.product.model.PetPlan>
		getRecommendedPlans() {

		return _petPlanLocalService.getRecommendedPlans();
	}

	@Override
	public com.mypage.admin.product.model.PetPlan searchPetPlanId(
		long petPlanId) {

		return _petPlanLocalService.searchPetPlanId(petPlanId);
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
	@Override
	public com.mypage.admin.product.model.PetPlan setActive(
			long userId, long petPlanId, int active,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petPlanLocalService.setActive(
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
	@Override
	public com.mypage.admin.product.model.PetPlan updatePetPlan(
			long petPlanId, String name, long limitDisability,
			long limitMedical, long limitThirdParty, long limitCustody,
			String benefit, long pimcorePlanId, int recommended, int customPlan,
			int active)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petPlanLocalService.updatePetPlan(
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
	@Override
	public com.mypage.admin.product.model.PetPlan updatePetPlan(
		com.mypage.admin.product.model.PetPlan petPlan) {

		return _petPlanLocalService.updatePetPlan(petPlan);
	}

	@Override
	public PetPlanLocalService getWrappedService() {
		return _petPlanLocalService;
	}

	@Override
	public void setWrappedService(PetPlanLocalService petPlanLocalService) {
		_petPlanLocalService = petPlanLocalService;
	}

	private PetPlanLocalService _petPlanLocalService;

}