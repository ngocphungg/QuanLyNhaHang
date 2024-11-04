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
public class tdmodel {
    String mamon,tenmon,loai;
    float giathanh;

    public tdmodel(String mamon, String tenmon, String loai, float giathanh) {
        this.mamon = mamon;
        this.tenmon = tenmon;
        this.loai = loai;
        this.giathanh = giathanh;
    }

    public tdmodel() {
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public float getGiathanh() {
        return giathanh;
    }

    public void setGiathanh(float giathanh) {
        this.giathanh = giathanh;
    }
    
}
