package Model;

public class InsertData
{
    public static int InsertDataKHACHHANG(String cmnd, String fullname, String phoneNumber, String gender, String birthDay, String address)
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
        return Model.connection.executeQuery(SQL);
    }

    public static int InsertDataTAIKHOAN(String accountNumber, String username, String password, String CMND)
    {
        String SQL = "use QLNH" +
                " insert into TAIKHOAN(SoTK, TenTK, MatKhau, CMND)" +
                "values('" + accountNumber + "','" + username + "','" + password + "','" + CMND + "')";
        return Model.connection.executeQuery(SQL);
    }

    public static int insertTransfer(String idTrade, String typeTrade, String accountNumber, String accountNumberReceived, double amount, String content)
    {
        String SQL = "use QLNH" +
                " insert into GIAODICH(MaGD, SoTien, GhiChu) " +
                "values('" + idTrade + "'," + amount + ",N'" + content + "') " +
                "insert into CHITIETGD(MaGD, LoaiGD, SoTK, SoTKNhan) " +
                " values ('" + idTrade + "',N'" + typeTrade + "','" + accountNumber + "','" + accountNumberReceived + "')";
        return connection.executeQuery(SQL);
    }

    public static int insertWithDrawAndRecharge(String idTrade, String typeTrade, String accountNumber, double amount, String content)
    {
        String SQL = "use QLNH " +
                " insert into GIAODICH(MaGD, SoTien, GhiChu) " +
                " values('" + idTrade + "'," + amount + ",N'" + content + "') " +
                " insert into CHITIETGD(MaGD, LoaiGD , SoTK, SoTKNhan) " +
                " values ('" + idTrade + "',N'" + typeTrade + "', '" + accountNumber + "','" + accountNumber + "')";
        return Model.connection.executeQuery(SQL);
    }
}
