package com.practice.JerseyTest.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
		private String id;
		private String message;
		private Date createddate;
		private String owner;
		
		public Message() {  
		}
		
		
		public Message(String id, String message, Date createddate, String owner) {
			super();
			this.id = id;
			this.message = message;
			this.createddate = createddate;
			this.owner = owner;
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Date getCreateddate() {
			return createddate;
		}
		public void setCreateddate(Date createddate) {
			this.createddate = createddate;
		}
		public String getOwner() {
			return owner;
		}
		public void setOwner(String owner) {
			this.owner = owner;
		}
	}
		
