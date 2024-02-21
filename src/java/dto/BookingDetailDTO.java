/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto;

import java.sql.Timestamp;

public class BookingDetailDTO {
    private int id;
    private int vehicleid;
    private String vehicleName;
    private int rentalTime;
    private int quantity;
    private int status;

    public BookingDetailDTO() {
    }

    public BookingDetailDTO(int id, int vehicleid, String vehicleName, int rentalTime, int quantity, int status) {
        this.id = id;
        this.vehicleid = vehicleid;
        this.vehicleName = vehicleName;
        this.rentalTime = rentalTime;
        this.quantity = quantity;
        this.status = status;
    }

    public int getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(int vehicleid) {
        this.vehicleid = vehicleid;
    }

   

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

 
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public int getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(int rentalTime) {
        this.rentalTime = rentalTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
