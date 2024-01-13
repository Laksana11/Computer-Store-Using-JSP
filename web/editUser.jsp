<%-- 
    Document   : editUser
    Created on : Jul 29, 2023, 2:12:15 PM
    Author     : navar
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="app.dao.UserDAO"%>
<%@page import="app.models.User"%>
<%@ page import="java.util.List" %>

<%
    int uid = Integer.parseInt(request.getParameter("id"));
    UserDAO userDao = new UserDAO();
    List<User> users = userDao.getUserById(uid);
%>


<!DOCTYPE html>
<html>
    <head>
        <title>Edit User</title>
        <link rel="stylesheet" type="text/css" href="css/style2.css">
    </head>
    <body>
    <center>
        <section class="edit-product-form">
        <h1 class="caption">Edit User</h1>
        <% for (User user : users) {%>
        <form action="userEditServlet" method="post">
            
            <input type="hidden" name="id" value="<%=user.getUserId()%>" />
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="<%=user.getUsername()%>" class="box" /><br>
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" value="<%=user.getEmail()%>" class="box" /><br>
            <input type="submit" value="Update" class="home-btn">
            
        </form>
        <% }%>
        </table>
         </section>
</center>
    </body>
</html>
