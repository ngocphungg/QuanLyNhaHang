/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.tkconnect;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.tkmodel;

/**
 *
 * @author admin
 */
@WebService(serviceName = "tk_ws")
public class tk_ws {
    tkconnect tk=new tkconnect();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTaikhoan")
    public List<tkmodel> getTaikhoan() {
        //TODO write your implementation code here:
        return tk.getTaikhoan();
    }

//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "findtk")
    public List<tkmodel> findtk(@WebParam(name = "a") String a) {
        //TODO write your implementation code here:
        return tk.find(a);
    }
//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "getThemtk")
    @Oneway
    public void getThemtk(@WebParam(name ="a") String a, 
            @WebParam(name="b") String b,
            @WebParam(name="c") String c,
            @WebParam(name="d") String d) {
        tk.getThem(a,b,c,d);
    }
//
//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "getUpdatetk")
    @Oneway
    public void getUpdatetk(@WebParam(name="a") String a,
            @WebParam(name="b") String b,
            @WebParam(name="c") String c,
            @WebParam(name="d") String d) {
        tk.getUpdate(a, b, c, d);
    }
//
//    /**
//     * Web service operation
//     */
    @WebMethod(operationName = "getDeletetk")
    @Oneway
    public void getDeletetk(@WebParam(name="a") String a) {
        tk.getDelete(a);
    }
//    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCheck")
    public boolean getCheck(@WebParam(name="a") String a) {
        
        //TODO write your implementation code here:
        return tk.check(a);
    }
    
    
   
}
