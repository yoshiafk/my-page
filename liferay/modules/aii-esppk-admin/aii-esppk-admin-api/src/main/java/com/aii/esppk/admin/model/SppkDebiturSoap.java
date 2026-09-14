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

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.aii.esppk.admin.service.http.SppkDebiturServiceSoap}.
 *
 * @author Gositus
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SppkDebiturSoap implements Serializable {

	public static SppkDebiturSoap toSoapModel(SppkDebitur model) {
		SppkDebiturSoap soapModel = new SppkDebiturSoap();

		soapModel.setSppkDebiturId(model.getSppkDebiturId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setApplicationNumber(model.getApplicationNumber());
		soapModel.setFullName(model.getFullName());
		soapModel.setBirthPlace(model.getBirthPlace());
		soapModel.setBirthDate(model.getBirthDate());
		soapModel.setIdNumber(model.getIdNumber());
		soapModel.setAddress(model.getAddress());
		soapModel.setOccupation(model.getOccupation());
		soapModel.setEmail(model.getEmail());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setGender(model.getGender());
		soapModel.setSumInsured(model.getSumInsured());
		soapModel.setProduct(model.getProduct());
		soapModel.setEsppkToken(model.getEsppkToken());
		soapModel.setEsppkTokenExpiry(model.getEsppkTokenExpiry());
		soapModel.setEsppkQ1(model.getEsppkQ1());
		soapModel.setEsppkQ2(model.getEsppkQ2());
		soapModel.setEsppkQ3(model.getEsppkQ3());
		soapModel.setAgreeRiplay(model.getAgreeRiplay());
		soapModel.setAgreeStatement(model.getAgreeStatement());
		soapModel.setNeedAssistance(model.getNeedAssistance());
		soapModel.setSubmitEsppkDate(model.getSubmitEsppkDate());
		soapModel.setSubmissionNumber(model.getSubmissionNumber());

		return soapModel;
	}

	public static SppkDebiturSoap[] toSoapModels(SppkDebitur[] models) {
		SppkDebiturSoap[] soapModels = new SppkDebiturSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SppkDebiturSoap[][] toSoapModels(SppkDebitur[][] models) {
		SppkDebiturSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SppkDebiturSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SppkDebiturSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SppkDebiturSoap[] toSoapModels(List<SppkDebitur> models) {
		List<SppkDebiturSoap> soapModels = new ArrayList<SppkDebiturSoap>(
			models.size());

		for (SppkDebitur model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SppkDebiturSoap[soapModels.size()]);
	}

	public SppkDebiturSoap() {
	}

	public long getPrimaryKey() {
		return _sppkDebiturId;
	}

	public void setPrimaryKey(long pk) {
		setSppkDebiturId(pk);
	}

	public long getSppkDebiturId() {
		return _sppkDebiturId;
	}

	public void setSppkDebiturId(long sppkDebiturId) {
		_sppkDebiturId = sppkDebiturId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getApplicationNumber() {
		return _applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		_applicationNumber = applicationNumber;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getBirthPlace() {
		return _birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		_birthPlace = birthPlace;
	}

	public Date getBirthDate() {
		return _birthDate;
	}

	public void setBirthDate(Date birthDate) {
		_birthDate = birthDate;
	}

	public String getIdNumber() {
		return _idNumber;
	}

	public void setIdNumber(String idNumber) {
		_idNumber = idNumber;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getOccupation() {
		return _occupation;
	}

	public void setOccupation(String occupation) {
		_occupation = occupation;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public BigDecimal getSumInsured() {
		return _sumInsured;
	}

	public void setSumInsured(BigDecimal sumInsured) {
		_sumInsured = sumInsured;
	}

	public String getProduct() {
		return _product;
	}

	public void setProduct(String product) {
		_product = product;
	}

	public String getEsppkToken() {
		return _esppkToken;
	}

	public void setEsppkToken(String esppkToken) {
		_esppkToken = esppkToken;
	}

	public Date getEsppkTokenExpiry() {
		return _esppkTokenExpiry;
	}

	public void setEsppkTokenExpiry(Date esppkTokenExpiry) {
		_esppkTokenExpiry = esppkTokenExpiry;
	}

	public int getEsppkQ1() {
		return _esppkQ1;
	}

	public void setEsppkQ1(int esppkQ1) {
		_esppkQ1 = esppkQ1;
	}

	public int getEsppkQ2() {
		return _esppkQ2;
	}

	public void setEsppkQ2(int esppkQ2) {
		_esppkQ2 = esppkQ2;
	}

	public int getEsppkQ3() {
		return _esppkQ3;
	}

	public void setEsppkQ3(int esppkQ3) {
		_esppkQ3 = esppkQ3;
	}

	public int getAgreeRiplay() {
		return _agreeRiplay;
	}

	public void setAgreeRiplay(int agreeRiplay) {
		_agreeRiplay = agreeRiplay;
	}

	public int getAgreeStatement() {
		return _agreeStatement;
	}

	public void setAgreeStatement(int agreeStatement) {
		_agreeStatement = agreeStatement;
	}

	public int getNeedAssistance() {
		return _needAssistance;
	}

	public void setNeedAssistance(int needAssistance) {
		_needAssistance = needAssistance;
	}

	public Date getSubmitEsppkDate() {
		return _submitEsppkDate;
	}

	public void setSubmitEsppkDate(Date submitEsppkDate) {
		_submitEsppkDate = submitEsppkDate;
	}

	public String getSubmissionNumber() {
		return _submissionNumber;
	}

	public void setSubmissionNumber(String submissionNumber) {
		_submissionNumber = submissionNumber;
	}

	private long _sppkDebiturId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _applicationNumber;
	private String _fullName;
	private String _birthPlace;
	private Date _birthDate;
	private String _idNumber;
	private String _address;
	private String _occupation;
	private String _email;
	private String _phoneNumber;
	private String _gender;
	private BigDecimal _sumInsured;
	private String _product;
	private String _esppkToken;
	private Date _esppkTokenExpiry;
	private int _esppkQ1;
	private int _esppkQ2;
	private int _esppkQ3;
	private int _agreeRiplay;
	private int _agreeStatement;
	private int _needAssistance;
	private Date _submitEsppkDate;
	private String _submissionNumber;

}