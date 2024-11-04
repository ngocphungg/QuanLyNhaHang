/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class DoanhThuModel {
     String ngay;
     float tongThu;
     int soLuongHoaDon;
     float trungBinhMoiBan;

    public DoanhThuModel(String ngay, float tongThu, int soLuongHoaDon, float trungBinhMoiBan) {
        this.ngay = ngay;
        this.tongThu = tongThu;
        this.soLuongHoaDon = soLuongHoaDon;
        this.trungBinhMoiBan = trungBinhMoiBan;
    }

    public DoanhThuModel() {
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public float getTongThu() {
        return tongThu;
    }

    public void setTongThu(float tongThu) {
        this.tongThu = tongThu;
    }

    public int getSoLuongHoaDon() {
        return soLuongHoaDon;
    }

    public void setSoLuongHoaDon(int soLuongHoaDon) {
        this.soLuongHoaDon = soLuongHoaDon;
    }

    public float getTrungBinhMoiBan() {
        return trungBinhMoiBan;
    }

    public void setTrungBinhMoiBan(float trungBinhMoiBan) {
        this.trungBinhMoiBan = trungBinhMoiBan;
    }
     
}
