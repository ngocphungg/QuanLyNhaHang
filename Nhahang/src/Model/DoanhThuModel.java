package Model;

public class DoanhThuModel {
    private String ngay;
    private float tongThu;
    private int soLuongHoaDon;
    private float trungBinhMoiBan;

    // Constructor
    public DoanhThuModel(String ngay, float tongThu, int soLuongHoaDon, float trungBinhMoiBan) {
        this.ngay = ngay;
        this.tongThu = tongThu;
        this.soLuongHoaDon = soLuongHoaDon;
        this.trungBinhMoiBan = trungBinhMoiBan;
    }

    // Getter và setter
    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public float getTongThu() {
        return tongThu;
    }

    public void setTongThu(float tongThu) {
        this.tongThu = tongThu;
    }

    public int getSoLuongHoaDon() {
        return soLuongHoaDon;
    }

    public void setSoLuongHoaDon(int soLuongHoaDon) {
        this.soLuongHoaDon = soLuongHoaDon;
    }

    public float getTrungBinhMoiBan() {
        return trungBinhMoiBan;
    }

    public void setTrungBinhMoiBan(float trungBinhMoiBan) {
        this.trungBinhMoiBan = trungBinhMoiBan;
    }
}
