package com.aaseya.alps.dto;
 
public class StartALPSRequestDTO {
 
	private String applicantId;
	private String category;
	private String subcategory;
	private int subsubcategory;
	private String createdBy;
 
	public String getApplicantId() {
		return applicantId;
	}
 
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}
 
	public String getCategory() {
		return category;
	}
 
	public void setCategory(String category) {
		this.category = category;
	}
 
	public String getSubcategory() {
		return subcategory;
	}
 
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
 
	public int getSubsubcategory() {
		return subsubcategory;
	}
 
	public void setSubsubcategory(int subsubcategory) {
		this.subsubcategory = subsubcategory;
	}
 
	public String getCreatedBy() {
		return createdBy;
	}
 
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
 
}
 