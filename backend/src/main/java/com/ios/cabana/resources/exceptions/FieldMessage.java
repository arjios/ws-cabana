package com.ios.cabana.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String fieldError;
	private String fieldMessage;
	
	public FieldMessage() {
	}

	public FieldMessage(String fieldError, String fieldMessage) {
		this.fieldError = fieldError;
		this.fieldMessage = fieldMessage;
	}

	public String getFieldError() {
		return fieldError;
	}

	public void setFieldError(String fieldError) {
		this.fieldError = fieldError;
	}

	public String getFieldMessage() {
		return fieldMessage;
	}

	public void setFieldMessage(String fieldMessage) {
		this.fieldMessage = fieldMessage;
	}

}
