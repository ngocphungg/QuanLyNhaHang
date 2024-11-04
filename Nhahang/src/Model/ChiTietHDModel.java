package Model;

public class ChiTietHDModel {
	private int idHoaDon;
    public String tenMon;
    public String loaiMon;
    public int soLuong;
//    private float thanhTien;

    // Constructor và các phương thức Getter và Setter

    public ChiTietHDModel(String tenMon,String loaiMon,int soLuong) {
    	this.tenMon=tenMon;
    	this.loaiMon=loaiMon;
    	this.soLuong=soLuong;
    }
    

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getLoaiMon() {
        return loaiMon;
    }

    
    public void setLoaiMon(String loaiMon) {
        this.loaiMon = loaiMon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
    	this.soLuong=soLuong;
    }

//	public float getThanhTien() {
//		return thanhTien;
//	}
//
//	public void setThanhTien(float thanhTien) {
//		this.thanhTien = thanhTien;
//	}
}
