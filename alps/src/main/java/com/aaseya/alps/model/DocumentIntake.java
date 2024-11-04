package com.aaseya.alps.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DocumentIntake")
public class DocumentIntake {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "document_id")
	private int document_id;
	@Column(name = "document_type")
	private String document_type;
	@Column(name = "name")
	private String name;
	@Column(name = "content")
	private String content;
	@ManyToOne
	@JoinColumn(name = "license_id")
	@JsonIgnore
	private LicenseCaseDetails licenseCaseDetails;
	
	public LicenseCaseDetails getLicenseCaseDetails() {
		return licenseCaseDetails;
	}
	public void setLicenseCaseDetails(LicenseCaseDetails licenseCaseDetails) {
		this.licenseCaseDetails = licenseCaseDetails;
	}
	
	public int getDocument_id() {
		return document_id;
	}
	public void setDocument_id(int document_id) {
		this.document_id = document_id;
	}
	public String getDocument_type() {
		return document_type;
	}
	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "DocumentIntake [document_id=" + document_id + ", document_type=" + document_type + ", name=" + name
				+ ", content=" + content + "]";
	}
	public String getLicense_id() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
