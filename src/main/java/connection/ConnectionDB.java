package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    //hieu
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Student?useSSL=false",
                    "root",
                    "admin"
            );
            System.out.println("ket noi thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ket noi khong thanh cong");
        }
        return connection;
    }
}