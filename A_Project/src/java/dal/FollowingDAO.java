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
import model.Following;

/**
 *
 * @author Admin
 */
public class FollowingDAO extends DBContext {

    public ArrayList<Following> select(String idMe) {
        ArrayList<Following> followings = new ArrayList<>();
        try {
            String sql = "select Users.name, Blog.title, Blog.id\n"
                    + "from Friends inner join Users on Friends.friend = Users.id\n"
                    + "inner join Blog on Users.id = Blog.creator\n"
                    + "where Friends.me = " + idMe;
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String friendName = rs.getString("name");
                String title = rs.getString("title");
                int blogID = rs.getInt("id");
                Following f = new Following(friendName, title, blogID);
                followings.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return followings;
    }

    public ArrayList<Integer> selectFollowingID(String idMe) {
        ArrayList<Integer> followingIDs = new ArrayList<>();
        try {
            String sql = "select Friends.friend from Friends where me = " + idMe;
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int friend = rs.getInt("friend");
                followingIDs.add(friend);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return followingIDs;
    }

    public void deleteFolowwing(String meID, String friendID) {
        try {
            String sql = "delete from friends where me = ? and friend = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, meID);
            ps.setString(2, friendID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertFollowing(String meID, String friendID) {
        try {
            String sql = "insert into Friends(me, friend)\n"
                    + "values (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, meID);
            ps.setString(2, friendID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
