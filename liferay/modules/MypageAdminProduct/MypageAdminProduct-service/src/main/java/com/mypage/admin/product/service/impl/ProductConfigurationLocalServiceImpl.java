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

package com.mypage.admin.product.service.impl;

import com.liferay.portal.aop.AopService;
import com.mypage.admin.product.exception.NoSuchProductConfigurationException;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.service.base.ProductConfigurationLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.ProductConfiguration",
	service = AopService.class
)
public class ProductConfigurationLocalServiceImpl extends ProductConfigurationLocalServiceBaseImpl {
	
	public ProductConfiguration getConfigByCode(String productCode) {

		ProductConfiguration _result = null;
		try {
			_result = productConfigurationPersistence.findByProductCode(productCode);
		} catch (NoSuchProductConfigurationException e) {
			System.out.println(e.getMessage());
		}

		return _result;
	}

	public ProductConfiguration addConfig(long productId, String productName, String productCode, double commission,
			double stampdutyIDR, double stampdutyUSD, double policyCostIDR, double policyCostUSD, int aclStatus,
			int aclGracePeriod, int webContentFolderId, String link, int isB2C, int isB2B, int isB2B2C,
			long iconFileEntryId, long imageFileEntryId, String ojkName, int pepEnable, long policyWordingEntryId, String metaTitle, String metaDescription, String metaKeywords) {
		ProductConfiguration config = null;

		if (productId == 0) {
			productId = counterLocalService.increment();
			config = productConfigurationPersistence.create(productId);
		} else {
			try {
				config = productConfigurationPersistence.findByPrimaryKey(productId);
			} catch (NoSuchProductConfigurationException e) {
				// e.printStackTrace();
				return config;
			}
		}

		config.setProductName(productName);
		config.setProductCode(productCode);
		config.setCommission(commission);
		config.setStampdutyIDR(stampdutyIDR);
		config.setStampdutyUSD(stampdutyUSD);
		config.setPolicyCostIDR(policyCostIDR);
		config.setPolicyCostUSD(policyCostUSD);
		config.setAclStatus(aclStatus);
		config.setAclGracePeriod(aclGracePeriod);
		config.setWebContentFolderId(webContentFolderId);
		config.setLink(link);
		config.setIsB2C(isB2C);
		config.setIsB2B(isB2B);
		config.setIsB2B2C(isB2B2C);
		config.setOjkName(ojkName);
		config.setPepEnable(pepEnable);
		config.setPolicyWordingEntryId(policyWordingEntryId);
		if (iconFileEntryId > 0)
			config.setIconFileEntryId(iconFileEntryId);
		if (imageFileEntryId > 0)
			config.setImageFileEntryId(imageFileEntryId);
		
		config.setMetaTitle(metaTitle);
		config.setMetaDescription(metaDescription);
		config.setMetaKeywords(metaKeywords);
		

		productConfigurationPersistence.update(config);

		return config;
	}

	public List<ProductConfiguration> getProductConfigurations() throws Exception, NoSuchProductConfigurationException {
		return productConfigurationPersistence.findAll();
	}	
}