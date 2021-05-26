package Controller;

import Model.Login;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class LoginController
{
    public static String fullname, gender, address, phone, dateSignUp, balance, accountNumber, born;
    public static Date birthday, dateRegister;
    public static double balanceService;

    public static void getUserData(String username)
    {
        ResultSet resultSet = Login.getUserData(username);
        try
        {
            resultSet.next();
            fullname = resultSet.getString(2);
            birthday = resultSet.getDate(3);
            born = new SimpleDateFormat("dd-MM-yyyy").format(LoginController.birthday);
            gender = resultSet.getString(4);
            if (gender.equalsIgnoreCase("1"))
                gender = "Nam";
            else if (gender.equalsIgnoreCase("0"))
                gender = "Nữ";
            address = resultSet.getString(5);
            phone = resultSet.getString(6);
            accountNumber = resultSet.getString(7);
            dateRegister = resultSet.getDate(10);
            dateSignUp = new SimpleDateFormat("dd-MM-yyyy").format(LoginController.dateRegister);
            balanceService = resultSet.getDouble(12);
            balance = String.format("%,.0f", balanceService);
        } catch (Exception exception)
        {
            System.err.println("LoginController.java.getUserData: " + exception.getMessage());
        }
    }

    public static boolean CheckLogin(String userName, String password)
    {
        ResultSet resultSet = Login.CheckLogin(userName, password);
        try
        {
            if (!resultSet.next())
                return false;
        } catch (Exception exception)
        {
            System.err.println("LoginController.java.CheckLogin: " + exception.getMessage());
        }
        return true;
    }

    public static String Random(int start, int end, int limit)
    {
        String accountNumber = "";
        Random r = new Random();
        long[] longs = r.longs(start, end).limit(limit).toArray();
        for (long x : longs)
        {
            accountNumber += String.valueOf(x);
        }
        return accountNumber;
    }

    public static boolean CheckSignUpSoTK(String accountNumber)
    {
        ResultSet resultSet = Login.CheckSignUpSoTK(accountNumber);
        try
        {
            if (!resultSet.next())
                return false;
        } catch (Exception exception)
        {
            System.err.println("LoginController.java.CheckSignUpSoTK: " + exception.getMessage());
        }
        return true;
    }

    public static boolean CheckSignUpTenTK(String username)
    {
        ResultSet resultSet = Login.CheckSignUpTenTK(username);
        try
        {
            if (!resultSet.next())
                return false;
        } catch (Exception exception)
        {
            System.err.println("LoginController.java.CheckSignUpTenTK: " + exception.getMessage());
        }
        return true;
    }

    public static boolean CheckCMND(String cmnd)
    {
        ResultSet resultSet = Login.CheckCMND(cmnd);
        try
        {
            if (!resultSet.next())
                return false;
        } catch (Exception exception)
        {
            System.err.println("LoginController.java.CheckCMND: " + exception.getMessage());
        }
        return true;
    }

    public static void InsertDataKHACHHANG(String cmnd, String fullname, String phoneNumber, String gender, String birthDay, String address)
    {
        try
        {
            Login.InsertDataKHACHHANG(cmnd, fullname, phoneNumber, gender, birthDay, address);
        } catch (Exception exception)
        {
            System.err.println("LoginController.java.InsertDataKHACHHANG: " + exception.getMessage());
        }
    }

    public static void InsertDataTAIKHOAN(String accountNumber, String username, String password, String CMND)
    {
        try
        {
            Login.InsertDataTAIKHOAN(accountNumber, username, password, CMND);
        } catch (Exception exception)
        {
            System.err.println("LoginController.java.InsertDataTAIKHOAN: " + exception.getMessage());
        }
    }

    public static boolean CheckGender(String username)
    {
        ResultSet resultSet = Login.CheckGender(username);
        try
        {
            resultSet.next();
            if (resultSet.getInt("GioiTinh") == 1)
                return true;
        } catch (Exception exception)
        {
            System.err.println("LoginController.java.CheckGender: " + exception.getMessage());
        }
        return false;
    }

    public static void UpdateProfile(String fullname, String gender, String phone, String birthDay, String address, String username)
    {
        try
        {
            Login.UpdateProfile(fullname, gender, phone, birthDay, address, username);
        } catch (Exception exception)
        {
            System.err.println("LoginController.java.UpdateProfile: " + exception.getMessage());
        }
    }

    public static void UpdatePassword(String password, String username)
    {
        try
        {
            Login.UpdatePassword(password, username);
        } catch (Exception exception)
        {
            System.err.println("LoginController.java.UpdatePassword: " + exception.getMessage());
        }
    }

    public static boolean checkTradingCode(String tradingCode)
    {
        ResultSet resultSet = Login.checkTradingCode(tradingCode);
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
        if (balanceService < amount)
            return false;
        Login.updateAccountNumberTransfer(accountNumber, accountNumberReceived, amount);
        String tradingCode = Random(0, 9, 5);
        while (LoginController.checkTradingCode(tradingCode))
            tradingCode = Random(0, 9, 5);
        Login.updateTransfer(tradingCode, typeTrade, accountNumber, accountNumberReceived,amount,content);
        return true;
    }

    public static boolean updateWithDrawAndRecharge(String typeTrade, String accountNumber, double amount, String content)
    {
        if (typeTrade.equals("Rút tiền"))
            if (balanceService < amount)
                return false;
        Login.updateAccountNumber(typeTrade, accountNumber, amount);
        String tradingCode = Random(0, 9, 5);
        while (checkTradingCode(tradingCode))
            tradingCode = Random(0, 9, 5);
        Login.updateWithDrawAndRecharge(tradingCode, typeTrade, accountNumber, amount, content);
        return true;
    }
}
