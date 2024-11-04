package Model;


public class DanhSachModel {
		public String xemTheo;
		public String dayFrom;
		public String dayTo;
//		public DanhSachModel() {
//			
//		}
		public DanhSachModel(String xemTheo,String dayFrom,String dayTo) {
			this.xemTheo=xemTheo;
			this.dayFrom=dayFrom;
			this.dayTo=dayTo;
		}
		public String getXemTheo() {
			return xemTheo;
		}
		public void setXemTheo(String xemTheo) {
			this.xemTheo = xemTheo;
		}
		public String getDayFrom() {
			return dayFrom;
		}
		public void setDayFrom(String dayFrom) {
			this.dayFrom = dayFrom;
		}
		public String getDayTo() {
			return dayTo;
		}
		public void setDayTo(String dayTo) {
			this.dayTo = dayTo;
		}
	
		
}
