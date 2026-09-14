package com.mypage.agencyportal.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class PolicyHolderDTO {

	@SerializedName("IsPep")
	private boolean isPep;

	@SerializedName("Name")
	private String name;

	@SerializedName("MaritalStatus")
	private String maritalStatus;

	@SerializedName("Email")
	private String email;

	@SerializedName("Phone")
	private String phone;

	@SerializedName("MobilePhone")
	private String mobilePhone;

	@SerializedName("Gender")
	private String gender;

	@SerializedName("Dob")
	private String dob;

	@SerializedName("BirthPlace")
	private String birthPlace;

	@SerializedName("Address")
	private String address;

	@SerializedName("Address2")
	private String address2;

	@SerializedName("Zip")
	private String zip;

	@SerializedName("Nationality")
	private String nationality;
	
	@SerializedName("NationalityCountry")
	private String nationalityCountry;
	
	@SerializedName("Province")
	private String province;

	@SerializedName("City")
	private String city;
	
	@SerializedName("CountryCode")
	private String countryCode;
	
	@SerializedName("AreaCode")
	private String areaCode;
	

	@SerializedName("IdNumber")
	private String idNumber;

	@SerializedName("PassportNumber")
	private String passportNumber;

	@SerializedName("KitasNumber")
	private String kitasNumber;

	@SerializedName("IdPhoto")
	private String idPhoto;

	@SerializedName("Job")
	private String job;

	@SerializedName("JobOther")
	private String jobOther;
	
	@SerializedName("Age")
	private String age;
	
	@SerializedName("WorkLocation")
	private String workLocation;
	
	@SerializedName("SourcePayment")
	private String sourcePayment;
	
	@SerializedName("Salary")
	private String salary;
	
	@SerializedName("Beneficiary")
	private String beneficiary;
	
	@SerializedName("BeneficiaryRelationship")
	private String beneficiaryRelationship;
	
	@SerializedName("IdPhotoUrl")
	private String idPhotoUrl;

	public boolean isPep() {
		return isPep;
	}

	public void setPep(boolean isPep) {
		this.isPep = isPep;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	

	public String getNationalityCountry() {
		return nationalityCountry;
	}

	public void setNationalityCountry(String nationalityCountry) {
		this.nationalityCountry = nationalityCountry;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getKitasNumber() {
		return kitasNumber;
	}

	public void setKitasNumber(String kitasNumber) {
		this.kitasNumber = kitasNumber;
	}

	public String getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(String idPhoto) {
		this.idPhoto = idPhoto;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getJobOther() {
		return jobOther;
	}

	public void setJobOther(String jobOther) {
		this.jobOther = jobOther;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public String getSourcePayment() {
		return sourcePayment;
	}

	public void setSourcePayment(String sourcePayment) {
		this.sourcePayment = sourcePayment;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}

	public String getBeneficiaryRelationship() {
		return beneficiaryRelationship;
	}

	public void setBeneficiaryRelationship(String beneficiaryRelationship) {
		this.beneficiaryRelationship = beneficiaryRelationship;
	}

	public String getIdPhotoUrl() {
		return idPhotoUrl;
	}

	public void setIdPhotoUrl(String idPhotoUrl) {
		this.idPhotoUrl = idPhotoUrl;
	}

	@Override
	public String toString() {
		return "PolicyHolderDTO [isPep=" + isPep + ", name=" + name + ", maritalStatus=" + maritalStatus + ", email="
				+ email + ", phone=" + phone + ", mobilePhone=" + mobilePhone + ", gender=" + gender + ", dob=" + dob
				+ ", birthPlace=" + birthPlace + ", address=" + address + ", address2=" + address2 + ", zip=" + zip
				+ ", nationality=" + nationality + ", nationalityCountry=" + nationalityCountry + ", province="
				+ province + ", city=" + city + ", countryCode=" + countryCode + ", areaCode=" + areaCode
				+ ", idNumber=" + idNumber + ", passportNumber=" + passportNumber + ", kitasNumber=" + kitasNumber
				+ ", idPhoto=" + idPhoto + ", job=" + job + ", jobOther=" + jobOther + ", age=" + age
				+ ", workLocation=" + workLocation + ", sourcePayment=" + sourcePayment + ", salary=" + salary
				+ ", beneficiary=" + beneficiary + ", beneficiaryRelationship=" + beneficiaryRelationship
				+ ", idPhotoUrl=" + idPhotoUrl + "]";
	}

	
}
