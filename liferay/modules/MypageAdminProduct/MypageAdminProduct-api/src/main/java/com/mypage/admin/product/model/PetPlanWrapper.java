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

package com.mypage.admin.product.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PetPlan}.
 * </p>
 *
 * @author Gositus Team
 * @see PetPlan
 * @generated
 */
public class PetPlanWrapper
	extends BaseModelWrapper<PetPlan>
	implements ModelWrapper<PetPlan>, PetPlan {

	public PetPlanWrapper(PetPlan petPlan) {
		super(petPlan);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("petPlanId", getPetPlanId());
		attributes.put("name", getName());
		attributes.put("limitDisability", getLimitDisability());
		attributes.put("limitMedical", getLimitMedical());
		attributes.put("limitThirdParty", getLimitThirdParty());
		attributes.put("limitCustody", getLimitCustody());
		attributes.put("recommended", getRecommended());
		attributes.put("customPlan", getCustomPlan());
		attributes.put("benefit", getBenefit());
		attributes.put("pimcorePlanId", getPimcorePlanId());
		attributes.put("active", getActive());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long petPlanId = (Long)attributes.get("petPlanId");

		if (petPlanId != null) {
			setPetPlanId(petPlanId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long limitDisability = (Long)attributes.get("limitDisability");

		if (limitDisability != null) {
			setLimitDisability(limitDisability);
		}

		Long limitMedical = (Long)attributes.get("limitMedical");

		if (limitMedical != null) {
			setLimitMedical(limitMedical);
		}

		Long limitThirdParty = (Long)attributes.get("limitThirdParty");

		if (limitThirdParty != null) {
			setLimitThirdParty(limitThirdParty);
		}

		Long limitCustody = (Long)attributes.get("limitCustody");

		if (limitCustody != null) {
			setLimitCustody(limitCustody);
		}

		Integer recommended = (Integer)attributes.get("recommended");

		if (recommended != null) {
			setRecommended(recommended);
		}

		Integer customPlan = (Integer)attributes.get("customPlan");

		if (customPlan != null) {
			setCustomPlan(customPlan);
		}

		String benefit = (String)attributes.get("benefit");

		if (benefit != null) {
			setBenefit(benefit);
		}

		Long pimcorePlanId = (Long)attributes.get("pimcorePlanId");

		if (pimcorePlanId != null) {
			setPimcorePlanId(pimcorePlanId);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the active of this pet plan.
	 *
	 * @return the active of this pet plan
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the benefit of this pet plan.
	 *
	 * @return the benefit of this pet plan
	 */
	@Override
	public String getBenefit() {
		return model.getBenefit();
	}

	/**
	 * Returns the company ID of this pet plan.
	 *
	 * @return the company ID of this pet plan
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this pet plan.
	 *
	 * @return the create date of this pet plan
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the custom plan of this pet plan.
	 *
	 * @return the custom plan of this pet plan
	 */
	@Override
	public int getCustomPlan() {
		return model.getCustomPlan();
	}

	/**
	 * Returns the group ID of this pet plan.
	 *
	 * @return the group ID of this pet plan
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the limit custody of this pet plan.
	 *
	 * @return the limit custody of this pet plan
	 */
	@Override
	public long getLimitCustody() {
		return model.getLimitCustody();
	}

	/**
	 * Returns the limit disability of this pet plan.
	 *
	 * @return the limit disability of this pet plan
	 */
	@Override
	public long getLimitDisability() {
		return model.getLimitDisability();
	}

	/**
	 * Returns the limit medical of this pet plan.
	 *
	 * @return the limit medical of this pet plan
	 */
	@Override
	public long getLimitMedical() {
		return model.getLimitMedical();
	}

	/**
	 * Returns the limit third party of this pet plan.
	 *
	 * @return the limit third party of this pet plan
	 */
	@Override
	public long getLimitThirdParty() {
		return model.getLimitThirdParty();
	}

	/**
	 * Returns the modified date of this pet plan.
	 *
	 * @return the modified date of this pet plan
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this pet plan.
	 *
	 * @return the name of this pet plan
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the pet plan ID of this pet plan.
	 *
	 * @return the pet plan ID of this pet plan
	 */
	@Override
	public long getPetPlanId() {
		return model.getPetPlanId();
	}

	/**
	 * Returns the pimcore plan ID of this pet plan.
	 *
	 * @return the pimcore plan ID of this pet plan
	 */
	@Override
	public long getPimcorePlanId() {
		return model.getPimcorePlanId();
	}

	/**
	 * Returns the primary key of this pet plan.
	 *
	 * @return the primary key of this pet plan
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the recommended of this pet plan.
	 *
	 * @return the recommended of this pet plan
	 */
	@Override
	public int getRecommended() {
		return model.getRecommended();
	}

	/**
	 * Returns the status of this pet plan.
	 *
	 * @return the status of this pet plan
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the trash entry created when this pet plan was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this pet plan.
	 *
	 * @return the trash entry created when this pet plan was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this pet plan.
	 *
	 * @return the class primary key of the trash entry for this pet plan
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this pet plan.
	 *
	 * @return the trash handler for this pet plan
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this pet plan.
	 *
	 * @return the user ID of this pet plan
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this pet plan.
	 *
	 * @return the user name of this pet plan
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this pet plan.
	 *
	 * @return the user uuid of this pet plan
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this pet plan.
	 *
	 * @return the uuid of this pet plan
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this pet plan is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this pet plan is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this pet plan is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this pet plan is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer() {
		return model.isInTrashContainer();
	}

	@Override
	public boolean isInTrashExplicitly() {
		return model.isInTrashExplicitly();
	}

	@Override
	public boolean isInTrashImplicitly() {
		return model.isInTrashImplicitly();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this pet plan.
	 *
	 * @param active the active of this pet plan
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the benefit of this pet plan.
	 *
	 * @param benefit the benefit of this pet plan
	 */
	@Override
	public void setBenefit(String benefit) {
		model.setBenefit(benefit);
	}

	/**
	 * Sets the company ID of this pet plan.
	 *
	 * @param companyId the company ID of this pet plan
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this pet plan.
	 *
	 * @param createDate the create date of this pet plan
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the custom plan of this pet plan.
	 *
	 * @param customPlan the custom plan of this pet plan
	 */
	@Override
	public void setCustomPlan(int customPlan) {
		model.setCustomPlan(customPlan);
	}

	/**
	 * Sets the group ID of this pet plan.
	 *
	 * @param groupId the group ID of this pet plan
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the limit custody of this pet plan.
	 *
	 * @param limitCustody the limit custody of this pet plan
	 */
	@Override
	public void setLimitCustody(long limitCustody) {
		model.setLimitCustody(limitCustody);
	}

	/**
	 * Sets the limit disability of this pet plan.
	 *
	 * @param limitDisability the limit disability of this pet plan
	 */
	@Override
	public void setLimitDisability(long limitDisability) {
		model.setLimitDisability(limitDisability);
	}

	/**
	 * Sets the limit medical of this pet plan.
	 *
	 * @param limitMedical the limit medical of this pet plan
	 */
	@Override
	public void setLimitMedical(long limitMedical) {
		model.setLimitMedical(limitMedical);
	}

	/**
	 * Sets the limit third party of this pet plan.
	 *
	 * @param limitThirdParty the limit third party of this pet plan
	 */
	@Override
	public void setLimitThirdParty(long limitThirdParty) {
		model.setLimitThirdParty(limitThirdParty);
	}

	/**
	 * Sets the modified date of this pet plan.
	 *
	 * @param modifiedDate the modified date of this pet plan
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this pet plan.
	 *
	 * @param name the name of this pet plan
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the pet plan ID of this pet plan.
	 *
	 * @param petPlanId the pet plan ID of this pet plan
	 */
	@Override
	public void setPetPlanId(long petPlanId) {
		model.setPetPlanId(petPlanId);
	}

	/**
	 * Sets the pimcore plan ID of this pet plan.
	 *
	 * @param pimcorePlanId the pimcore plan ID of this pet plan
	 */
	@Override
	public void setPimcorePlanId(long pimcorePlanId) {
		model.setPimcorePlanId(pimcorePlanId);
	}

	/**
	 * Sets the primary key of this pet plan.
	 *
	 * @param primaryKey the primary key of this pet plan
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the recommended of this pet plan.
	 *
	 * @param recommended the recommended of this pet plan
	 */
	@Override
	public void setRecommended(int recommended) {
		model.setRecommended(recommended);
	}

	/**
	 * Sets the user ID of this pet plan.
	 *
	 * @param userId the user ID of this pet plan
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this pet plan.
	 *
	 * @param userName the user name of this pet plan
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this pet plan.
	 *
	 * @param userUuid the user uuid of this pet plan
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this pet plan.
	 *
	 * @param uuid the uuid of this pet plan
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected PetPlanWrapper wrap(PetPlan petPlan) {
		return new PetPlanWrapper(petPlan);
	}

}