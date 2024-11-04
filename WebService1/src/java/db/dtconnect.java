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
import model.dtmodel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ptbic
 */
public class dtconnect {
    Connection conn = null;

    public dtconnect() {
        conn =DBConnect.get_Connection();
    }
    public List<dtmodel> getdoanhthu(){
        List<dtmodel> result = new ArrayList<>();
        try{
             String query = "SELECT * FROM doanhthu";
                    Statement st =conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        result.add(new dtmodel(rs.getInt(2), rs.getInt(3), rs.getInt(4)));
                    }

         }catch(SQLException e){
         }
        return result;
    }
    //  Hàm kiểm tra doanh thu năm tháng trong bảng doanhthu 
    public boolean checkDoanhThuExist(int year, int month) {
        boolean exists = false;
        String query = "SELECT COUNT(*) AS count FROM doanhthu WHERE nam = ? AND thang = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, year);
            stmt.setInt(2, month);
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
    //  cập nhật bảng doanhthu
    public void updateDoanhThu(int year, int month, float tien) {
        String query = "UPDATE doanhthu SET tien = tien + ? WHERE nam = ? AND thang = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setFloat(1, tien);
            stmt.setInt(2, year);
            stmt.setInt(3, month);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//  thêm mới dữ liệu vào bảng doanhthu
    public void insertDoanhThu(int year, int month, float tien) {
        String query = "INSERT INTO doanhthu (nam, thang, tien) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, year);
            stmt.setInt(2, month);
            stmt.setFloat(3, tien);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<dtmodel> fetchData(String year) {
//	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            List<dtmodel> arr = new ArrayList<>();
	    String query = "SELECT thang, tien, nam FROM doanhthu WHERE nam = ?";
	    try (PreparedStatement statement = conn.prepareStatement(query)) {
	        statement.setString(1, year);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                int thang = resultSet.getInt("thang");
	                int tien = resultSet.getInt("tien");
                        int nam = resultSet.getInt("nam");
	                arr.add(new dtmodel(tien, thang, nam));
	            }
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return arr;
	}
       public List<String> updateComboBox() {
        List<String> years = new ArrayList<>();
        String query = "SELECT DISTINCT nam FROM doanhthu";
        try ( PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String year = resultSet.getString("nam");
                years.add(year);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//        view.updateComboBox(years);
        return years;
    }
}
