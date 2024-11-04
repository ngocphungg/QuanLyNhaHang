
package View;


import Controller.QLyNhanVienCtrl;
import Controller.connectdb;
//import Model.nhanvienModel;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author admin
 */
public class NhanVienView extends JFrame implements ActionListener{
    
    static Integer k = 0;
    JFrame j;
    JTable table;
    public JLabel l,l1,manv,tennv,gioitinh,chucvu,sdt,anh,quequan,chon_anh;
    JPanel p1,p2,p3,p4,p_tt,p_nut,p5,p_center,p_anh;
    JButton timkiem,them,xoa,luu,xuat,reset,loadImg;
    public JTextField txt_tk,txt_manv,txt_ten,txt_sdt,txt_qq;
    public JComboBox cbb_cv;
    public JFileChooser image;
    String options[]={"Quản Lý","Nhân Viên"};
    public JCheckBox cb_nam,cb_nu;
    connectdb db;
    private QLyNhanVienCtrl controller;
//    nhanvienModel m;
    public DefaultTableModel model=new DefaultTableModel();
//    ArrayList<nhanvienModel> arr= new ArrayList<nhanvienModel>();
    private String selectedFile;
  
    public NhanVienView(){
        
        j=new JFrame();
        panel1();
        panel2();
        panel3();
        addcom();
        initialize();
        controller = new QLyNhanVienCtrl(this, db);
        
}
    public void panel1(){
        p1=new JPanel();
        p1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        Font f=new Font("Arial",Font.BOLD,30);
        l=new JLabel("QUẢN LÝ NHÂN VIÊN",JLabel.CENTER);
        l.setFont(f);
               
        l1=new JLabel("TÌM KIẾM",JLabel.CENTER);       
        txt_tk=new JTextField();
        txt_tk.setPreferredSize(new Dimension(200,30));
        txt_tk.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        ImageIcon icon=new ImageIcon("D:/TKKTPM/NhaHang/NhaHang/build/classes/icon&image/tk.png","tk");
        ImageIcon resizedIcon = resizeIcon(icon, 40, 40);
        timkiem = new JButton(resizedIcon);
        Insets margin = new Insets(0, 0, 0, 0); // top, left, bottom, right
        timkiem.setMargin(margin);
        timkiem.setPreferredSize(new Dimension(30,26));
        timkiem.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        
//        timkiem.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                  String searchText = txt_tk.getText().trim(); // Lấy nội dung từ ô nhập liệu
//                    searchAndDisplayResult(searchText);
//            }
//    });
           
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
        manv=new JLabel("Mã NV : ");
        tennv=new JLabel("Tên NV : ");
        gioitinh=new JLabel("Giới tính : ");
        chucvu=new JLabel("Chức vụ : ");
        sdt=new JLabel("SĐT : ");
        quequan=new JLabel("Quê quán:");
        chon_anh=new JLabel();
        chon_anh.setPreferredSize(new Dimension(150,150));
        chon_anh.setHorizontalAlignment(SwingConstants.CENTER);
        loadImg=new JButton("Ảnh");
        
//        loadImg.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JFileChooser fileChooser=new JFileChooser();
//                int result = fileChooser.showOpenDialog(NhanVienView.this);
//                if(result == JFileChooser.APPROVE_OPTION){
//                    File selectedFile=fileChooser.getSelectedFile();
//                    displayImage(selectedFile);
//                }
//            }
//        });
        
        
        txt_manv=new JTextField();
        txt_manv.setPreferredSize(new Dimension(200,25));
        txt_manv.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        txt_ten=new JTextField();
        txt_ten.setPreferredSize(new Dimension(200,25));
        txt_ten.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        txt_sdt=new JTextField();
        txt_sdt.setPreferredSize(new Dimension(200,25));
        txt_sdt.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        txt_qq=new JTextField();
        txt_qq.setPreferredSize(new Dimension(200,25));
        txt_qq.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        cb_nam=new JCheckBox("Nam");
        cb_nu=new JCheckBox("Nữ");
        cbb_cv=new JComboBox(options);
        cbb_cv.setPreferredSize(new Dimension(200,25));
        cbb_cv.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        
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
                txt_manv.setText("");
                txt_ten.setText("");
                cb_nam.setSelected(true);
                cb_nu.setSelected(false);
                cbb_cv.setSelectedIndex(0);
                txt_sdt.setText("");
                txt_qq.setText("");
                
            }
    });
        p_tt=new JPanel();
        p_tt.setLayout(new GridBagLayout());
        GridBagConstraints gb=new GridBagConstraints();
        gb.gridx=0;
        gb.gridy=0;
        gb.gridwidth=1;
        gb.insets=new Insets(5,5,5,5);
        p_tt.add(manv,gb);
        gb.gridx=1;
        gb.gridy=0;
        gb.gridwidth=2;
        gb.insets=new Insets(5,5,5,5);
        p_tt.add(txt_manv,gb);
        gb.gridx=0;
        gb.gridy=1;
        gb.gridwidth=1;
        gb.insets=new Insets(5,5,5,5);
        p_tt.add(tennv,gb);
        gb.gridx=1;
        gb.gridy=1;
        gb.gridwidth=2;
        gb.insets=new Insets(5,5,5,5);
        p_tt.add(txt_ten,gb);
        gb.gridx=0;
        gb.gridy=2;
        gb.gridwidth=1;
        gb.insets=new Insets(5,0,5,0);
        p_tt.add(gioitinh,gb);
        gb.gridx=1;
        gb.gridy=2;
        gb.gridwidth=1;
        gb.insets=new Insets(5,30,5,0);
        p_tt.add(cb_nam,gb);
        gb.gridx=2;
        gb.gridy=2;
        gb.gridwidth=1;
        gb.insets=new Insets(5,0,5,0);
        p_tt.add(cb_nu,gb);
        gb.gridx=0;
        gb.gridy=3;
        gb.gridwidth=1;
        gb.insets=new Insets(5,5,5,5);
        p_tt.add(chucvu,gb);
        gb.gridx=1;
        gb.gridy=3;
        gb.gridwidth=2;
        gb.insets=new Insets(5,15,5,5);
        p_tt.add(cbb_cv,gb);
        gb.gridx=0;
        gb.gridy=4;
        gb.gridwidth=1;
        gb.insets=new Insets(5,5,5,5);
        p_tt.add(sdt,gb);
        gb.gridx=1;
        gb.gridy=4;
        gb.gridwidth=2;
        gb.insets=new Insets(5,5,5,5);
        p_tt.add(txt_sdt,gb);
        gb.gridx=0;
        gb.gridy=5;
        gb.gridwidth=1;
        p_tt.add(quequan,gb);
        gb.gridx=1;
        gb.gridy=5;
        gb.gridwidth=2;
        p_tt.add(txt_qq,gb);
        
//        p_anh=new JPanel();
//        
//        p_anh.add(chon_anh,BorderLayout.CENTER);
//        p_anh.add(loadImg,BorderLayout.SOUTH);
        
        
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
        
//        p2.setLayout(new GridLayout(3,1,1,1));
//        p2.add(p_tt);
//        p2.add(p_anh);
//        p2.add(p_nut);
// Đặt layout của panel2 thành GridBagLayout
        p2.setLayout(new GridBagLayout());

        // Định nghĩa các ràng buộc cho các thành phần trong panel2
        GridBagConstraints gbc = new GridBagConstraints();

        // Thiết lập vị trí và kích thước cho p_tt
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        p2.add(p_tt, gbc);

        // Thiết lập vị trí và kích thước cho p_anh
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.BOTH;
//        gbc.weightx = 1.0;
//        gbc.weighty = 1.0;
        p2.add(p_nut, gbc);

        // Thiết lập vị trí và kích thước cho p_nut
//        gbc.gridx = 0;
//        gbc.gridy = 4;
//        gbc.gridwidth = 1;
//        gbc.gridheight = 1;
//        gbc.fill = GridBagConstraints.BOTH;
////        gbc.weightx = 1.0;
////        gbc.weighty = 1.0;
//        p2.add(p_nut, gbc);

        
        
    }
//    public void displayImage(File file) {
//        ImageIcon icon = new ImageIcon(file.getAbsolutePath());
//        chon_anh.setIcon(icon);
//    }
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
        model.addColumn("Mã NV");
        model.addColumn("Họ và tên");
        model.addColumn("Giới tính");
        model.addColumn("Chức vụ");
        model.addColumn("Số điện thoại");
        model.addColumn("Địa chỉ");
//        model.addColumn("Ảnh");
//        //thêm dữ liệu từ mảng vào
//        for(nhanvienModel st: arr){
//            model.addRow(new Object[]{st.getManv(), st.getHoten(), st.getGioitinh(), st.getChucvu(),st.getSdt(), st.getQuequan()});
//        }
        JScrollPane jScrollPane = new JScrollPane(table);
        p3.add(jScrollPane);


        table.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) { // Đảm bảo rằng có dòng được chọn
                txt_manv.setText((String) table.getValueAt(selectedRow, 0));
                txt_ten.setText((String) table.getValueAt(selectedRow, 1));
                String gioiTinh = (String) table.getValueAt(selectedRow, 2);
                if (gioiTinh.equals("Nam")) {
                    cb_nam.setSelected(true);
                    cb_nu.setSelected(false);
                } else {
                    cb_nam.setSelected(false);
                    cb_nu.setSelected(true);
                }
                cbb_cv.setSelectedItem((String) table.getValueAt(selectedRow, 3));
                txt_sdt.setText((String) table.getValueAt(selectedRow, 4));
                txt_qq.setText((String) table.getValueAt(selectedRow, 5));
//                chon_anh.setText((String)table.getValueAt(selectedRow, 6));
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
       
        j.setJMenuBar(new Menubar());
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        j.setSize(1100,800);
        p5=new JPanel();
        ImageIcon icon1=new ImageIcon("C:/Users/admin/Documents/NetBeansProjects/QLYNHAHANG/build/classes/icon&image/nhanvien.png","nhanvien");
        ImageIcon resizedIcon1 = resizeIcon(icon1, 400, 400);
        anh=new JLabel(resizedIcon1);
        p5.add(anh);
        p_center=new JPanel();
        p_center.setLayout(new BorderLayout() );
        p_center.add(p2,BorderLayout.CENTER);
        
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
          // Tạo sự kiện lắng nghe cho frame (khi nhấp chuột ra khỏi bảng)
        j.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // Cập nhật bảng về trạng thái ban đầu
                updateTableToInitialState();
            }
        });
}
    public void updateTableToInitialState() {
    table.setModel(model); // Sử dụng model để cập nhật bảng
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
    public void loadImgActionListener(ActionListener log){
        loadImg.addActionListener(log);
    }
//    public nhanvienModel get_nv(){ //phuong thuc nay lay thong tin tu thanh phan giao dien va tra ve mot doi tuong nhan vien
//        String gioiTinh = cb_nam.isSelected() ? "Nam" : "Nữ";
//        String cv = String.valueOf(cbb_cv.getSelectedItem());
//        int ma=Integer.parseInt(txt_manv.getText());
//        if (!txt_manv.getText().isEmpty()) {
//            int manv = Integer.parseInt(txt_manv.getText());
//            // Tiếp tục xử lý dữ liệu sau khi đã chuyển đổi thành công
//        } else {
//            // Xử lý trường hợp chuỗi rỗng
//        }
//      // File selectedFile = chon_anh.getSelectedFile(); // Lấy file hình ảnh được chọn
//        nhanvienModel nv=new nhanvienModel(ma,txt_ten.getText(),gioiTinh,cv,txt_sdt.getText(),txt_qq.getText());
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
        return txt_manv.getText();
    }
      public String getTen() {
        return txt_ten.getText();
    }
       public String getsdt() {
        return txt_sdt.getText();
    }
        public String getDc() {
        return txt_qq.getText();
    }
   

    public String getSelectedFile() {
      return selectedFile;
        
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
            Sheet sheet = (Sheet) workbook.createSheet("Danh sách nhân viên");
            Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Mã nhân viên");
                headerRow.createCell(1).setCellValue("Tên nhân viên");
                headerRow.createCell(2).setCellValue("Giới tính");
                headerRow.createCell(3).setCellValue("Chức vụ");
                headerRow.createCell(4).setCellValue("Số điện thoại");
                headerRow.createCell(5).setCellValue("Quê quán");
              
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
            try (FileOutputStream outputStream = new FileOutputStream("DanhSachNhanVien.xlsx")) {
                workbook.write(outputStream);
                JOptionPane.showMessageDialog(null, "Xuất Excel thành công!");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Xuất Excel thất bại: " + e.getMessage());
            }
        }
  

 
}
