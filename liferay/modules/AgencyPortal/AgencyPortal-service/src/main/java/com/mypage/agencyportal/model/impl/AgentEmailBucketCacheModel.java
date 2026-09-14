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

package com.mypage.agencyportal.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.mypage.agencyportal.model.AgentEmailBucket;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AgentEmailBucket in entity cache.
 *
 * @author Gositus Team
 * @generated
 */
public class AgentEmailBucketCacheModel
	implements CacheModel<AgentEmailBucket>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AgentEmailBucketCacheModel)) {
			return false;
		}

		AgentEmailBucketCacheModel agentEmailBucketCacheModel =
			(AgentEmailBucketCacheModel)object;

		if (agentEmailBucketId ==
				agentEmailBucketCacheModel.agentEmailBucketId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, agentEmailBucketId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{agentEmailBucketId=");
		sb.append(agentEmailBucketId);
		sb.append(", activity=");
		sb.append(activity);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", sender=");
		sb.append(sender);
		sb.append(", recipient=");
		sb.append(recipient);
		sb.append(", recipientCC=");
		sb.append(recipientCC);
		sb.append(", recipientBCC=");
		sb.append(recipientBCC);
		sb.append(", template=");
		sb.append(template);
		sb.append(", params=");
		sb.append(params);
		sb.append(", bodyText=");
		sb.append(bodyText);
		sb.append(", status_=");
		sb.append(status_);
		sb.append(", counter=");
		sb.append(counter);
		sb.append(", message=");
		sb.append(message);
		sb.append(", resendCount=");
		sb.append(resendCount);
		sb.append(", delay=");
		sb.append(delay);
		sb.append(", attachmentId=");
		sb.append(attachmentId);
		sb.append(", attachmentUrl=");
		sb.append(attachmentUrl);
		sb.append(", active=");
		sb.append(active);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AgentEmailBucket toEntityModel() {
		AgentEmailBucketImpl agentEmailBucketImpl = new AgentEmailBucketImpl();

		agentEmailBucketImpl.setAgentEmailBucketId(agentEmailBucketId);

		if (activity == null) {
			agentEmailBucketImpl.setActivity("");
		}
		else {
			agentEmailBucketImpl.setActivity(activity);
		}

		if (subject == null) {
			agentEmailBucketImpl.setSubject("");
		}
		else {
			agentEmailBucketImpl.setSubject(subject);
		}

		if (sender == null) {
			agentEmailBucketImpl.setSender("");
		}
		else {
			agentEmailBucketImpl.setSender(sender);
		}

		if (recipient == null) {
			agentEmailBucketImpl.setRecipient("");
		}
		else {
			agentEmailBucketImpl.setRecipient(recipient);
		}

		if (recipientCC == null) {
			agentEmailBucketImpl.setRecipientCC("");
		}
		else {
			agentEmailBucketImpl.setRecipientCC(recipientCC);
		}

		if (recipientBCC == null) {
			agentEmailBucketImpl.setRecipientBCC("");
		}
		else {
			agentEmailBucketImpl.setRecipientBCC(recipientBCC);
		}

		if (template == null) {
			agentEmailBucketImpl.setTemplate("");
		}
		else {
			agentEmailBucketImpl.setTemplate(template);
		}

		if (params == null) {
			agentEmailBucketImpl.setParams("");
		}
		else {
			agentEmailBucketImpl.setParams(params);
		}

		if (bodyText == null) {
			agentEmailBucketImpl.setBodyText("");
		}
		else {
			agentEmailBucketImpl.setBodyText(bodyText);
		}

		if (status_ == null) {
			agentEmailBucketImpl.setStatus_("");
		}
		else {
			agentEmailBucketImpl.setStatus_(status_);
		}

		agentEmailBucketImpl.setCounter(counter);

		if (message == null) {
			agentEmailBucketImpl.setMessage("");
		}
		else {
			agentEmailBucketImpl.setMessage(message);
		}

		agentEmailBucketImpl.setResendCount(resendCount);

		if (delay == null) {
			agentEmailBucketImpl.setDelay("");
		}
		else {
			agentEmailBucketImpl.setDelay(delay);
		}

		agentEmailBucketImpl.setAttachmentId(attachmentId);

		if (attachmentUrl == null) {
			agentEmailBucketImpl.setAttachmentUrl("");
		}
		else {
			agentEmailBucketImpl.setAttachmentUrl(attachmentUrl);
		}

		agentEmailBucketImpl.setActive(active);
		agentEmailBucketImpl.setGroupId(groupId);
		agentEmailBucketImpl.setCompanyId(companyId);
		agentEmailBucketImpl.setUserId(userId);

		if (userName == null) {
			agentEmailBucketImpl.setUserName("");
		}
		else {
			agentEmailBucketImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			agentEmailBucketImpl.setCreateDate(null);
		}
		else {
			agentEmailBucketImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			agentEmailBucketImpl.setModifiedDate(null);
		}
		else {
			agentEmailBucketImpl.setModifiedDate(new Date(modifiedDate));
		}

		agentEmailBucketImpl.resetOriginalValues();

		return agentEmailBucketImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		agentEmailBucketId = objectInput.readLong();
		activity = objectInput.readUTF();
		subject = objectInput.readUTF();
		sender = objectInput.readUTF();
		recipient = objectInput.readUTF();
		recipientCC = objectInput.readUTF();
		recipientBCC = objectInput.readUTF();
		template = objectInput.readUTF();
		params = objectInput.readUTF();
		bodyText = objectInput.readUTF();
		status_ = objectInput.readUTF();

		counter = objectInput.readInt();
		message = objectInput.readUTF();

		resendCount = objectInput.readInt();
		delay = objectInput.readUTF();

		attachmentId = objectInput.readLong();
		attachmentUrl = objectInput.readUTF();

		active = objectInput.readInt();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(agentEmailBucketId);

		if (activity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(activity);
		}

		if (subject == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (sender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sender);
		}

		if (recipient == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(recipient);
		}

		if (recipientCC == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(recipientCC);
		}

		if (recipientBCC == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(recipientBCC);
		}

		if (template == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(template);
		}

		if (params == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(params);
		}

		if (bodyText == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bodyText);
		}

		if (status_ == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status_);
		}

		objectOutput.writeInt(counter);

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}

		objectOutput.writeInt(resendCount);

		if (delay == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(delay);
		}

		objectOutput.writeLong(attachmentId);

		if (attachmentUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(attachmentUrl);
		}

		objectOutput.writeInt(active);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long agentEmailBucketId;
	public String activity;
	public String subject;
	public String sender;
	public String recipient;
	public String recipientCC;
	public String recipientBCC;
	public String template;
	public String params;
	public String bodyText;
	public String status_;
	public int counter;
	public String message;
	public int resendCount;
	public String delay;
	public long attachmentId;
	public String attachmentUrl;
	public int active;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}