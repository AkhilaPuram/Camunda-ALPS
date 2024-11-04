
	package com.aaseya.alps.model;
	 
	import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
	@Entity
	@Table(name = "LicenseCaseDetails")
	 
	public class LicenseCaseDetails {
		@Id
		@Column(name = "license_Id")
		private String license_Id;
		@Column(name = "applicantId")
		private String applicantId;
		@Column(name = "category")
		private String category;
		@Column(name = "subcategory")
		private String subcategory;
		@Column(name = "subsubcategory")
		private int subsubcategory;
		@Column(name = "status")
		private String status;
		@Column(name = "reviewerId")
		private String reviewerId;
		@Column(name = "createdBy")
		private String createdBy;
		
		public String getLicense_Id() {
			return license_Id;
		}
		public void setLicense_Id(String license_Id) {
			this.license_Id = license_Id;
		}
		@OneToMany(mappedBy = "licenseCaseDetails", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
		@JsonIgnore
		private List<DocumentIntake> documentIntakes;
		
		public String getCreatedBy() {
			return createdBy;
		}
		public List<DocumentIntake> getDocumentIntakes() {
			return documentIntakes;
		}
		public void setDocumentIntakes(List<DocumentIntake> documentIntakes) {
			this.documentIntakes = documentIntakes;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		
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
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getReviewerId() {
			return reviewerId;
		}
		public void setReviewerId(String reviewerId) {
			this.reviewerId = reviewerId;
		}
		@Override
		public String toString() {
			return "LicenseCaseDetails [license_Id=" + license_Id + ", applicantId=" + applicantId + ", category="
					+ category + ", subcategory=" + subcategory + ", subsubcategory=" + subsubcategory + ", status="
					+ status + ", reviewerId=" + reviewerId + ", createdBy=" + createdBy + ", documentIntakes="
					+ documentIntakes + "]";
		}
		
}
