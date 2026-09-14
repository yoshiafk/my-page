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
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.MasterPromoCodeServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MasterPromoCodeSoap implements Serializable {

	public static MasterPromoCodeSoap toSoapModel(MasterPromoCode model) {
		MasterPromoCodeSoap soapModel = new MasterPromoCodeSoap();

		soapModel.setPromoCodeId(model.getPromoCodeId());
		soapModel.setIsDefault(model.getIsDefault());
		soapModel.setProductCode(model.getProductCode());
		soapModel.setProductName(model.getProductName());
		soapModel.setPromoType(model.getPromoType());
		soapModel.setPromoCode(model.getPromoCode());
		soapModel.setDiscount(model.getDiscount());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setActiveDay(model.getActiveDay());
		soapModel.setLimit(model.getLimit());
		soapModel.setNetwork(model.getNetwork());
		soapModel.setChannel(model.getChannel());
		soapModel.setIsB2C(model.getIsB2C());
		soapModel.setIsB2B2C(model.getIsB2B2C());
		soapModel.setIsB2B(model.getIsB2B());
		soapModel.setPayment(model.getPayment());
		soapModel.setBirthdayMonth(model.getBirthdayMonth());
		soapModel.setRemarks(model.getRemarks());
		soapModel.setMypageUserId(model.getMypageUserId());
		soapModel.setAgentName(model.getAgentName());
		soapModel.setDeptoreCode(model.getDeptoreCode());
		soapModel.setCommission(model.getCommission());
		soapModel.setPlan_(model.getPlan_());
		soapModel.setPromoCodeTerms(model.getPromoCodeTerms());
		soapModel.setTravellerType(model.getTravellerType());
		soapModel.setUtmId(model.getUtmId());
		soapModel.setPaymentChannelId(model.getPaymentChannelId());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static MasterPromoCodeSoap[] toSoapModels(MasterPromoCode[] models) {
		MasterPromoCodeSoap[] soapModels =
			new MasterPromoCodeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MasterPromoCodeSoap[][] toSoapModels(
		MasterPromoCode[][] models) {

		MasterPromoCodeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new MasterPromoCodeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MasterPromoCodeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MasterPromoCodeSoap[] toSoapModels(
		List<MasterPromoCode> models) {

		List<MasterPromoCodeSoap> soapModels =
			new ArrayList<MasterPromoCodeSoap>(models.size());

		for (MasterPromoCode model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MasterPromoCodeSoap[soapModels.size()]);
	}

	public MasterPromoCodeSoap() {
	}

	public long getPrimaryKey() {
		return _promoCodeId;
	}

	public void setPrimaryKey(long pk) {
		setPromoCodeId(pk);
	}

	public long getPromoCodeId() {
		return _promoCodeId;
	}

	public void setPromoCodeId(long promoCodeId) {
		_promoCodeId = promoCodeId;
	}

	public int getIsDefault() {
		return _isDefault;
	}

	public void setIsDefault(int isDefault) {
		_isDefault = isDefault;
	}

	public String getProductCode() {
		return _productCode;
	}

	public void setProductCode(String productCode) {
		_productCode = productCode;
	}

	public String getProductName() {
		return _productName;
	}

	public void setProductName(String productName) {
		_productName = productName;
	}

	public String getPromoType() {
		return _promoType;
	}

	public void setPromoType(String promoType) {
		_promoType = promoType;
	}

	public String getPromoCode() {
		return _promoCode;
	}

	public void setPromoCode(String promoCode) {
		_promoCode = promoCode;
	}

	public double getDiscount() {
		return _discount;
	}

	public void setDiscount(double discount) {
		_discount = discount;
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

	public String getActiveDay() {
		return _activeDay;
	}

	public void setActiveDay(String activeDay) {
		_activeDay = activeDay;
	}

	public String getLimit() {
		return _limit;
	}

	public void setLimit(String limit) {
		_limit = limit;
	}

	public String getNetwork() {
		return _network;
	}

	public void setNetwork(String network) {
		_network = network;
	}

	public String getChannel() {
		return _channel;
	}

	public void setChannel(String channel) {
		_channel = channel;
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

	public String getPayment() {
		return _payment;
	}

	public void setPayment(String payment) {
		_payment = payment;
	}

	public String getBirthdayMonth() {
		return _birthdayMonth;
	}

	public void setBirthdayMonth(String birthdayMonth) {
		_birthdayMonth = birthdayMonth;
	}

	public String getRemarks() {
		return _remarks;
	}

	public void setRemarks(String remarks) {
		_remarks = remarks;
	}

	public long getMypageUserId() {
		return _mypageUserId;
	}

	public void setMypageUserId(long mypageUserId) {
		_mypageUserId = mypageUserId;
	}

	public String getAgentName() {
		return _agentName;
	}

	public void setAgentName(String agentName) {
		_agentName = agentName;
	}

	public String getDeptoreCode() {
		return _deptoreCode;
	}

	public void setDeptoreCode(String deptoreCode) {
		_deptoreCode = deptoreCode;
	}

	public String getCommission() {
		return _commission;
	}

	public void setCommission(String commission) {
		_commission = commission;
	}

	public String getPlan_() {
		return _plan_;
	}

	public void setPlan_(String plan_) {
		_plan_ = plan_;
	}

	public String getPromoCodeTerms() {
		return _promoCodeTerms;
	}

	public void setPromoCodeTerms(String promoCodeTerms) {
		_promoCodeTerms = promoCodeTerms;
	}

	public String getTravellerType() {
		return _travellerType;
	}

	public void setTravellerType(String travellerType) {
		_travellerType = travellerType;
	}

	public String getUtmId() {
		return _utmId;
	}

	public void setUtmId(String utmId) {
		_utmId = utmId;
	}

	public String getPaymentChannelId() {
		return _paymentChannelId;
	}

	public void setPaymentChannelId(String paymentChannelId) {
		_paymentChannelId = paymentChannelId;
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

	private long _promoCodeId;
	private int _isDefault;
	private String _productCode;
	private String _productName;
	private String _promoType;
	private String _promoCode;
	private double _discount;
	private Date _startDate;
	private Date _endDate;
	private String _activeDay;
	private String _limit;
	private String _network;
	private String _channel;
	private int _isB2C;
	private int _isB2B2C;
	private int _isB2B;
	private String _payment;
	private String _birthdayMonth;
	private String _remarks;
	private long _mypageUserId;
	private String _agentName;
	private String _deptoreCode;
	private String _commission;
	private String _plan_;
	private String _promoCodeTerms;
	private String _travellerType;
	private String _utmId;
	private String _paymentChannelId;
	private int _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}