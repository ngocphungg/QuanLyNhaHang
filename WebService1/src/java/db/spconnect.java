/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.nvmodel;
import model.spmodel;

/**
 *
 * @author admin
 */
public class spconnect {
    Connection conn=null;

    public spconnect() {
        conn=DBConnect.get_Connection();
    }
     
     
     public List<spmodel> getSanpham(){
         List<spmodel> result=new ArrayList<>();
         try{
             String query = "SELECT * FROM nhaplieu";
                    Statement st =conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    
                    while(rs.next()){
                        Date ngaynhap = rs.getDate("ngaynhap");
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String formattedDate = formatter.format(ngaynhap);
                        result.add(new spmodel(rs.getString(2), rs.getString(3), formattedDate, rs.getString(5), rs.getInt(6), rs.getFloat(7),rs.getFloat(8)));
                    }

         }catch(SQLException e){
         }
         return result;
         
     }
 
     
     public List<spmodel> find(String a) {
        List<spmodel> arr=new ArrayList<>();
        String sql = "SELECT * FROM `nhaplieu` WHERE `nhaplieu`.`tensp` LIKE '%"+a+"%';";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
           
            ps = (PreparedStatement) conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Date ngaynhap = rs.getDate("ngaynhap");
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String formattedDate = formatter.format(ngaynhap);
                arr.add(new spmodel(rs.getString(2), rs.getString(3), formattedDate, rs.getString(5), rs.getInt(6), rs.getFloat(7), rs.getFloat(8)));
            }
        } catch (NumberFormatException | SQLException ex) {
        } 
        return arr;
    }
//     
     public void getThem(String a, String b, String c, String d, int e, float f, float g){
         try{
           
             String query = "INSERT INTO `nhaplieu` VALUE (null,?,?,?,?,?,?,?)";
                    PreparedStatement statement =  (PreparedStatement) conn.prepareStatement(query);
                    statement.setString(1,a);
                    statement.setString(2,b);
                    statement.setString(3,c);
                    statement.setString(4,d);
                    statement.setInt(5,e);
                    statement.setFloat(6,f);
                    statement.setFloat(7,g);
                    statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(spconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getUpdate(String a, String b, String c, String d, int e, float f, float g) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String sql = "UPDATE `nhaplieu` SET `tensp`=?,`ngaynhap`=?,`donvi`=?, `soluong`=?,`chiphi`=?, `tongchiphi`=? WHERE `nhaplieu`.`masp`=?;";
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, b);
            ps.setString(2, c);
            ps.setString(3, d);
            ps.setInt(4,e);
            ps.setFloat(5,f);
            ps.setFloat(6,g);
            ps.setString(7, a);
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
           
            String sql = "DELETE FROM nhaplieu WHERE `nhaplieu`.`masp` = ?";
            PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, a);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(spconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public boolean check(String a){
        try {
           
           
                String query = "SELECT * FROM nhaplieu WHERE masp = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, a);
                ResultSet resultSet = statement.executeQuery();
                
                // Nếu resultSet không rỗng, tức là ID đã tồn tại
                if (resultSet.next()) {
                    return true;
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(spconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
