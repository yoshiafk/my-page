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
import com.mypage.agencyportal.model.AgentMarkCalendar;
import com.mypage.agencyportal.service.base.AgentMarkCalendarLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.agencyportal.model.AgentMarkCalendar",
	service = AopService.class
)
public class AgentMarkCalendarLocalServiceImpl extends AgentMarkCalendarLocalServiceBaseImpl {
	
	public AgentMarkCalendar addAgentMarkCalendar(long agentCalendarId, long mypageUserId) throws PortalException {
		long agentMarkCalendarId = counterLocalService.increment();
		AgentMarkCalendar agentMarkCalendar = agentMarkCalendarPersistence.create(agentMarkCalendarId);
			
		agentMarkCalendar.setAgentCalendarId(agentCalendarId);
		agentMarkCalendar.setMypageUserId(mypageUserId);

		agentMarkCalendarPersistence.update(agentMarkCalendar);

		return agentMarkCalendar;
	}
}