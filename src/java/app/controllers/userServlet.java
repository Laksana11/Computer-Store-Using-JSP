/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

/**
 *
 * @author navar
 */
// userServlet.java (Servlet to handle user registration)
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

@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session= request.getSession();
       
    
        String username = request.getParameter("username");
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

 
        UserDAO userDAO = new UserDAO();

    
        User user = new UserBuilder()
                .withUsername(username)
                .withRole(role)
                .withEmail(email)
                .withPassword(password)
                .build();

       
        userDAO.insertUser(user);

        try(PrintWriter out= response.getWriter()){
            out.println("<h1>Your account registred successfully </h1>");
       }
    }
}
