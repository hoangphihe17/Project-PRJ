/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package models;

import java.sql.Timestamp;

public class BookingDetail {
    private int id;
    private int bookingID;
    private int vehicleID;
    private int quantity;
    private int rentalTime;

    public BookingDetail() {
    }

    public BookingDetail(int id, int bookingID, int vehicleID, int quantity, int rentalTime) {
        this.id = id;
        this.bookingID = bookingID;
        this.vehicleID = vehicleID;
        this.quantity = quantity;
        this.rentalTime = rentalTime;
    }

   
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(int rentalTime) {
        this.rentalTime = rentalTime;
    }

    @Override
    public String toString() {
        return "BookingDetail{" + "id=" + id + ", bookingID=" + bookingID + ", vehicleID=" + vehicleID + ", rentalTime=" + rentalTime + '}';
    }
    
}
