package Controller;


import Model.ChuyenBanModel;
import Model.HoaDonModel;
import View.HomeView;
import View.ChuyenBanView;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChuyenBanControl {
    private ChuyenBanModel cbmodel;
    private HoaDonModel hdmodel;
    private ChuyenBanView cbview;
    public HomeView view;
    private connectdb dbConnect;

    public ChuyenBanControl(ChuyenBanModel cbmodel, HoaDonModel hdmodel, ChuyenBanView cbview, HomeView view, connectdb dbConnect) {
        this.cbmodel = cbmodel;
        this.hdmodel = hdmodel;
        this.cbview = cbview; // Gán cbview từ tham số truyền vào
        this.view = view;
        this.dbConnect = dbConnect;

        // Không cần khởi tạo cbview ở đây vì đã được truyền vào từ bên ngoài

//        cbview.confirmButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                handleChangeTableAction();
//            }
//        });
    }
    public void handleChangeTableAction(String banCu,String khuVucCu,String banMoi,String khuVucMoi) {
//		hdmodel=view.getHoaDon();
//		String banCu=hdmodel.tenBan;
//		String khuVucCu=hdmodel.khuVuc;
//		cbmodel=cbview.getChuyenBan();
//		String banMoi=cbmodel.getBanmoi();
//		String khuVucMoi=cbmodel.getKhuvucmoi();
//		String banCu= cbmodel.getBancu();
//		String khuVucCu=cbmodel.getKhuvuccu();
//		String banMoi=cbmodel.getBanmoi();
//		String khuVucMoi=cbmodel.getKhuvucmoi();
//		String banMoi=(String) cbview.cbBan.getSelectedItem();
//		String khuVucMoi=(String) cbview.cbKhuVuc.getSelectedItem();
//		System.out.println(banMoi+khuVucMoi);
		 if (banCu.equals(banMoi) && khuVucCu.equals(khuVucMoi)) {
		        cbview.displayMessage("Bạn đang ở " + banCu + " - " + khuVucCu + " không thể chuyển");
		    } else {
		        int idhoadon = getUnpaidHoadonID(banCu, khuVucCu);
		        int idhoadonden = getUnpaidHoadonID(banMoi, khuVucMoi);
		        if (idhoadonden != -1) {
		            cbview.displayMessage("Bàn đã có hóa đơn khác!");
		        } else {
		            updateTableNameAndZone(idhoadon, banMoi, khuVucMoi);
		            cbview.displayMessage("Chuyển bàn thành công sang "+banMoi+" "+khuVucMoi);
//		            getTableInfoFromHoadon(banMoi,khuVucMoi);
		        }
		    }
	}
	private int getUnpaidHoadonID(String tenban, String khuVuc) {
        int idhoadon = -1;

        String query = "SELECT idhd FROM hoadon WHERE tenban = ? AND khuvuc = ? AND trangthai = 'chưa thanh toán'";
        try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
            stmt.setString(1, tenban);
            stmt.setString(2, khuVuc);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idhoadon = rs.getInt("idhd");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idhoadon;
    }     
	private void updateTableNameAndZone(int idhoadon,String tenban,String khuvuc) {
		String query = "UPDATE hoadon SET tenban = ?, khuvuc = ? WHERE idhd =? ";
		try (PreparedStatement stmt = dbConnect.getConnection().prepareStatement(query)) {
            stmt.setString(1, tenban);
            stmt.setString(2, khuvuc); 
            stmt.setInt(3, idhoadon);
            stmt.executeUpdate();

		}catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	
}