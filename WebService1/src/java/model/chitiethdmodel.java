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
public class chitiethdmodel {
    String tenmon;
    int idhd,soluong;
    float thanhtien;
    String theloai;

    public chitiethdmodel(int idhd, String tenmon,  int soluong, float thanhtien, String theloai) {
        this.tenmon = tenmon;
        this.idhd = idhd;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
        this.theloai = theloai;
    }

    public chitiethdmodel() {
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public int getIdhd() {
        return idhd;
    }

    public void setIdhd(int idhd) {
        this.idhd = idhd;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }
    
}
