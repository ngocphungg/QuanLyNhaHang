package Controller;

import DangNhap.Loginmodel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import Model.TaiKhoanLoginModel;
import NhanVien.Nvmodel;
import View.DangNhapView;
import View.ThongTinView;
import java.util.List;
import javax.swing.JFrame;

public class LoginCtrl {
    public String loggedInUsername;
    List<Loginmodel> arr;
//    TaiKhoanLoginModel m;
    DangNhapView v;
//    JFrame frame;

    public LoginCtrl() {
        v =  new DangNhapView();
        v.action_dang_nhap(new login_listener());
        v.action_exit(new exit());
    }

     public boolean kt(String username, String password) {
       
        arr = getDangnhap();
          for (Loginmodel n1 : arr) {
        if (n1.getTentk().equals(username) && n1.getPass().equals(password)) {
            return true; // Trả về true nếu tìm thấy tài khoản và mật khẩu khớp trong danh sách
        }
    }
    return false; // Trả về false nếu không tìm thấy khớp
    }
    class login_listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            m = v.get_tai_khoan();
//            String username = m.user; // Lấy tên đăng nhập từ giao diện người dùng
//            String password = m.pass; // Lấy mật khẩu từ giao diện người dùng
//            frame = (JFrame) SwingUtilities.getWindowAncestor(v);

            // Kết nối đến cơ sở dữ liệu
//            Connection connection = connectdb.getConnection();
//
//            if (connection != null) {
//                try {
//                    // Tạo câu truy vấn kiểm tra thông tin đăng nhập
//                    String query = "SELECT * FROM taikhoan WHERE tentk = ? AND pass = ?";
//                    PreparedStatement statement = connection.prepareStatement(query);
//                    statement.setString(1, username);
//                    statement.setString(2, password);
//
//                    ResultSet resultSet = statement.executeQuery();
//
//                    if (resultSet.next()) {
                        String username = v.txt1.getText();
                        char[] password= v.pass.getPassword();
                       
                        arr = getDangnhap();
                        login(loggedInUsername, loggedInUsername);
                        if(kt(username, new String (password))){
                            JOptionPane.showMessageDialog(v, "Đăng nhập thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        
//                        loggedInUsername = resultSet.getString("tentk");
//                        v.txt1.setUser(loggedInUsername);
                        JFrame newFrame = new ThongTinView();
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        v.dispose();
                        v.setVisible(false);
                    } else {
                            JOptionPane.showMessageDialog(v, "Đăng nhập thất bại", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
//                        // Thông tin đăng nhập không chính xác
                        
                    }
//
//                    resultSet.close();
//                    statement.close();
//                    connection.close();
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            } else {
//                JOptionPane.showMessageDialog(v, "Không thể kết nối đến cơ sở dữ liệu", "Lỗi kết nối", JOptionPane.ERROR_MESSAGE);
//            }
        }


    }
    class exit implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          v.dispose();
          
        }       
    }
    
//    public static void main (String[] args){
//        new LoginCtrl();
//    }

    private static java.util.List<DangNhap.Loginmodel> getDangnhap() {
        DangNhap.LoginWs_Service service = new DangNhap.LoginWs_Service();
        DangNhap.LoginWs port = service.getLoginWsPort();
        return port.getDangnhap();
    }

    private static boolean login(java.lang.String username, java.lang.String password) {
        DangNhap.LoginWs_Service service = new DangNhap.LoginWs_Service();
        DangNhap.LoginWs port = service.getLoginWsPort();
        return port.login(username, password);
    }

    

   
}