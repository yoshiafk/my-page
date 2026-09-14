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

import com.mypage.admin.product.model.Premi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

import java.util.Date;

/**
 * The cache model class for representing Premi in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class PremiCacheModel implements CacheModel<Premi>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PremiCacheModel)) {
			return false;
		}

		PremiCacheModel premiCacheModel = (PremiCacheModel)object;

		if (premiId == premiCacheModel.premiId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, premiId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{premiId=");
		sb.append(premiId);
		sb.append(", travellerType=");
		sb.append(travellerType);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", basic=");
		sb.append(basic);
		sb.append(", additional=");
		sb.append(additional);
		sb.append(", annual=");
		sb.append(annual);
		sb.append(", active=");
		sb.append(active);
		sb.append(", benefitId=");
		sb.append(benefitId);
		sb.append(", planId=");
		sb.append(planId);
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
	public Premi toEntityModel() {
		PremiImpl premiImpl = new PremiImpl();

		premiImpl.setPremiId(premiId);

		if (travellerType == null) {
			premiImpl.setTravellerType("");
		}
		else {
			premiImpl.setTravellerType(travellerType);
		}

		if (currency == null) {
			premiImpl.setCurrency("");
		}
		else {
			premiImpl.setCurrency(currency);
		}

		premiImpl.setBasic(basic);
		premiImpl.setAdditional(additional);
		premiImpl.setAnnual(annual);
		premiImpl.setActive(active);
		premiImpl.setBenefitId(benefitId);
		premiImpl.setPlanId(planId);
		premiImpl.setGroupId(groupId);
		premiImpl.setCompanyId(companyId);
		premiImpl.setUserId(userId);

		if (userName == null) {
			premiImpl.setUserName("");
		}
		else {
			premiImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			premiImpl.setCreateDate(null);
		}
		else {
			premiImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			premiImpl.setModifiedDate(null);
		}
		else {
			premiImpl.setModifiedDate(new Date(modifiedDate));
		}

		premiImpl.resetOriginalValues();

		return premiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		premiId = objectInput.readLong();
		travellerType = objectInput.readUTF();
		currency = objectInput.readUTF();
		basic = (BigDecimal)objectInput.readObject();
		additional = (BigDecimal)objectInput.readObject();
		annual = (BigDecimal)objectInput.readObject();

		active = objectInput.readInt();

		benefitId = objectInput.readLong();

		planId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(premiId);

		if (travellerType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(travellerType);
		}

		if (currency == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currency);
		}

		objectOutput.writeObject(basic);
		objectOutput.writeObject(additional);
		objectOutput.writeObject(annual);

		objectOutput.writeInt(active);

		objectOutput.writeLong(benefitId);

		objectOutput.writeLong(planId);

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

	public long premiId;
	public String travellerType;
	public String currency;
	public BigDecimal basic;
	public BigDecimal additional;
	public BigDecimal annual;
	public int active;
	public long benefitId;
	public long planId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}