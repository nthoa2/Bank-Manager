package Model;

import java.sql.*;

public class connection {
    public static Connection connect;

    public connection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectString = "jdbc:sqlserver://localhost:1433;databaseName=QLNH;user=sa;password=123";
            connect = DriverManager.getConnection(connectString);
            System.out.println("Ket Noi Thanh Cong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet getData(String query) {
        try {
            Statement statement = connect.createStatement();
            return statement.executeQuery(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public static int executeQuery(String query) {
        try {
            Statement statement = connect.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException ex) {
<<<<<<< HEAD:Projects/BankManager/src/Model/connection.java
            System.out.println("ExecuteQuery fail");
=======
            System.err.println(ex.getMessage());
>>>>>>> Long:BankManager/src/Model/connection.java
            return -1;
        }
    }
}
