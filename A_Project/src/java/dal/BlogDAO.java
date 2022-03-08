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
import model.Blog;

/**
 *
 * @author Admin
 */
public class BlogDAO extends DBContext {

    public ArrayList<Blog> getBlogs(int idCreator) {
        ArrayList<Blog> blogs = new ArrayList<>();
        try {
            String sql = "select Blog.* from Blog \n"
                    + "join Users on Blog.creator = Users.id\n"
                    + "where Users.id = " + idCreator
                    + " order by id desc";

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int creator = rs.getInt("creator");
                String title = rs.getString("title");
                String content = rs.getString("content");
                int likes = rs.getInt("likes");
                Blog b = new Blog(id, title, content, likes, creator);
                blogs.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blogs;
    }

    public ArrayList<Blog> select() {
        ArrayList<Blog> blogs = new ArrayList<>();
        try {
            String sql = "select * from Blog";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int creator = rs.getInt("creator");
                String title = rs.getString("title");
                String content = rs.getString("content");
                int likes = rs.getInt("likes");
                Blog b = new Blog(id, title, content, likes, creator);
                blogs.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blogs;
    }

    public void insert(Blog b) {
        try {
            String sql = "insert into blog(creator,title,content,likes) values(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, String.valueOf(b.getCreator()));
            ps.setString(2, b.getTitle());
            ps.setString(3, b.getContent());
            ps.setString(4, String.valueOf(b.getLikes()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            String sql = "delete from Blog where id = " + id;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Blog selectBy(String blogID) {
        Blog b = new Blog();
        try {
            String sql = "select * from Blog where id = " + blogID;
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                b.setId(Integer.parseInt(blogID));
                b.setCreator(rs.getInt("creator"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));
                b.setLikes(rs.getInt("likes"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public void editBlog(String id, String title, String content) {
        try {
            String sql = "update Blog\n"
                    + "set title = ?, content = ?\n"
                    + "where id = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setString(3, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateLike(String id) {
        try {
            String sql = "update Blog\n"
                    + "set likes = likes + 1\n"
                    + "where id = " + id;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteLike(String id) {
        try {
            String sql = "update Blog\n"
                    + "set likes = likes - 1\n"
                    + "where id = " + id;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
