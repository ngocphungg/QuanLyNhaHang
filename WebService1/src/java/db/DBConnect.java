/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DBConnect {
    static Connection conn = null;
    public static Connection get_Connection() {
        String hostName = "localhost";
        String dbName = "qlnh";
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
        }
        return conn;
    }

    public static void main(String[] args) {
        get_Connection();
        if(conn !=null){
            System.out.println("Thanh cong");
        }else{
            System.out.println("That bai");
            
        }
    }
    
}
