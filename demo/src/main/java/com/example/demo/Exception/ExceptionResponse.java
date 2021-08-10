package com.example.demo.Exception;

import java.time.LocalDateTime;

/**
 * class that specifies the different attributes for Exception Handling
 * 
 * @author P7112764
 *
 */
public class ExceptionResponse {
	/**
	 * specifies the status_code
	 */
	private int Status_Code;
	/**
	 * specifies the message
	 */
	private String message;
	/**
	 * specifies the dateTime
	 */
	private LocalDateTime dateTime;
	/**
	 * specifies the description
	 */
	private String description;

	/**
	 * 
	 * @return Returns the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description accepts the description as argument and set the object
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return Returns the Status_code
	 */
	public int getStatus_Code() {
		return Status_Code;
	}

	/**
	 * 
	 * @param status_Code accepts the status_code
	 */
	public void setStatus_Code(int status_Code) {
		Status_Code = status_Code;
	}

	/**
	 * 
	 * @return Returns the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @param message accepts the message of String
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @return Returns the date and Time
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * 
	 * @param dateTime accepts the dateTime and set the object
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
