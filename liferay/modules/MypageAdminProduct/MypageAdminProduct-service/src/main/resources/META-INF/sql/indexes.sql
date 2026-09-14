create index IX_234151B8 on BenefitValueMapping (benefitTypeId, benefitId, planId);

create index IX_F24BA72B on BlacklistCustomer (email[$COLUMN_LENGTH:75$]);
create index IX_9C33DAAA on BlacklistCustomer (firstName[$COLUMN_LENGTH:75$]);
create index IX_AD9B09EF on BlacklistCustomer (fullName[$COLUMN_LENGTH:75$]);
create index IX_29E5DE17 on BlacklistCustomer (kitas[$COLUMN_LENGTH:75$]);
create index IX_5EE5B836 on BlacklistCustomer (ktp[$COLUMN_LENGTH:75$]);
create index IX_505518B6 on BlacklistCustomer (lastName[$COLUMN_LENGTH:75$]);
create index IX_74B18FB5 on BlacklistCustomer (middleName[$COLUMN_LENGTH:75$]);

create index IX_8F7A721C on HealthIndividuPremi (planId, age);

create index IX_DF937CE6 on IntTravelStandardNewPremi (travelType[$COLUMN_LENGTH:75$], packageType[$COLUMN_LENGTH:75$], peopleType[$COLUMN_LENGTH:75$], currency_[$COLUMN_LENGTH:75$], mainInsured, spouse, child);

create index IX_9159D365 on MasterBank (active_);
create index IX_85161586 on MasterBank (name[$COLUMN_LENGTH:75$], active_);

create index IX_81ACA1C9 on MasterBranch (name[$COLUMN_LENGTH:75$]);

create index IX_FCECBCD6 on MasterCity (active_);
create index IX_B0162F32 on MasterCity (provinceId);

create index IX_8ED6EFBE on MasterCountry (isSanctionCountry, active_);
create index IX_63CBD5B9 on MasterCountry (name[$COLUMN_LENGTH:75$]);

create unique index IX_6B524CB8 on MasterCurrency (name[$COLUMN_LENGTH:75$]);

create index IX_31F97276 on MasterOccupation (active_);
create index IX_E5A52C4D on MasterOccupation (masterOccupationCategoryId);

create index IX_7F34EF98 on MasterOccupationCategory (active_);
create index IX_618C3190 on MasterOccupationCategory (name[$COLUMN_LENGTH:75$]);

create index IX_2A5A1695 on MasterPromoCode (mypageUserId);
create index IX_387D07CC on MasterPromoCode (promoCode[$COLUMN_LENGTH:75$]);

create index IX_69CF0EF1 on MasterProvince (active_);

create index IX_94F93C59 on PaymentChannel (masterBankId, active_);
create index IX_ABB11853 on PaymentChannel (paymentChannelId, code_[$COLUMN_LENGTH:75$]);

create index IX_882A455 on PaymentChannelTenor (paymentChannelId);

create index IX_5854B7BA on PetAnimalType (name[$COLUMN_LENGTH:75$]);

create index IX_C3093FCD on PetPlan (name[$COLUMN_LENGTH:75$]);
create index IX_E95837FD on PetPlan (recommended);
create index IX_B2BCD02 on PetPlan (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9FE7AC04 on PetPlan (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_A62DCFB on PetRate (petPlan, petRemarks);

create index IX_D83B71F9 on PetRemarks (name[$COLUMN_LENGTH:75$]);

create index IX_E04327D0 on Premi (currency_[$COLUMN_LENGTH:75$], travellerType[$COLUMN_LENGTH:75$]);

create index IX_724D3B5F on ProductConfiguration (productCode[$COLUMN_LENGTH:75$]);

create index IX_156E5A80 on Promocodes (promocode[$COLUMN_LENGTH:75$], startDate, endDate, products[$COLUMN_LENGTH:75$]);
create index IX_6685A351 on Promocodes (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A110CA13 on Promocodes (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C8104695 on ReferenceNumber (userRole[$COLUMN_LENGTH:75$], channel[$COLUMN_LENGTH:75$], type_[$COLUMN_LENGTH:75$], productCode[$COLUMN_LENGTH:75$], businessType[$COLUMN_LENGTH:75$], currency_[$COLUMN_LENGTH:75$]);

create index IX_765DFD1A on SmartActiveBenefit (externalCode[$COLUMN_LENGTH:75$]);
create index IX_205FBAFF on SmartActiveBenefit (smartActiveBenefitTypeId);

create index IX_4E5F1CB2 on SmartActiveBenefitValue (value);

create index IX_E270F772 on SmartActiveBenefitValueMapping (smartActiveBenefitId, smartActiveBenefitValueId);
create index IX_7C6ACC93 on SmartActiveBenefitValueMapping (smartActiveBenefitTypeId, smartActiveBenefitId);
create index IX_E194A169 on SmartActiveBenefitValueMapping (smartActiveBenefitValueId);

create index IX_297351E1 on SmartActiveLink (category[$COLUMN_LENGTH:75$]);

create index IX_D4884042 on SmartActiveOccupation (code_[$COLUMN_LENGTH:75$]);

create index IX_D9DF7F45 on SmartActivePremi (smartActiveBenefitId, smartActiveClassRateId);

create index IX_E32ED66B on SmartActiveTopro (smartActiveBenefitValueId);
create index IX_6E608BD9 on SmartActiveTopro (topro[$COLUMN_LENGTH:75$]);

create index IX_99CF00B2 on SmartActiveToproBenefitMapping (smartActiveToproId);

create index IX_87818DC1 on SmartHealthBenefit (smartHealthPlanId);

create index IX_64F19D29 on SmartHealthBenefitGroup (groupCode[$COLUMN_LENGTH:75$]);

create index IX_ACE32012 on SmartHealthPlan (planGroup[$COLUMN_LENGTH:75$]);
create index IX_39DF38BC on SmartHealthPlan (planName[$COLUMN_LENGTH:75$]);

create index IX_7A291074 on SmartTravelIntLink (linkType[$COLUMN_LENGTH:75$]);

create index IX_5A7BE2B0 on StiBenefitValueMapping (benefitTypeId, benefitId, planId);

create index IX_3D00C2C8 on StiPremi (currency_[$COLUMN_LENGTH:75$], travellerType[$COLUMN_LENGTH:75$]);

create index IX_3B2A5739 on TravelDomesticBenefit (group_[$COLUMN_LENGTH:75$]);
create index IX_EAD5B822 on TravelDomesticBenefit (plan[$COLUMN_LENGTH:75$]);

create index IX_89E824FC on TravelDomesticBenefitGroup (code_[$COLUMN_LENGTH:75$]);

create index IX_19320BDE on TravelDomesticDuration (travelDomesticDurationId, code_[$COLUMN_LENGTH:75$], dayFrom, dayTo, label[$COLUMN_LENGTH:75$]);

create index IX_408C847E on TravelDomesticInsuredType (travelDomesticInsuredTypeId, name[$COLUMN_LENGTH:75$], code_[$COLUMN_LENGTH:75$]);

create index IX_996DEB1B on TravelDomesticPlan (code_[$COLUMN_LENGTH:75$]);
create index IX_4F2BEFB3 on TravelDomesticPlan (travelDomesticPlanId, name[$COLUMN_LENGTH:75$], code_[$COLUMN_LENGTH:75$], toproTsi, toproAtsi);

create index IX_4241B962 on TravelDomesticPremi (duration, plan[$COLUMN_LENGTH:75$], insuredType[$COLUMN_LENGTH:75$]);

create index IX_CFFF368A on TravelDomesticRelationship (travelDomesticRelationshipId, name[$COLUMN_LENGTH:75$], description[$COLUMN_LENGTH:75$], sort);

create index IX_5545A8DB on TravelIntBenefitValue (packageType[$COLUMN_LENGTH:75$]);

create index IX_C130A0E2 on TravelInternationalPremi (packageType[$COLUMN_LENGTH:75$], peopleType[$COLUMN_LENGTH:75$], currency_[$COLUMN_LENGTH:75$], adultCount, childrenCount, minDuration, maxDuration, active_);