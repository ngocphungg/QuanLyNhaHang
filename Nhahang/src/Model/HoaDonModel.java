package Model;


import java.util.ArrayList;

	public class HoaDonModel {
	    public int idHoaDon;
	    public String tenBan;
	    public String khuVuc;
//	    private String gioDen;
//	    private String gioVe;
//	    private float tongTien;
	    public String trangThai; // Thêm cột trạng thái
//	    public ArrayList<ChiTietHDModel> chiTietHoaDonList;

	    // Constructor và các phương thức Getter và Setter

	    public HoaDonModel() {
//	        chiTietHoaDonList = new ArrayList<>();
	    }

	    public HoaDonModel(String tenBan, String khuVuc) {
			super();
			this.tenBan = tenBan;
			this.khuVuc = khuVuc;
		}

	    public int getIdHoaDon() {
	        return idHoaDon;
	    }

	    public void setIdHoaDon(int idHoaDon) {
	        this.idHoaDon = idHoaDon;
	    }
//
	    public String getTenBan() {
	        return tenBan;
	    }

	    public void setTenBan(String tenBan) {
	        this.tenBan = tenBan;
	    }

	    public String getKhuVuc() {
	        return khuVuc;
	    }

	    public void setKhuVuc(String khuVuc) {
	        this.khuVuc = khuVuc;
	    }
//
//	    public String getGioDen() {
//	        return gioDen;
//	    }
//
//	    public void setGioDen(String gioDen) {
//	        this.gioDen = gioDen;
//	    }
//
//	    public String getGioVe() {
//	        return gioVe;
//	    }
//
//	    public void setGioVe(String gioVe) {
//	        this.gioVe = gioVe;
//	    }
//	    void updateTongTien(float newThanhTien) {
//	        tongTien += newThanhTien;
//	    }
//
//	    public void subtractTongTien(float oldThanhTien) {
//	        tongTien -= oldThanhTien;
//	    }
//
//	    public float getTongTien() {
//	        return tongTien;
//	    }
//
	    public String getTrangThai() {
	        return trangThai;
	    }

	    public void setTrangThai() {
	        this.trangThai = "chưa thanh toán";
	    }

//	    public ArrayList<ChiTietHDModel> getChiTietHoaDonList() {
//	        return chiTietHoaDonList;
//	    }
//
//	    public void setChiTietHoaDonList(ArrayList<ChiTietHDModel> chiTietHoaDonList) {
//	        this.chiTietHoaDonList = chiTietHoaDonList;
//	    }
//
//	    // Phương thức để thêm một chi tiết hóa đơn vào danh sách
//	    public void addChiTietHoaDon(ChiTietHDModel chiTietHoaDon) {
//	        this.chiTietHoaDonList.add(chiTietHoaDon);
//	    }
//
//	    // Phương thức để xoá một chi tiết hóa đơn khỏi danh sách
//	    public void removeChiTietHoaDon(ChiTietHDModel chiTietHoaDon) {
//	        this.chiTietHoaDonList.remove(chiTietHoaDon);
//	    }
	}


