package com.aaseya.alps.dto;





public class ProgramdetailsDTO {
	private String sub_sub_category;
	private String category;
	private String subcategory;
	private String description;
	private int application_fee;
	private int application_startdate;
	private int application_enddate;
	private String duration;
	private String compliance;
	private String inspection;
	private String application_for;
	private String status;
	
	public String getSub_sub_category() {
		return sub_sub_category;
	}
	public void setSub_sub_category(String sub_sub_category) {
		this.sub_sub_category = sub_sub_category;
	}
	public String getApplication_for() {
		return application_for;
	}
	public void setApplication_for(String application_for) {
		this.application_for = application_for;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getApplication_fee() {
		return application_fee;
	}
	public void setApplication_fee(int application_fee) {
		this.application_fee = application_fee;
	}
	public int getApplication_startdate() {
		return application_startdate;
	}
	public void setApplication_startdate(int application_startdate) {
		this.application_startdate = application_startdate;
	}
	public int getApplication_enddate() {
		return application_enddate;
	}
	public void setApplication_enddate(int application_enddate) {
		this.application_enddate = application_enddate;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getCompliance() {
		return compliance;
	}
	public void setCompliance(String compliance) {
		this.compliance = compliance;
	}
	public String getInspection() {
		return inspection;
	}
	public void setInspection(String inspection) {
		this.inspection = inspection;
	}

}
