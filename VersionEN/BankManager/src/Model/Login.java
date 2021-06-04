package Model;


import java.sql.*;

public class Login
{

    // khởi tạo k cần funcName
    public Login()
    {
        new connection();
    }


    public static ResultSet CheckLogin(String userName, String password)
    {
        String SQL = "use QLNH select * from TAIKHOAN where TenTK = N'" + userName + "' and MatKhau = N'" + password + "'";
        return Model.connection.getData(SQL);
    }


    public static ResultSet CheckSignUpSoTK(String accountNumber)
    {
        String SQL = "use QLNH select SoTK from TAIKHOAN where SoTK = '" + accountNumber + "'";
        return Model.connection.getData(SQL);
    }

    public static ResultSet CheckSignUpTenTK(String username)
    {
        String SQL = "use QLNH select TenTK from TAIKHOAN where TenTK = '" + username + "'";
        return Model.connection.getData(SQL);
    }

    public static ResultSet CheckCMND(String cmnd)
    {
        String SQL = "use QLNH select CMND from KHACHHANG where CMND = '" + cmnd + "'";
        return Model.connection.getData(SQL);
    }

}