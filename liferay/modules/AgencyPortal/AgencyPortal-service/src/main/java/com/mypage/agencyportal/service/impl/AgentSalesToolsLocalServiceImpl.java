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

package com.mypage.agencyportal.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.agencyportal.model.AgentSalesTools;
import com.mypage.agencyportal.service.base.AgentSalesToolsLocalServiceBaseImpl;
import com.mypage.user.service.MypageUserRoleLocalService;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.agencyportal.model.AgentSalesTools",
	service = AopService.class
)
public class AgentSalesToolsLocalServiceImpl extends AgentSalesToolsLocalServiceBaseImpl {
	public AgentSalesTools addSalesTools(String title, String description, int categoryId, String fileURL,
			long fileEntryId, int roleId, int active) throws PortalException {
		long agentSalesToolsId = counterLocalService.increment();
		String category = agentCategorySalesToolsPersistence.fetchByPrimaryKey(categoryId).getCategory();
		String role = _mypageUserRoleLocalService.getMypageUserRole(roleId).getName();
		AgentSalesTools agentSalesTools = agentSalesToolsPersistence.create(agentSalesToolsId);
		
		agentSalesTools.setTitle(title);
		agentSalesTools.setDescription(description);
		agentSalesTools.setCategoryId(categoryId);
		agentSalesTools.setCategory(category);
		agentSalesTools.setFileUploadUrl(fileURL);
		agentSalesTools.setFileUploadEntryId(fileEntryId);
		agentSalesTools.setMypageUserRoleId(roleId);
		agentSalesTools.setRole(role);
		agentSalesTools.setActive(active);

		agentSalesToolsPersistence.update(agentSalesTools);

		return agentSalesTools;
	}
	
	public AgentSalesTools updateSalesTools(long agentSalesToolsId, String title, String description, int categoryId,
			String fileURL, long fileEntryId, int roleId, int active) throws PortalException {
		String category = agentCategorySalesToolsPersistence.fetchByPrimaryKey(categoryId).getCategory();
		String role = _mypageUserRoleLocalService.getMypageUserRole(roleId).getName();
		AgentSalesTools agentSalesTools = agentSalesToolsPersistence.findByPrimaryKey(agentSalesToolsId);
		
		agentSalesTools.setTitle(title);
		agentSalesTools.setDescription(description);
		agentSalesTools.setCategoryId(categoryId);
		agentSalesTools.setCategory(category);
		
		if (Validator.isNotNull(fileEntryId)) {
			agentSalesTools.setFileUploadUrl(fileURL);
			agentSalesTools.setFileUploadEntryId(fileEntryId);
		}
		
		agentSalesTools.setMypageUserRoleId(roleId);
		agentSalesTools.setRole(role);
		agentSalesTools.setActive(active);

		agentSalesToolsPersistence.update(agentSalesTools);

		return agentSalesTools;
	}

	public AgentSalesTools setActive(long agentSalesToolsId, int active, ServiceContext serviceContext) throws PortalException {
		AgentSalesTools agentSalesTools = null;

		try {
			agentSalesTools = agentSalesToolsPersistence.findByPrimaryKey(agentSalesToolsId);
			Date now = new Date();
			agentSalesTools.setActive(active);
			agentSalesTools.setModifiedDate(serviceContext.getModifiedDate(now));

			agentSalesToolsPersistence.update(agentSalesTools);
		} catch (Exception e) {
			System.out.println(e);
		}

		return agentSalesTools;
	}
	
	public List<AgentSalesTools> findByFilter(int start, int end, String title, String category, long roleId) {
		DynamicQuery dynamicQuery = agentSalesToolsLocalService.dynamicQuery();
		Order order = OrderFactoryUtil.desc("agentSalesToolsId");
		dynamicQuery.addOrder(order);
		
		if (Validator.isNotNull(title) == true) {
			dynamicQuery.add(RestrictionsFactoryUtil.like("title", "%" + title + "%"));
		}
		
		if (Validator.isNotNull(category) == true) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("category", category));
		}
		
		dynamicQuery.add(RestrictionsFactoryUtil.eq("mypageUserRoleId", roleId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("active", 1));
		
	    return agentSalesToolsPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}
	
	public int getCountByFilter(String title, String category, long roleId) {
		DynamicQuery dynamicQuery = agentSalesToolsLocalService.dynamicQuery();
		
		if (Validator.isNotNull(title) == true) {
			dynamicQuery.add(RestrictionsFactoryUtil.like("title", "%" + title + "%"));
		}
		
		if (Validator.isNotNull(category) == true) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("category", category));
		}
		
		dynamicQuery.add(RestrictionsFactoryUtil.eq("mypageUserRoleId", roleId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("active", 1));
		
	    return (int) agentSalesToolsPersistence.countWithDynamicQuery(dynamicQuery);
	}
	
	@Reference
	private MypageUserRoleLocalService _mypageUserRoleLocalService;
}