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

import com.mypage.admin.product.model.PetDetail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PetDetail in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class PetDetailCacheModel
	implements CacheModel<PetDetail>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PetDetailCacheModel)) {
			return false;
		}

		PetDetailCacheModel petDetailCacheModel = (PetDetailCacheModel)object;

		if (petDetailId == petDetailCacheModel.petDetailId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, petDetailId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{petDetailId=");
		sb.append(petDetailId);
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
		sb.append(", remarksAValue=");
		sb.append(remarksAValue);
		sb.append(", remarksBValue=");
		sb.append(remarksBValue);
		sb.append(", remarksCValue=");
		sb.append(remarksCValue);
		sb.append(", remarksDValue=");
		sb.append(remarksDValue);
		sb.append(", petName=");
		sb.append(petName);
		sb.append(", petType=");
		sb.append(petType);
		sb.append(", petGender=");
		sb.append(petGender);
		sb.append(", petDob=");
		sb.append(petDob);
		sb.append(", petIdNumber=");
		sb.append(petIdNumber);
		sb.append(", petIdNumberIssuing=");
		sb.append(petIdNumberIssuing);
		sb.append(", petIdNumberFile=");
		sb.append(petIdNumberFile);
		sb.append(", petPhoto=");
		sb.append(petPhoto);
		sb.append(", petLocation=");
		sb.append(petLocation);
		sb.append(", petVaccine=");
		sb.append(petVaccine);
		sb.append(", petAuthorizedCertificate=");
		sb.append(petAuthorizedCertificate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PetDetail toEntityModel() {
		PetDetailImpl petDetailImpl = new PetDetailImpl();

		petDetailImpl.setPetDetailId(petDetailId);
		petDetailImpl.setGroupId(groupId);
		petDetailImpl.setCompanyId(companyId);
		petDetailImpl.setUserId(userId);

		if (userName == null) {
			petDetailImpl.setUserName("");
		}
		else {
			petDetailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			petDetailImpl.setCreateDate(null);
		}
		else {
			petDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			petDetailImpl.setModifiedDate(null);
		}
		else {
			petDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (remarksAValue == null) {
			petDetailImpl.setRemarksAValue("");
		}
		else {
			petDetailImpl.setRemarksAValue(remarksAValue);
		}

		if (remarksBValue == null) {
			petDetailImpl.setRemarksBValue("");
		}
		else {
			petDetailImpl.setRemarksBValue(remarksBValue);
		}

		if (remarksCValue == null) {
			petDetailImpl.setRemarksCValue("");
		}
		else {
			petDetailImpl.setRemarksCValue(remarksCValue);
		}

		if (remarksDValue == null) {
			petDetailImpl.setRemarksDValue("");
		}
		else {
			petDetailImpl.setRemarksDValue(remarksDValue);
		}

		if (petName == null) {
			petDetailImpl.setPetName("");
		}
		else {
			petDetailImpl.setPetName(petName);
		}

		petDetailImpl.setPetType(petType);
		petDetailImpl.setPetGender(petGender);

		if (petDob == Long.MIN_VALUE) {
			petDetailImpl.setPetDob(null);
		}
		else {
			petDetailImpl.setPetDob(new Date(petDob));
		}

		if (petIdNumber == null) {
			petDetailImpl.setPetIdNumber("");
		}
		else {
			petDetailImpl.setPetIdNumber(petIdNumber);
		}

		if (petIdNumberIssuing == null) {
			petDetailImpl.setPetIdNumberIssuing("");
		}
		else {
			petDetailImpl.setPetIdNumberIssuing(petIdNumberIssuing);
		}

		if (petIdNumberFile == null) {
			petDetailImpl.setPetIdNumberFile("");
		}
		else {
			petDetailImpl.setPetIdNumberFile(petIdNumberFile);
		}

		if (petPhoto == null) {
			petDetailImpl.setPetPhoto("");
		}
		else {
			petDetailImpl.setPetPhoto(petPhoto);
		}

		if (petLocation == null) {
			petDetailImpl.setPetLocation("");
		}
		else {
			petDetailImpl.setPetLocation(petLocation);
		}

		petDetailImpl.setPetVaccine(petVaccine);
		petDetailImpl.setPetAuthorizedCertificate(petAuthorizedCertificate);

		petDetailImpl.resetOriginalValues();

		return petDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		petDetailId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		remarksAValue = objectInput.readUTF();
		remarksBValue = objectInput.readUTF();
		remarksCValue = objectInput.readUTF();
		remarksDValue = objectInput.readUTF();
		petName = objectInput.readUTF();

		petType = objectInput.readInt();

		petGender = objectInput.readInt();
		petDob = objectInput.readLong();
		petIdNumber = objectInput.readUTF();
		petIdNumberIssuing = objectInput.readUTF();
		petIdNumberFile = objectInput.readUTF();
		petPhoto = objectInput.readUTF();
		petLocation = objectInput.readUTF();

		petVaccine = objectInput.readInt();

		petAuthorizedCertificate = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(petDetailId);

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

		if (remarksAValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarksAValue);
		}

		if (remarksBValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarksBValue);
		}

		if (remarksCValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarksCValue);
		}

		if (remarksDValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(remarksDValue);
		}

		if (petName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(petName);
		}

		objectOutput.writeInt(petType);

		objectOutput.writeInt(petGender);
		objectOutput.writeLong(petDob);

		if (petIdNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(petIdNumber);
		}

		if (petIdNumberIssuing == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(petIdNumberIssuing);
		}

		if (petIdNumberFile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(petIdNumberFile);
		}

		if (petPhoto == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(petPhoto);
		}

		if (petLocation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(petLocation);
		}

		objectOutput.writeInt(petVaccine);

		objectOutput.writeInt(petAuthorizedCertificate);
	}

	public long petDetailId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String remarksAValue;
	public String remarksBValue;
	public String remarksCValue;
	public String remarksDValue;
	public String petName;
	public int petType;
	public int petGender;
	public long petDob;
	public String petIdNumber;
	public String petIdNumberIssuing;
	public String petIdNumberFile;
	public String petPhoto;
	public String petLocation;
	public int petVaccine;
	public int petAuthorizedCertificate;

}