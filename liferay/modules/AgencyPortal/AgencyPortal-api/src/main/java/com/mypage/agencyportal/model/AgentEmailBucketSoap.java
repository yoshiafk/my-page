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

package com.mypage.agencyportal.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mypage.agencyportal.service.http.AgentEmailBucketServiceSoap}.
 *
 * @author Gositus Team
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AgentEmailBucketSoap implements Serializable {

	public static AgentEmailBucketSoap toSoapModel(AgentEmailBucket model) {
		AgentEmailBucketSoap soapModel = new AgentEmailBucketSoap();

		soapModel.setAgentEmailBucketId(model.getAgentEmailBucketId());
		soapModel.setActivity(model.getActivity());
		soapModel.setSubject(model.getSubject());
		soapModel.setSender(model.getSender());
		soapModel.setRecipient(model.getRecipient());
		soapModel.setRecipientCC(model.getRecipientCC());
		soapModel.setRecipientBCC(model.getRecipientBCC());
		soapModel.setTemplate(model.getTemplate());
		soapModel.setParams(model.getParams());
		soapModel.setBodyText(model.getBodyText());
		soapModel.setStatus_(model.getStatus_());
		soapModel.setCounter(model.getCounter());
		soapModel.setMessage(model.getMessage());
		soapModel.setResendCount(model.getResendCount());
		soapModel.setDelay(model.getDelay());
		soapModel.setAttachmentId(model.getAttachmentId());
		soapModel.setAttachmentUrl(model.getAttachmentUrl());
		soapModel.setActive(model.getActive());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static AgentEmailBucketSoap[] toSoapModels(
		AgentEmailBucket[] models) {

		AgentEmailBucketSoap[] soapModels =
			new AgentEmailBucketSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AgentEmailBucketSoap[][] toSoapModels(
		AgentEmailBucket[][] models) {

		AgentEmailBucketSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AgentEmailBucketSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AgentEmailBucketSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AgentEmailBucketSoap[] toSoapModels(
		List<AgentEmailBucket> models) {

		List<AgentEmailBucketSoap> soapModels =
			new ArrayList<AgentEmailBucketSoap>(models.size());

		for (AgentEmailBucket model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AgentEmailBucketSoap[soapModels.size()]);
	}

	public AgentEmailBucketSoap() {
	}

	public long getPrimaryKey() {
		return _agentEmailBucketId;
	}

	public void setPrimaryKey(long pk) {
		setAgentEmailBucketId(pk);
	}

	public long getAgentEmailBucketId() {
		return _agentEmailBucketId;
	}

	public void setAgentEmailBucketId(long agentEmailBucketId) {
		_agentEmailBucketId = agentEmailBucketId;
	}

	public String getActivity() {
		return _activity;
	}

	public void setActivity(String activity) {
		_activity = activity;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getSender() {
		return _sender;
	}

	public void setSender(String sender) {
		_sender = sender;
	}

	public String getRecipient() {
		return _recipient;
	}

	public void setRecipient(String recipient) {
		_recipient = recipient;
	}

	public String getRecipientCC() {
		return _recipientCC;
	}

	public void setRecipientCC(String recipientCC) {
		_recipientCC = recipientCC;
	}

	public String getRecipientBCC() {
		return _recipientBCC;
	}

	public void setRecipientBCC(String recipientBCC) {
		_recipientBCC = recipientBCC;
	}

	public String getTemplate() {
		return _template;
	}

	public void setTemplate(String template) {
		_template = template;
	}

	public String getParams() {
		return _params;
	}

	public void setParams(String params) {
		_params = params;
	}

	public String getBodyText() {
		return _bodyText;
	}

	public void setBodyText(String bodyText) {
		_bodyText = bodyText;
	}

	public String getStatus_() {
		return _status_;
	}

	public void setStatus_(String status_) {
		_status_ = status_;
	}

	public int getCounter() {
		return _counter;
	}

	public void setCounter(int counter) {
		_counter = counter;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public int getResendCount() {
		return _resendCount;
	}

	public void setResendCount(int resendCount) {
		_resendCount = resendCount;
	}

	public String getDelay() {
		return _delay;
	}

	public void setDelay(String delay) {
		_delay = delay;
	}

	public long getAttachmentId() {
		return _attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		_attachmentId = attachmentId;
	}

	public String getAttachmentUrl() {
		return _attachmentUrl;
	}

	public void setAttachmentUrl(String attachmentUrl) {
		_attachmentUrl = attachmentUrl;
	}

	public int getActive() {
		return _active;
	}

	public void setActive(int active) {
		_active = active;
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

	private long _agentEmailBucketId;
	private String _activity;
	private String _subject;
	private String _sender;
	private String _recipient;
	private String _recipientCC;
	private String _recipientBCC;
	private String _template;
	private String _params;
	private String _bodyText;
	private String _status_;
	private int _counter;
	private String _message;
	private int _resendCount;
	private String _delay;
	private long _attachmentId;
	private String _attachmentUrl;
	private int _active;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}