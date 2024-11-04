package Model;

public class ChuyenBanModel {
//	private String bancu;
//	private String khuvuccu;
	public String banmoi;
	public String khuvucmoi;//	private String bancu;
//	private String khuvuccu;;
	
	public ChuyenBanModel( String banmoi, String khuvucmoi) {
		super();
//		this.bancu = bancu;
//		this.khuvuccu = khuvuccu;
		this.banmoi = banmoi;
		this.khuvucmoi = khuvucmoi;
	}
//	public String getBancu() {
//		return bancu;
//	}
//	public void setBancu(String bancu) {
//		this.bancu = bancu;
//	}
//	public String getKhuvuccu() {
//		return khuvuccu;
//	}
//	public void setKhuvuccu(String khuvuccu) {
//		this.khuvuccu = khuvuccu;
//	}
	public String getBanmoi() {
		return banmoi;
	}
	public void setBanmoi(String banmoi) {
		this.banmoi = banmoi;
	}
	public String getKhuvucmoi() {
		return khuvucmoi;
	}
	public void setKhuvucmoi(String khuvucmoi) {
		this.khuvucmoi = khuvucmoi;
	}
}
