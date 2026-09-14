create table Benefit (
	benefitId LONG not null primary key,
	nameId VARCHAR(75) null,
	nameEn VARCHAR(75) null,
	sort INTEGER,
	benefitTypeId LONG,
	active_ INTEGER,
	planName VARCHAR(75) null,
	benefitValue VARCHAR(75) null,
	externalCode VARCHAR(75) null,
	benefitDescription VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table BenefitType (
	benefitTypeId LONG not null primary key,
	nameId VARCHAR(75) null,
	nameEn VARCHAR(75) null,
	sort INTEGER,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table BenefitValueMapping (
	benefitValueMappingId LONG not null primary key,
	benefitTypeId LONG,
	benefitId LONG,
	planId LONG,
	benefitValue VARCHAR(1000) null,
	benefitValueUSD VARCHAR(1000) null,
	sort INTEGER,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table BlacklistCustomer (
	blacklistCustomerId LONG not null primary key,
	fullName VARCHAR(75) null,
	firstName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	ktp VARCHAR(75) null,
	kitas VARCHAR(75) null,
	email VARCHAR(75) null,
	dateOfBirth DATE null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table CompanyType (
	companyTypeId LONG not null primary key,
	name VARCHAR(75) null,
	label VARCHAR(75) null,
	sort INTEGER,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table HealthIndividuPlan (
	healthIndividuPlanId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	limitYear LONG,
	limitDisability LONG,
	inpatient LONG,
	outpatient LONG,
	ambulanceService LONG,
	personalAccident LONG,
	detail VARCHAR(75) null,
	benefit VARCHAR(75) null,
	benefitIcon VARCHAR(75) null,
	recommended INTEGER,
	active_ INTEGER
);

create table HealthIndividuPremi (
	healthIndividuPremiId LONG not null primary key,
	planId LONG,
	age INTEGER,
	premi LONG,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table HealthSmeFacility (
	healthSmeFacilityId LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	healthSmeTypeId LONG,
	defaultMinimum INTEGER,
	minimum DOUBLE,
	defaultNormal INTEGER,
	normal DOUBLE,
	defaultMaximum INTEGER,
	maximum DOUBLE,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table HealthSmePremi (
	healthSmePremiId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	premiType VARCHAR(75) null,
	amount LONG,
	healthSmeTemplateId LONG,
	active_ INTEGER
);

create table HealthSmeTemplate (
	healthSmeTemplateId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	description VARCHAR(75) null,
	amount LONG,
	annualLimit LONG,
	healthSmeTypeId LONG,
	active_ INTEGER
);

create table HealthSmeType (
	healthSmeTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	typeName VARCHAR(75) null,
	typeCode VARCHAR(75) null,
	typeDescription VARCHAR(75) null,
	active_ INTEGER
);

create table Industry (
	industryId LONG not null primary key,
	name VARCHAR(75) null,
	industryCategoryId LONG,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table IndustryCategory (
	industryCategoryId LONG not null primary key,
	name VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table IntTravelStandardNewPremi (
	intTravelStandardNewPremiId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	travelType VARCHAR(75) null,
	packageType VARCHAR(75) null,
	peopleType VARCHAR(75) null,
	mainInsured INTEGER,
	spouse INTEGER,
	child INTEGER,
	currency_ VARCHAR(75) null,
	amount DECIMAL(30, 16) null,
	additionalPrice DECIMAL(30, 16) null,
	active_ INTEGER
);

create table JobPosition (
	jobPositionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	active_ INTEGER
);

create table MasterBank (
	masterBankId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	bankCode VARCHAR(75) null,
	bankDesc VARCHAR(75) null,
	name VARCHAR(75) null,
	detail VARCHAR(75) null,
	imageURL VARCHAR(75) null,
	imageFileEntryId LONG,
	order_ INTEGER,
	active_ INTEGER
);

create table MasterBranch (
	masterBranchId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	agiCode VARCHAR(75) null,
	magiCode VARCHAR(75) null,
	active_ INTEGER
);

create table MasterCity (
	masterCityId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	provinceId LONG,
	status VARCHAR(75) null,
	parEarthquakeZone INTEGER,
	active_ INTEGER
);

create table MasterCountry (
	countryId LONG not null primary key,
	name VARCHAR(75) null,
	isPlatinum INTEGER,
	isGold INTEGER,
	isSpecialAsia INTEGER,
	isSchengen INTEGER,
	isSanctionCountry INTEGER,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table MasterCurrency (
	currencyId LONG not null primary key,
	name VARCHAR(75) null,
	amount DOUBLE,
	isDefault INTEGER,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table MasterGlobalVariable (
	masterGlobalVariableId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	group_ VARCHAR(75) null,
	name VARCHAR(75) null,
	value VARCHAR(75) null,
	imageFileEntryId LONG,
	active_ INTEGER
);

create table MasterOccupation (
	masterOccupationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	masterOccupationCategoryId LONG,
	active_ INTEGER
);

create table MasterOccupationCategory (
	masterOccupationCategoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	active_ INTEGER
);

create table MasterPromoCode (
	promoCodeId LONG not null primary key,
	isDefault INTEGER,
	productCode VARCHAR(75) null,
	productName VARCHAR(75) null,
	promoType VARCHAR(75) null,
	promoCode VARCHAR(75) null,
	discount DOUBLE,
	startDate DATE null,
	endDate DATE null,
	activeDay VARCHAR(75) null,
	limit_ VARCHAR(75) null,
	network VARCHAR(75) null,
	channel VARCHAR(75) null,
	isB2C INTEGER,
	isB2B2C INTEGER,
	isB2B INTEGER,
	payment VARCHAR(75) null,
	birthdayMonth VARCHAR(75) null,
	remarks VARCHAR(75) null,
	mypageUserId LONG,
	agentName VARCHAR(75) null,
	deptoreCode VARCHAR(75) null,
	commission VARCHAR(75) null,
	plan_ VARCHAR(75) null,
	promoCodeTerms VARCHAR(75) null,
	travellerType VARCHAR(75) null,
	utmId VARCHAR(75) null,
	paymentChannelId VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table MasterProvince (
	masterProvinceId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	countryId INTEGER,
	active_ INTEGER
);

create table PaymentChannel (
	paymentChannelId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	minPayment DOUBLE,
	maxPayment DOUBLE,
	description VARCHAR(75) null,
	masterBankId LONG,
	mdrAxa VARCHAR(75) null,
	mdrUser VARCHAR(75) null,
	pgFeePct VARCHAR(75) null,
	pgFeeAmt VARCHAR(75) null,
	imageFileEntryId LONG,
	imageURL VARCHAR(75) null,
	utmOnly INTEGER,
	mallId VARCHAR(75) null,
	sharedKey VARCHAR(75) null,
	active_ INTEGER
);

create table PaymentChannelTenor (
	paymentChannelTenorId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	paymentChannelId LONG,
	promoid VARCHAR(75) null,
	tenor VARCHAR(75) null,
	tenorid VARCHAR(75) null,
	acquirer VARCHAR(75) null,
	active_ INTEGER
);

create table PersonalAccidentPremi (
	personalAccidentPremiId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	premiType VARCHAR(75) null,
	amount DOUBLE,
	active_ INTEGER
);

create table PetAnimalType (
	petAnimalTypeId LONG not null primary key,
	name VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table PetDetail (
	petDetailId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	remarksAValue VARCHAR(75) null,
	remarksBValue VARCHAR(75) null,
	remarksCValue VARCHAR(75) null,
	remarksDValue VARCHAR(75) null,
	petName VARCHAR(75) null,
	petType INTEGER,
	petGender INTEGER,
	petDob DATE null,
	petIdNumber VARCHAR(75) null,
	petIdNumberIssuing VARCHAR(75) null,
	petIdNumberFile VARCHAR(75) null,
	petPhoto VARCHAR(75) null,
	petLocation VARCHAR(75) null,
	petVaccine INTEGER,
	petAuthorizedCertificate INTEGER
);

create table PetPlan (
	uuid_ VARCHAR(75) null,
	petPlanId LONG not null primary key,
	name VARCHAR(75) null,
	limitDisability LONG,
	limitMedical LONG,
	limitThirdParty LONG,
	limitCustody LONG,
	recommended INTEGER,
	customPlan INTEGER,
	benefit VARCHAR(75) null,
	pimcorePlanId LONG,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table PetRate (
	petRateId LONG not null primary key,
	petPlan LONG,
	petRemarks LONG,
	rate VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table PetRemarks (
	petRemarksId LONG not null primary key,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table Premi (
	premiId LONG not null primary key,
	travellerType VARCHAR(75) null,
	currency_ VARCHAR(75) null,
	basic DECIMAL(30, 16) null,
	additional DECIMAL(30, 16) null,
	annual DECIMAL(30, 16) null,
	active_ INTEGER,
	benefitId LONG,
	planId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table ProductConfiguration (
	productId LONG not null primary key,
	productCode VARCHAR(75) null,
	productName VARCHAR(75) null,
	ojkName VARCHAR(75) null,
	stampdutyIDR DOUBLE,
	stampdutyUSD DOUBLE,
	policyCostIDR DOUBLE,
	policyCostUSD DOUBLE,
	aclStatus INTEGER,
	aclGracePeriod INTEGER,
	commission DOUBLE,
	webContentFolderId INTEGER,
	link VARCHAR(75) null,
	isB2C INTEGER,
	isB2B INTEGER,
	isB2B2C INTEGER,
	iconFileEntryId LONG,
	imageFileEntryId LONG,
	pepEnable INTEGER,
	policyWordingEntryId LONG,
	metaTitle VARCHAR(75) null,
	metaDescription VARCHAR(75) null,
	metaKeywords VARCHAR(75) null
);

create table Promocodes (
	uuid_ VARCHAR(75) null,
	promocodeId LONG not null primary key,
	products VARCHAR(75) null,
	promocode VARCHAR(75) null,
	commission DOUBLE,
	discount DOUBLE,
	isB2C INTEGER,
	isB2B2C INTEGER,
	isB2B INTEGER,
	user VARCHAR(75) null,
	mypageUserId LONG,
	startDate DATE null,
	endDate DATE null,
	promoType VARCHAR(75) null,
	birthdayMonth DATE null,
	limit_ INTEGER,
	terms VARCHAR(75) null,
	plan VARCHAR(75) null,
	paymentChannel VARCHAR(75) null,
	utmCampaignId VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table ReferenceNumber (
	referenceNumberId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	userRole VARCHAR(75) null,
	channel VARCHAR(75) null,
	type_ VARCHAR(75) null,
	productCode VARCHAR(75) null,
	businessType VARCHAR(75) null,
	currency_ VARCHAR(75) null,
	prefix VARCHAR(75) null,
	active_ INTEGER
);

create table SmartActiveBenefit (
	smartActiveBenefitId LONG not null primary key,
	nameId VARCHAR(75) null,
	nameEn VARCHAR(75) null,
	sort INTEGER,
	smartActiveBenefitTypeId LONG,
	active_ INTEGER,
	description VARCHAR(75) null,
	limit_ VARCHAR(75) null,
	externalCode VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table SmartActiveBenefitType (
	smartActiveBenefitTypeId LONG not null primary key,
	nameId VARCHAR(75) null,
	nameEn VARCHAR(75) null,
	sort INTEGER,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table SmartActiveBenefitValue (
	smartActiveBenefitValueId LONG not null primary key,
	value LONG,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table SmartActiveBenefitValueMapping (
	smartActiveBenefitValueMappingId LONG not null primary key,
	smartActiveBenefitTypeId LONG,
	smartActiveBenefitId LONG,
	smartActiveBenefitValueId LONG,
	value VARCHAR(75) null,
	limitValue DECIMAL(30, 16) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table SmartActiveClassRate (
	smartActiveClassRateId LONG not null primary key,
	nameId VARCHAR(75) null,
	nameEn VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table SmartActiveFeature (
	smartActiveFeatureId LONG not null primary key,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	fileUploadEntryId LONG,
	fileUploadUrl VARCHAR(75) null,
	sort INTEGER,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table SmartActiveLink (
	smartActiveLinkId LONG not null primary key,
	category VARCHAR(75) null,
	title VARCHAR(75) null,
	fileUploadEntryId LONG,
	fileUploadUrl VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table SmartActiveOccupation (
	smartActiveOccupationId LONG not null primary key,
	code_ VARCHAR(75) null,
	nameId VARCHAR(75) null,
	nameEn VARCHAR(75) null,
	active_ INTEGER,
	smartActiveClassRateId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table SmartActivePremi (
	smartActivePremiId LONG not null primary key,
	rate DOUBLE,
	active_ INTEGER,
	smartActiveClassRateId LONG,
	smartActiveBenefitId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table SmartActiveTopro (
	smartActiveToproId LONG not null primary key,
	topro VARCHAR(75) null,
	description VARCHAR(75) null,
	annotations VARCHAR(75) null,
	smartActiveBenefitValueId LONG,
	toc VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table SmartActiveToproBenefitMapping (
	smartActiveToproBenefitMappingId LONG not null primary key,
	smartActiveToproId LONG,
	ListBenefitId VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table SmartHealthBenefit (
	smartHealthBenefitId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	benefitTitle VARCHAR(75) null,
	benefitContent VARCHAR(75) null,
	smartHealthBenefitGroupId LONG,
	smartHealthPlanId LONG,
	active_ INTEGER
);

create table SmartHealthBenefitGroup (
	smartHealthBenefitGroupId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	groupName VARCHAR(75) null,
	groupDescription VARCHAR(75) null,
	groupCode VARCHAR(75) null,
	active_ INTEGER
);

create table SmartHealthPlan (
	smartHealthPlanId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	planName VARCHAR(75) null,
	planGroup VARCHAR(75) null,
	isRecommended INTEGER,
	active_ INTEGER
);

create table SmartHealthPremi (
	smartHealthPremiId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	age INTEGER,
	gender VARCHAR(75) null,
	currency_ VARCHAR(75) null,
	amount DOUBLE,
	planId LONG,
	status INTEGER
);

create table SmartTravelIntLink (
	smartTravelIntLinkId LONG not null primary key,
	linkType VARCHAR(75) null,
	linkTitle VARCHAR(75) null,
	linkHref VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table SmartTravelIntPlan (
	smartTravelIntPlanId LONG not null primary key,
	nameId VARCHAR(75) null,
	nameEn VARCHAR(75) null,
	sort INTEGER,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table StiBenefit (
	benefitId LONG not null primary key,
	nameId VARCHAR(75) null,
	nameEn VARCHAR(75) null,
	sort INTEGER,
	benefitTypeId LONG,
	active_ INTEGER,
	planName VARCHAR(75) null,
	benefitValue VARCHAR(75) null,
	externalCode VARCHAR(75) null,
	benefitDescription VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table StiBenefitValueMapping (
	benefitValueMappingId LONG not null primary key,
	benefitTypeId LONG,
	benefitId LONG,
	planId LONG,
	benefitValue VARCHAR(75) null,
	benefitValueUSD VARCHAR(75) null,
	sort INTEGER,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table StiPremi (
	premiId LONG not null primary key,
	travellerType VARCHAR(75) null,
	currency_ VARCHAR(75) null,
	basic DECIMAL(30, 16) null,
	additional DECIMAL(30, 16) null,
	annual DECIMAL(30, 16) null,
	active_ INTEGER,
	benefitId LONG,
	planId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table TravelDomesticBenefit (
	travelDomesticBenefitId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	plan VARCHAR(75) null,
	amount VARCHAR(75) null,
	benefit VARCHAR(75) null,
	benefitValue LONG,
	group_ VARCHAR(75) null,
	sort INTEGER,
	active_ INTEGER
);

create table TravelDomesticBenefitGroup (
	travelDomesticBenefitGroupId LONG not null primary key,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	active_ INTEGER
);

create table TravelDomesticDuration (
	travelDomesticDurationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	dayFrom INTEGER,
	dayTo INTEGER,
	label VARCHAR(75) null,
	active_ INTEGER
);

create table TravelDomesticInsuredType (
	travelDomesticInsuredTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	active_ INTEGER
);

create table TravelDomesticPlan (
	travelDomesticPlanId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	toproTsi INTEGER,
	toproAtsi INTEGER,
	sort INTEGER,
	active_ INTEGER
);

create table TravelDomesticPremi (
	travelDomesticPremiId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	duration INTEGER,
	plan VARCHAR(75) null,
	insuredType VARCHAR(75) null,
	currency_ VARCHAR(75) null,
	amount LONG,
	active_ INTEGER
);

create table TravelDomesticRelationship (
	travelDomesticRelationshipId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	sort INTEGER,
	active_ INTEGER
);

create table TravelDomesticTravellerType (
	travellerTypeId LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table TravelIntBenefit (
	travelIntBenefitId LONG not null primary key,
	benefitName VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table TravelIntBenefitValue (
	travelIntBenefitValueId LONG not null primary key,
	travelIntBenefitId LONG,
	currencyName VARCHAR(75) null,
	packageType VARCHAR(75) null,
	benefitValue VARCHAR(75) null,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table TravelInternationalPremi (
	premiId LONG not null primary key,
	packageType VARCHAR(75) null,
	peopleType VARCHAR(75) null,
	adultCount INTEGER,
	childrenCount INTEGER,
	currency_ VARCHAR(75) null,
	amount DECIMAL(30, 16) null,
	minDuration INTEGER,
	maxDuration INTEGER,
	active_ INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);