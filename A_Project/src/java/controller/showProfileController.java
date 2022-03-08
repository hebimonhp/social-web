/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BlogDAO;
import dal.FollowingDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Blog;
import model.User;

/**
 *
 * @author Admin
 */
public class showProfileController extends RequiredAuthentication {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response, User u) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDAO ud = new UserDAO();
        User u1 = ud.selectByID(id);
        FollowingDAO fd = new FollowingDAO();
        ArrayList<Integer> followingIDs = fd.selectFollowingID(id);
        ArrayList<User> followings = new ArrayList<>();
        for(int i = 0; i < followingIDs.size(); i++) {
            User u1l = ud.selectByID(String.valueOf(followingIDs.get(i)));
            followings.add(u1l);
        }
         BlogDAO bd = new BlogDAO();
        ArrayList<Blog> blogs = bd.getBlogs(Integer.parseInt(id));
        request.setAttribute("blogs", blogs);
        request.setAttribute("followings", followings);
        request.setAttribute("user", u1);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response, User u) throws ServletException, IOException {
    }

}
