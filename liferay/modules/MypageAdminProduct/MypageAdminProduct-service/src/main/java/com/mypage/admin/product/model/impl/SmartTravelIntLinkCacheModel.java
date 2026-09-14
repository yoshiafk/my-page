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

import com.mypage.admin.product.model.SmartTravelIntLink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SmartTravelIntLink in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class SmartTravelIntLinkCacheModel
	implements CacheModel<SmartTravelIntLink>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SmartTravelIntLinkCacheModel)) {
			return false;
		}

		SmartTravelIntLinkCacheModel smartTravelIntLinkCacheModel =
			(SmartTravelIntLinkCacheModel)object;

		if (smartTravelIntLinkId ==
				smartTravelIntLinkCacheModel.smartTravelIntLinkId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, smartTravelIntLinkId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{smartTravelIntLinkId=");
		sb.append(smartTravelIntLinkId);
		sb.append(", linkType=");
		sb.append(linkType);
		sb.append(", linkTitle=");
		sb.append(linkTitle);
		sb.append(", linkHref=");
		sb.append(linkHref);
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
	public SmartTravelIntLink toEntityModel() {
		SmartTravelIntLinkImpl smartTravelIntLinkImpl =
			new SmartTravelIntLinkImpl();

		smartTravelIntLinkImpl.setSmartTravelIntLinkId(smartTravelIntLinkId);

		if (linkType == null) {
			smartTravelIntLinkImpl.setLinkType("");
		}
		else {
			smartTravelIntLinkImpl.setLinkType(linkType);
		}

		if (linkTitle == null) {
			smartTravelIntLinkImpl.setLinkTitle("");
		}
		else {
			smartTravelIntLinkImpl.setLinkTitle(linkTitle);
		}

		if (linkHref == null) {
			smartTravelIntLinkImpl.setLinkHref("");
		}
		else {
			smartTravelIntLinkImpl.setLinkHref(linkHref);
		}

		smartTravelIntLinkImpl.setGroupId(groupId);
		smartTravelIntLinkImpl.setCompanyId(companyId);
		smartTravelIntLinkImpl.setUserId(userId);

		if (userName == null) {
			smartTravelIntLinkImpl.setUserName("");
		}
		else {
			smartTravelIntLinkImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			smartTravelIntLinkImpl.setCreateDate(null);
		}
		else {
			smartTravelIntLinkImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			smartTravelIntLinkImpl.setModifiedDate(null);
		}
		else {
			smartTravelIntLinkImpl.setModifiedDate(new Date(modifiedDate));
		}

		smartTravelIntLinkImpl.resetOriginalValues();

		return smartTravelIntLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		smartTravelIntLinkId = objectInput.readLong();
		linkType = objectInput.readUTF();
		linkTitle = objectInput.readUTF();
		linkHref = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(smartTravelIntLinkId);

		if (linkType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(linkType);
		}

		if (linkTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(linkTitle);
		}

		if (linkHref == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(linkHref);
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

	public long smartTravelIntLinkId;
	public String linkType;
	public String linkTitle;
	public String linkHref;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}