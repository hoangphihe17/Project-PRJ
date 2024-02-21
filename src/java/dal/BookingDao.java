/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dto.BookingDTO;
import dto.BookingDetailDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.Booking;

public class BookingDao extends DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<BookingDTO> getBookings() throws SQLException {
        List<BookingDTO> lsBookings = new ArrayList<>();
        String query = "SELECT b.ID, u.Name, b.Createat, b.Status FROM Booking b JOIN Users u ON b.UserID = u.ID";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String fullname = rs.getString(2);
                LocalDate create_at = rs.getDate(3).toLocalDate();
                boolean status = rs.getBoolean(4);

                lsBookings.add(new BookingDTO(id, fullname, create_at, status));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsBookings;
    }

  public List<BookingDetailDTO> getBookingDetails(int bookingid) throws SQLException {
        List<BookingDetailDTO> lsBookingDetails = new ArrayList<>();
        String query = "select b.ID ,v.ID, v.Name , b.RentalTime,b.quantity , b1.Status from BookingDetail b join Vehicles v on b.VehicleID = v.ID join Booking b1 on b1.ID = b.BookingID Where b.BookingID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, bookingid);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int vid = rs.getInt(2);
                String vehiclename = rs.getString(3);
                int rentalTime = rs.getInt(4);
                int quantity = rs.getInt(5);
                int status = rs.getInt(6);
                lsBookingDetails.add(new BookingDetailDTO(id, vid,vehiclename, rentalTime, quantity,status));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lsBookingDetails;
    }

    public boolean updateStatusBooking(int bookingId, int newStatus) throws SQLException {
        String updateStatusQuery = "UPDATE Booking SET Status = ? WHERE ID = ?";
        
        try {
            ps = connection.prepareStatement(updateStatusQuery);
            ps.setInt(1, newStatus);
            ps.setInt(2, bookingId);
            int rowsAffected = ps.executeUpdate();
            List<Integer> listV =  getVehicleIdsFromBooking(bookingId);
            if( rowsAffected > 0){
                for (Integer integer : listV) {
                    updateStatusVehicle(integer,newStatus);
                }
            }
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return false;
    }
     public boolean updateStatusVehicle(int vehicleid, int newStatus) throws SQLException {
        String updateStatusQuery = "UPDATE Vehicles SET Status = ? WHERE ID = ?";

        try {
            ps = connection.prepareStatement(updateStatusQuery);
            ps.setInt(1, newStatus);
            ps.setInt(2, vehicleid);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return false;
    }
    

    private List<Integer> getVehicleIdsFromBooking(int bookingId) throws SQLException {
        List<Integer> vehicleIds = new ArrayList<>();

        try {
            String query = "SELECT VehicleID FROM BookingDetail WHERE BookingID = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, bookingId);

            rs = ps.executeQuery();

            while (rs.next()) {
                int vehicleId = rs.getInt("VehicleID");
                vehicleIds.add(vehicleId);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return vehicleIds;
    }

     public boolean traxe(int vehicleid, int bd) throws SQLException {
        String updateStatusQuery = "Delete from BookingDetail  WHERE ID = ?";

        try {
            ps = connection.prepareStatement(updateStatusQuery);
            ps.setInt(1, bd);

            int rowsAffected = ps.executeUpdate();
            updateStatusVehicle(vehicleid, 0);
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return false;
    }

}
