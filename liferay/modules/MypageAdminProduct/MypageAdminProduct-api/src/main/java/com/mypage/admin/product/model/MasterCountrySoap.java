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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.MasterCountryServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MasterCountrySoap implements Serializable {

	public static MasterCountrySoap toSoapModel(MasterCountry model) {
		MasterCountrySoap soapModel = new MasterCountrySoap();

		soapModel.setCountryId(model.getCountryId());
		soapModel.setName(model.getName());
		soapModel.setIsPlatinum(model.getIsPlatinum());
		soapModel.setIsGold(model.getIsGold());
		soapModel.setIsSpecialAsia(model.getIsSpecialAsia());
		soapModel.setIsSchengen(model.getIsSchengen());
		soapModel.setIsSanctionCountry(model.getIsSanctionCountry());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static MasterCountrySoap[] toSoapModels(MasterCountry[] models) {
		MasterCountrySoap[] soapModels = new MasterCountrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MasterCountrySoap[][] toSoapModels(MasterCountry[][] models) {
		MasterCountrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MasterCountrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new MasterCountrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MasterCountrySoap[] toSoapModels(List<MasterCountry> models) {
		List<MasterCountrySoap> soapModels = new ArrayList<MasterCountrySoap>(
			models.size());

		for (MasterCountry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MasterCountrySoap[soapModels.size()]);
	}

	public MasterCountrySoap() {
	}

	public long getPrimaryKey() {
		return _countryId;
	}

	public void setPrimaryKey(long pk) {
		setCountryId(pk);
	}

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public Integer getIsPlatinum() {
		return _isPlatinum;
	}

	public void setIsPlatinum(Integer isPlatinum) {
		_isPlatinum = isPlatinum;
	}

	public Integer getIsGold() {
		return _isGold;
	}

	public void setIsGold(Integer isGold) {
		_isGold = isGold;
	}

	public Integer getIsSpecialAsia() {
		return _isSpecialAsia;
	}

	public void setIsSpecialAsia(Integer isSpecialAsia) {
		_isSpecialAsia = isSpecialAsia;
	}

	public Integer getIsSchengen() {
		return _isSchengen;
	}

	public void setIsSchengen(Integer isSchengen) {
		_isSchengen = isSchengen;
	}

	public Integer getIsSanctionCountry() {
		return _isSanctionCountry;
	}

	public void setIsSanctionCountry(Integer isSanctionCountry) {
		_isSanctionCountry = isSanctionCountry;
	}

	public Integer getActive() {
		return _active;
	}

	public void setActive(Integer active) {
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

	private long _countryId;
	private String _name;
	private Integer _isPlatinum;
	private Integer _isGold;
	private Integer _isSpecialAsia;
	private Integer _isSchengen;
	private Integer _isSanctionCountry;
	private Integer _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}