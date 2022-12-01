package com.example.demo.error;

public class studentNotFound extends Exception{

	public studentNotFound() {
		super();
	}

	public studentNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public studentNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public studentNotFound(String message) {
		super(message);
	}

	public studentNotFound(Throwable cause) {
		super(cause);
	}
	

}
