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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.PromocodesServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PromocodesSoap implements Serializable {

	public static PromocodesSoap toSoapModel(Promocodes model) {
		PromocodesSoap soapModel = new PromocodesSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPromocodeId(model.getPromocodeId());
		soapModel.setProducts(model.getProducts());
		soapModel.setPromocode(model.getPromocode());
		soapModel.setCommission(model.getCommission());
		soapModel.setDiscount(model.getDiscount());
		soapModel.setIsB2C(model.getIsB2C());
		soapModel.setIsB2B2C(model.getIsB2B2C());
		soapModel.setIsB2B(model.getIsB2B());
		soapModel.setUser(model.getUser());
		soapModel.setMypageUserId(model.getMypageUserId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setPromoType(model.getPromoType());
		soapModel.setBirthdayMonth(model.getBirthdayMonth());
		soapModel.setLimit(model.getLimit());
		soapModel.setTerms(model.getTerms());
		soapModel.setPlan(model.getPlan());
		soapModel.setPaymentChannel(model.getPaymentChannel());
		soapModel.setUtmCampaignId(model.getUtmCampaignId());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static PromocodesSoap[] toSoapModels(Promocodes[] models) {
		PromocodesSoap[] soapModels = new PromocodesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PromocodesSoap[][] toSoapModels(Promocodes[][] models) {
		PromocodesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PromocodesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PromocodesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PromocodesSoap[] toSoapModels(List<Promocodes> models) {
		List<PromocodesSoap> soapModels = new ArrayList<PromocodesSoap>(
			models.size());

		for (Promocodes model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PromocodesSoap[soapModels.size()]);
	}

	public PromocodesSoap() {
	}

	public long getPrimaryKey() {
		return _promocodeId;
	}

	public void setPrimaryKey(long pk) {
		setPromocodeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPromocodeId() {
		return _promocodeId;
	}

	public void setPromocodeId(long promocodeId) {
		_promocodeId = promocodeId;
	}

	public String getProducts() {
		return _products;
	}

	public void setProducts(String products) {
		_products = products;
	}

	public String getPromocode() {
		return _promocode;
	}

	public void setPromocode(String promocode) {
		_promocode = promocode;
	}

	public double getCommission() {
		return _commission;
	}

	public void setCommission(double commission) {
		_commission = commission;
	}

	public double getDiscount() {
		return _discount;
	}

	public void setDiscount(double discount) {
		_discount = discount;
	}

	public int getIsB2C() {
		return _isB2C;
	}

	public void setIsB2C(int isB2C) {
		_isB2C = isB2C;
	}

	public int getIsB2B2C() {
		return _isB2B2C;
	}

	public void setIsB2B2C(int isB2B2C) {
		_isB2B2C = isB2B2C;
	}

	public int getIsB2B() {
		return _isB2B;
	}

	public void setIsB2B(int isB2B) {
		_isB2B = isB2B;
	}

	public String getUser() {
		return _user;
	}

	public void setUser(String user) {
		_user = user;
	}

	public long getMypageUserId() {
		return _mypageUserId;
	}

	public void setMypageUserId(long mypageUserId) {
		_mypageUserId = mypageUserId;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public String getPromoType() {
		return _promoType;
	}

	public void setPromoType(String promoType) {
		_promoType = promoType;
	}

	public Date getBirthdayMonth() {
		return _birthdayMonth;
	}

	public void setBirthdayMonth(Date birthdayMonth) {
		_birthdayMonth = birthdayMonth;
	}

	public int getLimit() {
		return _limit;
	}

	public void setLimit(int limit) {
		_limit = limit;
	}

	public String getTerms() {
		return _terms;
	}

	public void setTerms(String terms) {
		_terms = terms;
	}

	public String getPlan() {
		return _plan;
	}

	public void setPlan(String plan) {
		_plan = plan;
	}

	public String getPaymentChannel() {
		return _paymentChannel;
	}

	public void setPaymentChannel(String paymentChannel) {
		_paymentChannel = paymentChannel;
	}

	public String getUtmCampaignId() {
		return _utmCampaignId;
	}

	public void setUtmCampaignId(String utmCampaignId) {
		_utmCampaignId = utmCampaignId;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	private String _uuid;
	private long _promocodeId;
	private String _products;
	private String _promocode;
	private double _commission;
	private double _discount;
	private int _isB2C;
	private int _isB2B2C;
	private int _isB2B;
	private String _user;
	private long _mypageUserId;
	private Date _startDate;
	private Date _endDate;
	private String _promoType;
	private Date _birthdayMonth;
	private int _limit;
	private String _terms;
	private String _plan;
	private String _paymentChannel;
	private String _utmCampaignId;
	private int _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;

}