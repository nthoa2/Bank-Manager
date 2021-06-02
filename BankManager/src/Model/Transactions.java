package Model;

import java.sql.ResultSet;

public class Transactions {

    public static ResultSet getAllTradingByAccount(String accountNumber) {
        String queryString = "SELECT dbo.[GIAODICH].[LoaiGD], dbo.[CHITIETGD].[NgayGD],dbo.[KHACHHANG].[TenKH] AS [NguoiNhan],dbo.[CHITIETGD].[NoiDung],dbo.[CHITIETGD].[SoTien]" +
                "FROM dbo.[CHITIETGD] FULL OUTER JOIN dbo.[GIAODICH] ON [GIAODICH].[MaGD] = [CHITIETGD].[MaGD]\n" +
                "LEFT JOIN dbo.TAIKHOAN ON dbo.GIAODICH.SoTK = '" + accountNumber + "'" +
                "INNER JOIN dbo.[KHACHHANG] ON [KHACHHANG].[MaKH] = [TAIKHOAN].[MaKH] " +
                "WHERE (dbo.[TAIKHOAN].[SoTK] !='" + accountNumber + "' AND (dbo.GIAODICH.LoaiGD = N'Chuyển Khoản' OR dbo.GIAODICH.LoaiGD = N'Nhận Chuyển Khoản'))" +
                "OR (dbo.[TAIKHOAN].[SoTK] ='" + accountNumber + "' AND (dbo.GIAODICH.LoaiGD = N'Nạp Tiền' OR dbo.GIAODICH.LoaiGD = N'Rút Tiền'))";
        return connection.getData(queryString);
    }

    private static int createTransactionData(String TradingID, String TradingContent, double amount) {
        String query = "SET DATEFORMAT DMY INSERT INTO dbo.[CHITIETGD]([MaGD],[SoTien],[NoiDung],[NgayGD])VALUES('" + TradingID + "'," + amount + ",N'" + TradingContent + "',DEFAULT)";
        return connection.executeQuery(query);
    }

    private static int createTransactionObjects(String accountNumber, String TradingType, String TradingID) {
        String query = "INSERT INTO dbo.[GIAODICH]([SoTK],[LoaiGD],[MaGD])VALUES('" + accountNumber + "',N'" + TradingType + "','" + TradingID + "')";
        return connection.executeQuery(query);
    }

    public static void createdTransaction(String accountNumber, String TradingID, String TradingType, String accountNumberRev, double amount, String TradingContent) {
        int result = 0;
        if (createTransactionData(TradingID, TradingContent, amount) == 1) {
            System.out.println("Tạo Data Giao Dịch Thanh Công");
            result++;
        }
        if (createTransactionObjects(accountNumber, TradingType, TradingID) == 1) {
            System.out.println("Tạo Data Người Giao Dịch Thanh Công");
            result++;
        }
        if (TradingType.equals("Chuyển Khoản")) {
            System.out.println("Tạo Thông Tin Người Nhận Chuyển Khoản");
            result += createTransactionObjects(accountNumberRev, "Nhận Chuyển Khoản", TradingID);
        }
        if(result >= 2){
            System.out.println("Thực Hiện Giao Dịch Thành Công");
        }else {
            System.err.println("Thực Hiện Giao Dịch Thất Bại");
        }
    }

    public static ResultSet getAllTransactionDetail() {
        String query = "SELECT * FROM dbo.[CHITIETGD]";
        return connection.getData(query);
    }
}
