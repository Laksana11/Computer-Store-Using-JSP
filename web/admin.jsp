<%-- 
    Document   : admin
    Created on : Jul 31, 2023, 11:06:47 PM
    Author     : laxsana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="userNav.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">

    </head>
    <body>

    <center>
        <h1 class="caption">Admin Pannel</h1>
        <div class="dec">
        <a href="manageUsers.jsp" class="box1">Manage Users</a>


        <a href="addComputer.jsp" class="box2">Add computer</a>


         <a href="computerPage.jsp" class="box3">Manage computers</a>

        </div>
    </center>
    </body>
</html>
