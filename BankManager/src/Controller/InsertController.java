package Controller;

import Model.InsertData;

public class InsertController
{
    public static void InsertDataKHACHHANG(String cmnd, String fullname, String phoneNumber, String gender, String birthDay, String address)
    {
        try
        {
            InsertData.InsertDataKHACHHANG(cmnd, fullname, phoneNumber, gender, birthDay, address);
        } catch (Exception exception)
        {
            System.err.println("LoginController.java.InsertDataKHACHHANG: " + exception.getMessage());
        }
    }

    public static void InsertDataTAIKHOAN(String accountNumber, String username, String password, String CMND)
    {
        try
        {
            InsertData.InsertDataTAIKHOAN(accountNumber, username, password, CMND);
        } catch (Exception exception)
        {
            System.err.println("LoginController.java.InsertDataTAIKHOAN: " + exception.getMessage());
        }
    }
}
