
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connectdb {
    public static Connection getConnection(){
        String url="jdbc:mysql://localhost:3306/qlnh";
        String user ="root";
        String password = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                return DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(connectdb.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(connectdb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
