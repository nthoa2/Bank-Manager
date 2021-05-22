package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserData {

    public static ResultSet getUserBalance(String userId){ // chua confirm data type nen de tam
        String query = "";
        return connection.getData(query);
    }

    public static ResultSet getUsersSpendingPerMonth(String userID){
        String query = "";
        return connection.getData(query);
    }
}
