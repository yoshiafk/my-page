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

import com.mypage.admin.product.model.Benefit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Benefit in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class BenefitCacheModel implements CacheModel<Benefit>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BenefitCacheModel)) {
			return false;
		}

		BenefitCacheModel benefitCacheModel = (BenefitCacheModel)object;

		if (benefitId == benefitCacheModel.benefitId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, benefitId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{benefitId=");
		sb.append(benefitId);
		sb.append(", nameId=");
		sb.append(nameId);
		sb.append(", nameEn=");
		sb.append(nameEn);
		sb.append(", sort=");
		sb.append(sort);
		sb.append(", benefitTypeId=");
		sb.append(benefitTypeId);
		sb.append(", active=");
		sb.append(active);
		sb.append(", planName=");
		sb.append(planName);
		sb.append(", benefitValue=");
		sb.append(benefitValue);
		sb.append(", externalCode=");
		sb.append(externalCode);
		sb.append(", benefitDescription=");
		sb.append(benefitDescription);
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
	public Benefit toEntityModel() {
		BenefitImpl benefitImpl = new BenefitImpl();

		benefitImpl.setBenefitId(benefitId);

		if (nameId == null) {
			benefitImpl.setNameId("");
		}
		else {
			benefitImpl.setNameId(nameId);
		}

		if (nameEn == null) {
			benefitImpl.setNameEn("");
		}
		else {
			benefitImpl.setNameEn(nameEn);
		}

		benefitImpl.setSort(sort);
		benefitImpl.setBenefitTypeId(benefitTypeId);
		benefitImpl.setActive(active);

		if (planName == null) {
			benefitImpl.setPlanName("");
		}
		else {
			benefitImpl.setPlanName(planName);
		}

		if (benefitValue == null) {
			benefitImpl.setBenefitValue("");
		}
		else {
			benefitImpl.setBenefitValue(benefitValue);
		}

		if (externalCode == null) {
			benefitImpl.setExternalCode("");
		}
		else {
			benefitImpl.setExternalCode(externalCode);
		}

		if (benefitDescription == null) {
			benefitImpl.setBenefitDescription("");
		}
		else {
			benefitImpl.setBenefitDescription(benefitDescription);
		}

		benefitImpl.setGroupId(groupId);
		benefitImpl.setCompanyId(companyId);
		benefitImpl.setUserId(userId);

		if (userName == null) {
			benefitImpl.setUserName("");
		}
		else {
			benefitImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			benefitImpl.setCreateDate(null);
		}
		else {
			benefitImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			benefitImpl.setModifiedDate(null);
		}
		else {
			benefitImpl.setModifiedDate(new Date(modifiedDate));
		}

		benefitImpl.resetOriginalValues();

		return benefitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		benefitId = objectInput.readLong();
		nameId = objectInput.readUTF();
		nameEn = objectInput.readUTF();

		sort = objectInput.readInt();

		benefitTypeId = objectInput.readLong();

		active = objectInput.readInt();
		planName = objectInput.readUTF();
		benefitValue = objectInput.readUTF();
		externalCode = objectInput.readUTF();
		benefitDescription = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(benefitId);

		if (nameId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameId);
		}

		if (nameEn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameEn);
		}

		objectOutput.writeInt(sort);

		objectOutput.writeLong(benefitTypeId);

		objectOutput.writeInt(active);

		if (planName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(planName);
		}

		if (benefitValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benefitValue);
		}

		if (externalCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalCode);
		}

		if (benefitDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benefitDescription);
		}

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

	public long benefitId;
	public String nameId;
	public String nameEn;
	public int sort;
	public long benefitTypeId;
	public int active;
	public String planName;
	public String benefitValue;
	public String externalCode;
	public String benefitDescription;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}