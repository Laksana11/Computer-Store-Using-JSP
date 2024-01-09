<%-- 
    Document   : home
    Created on : Jul 28, 2023, 2:45:40 PM
    Author     : laxsana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="app.dao.ComputerDAO"%>
<%@page import="app.models.Computer"%>
<%@ page import="java.util.List" %>
<jsp:include page="userNav.jsp" />

<%
    ComputerDAO computerDao = new ComputerDAO();
    List<Computer> computers = computerDao.getAllComputers();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/style2.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">

    </head>
    <body>

        <section class="home">

            <div class="content">
                <h3>Welcome to our Computer world</h3>
            </div>

        </section>


    <center>
        <section class="products">
            <h1 class="caption">Products</h1>
            <div class="box-container">

                <% for (Computer computer : computers) {%>
                <!--             <form action="orderComputerServlet" method="post" class="box">-->
                <div class="box">
                    <img class="image" src= "images/<%= computer.getImage()%>" alt="Computer Image">
                    <div class="name"><%= computer.getComputer_id()%></div>
                    <p><%= computer.getModel()%></p>
                    <p><%= computer.getProcessor()%></p>
                    <p>Ram : <%= computer.getRam()%> GB</p>
                    <p><%= computer.getGraphics()%></p>
                    <div class="price"> Rs <%= computer.getPrice()%> /- </div>


                    <form action="orderComputerServlet" method="post">
                        <input type="hidden" name="cid" value="<%=computer.getComputer_id()%>" />

                        <input type="hidden" name="price" value="<%=computer.getPrice()%>" />

                        <input type="hidden"  name="username" value="${loggedInUser_userName}" /><br>

                        <input type="submit" value="Order computer" class="rate-btn" >
                    </form>
                </div>


                <% }%>

            </div>
        </section>
    </center>

</body>
</html>
