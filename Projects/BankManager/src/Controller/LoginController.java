package Controller;

import Model.Login;
import Views.EditPassword;
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
                        LoginFrame.lblLoginMessage.setText("Tên Đăng Nhập Hoặc Mật Khẩu Không Đúng");
                        return false;
                    }
                    LoginFrame.lblLoginMessage.setText("Tên Đăng Nhập Hoặc Mật Khẩu Không Đúng");
                    return false;
                }
            } catch (SQLException e) {
                System.out.println("Lỗi Đăng Nhập:" + e.getMessage());
            }
        }
        LoginFrame.lblLoginMessage.setText("Tên Đăng Nhập Hoặc Mật Khẩu Không Đúng");
        return false;
    }

    public static boolean searchingLoginAccount(String accountName){
        ResultSet accountSet = Login.getLoginAccounts();
        try{
            while (accountSet.next()){
                if(accountName.equals(accountSet.getString("loginName"))){
                    System.out.println("Tên Đăng Nhập Đã Tồn Tại!");
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

}
