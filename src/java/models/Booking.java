/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package models;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Booking {
  private int id;
    private int userId;
    private LocalDate create_at;
    private boolean status;

    public Booking() {
    }

    public Booking(int id, int userId, LocalDate create_at, boolean status) {
        this.id = id;
        this.userId = userId;
        this.create_at = create_at;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "Booking{" + "id=" + id + ", userId=" + userId + ", create_at=" + create_at + ", status=" + status + '}';
    }
    
}
