/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BlogDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class editBlogController extends RequiredAuthentication {

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
         String id = request.getParameter("id");
        BlogDAO bd = new BlogDAO();
        Blog b = bd.selectBy(id);
        request.setAttribute("b", b);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response, User u) throws ServletException, IOException {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        BlogDAO bd = new BlogDAO();
        bd.editBlog(id, title, content);
        Blog b = bd.selectBy(id);
        int fix = 1;
        request.setAttribute("fix", fix);
        request.setAttribute("b", b);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

}
