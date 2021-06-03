package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserData {


    public static ResultSet getUserBalance(String userId) { // chua confirm data type nen de tam
        String query = "SELECT dbo.TAIKHOAN.SoDu FROM dbo.TAIKHOAN WHERE dbo.TAIKHOAN.SoTK =" + userId;
        return connection.getData(query);
    }

    public static ResultSet getUsersSpendingPerMonth(String userID, String startDate, String endDate) {
        String query = "SET DATEFORMAT dmy  SELECT SUM() AS TONGCHI FROM dbo.GIAODICH FULL OUTER JOIN dbo.CHITIETGD\n" +
                "ON CHITIETGD.MaGD = GIAODICH.MaGD AND CHITIETGD.SoTK = '" + userID + "'\n" +
                "WHERE dbo.GIAODICH.NgayGD  between '" + startDate + "' and '" + endDate + "'";
        return connection.getData(query);
    }

    public static ResultSet getUserReceivedPerMonth(String userID, String startDate, String endDate) {
        String query = "SET DATEFORMAT dmy  SELECT SUM() AS TONGNHAN FROM dbo.GIAODICH FULL OUTER JOIN dbo.CHITIETGD\n" +
                "ON CHITIETGD.MaGD = GIAODICH.MaGD AND CHITIETGD.SoTK = '" + userID + "'\n" +
                "WHERE dbo.GIAODICH.NgayGD  between '" + startDate + "' and '" + endDate + "'";
        return connection.getData(query);
    }

    public static double getUsersSpendingPerDay(String userID, String date) {
        String query = "SET DATEFORMAT dmy  SELECT SUM() AS CHIRA FROM dbo.GIAODICH FULL OUTER JOIN dbo.CHITIETGD\n" +
                "ON CHITIETGD.MaGD = GIAODICH.MaGD AND CHITIETGD.SoTK = '" + userID + "'\n" +
                "WHERE dbo.GIAODICH.NgayGD = '" + date + "'";
        ResultSet results = connection.getData(query);
        try {
            assert results != null;
            if (results.next()) {
                return results.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println("get spending per month fail");
        }
        return 0.0;
    }

    public static double getUserReceivedPerDay(String userID, String date) {
        String query = "SET DATEFORMAT dmy  SELECT SUM() AS NHANVAO FROM dbo.GIAODICH FULL OUTER JOIN dbo.CHITIETGD\n" +
                "ON CHITIETGD.MaGD = GIAODICH.MaGD AND CHITIETGD.SoTK = '" + userID + "'\n" +
                "WHERE dbo.GIAODICH.NgayGD = '" + date + "'";
        ResultSet results = connection.getData(query);
        try {
            assert results != null;
            if (results.next()) {
                return results.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println("get received per month fail");
        }
        return 0.0;
    }

    public static void addUser() {
        String query = "";
        connection.executeQuery(query);
    }
}
