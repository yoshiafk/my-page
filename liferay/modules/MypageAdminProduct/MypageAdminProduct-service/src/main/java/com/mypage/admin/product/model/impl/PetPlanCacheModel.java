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

import com.mypage.admin.product.model.PetPlan;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PetPlan in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class PetPlanCacheModel implements CacheModel<PetPlan>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PetPlanCacheModel)) {
			return false;
		}

		PetPlanCacheModel petPlanCacheModel = (PetPlanCacheModel)object;

		if (petPlanId == petPlanCacheModel.petPlanId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, petPlanId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", petPlanId=");
		sb.append(petPlanId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", limitDisability=");
		sb.append(limitDisability);
		sb.append(", limitMedical=");
		sb.append(limitMedical);
		sb.append(", limitThirdParty=");
		sb.append(limitThirdParty);
		sb.append(", limitCustody=");
		sb.append(limitCustody);
		sb.append(", recommended=");
		sb.append(recommended);
		sb.append(", customPlan=");
		sb.append(customPlan);
		sb.append(", benefit=");
		sb.append(benefit);
		sb.append(", pimcorePlanId=");
		sb.append(pimcorePlanId);
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
	public PetPlan toEntityModel() {
		PetPlanImpl petPlanImpl = new PetPlanImpl();

		if (uuid == null) {
			petPlanImpl.setUuid("");
		}
		else {
			petPlanImpl.setUuid(uuid);
		}

		petPlanImpl.setPetPlanId(petPlanId);

		if (name == null) {
			petPlanImpl.setName("");
		}
		else {
			petPlanImpl.setName(name);
		}

		petPlanImpl.setLimitDisability(limitDisability);
		petPlanImpl.setLimitMedical(limitMedical);
		petPlanImpl.setLimitThirdParty(limitThirdParty);
		petPlanImpl.setLimitCustody(limitCustody);
		petPlanImpl.setRecommended(recommended);
		petPlanImpl.setCustomPlan(customPlan);

		if (benefit == null) {
			petPlanImpl.setBenefit("");
		}
		else {
			petPlanImpl.setBenefit(benefit);
		}

		petPlanImpl.setPimcorePlanId(pimcorePlanId);
		petPlanImpl.setActive(active);
		petPlanImpl.setGroupId(groupId);
		petPlanImpl.setCompanyId(companyId);
		petPlanImpl.setUserId(userId);

		if (userName == null) {
			petPlanImpl.setUserName("");
		}
		else {
			petPlanImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			petPlanImpl.setCreateDate(null);
		}
		else {
			petPlanImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			petPlanImpl.setModifiedDate(null);
		}
		else {
			petPlanImpl.setModifiedDate(new Date(modifiedDate));
		}

		petPlanImpl.resetOriginalValues();

		return petPlanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		petPlanId = objectInput.readLong();
		name = objectInput.readUTF();

		limitDisability = objectInput.readLong();

		limitMedical = objectInput.readLong();

		limitThirdParty = objectInput.readLong();

		limitCustody = objectInput.readLong();

		recommended = objectInput.readInt();

		customPlan = objectInput.readInt();
		benefit = objectInput.readUTF();

		pimcorePlanId = objectInput.readLong();

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
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(petPlanId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(limitDisability);

		objectOutput.writeLong(limitMedical);

		objectOutput.writeLong(limitThirdParty);

		objectOutput.writeLong(limitCustody);

		objectOutput.writeInt(recommended);

		objectOutput.writeInt(customPlan);

		if (benefit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benefit);
		}

		objectOutput.writeLong(pimcorePlanId);

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

	public String uuid;
	public long petPlanId;
	public String name;
	public long limitDisability;
	public long limitMedical;
	public long limitThirdParty;
	public long limitCustody;
	public int recommended;
	public int customPlan;
	public String benefit;
	public long pimcorePlanId;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}