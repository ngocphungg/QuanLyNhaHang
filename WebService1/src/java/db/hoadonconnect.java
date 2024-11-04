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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.DoanhThuModel;
import model.dtngaymodel;
import model.hd1;
import model.hoadonmodel;


/**
 *
 * @author admin
 */
public class hoadonconnect {
    Connection conn=null;

    public hoadonconnect() {
        conn=DBConnect.get_Connection();
    }

    public List<hoadonmodel> getHoadon() {
        List<hoadonmodel> result=new ArrayList<>();
//        LocalDateTime gioDen;
//        LocalDateTime giove;
         try{
             String query = "SELECT * FROM hoadon";
                    Statement st =conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        Timestamp timestampden = rs.getTimestamp("gioden");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String gioden = sdf.format(timestampden);
                        Timestamp timestampve = rs.getTimestamp("giove");
                        String giove = sdf.format(timestampve);
                        result.add(new hoadonmodel(rs.getString(1), rs.getString(2), rs.getString(3),gioden, giove,rs.getFloat(6),rs.getString(7)));
                    }

         }catch(SQLException e){
         }
         return result;
         
    }
 
    //    Lấy ID hóa đơn từ db theo tên bàn và trạng thái
    public int getCurrentHoadonID(String tenban, String khuVuc,String trangthai) {
        int idhoadon = -1;
        String query = "SELECT idhd FROM hoadon WHERE tenban = ? AND khuvuc = ? AND trangthai =?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tenban);
            stmt.setString(2, khuVuc);
            stmt.setString(3,trangthai);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idhoadon = rs.getInt("idhd");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idhoadon;
    }

    //  Lấy giờ đến từ db
    public String getGioDen(int idhoadon) {
        String gioDen="";
        String query = "SELECT gioden FROM hoadon WHERE idhd = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idhoadon);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Timestamp timestamp = rs.getTimestamp("gioden");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                gioDen = sdf.format(timestamp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gioDen;
    }
    //lấy giờ về từ db
       public String getGioVe(int idhoadon) {
        String gioVe="";
        String query = "SELECT giove FROM hoadon WHERE idhd = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idhoadon);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Timestamp timestamp = rs.getTimestamp("giove");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                gioVe = sdf.format(timestamp);
//                Timestamp timestamp = rs.getTimestamp("giove");
//                if (timestamp != null) {
//                    gioVe = timestamp.toLocalDateTime();
//                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gioVe;
    }
    //  Cập nhật trạng thái và set giờ về cho hóa đơn trên db
    public void updatePaymentHoadon(int idhoadon) {
        LocalDateTime currentTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(currentTime);

        String query = "UPDATE hoadon SET trangthai = 'đã thanh toán', giove = ? WHERE idhd = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setTimestamp(1, timestamp);
            stmt.setInt(2, idhoadon);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //   Thêm 1 hóa đơn mới vào db trả về idhd chú ý khi chuyển đổi sang method ws
    public int addNewHoaDon(String tenban,String gioden, String khuVuc, float thanhtien) {
        int idhoadon = -1;
//        gioden = LocalDateTime.now();
//        Timestamp timestamp = Timestamp.valueOf(gioden);

        String query = "INSERT INTO hoadon (idhd, tenban, gioden, giove, tongtien, khuvuc, trangthai) VALUES (null, ?, ?, null, ?, ?, 'chưa thanh toán')";        
        try (PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, tenban);
            stmt.setString(2,  gioden);
            stmt.setFloat(3, thanhtien);
            stmt.setString(4, khuVuc);
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idhoadon = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idhoadon;
    }
    //    Lấy tất cả các ID hóa đơn từ db theo tên bàn
    public ArrayList<Integer> getAllHoadonIDs(String tenban, String khuVuc) {
        ArrayList<Integer> idhoadons = new ArrayList<>();

        String query = "SELECT idhd FROM hoadon WHERE tenban = ? AND khuvuc = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tenban);
            stmt.setString(2, khuVuc);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idhoadon = rs.getInt("idhd");
                idhoadons.add(idhoadon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idhoadons;
    }
    //    Lấy trạng thái của idhoadon từ db
    public String getHoadonStatus(int idhoadon) {
        String trangthai = "";
        String query = "SELECT trangthai FROM hoadon WHERE idhd = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idhoadon);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                trangthai = rs.getString("trangthai");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trangthai;
    }

    // cập nhật tông tiền nếu bàn đã order thêm món ăn vào chi tiết hóa đơn
    public void updateTotalAmount(int idhoadon, float totalAmount) {
        String query = "UPDATE hoadon SET tongtien = ? WHERE idhd = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setFloat(1, totalAmount);
            stmt.setInt(2, idhoadon);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getIDInfoFromHoadon(String tenban, String khuvuc) {    
        int id= -1;
        String query = "SELECT idhd FROM hoadon WHERE tenban = ? AND khuvuc = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tenban);
            stmt.setString(2, khuvuc);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("idhd");               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return id;
    }
    public String getStatusInfoFromHoadon(String tenban, String khuvuc) {    
        String trangthai= "";
        String query = "SELECT trangthai FROM hoadon WHERE tenban = ? AND khuvuc = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tenban);
            stmt.setString(2, khuvuc);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                trangthai = rs.getString("trangthai");               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return trangthai;
    }

    //    lấy tổng tiền từ bảng hoadon
    public float getTongTienByIdHoadon(int idhoadon) {
        float tongTien = 0.0f;
        String query = "SELECT tongtien FROM hoadon WHERE idhd = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idhoadon);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tongTien = rs.getFloat("tongtien");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tongTien;
    }
    //  lấy ra id hóa đơn của tên bàn chưa thanh toán
    public float getUnpaidHoadonID(String tenban, String khuVuc) {
        float idhoadon = 0.0f;

        String query = "SELECT idhd FROM hoadon WHERE tenban = ? AND khuvuc = ? AND trangthai = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tenban);
            stmt.setString(2, khuVuc);
            stmt.setString(3, "chưa thanh toán");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idhoadon = rs.getInt("idhd");
//                return idhoadon;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }      
        return idhoadon;
    }

//  xóa hóa đơn trên db và cập nhật lại view ( chú ý khi thêm ws )
    public void deleteHoadon(int idhoadon) {
        String query = "DELETE FROM hoadon WHERE idhd = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idhoadon);
            stmt.executeUpdate();
//            view.clearStatus();
//            view.clearTotalAmount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<DoanhThuModel> getIdhoadonsTheoNgayTang(String dayfrom, String monthfrom, String yearfrom, String dayto, String monthto, String yearto) {
    	// Chuỗi truy vấn SQL để đếm số lượng idhoadon theo từng ngày trong khoảng thời gian và trạng thái đã chỉ định
	dtngayconnect dtncn = new dtngayconnect();
        List<DoanhThuModel> doanhThuList = new ArrayList<>();    
        String query = "SELECT DATE(gioden) AS ngay, COUNT(idhd) AS soluong " +
	                   "FROM hoadon " +
	                   "WHERE (gioden >= ? AND gioden <= ?) " +
	                   "AND trangthai = 'đã thanh toán' " +
	                   "GROUP BY ngay";

	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        // Tạo chuỗi ngày bắt đầu và kết thúc trong định dạng phù hợp cho truy vấn SQL
	        String fromDate = yearfrom + "-" + monthfrom + "-" + dayfrom;
	        String toDate = yearto + "-" + monthto + "-" + dayto;

	        // Truyền tham số vào câu truy vấn
	        stmt.setString(1, fromDate);
	        stmt.setString(2, toDate);
	        // Thực thi truy vấn
	        ResultSet rs = stmt.executeQuery();
                
                //TRUY VẤN DỮ LIỆU LÊN BẢNG LÀM TRONG CONTROLLER
	        
	        // Lặp qua kết quả từ truy vấn và cập nhật dữ liệu lên bảng
	        while (rs.next()) {
	            String ngay = rs.getString("ngay");
	            int soLuong = rs.getInt("soluong");
	            String[] partsngay = ngay.split("-");
	            String year=partsngay[0];
	            String month=partsngay[1];
	            String day=partsngay[2];
	            int dayInt = Integer.parseInt(day);
	            int monthInt = Integer.parseInt(month);
	            int yearInt=Integer.parseInt(year);
	            float tongthu=dtncn.getTongThuCuaNgay(dayInt,monthInt,yearInt);
	            float tb1ban=(float) tongthu/soLuong;
	            DoanhThuModel doanhThu = new DoanhThuModel(ngay, tongthu, soLuong, tb1ban);
                doanhThuList.add(doanhThu);
                
	        }
	        Collections.sort(doanhThuList, new Comparator<DoanhThuModel>() {
                @Override
                public int compare(DoanhThuModel o1, DoanhThuModel o2) {
                    return Float.compare(o1.getTongThu(), o2.getTongThu());
                }
            });
           
//	        for (DoanhThuModel doanhThu : doanhThuList) {
//                view.updateTableInfo(doanhThu.getNgay(), doanhThu.getTongThu(), doanhThu.getSoLuongHoaDon(), doanhThu.getTrungBinhMoiBan());
//            }
	        
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
            return doanhThuList;
	}
	public List<DoanhThuModel> getAllDoanhThuNgayTang() {
            dtngayconnect dtncn = new dtngayconnect();
            List<DoanhThuModel> doanhThuList = new ArrayList<>();
        String query = "SELECT DATE(gioden) AS ngay, COUNT(idhd) AS soluong " +
                       "FROM hoadon " +
                       "WHERE trangthai = 'đã thanh toán' " +
                       "GROUP BY ngay";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            // Tạo một danh sách để lưu trữ các bản ghi
            

            while (rs.next()) {
                String ngay = rs.getString("ngay");
                int soLuong = rs.getInt("soluong");
                String[] partsNgay = ngay.split("-");
                int year = Integer.parseInt(partsNgay[0]);
                int month = Integer.parseInt(partsNgay[1]);
                int day = Integer.parseInt(partsNgay[2]);
                float tongThu =dtncn.getTongThuCuaNgay(day, month, year) ;
                            float tb1Ban = (float) tongThu / soLuong;

//                // Tạo một đối tượng DoanhThu và thêm vào danh sách
                DoanhThuModel doanhThu = new DoanhThuModel(ngay, tongThu, soLuong, tb1Ban);
                doanhThuList.add(doanhThu);
            }

            // Sắp xếp danh sách theo tổng thu tăng dần
            Collections.sort(doanhThuList, new Comparator<DoanhThuModel>() {
                @Override
                public int compare(DoanhThuModel o1, DoanhThuModel o2) {
                    return Float.compare(o1.getTongThu(), o2.getTongThu());
                }
            });

            // Cập nhật dữ liệu lên bảng
//            for (DoanhThuModel doanhThu : doanhThuList) {
//                view.updateTableInfo(doanhThu.getNgay(), doanhThu.getTongThu(), doanhThu.getSoLuongHoaDon(), doanhThu.getTrungBinhMoiBan());
//            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return doanhThuList;
    }


	public List<DoanhThuModel> getAllDoanhThuNgay() {
            dtngayconnect dtncn = new dtngayconnect();
            List<DoanhThuModel> doanhThuList = new ArrayList<>();
		String query = "SELECT DATE(gioden) AS ngay, COUNT(idhd) AS soluong " +
                   "FROM hoadon " +
                   "WHERE trangthai = 'đã thanh toán' " +
                   "GROUP BY ngay";
		    try (PreparedStatement stmt = conn.prepareStatement(query)) {        
		        // Truyền tham số vào câu truy vấn
		       
		        // Thực thi truy vấn
		        ResultSet rs = stmt.executeQuery();
		        // Lặp qua kết quả từ truy vấn và cập nhật dữ liệu lên bảng
		        while (rs.next()) {
		            String ngay = rs.getString("ngay");
		            int soLuong = rs.getInt("soluong");
		            String[] partsngay = ngay.split("-");
		            String year=partsngay[0];
		            String month=partsngay[1];
		            String day=partsngay[2];
		            int dayInt = Integer.parseInt(day);
		            int monthInt = Integer.parseInt(month);
		            int yearInt=Integer.parseInt(year);
                            float tongThu =dtncn.getTongThuCuaNgay(dayInt, monthInt, yearInt) ;
                            float tb1Ban = (float) tongThu / soLuong;
                            DoanhThuModel doanhThu = new DoanhThuModel(ngay, monthInt, soLuong, tb1Ban);
                            doanhThuList.add(doanhThu);
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
                    return doanhThuList;
}
	public List<DoanhThuModel> getIdhoadonsTheoNgay(String dayfrom, String monthfrom, String yearfrom, String dayto, String monthto, String yearto) {
	    // Chuỗi truy vấn SQL để đếm số lượng idhoadon theo từng ngày trong khoảng thời gian và trạng thái đã chỉ định
	    dtngayconnect dtncn = new dtngayconnect();
            List<DoanhThuModel> doanhThuList = new ArrayList<>();
            String query = "SELECT DATE(gioden) AS ngay, COUNT(idhd) AS soluong " +
	                   "FROM hoadon " +
	                   "WHERE (gioden >= ? AND gioden <= ?)" +
	                   "AND trangthai = 'đã thanh toán' " +
	                   "GROUP BY ngay";

	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        // Tạo chuỗi ngày bắt đầu và kết thúc trong định dạng phù hợp cho truy vấn SQL
	        String fromDate = yearfrom + "-" + monthfrom + "-" + dayfrom;
	        String toDate = yearto + "-" + monthto + "-" + dayto;

	        // Truyền tham số vào câu truy vấn
	        stmt.setString(1, fromDate);
	        stmt.setString(2, toDate);
	        // Thực thi truy vấn
	        ResultSet rs = stmt.executeQuery();
	        // LẶP LẠI KẾT QUẢ TRUY VẤN VÀ CẬP NHẬT DỮ LIỆU LÊN BẢNG 
	        while (rs.next()) {
	            String ngay = rs.getString("ngay");
	            int soLuong = rs.getInt("soluong");
	            String[] partsngay = ngay.split("-");
	            String year=partsngay[0];
	            String month=partsngay[1];
	            String day=partsngay[2];
	            int dayInt = Integer.parseInt(day);
	            int monthInt = Integer.parseInt(month);
	            int yearInt=Integer.parseInt(year);
                    float tongThu =dtncn.getTongThuCuaNgay(dayInt, monthInt, yearInt) ;
                    float tb1Ban = (float) tongThu / soLuong;
                    DoanhThuModel doanhThu = new DoanhThuModel(ngay, monthInt, soLuong, tb1Ban);
                    doanhThuList.add(doanhThu);
////	            float tongthu=getTongThuCuaNgay(dayInt,monthInt,yearInt);
////	            float tb1ban=(float) tongthu/soLuong;
////	            view.updateTableInfo(ngay,tongthu,soLuong,tb1ban);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
            return doanhThuList;
	}
   

}
