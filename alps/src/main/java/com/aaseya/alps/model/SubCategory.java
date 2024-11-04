package com.aaseya.alps.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
@Table(name = "SubCategory")
public class SubCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subcategory_id")
	private int subcategory_id;
	@Column(name = "subcategory_name")
	private String subcategory_name;

	@OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<SubSubCategory> subSubCategories;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private Category category;

	public int getSubcategory_id() {
		return subcategory_id;
	}

	public void setSubcategory_id(int subcategory_id) {
		this.subcategory_id = subcategory_id;
	}

	public String getSubcategory_name() {
		return subcategory_name;
	}

	public void setSubcategory_name(String subcategory_name) {
		this.subcategory_name = subcategory_name;
	}

	public List<SubSubCategory> getSubSubCategories() {
		return subSubCategories;
	}

	public void setSubSubCategories(List<SubSubCategory> subSubCategories) {
		this.subSubCategories = subSubCategories;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "SubCategory [subcategory_id=" + subcategory_id + ", subcategory_name=" + subcategory_name
				+ ", subSubCategories=" + subSubCategories + ", category=" + category + ", getSubcategory_id()="
				+ getSubcategory_id() + ", getSubcategory_name()=" + getSubcategory_name() + ", getSubSubCategories()="
				+ getSubSubCategories() + ", getCategory()=" + getCategory() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
