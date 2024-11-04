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

/**
 *
 * @author admin
 */
public class nvconnect {
     Connection conn=null;

    public nvconnect() {
        conn=DBConnect.get_Connection();
    }
     
     
     public List<nvmodel> getNhanvien(){
         List<nvmodel> result=new ArrayList<>();
         try{
             String query = "SELECT * FROM nhanvien";
                    Statement st =conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        result.add(new nvmodel(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
                    }

         }catch(SQLException e){
         }
         return result;
         
     }
     
     public List<nvmodel> find(String a) {
        List<nvmodel> arr=new ArrayList<>();
        String sql = "SELECT * FROM `nhanvien` WHERE `nhanvien`.`hoten` LIKE '%"+a+"%';";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            
            ps = (PreparedStatement) conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                arr.add(new nvmodel(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (NumberFormatException | SQLException ex) {
        } 
        return arr;
    }
     
     public void getThem(String a,String b, String c, String d, String e, String f) {
         try{
         String query = "INSERT INTO `nhanvien` VALUE (null,?,?,?,?,?,?)";
         PreparedStatement statement =  (PreparedStatement) conn.prepareStatement(query);
         statement.setString(1,a);
         statement.setString(2,b);
         statement.setString(3,c);
         statement.setString(4,d);
         statement.setString(5,e);
         statement.setString(6,f);
         statement.executeUpdate();
    }catch (SQLException ex) {
            Logger.getLogger(nvconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    public void getUpdate(String a, String b, String c, String d, String e, String f) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
           
            String sql = "UPDATE `nhanvien` SET `hoten`=?,`gioitinh`=?,`chucvu`=?,`sdt`=?,`quequan`=? WHERE `nhanvien`.`manv`=?;";
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, b);
            ps.setString(2, c);
            ps.setString(3, d);
            ps.setString(4, e);
            ps.setString(5, f);
            ps.setString(6, a);
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
            
            String sql = "DELETE FROM nhanvien WHERE `nhanvien`.`manv` = ?";
            PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, a);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(nvconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public boolean check(String a){
        try {
           
           
                String query = "SELECT * FROM nhanvien WHERE manv = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, a);
                ResultSet resultSet = statement.executeQuery();
                
                // Nếu resultSet không rỗng, tức là ID đã tồn tại
                if (resultSet.next()) {
                    return true;
                }
            
                
        } catch (SQLException ex) {
            Logger.getLogger(nvconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

