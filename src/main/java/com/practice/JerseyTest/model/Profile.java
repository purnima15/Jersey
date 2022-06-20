
package com.practice.JerseyTest.model;

import java.util.Date;

public class Profile
{
	private String id;
    private String profileName;
    private String firstname;
    private String lastname;
    private Date created;
    
    public Profile() {
    }
    
    public Profile(String id, String profileName, String firstname, String lastname, Date created) {
		super();
		this.id = id;
		this.profileName = profileName;
		this.firstname = firstname;
		this.lastname = lastname;
		this.created = created;
	}

	public String getProfileName() {
        return this.profileName;
    }
    
    public void setProfileName( String profileName) {
        this.profileName = profileName;
    }
    
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname( String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname( String lastname) {
        this.lastname = lastname;
    }
    
    public Date getCreated() {
        return this.created;
    }
    
    public void setCreated( Date created) {
        this.created = created;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}