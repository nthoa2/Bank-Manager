package Model;

import java.sql.ResultSet;

public class Login {

    public static ResultSet getLoginAccountByUserName(String userName) {
        String query = "SELECT * FROM dbo.[loginAccount] WHERE dbo.[loginAccount].loginName = '" + userName + "'";
        return connection.getData(query);
    }

    public static ResultSet getLoginAccounts() {
        String query = "SELECT * FROM dbo.[loginAccount] WHERE dbo.[loginAccount]";
        return connection.getData(query);
    }
}
