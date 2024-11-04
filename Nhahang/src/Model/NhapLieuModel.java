/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author admin
 */
public class NhapLieuModel {
    public int masp;
    public String tensp;
    public Date ngaynhap;
    public String donvi;
    public int soluong;
    public Double chiphi,tongchiphi;

    public NhapLieuModel(int masp, String tensp, Date ngaynhap, String donvi, int soluong, Double chiphi, Double tongchiphi) {
        this.masp = masp;
        this.tensp = tensp;
        this.ngaynhap = ngaynhap;
        this.donvi = donvi;
        this.soluong = soluong;
        this.chiphi = chiphi;
        this.tongchiphi = tongchiphi;
    }

  

   

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public Date getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Double getChiphi() {
        return chiphi;
    }

    public void setChiphi(Double chiphi) {
        this.chiphi = chiphi;
    }

    public Double getTongchiphi() {
        return tongchiphi;
    }

    public void setTongchiphi(Double tongchiphi) {
        this.tongchiphi = tongchiphi;
    }
   

    
    
}
