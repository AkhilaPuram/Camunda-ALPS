package com.aaseya.alps.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "PersonBasicDetails")

public class PersonBasicDetails {
	
	@Column(name = "first_name")
	private String first_name;
	@Column(name = "middle_name")
	private String middle_name;
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "email_id")
	private String email_id;
	@Column(name = "phone_number")
	private long phone_number;
	@Column(name = "date_of_birth")
	private String date_of_birth;
	@Column(name = "country")
	private String country;
	@Column(name = "address_line1")
	private String address_line1;
	@Column(name = "address_line2")
	private String address_line2;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "postal_code")
	private int postal_code;
	@Column(name = "approved_hunting_organization")
	private String approved_hunting_organization;
	@Column(name = "rlicense_accreditation_number")
	private long rlicense_accreditation_number;
	@Column(name = "trainer_number")
	private long trainer_number;
	@Column(name = "waterfowl_identification_test_number")
	private long waterfowl_identification_test_number;
	@Id
	@Column(name = "license_id")
	private String license_id;
	@Column(name = "action")
	private String action;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getLicense_id() {
		return license_id;
	}
	public void setLicense_id(String license_id) {
		this.license_id = license_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress_line1() {
		return address_line1;
	}
	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}
	public String getAddress_line2() {
		return address_line2;
	}
	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(int postal_code) {
		this.postal_code = postal_code;
	}
	public String getApproved_hunting_organization() {
		return approved_hunting_organization;
	}
	public void setApproved_hunting_organization(String approved_hunting_organization) {
		this.approved_hunting_organization = approved_hunting_organization;
	}
	public long getRlicense_accreditation_number() {
		return rlicense_accreditation_number;
	}
	public void setRlicense_accreditation_number(long rlicense_accreditation_number) {
		this.rlicense_accreditation_number = rlicense_accreditation_number;
	}
	public long getTrainer_number() {
		return trainer_number;
	}
	public void setTrainer_number(long trainer_number) {
		this.trainer_number = trainer_number;
	}
	public long getWaterfowl_identification_test_number() {
		return waterfowl_identification_test_number;
	}
	public void setWaterfowl_identification_test_number(long waterfowl_identification_test_number) {
		this.waterfowl_identification_test_number = waterfowl_identification_test_number;
	
	
}
	@Override
	public String toString() {
		return "PersonBasicDetails [first_name=" + first_name + ", middle_name=" + middle_name + ", last_name="
				+ last_name + ", email_id=" + email_id + ", phone_number=" + phone_number + ", date_of_birth="
				+ date_of_birth + ", country=" + country + ", address_line1=" + address_line1 + ", address_line2="
				+ address_line2 + ", city=" + city + ", state=" + state + ", postal_code=" + postal_code
				+ ", approved_hunting_organization=" + approved_hunting_organization
				+ ", rlicense_accreditation_number=" + rlicense_accreditation_number + ", trainer_number="
				+ trainer_number + ", waterfowl_identification_test_number=" + waterfowl_identification_test_number
				+ ", license_id=" + license_id + ", action=" + action + "]";
	}
}
