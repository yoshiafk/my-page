create index IX_305F4A62 on AP_AgentCalendar (location[$COLUMN_LENGTH:75$]);
create index IX_7346644B on AP_AgentCalendar (mypageUserGroupId);
create index IX_C471568E on AP_AgentCalendar (mypageUserId);
create index IX_493DB7A4 on AP_AgentCalendar (mypageUserRoleId);
create index IX_A77C24AF on AP_AgentCalendar (title[$COLUMN_LENGTH:75$]);

create index IX_6663EE66 on AP_AgentEmailBucket (status_[$COLUMN_LENGTH:75$]);

create index IX_736A9F39 on AP_AgentFAQ (category[$COLUMN_LENGTH:75$]);
create index IX_434EDFF4 on AP_AgentFAQ (categoryId);

create index IX_494927FB on AP_AgentMarkCalendar (mypageUserId);

create index IX_6C907A0F on AP_AgentNotification (location[$COLUMN_LENGTH:75$]);
create index IX_EF9B873E on AP_AgentNotification (mypageUserGroupId);
create index IX_1FF8E7BB on AP_AgentNotification (mypageUserId);
create index IX_870EEA51 on AP_AgentNotification (mypageUserRoleId);
create index IX_8E7DE610 on AP_AgentNotification (referenceId);
create index IX_39CFDC22 on AP_AgentNotification (title[$COLUMN_LENGTH:75$]);

create index IX_8BB5EB9C on AP_AgentSalesTools (category[$COLUMN_LENGTH:75$]);
create index IX_E47AA8D5 on AP_AgentSalesTools (mypageUserRoleId);

create index IX_3B3AB66A on AP_AgentToken (apiRequestToken[$COLUMN_LENGTH:1000$]);
create index IX_5D66FAB0 on AP_AgentToken (deptCode[$COLUMN_LENGTH:75$]);
create index IX_C70EC83F on AP_AgentToken (token[$COLUMN_LENGTH:1000$]);

create index IX_92AE0A53 on AP_AgentTokenLimiter (deptCode[$COLUMN_LENGTH:75$], tokenType[$COLUMN_LENGTH:75$]);
create index IX_66337F on AP_AgentTokenLimiter (token[$COLUMN_LENGTH:1000$]);

create index IX_BD3D829E on AP_FAQ (category[$COLUMN_LENGTH:75$]);
create index IX_63F67E19 on AP_FAQ (categoryId);