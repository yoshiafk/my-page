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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.SmartActiveToproServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SmartActiveToproSoap implements Serializable {

	public static SmartActiveToproSoap toSoapModel(SmartActiveTopro model) {
		SmartActiveToproSoap soapModel = new SmartActiveToproSoap();

		soapModel.setSmartActiveToproId(model.getSmartActiveToproId());
		soapModel.setTopro(model.getTopro());
		soapModel.setDescription(model.getDescription());
		soapModel.setAnnotations(model.getAnnotations());
		soapModel.setSmartActiveBenefitValueId(
			model.getSmartActiveBenefitValueId());
		soapModel.setToc(model.getToc());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SmartActiveToproSoap[] toSoapModels(
		SmartActiveTopro[] models) {

		SmartActiveToproSoap[] soapModels =
			new SmartActiveToproSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SmartActiveToproSoap[][] toSoapModels(
		SmartActiveTopro[][] models) {

		SmartActiveToproSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new SmartActiveToproSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SmartActiveToproSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SmartActiveToproSoap[] toSoapModels(
		List<SmartActiveTopro> models) {

		List<SmartActiveToproSoap> soapModels =
			new ArrayList<SmartActiveToproSoap>(models.size());

		for (SmartActiveTopro model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SmartActiveToproSoap[soapModels.size()]);
	}

	public SmartActiveToproSoap() {
	}

	public long getPrimaryKey() {
		return _smartActiveToproId;
	}

	public void setPrimaryKey(long pk) {
		setSmartActiveToproId(pk);
	}

	public long getSmartActiveToproId() {
		return _smartActiveToproId;
	}

	public void setSmartActiveToproId(long smartActiveToproId) {
		_smartActiveToproId = smartActiveToproId;
	}

	public String getTopro() {
		return _topro;
	}

	public void setTopro(String topro) {
		_topro = topro;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getAnnotations() {
		return _annotations;
	}

	public void setAnnotations(String annotations) {
		_annotations = annotations;
	}

	public long getSmartActiveBenefitValueId() {
		return _smartActiveBenefitValueId;
	}

	public void setSmartActiveBenefitValueId(long smartActiveBenefitValueId) {
		_smartActiveBenefitValueId = smartActiveBenefitValueId;
	}

	public String getToc() {
		return _toc;
	}

	public void setToc(String toc) {
		_toc = toc;
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

	private long _smartActiveToproId;
	private String _topro;
	private String _description;
	private String _annotations;
	private long _smartActiveBenefitValueId;
	private String _toc;
	private int _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}