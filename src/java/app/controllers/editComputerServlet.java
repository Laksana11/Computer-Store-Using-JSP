/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.dao.ComputerDAO;
import app.models.Computer;
import app.models.ComputerBuilder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author navar
 */
@WebServlet(name = "/editComputerServlet" ,urlPatterns = { "/editComputerServlet" })
  @MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class editComputerServlet extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("id"));
        String model = request.getParameter("model");
        String processor = request.getParameter("processor");
        int ram = Integer.parseInt(request.getParameter("ram"));
        String storage = request.getParameter("storage");
        String graphics = request.getParameter("graphics");
        double price = Double.parseDouble(request.getParameter("price"));
        Part imagePart = request.getPart("image");
        String imageName = extractFileName(imagePart);

    // Construct the directory path where you want to save the image
        String uploadDirectory = "../images/";
        String filePath = uploadDirectory + imageName;

        ComputerDAO computerDAO = new ComputerDAO();

        // Create a new User object using the Builder pattern or any other method you prefer
        Computer computer = new ComputerBuilder()
                .withModel(model)
                .withProcessor(processor)
                .withRam(ram)
                .withGraphics(graphics)
                .withStorage(storage)
                .withPrice(price)
                .withImage(imageName)
                .withComputerId(cid)
                .build();
 
        computerDAO.editComputerById(computer);

        response.sendRedirect("computerPage.jsp");
        
         try (InputStream inputStream = imagePart.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(filePath)) {

        // Read from the input stream and write to the output stream
        byte[] buffer = new byte[8192];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        // Optionally, you can close the streams after the operation
        inputStream.close();
        outputStream.close();

    } catch (IOException e) {
        // Handle any exceptions that may occur during file upload
        e.printStackTrace();
        // You can redirect to an error page or handle the error in any other way you prefer
        response.sendRedirect("error.jsp");
        return;
    }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
