/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class ThucDonModel {
   public String idmon,theloai,tenmon;
   public float dongia;

    public ThucDonModel(String idmon, String theloai, String tenmon, float dongia) {
        this.idmon = idmon;
        this.theloai = theloai;
        this.tenmon = tenmon;
        this.dongia = dongia;
    }

    public String getIdmon() {
        return idmon;
    }

    public void setIdmon(String idmon) {
        this.idmon = idmon;
    }

    public String gettheloai() {
        return theloai;
    }

    public void settheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }
   
}
