/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package models;

import java.math.BigDecimal;

public class Vehicle {
    private int id;
    private String vehicleName;
    private String licensePlate;
    private int status;
    private int cateId;
    private BigDecimal rentalPrice;

    public Vehicle() {
    }

    public Vehicle(int id, String vehicleName, String licensePlate, int status, int cateId, BigDecimal rentalPrice) {
        this.id = id;
        this.vehicleName = vehicleName;
        this.licensePlate = licensePlate;
        this.status = status;
        this.cateId = cateId;
        this.rentalPrice = rentalPrice;
    }

   public Vehicle( String vehicleName, String licensePlate, int status, int cateId, BigDecimal rentalPrice) {
        this.vehicleName = vehicleName;
        this.licensePlate = licensePlate;
        this.status = status;
        this.cateId = cateId;
        this.rentalPrice = rentalPrice;
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

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public BigDecimal getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(BigDecimal rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "id=" + id + ", vehicleName=" + vehicleName + ", licensePlate=" + licensePlate + ", status=" + status + ", cateId=" + cateId + ", rentalPrice=" + rentalPrice + '}';
    }
    
    
}
