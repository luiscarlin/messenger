package com.luchoc.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {

	private long id;
	private Date created; 
	private String author;
	private String message; 
	
	public Comment() {
	}

	public Comment(long id, String author, String message) {
		this.id = id;
		this.author = author;
		this.created = new Date();
		this.message = message;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) { 
		this.created = created;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}