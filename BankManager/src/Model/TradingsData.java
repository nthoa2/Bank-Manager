package Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TradingsData
{

    public static ResultSet getAllTrading(String accountNumber)
    {
        // thêm oder by vì khi thêm 1 giao dịch nó k nằm ở cuối list mà nằm lun tung
        String queryString = "SELECT dbo.CHITIETGD.LoaiGD, dbo.GIAODICH.NgayGD,dbo.CHITIETGD.SoTK, dbo.CHITIETGD.SoTKNhan, dbo.GIAODICH.GhiChu,dbo.GIAODICH.SoTien\n" +
                "FROM dbo.GIAODICH FULL OUTER JOIN dbo.CHITIETGD ON CHITIETGD.MaGD = GIAODICH.MaGD\n" +
                "INNER JOIN dbo.TAIKHOAN ON TAIKHOAN.SoTK = CHITIETGD.SoTK\n" +
                "INNER JOIN dbo.KHACHHANG ON KHACHHANG.CMND = TAIKHOAN.CMND" +
                " WHERE CHITIETGD.SoTK = '" + accountNumber + "' OR CHITIETGD.SoTKNhan = '" + accountNumber + "'" +
                " ORDER BY NgayGD";
        return connection.getData(queryString);
    }

    public static ResultSet getTradedByType(String type, String accountNumber)
    {
        // thêm oder by vì khi thêm 1 giao dịch nó k nằm ở cuối list mà nằm lun tung
        String queryString = "SELECT dbo.CHITIETGD.LoaiGD, dbo.GIAODICH.NgayGD,dbo.CHITIETGD.SoTK, dbo.CHITIETGD.SoTKNhan, dbo.GIAODICH.GhiChu,dbo.GIAODICH.SoTien\n" +
                "FROM dbo.GIAODICH FULL OUTER JOIN dbo.CHITIETGD ON CHITIETGD.MaGD = GIAODICH.MaGD\n" +
                "INNER JOIN dbo.TAIKHOAN ON TAIKHOAN.SoTK = CHITIETGD.SoTK\n" +
                "INNER JOIN dbo.KHACHHANG ON KHACHHANG.CMND = TAIKHOAN.CMND" +
                " WHERE (CHITIETGD.SoTK = '" + accountNumber + "' OR CHITIETGD.SoTKNhan = '" + accountNumber + "') AND LoaiGD = N'" + type + "'" +
                " ORDER BY NgayGD";
        return connection.getData(queryString);
    }

    public static ResultSet getUserName(String accountNumber)
    {
        String query = "SELECT TenKH FROM KHACHHANG KH LEFT JOIN TAIKHOAN TK ON KH.CMND = TK.CMND" +
                " WHERE SoTK = '" + accountNumber + "'";
        return connection.getData(query);
    }

    public static ResultSet getTop10Trading(String accountNumber)
    {
        String queryString = "SELECT TOP 10 dbo.CHITIETGD.LoaiGD, dbo.GIAODICH.NgayGD,dbo.CHITIETGD.SoTK, dbo.CHITIETGD.SoTKNhan, dbo.GIAODICH.GhiChu,dbo.GIAODICH.SoTien\n" +
                "FROM dbo.GIAODICH FULL OUTER JOIN dbo.CHITIETGD ON CHITIETGD.MaGD = GIAODICH.MaGD\n" +
                "INNER JOIN dbo.TAIKHOAN ON TAIKHOAN.SoTK = CHITIETGD.SoTK\n" +
                "INNER JOIN dbo.KHACHHANG ON KHACHHANG.CMND = TAIKHOAN.CMND" +
                " WHERE CHITIETGD.SoTK = '" + accountNumber + "' OR CHITIETGD.SoTKNhan = '" + accountNumber + "'" +
                " ORDER BY NgayGD DESC";
        return connection.getData(queryString);
    }

    public static ResultSet getUsersSpendingAndReceivedPerDay(String userID)
    {
        String query = "SET DATEFORMAT dmy " +
                "SELECT dbo.CHITIETGD.LoaiGD, dbo.GIAODICH.NgayGD,dbo.CHITIETGD.SoTK, dbo.CHITIETGD.SoTKNhan, dbo.GIAODICH.GhiChu,dbo.GIAODICH.SoTien\n" +
                "FROM dbo.GIAODICH FULL OUTER JOIN dbo.CHITIETGD ON CHITIETGD.MaGD = GIAODICH.MaGD\n" +
                "INNER JOIN dbo.TAIKHOAN ON TAIKHOAN.SoTK = CHITIETGD.SoTK\n" +
                "INNER JOIN dbo.KHACHHANG ON KHACHHANG.CMND = TAIKHOAN.CMND" +
                " WHERE CHITIETGD.SoTK = '" + userID + "' OR CHITIETGD.SoTKNhan = '" + userID + "'";
        return connection.getData(query);

    }

}
