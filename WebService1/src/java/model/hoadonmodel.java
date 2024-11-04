/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;



/**
 *
 * @author admin
 */
public class hoadonmodel {
    String mahd,khuvuc,tenban;
    String gioden,giove;
    float tongtien;
    String trangthai;
    public hoadonmodel( String mahd, String khuvuc, String tenban, String gioden, String giove, float tongtien, String trangthai) {
       
        this.mahd = mahd;
        this.khuvuc = khuvuc;
        this.tenban = tenban;
        this.gioden = gioden;
        this.giove = giove;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getKhuvuc() {
        return khuvuc;
    }

    public void setKhuvuc(String khuvuc) {
        this.khuvuc = khuvuc;
    }

    public String getTenban() {
        return tenban;
    }

    public void setTenban(String tenban) {
        this.tenban = tenban;
    }

    public String getGioden() {
        return gioden;
    }

    public void setGioden(String gioden) {
        this.gioden = gioden;
    }

    public String getGiove() {
        return giove;
    }

    public void setGiove(String giove) {
        this.giove = giove;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }

   

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = "chưa thanh toán";
    }
    
}
