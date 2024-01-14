<%-- 
    Document   : OrderComputer
    Created on : Jul 29, 2023, 2:15:31 PM
    Author     : user
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Computer</title>
    <link rel="stylesheet" type="text/css" href="css/style2.css">

</head>
<body>
    <section class="add-product">
        <h1 class="caption">Add Computer Build</h1>
    <form action="computerServlet" method="post" enctype="multipart/form-data">
        
        <label>Model : </label>
        <input type="text" name="model" class="box" placeholder="Enter model name">
        
        <br><br>
        <label>Processor:</label>
        <select name="processor" class="box" placeholder="Enter processor name">
            <option value="Intel Core i5">Intel Core i5</option>
            <option value="Intel Core i7">Intel Core i7</option>
            <option value="AMD Ryzen 5">AMD Ryzen 5</option>
            <option value="AMD Ryzen 7">AMD Ryzen 7</option>
            <!-- Add more processor options as needed -->
        </select>
        <br><br>
        
        <label>Storage:</label>
        <select name="storage" class="box" placeholder="Enter storage name">
            <option value="256GB SSD">256GB SSD</option>
            <option value="512GB SSD">512GB SSD</option>
            <option value="1TB HDD">1TB HDD</option>
            <option value="2TB HDD">2TB HDD</option>
            <!-- Add more storage options as needed -->
        </select>
     
        <br><br>

        <label>RAM (GB):</label>
        <input type="number" name="ram" min="4" max="64" step="4" class="box">
        <input type="hidden" name="username" value="${loggedInUser_userName}">
        <br><br>

        <label>Graphics:</label>
        <select name="graphics" class="box" placeholder="Enter graphics card name">
            <option value="NVIDIA GeForce GTX 1650">NVIDIA GeForce GTX 1650</option>
            <option value="NVIDIA GeForce RTX 3060">NVIDIA GeForce RTX 3060</option>
            <option value="AMD Radeon RX 5600 XT">AMD Radeon RX 5600 XT</option>
            <option value="AMD Radeon RX 6700 XT">AMD Radeon RX 6700 XT</option>
            <!-- Add more graphics options as needed -->
        </select>
        <br><br>
        
         <label>Price:</label>
        <input type="text" name="price" class="box" placeholder="Enter the Price">
        <br><br>
         <label>Choose Image (JPG/JPEG/PNG only)</label>
        <input type="file" name="image" accept="image/jpg, image/jpeg, image/png" class="box" required>
        <input type="submit" value="Submit Order" class="home-btn">
    </form>
    </section>
</body>
</html>