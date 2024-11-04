/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import Controller.QLyNhapLieuCtrl;
import Controller.connectdb;

import Model.NhapLieuModel;
import com.toedter.calendar.JDateChooser;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author admin
 */
public class NhapLieuView extends JFrame implements ActionListener{
    
    static Integer k = 0;
    JFrame j;
    JTable table;
    JLabel l,l1,masp,tensp,ngaynhap,donvi,slgkk,anh,cp,tcp;
    JPanel p1,p2,p3,p4,p_tt,p_nut,p5,p_center;
    JButton timkiem,them,xoa,luu,xuat,reset;
    public JTextField txt_tk,txt_masp,txt_tensp,txt_cp,txt_tcp;
    public JSpinner sp_sl;
    public JDateChooser calendar;
    public QLyNhapLieuCtrl controller;
    public JComboBox cbb_dv;
    String options[]={"Kg","Thùng","Cái"};
  
    connectdb db;
    public DefaultTableModel model=new DefaultTableModel();
   
    public NhapLieuView(){
        j=new JFrame();
        panel1();
        panel2();
        panel3();
        addcom();
        controller = new QLyNhapLieuCtrl(this, db);
        initialize();
        
}
    public void panel1(){
        p1=new JPanel();
        p1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        Font f=new Font("Arial",Font.BOLD,30);
        l=new JLabel("QUẢN LÝ SẢN PHẨM",JLabel.CENTER);
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
        p2.setSize(500, 700);
        p2.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        masp=new JLabel("Mã SP : ");
        tensp=new JLabel("Tên SP : ");
        ngaynhap=new JLabel("Ngày nhập : ");
        donvi=new JLabel("Đơn vị : ");
        slgkk=new JLabel("Số lượng : ");
        cp=new JLabel("Chi phí:");
        tcp=new JLabel(" Tổng chi phí:");
        txt_masp=new JTextField();
        txt_masp.setPreferredSize(new Dimension(200,25));
        txt_masp.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        txt_tensp=new JTextField();
        txt_tensp.setPreferredSize(new Dimension(200,25));
        txt_tensp.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        calendar=new JDateChooser();
        calendar.setDate(new Date());
        calendar.setDateFormatString("yyyy-MM-dd");
        calendar.setPreferredSize(new Dimension(200,25));
        calendar.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        txt_cp=new JTextField();
        txt_cp.setPreferredSize(new Dimension(200,25));
        txt_cp.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        txt_tcp=new JTextField();
        txt_tcp.setPreferredSize(new Dimension(200,25));
        txt_tcp.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        cbb_dv=new JComboBox(options);
        cbb_dv.setPreferredSize(new Dimension(200,25));
        cbb_dv.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        // Tạo SpinnerNumberModel với giá trị ban đầu, giá trị tối thiểu, tối đa và bước nhảy
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, 50, 1);

        // Tạo JSpinner với SpinnerNumberModel đã tạo
        sp_sl = new JSpinner(spinnerModel);

        // Thiết lập định dạng cho JSpinner
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) sp_sl.getEditor();
        editor.getTextField().setHorizontalAlignment(JTextField.CENTER);

        
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
                txt_masp.setText("");
                txt_tensp.setText("");
                Date date=null;
                calendar.setDate(date);
                cbb_dv.setSelectedItem("");
                sp_sl.setValue(1);
                txt_cp.setText("");
                txt_tcp.setText("");
                
            }
        });
        txt_cp.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            calculateTotalCost();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            calculateTotalCost();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            calculateTotalCost();
        }
    });

    sp_sl.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            calculateTotalCost();
        }
    });

        p_tt=new JPanel();
        p_tt.setSize(500,500);
        p_tt.setLayout(new GridBagLayout());
        GridBagConstraints gb=new GridBagConstraints();
        gb.insets=new Insets(5,5,5,5);
        gb.gridx=0;
        gb.gridy=0;
//        gb.gridwidth=1;
        p_tt.add(masp,gb);
        gb.gridx=1;
        gb.gridy=0;
//        gb.gridwidth=2;
        p_tt.add(txt_masp,gb);
        gb.gridx=0;
        gb.gridy=1;
//        gb.gridwidth=1;
        p_tt.add(tensp,gb);
        gb.gridx=1;
        gb.gridy=1;
//        gb.gridwidth=2;
        p_tt.add(txt_tensp,gb);
        gb.gridx=0;
        gb.gridy=2;
//        gb.gridwidth=1;
        p_tt.add(ngaynhap,gb);
        gb.gridx=1;
        gb.gridy=2;
//        gb.gridwidth=3;
//        gb.gridheight=3;
        p_tt.add(calendar,gb);
        gb.gridx=0;
        gb.gridy=5;
//        gb.gridwidth=1;
        p_tt.add(donvi,gb);
        gb.gridx=1;
        gb.gridy=5;
//        gb.gridwidth=1;
        p_tt.add(cbb_dv,gb);
        gb.gridx=0;
        gb.gridy=6;
//        gb.gridwidth=1;
        p_tt.add(slgkk,gb);
        gb.gridx=1;
        gb.gridy=6;
      
        p_tt.add(sp_sl,gb);
        gb.gridx=0;
        gb.gridy=7;
//        gb.gridwidth=1;
        p_tt.add(cp,gb);
        gb.gridx=1;
        gb.gridy=7;
//        gb.gridwidth=1;
        p_tt.add(txt_cp,gb);
        gb.gridx=0;
        gb.gridy=8;
//        gb.gridwidth=1;
        p_tt.add(tcp,gb);
        gb.gridx=1;
        gb.gridy=8;
//        gb.gridwidth=1;
        p_tt.add(txt_tcp,gb);
        
        p_nut=new JPanel();
        p_nut.setSize(500,50);
        p_nut.setLayout(new GridBagLayout());
        GridBagConstraints gb1=new GridBagConstraints();
        gb1.insets=new Insets(5,5,5,5);
        gb1.gridx=0;
        gb1.gridy=0;
        gb1.gridwidth=1;
        
        p_nut.add(them,gb1);
        gb1.gridx=1;
        gb1.gridy=0;
        gb1.gridwidth=1;
        
        p_nut.add(luu,gb1);
        gb1.gridx=2;
        gb1.gridy=0;
        gb1.gridwidth=1;
       
        p_nut.add(xoa,gb1);
        gb1.gridx=3;
        gb1.gridy=0;
        gb1.gridwidth=1;
        p_nut.add(xuat,gb1);
        gb1.gridx=4;
        gb1.gridy=0;
        gb1.gridwidth=1;
        p_nut.add(reset,gb1);
     
        p2.setLayout(new GridLayout(2,1));
        p2.add(p_tt);
        p2.add(p_nut);
       }
    private void calculateTotalCost() {
//    double chiphi = 0.0;
//    double tongchiphi = 0.0;
    try {
        float chiphi = Float.parseFloat(txt_cp.getText());
        int soluong = (int) sp_sl.getValue();
        float tongchiphi = chiphi * soluong;
        txt_tcp.setText(String.valueOf(tongchiphi));
    } catch (NumberFormatException ex) {
        // Xử lý nếu người dùng nhập không phải là số
        txt_tcp.setText(""); // Đặt lại về trống nếu có lỗi xảy ra
    }
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
            Sheet sheet = (Sheet) workbook.createSheet("Danh sách sản phẩm");
            Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Mã sản phẩm");
                headerRow.createCell(1).setCellValue("Tên sản phẩm");
                headerRow.createCell(2).setCellValue("Ngày nhập");
                headerRow.createCell(3).setCellValue("Đơn vị");
                headerRow.createCell(4).setCellValue("Số lượng");
                headerRow.createCell(5).setCellValue("Chi phí");
                headerRow.createCell(6).setCellValue("Tổng chi phí");
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
            try (FileOutputStream outputStream = new FileOutputStream("DanhSachSanPham.xlsx")) {
                workbook.write(outputStream);
                JOptionPane.showMessageDialog(null, "Xuất Excel thành công!");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Xuất Excel thất bại: " + e.getMessage());
            }
        }
    public final Object data=new Object[][]{};
    public void panel3(){
        p3=new JPanel();
        p3.setSize( 600, 500);
        p3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(700, 700));
        table.setBackground(new Color(247,251,251));
       
        model.addColumn("Mã SP");
        model.addColumn("Tên SP");
        model.addColumn("Ngày nhập");
        model.addColumn("Đơn vị");
        model.addColumn("Số lượng");
        model.addColumn("Chi phí");
        model.addColumn("Tổng chi phí");
        
//        for(NhapLieuModel st: arr){
//            model.addRow(new Object[]{st.masp, st.tensp, st.ngaynhap, st.donvi,st.soluong, st.chiphi,st.tongchiphi});
//        }
        JScrollPane jScrollPane = new JScrollPane(table);
        p3.add(jScrollPane);
          table.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int selectedRow = table.getSelectedRow();
            
            if (selectedRow != -1) { // Đảm bảo rằng có dòng được chọn
                txt_masp.setText((String) table.getValueAt(selectedRow, 0));
                txt_tensp.setText((String) table.getValueAt(selectedRow, 1));
                Date date=null;
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    date=formatter.parse((String) table.getValueAt(selectedRow, 2));
                } catch (ParseException ex) {
                    Logger.getLogger(NhapLieuView.class.getName()).log(Level.SEVERE, null, ex);
                }
                calendar.setDate(date);
                cbb_dv.setSelectedItem((String) table.getValueAt(selectedRow, 3));
                int soLuong=Integer.parseInt((String)table.getValueAt(selectedRow, 4));
                sp_sl.setValue(soLuong);
                txt_cp.setText((String) table.getValueAt(selectedRow, 5));
                txt_tcp.setText((String) table.getValueAt(selectedRow, 6));
            }
        }
    });
        
                }
    public JTable getTable(){
        return table;
    }
    
    public void addcom(){
       
        j.setJMenuBar(new Menubar());
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        j.setSize(1100,800);
        p_center=new JPanel();
        p_center.setLayout(new BorderLayout() );
        p_center.add(p2,BorderLayout.WEST);
        
        p_center.add(p3,BorderLayout.EAST);
        p1.setBackground(new Color(217, 217, 217));
        p2.setBackground(new Color(217, 217, 217));
        p3.setBackground(new Color(217, 217, 217));
        p4.setBackground(new Color(217, 217, 217));
        p_tt.setBackground(new Color(217, 217, 217));
        p_nut.setBackground(new Color(217, 217, 217));
        timkiem.setBackground(new Color(255, 204, 204));
       
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
//  public NhapLieuModel get_sp() {
//        
//        int ma=Integer.parseInt(txt_masp.getText());
//        String tensp = txt_tensp.getText();
//        Date ngayNhap = calendar.getDate(); // Lấy ngày từ JDateChooser
//
//        String donvi = String.valueOf(cbb_dv.getSelectedItem());
//        int soluong = (int) sp_sl.getValue(); // Lấy giá trị từ JSpinner
//
//        double chiphi = 0.0; // Giá trị mặc định
//        double tongchiphi = 0.0; // Giá trị mặc định
//
//        // Kiểm tra và chuyển đổi txt_cp và txt_tcp thành số nếu chúng không rỗng
//        String txtCpText = txt_cp.getText().trim();
//        String txtTcpText = txt_tcp.getText().trim();
//        if (!txtCpText.isEmpty()) {
//            chiphi = Double.parseDouble(txtCpText);
//        }
//        if (!txtTcpText.isEmpty()) {
//            tongchiphi = Double.parseDouble(txtTcpText);
//        }
//
//        NhapLieuModel sp = new NhapLieuModel(ma, tensp, ngayNhap, donvi, soluong,chiphi, tongchiphi);
//        return sp;
//}

     public void updateNewTable(int masp, String tensp, Date ngaynhap, String donvi,  int soluong,Double chiphi, Double tongchiphi) {
        // Thêm một hàng mới vào table model
        DefaultTableModel model=(DefaultTableModel)table.getModel();
        model.addRow(new Object[]{masp, tensp, ngaynhap, donvi, soluong,chiphi, tongchiphi});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }  

     public String getSearchText() {
        return txt_tk.getText();
    }
      public String getMa() {
        return txt_masp.getText();
    }
      public String getTen() {
        return txt_tensp.getText();
    }
       public String getCp() {
        return txt_cp.getText();
    }
    public void exitSearch() {
        

    }
   
   
}
