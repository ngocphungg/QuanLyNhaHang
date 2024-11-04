/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.spconnect;
//import java.sql.Date;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.spmodel;

/**
 *
 * @author admin
 */
@WebService(serviceName = "sp_ws")
public class sp_ws {
    spconnect sp= new spconnect();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getSanpham")
    public List<spmodel> getSanpham() {
        //TODO write your implementation code here:
        return sp.getSanpham();
    }
//
//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "findsp")
    public List<spmodel> findsp(@WebParam(name ="a") String a) {
        //TODO write your implementation code here:
        return sp.find(a);
    }
//
//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "getThemsp")
    @Oneway
    public void getThemsp(@WebParam(name="a") String a,
            @WebParam(name="b") String b,
            @WebParam(name="c") String c,
            @WebParam(name="d") String d,
            @WebParam(name="e") int e,
            @WebParam(name="f") float f,
            @WebParam(name="g") float g) {
        sp.getThem(a, b, c, d, e, f, g);
    }
//
//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "getUpdatesp")
    @Oneway
    public void getUpdatesp(@WebParam(name="a") String a,
            @WebParam(name="b") String b,
            @WebParam(name="c") String c,
            @WebParam(name="d") String d,
            @WebParam(name="e") int e,
            @WebParam(name="f") float f,
            @WebParam(name="g") float g) {
        sp.getUpdate(a, b, c, d, e, f, g);
    }

    @WebMethod(operationName = "getDeletesp")
    @Oneway
    public void getDeletesp(@WebParam(name="a") String a) {
        sp.getDelete(a);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCheck")
    public boolean getCheck(@WebParam(name="a") String a) {
        //TODO write your implementation code here:
        return sp.check(a);
    }
    
    
}
