package com.luchoc.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	private String errorMesage; 
	private int errorCode; 
	private String documentation;
	
	public ErrorMessage() { 
		
	}
	
	public ErrorMessage(String errorMesage, int errorCode, String documentation) {
		super();
		this.errorMesage = errorMesage;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}

	public String getErrorMesage() {
		return errorMesage;
	}
	
	public void setErrorMesage(String errorMesage) {
		this.errorMesage = errorMesage;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getDocumentation() {
		return documentation;
	}
	
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
}
