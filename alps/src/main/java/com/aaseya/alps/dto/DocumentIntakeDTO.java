package com.aaseya.alps.dto;

public class DocumentIntakeDTO {
	private int document_id;
	private String document_type;
	private String name;
	private String content;
	private String license_id;
	
	public String getLicense_id() {
		return license_id;
	}
	public void setLicense_id(String license_id) {
		this.license_id = license_id;
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
		return "DocumentIntakeDTO [document_id=" + document_id + ", document_type=" + document_type + ", name=" + name
				+ ", content=" + content + ", license_id=" + license_id + "]";
	}

}
