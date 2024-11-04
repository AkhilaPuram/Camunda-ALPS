package com.aaseya.alps.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProgramDetails")

public class ProgramDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "program_id")
	private int program_id;
	@Column(name = "program_name")
private String program_name;
	@Column(name = "category")
	private String category;

	@Column(name = "subcategory")
	private String subcategory;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "application_fee")
	private int application_fee;
	
	@Column(name = "application_startdate")
	private Date application_startdate;
	
	@Column(name = "application_enddate")
	private Date application_enddate;
	
	@Column(name = "duration")
	private String duration;
	
	@Column(name = "compliance")
	private String compliance;
	
	@Column(name = "inspection")
	private String inspection;
	
	@Column(name = "application_for")
	private String application_for;
	
	@Column(name = "status")
	private String status;

	
	
	public String getProgram_name() {
		return program_name;
	}

	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "subsubcategory_id")
    private SubSubCategory subsubCategory;

	public int getProgram_id() {
		return program_id;
	}

	public void setProgram_id(int program_id) {
		this.program_id = program_id;
	}

	public SubSubCategory getSubsubCategory() {
		return subsubCategory;
	}

	public void setSubsubCategory(SubSubCategory subsubCategory) {
		this.subsubCategory = subsubCategory;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public String getApplication_for() {
		return application_for;
	}

	public void setApplication_for(String application_for) {
		this.application_for = application_for;
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

	public Date getApplication_startdate() {
		return application_startdate;
	}

	public void setApplication_startdate(Date application_startdate) {
		this.application_startdate = application_startdate;
	}

	public Date getApplication_enddate() {
		return application_enddate;
	}

	public void setApplication_enddate(Date application_enddate) {
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

	@Override
	public String toString() {
		return "ProgramDetails [program_id=" + program_id + ", program_name=" + program_name + ", category=" + category
				+ ", subcategory=" + subcategory + ", description=" + description + ", application_fee="
				+ application_fee + ", application_startdate=" + application_startdate + ", application_enddate="
				+ application_enddate + ", duration=" + duration + ", compliance=" + compliance + ", inspection="
				+ inspection + ", application_for=" + application_for + ", status=" + status + ", subsubCategory="
				+ subsubCategory + "]";
	}

}
