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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AgentEmailBucket}.
 * </p>
 *
 * @author Gositus Team
 * @see AgentEmailBucket
 * @generated
 */
public class AgentEmailBucketWrapper
	extends BaseModelWrapper<AgentEmailBucket>
	implements AgentEmailBucket, ModelWrapper<AgentEmailBucket> {

	public AgentEmailBucketWrapper(AgentEmailBucket agentEmailBucket) {
		super(agentEmailBucket);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("agentEmailBucketId", getAgentEmailBucketId());
		attributes.put("activity", getActivity());
		attributes.put("subject", getSubject());
		attributes.put("sender", getSender());
		attributes.put("recipient", getRecipient());
		attributes.put("recipientCC", getRecipientCC());
		attributes.put("recipientBCC", getRecipientBCC());
		attributes.put("template", getTemplate());
		attributes.put("params", getParams());
		attributes.put("bodyText", getBodyText());
		attributes.put("status_", getStatus_());
		attributes.put("counter", getCounter());
		attributes.put("message", getMessage());
		attributes.put("resendCount", getResendCount());
		attributes.put("delay", getDelay());
		attributes.put("attachmentId", getAttachmentId());
		attributes.put("attachmentUrl", getAttachmentUrl());
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
		Long agentEmailBucketId = (Long)attributes.get("agentEmailBucketId");

		if (agentEmailBucketId != null) {
			setAgentEmailBucketId(agentEmailBucketId);
		}

		String activity = (String)attributes.get("activity");

		if (activity != null) {
			setActivity(activity);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String sender = (String)attributes.get("sender");

		if (sender != null) {
			setSender(sender);
		}

		String recipient = (String)attributes.get("recipient");

		if (recipient != null) {
			setRecipient(recipient);
		}

		String recipientCC = (String)attributes.get("recipientCC");

		if (recipientCC != null) {
			setRecipientCC(recipientCC);
		}

		String recipientBCC = (String)attributes.get("recipientBCC");

		if (recipientBCC != null) {
			setRecipientBCC(recipientBCC);
		}

		String template = (String)attributes.get("template");

		if (template != null) {
			setTemplate(template);
		}

		String params = (String)attributes.get("params");

		if (params != null) {
			setParams(params);
		}

		String bodyText = (String)attributes.get("bodyText");

		if (bodyText != null) {
			setBodyText(bodyText);
		}

		String status_ = (String)attributes.get("status_");

		if (status_ != null) {
			setStatus_(status_);
		}

		Integer counter = (Integer)attributes.get("counter");

		if (counter != null) {
			setCounter(counter);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Integer resendCount = (Integer)attributes.get("resendCount");

		if (resendCount != null) {
			setResendCount(resendCount);
		}

		String delay = (String)attributes.get("delay");

		if (delay != null) {
			setDelay(delay);
		}

		Long attachmentId = (Long)attributes.get("attachmentId");

		if (attachmentId != null) {
			setAttachmentId(attachmentId);
		}

		String attachmentUrl = (String)attributes.get("attachmentUrl");

		if (attachmentUrl != null) {
			setAttachmentUrl(attachmentUrl);
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
	 * Returns the active of this agent email bucket.
	 *
	 * @return the active of this agent email bucket
	 */
	@Override
	public int getActive() {
		return model.getActive();
	}

	/**
	 * Returns the activity of this agent email bucket.
	 *
	 * @return the activity of this agent email bucket
	 */
	@Override
	public String getActivity() {
		return model.getActivity();
	}

	/**
	 * Returns the agent email bucket ID of this agent email bucket.
	 *
	 * @return the agent email bucket ID of this agent email bucket
	 */
	@Override
	public long getAgentEmailBucketId() {
		return model.getAgentEmailBucketId();
	}

	/**
	 * Returns the attachment ID of this agent email bucket.
	 *
	 * @return the attachment ID of this agent email bucket
	 */
	@Override
	public long getAttachmentId() {
		return model.getAttachmentId();
	}

	/**
	 * Returns the attachment url of this agent email bucket.
	 *
	 * @return the attachment url of this agent email bucket
	 */
	@Override
	public String getAttachmentUrl() {
		return model.getAttachmentUrl();
	}

	/**
	 * Returns the body text of this agent email bucket.
	 *
	 * @return the body text of this agent email bucket
	 */
	@Override
	public String getBodyText() {
		return model.getBodyText();
	}

	/**
	 * Returns the company ID of this agent email bucket.
	 *
	 * @return the company ID of this agent email bucket
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the counter of this agent email bucket.
	 *
	 * @return the counter of this agent email bucket
	 */
	@Override
	public int getCounter() {
		return model.getCounter();
	}

	/**
	 * Returns the create date of this agent email bucket.
	 *
	 * @return the create date of this agent email bucket
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the delay of this agent email bucket.
	 *
	 * @return the delay of this agent email bucket
	 */
	@Override
	public String getDelay() {
		return model.getDelay();
	}

	/**
	 * Returns the group ID of this agent email bucket.
	 *
	 * @return the group ID of this agent email bucket
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the message of this agent email bucket.
	 *
	 * @return the message of this agent email bucket
	 */
	@Override
	public String getMessage() {
		return model.getMessage();
	}

	/**
	 * Returns the modified date of this agent email bucket.
	 *
	 * @return the modified date of this agent email bucket
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the params of this agent email bucket.
	 *
	 * @return the params of this agent email bucket
	 */
	@Override
	public String getParams() {
		return model.getParams();
	}

	/**
	 * Returns the primary key of this agent email bucket.
	 *
	 * @return the primary key of this agent email bucket
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the recipient of this agent email bucket.
	 *
	 * @return the recipient of this agent email bucket
	 */
	@Override
	public String getRecipient() {
		return model.getRecipient();
	}

	/**
	 * Returns the recipient bcc of this agent email bucket.
	 *
	 * @return the recipient bcc of this agent email bucket
	 */
	@Override
	public String getRecipientBCC() {
		return model.getRecipientBCC();
	}

	/**
	 * Returns the recipient cc of this agent email bucket.
	 *
	 * @return the recipient cc of this agent email bucket
	 */
	@Override
	public String getRecipientCC() {
		return model.getRecipientCC();
	}

	/**
	 * Returns the resend count of this agent email bucket.
	 *
	 * @return the resend count of this agent email bucket
	 */
	@Override
	public int getResendCount() {
		return model.getResendCount();
	}

	/**
	 * Returns the sender of this agent email bucket.
	 *
	 * @return the sender of this agent email bucket
	 */
	@Override
	public String getSender() {
		return model.getSender();
	}

	/**
	 * Returns the status of this agent email bucket.
	 *
	 * @return the status of this agent email bucket
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status_ of this agent email bucket.
	 *
	 * @return the status_ of this agent email bucket
	 */
	@Override
	public String getStatus_() {
		return model.getStatus_();
	}

	/**
	 * Returns the subject of this agent email bucket.
	 *
	 * @return the subject of this agent email bucket
	 */
	@Override
	public String getSubject() {
		return model.getSubject();
	}

	/**
	 * Returns the template of this agent email bucket.
	 *
	 * @return the template of this agent email bucket
	 */
	@Override
	public String getTemplate() {
		return model.getTemplate();
	}

	/**
	 * Returns the trash entry created when this agent email bucket was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this agent email bucket.
	 *
	 * @return the trash entry created when this agent email bucket was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this agent email bucket.
	 *
	 * @return the class primary key of the trash entry for this agent email bucket
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this agent email bucket.
	 *
	 * @return the trash handler for this agent email bucket
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this agent email bucket.
	 *
	 * @return the user ID of this agent email bucket
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this agent email bucket.
	 *
	 * @return the user name of this agent email bucket
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this agent email bucket.
	 *
	 * @return the user uuid of this agent email bucket
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this agent email bucket is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this agent email bucket is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this agent email bucket is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this agent email bucket is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer() {
		return model.isInTrashContainer();
	}

	@Override
	public boolean isInTrashExplicitly() {
		return model.isInTrashExplicitly();
	}

	@Override
	public boolean isInTrashImplicitly() {
		return model.isInTrashImplicitly();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this agent email bucket.
	 *
	 * @param active the active of this agent email bucket
	 */
	@Override
	public void setActive(int active) {
		model.setActive(active);
	}

	/**
	 * Sets the activity of this agent email bucket.
	 *
	 * @param activity the activity of this agent email bucket
	 */
	@Override
	public void setActivity(String activity) {
		model.setActivity(activity);
	}

	/**
	 * Sets the agent email bucket ID of this agent email bucket.
	 *
	 * @param agentEmailBucketId the agent email bucket ID of this agent email bucket
	 */
	@Override
	public void setAgentEmailBucketId(long agentEmailBucketId) {
		model.setAgentEmailBucketId(agentEmailBucketId);
	}

	/**
	 * Sets the attachment ID of this agent email bucket.
	 *
	 * @param attachmentId the attachment ID of this agent email bucket
	 */
	@Override
	public void setAttachmentId(long attachmentId) {
		model.setAttachmentId(attachmentId);
	}

	/**
	 * Sets the attachment url of this agent email bucket.
	 *
	 * @param attachmentUrl the attachment url of this agent email bucket
	 */
	@Override
	public void setAttachmentUrl(String attachmentUrl) {
		model.setAttachmentUrl(attachmentUrl);
	}

	/**
	 * Sets the body text of this agent email bucket.
	 *
	 * @param bodyText the body text of this agent email bucket
	 */
	@Override
	public void setBodyText(String bodyText) {
		model.setBodyText(bodyText);
	}

	/**
	 * Sets the company ID of this agent email bucket.
	 *
	 * @param companyId the company ID of this agent email bucket
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the counter of this agent email bucket.
	 *
	 * @param counter the counter of this agent email bucket
	 */
	@Override
	public void setCounter(int counter) {
		model.setCounter(counter);
	}

	/**
	 * Sets the create date of this agent email bucket.
	 *
	 * @param createDate the create date of this agent email bucket
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the delay of this agent email bucket.
	 *
	 * @param delay the delay of this agent email bucket
	 */
	@Override
	public void setDelay(String delay) {
		model.setDelay(delay);
	}

	/**
	 * Sets the group ID of this agent email bucket.
	 *
	 * @param groupId the group ID of this agent email bucket
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the message of this agent email bucket.
	 *
	 * @param message the message of this agent email bucket
	 */
	@Override
	public void setMessage(String message) {
		model.setMessage(message);
	}

	/**
	 * Sets the modified date of this agent email bucket.
	 *
	 * @param modifiedDate the modified date of this agent email bucket
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the params of this agent email bucket.
	 *
	 * @param params the params of this agent email bucket
	 */
	@Override
	public void setParams(String params) {
		model.setParams(params);
	}

	/**
	 * Sets the primary key of this agent email bucket.
	 *
	 * @param primaryKey the primary key of this agent email bucket
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the recipient of this agent email bucket.
	 *
	 * @param recipient the recipient of this agent email bucket
	 */
	@Override
	public void setRecipient(String recipient) {
		model.setRecipient(recipient);
	}

	/**
	 * Sets the recipient bcc of this agent email bucket.
	 *
	 * @param recipientBCC the recipient bcc of this agent email bucket
	 */
	@Override
	public void setRecipientBCC(String recipientBCC) {
		model.setRecipientBCC(recipientBCC);
	}

	/**
	 * Sets the recipient cc of this agent email bucket.
	 *
	 * @param recipientCC the recipient cc of this agent email bucket
	 */
	@Override
	public void setRecipientCC(String recipientCC) {
		model.setRecipientCC(recipientCC);
	}

	/**
	 * Sets the resend count of this agent email bucket.
	 *
	 * @param resendCount the resend count of this agent email bucket
	 */
	@Override
	public void setResendCount(int resendCount) {
		model.setResendCount(resendCount);
	}

	/**
	 * Sets the sender of this agent email bucket.
	 *
	 * @param sender the sender of this agent email bucket
	 */
	@Override
	public void setSender(String sender) {
		model.setSender(sender);
	}

	/**
	 * Sets the status_ of this agent email bucket.
	 *
	 * @param status_ the status_ of this agent email bucket
	 */
	@Override
	public void setStatus_(String status_) {
		model.setStatus_(status_);
	}

	/**
	 * Sets the subject of this agent email bucket.
	 *
	 * @param subject the subject of this agent email bucket
	 */
	@Override
	public void setSubject(String subject) {
		model.setSubject(subject);
	}

	/**
	 * Sets the template of this agent email bucket.
	 *
	 * @param template the template of this agent email bucket
	 */
	@Override
	public void setTemplate(String template) {
		model.setTemplate(template);
	}

	/**
	 * Sets the user ID of this agent email bucket.
	 *
	 * @param userId the user ID of this agent email bucket
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this agent email bucket.
	 *
	 * @param userName the user name of this agent email bucket
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this agent email bucket.
	 *
	 * @param userUuid the user uuid of this agent email bucket
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected AgentEmailBucketWrapper wrap(AgentEmailBucket agentEmailBucket) {
		return new AgentEmailBucketWrapper(agentEmailBucket);
	}

}