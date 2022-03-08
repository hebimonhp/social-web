/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BlogDAO;
import dal.CommentDAO;
import dal.LikeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Blog;
import model.Comment;
import model.Like;
import model.User;

/**
 *
 * @author Admin
 */
public class showController extends RequiredAuthentication {

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
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response, User u) throws ServletException, IOException {
        int check = 0;
        LikeDAO ld = new LikeDAO();
        String id = request.getParameter("id");
        BlogDAO bd = new BlogDAO();
        CommentDAO cd = new CommentDAO();
        ArrayList<Comment> comments = cd.selectByCommentTo(id);
        ArrayList<Like> likes = ld.select();
        for (Like ll : likes) {
            if (ll.getUserID() == u.getId() && ll.getBlogID() == Integer.parseInt(id)) {
                check = 1;
            }
        }
        int count = ld.countLikes(id);
        Blog b = bd.selectBy(id);
        request.setAttribute("b", b);
        request.setAttribute("comments", comments);
        request.setAttribute("check", check);
        request.setAttribute("count", count);
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response, User u) throws ServletException, IOException {
        String commentFrom = request.getParameter("commentFrom");
        String commentTo = request.getParameter("commentTo");
        String content = request.getParameter("content");
        CommentDAO cd = new CommentDAO();
        cd.addComment(commentFrom, commentTo, content);
        response.sendRedirect("show?id=" + commentTo);
    }

}
