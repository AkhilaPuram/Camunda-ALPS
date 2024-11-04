package com.aaseya.alps.dto;
 
public class ALPSResponseDTO {
	
	
	private String status;
	private String businessKey;
	private String message;
	public String getBusinessKey() {
		return businessKey;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}
	@Override
	public String toString() {
		return "AISResponseDTO [status=" + status + ", businessKey=" + businessKey + ", message=" + message + "]";
	}
	
	
	
}
