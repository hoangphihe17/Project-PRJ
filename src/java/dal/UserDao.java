/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.User;

public class UserDao extends DBContext{
 PreparedStatement ps = null;
    ResultSet rs = null;


    public User login(String uname, String psw) throws SQLException {
        String query = "select * from Users where Username =? and Password = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, psw);
            rs = ps.executeQuery();
            while (rs.next()) {
               return (new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getBoolean(7)));            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
     public boolean editUserProfile(User updatedUser) {
        String query = "UPDATE Users SET Name=?, Email=?, Address=? WHERE ID=?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, updatedUser.getFullname());
            ps.setString(2, updatedUser.getEmail());
            ps.setString(3, updatedUser.getAddress());
            ps.setInt(4, updatedUser.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        return false;
    }
     public boolean createUser(User newUser) {
    String query = "INSERT INTO Users (Username, Password, Name, Email, Address, Role) VALUES (?, ?, ?, ?, ?, 1)";
    
    try {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, newUser.getUsername());
        ps.setString(2, newUser.getPassword());
        ps.setString(3, newUser.getFullname());
        ps.setString(4, newUser.getEmail());
        ps.setString(5, newUser.getAddress());

        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException ex) {
        System.out.println(ex);
    }
    return false;
}

}
