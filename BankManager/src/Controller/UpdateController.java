package Controller;

import Model.InsertData;
import Model.TradingsData;
import Model.UpdateData;

import java.sql.ResultSet;

public class UpdateController
{
    public static boolean checkTradingCode(String tradingCode)
    {
        ResultSet resultSet = TradingsData.checkTradingCode(tradingCode);
        try
        {
            if (!resultSet.next())
                return false;
        } catch (Exception exception)
        {
            System.err.println("LoginController.java.checkTradingCode: " + exception.getMessage());
        }
        return true;
    }

    public static boolean updateTransfer(String typeTrade, String accountNumber, String accountNumberReceived, double amount, String content)
    {
        if (UserController.balanceService < amount)
            return false;
        UpdateData.updateAccountNumberTransfer(accountNumber, accountNumberReceived, amount);
        String tradingCode = LoginController.Random(0, 9, 5);
        while (checkTradingCode(tradingCode))
            tradingCode = LoginController.Random(0, 9, 5);
        InsertData.insertTransfer(tradingCode, typeTrade, accountNumber, accountNumberReceived,amount,content);
        return true;
    }

    public static boolean updateWithDrawAndRecharge(String typeTrade, String accountNumber, double amount, String content)
    {
        if (typeTrade.equals("Rút tiền"))
            if (UserController.balanceService < amount)
                return false;
        UpdateData.updateAccountNumber(typeTrade, accountNumber, amount);
        String tradingCode = LoginController.Random(0, 9, 5);
        while (checkTradingCode(tradingCode))
            tradingCode = LoginController.Random(0, 9, 5);
        InsertData.insertWithDrawAndRecharge(tradingCode, typeTrade, accountNumber, amount, content);
        return true;
    }

    public static void UpdateProfile(String fullname, String gender, String phone, String birthDay, String address, String username)
    {
        try
        {
            UpdateData.UpdateProfile(fullname, gender, phone, birthDay, address, username);
        } catch (Exception exception)
        {
            System.err.println("LoginController.java.UpdateProfile: " + exception.getMessage());
        }
    }

    public static void UpdatePassword(String password, String username)
    {
        try
        {
            UpdateData.UpdatePassword(password, username);
        } catch (Exception exception)
        {
            System.err.println("LoginController.java.UpdatePassword: " + exception.getMessage());
        }
    }
}
