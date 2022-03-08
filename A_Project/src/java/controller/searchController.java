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
import model.User;

/**
 *
 * @author Admin
 */
public class searchController extends RequiredAuthentication{

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
        
        String username = request.getParameter("search");
        UserDAO ud = new UserDAO();
        FollowingDAO fd = new FollowingDAO();
        ArrayList<Integer> followingIDS = fd.selectFollowingID(String.valueOf(u.getId()));
        ArrayList<User> users = ud.searchUsers(username);
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < followingIDS.size(); j++) {
                if (followingIDS.get(j) == users.get(i).getId()) {
                    users.get(i).setCheckFollow(true);
                    break;
                }
            }
        }
        request.setAttribute("searchName", username);
        request.setAttribute("users", users);
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response, User u) throws ServletException, IOException {
    }

}
