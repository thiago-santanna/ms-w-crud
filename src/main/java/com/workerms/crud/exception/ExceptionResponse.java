package com.workerms.crud.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 75272025816552410L;

	private LocalDateTime dtimestamp;
	private String message;
	private String details;

	public ExceptionResponse(LocalDateTime timestamp, String message, String details) {
		this.dtimestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public ExceptionResponse() {
	}

	public String getMessage() {
		return message;
	}
	

	public LocalDateTime getDtimestamp() {
		return dtimestamp;
	}

	public void setDtimestamp(LocalDateTime dtimestamp) {
		this.dtimestamp = dtimestamp;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [timestamp=" + dtimestamp + ", message=" + message + ", details=" + details + "]";
	}

}
