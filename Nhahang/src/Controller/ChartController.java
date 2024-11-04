package Controller;

import DoanhThu.Dtmodel;
import DoanhThuNgay.Dtngaymodel;
import HoaDon.Hoadonmodel;
import HoaDon.DoanhThuModel;
import Model.ChartModel;
import Model.DanhSachModel;

import View.ChartView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartController implements ActionListener{
    private connectdb dbConnect;
    private ChartView view;
    private ChartModel model;
    private DanhSachModel dsmodel;
    List<DoanhThuModel> doanhThuList = new ArrayList<>();
    List<Hoadonmodel> arr;
    List<Dtmodel> arrdt;
    List<Dtngaymodel> arrdtn;

    public ChartController(DanhSachModel dsmodel,ChartModel model, ChartView view,connectdb dbConnect) {
        this.dsmodel=dsmodel;
        this.model = model;
        this.view = view;
        this.dbConnect = dbConnect;
        
        view.addDrawButtonListener(new DrawButtonListener());
        view.addShowButtonListener(new ShowButtonListener());
        updateComboBox(); // Update JComboBox when the controller is initialized
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    class DrawButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selectedYear = view.getSelectedYear();
            DefaultCategoryDataset dataset = fetchData(selectedYear);
            
//            System.out.println("Chọn năm đã ấn");
            displayChart(dataset);
        }
    }

    class ShowButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
//			System.out.println("Controller đã gọi được nút showBtn.");
                view.clearTable();
                handleShowList();

        }
    	
    }
    
    private void handleShowList() {
		dsmodel = view.getDs();
		String xemtheo = dsmodel.xemTheo;
		String dayfrom = dsmodel.dayFrom;
		String dayto = dsmodel.dayTo;
		
		if (xemtheo.equals("Sắp xếp theo ngày")) {
			
		    if (dayfrom == null && dayto == null) {
		        getAllDoanhThuNgay();
		    } else if (dayfrom == null || dayto == null) {
		        // Nếu chỉ một trong hai ngày bị rỗng
		        JOptionPane.showMessageDialog(null, "Vui lòng chọn đủ thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
		    } else {
		        // Nếu cả hai ngày đều không rỗng
		    	String[] partsfrom = dayfrom.split("/");
		        String day_from = partsfrom[0];
		        String month_from = partsfrom[1];
		        String year_from = partsfrom[2];
		        
		        String[] partsto = dayto.split("/");
		        String day_to = partsto[0];
		        String month_to = partsto[1];
		        String year_to = partsto[2];
                        List<DoanhThuModel> arrdtn = new ArrayList<>();
                        arrdtn = getIdhoadonsTheoNgay_1(day_from, month_from, year_from, day_to, month_to, year_to);
                        for(DoanhThuModel dtn : arrdtn){
                            view.updateTableInfo(dtn.getNgay(), dtn.getTongThu(), dtn.getSoLuongHoaDon(), dtn.getTrungBinhMoiBan());
                        }
                        
//		        getIdhoadonsTheoNgay(day_from, month_from, year_from, day_to, month_to, year_to);
		        
		    }
		}else if(xemtheo.equals("Sắp xếp theo doanh thu tăng dần")) {
			if (dayfrom == null && dayto == null) {
		        getAllDoanhThuNgayTang();
		    } else if (dayfrom == null || dayto == null) {
		        // Nếu chỉ một trong hai ngày bị rỗng
		        JOptionPane.showMessageDialog(null, "Vui lòng chọn đủ thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
		    } else {
		        // Nếu cả hai ngày đều không rỗng
		    	String[] partsfrom = dayfrom.split("/");
		        String day_from = partsfrom[0];
		        String month_from = partsfrom[1];
		        String year_from = partsfrom[2];
		        
		        String[] partsto = dayto.split("/");
		        String day_to = partsto[0];
		        String month_to = partsto[1];
		        String year_to = partsto[2];
		        List<DoanhThuModel> arrdtn = new ArrayList<>();
                        arrdtn = getIdhoadonsTheoNgayTang(day_from, month_from, year_from, day_to, month_to, year_to);
                        for(DoanhThuModel dtn : arrdtn){
                            view.updateTableInfo(dtn.getNgay(), dtn.getTongThu(), dtn.getSoLuongHoaDon(), dtn.getTrungBinhMoiBan());
                        }
		        
		    }
		}
	}
	public void getAllDoanhThuNgayTang() {
            getAllDoanhThuNgayTang_1();

            // Cập nhật dữ liệu lên bảng
            for (DoanhThuModel doanhThu : doanhThuList) {
                view.updateTableInfo(doanhThu.getNgay(), doanhThu.getTongThu(), doanhThu.getSoLuongHoaDon(), doanhThu.getTrungBinhMoiBan());
            }
        
    }


	public void getAllDoanhThuNgay() {
            getAllDoanhThuNgay_1();
             for (DoanhThuModel doanhThu : doanhThuList) {
                view.updateTableInfo(doanhThu.getNgay(), doanhThu.getTongThu(), doanhThu.getSoLuongHoaDon(), doanhThu.getTrungBinhMoiBan());
            }
//		            view.updateTableInfo(ngay,tongthu,soLuong,tb1ban);
		        }

//	private void getIdhoadonsTheoNgay(String dayfrom, String monthfrom, String yearfrom, String dayto, String monthto, String yearto) {
//	    // Chuỗi truy vấn SQL để đếm số lượng idhoadon theo từng ngày trong khoảng thời gian và trạng thái đã chỉ định
//                    getIdhoadonsTheoNgay_1(dayfrom, monthfrom, yearfrom, dayto, monthto, yearto);
//                     for (DoanhThuModel doanhThu : doanhThuList) {
//                        view.updateTableInfo(doanhThu.getNgay(), doanhThu.getTongThu(), doanhThu.getSoLuongHoaDon(), doanhThu.getTrungBinhMoiBan());
//            }
////	            view.updateTableInfo(ngay,tongthu,soLuong,tb1ban);
//	        }
	   
	
	public void getTongThuCuaNgay(int day, int month, int year) {
	           getTongThuCuaNgay_1(day, month, year);
                   
	}
        List<Dtmodel> arrdtt;
	private DefaultCategoryDataset fetchData(String year) {
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    arrdtt = new ArrayList<>();
            arrdtt = fetchData_1(year);
            
            for(Dtmodel dt: arrdtt){
                int tien = dt.getTien();
                int thang = dt.getThang();
                dataset.addValue(tien, "money", "Tháng " + thang);
                System.out.println(tien);
            }        
            
	    return dataset;
	}


    // Display chart in the view
    private void displayChart(DefaultCategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createAreaChart("Doanh thu các tháng", "Tháng", "Tiền", dataset, PlotOrientation.VERTICAL, true, true, true);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.blue);
        ChartPanel barpanel = new ChartPanel(barChart);
        view.displayChart(barpanel);
    }

    private void updateComboBox() {
        List<String> years = new ArrayList<>();
        years = updateComboBox_1();

        view.updateComboBox(years);
    }

    private static float getTongThuCuaNgay_1(int day, int month, int year) {
        DoanhThuNgay.DtngayWs_Service service = new DoanhThuNgay.DtngayWs_Service();
        DoanhThuNgay.DtngayWs port = service.getDtngayWsPort();
        return port.getTongThuCuaNgay(day, month, year);
    }

    

    

    private static java.util.List<HoaDon.DoanhThuModel> getAllDoanhThuNgay_1() {
        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
        HoaDon.HoadonWs port = service.getHoadonWsPort();
        return port.getAllDoanhThuNgay();
    }

    private static java.util.List<HoaDon.DoanhThuModel> getAllDoanhThuNgayTang_1() {
        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
        HoaDon.HoadonWs port = service.getHoadonWsPort();
        return port.getAllDoanhThuNgayTang();
    }

    private static java.util.List<HoaDon.DoanhThuModel> getIdhoadonsTheoNgay_1(java.lang.String dayfrom, java.lang.String monthfrom, java.lang.String yearfrom, java.lang.String dayto, java.lang.String monthto, java.lang.String yearto) {
        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
        HoaDon.HoadonWs port = service.getHoadonWsPort();
        return port.getIdhoadonsTheoNgay(dayfrom, monthfrom, yearfrom, dayto, monthto, yearto);
    }

    private static java.util.List<HoaDon.DoanhThuModel> getIdhoadonsTheoNgayTang(java.lang.String dayfrom, java.lang.String monthfrom, java.lang.String yearfrom, java.lang.String dayto, java.lang.String monthto, java.lang.String yearto) {
        HoaDon.HoadonWs_Service service = new HoaDon.HoadonWs_Service();
        HoaDon.HoadonWs port = service.getHoadonWsPort();
        return port.getIdhoadonsTheoNgayTang(dayfrom, monthfrom, yearfrom, dayto, monthto, yearto);
    }

    private static java.util.List<java.lang.String> updateComboBox_1() {
        DoanhThu.DtWs_Service service = new DoanhThu.DtWs_Service();
        DoanhThu.DtWs port = service.getDtWsPort();
        return port.updateComboBox();
    }

    private static java.util.List<DoanhThu.Dtmodel> fetchData_1(java.lang.String year) {
        DoanhThu.DtWs_Service service = new DoanhThu.DtWs_Service();
        DoanhThu.DtWs port = service.getDtWsPort();
        return port.fetchData(year);
    }
    

    
}
