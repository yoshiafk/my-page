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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProductConfiguration}.
 * </p>
 *
 * @author Gositus Team
 * @see ProductConfiguration
 * @generated
 */
public class ProductConfigurationWrapper
	extends BaseModelWrapper<ProductConfiguration>
	implements ModelWrapper<ProductConfiguration>, ProductConfiguration {

	public ProductConfigurationWrapper(
		ProductConfiguration productConfiguration) {

		super(productConfiguration);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("productId", getProductId());
		attributes.put("productCode", getProductCode());
		attributes.put("productName", getProductName());
		attributes.put("ojkName", getOjkName());
		attributes.put("stampdutyIDR", getStampdutyIDR());
		attributes.put("stampdutyUSD", getStampdutyUSD());
		attributes.put("policyCostIDR", getPolicyCostIDR());
		attributes.put("policyCostUSD", getPolicyCostUSD());
		attributes.put("aclStatus", getAclStatus());
		attributes.put("aclGracePeriod", getAclGracePeriod());
		attributes.put("commission", getCommission());
		attributes.put("webContentFolderId", getWebContentFolderId());
		attributes.put("link", getLink());
		attributes.put("isB2C", getIsB2C());
		attributes.put("isB2B", getIsB2B());
		attributes.put("isB2B2C", getIsB2B2C());
		attributes.put("iconFileEntryId", getIconFileEntryId());
		attributes.put("imageFileEntryId", getImageFileEntryId());
		attributes.put("pepEnable", getPepEnable());
		attributes.put("policyWordingEntryId", getPolicyWordingEntryId());
		attributes.put("metaTitle", getMetaTitle());
		attributes.put("metaDescription", getMetaDescription());
		attributes.put("metaKeywords", getMetaKeywords());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		String productCode = (String)attributes.get("productCode");

		if (productCode != null) {
			setProductCode(productCode);
		}

		String productName = (String)attributes.get("productName");

		if (productName != null) {
			setProductName(productName);
		}

		String ojkName = (String)attributes.get("ojkName");

		if (ojkName != null) {
			setOjkName(ojkName);
		}

		Double stampdutyIDR = (Double)attributes.get("stampdutyIDR");

		if (stampdutyIDR != null) {
			setStampdutyIDR(stampdutyIDR);
		}

		Double stampdutyUSD = (Double)attributes.get("stampdutyUSD");

		if (stampdutyUSD != null) {
			setStampdutyUSD(stampdutyUSD);
		}

		Double policyCostIDR = (Double)attributes.get("policyCostIDR");

		if (policyCostIDR != null) {
			setPolicyCostIDR(policyCostIDR);
		}

		Double policyCostUSD = (Double)attributes.get("policyCostUSD");

		if (policyCostUSD != null) {
			setPolicyCostUSD(policyCostUSD);
		}

		Integer aclStatus = (Integer)attributes.get("aclStatus");

		if (aclStatus != null) {
			setAclStatus(aclStatus);
		}

		Integer aclGracePeriod = (Integer)attributes.get("aclGracePeriod");

		if (aclGracePeriod != null) {
			setAclGracePeriod(aclGracePeriod);
		}

		Double commission = (Double)attributes.get("commission");

		if (commission != null) {
			setCommission(commission);
		}

		Integer webContentFolderId = (Integer)attributes.get(
			"webContentFolderId");

		if (webContentFolderId != null) {
			setWebContentFolderId(webContentFolderId);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		Integer isB2C = (Integer)attributes.get("isB2C");

		if (isB2C != null) {
			setIsB2C(isB2C);
		}

		Integer isB2B = (Integer)attributes.get("isB2B");

		if (isB2B != null) {
			setIsB2B(isB2B);
		}

		Integer isB2B2C = (Integer)attributes.get("isB2B2C");

		if (isB2B2C != null) {
			setIsB2B2C(isB2B2C);
		}

		Long iconFileEntryId = (Long)attributes.get("iconFileEntryId");

		if (iconFileEntryId != null) {
			setIconFileEntryId(iconFileEntryId);
		}

		Long imageFileEntryId = (Long)attributes.get("imageFileEntryId");

		if (imageFileEntryId != null) {
			setImageFileEntryId(imageFileEntryId);
		}

		Integer pepEnable = (Integer)attributes.get("pepEnable");

		if (pepEnable != null) {
			setPepEnable(pepEnable);
		}

		Long policyWordingEntryId = (Long)attributes.get(
			"policyWordingEntryId");

		if (policyWordingEntryId != null) {
			setPolicyWordingEntryId(policyWordingEntryId);
		}

		String metaTitle = (String)attributes.get("metaTitle");

		if (metaTitle != null) {
			setMetaTitle(metaTitle);
		}

		String metaDescription = (String)attributes.get("metaDescription");

		if (metaDescription != null) {
			setMetaDescription(metaDescription);
		}

		String metaKeywords = (String)attributes.get("metaKeywords");

		if (metaKeywords != null) {
			setMetaKeywords(metaKeywords);
		}
	}

	/**
	 * Returns the acl grace period of this product configuration.
	 *
	 * @return the acl grace period of this product configuration
	 */
	@Override
	public int getAclGracePeriod() {
		return model.getAclGracePeriod();
	}

	/**
	 * Returns the acl status of this product configuration.
	 *
	 * @return the acl status of this product configuration
	 */
	@Override
	public int getAclStatus() {
		return model.getAclStatus();
	}

	/**
	 * Returns the commission of this product configuration.
	 *
	 * @return the commission of this product configuration
	 */
	@Override
	public Double getCommission() {
		return model.getCommission();
	}

	/**
	 * Returns the icon file entry ID of this product configuration.
	 *
	 * @return the icon file entry ID of this product configuration
	 */
	@Override
	public Long getIconFileEntryId() {
		return model.getIconFileEntryId();
	}

	/**
	 * Returns the image file entry ID of this product configuration.
	 *
	 * @return the image file entry ID of this product configuration
	 */
	@Override
	public Long getImageFileEntryId() {
		return model.getImageFileEntryId();
	}

	/**
	 * Returns the is b2b of this product configuration.
	 *
	 * @return the is b2b of this product configuration
	 */
	@Override
	public int getIsB2B() {
		return model.getIsB2B();
	}

	/**
	 * Returns the is b2b2c of this product configuration.
	 *
	 * @return the is b2b2c of this product configuration
	 */
	@Override
	public int getIsB2B2C() {
		return model.getIsB2B2C();
	}

	/**
	 * Returns the is b2c of this product configuration.
	 *
	 * @return the is b2c of this product configuration
	 */
	@Override
	public int getIsB2C() {
		return model.getIsB2C();
	}

	/**
	 * Returns the link of this product configuration.
	 *
	 * @return the link of this product configuration
	 */
	@Override
	public String getLink() {
		return model.getLink();
	}

	/**
	 * Returns the meta description of this product configuration.
	 *
	 * @return the meta description of this product configuration
	 */
	@Override
	public String getMetaDescription() {
		return model.getMetaDescription();
	}

	/**
	 * Returns the meta keywords of this product configuration.
	 *
	 * @return the meta keywords of this product configuration
	 */
	@Override
	public String getMetaKeywords() {
		return model.getMetaKeywords();
	}

	/**
	 * Returns the meta title of this product configuration.
	 *
	 * @return the meta title of this product configuration
	 */
	@Override
	public String getMetaTitle() {
		return model.getMetaTitle();
	}

	/**
	 * Returns the ojk name of this product configuration.
	 *
	 * @return the ojk name of this product configuration
	 */
	@Override
	public String getOjkName() {
		return model.getOjkName();
	}

	/**
	 * Returns the pep enable of this product configuration.
	 *
	 * @return the pep enable of this product configuration
	 */
	@Override
	public int getPepEnable() {
		return model.getPepEnable();
	}

	/**
	 * Returns the policy cost idr of this product configuration.
	 *
	 * @return the policy cost idr of this product configuration
	 */
	@Override
	public Double getPolicyCostIDR() {
		return model.getPolicyCostIDR();
	}

	/**
	 * Returns the policy cost usd of this product configuration.
	 *
	 * @return the policy cost usd of this product configuration
	 */
	@Override
	public Double getPolicyCostUSD() {
		return model.getPolicyCostUSD();
	}

	/**
	 * Returns the policy wording entry ID of this product configuration.
	 *
	 * @return the policy wording entry ID of this product configuration
	 */
	@Override
	public Long getPolicyWordingEntryId() {
		return model.getPolicyWordingEntryId();
	}

	/**
	 * Returns the primary key of this product configuration.
	 *
	 * @return the primary key of this product configuration
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product code of this product configuration.
	 *
	 * @return the product code of this product configuration
	 */
	@Override
	public String getProductCode() {
		return model.getProductCode();
	}

	/**
	 * Returns the product ID of this product configuration.
	 *
	 * @return the product ID of this product configuration
	 */
	@Override
	public long getProductId() {
		return model.getProductId();
	}

	/**
	 * Returns the product name of this product configuration.
	 *
	 * @return the product name of this product configuration
	 */
	@Override
	public String getProductName() {
		return model.getProductName();
	}

	/**
	 * Returns the stampduty idr of this product configuration.
	 *
	 * @return the stampduty idr of this product configuration
	 */
	@Override
	public Double getStampdutyIDR() {
		return model.getStampdutyIDR();
	}

	/**
	 * Returns the stampduty usd of this product configuration.
	 *
	 * @return the stampduty usd of this product configuration
	 */
	@Override
	public Double getStampdutyUSD() {
		return model.getStampdutyUSD();
	}

	/**
	 * Returns the status of this product configuration.
	 *
	 * @return the status of this product configuration
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the trash entry created when this product configuration was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this product configuration.
	 *
	 * @return the trash entry created when this product configuration was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this product configuration.
	 *
	 * @return the class primary key of the trash entry for this product configuration
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this product configuration.
	 *
	 * @return the trash handler for this product configuration
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the web content folder ID of this product configuration.
	 *
	 * @return the web content folder ID of this product configuration
	 */
	@Override
	public int getWebContentFolderId() {
		return model.getWebContentFolderId();
	}

	/**
	 * Returns <code>true</code> if this product configuration is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this product configuration is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this product configuration is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this product configuration is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer() {
		return model.isInTrashContainer();
	}

	@Override
	public boolean isInTrashExplicitly() {
		return model.isInTrashExplicitly();
	}

	@Override
	public boolean isInTrashImplicitly() {
		return model.isInTrashImplicitly();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the acl grace period of this product configuration.
	 *
	 * @param aclGracePeriod the acl grace period of this product configuration
	 */
	@Override
	public void setAclGracePeriod(int aclGracePeriod) {
		model.setAclGracePeriod(aclGracePeriod);
	}

	/**
	 * Sets the acl status of this product configuration.
	 *
	 * @param aclStatus the acl status of this product configuration
	 */
	@Override
	public void setAclStatus(int aclStatus) {
		model.setAclStatus(aclStatus);
	}

	/**
	 * Sets the commission of this product configuration.
	 *
	 * @param commission the commission of this product configuration
	 */
	@Override
	public void setCommission(Double commission) {
		model.setCommission(commission);
	}

	/**
	 * Sets the icon file entry ID of this product configuration.
	 *
	 * @param iconFileEntryId the icon file entry ID of this product configuration
	 */
	@Override
	public void setIconFileEntryId(Long iconFileEntryId) {
		model.setIconFileEntryId(iconFileEntryId);
	}

	/**
	 * Sets the image file entry ID of this product configuration.
	 *
	 * @param imageFileEntryId the image file entry ID of this product configuration
	 */
	@Override
	public void setImageFileEntryId(Long imageFileEntryId) {
		model.setImageFileEntryId(imageFileEntryId);
	}

	/**
	 * Sets the is b2b of this product configuration.
	 *
	 * @param isB2B the is b2b of this product configuration
	 */
	@Override
	public void setIsB2B(int isB2B) {
		model.setIsB2B(isB2B);
	}

	/**
	 * Sets the is b2b2c of this product configuration.
	 *
	 * @param isB2B2C the is b2b2c of this product configuration
	 */
	@Override
	public void setIsB2B2C(int isB2B2C) {
		model.setIsB2B2C(isB2B2C);
	}

	/**
	 * Sets the is b2c of this product configuration.
	 *
	 * @param isB2C the is b2c of this product configuration
	 */
	@Override
	public void setIsB2C(int isB2C) {
		model.setIsB2C(isB2C);
	}

	/**
	 * Sets the link of this product configuration.
	 *
	 * @param link the link of this product configuration
	 */
	@Override
	public void setLink(String link) {
		model.setLink(link);
	}

	/**
	 * Sets the meta description of this product configuration.
	 *
	 * @param metaDescription the meta description of this product configuration
	 */
	@Override
	public void setMetaDescription(String metaDescription) {
		model.setMetaDescription(metaDescription);
	}

	/**
	 * Sets the meta keywords of this product configuration.
	 *
	 * @param metaKeywords the meta keywords of this product configuration
	 */
	@Override
	public void setMetaKeywords(String metaKeywords) {
		model.setMetaKeywords(metaKeywords);
	}

	/**
	 * Sets the meta title of this product configuration.
	 *
	 * @param metaTitle the meta title of this product configuration
	 */
	@Override
	public void setMetaTitle(String metaTitle) {
		model.setMetaTitle(metaTitle);
	}

	/**
	 * Sets the ojk name of this product configuration.
	 *
	 * @param ojkName the ojk name of this product configuration
	 */
	@Override
	public void setOjkName(String ojkName) {
		model.setOjkName(ojkName);
	}

	/**
	 * Sets the pep enable of this product configuration.
	 *
	 * @param pepEnable the pep enable of this product configuration
	 */
	@Override
	public void setPepEnable(int pepEnable) {
		model.setPepEnable(pepEnable);
	}

	/**
	 * Sets the policy cost idr of this product configuration.
	 *
	 * @param policyCostIDR the policy cost idr of this product configuration
	 */
	@Override
	public void setPolicyCostIDR(Double policyCostIDR) {
		model.setPolicyCostIDR(policyCostIDR);
	}

	/**
	 * Sets the policy cost usd of this product configuration.
	 *
	 * @param policyCostUSD the policy cost usd of this product configuration
	 */
	@Override
	public void setPolicyCostUSD(Double policyCostUSD) {
		model.setPolicyCostUSD(policyCostUSD);
	}

	/**
	 * Sets the policy wording entry ID of this product configuration.
	 *
	 * @param policyWordingEntryId the policy wording entry ID of this product configuration
	 */
	@Override
	public void setPolicyWordingEntryId(Long policyWordingEntryId) {
		model.setPolicyWordingEntryId(policyWordingEntryId);
	}

	/**
	 * Sets the primary key of this product configuration.
	 *
	 * @param primaryKey the primary key of this product configuration
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product code of this product configuration.
	 *
	 * @param productCode the product code of this product configuration
	 */
	@Override
	public void setProductCode(String productCode) {
		model.setProductCode(productCode);
	}

	/**
	 * Sets the product ID of this product configuration.
	 *
	 * @param productId the product ID of this product configuration
	 */
	@Override
	public void setProductId(long productId) {
		model.setProductId(productId);
	}

	/**
	 * Sets the product name of this product configuration.
	 *
	 * @param productName the product name of this product configuration
	 */
	@Override
	public void setProductName(String productName) {
		model.setProductName(productName);
	}

	/**
	 * Sets the stampduty idr of this product configuration.
	 *
	 * @param stampdutyIDR the stampduty idr of this product configuration
	 */
	@Override
	public void setStampdutyIDR(Double stampdutyIDR) {
		model.setStampdutyIDR(stampdutyIDR);
	}

	/**
	 * Sets the stampduty usd of this product configuration.
	 *
	 * @param stampdutyUSD the stampduty usd of this product configuration
	 */
	@Override
	public void setStampdutyUSD(Double stampdutyUSD) {
		model.setStampdutyUSD(stampdutyUSD);
	}

	/**
	 * Sets the web content folder ID of this product configuration.
	 *
	 * @param webContentFolderId the web content folder ID of this product configuration
	 */
	@Override
	public void setWebContentFolderId(int webContentFolderId) {
		model.setWebContentFolderId(webContentFolderId);
	}

	@Override
	protected ProductConfigurationWrapper wrap(
		ProductConfiguration productConfiguration) {

		return new ProductConfigurationWrapper(productConfiguration);
	}

}