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

import com.mypage.admin.product.model.ProductConfiguration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ProductConfiguration in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class ProductConfigurationCacheModel
	implements CacheModel<ProductConfiguration>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductConfigurationCacheModel)) {
			return false;
		}

		ProductConfigurationCacheModel productConfigurationCacheModel =
			(ProductConfigurationCacheModel)object;

		if (productId == productConfigurationCacheModel.productId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, productId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{productId=");
		sb.append(productId);
		sb.append(", productCode=");
		sb.append(productCode);
		sb.append(", productName=");
		sb.append(productName);
		sb.append(", ojkName=");
		sb.append(ojkName);
		sb.append(", stampdutyIDR=");
		sb.append(stampdutyIDR);
		sb.append(", stampdutyUSD=");
		sb.append(stampdutyUSD);
		sb.append(", policyCostIDR=");
		sb.append(policyCostIDR);
		sb.append(", policyCostUSD=");
		sb.append(policyCostUSD);
		sb.append(", aclStatus=");
		sb.append(aclStatus);
		sb.append(", aclGracePeriod=");
		sb.append(aclGracePeriod);
		sb.append(", commission=");
		sb.append(commission);
		sb.append(", webContentFolderId=");
		sb.append(webContentFolderId);
		sb.append(", link=");
		sb.append(link);
		sb.append(", isB2C=");
		sb.append(isB2C);
		sb.append(", isB2B=");
		sb.append(isB2B);
		sb.append(", isB2B2C=");
		sb.append(isB2B2C);
		sb.append(", iconFileEntryId=");
		sb.append(iconFileEntryId);
		sb.append(", imageFileEntryId=");
		sb.append(imageFileEntryId);
		sb.append(", pepEnable=");
		sb.append(pepEnable);
		sb.append(", policyWordingEntryId=");
		sb.append(policyWordingEntryId);
		sb.append(", metaTitle=");
		sb.append(metaTitle);
		sb.append(", metaDescription=");
		sb.append(metaDescription);
		sb.append(", metaKeywords=");
		sb.append(metaKeywords);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProductConfiguration toEntityModel() {
		ProductConfigurationImpl productConfigurationImpl =
			new ProductConfigurationImpl();

		productConfigurationImpl.setProductId(productId);

		if (productCode == null) {
			productConfigurationImpl.setProductCode("");
		}
		else {
			productConfigurationImpl.setProductCode(productCode);
		}

		if (productName == null) {
			productConfigurationImpl.setProductName("");
		}
		else {
			productConfigurationImpl.setProductName(productName);
		}

		if (ojkName == null) {
			productConfigurationImpl.setOjkName("");
		}
		else {
			productConfigurationImpl.setOjkName(ojkName);
		}

		productConfigurationImpl.setStampdutyIDR(stampdutyIDR);
		productConfigurationImpl.setStampdutyUSD(stampdutyUSD);
		productConfigurationImpl.setPolicyCostIDR(policyCostIDR);
		productConfigurationImpl.setPolicyCostUSD(policyCostUSD);
		productConfigurationImpl.setAclStatus(aclStatus);
		productConfigurationImpl.setAclGracePeriod(aclGracePeriod);
		productConfigurationImpl.setCommission(commission);
		productConfigurationImpl.setWebContentFolderId(webContentFolderId);

		if (link == null) {
			productConfigurationImpl.setLink("");
		}
		else {
			productConfigurationImpl.setLink(link);
		}

		productConfigurationImpl.setIsB2C(isB2C);
		productConfigurationImpl.setIsB2B(isB2B);
		productConfigurationImpl.setIsB2B2C(isB2B2C);
		productConfigurationImpl.setIconFileEntryId(iconFileEntryId);
		productConfigurationImpl.setImageFileEntryId(imageFileEntryId);
		productConfigurationImpl.setPepEnable(pepEnable);
		productConfigurationImpl.setPolicyWordingEntryId(policyWordingEntryId);

		if (metaTitle == null) {
			productConfigurationImpl.setMetaTitle("");
		}
		else {
			productConfigurationImpl.setMetaTitle(metaTitle);
		}

		if (metaDescription == null) {
			productConfigurationImpl.setMetaDescription("");
		}
		else {
			productConfigurationImpl.setMetaDescription(metaDescription);
		}

		if (metaKeywords == null) {
			productConfigurationImpl.setMetaKeywords("");
		}
		else {
			productConfigurationImpl.setMetaKeywords(metaKeywords);
		}

		productConfigurationImpl.resetOriginalValues();

		return productConfigurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		productId = objectInput.readLong();
		productCode = objectInput.readUTF();
		productName = objectInput.readUTF();
		ojkName = objectInput.readUTF();

		stampdutyIDR = objectInput.readDouble();

		stampdutyUSD = objectInput.readDouble();

		policyCostIDR = objectInput.readDouble();

		policyCostUSD = objectInput.readDouble();

		aclStatus = objectInput.readInt();

		aclGracePeriod = objectInput.readInt();

		commission = objectInput.readDouble();

		webContentFolderId = objectInput.readInt();
		link = objectInput.readUTF();

		isB2C = objectInput.readInt();

		isB2B = objectInput.readInt();

		isB2B2C = objectInput.readInt();

		iconFileEntryId = objectInput.readLong();

		imageFileEntryId = objectInput.readLong();

		pepEnable = objectInput.readInt();

		policyWordingEntryId = objectInput.readLong();
		metaTitle = objectInput.readUTF();
		metaDescription = objectInput.readUTF();
		metaKeywords = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(productId);

		if (productCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productCode);
		}

		if (productName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productName);
		}

		if (ojkName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ojkName);
		}

		objectOutput.writeDouble(stampdutyIDR);

		objectOutput.writeDouble(stampdutyUSD);

		objectOutput.writeDouble(policyCostIDR);

		objectOutput.writeDouble(policyCostUSD);

		objectOutput.writeInt(aclStatus);

		objectOutput.writeInt(aclGracePeriod);

		objectOutput.writeDouble(commission);

		objectOutput.writeInt(webContentFolderId);

		if (link == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(link);
		}

		objectOutput.writeInt(isB2C);

		objectOutput.writeInt(isB2B);

		objectOutput.writeInt(isB2B2C);

		objectOutput.writeLong(iconFileEntryId);

		objectOutput.writeLong(imageFileEntryId);

		objectOutput.writeInt(pepEnable);

		objectOutput.writeLong(policyWordingEntryId);

		if (metaTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(metaTitle);
		}

		if (metaDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(metaDescription);
		}

		if (metaKeywords == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(metaKeywords);
		}
	}

	public long productId;
	public String productCode;
	public String productName;
	public String ojkName;
	public double stampdutyIDR;
	public double stampdutyUSD;
	public double policyCostIDR;
	public double policyCostUSD;
	public int aclStatus;
	public int aclGracePeriod;
	public double commission;
	public int webContentFolderId;
	public String link;
	public int isB2C;
	public int isB2B;
	public int isB2B2C;
	public long iconFileEntryId;
	public long imageFileEntryId;
	public int pepEnable;
	public long policyWordingEntryId;
	public String metaTitle;
	public String metaDescription;
	public String metaKeywords;

}