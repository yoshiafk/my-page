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
import com.liferay.portal.kernel.util.Validator;
import com.mypage.agencyportal.exception.NoSuchAgentTokenException;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalServiceUtil;
import com.mypage.agencyportal.service.base.AgentTokenLocalServiceBaseImpl;
import com.mypage.agencyportal.service.customhelper.MiscHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(property = "model.class.name=com.mypage.agencyportal.model.AgentToken", service = AopService.class)
public class AgentTokenLocalServiceImpl extends AgentTokenLocalServiceBaseImpl {

	/**
	 * Get Agent Token
	 */
	public AgentToken getAgentTokenByDeptCode(String deptCode) {
		AgentToken _result = null;
		try {
			_result = agentTokenPersistence.findBydeptCode(deptCode);
		} catch (NoSuchAgentTokenException e) {
			System.out.println(e.getMessage());
		}
		return _result;
	}

	/**
	 * Get Agent Token by Token
	 */
	public AgentToken getAgentTokenByToken(String token) {
		AgentToken _result = null;
		try {
			_result = agentTokenPersistence.findBytoken(token);
		} catch (NoSuchAgentTokenException e) {
			System.out.println(e.getMessage());
		}
		return _result;
	}

	/**
	 * Get Agent Token by Request Token
	 */
	public AgentToken getAgentTokenByApiRequestToken(String apiRequestToken) {
		AgentToken _result = null;
		try {
			_result = agentTokenPersistence.findByapiRequestToken(apiRequestToken);
		} catch (NoSuchAgentTokenException e) {
			System.out.println(e.getMessage());
		}
		return _result;
	}

	public AgentToken addAgentToken(String deptCode, String token, int isValid) {
		long agentTokenId = counterLocalService.increment();
		AgentToken agentToken = agentTokenPersistence.create(agentTokenId);

		agentToken.setDeptCode(deptCode);
		agentToken.setToken(token);
		agentToken.setIsValid(isValid);

		agentTokenPersistence.update(agentToken);

		return agentToken;
	}

	public AgentToken editAgentToken(long agentTokenId, String deptCode, String token, int isValid) {
		AgentToken agentToken = null;

		try {
			agentToken = agentTokenPersistence.findByPrimaryKey(agentTokenId);

			agentToken.setDeptCode(deptCode);
			agentToken.setToken(token);
			agentToken.setIsValid(isValid);

			agentTokenPersistence.update(agentToken);
		} catch (NoSuchAgentTokenException e) {
			System.out.println(e.getMessage());
		}

		return agentToken;
	}

	public AgentToken editAgentToken(long agentTokenId, String apiRequestToken, Date apiRequestTokenExpired) {
		AgentToken agentToken = null;

		try {
			agentToken = agentTokenPersistence.findByPrimaryKey(agentTokenId);

			agentToken.setApiRequestToken(apiRequestToken);
			agentToken.setApiRequestTokenExpired(apiRequestTokenExpired);

			agentTokenPersistence.update(agentToken);
		} catch (NoSuchAgentTokenException e) {
			System.out.println(e.getMessage());
		}

		return agentToken;
	}

	public AgentToken renewAgentToken(long agentTokenId) {
		AgentToken agentToken = null;

		try {
			agentToken = agentTokenPersistence.findByPrimaryKey(agentTokenId);

			// Generate new token
			String apiRequestToken = MiscHelper.generateSecureToken(32);
			if (Validator.isNull(apiRequestToken)) {
				throw new NoSuchAgentTokenException("apiRequestToken is empty because generate secure token failed");
			}
			agentToken.setApiRequestToken(apiRequestToken);

			// Token expired in 10 minutes
			Date serverTime = new Date();

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(serverTime);
			calendar.add(Calendar.MINUTE, 10);
			Date updatedTime = calendar.getTime();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formattedTime = dateFormat.format(updatedTime);
			Date apiRequestTokenExpired = dateFormat.parse(formattedTime);
			
			agentToken.setApiRequestTokenExpired(apiRequestTokenExpired);
			
			agentTokenPersistence.update(agentToken);
			
		} catch (NoSuchAgentTokenException | ParseException e) {
			System.out.println(e.getMessage());
		}

		return agentToken;
	}

	public boolean setAgentTokenToInvalid(long agentTokenId) {
		AgentToken agentToken = null;
		boolean statusSetToInvalid = false;

		try {
			agentToken = agentTokenPersistence.findByPrimaryKey(agentTokenId);
			agentToken.setIsValid(0);
			agentTokenPersistence.update(agentToken);
			statusSetToInvalid = true;
		} catch (NoSuchAgentTokenException e) {
			System.out.println(e.getMessage());
		}

		return statusSetToInvalid;
	}

	/**
	 * Verify render token and api request token
	 */
	public AgentToken verifyToken(String renderToken, String apiRequestToken) {
		AgentToken _agentToken = null;
		try {
			DynamicQuery dq = AgentTokenLocalServiceUtil.dynamicQuery();
			dq.add(RestrictionsFactoryUtil.eq("token", renderToken));
			dq.add(RestrictionsFactoryUtil.eq("apiRequestToken", apiRequestToken));
			List<AgentToken> _resultAgentToken = agentTokenLocalService.dynamicQuery(dq);

			if (!Validator.isNull(_resultAgentToken)) {
				// Check expired token
				long currentTimestamp = System.currentTimeMillis();
				long apiRequestTokenTimestamp = _resultAgentToken.get(0).getApiRequestTokenExpired().getTime();

				if (currentTimestamp < apiRequestTokenTimestamp) {
					_agentToken = _resultAgentToken.get(0);
				}
			}
		} catch (Exception e) {
			System.out.println("VerifyToken: " + e.getMessage());
		}

		return _agentToken;
	}
	
	public boolean deleteAgentTokenByDeptCode(String deptCode) {
		AgentToken agentToken = null;
		boolean deleteStatus = false;
		try {
			agentToken = agentTokenPersistence.removeBydeptCode(deptCode);
			System.out.println(agentToken.getAgentTokenId() + " was successfully deleted.");
			deleteStatus = true;
		} catch (NoSuchAgentTokenException e) {
			System.out.println(e.getMessage());
		}
		return deleteStatus;
	}
	
}