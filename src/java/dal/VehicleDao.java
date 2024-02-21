/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dal;

import dto.VehicleDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Category;
import models.Vehicle;

public class VehicleDao extends DBContext{
    PreparedStatement ps = null;
    ResultSet rs = null;


    public List<VehicleDTO> getListVehicle() throws SQLException {
        List<VehicleDTO> l = new ArrayList<>();
        String query = "SELECT v.ID, v.Name, v.LicensePlate,v.Status, c.Name,v.RentalPrice FROM Vehicles v join Categories c on c.ID = v.cateId";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                l.add(new VehicleDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getBigDecimal(6)));            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return l;
    }
    public List<VehicleDTO> getListVehicle(String sortOrder) throws SQLException {
    List<VehicleDTO> l = new ArrayList<>();
    String query = "SELECT v.ID, v.Name, v.LicensePlate, v.Status, c.Name, v.RentalPrice FROM Vehicles v join Categories c on c.ID = v.cateId";
    try {
        ps = connection.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()) {
            l.add(new VehicleDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getBigDecimal(6)));
        }
    } catch (Exception e) {
        System.out.println(e);
    }

    // Sort the list based on the Name column
    if ("desc".equalsIgnoreCase(sortOrder)) {
        Collections.sort(l, new Comparator<VehicleDTO>() {
            @Override
            public int compare(VehicleDTO v1, VehicleDTO v2) {
                return v2.getVehicleName().compareTo(v1.getVehicleName());
            }
        });
    } else {
        Collections.sort(l, new Comparator<VehicleDTO>() {
            @Override
            public int compare(VehicleDTO v1, VehicleDTO v2) {
                return v1.getVehicleName().compareTo(v2.getVehicleName());
            }
        });
    }

    return l;
}

    public List<Category> getListCategory() {
        List<Category> l = new ArrayList<>();
        String query = "SELECT * FROM Categories ";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                l.add(new Category(rs.getInt(1), rs.getString(2)));            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return l;
    }
    public boolean updateVehicle(Vehicle updatedVehicle) {
        String query = "UPDATE Vehicles SET Name=?, LicensePlate=?, Status=?, cateId=?, RentalPrice=? WHERE ID=?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, updatedVehicle.getVehicleName());
            ps.setString(2, updatedVehicle.getLicensePlate());
            ps.setInt(3, updatedVehicle.getStatus());
            ps.setInt(4, updatedVehicle.getCateId());
            ps.setBigDecimal(5, updatedVehicle.getRentalPrice());
            ps.setInt(6, updatedVehicle.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
public Vehicle getVehicleById(int vehicleId) {
    String query = "SELECT * FROM Vehicles  WHERE ID = ?";
    
    try {
        ps = connection.prepareStatement(query);
        ps.setInt(1, vehicleId);

        rs = ps.executeQuery();
        if (rs.next()) {
            return new Vehicle(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getBigDecimal(6)
            );
        }
    } catch (SQLException ex) {
        Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return null; 
}
public boolean deleteVehicleAndRelatedData(int vehicleId) {
    try {
        String deleteBookingDetailQuery = "DELETE FROM BookingDetail WHERE VehicleID = ?";
        ps = connection.prepareStatement(deleteBookingDetailQuery);
        ps.setInt(1, vehicleId);
        ps.executeUpdate();
        String deleteVehicleQuery = "DELETE FROM Vehicles WHERE ID = ?";
        ps = connection.prepareStatement(deleteVehicleQuery);
        ps.setInt(1, vehicleId);

        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException ex) {
        Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return false;
}

    public boolean addVehicle(Vehicle newVehicle) {
    String query = "INSERT INTO Vehicles (Name, LicensePlate, Status, cateId, RentalPrice) VALUES (?, ?, ?, ?, ?)";

    try {
        ps = connection.prepareStatement(query);
        ps.setString(1, newVehicle.getVehicleName());
        ps.setString(2, newVehicle.getLicensePlate());
        ps.setInt(3, newVehicle.getStatus());
        ps.setInt(4, newVehicle.getCateId());
        ps.setBigDecimal(5, newVehicle.getRentalPrice());

        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException ex) {
        Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return false;
}




}
