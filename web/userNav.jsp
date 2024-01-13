<%-- 
    Document   : userNav
    Created on : Jul 31, 2023, 9:21:13 PM
    Author     : laxsana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            .btn {
                border: none;
                outline: none;
                padding: 10px 16px;
                color:#ffffff;
                background-color:  #0059b3;
                cursor: pointer;
                font-size: 18px;
            }

            /* Style the active class, and buttons on mouse-over */
            .active, .btn:hover {
                background-color: #666;
                color: white;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style2.css">
    </head>
    <body>
        <div class="head" id="myDIV">
             <div id="user-btn" class="fas fa-user-circle ">
               <span class="user">
                   ${loggedInUser_userName}
               </span>
               <a href="logoutservlet" id="log" class="rate-btn">logout</a>
            </div>
               
        </div>
            
                 
       


        <script>
// Add active class to the current button (highlight it)
            var header = document.getElementById("myDIV");
            var btns = header.getElementsByClassName("btn");
            for (var i = 0; i < btns.length; i++) {
                btns[i].addEventListener("click", function () {
                    var current = document.getElementsByClassName("active");
                    current[0].className = current[0].className.replace(" active", "");
                    this.className += " active";
                });
            }
        </script>
    </body>
</html>