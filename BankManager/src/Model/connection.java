package Model;

import java.sql.*;

public class connection {
    private static Connection connect;

    public connection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectString = "jdbc:sqlserver://localhost:1433;databaseName=BankManager;user=sa;password=admin";
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
}
