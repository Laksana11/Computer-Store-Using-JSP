/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

/**
 *
 * @author user
 */
import app.models.Computer;
import app.models.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputerDAO {
    private static List<Computer> computers = new ArrayList<>();
    int view=0;

    // Save the computer to the database
    public int saveComputer(Computer computer) throws SQLException {
        try (Connection con = DBConnector.getConnection(); ) {
            String sql = "INSERT INTO computer (model, processor, storage, ram, graphics, price, image) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, computer.getModel());
            pstmt.setString(2, computer.getProcessor());
            pstmt.setString(3, computer.getStorage());
            pstmt.setInt(4, computer.getRam());
            pstmt.setString(5, computer.getGraphics());
            pstmt.setDouble(6, computer.getPrice());
            pstmt.setString(7, computer.getImage());

            // Execute the insert query
            int rowsAffected = pstmt.executeUpdate();
            if(rowsAffected>0){
                view=1;
            }else{
                view=0;
            }
            
            


        } catch (SQLException ex) {
            // Handle the exception appropriately
            ex.printStackTrace();
        }
      }
        return view;
    }
    
     public List<Computer> getAllComputers() {
        List<Computer> computers = new ArrayList<>();

        try (Connection con = DBConnector.getConnection()) {
            String sql = "SELECT * FROM computer";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        int computerId = rs.getInt("computer_id");
                        String model = rs.getString("model");
                        String processor = rs.getString("processor");
                        String storage = rs.getString("storage");
                        int ram = rs.getInt("ram");
                        String graphics = rs.getString("graphics");
                        double price = rs.getDouble("price");
                        String image = rs.getString("image");

                        Computer computer = new Computer();
                        computer.setComputer_id(computerId);
                        computer.setModel(model);
                        computer.setProcessor(processor);
                        computer.setRam(ram);
                        computer.setGraphics(graphics);
                        computer.setPrice(price);
                        computer.setImage(image);

                        computers.add(computer);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return computers;
    }
     
      public List<Computer> getComputerById(int id) {
        List<Computer> computers = new ArrayList<>();

        try (Connection con = DBConnector.getConnection()) {
            String sql = "SELECT * FROM computer WHERE computer_id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1,id);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        int computerId = rs.getInt("computer_id");
                        String model = rs.getString("model");
                        String processor = rs.getString("processor");
                        int ram = rs.getInt("ram");
                        String storage = rs.getString("storage");
                        String graphics = rs.getString("graphics");
                        double price = rs.getDouble("price");
                        String image = rs.getString("image");

                        Computer computer = new Computer();
                        computer.setComputer_id(computerId);
                        computer.setModel(model);
                        computer.setProcessor(processor);
                        computer.setStorage(storage);
                        computer.setRam(ram);
                        computer.setGraphics(graphics);
                        computer.setPrice(price);
                        computer.setImage(image);

                        computers.add(computer);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return computers;
    }
      
      public void editComputerById(Computer computer) {
         try (Connection con = DBConnector.getConnection(); ) {
            String sql = "UPDATE computer SET model=?, processor=?, ram=?, storage=?, graphics=?, price=?, image=? WHERE computer_id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
              
                pstmt.setString(1, computer.getModel());
                pstmt.setString(2, computer.getProcessor());
                pstmt.setInt(3, computer.getRam());
                pstmt.setString(4, computer.getStorage());
                pstmt.setString(5, computer.getGraphics());
                pstmt.setDouble(6, computer.getPrice());
                pstmt.setString(7, computer.getImage());
                pstmt.setInt(8, computer.getComputer_id());
                
                pstmt.execute();
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
          
        }
         computers.add(computer);
     
    }
      
      public void deleteComputer(Computer computer) {
         try (Connection con = DBConnector.getConnection(); ) {
            String sql = "DELETE FROM computer WHERE computer_id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, computer.getComputer_id());
                
                pstmt.executeUpdate();
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
          
        }
         computers.add(computer);
     
    }
     
}
