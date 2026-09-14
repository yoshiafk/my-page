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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PetDetail}.
 * </p>
 *
 * @author Gositus Team
 * @see PetDetail
 * @generated
 */
public class PetDetailWrapper
	extends BaseModelWrapper<PetDetail>
	implements ModelWrapper<PetDetail>, PetDetail {

	public PetDetailWrapper(PetDetail petDetail) {
		super(petDetail);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("petDetailId", getPetDetailId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("remarksAValue", getRemarksAValue());
		attributes.put("remarksBValue", getRemarksBValue());
		attributes.put("remarksCValue", getRemarksCValue());
		attributes.put("remarksDValue", getRemarksDValue());
		attributes.put("petName", getPetName());
		attributes.put("petType", getPetType());
		attributes.put("petGender", getPetGender());
		attributes.put("petDob", getPetDob());
		attributes.put("petIdNumber", getPetIdNumber());
		attributes.put("petIdNumberIssuing", getPetIdNumberIssuing());
		attributes.put("petIdNumberFile", getPetIdNumberFile());
		attributes.put("petPhoto", getPetPhoto());
		attributes.put("petLocation", getPetLocation());
		attributes.put("petVaccine", getPetVaccine());
		attributes.put(
			"petAuthorizedCertificate", getPetAuthorizedCertificate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long petDetailId = (Long)attributes.get("petDetailId");

		if (petDetailId != null) {
			setPetDetailId(petDetailId);
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

		String remarksAValue = (String)attributes.get("remarksAValue");

		if (remarksAValue != null) {
			setRemarksAValue(remarksAValue);
		}

		String remarksBValue = (String)attributes.get("remarksBValue");

		if (remarksBValue != null) {
			setRemarksBValue(remarksBValue);
		}

		String remarksCValue = (String)attributes.get("remarksCValue");

		if (remarksCValue != null) {
			setRemarksCValue(remarksCValue);
		}

		String remarksDValue = (String)attributes.get("remarksDValue");

		if (remarksDValue != null) {
			setRemarksDValue(remarksDValue);
		}

		String petName = (String)attributes.get("petName");

		if (petName != null) {
			setPetName(petName);
		}

		Integer petType = (Integer)attributes.get("petType");

		if (petType != null) {
			setPetType(petType);
		}

		Integer petGender = (Integer)attributes.get("petGender");

		if (petGender != null) {
			setPetGender(petGender);
		}

		Date petDob = (Date)attributes.get("petDob");

		if (petDob != null) {
			setPetDob(petDob);
		}

		String petIdNumber = (String)attributes.get("petIdNumber");

		if (petIdNumber != null) {
			setPetIdNumber(petIdNumber);
		}

		String petIdNumberIssuing = (String)attributes.get(
			"petIdNumberIssuing");

		if (petIdNumberIssuing != null) {
			setPetIdNumberIssuing(petIdNumberIssuing);
		}

		String petIdNumberFile = (String)attributes.get("petIdNumberFile");

		if (petIdNumberFile != null) {
			setPetIdNumberFile(petIdNumberFile);
		}

		String petPhoto = (String)attributes.get("petPhoto");

		if (petPhoto != null) {
			setPetPhoto(petPhoto);
		}

		String petLocation = (String)attributes.get("petLocation");

		if (petLocation != null) {
			setPetLocation(petLocation);
		}

		Integer petVaccine = (Integer)attributes.get("petVaccine");

		if (petVaccine != null) {
			setPetVaccine(petVaccine);
		}

		Integer petAuthorizedCertificate = (Integer)attributes.get(
			"petAuthorizedCertificate");

		if (petAuthorizedCertificate != null) {
			setPetAuthorizedCertificate(petAuthorizedCertificate);
		}
	}

	/**
	 * Returns the company ID of this pet detail.
	 *
	 * @return the company ID of this pet detail
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this pet detail.
	 *
	 * @return the create date of this pet detail
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this pet detail.
	 *
	 * @return the group ID of this pet detail
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this pet detail.
	 *
	 * @return the modified date of this pet detail
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the pet authorized certificate of this pet detail.
	 *
	 * @return the pet authorized certificate of this pet detail
	 */
	@Override
	public int getPetAuthorizedCertificate() {
		return model.getPetAuthorizedCertificate();
	}

	/**
	 * Returns the pet detail ID of this pet detail.
	 *
	 * @return the pet detail ID of this pet detail
	 */
	@Override
	public long getPetDetailId() {
		return model.getPetDetailId();
	}

	/**
	 * Returns the pet dob of this pet detail.
	 *
	 * @return the pet dob of this pet detail
	 */
	@Override
	public Date getPetDob() {
		return model.getPetDob();
	}

	/**
	 * Returns the pet gender of this pet detail.
	 *
	 * @return the pet gender of this pet detail
	 */
	@Override
	public int getPetGender() {
		return model.getPetGender();
	}

	/**
	 * Returns the pet ID number of this pet detail.
	 *
	 * @return the pet ID number of this pet detail
	 */
	@Override
	public String getPetIdNumber() {
		return model.getPetIdNumber();
	}

	/**
	 * Returns the pet ID number file of this pet detail.
	 *
	 * @return the pet ID number file of this pet detail
	 */
	@Override
	public String getPetIdNumberFile() {
		return model.getPetIdNumberFile();
	}

	/**
	 * Returns the pet ID number issuing of this pet detail.
	 *
	 * @return the pet ID number issuing of this pet detail
	 */
	@Override
	public String getPetIdNumberIssuing() {
		return model.getPetIdNumberIssuing();
	}

	/**
	 * Returns the pet location of this pet detail.
	 *
	 * @return the pet location of this pet detail
	 */
	@Override
	public String getPetLocation() {
		return model.getPetLocation();
	}

	/**
	 * Returns the pet name of this pet detail.
	 *
	 * @return the pet name of this pet detail
	 */
	@Override
	public String getPetName() {
		return model.getPetName();
	}

	/**
	 * Returns the pet photo of this pet detail.
	 *
	 * @return the pet photo of this pet detail
	 */
	@Override
	public String getPetPhoto() {
		return model.getPetPhoto();
	}

	/**
	 * Returns the pet type of this pet detail.
	 *
	 * @return the pet type of this pet detail
	 */
	@Override
	public int getPetType() {
		return model.getPetType();
	}

	/**
	 * Returns the pet vaccine of this pet detail.
	 *
	 * @return the pet vaccine of this pet detail
	 */
	@Override
	public int getPetVaccine() {
		return model.getPetVaccine();
	}

	/**
	 * Returns the primary key of this pet detail.
	 *
	 * @return the primary key of this pet detail
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the remarks a value of this pet detail.
	 *
	 * @return the remarks a value of this pet detail
	 */
	@Override
	public String getRemarksAValue() {
		return model.getRemarksAValue();
	}

	/**
	 * Returns the remarks b value of this pet detail.
	 *
	 * @return the remarks b value of this pet detail
	 */
	@Override
	public String getRemarksBValue() {
		return model.getRemarksBValue();
	}

	/**
	 * Returns the remarks c value of this pet detail.
	 *
	 * @return the remarks c value of this pet detail
	 */
	@Override
	public String getRemarksCValue() {
		return model.getRemarksCValue();
	}

	/**
	 * Returns the remarks d value of this pet detail.
	 *
	 * @return the remarks d value of this pet detail
	 */
	@Override
	public String getRemarksDValue() {
		return model.getRemarksDValue();
	}

	/**
	 * Returns the user ID of this pet detail.
	 *
	 * @return the user ID of this pet detail
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this pet detail.
	 *
	 * @return the user name of this pet detail
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this pet detail.
	 *
	 * @return the user uuid of this pet detail
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
	 * Sets the company ID of this pet detail.
	 *
	 * @param companyId the company ID of this pet detail
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this pet detail.
	 *
	 * @param createDate the create date of this pet detail
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this pet detail.
	 *
	 * @param groupId the group ID of this pet detail
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this pet detail.
	 *
	 * @param modifiedDate the modified date of this pet detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the pet authorized certificate of this pet detail.
	 *
	 * @param petAuthorizedCertificate the pet authorized certificate of this pet detail
	 */
	@Override
	public void setPetAuthorizedCertificate(int petAuthorizedCertificate) {
		model.setPetAuthorizedCertificate(petAuthorizedCertificate);
	}

	/**
	 * Sets the pet detail ID of this pet detail.
	 *
	 * @param petDetailId the pet detail ID of this pet detail
	 */
	@Override
	public void setPetDetailId(long petDetailId) {
		model.setPetDetailId(petDetailId);
	}

	/**
	 * Sets the pet dob of this pet detail.
	 *
	 * @param petDob the pet dob of this pet detail
	 */
	@Override
	public void setPetDob(Date petDob) {
		model.setPetDob(petDob);
	}

	/**
	 * Sets the pet gender of this pet detail.
	 *
	 * @param petGender the pet gender of this pet detail
	 */
	@Override
	public void setPetGender(int petGender) {
		model.setPetGender(petGender);
	}

	/**
	 * Sets the pet ID number of this pet detail.
	 *
	 * @param petIdNumber the pet ID number of this pet detail
	 */
	@Override
	public void setPetIdNumber(String petIdNumber) {
		model.setPetIdNumber(petIdNumber);
	}

	/**
	 * Sets the pet ID number file of this pet detail.
	 *
	 * @param petIdNumberFile the pet ID number file of this pet detail
	 */
	@Override
	public void setPetIdNumberFile(String petIdNumberFile) {
		model.setPetIdNumberFile(petIdNumberFile);
	}

	/**
	 * Sets the pet ID number issuing of this pet detail.
	 *
	 * @param petIdNumberIssuing the pet ID number issuing of this pet detail
	 */
	@Override
	public void setPetIdNumberIssuing(String petIdNumberIssuing) {
		model.setPetIdNumberIssuing(petIdNumberIssuing);
	}

	/**
	 * Sets the pet location of this pet detail.
	 *
	 * @param petLocation the pet location of this pet detail
	 */
	@Override
	public void setPetLocation(String petLocation) {
		model.setPetLocation(petLocation);
	}

	/**
	 * Sets the pet name of this pet detail.
	 *
	 * @param petName the pet name of this pet detail
	 */
	@Override
	public void setPetName(String petName) {
		model.setPetName(petName);
	}

	/**
	 * Sets the pet photo of this pet detail.
	 *
	 * @param petPhoto the pet photo of this pet detail
	 */
	@Override
	public void setPetPhoto(String petPhoto) {
		model.setPetPhoto(petPhoto);
	}

	/**
	 * Sets the pet type of this pet detail.
	 *
	 * @param petType the pet type of this pet detail
	 */
	@Override
	public void setPetType(int petType) {
		model.setPetType(petType);
	}

	/**
	 * Sets the pet vaccine of this pet detail.
	 *
	 * @param petVaccine the pet vaccine of this pet detail
	 */
	@Override
	public void setPetVaccine(int petVaccine) {
		model.setPetVaccine(petVaccine);
	}

	/**
	 * Sets the primary key of this pet detail.
	 *
	 * @param primaryKey the primary key of this pet detail
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the remarks a value of this pet detail.
	 *
	 * @param remarksAValue the remarks a value of this pet detail
	 */
	@Override
	public void setRemarksAValue(String remarksAValue) {
		model.setRemarksAValue(remarksAValue);
	}

	/**
	 * Sets the remarks b value of this pet detail.
	 *
	 * @param remarksBValue the remarks b value of this pet detail
	 */
	@Override
	public void setRemarksBValue(String remarksBValue) {
		model.setRemarksBValue(remarksBValue);
	}

	/**
	 * Sets the remarks c value of this pet detail.
	 *
	 * @param remarksCValue the remarks c value of this pet detail
	 */
	@Override
	public void setRemarksCValue(String remarksCValue) {
		model.setRemarksCValue(remarksCValue);
	}

	/**
	 * Sets the remarks d value of this pet detail.
	 *
	 * @param remarksDValue the remarks d value of this pet detail
	 */
	@Override
	public void setRemarksDValue(String remarksDValue) {
		model.setRemarksDValue(remarksDValue);
	}

	/**
	 * Sets the user ID of this pet detail.
	 *
	 * @param userId the user ID of this pet detail
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this pet detail.
	 *
	 * @param userName the user name of this pet detail
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this pet detail.
	 *
	 * @param userUuid the user uuid of this pet detail
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PetDetailWrapper wrap(PetDetail petDetail) {
		return new PetDetailWrapper(petDetail);
	}

}