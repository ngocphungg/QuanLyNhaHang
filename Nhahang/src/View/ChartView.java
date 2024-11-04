package View;

import Controller.ChartController;
import Controller.connectdb;
import Model.ChartModel;
import Model.DanhSachModel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartPanel;

import com.toedter.calendar.JDateChooser;
import java.util.List;

public class ChartView extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    
    private DanhSachModel dsmodel;
    ChartModel model;
    ChartController controller;
    private JPanel contentPane;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel;
    private JComboBox<String> comboBox;
    public JButton btnNewButton;
    private DefaultTableModel tableModel1;
    private JTable table;
    public JButton showBtn;
    public JComboBox cbShow;
    public JDateChooser dcFrom,dcTo;
    public String dayFrom,dayTo;

    public ChartView() {
//        connectdb dbConnect = new connectdb(); 
//        controller = new ChartController(dsmodel,model,this,dbConnect);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Menubar menuBar = new Menubar();
        setJMenuBar(menuBar);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane);

        panel = new JPanel();
        tabbedPane.addTab("Danh Sách", null, panel, null);
        panel.setLayout(null);

        panel_1 = new JPanel();
        tabbedPane.addTab("Sơ đồ", null, panel_1, null);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("Chọn năm");
        lblNewLabel.setBounds(560, 25, 71, 13);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(lblNewLabel);

        panel_2 = new JPanel();
        panel_2.setBounds(30, 82, 1200, 580);
        panel_1.add(panel_2);
        panel_2.setLayout(new BorderLayout(0, 0));

        comboBox = new JComboBox<>();
        comboBox.setBounds(630, 21, 80, 21);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 10));
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] {}));
        panel_1.add(comboBox);

        btnNewButton = new JButton("Chọn");
        btnNewButton.addActionListener(this);
        btnNewButton.setBounds(718, 21, 85, 21);
        panel_1.add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("Biểu đồ doanh thu theo năm");
        lblNewLabel_1.setBounds(30, 53, 201, 21);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(lblNewLabel_1);

        cbShow = new JComboBox();
        cbShow.setBounds(30, 10, 220, 21);
        cbShow.setModel(new DefaultComboBoxModel(new String[] { "Sắp xếp theo ngày", "Sắp xếp theo doanh thu tăng dần", "Sắp xếp theo doanh thu giảm dần" }));
        panel.add(cbShow);

        JLabel lblNewLabel_2 = new JLabel("Từ");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(260, 14, 45, 13);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Đến");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(430, 14, 45, 13);
        panel.add(lblNewLabel_3);

        showBtn = new JButton("Xem");
//        showBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                System.out.println("ấn");
//               
//            }
//        });
        showBtn.setBounds(600, 10, 85, 21);
        panel.add(showBtn);

        dcFrom = new JDateChooser();
        dcFrom.setBounds(280, 12, 123, 19);
        panel.add(dcFrom);
        dcFrom.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    Date selectedDate = (Date) e.getNewValue();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    dayFrom = dateFormat.format(selectedDate);
//                    System.out.println("Ngày được chọn: " + formattedDate);
                }
            }
        });

        dcTo = new JDateChooser();
        dcTo.setBounds(460, 12, 123, 19);
        panel.add(dcTo);
        dcTo.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                // Kiểm tra nếu sự kiện là về việc thay đổi ngày
                if ("date".equals(e.getPropertyName())) {
                    Date selectedDate = (Date) e.getNewValue();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    dayTo = dateFormat.format(selectedDate);
//                    System.out.println("Ngày được chọn: " + formattedDate);
                }
            }
        });

        JLabel lblNewLabel_4 = new JLabel("Quản lý doanh thu");
        lblNewLabel_4.setBounds(30, 53, 201, 21);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(lblNewLabel_4);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(30, 82, 1200, 580);
        panel.add(panel_3);

        tableModel1 = new DefaultTableModel();
        tableModel1.setColumnIdentifiers(new String[] {"Ngày", "Tổng thu", "Số lượng hóa đơn", "Trung bình 1 bàn"});

        table = new JTable(tableModel1);
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel_3.setLayout(new BorderLayout());
        panel_3.add(scrollPane);
        setVisible(true);
        connectdb dbConnect = new connectdb();
        controller = new ChartController(dsmodel,model,this,dbConnect);
    }

    public void addDrawButtonListener(ActionListener log) {
        btnNewButton.addActionListener(log);
    }
//    public void XemListListener(ActionListener log) {
//        showBtn.addActionListener(log);
//    }
    public void addShowButtonListener(ActionListener listenForShowButton) {
        showBtn.addActionListener(listenForShowButton);
    }

    public void displayChart(ChartPanel chartPanel) {
        panel_2.removeAll();
        panel_2.add(chartPanel, BorderLayout.CENTER);
        panel_2.validate();
    }

    public void setComboBoxYears(ArrayList<String> years) {
        comboBox.setModel(new DefaultComboBoxModel<>(years.toArray(new String[0])));
    }

    public void updateComboBox(List<String> years) {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(years.toArray(new String[0]));
        comboBox.setModel(comboBoxModel);
    }

    public String getSelectedYear() {
        return (String) comboBox.getSelectedItem();
    }
    public DanhSachModel getDs() {
    	String xemtheo=(String)cbShow.getSelectedItem();
    	String dayfrom=dayFrom;
    	String dayto=dayTo;
    	DanhSachModel dsmodel= new DanhSachModel(xemtheo,dayfrom,dayto);
        return dsmodel;
        
    }
    public void updateTableInfo(String ngay, float tongthu, int slhoadon, float tb1ban) {
        tableModel1.addRow(new Object[]{ngay, tongthu, slhoadon, tb1ban});
    }
    public void clearTable() {
        tableModel1.setRowCount(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
	
}
