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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.PetDetailServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PetDetailSoap implements Serializable {

	public static PetDetailSoap toSoapModel(PetDetail model) {
		PetDetailSoap soapModel = new PetDetailSoap();

		soapModel.setPetDetailId(model.getPetDetailId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRemarksAValue(model.getRemarksAValue());
		soapModel.setRemarksBValue(model.getRemarksBValue());
		soapModel.setRemarksCValue(model.getRemarksCValue());
		soapModel.setRemarksDValue(model.getRemarksDValue());
		soapModel.setPetName(model.getPetName());
		soapModel.setPetType(model.getPetType());
		soapModel.setPetGender(model.getPetGender());
		soapModel.setPetDob(model.getPetDob());
		soapModel.setPetIdNumber(model.getPetIdNumber());
		soapModel.setPetIdNumberIssuing(model.getPetIdNumberIssuing());
		soapModel.setPetIdNumberFile(model.getPetIdNumberFile());
		soapModel.setPetPhoto(model.getPetPhoto());
		soapModel.setPetLocation(model.getPetLocation());
		soapModel.setPetVaccine(model.getPetVaccine());
		soapModel.setPetAuthorizedCertificate(
			model.getPetAuthorizedCertificate());

		return soapModel;
	}

	public static PetDetailSoap[] toSoapModels(PetDetail[] models) {
		PetDetailSoap[] soapModels = new PetDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PetDetailSoap[][] toSoapModels(PetDetail[][] models) {
		PetDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PetDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PetDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PetDetailSoap[] toSoapModels(List<PetDetail> models) {
		List<PetDetailSoap> soapModels = new ArrayList<PetDetailSoap>(
			models.size());

		for (PetDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PetDetailSoap[soapModels.size()]);
	}

	public PetDetailSoap() {
	}

	public long getPrimaryKey() {
		return _petDetailId;
	}

	public void setPrimaryKey(long pk) {
		setPetDetailId(pk);
	}

	public long getPetDetailId() {
		return _petDetailId;
	}

	public void setPetDetailId(long petDetailId) {
		_petDetailId = petDetailId;
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

	public String getRemarksAValue() {
		return _remarksAValue;
	}

	public void setRemarksAValue(String remarksAValue) {
		_remarksAValue = remarksAValue;
	}

	public String getRemarksBValue() {
		return _remarksBValue;
	}

	public void setRemarksBValue(String remarksBValue) {
		_remarksBValue = remarksBValue;
	}

	public String getRemarksCValue() {
		return _remarksCValue;
	}

	public void setRemarksCValue(String remarksCValue) {
		_remarksCValue = remarksCValue;
	}

	public String getRemarksDValue() {
		return _remarksDValue;
	}

	public void setRemarksDValue(String remarksDValue) {
		_remarksDValue = remarksDValue;
	}

	public String getPetName() {
		return _petName;
	}

	public void setPetName(String petName) {
		_petName = petName;
	}

	public int getPetType() {
		return _petType;
	}

	public void setPetType(int petType) {
		_petType = petType;
	}

	public int getPetGender() {
		return _petGender;
	}

	public void setPetGender(int petGender) {
		_petGender = petGender;
	}

	public Date getPetDob() {
		return _petDob;
	}

	public void setPetDob(Date petDob) {
		_petDob = petDob;
	}

	public String getPetIdNumber() {
		return _petIdNumber;
	}

	public void setPetIdNumber(String petIdNumber) {
		_petIdNumber = petIdNumber;
	}

	public String getPetIdNumberIssuing() {
		return _petIdNumberIssuing;
	}

	public void setPetIdNumberIssuing(String petIdNumberIssuing) {
		_petIdNumberIssuing = petIdNumberIssuing;
	}

	public String getPetIdNumberFile() {
		return _petIdNumberFile;
	}

	public void setPetIdNumberFile(String petIdNumberFile) {
		_petIdNumberFile = petIdNumberFile;
	}

	public String getPetPhoto() {
		return _petPhoto;
	}

	public void setPetPhoto(String petPhoto) {
		_petPhoto = petPhoto;
	}

	public String getPetLocation() {
		return _petLocation;
	}

	public void setPetLocation(String petLocation) {
		_petLocation = petLocation;
	}

	public int getPetVaccine() {
		return _petVaccine;
	}

	public void setPetVaccine(int petVaccine) {
		_petVaccine = petVaccine;
	}

	public int getPetAuthorizedCertificate() {
		return _petAuthorizedCertificate;
	}

	public void setPetAuthorizedCertificate(int petAuthorizedCertificate) {
		_petAuthorizedCertificate = petAuthorizedCertificate;
	}

	private long _petDetailId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _remarksAValue;
	private String _remarksBValue;
	private String _remarksCValue;
	private String _remarksDValue;
	private String _petName;
	private int _petType;
	private int _petGender;
	private Date _petDob;
	private String _petIdNumber;
	private String _petIdNumberIssuing;
	private String _petIdNumberFile;
	private String _petPhoto;
	private String _petLocation;
	private int _petVaccine;
	private int _petAuthorizedCertificate;

}