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

package com.aii.esppk.admin.model.impl;

import com.aii.esppk.admin.model.SppkUser;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SppkUser in entity cache.
 *
 * @author Gositus
 * @generated
 */
public class SppkUserCacheModel
	implements CacheModel<SppkUser>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SppkUserCacheModel)) {
			return false;
		}

		SppkUserCacheModel sppkUserCacheModel = (SppkUserCacheModel)object;

		if (sppkUserId == sppkUserCacheModel.sppkUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sppkUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{sppkUserId=");
		sb.append(sppkUserId);
		sb.append(", sppkLoginCode=");
		sb.append(sppkLoginCode);
		sb.append(", password=");
		sb.append(password);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", roleCode=");
		sb.append(roleCode);
		sb.append(", email=");
		sb.append(email);
		sb.append(", allAccess=");
		sb.append(allAccess);
		sb.append(", accessData=");
		sb.append(accessData);
		sb.append(", accessMonitoring=");
		sb.append(accessMonitoring);
		sb.append(", active=");
		sb.append(active);
		sb.append(", expireDate=");
		sb.append(expireDate);
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
		sb.append(", otpCode=");
		sb.append(otpCode);
		sb.append(", otpExpired=");
		sb.append(otpExpired);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SppkUser toEntityModel() {
		SppkUserImpl sppkUserImpl = new SppkUserImpl();

		sppkUserImpl.setSppkUserId(sppkUserId);

		if (sppkLoginCode == null) {
			sppkUserImpl.setSppkLoginCode("");
		}
		else {
			sppkUserImpl.setSppkLoginCode(sppkLoginCode);
		}

		if (password == null) {
			sppkUserImpl.setPassword("");
		}
		else {
			sppkUserImpl.setPassword(password);
		}

		if (fullName == null) {
			sppkUserImpl.setFullName("");
		}
		else {
			sppkUserImpl.setFullName(fullName);
		}

		if (roleCode == null) {
			sppkUserImpl.setRoleCode("");
		}
		else {
			sppkUserImpl.setRoleCode(roleCode);
		}

		if (email == null) {
			sppkUserImpl.setEmail("");
		}
		else {
			sppkUserImpl.setEmail(email);
		}

		sppkUserImpl.setAllAccess(allAccess);
		sppkUserImpl.setAccessData(accessData);
		sppkUserImpl.setAccessMonitoring(accessMonitoring);
		sppkUserImpl.setActive(active);

		if (expireDate == Long.MIN_VALUE) {
			sppkUserImpl.setExpireDate(null);
		}
		else {
			sppkUserImpl.setExpireDate(new Date(expireDate));
		}

		sppkUserImpl.setGroupId(groupId);
		sppkUserImpl.setCompanyId(companyId);
		sppkUserImpl.setUserId(userId);

		if (userName == null) {
			sppkUserImpl.setUserName("");
		}
		else {
			sppkUserImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			sppkUserImpl.setCreateDate(null);
		}
		else {
			sppkUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			sppkUserImpl.setModifiedDate(null);
		}
		else {
			sppkUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (otpCode == null) {
			sppkUserImpl.setOtpCode("");
		}
		else {
			sppkUserImpl.setOtpCode(otpCode);
		}

		if (otpExpired == Long.MIN_VALUE) {
			sppkUserImpl.setOtpExpired(null);
		}
		else {
			sppkUserImpl.setOtpExpired(new Date(otpExpired));
		}

		sppkUserImpl.resetOriginalValues();

		return sppkUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sppkUserId = objectInput.readLong();
		sppkLoginCode = objectInput.readUTF();
		password = objectInput.readUTF();
		fullName = objectInput.readUTF();
		roleCode = objectInput.readUTF();
		email = objectInput.readUTF();

		allAccess = objectInput.readInt();

		accessData = objectInput.readInt();

		accessMonitoring = objectInput.readInt();

		active = objectInput.readInt();
		expireDate = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		otpCode = objectInput.readUTF();
		otpExpired = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(sppkUserId);

		if (sppkLoginCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sppkLoginCode);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (roleCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(roleCode);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeInt(allAccess);

		objectOutput.writeInt(accessData);

		objectOutput.writeInt(accessMonitoring);

		objectOutput.writeInt(active);
		objectOutput.writeLong(expireDate);

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

		if (otpCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(otpCode);
		}

		objectOutput.writeLong(otpExpired);
	}

	public long sppkUserId;
	public String sppkLoginCode;
	public String password;
	public String fullName;
	public String roleCode;
	public String email;
	public int allAccess;
	public int accessData;
	public int accessMonitoring;
	public int active;
	public long expireDate;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String otpCode;
	public long otpExpired;

}