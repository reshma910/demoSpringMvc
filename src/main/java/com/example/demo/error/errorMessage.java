package com.example.demo.error;

import org.springframework.http.HttpStatus;

public class errorMessage {
	private HttpStatus status;
	private String Message;
	

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}

	public errorMessage(HttpStatus status, String message) {
		super();
		this.status = status;
		Message = message;
	}

	public errorMessage() {
		super();
	}
	
	

}
