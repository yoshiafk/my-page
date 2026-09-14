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

package com.mypage.admin.product.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.admin.product.service.http.ProductConfigurationServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ProductConfigurationSoap implements Serializable {

	public static ProductConfigurationSoap toSoapModel(
		ProductConfiguration model) {

		ProductConfigurationSoap soapModel = new ProductConfigurationSoap();

		soapModel.setProductId(model.getProductId());
		soapModel.setProductCode(model.getProductCode());
		soapModel.setProductName(model.getProductName());
		soapModel.setOjkName(model.getOjkName());
		soapModel.setStampdutyIDR(model.getStampdutyIDR());
		soapModel.setStampdutyUSD(model.getStampdutyUSD());
		soapModel.setPolicyCostIDR(model.getPolicyCostIDR());
		soapModel.setPolicyCostUSD(model.getPolicyCostUSD());
		soapModel.setAclStatus(model.getAclStatus());
		soapModel.setAclGracePeriod(model.getAclGracePeriod());
		soapModel.setCommission(model.getCommission());
		soapModel.setWebContentFolderId(model.getWebContentFolderId());
		soapModel.setLink(model.getLink());
		soapModel.setIsB2C(model.getIsB2C());
		soapModel.setIsB2B(model.getIsB2B());
		soapModel.setIsB2B2C(model.getIsB2B2C());
		soapModel.setIconFileEntryId(model.getIconFileEntryId());
		soapModel.setImageFileEntryId(model.getImageFileEntryId());
		soapModel.setPepEnable(model.getPepEnable());
		soapModel.setPolicyWordingEntryId(model.getPolicyWordingEntryId());
		soapModel.setMetaTitle(model.getMetaTitle());
		soapModel.setMetaDescription(model.getMetaDescription());
		soapModel.setMetaKeywords(model.getMetaKeywords());

		return soapModel;
	}

	public static ProductConfigurationSoap[] toSoapModels(
		ProductConfiguration[] models) {

		ProductConfigurationSoap[] soapModels =
			new ProductConfigurationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductConfigurationSoap[][] toSoapModels(
		ProductConfiguration[][] models) {

		ProductConfigurationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ProductConfigurationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductConfigurationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductConfigurationSoap[] toSoapModels(
		List<ProductConfiguration> models) {

		List<ProductConfigurationSoap> soapModels =
			new ArrayList<ProductConfigurationSoap>(models.size());

		for (ProductConfiguration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ProductConfigurationSoap[soapModels.size()]);
	}

	public ProductConfigurationSoap() {
	}

	public long getPrimaryKey() {
		return _productId;
	}

	public void setPrimaryKey(long pk) {
		setProductId(pk);
	}

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public String getProductCode() {
		return _productCode;
	}

	public void setProductCode(String productCode) {
		_productCode = productCode;
	}

	public String getProductName() {
		return _productName;
	}

	public void setProductName(String productName) {
		_productName = productName;
	}

	public String getOjkName() {
		return _ojkName;
	}

	public void setOjkName(String ojkName) {
		_ojkName = ojkName;
	}

	public Double getStampdutyIDR() {
		return _stampdutyIDR;
	}

	public void setStampdutyIDR(Double stampdutyIDR) {
		_stampdutyIDR = stampdutyIDR;
	}

	public Double getStampdutyUSD() {
		return _stampdutyUSD;
	}

	public void setStampdutyUSD(Double stampdutyUSD) {
		_stampdutyUSD = stampdutyUSD;
	}

	public Double getPolicyCostIDR() {
		return _policyCostIDR;
	}

	public void setPolicyCostIDR(Double policyCostIDR) {
		_policyCostIDR = policyCostIDR;
	}

	public Double getPolicyCostUSD() {
		return _policyCostUSD;
	}

	public void setPolicyCostUSD(Double policyCostUSD) {
		_policyCostUSD = policyCostUSD;
	}

	public int getAclStatus() {
		return _aclStatus;
	}

	public void setAclStatus(int aclStatus) {
		_aclStatus = aclStatus;
	}

	public int getAclGracePeriod() {
		return _aclGracePeriod;
	}

	public void setAclGracePeriod(int aclGracePeriod) {
		_aclGracePeriod = aclGracePeriod;
	}

	public Double getCommission() {
		return _commission;
	}

	public void setCommission(Double commission) {
		_commission = commission;
	}

	public int getWebContentFolderId() {
		return _webContentFolderId;
	}

	public void setWebContentFolderId(int webContentFolderId) {
		_webContentFolderId = webContentFolderId;
	}

	public String getLink() {
		return _link;
	}

	public void setLink(String link) {
		_link = link;
	}

	public int getIsB2C() {
		return _isB2C;
	}

	public void setIsB2C(int isB2C) {
		_isB2C = isB2C;
	}

	public int getIsB2B() {
		return _isB2B;
	}

	public void setIsB2B(int isB2B) {
		_isB2B = isB2B;
	}

	public int getIsB2B2C() {
		return _isB2B2C;
	}

	public void setIsB2B2C(int isB2B2C) {
		_isB2B2C = isB2B2C;
	}

	public Long getIconFileEntryId() {
		return _iconFileEntryId;
	}

	public void setIconFileEntryId(Long iconFileEntryId) {
		_iconFileEntryId = iconFileEntryId;
	}

	public Long getImageFileEntryId() {
		return _imageFileEntryId;
	}

	public void setImageFileEntryId(Long imageFileEntryId) {
		_imageFileEntryId = imageFileEntryId;
	}

	public int getPepEnable() {
		return _pepEnable;
	}

	public void setPepEnable(int pepEnable) {
		_pepEnable = pepEnable;
	}

	public Long getPolicyWordingEntryId() {
		return _policyWordingEntryId;
	}

	public void setPolicyWordingEntryId(Long policyWordingEntryId) {
		_policyWordingEntryId = policyWordingEntryId;
	}

	public String getMetaTitle() {
		return _metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		_metaTitle = metaTitle;
	}

	public String getMetaDescription() {
		return _metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		_metaDescription = metaDescription;
	}

	public String getMetaKeywords() {
		return _metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		_metaKeywords = metaKeywords;
	}

	private long _productId;
	private String _productCode;
	private String _productName;
	private String _ojkName;
	private Double _stampdutyIDR;
	private Double _stampdutyUSD;
	private Double _policyCostIDR;
	private Double _policyCostUSD;
	private int _aclStatus;
	private int _aclGracePeriod;
	private Double _commission;
	private int _webContentFolderId;
	private String _link;
	private int _isB2C;
	private int _isB2B;
	private int _isB2B2C;
	private Long _iconFileEntryId;
	private Long _imageFileEntryId;
	private int _pepEnable;
	private Long _policyWordingEntryId;
	private String _metaTitle;
	private String _metaDescription;
	private String _metaKeywords;

}