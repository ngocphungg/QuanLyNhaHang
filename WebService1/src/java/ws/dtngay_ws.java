/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.dtngayconnect;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.dtngaymodel;

/**
 *
 * @author admin
 */
@WebService(serviceName = "dtngay_ws")
public class dtngay_ws {
    dtngayconnect dtn=new dtngayconnect();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getDoanhThuNgay")
    public List<dtngaymodel> getDoanhThuNgay() {
        //TODO write your implementation code here:
        return dtn.getDoanhThu();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isDateExistInDoanhThuNgay")
    public boolean isDateExistInDoanhThuNgay(@WebParam(name="ngay") int ngay,
            @WebParam(name="thang") int thang,
            @WebParam(name="nam") int nam) {
        //TODO write your implementation code here:
        return dtn.isDateExistsInDoanhThuNgay(ngay, thang, nam);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addNewDoanhThuNgay")
    @Oneway
    public void addNewDoanhThuNgay(@WebParam(name="ngay") int ngay,
            @WebParam(name="thang") int thang,
            @WebParam(name="nam")int nam,
            @WebParam(name="tongTien") float tongTien) {
        dtn.addNewDoanhThuNgay(ngay, thang, nam, tongTien);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateTongTienDoanhThuNgay")
    @Oneway
    public void updateTongTienDoanhThuNgay(@WebParam(name="ngay") int ngay,
            @WebParam(name="thang") int thang,
            @WebParam(name="nam") int nam,
            @WebParam(name="tongTien") float tongTien) {
        dtn.updateTongTienDoanhThuNgay(ngay, thang, nam, tongTien);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTongThuCuaNgay")
    public float getTongThuCuaNgay(@WebParam(name="day") int day,
            @WebParam(name="month") int month,
            @WebParam(name="year") int year) {
        //TODO write your implementation code here:
        return dtn.getTongThuCuaNgay(day, month, year);
    }
    
}
