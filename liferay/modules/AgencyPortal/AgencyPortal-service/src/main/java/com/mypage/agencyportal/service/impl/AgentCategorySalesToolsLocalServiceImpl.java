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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.agencyportal.model.AgentCategorySalesTools;
import com.mypage.agencyportal.service.base.AgentCategorySalesToolsLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.agencyportal.model.AgentCategorySalesTools",
	service = AopService.class
)
public class AgentCategorySalesToolsLocalServiceImpl extends AgentCategorySalesToolsLocalServiceBaseImpl {
	
	public List<AgentCategorySalesTools> getActiveCategory() {
		return (List<AgentCategorySalesTools>) agentCategorySalesToolsPersistence.findAll().stream().filter(v -> v.getActive() == 1).collect(Collectors.toList());
	}
	
	public AgentCategorySalesTools addCategorySalesTools(String category, int active) throws PortalException {
		long agentCategorySalesToolsId = counterLocalService.increment();
		AgentCategorySalesTools agentCategorySalesTools = agentCategorySalesToolsPersistence.create(agentCategorySalesToolsId);
			
		agentCategorySalesTools.setCategory(category);
		agentCategorySalesTools.setActive(active);

		agentCategorySalesToolsPersistence.update(agentCategorySalesTools);

		return agentCategorySalesTools;
	}
	
	public AgentCategorySalesTools updateCategorySalesTools(long agentCategorySalesToolsId, String category, int active) throws PortalException {
		AgentCategorySalesTools agentCategorySalesTools = agentCategorySalesToolsPersistence.findByPrimaryKey(agentCategorySalesToolsId);
		
		agentCategorySalesTools.setCategory(category);
		agentCategorySalesTools.setActive(active);

		agentCategorySalesToolsPersistence.update(agentCategorySalesTools);

		return agentCategorySalesTools;
	}

	public AgentCategorySalesTools setActive(long agentCategorySalesToolsId, int active, ServiceContext serviceContext) throws PortalException {
		AgentCategorySalesTools agentCategorySalesTools = null;

		try {
			agentCategorySalesTools = agentCategorySalesToolsPersistence.findByPrimaryKey(agentCategorySalesToolsId);
			Date now = new Date();
			agentCategorySalesTools.setActive(active);
			agentCategorySalesTools.setModifiedDate(serviceContext.getModifiedDate(now));

			agentCategorySalesToolsPersistence.update(agentCategorySalesTools);
		} catch (Exception e) {
			System.out.println(e);
		}

		return agentCategorySalesTools;
	}
}