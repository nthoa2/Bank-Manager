package Model;

import java.sql.*;

public class Database {
    private  Connection connect;
    private  PreparedStatement preStatement; // dùng đê gọi proc trong database
    public Database(){
        try{
            connect = DriverManager.getConnection(Common.connectString);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public int trade(int accountId, int amount, String tradeType){
        try{
            preStatement = connect.prepareCall("{call Trade(?,?,?)}");
            preStatement.setInt(1,accountId);
            preStatement.setInt(2,amount);
            preStatement.setString(3,tradeType);
            ResultSet result = preStatement.executeQuery();
            while(result.next()){
                return result.getInt("result");
            }
            return -1;
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    public int getBalance(int accountId){
        try{
            preStatement = connect.prepareCall("{call getBalance(?)}");
            preStatement.setInt(1,accountId);
            ResultSet result = preStatement.executeQuery();
            while(result.next()){
                return result.getInt("balance");
            }
            return -1;
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    public ResultSet getHistory(int accountId){
        try{
            preStatement = connect.prepareCall("{call getHistory(?)}");
            preStatement.setInt(1,accountId);
            ResultSet result = preStatement.executeQuery();
            while(result.next()){
                return result;
            }
            return null;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
