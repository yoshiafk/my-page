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

package com.mypage.leads.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DetailPet}.
 * </p>
 *
 * @author Gositus
 * @see DetailPet
 * @generated
 */
public class DetailPetWrapper
	extends BaseModelWrapper<DetailPet>
	implements DetailPet, ModelWrapper<DetailPet> {

	public DetailPetWrapper(DetailPet detailPet) {
		super(detailPet);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("detailPetId", getDetailPetId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("LeadsId", getLeadsId());
		attributes.put("PlanId", getPlanId());
		attributes.put("LimitDisability", getLimitDisability());
		attributes.put("LimitMedical", getLimitMedical());
		attributes.put("LimitThirdParty", getLimitThirdParty());
		attributes.put("LimitCustody", getLimitCustody());
		attributes.put("PetName", getPetName());
		attributes.put("PetType", getPetType());
		attributes.put("PetGender", getPetGender());
		attributes.put("PetDob", getPetDob());
		attributes.put("PetIdNumber", getPetIdNumber());
		attributes.put("PetIdNumberIssuing", getPetIdNumberIssuing());
		attributes.put("PetIdNumberFileEntryId", getPetIdNumberFileEntryId());
		attributes.put("PetIdNumberURL", getPetIdNumberURL());
		attributes.put("PetPhotoFileEntryId", getPetPhotoFileEntryId());
		attributes.put("PetPhotoURL", getPetPhotoURL());
		attributes.put("PetLocation", getPetLocation());
		attributes.put("PetVaccine", getPetVaccine());
		attributes.put(
			"PetAuthorizedCertificate", getPetAuthorizedCertificate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long detailPetId = (Long)attributes.get("detailPetId");

		if (detailPetId != null) {
			setDetailPetId(detailPetId);
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

		Long LeadsId = (Long)attributes.get("LeadsId");

		if (LeadsId != null) {
			setLeadsId(LeadsId);
		}

		Long PlanId = (Long)attributes.get("PlanId");

		if (PlanId != null) {
			setPlanId(PlanId);
		}

		Double LimitDisability = (Double)attributes.get("LimitDisability");

		if (LimitDisability != null) {
			setLimitDisability(LimitDisability);
		}

		Double LimitMedical = (Double)attributes.get("LimitMedical");

		if (LimitMedical != null) {
			setLimitMedical(LimitMedical);
		}

		Double LimitThirdParty = (Double)attributes.get("LimitThirdParty");

		if (LimitThirdParty != null) {
			setLimitThirdParty(LimitThirdParty);
		}

		Double LimitCustody = (Double)attributes.get("LimitCustody");

		if (LimitCustody != null) {
			setLimitCustody(LimitCustody);
		}

		String PetName = (String)attributes.get("PetName");

		if (PetName != null) {
			setPetName(PetName);
		}

		String PetType = (String)attributes.get("PetType");

		if (PetType != null) {
			setPetType(PetType);
		}

		String PetGender = (String)attributes.get("PetGender");

		if (PetGender != null) {
			setPetGender(PetGender);
		}

		Date PetDob = (Date)attributes.get("PetDob");

		if (PetDob != null) {
			setPetDob(PetDob);
		}

		String PetIdNumber = (String)attributes.get("PetIdNumber");

		if (PetIdNumber != null) {
			setPetIdNumber(PetIdNumber);
		}

		String PetIdNumberIssuing = (String)attributes.get(
			"PetIdNumberIssuing");

		if (PetIdNumberIssuing != null) {
			setPetIdNumberIssuing(PetIdNumberIssuing);
		}

		Long PetIdNumberFileEntryId = (Long)attributes.get(
			"PetIdNumberFileEntryId");

		if (PetIdNumberFileEntryId != null) {
			setPetIdNumberFileEntryId(PetIdNumberFileEntryId);
		}

		String PetIdNumberURL = (String)attributes.get("PetIdNumberURL");

		if (PetIdNumberURL != null) {
			setPetIdNumberURL(PetIdNumberURL);
		}

		Long PetPhotoFileEntryId = (Long)attributes.get("PetPhotoFileEntryId");

		if (PetPhotoFileEntryId != null) {
			setPetPhotoFileEntryId(PetPhotoFileEntryId);
		}

		String PetPhotoURL = (String)attributes.get("PetPhotoURL");

		if (PetPhotoURL != null) {
			setPetPhotoURL(PetPhotoURL);
		}

		String PetLocation = (String)attributes.get("PetLocation");

		if (PetLocation != null) {
			setPetLocation(PetLocation);
		}

		Integer PetVaccine = (Integer)attributes.get("PetVaccine");

		if (PetVaccine != null) {
			setPetVaccine(PetVaccine);
		}

		Integer PetAuthorizedCertificate = (Integer)attributes.get(
			"PetAuthorizedCertificate");

		if (PetAuthorizedCertificate != null) {
			setPetAuthorizedCertificate(PetAuthorizedCertificate);
		}
	}

	/**
	 * Returns the company ID of this detail pet.
	 *
	 * @return the company ID of this detail pet
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this detail pet.
	 *
	 * @return the create date of this detail pet
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the detail pet ID of this detail pet.
	 *
	 * @return the detail pet ID of this detail pet
	 */
	@Override
	public long getDetailPetId() {
		return model.getDetailPetId();
	}

	/**
	 * Returns the group ID of this detail pet.
	 *
	 * @return the group ID of this detail pet
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the leads ID of this detail pet.
	 *
	 * @return the leads ID of this detail pet
	 */
	@Override
	public long getLeadsId() {
		return model.getLeadsId();
	}

	/**
	 * Returns the limit custody of this detail pet.
	 *
	 * @return the limit custody of this detail pet
	 */
	@Override
	public double getLimitCustody() {
		return model.getLimitCustody();
	}

	/**
	 * Returns the limit disability of this detail pet.
	 *
	 * @return the limit disability of this detail pet
	 */
	@Override
	public double getLimitDisability() {
		return model.getLimitDisability();
	}

	/**
	 * Returns the limit medical of this detail pet.
	 *
	 * @return the limit medical of this detail pet
	 */
	@Override
	public double getLimitMedical() {
		return model.getLimitMedical();
	}

	/**
	 * Returns the limit third party of this detail pet.
	 *
	 * @return the limit third party of this detail pet
	 */
	@Override
	public double getLimitThirdParty() {
		return model.getLimitThirdParty();
	}

	/**
	 * Returns the modified date of this detail pet.
	 *
	 * @return the modified date of this detail pet
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the pet authorized certificate of this detail pet.
	 *
	 * @return the pet authorized certificate of this detail pet
	 */
	@Override
	public Integer getPetAuthorizedCertificate() {
		return model.getPetAuthorizedCertificate();
	}

	/**
	 * Returns the pet dob of this detail pet.
	 *
	 * @return the pet dob of this detail pet
	 */
	@Override
	public Date getPetDob() {
		return model.getPetDob();
	}

	/**
	 * Returns the pet gender of this detail pet.
	 *
	 * @return the pet gender of this detail pet
	 */
	@Override
	public String getPetGender() {
		return model.getPetGender();
	}

	/**
	 * Returns the pet ID number of this detail pet.
	 *
	 * @return the pet ID number of this detail pet
	 */
	@Override
	public String getPetIdNumber() {
		return model.getPetIdNumber();
	}

	/**
	 * Returns the pet ID number file entry ID of this detail pet.
	 *
	 * @return the pet ID number file entry ID of this detail pet
	 */
	@Override
	public long getPetIdNumberFileEntryId() {
		return model.getPetIdNumberFileEntryId();
	}

	/**
	 * Returns the pet ID number issuing of this detail pet.
	 *
	 * @return the pet ID number issuing of this detail pet
	 */
	@Override
	public String getPetIdNumberIssuing() {
		return model.getPetIdNumberIssuing();
	}

	/**
	 * Returns the pet ID number url of this detail pet.
	 *
	 * @return the pet ID number url of this detail pet
	 */
	@Override
	public String getPetIdNumberURL() {
		return model.getPetIdNumberURL();
	}

	/**
	 * Returns the pet location of this detail pet.
	 *
	 * @return the pet location of this detail pet
	 */
	@Override
	public String getPetLocation() {
		return model.getPetLocation();
	}

	/**
	 * Returns the pet name of this detail pet.
	 *
	 * @return the pet name of this detail pet
	 */
	@Override
	public String getPetName() {
		return model.getPetName();
	}

	/**
	 * Returns the pet photo file entry ID of this detail pet.
	 *
	 * @return the pet photo file entry ID of this detail pet
	 */
	@Override
	public long getPetPhotoFileEntryId() {
		return model.getPetPhotoFileEntryId();
	}

	/**
	 * Returns the pet photo url of this detail pet.
	 *
	 * @return the pet photo url of this detail pet
	 */
	@Override
	public String getPetPhotoURL() {
		return model.getPetPhotoURL();
	}

	/**
	 * Returns the pet type of this detail pet.
	 *
	 * @return the pet type of this detail pet
	 */
	@Override
	public String getPetType() {
		return model.getPetType();
	}

	/**
	 * Returns the pet vaccine of this detail pet.
	 *
	 * @return the pet vaccine of this detail pet
	 */
	@Override
	public Integer getPetVaccine() {
		return model.getPetVaccine();
	}

	/**
	 * Returns the plan ID of this detail pet.
	 *
	 * @return the plan ID of this detail pet
	 */
	@Override
	public long getPlanId() {
		return model.getPlanId();
	}

	/**
	 * Returns the primary key of this detail pet.
	 *
	 * @return the primary key of this detail pet
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this detail pet.
	 *
	 * @return the user ID of this detail pet
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this detail pet.
	 *
	 * @return the user name of this detail pet
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this detail pet.
	 *
	 * @return the user uuid of this detail pet
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this detail pet.
	 *
	 * @param companyId the company ID of this detail pet
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this detail pet.
	 *
	 * @param createDate the create date of this detail pet
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the detail pet ID of this detail pet.
	 *
	 * @param detailPetId the detail pet ID of this detail pet
	 */
	@Override
	public void setDetailPetId(long detailPetId) {
		model.setDetailPetId(detailPetId);
	}

	/**
	 * Sets the group ID of this detail pet.
	 *
	 * @param groupId the group ID of this detail pet
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the leads ID of this detail pet.
	 *
	 * @param LeadsId the leads ID of this detail pet
	 */
	@Override
	public void setLeadsId(long LeadsId) {
		model.setLeadsId(LeadsId);
	}

	/**
	 * Sets the limit custody of this detail pet.
	 *
	 * @param LimitCustody the limit custody of this detail pet
	 */
	@Override
	public void setLimitCustody(double LimitCustody) {
		model.setLimitCustody(LimitCustody);
	}

	/**
	 * Sets the limit disability of this detail pet.
	 *
	 * @param LimitDisability the limit disability of this detail pet
	 */
	@Override
	public void setLimitDisability(double LimitDisability) {
		model.setLimitDisability(LimitDisability);
	}

	/**
	 * Sets the limit medical of this detail pet.
	 *
	 * @param LimitMedical the limit medical of this detail pet
	 */
	@Override
	public void setLimitMedical(double LimitMedical) {
		model.setLimitMedical(LimitMedical);
	}

	/**
	 * Sets the limit third party of this detail pet.
	 *
	 * @param LimitThirdParty the limit third party of this detail pet
	 */
	@Override
	public void setLimitThirdParty(double LimitThirdParty) {
		model.setLimitThirdParty(LimitThirdParty);
	}

	/**
	 * Sets the modified date of this detail pet.
	 *
	 * @param modifiedDate the modified date of this detail pet
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the pet authorized certificate of this detail pet.
	 *
	 * @param PetAuthorizedCertificate the pet authorized certificate of this detail pet
	 */
	@Override
	public void setPetAuthorizedCertificate(Integer PetAuthorizedCertificate) {
		model.setPetAuthorizedCertificate(PetAuthorizedCertificate);
	}

	/**
	 * Sets the pet dob of this detail pet.
	 *
	 * @param PetDob the pet dob of this detail pet
	 */
	@Override
	public void setPetDob(Date PetDob) {
		model.setPetDob(PetDob);
	}

	/**
	 * Sets the pet gender of this detail pet.
	 *
	 * @param PetGender the pet gender of this detail pet
	 */
	@Override
	public void setPetGender(String PetGender) {
		model.setPetGender(PetGender);
	}

	/**
	 * Sets the pet ID number of this detail pet.
	 *
	 * @param PetIdNumber the pet ID number of this detail pet
	 */
	@Override
	public void setPetIdNumber(String PetIdNumber) {
		model.setPetIdNumber(PetIdNumber);
	}

	/**
	 * Sets the pet ID number file entry ID of this detail pet.
	 *
	 * @param PetIdNumberFileEntryId the pet ID number file entry ID of this detail pet
	 */
	@Override
	public void setPetIdNumberFileEntryId(long PetIdNumberFileEntryId) {
		model.setPetIdNumberFileEntryId(PetIdNumberFileEntryId);
	}

	/**
	 * Sets the pet ID number issuing of this detail pet.
	 *
	 * @param PetIdNumberIssuing the pet ID number issuing of this detail pet
	 */
	@Override
	public void setPetIdNumberIssuing(String PetIdNumberIssuing) {
		model.setPetIdNumberIssuing(PetIdNumberIssuing);
	}

	/**
	 * Sets the pet ID number url of this detail pet.
	 *
	 * @param PetIdNumberURL the pet ID number url of this detail pet
	 */
	@Override
	public void setPetIdNumberURL(String PetIdNumberURL) {
		model.setPetIdNumberURL(PetIdNumberURL);
	}

	/**
	 * Sets the pet location of this detail pet.
	 *
	 * @param PetLocation the pet location of this detail pet
	 */
	@Override
	public void setPetLocation(String PetLocation) {
		model.setPetLocation(PetLocation);
	}

	/**
	 * Sets the pet name of this detail pet.
	 *
	 * @param PetName the pet name of this detail pet
	 */
	@Override
	public void setPetName(String PetName) {
		model.setPetName(PetName);
	}

	/**
	 * Sets the pet photo file entry ID of this detail pet.
	 *
	 * @param PetPhotoFileEntryId the pet photo file entry ID of this detail pet
	 */
	@Override
	public void setPetPhotoFileEntryId(long PetPhotoFileEntryId) {
		model.setPetPhotoFileEntryId(PetPhotoFileEntryId);
	}

	/**
	 * Sets the pet photo url of this detail pet.
	 *
	 * @param PetPhotoURL the pet photo url of this detail pet
	 */
	@Override
	public void setPetPhotoURL(String PetPhotoURL) {
		model.setPetPhotoURL(PetPhotoURL);
	}

	/**
	 * Sets the pet type of this detail pet.
	 *
	 * @param PetType the pet type of this detail pet
	 */
	@Override
	public void setPetType(String PetType) {
		model.setPetType(PetType);
	}

	/**
	 * Sets the pet vaccine of this detail pet.
	 *
	 * @param PetVaccine the pet vaccine of this detail pet
	 */
	@Override
	public void setPetVaccine(Integer PetVaccine) {
		model.setPetVaccine(PetVaccine);
	}

	/**
	 * Sets the plan ID of this detail pet.
	 *
	 * @param PlanId the plan ID of this detail pet
	 */
	@Override
	public void setPlanId(long PlanId) {
		model.setPlanId(PlanId);
	}

	/**
	 * Sets the primary key of this detail pet.
	 *
	 * @param primaryKey the primary key of this detail pet
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this detail pet.
	 *
	 * @param userId the user ID of this detail pet
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this detail pet.
	 *
	 * @param userName the user name of this detail pet
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this detail pet.
	 *
	 * @param userUuid the user uuid of this detail pet
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected DetailPetWrapper wrap(DetailPet detailPet) {
		return new DetailPetWrapper(detailPet);
	}

}