package Controller;

import Model.Login;
import Views.LoginFrame;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    public static String UserName;
    public static String Password;
    public static String AccountNumber;
    public static boolean authentication(String userName, String password) {

        if (!userName.trim().equals("") && !password.trim().equals("")) {
            ResultSet rs = Login.getLoginAccountByUserName(userName);
            try {
                if (rs.next()) {
                    if (rs.getString("loginName").matches(userName)) {
                        if (rs.getString("loginPassword").matches(password)) {
                            System.out.println("Đăng nhập thành công");
                            UserName = rs.getString("loginName");
                            Password = rs.getString("loginPassword");
                            AccountNumber = rs.getString("SoTK");
                            return true;
                        }
                        LoginFrame.lblLoginMessage.setText("Username or Password wrong!");
                        return false;
                    }
                    LoginFrame.lblLoginMessage.setText("Username or Password wrong!");
                    return false;
                }
            } catch (SQLException e) {
                System.out.println("Lỗi Đăng Nhập:"+ e.getMessage());
            }
            LoginFrame.lblLoginMessage.setText("Username or Password wrong!");
        } else {
            LoginFrame.lblLoginMessage.setText("Please input all requirements!");
        }
        return false;
    }
}
