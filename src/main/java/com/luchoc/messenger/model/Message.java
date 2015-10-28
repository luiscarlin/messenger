package com.luchoc.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private long id; 
	private String message; 
	private Date created; 
	private String author; 
	
	public Message() {
	}

	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getMassage() {
		return message;
	}
	
	public void setMassage(String message) {
		this.message = message;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
}