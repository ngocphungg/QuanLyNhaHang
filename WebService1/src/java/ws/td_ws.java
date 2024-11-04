/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.tdconnect;
import java.util.ArrayList;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.tdmodel;
import model.theloaimodel;

/**
 *
 * @author admin
 */
@WebService(serviceName = "td_ws")
public class td_ws {
    tdconnect td=new tdconnect();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getThucdon")
    public List<tdmodel> getThucdon() {
        //TODO write your implementation code here:
        return td.getThucdon();
    }

//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "findtd")
    public List<tdmodel> findtd(@WebParam(name="a") String a) {
        //TODO write your implementation code here:
        return td.find(a);
    }
//
//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "getThemtd")
    @Oneway
    public void getThemtd(@WebParam(name="a") String a,
            @WebParam(name="b") String b,
            @WebParam(name="c") String c,
            @WebParam(name="d") float d) {
       td.getThem(a, b, c, d);
    }
//
//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "getUpdatetd")
    @Oneway
    public void getUpdatetd(@WebParam(name="a") String a,
            @WebParam(name="b") String b,
            @WebParam(name="c") String c,
            @WebParam(name="d") float d) {
        td.getUpdate(a, b, c, d);
    }
//
//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "getDeletetd")
    @Oneway
    public void getDeletetd(@WebParam(name="a") String a) {
        td.getDelete(a);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTheloai")
    public List<theloaimodel> getTheloai() {
        //TODO write your implementation code here:
        return td.getTheLoai();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getMenuItemsFromDatabase")
    public ArrayList<String> getMenuItemsFromDatabase(@WebParam(name = "theloai") String theloai) {
        //TODO write your implementation code here:
        return td.getMenuItemsFromDatabase(theloai);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "giaMon")
    public Float giaMon(@WebParam(name = "tenmon") String tenmon) {
        //TODO write your implementation code here:
        return td.giaMon(tenmon);
    }
    

    
    
    
   
}
