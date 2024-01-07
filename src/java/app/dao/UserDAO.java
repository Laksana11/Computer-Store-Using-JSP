/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

/**
 *
 * @author laxsana
 */

import app.models.DBConnector;
import app.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users = new ArrayList<>();
    boolean res = false;
    String password;
    String username;
    String email;
    int userId;
   

    public void insertUser(User user) {
         try (Connection con = DBConnector.getConnection(); ) {
            String sql = "INSERT INTO users (username, role, email, password) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, user.getUsername());
                pstmt.setString(2, user.getRole());
                pstmt.setString(3, user.getEmail());
                pstmt.setString(4, user.getPassword());

                pstmt.execute();
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
         
        }
         users.add(user);
     
    }
   
   
     public void editUser(User user) {
         try (Connection con = DBConnector.getConnection(); ) {
            String sql = "UPDATE users SET username=?, email=? WHERE user_id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
             
                pstmt.setString(1, user.getUsername());
                pstmt.setString(2, user.getEmail());
                pstmt.setInt(3, user.getUserId());
               
                pstmt.execute();
                              
            }
        } catch (SQLException e) {
            e.printStackTrace();
         
        }
         users.add(user);
     
    }
     
     
     public void deleteUser(User user) {
         try (Connection con = DBConnector.getConnection(); ) {
            String sql = "DELETE FROM users WHERE user_id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, user.getUserId());
               
                pstmt.executeUpdate();
                              
            }
        } catch (SQLException e) {
            e.printStackTrace();
         
        }
         users.add(user);
     
    }
   
     
     public String login(User user){
         String role=null;
        try (Connection con = DBConnector.getConnection(); ) {
             String sql = "SELECT password, role FROM users WHERE username = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, user.getUsername());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String storedPassword = rs.getString("password");
                        role = rs.getString("role");
                     
                        if(verifyPassword(user.getPassword(), storedPassword)){
                            return role;
                        }
                       
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
         
        }
        return role;
    }
   
 public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (Connection con = DBConnector.getConnection()) {
            String sql = "SELECT * FROM users";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        int userId = rs.getInt("user_id");
                        String username = rs.getString("username");
                        String role = rs.getString("role");
                        String email = rs.getString("email");
                        String password = rs.getString("password");

                        User user = new User();
                        user.setUserId(userId);
                        user.setUsername(username);
                        user.setRole(role);
                        user.setEmail(email);
                        user.setPassword(password);

                        users.add(user);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

 public List<User> getUserById(int id) {
        List<User> users = new ArrayList<>();

        try (Connection con = DBConnector.getConnection()) {
            String sql = "SELECT * FROM users WHERE user_id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1,id);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        int userId = rs.getInt("user_id");
                        String username = rs.getString("username");
                        String email = rs.getString("email");
                        String password = rs.getString("password");

                        User user = new User();
                        user.setUserId(userId);
                        user.setUsername(username);
                        user.setEmail(email);
                        user.setPassword(password);

                        users.add(user);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
 
   
    private boolean verifyPassword(String inputPassword, String storedPassword) {
        return inputPassword.equals(storedPassword);
    }

    
    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; 
    }

   
    public boolean isEmailExists(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true; 
            }
        }
        return false; 
    }

   
    public boolean isUsernameExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true; 
            }
        }
        return false; 
    }
}

