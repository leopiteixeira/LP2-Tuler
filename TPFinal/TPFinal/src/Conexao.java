package TPFinal.TPFinal.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
    
    public Connection conectaDB(){
        Connection conn = null;

        String driverName = "com.mysql.cj.jdbc.Driver";                  
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            String url = "jdbc:mysql://localhost/JavaFinal?user=root&password=Tomcat.1";
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexao: " + e.getMessage());
        }
        return conn;
    }
}
