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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.PetPlanServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PetPlanSoap implements Serializable {

	public static PetPlanSoap toSoapModel(PetPlan model) {
		PetPlanSoap soapModel = new PetPlanSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPetPlanId(model.getPetPlanId());
		soapModel.setName(model.getName());
		soapModel.setLimitDisability(model.getLimitDisability());
		soapModel.setLimitMedical(model.getLimitMedical());
		soapModel.setLimitThirdParty(model.getLimitThirdParty());
		soapModel.setLimitCustody(model.getLimitCustody());
		soapModel.setRecommended(model.getRecommended());
		soapModel.setCustomPlan(model.getCustomPlan());
		soapModel.setBenefit(model.getBenefit());
		soapModel.setPimcorePlanId(model.getPimcorePlanId());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static PetPlanSoap[] toSoapModels(PetPlan[] models) {
		PetPlanSoap[] soapModels = new PetPlanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PetPlanSoap[][] toSoapModels(PetPlan[][] models) {
		PetPlanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PetPlanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PetPlanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PetPlanSoap[] toSoapModels(List<PetPlan> models) {
		List<PetPlanSoap> soapModels = new ArrayList<PetPlanSoap>(
			models.size());

		for (PetPlan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PetPlanSoap[soapModels.size()]);
	}

	public PetPlanSoap() {
	}

	public long getPrimaryKey() {
		return _petPlanId;
	}

	public void setPrimaryKey(long pk) {
		setPetPlanId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPetPlanId() {
		return _petPlanId;
	}

	public void setPetPlanId(long petPlanId) {
		_petPlanId = petPlanId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getLimitDisability() {
		return _limitDisability;
	}

	public void setLimitDisability(long limitDisability) {
		_limitDisability = limitDisability;
	}

	public long getLimitMedical() {
		return _limitMedical;
	}

	public void setLimitMedical(long limitMedical) {
		_limitMedical = limitMedical;
	}

	public long getLimitThirdParty() {
		return _limitThirdParty;
	}

	public void setLimitThirdParty(long limitThirdParty) {
		_limitThirdParty = limitThirdParty;
	}

	public long getLimitCustody() {
		return _limitCustody;
	}

	public void setLimitCustody(long limitCustody) {
		_limitCustody = limitCustody;
	}

	public int getRecommended() {
		return _recommended;
	}

	public void setRecommended(int recommended) {
		_recommended = recommended;
	}

	public int getCustomPlan() {
		return _customPlan;
	}

	public void setCustomPlan(int customPlan) {
		_customPlan = customPlan;
	}

	public String getBenefit() {
		return _benefit;
	}

	public void setBenefit(String benefit) {
		_benefit = benefit;
	}

	public long getPimcorePlanId() {
		return _pimcorePlanId;
	}

	public void setPimcorePlanId(long pimcorePlanId) {
		_pimcorePlanId = pimcorePlanId;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
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

	private String _uuid;
	private long _petPlanId;
	private String _name;
	private long _limitDisability;
	private long _limitMedical;
	private long _limitThirdParty;
	private long _limitCustody;
	private int _recommended;
	private int _customPlan;
	private String _benefit;
	private long _pimcorePlanId;
	private int _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}