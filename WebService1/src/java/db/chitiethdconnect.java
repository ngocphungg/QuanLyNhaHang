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
import model.chitiethdmodel;
import model.spmodel;

/**
 *
 * @author admin
 */
public class chitiethdconnect {
    Connection conn=null;

    public chitiethdconnect() {
        conn=DBConnect.get_Connection();
    }
     public List<chitiethdmodel> getCT(){
         List<chitiethdmodel> result=new ArrayList<>();
         try{
             String query = "SELECT * FROM chitiethd";
                    Statement st =conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        result.add(new chitiethdmodel(rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getString(6)));
                    }

         }catch(SQLException e){
         }
         return result;
         
     }
      //    Xóa chi tiết hóa đơn

    public int countOrderDetails(int idhoadon) {
        int count = 0;
        String query = "SELECT COUNT(*) AS count FROM chitiethd WHERE idhd = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idhoadon);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
//    //chỉ xóa chi tiết
    public void deleteChiTietHD(int idhoadon, String tenmon) {
        try {
            String queryDeleteChiTietHD = "DELETE FROM chitiethd WHERE idhd = ? AND tenmon = ?";
            try (PreparedStatement stmtDeleteChiTietHD = conn.prepareStatement(queryDeleteChiTietHD)) {
                stmtDeleteChiTietHD.setInt(1, idhoadon);
                stmtDeleteChiTietHD.setString(2, tenmon);
                stmtDeleteChiTietHD.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//            //  Kiểm tra dữ liệu chi tiết hóa đơn đã tồn tại hay chưa của hóa đơn đang kiểm tra
    public boolean checkIfItemExistsInOrder(int idhoadon, String tenmon) {
        String query = "SELECT COUNT(*) AS count FROM chitiethd WHERE idhd = ? AND tenmon = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idhoadon);
            stmt.setString(2, tenmon);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
//        //Cập nhật chi tiết hóa đơn của hóa đơn đã tồn tại trong db
    public void updateExistingItemInOrder(int idhoadon, String tenmon, int soluong, float thanhtien, String loaiMon) {
        
    	String query = "UPDATE chitiethd SET soluong = soluong + ?, thanhtien = thanhtien + ? WHERE idhd = ? AND tenmon = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, soluong);
            stmt.setFloat(2, thanhtien);
            stmt.setInt(3, idhoadon);
            stmt.setString(4, tenmon);
            stmt.executeUpdate();

//            float totalAmount = calculateTotalAmount(idhoadon);

//            updateTotalAmount(idhoadon, totalAmount);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//        //Thêm mới vào db 1 chi tiết hóa đơn
    public void addChitiethdAndUpdateTongtien(int idhoadon, String tenmon, int soluong, float thanhtien, String loaiMon) {
        if(soluong<=0) {
        	return;
        }
    	String query = "INSERT INTO chitiethd (idhd, tenmon, soluong, thanhtien, theloai) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idhoadon);
            stmt.setString(2, tenmon);
            stmt.setInt(3, soluong);
            stmt.setFloat(4, thanhtien);
            stmt.setString(5, loaiMon);
            stmt.executeUpdate();

            float totalAmount = calculateTotalAmount(idhoadon);

//            updateTotalAmount(idhoadon, totalAmount);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    //Tính tổng tiền các món đã gọi từ cột thành tiền trong cthd có idhd giống nhau
//    // Tính tổng tiền của chi tiết(cthd) để hiện lên table
    public float calculateTotalAmount(int idhoadon) {
        float totalAmount = 0.0f;
        String query = "SELECT SUM(thanhtien) AS tongtien FROM chitiethd WHERE idhd = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idhoadon);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalAmount = rs.getFloat("tongtien");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalAmount;
    }
//        //    Hiển thị thông tin chi tiết hd của 1 bàn
    public List<chitiethdmodel> getTableDetailsFromChitiethd(int idhoadon) {
        List<chitiethdmodel> result = new ArrayList<>();
        String query = "SELECT tenmon, theloai, soluong, thanhtien FROM chitiethd WHERE idhd = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idhoadon);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                hdmodel = view.getHoaDon();
                
                String tenmon = rs.getString("tenmon");
                String loaimon = rs.getString("theloai");
                int soluong = rs.getInt("soluong");
                float thanhtien = rs.getFloat("thanhtien");
                result.add(new chitiethdmodel(idhoadon, tenmon, soluong, thanhtien, tenmon));
                //view.updateTableInfo(hdmodel.tenBan, hdmodel.khuVuc, tenmon, loaimon, soluong, giaMon(tenmon), thanhtien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    //  Xóa chi tiết hd trên db
    public void deleteCTHD(int idhoadon) {
        try {
            String queryDeleteChiTietHD = "DELETE FROM chitiethd WHERE idhd = ? ";
            try (PreparedStatement stmtDeleteChiTietHD = conn.prepareStatement(queryDeleteChiTietHD)) {
                stmtDeleteChiTietHD.setInt(1, idhoadon);
                stmtDeleteChiTietHD.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
