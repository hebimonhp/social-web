/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class User {
    private int id;
    private String email,name,password;
    private ArrayList<String> comment;
    private boolean checkFollow;
    public User() {
    }

    public boolean isCheckFollow() {
        return checkFollow;
    }

    public void setCheckFollow(boolean checkFollow) {
        this.checkFollow = checkFollow;
    }

    public User(int id, String email, String name, String password, ArrayList<String> comment) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.comment = comment;
    }

    public ArrayList<String> getComment() {
        return comment;
    }

    public void setComment(ArrayList<String> comment) {
        this.comment = comment;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
