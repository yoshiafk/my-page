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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.IndustryServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class IndustrySoap implements Serializable {

	public static IndustrySoap toSoapModel(Industry model) {
		IndustrySoap soapModel = new IndustrySoap();

		soapModel.setIndustryId(model.getIndustryId());
		soapModel.setName(model.getName());
		soapModel.setIndustryCategoryId(model.getIndustryCategoryId());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static IndustrySoap[] toSoapModels(Industry[] models) {
		IndustrySoap[] soapModels = new IndustrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IndustrySoap[][] toSoapModels(Industry[][] models) {
		IndustrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new IndustrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new IndustrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IndustrySoap[] toSoapModels(List<Industry> models) {
		List<IndustrySoap> soapModels = new ArrayList<IndustrySoap>(
			models.size());

		for (Industry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IndustrySoap[soapModels.size()]);
	}

	public IndustrySoap() {
	}

	public long getPrimaryKey() {
		return _industryId;
	}

	public void setPrimaryKey(long pk) {
		setIndustryId(pk);
	}

	public long getIndustryId() {
		return _industryId;
	}

	public void setIndustryId(long industryId) {
		_industryId = industryId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getIndustryCategoryId() {
		return _industryCategoryId;
	}

	public void setIndustryCategoryId(long industryCategoryId) {
		_industryCategoryId = industryCategoryId;
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

	private long _industryId;
	private String _name;
	private long _industryCategoryId;
	private int _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}