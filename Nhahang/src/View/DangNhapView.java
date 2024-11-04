/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.TaiKhoanLoginModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DangNhapView extends JFrame implements ActionListener{
    JFrame j;
    JPanel p1, p2, p3, p4, p5;
    JLabel l1, l2, l3;
    public JTextField txt1;
    public JPasswordField pass;
    JButton b1, b2;

    public DangNhapView() {
        j = new JFrame();
        j.setTitle("DangNhap");
        j.setSize(1000, 600);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);
        j.setLayout(new GridLayout(1,2,5,5));
        p1 = new JPanel();
        p2 = new JPanel();
        
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.BOTH;
////        gbc.weightx = 1.0;
////        gbc.weighty = 1.0;
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridwidth = 1;
//        gbc.gridheight = 1;
//        gbc.insets = new Insets(10, 10, 10, 10); // Set khoảng cách ở đây
//        j.add(p1 );
//        j.add(p2);
        panel1();
        panel2();
        
        j.setVisible(true);
    }

    public void panel1() {
        p1.setBackground(new Color(228,213,218));
        ImageIcon icon = new ImageIcon("C:/Users/ptbic/OneDrive/Documents/NetBeansProjects/NhaHang/src/icon&image/restaurant.png", "resaurant");
        ImageIcon resizedIcon0 = resizeIcon(icon, 300, 400);
        JLabel l = new JLabel("", resizedIcon0, JLabel.CENTER);
        p1.add(l);
        j.add(p1);
       }

    public void panel2() {
        p3=new JPanel();
        p3.setBackground(new Color(228,213,218));
        Font f=new Font("Arial",Font.BOLD,40);
        l3 = new JLabel("ĐĂNG NHẬP", JLabel.CENTER);
        l3.setFont(f);
        p3.add(l3,JPanel.BOTTOM_ALIGNMENT);
        
        ImageIcon icon = new ImageIcon("C:/Users/ptbic/OneDrive/Documents/NetBeansProjects/NhaHang/src/icon&image/profile.png", "profile");
        
//        ImageIcon icon = new ImageIcon("C:/Users/admin/Documents/NetBeansProjects/QLYNHAHANG/build/classes/icon&image/profile.png", "profile");
//        
        ImageIcon resizedIcon = resizeIcon(icon, 50, 50);
        l1 = new JLabel(resizedIcon);
        l1.setPreferredSize(new Dimension(50, 50));
        txt1 = new JTextField();
        txt1.setPreferredSize(new Dimension(250, 40));
        txt1.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));

        ImageIcon icon1 = new ImageIcon("C:/Users/ptbic/OneDrive/Documents/NetBeansProjects/NhaHang/src/icon&image/reset-password.png", "reset-password");
        
//        ImageIcon icon1 = new ImageIcon("C:/Users/admin/Documents/NetBeansProjects/QLYNHAHANG/build/classes/icon&image/reset-password.png", "reset-password");
//        
        ImageIcon resizedIcon1 = resizeIcon(icon1, 50, 50);
        l2 = new JLabel(resizedIcon1);
        l2.setPreferredSize(new Dimension(50, 50));
        pass = new JPasswordField();
        pass.setPreferredSize(new Dimension(250, 40));
        pass.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));

        b1 = new JButton("Đăng Nhập");
        b1.setPreferredSize(new Dimension(100, 30));
        b1.setBackground(new Color(255, 179, 179));
        b1.setBorder(BorderFactory.createLineBorder(new Color(255, 179, 179), 1));
        b2 = new JButton("Thoát");
        b2.setPreferredSize(new Dimension(100, 30));
        b2.setBackground(new Color(255, 179, 179));
        b2.setBorder(BorderFactory.createLineBorder(new Color(255, 179, 179), 1));

        p4 = new JPanel();
        p4.setBackground(new Color(228,213,218));
        p4.setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.anchor = GridBagConstraints.CENTER;
        gb.gridx = 0;
        gb.gridy = 0;
        gb.gridwidth = 1;
        gb.insets = new Insets(5, 0, 10, 5);
        p4.add(l1, gb);
        gb.gridx = 1;
        gb.gridy = 0;
        gb.gridwidth = 1;
        gb.insets = new Insets(5, 5, 10, 5);
        p4.add(txt1, gb);
        gb.gridx = 0;
        gb.gridy = 1;
        gb.gridwidth = 1;
        gb.insets = new Insets(5, 5, 10, 5);
        p4.add(l2, gb);
        gb.gridx = 1;
        gb.gridy = 1;
        gb.gridwidth = 1;
        gb.insets = new Insets(5, 5, 10, 5);
        p4.add(pass, gb);

        p5 = new JPanel();
        p5.setBackground(new Color(228,213,218));
        p5.setLayout(new GridBagLayout());
        GridBagConstraints gb1 = new GridBagConstraints();
        gb1.fill = GridBagConstraints.HORIZONTAL;
        gb1.anchor = GridBagConstraints.CENTER;
        gb1.gridx = 1;
        gb1.gridy = 0;
        gb1.gridwidth = 1;
        gb1.insets = new Insets(5, 5, 10, 5);
        p5.add(b1,gb1);
        gb1.gridx = 2;
        gb1.gridy = 0;
        gb1.gridwidth = 1;
        gb1.insets = new Insets(5, 5, 10, 5);
        p5.add(b2,gb1);

        p2 = new JPanel();
        p2.setBackground(new Color(228,213,218));
        p2.setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        gbc1.anchor = GridBagConstraints.CENTER;
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.gridwidth = 1;
        gbc1.insets = new Insets(5, 25,20, 5);
        p2.add(p3,gbc1);
        gbc1.gridx = 0;
        gbc1.gridy = 1;
        gbc1.gridwidth = 1;
        gbc1.insets = new Insets(5, 5, 5, 5);
        p2.add(p4,gbc1);
        gbc1.gridx = 0;
        gbc1.gridy = 4;
        gbc1.gridwidth = 1;
        gbc1.insets = new Insets(20, 20, 5, 5);
        p2.add(p5,gbc1);
        
        j.add(p2);
    }

    // Hàm để thu nhỏ kích thước của ImageIcon
    private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void action_dang_nhap( ActionListener log){
        b1.addActionListener(log);
    }
//    public TaiKhoanLoginModel get_tai_khoan(){
//        char[] passw= pass.getPassword();
//        TaiKhoanLoginModel t= new TaiKhoanLoginModel(txt1.getText(), String.valueOf(passw));
//        return t;
//    }
    public void action_exit(ActionListener log){
        b2.addActionListener(log);
    }
    

}
