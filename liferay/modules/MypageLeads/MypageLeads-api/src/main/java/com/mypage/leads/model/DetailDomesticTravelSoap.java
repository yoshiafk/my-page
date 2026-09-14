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
 * This class is used by SOAP remote services, specifically {@link com.mypage.leads.service.http.DetailDomesticTravelServiceSoap}.
 *
 * @author Gositus
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DetailDomesticTravelSoap implements Serializable {

	public static DetailDomesticTravelSoap toSoapModel(
		DetailDomesticTravel model) {

		DetailDomesticTravelSoap soapModel = new DetailDomesticTravelSoap();

		soapModel.setDetailDomesticTravelId(model.getDetailDomesticTravelId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLeadsId(model.getLeadsId());
		soapModel.setTravelType(model.getTravelType());
		soapModel.setTravelPlan(model.getTravelPlan());
		soapModel.setTravellerType(model.getTravellerType());
		soapModel.setAdult(model.getAdult());
		soapModel.setChild(model.getChild());
		soapModel.setDepartureDate(model.getDepartureDate());
		soapModel.setArrivalDate(model.getArrivalDate());
		soapModel.setCommercialOffers(model.getCommercialOffers());

		return soapModel;
	}

	public static DetailDomesticTravelSoap[] toSoapModels(
		DetailDomesticTravel[] models) {

		DetailDomesticTravelSoap[] soapModels =
			new DetailDomesticTravelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DetailDomesticTravelSoap[][] toSoapModels(
		DetailDomesticTravel[][] models) {

		DetailDomesticTravelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DetailDomesticTravelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DetailDomesticTravelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DetailDomesticTravelSoap[] toSoapModels(
		List<DetailDomesticTravel> models) {

		List<DetailDomesticTravelSoap> soapModels =
			new ArrayList<DetailDomesticTravelSoap>(models.size());

		for (DetailDomesticTravel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new DetailDomesticTravelSoap[soapModels.size()]);
	}

	public DetailDomesticTravelSoap() {
	}

	public long getPrimaryKey() {
		return _detailDomesticTravelId;
	}

	public void setPrimaryKey(long pk) {
		setDetailDomesticTravelId(pk);
	}

	public long getDetailDomesticTravelId() {
		return _detailDomesticTravelId;
	}

	public void setDetailDomesticTravelId(long detailDomesticTravelId) {
		_detailDomesticTravelId = detailDomesticTravelId;
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

	public String getTravelType() {
		return _TravelType;
	}

	public void setTravelType(String TravelType) {
		_TravelType = TravelType;
	}

	public String getTravelPlan() {
		return _TravelPlan;
	}

	public void setTravelPlan(String TravelPlan) {
		_TravelPlan = TravelPlan;
	}

	public String getTravellerType() {
		return _TravellerType;
	}

	public void setTravellerType(String TravellerType) {
		_TravellerType = TravellerType;
	}

	public Integer getAdult() {
		return _Adult;
	}

	public void setAdult(Integer Adult) {
		_Adult = Adult;
	}

	public Integer getChild() {
		return _Child;
	}

	public void setChild(Integer Child) {
		_Child = Child;
	}

	public Date getDepartureDate() {
		return _DepartureDate;
	}

	public void setDepartureDate(Date DepartureDate) {
		_DepartureDate = DepartureDate;
	}

	public Date getArrivalDate() {
		return _ArrivalDate;
	}

	public void setArrivalDate(Date ArrivalDate) {
		_ArrivalDate = ArrivalDate;
	}

	public Integer getCommercialOffers() {
		return _CommercialOffers;
	}

	public void setCommercialOffers(Integer CommercialOffers) {
		_CommercialOffers = CommercialOffers;
	}

	private long _detailDomesticTravelId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _LeadsId;
	private String _TravelType;
	private String _TravelPlan;
	private String _TravellerType;
	private Integer _Adult;
	private Integer _Child;
	private Date _DepartureDate;
	private Date _ArrivalDate;
	private Integer _CommercialOffers;

}