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

package com.mypage.admin.product.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MasterCountry}.
 * </p>
 *
 * @author Gositus Team
 * @see MasterCountry
 * @generated
 */
public class MasterCountryWrapper
	extends BaseModelWrapper<MasterCountry>
	implements MasterCountry, ModelWrapper<MasterCountry> {

	public MasterCountryWrapper(MasterCountry masterCountry) {
		super(masterCountry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("countryId", getCountryId());
		attributes.put("name", getName());
		attributes.put("isPlatinum", getIsPlatinum());
		attributes.put("isGold", getIsGold());
		attributes.put("isSpecialAsia", getIsSpecialAsia());
		attributes.put("isSchengen", getIsSchengen());
		attributes.put("isSanctionCountry", getIsSanctionCountry());
		attributes.put("active", getActive());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer isPlatinum = (Integer)attributes.get("isPlatinum");

		if (isPlatinum != null) {
			setIsPlatinum(isPlatinum);
		}

		Integer isGold = (Integer)attributes.get("isGold");

		if (isGold != null) {
			setIsGold(isGold);
		}

		Integer isSpecialAsia = (Integer)attributes.get("isSpecialAsia");

		if (isSpecialAsia != null) {
			setIsSpecialAsia(isSpecialAsia);
		}

		Integer isSchengen = (Integer)attributes.get("isSchengen");

		if (isSchengen != null) {
			setIsSchengen(isSchengen);
		}

		Integer isSanctionCountry = (Integer)attributes.get(
			"isSanctionCountry");

		if (isSanctionCountry != null) {
			setIsSanctionCountry(isSanctionCountry);
		}

		Integer active = (Integer)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the active of this master country.
	 *
	 * @return the active of this master country
	 */
	@Override
	public Integer getActive() {
		return model.getActive();
	}

	/**
	 * Returns the company ID of this master country.
	 *
	 * @return the company ID of this master country
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the country ID of this master country.
	 *
	 * @return the country ID of this master country
	 */
	@Override
	public long getCountryId() {
		return model.getCountryId();
	}

	/**
	 * Returns the create date of this master country.
	 *
	 * @return the create date of this master country
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this master country.
	 *
	 * @return the group ID of this master country
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is gold of this master country.
	 *
	 * @return the is gold of this master country
	 */
	@Override
	public Integer getIsGold() {
		return model.getIsGold();
	}

	/**
	 * Returns the is platinum of this master country.
	 *
	 * @return the is platinum of this master country
	 */
	@Override
	public Integer getIsPlatinum() {
		return model.getIsPlatinum();
	}

	/**
	 * Returns the is sanction country of this master country.
	 *
	 * @return the is sanction country of this master country
	 */
	@Override
	public Integer getIsSanctionCountry() {
		return model.getIsSanctionCountry();
	}

	/**
	 * Returns the is schengen of this master country.
	 *
	 * @return the is schengen of this master country
	 */
	@Override
	public Integer getIsSchengen() {
		return model.getIsSchengen();
	}

	/**
	 * Returns the is special asia of this master country.
	 *
	 * @return the is special asia of this master country
	 */
	@Override
	public Integer getIsSpecialAsia() {
		return model.getIsSpecialAsia();
	}

	/**
	 * Returns the modified date of this master country.
	 *
	 * @return the modified date of this master country
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this master country.
	 *
	 * @return the name of this master country
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this master country.
	 *
	 * @return the primary key of this master country
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this master country.
	 *
	 * @return the user ID of this master country
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this master country.
	 *
	 * @return the user name of this master country
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this master country.
	 *
	 * @return the user uuid of this master country
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this master country.
	 *
	 * @param active the active of this master country
	 */
	@Override
	public void setActive(Integer active) {
		model.setActive(active);
	}

	/**
	 * Sets the company ID of this master country.
	 *
	 * @param companyId the company ID of this master country
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the country ID of this master country.
	 *
	 * @param countryId the country ID of this master country
	 */
	@Override
	public void setCountryId(long countryId) {
		model.setCountryId(countryId);
	}

	/**
	 * Sets the create date of this master country.
	 *
	 * @param createDate the create date of this master country
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this master country.
	 *
	 * @param groupId the group ID of this master country
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the is gold of this master country.
	 *
	 * @param isGold the is gold of this master country
	 */
	@Override
	public void setIsGold(Integer isGold) {
		model.setIsGold(isGold);
	}

	/**
	 * Sets the is platinum of this master country.
	 *
	 * @param isPlatinum the is platinum of this master country
	 */
	@Override
	public void setIsPlatinum(Integer isPlatinum) {
		model.setIsPlatinum(isPlatinum);
	}

	/**
	 * Sets the is sanction country of this master country.
	 *
	 * @param isSanctionCountry the is sanction country of this master country
	 */
	@Override
	public void setIsSanctionCountry(Integer isSanctionCountry) {
		model.setIsSanctionCountry(isSanctionCountry);
	}

	/**
	 * Sets the is schengen of this master country.
	 *
	 * @param isSchengen the is schengen of this master country
	 */
	@Override
	public void setIsSchengen(Integer isSchengen) {
		model.setIsSchengen(isSchengen);
	}

	/**
	 * Sets the is special asia of this master country.
	 *
	 * @param isSpecialAsia the is special asia of this master country
	 */
	@Override
	public void setIsSpecialAsia(Integer isSpecialAsia) {
		model.setIsSpecialAsia(isSpecialAsia);
	}

	/**
	 * Sets the modified date of this master country.
	 *
	 * @param modifiedDate the modified date of this master country
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this master country.
	 *
	 * @param name the name of this master country
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this master country.
	 *
	 * @param primaryKey the primary key of this master country
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this master country.
	 *
	 * @param userId the user ID of this master country
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this master country.
	 *
	 * @param userName the user name of this master country
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this master country.
	 *
	 * @param userUuid the user uuid of this master country
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected MasterCountryWrapper wrap(MasterCountry masterCountry) {
		return new MasterCountryWrapper(masterCountry);
	}

}