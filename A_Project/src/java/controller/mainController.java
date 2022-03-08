/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BlogDAO;
import dal.FollowingDAO;
import dal.LikeDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Blog;
import model.Following;
import model.User;

/**
 *
 * @author Admin
 */
public class mainController extends RequiredAuthentication {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @param u
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

   
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response, User u) throws ServletException, IOException {
        BlogDAO bd = new BlogDAO();
        ArrayList<Blog> myBlogs = bd.getBlogs(u.getId());
        FollowingDAO fd = new FollowingDAO();
        ArrayList<Following> followings = fd.select(String.valueOf(u.getId()));
        request.setAttribute("followings", followings);
        request.setAttribute("myBlogs", myBlogs);
        request.setAttribute("user", u);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response, User u) throws ServletException, IOException {
        BlogDAO bd = new BlogDAO();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        ArrayList<Blog> blogs = bd.select();
        Blog b = new Blog(blogs.size()+1, title, content, 0, u.getId());
        bd.insert(b);
        response.sendRedirect("main");
    }

}
