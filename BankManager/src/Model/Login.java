package Model;


import java.math.BigInteger;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Random;


public class Login
{
    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    public static String fullname, gender, address, phone, dateSignUp, balance, accountNumber, born;
    public static Date birthday, dateRegister;

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
    public boolean CheckGender(String username)
    {
        String SQL = "use QLNH Select GioiTinh From KHACHHANG KH Inner Join TAIKHOAN TK ON KH.CMND = TK.CMND Where TenTK = ?";
        try
        {
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if(resultSet.getInt("GioiTinh") == 1)
                return true;
        } catch (Exception exception)
        {
            System.err.println("Login.java.CheckGender: " + exception.getMessage());
        }
        return false;
    }
    public void UpdateProfile(String fullname, String gender, String phone, String birthDay, String address, String usernme)
    {
        int genderLast = -1;
        if (gender.equalsIgnoreCase("nam"))
            genderLast = 1;
        else if (gender.equalsIgnoreCase("nu") || gender.equalsIgnoreCase("nữ"))
            genderLast = 0;

        String SQL = "use QLNH Update KHACHHANG set TenKH = ?, NgaySinh = ?, GioiTinh = ?, DiaChi=?, SoDienThoai=?\n" +
                "where CMND = (select KH.CMND from KHACHHANG KH INNER JOIN TAIKHOAN TK ON KH.CMND = TK.CMND where TK.TenTK = ?)";

        try
        {
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, fullname);
            preparedStatement.setString(2, birthDay);
            preparedStatement.setInt(3, genderLast);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, phone);
            preparedStatement.setString(6, usernme);
            preparedStatement.executeQuery();
        } catch (Exception exception)
        {
            System.err.println("Login.java.UpdateProfile: " + exception.getMessage());
        }
    }

    public void UpdatePassword(String password, String username)
    {
        String SQL = "use QLNH Update TAIKHOAN set MatKhau = ? where TenTK = ?";
        try
        {
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            preparedStatement.executeQuery();
        } catch (Exception exception)
        {
            System.err.println("Login.java.UpdateProfile: " + exception.getMessage());
        }
    }

    public void getData(String username)
    {
        String SQL = "use QLNH select * from KHACHHANG KH INNER JOIN TAIKHOAN TK ON KH.CMND = TK.CMND WHERE TenTK = ?";

        try
        {
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            fullname = resultSet.getString(2);
            birthday = resultSet.getDate(3);
            born = new SimpleDateFormat("dd-MM-yyyy").format(Login.birthday);
            gender = resultSet.getString(4);
            if (gender.equalsIgnoreCase("1"))
                gender = "Nam";
            else if (gender.equalsIgnoreCase("0"))
                gender = "Nữ";
            address = resultSet.getString(5);
            phone = resultSet.getString(6);
            accountNumber = resultSet.getString(7);
            dateRegister = resultSet.getDate(10);
            dateSignUp = new SimpleDateFormat("dd-MM-yyyy").format(Login.dateRegister);
            double balanceTemp = resultSet.getDouble(12);
            balance = String.format("%,.0f", balanceTemp);
        } catch (Exception exception)
        {
            System.err.println("Login.java.getData: " + exception.getMessage());
        }
    }

    public String getBorn(String username)
    {
        String SQL = "use QLNH select NgaySinh from KHACHHANG KH INNER JOIN TAIKHOAN TK ON KH.CMND = TK.CMND WHERE TenTK = ?";
        try
        {
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            birthday = resultSet.getDate(1);
        } catch (Exception exception)
        {
            System.err.println("Login.java.getDate: " + exception.getMessage());
        }
        return new SimpleDateFormat("dd-MM-yyyy").format(Login.birthday);
    }

    public void getTransfer(String amount, String typeTrade, String accountNumberReceived, String accountNumber)
    {
        String SQL = "use QLNH" +
                " insert into GIAODICH(SoTien, LoaiGD, SoTKNhan, SoTK)" +
                "values(?,?,?,?)" +
                "insert into CHITIETGD()";
        try
        {
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, amount);
            preparedStatement.setString(2, typeTrade);
            preparedStatement.setString(3, accountNumberReceived);
            preparedStatement.setString(4, accountNumber);
            preparedStatement.executeQuery();
        } catch (Exception exception)
        {
            System.err.println("Login.java.InsertDataTAIKHOAN: " + exception.getMessage());
        }
    }
}