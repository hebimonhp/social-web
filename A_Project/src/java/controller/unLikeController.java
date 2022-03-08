/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BlogDAO;
import dal.LikeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Admin
 */
public class unLikeController extends RequiredAuthentication {

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
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response, User u) throws ServletException, IOException {
        String id = request.getParameter("id");
        LikeDAO ld = new LikeDAO();
        ld.removeLike(String.valueOf(u.getId()), id);
        response.sendRedirect("show?id=" + id);
    }

}
