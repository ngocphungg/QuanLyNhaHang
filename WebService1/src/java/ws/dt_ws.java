/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.dtconnect;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.dtmodel;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author admin
 */
@WebService(serviceName = "dt_ws")
public class dt_ws {
    dtconnect dt=new dtconnect();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getdoanhthu")
    public List<dtmodel> getdoanhthu() {
        //TODO write your implementation code here:
        return dt.getdoanhthu();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkDoanhThuExist")
    public boolean checkDoanhThuExist(@WebParam(name="year") int year,
            @WebParam(name="month") int month) {
        //TODO write your implementation code here:
        return dt.checkDoanhThuExist(year, month);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateDoanhthu")
    @Oneway
    public void updateDoanhthu(@WebParam(name="year") int year,
            @WebParam(name="month") int month,
            @WebParam(name="tien") float tien) {
        dt.updateDoanhThu(year, month, tien);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertDoanhthu")
    @Oneway
    public void insertDoanhthu(@WebParam(name="year") int year,
            @WebParam(name="month") int month,
            @WebParam(name="tien") float tien) {
        dt.insertDoanhThu(year, month, tien);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "fetchData")
    public List<dtmodel> fetchData(@WebParam(name="year") String year) {
        //TODO write your implementation code here:
        return dt.fetchData(year);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateComboBox")
    public List<String> updateComboBox() {
        //TODO write your implementation code here:
        return dt.updateComboBox();
    }

    
    
}
