create index IX_55C3E34E on CreditType (mypageUserId);

create index IX_88349E49 on CreditWalletHistory (creditWalletId);

create index IX_A2AD96BA on MypageGroupUser (mypageGroupId);
create index IX_3200B42A on MypageGroupUser (mypageUserId);

create index IX_F4AF59B6 on MypageUser (code_[$COLUMN_LENGTH:75$]);
create unique index IX_BE8E2E4D on MypageUser (creditWalletId);
create index IX_1231982E on MypageUser (deptoreCode[$COLUMN_LENGTH:75$]);
create index IX_5AE9DAC0 on MypageUser (email[$COLUMN_LENGTH:75$]);
create index IX_1D0756B8 on MypageUser (liferayUserId);
create index IX_CE4837B7 on MypageUser (mypageUserRoleId);
create index IX_ED5963FD on MypageUser (prettyUrl[$COLUMN_LENGTH:75$]);

create index IX_9AB4244E on MypageUserGracePeriod (mypageUserId);

create index IX_D875F693 on MypageUserLicenses (mypageUserId);

create index IX_A1A70882 on MypageUserTimeline (mypageUserId);

create index IX_AD45896A on MypageUserWorkingHour (mypageUserId);

create index IX_1C82591E on UserOneTimeCode (userId, sharedSecret[$COLUMN_LENGTH:75$]);

create index IX_E7E58E9D on UserRegistrationEducation (userRegistrationId);

create index IX_73293D5D on UserRegistrationJobExp (userRegistrationId);

create index IX_2A7ACE42 on UserRegistrationLiability (userRegistrationId);

create index IX_4A1EBA00 on UserRegistrationReference (userRegistrationId);