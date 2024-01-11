<%-- 
    Document   : manageUsers
    Created on : Jul 28, 2023, 4:07:03 PM
    Author     : navar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="app.dao.UserDAO"%>
<%@page import="app.models.User"%>
<%@ page import="java.util.List" %>

<%
    UserDAO userDao = new UserDAO();
    List<User> users = userDao.getAllUsers();
%>

<!DOCTYPE html>
<html>
    <head>
        <title>User Details</title>
         <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        
    <center>
        <h1 class="caption">User Details</h1>
        <div class="box-container">
            <table>
                <tr>
                    <th>User Id</th>
                    <th>Username</th>
                    <th>email</th>
                    <th>manage</th>
                </tr>
                <% for (User user : users) {%>
                <tr>
                    <td><%= user.getUserId()%></td>
                    <td><%= user.getUsername()%></td>
                    <td><%= user.getEmail()%></td>

                    <td>
                        <a href="editUser.jsp?id=<%= user.getUserId()%>" class="rate-btn">Edit</a>
                        <a href="deleteUserServlet?id=<%= user.getUserId()%>" class="delete-btn">Delete</a>
                    </td>
                </tr>
                <% }%>
            </table>
        </div>
    </center>

</body>
</html>


