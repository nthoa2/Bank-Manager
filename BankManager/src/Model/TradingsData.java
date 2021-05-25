package Model;

import java.sql.ResultSet;

public class TradingsData {

    public static ResultSet getAllTrading() {
        String queryString = "SELECT dbo.GIAODICH.LoaiGD, dbo.GIAODICH.NgayGD,dbo.CHITIETGD.SoTKNhan,dbo.CHITIETGD.GhiChu,dbo.CHITIETGD.SoTien FROM dbo.GIAODICH FULL OUTER JOIN dbo.CHITIETGD ON CHITIETGD.MaGD = GIAODICH.MaGD";
        return connection.getData(queryString);
    }

    public static ResultSet getTradedByType(String type) {
        String queryString = "SELECT dbo.GIAODICH.LoaiGD, dbo.GIAODICH.NgayGD,dbo.CHITIETGD.SoTKNhan,dbo.CHITIETGD.GhiChu,dbo.CHITIETGD.SoTien FROM dbo.GIAODICH inner JOIN dbo.CHITIETGD \n" +
                "ON CHITIETGD.MaGD = GIAODICH.MaGD\n" +
                "WHERE LoaiGD = N'" + type + "'";
        return connection.getData(queryString);
    }

}
