/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Following {
    private String friendName,blogTitle;
    private int blogID;

    public Following() {
    }

    public Following(String friendName, String blogTitle, int blogID) {
        this.friendName = friendName;
        this.blogTitle = blogTitle;
        this.blogID = blogID;
    }
    
    
    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public int getBlogID() {
        return blogID;
    }

    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }

    
    
    
}
