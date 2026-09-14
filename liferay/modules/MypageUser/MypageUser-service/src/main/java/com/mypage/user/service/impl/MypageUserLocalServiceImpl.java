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

package com.mypage.user.service.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mypage.user.exception.MypageUserException;
import com.mypage.user.exception.NoSuchMypageUserException;
import com.mypage.user.model.CreditWallet;
import com.mypage.user.model.MypageUser;
import com.mypage.user.model.impl.CreditWalletBaseImpl;
import com.mypage.user.service.CreditWalletLocalService;
import com.mypage.user.service.CreditWalletLocalServiceUtil;
import com.mypage.user.service.MypageUserLocalServiceUtil;
import com.mypage.user.service.base.MypageUserLocalServiceBaseImpl;
import com.mypage.user.service.permission.MypageUserPermission;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.mypage.user.model.MypageUser",
	service = AopService.class
)
public class MypageUserLocalServiceImpl extends MypageUserLocalServiceBaseImpl {
	public MypageUser setActive(long id, int active, ServiceContext serviceContext) throws PortalException {
		MypageUser _mypageUser = null;

		try {
			_mypageUser = mypageUserPersistence.findByPrimaryKey(id);
			Date now = new Date();
			_mypageUser.setActive(active);
			_mypageUser.setModifiedDate(serviceContext.getModifiedDate(now));

			mypageUserPersistence.update(_mypageUser);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return _mypageUser;
	}

	/*
	 * Add / Update MypageUser
	 * 
	 * @param mypageUserId the primary key of the user
	 * 
	 * @param data data JSONObject
	 * 
	 * @param creatorUserId the primary key of the creator user
	 * 
	 * @param serviceContext service context
	 * 
	 */
	public MypageUser addMypageUser(long mypageUserId, JSONObject data, long userId, ServiceContext serviceContext)
			throws PortalException, ParseException {
		MypageUser _mypageUser = null;

		long groupId = serviceContext.getScopeGroupId();
		User user = userLocalService.getUserById(userId);

		long liferayUserId = data.getLong("liferayUserId");
		long companyId = data.getLong("companyId");
		String productIds = data.getString("productConfigurationsSearchContainerPrimaryKeys");
		// get pageKey
		String pageKey = data.getString("pageKey");

		data.put("groupId", groupId);
		data.put("companyId", companyId);
		data.put("userId", userId);
		data.put("userName", user.getFullName());

		User updateUser = null;
		if (liferayUserId > 0) {

			// update liferay user
			///////////////////
			if (pageKey.equals("basic_information")) {
				User getUser = UserLocalServiceUtil.getUserById(liferayUserId);

				// get birtday
				Integer day = null;
				Integer month = null;
				Integer year = null;
				if (Validator.isNotNull(data.getString("birthday"))) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

					// convert String to LocalDate
					LocalDate Dob = LocalDate.parse(data.getString("birthday"), formatter);

					day = Dob.getDayOfMonth();
					month = Dob.getMonthValue() - 1;
					year = Dob.getYear();
				}

				List<UserGroupRole> userGroupRoleList = UserGroupRoleLocalServiceUtil.getUserGroupRoles(liferayUserId,
						groupId);
				Contact contact = getUser.getContact();
				_userService.updateUser(liferayUserId, getUser.getPassword(), null, null, false, null, null,
						data.getString("screenName"), data.getString("emailAddress"), getUser.getLanguageId(),
						getUser.getTimeZoneId(), getUser.getGreeting(), getUser.getComments(),
						data.getString("firstName"), data.getString("middleName"), data.getString("lastName"), 0, 0,
						getUser.getMale(), month, day, year, contact.getSmsSn(), contact.getFacebookSn(),
						contact.getJabberSn(), contact.getSkypeSn(), contact.getTwitterSn(), getUser.getJobTitle(),
						getUser.getGroupIds(), getUser.getOrganizationIds(), getUser.getRoleIds(), userGroupRoleList,
						getUser.getUserGroupIds(), serviceContext);
			}

			// update password
			if (data.getString("password") != "" && !data.getString("password").equals("********"))
				UserLocalServiceUtil.updatePassword(liferayUserId, data.getString("password"),
						data.getString("password"), true);

			// update mypage user
			///////////////////
			_mypageUser = updateMypageUser(mypageUserId, data);

			// register permission
			///////////////////
			resourceLocalService.updateResources(_mypageUser.getCompanyId(), _mypageUser.getGroupId(),
					MypageUser.class.getName(), _mypageUser.getMypageUserId(), serviceContext.getModelPermissions());
		} else {
			// add user liferay
			///////////////////
			// get birthdate
			Integer day = null;
			Integer month = null;
			Integer year = null;
			if (Validator.isNotNull(data.getString("birthday"))) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

				// convert String to LocalDate
				LocalDate Dob = LocalDate.parse(data.getString("birthday"), formatter);

				day = Dob.getDayOfMonth();
				month = Dob.getMonthValue() - 1;
				year = Dob.getYear();
			}

			User addUser = UserLocalServiceUtil.addUser(userId, companyId, true, null, null, false,
					data.getString("screenName"), data.getString("emailAddress"), LocaleUtil.getDefault(),
					data.getString("firstName"), data.getString("middleName"), data.getString("lastName"), 0, 0, false,
					month, day, year, null, null, null, null, null, false, null);
//			System.out.println(addUser);
			data.put("liferayUserId", addUser.getUserId());

			// add mypage user
			///////////////////
			_mypageUser = updateMypageUser(0, data);

			// register permission
			///////////////////
			resourceLocalService.addResources(_mypageUser.getCompanyId(), _mypageUser.getGroupId(),
					_mypageUser.getUserId(), MypageUser.class.getName(), _mypageUser.getMypageUserId(), false, true,
					true);
		}

		return _mypageUser;
	}

	/*
	 * update mypage user
	 */
	private MypageUser updateMypageUser(long mypageUserId, JSONObject data) throws PortalException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		MypageUser setMypageUser = null;
		// get pageKey
		String pageKey = data.getString("pageKey");

		// PERMISSIONS
		User currentUser = UserLocalServiceUtil.getUser(data.getLong("userId"));
		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(currentUser);
		boolean allowAdd = MypageUserPermission.contains(permissionChecker, data.getLong("groupId"), "ADD_ENTRY");

		// add / update mypageUSer
		/////////////////////////////
		if (mypageUserId > 0) {
			setMypageUser = MypageUserLocalServiceUtil.getMypageUser(mypageUserId);
		} else {
			long getMypageUserId = CounterLocalServiceUtil.increment(MypageUser.class.getName());
			setMypageUser = MypageUserLocalServiceUtil.createMypageUser(getMypageUserId);
		}

		// get liferay user
		long liferayUserId = data.getLong("liferayUserId");
		User user = userLocalService.getUserById(liferayUserId);

		// add user
		if (allowAdd && pageKey.equals("add_user")) {
			// add credit wallet
			CreditWallet creditWallet = _creditWalletLocalService.addCreditWallet(0, null, null, 0, 0);
//			CreditWallet creditWallet = _creditWalletLocalService.addCreditWallet(null);

			setMypageUser.setLiferayUserId(liferayUserId);
			setMypageUser.setBirthPlace(data.getString("birthPlace"));
			setMypageUser.setStatus("inactive");
			setMypageUser.setCreditWalletId(creditWallet.getCreditWalletId());
		}

		// account
		if (allowAdd && pageKey.equals("account")) {
			// Add remove user roles
			String addRoleIds = data.getString("addRoleIds");
			String[] StringRolesIds = addRoleIds.split(",");

			String deleteRoleIds = data.getString("deleteRoleIds");
			String[] StringDelRolesIds = deleteRoleIds.split(",");

			if (StringRolesIds.length > 0) {
				for (int i = 0; i < StringRolesIds.length; i++) {
					if (StringRolesIds[i].length() > 0) {
						UserLocalServiceUtil.addRoleUser(Long.parseLong(StringRolesIds[i]), liferayUserId);
					}
				}
			}
			if (StringDelRolesIds.length > 0) {
				for (int i = 0; i < StringDelRolesIds.length; i++) {
					if (StringDelRolesIds[i].length() > 0) {
						UserLocalServiceUtil.deleteRoleUser(Long.parseLong(StringDelRolesIds[i]), liferayUserId);
					}
				}
			}

			// update user contact liferay
			long contactId = user.getContactId();
			Contact contact = ContactLocalServiceUtil.getContact(contactId);
			if (Validator.isNotNull(data.getString("birthday"))) {
				Date birthday = sdf.parse(data.getString("birthday"));
				contact.setBirthday(birthday);
			}

			Contact updateContact = ContactLocalServiceUtil.updateContact(contact);

			// for update mypage user
			setMypageUser.setUserParent(data.getLong("userParent"));
			setMypageUser.setUserBranch(data.getLong("userBranch"));
			setMypageUser.setStatus(data.getString("status"));
			setMypageUser.setCreditStatus(data.getString("creditStatus"));
			setMypageUser.setCashPayment(data.getInt("cashPayment"));
			setMypageUser.setPaymentMethod(data.getString("paymentMethod"));

			// check credit wallet id
			if (Validator.isNotNull(data.getLong("creditWalletId"))) {
				MypageUser checkCreditWallet = mypageUserPersistence
						.fetchBycreditWalletId(data.getLong("creditWalletId"));
				if (checkCreditWallet != null) {
					throw new MypageUserException.CreditWalletIdMustNotBeDuplicate(checkCreditWallet.getMypageUserId(),
							data.getLong("creditWalletId"));
				}
				setMypageUser.setCreditWalletId(data.getLong("creditWalletId"));
			}
		}

		// basic information
		if (pageKey.equals("basic_information")) {
			setMypageUser.setBirthPlace(data.getString("birthPlace"));
			setMypageUser.setGender(data.getString("gender"));
			setMypageUser.setIdNumber(data.getString("idNumber"));
			setMypageUser.setPhone(data.getString("phone"));
			setMypageUser.setMobilePhone(data.getString("mobilePhone"));
			setMypageUser.setAddress(data.getString("address"));
			setMypageUser.setZip(data.getString("zip"));
			setMypageUser.setCountry(data.getLong("country"));
			setMypageUser.setProvince(data.getLong("province"));
			setMypageUser.setCity(data.getLong("city"));
			setMypageUser.setLatitude(data.getString("latitude"));
			setMypageUser.setLongitude(data.getString("longitude"));
			setMypageUser.setPositionZoom(data.getInt("positionZoom"));
		}

		// agent
		if (allowAdd && pageKey.equals("agent")) {
			setMypageUser.setCode(data.getString("code"));
			setMypageUser.setAgentFlag(data.getString("agentFlag"));
			setMypageUser.setBranch(data.getLong("branch"));
			setMypageUser.setPromoCode(data.getString("promoCode"));
			setMypageUser.setAgsPromoCode(data.getString("agsPromoCode"));
			setMypageUser.setDeptoreCode(data.getString("deptoreCode"));
			setMypageUser.setLeader(data.getLong("leader"));
			setMypageUser.setStatusAgent(data.getString("statusAgent"));
			setMypageUser.setLicenseNumber(data.getString("licenseNumber"));
			if (Validator.isNotNull(data.getString("joinDate"))) {
				Date joinDate = sdf.parse(data.getString("joinDate"));
				setMypageUser.setJoinDate(joinDate);
			}
			if (Validator.isNotNull(data.getString("endDate"))) {
				Date endDate = sdf.parse(data.getString("endDate"));
				setMypageUser.setEndDate(endDate);
			}
			setMypageUser.setPrettyUrl(data.getString("prettyUrl"));
			setMypageUser.setPrettyUrlChange(data.getInt("prettyUrlChange"));
			setMypageUser.setTaxRate(data.getDouble("taxRate"));
			setMypageUser.setVisitedCount(data.getInt("visitedCount"));
			setMypageUser.setIsPartnership(data.getInt("isPartnership"));
			setMypageUser.setPartnershipName(data.getString("partnershipName"));
		}

		// about me
		if (pageKey.equals("about_me")) {
			setMypageUser.setMyTitle(data.getString("myTitle"));
			setMypageUser.setMyVideo(data.getString("myVideo"));
			setMypageUser.setAboutMe(data.getString("aboutMe"));
		}

		// social media
		if (pageKey.equals("social_media")) {
			setMypageUser.setFacebook(data.getString("facebook"));
			setMypageUser.setTiktok(data.getString("tiktok"));
			setMypageUser.setInstagram(data.getString("instagram"));
			setMypageUser.setTwitter(data.getString("twitter"));
			setMypageUser.setLinkedIn(data.getString("linkedIn"));
			setMypageUser.setBlog(data.getString("blog"));
			setMypageUser.setWhatsapp(data.getString("whatsapp"));
			setMypageUser.setSkype(data.getString("skype"));
		}

		// images
		if (pageKey.equals("image")) {
			if (data.getLong("profileImageFileEntryId") > 0)
				setMypageUser.setProfileImageFileEntryId(data.getLong("profileImageFileEntryId"));
			if (data.getLong("bannerImageFileEntryId") > 0)
				setMypageUser.setBannerImageFileEntryId(data.getLong("bannerImageFileEntryId"));
		}

		// user status
		if (allowAdd) {
			setMypageUser.setActive(data.getInt("active"));
		}

		setMypageUser.setGroupId(data.getLong("groupId"));
		setMypageUser.setCompanyId(data.getLong("companyId"));
		setMypageUser.setUserId(data.getLong("userId"));
		setMypageUser.setUserName(data.getString("userName"));

		return MypageUserLocalServiceUtil.updateMypageUser(setMypageUser);
	}

	/*
	 * Update MypageUser
	 * 
	 * @param user the mypage user
	 * 
	 */
	public MypageUser updateMypageUser(MypageUser user) {
		return mypageUserPersistence.update(user);
	}

	/*
	 * Get MypageUser by liferayUserId
	 * 
	 * @param liferayUserId the primary key of the liferay user
	 * 
	 */
	public MypageUser getByLiferayUserId(long liferayUserId) {
		return mypageUserPersistence.fetchBygetByLiferayUserId(liferayUserId);
	}

	public List<MypageUser> getMypageUsers() {
		return mypageUserPersistence.findAll();
	}

	public List<User> getJoinMypageUser() {
		Session session = null;

		try {
//	        session = openSession();

			DynamicQuery mypageQuery = MypageUserLocalServiceUtil.dynamicQuery()
					.setProjection(ProjectionFactoryUtil.property("liferayUserId"));
			// .add(PropertyFactoryUtil.forName("liferayUserId").in(liferayQuery));

			DynamicQuery liferayQuery = UserLocalServiceUtil.dynamicQuery()
					// .setProjection(ProjectionFactoryUtil.property("userId"));
					.add(PropertyFactoryUtil.forName("userId").in(mypageQuery));

			List<User> result = UserLocalServiceUtil.dynamicQuery(liferayQuery);

			return result;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
//	        closeSession(session);
		}
		return null;
	}

	public MypageUser getByPrettyUrl(String prettyUrl) {
		MypageUser myPageUser = mypageUserPersistence.fetchByPrettyUrl(prettyUrl);

		return myPageUser;
	}

	public MypageUser updateAgentFromDashboard(long liferayUserId, JSONObject data)
			throws JSONException, PortalException {
		MypageUser myPageUser = null;

		try {
			if (liferayUserId > 0) {

				myPageUser = mypageUserPersistence.fetchBygetByLiferayUserId(data.getLong("LiferayUserId"));

				if (!Validator.isNull(myPageUser)) {
					myPageUser.setAddress(data.getString("Address"));
					myPageUser.setMobilePhone(data.getString("MobilePhone"));
					myPageUser.setWhatsapp(data.getString("Whatsapp"));
					myPageUser.setSkype(data.getString("Skype"));
					myPageUser.setPaymentMethod(data.getString("PaymentMethod"));

					myPageUser.setPrettyUrl(data.getString("PrettyUrl"));
					myPageUser.setPrettyUrlChange(myPageUser.getPrettyUrlChange() + 1);

					myPageUser.setMyTitle(data.getString("MyTitle"));
					myPageUser.setAboutMe(data.getString("AboutMe"));
					myPageUser.setMyVideo(data.getString("MyVideo"));

					mypageUserPersistence.update(myPageUser);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return myPageUser;
	}

	public MypageUser updateProfileImage(long liferayUserId, long fileEntryId, String profileImageURL)
			throws PortalException {
		MypageUser mypageUser = null;

		if (liferayUserId > 0) {
			mypageUser = mypageUserPersistence.fetchBygetByLiferayUserId(liferayUserId);
			if (!Validator.isNull(mypageUser)) {
				mypageUser.setProfileImageFileEntryId(fileEntryId);
				mypageUser.setProfileImageURL(profileImageURL);

				mypageUserPersistence.update(mypageUser);
			}
		}

		return mypageUser;
	}
	
	public MypageUser getByAgentCode(String code) {
		MypageUser myPageUser = mypageUserPersistence.fetchByAgentCode(code);

		return myPageUser;
	}
	
	public MypageUser getUserByEmail(String email) {
		MypageUser myPageUser = mypageUserPersistence.fetchByEmailAddress(email);

		return myPageUser;
    }
	
	public MypageUser updateCounterById(long userId, int counter) {
		
		TimeZone wibTimeZone = TimeZone.getTimeZone("Asia/Jakarta");
		Calendar calendar = Calendar.getInstance(wibTimeZone);
		Date currentDate = calendar.getTime();
		Instant instant = currentDate.toInstant();
		LocalDateTime localDateTime = instant.atZone(wibTimeZone.toZoneId()).toLocalDateTime();
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
		Instant instantDate = zonedDateTime.toInstant();
		Date now = Date.from(instantDate);
		
		MypageUser mypageUser = mypageUserPersistence.fetchByPrimaryKey(userId);
		
		mypageUser.setLoginCounter(counter);
		mypageUser.setLastSubmitLoginDate(counter == 0 ? null : now);
		
		mypageUserPersistence.update(mypageUser);
		
		return mypageUser;
	}
	
	public MypageUser updateStatusById(long userId, String status) {
		MypageUser mypageUser = mypageUserPersistence.fetchByPrimaryKey(userId);
		
		mypageUser.setStatus(status);
		
		mypageUserPersistence.update(mypageUser);
		
		return mypageUser;
	}
	
	public MypageUser updateTempCodeById(long userId, String token, int expiresIn) {
		
		TimeZone wibTimeZone = TimeZone.getTimeZone("Asia/Jakarta");
		Calendar calendar = Calendar.getInstance(wibTimeZone);
		Date currentDate = calendar.getTime();
		Instant instant = currentDate.toInstant();
		LocalDateTime localDateTime = instant.atZone(wibTimeZone.toZoneId()).toLocalDateTime();
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault()).plusMinutes(expiresIn);
		Instant instantDate = zonedDateTime.toInstant();
		Date now = Date.from(instantDate);
		
		MypageUser mypageUser = mypageUserPersistence.fetchByPrimaryKey(userId);
		
		mypageUser.setTempCode(token);
		mypageUser.setTempCodeExpiryDate(expiresIn == 0 ? null : now);
		
		mypageUserPersistence.update(mypageUser);
		
		return mypageUser;
	}
	
	public MypageUser getByToken(String token) {
		MypageUser mypageUser = null;
		
		try {
			DynamicQuery dq = MypageUserLocalServiceUtil.dynamicQuery();
			dq.add(RestrictionsFactoryUtil.eq("TempCode", token));
			List<MypageUser> users = mypageUserLocalService.dynamicQuery(dq);

			if (users.size() > 0) {
				mypageUser = users.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mypageUser;
	}
	
	public long authenticateForBasic(String email, String password) {
		long userId = 0L;
		
		try {
			DynamicQuery dq = MypageUserLocalServiceUtil.dynamicQuery();
			dq.add(RestrictionsFactoryUtil.eq("email", email));
			dq.add(RestrictionsFactoryUtil.eq("userPassword", password));
			List<MypageUser> users = mypageUserLocalService.dynamicQuery(dq);

			if (users.size() > 0) {
				userId = users.get(0).getMypageUserId();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userId;
	}
	
	public MypageUser getByDeptoreCode(String deptoreCode) {
		MypageUser mypageUser = null;
		
		try {
			DynamicQuery dq = MypageUserLocalServiceUtil.dynamicQuery();
			dq.add(RestrictionsFactoryUtil.eq("deptoreCode", deptoreCode));
			List<MypageUser> users = mypageUserLocalService.dynamicQuery(dq);

			if (users.size() > 0) {
				mypageUser = users.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mypageUser;
	}
	
	public List<MypageUser> getByRoleId(long roleId) {
		List<MypageUser> mypageUser = null;
		
		try {
			DynamicQuery dq = MypageUserLocalServiceUtil.dynamicQuery();
			dq.add(RestrictionsFactoryUtil.eq("mypageUserRoleId", roleId));
			mypageUser = mypageUserLocalService.dynamicQuery(dq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mypageUser;
    }
	
	public MypageUser addMypageUserForAgencyPortal(JSONObject data) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		MypageUser mypageUser = null;
		
		long mypageUserId = Validator.isNotNull(getByDeptoreCode(data.getString("deptoreCode"))) ? getByDeptoreCode(data.getString("deptoreCode")).getMypageUserId() : counterLocalService.increment();
		mypageUser = Validator.isNotNull(getByDeptoreCode(data.getString("deptoreCode"))) ? mypageUserPersistence.fetchByPrimaryKey(mypageUserId) : mypageUserPersistence.create(mypageUserId);
		
		if (Validator.isNull(getByDeptoreCode(data.getString("deptoreCode")))) mypageUser.setMypageUserId(mypageUserId);
		mypageUser.setUserName(data.getString("userName"));
		mypageUser.setCode(data.getString("code"));
		mypageUser.setDeptoreCode(data.getString("deptoreCode"));
		mypageUser.setMypageUserRoleId(data.getLong("mypageUserRoleId"));
		mypageUser.setEmail(data.getString("email"));
		mypageUser.setStatus(data.getString("status"));
		mypageUser.setGender(data.getString("gender"));
		mypageUser.setMobilePhone(data.getString("mobilePhone"));
		mypageUser.setPrettyUrl(data.getString("prettyUrl"));
		mypageUser.setPrettyUrlChange(data.getInt("prettyUrlChange"));
		
		try {
			mypageUser.setDob(dateFormat.parse(data.getString("dob")));
		} catch (ParseException e) {
			 
		}
		
		try {
			mypageUser.setJoinDate(dateFormat.parse(data.getString("joinDate")));
		} catch (ParseException e) {
			 
		}
		
		try {
			mypageUser.setEndDate(dateFormat.parse(data.getString("endDate")));
		} catch (ParseException e) {
			 
		}
		
		if (Validator.isNull(getByDeptoreCode(data.getString("deptoreCode")))) mypageUser.setCreditWalletId(counterLocalService.increment());
		
		mypageUser.setActive(1);
		
		mypageUserPersistence.update(mypageUser);
		
		return mypageUser;
	}
	
	public MypageUser updateClub(String deptoreCode, String club, ServiceContext serviceContext) throws PortalException {
		MypageUser mypageUser = null;

		try {
			mypageUser = mypageUserPersistence.findByDeptoreCode(deptoreCode);
			Date now = new Date();
			mypageUser.setClub(club);
			mypageUser.setModifiedDate(serviceContext.getModifiedDate(now));

			mypageUserPersistence.update(mypageUser);
		} catch (Exception e) {
			System.out.println(e);
		}

		return mypageUser;
	}
	
	@Reference
	private UserService _userService;

	@Reference
	private CreditWalletLocalService _creditWalletLocalService;	
}