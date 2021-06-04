package Controller;

import Model.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Random;

public class LoginController
{

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
        UserController.getUserData(userName);
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

    public static boolean CheckCMND (String cmnd)
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

}
