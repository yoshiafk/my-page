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
import com.liferay.portal.kernel.exception.PortalException;
import com.mypage.admin.product.exception.NoSuchSmartTravelIntLinkException;
import com.mypage.admin.product.model.SmartTravelIntLink;
import com.mypage.admin.product.service.base.SmartTravelIntLinkLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(property = "model.class.name=com.mypage.admin.product.model.SmartTravelIntLink", service = AopService.class)
public class SmartTravelIntLinkLocalServiceImpl extends SmartTravelIntLinkLocalServiceBaseImpl {

	public SmartTravelIntLink addLink(String linkType, String linkTitle, String linkHref) throws PortalException {
		long linkId = counterLocalService.increment();
		SmartTravelIntLink link = smartTravelIntLinkPersistence.create(linkId);

		link.setLinkType(linkType);
		link.setLinkTitle(linkTitle);
		link.setLinkHref(linkHref);

		smartTravelIntLinkPersistence.update(link);

		return link;
	}

	public SmartTravelIntLink updateLink(long smartTravelIntLinkId, String linkType, String linkTitle, String linkHref)
			throws PortalException {
		SmartTravelIntLink link = smartTravelIntLinkPersistence.findByPrimaryKey(smartTravelIntLinkId);
		link.setLinkType(linkType);
		link.setLinkTitle(linkTitle);
		link.setLinkHref(linkHref);

		smartTravelIntLinkPersistence.update(link);
		return link;
	}

	public List<SmartTravelIntLink> getLinks() {
		return smartTravelIntLinkPersistence.findAll();
	}

	public int getLinksCount() {
		return smartTravelIntLinkPersistence.countAll();
	}

	public SmartTravelIntLink getByLinkType(String linkType) {
		SmartTravelIntLink link = null;

		try {
			link = smartTravelIntLinkPersistence.findByLinkType(linkType);
		} catch (NoSuchSmartTravelIntLinkException e) {
			System.out.println(e.getMessage());
		}

		return link;
	}
}