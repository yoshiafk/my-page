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
import com.mypage.agencyportal.exception.NoSuchAgentTokenLimiterException;
import com.mypage.agencyportal.model.AgentTokenLimiter;
import com.mypage.agencyportal.service.base.AgentTokenLimiterLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.agencyportal.model.AgentTokenLimiter",
	service = AopService.class
)
public class AgentTokenLimiterLocalServiceImpl
	extends AgentTokenLimiterLocalServiceBaseImpl {
	
	public AgentTokenLimiter getAgentTokenLimiterByDeptCodeAndTokenType(String deptCode, String tokenType) {
		AgentTokenLimiter _result = null;
		try {
			_result = agentTokenLimiterPersistence.findBydeptCodeAndTokenType(deptCode, tokenType);
		} catch (NoSuchAgentTokenLimiterException e) {
			System.out.println(e.getMessage());
		}
		return _result;
	}
	
	public AgentTokenLimiter getAgentTokenLimiterByToken(String token) {
		AgentTokenLimiter _result = null;
		try {
			_result = agentTokenLimiterPersistence.findBytoken(token);
		} catch (NoSuchAgentTokenLimiterException e) {
			System.out.println(e.getMessage());
		}
		return _result;
	}
	
	public AgentTokenLimiter addAgentTokenLimiter(String deptCode, String token, String tokenType, int isValid) {
		long agentTokenLimiterId = counterLocalService.increment();
		AgentTokenLimiter agentToken = agentTokenLimiterPersistence.create(agentTokenLimiterId);

		agentToken.setDeptCode(deptCode);
		agentToken.setToken(token);
		agentToken.setTokenType(tokenType);
		agentToken.setIsValid(isValid);

		agentTokenLimiterPersistence.update(agentToken);

		return agentToken;
	}
	
	public AgentTokenLimiter editAgentTokenLimiter(long agentTokenLimiterId, String deptCode, String token, String tokenType, int isValid) {
		AgentTokenLimiter agentToken = null;

		try {
			agentToken = agentTokenLimiterPersistence.findByPrimaryKey(agentTokenLimiterId);

			agentToken.setDeptCode(deptCode);
			agentToken.setToken(token);
			agentToken.setTokenType(tokenType);
			agentToken.setIsValid(isValid);

			agentTokenLimiterPersistence.update(agentToken);
		} catch (NoSuchAgentTokenLimiterException e) {
			System.out.println(e.getMessage());
		}

		return agentToken;
	}
	
	public boolean setToInvalid(long agentTokenLimiterId) {
		AgentTokenLimiter agentToken = null;
		boolean statusSetToInvalid = false;

		try {
			agentToken = agentTokenLimiterPersistence.findByPrimaryKey(agentTokenLimiterId);
			agentToken.setIsValid(0);
			agentTokenLimiterPersistence.update(agentToken);
			statusSetToInvalid = true;
		} catch (NoSuchAgentTokenLimiterException e) {
			System.out.println(e.getMessage());
		}

		return statusSetToInvalid;
	}
}