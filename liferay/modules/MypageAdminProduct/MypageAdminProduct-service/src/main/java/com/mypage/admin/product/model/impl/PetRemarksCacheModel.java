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

import com.mypage.admin.product.model.PetRemarks;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PetRemarks in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class PetRemarksCacheModel
	implements CacheModel<PetRemarks>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PetRemarksCacheModel)) {
			return false;
		}

		PetRemarksCacheModel petRemarksCacheModel =
			(PetRemarksCacheModel)object;

		if (petRemarksId == petRemarksCacheModel.petRemarksId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, petRemarksId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{petRemarksId=");
		sb.append(petRemarksId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", code=");
		sb.append(code);
		sb.append(", active=");
		sb.append(active);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PetRemarks toEntityModel() {
		PetRemarksImpl petRemarksImpl = new PetRemarksImpl();

		petRemarksImpl.setPetRemarksId(petRemarksId);

		if (name == null) {
			petRemarksImpl.setName("");
		}
		else {
			petRemarksImpl.setName(name);
		}

		if (code == null) {
			petRemarksImpl.setCode("");
		}
		else {
			petRemarksImpl.setCode(code);
		}

		petRemarksImpl.setActive(active);
		petRemarksImpl.setGroupId(groupId);
		petRemarksImpl.setCompanyId(companyId);
		petRemarksImpl.setUserId(userId);

		if (userName == null) {
			petRemarksImpl.setUserName("");
		}
		else {
			petRemarksImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			petRemarksImpl.setCreateDate(null);
		}
		else {
			petRemarksImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			petRemarksImpl.setModifiedDate(null);
		}
		else {
			petRemarksImpl.setModifiedDate(new Date(modifiedDate));
		}

		petRemarksImpl.resetOriginalValues();

		return petRemarksImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		petRemarksId = objectInput.readLong();
		name = objectInput.readUTF();
		code = objectInput.readUTF();

		active = objectInput.readInt();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(petRemarksId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeInt(active);

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
	}

	public long petRemarksId;
	public String name;
	public String code;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}