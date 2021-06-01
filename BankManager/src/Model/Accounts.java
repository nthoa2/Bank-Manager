package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Accounts {


    public static ResultSet getSpendingPerMonth(String startDate, String endDate) {
        String query = "";
        return connection.getData(query);
    }

    public static ResultSet getReceivedPerMonth(String startDate, String endDate) {
        String query = "";
        return connection.getData(query);
    }

    public static ResultSet getSpendingPerDay(String date) {
        String query = "";
        return connection.getData(query);
    }

    public static ResultSet getUserReceivedPerDay(String date) {
        String query = "";
        return connection.getData(query);

    }

    public static void updateAccountBalance(String accountNumber, String TransactionType, double amount) {
        if (TransactionType.equals("Chuyển Khoản") || TransactionType.equals("Nạp Tiền")){
            amount *= -1.0;
        }
        String query = "UPDATE dbo.[TAIKHOAN] SET [SoDu] = [SoDu] + " + amount + " WHERE SoTK = '" + accountNumber + "'";
        connection.executeQuery(query);
    }

    public void addAccount(){

    }

    public void editPassword(){
        
    }
}
