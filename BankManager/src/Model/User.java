package Model;

import java.sql.ResultSet;

public class User {

    public static ResultSet getUserData(String AccountNumber) {
        String query = "SELECT dbo.[TAIKHOAN].[SoTK],dbo.[TAIKHOAN].[SoDu],[dbo].[TAIKHOAN].[NgayDangKy],dbo.[KHACHHANG].* FROM dbo.[KHACHHANG]" +
                "FULL OUTER JOIN dbo.[TAIKHOAN] ON [TAIKHOAN].[MaKH] = [KHACHHANG].[MaKH]" +
                "LEFT JOIN dbo.[loginAccount] ON [loginAccount].[SoTK] = [TAIKHOAN].[SoTK]" +
                "WHERE dbo.[loginAccount].[SoTK] = '" + AccountNumber + "'";
        return connection.getData(query);
    }

    public static ResultSet getAllUserData() {
        String query = "SELECT dbo.[TAIKHOAN].[SoTK],dbo.[KHACHHANG].*,dbo.[TAIKHOAN].[NgayDangKy],dbo.[TAIKHOAN].[SoDu]" +
                "FROM dbo.[KHACHHANG] FULL OUTER JOIN dbo.[TAIKHOAN] ON [TAIKHOAN].[MaKH] = [KHACHHANG].[MaKH]";
        return connection.getData(query);
    }
}
