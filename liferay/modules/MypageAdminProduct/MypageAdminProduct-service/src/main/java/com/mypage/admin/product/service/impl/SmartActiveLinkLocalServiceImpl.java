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
import com.mypage.admin.product.exception.NoSuchSmartActiveLinkException;
import com.mypage.admin.product.model.SmartActiveLink;
import com.mypage.admin.product.service.base.SmartActiveLinkLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.SmartActiveLink",
	service = AopService.class
)
public class SmartActiveLinkLocalServiceImpl extends SmartActiveLinkLocalServiceBaseImpl {
	
	public SmartActiveLink addLink(String category, String title, String fileURL, long fileEntryId, int active) throws PortalException {
		long linkId = counterLocalService.increment();
		SmartActiveLink link = smartActiveLinkPersistence.create(linkId);

		link.setCategory(category);
		link.setTitle(title);
		link.setFileUploadEntryId(fileEntryId);
		link.setFileUploadUrl(fileURL);
		link.setActive(active);

		smartActiveLinkPersistence.update(link);

		return link;
	}

	public SmartActiveLink updateLink(long smartActiveLinkId, String category, String title, String fileURL, long fileEntryId, int active)
			throws PortalException {
		SmartActiveLink link = smartActiveLinkPersistence.findByPrimaryKey(smartActiveLinkId);
		
		link.setCategory(category);
		link.setTitle(title);
		link.setFileUploadEntryId(fileEntryId);
		link.setFileUploadUrl(fileURL);
		link.setActive(active);

		smartActiveLinkPersistence.update(link);
		
		return link;
	}
	
	public List<SmartActiveLink> getLinks(int start, int end) {
		return smartActiveLinkPersistence.findAll(start, end);
	}

	public List<SmartActiveLink> getActiveLink() {
		List<SmartActiveLink> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("smartActiveLinkId"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);

		return list;
	}

	public List<SmartActiveLink> getLinks() {
		return smartActiveLinkPersistence.findAll();
	}

	public int getLinksCount() {
		return smartActiveLinkPersistence.countAll();
	}

	public SmartActiveLink getByCategory(String category) {
		SmartActiveLink link = null;

		try {
			link = smartActiveLinkPersistence.findBycategory(category);
		} catch (NoSuchSmartActiveLinkException e) {
			System.out.println(e.getMessage());
		}

		return link;
	}
	
	public SmartActiveLink setActive(long linkId, int active, ServiceContext serviceContext) {
		SmartActiveLink link = null;
		
		try {
			link = smartActiveLinkPersistence.findByPrimaryKey(linkId);
			Date date = new Date();
			
			link.setActive(active);
			link.setModifiedDate(serviceContext.getModifiedDate(date));
			
			smartActiveLinkPersistence.update(link);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return link;
	}
}