/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.Computer;
import app.models.Computer;
import app.models.ComputerBuilder;
import app.models.ComputerBuilder;
import app.dao.ComputerDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part; 
/**
 *
 * @author user
 */
@WebServlet(name = "/computerServlet", urlPatterns = { "/computerServlet" })
  @MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)

public class computerServlet extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
        private String extractFileName(Part part) {
            String contentDispositionHeader = part.getHeader("content-disposition");
            String[] elements = contentDispositionHeader.split(";");

            for (String element : elements) {
                if (element.trim().startsWith("filename")) {
                    String fileName = element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
                    // Extract only the filename without the path
                    String[] nameParts = fileName.split("[\\\\/]");
                    String extractedFileName = nameParts[nameParts.length - 1];
                    return extractedFileName;
                }
            }
            return null;
        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        boolean success;
        // Retrieve user input from the form
        String model = request.getParameter("model");
        String processor = request.getParameter("processor");
        int ram = Integer.parseInt(request.getParameter("ram"));
        String graphics = request.getParameter("graphics");
        String storage = request.getParameter("storage");
        double price = Double.parseDouble(request.getParameter("price"));
        Part imagePart = request.getPart("image");
        String imageName = extractFileName(imagePart);

    // Construct the directory path where you want to save the image
       String uploadDirectory = "web" + File.separator + "images";
String userHomeDirectory = System.getProperty("user.home");
String documentsDirectory = userHomeDirectory + File.separator + "Documents";
String projectDirectory = documentsDirectory + File.separator + "NetBeansProjects";
String filePath = projectDirectory + File.separator + "builder" + File.separator + uploadDirectory + File.separator + imageName;
      try(PrintWriter out= response.getWriter()){
            out.println("<h1>"+filePath+"</h1>");
       }
        // Assuming you have a ComputerDAO class to handle database operations
        ComputerDAO computerDAO = new ComputerDAO();

        // Create a new Computer object using the Builder pattern
        Computer computer = new ComputerBuilder()
                .withModel(model)
                .withProcessor(processor)
                .withRam(ram)
                .withGraphics(graphics)
                .withStorage(storage)
                .withPrice(price)
                .withImage(imageName)
                .build();
  
        try {
            // Call the method to insert the computer into the database
            if (computerDAO.saveComputer(computer) > 0) {
               try(PrintWriter out= response.getWriter()){
            out.println("<h1>Successfully Stored</h1>");
       }
            } else {
                 try(PrintWriter out= response.getWriter()){
            out.println("<h1>Failed</h1>");
       }
            }
        } catch (SQLException ex) {
            Logger.getLogger(computerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try (InputStream inputStream = imagePart.getInputStream()) {
    Files.copy(inputStream, Paths.get(filePath));
} catch (IOException e) {
    // Handle the exception if something goes wrong
    e.printStackTrace();
}

    }
    
}
//C:\Users\laxsana\Documents\NetBeansProjects\builder\web\images\img4.jpg
//C:\Users\laxsana\Documents\NetBeansProject\builder-20230730T123343Z-001\builder\web\images\wp3645674.jpg