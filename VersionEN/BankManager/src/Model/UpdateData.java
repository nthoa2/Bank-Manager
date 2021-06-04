package Model;

public class UpdateData
{
    public static int UpdateProfile(String fullname, String gender, String phone, String birthDay, String address, String usernme)
    {
        int genderLast = -1;
        if (gender.equalsIgnoreCase("nam"))
            genderLast = 1;
        else if (gender.equalsIgnoreCase("nu") || gender.equalsIgnoreCase("nữ"))
            genderLast = 0;

        String SQL = "use QLNH Update KHACHHANG set TenKH = N'" + fullname + "', NgaySinh = '" + birthDay + "', GioiTinh = " + genderLast + ", DiaChi=N'" + address + "', SoDienThoai= '" + phone + "' \n" +
                "where CMND = (select KH.CMND from KHACHHANG KH INNER JOIN TAIKHOAN TK ON KH.CMND = TK.CMND where TK.TenTK = '" + usernme + "')";
        return Model.connection.executeQuery(SQL);
    }

    public static int UpdatePassword(String password, String username)
    {
        String SQL = "use QLNH Update TAIKHOAN set MatKhau = '" + password + "' where TenTK = '" + username + "'";
        return Model.connection.executeQuery(SQL);
    }

    public static int updateAccountNumberTransfer(String accountNumber, String accountNumberReceived, double amount)
    {
        String SQL = "use QLNH \n" +
                " UPDATE TAIKHOAN SET SoDu = SoDu - " + amount + " WHERE SoTK = '" + accountNumber + "'"
                + " UPDATE TAIKHOAN SET SoDu = SoDu + " + amount + " WHERE SoTK = '" + accountNumberReceived + "'";
        return Model.connection.executeQuery(SQL);
    }

    public static int updateAccountNumber(String typeTrade, String accountNumber, double amount)
    {
        String SQL;
        if (typeTrade.equals("Rút tiền"))
            SQL = "use QLNH update TAIKHOAN set SoDu = SoDu - " + amount + " where SoTK = '" + accountNumber + "'";
        else SQL = "use QLNH update TAIKHOAN set SoDu = SoDu + " + amount + " where SoTK = '" + accountNumber + "'";
        return Model.connection.executeQuery(SQL);
    }
}
