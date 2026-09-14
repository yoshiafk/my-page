create index IX_DC16C2DF on MSPPK_SppkUser (email[$COLUMN_LENGTH:75$], otpCode[$COLUMN_LENGTH:75$]);
create index IX_D1E16831 on MSPPK_SppkUser (fullName[$COLUMN_LENGTH:75$]);
create unique index IX_85ABBFCB on MSPPK_SppkUser (sppkLoginCode[$COLUMN_LENGTH:75$]);