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

package com.mypage.admin.product.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.mypage.admin.product.model.MasterBank;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MasterBank in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class MasterBankCacheModel
	implements CacheModel<MasterBank>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MasterBankCacheModel)) {
			return false;
		}

		MasterBankCacheModel masterBankCacheModel =
			(MasterBankCacheModel)object;

		if (masterBankId == masterBankCacheModel.masterBankId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, masterBankId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{masterBankId=");
		sb.append(masterBankId);
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
		sb.append(", bankCode=");
		sb.append(bankCode);
		sb.append(", bankDesc=");
		sb.append(bankDesc);
		sb.append(", name=");
		sb.append(name);
		sb.append(", detail=");
		sb.append(detail);
		sb.append(", imageURL=");
		sb.append(imageURL);
		sb.append(", imageFileEntryId=");
		sb.append(imageFileEntryId);
		sb.append(", order=");
		sb.append(order);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MasterBank toEntityModel() {
		MasterBankImpl masterBankImpl = new MasterBankImpl();

		masterBankImpl.setMasterBankId(masterBankId);
		masterBankImpl.setGroupId(groupId);
		masterBankImpl.setCompanyId(companyId);
		masterBankImpl.setUserId(userId);

		if (userName == null) {
			masterBankImpl.setUserName("");
		}
		else {
			masterBankImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			masterBankImpl.setCreateDate(null);
		}
		else {
			masterBankImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			masterBankImpl.setModifiedDate(null);
		}
		else {
			masterBankImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (bankCode == null) {
			masterBankImpl.setBankCode("");
		}
		else {
			masterBankImpl.setBankCode(bankCode);
		}

		if (bankDesc == null) {
			masterBankImpl.setBankDesc("");
		}
		else {
			masterBankImpl.setBankDesc(bankDesc);
		}

		if (name == null) {
			masterBankImpl.setName("");
		}
		else {
			masterBankImpl.setName(name);
		}

		if (detail == null) {
			masterBankImpl.setDetail("");
		}
		else {
			masterBankImpl.setDetail(detail);
		}

		if (imageURL == null) {
			masterBankImpl.setImageURL("");
		}
		else {
			masterBankImpl.setImageURL(imageURL);
		}

		masterBankImpl.setImageFileEntryId(imageFileEntryId);
		masterBankImpl.setOrder(order);
		masterBankImpl.setActive(active);

		masterBankImpl.resetOriginalValues();

		return masterBankImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		masterBankId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		bankCode = objectInput.readUTF();
		bankDesc = objectInput.readUTF();
		name = objectInput.readUTF();
		detail = objectInput.readUTF();
		imageURL = objectInput.readUTF();

		imageFileEntryId = objectInput.readLong();

		order = objectInput.readInt();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(masterBankId);

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

		if (bankCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankCode);
		}

		if (bankDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankDesc);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (detail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(detail);
		}

		if (imageURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imageURL);
		}

		objectOutput.writeLong(imageFileEntryId);

		objectOutput.writeInt(order);

		objectOutput.writeInt(active);
	}

	public long masterBankId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String bankCode;
	public String bankDesc;
	public String name;
	public String detail;
	public String imageURL;
	public long imageFileEntryId;
	public int order;
	public int active;

}