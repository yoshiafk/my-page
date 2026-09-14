create index IX_28A5EE6E on Customer (LeadsId, ProductCode[$COLUMN_LENGTH:75$]);

create index IX_C489153 on DetailDomesticTravel (LeadsId);

create index IX_D7470C83 on DetailDrive (leadsId);

create index IX_C03FDB81 on DetailHealthIndividu (LeadsId);

create index IX_E160DA25 on DetailInternationalTravel (LeadsId);

create index IX_6B2165EE on DetailPet (LeadsId);

create index IX_36D5E5FE on DetailSmartactive (LeadsId);

create index IX_E1F50495 on DetailTlp (leadsId);

create index IX_1A1D4A8F on Leads (LeadsParentId);
create index IX_783E858F on Leads (PromoCode[$COLUMN_LENGTH:75$]);
create index IX_F7A4F1A7 on Leads (ReferenceNumber[$COLUMN_LENGTH:75$]);
create index IX_DAF2592C on Leads (Token[$COLUMN_LENGTH:75$]);
create index IX_4DFAF5AB on Leads (idPhotoFileEntryId);
create index IX_BBDD51D2 on Leads (mypageUserId);

create index IX_782E23F6 on Payment (LeadsId);
create index IX_7A3813D on Payment (TransactionId[$COLUMN_LENGTH:75$]);