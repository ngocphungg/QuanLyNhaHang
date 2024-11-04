/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import Controller.QLyTaiKhoanCtrl;
import Controller.connectdb;

import Model.TaiKhoanModel;
import java.awt.BorderLayout;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author admin
 */
public class TaiKhoanView extends JFrame implements ActionListener{
    
    static Integer k = 0;
    JFrame j;
    JTable table;
    JLabel l,l1,matk,tentk,matkhau,quyen;
    JPanel p1,p2,p3,p4,p_tt,p_nut,p5,p_center,anh;
    JButton timkiem,them,xoa,luu,xuat,reset;
    public JTextField txt_tk,txt_matk,txt_tentk,txt_mk;
    public JComboBox cbb_q;
    String options[]={"Quản trị","Người dùng"};
//    TaiKhoanModel m;
    QLyTaiKhoanCtrl controller;
    connectdb db;
    
    public DefaultTableModel model=new DefaultTableModel();
//    ArrayList<TaiKhoanModel> arr= new ArrayList<TaiKhoanModel>();
    public TaiKhoanView(){
        
        j=new JFrame();
        panel1();
        panel2();
        panel3();
        addcom();
        initialize();
        controller = new QLyTaiKhoanCtrl( this, db);
        
}
    public void panel1(){
        p1=new JPanel();
        p1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        Font f=new Font("Arial",Font.BOLD,30);
        l=new JLabel("QUẢN LÝ TÀI KHOẢN",JLabel.CENTER);
        l.setFont(f);
               
        l1=new JLabel("TÌM KIẾM",JLabel.CENTER);       
        txt_tk=new JTextField();
        txt_tk.setPreferredSize(new Dimension(200,30));
        txt_tk.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        ImageIcon icon=new ImageIcon("C:/Users/admin/Documents/NetBeansProjects/QLYNHAHANG/build/classes/icon&image/tk.png","tk");
        ImageIcon resizedIcon = resizeIcon(icon, 40, 40);
        timkiem = new JButton(resizedIcon);
        Insets margin = new Insets(0, 0, 0, 0); // top, left, bottom, right
        timkiem.setMargin(margin);
        timkiem.setPreferredSize(new Dimension(30,26));
        timkiem.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));

        p4=new JPanel();
        p4.setLayout(new GridBagLayout());
        GridBagConstraints gb=new GridBagConstraints();
        gb.fill=GridBagConstraints.HORIZONTAL;
        gb.anchor=GridBagConstraints.CENTER;
        gb.gridx=0;
        gb.gridy=0;
        gb.gridwidth=1;
        gb.insets=new Insets(5,5,5,5);
        p4.add(l1,gb);
        gb.gridx=1;
        gb.gridy=0;
        gb.gridwidth=1;
        gb.insets=new Insets(5,5,5,5);
        p4.add(txt_tk,gb);
        gb.gridx=2;
        gb.gridy=0;
        gb.gridwidth=1;
        gb.insets=new Insets(5,5,5,5);
        p4.add(timkiem,gb);
        p1.setLayout(new GridLayout(2,1));
        p1.add(l);
        p1.add(p4);
      
    }
    // Hàm để thu nhỏ kích thước của ImageIcon
    private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
    public void panel2(){
        p2=new JPanel();
        p2.setSize(500, 300);
        p2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        matk=new JLabel("Mã TK : ");
        tentk=new JLabel("Tên tài khoản : ");
        matkhau=new JLabel("Mật khẩu : ");
        quyen=new JLabel("Quyền : ");
        
        txt_matk=new JTextField();
        txt_matk.setPreferredSize(new Dimension(200,25));
        txt_matk.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        txt_tentk=new JTextField();
        txt_tentk.setPreferredSize(new Dimension(200,25));
        txt_tentk.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        txt_mk=new JTextField();
        txt_mk.setPreferredSize(new Dimension(200,25));
        txt_mk.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        cbb_q=new JComboBox(options);
        cbb_q.setPreferredSize(new Dimension(200,25));
        cbb_q.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        
        them=new JButton("Thêm");
        them.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        them.setPreferredSize(new Dimension(40,30));
        them.setBackground(new Color(242,188,214));
        them.addActionListener(this);
        
        xoa=new JButton("Xóa");
        xoa.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        xoa.setPreferredSize(new Dimension(40,30));
        xoa.setBackground(new Color(242,188,214));
        xoa.addActionListener(this);
        
        luu=new JButton("Lưu");
        luu.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        luu.setPreferredSize(new Dimension(40,30));
        luu.setBackground(new Color(242,188,214));
        luu.addActionListener(this);
        
        xuat=new JButton("Xuất");
        xuat.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        xuat.setPreferredSize(new Dimension(40,30));
        xuat.setBackground(new Color(242,188,214));
        reset=new JButton("Reset"); //làm mới thông tin
        reset.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        reset.setPreferredSize(new Dimension(40,30));
        reset.setBackground(new Color(242,188,214));
        reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_matk.setText("");
                txt_tentk.setText("");
                txt_mk.setText("");
                cbb_q.setSelectedIndex(0);
            }
    });
        p_tt=new JPanel();
        p_tt.setLayout(new GridBagLayout());
        GridBagConstraints gb=new GridBagConstraints();
        gb.gridx=0;
        gb.gridy=0;
        gb.gridwidth=1;
        gb.insets=new Insets(5,5,5,5);
        p_tt.add(matk,gb);
        gb.gridx=1;
        gb.gridy=0;
        gb.gridwidth=2;
        gb.insets=new Insets(5,5,5,5);
        p_tt.add(txt_matk,gb);
        gb.gridx=0;
        gb.gridy=1;
        gb.gridwidth=1;
        gb.insets=new Insets(5,5,5,5);
        p_tt.add(tentk,gb);
        gb.gridx=1;
        gb.gridy=1;
        gb.gridwidth=2;
        gb.insets=new Insets(5,5,5,5);
        p_tt.add(txt_tentk,gb);
        gb.gridx=0;
        gb.gridy=2;
        gb.gridwidth=1;
        gb.insets=new Insets(5,5,5,5);
        p_tt.add(matkhau,gb);
        gb.gridx=1;
        gb.gridy=2;
        gb.gridwidth=1;
        gb.insets=new Insets(5,5,5,5);
        p_tt.add(txt_mk,gb);
        gb.gridx=0;
        gb.gridy=3;
        gb.gridwidth=1;
        gb.insets=new Insets(5,5,5,5);
        p_tt.add(quyen,gb);
        gb.gridx=1;
        gb.gridy=3;
        gb.gridwidth=1;
        gb.insets=new Insets(5,5,5,5);
        p_tt.add(cbb_q,gb);
        
        p_nut=new JPanel();
        p_nut.setLayout(new GridBagLayout());
        GridBagConstraints gb1=new GridBagConstraints();
        gb1.gridx=0;
        gb1.gridy=0;
        gb1.gridwidth=1;
        gb1.insets=new Insets(5,5,5,5);
        p_nut.add(them,gb1);
        gb1.gridx=1;
        gb1.gridy=0;
        gb1.gridwidth=1;
        gb1.insets=new Insets(5,5,5,5);
        p_nut.add(xoa,gb1);
        gb1.gridx=2;
        gb1.gridy=0;
        gb1.gridwidth=1;
        gb1.insets=new Insets(5,5,5,5);
        p_nut.add(luu,gb1);
        gb1.gridx=3;
        gb1.gridy=0;
        gb1.gridwidth=1;
        gb1.insets=new Insets(5,5,5,5);
        p_nut.add(xuat,gb1);
        gb1.gridx=4;
        gb1.gridy=0;
        gb1.gridwidth=1;
        gb1.insets=new Insets(5,5,5,5);
        p_nut.add(reset,gb1);
        
        p2.setLayout(new GridLayout(2,1,1,1));
        p2.add(p_tt);
        p2.add(p_nut);
        
        
    }
     public final Object data=new Object[][]{};
    public void panel3(){
        p3=new JPanel();
        p3.setSize( 600, 500);
        p3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        //khởi tạo mô hình
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(700, 700));
        table.setBackground(new Color(247,251,251));
       //thêm cột cho mô hình
        model.addColumn("Mã TK");
        model.addColumn("Tên Tài Khoản");
        model.addColumn("Mật Khẩu");
        model.addColumn("Phân Quyền");
        
        //thêm dữ liệu từ mảng vào
//        for(TaiKhoanModel st: arr){
//            model.addRow(new Object[]{st.getIdtk(), st.getTentk(), st.getMk(), st.getQuyen()});
//        }
        JScrollPane jScrollPane = new JScrollPane(table);
        p3.add(jScrollPane);
        
          table.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) { // Đảm bảo rằng có dòng được chọn
                txt_matk.setText((String) table.getValueAt(selectedRow, 0));
                txt_tentk.setText((String) table.getValueAt(selectedRow, 1));
                txt_mk.setText((String) table.getValueAt(selectedRow, 2));
                cbb_q.setSelectedItem((String) table.getValueAt(selectedRow, 3));
            }
        }
    });
        
                }
    public JTable getTable(){
        return table;
    }
    public JTextField getText(){
        return txt_tk;
    }
    
    public void addcom(){
        p1.setBackground(new Color(217, 217, 217));
        p2.setBackground(new Color(217, 217, 217));
        p3.setBackground(new Color(217, 217, 217));
        p4.setBackground(new Color(217, 217, 217));
        p_tt.setBackground(new Color(217, 217, 217));
        p_nut.setBackground(new Color(217, 217, 217));
        timkiem.setBackground(new Color(255, 204, 204));
       
        j.setJMenuBar(new Menubar());
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        j.setSize(1100,800);
//        p5=new JPanel();
//        ImageIcon icon1=new ImageIcon("C:/Users/admin/Documents/NetBeansProjects/QLYNHAHANG/build/classes/icon&image/nhanvien.png","nhanvien");
//        ImageIcon resizedIcon1 = resizeIcon(icon1, 400, 400);
//        anh=new JLabel(resizedIcon1);
//        p5.add(anh);
        p_center=new JPanel();
        p_center.setLayout(new BorderLayout() );
        p_center.add(p2,BorderLayout.WEST);
        
        p_center.add(p3,BorderLayout.EAST);
       
        j.setLayout(new BorderLayout());
        j.add(p1,BorderLayout.NORTH);
        j.add(p_center,BorderLayout.CENTER);
        
        j.setVisible(true);
}


    public void timkiemActionListener (ActionListener log){
        timkiem.addActionListener(log);

    }
    public void themActionListener(ActionListener log){
        them.addActionListener(log);
    }
   
    public void xoaActionListener(ActionListener log){
        xoa.addActionListener(log);
    }
    public void luuActionListener(ActionListener log){
        luu.addActionListener(log);
    }
    public void xuatActionListener(ActionListener log){
        xuat.addActionListener(log);
    }
//    public TaiKhoanModel get_tk(){ //phuong thuc nay lay thong tin tu thanh phan giao dien va tra ve mot doi tuong nhan vien
//        String pq = String.valueOf(cbb_q.getSelectedItem());
//        int ma_tk=Integer.parseInt(txt_matk.getText());
//        if (!txt_matk.getText().isEmpty()) {
//            int matk = Integer.parseInt(txt_matk.getText());
//            // Tiếp tục xử lý dữ liệu sau khi đã chuyển đổi thành công
//        } else {
//            // Xử lý trường hợp chuỗi rỗng
//        }
//
//        TaiKhoanModel nv=new TaiKhoanModel(ma_tk,txt_tentk.getText(),txt_mk.getText(),pq);
//        return nv;
//        }
//     public void updateNewTable(String Manv, String Hoten, String Gioitinh, String Chucvu, String Sdt, String Quequan) {
//        // Thêm một hàng mới vào table model
//        DefaultTableModel model=(DefaultTableModel)table.getModel();
//        model.addRow(new Object[]{Manv, Hoten, Gioitinh, Chucvu, Sdt,Quequan});
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }  

    public String getSearchText() {
        return txt_tk.getText();
    }
     public String getMa() {
        return txt_matk.getText();
    }
      public String getTen() {
        return txt_tentk.getText();
    }
       public String getMk() {
        return txt_mk.getText();
    }

  
    //Xuất excel
               private void initialize() {
                xuat.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Gọi hành động từ controller khi nút xuất được nhấn
                        exportToExcel();
                    }
                });
           }
               
               // Phương thức để xuất dữ liệu ra file Excel
        private void exportToExcel() {
            Workbook workbook = new XSSFWorkbook(); // Tạo workbook mới

            // Tạo một trang mới trong workbook
            Sheet sheet = (Sheet) workbook.createSheet("Danh sách tài khoản");
            Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Mã tài khoản");
                headerRow.createCell(1).setCellValue("Tên tài khoản");
                headerRow.createCell(2).setCellValue("Mật khẩu");
                headerRow.createCell(3).setCellValue("Phân quyền");
               
            // Lấy số lượng hàng và cột trong bảng
            int rowCount = table.getRowCount();
            int columnCount = table.getColumnCount();
             
            
            // Lặp qua từng hàng trong bảng và thêm dữ liệu vào workbook
            for (int i = 0; i < rowCount; i++) {
                // Tạo một hàng mới trong trang
                Row row = sheet.createRow(i+1);
               
                // Lặp qua từng cột trong hàng và thêm dữ liệu vào workbook
                for (int j = 0; j < columnCount; j++) {
                    Object value = table.getValueAt(i, j); // Lấy giá trị từ bảng
                    Cell cell = row.createCell(j); // Tạo một ô mới trong hàng

                    // Đặt giá trị cho ô mới
                    if (value != null) {
                        cell.setCellValue(value.toString());
                    } else {
                        cell.setCellValue("");
                    }
                }
            }

            // Lưu workbook vào file Excel
            try (FileOutputStream outputStream = new FileOutputStream("DanhSachTaiKhoan.xlsx")) {
                workbook.write(outputStream);
                JOptionPane.showMessageDialog(null, "Xuất Excel thành công!");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Xuất Excel thất bại: " + e.getMessage());
            }
        }
 
}
