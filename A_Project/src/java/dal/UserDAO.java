/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author Admin
 */
public class UserDAO extends DBContext{

    public User selectBy(String email, String password) {
        String passwordDAO = "", nameDAO = null;
        int id = 0;
        ArrayList<String> comments = new ArrayList<>();
        try {
            String sql = "select * from Users where email = " + "'" + email + "'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                passwordDAO = rs.getString("password");
                nameDAO = rs.getString("name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (password.equals(passwordDAO) && !password.equals("")) {
            CommentDAO cd = new CommentDAO();
            comments = cd.selectBy(id);
            return new User(id, email, nameDAO, password, comments);
        } else {
            return null;
        }
    }
    
    public ArrayList<String> getEmails() {
        ArrayList<String> emails = new ArrayList<>();
        try {
            String sql = "select email from Users";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String email = rs.getString("email");
                emails.add(email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return emails;
    }
    
    public void insert(String email, String name, String password) {
        try {
            String sql = "Insert into Users(email,name,password) values(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, name);
            ps.setString(3, password);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   public User selectByID (String id) {
       User u = new User();
       try {
           String sql = "select * from users where id = " + id;
           PreparedStatement ps = connection.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           while(rs.next()) {
               u.setId(rs.getInt("id"));
               u.setEmail(rs.getString("email"));
               u.setName(rs.getString("name"));
               u.setPassword(rs.getString("password"));
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return u;
   }
   
   public ArrayList<User> searchUsers(String username) {
       ArrayList<User> users = new ArrayList<>();
       try {
           String sql = "select * from Users where name like '%"+ username + "%'";
           PreparedStatement ps = connection.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           while(rs.next()) {
               CommentDAO cd = new CommentDAO();
               int id = rs.getInt("id");
               String email = rs.getString("email");
               String name = rs.getString("name");
               String password = rs.getString("password");
               ArrayList<String> comments = cd.selectBy(id);
               User u = new User(id, email, name, password, comments);
               users.add(u);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return users;
   }
}
