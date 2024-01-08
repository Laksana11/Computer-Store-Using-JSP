<%-- 
    Document   : login
    Created on : Jul 28, 2023, 2:45:51 PM
    Author     : navar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
     <div class="form">
   
    <form action="loginServlet" method="POST">
         <h1>User Login</h1>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" placeholder="enter your name" class="box" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" placeholder="enter your password" class="box" required><br>

        <input type="submit" value="Login" class="home-btn">
        <p>Create an Account ? <a href="registration.jsp">Register now</a></p>
    </form>
    </div>
</body>
</html>