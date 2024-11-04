package Controller;

//import Model.ChiTietHDModel;
//import Model.HoaDonModel;
import ChitietHD.Chitiethdmodel;
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
import java.time.format.DateTimeFormatter;
import java.util.List;


public class HoaDonController implements ActionListener {
    private HoaDonModel hdmodel;
    private ChiTietHDModel ctmodel;
    private HomeView view;
    private connectdb dbConnect;
    List<Theloaimodel> arrtl;
    List<String> menu;
    String selectedCategory;

    public HoaDonController( HomeView view, connectdb dbConnect) {
//        this.hdmodel = hdmodel;
//        this.ctmodel=ctmodel;
        this.view = view;
        this.dbConnect = dbConnect;
        loadCategories();
        loadmenu();
        


        view.XacNhanListener(this);
        view.cb1.addActionListener(this);
        view.XoaBanListenner(this);
        view.ThanhtoanListenner(this);
        view.XoaMonListener(this);
        view.SuaItemListener(this);
        
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
//      
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
                view.displayMessage("Xóa 1 món thành công.");
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
    List<Chitiethdmodel> arr;

    public void deleteOrderedItem(int idhoadon, String tenmon, Float thanhtien) {
        float tongtien = getTongTienByIdHoadon(idhoadon);
        tongtien -= thanhtien;
        updateTotalAmount(idhoadon, tongtien);
        deleteChiTietHD(idhoadon, tenmon);
        int count = countOrderDetails(idhoadon);
        if (count == 0) {
            deleteHoadon(idhoadon);
        }
}

    public void deleteSuaChitietHD(int idhoadon, String tenmon, Float thanhtien) {
        float tongtien = getTongTienByIdHoadon(idhoadon);
        // Trừ thanhtien từ tongtien
        tongtien -= thanhtien;
        updateTotalAmount(idhoadon, tongtien);
        deleteChiTietHD(idhoadon, tenmon);
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
        int idhoadon = getIDInfoFromHoadon(tenban, khuVuc);

        if (idhoadon != -1) {
            float tongtien = getTongTienByIdHoadon(idhoadon);
            String trangthai = getHoadonStatus(idhoadon);

            if (trangthai.equals("chưa thanh toán")) {
                updatePaymentHoadon(idhoadon);
                String gioDen = getgioden(idhoadon);
                String gioVe =getgiove(idhoadon);

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
//    private LocalDateTime getGioDen(int idhoadon) {
//        LocalDateTime gioDen = null;
//        String query = "SELECT gioden FROM hoadon WHERE idhd = ?";
//        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
//            stmt.setInt(1, idhoadon);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                Timestamp timestamp = rs.getTimestamp("gioden");
//                if (timestamp != null) {
//                    gioDen = timestamp.toLocalDateTime();
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return gioDen;
//    }
//    private LocalDateTime getGioVe(int idhoadon) {
//        LocalDateTime gioVe = null;
//        String query = "SELECT giove FROM hoadon WHERE idhd = ?";
//        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
//            stmt.setInt(1, idhoadon);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                Timestamp timestamp = rs.getTimestamp("giove");
//                if (timestamp != null) {
//                    gioVe = timestamp.toLocalDateTime();
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return gioVe;
//    }

    private void updateDoanhThuNgay(String gioden, float tongTien) {
//        String gioden="";
//        gioden = gioDen.toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime gioDen = LocalDateTime.parse(gioden, formatter);
        int ngay = gioDen.getDayOfMonth();
        int thang = gioDen.getMonthValue();
        int nam = gioDen.getYear();
// Kiểm tra xem có ngày chưa nếu chưa có thì thêm ngày mới có rồi thì cập nhật doanh thu cho ngày đó
        if (!isDateExistInDoanhThuNgay(ngay, thang, nam)) {
            addNewDoanhThuNgay(ngay, thang, nam, tongTien);
        } else {
            updateTongTienDoanhThuNgay(ngay, thang, nam, tongTien);
        }
    }

//   Tương tự với Năm  và tháng
    private void updateOrInsertDoanhThu(String giove, float tien) {
//        LocalDateTime gioden;
//        gioden = gioDen.toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime gioVe = LocalDateTime.parse(giove, formatter);
        int year = gioVe.getYear();
        int month = gioVe.getMonthValue();
        
        boolean hasData = checkDoanhThuExist(year, month);
        
        if (hasData) {
            updateDoanhthu(year, month, tien);
        } else {
            insertDoanhthu(year, month, tien);
        }
    }


//  Xử lý view khi xác nhận thêm hóa đơn chú ý khi thêm ws	Order
    public void handleOrderAction() {
        hdmodel=view.getHoaDon();
        ctmodel=view.getCTHD();
        String loaiMon=ctmodel.loaiMon;
        String tenMon=ctmodel.tenMon;
        int soLuong=ctmodel.soLuong;
        String tenBan= hdmodel.tenBan;
        String khuVuc = hdmodel.khuVuc;

        if (soLuong > 0) {
            float thanhTien = soLuong * giaMon(tenMon);
//                addDataToDatabase(tenBan,tenMon,soLuong,thanhTien,loaiMon,khuVuc);
            boolean hasUnpaidHoadon = false; 
            idhoadons = getAllHoadonIDs(tenBan, khuVuc);
        // Duyệt qua tất cả các idhoadon
            for (int idhoadon : idhoadons) {
                String trangthai = getHoadonStatus(idhoadon);
                if (trangthai.equals("chưa thanh toán")) {
//                    load(idhoadon);
                    hasUnpaidHoadon = true;
                    boolean isExisting = checkIfItemExistsInOrder(idhoadon, tenMon);
                    if (isExisting) {
                        updateExistingItemInOrder(idhoadon, tenMon, soLuong, thanhTien, loaiMon);
                        float total = calculateTotalAmount(idhoadon);
                        updateTotalAmount(idhoadon, total);
                    } else {
                        addChitiethdAndUpdateTongtien(idhoadon, tenMon, soLuong, thanhTien, loaiMon);
                        
                        getTableInfoFromHoadon(tenBan, khuVuc);
                    }
                }
            }

            if (!hasUnpaidHoadon) {
                LocalDateTime gioden = LocalDateTime.now();
    //            Timestamp timestamp = Timestamp.valueOf(gioden);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDateTime = gioden.format(formatter);
                int newHoadonID = addNewHoaDon(tenBan,formattedDateTime, khuVuc, thanhTien);
                
                addChitiethdAndUpdateTongtien(newHoadonID, tenMon, soLuong, thanhTien, loaiMon);
                getTableInfoFromHoadon(tenBan, khuVuc);
//                load(newHoadonID);
                
            }
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
    List<Integer> idhoadons;
//    Hiển thị thông tin chi tiết lên bảng từ tên bàn, kiểm tra id và trạng thái là chưa thanh toán
    public void getTableInfoFromHoadon(String tenban, String khuvuc) {
        
        int id;
        String trangthai;
        id = getIDInfoFromHoadon(tenban, khuvuc);
        trangthai = getStatusInfoFromHoadon(tenban, khuvuc);
        boolean hasUnpaidHoadon = false; 
//        for(Hd1 cthdtt : idtt){
//            int id = cthdtt.getIdhd1();
            
//            String trangthai =cthdtt.getTthd1();
            if (trangthai.equals("chưa thanh toán")) {
                    // Gọi phương thức để lấy thông tin của bàn từ idhoadon
//                getTableDetailsFromChitiethd(id);
//                id = getCurrentHoadonID(tenban, khuvuc, trangthai);
                arr = getTableDetailsFromChitiethd(id);
                int i = 0;
                view.tableModel.setRowCount(0);
                for (Chitiethdmodel c : arr) {
                    Float dongia = giaMon(c.getTenmon());        
                    
                    view.updateNewTable(c.getTheloai(),c.getTenmon(),c.getSoluong(),dongia,c.getThanhtien());
//                    view.tableModel.addRow(new Object[]{i,c.getTheloai(),c.getTenmon(),c.getSoluong(),dongia,c.getThanhtien()});
                    i++;
                }
                float totalAmount = calculateTotalAmount(id);
                view.updateStatus(trangthai);
                view.setTotalAmount(totalAmount);
                hasUnpaidHoadon = true;
            } else {
                view.clearTable();
                view.updateStatus("");
                view.clearTotalAmount();
            }
//        }
        if (hasUnpaidHoadon==false) {
            view.clearTable();
            view.updateStatus("");
            view.clearTotalAmount();

        }
        
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
        int idhoadon = getIDInfoFromHoadon(tenban, khuVuc);


        if (idhoadon == -1) {
          return false; 
        }
        deleteCTHD(idhoadon);
        // Xóa hóa đơn
        deleteHoadon(idhoadon);
        return true; 
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

    private static Float giaMon(java.lang.String tenmon) {
        ThucDon.TdWs_Service service = new ThucDon.TdWs_Service();
        ThucDon.TdWs port = service.getTdWsPort();
        return port.giaMon(tenmon);
    }

    private static int countOrderDetails(int idhoadon) {
        ChitietHD.ChitiethdWs_Service service = new ChitietHD.ChitiethdWs_Service();
        ChitietHD.ChitiethdWs port = service.getChitiethdWsPort();
        return port.countOrderDetails(idhoadon);
    }

    private static void deleteChiTietHD(int idhoadon, java.lang.String tenmon) {
        ChitietHD.ChitiethdWs_Service service = new ChitietHD.ChitiethdWs_Service();
        ChitietHD.ChitiethdWs port = service.getChitiethdWsPort();
        port.deleteChiTietHD(idhoadon, tenmon);
    }

    private static void updatePaymentHoadon(int idhoadon) {
        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
        HoaDon.HoadonWs port = service.getHoadonWsPort();
        port.updatePaymentHoadon(idhoadon);
    }

    

    private static java.util.List<java.lang.Integer> getAllHoadonIDs(java.lang.String tenban, java.lang.String khuVuc) {
        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
        HoaDon.HoadonWs port = service.getHoadonWsPort();
        return port.getAllHoadonIDs(tenban, khuVuc);
    }

    private static String getHoadonStatus(int idhoadon) {
        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
        HoaDon.HoadonWs port = service.getHoadonWsPort();
        return port.getHoadonStatus(idhoadon);
    }

    private static boolean checkIfItemExistsInOrder(int idhoadon, java.lang.String tenmon) {
        ChitietHD.ChitiethdWs_Service service = new ChitietHD.ChitiethdWs_Service();
        ChitietHD.ChitiethdWs port = service.getChitiethdWsPort();
        return port.checkIfItemExistsInOrder(idhoadon, tenmon);
    }

    private static void updateExistingItemInOrder(int idhoadon, java.lang.String tenmon, int soluong, float thanhtien, java.lang.String loaiMon) {
        ChitietHD.ChitiethdWs_Service service = new ChitietHD.ChitiethdWs_Service();
        ChitietHD.ChitiethdWs port = service.getChitiethdWsPort();
        port.updateExistingItemInOrder(idhoadon, tenmon, soluong, thanhtien, loaiMon);
    }

    private static void addChitiethdAndUpdateTongtien(int idhoadon, java.lang.String tenmon, int soluong, float thanhtien, java.lang.String loaiMon) {
        ChitietHD.ChitiethdWs_Service service = new ChitietHD.ChitiethdWs_Service();
        ChitietHD.ChitiethdWs port = service.getChitiethdWsPort();
        port.addChitiethdAndUpdateTongtien(idhoadon, tenmon, soluong, thanhtien, loaiMon);
    }

    private static float calculateTotalAmount(int idhoadon) {
        ChitietHD.ChitiethdWs_Service service = new ChitietHD.ChitiethdWs_Service();
        ChitietHD.ChitiethdWs port = service.getChitiethdWsPort();
        return port.calculateTotalAmount(idhoadon);
    }

    private static void updateTotalAmount(int idhoadon, float totalAmount) {
        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
        HoaDon.HoadonWs port = service.getHoadonWsPort();
        port.updateTotalAmount(idhoadon, totalAmount);
    }

    private static float getTongTienByIdHoadon(int idhoadon) {
        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
        HoaDon.HoadonWs port = service.getHoadonWsPort();
        return port.getTongTienByIdHoadon(idhoadon);
    }

    private static float getUnpaidHoadonID(java.lang.String tenban, java.lang.String khuVuc) {
        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
        HoaDon.HoadonWs port = service.getHoadonWsPort();
        return port.getUnpaidHoadonID(tenban, khuVuc);
    }

    private static void deleteHoadon(int idhoadon) {
        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
        HoaDon.HoadonWs port = service.getHoadonWsPort();
        port.deleteHoadon(idhoadon);
    }

    private static void deleteCTHD(int idhoadon) {
        ChitietHD.ChitiethdWs_Service service = new ChitietHD.ChitiethdWs_Service();
        ChitietHD.ChitiethdWs port = service.getChitiethdWsPort();
        port.deleteCTHD(idhoadon);
    }

    

    
    private static void insertDoanhthu(int year, int month, float tien) {
        DoanhThu.DtWs_Service service = new DoanhThu.DtWs_Service();
        DoanhThu.DtWs port = service.getDtWsPort();
        port.insertDoanhthu(year, month, tien);
    }

    private static void updateDoanhthu(int year, int month, float tien) {
        DoanhThu.DtWs_Service service = new DoanhThu.DtWs_Service();
        DoanhThu.DtWs port = service.getDtWsPort();
        port.updateDoanhthu(year, month, tien);
    }

    private static boolean checkDoanhThuExist(int year, int month) {
        DoanhThu.DtWs_Service service = new DoanhThu.DtWs_Service();
        DoanhThu.DtWs port = service.getDtWsPort();
        return port.checkDoanhThuExist(year, month);
    }

    private static void updateTongTienDoanhThuNgay(int ngay, int thang, int nam, float tongTien) {
        DoanhThuNgay.DtngayWs_Service service = new DoanhThuNgay.DtngayWs_Service();
        DoanhThuNgay.DtngayWs port = service.getDtngayWsPort();
        port.updateTongTienDoanhThuNgay(ngay, thang, nam, tongTien);
    }

    private static boolean isDateExistInDoanhThuNgay(int ngay, int thang, int nam) {
        DoanhThuNgay.DtngayWs_Service service = new DoanhThuNgay.DtngayWs_Service();
        DoanhThuNgay.DtngayWs port = service.getDtngayWsPort();
        return port.isDateExistInDoanhThuNgay(ngay, thang, nam);
    }

    private static void addNewDoanhThuNgay(int ngay, int thang, int nam, float tongTien) {
        DoanhThuNgay.DtngayWs_Service service = new DoanhThuNgay.DtngayWs_Service();
        DoanhThuNgay.DtngayWs port = service.getDtngayWsPort();
        port.addNewDoanhThuNgay(ngay, thang, nam, tongTien);
    }

//    private static HoaDon.Timestamp getgioden(int idhoadon) {
//        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
//        HoaDon.HoadonWs port = service.getHoadonWsPort();
//        return port.getgioden(idhoadon);
//    }

    private static int addNewHoaDon(java.lang.String tenban, java.lang.String gioden, java.lang.String khuvuc, float tongtien) {
        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
        HoaDon.HoadonWs port = service.getHoadonWsPort();
        return port.addNewHoaDon(tenban, gioden, khuvuc, tongtien);
    }

    private static java.util.List<ChitietHD.Chitiethdmodel> getTableDetailsFromChitiethd(int idhoadon) {
        ChitietHD.ChitiethdWs_Service service = new ChitietHD.ChitiethdWs_Service();
        ChitietHD.ChitiethdWs port = service.getChitiethdWsPort();
        return port.getTableDetailsFromChitiethd(idhoadon);
    }

    private static int getIDInfoFromHoadon(java.lang.String tenban, java.lang.String khuvuc) {
        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
        HoaDon.HoadonWs port = service.getHoadonWsPort();
        return port.getIDInfoFromHoadon(tenban, khuvuc);
    }

    private static String getStatusInfoFromHoadon(java.lang.String tenban, java.lang.String khuvuc) {
        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
        HoaDon.HoadonWs port = service.getHoadonWsPort();
        return port.getStatusInfoFromHoadon(tenban, khuvuc);
    }

    private static String getgioden(int idhoadon) {
        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
        HoaDon.HoadonWs port = service.getHoadonWsPort();
        return port.getgioden(idhoadon);
    }

    private static String getgiove(int idhoadon) {
        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
        HoaDon.HoadonWs port = service.getHoadonWsPort();
        return port.getgiove(idhoadon);
    }

    


}

