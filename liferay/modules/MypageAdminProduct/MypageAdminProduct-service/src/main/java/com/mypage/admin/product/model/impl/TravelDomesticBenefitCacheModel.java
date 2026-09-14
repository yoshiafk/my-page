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

import com.mypage.admin.product.model.TravelDomesticBenefit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TravelDomesticBenefit in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class TravelDomesticBenefitCacheModel
	implements CacheModel<TravelDomesticBenefit>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TravelDomesticBenefitCacheModel)) {
			return false;
		}

		TravelDomesticBenefitCacheModel travelDomesticBenefitCacheModel =
			(TravelDomesticBenefitCacheModel)object;

		if (travelDomesticBenefitId ==
				travelDomesticBenefitCacheModel.travelDomesticBenefitId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, travelDomesticBenefitId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{travelDomesticBenefitId=");
		sb.append(travelDomesticBenefitId);
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
		sb.append(", plan=");
		sb.append(plan);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", benefit=");
		sb.append(benefit);
		sb.append(", benefitValue=");
		sb.append(benefitValue);
		sb.append(", group=");
		sb.append(group);
		sb.append(", sort=");
		sb.append(sort);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TravelDomesticBenefit toEntityModel() {
		TravelDomesticBenefitImpl travelDomesticBenefitImpl =
			new TravelDomesticBenefitImpl();

		travelDomesticBenefitImpl.setTravelDomesticBenefitId(
			travelDomesticBenefitId);
		travelDomesticBenefitImpl.setGroupId(groupId);
		travelDomesticBenefitImpl.setCompanyId(companyId);
		travelDomesticBenefitImpl.setUserId(userId);

		if (userName == null) {
			travelDomesticBenefitImpl.setUserName("");
		}
		else {
			travelDomesticBenefitImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			travelDomesticBenefitImpl.setCreateDate(null);
		}
		else {
			travelDomesticBenefitImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			travelDomesticBenefitImpl.setModifiedDate(null);
		}
		else {
			travelDomesticBenefitImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (plan == null) {
			travelDomesticBenefitImpl.setPlan("");
		}
		else {
			travelDomesticBenefitImpl.setPlan(plan);
		}

		if (amount == null) {
			travelDomesticBenefitImpl.setAmount("");
		}
		else {
			travelDomesticBenefitImpl.setAmount(amount);
		}

		if (benefit == null) {
			travelDomesticBenefitImpl.setBenefit("");
		}
		else {
			travelDomesticBenefitImpl.setBenefit(benefit);
		}

		travelDomesticBenefitImpl.setBenefitValue(benefitValue);

		if (group == null) {
			travelDomesticBenefitImpl.setGroup("");
		}
		else {
			travelDomesticBenefitImpl.setGroup(group);
		}

		travelDomesticBenefitImpl.setSort(sort);
		travelDomesticBenefitImpl.setActive(active);

		travelDomesticBenefitImpl.resetOriginalValues();

		return travelDomesticBenefitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		travelDomesticBenefitId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		plan = objectInput.readUTF();
		amount = objectInput.readUTF();
		benefit = objectInput.readUTF();

		benefitValue = objectInput.readLong();
		group = objectInput.readUTF();

		sort = objectInput.readInt();

		active = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(travelDomesticBenefitId);

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

		if (plan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(plan);
		}

		if (amount == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(amount);
		}

		if (benefit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benefit);
		}

		objectOutput.writeLong(benefitValue);

		if (group == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(group);
		}

		objectOutput.writeInt(sort);

		objectOutput.writeInt(active);
	}

	public long travelDomesticBenefitId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String plan;
	public String amount;
	public String benefit;
	public long benefitValue;
	public String group;
	public int sort;
	public int active;

}