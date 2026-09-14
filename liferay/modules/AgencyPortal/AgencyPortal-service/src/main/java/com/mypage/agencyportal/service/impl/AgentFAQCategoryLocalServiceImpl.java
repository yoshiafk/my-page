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
import com.mypage.agencyportal.model.AgentFAQ;
import com.mypage.agencyportal.model.AgentFAQCategory;
import com.mypage.agencyportal.service.base.AgentFAQCategoryLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(property = "model.class.name=com.mypage.agencyportal.model.AgentFAQCategory", service = AopService.class)
public class AgentFAQCategoryLocalServiceImpl extends AgentFAQCategoryLocalServiceBaseImpl {

	public List<AgentFAQCategory> getActiveCategoryInUse() {
		
		List<AgentFAQ> faqsActive = agentFAQPersistence.findAll().stream().filter(fa -> fa.getActive() == 1)
				.collect(Collectors.toList());

		List<Long> idCategoryUsedFAQActive = faqsActive.stream().map(AgentFAQ::getCategoryId).distinct()
				.collect(Collectors.toList());

		List<AgentFAQCategory> agentActiveUse = agentFAQCategoryPersistence.findAll().stream()
				.filter(v -> v.getActive() == 1 && idCategoryUsedFAQActive.contains(v.getAgentFaqCategoryId()))
				.collect(Collectors.toList());
		return agentActiveUse;
		
	}
	
	public List<AgentFAQCategory> getActiveCategory() {
		
		return (List<AgentFAQCategory>) agentFAQCategoryPersistence.findAll().stream().filter(v -> v.getActive() == 1)
				.collect(Collectors.toList());
	}
	

	public AgentFAQCategory addFaqCategory(String category, int active) throws PortalException {
		long agentFaqCategoryId = counterLocalService.increment();
		AgentFAQCategory agentFaqCategory = agentFAQCategoryPersistence.create(agentFaqCategoryId);

		agentFaqCategory.setCategory(category);
		agentFaqCategory.setActive(active);

		agentFAQCategoryPersistence.update(agentFaqCategory);

		return agentFaqCategory;
	}

	@Override
	public AgentFAQCategory updateFaqCategory(long agentFaqCategoryId, String category, int active) throws PortalException {
	    AgentFAQCategory agentFaqCategory = agentFAQCategoryPersistence.findByPrimaryKey(agentFaqCategoryId);
	    String oldCategoryName = agentFaqCategory.getCategory();  // Simpan nama kategori lama
	    agentFaqCategory.setCategory(category);
	    agentFaqCategory.setActive(active);
	    agentFAQCategoryPersistence.update(agentFaqCategory);
	    
	    
	    if (!oldCategoryName.equals(category)) {
	    	List<AgentFAQ> data = agentFAQPersistence.findBycategory(oldCategoryName).stream().collect(Collectors.toList());
	        for (AgentFAQ faq : data) {
	            faq.setCategory(category);
	            agentFAQPersistence.update(faq);
	        }
	    }


	    return agentFaqCategory;
	}


	public AgentFAQCategory setActive(long agentFaqCategoryId, int active, ServiceContext serviceContext)
			throws PortalException {
		AgentFAQCategory agentFaqCategory = null;

		try {
			agentFaqCategory = agentFAQCategoryPersistence.findByPrimaryKey(agentFaqCategoryId);
			Date now = new Date();
			agentFaqCategory.setActive(active);
			agentFaqCategory.setModifiedDate(serviceContext.getModifiedDate(now));

			agentFAQCategoryPersistence.update(agentFaqCategory);
		} catch (Exception e) {
			System.out.println(e);
		}

		return agentFaqCategory;
	}

}