package com.practice.JerseyTest.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.practice.JerseyTest.config.DatabaseConfig;
import com.practice.JerseyTest.model.Message;

public class MessageService {
	
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		DatabaseConfig dbObj=null;

      

	public List<Message> getAllMessages() {
		
		 dbObj=new DatabaseConfig();
         List<Message> Messages = new ArrayList<Message>();
         String query = "Select * from Message";
         ResultSet rs = dbObj.excuteDBQuery(query);
         Message p = null;
        
         try {
        	 while (rs.next()) {
                p = new Message();
                p.setId(rs.getString("ID"));
                p.setMessage(rs.getString("MESSAGE"));
                p.setOwner(rs.getString("OWNER"));
                p.setCreateddate(formatter.parse(rs.getString("createddate")));
               Messages.add(p);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ParseException e2) {
            e2.printStackTrace();
        }
        return Messages;
    }
    
    public Message getMessageById(String id) {
    	
		 dbObj=new DatabaseConfig();

         String query = "select * from Message where id=" + id;
         ResultSet rs = dbObj.excuteDBQuery(query);
        Message p = null;
        try {
            if (rs.next()) {
                p = new Message();
                p.setId(rs.getString("ID"));
                p.setMessage(rs.getString("MESSAGE"));
                p.setOwner(rs.getString("OWNER"));
                p.setCreateddate(formatter.parse(rs.getString("createddate")));
            }
        }
        catch (SQLException | ParseException ex2) {
           
            ex2.printStackTrace();
        }
        return p;
    }
    
    public void addMessage( Message Message) {
    	
		 dbObj=new DatabaseConfig();

         String query = "insert into Message values(?,?,?,?,?)";
         int addedrows = dbObj.excuteDBInsert(query, Message);
        if (addedrows > 0) {
            System.out.println("Added successfully");
        }
    }
    
    public void updateMessage( Message Message,  String id) {
    	
		 dbObj=new DatabaseConfig();

         String query = "update Message set profname=?,fname=?,lname=?,createddate=? where id=?";
         int addedrows = dbObj.excuteDBUpdate(query, Message);
        if (addedrows > 0) {
            System.out.println("Updated successfully");
        }
    }
    
    public void deleteMessageById( String id) {
		 dbObj=new DatabaseConfig();

         String query = "delete from Message where id=?";
         int addedrows = dbObj.DeleteQuery(query, id);
        if (addedrows > 0) {
            System.out.println("Deleted successfully");
        }
    }
}
