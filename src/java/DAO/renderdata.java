/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Nguyen Khanh
 */
public class renderdata {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getToan() {
        return toan;
    }

    public void setToan(String toan) {
        this.toan = toan;
    }

    public String getVan() {
        return van;
    }

    public void setVan(String van) {
        this.van = van;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public renderdata(int id, String hoten, String email, String diachi, String toan, String van, String anh) {
        this.id = id;
        this.hoten = hoten;
        this.email = email;
        this.diachi = diachi;
        this.toan = toan;
        this.van = van;
        this.anh = anh;
    }

   public int id;
   public String hoten;
   public String email;
   public String diachi;
   public String toan;
   public String van;   
   public String anh;    
}
