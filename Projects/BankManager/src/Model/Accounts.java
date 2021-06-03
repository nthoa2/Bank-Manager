package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Accounts {


    public static ResultSet getSpendingPerMonth(String startDate, String endDate) {
        String query = "SET DATEFORMAT DMY SELECT dbo.[TAIKHOAN].[SoTK],SUM(dbo.[CHITIETGD].[SoTien]) AS [ChiRa]" +
                "FROM dbo.[TAIKHOAN] right JOIN dbo.[GIAODICH] ON [GIAODICH].[SoTK] = [TAIKHOAN].[SoTK]" +
                "RIGHT JOIN dbo.[CHITIETGD] ON [CHITIETGD].[MaGD] = [GIAODICH].[MaGD]" +
                "WHERE (dbo.[GIAODICH].[LoaiGD] = N'Rút Tiền' or dbo.[GIAODICH].[LoaiGD] = N'Chuyển Khoản') " +
                "AND (dbo.[CHITIETGD].[NgayGD] BETWEEN  '" + startDate + "' AND '" + endDate + "')" +
                "GROUP BY [TAIKHOAN].[SoTK]";
        return connection.getData(query);
    }

    public static ResultSet getReceivedPerMonth(String startDate, String endDate) {
        String query = "SET DATEFORMAT DMY SELECT dbo.[TAIKHOAN].[SoTK],SUM(dbo.[CHITIETGD].[SoTien]) AS [NhanVao]" +
                "FROM dbo.[TAIKHOAN] right JOIN dbo.[GIAODICH] ON [GIAODICH].[SoTK] = [TAIKHOAN].[SoTK]" +
                "RIGHT JOIN dbo.[CHITIETGD] ON [CHITIETGD].[MaGD] = [GIAODICH].[MaGD]" +
                "WHERE (dbo.[GIAODICH].[LoaiGD] = N'Nạp Tiền' or dbo.[GIAODICH].[LoaiGD] = N'Nhận Chuyển Khoản') " +
                "AND (dbo.[CHITIETGD].[NgayGD] BETWEEN  '" + startDate + "' AND '" + endDate + "')" +
                "GROUP BY [TAIKHOAN].[SoTK]";
        return connection.getData(query);
    }

    public static ResultSet getSpendingPerDay(String date) {
        String query = "SET DATEFORMAT DMY SELECT dbo.[TAIKHOAN].[SoTK],SUM(dbo.[CHITIETGD].[SoTien]) AS [ChiRa]" +
                "FROM dbo.[TAIKHOAN] right JOIN dbo.[GIAODICH] ON [GIAODICH].[SoTK] = [TAIKHOAN].[SoTK]" +
                "RIGHT JOIN dbo.[CHITIETGD] ON [CHITIETGD].[MaGD] = [GIAODICH].[MaGD]" +
                "WHERE (dbo.[GIAODICH].[LoaiGD] = N'Rút Tiền' or dbo.[GIAODICH].[LoaiGD] = N'Chuyển Khoản') " +
                "AND dbo.[CHITIETGD].[NgayGD] = '" + date + "'" +
                "GROUP BY [TAIKHOAN].[SoTK]";
        return connection.getData(query);
    }

    public static ResultSet getReceivedPerDay(String date) {
        String query = "SET DATEFORMAT DMY SELECT dbo.[TAIKHOAN].[SoTK],SUM(dbo.[CHITIETGD].[SoTien]) AS [NhanVao]" +
                "FROM dbo.[TAIKHOAN] right JOIN dbo.[GIAODICH] ON [GIAODICH].[SoTK] = [TAIKHOAN].[SoTK]" +
                "RIGHT JOIN dbo.[CHITIETGD] ON [CHITIETGD].[MaGD] = [GIAODICH].[MaGD]" +
                "WHERE (dbo.[GIAODICH].[LoaiGD] = N'Nạp Tiền' or dbo.[GIAODICH].[LoaiGD] = N'Nhận Chuyển Khoản') " +
                "AND dbo.[CHITIETGD].[NgayGD] = '" + date + "'" +
                "GROUP BY [TAIKHOAN].[SoTK]";
        return connection.getData(query);

    }

    public static void updateAccountBalance(String accountNumber, String TransactionType, double amount) {
        double temp = amount;
        if (TransactionType.equals("Chuyển Khoản") || TransactionType.equals("Rút Tiền")) {
            temp *= -1.0;
        }
        String query = "UPDATE dbo.[TAIKHOAN] SET [SoDu] = [SoDu] + " + temp + " WHERE SoTK = '" + accountNumber + "'";
        connection.executeQuery(query);
    }

    public static void editPassword(String userAccount, String newPassword) {
        String query = "UPDATE dbo.loginAccount SET loginPassword = '" + newPassword + "' WHERE loginName = '" + userAccount + "'";
        connection.executeQuery(query);
    }

    public static void insertAccount(String accountNumber, String userID) {
        String query = "INSERT INTO dbo.TAIKHOAN(SoTK,MaKH,NgayDangKy,SoDu)" +
                "VALUES('" + accountNumber + "','" + userID + "',GETDATE(), DEFAULT)";
        connection.executeQuery(query);
    }

}
