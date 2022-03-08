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
import model.Comment;

/**
 *
 * @author Admin
 */
public class CommentDAO extends DBContext {

    public ArrayList<String> selectBy(int commentFromID) {
        ArrayList<String> comments = new ArrayList<>();
        try {
            String sql = "select commentContent from Comment inner join Users on Users.id = Comment.commentFrom\n"
                    + "where Comment.commentFrom = " + commentFromID;
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String comment = rs.getString("commentContent");
                comments.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    public void delete(String idCommentTo) {
        try {
            String sql = "delete from Comment where commentTo = " + idCommentTo;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Comment> selectByCommentTo(String id) {
        ArrayList<Comment> comments = new ArrayList<>();
        try {
            String sql = "select Users.name, comment.commentContent\n"
                    + "from Users inner join comment \n"
                    + "on Users.id = comment.commentFrom\n"
                    + "where commentTo = " + id;
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String content = rs.getString("commentContent");
                Comment c = new Comment(name, content);
                comments.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    public void addComment(String from, String to, String content) {
        try {
            String sql = "insert into Comment(commentFrom,commentTo,commentContent)\n"
                    + "values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, from);
            ps.setString(2, to);
            ps.setString(3, content);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
