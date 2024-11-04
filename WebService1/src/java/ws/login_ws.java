/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.loginconnect;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.loginmodel;

/**
 *
 * @author admin
 */
@WebService(serviceName = "login_ws")
public class login_ws {
    loginconnect lg=new loginconnect();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getDangnhap")
    public List<loginmodel> getDangnhap() {
        //TODO write your implementation code here:
        return lg.getDangnhap();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name="username") String username,
            @WebParam(name="password") String password) {
        //TODO write your implementation code here:
        return lg.login(username, password);
    }
    /**
     * This is a sample web service operation
     */
    
}
