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

package com.mypage.user.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.user.service.http.MypageUserTimelineServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MypageUserTimelineSoap implements Serializable {

	public static MypageUserTimelineSoap toSoapModel(MypageUserTimeline model) {
		MypageUserTimelineSoap soapModel = new MypageUserTimelineSoap();

		soapModel.setMypageUserTimelineId(model.getMypageUserTimelineId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMypageUserId(model.getMypageUserId());
		soapModel.setImgUploadTimelineEntryId(
			model.getImgUploadTimelineEntryId());
		soapModel.setImgUploadTimelineUrl(model.getImgUploadTimelineUrl());
		soapModel.setVideoUploadTimelineUrl(model.getVideoUploadTimelineUrl());
		soapModel.setText(model.getText());

		return soapModel;
	}

	public static MypageUserTimelineSoap[] toSoapModels(
		MypageUserTimeline[] models) {

		MypageUserTimelineSoap[] soapModels =
			new MypageUserTimelineSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MypageUserTimelineSoap[][] toSoapModels(
		MypageUserTimeline[][] models) {

		MypageUserTimelineSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new MypageUserTimelineSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MypageUserTimelineSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MypageUserTimelineSoap[] toSoapModels(
		List<MypageUserTimeline> models) {

		List<MypageUserTimelineSoap> soapModels =
			new ArrayList<MypageUserTimelineSoap>(models.size());

		for (MypageUserTimeline model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new MypageUserTimelineSoap[soapModels.size()]);
	}

	public MypageUserTimelineSoap() {
	}

	public long getPrimaryKey() {
		return _mypageUserTimelineId;
	}

	public void setPrimaryKey(long pk) {
		setMypageUserTimelineId(pk);
	}

	public long getMypageUserTimelineId() {
		return _mypageUserTimelineId;
	}

	public void setMypageUserTimelineId(long mypageUserTimelineId) {
		_mypageUserTimelineId = mypageUserTimelineId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getMypageUserId() {
		return _mypageUserId;
	}

	public void setMypageUserId(long mypageUserId) {
		_mypageUserId = mypageUserId;
	}

	public long getImgUploadTimelineEntryId() {
		return _imgUploadTimelineEntryId;
	}

	public void setImgUploadTimelineEntryId(long imgUploadTimelineEntryId) {
		_imgUploadTimelineEntryId = imgUploadTimelineEntryId;
	}

	public String getImgUploadTimelineUrl() {
		return _imgUploadTimelineUrl;
	}

	public void setImgUploadTimelineUrl(String imgUploadTimelineUrl) {
		_imgUploadTimelineUrl = imgUploadTimelineUrl;
	}

	public String getVideoUploadTimelineUrl() {
		return _videoUploadTimelineUrl;
	}

	public void setVideoUploadTimelineUrl(String videoUploadTimelineUrl) {
		_videoUploadTimelineUrl = videoUploadTimelineUrl;
	}

	public String getText() {
		return _text;
	}

	public void setText(String text) {
		_text = text;
	}

	private long _mypageUserTimelineId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _mypageUserId;
	private long _imgUploadTimelineEntryId;
	private String _imgUploadTimelineUrl;
	private String _videoUploadTimelineUrl;
	private String _text;

}