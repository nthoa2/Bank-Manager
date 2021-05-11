package Model;

import java.sql.*;

public class connection {
    private static final String DatabaseURL = "jdbc:sqlserver://localhost:1433;databaseName=BankManager;";
    private static final String USER_NAME = "sa";
    private static final String PASSWORD = "admin";
    public static java.sql.Connection conn = null;

    static PreparedStatement preparedStatement(String strQuery) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public connection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DatabaseURL, USER_NAME, PASSWORD);
            System.out.println("connect successfully");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public static ResultSet getData(String query) {
        try {
            Statement statement = conn.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
            return null;
        }
    }

    public static int ExecutedQuery(String query) {
        try {
            Statement stm = conn.createStatement();
            return stm.executeUpdate(query);
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
            return -1;
        }
    }
}
