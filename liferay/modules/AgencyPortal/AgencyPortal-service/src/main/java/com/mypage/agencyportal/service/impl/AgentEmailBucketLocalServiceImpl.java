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
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.agencyportal.model.AgentEmailBucket;
import com.mypage.agencyportal.service.base.AgentEmailBucketLocalServiceBaseImpl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.agencyportal.model.AgentEmailBucket",
	service = AopService.class
)
public class AgentEmailBucketLocalServiceImpl extends AgentEmailBucketLocalServiceBaseImpl {
	
	public AgentEmailBucket addEmailBucket(String activity, String subject, String recipient, String template, String params,
			String attachmentURL, long attachmentId) throws PortalException, ParseException {
		long agentEmailBucketId = counterLocalService.increment();
		AgentEmailBucket emailBucket = agentEmailBucketPersistence.create(agentEmailBucketId);
		
		emailBucket.setActivity(activity);
		emailBucket.setSubject(subject);
		emailBucket.setRecipient(recipient);
		emailBucket.setTemplate(template);
		emailBucket.setParams(params);
		emailBucket.setAttachmentId(attachmentId);
		emailBucket.setAttachmentUrl(attachmentURL);
		emailBucket.setActive(1);

		agentEmailBucketPersistence.update(emailBucket);

		return emailBucket;
	}
	
	public List<AgentEmailBucket> findByFilter(int size) {
		DynamicQuery dynamicQuery = agentEmailBucketLocalService.dynamicQuery();
		
		dynamicQuery.add(RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.ne("status_", "Success"), RestrictionsFactoryUtil.isNull("status_")));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("active", 1));
		
	    return agentSalesToolsPersistence.findWithDynamicQuery(dynamicQuery, 0, size);
	}
	
	public AgentEmailBucket setStatus(long agentEmailBucketId, String status, ServiceContext serviceContext) throws PortalException {
		AgentEmailBucket emailBucket = null;

		try {
			emailBucket = agentEmailBucketPersistence.findByPrimaryKey(agentEmailBucketId);
			Date now = new Date();
			emailBucket.setStatus_(status);
			if (status.equalsIgnoreCase("success") == true) emailBucket.setCounter(emailBucket.getCounter() + 1);
			emailBucket.setModifiedDate(serviceContext.getModifiedDate(now));

			agentEmailBucketPersistence.update(emailBucket);
		} catch (Exception e) {
			System.out.println(e);
		}

		return emailBucket;
	}
}