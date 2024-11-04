/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class NhanVienModel implements Serializable{
    public String Hoten,Gioitinh,Chucvu,Sdt,Quequan;
    public String Manv;

    public NhanVienModel(String Manv,String Hoten, String Gioitinh, String Chucvu, String Sdt, String Quequan) {
        this.Hoten = Hoten;
        this.Gioitinh = Gioitinh;
        this.Chucvu = Chucvu;
        this.Sdt = Sdt;
        this.Quequan = Quequan;
        this.Manv = Manv;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getChucvu() {
        return Chucvu;
    }

    public void setChucvu(String Chucvu) {
        this.Chucvu = Chucvu;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getQuequan() {
        return Quequan;
    }

    public void setQuequan(String Quequan) {
        this.Quequan = Quequan;
    }

    public String getManv() {
        return Manv;
    }

    public void setManv(String Manv) {
        this.Manv = Manv;
    }

    
//
//    public void reset() {
//        this.Manv="";
//        this.Hoten="";
//        this.Gioitinh="";
//        this.Chucvu="";
//        this.Sdt="";
//        this.Quequan="";
//    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    

    
    
    
        
}
