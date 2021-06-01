package Controller;

import Model.User;
import Views.PanelProfile;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class UserController {
    public static String userFullName;
    public static String userGender;
    public static double AccountBalance;
    public static String userBirthday;
    public static String userPhoneNumber;
    public static String userAddress;
    public static String userDateSignUp;
    public static  final DecimalFormat BalanceFormat = new DecimalFormat("###,###,###");
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void setUserData(String accountNumber) {
        ResultSet resultSet = User.getUserData(accountNumber);
        try {
            if (resultSet.next()) {
                userFullName = resultSet.getString("TenKH");
                if (resultSet.getInt("GioiTinh") == 1) {
                    userGender = "Nam";
                } else {
                    userGender = "Nữ";
                }
                AccountBalance = resultSet.getDouble("SoDu");
                userBirthday = dateFormat.format(resultSet.getDate("NgaySinh"));
                userPhoneNumber = resultSet.getString("SoDienThoai");
                userAddress = resultSet.getString("DiaChi");
                userDateSignUp = dateFormat.format(resultSet.getDate("NgayDangKy"));
            }
        } catch (SQLException e) {
            System.err.println("setUserData: " + e.getMessage());
        }

    }
    public static void setGenderIcon(String gender) {
        if (gender.equals("Nam")) {
            PanelProfile.lblAvatar.setIcon(new ImageIcon(PanelProfile.img_man));
        } else {
            PanelProfile.lblAvatar.setIcon(new ImageIcon(PanelProfile.img_woman));
        }
    }

    public static boolean searchAccountNumber(String accountNumber){
        ResultSet results = User.getAllUserData();
        try{
            while (results.next()){
                if(accountNumber.equals(results.getString("SoTK"))){
                    System.out.println("Tim Thay SoTK");
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
