<%-- 
    Document   : computerPage
    Created on : Jul 30, 2023, 10:30:49 AM
    Author     : laxsana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="app.dao.ComputerDAO"%>
<%@page import="app.models.Computer"%>
<%@ page import="java.util.List" %>

<%
    ComputerDAO computerDao = new ComputerDAO();
    List<Computer> computers = computerDao.getAllComputers();
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Computer Details</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">

    </head>
    <body>
        <section class="show-products">
        <h1 class="caption">Computer Details</h1>
         <div class="box-container">
            <% for (Computer computer : computers) {%>
              <div class="box">
               <img class="image" src="images/<%= computer.getImage()%>" alt="Computer Image" >
               <div class="name"><%= computer.getComputer_id()%></div>
               <div class="name">  <%= computer.getModel()%></div>
               <div class="name"> <%= computer.getProcessor()%></div>
               <div class="name"> Ram :  <%= computer.getRam()%> GB</div>
               <div class="name">  <%= computer.getGraphics()%></div>
              <div class="price"><%= computer.getPrice()%></div>
              
             
                    <a href="editComputer.jsp?id=<%= computer.getComputer_id()%>"  class="rate-btn" >Edit</a>
                    <a href="deleteComputerServlet?id=<%= computer.getComputer_id()%>" class="delete-btn">Delete</a>
               
            </div>
            <% }%>
         </div>
        </Section>
    </body>
</html>

