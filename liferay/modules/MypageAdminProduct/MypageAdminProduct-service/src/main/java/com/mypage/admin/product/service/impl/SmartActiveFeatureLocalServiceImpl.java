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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.admin.product.model.SmartActiveFeature;
import com.mypage.admin.product.service.base.SmartActiveFeatureLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.SmartActiveFeature",
	service = AopService.class
)
public class SmartActiveFeatureLocalServiceImpl extends SmartActiveFeatureLocalServiceBaseImpl {
	
	public SmartActiveFeature addFeature(String title, String description, String fileURL, long fileEntryId, int sort, int active) throws PortalException {
		long featureId = counterLocalService.increment();
		SmartActiveFeature feature = smartActiveFeaturePersistence.create(featureId);

		feature.setTitle(title);
		feature.setDescription(description);
		feature.setFileUploadEntryId(fileEntryId);
		feature.setFileUploadUrl(fileURL);
		feature.setSort(sort);
		feature.setActive(active);

		smartActiveFeaturePersistence.update(feature);

		return feature;
	}

	public SmartActiveFeature updateFeature(long smartActiveFeatureId, String title, String description, String fileURL, long fileEntryId, int sort, int active)
			throws PortalException {
		SmartActiveFeature feature = smartActiveFeaturePersistence.findByPrimaryKey(smartActiveFeatureId);
		
		feature.setTitle(title);
		feature.setDescription(description);
		feature.setFileUploadEntryId(fileEntryId);
		feature.setFileUploadUrl(fileURL);
		feature.setSort(sort);
		feature.setActive(active);

		smartActiveFeaturePersistence.update(feature);
		
		return feature;
	}
	
	public List<SmartActiveFeature> getFeatures(int start, int end) {
		return smartActiveFeaturePersistence.findAll(start, end);
	}

	public List<SmartActiveFeature> getActiveFeature() {
		List<SmartActiveFeature> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("sort"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);

		return list;
	}

	public List<SmartActiveFeature> getFeatures() {
		return smartActiveFeaturePersistence.findAll();
	}

	public int getFeaturesCount() {
		return smartActiveFeaturePersistence.countAll();
	}
	
	public SmartActiveFeature setActive(long featureId, int active, ServiceContext serviceContext) {
		SmartActiveFeature feature = null;
		
		try {
			feature = smartActiveFeaturePersistence.findByPrimaryKey(featureId);
			Date date = new Date();
			
			feature.setActive(active);
			feature.setModifiedDate(serviceContext.getModifiedDate(date));
			
			smartActiveFeaturePersistence.update(feature);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return feature;
	}
}