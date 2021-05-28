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

    public static ResultSet InsertDataKHACHHANG(String cmnd, String fullname, String phoneNumber, String gender, String birthDay, String address)
    {
        int genderLast = -1;
        String SQL;
        if (gender.equalsIgnoreCase("nam"))
            genderLast = 1;
        else if (gender.equalsIgnoreCase("nu") || gender.equalsIgnoreCase("nữ"))
            genderLast = 0;
        SQL = "use QLNH " +
                "insert into KHACHHANG(CMND, TenKH, NgaySinh, GioiTinh, DiaChi, SoDienThoai)" +
                " values('" + cmnd + "',N'" + fullname + "','" + birthDay + "'," + genderLast + ",N'" + address + "','" + phoneNumber + "')";
        return Model.connection.getData(SQL);
    }

    public static ResultSet InsertDataTAIKHOAN(String accountNumber, String username, String password, String CMND)
    {
        String SQL = "use QLNH" +
                " insert into TAIKHOAN(SoTK, TenTK, MatKhau, CMND)" +
                "values('" + accountNumber + "','" + username + "','" + password + "','" + CMND + "')";
        return Model.connection.getData(SQL);
    }

    public static ResultSet CheckGender(String username)
    {
        String SQL = "use QLNH Select GioiTinh From KHACHHANG KH Inner Join TAIKHOAN TK ON KH.CMND = TK.CMND Where TenTK = '" + username + "'";
        return Model.connection.getData(SQL);
    }

    public static ResultSet UpdateProfile(String fullname, String gender, String phone, String birthDay, String address, String usernme)
    {
        int genderLast = -1;
        if (gender.equalsIgnoreCase("nam"))
            genderLast = 1;
        else if (gender.equalsIgnoreCase("nu") || gender.equalsIgnoreCase("nữ"))
            genderLast = 0;

        String SQL = "use QLNH Update KHACHHANG set TenKH = N'" + fullname + "', NgaySinh = '" + birthDay + "', GioiTinh = " + genderLast + ", DiaChi=N'" + address + "', SoDienThoai= '" + phone + "' \n" +
                "where CMND = (select KH.CMND from KHACHHANG KH INNER JOIN TAIKHOAN TK ON KH.CMND = TK.CMND where TK.TenTK = '" + usernme + "')";
        return Model.connection.getData(SQL);
    }

    public static ResultSet UpdatePassword(String password, String username)
    {
        String SQL = "use QLNH Update TAIKHOAN set MatKhau = '" + password + "' where TenTK = '" + username + "'";
        return Model.connection.getData(SQL);
    }


    public static ResultSet getUserData(String username)
    {
        String SQL = "use QLNH select * from KHACHHANG KH INNER JOIN TAIKHOAN TK ON KH.CMND = TK.CMND WHERE TenTK =N'" + username + "'";
        return Model.connection.getData(SQL);
    }


    public static ResultSet checkTradingCode(String tradingCode)
    {
        String SQL = "use QLNH select * from GIAODICH Where MaGD = '" + tradingCode + "'";
        return Model.connection.getData(SQL);
    }

    public static ResultSet updateAccountNumberTransfer(String accountNumber, String accountNumberReceived, double amount)
    {
        String SQL = "use QLNH \n" +
                " UPDATE TAIKHOAN SET SoDu = SoDu - " + amount + " WHERE SoTK = '" + accountNumber + "'"
                + " UPDATE TAIKHOAN SET SoDu = SoDu + " + amount + " WHERE SoTK = '" + accountNumberReceived + "'";
        return Model.connection.getData(SQL);
    }

    public static ResultSet updateTransfer(String idTrade, String typeTrade, String accountNumber, String accountNumberReceived, double amount, String content)
    {
        String SQL = "use QLNH" +
                " insert into GIAODICH(MaGD, SoTien, GhiChu) " +
                "values('" + idTrade + "','" + amount + "',N'" + content + "') " +
                "insert into CHITIETGD(MaGD, LoaiGD, SoTK, SoTKNhan) " +
                " values ('" + idTrade + "',N'" + typeTrade + "','" + accountNumber + "','" + accountNumberReceived + "')";
        return connection.getData(SQL);
    }

    public static int updateAccountNumber(String typeTrade, String accountNumber, double amount)
    {
        String SQL;
        if (typeTrade.equals("Rút tiền"))
            SQL = "use QLNH update TAIKHOAN set SoDu = SoDu - " + amount + " where SoTK = '" + accountNumber + "'";
        else SQL = "use QLNH update TAIKHOAN set SoDu = SoDu + " + amount + " where SoTK = '" + accountNumber + "'";
        return Model.connection.executeQuery(SQL);
    }

    public static int updateWithDrawAndRecharge(String idTrade, String typeTrade, String accountNumber, double amount, String content)
    {
        String SQL = "use QLNH" +
                " insert into GIAODICH(MaGD, SoTien, GhiChu)" +
                "values('" + idTrade + "','" + amount + "',N'" + content + "')" +
                "insert into CHITIETGD(MaGD, LoaiGD , SoTK, SoTKNhan)" +
                "values ('" + idTrade + "',N'" + typeTrade + "', '" + accountNumber + "','" + accountNumber + "')";
        return Model.connection.executeQuery(SQL);
    }
}