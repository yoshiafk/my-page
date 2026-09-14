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

package com.mypage.user.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.user.service.http.MypageUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MypageUserSoap implements Serializable {

	public static MypageUserSoap toSoapModel(MypageUser model) {
		MypageUserSoap soapModel = new MypageUserSoap();

		soapModel.setMypageUserId(model.getMypageUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLiferayUserId(model.getLiferayUserId());
		soapModel.setUserPassword(model.getUserPassword());
		soapModel.setAgentFlag(model.getAgentFlag());
		soapModel.setUserParent(model.getUserParent());
		soapModel.setUserBranch(model.getUserBranch());
		soapModel.setMypageUserRoleId(model.getMypageUserRoleId());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreditStatus(model.getCreditStatus());
		soapModel.setCreditWalletId(model.getCreditWalletId());
		soapModel.setCashPayment(model.getCashPayment());
		soapModel.setPaymentMethod(model.getPaymentMethod());
		soapModel.setLoginCounter(model.getLoginCounter());
		soapModel.setLastSubmitLoginDate(model.getLastSubmitLoginDate());
		soapModel.setTempCode(model.getTempCode());
		soapModel.setTempCodeExpiryDate(model.getTempCodeExpiryDate());
		soapModel.setPhone(model.getPhone());
		soapModel.setMobilePhone(model.getMobilePhone());
		soapModel.setEmail(model.getEmail());
		soapModel.setBirthPlace(model.getBirthPlace());
		soapModel.setDob(model.getDob());
		soapModel.setIdNumber(model.getIdNumber());
		soapModel.setAddress(model.getAddress());
		soapModel.setZip(model.getZip());
		soapModel.setGender(model.getGender());
		soapModel.setCountry(model.getCountry());
		soapModel.setProvince(model.getProvince());
		soapModel.setCity(model.getCity());
		soapModel.setLatitude(model.getLatitude());
		soapModel.setLongitude(model.getLongitude());
		soapModel.setPositionZoom(model.getPositionZoom());
		soapModel.setCode(model.getCode());
		soapModel.setBranch(model.getBranch());
		soapModel.setPromoCode(model.getPromoCode());
		soapModel.setAgsPromoCode(model.getAgsPromoCode());
		soapModel.setDeptoreCode(model.getDeptoreCode());
		soapModel.setClub(model.getClub());
		soapModel.setLeader(model.getLeader());
		soapModel.setStatusAgent(model.getStatusAgent());
		soapModel.setLicenseNumber(model.getLicenseNumber());
		soapModel.setJoinDate(model.getJoinDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setPrettyUrl(model.getPrettyUrl());
		soapModel.setPrettyUrlChange(model.getPrettyUrlChange());
		soapModel.setTaxRate(model.getTaxRate());
		soapModel.setVisitedCount(model.getVisitedCount());
		soapModel.setIsPartnership(model.getIsPartnership());
		soapModel.setPartnershipName(model.getPartnershipName());
		soapModel.setDefCommPartnerMV(model.getDefCommPartnerMV());
		soapModel.setDefCommPartnerEH(model.getDefCommPartnerEH());
		soapModel.setDefCommPartnerDT(model.getDefCommPartnerDT());
		soapModel.setDefCommPartnerIT(model.getDefCommPartnerIT());
		soapModel.setDefCommPartnerSME(model.getDefCommPartnerSME());
		soapModel.setDefCommPartnerProperty(model.getDefCommPartnerProperty());
		soapModel.setDefCommPartnerPet(model.getDefCommPartnerPet());
		soapModel.setDefCommPartnerPA(model.getDefCommPartnerPA());
		soapModel.setDefCommPartnerGP(model.getDefCommPartnerGP());
		soapModel.setBannerImageURL(model.getBannerImageURL());
		soapModel.setBannerImageFileEntryId(model.getBannerImageFileEntryId());
		soapModel.setProfileImageURL(model.getProfileImageURL());
		soapModel.setProfileImageFileEntryId(
			model.getProfileImageFileEntryId());
		soapModel.setMyTitle(model.getMyTitle());
		soapModel.setMyVideo(model.getMyVideo());
		soapModel.setAboutMe(model.getAboutMe());
		soapModel.setFacebook(model.getFacebook());
		soapModel.setTiktok(model.getTiktok());
		soapModel.setInstagram(model.getInstagram());
		soapModel.setTwitter(model.getTwitter());
		soapModel.setLinkedIn(model.getLinkedIn());
		soapModel.setBlog(model.getBlog());
		soapModel.setWhatsapp(model.getWhatsapp());
		soapModel.setSkype(model.getSkype());
		soapModel.setIs24Hours(model.getIs24Hours());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static MypageUserSoap[] toSoapModels(MypageUser[] models) {
		MypageUserSoap[] soapModels = new MypageUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MypageUserSoap[][] toSoapModels(MypageUser[][] models) {
		MypageUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MypageUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MypageUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MypageUserSoap[] toSoapModels(List<MypageUser> models) {
		List<MypageUserSoap> soapModels = new ArrayList<MypageUserSoap>(
			models.size());

		for (MypageUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MypageUserSoap[soapModels.size()]);
	}

	public MypageUserSoap() {
	}

	public long getPrimaryKey() {
		return _mypageUserId;
	}

	public void setPrimaryKey(long pk) {
		setMypageUserId(pk);
	}

	public long getMypageUserId() {
		return _mypageUserId;
	}

	public void setMypageUserId(long mypageUserId) {
		_mypageUserId = mypageUserId;
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

	public long getLiferayUserId() {
		return _liferayUserId;
	}

	public void setLiferayUserId(long liferayUserId) {
		_liferayUserId = liferayUserId;
	}

	public String getUserPassword() {
		return _userPassword;
	}

	public void setUserPassword(String userPassword) {
		_userPassword = userPassword;
	}

	public String getAgentFlag() {
		return _agentFlag;
	}

	public void setAgentFlag(String agentFlag) {
		_agentFlag = agentFlag;
	}

	public long getUserParent() {
		return _userParent;
	}

	public void setUserParent(long userParent) {
		_userParent = userParent;
	}

	public long getUserBranch() {
		return _userBranch;
	}

	public void setUserBranch(long userBranch) {
		_userBranch = userBranch;
	}

	public long getMypageUserRoleId() {
		return _mypageUserRoleId;
	}

	public void setMypageUserRoleId(long mypageUserRoleId) {
		_mypageUserRoleId = mypageUserRoleId;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getCreditStatus() {
		return _creditStatus;
	}

	public void setCreditStatus(String creditStatus) {
		_creditStatus = creditStatus;
	}

	public long getCreditWalletId() {
		return _creditWalletId;
	}

	public void setCreditWalletId(long creditWalletId) {
		_creditWalletId = creditWalletId;
	}

	public int getCashPayment() {
		return _cashPayment;
	}

	public void setCashPayment(int cashPayment) {
		_cashPayment = cashPayment;
	}

	public String getPaymentMethod() {
		return _paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		_paymentMethod = paymentMethod;
	}

	public int getLoginCounter() {
		return _loginCounter;
	}

	public void setLoginCounter(int loginCounter) {
		_loginCounter = loginCounter;
	}

	public Date getLastSubmitLoginDate() {
		return _lastSubmitLoginDate;
	}

	public void setLastSubmitLoginDate(Date lastSubmitLoginDate) {
		_lastSubmitLoginDate = lastSubmitLoginDate;
	}

	public String getTempCode() {
		return _TempCode;
	}

	public void setTempCode(String TempCode) {
		_TempCode = TempCode;
	}

	public Date getTempCodeExpiryDate() {
		return _TempCodeExpiryDate;
	}

	public void setTempCodeExpiryDate(Date TempCodeExpiryDate) {
		_TempCodeExpiryDate = TempCodeExpiryDate;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getMobilePhone() {
		return _mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		_mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getBirthPlace() {
		return _birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		_birthPlace = birthPlace;
	}

	public Date getDob() {
		return _dob;
	}

	public void setDob(Date dob) {
		_dob = dob;
	}

	public String getIdNumber() {
		return _idNumber;
	}

	public void setIdNumber(String idNumber) {
		_idNumber = idNumber;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getZip() {
		return _zip;
	}

	public void setZip(String zip) {
		_zip = zip;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public long getCountry() {
		return _country;
	}

	public void setCountry(long country) {
		_country = country;
	}

	public long getProvince() {
		return _province;
	}

	public void setProvince(long province) {
		_province = province;
	}

	public long getCity() {
		return _city;
	}

	public void setCity(long city) {
		_city = city;
	}

	public String getLatitude() {
		return _latitude;
	}

	public void setLatitude(String latitude) {
		_latitude = latitude;
	}

	public String getLongitude() {
		return _longitude;
	}

	public void setLongitude(String longitude) {
		_longitude = longitude;
	}

	public int getPositionZoom() {
		return _positionZoom;
	}

	public void setPositionZoom(int positionZoom) {
		_positionZoom = positionZoom;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public long getBranch() {
		return _branch;
	}

	public void setBranch(long branch) {
		_branch = branch;
	}

	public String getPromoCode() {
		return _promoCode;
	}

	public void setPromoCode(String promoCode) {
		_promoCode = promoCode;
	}

	public String getAgsPromoCode() {
		return _agsPromoCode;
	}

	public void setAgsPromoCode(String agsPromoCode) {
		_agsPromoCode = agsPromoCode;
	}

	public String getDeptoreCode() {
		return _deptoreCode;
	}

	public void setDeptoreCode(String deptoreCode) {
		_deptoreCode = deptoreCode;
	}

	public String getClub() {
		return _club;
	}

	public void setClub(String club) {
		_club = club;
	}

	public long getLeader() {
		return _leader;
	}

	public void setLeader(long leader) {
		_leader = leader;
	}

	public String getStatusAgent() {
		return _statusAgent;
	}

	public void setStatusAgent(String statusAgent) {
		_statusAgent = statusAgent;
	}

	public String getLicenseNumber() {
		return _licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		_licenseNumber = licenseNumber;
	}

	public Date getJoinDate() {
		return _joinDate;
	}

	public void setJoinDate(Date joinDate) {
		_joinDate = joinDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public String getPrettyUrl() {
		return _prettyUrl;
	}

	public void setPrettyUrl(String prettyUrl) {
		_prettyUrl = prettyUrl;
	}

	public int getPrettyUrlChange() {
		return _prettyUrlChange;
	}

	public void setPrettyUrlChange(int prettyUrlChange) {
		_prettyUrlChange = prettyUrlChange;
	}

	public double getTaxRate() {
		return _taxRate;
	}

	public void setTaxRate(double taxRate) {
		_taxRate = taxRate;
	}

	public int getVisitedCount() {
		return _visitedCount;
	}

	public void setVisitedCount(int visitedCount) {
		_visitedCount = visitedCount;
	}

	public int getIsPartnership() {
		return _isPartnership;
	}

	public void setIsPartnership(int isPartnership) {
		_isPartnership = isPartnership;
	}

	public String getPartnershipName() {
		return _partnershipName;
	}

	public void setPartnershipName(String partnershipName) {
		_partnershipName = partnershipName;
	}

	public double getDefCommPartnerMV() {
		return _defCommPartnerMV;
	}

	public void setDefCommPartnerMV(double defCommPartnerMV) {
		_defCommPartnerMV = defCommPartnerMV;
	}

	public double getDefCommPartnerEH() {
		return _defCommPartnerEH;
	}

	public void setDefCommPartnerEH(double defCommPartnerEH) {
		_defCommPartnerEH = defCommPartnerEH;
	}

	public double getDefCommPartnerDT() {
		return _defCommPartnerDT;
	}

	public void setDefCommPartnerDT(double defCommPartnerDT) {
		_defCommPartnerDT = defCommPartnerDT;
	}

	public double getDefCommPartnerIT() {
		return _defCommPartnerIT;
	}

	public void setDefCommPartnerIT(double defCommPartnerIT) {
		_defCommPartnerIT = defCommPartnerIT;
	}

	public double getDefCommPartnerSME() {
		return _defCommPartnerSME;
	}

	public void setDefCommPartnerSME(double defCommPartnerSME) {
		_defCommPartnerSME = defCommPartnerSME;
	}

	public double getDefCommPartnerProperty() {
		return _defCommPartnerProperty;
	}

	public void setDefCommPartnerProperty(double defCommPartnerProperty) {
		_defCommPartnerProperty = defCommPartnerProperty;
	}

	public double getDefCommPartnerPet() {
		return _defCommPartnerPet;
	}

	public void setDefCommPartnerPet(double defCommPartnerPet) {
		_defCommPartnerPet = defCommPartnerPet;
	}

	public double getDefCommPartnerPA() {
		return _defCommPartnerPA;
	}

	public void setDefCommPartnerPA(double defCommPartnerPA) {
		_defCommPartnerPA = defCommPartnerPA;
	}

	public double getDefCommPartnerGP() {
		return _defCommPartnerGP;
	}

	public void setDefCommPartnerGP(double defCommPartnerGP) {
		_defCommPartnerGP = defCommPartnerGP;
	}

	public String getBannerImageURL() {
		return _bannerImageURL;
	}

	public void setBannerImageURL(String bannerImageURL) {
		_bannerImageURL = bannerImageURL;
	}

	public Long getBannerImageFileEntryId() {
		return _bannerImageFileEntryId;
	}

	public void setBannerImageFileEntryId(Long bannerImageFileEntryId) {
		_bannerImageFileEntryId = bannerImageFileEntryId;
	}

	public String getProfileImageURL() {
		return _profileImageURL;
	}

	public void setProfileImageURL(String profileImageURL) {
		_profileImageURL = profileImageURL;
	}

	public Long getProfileImageFileEntryId() {
		return _profileImageFileEntryId;
	}

	public void setProfileImageFileEntryId(Long profileImageFileEntryId) {
		_profileImageFileEntryId = profileImageFileEntryId;
	}

	public String getMyTitle() {
		return _myTitle;
	}

	public void setMyTitle(String myTitle) {
		_myTitle = myTitle;
	}

	public String getMyVideo() {
		return _myVideo;
	}

	public void setMyVideo(String myVideo) {
		_myVideo = myVideo;
	}

	public String getAboutMe() {
		return _aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		_aboutMe = aboutMe;
	}

	public String getFacebook() {
		return _facebook;
	}

	public void setFacebook(String facebook) {
		_facebook = facebook;
	}

	public String getTiktok() {
		return _tiktok;
	}

	public void setTiktok(String tiktok) {
		_tiktok = tiktok;
	}

	public String getInstagram() {
		return _instagram;
	}

	public void setInstagram(String instagram) {
		_instagram = instagram;
	}

	public String getTwitter() {
		return _twitter;
	}

	public void setTwitter(String twitter) {
		_twitter = twitter;
	}

	public String getLinkedIn() {
		return _linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		_linkedIn = linkedIn;
	}

	public String getBlog() {
		return _blog;
	}

	public void setBlog(String blog) {
		_blog = blog;
	}

	public String getWhatsapp() {
		return _whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		_whatsapp = whatsapp;
	}

	public String getSkype() {
		return _skype;
	}

	public void setSkype(String skype) {
		_skype = skype;
	}

	public int getIs24Hours() {
		return _is24Hours;
	}

	public void setIs24Hours(int is24Hours) {
		_is24Hours = is24Hours;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
	}

	private long _mypageUserId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _liferayUserId;
	private String _userPassword;
	private String _agentFlag;
	private long _userParent;
	private long _userBranch;
	private long _mypageUserRoleId;
	private String _status;
	private String _creditStatus;
	private long _creditWalletId;
	private int _cashPayment;
	private String _paymentMethod;
	private int _loginCounter;
	private Date _lastSubmitLoginDate;
	private String _TempCode;
	private Date _TempCodeExpiryDate;
	private String _phone;
	private String _mobilePhone;
	private String _email;
	private String _birthPlace;
	private Date _dob;
	private String _idNumber;
	private String _address;
	private String _zip;
	private String _gender;
	private long _country;
	private long _province;
	private long _city;
	private String _latitude;
	private String _longitude;
	private int _positionZoom;
	private String _code;
	private long _branch;
	private String _promoCode;
	private String _agsPromoCode;
	private String _deptoreCode;
	private String _club;
	private long _leader;
	private String _statusAgent;
	private String _licenseNumber;
	private Date _joinDate;
	private Date _endDate;
	private String _prettyUrl;
	private int _prettyUrlChange;
	private double _taxRate;
	private int _visitedCount;
	private int _isPartnership;
	private String _partnershipName;
	private double _defCommPartnerMV;
	private double _defCommPartnerEH;
	private double _defCommPartnerDT;
	private double _defCommPartnerIT;
	private double _defCommPartnerSME;
	private double _defCommPartnerProperty;
	private double _defCommPartnerPet;
	private double _defCommPartnerPA;
	private double _defCommPartnerGP;
	private String _bannerImageURL;
	private Long _bannerImageFileEntryId;
	private String _profileImageURL;
	private Long _profileImageFileEntryId;
	private String _myTitle;
	private String _myVideo;
	private String _aboutMe;
	private String _facebook;
	private String _tiktok;
	private String _instagram;
	private String _twitter;
	private String _linkedIn;
	private String _blog;
	private String _whatsapp;
	private String _skype;
	private int _is24Hours;
	private int _active;

}