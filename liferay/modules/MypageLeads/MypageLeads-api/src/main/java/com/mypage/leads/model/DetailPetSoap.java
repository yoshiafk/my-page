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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.leads.service.http.DetailPetServiceSoap}.
 *
 * @author Gositus
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DetailPetSoap implements Serializable {

	public static DetailPetSoap toSoapModel(DetailPet model) {
		DetailPetSoap soapModel = new DetailPetSoap();

		soapModel.setDetailPetId(model.getDetailPetId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLeadsId(model.getLeadsId());
		soapModel.setPlanId(model.getPlanId());
		soapModel.setLimitDisability(model.getLimitDisability());
		soapModel.setLimitMedical(model.getLimitMedical());
		soapModel.setLimitThirdParty(model.getLimitThirdParty());
		soapModel.setLimitCustody(model.getLimitCustody());
		soapModel.setPetName(model.getPetName());
		soapModel.setPetType(model.getPetType());
		soapModel.setPetGender(model.getPetGender());
		soapModel.setPetDob(model.getPetDob());
		soapModel.setPetIdNumber(model.getPetIdNumber());
		soapModel.setPetIdNumberIssuing(model.getPetIdNumberIssuing());
		soapModel.setPetIdNumberFileEntryId(model.getPetIdNumberFileEntryId());
		soapModel.setPetIdNumberURL(model.getPetIdNumberURL());
		soapModel.setPetPhotoFileEntryId(model.getPetPhotoFileEntryId());
		soapModel.setPetPhotoURL(model.getPetPhotoURL());
		soapModel.setPetLocation(model.getPetLocation());
		soapModel.setPetVaccine(model.getPetVaccine());
		soapModel.setPetAuthorizedCertificate(
			model.getPetAuthorizedCertificate());

		return soapModel;
	}

	public static DetailPetSoap[] toSoapModels(DetailPet[] models) {
		DetailPetSoap[] soapModels = new DetailPetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DetailPetSoap[][] toSoapModels(DetailPet[][] models) {
		DetailPetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DetailPetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DetailPetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DetailPetSoap[] toSoapModels(List<DetailPet> models) {
		List<DetailPetSoap> soapModels = new ArrayList<DetailPetSoap>(
			models.size());

		for (DetailPet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DetailPetSoap[soapModels.size()]);
	}

	public DetailPetSoap() {
	}

	public long getPrimaryKey() {
		return _detailPetId;
	}

	public void setPrimaryKey(long pk) {
		setDetailPetId(pk);
	}

	public long getDetailPetId() {
		return _detailPetId;
	}

	public void setDetailPetId(long detailPetId) {
		_detailPetId = detailPetId;
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

	public long getLeadsId() {
		return _LeadsId;
	}

	public void setLeadsId(long LeadsId) {
		_LeadsId = LeadsId;
	}

	public long getPlanId() {
		return _PlanId;
	}

	public void setPlanId(long PlanId) {
		_PlanId = PlanId;
	}

	public double getLimitDisability() {
		return _LimitDisability;
	}

	public void setLimitDisability(double LimitDisability) {
		_LimitDisability = LimitDisability;
	}

	public double getLimitMedical() {
		return _LimitMedical;
	}

	public void setLimitMedical(double LimitMedical) {
		_LimitMedical = LimitMedical;
	}

	public double getLimitThirdParty() {
		return _LimitThirdParty;
	}

	public void setLimitThirdParty(double LimitThirdParty) {
		_LimitThirdParty = LimitThirdParty;
	}

	public double getLimitCustody() {
		return _LimitCustody;
	}

	public void setLimitCustody(double LimitCustody) {
		_LimitCustody = LimitCustody;
	}

	public String getPetName() {
		return _PetName;
	}

	public void setPetName(String PetName) {
		_PetName = PetName;
	}

	public String getPetType() {
		return _PetType;
	}

	public void setPetType(String PetType) {
		_PetType = PetType;
	}

	public String getPetGender() {
		return _PetGender;
	}

	public void setPetGender(String PetGender) {
		_PetGender = PetGender;
	}

	public Date getPetDob() {
		return _PetDob;
	}

	public void setPetDob(Date PetDob) {
		_PetDob = PetDob;
	}

	public String getPetIdNumber() {
		return _PetIdNumber;
	}

	public void setPetIdNumber(String PetIdNumber) {
		_PetIdNumber = PetIdNumber;
	}

	public String getPetIdNumberIssuing() {
		return _PetIdNumberIssuing;
	}

	public void setPetIdNumberIssuing(String PetIdNumberIssuing) {
		_PetIdNumberIssuing = PetIdNumberIssuing;
	}

	public long getPetIdNumberFileEntryId() {
		return _PetIdNumberFileEntryId;
	}

	public void setPetIdNumberFileEntryId(long PetIdNumberFileEntryId) {
		_PetIdNumberFileEntryId = PetIdNumberFileEntryId;
	}

	public String getPetIdNumberURL() {
		return _PetIdNumberURL;
	}

	public void setPetIdNumberURL(String PetIdNumberURL) {
		_PetIdNumberURL = PetIdNumberURL;
	}

	public long getPetPhotoFileEntryId() {
		return _PetPhotoFileEntryId;
	}

	public void setPetPhotoFileEntryId(long PetPhotoFileEntryId) {
		_PetPhotoFileEntryId = PetPhotoFileEntryId;
	}

	public String getPetPhotoURL() {
		return _PetPhotoURL;
	}

	public void setPetPhotoURL(String PetPhotoURL) {
		_PetPhotoURL = PetPhotoURL;
	}

	public String getPetLocation() {
		return _PetLocation;
	}

	public void setPetLocation(String PetLocation) {
		_PetLocation = PetLocation;
	}

	public Integer getPetVaccine() {
		return _PetVaccine;
	}

	public void setPetVaccine(Integer PetVaccine) {
		_PetVaccine = PetVaccine;
	}

	public Integer getPetAuthorizedCertificate() {
		return _PetAuthorizedCertificate;
	}

	public void setPetAuthorizedCertificate(Integer PetAuthorizedCertificate) {
		_PetAuthorizedCertificate = PetAuthorizedCertificate;
	}

	private long _detailPetId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _LeadsId;
	private long _PlanId;
	private double _LimitDisability;
	private double _LimitMedical;
	private double _LimitThirdParty;
	private double _LimitCustody;
	private String _PetName;
	private String _PetType;
	private String _PetGender;
	private Date _PetDob;
	private String _PetIdNumber;
	private String _PetIdNumberIssuing;
	private long _PetIdNumberFileEntryId;
	private String _PetIdNumberURL;
	private long _PetPhotoFileEntryId;
	private String _PetPhotoURL;
	private String _PetLocation;
	private Integer _PetVaccine;
	private Integer _PetAuthorizedCertificate;

}