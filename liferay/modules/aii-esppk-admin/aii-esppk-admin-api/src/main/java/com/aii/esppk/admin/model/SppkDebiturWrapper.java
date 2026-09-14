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

package com.aii.esppk.admin.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SppkDebitur}.
 * </p>
 *
 * @author Gositus
 * @see SppkDebitur
 * @generated
 */
public class SppkDebiturWrapper
	extends BaseModelWrapper<SppkDebitur>
	implements ModelWrapper<SppkDebitur>, SppkDebitur {

	public SppkDebiturWrapper(SppkDebitur sppkDebitur) {
		super(sppkDebitur);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sppkDebiturId", getSppkDebiturId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("applicationNumber", getApplicationNumber());
		attributes.put("fullName", getFullName());
		attributes.put("birthPlace", getBirthPlace());
		attributes.put("birthDate", getBirthDate());
		attributes.put("idNumber", getIdNumber());
		attributes.put("address", getAddress());
		attributes.put("occupation", getOccupation());
		attributes.put("email", getEmail());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("gender", getGender());
		attributes.put("sumInsured", getSumInsured());
		attributes.put("product", getProduct());
		attributes.put("esppkToken", getEsppkToken());
		attributes.put("esppkTokenExpiry", getEsppkTokenExpiry());
		attributes.put("esppkQ1", getEsppkQ1());
		attributes.put("esppkQ2", getEsppkQ2());
		attributes.put("esppkQ3", getEsppkQ3());
		attributes.put("agreeRiplay", getAgreeRiplay());
		attributes.put("agreeStatement", getAgreeStatement());
		attributes.put("needAssistance", getNeedAssistance());
		attributes.put("submitEsppkDate", getSubmitEsppkDate());
		attributes.put("submissionNumber", getSubmissionNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sppkDebiturId = (Long)attributes.get("sppkDebiturId");

		if (sppkDebiturId != null) {
			setSppkDebiturId(sppkDebiturId);
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

		String applicationNumber = (String)attributes.get("applicationNumber");

		if (applicationNumber != null) {
			setApplicationNumber(applicationNumber);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String birthPlace = (String)attributes.get("birthPlace");

		if (birthPlace != null) {
			setBirthPlace(birthPlace);
		}

		Date birthDate = (Date)attributes.get("birthDate");

		if (birthDate != null) {
			setBirthDate(birthDate);
		}

		String idNumber = (String)attributes.get("idNumber");

		if (idNumber != null) {
			setIdNumber(idNumber);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String occupation = (String)attributes.get("occupation");

		if (occupation != null) {
			setOccupation(occupation);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		BigDecimal sumInsured = (BigDecimal)attributes.get("sumInsured");

		if (sumInsured != null) {
			setSumInsured(sumInsured);
		}

		String product = (String)attributes.get("product");

		if (product != null) {
			setProduct(product);
		}

		String esppkToken = (String)attributes.get("esppkToken");

		if (esppkToken != null) {
			setEsppkToken(esppkToken);
		}

		Date esppkTokenExpiry = (Date)attributes.get("esppkTokenExpiry");

		if (esppkTokenExpiry != null) {
			setEsppkTokenExpiry(esppkTokenExpiry);
		}

		Integer esppkQ1 = (Integer)attributes.get("esppkQ1");

		if (esppkQ1 != null) {
			setEsppkQ1(esppkQ1);
		}

		Integer esppkQ2 = (Integer)attributes.get("esppkQ2");

		if (esppkQ2 != null) {
			setEsppkQ2(esppkQ2);
		}

		Integer esppkQ3 = (Integer)attributes.get("esppkQ3");

		if (esppkQ3 != null) {
			setEsppkQ3(esppkQ3);
		}

		Integer agreeRiplay = (Integer)attributes.get("agreeRiplay");

		if (agreeRiplay != null) {
			setAgreeRiplay(agreeRiplay);
		}

		Integer agreeStatement = (Integer)attributes.get("agreeStatement");

		if (agreeStatement != null) {
			setAgreeStatement(agreeStatement);
		}

		Integer needAssistance = (Integer)attributes.get("needAssistance");

		if (needAssistance != null) {
			setNeedAssistance(needAssistance);
		}

		Date submitEsppkDate = (Date)attributes.get("submitEsppkDate");

		if (submitEsppkDate != null) {
			setSubmitEsppkDate(submitEsppkDate);
		}

		String submissionNumber = (String)attributes.get("submissionNumber");

		if (submissionNumber != null) {
			setSubmissionNumber(submissionNumber);
		}
	}

	/**
	 * Returns the address of this sppk debitur.
	 *
	 * @return the address of this sppk debitur
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the agree riplay of this sppk debitur.
	 *
	 * @return the agree riplay of this sppk debitur
	 */
	@Override
	public int getAgreeRiplay() {
		return model.getAgreeRiplay();
	}

	/**
	 * Returns the agree statement of this sppk debitur.
	 *
	 * @return the agree statement of this sppk debitur
	 */
	@Override
	public int getAgreeStatement() {
		return model.getAgreeStatement();
	}

	/**
	 * Returns the application number of this sppk debitur.
	 *
	 * @return the application number of this sppk debitur
	 */
	@Override
	public String getApplicationNumber() {
		return model.getApplicationNumber();
	}

	/**
	 * Returns the birth date of this sppk debitur.
	 *
	 * @return the birth date of this sppk debitur
	 */
	@Override
	public Date getBirthDate() {
		return model.getBirthDate();
	}

	/**
	 * Returns the birth place of this sppk debitur.
	 *
	 * @return the birth place of this sppk debitur
	 */
	@Override
	public String getBirthPlace() {
		return model.getBirthPlace();
	}

	/**
	 * Returns the company ID of this sppk debitur.
	 *
	 * @return the company ID of this sppk debitur
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this sppk debitur.
	 *
	 * @return the create date of this sppk debitur
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this sppk debitur.
	 *
	 * @return the email of this sppk debitur
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the esppk q1 of this sppk debitur.
	 *
	 * @return the esppk q1 of this sppk debitur
	 */
	@Override
	public int getEsppkQ1() {
		return model.getEsppkQ1();
	}

	/**
	 * Returns the esppk q2 of this sppk debitur.
	 *
	 * @return the esppk q2 of this sppk debitur
	 */
	@Override
	public int getEsppkQ2() {
		return model.getEsppkQ2();
	}

	/**
	 * Returns the esppk q3 of this sppk debitur.
	 *
	 * @return the esppk q3 of this sppk debitur
	 */
	@Override
	public int getEsppkQ3() {
		return model.getEsppkQ3();
	}

	/**
	 * Returns the esppk token of this sppk debitur.
	 *
	 * @return the esppk token of this sppk debitur
	 */
	@Override
	public String getEsppkToken() {
		return model.getEsppkToken();
	}

	/**
	 * Returns the esppk token expiry of this sppk debitur.
	 *
	 * @return the esppk token expiry of this sppk debitur
	 */
	@Override
	public Date getEsppkTokenExpiry() {
		return model.getEsppkTokenExpiry();
	}

	/**
	 * Returns the full name of this sppk debitur.
	 *
	 * @return the full name of this sppk debitur
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the gender of this sppk debitur.
	 *
	 * @return the gender of this sppk debitur
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this sppk debitur.
	 *
	 * @return the group ID of this sppk debitur
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the id number of this sppk debitur.
	 *
	 * @return the id number of this sppk debitur
	 */
	@Override
	public String getIdNumber() {
		return model.getIdNumber();
	}

	/**
	 * Returns the modified date of this sppk debitur.
	 *
	 * @return the modified date of this sppk debitur
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the need assistance of this sppk debitur.
	 *
	 * @return the need assistance of this sppk debitur
	 */
	@Override
	public int getNeedAssistance() {
		return model.getNeedAssistance();
	}

	/**
	 * Returns the occupation of this sppk debitur.
	 *
	 * @return the occupation of this sppk debitur
	 */
	@Override
	public String getOccupation() {
		return model.getOccupation();
	}

	/**
	 * Returns the phone number of this sppk debitur.
	 *
	 * @return the phone number of this sppk debitur
	 */
	@Override
	public String getPhoneNumber() {
		return model.getPhoneNumber();
	}

	/**
	 * Returns the primary key of this sppk debitur.
	 *
	 * @return the primary key of this sppk debitur
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product of this sppk debitur.
	 *
	 * @return the product of this sppk debitur
	 */
	@Override
	public String getProduct() {
		return model.getProduct();
	}

	/**
	 * Returns the sppk debitur ID of this sppk debitur.
	 *
	 * @return the sppk debitur ID of this sppk debitur
	 */
	@Override
	public long getSppkDebiturId() {
		return model.getSppkDebiturId();
	}

	/**
	 * Returns the status of this sppk debitur.
	 *
	 * @return the status of this sppk debitur
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the submission number of this sppk debitur.
	 *
	 * @return the submission number of this sppk debitur
	 */
	@Override
	public String getSubmissionNumber() {
		return model.getSubmissionNumber();
	}

	/**
	 * Returns the submit esppk date of this sppk debitur.
	 *
	 * @return the submit esppk date of this sppk debitur
	 */
	@Override
	public Date getSubmitEsppkDate() {
		return model.getSubmitEsppkDate();
	}

	/**
	 * Returns the sum insured of this sppk debitur.
	 *
	 * @return the sum insured of this sppk debitur
	 */
	@Override
	public BigDecimal getSumInsured() {
		return model.getSumInsured();
	}

	/**
	 * Returns the trash entry created when this sppk debitur was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this sppk debitur.
	 *
	 * @return the trash entry created when this sppk debitur was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this sppk debitur.
	 *
	 * @return the class primary key of the trash entry for this sppk debitur
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this sppk debitur.
	 *
	 * @return the trash handler for this sppk debitur
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this sppk debitur.
	 *
	 * @return the user ID of this sppk debitur
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this sppk debitur.
	 *
	 * @return the user name of this sppk debitur
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this sppk debitur.
	 *
	 * @return the user uuid of this sppk debitur
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this sppk debitur is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this sppk debitur is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this sppk debitur is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this sppk debitur is in the Recycle Bin; <code>false</code> otherwise
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
	 * Sets the address of this sppk debitur.
	 *
	 * @param address the address of this sppk debitur
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the agree riplay of this sppk debitur.
	 *
	 * @param agreeRiplay the agree riplay of this sppk debitur
	 */
	@Override
	public void setAgreeRiplay(int agreeRiplay) {
		model.setAgreeRiplay(agreeRiplay);
	}

	/**
	 * Sets the agree statement of this sppk debitur.
	 *
	 * @param agreeStatement the agree statement of this sppk debitur
	 */
	@Override
	public void setAgreeStatement(int agreeStatement) {
		model.setAgreeStatement(agreeStatement);
	}

	/**
	 * Sets the application number of this sppk debitur.
	 *
	 * @param applicationNumber the application number of this sppk debitur
	 */
	@Override
	public void setApplicationNumber(String applicationNumber) {
		model.setApplicationNumber(applicationNumber);
	}

	/**
	 * Sets the birth date of this sppk debitur.
	 *
	 * @param birthDate the birth date of this sppk debitur
	 */
	@Override
	public void setBirthDate(Date birthDate) {
		model.setBirthDate(birthDate);
	}

	/**
	 * Sets the birth place of this sppk debitur.
	 *
	 * @param birthPlace the birth place of this sppk debitur
	 */
	@Override
	public void setBirthPlace(String birthPlace) {
		model.setBirthPlace(birthPlace);
	}

	/**
	 * Sets the company ID of this sppk debitur.
	 *
	 * @param companyId the company ID of this sppk debitur
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this sppk debitur.
	 *
	 * @param createDate the create date of this sppk debitur
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this sppk debitur.
	 *
	 * @param email the email of this sppk debitur
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the esppk q1 of this sppk debitur.
	 *
	 * @param esppkQ1 the esppk q1 of this sppk debitur
	 */
	@Override
	public void setEsppkQ1(int esppkQ1) {
		model.setEsppkQ1(esppkQ1);
	}

	/**
	 * Sets the esppk q2 of this sppk debitur.
	 *
	 * @param esppkQ2 the esppk q2 of this sppk debitur
	 */
	@Override
	public void setEsppkQ2(int esppkQ2) {
		model.setEsppkQ2(esppkQ2);
	}

	/**
	 * Sets the esppk q3 of this sppk debitur.
	 *
	 * @param esppkQ3 the esppk q3 of this sppk debitur
	 */
	@Override
	public void setEsppkQ3(int esppkQ3) {
		model.setEsppkQ3(esppkQ3);
	}

	/**
	 * Sets the esppk token of this sppk debitur.
	 *
	 * @param esppkToken the esppk token of this sppk debitur
	 */
	@Override
	public void setEsppkToken(String esppkToken) {
		model.setEsppkToken(esppkToken);
	}

	/**
	 * Sets the esppk token expiry of this sppk debitur.
	 *
	 * @param esppkTokenExpiry the esppk token expiry of this sppk debitur
	 */
	@Override
	public void setEsppkTokenExpiry(Date esppkTokenExpiry) {
		model.setEsppkTokenExpiry(esppkTokenExpiry);
	}

	/**
	 * Sets the full name of this sppk debitur.
	 *
	 * @param fullName the full name of this sppk debitur
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the gender of this sppk debitur.
	 *
	 * @param gender the gender of this sppk debitur
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this sppk debitur.
	 *
	 * @param groupId the group ID of this sppk debitur
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the id number of this sppk debitur.
	 *
	 * @param idNumber the id number of this sppk debitur
	 */
	@Override
	public void setIdNumber(String idNumber) {
		model.setIdNumber(idNumber);
	}

	/**
	 * Sets the modified date of this sppk debitur.
	 *
	 * @param modifiedDate the modified date of this sppk debitur
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the need assistance of this sppk debitur.
	 *
	 * @param needAssistance the need assistance of this sppk debitur
	 */
	@Override
	public void setNeedAssistance(int needAssistance) {
		model.setNeedAssistance(needAssistance);
	}

	/**
	 * Sets the occupation of this sppk debitur.
	 *
	 * @param occupation the occupation of this sppk debitur
	 */
	@Override
	public void setOccupation(String occupation) {
		model.setOccupation(occupation);
	}

	/**
	 * Sets the phone number of this sppk debitur.
	 *
	 * @param phoneNumber the phone number of this sppk debitur
	 */
	@Override
	public void setPhoneNumber(String phoneNumber) {
		model.setPhoneNumber(phoneNumber);
	}

	/**
	 * Sets the primary key of this sppk debitur.
	 *
	 * @param primaryKey the primary key of this sppk debitur
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product of this sppk debitur.
	 *
	 * @param product the product of this sppk debitur
	 */
	@Override
	public void setProduct(String product) {
		model.setProduct(product);
	}

	/**
	 * Sets the sppk debitur ID of this sppk debitur.
	 *
	 * @param sppkDebiturId the sppk debitur ID of this sppk debitur
	 */
	@Override
	public void setSppkDebiturId(long sppkDebiturId) {
		model.setSppkDebiturId(sppkDebiturId);
	}

	/**
	 * Sets the submission number of this sppk debitur.
	 *
	 * @param submissionNumber the submission number of this sppk debitur
	 */
	@Override
	public void setSubmissionNumber(String submissionNumber) {
		model.setSubmissionNumber(submissionNumber);
	}

	/**
	 * Sets the submit esppk date of this sppk debitur.
	 *
	 * @param submitEsppkDate the submit esppk date of this sppk debitur
	 */
	@Override
	public void setSubmitEsppkDate(Date submitEsppkDate) {
		model.setSubmitEsppkDate(submitEsppkDate);
	}

	/**
	 * Sets the sum insured of this sppk debitur.
	 *
	 * @param sumInsured the sum insured of this sppk debitur
	 */
	@Override
	public void setSumInsured(BigDecimal sumInsured) {
		model.setSumInsured(sumInsured);
	}

	/**
	 * Sets the user ID of this sppk debitur.
	 *
	 * @param userId the user ID of this sppk debitur
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this sppk debitur.
	 *
	 * @param userName the user name of this sppk debitur
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this sppk debitur.
	 *
	 * @param userUuid the user uuid of this sppk debitur
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SppkDebiturWrapper wrap(SppkDebitur sppkDebitur) {
		return new SppkDebiturWrapper(sppkDebitur);
	}

}