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
import com.liferay.portal.kernel.util.Validator;
import com.mypage.agencyportal.model.AgentCalendar;
import com.mypage.agencyportal.model.AgentMarkCalendar;
import com.mypage.agencyportal.service.base.AgentCalendarLocalServiceBaseImpl;
import com.mypage.user.service.MypageUserGroupLocalService;
import com.mypage.user.service.MypageUserRoleLocalService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.agencyportal.model.AgentCalendar",
	service = AopService.class
)
public class AgentCalendarLocalServiceImpl extends AgentCalendarLocalServiceBaseImpl {
	
	public List<AgentCalendar> getActiveCalendarByRole(long userId, long roleId, List<Long> groupId) {
		List<AgentCalendar> agentCalendar = new ArrayList<AgentCalendar>();
		List<Long> marked = new ArrayList<>();
		
		if (userId > 0) {
			marked.addAll(agentMarkCalendarPersistence.findAll().stream()
						.filter(v -> v.getMypageUserId() == userId)
						.map(AgentMarkCalendar::getAgentCalendarId)
						.collect(Collectors.toList()));
		}
		
		Comparator<AgentCalendar> comparator = Comparator.comparing(AgentCalendar::getStartDate);
		
		agentCalendar = (List<AgentCalendar>) agentCalendarPersistence.findAll().stream()
						.filter(v -> v.getActive() == 1 && 
							   (v.getMypageUserRoleId() == roleId || v.getMypageUserId() == userId || groupId.contains(v.getMypageUserGroupId())
							   ))
						.filter(v -> !marked.contains(v.getAgentCalendarId()))
						.sorted(comparator)
						.collect(Collectors.toList());
		
		return agentCalendar;
	}
	
	public AgentCalendar addCalendar(String title, String location, String address, String description, String link, String category, 
			long roleId, long groupId, String startDate, String startTime, String endDate, String endTime, String fileURL,
			long fileEntryId, int isAllDay, int active, long userId) throws PortalException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		long agentCalendarId = counterLocalService.increment();
		String role = roleId > 0 ? _mypageUserRoleLocalService.getMypageUserRole(roleId).getName() : "";
		String group = groupId > 0 ? _mypageUserGroupLocalService.getMypageUserGroup(groupId).getName() : "";
		
		AgentCalendar agentCalendar = agentCalendarPersistence.create(agentCalendarId);
		
		agentCalendar.setTitle(title);
		agentCalendar.setLocation(location);
		agentCalendar.setAddress(address);
		agentCalendar.setDescription(description);
		agentCalendar.setLink(link);
		agentCalendar.setCategory(category);
		agentCalendar.setMypageUserRoleId(roleId);
		agentCalendar.setRole(role);
		agentCalendar.setMypageUserGroupId(groupId);
		agentCalendar.setGroup(group);
		agentCalendar.setStartDate(dateFormat.parse(startDate));
		
		if (Validator.isNotNull(endDate)) {
			agentCalendar.setEndDate(dateFormat.parse(endDate));
		}

		if (Validator.isNotNull(startTime)) {
			agentCalendar.setStartTime(startTime);
		}
		
		if (Validator.isNotNull(endTime)) {
			agentCalendar.setEndTime(endTime);
		}
		
		agentCalendar.setFileUploadUrl(fileURL);
		agentCalendar.setFileUploadEntryId(fileEntryId);
		agentCalendar.setIsAllDay(isAllDay);
		agentCalendar.setActive(active);
		agentCalendar.setMypageUserId(userId);

		agentCalendarPersistence.update(agentCalendar);

		return agentCalendar;
	}
	
	public AgentCalendar updateCalendar(long agentCalendarId, String title, String location, String address, String description, 
			String link, String category, long roleId, long groupId, String startDate, String startTime, String endDate, String endTime, 
			String fileURL, long fileEntryId, int isAllDay, int active) throws PortalException, ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String role = roleId > 0 ? _mypageUserRoleLocalService.getMypageUserRole(roleId).getName() : "";
		String group = groupId > 0 ? _mypageUserGroupLocalService.getMypageUserGroup(groupId).getName() : "";
		AgentCalendar agentCalendar = agentCalendarPersistence.findByPrimaryKey(agentCalendarId);
		
		agentCalendar.setTitle(title);
		agentCalendar.setLocation(location);
		agentCalendar.setAddress(address);
		agentCalendar.setDescription(description);
		agentCalendar.setLink(link);
		agentCalendar.setCategory(category);
		agentCalendar.setMypageUserRoleId(roleId);
		agentCalendar.setRole(role);
		agentCalendar.setMypageUserGroupId(groupId);
		agentCalendar.setGroup(group);
		agentCalendar.setStartDate(dateFormat.parse(startDate));
		agentCalendar.setStartTime(startTime);
		agentCalendar.setEndDate(dateFormat.parse(endDate));
		agentCalendar.setEndTime(endTime);
		
		if (Validator.isNotNull(fileEntryId)) {
			agentCalendar.setFileUploadUrl(fileURL);
			agentCalendar.setFileUploadEntryId(fileEntryId);
		}
		
		agentCalendar.setIsAllDay(isAllDay);
		agentCalendar.setActive(active);

		agentCalendarPersistence.update(agentCalendar);

		return agentCalendar;
	}

	public AgentCalendar setActive(long agentCalendarId, int active, ServiceContext serviceContext) throws PortalException {
		AgentCalendar agentCalendar = null;

		try {
			agentCalendar = agentCalendarPersistence.findByPrimaryKey(agentCalendarId);
			Date now = new Date();
			agentCalendar.setActive(active);
			agentCalendar.setModifiedDate(serviceContext.getModifiedDate(now));

			agentCalendarPersistence.update(agentCalendar);
		} catch (Exception e) {
			System.out.println(e);
		}

		return agentCalendar;
	}
	
	@Reference
	private MypageUserRoleLocalService _mypageUserRoleLocalService;
	
	@Reference
	private MypageUserGroupLocalService _mypageUserGroupLocalService;
}