/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.chitiethdconnect;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.chitiethdmodel;

/**
 *
 * @author admin
 */
@WebService(serviceName = "chitiethd_ws")
public class chitiethd_ws {
    chitiethdconnect ct=new chitiethdconnect();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "countOrderDetails")
    public int countOrderDetails(@WebParam(name="idhoadon") int idhoadon) {
        //TODO write your implementation code here:
        return ct.countOrderDetails(idhoadon);
    }
//
//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "deleteChiTietHD")
    @Oneway
    public void deleteChiTietHD(@WebParam(name="idhoadon") int idhoadon,
            @WebParam(name="tenmon") String tenmon) {
        ct.deleteChiTietHD(idhoadon, tenmon);
    }
//
//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "checkIfItemExistsInOrder")
    public boolean checkIfItemExistsInOrder(@WebParam(name="idhoadon") int idhoadon,
            @WebParam(name="tenmon") String tenmon) {
        //TODO write your implementation code here:
        return ct.checkIfItemExistsInOrder(idhoadon, tenmon);
    }
//
//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "updateExistingItemInOrder")
    @Oneway
    public void updateExistingItemInOrder(@WebParam(name="idhoadon") int idhoadon,
            @WebParam(name="tenmon") String tenmon,
            @WebParam(name="soluong") int soluong,
            @WebParam(name="thanhtien") float thanhtien,
            @WebParam(name="loaiMon") String loaiMon) {
        ct.updateExistingItemInOrder(idhoadon, tenmon, soluong, thanhtien, loaiMon);
    }

//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "addChitiethdAndUpdateTongtien")
    @Oneway
    public void addChitiethdAndUpdateTongtien(@WebParam(name="idhoadon") int idhoadon,
            @WebParam(name="tenmon") String tenmon,
            @WebParam(name="soluong") int soluong,
            @WebParam(name="thanhtien") float thanhtien,
            @WebParam(name="loaiMon") String loaiMon) {
        ct.addChitiethdAndUpdateTongtien(idhoadon, tenmon, soluong, thanhtien, loaiMon);
    }
//
//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "calculateTotalAmount")
    public float calculateTotalAmount(@WebParam(name="idhoadon") int idhoadon) {
        //TODO write your implementation code here:
        return ct.calculateTotalAmount(idhoadon);
    }



    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCT")
    public List<chitiethdmodel> getCT() {
        //TODO write your implementation code here:
        return ct.getCT();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteCTHD")
    @Oneway
    public void deleteCTHD(@WebParam(name = "idhoadon") int idhoadon) {
        ct.deleteCTHD(idhoadon);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTableDetailsFromChitiethd")
    public List<chitiethdmodel> getTableDetailsFromChitiethd(@WebParam(name = "idhoadon") int idhoadon) {
        //TODO write your implementation code here:
        return ct.getTableDetailsFromChitiethd(idhoadon);
    }
    
    
   
}
