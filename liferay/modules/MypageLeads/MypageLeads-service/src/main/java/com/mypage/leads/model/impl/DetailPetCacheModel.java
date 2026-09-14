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

package com.mypage.leads.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.mypage.leads.model.DetailPet;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DetailPet in entity cache.
 *
 * @author Gositus
 * @generated
 */
public class DetailPetCacheModel
	implements CacheModel<DetailPet>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DetailPetCacheModel)) {
			return false;
		}

		DetailPetCacheModel detailPetCacheModel = (DetailPetCacheModel)object;

		if (detailPetId == detailPetCacheModel.detailPetId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, detailPetId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{detailPetId=");
		sb.append(detailPetId);
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
		sb.append(", LeadsId=");
		sb.append(LeadsId);
		sb.append(", PlanId=");
		sb.append(PlanId);
		sb.append(", LimitDisability=");
		sb.append(LimitDisability);
		sb.append(", LimitMedical=");
		sb.append(LimitMedical);
		sb.append(", LimitThirdParty=");
		sb.append(LimitThirdParty);
		sb.append(", LimitCustody=");
		sb.append(LimitCustody);
		sb.append(", PetName=");
		sb.append(PetName);
		sb.append(", PetType=");
		sb.append(PetType);
		sb.append(", PetGender=");
		sb.append(PetGender);
		sb.append(", PetDob=");
		sb.append(PetDob);
		sb.append(", PetIdNumber=");
		sb.append(PetIdNumber);
		sb.append(", PetIdNumberIssuing=");
		sb.append(PetIdNumberIssuing);
		sb.append(", PetIdNumberFileEntryId=");
		sb.append(PetIdNumberFileEntryId);
		sb.append(", PetIdNumberURL=");
		sb.append(PetIdNumberURL);
		sb.append(", PetPhotoFileEntryId=");
		sb.append(PetPhotoFileEntryId);
		sb.append(", PetPhotoURL=");
		sb.append(PetPhotoURL);
		sb.append(", PetLocation=");
		sb.append(PetLocation);
		sb.append(", PetVaccine=");
		sb.append(PetVaccine);
		sb.append(", PetAuthorizedCertificate=");
		sb.append(PetAuthorizedCertificate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DetailPet toEntityModel() {
		DetailPetImpl detailPetImpl = new DetailPetImpl();

		detailPetImpl.setDetailPetId(detailPetId);
		detailPetImpl.setGroupId(groupId);
		detailPetImpl.setCompanyId(companyId);
		detailPetImpl.setUserId(userId);

		if (userName == null) {
			detailPetImpl.setUserName("");
		}
		else {
			detailPetImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			detailPetImpl.setCreateDate(null);
		}
		else {
			detailPetImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			detailPetImpl.setModifiedDate(null);
		}
		else {
			detailPetImpl.setModifiedDate(new Date(modifiedDate));
		}

		detailPetImpl.setLeadsId(LeadsId);
		detailPetImpl.setPlanId(PlanId);
		detailPetImpl.setLimitDisability(LimitDisability);
		detailPetImpl.setLimitMedical(LimitMedical);
		detailPetImpl.setLimitThirdParty(LimitThirdParty);
		detailPetImpl.setLimitCustody(LimitCustody);

		if (PetName == null) {
			detailPetImpl.setPetName("");
		}
		else {
			detailPetImpl.setPetName(PetName);
		}

		if (PetType == null) {
			detailPetImpl.setPetType("");
		}
		else {
			detailPetImpl.setPetType(PetType);
		}

		if (PetGender == null) {
			detailPetImpl.setPetGender("");
		}
		else {
			detailPetImpl.setPetGender(PetGender);
		}

		if (PetDob == Long.MIN_VALUE) {
			detailPetImpl.setPetDob(null);
		}
		else {
			detailPetImpl.setPetDob(new Date(PetDob));
		}

		if (PetIdNumber == null) {
			detailPetImpl.setPetIdNumber("");
		}
		else {
			detailPetImpl.setPetIdNumber(PetIdNumber);
		}

		if (PetIdNumberIssuing == null) {
			detailPetImpl.setPetIdNumberIssuing("");
		}
		else {
			detailPetImpl.setPetIdNumberIssuing(PetIdNumberIssuing);
		}

		detailPetImpl.setPetIdNumberFileEntryId(PetIdNumberFileEntryId);

		if (PetIdNumberURL == null) {
			detailPetImpl.setPetIdNumberURL("");
		}
		else {
			detailPetImpl.setPetIdNumberURL(PetIdNumberURL);
		}

		detailPetImpl.setPetPhotoFileEntryId(PetPhotoFileEntryId);

		if (PetPhotoURL == null) {
			detailPetImpl.setPetPhotoURL("");
		}
		else {
			detailPetImpl.setPetPhotoURL(PetPhotoURL);
		}

		if (PetLocation == null) {
			detailPetImpl.setPetLocation("");
		}
		else {
			detailPetImpl.setPetLocation(PetLocation);
		}

		detailPetImpl.setPetVaccine(PetVaccine);
		detailPetImpl.setPetAuthorizedCertificate(PetAuthorizedCertificate);

		detailPetImpl.resetOriginalValues();

		return detailPetImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		detailPetId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		LeadsId = objectInput.readLong();

		PlanId = objectInput.readLong();

		LimitDisability = objectInput.readDouble();

		LimitMedical = objectInput.readDouble();

		LimitThirdParty = objectInput.readDouble();

		LimitCustody = objectInput.readDouble();
		PetName = objectInput.readUTF();
		PetType = objectInput.readUTF();
		PetGender = objectInput.readUTF();
		PetDob = objectInput.readLong();
		PetIdNumber = objectInput.readUTF();
		PetIdNumberIssuing = objectInput.readUTF();

		PetIdNumberFileEntryId = objectInput.readLong();
		PetIdNumberURL = objectInput.readUTF();

		PetPhotoFileEntryId = objectInput.readLong();
		PetPhotoURL = objectInput.readUTF();
		PetLocation = objectInput.readUTF();

		PetVaccine = objectInput.readInt();

		PetAuthorizedCertificate = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(detailPetId);

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

		objectOutput.writeLong(LeadsId);

		objectOutput.writeLong(PlanId);

		objectOutput.writeDouble(LimitDisability);

		objectOutput.writeDouble(LimitMedical);

		objectOutput.writeDouble(LimitThirdParty);

		objectOutput.writeDouble(LimitCustody);

		if (PetName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PetName);
		}

		if (PetType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PetType);
		}

		if (PetGender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PetGender);
		}

		objectOutput.writeLong(PetDob);

		if (PetIdNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PetIdNumber);
		}

		if (PetIdNumberIssuing == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PetIdNumberIssuing);
		}

		objectOutput.writeLong(PetIdNumberFileEntryId);

		if (PetIdNumberURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PetIdNumberURL);
		}

		objectOutput.writeLong(PetPhotoFileEntryId);

		if (PetPhotoURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PetPhotoURL);
		}

		if (PetLocation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PetLocation);
		}

		objectOutput.writeInt(PetVaccine);

		objectOutput.writeInt(PetAuthorizedCertificate);
	}

	public long detailPetId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long LeadsId;
	public long PlanId;
	public double LimitDisability;
	public double LimitMedical;
	public double LimitThirdParty;
	public double LimitCustody;
	public String PetName;
	public String PetType;
	public String PetGender;
	public long PetDob;
	public String PetIdNumber;
	public String PetIdNumberIssuing;
	public long PetIdNumberFileEntryId;
	public String PetIdNumberURL;
	public long PetPhotoFileEntryId;
	public String PetPhotoURL;
	public String PetLocation;
	public int PetVaccine;
	public int PetAuthorizedCertificate;

}