package Model;

import java.sql.ResultSet;

public class TradingsData {

    public static ResultSet getAllTrading(String accountNumber) {
        String queryString = "SELECT gd.LoaiGD, gd.NgayGD, ctgd.SoTKNhan, ctgd.GhiChu, ctgd.SoTien\n" +
                "  FROM TAIKHOAN tk LEFT JOIN CHITIETGD ctgd ON tk.SoTK = ctgd.SoTK LEFT JOIN GIAODICH gd on ctgd.MaGD = gd.MaGD \n" +
                "  WHERE ctgd.SoTK = '"+accountNumber+"' OR ctgd.SoTKNhan = '"+accountNumber+"'";
        return connection.getData(queryString);
    }

    public static ResultSet getTradedByType(String type) {
        String queryString = "SELECT dbo.GIAODICH.LoaiGD, dbo.GIAODICH.NgayGD,dbo.CHITIETGD.SoTKNhan,dbo.CHITIETGD.GhiChu,dbo.CHITIETGD.SoTien FROM dbo.GIAODICH inner JOIN dbo.CHITIETGD \n" +
                "ON CHITIETGD.MaGD = GIAODICH.MaGD\n" +
                "WHERE LoaiGD = N'" + type + "'";
        return connection.getData(queryString);
    }
}
