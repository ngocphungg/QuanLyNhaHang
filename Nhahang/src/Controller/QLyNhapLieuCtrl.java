package Controller;
import java.util.List;

import SanPham.Spmodel;
import View.NhapLieuView;
//import com.mysql.cj.result.Row;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
//import javax.swing.SwingUtilities;
//import javax.swing.event.DocumentListener;
//import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
//import javax.swing.text.AttributeSet;
//import javax.swing.text.BadLocationException;
//import javax.swing.text.Document;
//import javax.swing.text.Element;
//import javax.swing.text.Position;
//import javax.swing.text.Segment;
//import static org.apache.poi.hssf.usermodel.HeaderFooter.date;
//import org.apache.poi.sl.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class QLyNhapLieuCtrl implements ActionListener{
    List<Spmodel> arr;
    NhapLieuView v;
    connectdb db;
    JFrame j;

    public QLyNhapLieuCtrl( NhapLieuView v, connectdb db) {
      
        this.v = v;
        this.db = db;
        JTable table=v.getTable();
          load();
         
        v.timkiemActionListener(new search_nv_listener());
        v.themActionListener(new add_nv_listener());
        v.luuActionListener(new update_nv_listener());
        v.xoaActionListener(new delete_nv_listener(table));

    }
    public void load() {
        arr = getSanpham();
        int i = 0;
        v.model.setRowCount(0);
        for (Spmodel c : arr) {
            i++;
            v.model.addRow(new Object[]{ c.getMasp(), c.getTensp(), c.getNgaynhap(), c.getDonvi(), c.getSoluong(), c.getChiphi(), c.getTongchiphi()});
           
        }
    }
        public boolean kt(String a) {
        boolean t = false;
        arr = getSanpham();
        for (Spmodel n1 : arr) {
            t = n1.getMasp().equals(a);
        }
        return t;
    }

//    public boolean check_null() {
//        boolean t = false;
//        t = n.t_ma.getText().equals("") || n.t_ten.getText().equals("") || n.t_ngaysinh.getText().equals("") || n.t_dienthoai.getText().equals("") || n.t_luong.getText().equals("");
//        return t;
//    }
//    public boolean checkID(int id){
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//
//        try {
//            connection = connectdb.getConnection();
//            if (connection != null) {
//                String query = "SELECT * FROM nhaplieu WHERE masp = ?";
//                statement = connection.prepareStatement(query);
//                statement.setInt(1, id);
//                resultSet = statement.executeQuery();
//                
//                // Nếu resultSet không rỗng, tức là ID đã tồn tại
//                if (resultSet.next()) {
//                    return true;
//                }
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                if (resultSet != null) resultSet.close();
//                if (statement != null) statement.close();
//                if (connection != null) connection.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//        
//        return false;
//        
//    }



    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    class add_nv_listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String ma = v.getMa(); // Lấy văn bản tìm kiếm từ giao diện
            String ten = v.getTen();
            String chip = v.getCp();
            if (ma.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã sản phẩm. Vui lòng nhập mã sản phẩm", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
             if (ten.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên sản phẩm. Vui lòng nhập tên sản phẩm", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
              if (chip.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập chi phí sản phẩm. Vui lòng nhập", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }   

                  // Kiểm tra xem ID đã tồn tại trong cơ sở dữ liệu hay chưa
            if (kt(v.txt_masp.getText())) {
                JOptionPane.showMessageDialog(null, "ID đã tồn tại. Vui lòng nhập lại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
        Date ngayNhap = v.calendar.getDate(); // Lấy ngày từ JDateChooser
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng của ngày tháng
        String ngayNhapString = dateFormat.format(ngayNhap); // Chuyển đổi Date thành chuỗi String
        String donvi = String.valueOf(v.cbb_dv.getSelectedItem());
        int soluong = (int) v.sp_sl.getValue(); // Lấy giá trị từ JSpinner
//
        float chiphi = (float) 0.0; // Giá trị mặc định
        float tongchiphi = (float) 0.0; // Giá trị mặc định
//
//        // Kiểm tra và chuyển đổi txt_cp và txt_tcp thành số nếu chúng không rỗng
        String txtCpText = v.txt_cp.getText().trim();
        String txtTcpText = v.txt_tcp.getText().trim();
        if (!txtCpText.isEmpty()) {
            chiphi = Float.parseFloat(txtCpText);
        }
        if (!txtTcpText.isEmpty()) {
            tongchiphi = Float.parseFloat(txtTcpText);
        }
//
//        NhapLieuModel sp = new NhapLieuModel(ma, tensp, ngayNhap, donvi, soluong,chiphi, tongchiphi);
//        return sp;
            getThemsp(v.txt_masp.getText(),v.txt_tensp.getText(),ngayNhapString,donvi,soluong,chiphi,tongchiphi);
                        v.txt_masp.setText("");
                        v.txt_tensp.setText("");
                        v.txt_cp.setText("");
                        v.txt_tcp.setText("");
                        Date date = null;
                        v.calendar.setDate(date);
                        v.sp_sl.setValue(1);
                        v.cbb_dv.setSelectedItem("");
                      
                        load();
                        JOptionPane.showMessageDialog(null,"Thêm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                   
            
        }
    }
    class delete_nv_listener implements ActionListener{

        private JTable table;
        public delete_nv_listener(JTable table){
            this.table=table;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            
            int selectedRow=table.getSelectedRow();//chon 1 dong 
            if(selectedRow!=-1){
                String id=table.getValueAt(selectedRow, 0).toString();
                String name=table.getValueAt(selectedRow, 1).toString();
                String date=table.getValueAt(selectedRow, 2).toString();
                String dv=table.getValueAt(selectedRow, 3).toString();
                String number=table.getValueAt(selectedRow, 4).toString();
                String cp=table.getValueAt(selectedRow,5).toString();
                String tcp=table.getValueAt(selectedRow,6).toString();
                deleteDataFromDatabase(id);//xoa du lieu tu csdl
                ((DefaultTableModel)table.getModel()).removeRow(selectedRow);//xoa dong duoc chon trong bang
            }
        }

        private void deleteDataFromDatabase(String id) {
                        getDeletesp(id);
                        JOptionPane.showMessageDialog(null,"Xóa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        v.txt_masp.setText("");
                        v.txt_tensp.setText("");
                        v.txt_cp.setText("");
                        v.txt_tcp.setText("");
                        Date date=null;
                        v.calendar.setDate(date);
                        v.sp_sl.setValue(1);
                        v.cbb_dv.setSelectedItem("");
                        load();
        }
    }
   class update_nv_listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String ma = v.getMa(); // Lấy văn bản tìm kiếm từ giao diện
            String ten = v.getTen();
            String chip = v.getCp();
            if (ma.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã sản phẩm. Vui lòng nhập mã sản phẩm", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
             if (ten.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên sản phẩm. Vui lòng nhập tên sản phẩm", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
              if (chip.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập chi phí sản phẩm. Vui lòng nhập", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }   

                          Date ngayNhap =  v.calendar.getDate(); // Lấy ngày từ JDateChooser
                          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng của ngày tháng
                          String ngayNhapString = dateFormat.format(ngayNhap); // Chuyển đổi Date thành chuỗi String
        String donvi = String.valueOf(v.cbb_dv.getSelectedItem());
        int soluong = (int) v.sp_sl.getValue(); // Lấy giá trị từ JSpinner
//
        float chiphi = (float) 0.0; // Giá trị mặc định
        float tongchiphi = (float) 0.0; // Giá trị mặc định
//
//        // Kiểm tra và chuyển đổi txt_cp và txt_tcp thành số nếu chúng không rỗng
        String txtCpText = v.txt_cp.getText().trim();
        String txtTcpText = v.txt_tcp.getText().trim();
        if (!txtCpText.isEmpty()) {
            chiphi = Float.parseFloat(txtCpText);
        }
        if (!txtTcpText.isEmpty()) {
            tongchiphi = Float.parseFloat(txtTcpText);
        }
                    getUpdatesp(v.txt_masp.getText(),v.txt_tensp.getText(),ngayNhapString,donvi,soluong,chiphi,tongchiphi);
                        JOptionPane.showMessageDialog(null,"Cập nhật thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                            v.txt_masp.setText("");
                            v.txt_tensp.setText("");
                            v.txt_cp.setText("");
                            v.txt_tcp.setText("");
                            Date date=null;
                            v.calendar.setDate(date);
                            v.sp_sl.setValue(1);
                            v.cbb_dv.setSelectedItem("");
                            load();
            }
    }
   class search_nv_listener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        String searchText = v.getSearchText(); // Lấy văn bản tìm kiếm từ giao diện
        
        if (searchText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập từ khóa tìm kiếm.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
         arr = new ArrayList<Spmodel>();
            arr = findsp(v.txt_tk.getText());
            int i = 0;
            v.model.setRowCount(0);
            for (Spmodel c : arr) {
                i++;
                          v.model.addRow(new Object[]{ c.getMasp(), c.getTensp(),c.getNgaynhap() , c.getDonvi(), c.getSoluong(), c.getChiphi(), c.getTongchiphi()});

            }
            }
        }

    private static java.util.List<SanPham.Spmodel> findsp(java.lang.String a) {
        SanPham.SpWs_Service service = new SanPham.SpWs_Service();
        SanPham.SpWs port = service.getSpWsPort();
        return port.findsp(a);
    }

    private static boolean getCheck(java.lang.String a) {
        SanPham.SpWs_Service service = new SanPham.SpWs_Service();
        SanPham.SpWs port = service.getSpWsPort();
        return port.getCheck(a);
    }

    private static void getDeletesp(java.lang.String a) {
        SanPham.SpWs_Service service = new SanPham.SpWs_Service();
        SanPham.SpWs port = service.getSpWsPort();
        port.getDeletesp(a);
    }

    private static java.util.List<SanPham.Spmodel> getSanpham() {
        SanPham.SpWs_Service service = new SanPham.SpWs_Service();
        SanPham.SpWs port = service.getSpWsPort();
        return port.getSanpham();
    }

    private static void getThemsp(java.lang.String a, java.lang.String b, java.lang.String c, java.lang.String d, int e, float f, float g) {
        SanPham.SpWs_Service service = new SanPham.SpWs_Service();
        SanPham.SpWs port = service.getSpWsPort();
        port.getThemsp(a, b, c, d, e, f, g);
    }

    private static void getUpdatesp(java.lang.String a, java.lang.String b, java.lang.String c, java.lang.String d, int e, float f, float g) {
        SanPham.SpWs_Service service = new SanPham.SpWs_Service();
        SanPham.SpWs port = service.getSpWsPort();
        port.getUpdatesp(a, b, c, d, e, f, g);
    }

 
    
          
}


    

