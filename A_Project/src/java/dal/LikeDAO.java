/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Like;

/**
 *
 * @author Admin
 */
public class LikeDAO extends DBContext {

    public void addLike(String userID, String blogID) {
        try {
            String sql = "insert into likes(userID,blogID) values(?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, blogID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Like> select() {
        ArrayList<Like> likes = new ArrayList<>();
        try {
            String sql = "select * from likes";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt("userID");
                int blogID = rs.getInt("blogID");
                Like l = new Like(userID, blogID);
                likes.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return likes;
    }

    public void removeLike(String userID, String blogID) {
        try {
            String sql = "delete from likes where userID = ? and blogID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, blogID);
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int countLikes(String blogID) {
        int result = 0;
        try {
            String sql = "select count(userID) as count\n"
                    + "from likes\n"
                    + "where blogID = " + blogID;
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result = rs.getInt("count");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
