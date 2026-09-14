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

import com.mypage.admin.product.model.SmartActiveTopro;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SmartActiveTopro in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class SmartActiveToproCacheModel
	implements CacheModel<SmartActiveTopro>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SmartActiveToproCacheModel)) {
			return false;
		}

		SmartActiveToproCacheModel smartActiveToproCacheModel =
			(SmartActiveToproCacheModel)object;

		if (smartActiveToproId ==
				smartActiveToproCacheModel.smartActiveToproId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, smartActiveToproId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{smartActiveToproId=");
		sb.append(smartActiveToproId);
		sb.append(", topro=");
		sb.append(topro);
		sb.append(", description=");
		sb.append(description);
		sb.append(", annotations=");
		sb.append(annotations);
		sb.append(", smartActiveBenefitValueId=");
		sb.append(smartActiveBenefitValueId);
		sb.append(", toc=");
		sb.append(toc);
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
	public SmartActiveTopro toEntityModel() {
		SmartActiveToproImpl smartActiveToproImpl = new SmartActiveToproImpl();

		smartActiveToproImpl.setSmartActiveToproId(smartActiveToproId);

		if (topro == null) {
			smartActiveToproImpl.setTopro("");
		}
		else {
			smartActiveToproImpl.setTopro(topro);
		}

		if (description == null) {
			smartActiveToproImpl.setDescription("");
		}
		else {
			smartActiveToproImpl.setDescription(description);
		}

		if (annotations == null) {
			smartActiveToproImpl.setAnnotations("");
		}
		else {
			smartActiveToproImpl.setAnnotations(annotations);
		}

		smartActiveToproImpl.setSmartActiveBenefitValueId(
			smartActiveBenefitValueId);

		if (toc == null) {
			smartActiveToproImpl.setToc("");
		}
		else {
			smartActiveToproImpl.setToc(toc);
		}

		smartActiveToproImpl.setActive(active);
		smartActiveToproImpl.setGroupId(groupId);
		smartActiveToproImpl.setCompanyId(companyId);
		smartActiveToproImpl.setUserId(userId);

		if (userName == null) {
			smartActiveToproImpl.setUserName("");
		}
		else {
			smartActiveToproImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			smartActiveToproImpl.setCreateDate(null);
		}
		else {
			smartActiveToproImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			smartActiveToproImpl.setModifiedDate(null);
		}
		else {
			smartActiveToproImpl.setModifiedDate(new Date(modifiedDate));
		}

		smartActiveToproImpl.resetOriginalValues();

		return smartActiveToproImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		smartActiveToproId = objectInput.readLong();
		topro = objectInput.readUTF();
		description = objectInput.readUTF();
		annotations = objectInput.readUTF();

		smartActiveBenefitValueId = objectInput.readLong();
		toc = objectInput.readUTF();

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
		objectOutput.writeLong(smartActiveToproId);

		if (topro == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(topro);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (annotations == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(annotations);
		}

		objectOutput.writeLong(smartActiveBenefitValueId);

		if (toc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(toc);
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

	public long smartActiveToproId;
	public String topro;
	public String description;
	public String annotations;
	public long smartActiveBenefitValueId;
	public String toc;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}