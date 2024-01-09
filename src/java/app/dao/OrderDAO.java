/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.models.DBConnector;
import app.models.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laxsana
 */
public class OrderDAO {
    private static List<Order> orders = new ArrayList<>();
    
    public void placeOrder(Order order) {
         try (Connection con = DBConnector.getConnection(); ) {
            String sql = "INSERT INTO orders (computer_id, username, price) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, order.getComputer_id());
                pstmt.setString(2, order.getUsername());
                pstmt.setDouble(3, order.getPrice());

                pstmt.execute();
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
          
        }
         orders.add(order);
     
    }
}
