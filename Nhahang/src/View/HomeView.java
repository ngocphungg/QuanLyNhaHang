package View;

import Controller.HoaDonController;
import Controller.connectdb;
import Model.ChiTietHDModel;
import Model.HoaDonModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HomeView extends JFrame implements ActionListener {

    private HoaDonModel hdmodel;
    private ChiTietHDModel ctmodel;
    private HoaDonController controller;
    public JFrame j;
    public JPanel p1, p2, p3, p12, p11, p21, p22;
    public JLabel l1, l2, l3, l4, l5, l6, soban, status;
    private JLabel tt;
    public String zone[] = {"Ngoài trời", "Tầng 1", "Tầng 2"};
    public JComboBox cb, cb3;
    public JButton[] ban;
    public JButton order, edit, chuyenban, xoa,thanhtoan,xoamon,inhd;
    public DefaultTableModel tableModel;
    private JButton selectedTableButton;
    public SpinnerNumberModel spinnerModel;
    public JSpinner soluong ;
    public JTable jt;
    public String banso,khuvuc;
    public JComboBox<String> cb1; // Thanh chọn loại món
    public JComboBox<String> cb2; // Thanh chọn món
    int solgg;
//    public DefaultTableModel model=new DefaultTableModel();


    public HomeView() {
        j = new JFrame();
        j.setSize(1100, 750);
        j.setLocationRelativeTo(null);
        customcomponent();
        addcomponent();
        order();
        initialize();
        hdmodel = new HoaDonModel();
        connectdb dbConnect = new connectdb(); // Khởi tạo đối tượng DBConnect
        controller = new HoaDonController(this, dbConnect);
        
    }

    public void customcomponent() {

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p12 = new JPanel();
        p11 = new JPanel();
        ban = new JButton[15];

        for (int i = 0; i < ban.length; i++) {
            ban[i] = new JButton("Bàn " + (i + 1));
            ban[i].addActionListener(this);
            p12.add(ban[i]);
        }
        l1 = new JLabel("Khu vực");
        cb = new JComboBox(zone);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setJMenuBar(new Menubar());
        j.setExtendedState(JFrame.MAXIMIZED_BOTH);
        j.setTitle("Nhà Hàng Như Ý");
        j.setLayout(new BorderLayout());
        j.setLocationRelativeTo(null);
        p1.setLayout(new BorderLayout());
        p1.setOpaque(true);
        p1.setBorder(BorderFactory.createTitledBorder("Bàn ăn"));

        cb.setBounds(20, 20, 30, 10);
        p12.setLayout(new GridLayout(5, 3, 10, 10));
    }

    public void addcomponent() {
        p11.add(l1);
        p11.add(cb);
        p1.add(p12, BorderLayout.CENTER);
        p1.add(p11, BorderLayout.NORTH);
        j.add(p1, BorderLayout.WEST);
        j.add(p2, BorderLayout.CENTER);
        j.add(p3, BorderLayout.SOUTH);
        j.setVisible(true);
    }

    public void order() {
        p2.setLayout(new BorderLayout());
        p2.setBorder(BorderFactory.createTitledBorder("Gọi món"));
        l3 = new JLabel("Chọn món:");
        l4 = new JLabel("Số lượng:");

        p21 = new JPanel();
        p21.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 10, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        
        p21.add(new JLabel("Chọn loại:"), gbc);
        cb1 = new JComboBox<>();
        cb2 = new JComboBox<>();
        gbc.gridx = 1;
        gbc.gridy = 0;
        cb1 = new JComboBox();
        cb1.setPreferredSize(new Dimension(200,25));
        p21.add(cb1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        p21.add(l3, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        cb2 = new JComboBox();
        cb2.setPreferredSize(new Dimension(200, 25));
        p21.add(cb2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        p21.add(l4, gbc);

        // Tạo SpinnerNumberModel với giá trị ban đầu, giá trị tối thiểu, tối đa và bước nhảy
        spinnerModel = new SpinnerNumberModel(0, 0, 50, 1); // Giá trị ban đầu là 0, giá trị tối thiểu là 0, tối đa là 50, bước nhảy là 1
        soluong = new JSpinner(spinnerModel);
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) soluong.getEditor();
        editor.getTextField().setHorizontalAlignment(JTextField.CENTER);
        spinnerModel.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				solgg=(int)spinnerModel.getValue();
			}
		});
        

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        p21.add(soluong, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        p21.add(new JLabel("Số bàn:"), gbc);

        //so ban, lay so ban theo button ban
        soban = new JLabel();

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        p21.add(soban, gbc);

        //Trạng thái, lấy trạng thái từ button bàn
        gbc.gridx = 3;
        gbc.gridy = 3;
        p21.add(new JLabel("Trạng thái:"), gbc);
        status = new JLabel();
        gbc.gridx = 4;
        gbc.gridy = 3;
        p21.add(status, gbc);
        //4 button xác nhận order
        order = new JButton("Xác nhận");
        edit = new JButton("Sửa đổi");
        chuyenban = new JButton("Chuyển bàn");
        chuyenban.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kiểm tra xem đã chọn bàn và khu vực chưa
                if (banso == null || khuvuc == null) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn và khu vực trước khi chuyển", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Hiển thị frame ChuyenBan
                String[] tableInfo = getSelectedTableInfo();
                new ChuyenBanView(HomeView.this, tableInfo[0], tableInfo[1]).setVisible(true);
               
            }
        });
        xoa = new JButton("Xóa bàn");
        xoamon=new JButton("Xóa món");
        gbc.gridx = 0;
        gbc.gridy = 4;
        p21.add(order, gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        p21.add(edit, gbc);
        gbc.gridx = 4;
        gbc.gridy = 4;
        p21.add(chuyenban, gbc);
        gbc.gridx = 6;
        gbc.gridy = 4;
        p21.add(xoa, gbc);
        //panel các món đã gọi
        p22 = new JPanel();
        p22.setBorder(BorderFactory.createTitledBorder("Món đã gọi"));

        jt = new JTable();
        jt.setBounds(0, 40, 400, 400);
        JScrollPane sp = new JScrollPane(jt);
        
        // Thiết lập kích thước và vị trí cho JScrollPane
        sp.setPreferredSize(new Dimension(800, 400)); // Thiết lập kích thước ban đầu, bạn có thể thay đổi theo ý muốn
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // Đặt chính sách thanh cuộn ngang theo nhu cầu
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Đặt chính sách thanh cuộn dọc theo nhu cầu

        // Thêm JScrollPane vào panel p22
        p22.add(sp);
        tableModel = new DefaultTableModel();
     // Thêm sự kiện mouse listener để kiểm tra khi nhấn đúp lên một dòng trong bảng
        jt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Lấy chỉ mục hàng được chọn
                int selectedRow = jt.getSelectedRow();
                // Nếu có hàng được chọn
                if (selectedRow != -1) {
                    // Hiển thị button "Xoá món"
                    gbc.gridx = 8;
                    gbc.gridy = 4;
                    p21.add(xoamon, gbc);
                    p21.revalidate(); // Cập nhật layout của panel p21
                    p21.repaint(); // Vẽ lại panel p21
                    String loaiMon = (String) jt.getValueAt(selectedRow, 0);
                    String tenMon = (String) jt.getValueAt(selectedRow, 1);
                    Object soLuongObject = jt.getValueAt(selectedRow, 2);
                    int soLuong = 0; // Giá trị mặc định nếu không thể chuyển đổi
                    if (soLuongObject instanceof Integer) {
                        soLuong = (int) soLuongObject; // Chuyển đổi kiểu dữ liệu từ Object thành int
                    } else if (soLuongObject instanceof String) {
                        try {
                            soLuong = Integer.parseInt((String) soLuongObject); // Chuyển đổi kiểu dữ liệu từ String thành int
                        } catch (NumberFormatException e1) {
                            // Xử lý nếu không thể chuyển đổi String sang int
                            e1.printStackTrace();
                        }
                    }                    // Đặt thông tin vào các thành phần tương ứng
                    cb1.setSelectedItem(loaiMon);
                    cb2.setSelectedItem(tenMon);
                    spinnerModel.setValue(soLuong);
                } 
            }
        });
       j.addMouseListener(new MouseAdapter() {
    	   
    	   public void mouseClicked(MouseEvent e) {
               
                p21.remove(xoamon); // Xóa button "Xoá món" khỏi panel p21
                p21.revalidate(); // Cập nhật layout của panel p21
                p21.repaint(); // Vẽ lại panel p21
               }
       });
       

//        Dimension oldSize = sp.getPreferredSize();
//        int newWidth = oldSize.width * 2; // Gấp đôi kích thước cũ
//        int height = oldSize.height;
//
//        // Thiết lập kích thước mới cho JScrollPane
//        sp.setPreferredSize(new Dimension(newWidth, height));
        tableModel.setColumnIdentifiers(new String[]{"Loại", "Món", "Số lượng", "Đơn giá", "Thành tiền"});
        jt.setModel(tableModel);

        JPanel p23 = new JPanel();
        p23.setLayout(new GridLayout(1, 3, 10, 10));
        thanhtoan = new JButton("Thanh toán ");
        inhd=new JButton("Thanh toán và in hóa đơn");
        tt = new JLabel();
        p23.add(tt);
        p23.add(thanhtoan);
        p23.add(inhd);
        
        p22.add(sp);
        p2.add(p21, BorderLayout.NORTH);
        p2.add(p22, BorderLayout.CENTER);
        p2.add(p23, BorderLayout.SOUTH);
    }
    public void updateCategories(ArrayList<String> categories) {
        String selectedCategory = (String) cb1.getSelectedItem(); // Lấy thể loại đã chọn trước khi cập nhật

        cb1.removeAllItems(); // Xóa các mục cũ trước khi cập nhật mới
        for (String category : categories) {
            cb1.addItem(category); // Thêm các mục mới vào thanh chọn
        }

        // Sau khi cập nhật, chọn lại thể loại trước đó nếu có
        if (selectedCategory != null && categories.contains(selectedCategory)) {
            cb1.setSelectedItem(selectedCategory);
        }
    }

    // Phương thức để cập nhật thanh chọn món
//    public void updateMenuItems(ArrayList<String> menuItems) {
//        String selectedMenuItem = (String) cb2.getSelectedItem(); // Lấy món đã chọn trước khi cập nhật
//
//        cb2.removeAllItems(); // Xóa các mục cũ trước khi cập nhật mới
//        for (String menuItem : menuItems) {
//            cb2.addItem(menuItem); // Thêm các mục mới vào thanh chọn
//        }
//
//        // Sau khi cập nhật, chọn lại món trước đó nếu có
//        if (selectedMenuItem != null && menuItems.contains(selectedMenuItem)) {
//            cb2.setSelectedItem(selectedMenuItem);
//        }
//    }

   
 // Khai báo biến để lưu trạng thái hiện tại của button
    private JButton selectedButton = null;
//    Chọn bàn
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        // Xử lý sự kiện khi click vào button bàn
        for (int i = 0; i < ban.length; i++) {
            if (source == ban[i]) {
                // Lấy số bàn từ button và khu vực từ combobox
                banso = ban[i].getText();
                khuvuc = (String) cb.getSelectedItem();
                // Cập nhật label soban
                clearTable();
                updateSobanLabel(khuvuc, banso);
                controller.getTableInfoFromHoadon(banso, khuvuc);
                
                // Nếu có button được chọn trước đó, đặt màu của nó về màu cũ
                if(selectedButton != null) {
                    selectedButton.setBackground(UIManager.getColor("Button.background"));
                }
                
                // Đặt màu xanh cho button được chọn
                ban[i].setBackground(Color.GREEN);
                selectedButton = ban[i]; // Lưu button hiện tại vào biến selectedButton
                if (cb1.getItemCount() > 0) {
                    cb1.setSelectedIndex(0);
                }
                if (cb2.getItemCount() > 0) {
                    cb2.setSelectedIndex(0);
                }
                
                // Đặt giá trị của JSpinner về 0
                spinnerModel.setValue(0);
                
                break;
               
            }
        }
        // Xử lý sự kiện khi chọn khu vực từ combobox
        if (source == cb) {
            // Lấy khu vực từ combobox
            khuvuc = (String) cb.getSelectedItem();
            // Cập nhật label soban
            clearTable();
            updateSobanLabel(khuvuc, "");
            
            // Nếu có button được chọn trước đó, đặt màu của nó về màu cũ
            if(selectedButton != null) {
                selectedButton.setBackground(UIManager.getColor("Button.background"));
                selectedButton = null; // Xóa button được chọn
            }
        }
    }

    // Phương thức cập nhật label soban
    public void updateSobanLabel(String khuvuc, String banso) {
        soban.setText("Khu vực: " + khuvuc + ", Bàn: " + banso);
        hdmodel.setKhuVuc(khuvuc);

    }

    public void updateNewTable(String type, String menu, int quantity, float unitPrice, float totalPrice) {
        // Thêm một hàng mới vào table model
        tableModel.addRow(new Object[]{type, menu, quantity, unitPrice, totalPrice});
    }

    public void XacNhanListener(ActionListener log) {
    	order.addActionListener(new ActionListener() {
			
        @Override
        public void actionPerformed(ActionEvent e) {
                if (banso == null || khuvuc == null) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn và khu vực trước khi thanh toán", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                log.actionPerformed(e);
            }
      });   	
    }
    public void XoaMonListener(ActionListener log) {
    	xoamon.addActionListener(new ActionListener() {
			
        @Override
        public void actionPerformed(ActionEvent e) {
                if (banso == null || khuvuc == null) {
          JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn và khu vực trước khi xóa món", "Lỗi", JOptionPane.ERROR_MESSAGE);
          return;
        }
                int confirmed = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa món này ở bàn"+banso+"-"+khuvuc+ "?", "Xác nhận xóa bàn", JOptionPane.YES_NO_OPTION);
if (confirmed == JOptionPane.YES_OPTION) {
    log.actionPerformed(e);
}

        }
});
    }

    public void XoaBanListenner(ActionListener log) {
        xoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (banso == null || khuvuc == null) {
            		  JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn và khu vực trước khi xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
            		  return;
            		}

            		int confirmed = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa bàn " + banso + " ở " + khuvuc + " ?", "Xác nhận xóa bàn", JOptionPane.YES_NO_OPTION);
            		if (confirmed == JOptionPane.YES_OPTION) {
            		  log.actionPerformed(e);
            		}
            }
        });
    }
    public void SuaItemListener(ActionListener log) {
    	edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (banso == null || khuvuc == null) {
          		  JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn và khu vực trước khi sửa", "Lỗi", JOptionPane.ERROR_MESSAGE);
          		  return;
          		}
				int confirmed = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn sửa " + banso + " ở " + khuvuc + " ?", "Xác nhận sửa", JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    log.actionPerformed(e);
                }				
			}
		});
    }
    public void ThanhtoanListenner(ActionListener log) {
        thanhtoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(banso != null && khuvuc != null) {
            		if (banso == null || khuvuc == null) {
              		  JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn và khu vực trước khi thanh toán", "Lỗi", JOptionPane.ERROR_MESSAGE);
              		  return;
              		}
                int confirmed = JOptionPane.showConfirmDialog(null, "Bạn thanh toán bàn " + banso+ " - " + khuvuc + " ?", "Xác nhận thanh toán bàn", JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    log.actionPerformed(e);
                    
                		}
            		}else {
            			displayMessage("Không có thông tin bàn!!!");
            	}
            }
        });
    }
    public void ChuyenBanListenner(ActionListener log) {
        chuyenban.addActionListener(log);
    }

//    hiển thị thêm 1 hàng dữ liệu lên bảng chi tiết hóa đơn 
    public void updateTableInfo(String banso, String khuvuc, String tenmon, String loaimon, int soluong, float dongia, float thanhtien) {
        // Thêm một hàng mới vào bảng
        tableModel.addRow(new Object[]{loaimon, tenmon, soluong, dongia, thanhtien});
    }

    public void clearTable() {
        tableModel.setRowCount(0);
    }
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    public void updateStatus(String trangthai) {
        status.setText(trangthai);
    }
    public void setTotalAmount(float totalAmount) {
        // Sử dụng biến tt để hiển thị tổng tiền
        String totalAmountText = String.format("%.1f", totalAmount);
        tt.setText(" Tổng tiền: " +totalAmountText);
    }
    public void clearStatus() {
    	status.setText("");
    }
    public void clearTotalAmount() {
    	tt.setText(" Tổng tiền: ");
    }
    public JTable getTable() {
        return jt;
    }
    public ChiTietHDModel getCTHD() {
    	String loaiMon= (String)cb1.getSelectedItem();
    	String tenMon=(String)cb2.getSelectedItem();
    	int soLuong= (int) spinnerModel.getValue();
    	ChiTietHDModel cthd= new ChiTietHDModel(tenMon,loaiMon,soLuong);
		return cthd;
    }
  
    public HoaDonModel getHoaDon() {
    	HoaDonModel hd= new HoaDonModel(banso,khuvuc);
    	return hd;
    }
    public String[] getSelectedTableInfo() {
        String khuVuc = khuvuc;
        String ban = banso; // selectedButton là button bàn đang được chọn
        return new String[]{khuVuc, ban};
    }

     //Xuất excel
    private void initialize() {
     inhd.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             if(banso != null && khuvuc != null) {
             if (banso == null || khuvuc == null) {
               JOptionPane.showMessageDialog(null, "Vui lòng chọn bàn và khu vực trước khi thanh toán", "Lỗi", JOptionPane.ERROR_MESSAGE);
               return;
             }
             int confirmed = JOptionPane.showConfirmDialog(null, "Bạn thanh toán bàn " + banso+ " - " + khuvuc + " ?", "Xác nhận thanh toán bàn", JOptionPane.YES_NO_OPTION);
             if (confirmed == JOptionPane.YES_OPTION){
                 controller.PaymentOfCurrentTable();
             // Gọi hành động từ controller khi nút xuất được nhấn
                 exportToExcel();
             }
             }

         }
     });
}
    private void exportToExcel() {

           Workbook workbook = new XSSFWorkbook(); // Tạo workbook mới

          // Tạo một trang mới trong workbook
          Sheet sheet = workbook.createSheet("Hóa đơn");

          // Tạo header cho bảng Excel
          Row headerRow = sheet.createRow(0);
          headerRow.createCell(0).setCellValue("STT");
          headerRow.createCell(1).setCellValue("Tên bàn");
          headerRow.createCell(2).setCellValue("Tên món");
          headerRow.createCell(3).setCellValue("Số lượng");
          headerRow.createCell(4).setCellValue("Giá thành");
          headerRow.createCell(5).setCellValue("Tổng tiền");

          // Lấy số lượng hàng trong bảng
          int rowCount = tableModel.getRowCount();

          // Duyệt qua từng hàng trong bảng và thêm dữ liệu vào workbook
          for (int i = 0; i < rowCount; i++) {
              // Tạo một hàng mới trong trang
              Row row = sheet.createRow(i + 1);
    //
              // Lấy thông tin từ bảng
              int soThuTu = i + 1;
              String tenBan = banso;
              String tenMon = tableModel.getValueAt(i, 1).toString();
              int soLuong = Integer.parseInt(tableModel.getValueAt(i, 2).toString());
              float giaThanh = Float.parseFloat(tableModel.getValueAt(i, 3).toString());
              float tongTien = Float.parseFloat(tableModel.getValueAt(i, 4).toString());

              // Đặt giá trị cho từng ô trong hàng
              row.createCell(0).setCellValue(soThuTu);
              row.createCell(1).setCellValue(tenBan);
              row.createCell(2).setCellValue(tenMon);
              row.createCell(3).setCellValue(soLuong);
              row.createCell(4).setCellValue(giaThanh);
              row.createCell(5).setCellValue(tongTien);
          }

          // Lưu workbook vào file Excel
          try (FileOutputStream outputStream = new FileOutputStream("HoaDon.xlsx")) {
              workbook.write(outputStream);
              JOptionPane.showMessageDialog(null, "Xuất hóa đơn thành công!");
          } catch (IOException e) {
              e.printStackTrace();
              JOptionPane.showMessageDialog(null, "Xuất Excel thất bại: " + e.getMessage());
          }
}
    

}
