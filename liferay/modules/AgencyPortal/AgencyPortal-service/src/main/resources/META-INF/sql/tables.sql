create table AP_AgentCalendar (
	agentCalendarId LONG not null primary key,
	title VARCHAR(75) null,
	location VARCHAR(75) null,
	address VARCHAR(75) null,
	startDate DATE null,
	startTime VARCHAR(75) null,
	endDate DATE null,
	endTime VARCHAR(75) null,
	mypageUserRoleId LONG,
	role_ VARCHAR(75) null,
	mypageUserGroupId LONG,
	group_ VARCHAR(75) null,
	description VARCHAR(75) null,
	link VARCHAR(75) null,
	category VARCHAR(75) null,
	fileUploadEntryId LONG,
	fileUploadUrl VARCHAR(75) null,
	isAllDay INTEGER,
	active_ INTEGER,
	mypageUserId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table AP_AgentCategorySalesTools (
	agentCategorySalesToolsId LONG not null primary key,
	category VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table AP_AgentEmailBucket (
	agentEmailBucketId LONG not null primary key,
	activity VARCHAR(75) null,
	subject VARCHAR(75) null,
	sender VARCHAR(75) null,
	recipient VARCHAR(75) null,
	recipientCC VARCHAR(75) null,
	recipientBCC VARCHAR(75) null,
	template VARCHAR(75) null,
	params VARCHAR(75) null,
	bodyText VARCHAR(75) null,
	status_ VARCHAR(75) null,
	counter INTEGER,
	message VARCHAR(75) null,
	resendCount INTEGER,
	delay VARCHAR(75) null,
	attachmentId LONG,
	attachmentUrl VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table AP_AgentFAQ (
	agentFaqId LONG not null primary key,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	categoryId LONG,
	category VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table AP_AgentFAQCategory (
	agentFaqCategoryId LONG not null primary key,
	category VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table AP_AgentMarkCalendar (
	agentMarkCalendarId LONG not null primary key,
	agentCalendarId LONG,
	mypageUserId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table AP_AgentNotification (
	agentNotificationId LONG not null primary key,
	title VARCHAR(75) null,
	location VARCHAR(75) null,
	address VARCHAR(75) null,
	startDate DATE null,
	startTime VARCHAR(75) null,
	endDate DATE null,
	endTime VARCHAR(75) null,
	mypageUserRoleId LONG,
	role_ VARCHAR(75) null,
	mypageUserGroupId LONG,
	group_ VARCHAR(75) null,
	referenceId LONG,
	description VARCHAR(75) null,
	link VARCHAR(75) null,
	category VARCHAR(75) null,
	fileUploadEntryId LONG,
	fileUploadUrl VARCHAR(75) null,
	isAllDay INTEGER,
	isRead INTEGER,
	active_ INTEGER,
	mypageUserId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table AP_AgentSalesTools (
	agentSalesToolsId LONG not null primary key,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	categoryId LONG,
	category VARCHAR(75) null,
	fileUploadEntryId LONG,
	fileUploadUrl VARCHAR(75) null,
	mypageUserRoleId LONG,
	role_ VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table AP_AgentToken (
	agentTokenId LONG not null primary key,
	deptCode VARCHAR(75) null,
	token VARCHAR(1000) null,
	isValid INTEGER,
	apiRequestToken VARCHAR(1000) null,
	apiRequestTokenExpired DATE null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table AP_AgentTokenLimiter (
	agentTokenLimiterId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	deptCode VARCHAR(75) null,
	token VARCHAR(1000) null,
	isValid INTEGER,
	tokenType VARCHAR(75) null
);

create table AP_FAQ (
	faqId LONG not null primary key,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	categoryId LONG,
	category VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table AP_FAQCategory (
	faqCategoryId LONG not null primary key,
	category VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);