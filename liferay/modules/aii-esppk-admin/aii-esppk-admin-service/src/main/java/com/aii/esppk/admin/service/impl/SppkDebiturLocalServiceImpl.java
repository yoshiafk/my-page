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

import com.aii.esppk.admin.model.SppkDebitur;
import com.aii.esppk.admin.service.base.SppkDebiturLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gositus
 */
@Component(property = "model.class.name=com.aii.esppk.admin.model.SppkDebitur", service = AopService.class)
public class SppkDebiturLocalServiceImpl extends SppkDebiturLocalServiceBaseImpl {

    private static final String FULLNAME = "fullName";
    private static final String ID_NUMBER = "idNumber";
    private static final String BIRTH_DATE = "birthDate";
    private static final String CREATE_DATE = "createDate";
    private static final String SUBMIT_ESPPK_DATE = "submitEsppkDate";
    private static final String APPLICATION_NUMBER = "applicationNumber";
    private static final String SUBMISSION_NUMBER = "submissionNumber";
    private static final String ESPPKQ1 = "esppkQ1";
    private static final String ESPPKQ2 = "esppkQ2";
    private static final String ESPPKQ3 = "esppkQ3";

	public SppkDebitur addSppkDebitur(String fullName, String birthPlace, Date birthDate, String idNumber,
			String occupation, String email, String phoneNumber, String gender, BigDecimal sumInsured, String product,
            String applicationNumber, String address, String submissionNumber)
			throws PortalException {
		long sppkDebiturId = counterLocalService.increment();
		SppkDebitur sppkDebitur = sppkDebiturPersistence.create(sppkDebiturId);

        sppkDebitur.setApplicationNumber(applicationNumber);
		sppkDebitur.setFullName(fullName);
		sppkDebitur.setBirthPlace(birthPlace);
		sppkDebitur.setBirthDate(birthDate);
		sppkDebitur.setIdNumber(idNumber);
        sppkDebitur.setAddress(address);
		sppkDebitur.setOccupation(occupation);
		sppkDebitur.setEmail(email);
		sppkDebitur.setPhoneNumber(phoneNumber);
		sppkDebitur.setGender(gender);
		sppkDebitur.setSumInsured(sumInsured);
		sppkDebitur.setProduct(product);
		sppkDebitur.setSubmissionNumber(submissionNumber);

		sppkDebiturPersistence.update(sppkDebitur);

		return sppkDebitur;
	}

	public SppkDebitur updateSppkDebitur(long sppkDebiturId, String fullName, String birthPlace, Date birthDate,
			String idNumber, String occupation, String email, String phoneNumber, String gender, BigDecimal sumInsured,
			String product, String applicationNumber, String address) throws PortalException {
		SppkDebitur sppkDebitur = sppkDebiturPersistence.findByPrimaryKey(sppkDebiturId);

        sppkDebitur.setApplicationNumber(applicationNumber);
		sppkDebitur.setFullName(fullName);
		sppkDebitur.setBirthPlace(birthPlace);
		sppkDebitur.setBirthDate(birthDate);
		sppkDebitur.setIdNumber(idNumber);
        sppkDebitur.setAddress(address);
		sppkDebitur.setOccupation(occupation);
		sppkDebitur.setEmail(email);
		sppkDebitur.setPhoneNumber(phoneNumber);
		sppkDebitur.setGender(gender);
		sppkDebitur.setSumInsured(sumInsured);
		sppkDebitur.setProduct(product);

		sppkDebiturPersistence.update(sppkDebitur);

		return sppkDebitur;
	}

    public SppkDebitur updateSppkDebitur(long sppkDebiturId, String esppkToken, Date esppkTokenExpiry) throws PortalException {
        SppkDebitur sppkDebitur = sppkDebiturPersistence.findByPrimaryKey(sppkDebiturId);

        sppkDebitur.setEsppkToken(esppkToken);
        sppkDebitur.setEsppkTokenExpiry(esppkTokenExpiry);

        sppkDebiturPersistence.update(sppkDebitur);

        return sppkDebitur;
    }

    public SppkDebitur updateSppkDebitur(long sppkDebiturId, int esppkQ1, int esppkQ2, int esppkQ3, int agreeRiplay,
            int agreeStatement, int needAssistance, Date submitEsppkDate) throws PortalException {
        SppkDebitur sppkDebitur = sppkDebiturPersistence.findByPrimaryKey(sppkDebiturId);

        sppkDebitur.setEsppkQ1(esppkQ1);
        sppkDebitur.setEsppkQ2(esppkQ2);
        sppkDebitur.setEsppkQ3(esppkQ3);
        sppkDebitur.setAgreeRiplay(agreeRiplay);
        sppkDebitur.setAgreeStatement(agreeStatement);
        sppkDebitur.setNeedAssistance(needAssistance);
        sppkDebitur.setSubmitEsppkDate(submitEsppkDate);

        sppkDebiturPersistence.update(sppkDebitur);

        return sppkDebitur;
    }

	public List<SppkDebitur> filterDebitur(JSONObject data, int start, int end, JSONArray sortArray) throws PortalException {
		List<SppkDebitur> sppkDebitur = null;

		DynamicQuery query = sppkDebiturLocalService.dynamicQuery();
		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

        String fullName = data.getString(FULLNAME);
        String idNumber = data.getString(ID_NUMBER);
        String createDateString = data.getString(CREATE_DATE);
        String applicationNumber = data.getString(APPLICATION_NUMBER);
        String submissionNumber = data.getString(SUBMISSION_NUMBER);

        if (!fullName.isEmpty()) {
            conjunction.add(RestrictionsFactoryUtil.ilike(FULLNAME, "%" + fullName + "%"));
        }

        if (!idNumber.isEmpty()) {
            conjunction.add(RestrictionsFactoryUtil.eq(ID_NUMBER, idNumber));
        }

        if (!createDateString.isEmpty()) {
            LocalDate local = LocalDate.parse(createDateString);

            // mulai dari jam 00:00:00
            Date startDate = Date.from(local.atStartOfDay(ZoneId.systemDefault()).toInstant());

            // sampai jam 23:59:59.999
            Date endDate = Date.from(local.atTime(23, 59, 59, 999_000_000)
                    .atZone(ZoneId.systemDefault())
                    .toInstant());

            conjunction.add(RestrictionsFactoryUtil.ge(CREATE_DATE, startDate));
            conjunction.add(RestrictionsFactoryUtil.le(CREATE_DATE, endDate));
        }

        if (!applicationNumber.isEmpty()) {
            conjunction.add(RestrictionsFactoryUtil.eq(APPLICATION_NUMBER, applicationNumber));
        }
        
        if (!submissionNumber.isEmpty()) {
            conjunction.add(RestrictionsFactoryUtil.eq(SUBMISSION_NUMBER, submissionNumber));
        }

		query.add(conjunction);

        for (int i = 0; i < sortArray.length(); i++) {
            JSONObject s = sortArray.getJSONObject(i);
            String col = s.getString("column");
            String dir = s.getString("direction");

            if ("asc".equalsIgnoreCase(dir)) {
                query.addOrder(PropertyFactoryUtil.forName(col).asc());
            } else {
                query.addOrder(PropertyFactoryUtil.forName(col).desc());
            }
        }

		sppkDebitur = sppkDebiturLocalService.dynamicQuery(query, start, end);
		

		return sppkDebitur;
	}

    public int countFilterDebitur(JSONObject data) throws PortalException {
        DynamicQuery query = sppkDebiturLocalService.dynamicQuery();
        Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

        String fullName = data.getString(FULLNAME);
        String idNumber = data.getString(ID_NUMBER);
        String createDateString = data.getString(CREATE_DATE);
        String applicationNumber = data.getString(APPLICATION_NUMBER);
        String submissionNumber = data.getString(SUBMISSION_NUMBER);

        if (!fullName.isEmpty()) {
            conjunction.add(RestrictionsFactoryUtil.ilike(FULLNAME, "%" + fullName + "%"));
        }

        if (!idNumber.isEmpty()) {
            conjunction.add(RestrictionsFactoryUtil.eq(ID_NUMBER, idNumber));
        }

        if (!createDateString.isEmpty()) {
            LocalDate local = LocalDate.parse(createDateString);

            // mulai dari jam 00:00:00
            Date startDate = Date.from(local.atStartOfDay(ZoneId.systemDefault()).toInstant());

            // sampai jam 23:59:59.999
            Date endDate = Date.from(local.atTime(23, 59, 59, 999_000_000)
                    .atZone(ZoneId.systemDefault())
                    .toInstant());

            conjunction.add(RestrictionsFactoryUtil.ge(CREATE_DATE, startDate));
            conjunction.add(RestrictionsFactoryUtil.le(CREATE_DATE, endDate));
        }

        if (!applicationNumber.isEmpty()) {
            conjunction.add(RestrictionsFactoryUtil.eq(APPLICATION_NUMBER, applicationNumber));
        }

        if (!submissionNumber.isEmpty()) {
            conjunction.add(RestrictionsFactoryUtil.eq(SUBMISSION_NUMBER, submissionNumber));
        }

        query.add(conjunction);

        return (int) sppkDebiturLocalService.dynamicQueryCount(query);
    }
	
	public int countTotalSppkDebitur() {
		return sppkDebiturPersistence.countAll();
	}

    public List<SppkDebitur> filterMonitoring(JSONObject data, int start, int end, JSONArray sortArray) throws PortalException {
        DynamicQuery query = sppkDebiturLocalService.dynamicQuery();
        Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

        conjunction.add(RestrictionsFactoryUtil.isNotNull(SUBMIT_ESPPK_DATE));

        String fullName = data.getString(FULLNAME);
        String idNumber = data.getString(ID_NUMBER);
        String birthDateString = data.getString(BIRTH_DATE);
        String status = data.getString("status");
        String submitEsppkDateString = data.getString(SUBMIT_ESPPK_DATE);
        String applicationNumber = data.getString(APPLICATION_NUMBER);
        String submissionNumber = data.getString(SUBMISSION_NUMBER);

        if (!fullName.isEmpty()) {
            conjunction.add(RestrictionsFactoryUtil.ilike(FULLNAME, "%" + fullName + "%"));
        }

        if (!idNumber.isEmpty()) {
            conjunction.add(RestrictionsFactoryUtil.ilike(ID_NUMBER, "%" + idNumber + "%"));
        }

        if (!birthDateString.isEmpty()) {
            LocalDate local = LocalDate.parse(birthDateString);
            Date birthDate = Date.from(local.atStartOfDay(ZoneId.systemDefault()).toInstant());
            conjunction.add(RestrictionsFactoryUtil.eq(BIRTH_DATE, birthDate));
        }

        if (!status.isEmpty()) {
            if (status.equalsIgnoreCase("eligible")) {
                conjunction.add(RestrictionsFactoryUtil.eq(ESPPKQ1, 0));
                conjunction.add(RestrictionsFactoryUtil.eq(ESPPKQ2, 0));
                conjunction.add(RestrictionsFactoryUtil.eq(ESPPKQ3, 0));
            } else if (status.equalsIgnoreCase("not eligible")) {
                Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
                disjunction.add(RestrictionsFactoryUtil.eq(ESPPKQ1, 1));
                disjunction.add(RestrictionsFactoryUtil.eq(ESPPKQ2, 1));
                disjunction.add(RestrictionsFactoryUtil.eq(ESPPKQ3, 1));
                conjunction.add(disjunction);
            }
        }

        if (!submitEsppkDateString.isEmpty()) {
            LocalDate local = LocalDate.parse(submitEsppkDateString);

            // mulai dari jam 00:00:00
            Date startDate = Date.from(local.atStartOfDay(ZoneId.systemDefault()).toInstant());

            // sampai jam 23:59:59.999
            Date endDate = Date.from(local.atTime(23, 59, 59, 999_000_000)
                    .atZone(ZoneId.systemDefault())
                    .toInstant());

            conjunction.add(RestrictionsFactoryUtil.ge(SUBMIT_ESPPK_DATE, startDate));
            conjunction.add(RestrictionsFactoryUtil.le(SUBMIT_ESPPK_DATE, endDate));
        }

        if (!applicationNumber.isEmpty()) {
            conjunction.add(RestrictionsFactoryUtil.ilike(APPLICATION_NUMBER, "%" + applicationNumber + "%"));
        }

        if (!submissionNumber.isEmpty()) {
            conjunction.add(RestrictionsFactoryUtil.ilike(SUBMISSION_NUMBER, "%" + submissionNumber + "%"));
        }

        query.add(conjunction);

        for (int i = 0; i < sortArray.length(); i++) {
            JSONObject s = sortArray.getJSONObject(i);
            String col = s.getString("column");
            String dir = s.getString("direction");

            if ("asc".equalsIgnoreCase(dir)) {
                query.addOrder(PropertyFactoryUtil.forName(col).asc());
            } else {
                query.addOrder(PropertyFactoryUtil.forName(col).desc());
            }
        }

        return sppkDebiturLocalService.dynamicQuery(query, start, end);
    }

    public int countFilterMonitoring(JSONObject data) throws PortalException {
        DynamicQuery query = sppkDebiturLocalService.dynamicQuery();
        Conjunction conjunction = RestrictionsFactoryUtil.conjunction();

        conjunction.add(RestrictionsFactoryUtil.isNotNull(SUBMIT_ESPPK_DATE));

        String fullName = data.getString(FULLNAME);
        String idNumber = data.getString(ID_NUMBER);
        String birthDateString = data.getString(BIRTH_DATE);
        String status = data.getString("status");
        String submitEsppkDateString = data.getString(SUBMIT_ESPPK_DATE);
        String applicationNumber = data.getString(APPLICATION_NUMBER);
        String submissionNumber = data.getString(SUBMISSION_NUMBER);

        if (!fullName.isEmpty()) {
            conjunction.add(RestrictionsFactoryUtil.ilike(FULLNAME, "%" + fullName + "%"));
        }

        if (!idNumber.isEmpty()) {
            conjunction.add(RestrictionsFactoryUtil.ilike(ID_NUMBER, "%" + idNumber + "%"));
        }

        if (!birthDateString.isEmpty()) {
            LocalDate local = LocalDate.parse(birthDateString);
            Date birthDate = Date.from(local.atStartOfDay(ZoneId.systemDefault()).toInstant());
            conjunction.add(RestrictionsFactoryUtil.eq(BIRTH_DATE, birthDate));
        }

        if (!status.isEmpty()) {
            if (status.equalsIgnoreCase("eligible")) {
                conjunction.add(RestrictionsFactoryUtil.eq(ESPPKQ1, 0));
                conjunction.add(RestrictionsFactoryUtil.eq(ESPPKQ2, 0));
                conjunction.add(RestrictionsFactoryUtil.eq(ESPPKQ3, 0));
            } else if (status.equalsIgnoreCase("not eligible")) {
                Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
                disjunction.add(RestrictionsFactoryUtil.eq(ESPPKQ1, 1));
                disjunction.add(RestrictionsFactoryUtil.eq(ESPPKQ2, 1));
                disjunction.add(RestrictionsFactoryUtil.eq(ESPPKQ3, 1));
                conjunction.add(disjunction);
            }
        }

        if (!submitEsppkDateString.isEmpty()) {
            LocalDate local = LocalDate.parse(submitEsppkDateString);

            // mulai dari jam 00:00:00
            Date startDate = Date.from(local.atStartOfDay(ZoneId.systemDefault()).toInstant());

            // sampai jam 23:59:59.999
            Date endDate = Date.from(local.atTime(23, 59, 59, 999_000_000)
                    .atZone(ZoneId.systemDefault())
                    .toInstant());

            conjunction.add(RestrictionsFactoryUtil.ge(SUBMIT_ESPPK_DATE, startDate));
            conjunction.add(RestrictionsFactoryUtil.le(SUBMIT_ESPPK_DATE, endDate));
        }

        if (!applicationNumber.isEmpty()) {
            conjunction.add(RestrictionsFactoryUtil.ilike(APPLICATION_NUMBER, "%" + applicationNumber + "%"));
        }

        if (!submissionNumber.isEmpty()) {
            conjunction.add(RestrictionsFactoryUtil.ilike(SUBMISSION_NUMBER, "%" + submissionNumber + "%"));
        }

        query.add(conjunction);

        return (int) sppkDebiturLocalService.dynamicQueryCount(query);
    }

    public int countTotalSppkDebiturSubmitted() {
        DynamicQuery query = sppkDebiturLocalService.dynamicQuery();

        query.add(RestrictionsFactoryUtil.isNotNull(SUBMIT_ESPPK_DATE));

        return (int) sppkDebiturLocalService.dynamicQueryCount(query);
    }

}