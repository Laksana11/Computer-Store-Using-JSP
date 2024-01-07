/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.dao.UserDAO;
import app.models.User;
import app.models.UserBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author navar
 */

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Retrieve user input from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Assuming you have a UserDAO class to handle database operations
        UserDAO userDAO = new UserDAO();

        // Create a new User object using the Builder pattern or any other method you prefer
        User user = new UserBuilder()
                .withUsername(username)
                .withPassword(password)
                .build();


        if (userDAO.login(user).equals("user")) {
            session.setAttribute("loggedInUser_userName", username);
            response.sendRedirect("home.jsp");
        } else if (userDAO.login(user).equals("admin")) {
            session.setAttribute("loggedInUser_userName", username);
            response.sendRedirect("admin.jsp");

        } else {
          try(PrintWriter out= response.getWriter()){
            out.println("<h1>Invalid username/password check and login again </h1>");
       }
        }

    }
}