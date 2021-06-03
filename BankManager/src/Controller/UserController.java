package Controller;

import Model.UserData;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class UserController
{
    public static String fullname, gender, address, phone, dateSignUp, balance, accountNumber, born;
    public static Date birthday, dateRegister;
    public static double balanceService;

    public static void getUserData(String username)
    {
        ResultSet resultSet = UserData.getUserData(username);
        try
        {
            resultSet.next();
            fullname = resultSet.getString(2);
            birthday = resultSet.getDate(3);
            born = new SimpleDateFormat("dd-MM-yyyy").format(UserController.birthday);
            gender = resultSet.getString(4);
            if (gender.equalsIgnoreCase("1"))
                gender = "Nam";
            else if (gender.equalsIgnoreCase("0"))
                gender = "Nữ";
            address = resultSet.getString(5);
            phone = resultSet.getString(6);
            accountNumber = resultSet.getString(7);
            dateRegister = resultSet.getDate(11);
            dateSignUp = new SimpleDateFormat("dd-MM-yyyy").format(UserController.dateRegister);
            balanceService = resultSet.getDouble(12);
            balance = String.format("%,.0f", balanceService);
        } catch (Exception exception)
        {
            System.err.println("LoginController.java.getUserData: " + exception.getMessage());
        }
    }

    public static boolean CheckGender(String username)
    {
        ResultSet resultSet = UserData.CheckGender(username);
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
}
