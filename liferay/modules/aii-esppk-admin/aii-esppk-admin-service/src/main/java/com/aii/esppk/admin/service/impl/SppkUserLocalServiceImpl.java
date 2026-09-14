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

package com.aii.esppk.admin.service.impl;

import com.aii.esppk.admin.exception.NoSuchSppkUserException;
import com.aii.esppk.admin.model.SppkUser;
import com.aii.esppk.admin.service.base.SppkUserLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus
 */
@Component(property = "model.class.name=com.aii.esppk.admin.model.SppkUser", service = AopService.class)
public class SppkUserLocalServiceImpl extends SppkUserLocalServiceBaseImpl {

	private static final SecureRandom random = new SecureRandom();

	public SppkUser addSppkUser(String fullName, String loginCode, String password, String email, String roleCode, int allAccess,
			int accessData, int accessMonitoring, int active) throws PortalException {
		long sppkUserId = counterLocalService.increment();
		SppkUser sppkUser = sppkUserPersistence.create(sppkUserId);

		sppkUser.setFullName(fullName);
		sppkUser.setSppkLoginCode(loginCode);
		sppkUser.setPassword(password);
		sppkUser.setEmail(email);
		sppkUser.setRoleCode(roleCode);
		sppkUser.setAllAccess(allAccess);
		sppkUser.setAccessData(accessData);
		sppkUser.setAccessMonitoring(accessMonitoring);
		sppkUser.setActive(active);

		sppkUserPersistence.update(sppkUser);

		return sppkUser;
	}

	public SppkUser updateSppkUser(long sppkUserId, String fullName, String loginCode, String password, String email, String roleCode,
			int allAccess, int accessData, int accessMonitoring, int active) throws PortalException {
		SppkUser sppkUser = sppkUserPersistence.findByPrimaryKey(sppkUserId);

		sppkUser.setFullName(fullName);
		sppkUser.setSppkLoginCode(loginCode);

		if (!password.isEmpty()) {
			sppkUser.setPassword(password);
		}
		
		sppkUser.setEmail(email);

		sppkUser.setRoleCode(roleCode);
		sppkUser.setAllAccess(allAccess);
		sppkUser.setAccessData(accessData);
		sppkUser.setAccessMonitoring(accessMonitoring);
		sppkUser.setActive(active);

		sppkUserPersistence.update(sppkUser);

		return sppkUser;
	}

	public List<SppkUser> getSppkUsers() {
		return sppkUserPersistence.findAll();
	}

	public int getSppkUserCount() {
		return sppkUserPersistence.countAll();
	}

	public SppkUser setActive(long sppkUserId, int active, ServiceContext serviceContext) {
		SppkUser sppkUser = null;

		try {
			sppkUser = sppkUserPersistence.findByPrimaryKey(sppkUserId);
			Date now = new Date();
			sppkUser.setSppkUserId(sppkUserId);
			sppkUser.setActive(active);
			sppkUser.setModifiedDate(serviceContext.getModifiedDate(now));

			sppkUserPersistence.update(sppkUser);

		} catch (Exception e) {
            log.debug(e.getMessage());
		}

		return sppkUser;
	}

	public SppkUser getByLoginCode(String username) {
		SppkUser result = null;
		try {
			result = sppkUserPersistence.findBysppkLoginCode(username);
		} catch (NoSuchSppkUserException e) {
            log.debug(e.getMessage());
		}
		return result;
	}

	public SppkUser updateOtp(long sppkUserId) {
		SppkUser sppkUser = null;
		try {
			sppkUser = sppkUserPersistence.findByPrimaryKey(sppkUserId);

			int number = random.nextInt(100000);
			String otp = String.format("%05d", number);
			sppkUser.setOtpCode(otp);

			LocalDateTime expiredAt = LocalDateTime.now().plusMinutes(15);
			Date expiredDate = Date.from(expiredAt.atZone(ZoneId.systemDefault()).toInstant());
			sppkUser.setOtpExpired(expiredDate);

			sppkUserPersistence.update(sppkUser);

		} catch (Exception e) {
            log.debug(e.getMessage());
		}

		return sppkUser;
	}
	
	public SppkUser verifyOtp(String email, String otpCode) {
		SppkUser sppkUser = null;
		try {
			sppkUser = sppkUserPersistence.findByemailAndOtpCode(email, otpCode);	
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		
		return sppkUser;
	}

    private static final Log log = LogFactoryUtil.getLog(SppkUserLocalServiceImpl.class);
}