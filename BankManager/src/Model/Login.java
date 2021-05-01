package Model;


import java.sql.*;
import java.util.Random;


public class Login
{
    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    // khởi tạo k cần funcName
    {
        try
        {
            connection = DriverManager.getConnection(Common.connectString);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    public boolean CheckLogin(String userName, String password)
    {
        String SQL = "use QLNH select * from TAIKHOAN where TenTK = ? and MatKhau = ?";
        try
        {
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                return false;
        } catch (Exception exception)
        {
            System.err.println("Login.java.CheckLogin: " + exception.getMessage());
        }
        return true;
    }

    public String Random(int start, int end, int limit)
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

    public boolean CheckSignUpSoTK(String accountNumber)
    {
        String SQL = "use QLNH select SoTK from TAIKHOAN where SoTK = ?";
        try
        {
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, accountNumber);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                return false;
        } catch (Exception exception)
        {
            System.err.println("Login.java.CheckSignUpSoTK: " + exception.getMessage());
        }
        return true;
    }

    public boolean CheckSignUpTenTK(String username)
    {
        String SQL = "use QLNH select TenTK from TAIKHOAN where TenTK = ?";
        try
        {
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                return false;
        } catch (Exception exception)
        {
            System.err.println("Login.java.CheckSignUpTenTK: " + exception.getMessage());
        }
        return true;
    }

    public boolean CheckCMND(String cmnd)
    {
        String SQL = "use QLNH select CMND from KHACHHANG where CMND = ?";
        try
        {
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, cmnd);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                return false;
        } catch (Exception exception)
        {
            System.err.println("Login.java.CheckCMND: " + exception.getMessage());
        }
        return true;
    }

    public void InsertDataKHACHHANG(String cmnd, String fullname, String phoneNumber, String gender, String birthDay, String address)
    {
        int genderLast = -1;
        String SQL;
        if (gender.equalsIgnoreCase("nam"))
            genderLast = 1;
        else if (gender.equalsIgnoreCase("nu") || gender.equalsIgnoreCase("nữ"))
            genderLast = 0;
        SQL = "use QLNH " +
                "insert into KHACHHANG(CMND, TenKH, NgaySinh, GioiTinh, DiaChi, SoDienThoai)" +
                "values(?,?,?,?,?,?)";
        try
        {
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, cmnd);
            preparedStatement.setString(2, fullname);
            preparedStatement.setString(3, birthDay);
            preparedStatement.setInt(4, genderLast);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, phoneNumber);
            preparedStatement.executeQuery();
        } catch (Exception exception)
        {
            System.err.println("Login.java.InsertDataKHACHHANG: " + exception.getMessage());
        }
    }

    public void InsertDataTAIKHOAN(String accountNumber, String username, String password, String CMND)
    {
        String SQL = "use QLNH" +
                " insert into TAIKHOAN(SoTK, TenTK, MatKhau, CMND)" +
                "values(?,?,?,?)";
        try
        {
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, accountNumber);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, CMND);
            preparedStatement.executeQuery();
        } catch (Exception exception)
        {
            System.err.println("Login.java.InsertDataTAIKHOAN: " + exception.getMessage());
        }
    }
}