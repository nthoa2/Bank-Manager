package Model;

import java.sql.ResultSet;

public class Login {

    public static ResultSet getLoginAccountByUserName(String userName) {
        String query = "SELECT * FROM dbo.[loginAccount] WHERE dbo.[loginAccount].loginName = '" + userName + "'";
        return connection.getData(query);
    }

    public static ResultSet getLoginAccounts() {
        String query = "SELECT * FROM dbo.[loginAccount]";
        return connection.getData(query);
    }

    public static void insertNewLoginAccount(String userName, String password, String accountNumber) {
        String query = "INSERT INTO dbo.[loginAccount](loginName,loginPassword,SoTK)" +
                "VALUES('" + userName + "','" + password + "','" + accountNumber + "')";
        connection.executeQuery(query);
    }


}
