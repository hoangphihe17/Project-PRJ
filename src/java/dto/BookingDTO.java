/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto;

import java.sql.Timestamp;
import java.time.LocalDate;

public class BookingDTO {
    private int id;
    private String fullname;
    private LocalDate create_at;
    private boolean status;

    public BookingDTO() {
    }

    public BookingDTO(int id, String fullname, LocalDate create_at, boolean status) {
        this.id = id;
        this.fullname = fullname;
        this.create_at = create_at;
        this.status = status;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDate create_at) {
        this.create_at = create_at;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

   
}

