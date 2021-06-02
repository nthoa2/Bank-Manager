package Controller;

import Model.Accounts;
import Model.User;
import Views.ColumnChartPanel;
import Views.EditPassword;
import Views.LineGraphPanel;
import Views.OverviewPanel;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountController {

    public static boolean validateAccountNumber(String accountNumber) {


        return true;
    }

    public static boolean validateAccountName(String accountName) {


        return true;
    }

    public static double getSpendingOnDay(String accountNumber, String date) {
        ResultSet resultSet = Accounts.getSpendingPerDay(date);
        if (resultSet == null) {
            return 0.0;
        }
        double result = 0.0;
        try {
            while (resultSet.next()) {
                if (resultSet.getString("SoTK").equals(accountNumber)) {
                    result = resultSet.getDouble("ChiRa");
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi biểu đồ đường: " + e.getMessage());
        }
        return result;
    }

    public static double getReceivedOnDay(String accountNumber, String date) {
        ResultSet resultSet = Accounts.getReceivedPerDay(date);
        if (resultSet == null) {
            return 0.0;
        }
        double result = 0.0;
        try {
            while (resultSet.next()) {
                if (resultSet.getString("SoTK").equals(accountNumber)) {
                    result = resultSet.getDouble("NhanVao");
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi biểu đồ đường: " + e.getMessage());
        }
        return result;
    }

    public static void uploadDataToOverView(String accountNumber, String startDay, String finishDay) {
        ResultSet spendingResult = Accounts.getSpendingPerMonth(startDay, finishDay);
        ResultSet receivedResult = Accounts.getReceivedPerMonth(startDay, finishDay);
        if (spendingResult == null) {
            OverviewPanel.totalSpending = 0.0;
        } else {
            try {
                while (spendingResult.next()) {
                    if (spendingResult.getString("SoTK").equals(accountNumber)) {
                        OverviewPanel.totalSpending = spendingResult.getDouble("ChiRa");
                    }
                }
            } catch (SQLException e) {
                System.err.println("lỗi upload overview: " + e.getMessage());
            }
        }
        if (receivedResult == null) {
            OverviewPanel.totalReceived = 0.0;
        } else {
            try {
                while (receivedResult.next()) {
                    if (receivedResult.getString("SoTK").equals(accountNumber)) {
                        OverviewPanel.totalReceived = receivedResult.getDouble("NhanVao");
                    }
                }
            } catch (SQLException e) {
                System.err.println("lỗi upload overview: " + e.getMessage());
            }
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
    public static void validateEditPassword(String userAccount, String newPassword, String oldPassword) {
        if (newPassword.length() >= 5) {
            if (oldPassword.equals(LoginController.Password)) {
                if (!newPassword.equals(LoginController.Password)) {
                    Accounts.editPassword(userAccount, newPassword);
                    JOptionPane.showConfirmDialog(null, "Đổi Mật Khẩu Thành Công!", "Thông Báo", JOptionPane.OK_OPTION);
                    LoginController.Password = newPassword;
                    return;
                }
                EditPassword.lblLoginMessage.setText("Mật Khẩu Cũ Và Mới Không Được Trùng Nhau");
            }
            EditPassword.lblLoginMessage.setText("Mật Khẩu Cũ Không Chính Xác");
        } else {
            EditPassword.lblLoginMessage.setText("Mật Khẩu Phải Chứa Ít Nhất 5 Ký Tự!");
        }
    }
}
