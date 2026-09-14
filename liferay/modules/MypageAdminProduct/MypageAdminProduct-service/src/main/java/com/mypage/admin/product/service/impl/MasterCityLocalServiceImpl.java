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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.admin.product.model.MasterCity;
import com.mypage.admin.product.model.MasterProvince;
import com.mypage.admin.product.service.MasterProvinceLocalServiceUtil;
import com.mypage.admin.product.service.base.MasterCityLocalServiceBaseImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.MasterCity",
	service = AopService.class
)
public class MasterCityLocalServiceImpl extends MasterCityLocalServiceBaseImpl {
	
	public MasterCity addMasterCity(String name, long provinceId, String status, int parEarthquakeZone, int active)
			throws PortalException {
		long cityId = counterLocalService.increment();
		MasterCity mastercity = masterCityPersistence.create(cityId);

		mastercity.setName(name);
		mastercity.setProvinceId(provinceId);
		mastercity.setStatus(status);
		mastercity.setParEarthquakeZone(parEarthquakeZone);
		mastercity.setActive(active);

		masterCityPersistence.update(mastercity);

		return mastercity;
	}

	public MasterCity updateMasterCity(long masterCityId, String name, long provinceId, String status,
			int parEarthquakeZone, int active) throws PortalException {
		MasterCity mastercity = masterCityPersistence.findByPrimaryKey(masterCityId);

		mastercity.setName(name);
		mastercity.setProvinceId(provinceId);
		mastercity.setStatus(status);
		mastercity.setParEarthquakeZone(parEarthquakeZone);
		mastercity.setActive(active);

		masterCityPersistence.update(mastercity);

		return mastercity;
	}

	public MasterCity setActive(long masterCityId, int active, ServiceContext serviceContext) throws PortalException {
		MasterCity mastercity = null;

		try {
			mastercity = masterCityPersistence.findByPrimaryKey(masterCityId);
			Date now = new Date();
			mastercity.setActive(active);
			mastercity.setModifiedDate(serviceContext.getModifiedDate(now));

			masterCityPersistence.update(mastercity);
		} catch (Exception e) {
			System.out.println(e);
		}

		return mastercity;
	}

	public List<MasterCity> getActiveCities() {
		List<MasterCity> cities = masterCityPersistence.findByactiveCities(1);
		return cities;
	}
	
	public List<MasterCity> getCityProvinceMap() {
		List<MasterCity> cities = masterCityPersistence.findAll();
		Map<MasterCity, String> cityProvinceMap = new HashMap<>();
		
		for(MasterCity city:cities) {
			try {
				MasterProvince prov = MasterProvinceLocalServiceUtil.getMasterProvince(city.getProvinceId());
				cityProvinceMap.put(city, prov.getName());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		for (Map.Entry<MasterCity, String> entry : cityProvinceMap.entrySet()) {
		    MasterCity city = entry.getKey();
		    String provinceName = entry.getValue();
		}
		
		return cities;
	}
	
	public JSONObject getJsonCities() {
		JSONObject result = JSONFactoryUtil.createJSONObject();
		JSONObject data = JSONFactoryUtil.createJSONObject();
		result.put("Status", 0);
		result.put("Data", data);

		List<MasterCity> cities = getActiveCities();

		if (!cities.isEmpty()) {
			for (MasterCity city : cities) {
				JSONObject dataCity = JSONFactoryUtil.createJSONObject();
				dataCity.put("id", city.getMasterCityId());
				dataCity.put("name", city.getName());
				dataCity.put("status", city.getStatus());
				dataCity.put("parEarthquakeZone", city.getParEarthquakeZone());

				if (data.getJSONArray(String.valueOf(city.getProvinceId())) != null) {
					JSONArray temp = data.getJSONArray(String.valueOf(city.getProvinceId()));
					temp.put(dataCity);
					data.put(String.valueOf(city.getProvinceId()), temp);
				} else {
					JSONArray temp = JSONFactoryUtil.createJSONArray();
					temp.put(dataCity);
					data.put(String.valueOf(city.getProvinceId()), temp);
				}
			}

			result.put("Status", 1);
			result.put("Data", data);
		}
		return result;
	}

	public List<MasterCity> searchByProvinceId(long provinceId) {
		return masterCityPersistence.findBysearchByProvinceId(provinceId);
	}
	
}