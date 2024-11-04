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
import model.dtngaymodel;
import model.dtmodel;

/**
 *
 * @author ptbic
 */
public class dtngayconnect {
    Connection conn = null;

    public dtngayconnect() {
        conn = DBConnect.get_Connection();
    }
    public List<dtngaymodel> getDoanhThu(){
        List<dtngaymodel> result = new ArrayList<>();
        try{
             String query = "SELECT * FROM doanhthungay";
                    Statement st =conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        result.add(new dtngaymodel(rs.getInt(2), rs.getInt(3), rs.getInt(4),rs.getInt(5)));
                    }

         }catch(SQLException e){
         }
        return result;
    }
    //  hàm kiểm tra dữ liệu doanh thu ngày n trong db bảng doanh thu ngày
    public boolean isDateExistsInDoanhThuNgay(int ngay, int thang, int nam) {
        boolean exists = false;
        String query = "SELECT COUNT(*) AS count FROM doanhthungay WHERE ngay = ? AND thang = ? AND nam = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, ngay);
            stmt.setInt(2, thang);
            stmt.setInt(3, nam);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                exists = count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }
    //  Thêm 1 dữ liệu về doanh thu ngày mới trên db
   public void addNewDoanhThuNgay(int ngay, int thang, int nam, float tongTien) {
        String query = "INSERT INTO doanhthungay (nam, thang, ngay, tientheongay) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, nam);
            stmt.setInt(2, thang);
            stmt.setInt(3, ngay);
            stmt.setFloat(4, tongTien);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //   Cập nhật tổng tiền doanh thu ngày 
    public void updateTongTienDoanhThuNgay(int ngay, int thang, int nam, float tongTien) {
        String query = "UPDATE doanhthungay SET tientheongay = tientheongay + ? WHERE ngay = ? AND thang = ? AND nam = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setFloat(1, tongTien);
            stmt.setInt(2, ngay);
            stmt.setInt(3, thang);
            stmt.setInt(4, nam);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public float getTongThuCuaNgay(int day, int month, int year) {
        
	    float tongThu = 0.0f;

	    try {
	        // Chuỗi truy vấn SQL để lấy tientheongay từ bảng doanhthungay với điều kiện ngày, tháng và năm
	        String query = "SELECT tientheongay FROM doanhthungay WHERE ngay = ? AND thang = ? AND nam = ?";
	        
	        // Tạo PreparedStatement
	        PreparedStatement stmt = conn.prepareStatement(query);
	        
	        // Truyền tham số vào truy vấn
	        stmt.setInt(1, day);
	        stmt.setInt(2, month);
	        stmt.setInt(3, year);
	        
	        // Thực thi truy vấn
	        ResultSet rs = stmt.executeQuery();
	        
	        // Lặp qua kết quả từ truy vấn (chỉ có một dòng kết quả hoặc không có dòng nào)
	        if (rs.next()) {
	            // Lấy giá trị tientheongay từ ResultSet
	            tongThu = rs.getFloat("tientheongay");
                    
	        }
	        
	        // Đóng ResultSet và PreparedStatement
	        rs.close();
	        stmt.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }

	    return tongThu;
	}
}
