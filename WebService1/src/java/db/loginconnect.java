/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.loginmodel;


/**
 *
 * @author admin
 */
public class loginconnect {
    public String loggedInUsername;
    Connection conn=null;

    public loginconnect() {
        conn=DBConnect.get_Connection();
    }
     
     
     public List<loginmodel> getDangnhap(){
         List<loginmodel> result=new ArrayList<>();
         if(conn!=null){
             try{
             String query = "SELECT * FROM `taikhoan`";
                    Statement st =conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        result.add(new loginmodel( rs.getString(3), rs.getString(4)));
                    }

         }catch(SQLException e){
              e.printStackTrace();
         }
         }
         
         return result;
         
     }
       public boolean login(String username, String password)  {
 
        
            // Tạo truy vấn SQL để kiểm tra thông tin đăng nhập
            String sql = "SELECT * FROM taikhoan WHERE tentk = ? AND pass = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password);
                // Thực thi truy vấn
                try (ResultSet resultSet = statement.executeQuery()) {
                    // Nếu resultSet không rỗng, tức là có một bản ghi khớp với thông tin đăng nhập
                    if (resultSet.next()) {
                        System.out.println("Đăng nhập thành công");
                        return true;
                    } else {
                       System.out.println("Tên đăng nhập hoặc mật khẩu không chính xác");
                        return false;
                    }
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
//    static Connection con;
//    public static Connection getConnection(){
//        String url="jdbc:mysql://localhost:3306/qlnh";
//        String user ="root";
//        String password = "";
//        
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            try {
//                con=(Connection) DriverManager.getConnection(url, user, password);
//
//            } catch (SQLException ex) {
//                Logger.getLogger(loginconnect.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(loginconnect.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return con;
//    }
//     
//     public List<loginmodel> getDangnhap(){
//         List<loginmodel> result=new ArrayList<>();
//         try{
//             con = getConnection();
//             String query = "SELECT * FROM taikhoan WHERE tentk=? AND pass=?";
//                    PreparedStatement statement =  (PreparedStatement) con.prepareStatement(query);
//                    ResultSet resultSet = statement.executeQuery();
//                    while(resultSet.next()){
//                        loginmodel login=new loginmodel();
//                        login.setUser(resultSet.getString(3));
//                        login.setPass(resultSet.getString(4));
//                        result.add(login);
//                    }
//                    resultSet.close();
//                    statement.close();
//                    con.close();
//
//                    
//         }catch(Exception e){
//             e.printStackTrace();
//         }
//         return result;
//         
//     }
}
