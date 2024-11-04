/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.nvconnect;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.nvmodel;

/**
 *
 * @author admin
 */
@WebService(serviceName = "nv_ws")
public class nv_ws {
    nvconnect nv=new nvconnect();

    
    @WebMethod(operationName = "getNhanvien")
    public List<nvmodel> getNhanvien() {
        //TODO write your implementation code here:
        return nv.getNhanvien();
    }

    
    @WebMethod(operationName = "findnv")
    public List<nvmodel> findnv(@WebParam(name="a") String a) {
        //TODO write your implementation code here:
        return nv.find(a);
    }

    @WebMethod(operationName = "getUpdatenv")
    @Oneway
    public void getUpdatenv(@WebParam(name="a") String a,
            @WebParam(name="b") String b,
            @WebParam(name="c") String c,
            @WebParam(name="d") String d,
            @WebParam(name="e") String e,
            @WebParam(name="f") String f) {
        nv.getUpdate(a, b, c, d, e, f);
    }
    
    @WebMethod(operationName = "getDeletenv")
    @Oneway
    public void getDeletenv(@WebParam(name="a") String a) {
        nv.getDelete(a);
    }
    
    @WebMethod(operationName = "getThemnv")
    @Oneway
    public void getThemnv(@WebParam (name="a") String a,
            @WebParam (name="b") String b,
            @WebParam (name="c") String c,
            @WebParam (name="d") String d,
            @WebParam (name="e") String e,
            @WebParam (name="f") String f) {
        nv.getThem(a, b, c, d, e, f);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCheck")
    public boolean getCheck(@WebParam(name="a") String a) {
        //TODO write your implementation code here:
        return nv.check(a);
    }
    
    
    
    
    
    
}
