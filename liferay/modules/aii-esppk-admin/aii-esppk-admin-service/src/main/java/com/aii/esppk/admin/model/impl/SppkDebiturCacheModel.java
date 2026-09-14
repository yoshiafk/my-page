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

import com.aii.esppk.admin.model.SppkDebitur;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

import java.util.Date;

/**
 * The cache model class for representing SppkDebitur in entity cache.
 *
 * @author Gositus
 * @generated
 */
public class SppkDebiturCacheModel
	implements CacheModel<SppkDebitur>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SppkDebiturCacheModel)) {
			return false;
		}

		SppkDebiturCacheModel sppkDebiturCacheModel =
			(SppkDebiturCacheModel)object;

		if (sppkDebiturId == sppkDebiturCacheModel.sppkDebiturId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sppkDebiturId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(59);

		sb.append("{sppkDebiturId=");
		sb.append(sppkDebiturId);
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
		sb.append(", applicationNumber=");
		sb.append(applicationNumber);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", birthPlace=");
		sb.append(birthPlace);
		sb.append(", birthDate=");
		sb.append(birthDate);
		sb.append(", idNumber=");
		sb.append(idNumber);
		sb.append(", address=");
		sb.append(address);
		sb.append(", occupation=");
		sb.append(occupation);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", sumInsured=");
		sb.append(sumInsured);
		sb.append(", product=");
		sb.append(product);
		sb.append(", esppkToken=");
		sb.append(esppkToken);
		sb.append(", esppkTokenExpiry=");
		sb.append(esppkTokenExpiry);
		sb.append(", esppkQ1=");
		sb.append(esppkQ1);
		sb.append(", esppkQ2=");
		sb.append(esppkQ2);
		sb.append(", esppkQ3=");
		sb.append(esppkQ3);
		sb.append(", agreeRiplay=");
		sb.append(agreeRiplay);
		sb.append(", agreeStatement=");
		sb.append(agreeStatement);
		sb.append(", needAssistance=");
		sb.append(needAssistance);
		sb.append(", submitEsppkDate=");
		sb.append(submitEsppkDate);
		sb.append(", submissionNumber=");
		sb.append(submissionNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SppkDebitur toEntityModel() {
		SppkDebiturImpl sppkDebiturImpl = new SppkDebiturImpl();

		sppkDebiturImpl.setSppkDebiturId(sppkDebiturId);
		sppkDebiturImpl.setGroupId(groupId);
		sppkDebiturImpl.setCompanyId(companyId);
		sppkDebiturImpl.setUserId(userId);

		if (userName == null) {
			sppkDebiturImpl.setUserName("");
		}
		else {
			sppkDebiturImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			sppkDebiturImpl.setCreateDate(null);
		}
		else {
			sppkDebiturImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			sppkDebiturImpl.setModifiedDate(null);
		}
		else {
			sppkDebiturImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (applicationNumber == null) {
			sppkDebiturImpl.setApplicationNumber("");
		}
		else {
			sppkDebiturImpl.setApplicationNumber(applicationNumber);
		}

		if (fullName == null) {
			sppkDebiturImpl.setFullName("");
		}
		else {
			sppkDebiturImpl.setFullName(fullName);
		}

		if (birthPlace == null) {
			sppkDebiturImpl.setBirthPlace("");
		}
		else {
			sppkDebiturImpl.setBirthPlace(birthPlace);
		}

		if (birthDate == Long.MIN_VALUE) {
			sppkDebiturImpl.setBirthDate(null);
		}
		else {
			sppkDebiturImpl.setBirthDate(new Date(birthDate));
		}

		if (idNumber == null) {
			sppkDebiturImpl.setIdNumber("");
		}
		else {
			sppkDebiturImpl.setIdNumber(idNumber);
		}

		if (address == null) {
			sppkDebiturImpl.setAddress("");
		}
		else {
			sppkDebiturImpl.setAddress(address);
		}

		if (occupation == null) {
			sppkDebiturImpl.setOccupation("");
		}
		else {
			sppkDebiturImpl.setOccupation(occupation);
		}

		if (email == null) {
			sppkDebiturImpl.setEmail("");
		}
		else {
			sppkDebiturImpl.setEmail(email);
		}

		if (phoneNumber == null) {
			sppkDebiturImpl.setPhoneNumber("");
		}
		else {
			sppkDebiturImpl.setPhoneNumber(phoneNumber);
		}

		if (gender == null) {
			sppkDebiturImpl.setGender("");
		}
		else {
			sppkDebiturImpl.setGender(gender);
		}

		sppkDebiturImpl.setSumInsured(sumInsured);

		if (product == null) {
			sppkDebiturImpl.setProduct("");
		}
		else {
			sppkDebiturImpl.setProduct(product);
		}

		if (esppkToken == null) {
			sppkDebiturImpl.setEsppkToken("");
		}
		else {
			sppkDebiturImpl.setEsppkToken(esppkToken);
		}

		if (esppkTokenExpiry == Long.MIN_VALUE) {
			sppkDebiturImpl.setEsppkTokenExpiry(null);
		}
		else {
			sppkDebiturImpl.setEsppkTokenExpiry(new Date(esppkTokenExpiry));
		}

		sppkDebiturImpl.setEsppkQ1(esppkQ1);
		sppkDebiturImpl.setEsppkQ2(esppkQ2);
		sppkDebiturImpl.setEsppkQ3(esppkQ3);
		sppkDebiturImpl.setAgreeRiplay(agreeRiplay);
		sppkDebiturImpl.setAgreeStatement(agreeStatement);
		sppkDebiturImpl.setNeedAssistance(needAssistance);

		if (submitEsppkDate == Long.MIN_VALUE) {
			sppkDebiturImpl.setSubmitEsppkDate(null);
		}
		else {
			sppkDebiturImpl.setSubmitEsppkDate(new Date(submitEsppkDate));
		}

		if (submissionNumber == null) {
			sppkDebiturImpl.setSubmissionNumber("");
		}
		else {
			sppkDebiturImpl.setSubmissionNumber(submissionNumber);
		}

		sppkDebiturImpl.resetOriginalValues();

		return sppkDebiturImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		sppkDebiturId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		applicationNumber = objectInput.readUTF();
		fullName = objectInput.readUTF();
		birthPlace = objectInput.readUTF();
		birthDate = objectInput.readLong();
		idNumber = objectInput.readUTF();
		address = objectInput.readUTF();
		occupation = objectInput.readUTF();
		email = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();
		gender = objectInput.readUTF();
		sumInsured = (BigDecimal)objectInput.readObject();
		product = objectInput.readUTF();
		esppkToken = objectInput.readUTF();
		esppkTokenExpiry = objectInput.readLong();

		esppkQ1 = objectInput.readInt();

		esppkQ2 = objectInput.readInt();

		esppkQ3 = objectInput.readInt();

		agreeRiplay = objectInput.readInt();

		agreeStatement = objectInput.readInt();

		needAssistance = objectInput.readInt();
		submitEsppkDate = objectInput.readLong();
		submissionNumber = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(sppkDebiturId);

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

		if (applicationNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicationNumber);
		}

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (birthPlace == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(birthPlace);
		}

		objectOutput.writeLong(birthDate);

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

		if (occupation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(occupation);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		objectOutput.writeObject(sumInsured);

		if (product == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(product);
		}

		if (esppkToken == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(esppkToken);
		}

		objectOutput.writeLong(esppkTokenExpiry);

		objectOutput.writeInt(esppkQ1);

		objectOutput.writeInt(esppkQ2);

		objectOutput.writeInt(esppkQ3);

		objectOutput.writeInt(agreeRiplay);

		objectOutput.writeInt(agreeStatement);

		objectOutput.writeInt(needAssistance);
		objectOutput.writeLong(submitEsppkDate);

		if (submissionNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(submissionNumber);
		}
	}

	public long sppkDebiturId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String applicationNumber;
	public String fullName;
	public String birthPlace;
	public long birthDate;
	public String idNumber;
	public String address;
	public String occupation;
	public String email;
	public String phoneNumber;
	public String gender;
	public BigDecimal sumInsured;
	public String product;
	public String esppkToken;
	public long esppkTokenExpiry;
	public int esppkQ1;
	public int esppkQ2;
	public int esppkQ3;
	public int agreeRiplay;
	public int agreeStatement;
	public int needAssistance;
	public long submitEsppkDate;
	public String submissionNumber;

}