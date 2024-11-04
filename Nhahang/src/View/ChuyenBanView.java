package View;

import Controller.ChuyenBanControl;
import Controller.connectdb;
import Model.ChuyenBanModel;
import Model.HoaDonModel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChuyenBanView extends JFrame{
	private HomeView view;
	private HoaDonModel hdmodel;
	private ChuyenBanControl cbctr;
	private ChuyenBanModel cbmodel;
	public JComboBox<String> cbKhuVuc;
    public JComboBox<String> cbBan;
    private String a;
    private String b;
    private String khuVucmoi;
    private String banMoi;
    public JButton confirmButton;
    public	JButton cancelButton;
    

    public ChuyenBanView(JFrame parent, String khuVuc, String ban) {
//    	view=new HomeView();
    	hdmodel=new HoaDonModel();
    	connectdb dbConnect = new connectdb();
    	cbctr = new ChuyenBanControl(cbmodel, hdmodel, this, view, dbConnect);

        // Tạo combobox cho khu vực
        String[] khuvuc = {"Ngoài trời", "Tầng 1", "Tầng 2"};
        String[] banchon = new String[15];
        for (int i = 0; i < 15; i++) {
            banchon[i] = "Bàn " + (i + 1);
        }

        cbKhuVuc = new JComboBox<>(khuvuc);
        cbBan = new JComboBox<>(banchon);
        a=khuVuc;
        b=ban;
        
//        System.out.println(a+b);
//        System.out.println((String)cbKhuVuc.getSelectedItem() + (String)cbBan.getSelectedItem());
        

        // Tạo panel chứa combobox và nút
        setBounds(100, 100, 300, 190);
        setResizable(false);
        setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chọn bàn để chuyển");
		lblNewLabel.setBounds(94, 10, 141, 13);
		contentPane.add(lblNewLabel);
		
		cbKhuVuc.setBounds(102, 33, 159, 21);
		contentPane.add(cbKhuVuc);
		
		cbBan.setBounds(102, 64, 159, 21);
		contentPane.add(cbBan);
		
		confirmButton = new JButton("Xác nhận");
		confirmButton.setBounds(24, 106, 103, 37);
		contentPane.add(confirmButton);
		
		cancelButton = new JButton("Thoát");
		cancelButton.setBounds(150, 106, 103, 37);
		contentPane.add(cancelButton);
		
		JLabel lblkhuvuc = new JLabel("Chọn khu vực");
		lblkhuvuc.setBounds(10, 35, 82, 17);
		contentPane.add(lblkhuvuc);
		
		JLabel lblban = new JLabel("Chọn bàn");
		lblban.setBounds(10, 66, 69, 17);
		contentPane.add(lblban);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(b+a+(String)cbBan.getSelectedItem()+(String)cbKhuVuc.getSelectedItem());
            	if((String)cbKhuVuc.getSelectedItem()==a&&(String)cbBan.getSelectedItem()==b) {
            	displayMessage("Không thể chuyển bàn");
            	}
            	cbctr.handleChangeTableAction(b,a,(String)cbBan.getSelectedItem(),(String)cbKhuVuc.getSelectedItem());
            	dispose();
            	}
            
            });
        

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public ChuyenBanModel getChuyenBan() {
//    	String bancu=b;
//    	String khuvuccu=a;
    	String banmoi=(String)cbBan.getSelectedItem();
    	String khuvucmoi=(String)cbKhuVuc.getSelectedItem();
    	ChuyenBanModel cbmodel=new ChuyenBanModel(banmoi, khuvucmoi);
    	return cbmodel;
    }
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
//   
}
