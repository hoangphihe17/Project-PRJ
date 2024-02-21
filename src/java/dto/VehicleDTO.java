/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto;

import java.math.BigDecimal;

public class VehicleDTO {
    private int id;
    private String vehicleName;
    private String licensePlate;
    private int status;
    private String cateName;
    private BigDecimal rentalPrice;

    public VehicleDTO() {
    }

    public VehicleDTO(int id, String vehicleName, String licensePlate, int status, String cateName, BigDecimal rentalPrice) {
        this.id = id;
        this.vehicleName = vehicleName;
        this.licensePlate = licensePlate;
        this.status = status;
        this.cateName = cateName;
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

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public BigDecimal getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(BigDecimal rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    
    
}
