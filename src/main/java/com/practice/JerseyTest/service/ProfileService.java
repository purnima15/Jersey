
package com.practice.JerseyTest.service;

import java.sql.ResultSet;
import java.text.ParseException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import com.practice.JerseyTest.model.Profile;
import java.util.List;
import java.text.SimpleDateFormat;
import com.practice.JerseyTest.config.DatabaseConfig;

public class ProfileService
{
    DatabaseConfig dbObj;
    SimpleDateFormat formatter;
    private List<Profile> profiles;
    
    public ProfileService() {
        dbObj = new DatabaseConfig();
        formatter = null;
        profiles = new ArrayList<Profile>(Arrays.asList(
        		new Profile("1", "poosis15", "Punam", "Sisodiya", new Date()),
        		new Profile("2", "csk123", "chennai", "Kings", new Date())
        		));
    }
    
    public List<Profile> getProfiles() {
        return profiles;
    }
    
    public void setProfiles( List<Profile> profiles) {
        profiles = profiles;
    }
    
    public List<Profile> getAllProfiles() {
        formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
         List<Profile> profiles = new ArrayList<Profile>();
         String query = "Select * from Profile";
         ResultSet rs = dbObj.excuteDBQuery(query);
        Profile p = null;
        try {
            while (rs.next()) {
                p = new Profile();
                p.setId(rs.getString("ID"));
                p.setProfileName(rs.getString("profname"));
                p.setFirstname(rs.getString("fname"));
                p.setLastname(rs.getString("lname"));
                p.setCreated(formatter.parse(rs.getString("createddate")));
                profiles.add(p);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ParseException e2) {
            e2.printStackTrace();
        }
        return profiles;
    }
    
    public Profile getProfileById( String id) {
        formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
         String query = "select * from profile where id=" + id;
         ResultSet rs = dbObj.excuteDBQuery(query);
        Profile p = null;
        try {
            if (rs.next()) {
                p = new Profile();
                p.setId(rs.getString("ID"));
                p.setProfileName(rs.getString("profname"));
                p.setFirstname(rs.getString("fname"));
                p.setLastname(rs.getString("lname"));
                p.setCreated(formatter.parse(rs.getString("createddate")));
            }
        }
        catch (SQLException | ParseException ex2) {
           
            ex2.printStackTrace();
        }
        return p;
    }
    
    public void addProfile( Profile profile) {
         String query = "insert into profile values(?,?,?,?,?)";
         int addedrows = dbObj.excuteDBInsert(query, profile);
        if (addedrows > 0) {
            System.out.println("Added successfully");
        }
    }
    
    public void updateProfile( Profile profile,  String id) {
         String query = "update Profile set profname=?,fname=?,lname=?,createddate=? where id=?";
         int addedrows = dbObj.excuteDBUpdate(query, profile);
        if (addedrows > 0) {
            System.out.println("Updated successfully");
        }
    }
    
    public void deleteProfileById( String id) {
         String query = "delete from Profile where id=?";
         int addedrows = dbObj.DeleteQuery(query, id);
        if (addedrows > 0) {
            System.out.println("Deleted successfully");
        }
    }
}