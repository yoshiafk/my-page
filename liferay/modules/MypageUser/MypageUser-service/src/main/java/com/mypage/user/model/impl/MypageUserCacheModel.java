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

package com.mypage.user.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.mypage.user.model.MypageUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MypageUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MypageUserCacheModel
	implements CacheModel<MypageUser>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MypageUserCacheModel)) {
			return false;
		}

		MypageUserCacheModel mypageUserCacheModel =
			(MypageUserCacheModel)object;

		if (mypageUserId == mypageUserCacheModel.mypageUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, mypageUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(161);

		sb.append("{mypageUserId=");
		sb.append(mypageUserId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", liferayUserId=");
		sb.append(liferayUserId);
		sb.append(", userPassword=");
		sb.append(userPassword);
		sb.append(", agentFlag=");
		sb.append(agentFlag);
		sb.append(", userParent=");
		sb.append(userParent);
		sb.append(", userBranch=");
		sb.append(userBranch);
		sb.append(", mypageUserRoleId=");
		sb.append(mypageUserRoleId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", creditStatus=");
		sb.append(creditStatus);
		sb.append(", creditWalletId=");
		sb.append(creditWalletId);
		sb.append(", cashPayment=");
		sb.append(cashPayment);
		sb.append(", paymentMethod=");
		sb.append(paymentMethod);
		sb.append(", loginCounter=");
		sb.append(loginCounter);
		sb.append(", lastSubmitLoginDate=");
		sb.append(lastSubmitLoginDate);
		sb.append(", TempCode=");
		sb.append(TempCode);
		sb.append(", TempCodeExpiryDate=");
		sb.append(TempCodeExpiryDate);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", birthPlace=");
		sb.append(birthPlace);
		sb.append(", dob=");
		sb.append(dob);
		sb.append(", idNumber=");
		sb.append(idNumber);
		sb.append(", address=");
		sb.append(address);
		sb.append(", zip=");
		sb.append(zip);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", country=");
		sb.append(country);
		sb.append(", province=");
		sb.append(province);
		sb.append(", city=");
		sb.append(city);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", positionZoom=");
		sb.append(positionZoom);
		sb.append(", code=");
		sb.append(code);
		sb.append(", branch=");
		sb.append(branch);
		sb.append(", promoCode=");
		sb.append(promoCode);
		sb.append(", agsPromoCode=");
		sb.append(agsPromoCode);
		sb.append(", deptoreCode=");
		sb.append(deptoreCode);
		sb.append(", club=");
		sb.append(club);
		sb.append(", leader=");
		sb.append(leader);
		sb.append(", statusAgent=");
		sb.append(statusAgent);
		sb.append(", licenseNumber=");
		sb.append(licenseNumber);
		sb.append(", joinDate=");
		sb.append(joinDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", prettyUrl=");
		sb.append(prettyUrl);
		sb.append(", prettyUrlChange=");
		sb.append(prettyUrlChange);
		sb.append(", taxRate=");
		sb.append(taxRate);
		sb.append(", visitedCount=");
		sb.append(visitedCount);
		sb.append(", isPartnership=");
		sb.append(isPartnership);
		sb.append(", partnershipName=");
		sb.append(partnershipName);
		sb.append(", defCommPartnerMV=");
		sb.append(defCommPartnerMV);
		sb.append(", defCommPartnerEH=");
		sb.append(defCommPartnerEH);
		sb.append(", defCommPartnerDT=");
		sb.append(defCommPartnerDT);
		sb.append(", defCommPartnerIT=");
		sb.append(defCommPartnerIT);
		sb.append(", defCommPartnerSME=");
		sb.append(defCommPartnerSME);
		sb.append(", defCommPartnerProperty=");
		sb.append(defCommPartnerProperty);
		sb.append(", defCommPartnerPet=");
		sb.append(defCommPartnerPet);
		sb.append(", defCommPartnerPA=");
		sb.append(defCommPartnerPA);
		sb.append(", defCommPartnerGP=");
		sb.append(defCommPartnerGP);
		sb.append(", bannerImageURL=");
		sb.append(bannerImageURL);
		sb.append(", bannerImageFileEntryId=");
		sb.append(bannerImageFileEntryId);
		sb.append(", profileImageURL=");
		sb.append(profileImageURL);
		sb.append(", profileImageFileEntryId=");
		sb.append(profileImageFileEntryId);
		sb.append(", myTitle=");
		sb.append(myTitle);
		sb.append(", myVideo=");
		sb.append(myVideo);
		sb.append(", aboutMe=");
		sb.append(aboutMe);
		sb.append(", facebook=");
		sb.append(facebook);
		sb.append(", tiktok=");
		sb.append(tiktok);
		sb.append(", instagram=");
		sb.append(instagram);
		sb.append(", twitter=");
		sb.append(twitter);
		sb.append(", linkedIn=");
		sb.append(linkedIn);
		sb.append(", blog=");
		sb.append(blog);
		sb.append(", whatsapp=");
		sb.append(whatsapp);
		sb.append(", skype=");
		sb.append(skype);
		sb.append(", is24Hours=");
		sb.append(is24Hours);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MypageUser toEntityModel() {
		MypageUserImpl mypageUserImpl = new MypageUserImpl();

		mypageUserImpl.setMypageUserId(mypageUserId);
		mypageUserImpl.setGroupId(groupId);
		mypageUserImpl.setCompanyId(companyId);
		mypageUserImpl.setUserId(userId);

		if (userName == null) {
			mypageUserImpl.setUserName("");
		}
		else {
			mypageUserImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			mypageUserImpl.setCreateDate(null);
		}
		else {
			mypageUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			mypageUserImpl.setModifiedDate(null);
		}
		else {
			mypageUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		mypageUserImpl.setLiferayUserId(liferayUserId);

		if (userPassword == null) {
			mypageUserImpl.setUserPassword("");
		}
		else {
			mypageUserImpl.setUserPassword(userPassword);
		}

		if (agentFlag == null) {
			mypageUserImpl.setAgentFlag("");
		}
		else {
			mypageUserImpl.setAgentFlag(agentFlag);
		}

		mypageUserImpl.setUserParent(userParent);
		mypageUserImpl.setUserBranch(userBranch);
		mypageUserImpl.setMypageUserRoleId(mypageUserRoleId);

		if (status == null) {
			mypageUserImpl.setStatus("");
		}
		else {
			mypageUserImpl.setStatus(status);
		}

		if (creditStatus == null) {
			mypageUserImpl.setCreditStatus("");
		}
		else {
			mypageUserImpl.setCreditStatus(creditStatus);
		}

		mypageUserImpl.setCreditWalletId(creditWalletId);
		mypageUserImpl.setCashPayment(cashPayment);

		if (paymentMethod == null) {
			mypageUserImpl.setPaymentMethod("");
		}
		else {
			mypageUserImpl.setPaymentMethod(paymentMethod);
		}

		mypageUserImpl.setLoginCounter(loginCounter);

		if (lastSubmitLoginDate == Long.MIN_VALUE) {
			mypageUserImpl.setLastSubmitLoginDate(null);
		}
		else {
			mypageUserImpl.setLastSubmitLoginDate(
				new Date(lastSubmitLoginDate));
		}

		if (TempCode == null) {
			mypageUserImpl.setTempCode("");
		}
		else {
			mypageUserImpl.setTempCode(TempCode);
		}

		if (TempCodeExpiryDate == Long.MIN_VALUE) {
			mypageUserImpl.setTempCodeExpiryDate(null);
		}
		else {
			mypageUserImpl.setTempCodeExpiryDate(new Date(TempCodeExpiryDate));
		}

		if (phone == null) {
			mypageUserImpl.setPhone("");
		}
		else {
			mypageUserImpl.setPhone(phone);
		}

		if (mobilePhone == null) {
			mypageUserImpl.setMobilePhone("");
		}
		else {
			mypageUserImpl.setMobilePhone(mobilePhone);
		}

		if (email == null) {
			mypageUserImpl.setEmail("");
		}
		else {
			mypageUserImpl.setEmail(email);
		}

		if (birthPlace == null) {
			mypageUserImpl.setBirthPlace("");
		}
		else {
			mypageUserImpl.setBirthPlace(birthPlace);
		}

		if (dob == Long.MIN_VALUE) {
			mypageUserImpl.setDob(null);
		}
		else {
			mypageUserImpl.setDob(new Date(dob));
		}

		if (idNumber == null) {
			mypageUserImpl.setIdNumber("");
		}
		else {
			mypageUserImpl.setIdNumber(idNumber);
		}

		if (address == null) {
			mypageUserImpl.setAddress("");
		}
		else {
			mypageUserImpl.setAddress(address);
		}

		if (zip == null) {
			mypageUserImpl.setZip("");
		}
		else {
			mypageUserImpl.setZip(zip);
		}

		if (gender == null) {
			mypageUserImpl.setGender("");
		}
		else {
			mypageUserImpl.setGender(gender);
		}

		mypageUserImpl.setCountry(country);
		mypageUserImpl.setProvince(province);
		mypageUserImpl.setCity(city);

		if (latitude == null) {
			mypageUserImpl.setLatitude("");
		}
		else {
			mypageUserImpl.setLatitude(latitude);
		}

		if (longitude == null) {
			mypageUserImpl.setLongitude("");
		}
		else {
			mypageUserImpl.setLongitude(longitude);
		}

		mypageUserImpl.setPositionZoom(positionZoom);

		if (code == null) {
			mypageUserImpl.setCode("");
		}
		else {
			mypageUserImpl.setCode(code);
		}

		mypageUserImpl.setBranch(branch);

		if (promoCode == null) {
			mypageUserImpl.setPromoCode("");
		}
		else {
			mypageUserImpl.setPromoCode(promoCode);
		}

		if (agsPromoCode == null) {
			mypageUserImpl.setAgsPromoCode("");
		}
		else {
			mypageUserImpl.setAgsPromoCode(agsPromoCode);
		}

		if (deptoreCode == null) {
			mypageUserImpl.setDeptoreCode("");
		}
		else {
			mypageUserImpl.setDeptoreCode(deptoreCode);
		}

		if (club == null) {
			mypageUserImpl.setClub("");
		}
		else {
			mypageUserImpl.setClub(club);
		}

		mypageUserImpl.setLeader(leader);

		if (statusAgent == null) {
			mypageUserImpl.setStatusAgent("");
		}
		else {
			mypageUserImpl.setStatusAgent(statusAgent);
		}

		if (licenseNumber == null) {
			mypageUserImpl.setLicenseNumber("");
		}
		else {
			mypageUserImpl.setLicenseNumber(licenseNumber);
		}

		if (joinDate == Long.MIN_VALUE) {
			mypageUserImpl.setJoinDate(null);
		}
		else {
			mypageUserImpl.setJoinDate(new Date(joinDate));
		}

		if (endDate == Long.MIN_VALUE) {
			mypageUserImpl.setEndDate(null);
		}
		else {
			mypageUserImpl.setEndDate(new Date(endDate));
		}

		if (prettyUrl == null) {
			mypageUserImpl.setPrettyUrl("");
		}
		else {
			mypageUserImpl.setPrettyUrl(prettyUrl);
		}

		mypageUserImpl.setPrettyUrlChange(prettyUrlChange);
		mypageUserImpl.setTaxRate(taxRate);
		mypageUserImpl.setVisitedCount(visitedCount);
		mypageUserImpl.setIsPartnership(isPartnership);

		if (partnershipName == null) {
			mypageUserImpl.setPartnershipName("");
		}
		else {
			mypageUserImpl.setPartnershipName(partnershipName);
		}

		mypageUserImpl.setDefCommPartnerMV(defCommPartnerMV);
		mypageUserImpl.setDefCommPartnerEH(defCommPartnerEH);
		mypageUserImpl.setDefCommPartnerDT(defCommPartnerDT);
		mypageUserImpl.setDefCommPartnerIT(defCommPartnerIT);
		mypageUserImpl.setDefCommPartnerSME(defCommPartnerSME);
		mypageUserImpl.setDefCommPartnerProperty(defCommPartnerProperty);
		mypageUserImpl.setDefCommPartnerPet(defCommPartnerPet);
		mypageUserImpl.setDefCommPartnerPA(defCommPartnerPA);
		mypageUserImpl.setDefCommPartnerGP(defCommPartnerGP);

		if (bannerImageURL == null) {
			mypageUserImpl.setBannerImageURL("");
		}
		else {
			mypageUserImpl.setBannerImageURL(bannerImageURL);
		}

		mypageUserImpl.setBannerImageFileEntryId(bannerImageFileEntryId);

		if (profileImageURL == null) {
			mypageUserImpl.setProfileImageURL("");
		}
		else {
			mypageUserImpl.setProfileImageURL(profileImageURL);
		}

		mypageUserImpl.setProfileImageFileEntryId(profileImageFileEntryId);

		if (myTitle == null) {
			mypageUserImpl.setMyTitle("");
		}
		else {
			mypageUserImpl.setMyTitle(myTitle);
		}

		if (myVideo == null) {
			mypageUserImpl.setMyVideo("");
		}
		else {
			mypageUserImpl.setMyVideo(myVideo);
		}

		if (aboutMe == null) {
			mypageUserImpl.setAboutMe("");
		}
		else {
			mypageUserImpl.setAboutMe(aboutMe);
		}

		if (facebook == null) {
			mypageUserImpl.setFacebook("");
		}
		else {
			mypageUserImpl.setFacebook(facebook);
		}

		if (tiktok == null) {
			mypageUserImpl.setTiktok("");
		}
		else {
			mypageUserImpl.setTiktok(tiktok);
		}

		if (instagram == null) {
			mypageUserImpl.setInstagram("");
		}
		else {
			mypageUserImpl.setInstagram(instagram);
		}

		if (twitter == null) {
			mypageUserImpl.setTwitter("");
		}
		else {
			mypageUserImpl.setTwitter(twitter);
		}

		if (linkedIn == null) {
			mypageUserImpl.setLinkedIn("");
		}
		else {
			mypageUserImpl.setLinkedIn(linkedIn);
		}

		if (blog == null) {
			mypageUserImpl.setBlog("");
		}
		else {
			mypageUserImpl.setBlog(blog);
		}

		if (whatsapp == null) {
			mypageUserImpl.setWhatsapp("");
		}
		else {
			mypageUserImpl.setWhatsapp(whatsapp);
		}

		if (skype == null) {
			mypageUserImpl.setSkype("");
		}
		else {
			mypageUserImpl.setSkype(skype);
		}

		mypageUserImpl.setIs24Hours(is24Hours);
		mypageUserImpl.setActive(active);

		mypageUserImpl.resetOriginalValues();

		return mypageUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mypageUserId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		liferayUserId = objectInput.readLong();
		userPassword = objectInput.readUTF();
		agentFlag = objectInput.readUTF();

		userParent = objectInput.readLong();

		userBranch = objectInput.readLong();

		mypageUserRoleId = objectInput.readLong();
		status = objectInput.readUTF();
		creditStatus = objectInput.readUTF();

		creditWalletId = objectInput.readLong();

		cashPayment = objectInput.readInt();
		paymentMethod = objectInput.readUTF();

		loginCounter = objectInput.readInt();
		lastSubmitLoginDate = objectInput.readLong();
		TempCode = objectInput.readUTF();
		TempCodeExpiryDate = objectInput.readLong();
		phone = objectInput.readUTF();
		mobilePhone = objectInput.readUTF();
		email = objectInput.readUTF();
		birthPlace = objectInput.readUTF();
		dob = objectInput.readLong();
		idNumber = objectInput.readUTF();
		address = objectInput.readUTF();
		zip = objectInput.readUTF();
		gender = objectInput.readUTF();

		country = objectInput.readLong();

		province = objectInput.readLong();

		city = objectInput.readLong();
		latitude = objectInput.readUTF();
		longitude = objectInput.readUTF();

		positionZoom = objectInput.readInt();
		code = objectInput.readUTF();

		branch = objectInput.readLong();
		promoCode = objectInput.readUTF();
		agsPromoCode = objectInput.readUTF();
		deptoreCode = objectInput.readUTF();
		club = objectInput.readUTF();

		leader = objectInput.readLong();
		statusAgent = objectInput.readUTF();
		licenseNumber = objectInput.readUTF();
		joinDate = objectInput.readLong();
		endDate = objectInput.readLong();
		prettyUrl = objectInput.readUTF();

		prettyUrlChange = objectInput.readInt();

		taxRate = objectInput.readDouble();

		visitedCount = objectInput.readInt();

		isPartnership = objectInput.readInt();
		partnershipName = objectInput.readUTF();

		defCommPartnerMV = objectInput.readDouble();

		defCommPartnerEH = objectInput.readDouble();

		defCommPartnerDT = objectInput.readDouble();

		defCommPartnerIT = objectInput.readDouble();

		defCommPartnerSME = objectInput.readDouble();

		defCommPartnerProperty = objectInput.readDouble();

		defCommPartnerPet = objectInput.readDouble();

		defCommPartnerPA = objectInput.readDouble();

		defCommPartnerGP = objectInput.readDouble();
		bannerImageURL = objectInput.readUTF();

		bannerImageFileEntryId = objectInput.readLong();
		profileImageURL = objectInput.readUTF();

		profileImageFileEntryId = objectInput.readLong();
		myTitle = objectInput.readUTF();
		myVideo = objectInput.readUTF();
		aboutMe = objectInput.readUTF();
		facebook = objectInput.readUTF();
		tiktok = objectInput.readUTF();
		instagram = objectInput.readUTF();
		twitter = objectInput.readUTF();
		linkedIn = objectInput.readUTF();
		blog = objectInput.readUTF();
		whatsapp = objectInput.readUTF();
		skype = objectInput.readUTF();

		is24Hours = objectInput.readInt();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mypageUserId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(liferayUserId);

		if (userPassword == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userPassword);
		}

		if (agentFlag == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(agentFlag);
		}

		objectOutput.writeLong(userParent);

		objectOutput.writeLong(userBranch);

		objectOutput.writeLong(mypageUserRoleId);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (creditStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(creditStatus);
		}

		objectOutput.writeLong(creditWalletId);

		objectOutput.writeInt(cashPayment);

		if (paymentMethod == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paymentMethod);
		}

		objectOutput.writeInt(loginCounter);
		objectOutput.writeLong(lastSubmitLoginDate);

		if (TempCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TempCode);
		}

		objectOutput.writeLong(TempCodeExpiryDate);

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (mobilePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobilePhone);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (birthPlace == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(birthPlace);
		}

		objectOutput.writeLong(dob);

		if (idNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idNumber);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (zip == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zip);
		}

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		objectOutput.writeLong(country);

		objectOutput.writeLong(province);

		objectOutput.writeLong(city);

		if (latitude == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(latitude);
		}

		if (longitude == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(longitude);
		}

		objectOutput.writeInt(positionZoom);

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeLong(branch);

		if (promoCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(promoCode);
		}

		if (agsPromoCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(agsPromoCode);
		}

		if (deptoreCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(deptoreCode);
		}

		if (club == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(club);
		}

		objectOutput.writeLong(leader);

		if (statusAgent == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusAgent);
		}

		if (licenseNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(licenseNumber);
		}

		objectOutput.writeLong(joinDate);
		objectOutput.writeLong(endDate);

		if (prettyUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prettyUrl);
		}

		objectOutput.writeInt(prettyUrlChange);

		objectOutput.writeDouble(taxRate);

		objectOutput.writeInt(visitedCount);

		objectOutput.writeInt(isPartnership);

		if (partnershipName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(partnershipName);
		}

		objectOutput.writeDouble(defCommPartnerMV);

		objectOutput.writeDouble(defCommPartnerEH);

		objectOutput.writeDouble(defCommPartnerDT);

		objectOutput.writeDouble(defCommPartnerIT);

		objectOutput.writeDouble(defCommPartnerSME);

		objectOutput.writeDouble(defCommPartnerProperty);

		objectOutput.writeDouble(defCommPartnerPet);

		objectOutput.writeDouble(defCommPartnerPA);

		objectOutput.writeDouble(defCommPartnerGP);

		if (bannerImageURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bannerImageURL);
		}

		objectOutput.writeLong(bannerImageFileEntryId);

		if (profileImageURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(profileImageURL);
		}

		objectOutput.writeLong(profileImageFileEntryId);

		if (myTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(myTitle);
		}

		if (myVideo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(myVideo);
		}

		if (aboutMe == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(aboutMe);
		}

		if (facebook == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(facebook);
		}

		if (tiktok == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tiktok);
		}

		if (instagram == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(instagram);
		}

		if (twitter == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(twitter);
		}

		if (linkedIn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(linkedIn);
		}

		if (blog == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(blog);
		}

		if (whatsapp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(whatsapp);
		}

		if (skype == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(skype);
		}

		objectOutput.writeInt(is24Hours);

		objectOutput.writeInt(active);
	}

	public long mypageUserId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long liferayUserId;
	public String userPassword;
	public String agentFlag;
	public long userParent;
	public long userBranch;
	public long mypageUserRoleId;
	public String status;
	public String creditStatus;
	public long creditWalletId;
	public int cashPayment;
	public String paymentMethod;
	public int loginCounter;
	public long lastSubmitLoginDate;
	public String TempCode;
	public long TempCodeExpiryDate;
	public String phone;
	public String mobilePhone;
	public String email;
	public String birthPlace;
	public long dob;
	public String idNumber;
	public String address;
	public String zip;
	public String gender;
	public long country;
	public long province;
	public long city;
	public String latitude;
	public String longitude;
	public int positionZoom;
	public String code;
	public long branch;
	public String promoCode;
	public String agsPromoCode;
	public String deptoreCode;
	public String club;
	public long leader;
	public String statusAgent;
	public String licenseNumber;
	public long joinDate;
	public long endDate;
	public String prettyUrl;
	public int prettyUrlChange;
	public double taxRate;
	public int visitedCount;
	public int isPartnership;
	public String partnershipName;
	public double defCommPartnerMV;
	public double defCommPartnerEH;
	public double defCommPartnerDT;
	public double defCommPartnerIT;
	public double defCommPartnerSME;
	public double defCommPartnerProperty;
	public double defCommPartnerPet;
	public double defCommPartnerPA;
	public double defCommPartnerGP;
	public String bannerImageURL;
	public long bannerImageFileEntryId;
	public String profileImageURL;
	public long profileImageFileEntryId;
	public String myTitle;
	public String myVideo;
	public String aboutMe;
	public String facebook;
	public String tiktok;
	public String instagram;
	public String twitter;
	public String linkedIn;
	public String blog;
	public String whatsapp;
	public String skype;
	public int is24Hours;
	public int active;

}