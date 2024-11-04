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
import model.nvmodel;
import model.tkmodel;

/**
 *
 * @author admin
 */
public class tkconnect {
    Connection conn=null;

    public tkconnect() {
        conn=DBConnect.get_Connection();
    }
     
     
     public List<tkmodel> getTaikhoan(){
         List<tkmodel> result=new ArrayList<>();
         try{
             String query = "SELECT * FROM taikhoan";
                    Statement st =conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        result.add(new tkmodel(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
                    }

         }catch(SQLException e){
         }
         return result;
         
     }

//     
     public List<tkmodel> find(String a) {
        List<tkmodel> arr=new ArrayList<>();
        String sql = "SELECT * FROM `taikhoan` WHERE `taikhoan`.`tentk` LIKE '%"+a+"%';";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
           
            ps = (PreparedStatement) conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                arr.add(new tkmodel(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (NumberFormatException | SQLException ex) {
        } 
        return arr;
    }
     
     public void getThem(String a,String b, String c, String d){
         try{
            
             String query = "INSERT INTO `taikhoan` VALUE (null,?,?,?,?)";
                    PreparedStatement statement =  (PreparedStatement) conn.prepareStatement(query);
                    statement.setString(1,a);
                    statement.setString(2,b);
                    statement.setString(3,c);
                    statement.setString(4,d);
                    statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(tkconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getUpdate(String a, String b, String c, String d) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
           
            String sql = "UPDATE `taikhoan` SET `tentk`=?,`pass`=?,`quyen`=? WHERE `taikhoan`.`matk`=?;";
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, b);
            ps.setString(2, c);
            ps.setString(3, d);
            ps.setString(4, a);
            ps.executeUpdate();
        } catch (SQLException ex) {
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
            }
        }
    }
    
    public void getDelete(String a)  {
        try {
           
            String sql = "DELETE FROM taikhoan WHERE `taikhoan`.`matk` = ?";
            PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, a);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(tkconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean check(String a){
        try {
           
           
                String query = "SELECT * FROM taikhoan WHERE matk = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, a);
                ResultSet resultSet = statement.executeQuery();
                
                // Nếu resultSet không rỗng, tức là ID đã tồn tại
                if (resultSet.next()) {
                    return true;
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(tkconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


}
