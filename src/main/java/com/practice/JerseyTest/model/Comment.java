package com.practice.JerseyTest.model;

import java.util.Date;

public class Comment
{
    private String id;
    private String comment;
    private Date createddate;
    private String owner;
    
	public Comment(String id, String comment, Date createddate, String owner) {
		super();
		this.id = id;
		this.comment = comment;
		this.createddate = createddate;
		this.owner = owner;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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