package nhahang;

import Controller.connectdb;
import Model.ChiTietHDModel;
import Model.HoaDonModel;
import ThucDon.Theloaimodel;
import View.HomeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class HoaDonController implements ActionListener {
    private HoaDonModel hdmodel;
    private ChiTietHDModel ctmodel;
    private HomeView view;
    private connectdb dbConnect;
    List<Theloaimodel> arrtl;
    List<String> menu;
    String selectedCategory;

    public HoaDonController(HoaDonModel hdmodel,ChiTietHDModel ctmodel, HomeView view, connectdb dbConnect) {
        this.hdmodel = hdmodel;
        this.ctmodel=ctmodel;
        this.view = view;
        this.dbConnect = dbConnect;


        view.XacNhanListener(this);
        view.cb1.addActionListener(this);
        view.XoaBanListenner(this);
        view.ThanhtoanListenner(this);
        view.XoaMonListener(this);
        view.SuaItemListener(this);
        loadCategories();
        loadmenu();
    }

    private void loadCategories() {
        arrtl = getTheloai();
        
        view.cb1.removeAllItems();
        for (Theloaimodel category : arrtl) {
            view.cb1.addItem(category.getTheloai()); // Thêm các mục mới vào thanh chọn
        }

        // Sau khi cập nhật, chọn lại thể loại trước đó nếu có
        if (selectedCategory != null && arrtl.contains(selectedCategory)) {
            view.cb1.setSelectedItem(selectedCategory);
        }// Cập nhật thanh chọn loại trên giao diện
    }
    public void loadmenu(){
        selectedCategory = (String)view.cb1.getSelectedItem();
        menu = getMenuItemsFromDatabase(selectedCategory);
        String selectedMenuItem = (String) view.cb2.getSelectedItem(); // Lấy món đã chọn trước khi cập nhật

        view.cb2.removeAllItems(); // Xóa các mục cũ trước khi cập nhật mới
        for (String menuItem : menu) {
            view.cb2.addItem(menuItem); // Thêm các mục mới vào thanh chọn
        }

        // Sau khi cập nhật, chọn lại món trước đó nếu có
        if (selectedMenuItem != null && menu.contains(selectedMenuItem)) {
            view.cb2.setSelectedItem(selectedMenuItem);
        }
    }
//  Kiểm tra nút nào được click từ View thông qua đối tượng 
	@Override
    public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
        if (source == view.order) {
                handleOrderAction();
        } else if (source == view.cb1) {
                handleCategorySelection();
        } else if (source == view.xoa) {
                handleDeleteAction();
        } else if (source == view.thanhtoan) {
                handlePayment();
        } else if (source == view.xoamon) {
                handleDeleteItem();
        } else if( source== view.edit) {
                handleEditItem();
        }
    }
//  Xử lý sửa món (chưa hiểu lắm hơi loằng ngoằng, lúc add WS chú ý)
//    Xóa chi tiết cũ xong thì thêm chi tiết mới chứ không update
    private void handleEditItem() {
        hdmodel = view.getHoaDon();
        String tenban = hdmodel.tenBan;
        String khuvuc = hdmodel.khuVuc;
        int selectedRow = view.jt.getSelectedRow();
        if (selectedRow != -1) {
            String tenmon = (String) view.jt.getValueAt(selectedRow, 1); 
            int soluong = Integer.parseInt(view.jt.getValueAt(selectedRow, 2).toString());
            float thanhtien = (float) view.jt.getValueAt(selectedRow, 4);
            String trangthai = view.status.getText();
            int idhoadon = getCurrentHoadonID(tenban, khuvuc, trangthai);
            
            String loaiMonSau = (String) view.cb1.getSelectedItem();
            String tenMonSau = (String) view.cb2.getSelectedItem();
            int soLuongSau = (int) view.spinnerModel.getValue();
            float thanhTienSau = (float) soLuongSau * giaMon(tenMonSau);

            if (soLuongSau == soluong) {
                view.displayMessage("Thông tin món vẫn như cũ");
                return;
            }
            deleteSuaChitietHD(idhoadon, tenmon, thanhtien);
            view.clearTable();
            System.out.println(soLuongSau);
            if (soLuongSau == 0) {
                getTableInfoFromHoadon(tenban,khuvuc);
                view.displayMessage("Xóa dòng món thành công.");
                return;
            }
            boolean isExisting = checkIfItemExistsInOrder(idhoadon, tenMonSau);
            if (isExisting) {
                updateExistingItemInOrder(idhoadon, tenMonSau, soLuongSau, thanhTienSau, loaiMonSau);
                view.clearTable();
                getTableInfoFromHoadon(tenban,khuvuc);

            } else {
                addChitiethdAndUpdateTongtien(idhoadon, tenMonSau, soLuongSau, thanhTienSau, loaiMonSau);
                view.clearTable();
                getTableInfoFromHoadon(tenban,khuvuc);

            }
            view.displayMessage("Sửa thành công");
        }
        else {
                view.displayMessage("Vui lòng chọn món để sửa");
        }
    }
//  Xử lý xóa trên view	DELETE ITEM
    public void handleDeleteItem() {
        hdmodel = view.getHoaDon();
                String tenban=hdmodel.tenBan;
        String khuvuc = hdmodel.khuVuc;

        int selectedRow = view.jt.getSelectedRow();
        if (selectedRow != -1) {
            String tenmon = (String) view.jt.getValueAt(selectedRow, 1); 
            float thanhtien = (float) view.jt.getValueAt(selectedRow, 4);
            String trangthai= view.status.getText();
            int idhoadon = getCurrentHoadonID(tenban, khuvuc, trangthai);
            deleteOrderedItem(idhoadon, tenmon, thanhtien);
            view.clearTable();
            getTableDetailsFromChitiethd(idhoadon);
            view.p21.remove(view.xoamon); 
            view.p21.revalidate(); 
            view.p21.repaint();
            view.displayMessage("Xóa món thành công");
            view.cb1.setSelectedIndex(0);
            view.cb2.setSelectedIndex(0);
            view.spinnerModel.setValue(0);
        } else {
            view.displayMessage("Vui lòng chọn một món để xóa.");
        }
    }
//    Lấy ID hóa đơn từ db theo tên bàn và trạng thái
//    public int getCurrentHoadonID(String tenban, String khuVuc,String trangthai) {
//        int idhoadon = -1;
//        String query = "SELECT idhd FROM hoadon WHERE tenban = ? AND khuvuc = ? AND trangthai =?";
//        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
//            stmt.setString(1, tenban);
//            stmt.setString(2, khuVuc);
//            stmt.setString(3,trangthai);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                idhoadon = rs.getInt("idhd");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return idhoadon;
//    }
//    Xóad chi tiết hóa đơn
    public void deleteOrderedItem(int idhoadon, String tenmon, Float thanhtien) {
        try {
            String queryGetTongTien = "SELECT tongtien FROM hoadon WHERE idhd = ?";
            try (PreparedStatement stmtGetTongTien = dbConnect.getConnection().prepareStatement(queryGetTongTien)) {
                stmtGetTongTien.setInt(1, idhoadon);
                ResultSet rs = stmtGetTongTien.executeQuery();
                if (rs.next()) {
                    Float tongtien = rs.getFloat("tongtien");
                    // Trừ thanhtien từ tongtien
                    tongtien -= thanhtien;
//                    Cập nhật tổng tiền vào hóa đơn
                    String queryUpdateTongTien = "UPDATE hoadon SET tongtien = ? WHERE idhd = ?";
                    try (PreparedStatement stmtUpdateTongTien = dbConnect.getConnection().prepareStatement(queryUpdateTongTien)) {
                        stmtUpdateTongTien.setFloat(1, tongtien);
                        stmtUpdateTongTien.setInt(2, idhoadon);
                        stmtUpdateTongTien.executeUpdate();
                    }
                }
            }
//          Xóa chi tiết hóa đơn
            String queryDeleteChiTietHD = "DELETE FROM chitiethd WHERE idhd = ? AND tenmon = ?";
            try (PreparedStatement stmtDeleteChiTietHD = dbConnect.getConnection().prepareStatement(queryDeleteChiTietHD)) {
                stmtDeleteChiTietHD.setInt(1, idhoadon);
                stmtDeleteChiTietHD.setString(2, tenmon);
                stmtDeleteChiTietHD.executeUpdate();

            }
//          Đếm tất cả các chi tiết hóa đơn của hóa đơn nếu 0 tồn tại cthd thì xóa hóa đơn
            String queryCountChiTietHD = "SELECT COUNT(*) AS count FROM chitiethd WHERE idhd = ?";
            try (PreparedStatement stmtCountChiTietHD = dbConnect.getConnection().prepareStatement(queryCountChiTietHD)) {
                stmtCountChiTietHD.setInt(1, idhoadon);
                ResultSet resultSet = stmtCountChiTietHD.executeQuery();
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    if (count == 0) {
                        deleteHoadon(idhoadon);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//  Chỉ xóa chi tiết
//    Sửa 3 truy vấn dưới thành 3 hàm riêng biệt và gọi lại để sử dụng vào cả hàm trên và dưới
    public void deleteSuaChitietHD(int idhoadon, String tenmon, Float thanhtien) {
        try {
            String queryGetTongTien = "SELECT tongtien FROM hoadon WHERE idhd = ?";
            try (PreparedStatement stmtGetTongTien = dbConnect.getConnection().prepareStatement(queryGetTongTien)) {
                stmtGetTongTien.setInt(1, idhoadon);
                ResultSet rs = stmtGetTongTien.executeQuery();
                if (rs.next()) {
                    Float tongtien = rs.getFloat("tongtien");
                    // Trừ thanhtien từ tongtien
                    tongtien -= thanhtien;

                    String queryUpdateTongTien = "UPDATE hoadon SET tongtien = ? WHERE idhd = ?";
                    try (PreparedStatement stmtUpdateTongTien = dbConnect.getConnection().prepareStatement(queryUpdateTongTien)) {
                        stmtUpdateTongTien.setFloat(1, tongtien);
                        stmtUpdateTongTien.setInt(2, idhoadon);
                        stmtUpdateTongTien.executeUpdate();
                    }
                }
            }

            String queryDeleteChiTietHD = "DELETE FROM chitiethd WHERE idhd = ? AND tenmon = ?";
            try (PreparedStatement stmtDeleteChiTietHD = dbConnect.getConnection().prepareStatement(queryDeleteChiTietHD)) {
                stmtDeleteChiTietHD.setInt(1, idhoadon);
                stmtDeleteChiTietHD.setString(2, tenmon);
                stmtDeleteChiTietHD.executeUpdate();
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//  Xử lý view khi thực hiện thanh toán
    private void handlePayment() {
    	PaymentOfCurrentTable();
        view.clearTable();
        view.clearStatus();
        view.clearTotalAmount();
        
    }
//    Xử lý thanh toán chú ý khi thêm ws
    public void PaymentOfCurrentTable() {
        hdmodel = view.getHoaDon();
        String tenban = hdmodel.tenBan;
        String khuVuc = hdmodel.khuVuc;
        int idhoadon = getUnpaidHoadonID(tenban, khuVuc);

        if (idhoadon != -1) {
            float tongtien = getTongTienByIdHoadon(idhoadon);
            String trangthai = getHoadonStatus(idhoadon);

            if (trangthai.equals("chưa thanh toán")) {
                updatePaymentHoadon(idhoadon);

                LocalDateTime gioDen = getGioDen(idhoadon);
                LocalDateTime gioVe =getGioVe(idhoadon);

                float tongTien = calculateTotalAmount(idhoadon);

                updateDoanhThuNgay(gioDen, tongTien);

                updateOrInsertDoanhThu(gioDen, tongTien);

                view.displayMessage("Giờ đến: " + gioDen+"\nGiờ về: "+gioVe);

                view.displayMessage("Bạn đã thanh toán " + tongtien + " cho " + tenban + " - " + khuVuc + " thành công!");
            } else {
                view.displayMessage("Không có thông tin hóa đơn chưa thanh toán của " + tenban + "-" + khuVuc);
            }

        } else {
            view.displayMessage("Không có thông tin hóa đơn cho " + tenban + " - " + khuVuc);
        }
    }
//  Lấy giờ đến từ db
    private LocalDateTime getGioDen(int idhoadon) {
        LocalDateTime gioDen = null;
        String query = "SELECT gioden FROM hoadon WHERE idhd = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
            stmt.setInt(1, idhoadon);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Timestamp timestamp = rs.getTimestamp("gioden");
                if (timestamp != null) {
                    gioDen = timestamp.toLocalDateTime();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gioDen;
    }
    private LocalDateTime getGioVe(int idhoadon) {
        LocalDateTime gioVe = null;
        String query = "SELECT giove FROM hoadon WHERE idhd = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
            stmt.setInt(1, idhoadon);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Timestamp timestamp = rs.getTimestamp("giove");
                if (timestamp != null) {
                    gioVe = timestamp.toLocalDateTime();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gioVe;
    }

//  Cập nhật trạng thái và set giờ về cho hóa đơn trên db
    private void updatePaymentHoadon(int idhoadon) {
        LocalDateTime currentTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(currentTime);

        String query = "UPDATE hoadon SET trangthai = 'đã thanh toán', giove = ? WHERE idhd = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
            stmt.setTimestamp(1, timestamp);
            stmt.setInt(2, idhoadon);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateDoanhThuNgay(LocalDateTime gioDen, float tongTien) {
        int ngay = gioDen.getDayOfMonth();
        int thang = gioDen.getMonthValue();
        int nam = gioDen.getYear();
// Kiểm tra xem có ngày chưa nếu chưa có thì thêm ngày mới có rồi thì cập nhật doanh thu cho ngày đó
        if (!isDateExistsInDoanhThuNgay(ngay, thang, nam)) {
            addNewDoanhThuNgay(ngay, thang, nam, tongTien);
        } else {
            updateTongTienDoanhThuNgay(ngay, thang, nam, tongTien);
        }
    }
//  hàm kiểm tra dữ liệu doanh thu ngày n trong db bảng doanh thu ngày
    private boolean isDateExistsInDoanhThuNgay(int ngay, int thang, int nam) {
        boolean exists = false;
        String query = "SELECT COUNT(*) AS count FROM doanhthungay WHERE ngay = ? AND thang = ? AND nam = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
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
    private void addNewDoanhThuNgay(int ngay, int thang, int nam, float tongTien) {
        String query = "INSERT INTO doanhthungay (nam, thang, ngay, tientheongay) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
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
    private void updateTongTienDoanhThuNgay(int ngay, int thang, int nam, float tongTien) {
        String query = "UPDATE doanhthungay SET tientheongay = tientheongay + ? WHERE ngay = ? AND thang = ? AND nam = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
            stmt.setFloat(1, tongTien);
            stmt.setInt(2, ngay);
            stmt.setInt(3, thang);
            stmt.setInt(4, nam);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//   Tương tự với Năm  và tháng
    private void updateOrInsertDoanhThu(LocalDateTime gioDen, float tien) {
        int year = gioDen.getYear();
        int month = gioDen.getMonthValue();
        
        boolean hasData = checkDoanhThuExist(year, month);
        
        if (hasData) {
            updateDoanhThu(year, month, tien);
        } else {
            insertDoanhThu(year, month, tien);
        }
    }
//  Hàm kiểm tra doanh thu năm tháng trong bảng doanhthu 
    private boolean checkDoanhThuExist(int year, int month) {
        boolean exists = false;
        String query = "SELECT COUNT(*) AS count FROM doanhthu WHERE nam = ? AND thang = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
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
    private void updateDoanhThu(int year, int month, float tien) {
        String query = "UPDATE doanhthu SET tien = tien + ? WHERE nam = ? AND thang = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
            stmt.setFloat(1, tien);
            stmt.setInt(2, year);
            stmt.setInt(3, month);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//  thêm mới dữ liệu vào bảng doanhthu
    private void insertDoanhThu(int year, int month, float tien) {
        String query = "INSERT INTO doanhthu (nam, thang, tien) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
            stmt.setInt(1, year);
            stmt.setInt(2, month);
            stmt.setFloat(3, tien);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//  Xử lý view khi xác nhận thêm hóa đơn chú ý khi thêm ws	Order
    private void handleOrderAction() {
        hdmodel=view.getHoaDon();
        ctmodel=view.getCTHD();
        String loaiMon=ctmodel.loaiMon;
        String tenMon=ctmodel.tenMon;
        int soLuong=ctmodel.soLuong;
        String tenBan= hdmodel.tenBan;
        String khuVuc = hdmodel.khuVuc;

            if (soLuong > 0) {
                float thanhTien = soLuong * giaMon(tenMon);
                addDataToDatabase(tenBan,tenMon,soLuong,thanhTien,loaiMon,khuVuc);
                view.clearTable();
                getTableInfoFromHoadon(tenBan, khuVuc);
                view.cb1.setSelectedIndex(0);
                    view.cb2.setSelectedIndex(0);
                    view.spinnerModel.setValue(0);
            } else {
                view.displayMessage("Vui lòng chọn số lượng!");
            }

    }

//  xử lý khi chọn 1 thể loại từ view
    private void handleCategorySelection() {
        String selectedTheloai = (String) view.cb1.getSelectedItem();
        if (selectedTheloai != null) {
                loadmenu();
//            }
        }
	}
   
//    Lấy ra giá món từ bảng thực đơn trên db
    private float giaMon(String tenmon) {
        float gia = 0.0f;
        String query = "SELECT giathanh FROM thucdon WHERE tenmon = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
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
//    Thêm 1 hóa đơn mới vào db trả về idhd chú ý khi chuyển đổi sang method ws
    private int addNewHoaDon(String tenban, String khuVuc, float thanhtien) {
        int idhoadon = -1;
        LocalDateTime currentTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(currentTime);

        String query = "INSERT INTO hoadon (idhd, idnv, tenban, gioden, giove, tongtien, khuvuc, trangthai) VALUES (null, null, ?, ?, null, ?, ?, 'chưa thanh toán')";        
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, tenban);
            stmt.setTimestamp(2, timestamp);
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
//  xử lý khi thêm dữ liệu vào db khi xác nhận hóa đơn (chú ý khi thêm method ws)
    private void addDataToDatabase(String tenban, String tenmon, int soluong, float thanhtien, String loaiMon, String khuVuc) {
        boolean hasUnpaidHoadon = false; 

        ArrayList<Integer> idhoadons = getAllHoadonIDs(tenban, khuVuc);

        // Duyệt qua tất cả các idhoadon
        for (int idhoadon : idhoadons) {
            String trangthai = getHoadonStatus(idhoadon);
            if (trangthai.equals("chưa thanh toán")) {
             
                hasUnpaidHoadon = true;

                boolean isExisting = checkIfItemExistsInOrder(idhoadon, tenmon);

                if (isExisting) {
                    updateExistingItemInOrder(idhoadon, tenmon, soluong, thanhtien, loaiMon);
                    
                } else {
                    addChitiethdAndUpdateTongtien(idhoadon, tenmon, soluong, thanhtien, loaiMon);
                }
            }
        }

        if (!hasUnpaidHoadon) {
            int newHoadonID = addNewHoaDon(tenban, khuVuc, thanhtien);
            addChitiethdAndUpdateTongtien(newHoadonID, tenmon, soluong, thanhtien, loaiMon);
        }
    }
//    Lấy tất cả các ID hóa đơn từ db theo tên bàn
    private ArrayList<Integer> getAllHoadonIDs(String tenban, String khuVuc) {
        ArrayList<Integer> idhoadons = new ArrayList<>();

        String query = "SELECT idhd FROM hoadon WHERE tenban = ? AND khuvuc = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
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
//    Lất trạng thái của idhoadon từ db
    private String getHoadonStatus(int idhoadon) {
        String trangthai = "";
        String query = "SELECT trangthai FROM hoadon WHERE idhd = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
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
//  Kiểm tra dữ liệu chi tiết hóa đơn đã tồn tại hay chưa của hóa đơn đang kiểm tra
    private boolean checkIfItemExistsInOrder(int idhoadon, String tenmon) {
        String query = "SELECT COUNT(*) AS count FROM chitiethd WHERE idhd = ? AND tenmon = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
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
//    Cập nhật chi tiết hóa đơn của hóa đơn đã tồn tại trong db
    private void updateExistingItemInOrder(int idhoadon, String tenmon, int soluong, float thanhtien, String loaiMon) {
        
    	String query = "UPDATE chitiethd SET soluong = soluong + ?, thanhtien = thanhtien + ? WHERE idhd = ? AND tenmon = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
            stmt.setInt(1, soluong);
            stmt.setFloat(2, thanhtien);
            stmt.setInt(3, idhoadon);
            stmt.setString(4, tenmon);
            stmt.executeUpdate();

            float totalAmount = calculateTotalAmount(idhoadon);

            updateTotalAmount(idhoadon, totalAmount);

            view.updateNewTable(loaiMon, tenmon, soluong, giaMon(tenmon), thanhtien); // Gọi phương thức để hiển thị dữ liệu lên bảng
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    Thêm mới vào db 1 chi tiết hóa đơn
    private void addChitiethdAndUpdateTongtien(int idhoadon, String tenmon, int soluong, float thanhtien, String loaiMon) {
        if(soluong<=0) {
        	return;
        }
    	String query = "INSERT INTO chitiethd (idhd, tenmon, soluong, thanhtien, loaimon) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
            stmt.setInt(1, idhoadon);
            stmt.setString(2, tenmon);
            stmt.setInt(3, soluong);
            stmt.setFloat(4, thanhtien);
            stmt.setString(5, loaiMon);
            stmt.executeUpdate();

            float totalAmount = calculateTotalAmount(idhoadon);

            updateTotalAmount(idhoadon, totalAmount);

            view.updateNewTable(loaiMon, tenmon, soluong, giaMon(tenmon), thanhtien); // Gọi phương thức để hiển thị dữ liệu lên bảng
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    Tính tổng tiền các món đã gọi từ cột thành tiền trong cthd có idhd giống nhau
    private float calculateTotalAmount(int idhoadon) {
        float totalAmount = 0.0f;
        String query = "SELECT SUM(thanhtien) AS tongtien FROM chitiethd WHERE idhd = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
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
// cập nhật tông tiền nếu bàn đã order thêm món ăn vào chi tiết hóa đơn
    private void updateTotalAmount(int idhoadon, float totalAmount) {
        String query = "UPDATE hoadon SET tongtien = ? WHERE idhd = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
            stmt.setFloat(1, totalAmount);
            stmt.setInt(2, idhoadon);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    Hiển thị thông tin chi tiết lên bảng từ tên bàn, kiểm tra id và trạng thái là chưa thanh toán
    public void getTableInfoFromHoadon(String tenban, String khuvuc) {
        String query = "SELECT idhd, trangthai FROM hoadon WHERE tenban = ? AND khuvuc = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
            stmt.setString(1, tenban);
            stmt.setString(2, khuvuc);
            ResultSet rs = stmt.executeQuery();
            boolean hasUnpaidHoadon = false; 
            while (rs.next()) {
                int idhoadon = rs.getInt("idhd");
                String trangthai = rs.getString("trangthai");
                if (trangthai.equals("chưa thanh toán")) {
                    // Gọi phương thức để lấy thông tin của bàn từ idhoadon
                    getTableDetailsFromChitiethd(idhoadon);
//                    hdmodel.setIdHoaDon(idhoadon);
//                    ctmodel.setIdHoaDon(idhoadon);
                    float totalAmount = getTongTienByIdHoadon(idhoadon);
                    view.updateStatus(trangthai);
                    view.setTotalAmount(totalAmount);
                    hasUnpaidHoadon = true;
                } else {
                    view.clearTable();
                    view.updateStatus("");
                    view.clearTotalAmount();
                }
            }
            if (!hasUnpaidHoadon) {
                view.clearTable();
                view.updateStatus("");
                view.clearTotalAmount();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    Hiển thị thông tin chi tiết hd của 1 bàn
    private void getTableDetailsFromChitiethd(int idhoadon) {
        String query = "SELECT tenmon, loaimon, soluong, thanhtien FROM chitiethd WHERE idhd = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
            stmt.setInt(1, idhoadon);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                hdmodel = view.getHoaDon();
                String tenmon = rs.getString("tenmon");
                String loaimon = rs.getString("loaimon");
                int soluong = rs.getInt("soluong");
                float thanhtien = rs.getFloat("thanhtien");
                view.updateTableInfo(hdmodel.tenBan, hdmodel.khuVuc, tenmon, loaimon, soluong, giaMon(tenmon), thanhtien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    lấy tổng tiền ra để hiển thị lên view tổng tiền
    private float getTongTienByIdHoadon(int idhoadon) {
        float tongTien = 0.0f;
        String query = "SELECT tongtien FROM hoadon WHERE idhd = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
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
//   cập nhật lại view khi xóa thành công
    private void handleDeleteAction() {
        boolean deletedSuccessfully = deleteUnpaidHoadonOfCurrentTable();
        
        if (deletedSuccessfully) {
            view.displayMessage("Đã xóa thành công bàn ");
            view.clearTable();
            view.clearStatus();
            view.clearTotalAmount();
            view.cb1.setSelectedIndex(0);
            view.cb2.setSelectedIndex(0);
            view.spinnerModel.setValue(0);
        } else {
            view.displayMessage("Xóa không thành công");
        }
    }
//    Xóa 1 bàn chưa thanh toán xóa cả hóa đơn và chi tiết hóa đơn
    private boolean deleteUnpaidHoadonOfCurrentTable() {
    	  hdmodel = view.getHoaDon();
    	  String tenban = hdmodel.tenBan;
    	  String khuVuc = hdmodel.khuVuc;
    	  int idhoadon = getUnpaidHoadonID(tenban, khuVuc);

    	  if (idhoadon == -1) {
    	    return false; 
    	  }
    	  deleteChitiethd(idhoadon);
          // Xóa hóa đơn
          deleteHoadon(idhoadon);
    	  return true; 
}
//  lấy ra id hóa đơn của tên bàn chưa thanh toán
    private int getUnpaidHoadonID(String tenban, String khuVuc) {
        int idhoadon = -1;

        String query = "SELECT idhd FROM hoadon WHERE tenban = ? AND khuvuc = ? AND trangthai = 'chưa thanh toán'";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
            stmt.setString(1, tenban);
            stmt.setString(2, khuVuc);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idhoadon = rs.getInt("idhd");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idhoadon;
    }
//  Xóa chi tiết hd trên db
    private void deleteChitiethd(int idhoadon) {
        String query = "DELETE FROM chitiethd WHERE idhd = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
            stmt.setInt(1, idhoadon);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//  xóa hóa đơn trên db và cập nhật lại view ( chú ý khi thêm ws )
    private void deleteHoadon(int idhoadon) {
        String query = "DELETE FROM hoadon WHERE idhd = ?";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
            stmt.setInt(1, idhoadon);
            stmt.executeUpdate();
            view.clearStatus();
            view.clearTotalAmount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static java.util.List<ThucDon.Theloaimodel> getTheloai() {
        ThucDon.TdWs_Service service = new ThucDon.TdWs_Service();
        ThucDon.TdWs port = service.getTdWsPort();
        return port.getTheloai();
    }

    private static java.util.List<java.lang.String> getMenuItemsFromDatabase(java.lang.String theloai) {
        ThucDon.TdWs_Service service = new ThucDon.TdWs_Service();
        ThucDon.TdWs port = service.getTdWsPort();
        return port.getMenuItemsFromDatabase(theloai);
    }

    private static int getCurrentHoadonID(java.lang.String tenban, java.lang.String khuVuc, java.lang.String trangthai) {
        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
        HoaDon.HoadonWs port = service.getHoadonWsPort();
        return port.getCurrentHoadonID(tenban, khuVuc, trangthai);
    }


}

