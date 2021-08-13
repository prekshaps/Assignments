package com.demo.cosmosdbdemo.Exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
	private int Status_Code;

	private String message;
	private LocalDateTime dateTime;

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus_Code() {
		return Status_Code;
	}

	public void setStatus_Code(int status_Code) {
		Status_Code = status_Code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}