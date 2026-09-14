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
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mypage.admin.product.model.BenefitType;
import com.mypage.admin.product.service.base.BenefitTypeLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus Team
 */
@Component(
	property = "model.class.name=com.mypage.admin.product.model.BenefitType",
	service = AopService.class
)
public class BenefitTypeLocalServiceImpl
	extends BenefitTypeLocalServiceBaseImpl {
	
	public BenefitType addBenefitType(String nameId, String nameEn, int sort, int active)throws PortalException {
		long benefitTypeId = counterLocalService.increment();
		BenefitType benefitType = benefitTypePersistence.create(benefitTypeId);
		
		benefitType.setNameId(nameId);
		benefitType.setNameEn(nameEn);
		benefitType.setSort(sort);
		benefitType.setActive(active);
		
		benefitTypePersistence.update(benefitType);
		
		return benefitType;
		
	}
	
	public BenefitType updateBenefitType(long benefitTypeId, String nameId, String nameEn, int sort, int active) throws PortalException{
		BenefitType benefitTypeUpdate = benefitTypePersistence.findByPrimaryKey(benefitTypeId);
		
		benefitTypeUpdate.setBenefitTypeId(benefitTypeId);
		benefitTypeUpdate.setNameId(nameId);
		benefitTypeUpdate.setNameEn(nameEn);
		benefitTypeUpdate.setSort(sort);
		benefitTypeUpdate.setActive(active);
		
		benefitTypePersistence.update(benefitTypeUpdate);
		
		return benefitTypeUpdate;
	}
	
	public List<BenefitType> getAllBenefitTypes(){
		return benefitTypePersistence.findAll();
	}
	
	public List<BenefitType> getBenefitTypes(int start ,int end){
		return benefitTypePersistence.findAll(start, end);
	}
	
	public List<BenefitType> getActiveBenefitType(){
		List<BenefitType> list = null;
		DynamicQuery query = dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("sort"));
		query.add(PropertyFactoryUtil.forName("active").ge(new Integer(1)));
		list = dynamicQuery(query);
		
		return list;
	}
	
	public List<BenefitType> getBenefitTypeByName(String nameId, String nameEn) {
	    List<BenefitType> list = null;
	    
	    DynamicQuery query = dynamicQuery();
	    
	    Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
	    
	    disjunction.add(PropertyFactoryUtil.forName("nameId").eq(nameId));
	    disjunction.add(PropertyFactoryUtil.forName("nameEn").eq(nameEn));
	    
	    query.add(disjunction);
	    
	    query.add(PropertyFactoryUtil.forName("active").ge(1));
	    
	    list = dynamicQuery(query);
	    
	    return list;
	}
	
	public List<BenefitType> getBenefitTypeBySort(int sort) {
	    List<BenefitType> list = null;
	    
	    DynamicQuery query = dynamicQuery();
	    query.add(PropertyFactoryUtil.forName("active").ge(1));
	    
	    //by sort
	    query.add(PropertyFactoryUtil.forName("sort").ne(sort));
	    
	    list = dynamicQuery(query);
	    
	    return list;
	}

	
	
	public List<BenefitType> getBenefitTypes() {
		return benefitTypePersistence.findAll();
	}
	
	public int getBenefitTypeCount() {
		return benefitTypePersistence.countAll();
	}
	
	public BenefitType setActive(long benefitTypeId, int active, ServiceContext serviceContext) {
		BenefitType benefitType = null;
		
		try {
			benefitType = benefitTypePersistence.findByPrimaryKey(benefitTypeId);
			Date now = new Date();
			benefitType.setBenefitTypeId(benefitTypeId);
			benefitType.setActive(active);
			benefitType.setModifiedDate(serviceContext.getModifiedDate(now));
			
			benefitTypePersistence.update(benefitType);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return benefitType;
	}
	
	
	public List<BenefitType> getBenefitTypeAdditional() {
	    List<BenefitType> list = null;
	    
	    // Membuat dynamic query
	    DynamicQuery query = dynamicQuery();
	    
	    // Menambahkan urutan sort ascending berdasarkan kolom 'sort'
	    query.addOrder(OrderFactoryUtil.asc("sort"));
	    
	    // Menambahkan kondisi filter active >= 1
	    query.add(PropertyFactoryUtil.forName("active").ge(1));
	    
	    // Menambahkan kondisi filter nameId bukan "Jaminan Utama"
	    //query.add(PropertyFactoryUtil.forName("nameId").ne("Jaminan Utama"));
	    
	    // Menambahkan kondisi filter nameEn bukan "Main Benefit"
	    //query.add(PropertyFactoryUtil.forName("nameEn").ne("Main Benefit"));

	    //by sort
	    query.add(PropertyFactoryUtil.forName("sort").ne(1));
	    
	    // Menjalankan query dan mendapatkan list
	    list = dynamicQuery(query);
	    
	    return list;
	}
	
	public List<BenefitType> getBenefitTypeMain() {
	    List<BenefitType> list = null;
	    
	    // Membuat dynamic query
	    DynamicQuery query = dynamicQuery();
	    
	    // Menambahkan urutan sort ascending berdasarkan kolom 'sort'
	    query.addOrder(OrderFactoryUtil.asc("sort"));
	    
	    // Menambahkan kondisi filter active >= 1
	    query.add(PropertyFactoryUtil.forName("active").ge(1));
	    
	    // Menambahkan kondisi filter nameId bukan "Jaminan Utama"
	    //query.add(PropertyFactoryUtil.forName("nameId").eq("Jaminan Utama"));
	    
	    // Menambahkan kondisi filter nameEn bukan "Main Benefit"
	    //query.add(PropertyFactoryUtil.forName("nameEn").eq("Main Benefit"));
	    
	    //by sort
	    query.add(PropertyFactoryUtil.forName("sort").eq(1));

	    // Menjalankan query dan mendapatkan list
	    list = dynamicQuery(query);
	    
	    return list;
	}
	

}