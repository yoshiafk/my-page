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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.SmartTravelIntLinkServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SmartTravelIntLinkSoap implements Serializable {

	public static SmartTravelIntLinkSoap toSoapModel(SmartTravelIntLink model) {
		SmartTravelIntLinkSoap soapModel = new SmartTravelIntLinkSoap();

		soapModel.setSmartTravelIntLinkId(model.getSmartTravelIntLinkId());
		soapModel.setLinkType(model.getLinkType());
		soapModel.setLinkTitle(model.getLinkTitle());
		soapModel.setLinkHref(model.getLinkHref());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SmartTravelIntLinkSoap[] toSoapModels(
		SmartTravelIntLink[] models) {

		SmartTravelIntLinkSoap[] soapModels =
			new SmartTravelIntLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SmartTravelIntLinkSoap[][] toSoapModels(
		SmartTravelIntLink[][] models) {

		SmartTravelIntLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new SmartTravelIntLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SmartTravelIntLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SmartTravelIntLinkSoap[] toSoapModels(
		List<SmartTravelIntLink> models) {

		List<SmartTravelIntLinkSoap> soapModels =
			new ArrayList<SmartTravelIntLinkSoap>(models.size());

		for (SmartTravelIntLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new SmartTravelIntLinkSoap[soapModels.size()]);
	}

	public SmartTravelIntLinkSoap() {
	}

	public long getPrimaryKey() {
		return _smartTravelIntLinkId;
	}

	public void setPrimaryKey(long pk) {
		setSmartTravelIntLinkId(pk);
	}

	public long getSmartTravelIntLinkId() {
		return _smartTravelIntLinkId;
	}

	public void setSmartTravelIntLinkId(long smartTravelIntLinkId) {
		_smartTravelIntLinkId = smartTravelIntLinkId;
	}

	public String getLinkType() {
		return _linkType;
	}

	public void setLinkType(String linkType) {
		_linkType = linkType;
	}

	public String getLinkTitle() {
		return _linkTitle;
	}

	public void setLinkTitle(String linkTitle) {
		_linkTitle = linkTitle;
	}

	public String getLinkHref() {
		return _linkHref;
	}

	public void setLinkHref(String linkHref) {
		_linkHref = linkHref;
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

	private long _smartTravelIntLinkId;
	private String _linkType;
	private String _linkTitle;
	private String _linkHref;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}