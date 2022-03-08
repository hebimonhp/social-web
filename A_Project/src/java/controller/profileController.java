/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.FollowingDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Following;
import model.User;

/**
 *
 * @author Admin
 */
public class profileController extends RequiredAuthentication{

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
        FollowingDAO fd = new FollowingDAO();
        UserDAO ud = new UserDAO();
        ArrayList<Integer> followingIDs = fd.selectFollowingID(String.valueOf(u.getId()));
        ArrayList<User> followings = new ArrayList<>();
        for(int i = 0; i < followingIDs.size(); i++) {
            User u1 = ud.selectByID(String.valueOf(followingIDs.get(i)));
            followings.add(u1);
        }
        request.setAttribute("followings", followings);
        request.setAttribute("name", u.getName());
        request.setAttribute("email", u.getEmail());
        request.setAttribute("password", u.getPassword());
        request.getRequestDispatcher("myprofile.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response, User u) throws ServletException, IOException {
        
    }
}
