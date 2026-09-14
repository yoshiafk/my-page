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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MypageUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MypageUser
 * @generated
 */
public class MypageUserWrapper
	extends BaseModelWrapper<MypageUser>
	implements ModelWrapper<MypageUser>, MypageUser {

	public MypageUserWrapper(MypageUser mypageUser) {
		super(mypageUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mypageUserId", getMypageUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("liferayUserId", getLiferayUserId());
		attributes.put("userPassword", getUserPassword());
		attributes.put("agentFlag", getAgentFlag());
		attributes.put("userParent", getUserParent());
		attributes.put("userBranch", getUserBranch());
		attributes.put("mypageUserRoleId", getMypageUserRoleId());
		attributes.put("status", getStatus());
		attributes.put("creditStatus", getCreditStatus());
		attributes.put("creditWalletId", getCreditWalletId());
		attributes.put("cashPayment", getCashPayment());
		attributes.put("paymentMethod", getPaymentMethod());
		attributes.put("loginCounter", getLoginCounter());
		attributes.put("lastSubmitLoginDate", getLastSubmitLoginDate());
		attributes.put("TempCode", getTempCode());
		attributes.put("TempCodeExpiryDate", getTempCodeExpiryDate());
		attributes.put("phone", getPhone());
		attributes.put("mobilePhone", getMobilePhone());
		attributes.put("email", getEmail());
		attributes.put("birthPlace", getBirthPlace());
		attributes.put("dob", getDob());
		attributes.put("idNumber", getIdNumber());
		attributes.put("address", getAddress());
		attributes.put("zip", getZip());
		attributes.put("gender", getGender());
		attributes.put("country", getCountry());
		attributes.put("province", getProvince());
		attributes.put("city", getCity());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("positionZoom", getPositionZoom());
		attributes.put("code", getCode());
		attributes.put("branch", getBranch());
		attributes.put("promoCode", getPromoCode());
		attributes.put("agsPromoCode", getAgsPromoCode());
		attributes.put("deptoreCode", getDeptoreCode());
		attributes.put("club", getClub());
		attributes.put("leader", getLeader());
		attributes.put("statusAgent", getStatusAgent());
		attributes.put("licenseNumber", getLicenseNumber());
		attributes.put("joinDate", getJoinDate());
		attributes.put("endDate", getEndDate());
		attributes.put("prettyUrl", getPrettyUrl());
		attributes.put("prettyUrlChange", getPrettyUrlChange());
		attributes.put("taxRate", getTaxRate());
		attributes.put("visitedCount", getVisitedCount());
		attributes.put("isPartnership", getIsPartnership());
		attributes.put("partnershipName", getPartnershipName());
		attributes.put("defCommPartnerMV", getDefCommPartnerMV());
		attributes.put("defCommPartnerEH", getDefCommPartnerEH());
		attributes.put("defCommPartnerDT", getDefCommPartnerDT());
		attributes.put("defCommPartnerIT", getDefCommPartnerIT());
		attributes.put("defCommPartnerSME", getDefCommPartnerSME());
		attributes.put("defCommPartnerProperty", getDefCommPartnerProperty());
		attributes.put("defCommPartnerPet", getDefCommPartnerPet());
		attributes.put("defCommPartnerPA", getDefCommPartnerPA());
		attributes.put("defCommPartnerGP", getDefCommPartnerGP());
		attributes.put("bannerImageURL", getBannerImageURL());
		attributes.put("bannerImageFileEntryId", getBannerImageFileEntryId());
		attributes.put("profileImageURL", getProfileImageURL());
		attributes.put("profileImageFileEntryId", getProfileImageFileEntryId());
		attributes.put("myTitle", getMyTitle());
		attributes.put("myVideo", getMyVideo());
		attributes.put("aboutMe", getAboutMe());
		attributes.put("facebook", getFacebook());
		attributes.put("tiktok", getTiktok());
		attributes.put("instagram", getInstagram());
		attributes.put("twitter", getTwitter());
		attributes.put("linkedIn", getLinkedIn());
		attributes.put("blog", getBlog());
		attributes.put("whatsapp", getWhatsapp());
		attributes.put("skype", getSkype());
		attributes.put("is24Hours", getIs24Hours());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mypageUserId = (Long)attributes.get("mypageUserId");

		if (mypageUserId != null) {
			setMypageUserId(mypageUserId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long liferayUserId = (Long)attributes.get("liferayUserId");

		if (liferayUserId != null) {
			setLiferayUserId(liferayUserId);
		}

		String userPassword = (String)attributes.get("userPassword");

		if (userPassword != null) {
			setUserPassword(userPassword);
		}

		String agentFlag = (String)attributes.get("agentFlag");

		if (agentFlag != null) {
			setAgentFlag(agentFlag);
		}

		Long userParent = (Long)attributes.get("userParent");

		if (userParent != null) {
			setUserParent(userParent);
		}

		Long userBranch = (Long)attributes.get("userBranch");

		if (userBranch != null) {
			setUserBranch(userBranch);
		}

		Long mypageUserRoleId = (Long)attributes.get("mypageUserRoleId");

		if (mypageUserRoleId != null) {
			setMypageUserRoleId(mypageUserRoleId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String creditStatus = (String)attributes.get("creditStatus");

		if (creditStatus != null) {
			setCreditStatus(creditStatus);
		}

		Long creditWalletId = (Long)attributes.get("creditWalletId");

		if (creditWalletId != null) {
			setCreditWalletId(creditWalletId);
		}

		Integer cashPayment = (Integer)attributes.get("cashPayment");

		if (cashPayment != null) {
			setCashPayment(cashPayment);
		}

		String paymentMethod = (String)attributes.get("paymentMethod");

		if (paymentMethod != null) {
			setPaymentMethod(paymentMethod);
		}

		Integer loginCounter = (Integer)attributes.get("loginCounter");

		if (loginCounter != null) {
			setLoginCounter(loginCounter);
		}

		Date lastSubmitLoginDate = (Date)attributes.get("lastSubmitLoginDate");

		if (lastSubmitLoginDate != null) {
			setLastSubmitLoginDate(lastSubmitLoginDate);
		}

		String TempCode = (String)attributes.get("TempCode");

		if (TempCode != null) {
			setTempCode(TempCode);
		}

		Date TempCodeExpiryDate = (Date)attributes.get("TempCodeExpiryDate");

		if (TempCodeExpiryDate != null) {
			setTempCodeExpiryDate(TempCodeExpiryDate);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String mobilePhone = (String)attributes.get("mobilePhone");

		if (mobilePhone != null) {
			setMobilePhone(mobilePhone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String birthPlace = (String)attributes.get("birthPlace");

		if (birthPlace != null) {
			setBirthPlace(birthPlace);
		}

		Date dob = (Date)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}

		String idNumber = (String)attributes.get("idNumber");

		if (idNumber != null) {
			setIdNumber(idNumber);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String zip = (String)attributes.get("zip");

		if (zip != null) {
			setZip(zip);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Long country = (Long)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		Long province = (Long)attributes.get("province");

		if (province != null) {
			setProvince(province);
		}

		Long city = (Long)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		Integer positionZoom = (Integer)attributes.get("positionZoom");

		if (positionZoom != null) {
			setPositionZoom(positionZoom);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Long branch = (Long)attributes.get("branch");

		if (branch != null) {
			setBranch(branch);
		}

		String promoCode = (String)attributes.get("promoCode");

		if (promoCode != null) {
			setPromoCode(promoCode);
		}

		String agsPromoCode = (String)attributes.get("agsPromoCode");

		if (agsPromoCode != null) {
			setAgsPromoCode(agsPromoCode);
		}

		String deptoreCode = (String)attributes.get("deptoreCode");

		if (deptoreCode != null) {
			setDeptoreCode(deptoreCode);
		}

		String club = (String)attributes.get("club");

		if (club != null) {
			setClub(club);
		}

		Long leader = (Long)attributes.get("leader");

		if (leader != null) {
			setLeader(leader);
		}

		String statusAgent = (String)attributes.get("statusAgent");

		if (statusAgent != null) {
			setStatusAgent(statusAgent);
		}

		String licenseNumber = (String)attributes.get("licenseNumber");

		if (licenseNumber != null) {
			setLicenseNumber(licenseNumber);
		}

		Date joinDate = (Date)attributes.get("joinDate");

		if (joinDate != null) {
			setJoinDate(joinDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String prettyUrl = (String)attributes.get("prettyUrl");

		if (prettyUrl != null) {
			setPrettyUrl(prettyUrl);
		}

		Integer prettyUrlChange = (Integer)attributes.get("prettyUrlChange");

		if (prettyUrlChange != null) {
			setPrettyUrlChange(prettyUrlChange);
		}

		Double taxRate = (Double)attributes.get("taxRate");

		if (taxRate != null) {
			setTaxRate(taxRate);
		}

		Integer visitedCount = (Integer)attributes.get("visitedCount");

		if (visitedCount != null) {
			setVisitedCount(visitedCount);
		}

		Integer isPartnership = (Integer)attributes.get("isPartnership");

		if (isPartnership != null) {
			setIsPartnership(isPartnership);
		}

		String partnershipName = (String)attributes.get("partnershipName");

		if (partnershipName != null) {
			setPartnershipName(partnershipName);
		}

		Double defCommPartnerMV = (Double)attributes.get("defCommPartnerMV");

		if (defCommPartnerMV != null) {
			setDefCommPartnerMV(defCommPartnerMV);
		}

		Double defCommPartnerEH = (Double)attributes.get("defCommPartnerEH");

		if (defCommPartnerEH != null) {
			setDefCommPartnerEH(defCommPartnerEH);
		}

		Double defCommPartnerDT = (Double)attributes.get("defCommPartnerDT");

		if (defCommPartnerDT != null) {
			setDefCommPartnerDT(defCommPartnerDT);
		}

		Double defCommPartnerIT = (Double)attributes.get("defCommPartnerIT");

		if (defCommPartnerIT != null) {
			setDefCommPartnerIT(defCommPartnerIT);
		}

		Double defCommPartnerSME = (Double)attributes.get("defCommPartnerSME");

		if (defCommPartnerSME != null) {
			setDefCommPartnerSME(defCommPartnerSME);
		}

		Double defCommPartnerProperty = (Double)attributes.get(
			"defCommPartnerProperty");

		if (defCommPartnerProperty != null) {
			setDefCommPartnerProperty(defCommPartnerProperty);
		}

		Double defCommPartnerPet = (Double)attributes.get("defCommPartnerPet");

		if (defCommPartnerPet != null) {
			setDefCommPartnerPet(defCommPartnerPet);
		}

		Double defCommPartnerPA = (Double)attributes.get("defCommPartnerPA");

		if (defCommPartnerPA != null) {
			setDefCommPartnerPA(defCommPartnerPA);
		}

		Double defCommPartnerGP = (Double)attributes.get("defCommPartnerGP");

		if (defCommPartnerGP != null) {
			setDefCommPartnerGP(defCommPartnerGP);
		}

		String bannerImageURL = (String)attributes.get("bannerImageURL");

		if (bannerImageURL != null) {
			setBannerImageURL(bannerImageURL);
		}

		Long bannerImageFileEntryId = (Long)attributes.get(
			"bannerImageFileEntryId");

		if (bannerImageFileEntryId != null) {
			setBannerImageFileEntryId(bannerImageFileEntryId);
		}

		String profileImageURL = (String)attributes.get("profileImageURL");

		if (profileImageURL != null) {
			setProfileImageURL(profileImageURL);
		}

		Long profileImageFileEntryId = (Long)attributes.get(
			"profileImageFileEntryId");

		if (profileImageFileEntryId != null) {
			setProfileImageFileEntryId(profileImageFileEntryId);
		}

		String myTitle = (String)attributes.get("myTitle");

		if (myTitle != null) {
			setMyTitle(myTitle);
		}

		String myVideo = (String)attributes.get("myVideo");

		if (myVideo != null) {
			setMyVideo(myVideo);
		}

		String aboutMe = (String)attributes.get("aboutMe");

		if (aboutMe != null) {
			setAboutMe(aboutMe);
		}

		String facebook = (String)attributes.get("facebook");

		if (facebook != null) {
			setFacebook(facebook);
		}

		String tiktok = (String)attributes.get("tiktok");

		if (tiktok != null) {
			setTiktok(tiktok);
		}

		String instagram = (String)attributes.get("instagram");

		if (instagram != null) {
			setInstagram(instagram);
		}

		String twitter = (String)attributes.get("twitter");

		if (twitter != null) {
			setTwitter(twitter);
		}

		String linkedIn = (String)attributes.get("linkedIn");

		if (linkedIn != null) {
			setLinkedIn(linkedIn);
		}

		String blog = (String)attributes.get("blog");

		if (blog != null) {
			setBlog(blog);
		}

		String whatsapp = (String)attributes.get("whatsapp");

		if (whatsapp != null) {
			setWhatsapp(whatsapp);
		}

		String skype = (String)attributes.get("skype");

		if (skype != null) {
			setSkype(skype);
		}

		Integer is24Hours = (Integer)attributes.get("is24Hours");

		if (is24Hours != null) {
			setIs24Hours(is24Hours);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	 * Returns the about me of this mypage user.
	 *
	 * @return the about me of this mypage user
	 */
	@Override
	public String getAboutMe() {
		return model.getAboutMe();
	}

	/**
	 * Returns the active of this mypage user.
	 *
	 * @return the active of this mypage user
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the address of this mypage user.
	 *
	 * @return the address of this mypage user
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the agent flag of this mypage user.
	 *
	 * @return the agent flag of this mypage user
	 */
	@Override
	public String getAgentFlag() {
		return model.getAgentFlag();
	}

	/**
	 * Returns the ags promo code of this mypage user.
	 *
	 * @return the ags promo code of this mypage user
	 */
	@Override
	public String getAgsPromoCode() {
		return model.getAgsPromoCode();
	}

	/**
	 * Returns the banner image file entry ID of this mypage user.
	 *
	 * @return the banner image file entry ID of this mypage user
	 */
	@Override
	public Long getBannerImageFileEntryId() {
		return model.getBannerImageFileEntryId();
	}

	/**
	 * Returns the banner image url of this mypage user.
	 *
	 * @return the banner image url of this mypage user
	 */
	@Override
	public String getBannerImageURL() {
		return model.getBannerImageURL();
	}

	/**
	 * Returns the birth place of this mypage user.
	 *
	 * @return the birth place of this mypage user
	 */
	@Override
	public String getBirthPlace() {
		return model.getBirthPlace();
	}

	/**
	 * Returns the blog of this mypage user.
	 *
	 * @return the blog of this mypage user
	 */
	@Override
	public String getBlog() {
		return model.getBlog();
	}

	/**
	 * Returns the branch of this mypage user.
	 *
	 * @return the branch of this mypage user
	 */
	@Override
	public long getBranch() {
		return model.getBranch();
	}

	/**
	 * Returns the cash payment of this mypage user.
	 *
	 * @return the cash payment of this mypage user
	 */
	@Override
	public int getCashPayment() {
		return model.getCashPayment();
	}

	/**
	 * Returns the city of this mypage user.
	 *
	 * @return the city of this mypage user
	 */
	@Override
	public long getCity() {
		return model.getCity();
	}

	/**
	 * Returns the club of this mypage user.
	 *
	 * @return the club of this mypage user
	 */
	@Override
	public String getClub() {
		return model.getClub();
	}

	/**
	 * Returns the code of this mypage user.
	 *
	 * @return the code of this mypage user
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this mypage user.
	 *
	 * @return the company ID of this mypage user
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the country of this mypage user.
	 *
	 * @return the country of this mypage user
	 */
	@Override
	public long getCountry() {
		return model.getCountry();
	}

	/**
	 * Returns the create date of this mypage user.
	 *
	 * @return the create date of this mypage user
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the credit status of this mypage user.
	 *
	 * @return the credit status of this mypage user
	 */
	@Override
	public String getCreditStatus() {
		return model.getCreditStatus();
	}

	/**
	 * Returns the credit wallet ID of this mypage user.
	 *
	 * @return the credit wallet ID of this mypage user
	 */
	@Override
	public long getCreditWalletId() {
		return model.getCreditWalletId();
	}

	/**
	 * Returns the def comm partner dt of this mypage user.
	 *
	 * @return the def comm partner dt of this mypage user
	 */
	@Override
	public double getDefCommPartnerDT() {
		return model.getDefCommPartnerDT();
	}

	/**
	 * Returns the def comm partner eh of this mypage user.
	 *
	 * @return the def comm partner eh of this mypage user
	 */
	@Override
	public double getDefCommPartnerEH() {
		return model.getDefCommPartnerEH();
	}

	/**
	 * Returns the def comm partner gp of this mypage user.
	 *
	 * @return the def comm partner gp of this mypage user
	 */
	@Override
	public double getDefCommPartnerGP() {
		return model.getDefCommPartnerGP();
	}

	/**
	 * Returns the def comm partner it of this mypage user.
	 *
	 * @return the def comm partner it of this mypage user
	 */
	@Override
	public double getDefCommPartnerIT() {
		return model.getDefCommPartnerIT();
	}

	/**
	 * Returns the def comm partner mv of this mypage user.
	 *
	 * @return the def comm partner mv of this mypage user
	 */
	@Override
	public double getDefCommPartnerMV() {
		return model.getDefCommPartnerMV();
	}

	/**
	 * Returns the def comm partner pa of this mypage user.
	 *
	 * @return the def comm partner pa of this mypage user
	 */
	@Override
	public double getDefCommPartnerPA() {
		return model.getDefCommPartnerPA();
	}

	/**
	 * Returns the def comm partner pet of this mypage user.
	 *
	 * @return the def comm partner pet of this mypage user
	 */
	@Override
	public double getDefCommPartnerPet() {
		return model.getDefCommPartnerPet();
	}

	/**
	 * Returns the def comm partner property of this mypage user.
	 *
	 * @return the def comm partner property of this mypage user
	 */
	@Override
	public double getDefCommPartnerProperty() {
		return model.getDefCommPartnerProperty();
	}

	/**
	 * Returns the def comm partner sme of this mypage user.
	 *
	 * @return the def comm partner sme of this mypage user
	 */
	@Override
	public double getDefCommPartnerSME() {
		return model.getDefCommPartnerSME();
	}

	/**
	 * Returns the deptore code of this mypage user.
	 *
	 * @return the deptore code of this mypage user
	 */
	@Override
	public String getDeptoreCode() {
		return model.getDeptoreCode();
	}

	/**
	 * Returns the dob of this mypage user.
	 *
	 * @return the dob of this mypage user
	 */
	@Override
	public Date getDob() {
		return model.getDob();
	}

	/**
	 * Returns the email of this mypage user.
	 *
	 * @return the email of this mypage user
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the end date of this mypage user.
	 *
	 * @return the end date of this mypage user
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the facebook of this mypage user.
	 *
	 * @return the facebook of this mypage user
	 */
	@Override
	public String getFacebook() {
		return model.getFacebook();
	}

	/**
	 * Returns the gender of this mypage user.
	 *
	 * @return the gender of this mypage user
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this mypage user.
	 *
	 * @return the group ID of this mypage user
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the id number of this mypage user.
	 *
	 * @return the id number of this mypage user
	 */
	@Override
	public String getIdNumber() {
		return model.getIdNumber();
	}

	/**
	 * Returns the instagram of this mypage user.
	 *
	 * @return the instagram of this mypage user
	 */
	@Override
	public String getInstagram() {
		return model.getInstagram();
	}

	/**
	 * Returns the is24 hours of this mypage user.
	 *
	 * @return the is24 hours of this mypage user
	 */
	@Override
	public int getIs24Hours() {
		return model.getIs24Hours();
	}

	/**
	 * Returns the is partnership of this mypage user.
	 *
	 * @return the is partnership of this mypage user
	 */
	@Override
	public int getIsPartnership() {
		return model.getIsPartnership();
	}

	/**
	 * Returns the join date of this mypage user.
	 *
	 * @return the join date of this mypage user
	 */
	@Override
	public Date getJoinDate() {
		return model.getJoinDate();
	}

	/**
	 * Returns the last submit login date of this mypage user.
	 *
	 * @return the last submit login date of this mypage user
	 */
	@Override
	public Date getLastSubmitLoginDate() {
		return model.getLastSubmitLoginDate();
	}

	/**
	 * Returns the latitude of this mypage user.
	 *
	 * @return the latitude of this mypage user
	 */
	@Override
	public String getLatitude() {
		return model.getLatitude();
	}

	/**
	 * Returns the leader of this mypage user.
	 *
	 * @return the leader of this mypage user
	 */
	@Override
	public long getLeader() {
		return model.getLeader();
	}

	/**
	 * Returns the license number of this mypage user.
	 *
	 * @return the license number of this mypage user
	 */
	@Override
	public String getLicenseNumber() {
		return model.getLicenseNumber();
	}

	/**
	 * Returns the liferay user ID of this mypage user.
	 *
	 * @return the liferay user ID of this mypage user
	 */
	@Override
	public long getLiferayUserId() {
		return model.getLiferayUserId();
	}

	/**
	 * Returns the liferay user uuid of this mypage user.
	 *
	 * @return the liferay user uuid of this mypage user
	 */
	@Override
	public String getLiferayUserUuid() {
		return model.getLiferayUserUuid();
	}

	/**
	 * Returns the linked in of this mypage user.
	 *
	 * @return the linked in of this mypage user
	 */
	@Override
	public String getLinkedIn() {
		return model.getLinkedIn();
	}

	/**
	 * Returns the login counter of this mypage user.
	 *
	 * @return the login counter of this mypage user
	 */
	@Override
	public int getLoginCounter() {
		return model.getLoginCounter();
	}

	/**
	 * Returns the longitude of this mypage user.
	 *
	 * @return the longitude of this mypage user
	 */
	@Override
	public String getLongitude() {
		return model.getLongitude();
	}

	/**
	 * Returns the mobile phone of this mypage user.
	 *
	 * @return the mobile phone of this mypage user
	 */
	@Override
	public String getMobilePhone() {
		return model.getMobilePhone();
	}

	/**
	 * Returns the modified date of this mypage user.
	 *
	 * @return the modified date of this mypage user
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mypage user ID of this mypage user.
	 *
	 * @return the mypage user ID of this mypage user
	 */
	@Override
	public long getMypageUserId() {
		return model.getMypageUserId();
	}

	/**
	 * Returns the mypage user role ID of this mypage user.
	 *
	 * @return the mypage user role ID of this mypage user
	 */
	@Override
	public long getMypageUserRoleId() {
		return model.getMypageUserRoleId();
	}

	/**
	 * Returns the mypage user uuid of this mypage user.
	 *
	 * @return the mypage user uuid of this mypage user
	 */
	@Override
	public String getMypageUserUuid() {
		return model.getMypageUserUuid();
	}

	/**
	 * Returns the my title of this mypage user.
	 *
	 * @return the my title of this mypage user
	 */
	@Override
	public String getMyTitle() {
		return model.getMyTitle();
	}

	/**
	 * Returns the my video of this mypage user.
	 *
	 * @return the my video of this mypage user
	 */
	@Override
	public String getMyVideo() {
		return model.getMyVideo();
	}

	/**
	 * Returns the partnership name of this mypage user.
	 *
	 * @return the partnership name of this mypage user
	 */
	@Override
	public String getPartnershipName() {
		return model.getPartnershipName();
	}

	/**
	 * Returns the payment method of this mypage user.
	 *
	 * @return the payment method of this mypage user
	 */
	@Override
	public String getPaymentMethod() {
		return model.getPaymentMethod();
	}

	/**
	 * Returns the phone of this mypage user.
	 *
	 * @return the phone of this mypage user
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the position zoom of this mypage user.
	 *
	 * @return the position zoom of this mypage user
	 */
	@Override
	public int getPositionZoom() {
		return model.getPositionZoom();
	}

	/**
	 * Returns the pretty url of this mypage user.
	 *
	 * @return the pretty url of this mypage user
	 */
	@Override
	public String getPrettyUrl() {
		return model.getPrettyUrl();
	}

	/**
	 * Returns the pretty url change of this mypage user.
	 *
	 * @return the pretty url change of this mypage user
	 */
	@Override
	public int getPrettyUrlChange() {
		return model.getPrettyUrlChange();
	}

	/**
	 * Returns the primary key of this mypage user.
	 *
	 * @return the primary key of this mypage user
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the profile image file entry ID of this mypage user.
	 *
	 * @return the profile image file entry ID of this mypage user
	 */
	@Override
	public Long getProfileImageFileEntryId() {
		return model.getProfileImageFileEntryId();
	}

	/**
	 * Returns the profile image url of this mypage user.
	 *
	 * @return the profile image url of this mypage user
	 */
	@Override
	public String getProfileImageURL() {
		return model.getProfileImageURL();
	}

	/**
	 * Returns the promo code of this mypage user.
	 *
	 * @return the promo code of this mypage user
	 */
	@Override
	public String getPromoCode() {
		return model.getPromoCode();
	}

	/**
	 * Returns the province of this mypage user.
	 *
	 * @return the province of this mypage user
	 */
	@Override
	public long getProvince() {
		return model.getProvince();
	}

	/**
	 * Returns the skype of this mypage user.
	 *
	 * @return the skype of this mypage user
	 */
	@Override
	public String getSkype() {
		return model.getSkype();
	}

	/**
	 * Returns the status of this mypage user.
	 *
	 * @return the status of this mypage user
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status agent of this mypage user.
	 *
	 * @return the status agent of this mypage user
	 */
	@Override
	public String getStatusAgent() {
		return model.getStatusAgent();
	}

	/**
	 * Returns the tax rate of this mypage user.
	 *
	 * @return the tax rate of this mypage user
	 */
	@Override
	public double getTaxRate() {
		return model.getTaxRate();
	}

	/**
	 * Returns the temp code of this mypage user.
	 *
	 * @return the temp code of this mypage user
	 */
	@Override
	public String getTempCode() {
		return model.getTempCode();
	}

	/**
	 * Returns the temp code expiry date of this mypage user.
	 *
	 * @return the temp code expiry date of this mypage user
	 */
	@Override
	public Date getTempCodeExpiryDate() {
		return model.getTempCodeExpiryDate();
	}

	/**
	 * Returns the tiktok of this mypage user.
	 *
	 * @return the tiktok of this mypage user
	 */
	@Override
	public String getTiktok() {
		return model.getTiktok();
	}

	/**
	 * Returns the twitter of this mypage user.
	 *
	 * @return the twitter of this mypage user
	 */
	@Override
	public String getTwitter() {
		return model.getTwitter();
	}

	/**
	 * Returns the user branch of this mypage user.
	 *
	 * @return the user branch of this mypage user
	 */
	@Override
	public long getUserBranch() {
		return model.getUserBranch();
	}

	/**
	 * Returns the user ID of this mypage user.
	 *
	 * @return the user ID of this mypage user
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this mypage user.
	 *
	 * @return the user name of this mypage user
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user parent of this mypage user.
	 *
	 * @return the user parent of this mypage user
	 */
	@Override
	public long getUserParent() {
		return model.getUserParent();
	}

	/**
	 * Returns the user password of this mypage user.
	 *
	 * @return the user password of this mypage user
	 */
	@Override
	public String getUserPassword() {
		return model.getUserPassword();
	}

	/**
	 * Returns the user uuid of this mypage user.
	 *
	 * @return the user uuid of this mypage user
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the visited count of this mypage user.
	 *
	 * @return the visited count of this mypage user
	 */
	@Override
	public int getVisitedCount() {
		return model.getVisitedCount();
	}

	/**
	 * Returns the whatsapp of this mypage user.
	 *
	 * @return the whatsapp of this mypage user
	 */
	@Override
	public String getWhatsapp() {
		return model.getWhatsapp();
	}

	/**
	 * Returns the zip of this mypage user.
	 *
	 * @return the zip of this mypage user
	 */
	@Override
	public String getZip() {
		return model.getZip();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the about me of this mypage user.
	 *
	 * @param aboutMe the about me of this mypage user
	 */
	@Override
	public void setAboutMe(String aboutMe) {
		model.setAboutMe(aboutMe);
	}

	/**
	 * Sets the active of this mypage user.
	 *
	 * @param active the active of this mypage user
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the address of this mypage user.
	 *
	 * @param address the address of this mypage user
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the agent flag of this mypage user.
	 *
	 * @param agentFlag the agent flag of this mypage user
	 */
	@Override
	public void setAgentFlag(String agentFlag) {
		model.setAgentFlag(agentFlag);
	}

	/**
	 * Sets the ags promo code of this mypage user.
	 *
	 * @param agsPromoCode the ags promo code of this mypage user
	 */
	@Override
	public void setAgsPromoCode(String agsPromoCode) {
		model.setAgsPromoCode(agsPromoCode);
	}

	/**
	 * Sets the banner image file entry ID of this mypage user.
	 *
	 * @param bannerImageFileEntryId the banner image file entry ID of this mypage user
	 */
	@Override
	public void setBannerImageFileEntryId(Long bannerImageFileEntryId) {
		model.setBannerImageFileEntryId(bannerImageFileEntryId);
	}

	/**
	 * Sets the banner image url of this mypage user.
	 *
	 * @param bannerImageURL the banner image url of this mypage user
	 */
	@Override
	public void setBannerImageURL(String bannerImageURL) {
		model.setBannerImageURL(bannerImageURL);
	}

	/**
	 * Sets the birth place of this mypage user.
	 *
	 * @param birthPlace the birth place of this mypage user
	 */
	@Override
	public void setBirthPlace(String birthPlace) {
		model.setBirthPlace(birthPlace);
	}

	/**
	 * Sets the blog of this mypage user.
	 *
	 * @param blog the blog of this mypage user
	 */
	@Override
	public void setBlog(String blog) {
		model.setBlog(blog);
	}

	/**
	 * Sets the branch of this mypage user.
	 *
	 * @param branch the branch of this mypage user
	 */
	@Override
	public void setBranch(long branch) {
		model.setBranch(branch);
	}

	/**
	 * Sets the cash payment of this mypage user.
	 *
	 * @param cashPayment the cash payment of this mypage user
	 */
	@Override
	public void setCashPayment(int cashPayment) {
		model.setCashPayment(cashPayment);
	}

	/**
	 * Sets the city of this mypage user.
	 *
	 * @param city the city of this mypage user
	 */
	@Override
	public void setCity(long city) {
		model.setCity(city);
	}

	/**
	 * Sets the club of this mypage user.
	 *
	 * @param club the club of this mypage user
	 */
	@Override
	public void setClub(String club) {
		model.setClub(club);
	}

	/**
	 * Sets the code of this mypage user.
	 *
	 * @param code the code of this mypage user
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this mypage user.
	 *
	 * @param companyId the company ID of this mypage user
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the country of this mypage user.
	 *
	 * @param country the country of this mypage user
	 */
	@Override
	public void setCountry(long country) {
		model.setCountry(country);
	}

	/**
	 * Sets the create date of this mypage user.
	 *
	 * @param createDate the create date of this mypage user
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the credit status of this mypage user.
	 *
	 * @param creditStatus the credit status of this mypage user
	 */
	@Override
	public void setCreditStatus(String creditStatus) {
		model.setCreditStatus(creditStatus);
	}

	/**
	 * Sets the credit wallet ID of this mypage user.
	 *
	 * @param creditWalletId the credit wallet ID of this mypage user
	 */
	@Override
	public void setCreditWalletId(long creditWalletId) {
		model.setCreditWalletId(creditWalletId);
	}

	/**
	 * Sets the def comm partner dt of this mypage user.
	 *
	 * @param defCommPartnerDT the def comm partner dt of this mypage user
	 */
	@Override
	public void setDefCommPartnerDT(double defCommPartnerDT) {
		model.setDefCommPartnerDT(defCommPartnerDT);
	}

	/**
	 * Sets the def comm partner eh of this mypage user.
	 *
	 * @param defCommPartnerEH the def comm partner eh of this mypage user
	 */
	@Override
	public void setDefCommPartnerEH(double defCommPartnerEH) {
		model.setDefCommPartnerEH(defCommPartnerEH);
	}

	/**
	 * Sets the def comm partner gp of this mypage user.
	 *
	 * @param defCommPartnerGP the def comm partner gp of this mypage user
	 */
	@Override
	public void setDefCommPartnerGP(double defCommPartnerGP) {
		model.setDefCommPartnerGP(defCommPartnerGP);
	}

	/**
	 * Sets the def comm partner it of this mypage user.
	 *
	 * @param defCommPartnerIT the def comm partner it of this mypage user
	 */
	@Override
	public void setDefCommPartnerIT(double defCommPartnerIT) {
		model.setDefCommPartnerIT(defCommPartnerIT);
	}

	/**
	 * Sets the def comm partner mv of this mypage user.
	 *
	 * @param defCommPartnerMV the def comm partner mv of this mypage user
	 */
	@Override
	public void setDefCommPartnerMV(double defCommPartnerMV) {
		model.setDefCommPartnerMV(defCommPartnerMV);
	}

	/**
	 * Sets the def comm partner pa of this mypage user.
	 *
	 * @param defCommPartnerPA the def comm partner pa of this mypage user
	 */
	@Override
	public void setDefCommPartnerPA(double defCommPartnerPA) {
		model.setDefCommPartnerPA(defCommPartnerPA);
	}

	/**
	 * Sets the def comm partner pet of this mypage user.
	 *
	 * @param defCommPartnerPet the def comm partner pet of this mypage user
	 */
	@Override
	public void setDefCommPartnerPet(double defCommPartnerPet) {
		model.setDefCommPartnerPet(defCommPartnerPet);
	}

	/**
	 * Sets the def comm partner property of this mypage user.
	 *
	 * @param defCommPartnerProperty the def comm partner property of this mypage user
	 */
	@Override
	public void setDefCommPartnerProperty(double defCommPartnerProperty) {
		model.setDefCommPartnerProperty(defCommPartnerProperty);
	}

	/**
	 * Sets the def comm partner sme of this mypage user.
	 *
	 * @param defCommPartnerSME the def comm partner sme of this mypage user
	 */
	@Override
	public void setDefCommPartnerSME(double defCommPartnerSME) {
		model.setDefCommPartnerSME(defCommPartnerSME);
	}

	/**
	 * Sets the deptore code of this mypage user.
	 *
	 * @param deptoreCode the deptore code of this mypage user
	 */
	@Override
	public void setDeptoreCode(String deptoreCode) {
		model.setDeptoreCode(deptoreCode);
	}

	/**
	 * Sets the dob of this mypage user.
	 *
	 * @param dob the dob of this mypage user
	 */
	@Override
	public void setDob(Date dob) {
		model.setDob(dob);
	}

	/**
	 * Sets the email of this mypage user.
	 *
	 * @param email the email of this mypage user
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the end date of this mypage user.
	 *
	 * @param endDate the end date of this mypage user
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the facebook of this mypage user.
	 *
	 * @param facebook the facebook of this mypage user
	 */
	@Override
	public void setFacebook(String facebook) {
		model.setFacebook(facebook);
	}

	/**
	 * Sets the gender of this mypage user.
	 *
	 * @param gender the gender of this mypage user
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this mypage user.
	 *
	 * @param groupId the group ID of this mypage user
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the id number of this mypage user.
	 *
	 * @param idNumber the id number of this mypage user
	 */
	@Override
	public void setIdNumber(String idNumber) {
		model.setIdNumber(idNumber);
	}

	/**
	 * Sets the instagram of this mypage user.
	 *
	 * @param instagram the instagram of this mypage user
	 */
	@Override
	public void setInstagram(String instagram) {
		model.setInstagram(instagram);
	}

	/**
	 * Sets the is24 hours of this mypage user.
	 *
	 * @param is24Hours the is24 hours of this mypage user
	 */
	@Override
	public void setIs24Hours(int is24Hours) {
		model.setIs24Hours(is24Hours);
	}

	/**
	 * Sets the is partnership of this mypage user.
	 *
	 * @param isPartnership the is partnership of this mypage user
	 */
	@Override
	public void setIsPartnership(int isPartnership) {
		model.setIsPartnership(isPartnership);
	}

	/**
	 * Sets the join date of this mypage user.
	 *
	 * @param joinDate the join date of this mypage user
	 */
	@Override
	public void setJoinDate(Date joinDate) {
		model.setJoinDate(joinDate);
	}

	/**
	 * Sets the last submit login date of this mypage user.
	 *
	 * @param lastSubmitLoginDate the last submit login date of this mypage user
	 */
	@Override
	public void setLastSubmitLoginDate(Date lastSubmitLoginDate) {
		model.setLastSubmitLoginDate(lastSubmitLoginDate);
	}

	/**
	 * Sets the latitude of this mypage user.
	 *
	 * @param latitude the latitude of this mypage user
	 */
	@Override
	public void setLatitude(String latitude) {
		model.setLatitude(latitude);
	}

	/**
	 * Sets the leader of this mypage user.
	 *
	 * @param leader the leader of this mypage user
	 */
	@Override
	public void setLeader(long leader) {
		model.setLeader(leader);
	}

	/**
	 * Sets the license number of this mypage user.
	 *
	 * @param licenseNumber the license number of this mypage user
	 */
	@Override
	public void setLicenseNumber(String licenseNumber) {
		model.setLicenseNumber(licenseNumber);
	}

	/**
	 * Sets the liferay user ID of this mypage user.
	 *
	 * @param liferayUserId the liferay user ID of this mypage user
	 */
	@Override
	public void setLiferayUserId(long liferayUserId) {
		model.setLiferayUserId(liferayUserId);
	}

	/**
	 * Sets the liferay user uuid of this mypage user.
	 *
	 * @param liferayUserUuid the liferay user uuid of this mypage user
	 */
	@Override
	public void setLiferayUserUuid(String liferayUserUuid) {
		model.setLiferayUserUuid(liferayUserUuid);
	}

	/**
	 * Sets the linked in of this mypage user.
	 *
	 * @param linkedIn the linked in of this mypage user
	 */
	@Override
	public void setLinkedIn(String linkedIn) {
		model.setLinkedIn(linkedIn);
	}

	/**
	 * Sets the login counter of this mypage user.
	 *
	 * @param loginCounter the login counter of this mypage user
	 */
	@Override
	public void setLoginCounter(int loginCounter) {
		model.setLoginCounter(loginCounter);
	}

	/**
	 * Sets the longitude of this mypage user.
	 *
	 * @param longitude the longitude of this mypage user
	 */
	@Override
	public void setLongitude(String longitude) {
		model.setLongitude(longitude);
	}

	/**
	 * Sets the mobile phone of this mypage user.
	 *
	 * @param mobilePhone the mobile phone of this mypage user
	 */
	@Override
	public void setMobilePhone(String mobilePhone) {
		model.setMobilePhone(mobilePhone);
	}

	/**
	 * Sets the modified date of this mypage user.
	 *
	 * @param modifiedDate the modified date of this mypage user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mypage user ID of this mypage user.
	 *
	 * @param mypageUserId the mypage user ID of this mypage user
	 */
	@Override
	public void setMypageUserId(long mypageUserId) {
		model.setMypageUserId(mypageUserId);
	}

	/**
	 * Sets the mypage user role ID of this mypage user.
	 *
	 * @param mypageUserRoleId the mypage user role ID of this mypage user
	 */
	@Override
	public void setMypageUserRoleId(long mypageUserRoleId) {
		model.setMypageUserRoleId(mypageUserRoleId);
	}

	/**
	 * Sets the mypage user uuid of this mypage user.
	 *
	 * @param mypageUserUuid the mypage user uuid of this mypage user
	 */
	@Override
	public void setMypageUserUuid(String mypageUserUuid) {
		model.setMypageUserUuid(mypageUserUuid);
	}

	/**
	 * Sets the my title of this mypage user.
	 *
	 * @param myTitle the my title of this mypage user
	 */
	@Override
	public void setMyTitle(String myTitle) {
		model.setMyTitle(myTitle);
	}

	/**
	 * Sets the my video of this mypage user.
	 *
	 * @param myVideo the my video of this mypage user
	 */
	@Override
	public void setMyVideo(String myVideo) {
		model.setMyVideo(myVideo);
	}

	/**
	 * Sets the partnership name of this mypage user.
	 *
	 * @param partnershipName the partnership name of this mypage user
	 */
	@Override
	public void setPartnershipName(String partnershipName) {
		model.setPartnershipName(partnershipName);
	}

	/**
	 * Sets the payment method of this mypage user.
	 *
	 * @param paymentMethod the payment method of this mypage user
	 */
	@Override
	public void setPaymentMethod(String paymentMethod) {
		model.setPaymentMethod(paymentMethod);
	}

	/**
	 * Sets the phone of this mypage user.
	 *
	 * @param phone the phone of this mypage user
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the position zoom of this mypage user.
	 *
	 * @param positionZoom the position zoom of this mypage user
	 */
	@Override
	public void setPositionZoom(int positionZoom) {
		model.setPositionZoom(positionZoom);
	}

	/**
	 * Sets the pretty url of this mypage user.
	 *
	 * @param prettyUrl the pretty url of this mypage user
	 */
	@Override
	public void setPrettyUrl(String prettyUrl) {
		model.setPrettyUrl(prettyUrl);
	}

	/**
	 * Sets the pretty url change of this mypage user.
	 *
	 * @param prettyUrlChange the pretty url change of this mypage user
	 */
	@Override
	public void setPrettyUrlChange(int prettyUrlChange) {
		model.setPrettyUrlChange(prettyUrlChange);
	}

	/**
	 * Sets the primary key of this mypage user.
	 *
	 * @param primaryKey the primary key of this mypage user
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the profile image file entry ID of this mypage user.
	 *
	 * @param profileImageFileEntryId the profile image file entry ID of this mypage user
	 */
	@Override
	public void setProfileImageFileEntryId(Long profileImageFileEntryId) {
		model.setProfileImageFileEntryId(profileImageFileEntryId);
	}

	/**
	 * Sets the profile image url of this mypage user.
	 *
	 * @param profileImageURL the profile image url of this mypage user
	 */
	@Override
	public void setProfileImageURL(String profileImageURL) {
		model.setProfileImageURL(profileImageURL);
	}

	/**
	 * Sets the promo code of this mypage user.
	 *
	 * @param promoCode the promo code of this mypage user
	 */
	@Override
	public void setPromoCode(String promoCode) {
		model.setPromoCode(promoCode);
	}

	/**
	 * Sets the province of this mypage user.
	 *
	 * @param province the province of this mypage user
	 */
	@Override
	public void setProvince(long province) {
		model.setProvince(province);
	}

	/**
	 * Sets the skype of this mypage user.
	 *
	 * @param skype the skype of this mypage user
	 */
	@Override
	public void setSkype(String skype) {
		model.setSkype(skype);
	}

	/**
	 * Sets the status of this mypage user.
	 *
	 * @param status the status of this mypage user
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status agent of this mypage user.
	 *
	 * @param statusAgent the status agent of this mypage user
	 */
	@Override
	public void setStatusAgent(String statusAgent) {
		model.setStatusAgent(statusAgent);
	}

	/**
	 * Sets the tax rate of this mypage user.
	 *
	 * @param taxRate the tax rate of this mypage user
	 */
	@Override
	public void setTaxRate(double taxRate) {
		model.setTaxRate(taxRate);
	}

	/**
	 * Sets the temp code of this mypage user.
	 *
	 * @param TempCode the temp code of this mypage user
	 */
	@Override
	public void setTempCode(String TempCode) {
		model.setTempCode(TempCode);
	}

	/**
	 * Sets the temp code expiry date of this mypage user.
	 *
	 * @param TempCodeExpiryDate the temp code expiry date of this mypage user
	 */
	@Override
	public void setTempCodeExpiryDate(Date TempCodeExpiryDate) {
		model.setTempCodeExpiryDate(TempCodeExpiryDate);
	}

	/**
	 * Sets the tiktok of this mypage user.
	 *
	 * @param tiktok the tiktok of this mypage user
	 */
	@Override
	public void setTiktok(String tiktok) {
		model.setTiktok(tiktok);
	}

	/**
	 * Sets the twitter of this mypage user.
	 *
	 * @param twitter the twitter of this mypage user
	 */
	@Override
	public void setTwitter(String twitter) {
		model.setTwitter(twitter);
	}

	/**
	 * Sets the user branch of this mypage user.
	 *
	 * @param userBranch the user branch of this mypage user
	 */
	@Override
	public void setUserBranch(long userBranch) {
		model.setUserBranch(userBranch);
	}

	/**
	 * Sets the user ID of this mypage user.
	 *
	 * @param userId the user ID of this mypage user
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this mypage user.
	 *
	 * @param userName the user name of this mypage user
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user parent of this mypage user.
	 *
	 * @param userParent the user parent of this mypage user
	 */
	@Override
	public void setUserParent(long userParent) {
		model.setUserParent(userParent);
	}

	/**
	 * Sets the user password of this mypage user.
	 *
	 * @param userPassword the user password of this mypage user
	 */
	@Override
	public void setUserPassword(String userPassword) {
		model.setUserPassword(userPassword);
	}

	/**
	 * Sets the user uuid of this mypage user.
	 *
	 * @param userUuid the user uuid of this mypage user
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the visited count of this mypage user.
	 *
	 * @param visitedCount the visited count of this mypage user
	 */
	@Override
	public void setVisitedCount(int visitedCount) {
		model.setVisitedCount(visitedCount);
	}

	/**
	 * Sets the whatsapp of this mypage user.
	 *
	 * @param whatsapp the whatsapp of this mypage user
	 */
	@Override
	public void setWhatsapp(String whatsapp) {
		model.setWhatsapp(whatsapp);
	}

	/**
	 * Sets the zip of this mypage user.
	 *
	 * @param zip the zip of this mypage user
	 */
	@Override
	public void setZip(String zip) {
		model.setZip(zip);
	}

	@Override
	protected MypageUserWrapper wrap(MypageUser mypageUser) {
		return new MypageUserWrapper(mypageUser);
	}

}