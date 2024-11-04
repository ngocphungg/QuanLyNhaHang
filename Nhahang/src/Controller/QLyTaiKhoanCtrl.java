package Controller;



import SanPham.Spmodel;
import TaiKhoan.Tkmodel;
import View.TaiKhoanView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class QLyTaiKhoanCtrl implements ActionListener{
   
    TaiKhoanView v;
    connectdb db;
    List<Tkmodel> arr;
    JFrame j;

    public QLyTaiKhoanCtrl( TaiKhoanView v, connectdb db) {
      
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
        arr = getTaikhoan();
        int i = 0;
        v.model.setRowCount(0);
        for (Tkmodel c : arr) {
            i++;
            v.model.addRow(new Object[]{ c.getMatk(), c.getTentk(),c.getPass() , c.getQuyen()});
        }
    }
       public boolean kt(String a) {
        boolean t = false;
        arr = getTaikhoan();
        for (Tkmodel n1 : arr) {
            t = n1.getMatk().equals(a);
        }
        return t;
    }
//        public boolean checkID(int id){
//        Connection connection = null;
//        PreparedStatement statement = null; //Khởi tạo một đối tượng PreparedStatement để chuẩn bị và thực thi truy vấn SQL.
//        ResultSet resultSet = null; //Khởi tạo một đối tượng ResultSet để chứa kết quả trả về từ cơ sở dữ liệu.
//
//        try {
//            connection = connectdb.getConnection();
//            if (connection != null) {
//                String query = "SELECT * FROM taikhoan WHERE idtk = ?";
//                statement = connection.prepareStatement(query); //Chuẩn bị truy vấn SQL với kết nối đã thiết lập.
//                statement.setInt(1, id); //Thiết lập giá trị của tham số id vào truy vấn SQL.
//                resultSet = statement.executeQuery(); //Thực thi truy vấn SQL và lấy kết quả trả về vào đối tượng ResultSet.
//                
//                // Nếu resultSet không rỗng, tức là ID đã tồn tại trong csdl
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
            String mk = v.getMk();
            if (ma.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã tài khoản. Vui lòng nhập mã tài khoản", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
             if (ten.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên đăng nhập cho tài khoản. Vui lòng nhập tên đăng nhập", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
              if (mk.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bạn chưa nhập mật khẩu. Vui lòng nhập mật khẩu", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }   
            if(kt(v.txt_matk.getText()) ==  true ){
                JOptionPane.showMessageDialog(null, "ID đã tồn tại. Vui lòng nhập lại","Thông báo",JOptionPane.WARNING_MESSAGE);
                return;
            }

           getThemtk(v.txt_matk.getText(),v.txt_tentk.getText(),v.txt_mk.getText(),(String) v.cbb_q.getSelectedItem());
                        v.txt_matk.setText("");
                        v.txt_tentk.setText("");
                        v.txt_mk.setText("");
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
            
            int selectedRow=table.getSelectedRow();//Lấy ra chỉ số của dòng được chọn trong bảng table.
            if(selectedRow!=-1){
                String id=table.getValueAt(selectedRow, 0).toString();
                String name=table.getValueAt(selectedRow, 1).toString();
                String passw=table.getValueAt(selectedRow, 2).toString();
                String pquyen=table.getValueAt(selectedRow, 3).toString();
                deleteDataFromDatabase(id);//xoa du lieu tu csdl
                ((DefaultTableModel)table.getModel()).removeRow(selectedRow);//xoa dong duoc chon trong bang
            }
        }

        private void deleteDataFromDatabase(String id) {
          
                    int confirmed = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa sản phẩm này ?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                    if (confirmed == JOptionPane.YES_OPTION){
                   
                            getDeletetk(id);
                   
                        JOptionPane.showMessageDialog(null,"Xóa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                            v.txt_matk.setText("");
                            v.txt_tentk.setText("");
                            v.txt_mk.setText("");
                            v.cbb_q.setSelectedItem("");
                           
                   
        }
    }
    }
    class update_nv_listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        String ma = v.getMa(); // Lấy văn bản tìm kiếm từ giao diện
        String ten = v.getTen();
        String mk = v.getMk();
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã tài khoản. Vui lòng nhập mã tài khoản", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
         if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên đăng nhập cho tài khoản. Vui lòng nhập tên đăng nhập", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
          if (mk.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập mật khẩu. Vui lòng nhập mật khẩu", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
           getUpdatetk(v.txt_matk.getText(),v.txt_tentk.getText(),v.txt_mk.getText(),(String) v.cbb_q.getSelectedItem());
          
                        JOptionPane.showMessageDialog(null,"Cập nhật thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                            v.txt_matk.setText("");
                            v.txt_tentk.setText("");
                            v.txt_mk.setText("");
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
         arr = new ArrayList<Tkmodel>();
            arr = findtk(v.txt_tk.getText());
            int i = 0;
            v.model.setRowCount(0);
            for (Tkmodel c : arr) {
                i++;
               v.model.addRow(new Object[]{ c.getMatk(), c.getTentk(),c.getPass() , c.getQuyen()});
            }
        
       
    }
    }

    private static java.util.List<TaiKhoan.Tkmodel> findtk(java.lang.String a) {
        TaiKhoan.TkWs_Service service = new TaiKhoan.TkWs_Service();
        TaiKhoan.TkWs port = service.getTkWsPort();
        return port.findtk(a);
    }

    private static boolean getCheck(java.lang.String a) {
        TaiKhoan.TkWs_Service service = new TaiKhoan.TkWs_Service();
        TaiKhoan.TkWs port = service.getTkWsPort();
        return port.getCheck(a);
    }

    private static void getDeletetk(java.lang.String a) {
        TaiKhoan.TkWs_Service service = new TaiKhoan.TkWs_Service();
        TaiKhoan.TkWs port = service.getTkWsPort();
        port.getDeletetk(a);
    }

    private static java.util.List<TaiKhoan.Tkmodel> getTaikhoan() {
        TaiKhoan.TkWs_Service service = new TaiKhoan.TkWs_Service();
        TaiKhoan.TkWs port = service.getTkWsPort();
        return port.getTaikhoan();
    }

    private static void getThemtk(java.lang.String a, java.lang.String b, java.lang.String c, java.lang.String d) {
        TaiKhoan.TkWs_Service service = new TaiKhoan.TkWs_Service();
        TaiKhoan.TkWs port = service.getTkWsPort();
        port.getThemtk(a, b, c, d);
    }

    private static void getUpdatetk(java.lang.String a, java.lang.String b, java.lang.String c, java.lang.String d) {
        TaiKhoan.TkWs_Service service = new TaiKhoan.TkWs_Service();
        TaiKhoan.TkWs port = service.getTkWsPort();
        port.getUpdatetk(a, b, c, d);
    }

      

}
    
