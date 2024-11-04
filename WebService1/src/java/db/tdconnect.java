/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.tdmodel;
import model.theloaimodel;


/**
 *
 * @author admin
 */
public class tdconnect {
    Connection conn=null;

    public tdconnect() {
        conn=DBConnect.get_Connection();
    }
     
     
     public List<tdmodel> getThucdon(){
         List<tdmodel> result=new ArrayList<>();
         try{
             String query = "SELECT * FROM thucdon";
                    Statement st =conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        result.add(new tdmodel(rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5)));
                    }

         }catch(SQLException e){
         }
         return result;
         
     }

     
     public List<tdmodel> find(String a) {
        List<tdmodel> arr=new ArrayList<>();
        String sql = "SELECT * FROM `thucdon` WHERE `thucdon`.`tenmon` LIKE '%"+a+"%';";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            
            ps = (PreparedStatement) conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                arr.add(new tdmodel(rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5)));
            }
        } catch (NumberFormatException | SQLException ex) {
        } 
        return arr;
    }
     
     public void getThem(String a,String b, String c, float d){
         try{
            
             String query = "INSERT INTO `thucdon` VALUE (null,?,?,?,?)";
                    PreparedStatement statement =  (PreparedStatement) conn.prepareStatement(query);
                    statement.setString(1,a);
                    statement.setString(2,b);
                    statement.setString(3,c);
                    statement.setFloat(4,d);
                    statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(tdconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getUpdate(String a, String b, String c, float d) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            
            String sql = "UPDATE `thucdon` SET `tenmon`=?,`theloai`=?,`giathanh`=? WHERE `thucdon`.`mamon`=?;";
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, b);
            ps.setString(2, c);
            ps.setFloat(3, d);
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

            String sql = "DELETE FROM thucdon WHERE `thucdon`.`mamon` = ?";
            PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, a);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(tdconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<theloaimodel> getTheLoai(){
        List<theloaimodel> result=new ArrayList<>();
         try{
             String query = "SELECT theloai FROM thucdon GROUP BY theloai";
                    Statement st =conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        result.add(new theloaimodel(rs.getString(1)));
                    }
         }catch(SQLException e){
         }
         return result;
    }
    
    //lấy tên món ăn từ db
       public ArrayList<String> getMenuItemsFromDatabase(String idTheloai) {
        ArrayList<String> menuItems = new ArrayList<>();
        String query = "SELECT tenmon FROM thucdon WHERE theloai = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, idTheloai);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String tenmon = rs.getString("tenmon");
                menuItems.add(tenmon);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return menuItems;
    }
           //    Lấy ra giá món từ bảng thực đơn trên db
    public float giaMon(String tenmon) {
        float gia = 0.0f;
        String query = "SELECT giathanh FROM thucdon WHERE tenmon = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tenmon);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                gia = rs.getFloat("giathanh");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gia;
    }
}
