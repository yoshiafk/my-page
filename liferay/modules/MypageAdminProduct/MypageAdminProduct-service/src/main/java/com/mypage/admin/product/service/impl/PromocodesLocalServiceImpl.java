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
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.admin.product.model.ProductConfiguration;
import com.mypage.admin.product.model.Promocodes;
import com.mypage.admin.product.service.ProductConfigurationLocalServiceUtil;
import com.mypage.admin.product.service.base.PromocodesLocalServiceBaseImpl;
import com.mypage.admin.product.service.persistence.PromocodesPersistence;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.Promocodes",
	service = AopService.class
)
public class PromocodesLocalServiceImpl extends PromocodesLocalServiceBaseImpl {
	
	public Promocodes addPromocodes(long promocodeId, JSONObject data, ServiceContext serviceContext)
			throws PortalException {

		Promocodes promo = null;
		double commission = 0.0;

		ProductConfiguration _configList = ProductConfigurationLocalServiceUtil
				.getConfigByCode(data.getString("product"));
		ProductConfiguration _config = _configList;

		try {
			if (promocodeId == 0) {
				promocodeId = counterLocalService.increment();
				promo = _promocodesPersistence.create(promocodeId);
			} else {
				promo = _promocodesPersistence.findByPrimaryKey(promocodeId);
			}

			long groupId = serviceContext.getScopeGroupId();
			// User user = userLocalService.getUserById(userId);
			Date now = new Date();
			commission = data.getDouble("discount") - _config.getCommission();

			System.out.println(commission);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			promo.setPromocodeId(promocodeId);
			promo.setProducts(data.getString("product"));
			promo.setCommission(commission);
			promo.setPromocode(data.getString("promocode"));
			promo.setDiscount(data.getDouble("discount"));
			promo.setLimit(data.getInt("limit"));
			promo.setIsB2C(0);
			promo.setIsB2B2C(0);
			promo.setIsB2B(0);
			if (Validator.isNotNull(data.get("startDate"))) {
				Date startDate = sdf.parse(data.getString("startDate"));
				promo.setStartDate(startDate);
			}

			if (Validator.isNotNull(data.get("endDate"))) {
				Date endDate = sdf.parse(data.getString("endDate"));
				promo.setEndDate(endDate);
			}

			promo.setPromoType(data.getString(null));
			promo.setBirthdayMonth(null);
			// promo.setLimit(data.getInt(null));
			promo.setTerms(data.getString("PromocodeTerms"));
			promo.setPlan(data.getString(null));
			promo.setPaymentChannel(data.getString(null));
			promo.setUtmCampaignId(data.getString(null));
			promo.setActive(data.getInt("status"));

			promo.setUuid(serviceContext.getUuid());
			promo.setUserId(serviceContext.getUserId());
			promo.setGroupId(groupId);
			promo.setCompanyId(serviceContext.getCompanyId());
			// promo.setUserName(user.getFullName());
			promo.setCreateDate(serviceContext.getCreateDate(now));
			promo.setModifiedDate(serviceContext.getModifiedDate(now));
			promo.setExpandoBridgeAttributes(serviceContext);

			_promocodesPersistence.update(promo);

		} catch (Exception e) {
			// TODO: handle exception
            log.debug(e.getMessage());
		}

		return promo;
	}

	public Promocodes updatePromocodes(long promocodeId, JSONObject data) throws JSONException, PortalException {
		Promocodes promo = null;
		try {

			// User user = userLocalService.getUserById(userId);

			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			if (promocodeId > 0) {

				if (!Validator.isNull(promocodeId)) {
					promo = promocodesPersistence.fetchByPrimaryKey(promocodeId);

					promo.setPromocodeId(promocodeId);
					promo.setProducts(data.getString("product"));
					promo.setPromocode(data.getString("promocode"));
					promo.setDiscount(data.getDouble("discount"));
					promo.setLimit(data.getInt("limit"));
					if (Validator.isNotNull(data.get("startDate"))) {
						Date startDate = sdf.parse(data.getString("startDate"));
						promo.setStartDate(startDate);
					}

					if (Validator.isNotNull(data.get("endDate"))) {
						Date endDate = sdf.parse(data.getString("endDate"));
						promo.setEndDate(endDate);
					}
					promo.setActive(data.getInt("status"));

					_promocodesPersistence.update(promo);

				}
			}

		} catch (Exception e) {
			// TODO: handle exception
            log.debug(e.getMessage());
		}
		return promo;

	}

	public Promocodes setActive(long userId, long promocodeId, int active, ServiceContext serviceContext)
			throws PortalException {
		Promocodes promo = null;

		try {
			promo = _promocodesPersistence.findByPrimaryKey(promocodeId);
			Date now = new Date();
			promo.setPromocodeId(promocodeId);
			promo.setActive(active);
			promo.setModifiedDate(serviceContext.getModifiedDate(now));

			_promocodesPersistence.update(promo);

		} catch (Exception e) {
			// TODO: handle exception
            log.debug(e.getMessage());
		}

		return promo;
	}

	public List<Promocodes> searchB2CPromo(String promocode, Date startDate, Date endDate, String products) {
		List<Promocodes> promo = null;
		try {
			promo = _promocodesPersistence.findBysearchB2CPromo(promocode, startDate, endDate, '%' + products + '%');
			return promo;
		} catch (Exception e) {
			// TODO: handle exception
            log.debug(e.getMessage());
		}

		return promo;
	}

    private static final Log log = LogFactoryUtil.getLog(PromocodesLocalServiceImpl.class);

	@Reference
	PromocodesPersistence _promocodesPersistence;	
}