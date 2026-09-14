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

package com.mypage.admin.product.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.BlacklistCustomer;
import com.mypage.admin.product.service.BlacklistCustomerLocalServiceUtil;
import com.mypage.admin.product.service.base.BlacklistCustomerLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.BlacklistCustomer",
	service = AopService.class
)
public class BlacklistCustomerLocalServiceImpl
	extends BlacklistCustomerLocalServiceBaseImpl {
	public BlacklistCustomer addBlacklistCustomer(String fullName, String firstName, String middleName, String lastName,
			String ktp, String kitas, String email, Date dateOfBirth, int active) throws PortalException {
		long blacklistCustomerId = counterLocalService.increment();
		BlacklistCustomer blacklistcustomer = blacklistCustomerPersistence.create(blacklistCustomerId);

		blacklistcustomer.setFullName(fullName);
		blacklistcustomer.setFirstName(firstName);
		blacklistcustomer.setMiddleName(middleName);
		blacklistcustomer.setLastName(lastName);
		blacklistcustomer.setKtp(ktp);
		blacklistcustomer.setKitas(kitas);
		blacklistcustomer.setEmail(email);
		blacklistcustomer.setDateOfBirth(dateOfBirth);
		blacklistcustomer.setActive(active);

		blacklistCustomerPersistence.update(blacklistcustomer);

		return blacklistcustomer;
	}

	public BlacklistCustomer updateBlacklistCustomer(long blacklistCustomerId, String fullName, String firstName,
			String middleName, String lastName, String ktp, String kitas, String email, Date dateOfBirth, int active)
			throws PortalException {
		BlacklistCustomer blacklistcustomer = blacklistCustomerPersistence.findByPrimaryKey(blacklistCustomerId);

		blacklistcustomer.setBlacklistCustomerId(blacklistCustomerId);
		blacklistcustomer.setFullName(fullName);
		blacklistcustomer.setFirstName(firstName);
		blacklistcustomer.setMiddleName(middleName);
		blacklistcustomer.setLastName(lastName);
		blacklistcustomer.setKtp(ktp);
		blacklistcustomer.setKitas(kitas);
		blacklistcustomer.setEmail(email);
		blacklistcustomer.setDateOfBirth(dateOfBirth);
		blacklistcustomer.setActive(active);

		blacklistCustomerPersistence.update(blacklistcustomer);

		return blacklistcustomer;
	}

	public BlacklistCustomer updateBlacklistCustomer(long blacklistCustomerId, String fullName, String firstName,
			String middleName, String lastName, String ktp, String kitas, String email, Date dateOfBirth)
			throws PortalException {
		BlacklistCustomer blacklistcustomer = blacklistCustomerPersistence.findByPrimaryKey(blacklistCustomerId);

		blacklistcustomer.setBlacklistCustomerId(blacklistCustomerId);
		blacklistcustomer.setFullName(fullName);
		blacklistcustomer.setFirstName(firstName);
		blacklistcustomer.setMiddleName(middleName);
		blacklistcustomer.setLastName(lastName);
		blacklistcustomer.setKtp(ktp);
		blacklistcustomer.setKitas(kitas);
		blacklistcustomer.setEmail(email);
		blacklistcustomer.setDateOfBirth(dateOfBirth);

		blacklistCustomerPersistence.update(blacklistcustomer);

		return blacklistcustomer;
	}

	public List<BlacklistCustomer> getBlacklistCustomers() {
		return blacklistCustomerPersistence.findAll();
	}

	public int getBlacklistCustomerCount() {
		return blacklistCustomerPersistence.countAll();
	}

	public BlacklistCustomer setActive(long blacklistCustomerId, int active, ServiceContext serviceContext)
			throws PortalException {
		BlacklistCustomer blacklistCustomer = null;

		try {
			blacklistCustomer = blacklistCustomerPersistence.findByPrimaryKey(blacklistCustomerId);
			Date now = new Date();
			blacklistCustomer.setBlacklistCustomerId(blacklistCustomerId);
			blacklistCustomer.setActive(active);
			blacklistCustomer.setModifiedDate(serviceContext.getModifiedDate(now));

			blacklistCustomerPersistence.update(blacklistCustomer);
		} catch (Exception e) {
			System.out.println(e);
		}

		return blacklistCustomer;
	}

	public List<BlacklistCustomer> blacklistFullName(String fullName) {
		return blacklistCustomerPersistence.findByfullName(fullName);
	}

	public List<BlacklistCustomer> checkBlackList(String fullName, String ktp, String kitas, String email,
			Date dateOfBirth) {
		List<BlacklistCustomer> _result = null;

		DynamicQuery query = BlacklistCustomerLocalServiceUtil.dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("fullName"));

		Criterion condition = null;

		if (Validator.isNotNull(fullName)) {
			condition = RestrictionsFactoryUtil.ilike("fullName", fullName);

			if (Validator.isNotNull(dateOfBirth)) {
				condition = RestrictionsFactoryUtil.and(condition,
						RestrictionsFactoryUtil.eq("dateOfBirth", dateOfBirth));
			}
		}

		if (condition != null && Validator.isNotNull(ktp)) {
			condition = RestrictionsFactoryUtil.or(condition, RestrictionsFactoryUtil.eq("ktp", ktp));
		} else if (Validator.isNotNull(ktp)) {
			condition = RestrictionsFactoryUtil.eq("ktp", ktp);
		}

		if (condition != null && Validator.isNotNull(kitas)) {
			condition = RestrictionsFactoryUtil.or(condition, RestrictionsFactoryUtil.eq("kitas", kitas));
		} else if (Validator.isNotNull(kitas)) {
			condition = RestrictionsFactoryUtil.eq("kitas", kitas);
		}

		if (condition != null && Validator.isNotNull(email)) {
			condition = RestrictionsFactoryUtil.or(condition, RestrictionsFactoryUtil.eq("email", email));
		} else if (Validator.isNotNull(email)) {
			condition = RestrictionsFactoryUtil.ilike("email", email);
		}

		query.add(condition);

		_result = BlacklistCustomerLocalServiceUtil.dynamicQuery(query);

		return _result;
	}
}