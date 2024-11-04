package Controller;

import ThucDon.Tdmodel;
import ThucDon.Theloaimodel;
import View.QLyThucDonView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QLyThucDonCtrl implements ActionListener{
//    private ThucDonModel m;
    private QLyThucDonView v;
    private connectdb db;
    JFrame j;
    Connection connection = null;
    PreparedStatement statement = null;
    PreparedStatement stm = null;
    List<Tdmodel> arr;
    List<Theloaimodel> arrtl;

    public QLyThucDonCtrl( QLyThucDonView v, connectdb db) {
//        this.m = m;
        this.v = v;
        this.db = db;
        
        JTable table=v.getTable();
        load();
        loadCategories();
//        loadDataFromDatabase();
        v.cbb_loai.addActionListener(this);
        // Load danh sách thể loại vào combobox
        
        v.themListener(new add_td_listener());
        v.xoaListener(new delete_td_listener());
        v.luuListener(new edit_td_listener());
        
        
    }
    public void load() {
        arr = getThucdon();
        int i = 0;
        v.model.setRowCount(0);
        for (Tdmodel c : arr) {
            i++;
            v.model.addRow(new Object[]{c.getMamon(),c.getLoai(),c.getTenmon(),c.getGiathanh()});
        }
    }
    private void loadCategories() {
        arrtl = getTheloai();
        String selectedCategory = (String) v.cbb_loai.getSelectedItem();
        v.cbb_loai.removeAllItems();
        for (Theloaimodel category : arrtl) {
            v.cbb_loai.addItem(category.getTheloai()); // Thêm các mục mới vào thanh chọn
        }

        // Sau khi cập nhật, chọn lại thể loại trước đó nếu có
        if (selectedCategory != null && arrtl.contains(selectedCategory)) {
            v.cbb_loai.setSelectedItem(selectedCategory);
        }// Cập nhật thanh chọn loại trên giao diện
    }
    
//    public boolean checkmon(){
//        m = v.get_td();
//        String id = m.idmon;
//        String name = m.tenmon;
//        String loai = m.theloai;
//        double gia = m.dongia;
//        try {
//            connection = connectdb.getConnection();
//            if (connection != null) {
//                String check="Select idmon, tenmon from thucdon where idmon =? or tenmon=?";
//                statement=connection.prepareStatement(check);
//                statement.setString(1,id);
//                statement.setString(2,name);
//                ResultSet rs = statement.executeQuery();
//                if(rs.next()){
////                    JOptionPane.showMessageDialog(null, "Đã tồn tại trong thực đơn\n Đặt lại Mã món hoặc Tên món","Thông báo",JOptionPane.WARNING_MESSAGE);
//                    return true;
//                }
//            }     
//        }catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
//    Thêm 1 món ăn - done
    class add_td_listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String loai = String.valueOf(v.cbb_loai.getSelectedItem());
            String newloai = v.txt_theloai.getText();
            if(newloai.isEmpty()){
                getThemtd(v.txt_mamon.getText(), v.txt_tenmon.getText(), loai, Float.parseFloat(v.txt_gia.getText()));
                v.txt_mamon.setText("");
                v.txt_tenmon.setText("");
                v.txt_theloai.setText("");
                v.txt_gia.setText("");
                load();
                JOptionPane.showMessageDialog(null,"Thêm món thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }else{
                getThemtd(v.txt_mamon.getText(), v.txt_tenmon.getText(), newloai, Float.parseFloat(v.txt_gia.getText()));
                v.txt_mamon.setText("");
                v.txt_tenmon.setText("");
                v.txt_theloai.setText("");
                v.txt_gia.setText("");
                load();
                JOptionPane.showMessageDialog(null,"Thêm món thành công\nĐã thêm mới thể loại:"+newloai+"","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }
//    Sửa thông tin món ăn
    class edit_td_listener implements ActionListener{   
        int selectedRow = v.getTable().getSelectedRow();
        @Override
        public void actionPerformed(ActionEvent e) {
            String loai = String.valueOf(v.cbb_loai.getSelectedItem());
            getUpdatetd(v.txt_mamon.getText(), v.txt_tenmon.getText(), loai, Float.parseFloat(v.txt_gia.getText()));
            v.txt_mamon.setText("");
            v.txt_tenmon.setText("");
            v.txt_theloai.setText("");
            v.txt_gia.setText("");
            load();
            JOptionPane.showMessageDialog(null,"Sửa thông tin món thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
        }
    }
//    xóa 1 món ăn - done
    class delete_td_listener implements ActionListener{
        private JTable table;
        @Override
        public void actionPerformed(ActionEvent e) {
            this.table=v.getTable();
            int selectedRow=table.getSelectedRow();//chon 1 dong 
            if(selectedRow!=-1){
                String id=table.getValueAt(selectedRow, 0).toString();
                String theloai=table.getValueAt(selectedRow, 1).toString();
                String tenmon=table.getValueAt(selectedRow, 2).toString();
                String gia=table.getValueAt(selectedRow, 3).toString();
                int confirmed = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa món ?", "Xác nhận xóa bàn", JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    getDeletetd(id);//xoa du lieu tu csdl
                    JOptionPane.showMessageDialog(null,"Xóa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    v.txt_mamon.setText("");
                    v.txt_gia.setText("");
                    v.txt_tenmon.setText("");                
                    ((DefaultTableModel)table.getModel()).removeRow(selectedRow);//xoa dong duoc chon trong bang
                }
            }
        }
    }

    private static java.util.List<ThucDon.Tdmodel> findtd(java.lang.String a) {
        ThucDon.TdWs_Service service = new ThucDon.TdWs_Service();
        ThucDon.TdWs port = service.getTdWsPort();
        return port.findtd(a);
    }

    private static void getDeletetd(java.lang.String a) {
        ThucDon.TdWs_Service service = new ThucDon.TdWs_Service();
        ThucDon.TdWs port = service.getTdWsPort();
        port.getDeletetd(a);
    }

    private static void getThemtd(java.lang.String a, java.lang.String b, java.lang.String c, float d) {
        ThucDon.TdWs_Service service = new ThucDon.TdWs_Service();
        ThucDon.TdWs port = service.getTdWsPort();
        port.getThemtd(a, b, c, d);
    }

    private static java.util.List<ThucDon.Tdmodel> getThucdon() {
        ThucDon.TdWs_Service service = new ThucDon.TdWs_Service();
        ThucDon.TdWs port = service.getTdWsPort();
        return port.getThucdon();
    }


    private static java.util.List<ThucDon.Theloaimodel> getTheloai() {
        ThucDon.TdWs_Service service = new ThucDon.TdWs_Service();
        ThucDon.TdWs port = service.getTdWsPort();
        return port.getTheloai();
    }

    private static void getUpdatetd(java.lang.String a, java.lang.String b, java.lang.String c, float d) {
        ThucDon.TdWs_Service service = new ThucDon.TdWs_Service();
        ThucDon.TdWs port = service.getTdWsPort();
        port.getUpdatetd(a, b, c, d);
    }
    
    
}
    

