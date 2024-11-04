package Controller;

import NhanVien.Nvmodel;
import View.NhanVienView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QLyNhanVienCtrl implements ActionListener{
    NhanVienView v;
    connectdb db;
    JFrame j;
    List<Nvmodel> arr;
    public QLyNhanVienCtrl( NhanVienView v, connectdb db) {
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
        arr = getNhanvien();
        int i = 0;
        v.model.setRowCount(0);
        for (Nvmodel c : arr) {
            i++;
            v.model.addRow(new Object[]{ c.getManv(), c.getHoten(),c.getGioitinh() , c.getChucvu(), c.getSdt(),c.getQuequan()});
        }
    }
//     public boolean checkID(String id){
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//
//        try {
//            connection = connectdb.getConnection();
//            if (connection != null) {
//                String query = "SELECT * FROM nhanvien WHERE manv = ?";
//                statement = connection.prepareStatement(query);
//                statement.setString(1, id);
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

//     private void loadDataFromDatabase() {
//       load();
//        
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    class add_nv_listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(kt(v.txt_manv.getText())){
                JOptionPane.showMessageDialog(null, "ID đã tồn tại. Vui lòng nhập lại","Thông báo",JOptionPane.WARNING_MESSAGE);
                return;
            }
            String ma = v.getMa(); // Lấy văn bản tìm kiếm từ giao diện
            String ten = v.getTen();
            String phone = v.getsdt();
            String address=v.getDc();
            if (ma.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã sản phẩm. Vui lòng nhập mã sản phẩm", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
             if (ten.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên sản phẩm. Vui lòng nhập tên sản phẩm", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
             
             if(phone.isEmpty()){
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập số điện thoại. Vui lòng nhập lại","Thông báo",JOptionPane.WARNING_MESSAGE);
                return;
            
          
            } else if (!phone.matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null, "Số điện thoại chỉ được chứa số. Vui lòng nhập lại","Thông báo",JOptionPane.WARNING_MESSAGE);
                return;
            }
             if(address.isEmpty()){
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập địa chỉ. Vui lòng nhập lại","Thông báo",JOptionPane.WARNING_MESSAGE);
                return;
            }
              if (kt(v.txt_manv.getText())) {
                JOptionPane.showMessageDialog(null, "ID đã tồn tại. Vui lòng nhập lại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

                String gioiTinh = v.cb_nam.isSelected() ? "Nam" : "Nữ";
                getThemnv(v.txt_manv.getText(),v.txt_ten.getText(),gioiTinh, (String) v.cbb_cv.getSelectedItem(),v.txt_sdt.getText(),v.txt_qq.getText());

                        v.txt_manv.setText("");
                        v.txt_ten.setText("");
                        v.txt_qq.setText("");
                        v.txt_sdt.setText("");
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
                String sex=table.getValueAt(selectedRow, 2).toString();
                String Cv=table.getValueAt(selectedRow, 3).toString();
                String phone=table.getValueAt(selectedRow, 4).toString();
                String address=table.getValueAt(selectedRow,5).toString();
//                String image=table.getValueAt(selectedRow,6).toString();
                deleteDataFromDatabase(id);//xoa du lieu tu csdl
                ((DefaultTableModel)table.getModel()).removeRow(selectedRow);//xoa dong duoc chon trong bang
            }
        }

        private void deleteDataFromDatabase(String id) {
            
                    int confirmed = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa nhân viên này ?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                    if (confirmed == JOptionPane.YES_OPTION){
                        getDeletenv(id);
                        JOptionPane.showMessageDialog(null,"Xóa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                            v.txt_manv.setText("");
                            v.txt_ten.setText("");
                            v.txt_qq.setText("");
                            v.cbb_cv.setSelectedItem("");
                            v.txt_sdt.setText("");
                            load();
                    }
                }
    } 
    
    class update_nv_listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          
            String ma = v.getMa(); // Lấy văn bản tìm kiếm từ giao diện
            String ten = v.getTen();
            String phone = v.getsdt();
            String address=v.getDc();
            if (ma.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã sản phẩm. Vui lòng nhập mã sản phẩm", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
             if (ten.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên sản phẩm. Vui lòng nhập tên sản phẩm", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
             
             if(phone.isEmpty()){
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập số điện thoại. Vui lòng nhập lại","Thông báo",JOptionPane.WARNING_MESSAGE);
                return;
            
          
            } else if (!phone.matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null, "Số điện thoại chỉ được chứa số. Vui lòng nhập lại","Thông báo",JOptionPane.WARNING_MESSAGE);
                return;
            }
             if(address.isEmpty()){
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập địa chỉ. Vui lòng nhập lại","Thông báo",JOptionPane.WARNING_MESSAGE);
                return;
            }
       
                String gioiTinh = v.cb_nam.isSelected() ? "Nam" : "Nữ";
                getUpdatenv(v.txt_manv.getText(),v.txt_ten.getText(),gioiTinh, (String) v.cbb_cv.getSelectedItem(),v.txt_sdt.getText(),v.txt_qq.getText());
                        JOptionPane.showMessageDialog(null,"Cập nhật thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                            v.txt_manv.setText("");
                            v.txt_ten.setText("");
                            v.txt_qq.setText("");
                            v.txt_sdt.setText("");
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
         arr = new ArrayList<Nvmodel>();
            arr = findnv(v.txt_tk.getText());
            int i = 0;
            v.model.setRowCount(0);
            for (Nvmodel c : arr) {
                i++;
                v.model.addRow(new Object[]{i, c.getManv(), c.getHoten(),c.getGioitinh() , c.getChucvu(), c.getSdt(),c.getQuequan()}); 
            }
        
       
    }
       
    }
        public boolean kt(String a) {
        boolean t = false;
        arr = getNhanvien();
        for (Nvmodel n1 : arr) {
            t = n1.getManv().equals(a);
        }
        return t;
    }
//
//    public boolean check_null() {
//        boolean t = false;
//        t = n.t_ma.getText().equals("") || n.t_ten.getText().equals("") || n.t_ngaysinh.getText().equals("") || n.t_dienthoai.getText().equals("") || n.t_luong.getText().equals("");
//        return t;
//    }
    private static java.util.List<NhanVien.Nvmodel> getNhanvien() {
        NhanVien.NvWs_Service service = new NhanVien.NvWs_Service();
        NhanVien.NvWs port = service.getNvWsPort();
        return port.getNhanvien();
    }

    private static void getThemnv(java.lang.String a, java.lang.String b, java.lang.String c, java.lang.String d, java.lang.String e, java.lang.String f) {
        NhanVien.NvWs_Service service = new NhanVien.NvWs_Service();
        NhanVien.NvWs port = service.getNvWsPort();
        port.getThemnv(a, b, c, d, e, f);
    }
    private static java.util.List<NhanVien.Nvmodel> findnv(java.lang.String a) {
        NhanVien.NvWs_Service service = new NhanVien.NvWs_Service();
        NhanVien.NvWs port = service.getNvWsPort();
        return port.findnv(a);
    }

    private static void getDeletenv(java.lang.String a) {
        NhanVien.NvWs_Service service = new NhanVien.NvWs_Service();
        NhanVien.NvWs port = service.getNvWsPort();
        port.getDeletenv(a);
    }

    private static void getUpdatenv(java.lang.String a, java.lang.String b, java.lang.String c, java.lang.String d, java.lang.String e, java.lang.String f) {
        NhanVien.NvWs_Service service = new NhanVien.NvWs_Service();
        NhanVien.NvWs port = service.getNvWsPort();
        port.getUpdatenv(a, b, c, d, e, f);
    }

    private static boolean getCheck(java.lang.String a) {
        NhanVien.NvWs_Service service = new NhanVien.NvWs_Service();
        NhanVien.NvWs port = service.getNvWsPort();
        return port.getCheck(a);
    }
    
}
    


    
