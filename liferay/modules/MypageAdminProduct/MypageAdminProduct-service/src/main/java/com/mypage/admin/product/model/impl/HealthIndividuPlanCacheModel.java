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

import com.mypage.admin.product.model.HealthIndividuPlan;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing HealthIndividuPlan in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class HealthIndividuPlanCacheModel
	implements CacheModel<HealthIndividuPlan>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HealthIndividuPlanCacheModel)) {
			return false;
		}

		HealthIndividuPlanCacheModel healthIndividuPlanCacheModel =
			(HealthIndividuPlanCacheModel)object;

		if (healthIndividuPlanId ==
				healthIndividuPlanCacheModel.healthIndividuPlanId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, healthIndividuPlanId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{healthIndividuPlanId=");
		sb.append(healthIndividuPlanId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", limitYear=");
		sb.append(limitYear);
		sb.append(", limitDisability=");
		sb.append(limitDisability);
		sb.append(", inpatient=");
		sb.append(inpatient);
		sb.append(", outpatient=");
		sb.append(outpatient);
		sb.append(", ambulanceService=");
		sb.append(ambulanceService);
		sb.append(", personalAccident=");
		sb.append(personalAccident);
		sb.append(", detail=");
		sb.append(detail);
		sb.append(", benefit=");
		sb.append(benefit);
		sb.append(", benefitIcon=");
		sb.append(benefitIcon);
		sb.append(", recommended=");
		sb.append(recommended);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public HealthIndividuPlan toEntityModel() {
		HealthIndividuPlanImpl healthIndividuPlanImpl =
			new HealthIndividuPlanImpl();

		healthIndividuPlanImpl.setHealthIndividuPlanId(healthIndividuPlanId);
		healthIndividuPlanImpl.setGroupId(groupId);
		healthIndividuPlanImpl.setCompanyId(companyId);
		healthIndividuPlanImpl.setUserId(userId);

		if (userName == null) {
			healthIndividuPlanImpl.setUserName("");
		}
		else {
			healthIndividuPlanImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			healthIndividuPlanImpl.setCreateDate(null);
		}
		else {
			healthIndividuPlanImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			healthIndividuPlanImpl.setModifiedDate(null);
		}
		else {
			healthIndividuPlanImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			healthIndividuPlanImpl.setName("");
		}
		else {
			healthIndividuPlanImpl.setName(name);
		}

		healthIndividuPlanImpl.setLimitYear(limitYear);
		healthIndividuPlanImpl.setLimitDisability(limitDisability);
		healthIndividuPlanImpl.setInpatient(inpatient);
		healthIndividuPlanImpl.setOutpatient(outpatient);
		healthIndividuPlanImpl.setAmbulanceService(ambulanceService);
		healthIndividuPlanImpl.setPersonalAccident(personalAccident);

		if (detail == null) {
			healthIndividuPlanImpl.setDetail("");
		}
		else {
			healthIndividuPlanImpl.setDetail(detail);
		}

		if (benefit == null) {
			healthIndividuPlanImpl.setBenefit("");
		}
		else {
			healthIndividuPlanImpl.setBenefit(benefit);
		}

		if (benefitIcon == null) {
			healthIndividuPlanImpl.setBenefitIcon("");
		}
		else {
			healthIndividuPlanImpl.setBenefitIcon(benefitIcon);
		}

		healthIndividuPlanImpl.setRecommended(recommended);
		healthIndividuPlanImpl.setActive(active);

		healthIndividuPlanImpl.resetOriginalValues();

		return healthIndividuPlanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		healthIndividuPlanId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();

		limitYear = objectInput.readLong();

		limitDisability = objectInput.readLong();

		inpatient = objectInput.readLong();

		outpatient = objectInput.readLong();

		ambulanceService = objectInput.readLong();

		personalAccident = objectInput.readLong();
		detail = objectInput.readUTF();
		benefit = objectInput.readUTF();
		benefitIcon = objectInput.readUTF();

		recommended = objectInput.readInt();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(healthIndividuPlanId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(limitYear);

		objectOutput.writeLong(limitDisability);

		objectOutput.writeLong(inpatient);

		objectOutput.writeLong(outpatient);

		objectOutput.writeLong(ambulanceService);

		objectOutput.writeLong(personalAccident);

		if (detail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(detail);
		}

		if (benefit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benefit);
		}

		if (benefitIcon == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benefitIcon);
		}

		objectOutput.writeInt(recommended);

		objectOutput.writeInt(active);
	}

	public long healthIndividuPlanId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public long limitYear;
	public long limitDisability;
	public long inpatient;
	public long outpatient;
	public long ambulanceService;
	public long personalAccident;
	public String detail;
	public String benefit;
	public String benefitIcon;
	public int recommended;
	public int active;

}