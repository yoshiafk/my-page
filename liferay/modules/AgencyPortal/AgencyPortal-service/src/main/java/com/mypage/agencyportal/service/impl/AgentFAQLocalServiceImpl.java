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
import com.mypage.agencyportal.model.AgentFAQ;
import com.mypage.agencyportal.service.base.AgentFAQLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.agencyportal.model.AgentFAQ",
	service = AopService.class
)
public class AgentFAQLocalServiceImpl extends AgentFAQLocalServiceBaseImpl {
	
	public AgentFAQ addFaq(String title, String description, int categoryId, int active) throws PortalException {
		long agentFaqId = counterLocalService.increment();
		String category = agentFAQCategoryPersistence.fetchByPrimaryKey(categoryId).getCategory();		
		AgentFAQ _faq = agentFAQPersistence.create(agentFaqId);
		
		_faq.setTitle(title);
		_faq.setDescription(description);
		_faq.setCategoryId(categoryId);
		_faq.setCategory(category);
		_faq.setActive(active);

		agentFAQPersistence.update(_faq);

		return _faq;
	}
	
	
	public AgentFAQ updateFaq(long agentFaqId, String title, String description, int categoryId,
			int active) throws PortalException {
		String category = agentFAQCategoryPersistence.fetchByPrimaryKey(categoryId).getCategory();
		//String role = _mypageUserRoleLocalService.getMypageUserRole(roleId).getName();
		AgentFAQ _faq = agentFAQPersistence.findByPrimaryKey(agentFaqId);
		
		_faq.setTitle(title);
		_faq.setDescription(description);
		_faq.setCategoryId(categoryId);
		_faq.setCategory(category);
		_faq.setActive(active);
		

		agentFAQPersistence.update(_faq);

		return _faq;
	}
	
	public AgentFAQ setActive(long agentFaqId, int active, ServiceContext serviceContext) throws PortalException {
		AgentFAQ agentFaq = null;

		try {
			agentFaq = agentFAQPersistence.findByPrimaryKey(agentFaqId);
			Date now = new Date();
			agentFaq.setActive(active);
			agentFaq.setModifiedDate(serviceContext.getModifiedDate(now));

			agentFAQPersistence.update(agentFaq);
		} catch (Exception e) {
			System.out.println(e);
		}

		return agentFaq;
	}
	
	public List<AgentFAQ> findByFilter(int start, int end, String title, String category) {
		DynamicQuery dynamicQuery = agentFAQLocalService.dynamicQuery();
		Order order = OrderFactoryUtil.desc("agentFaqId");
		dynamicQuery.addOrder(order);
		
		if (Validator.isNotNull(title) == true) {
			dynamicQuery.add(RestrictionsFactoryUtil.like("title", "%" + title + "%"));
		}
		
		if (Validator.isNotNull(category) == true) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("category", category));
		}
		
		dynamicQuery.add(RestrictionsFactoryUtil.eq("active", 1));
		
	    return agentFAQPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}
	
	public int getCountByFilter(String title, String category, long roleId) {
		DynamicQuery dynamicQuery = agentFAQLocalService.dynamicQuery();
		
		if (Validator.isNotNull(title) == true) {
			dynamicQuery.add(RestrictionsFactoryUtil.like("title", "%" + title + "%"));
		}
		
		if (Validator.isNotNull(category) == true) {
			dynamicQuery.add(RestrictionsFactoryUtil.eq("category", category));
		}
		
		dynamicQuery.add(RestrictionsFactoryUtil.eq("active", 1));
		
	    return (int) agentFAQPersistence.countWithDynamicQuery(dynamicQuery);
	}
	
	public List<AgentFAQ> findByCategory(String category) {
		List<AgentFAQ> data = agentFAQPersistence.findBycategory(category).stream().filter(f -> f.getActive() == 1).collect(Collectors.toList());
		return data;
	}
	
}