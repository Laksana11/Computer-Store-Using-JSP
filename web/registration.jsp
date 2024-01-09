<%-- 
    Document   : registration
    Created on : Jul 28, 2023, 11:42:43 AM
    Author     : laxsana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>User Registration</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>

        <div class="form">
            <form action="userServlet" method="POST" >
                <h1>User Registration</h1>
                <label for="username">Username:</label>
                <input type="text" id="username" name="username"  placeholder="enter your name" class="box" required><br>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" placeholder="enter your email" class="box" required ><br>

                <input type="hidden"  name="role" value="user" ><br>
                
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" placeholder="enter your password" class="box" required><br>

                <input type="submit" value="Register" class="home-btn">
                <p>already have an account? <a href="index.jsp">login now</a></p>
            </form>
        </div>
    </body>
</html>
