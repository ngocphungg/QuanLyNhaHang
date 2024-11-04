/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ptbic
 */
public class dtngaymodel {
     int ngay, thang, nam, tientheongay;
//    public int id;

    public dtngaymodel(int nam, int thang, int ngay, int tientheongay) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
        this.tientheongay = tientheongay;
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getTientheongay() {
        return tientheongay;
    }

    public void setTientheongay(int tientheongay) {
        this.tientheongay = tientheongay;
    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
    
}
