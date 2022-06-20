
package com.practice.JerseyTest.config;

import com.practice.JerseyTest.model.Profile;
import java.sql.PreparedStatement;
import java.util.Date;
import com.practice.JerseyTest.model.Message;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.text.SimpleDateFormat;

public class DatabaseConfig
{
   

		SimpleDateFormat formatter =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
     	String strDate = formatter.format(new Date());

    
    public Connection createCon() 
    {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    
    public void CloseConnection( Connection con) throws SQLException 
    {
        con.close();
    }
    
    public ResultSet excuteDBQuery(String query) 
    {
        ResultSet rs = null;
        Connection con = createCon();
        if (con != null) {
            try {
                 Statement st = con.createStatement();
                rs = st.executeQuery(query);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
    
    public int excuteDBUpdate( String query,  Message message) {
     
        int affectedrows = 0;
        try {
            System.out.println("query " + query);
             Connection con = createCon();
            if (con != null) {
                 PreparedStatement ps = con.prepareStatement(query);
                ps.setString(4, message.getId());
                ps.setString(1, message.getMessage());
                ps.setString(2, strDate);
                ps.setString(3, message.getOwner());
                affectedrows = ps.executeUpdate();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedrows;
    }
    
    public int excuteDBInsert( String query,  Message message) {
       
        int affectedrows = 0;
        try {
            System.out.println("query " + query);
             Connection con = createCon();
            if (con != null) {
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, message.getId());
                ps.setString(2, message.getMessage());
                ps.setString(3, strDate);
                ps.setString(4, message.getOwner());
                affectedrows = ps.executeUpdate();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedrows;
    }
    
    public int DeleteQuery( String query,  String id) {
        int affectedrows = 0;
        try {
            System.out.println("query " + query);
             Connection con = createCon();
            if (con != null) {
                 PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, id);
                affectedrows = ps.executeUpdate();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedrows;
    }
    
    public int excuteDBInsert( String query,  Profile profile) {

        int affectedrows = 0;
        try {
            System.out.println("query " + query);
             Connection con = createCon();
            if (con != null) {
                 PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, profile.getId());
                ps.setString(2, profile.getProfileName());
                ps.setString(3, profile.getFirstname());
                ps.setString(4, profile.getLastname());
                ps.setString(5, strDate);
                affectedrows = ps.executeUpdate();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedrows;
    }
    
    public int excuteDBUpdate( String query,  Profile profile) {
     
        int affectedrows = 0;
        try {
            System.out.println("query " + query);
             Connection con = createCon();
            if (con != null) {
                 PreparedStatement ps = con.prepareStatement(query);
                ps.setString(5, profile.getId());
                ps.setString(1, profile.getProfileName());
                ps.setString(2, profile.getFirstname());
                ps.setString(3, profile.getLastname());
                ps.setString(4, strDate);
                affectedrows = ps.executeUpdate();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedrows;
    }
}

