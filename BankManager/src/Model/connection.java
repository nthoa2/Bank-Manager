package Model;

import java.sql.*;

public class connection {
    public static Connection connect;

    public connection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectString = "jdbc:sqlserver://localhost:1433;databaseName=QLNH;user=sa;password=123";
            connect = DriverManager.getConnection(connectString);
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
            System.out.println("ExecuteQuery fail");
            return -1;
        }
    }
}
