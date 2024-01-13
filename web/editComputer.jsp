<%-- 
    Document   : editComputer
    Created on : Jul 30, 2023, 10:58:16 AM
    Author     : navar
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="app.dao.ComputerDAO"%>
<%@page import="app.models.Computer"%>
<%@ page import="java.util.List" %>

<%
    int cid = Integer.parseInt(request.getParameter("id"));
    ComputerDAO computerDAO = new ComputerDAO();
    List<Computer> computers = computerDAO.getComputerById(cid);
%>


<!DOCTYPE html>
<html>
    <head>
        <title>Edit Computer</title>
         <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <section class="edit-product-form">
        <h1>Edit Computer</h1>
      
        <% for (Computer computer : computers) {%>

        <form action="editComputerServlet" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="<%=computer.getComputer_id()%>" />
            <!--<p><%=computer.getComputer_id()%></p>-->
            <img class="image" src= "images/<%= computer.getImage()%>" alt="Computer Image">
            <br><br>
            <label for="model">Model</label>
            <input type="text"  name="model" value="<%=computer.getModel()%>" class="box" /><br>
            <label for="processor">Processor</label>
            <input type="text" id="processor" name="processor" value="<%=computer.getProcessor()%>" class="box" /><br>
            <label for="ram">Ram</label>
            <input type="text" id="ram" name="ram" value="<%=computer.getRam()%>" class="box" /><br>
            <label for="storage">Storage</label>
            <input type="text" id="storage" name="storage" value="<%=computer.getStorage()%>" class="box" /><br>
            <label for="graphics">Graphics</label>
            <input type="text" id="graphics" name="graphics" value="<%=computer.getGraphics()%>" class="box" /><br>
            <label for="price">Price</label>
            <input type="text" id="price" name="price" value="<%=computer.getPrice()%>" class="box" /><br>
            <label for="image">Image</label>
            <input type="file" class="box" name="image" value="<%=computer.getImage()%>" accept="image/jpg, image/jpeg, image/png" /><br>
            <input type="submit" value="Update" class="home-btn">
        </form>
    
        <% }%>
        
        </div
    </section>
    </body>
</html>
