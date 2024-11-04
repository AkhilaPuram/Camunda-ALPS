package com.aaseya.alps.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "SubSubCategory")
public class SubSubCategory {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subsubcategory_id")
	private int subsubcategory_id;
	@Column(name = "subsubcategory_name")
	private String subsubcategory_name;
	
	     @ManyToOne
	    @JoinColumn(name = "subcategory_id")
	     @JsonIgnore
		private SubCategory subCategory;
	 
	
	   @OneToOne(mappedBy = "subsubCategory")
	   @JsonIgnore
	 private ProgramDetails programDetails;
	
	public SubCategory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
	public int getSubsubcategory_id() {
		return subsubcategory_id;
	}
	public void setSubsubcategory_id(int subsubcategory_id) {
		this.subsubcategory_id = subsubcategory_id;
	}
	public String getSubsubcategory_name() {
		return subsubcategory_name;
	}
	public void setSubsubcategory_name(String subsubcategory_name) {
		this.subsubcategory_name = subsubcategory_name;
	}
	@Override
	public String toString() {
		return "SubSubCategory [subsubcategory_id=" + subsubcategory_id + ", subsubcategory_name=" + subsubcategory_name
				+ ", getSubsubcategory_id()=" + getSubsubcategory_id() + ", getSubsubcategory_name()="
				+ getSubsubcategory_name() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
