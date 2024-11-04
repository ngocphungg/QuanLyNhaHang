/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class spmodel {
    String masp, tensp;
    String ngaynhap;
    String donvi;
    int soluong;
    float chiphi, tongchiphi;

    public spmodel(String masp, String tensp, String ngaynhap, String donvi, int soluong, float chiphi, float tongchiphi) {
        this.masp = masp;
        this.tensp = tensp;
        this.ngaynhap = ngaynhap;
        this.donvi = donvi;
        this.soluong = soluong;
        this.chiphi = chiphi;
        this.tongchiphi = tongchiphi;
    }

    public spmodel() {
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
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

    public float getChiphi() {
        return chiphi;
    }

    public void setChiphi(float chiphi) {
        this.chiphi = chiphi;
    }

    public float getTongchiphi() {
        return tongchiphi;
    }

    public void setTongchiphi(float tongchiphi) {
        this.tongchiphi = tongchiphi;
    }
    
}
