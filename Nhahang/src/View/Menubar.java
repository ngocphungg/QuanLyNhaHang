/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *
 * @author ptbic
 */
public class Menubar extends JMenuBar{
    public JMenu ql;
    

    public Menubar() {
        ImageIcon nhahang = resizeIcon(new ImageIcon("C:/Users/ptbic/OneDrive/Documents/NetBeansProjects/NhaHang/src//icon&image/nh.png", "nh"), 25, 25);
        JMenu nh= new JMenu("NHÀ HÀNG");
        nh.setIcon(nhahang);
        
        nh.addMenuListener(new MenuListener() {
            public void menuSelected(MenuEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Menubar.this);
                if (frame != null && frame.isVisible()) {
                    // Đóng frame
                    frame.dispose();
                }
                // Hiển thị cửa sổ mới khi menu "Nhà hàng" được chọn
                JFrame newFrame = new HomeView();
                
            }
            public void menuDeselected(MenuEvent e) {}

            public void menuCanceled(MenuEvent e) {}
        });
        menuquanly();

//        C:/Users/ptbic/OneDrive/Documents/NetBeansProjects/NhaHang/src/
        ImageIcon taikhoan = resizeIcon(new ImageIcon("C:/Users/ptbic/OneDrive/Documents/NetBeansProjects/NhaHang/src//icon&image/taikhoan.png", "taikhoan"), 25, 25);
        JMenu tk= new JMenu("TÀI KHOẢN");
        tk.setIcon(taikhoan);
        
        ImageIcon cstt = resizeIcon(new ImageIcon("C:/Users/ptbic/OneDrive/Documents/NetBeansProjects/NhaHang/src//icon&image/fix.png", "fix"), 25, 25);
        JMenuItem t1 = new JMenuItem("Chỉnh sửa thông tin");
        t1.setIcon(cstt);
        t1.setBackground(new Color(255, 255, 255));
        
        ImageIcon dangxuat = resizeIcon(new ImageIcon("C:/Users/ptbic/OneDrive/Documents/NetBeansProjects/NhaHang/src//icon&image/logout.png", "logout"), 25, 25);
        JMenuItem t2 = new JMenuItem("Đăng xuất");
        t2.setBackground(new Color(255, 255, 255));
        t2.setIcon(dangxuat);
        
        t2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Menubar.this);
                if (frame != null && frame.isVisible()) {
                    // Đóng frame
                    frame.dispose();
                }
                // Hiển thị cửa sổ mới khi menu "Nhà hàng" được chọn
                JFrame newFrame = new DangNhapView();
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        tk.add(t1);tk.add(t2);
        //
//        JMenu db= new JMenu("Đặt bàn");
        ImageIcon congcu = resizeIcon(new ImageIcon("C:/Users/ptbic/OneDrive/Documents/NetBeansProjects/NhaHang/src//icon&image/congcu.png", "congcu"), 25, 25);
        JMenu cc= new JMenu("CÔNG CỤ");
        cc.setIcon(congcu);
        
        ImageIcon thoat = resizeIcon(new ImageIcon("C:/Users/ptbic/OneDrive/Documents/NetBeansProjects/NhaHang/src//icon&image/logout.png", "logout"), 25, 25);
        JMenuItem exitItem = new JMenuItem("Thoát");
        exitItem.setIcon(thoat);
        exitItem.setBackground(new Color(255, 255, 255));
        cc.add(exitItem);
        
        this.setPreferredSize(new Dimension(600, 50));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 10));
        this.setBackground(new Color(255, 204, 204));
        this.add(nh);
        this.add(ql);
        this.add(tk);
//        this.add(db);
        this.add(cc);
        
        exitItem.addActionListener(e -> System.exit(0));
    }
    
       
    public void menuquanly(){
        ImageIcon quanly = resizeIcon(new ImageIcon("C:/Users/ptbic/OneDrive/Documents/NetBeansProjects/NhaHang/src/icon&image/qly.png", "qly"), 25, 25);
        ql= new JMenu("QUẢN LÝ");
        ql.setIcon(quanly);
        
        ImageIcon qlnv = resizeIcon(new ImageIcon("C:/Users/ptbic/OneDrive/Documents/NetBeansProjects/NhaHang/src//icon&image/qlnv.png", "qlnv"), 25, 25);
        JMenuItem i1 = new JMenuItem("Quản Lý Nhân Viên");
        i1.setIcon(qlnv);
        i1.setBackground(new Color(255, 255, 255));
        
        ql.setBackground(new Color(255, 230, 230));
        i1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Menubar.this);
                if (frame != null && frame.isVisible()) {
                    // Đóng frame
                    frame.dispose();
                }
                // Hiển thị cửa sổ mới khi menu "Nhà hàng" được chọn
                JFrame newFrame = new NhanVienView();
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        
        ImageIcon qltd = resizeIcon(new ImageIcon("C:/Users/ptbic/OneDrive/Documents/NetBeansProjects/NhaHang/src//icon&image/qltd.png", "qltd"), 25, 25);
        JMenuItem i2 = new JMenuItem("Quản Lý Thực Đơn");
        i2.setIcon(qltd);
        i2.setBackground(new Color(255, 255, 255));
        i2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Menubar.this);
                if (frame != null && frame.isVisible()) {
                    // Đóng frame
                    frame.dispose();
                }
                // Hiển thị cửa sổ mới khi menu "Nhà hàng" được chọn
                JFrame newFrame = new QLyThucDonView();
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        
        ImageIcon qldt = resizeIcon(new ImageIcon("C:/Users/ptbic/OneDrive/Documents/NetBeansProjects/NhaHang/src//icon&image/qldt.png", "qldt"), 25, 25);
        JMenuItem i3 = new JMenuItem("Quản Lý Doanh Thu");
        i3.setIcon(qldt);
        i3.setBackground(new Color(255, 255, 255));
        i3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Menubar.this);
                if (frame != null && frame.isVisible()) {
                    // Đóng frame
                    frame.dispose();
                }
                JFrame newFrame = new ChartView();
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        
        ImageIcon qlnl = resizeIcon(new ImageIcon("C:/Users/ptbic/OneDrive/Documents/NetBeansProjects/NhaHang/src//icon&image/qlnl.png", "qlnl"), 25, 25);
        JMenuItem i4 = new JMenuItem("Quản Lý Nhập Liệu");
        i4.setIcon(qlnl);
        i4.setBackground(new Color(255, 255, 255));
        i4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Menubar.this);
                if (frame != null && frame.isVisible()) {
                    // Đóng frame
                    frame.dispose();
                }
                JFrame newFrame = new NhapLieuView();
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        ImageIcon qltk = resizeIcon(new ImageIcon("C:/Users/ptbic/OneDrive/Documents/NetBeansProjects/NhaHang/src//icon&image/qltk.png", "qltk"), 25, 25);
        JMenuItem i5 = new JMenuItem("Quản Lý Tài Khoản");
        i5.setIcon(qltk);
        i5.setBackground(new Color(255, 255, 255));
        i5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Menubar.this);
                if (frame != null && frame.isVisible()) {
                    // Đóng frame
                    frame.dispose();
                }
                JFrame newFrame = new TaiKhoanView();
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        ql.add(i1);ql.add(i2);ql.add(i3);ql.add(i4);ql.add(i5);
    }
       // Phương thức để thay đổi kích thước của icon
    private static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
    
    
    
}
