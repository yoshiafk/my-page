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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.SmartHealthBenefitGroupServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SmartHealthBenefitGroupSoap implements Serializable {

	public static SmartHealthBenefitGroupSoap toSoapModel(
		SmartHealthBenefitGroup model) {

		SmartHealthBenefitGroupSoap soapModel =
			new SmartHealthBenefitGroupSoap();

		soapModel.setSmartHealthBenefitGroupId(
			model.getSmartHealthBenefitGroupId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGroupName(model.getGroupName());
		soapModel.setGroupDescription(model.getGroupDescription());
		soapModel.setGroupCode(model.getGroupCode());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static SmartHealthBenefitGroupSoap[] toSoapModels(
		SmartHealthBenefitGroup[] models) {

		SmartHealthBenefitGroupSoap[] soapModels =
			new SmartHealthBenefitGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SmartHealthBenefitGroupSoap[][] toSoapModels(
		SmartHealthBenefitGroup[][] models) {

		SmartHealthBenefitGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new SmartHealthBenefitGroupSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new SmartHealthBenefitGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SmartHealthBenefitGroupSoap[] toSoapModels(
		List<SmartHealthBenefitGroup> models) {

		List<SmartHealthBenefitGroupSoap> soapModels =
			new ArrayList<SmartHealthBenefitGroupSoap>(models.size());

		for (SmartHealthBenefitGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new SmartHealthBenefitGroupSoap[soapModels.size()]);
	}

	public SmartHealthBenefitGroupSoap() {
	}

	public long getPrimaryKey() {
		return _smartHealthBenefitGroupId;
	}

	public void setPrimaryKey(long pk) {
		setSmartHealthBenefitGroupId(pk);
	}

	public long getSmartHealthBenefitGroupId() {
		return _smartHealthBenefitGroupId;
	}

	public void setSmartHealthBenefitGroupId(long smartHealthBenefitGroupId) {
		_smartHealthBenefitGroupId = smartHealthBenefitGroupId;
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

	public String getGroupName() {
		return _groupName;
	}

	public void setGroupName(String groupName) {
		_groupName = groupName;
	}

	public String getGroupDescription() {
		return _groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		_groupDescription = groupDescription;
	}

	public String getGroupCode() {
		return _groupCode;
	}

	public void setGroupCode(String groupCode) {
		_groupCode = groupCode;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _smartHealthBenefitGroupId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _groupName;
	private String _groupDescription;
	private String _groupCode;
	private int _active;

}