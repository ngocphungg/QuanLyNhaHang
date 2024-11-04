/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.hoadonconnect;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.DoanhThuModel;
import model.hd1;
import model.hoadonmodel;

/**
 *
 * @author admin
 */
@WebService(serviceName = "hoadon_ws")
public class hoadon_ws {
    hoadonconnect hd=new hoadonconnect();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getHoadon")
    public List<hoadonmodel> getHoadon() {
        //TODO write your implementation code here:
        return hd.getHoadon();
    }

    @WebMethod(operationName = "getCurrentHoadonID")
    public int getCurrentHoadonID(@WebParam(name="tenban") String tenban,
            @WebParam(name="khuVuc") String khuVuc,
            @WebParam(name="trangthai") String trangthai) {
        //TODO write your implementation code here:
        return hd.getCurrentHoadonID(tenban, khuVuc, trangthai);
    }

////
//    @WebMethod(operationName = "getGioDen")
//    public Timestamp getGioDen(@WebParam(name="idhoadon") int idhoadon) {
//        //TODO write your implementation code here:
//        return hd.getGioDen(idhoadon);
//    }
//    
//
//    /**
//     * Web service operation
//     */
//    @WebMethod(operationName = "getGioVe")
//    public Timestamp getGioVe(@WebParam(name="idhoadon") int idhoadon) {
//        //TODO write your implementation code here:
//        return hd.getGioVe(idhoadon);
//    }
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updatePaymentHoadon")
    @Oneway
    public void updatePaymentHoadon(@WebParam(name="idhoadon") int idhoadon) {
        hd.updatePaymentHoadon(idhoadon);
    }


    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllHoadonIDs")
    public ArrayList<Integer> getAllHoadonIDs(@WebParam(name="tenban") String tenban,
            @WebParam(name="khuVuc") String khuVuc) {
        //TODO write your implementation code here:
        return hd.getAllHoadonIDs(tenban, khuVuc);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getHoadonStatus")
    public String getHoadonStatus(@WebParam(name="idhoadon") int idhoadon) {
        //TODO write your implementation code here:
        return hd.getHoadonStatus(idhoadon);
    }


    @WebMethod(operationName = "updateTotalAmount")
    @Oneway
    public void updateTotalAmount(@WebParam(name="idhoadon") int idhoadon,
            @WebParam(name="totalAmount") float totalAmount) {
        hd.updateTotalAmount(idhoadon, totalAmount);
    }

    

    @WebMethod(operationName = "getTongTienByIdHoadon")
    public float getTongTienByIdHoadon(@WebParam(name="idhoadon") int idhoadon) {
        //TODO write your implementation code here:
        return hd.getTongTienByIdHoadon(idhoadon);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUnpaidHoadonID")
    public float getUnpaidHoadonID(@WebParam(name="tenban") String tenban,
            @WebParam(name="khuVuc") String khuVuc) {
        //TODO write your implementation code here:
        return hd.getUnpaidHoadonID(tenban, khuVuc);
    }

    @WebMethod(operationName = "deleteHoadon")
    @Oneway
    public void deleteHoadon(@WebParam(name="idhoadon") int idhoadon) {
        hd.deleteHoadon(idhoadon);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getIdhoadonsTheoNgayTang")
    public List<DoanhThuModel> getIdhoadonsTheoNgayTang(@WebParam(name="dayfrom") String dayfrom,
            @WebParam(name="monthfrom") String monthfrom,
            @WebParam(name="yearfrom") String yearfrom,
            @WebParam(name="dayto") String dayto,
            @WebParam(name="monthto") String monthto,
            @WebParam(name="yearto") String yearto) {
        return hd.getIdhoadonsTheoNgayTang(dayfrom, monthfrom, yearfrom, dayto, monthto, yearto);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllDoanhThuNgayTang")
    public List<DoanhThuModel> getAllDoanhThuNgayTang() {
        return hd.getAllDoanhThuNgayTang();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllDoanhThuNgay")
    public List<DoanhThuModel> getAllDoanhThuNgay() {
        return hd.getAllDoanhThuNgay();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getIdhoadonsTheoNgay")
    public List<DoanhThuModel> getIdhoadonsTheoNgay(@WebParam(name="dayfrom") String dayfrom,
            @WebParam(name="monthfrom") String monthfrom,
            @WebParam(name="yearfrom") String yearfrom,
            @WebParam(name="dayto") String dayto,
            @WebParam(name="monthto") String monthto,
            @WebParam(name="yearto") String yearto) {
        return hd.getIdhoadonsTheoNgay(dayfrom, monthfrom, yearfrom, dayto, monthto, yearto);
    }

    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getgioden")
    public String getgioden(@WebParam(name = "idhoadon") int idhoadon) {
        //TODO write your implementation code here:
        return hd.getGioDen(idhoadon);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getgiove")
    public String getgiove(@WebParam(name = "idhoadon") int idhoadon) {
        //TODO write your implementation code here:
        return hd.getGioVe(idhoadon);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addNewHoaDon")
    public int addNewHoaDon(@WebParam(name = "tenban") String tenban, @WebParam(name = "gioden") String gioden, @WebParam(name = "khuvuc") String khuvuc, @WebParam(name = "tongtien") float tongtien) {
        //TODO write your implementation code here:
        return hd.addNewHoaDon(tenban, gioden, khuvuc, tongtien);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getStatusInfoFromHoadon")
    public String getStatusInfoFromHoadon(@WebParam(name = "tenban") String tenban, @WebParam(name = "khuvuc") String khuvuc) {
        //TODO write your implementation code here:
        return hd.getStatusInfoFromHoadon(tenban, khuvuc);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getIDInfoFromHoadon")
    public int getIDInfoFromHoadon(@WebParam(name = "tenban") String tenban, @WebParam(name = "khuvuc") String khuvuc) {
        //TODO write your implementation code here:
        return hd.getIDInfoFromHoadon(tenban, khuvuc);
    }
    

}
