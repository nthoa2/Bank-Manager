package Model;

import java.sql.ResultSet;

public class TradingsData {

    public static ResultSet getAllTrading(String accountNumber) {
            String queryString = "SELECT dbo.CHITIETGD.LoaiGD, dbo.GIAODICH.NgayGD,dbo.CHITIETGD.SoTK, dbo.CHITIETGD.SoTKNhan, dbo.GIAODICH.GhiChu,dbo.GIAODICH.SoTien\n" +
                    "FROM dbo.GIAODICH FULL OUTER JOIN dbo.CHITIETGD ON CHITIETGD.MaGD = GIAODICH.MaGD\n" +
                    "INNER JOIN dbo.TAIKHOAN ON TAIKHOAN.SoTK = CHITIETGD.SoTK\n" +
                    "INNER JOIN dbo.KHACHHANG ON KHACHHANG.CMND = TAIKHOAN.CMND" +
                    " WHERE CHITIETGD.SoTK = '" + accountNumber + "' OR CHITIETGD.SoTKNhan = '" + accountNumber +"'";
        return connection.getData(queryString);
    }

    public static ResultSet getTradedByType(String type) {
        String queryString = "SELECT dbo.CHITIETGD.LoaiGD, dbo.GIAODICH.NgayGD,dbo.CHITIETGD.SoTK, dbo.CHITIETGD.SoTKNhan, dbo.GIAODICH.GhiChu,dbo.GIAODICH.SoTien\n" +
                "FROM dbo.GIAODICH FULL OUTER JOIN dbo.CHITIETGD ON CHITIETGD.MaGD = GIAODICH.MaGD\n" +
                "INNER JOIN dbo.TAIKHOAN ON TAIKHOAN.SoTK = CHITIETGD.SoTK\n" +
                "INNER JOIN dbo.KHACHHANG ON KHACHHANG.CMND = TAIKHOAN.CMND" +
                "WHERE LoaiGD = N'" + type + "'";
        return connection.getData(queryString);
    }


}
