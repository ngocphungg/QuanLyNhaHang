
package View;

import Controller.QLyThucDonCtrl;
import Controller.connectdb;
import Model.ThucDonModel;
import ThucDon.Theloaimodel;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class QLyThucDonView extends JFrame implements ActionListener{
    
    static Integer k = 0;
    JFrame j;
    JTable table;
    JLabel l,l1,mamon,tenmon,giamon,loai,anh;
    JPanel p1,p2,p3,p4,p_tt,p_nut,p5,p_center;
    JButton timkiem,them,xoa,luu,xuat,reset;
    public JTextField txt_tk,txt_mamon,txt_tenmon,txt_gia, txt_theloai;
    public JComboBox<String> cbb_loai;
    String options="Thêm thể loại";
    private QLyThucDonCtrl controller;
    
    private ThucDonModel md;
   
    public DefaultTableModel model=new DefaultTableModel();
    ArrayList<ThucDonModel> arr= new ArrayList<ThucDonModel>();
    public QLyThucDonView(){
        
        j=new JFrame();
        panel1();
        panel2();
        panel3();
        addcom();
        initialize();
        connectdb dbConnect = new connectdb();
        controller = new QLyThucDonCtrl( this, dbConnect);
        
}
    public void panel1(){
        p1=new JPanel();
        p1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        Font f=new Font("Arial",Font.BOLD,30);
        l=new JLabel("QUẢN LÝ THỰC ĐƠN",JLabel.CENTER);
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
        mamon=new JLabel("Mã món : ");
        tenmon=new JLabel("Tên món : ");
        loai=new JLabel("Loại : ");
        giamon=new JLabel("Đơn giá : ");
   
        txt_mamon=new JTextField();
        txt_mamon.setPreferredSize(new Dimension(200,25));
        txt_mamon.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        txt_tenmon=new JTextField();
        txt_tenmon.setPreferredSize(new Dimension(200,25));
        txt_tenmon.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        txt_gia=new JTextField();
        txt_gia.setPreferredSize(new Dimension(200,25));
        txt_gia.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        txt_theloai=new JTextField();
        txt_theloai.setPreferredSize(new Dimension(200,25));
        txt_theloai.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        cbb_loai=new JComboBox<>();
        cbb_loai.addItem(options);
        
        
        cbb_loai.setPreferredSize(new Dimension(200,25));
        cbb_loai.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        
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
        xoa.setVisible(false);

        luu=new JButton("Lưu");
        luu.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        luu.setPreferredSize(new Dimension(40,30));
        luu.setBackground(new Color(242,188,214));
        luu.addActionListener(this);
        luu.setVisible(false);
        
        xuat=new JButton("Xuất");
        xuat.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        xuat.setPreferredSize(new Dimension(40,30));
        xuat.setBackground(new Color(242,188,214));
        reset=new JButton("Reset"); //làm mới thông tin
        reset.setBorder(BorderFactory.createLineBorder(new Color(230, 255, 230), 1));
        reset.setPreferredSize(new Dimension(40,30));
        reset.setBackground(new Color(242,188,214));
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                txt_mamon.setText("");
                txt_gia.setText("");
                txt_tenmon.setText("");
                them.setVisible(true);
                cbb_loai.setVisible(true);
                txt_mamon.setEditable(true);
            }
        });
        p_tt=new JPanel();
        p_tt.setSize(500,500);
        p_tt.setLayout(new GridBagLayout());
        GridBagConstraints gb=new GridBagConstraints();
        gb.insets=new Insets(5,5,5,5);
        gb.gridx=0;
        gb.gridy=0;
        p_tt.add(mamon,gb);
        gb.gridx=1;
        gb.gridy=0;
        p_tt.add(txt_mamon,gb);
        gb.gridx=0;
        gb.gridy=1;
        p_tt.add(tenmon,gb);
        gb.gridx=1;
        gb.gridy=1;
        p_tt.add(txt_tenmon,gb);
        gb.gridx=0;
        gb.gridy=2;
        p_tt.add(loai,gb);
        cbb_loai.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (cbb_loai.getSelectedItem().equals("Thêm thể loại")) {
                        cbb_loai.setVisible(false);
                        gb.gridx=1;
                        gb.gridy=2;
                        p_tt.add(txt_theloai,gb);
                        
                        // Hiển thị JTextField khi mục "Thêm mục mới" được chọn
                    }
                }
            }
        }); 
        gb.gridx=1;
        gb.gridy=2;
        p_tt.add(cbb_loai,gb);
        
        gb.gridx=0;
        gb.gridy=5;
        p_tt.add(giamon,gb);
        gb.gridx=1;
        gb.gridy=5;
        p_tt.add(txt_gia,gb);
        
        p_nut=new JPanel();
        p_nut.setSize(500,50);
        p_nut.setLayout(new GridBagLayout());
        GridBagConstraints gb1=new GridBagConstraints();
        gb1.insets=new Insets(5,5,5,5);
        gb1.gridx=0;
        gb1.gridy=0;
        gb1.gridwidth=1;
        p_nut.add(them,gb1);
//        
//        gb1.gridx=1;
//        gb1.gridy=0;
//        gb1.gridwidth=1;
//        p_nut.add(sua,gb1);
        
        gb1.gridx=2;
        gb1.gridy=0;
        gb1.gridwidth=1;
        p_nut.add(xoa,gb1);
        
        gb1.gridx=3;
        gb1.gridy=0;
        gb1.gridwidth=1;
        p_nut.add(luu,gb1);
        gb1.gridx=4;
        gb1.gridy=0;
        gb1.gridwidth=1;
        p_nut.add(xuat,gb1);
        gb1.gridx=5;
        gb1.gridy=0;
        gb1.gridwidth=1;
        p_nut.add(reset,gb1);
        
        p2.setLayout(new GridLayout(2,1));
        p2.add(p_tt);
        p2.add(p_nut);
    }
    public final Object data=new Object[][]{};
    public void panel3(){
        p3=new JPanel();
        p3.setSize( 600, 500);
        p3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(700, 700));
        table.setBackground(new Color(247,251,251));
       
        model.addColumn("Mã món");
        model.addColumn("Loại");
        model.addColumn("Tên món");
        model.addColumn("Đơn giá");
//        
//        for(ThucDonModel st: arr){
//            model.addRow(new Object[]{st.idmon, st.theloai, st.tenmon, st.dongia});
//        }
        JScrollPane jScrollPane = new JScrollPane(table);
        p3.add(jScrollPane);
        table.addMouseListener(new MouseAdapter() {
//            sai chưa hiển thị được dữ liệu
        @Override
        public void mouseClicked(MouseEvent e) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1)  {
                txt_mamon.setText((String) table.getValueAt(selectedRow, 0));
                txt_mamon.setEditable(false);
                txt_tenmon.setText((String) table.getValueAt(selectedRow, 2));
                cbb_loai.setSelectedItem((String) table.getValueAt(selectedRow, 1));
                // sua kieu du lieu 
                txt_gia.setText((String) table.getValueAt(selectedRow, 3).toString());
                
                them.setVisible(false);
                xoa.setVisible(true);
                luu.setVisible(true);
            }
        }
    });
    }
//    public void tableListener(MouseAdapter log){
//        table.addMouseListener(log);
//    }
    public JTable getTable(){
        return table;
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
        p5=new JPanel();
        ImageIcon icon1=new ImageIcon("C:/Users/admin/Documents/NetBeansProjects/QLYNHAHANG/build/classes/icon&image/nhanvien.png","nhanvien");
        ImageIcon resizedIcon1 = resizeIcon(icon1, 400, 400);
        anh=new JLabel(resizedIcon1);
        p5.add(anh);
        p_center=new JPanel();
        p_center.setLayout(new BorderLayout() );
        p_center.add(p2,BorderLayout.WEST);
        
        p_center.add(p3,BorderLayout.EAST);
       
        j.setLayout(new BorderLayout());
        j.add(p1,BorderLayout.NORTH);
        j.add(p_center,BorderLayout.CENTER);
        
        j.setVisible(true);
}


    public void themListener (ActionListener log){
        them.addActionListener(log);       
    }
    public void xoaListener (ActionListener log){
        xoa.addActionListener(log);       
    }
    public void luuListener (ActionListener log){
        luu.addActionListener(log);
        
    }
    public ThucDonModel get_td() {
        String mamon = txt_mamon.getText();
        String tenmon = txt_tenmon.getText();
        String loai = String.valueOf(cbb_loai.getSelectedItem());
        float gia = 0; // Giá trị mặc định

        // Kiểm tra và chuyển đổi txt_gia thành số nếu chúng không rỗng
        String txtGiaText = txt_gia.getText().trim();
        if (!txtGiaText.isEmpty()) {
            gia = Float.parseFloat(txtGiaText);
        }
       
        ThucDonModel td = new ThucDonModel(mamon, loai, tenmon, gia );
        return td;
}

     public void updateNewTable(String mamon, String loai, String tenmon, Double gia) {
        // Thêm một hàng mới vào table model
        DefaultTableModel model=(DefaultTableModel)table.getModel();
        model.addRow(new Object[]{mamon, loai, tenmon,gia});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }  
//    public void updateCategories(List<Theloaimodel> arrtl) {
//        String selectedCategory = (String) cbb_loai.getSelectedItem(); // Lấy thể loại đã chọn trước khi cập nhật
//
////        cbb_loai.removeAllItems(); // Xóa các mục cũ trước khi cập nhật mới
//        for (Theloaimodel category : arrtl) {
//            cbb_loai.addItem(category); // Thêm các mục mới vào thanh chọn
//        }
//
//        // Sau khi cập nhật, chọn lại thể loại trước đó nếu có
//        if (selectedCategory != null && arrtl.contains(selectedCategory)) {
//            cbb_loai.setSelectedItem(selectedCategory);
//        }
//    }

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
                headerRow.createCell(0).setCellValue("Mã món");
                headerRow.createCell(1).setCellValue("Thể loại");
                headerRow.createCell(2).setCellValue("Tên món");
                headerRow.createCell(3).setCellValue("Giá thành");
            
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
            try (FileOutputStream outputStream = new FileOutputStream("DanhSachThucDon.xlsx")) {
                workbook.write(outputStream);
                JOptionPane.showMessageDialog(null, "Xuất Excel thành công!");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Xuất Excel thất bại: " + e.getMessage());
            }
        }

    public void updateCategories(List<Theloaimodel> arrtl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   
}
