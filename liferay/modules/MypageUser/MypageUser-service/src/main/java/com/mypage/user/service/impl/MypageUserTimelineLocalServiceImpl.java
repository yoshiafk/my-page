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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.mypage.user.model.MypageUser;
import com.mypage.user.model.MypageUserTimeline;
import com.mypage.user.service.MypageUserLocalServiceUtil;
import com.mypage.user.service.base.MypageUserTimelineLocalServiceBaseImpl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.mypage.user.model.MypageUserTimeline", service = AopService.class)
public class MypageUserTimelineLocalServiceImpl extends MypageUserTimelineLocalServiceBaseImpl {

	/*
	 * add working hour
	 */
	@Override
	public MypageUserTimeline addTimeline(long mypageUserId, String text, long fileEntryId, String filePathUrl, String linkVideo) {
		MypageUserTimeline Timeline = null;

		try {

			MypageUser user = MypageUserLocalServiceUtil.getMypageUser(mypageUserId);

			TimeZone wibTimeZone = TimeZone.getTimeZone("Asia/Jakarta");
			Calendar calendar = Calendar.getInstance(wibTimeZone);
			Date currentDate = calendar.getTime();
			Instant instant = currentDate.toInstant();
			LocalDateTime localDateTime = instant.atZone(wibTimeZone.toZoneId()).toLocalDateTime();
			ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
			Instant instantDate = zonedDateTime.toInstant();
			Date now = Date.from(instantDate);

			long mypageUserTimelineId = counterLocalService.increment();
			Timeline = mypageUserTimelinePersistence.create(mypageUserTimelineId);
			Timeline.setMypageUserId(mypageUserId);
			Timeline.setUserId(user.getUserId() != 0 ? user.getUserId() : 0);
			Timeline.setUserName(user.getUserName() != null ? user.getUserName() : null);
			Timeline.setText(text);
			Timeline.setCreateDate(now);
			Timeline.setModifiedDate(now);
			Timeline.setImgUploadTimelineEntryId(fileEntryId);
			Timeline.setImgUploadTimelineUrl(filePathUrl);
			Timeline.setVideoUploadTimelineUrl(linkVideo);

			mypageUserTimelinePersistence.update(Timeline);

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Timeline;
	}

	/*
	 * delete working hour by mypageuserid
	 */
	public void removeByMypageUserId(long mypageUserId) {
		mypageUserTimelinePersistence.removeBygetByMypageUserId(mypageUserId);
	}

	/*
	 * get working hour by mypageuserid
	 */
	public List<MypageUserTimeline> getByMypageUserId(long mypageUserId) {
		return mypageUserTimelinePersistence.findBygetByMypageUserId(mypageUserId);
	}
}