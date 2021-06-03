package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserData {

    public static ResultSet CheckGender(String username)
    {
        String SQL = "use QLNH Select GioiTinh From KHACHHANG KH Inner Join TAIKHOAN TK ON KH.CMND = TK.CMND Where TenTK = '" + username + "'";
        return Model.connection.getData(SQL);
    }


    public static ResultSet getUserData(String username)
    {
        String SQL = "use QLNH select * from KHACHHANG KH INNER JOIN TAIKHOAN TK ON KH.CMND = TK.CMND WHERE TenTK =N'" + username + "'";
        return Model.connection.getData(SQL);
    }
}