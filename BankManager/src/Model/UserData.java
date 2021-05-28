package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserData {

    public static ResultSet getUserBalance(String userId) { // chua confirm data type nen de tam
        String query = "";
        return connection.getData(query);
    }

    public static ResultSet getUsersSpendingPerMonth(String userID) {
        String query = "";
        return connection.getData(query);
    }

    public static ResultSet getUserReceivedPerMonth(String userID) {
        String query = "";
        return connection.getData(query);
    }

    public static double getUsersSpendingPerDay(int day, int month, int year) {
        String query = "";
        ResultSet results = connection.getData(query);
        try {
            assert results != null;
            if (results.next()) {
                return results.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println("get spending per month fail");
        }
        return 0.0;
    }
    public static double getUserReceivedPerMonth(int day, int month, int year) {
        String query = "";
        ResultSet results = connection.getData(query);
        try {
            assert results != null;
            if (results.next()) {
                return results.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println("get received per month fail");
        }
        return 0.0;
    }

    public static void addUser(){
        String query = "";
        connection.executeQuery(query);
    }
}