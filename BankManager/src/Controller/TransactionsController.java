package Controller;

import Model.Accounts;
import Model.Transactions;
import Model.User;
import Views.LoginFrame;
import Views.PanelProfile;
import Views.PanelTrading;
import Views.TradingsHistoryPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class TransactionsController {

    public static String randomID(int start, int end, int limit) {
        StringBuilder accountNumber = new StringBuilder();
        Random r = new Random();
        long[] longs = r.longs(start, end).limit(limit).toArray();
        for (long x : longs) {
            accountNumber.append(String.valueOf(x));
        }
        return accountNumber.toString();
    }

    public static boolean searchTransactionID(String tradingID) {
        ResultSet result = Transactions.getAllTransactionDetail();
        try {
            while (result.next()) {
                if (tradingID.equals(result.getString("MaGD"))) {
                    System.out.println("Ma Da Ton Tai");
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("search TradingID: " + e.getMessage());
        }
        return false;
    }

    public static void uploadAllTradingData(JTable table, String accountNumber) {
        ResultSet resultSet = Transactions.getAllTradingByAccount(accountNumber);
        showHistoryTradingPanel(table, resultSet);
    }

    public static void uploadTradingByType(JTable table, String accountNumber, int type) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        ResultSet resultSet = Transactions.getAllTradingByAccount(accountNumber);
        switch (type){
            case 0 -> uploadAllTradingData(table,accountNumber);
            case 1 -> filterTransactionType(tableModel,resultSet,"Nạp Tiền");
            case 2 -> filterTransactionType(tableModel,resultSet,"Rút Tiền");
            case 3 -> filterTransactionType(tableModel,resultSet,"Chuyển Khoản");
            case 4 -> filterTransactionType(tableModel,resultSet,"Nhận Chuyển Khoản");
        }
    }
    private static void filterTransactionType(DefaultTableModel tableModel,ResultSet resultSet,String type){
        Object[] dataObjects = new Object[5];
        tableModel.setRowCount(0);
        try{
            while (resultSet.next()){
                if(resultSet.getString("LoaiGD").equals(type)){
                    dataObjects[0] = resultSet.getString("LoaiGD");
                    dataObjects[1] = resultSet.getString("NgayGD");
                    dataObjects[2] = resultSet.getString("NguoiNhan");
                    dataObjects[3] = resultSet.getString("NoiDung");
                    dataObjects[4] = UserController.BalanceFormat.format(resultSet.getDouble("SoTien"))  + " VNĐ";
                    tableModel.addRow(dataObjects);
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi lọc lịch sử giao dịch: " + e.getMessage());
        }

    }
    private static void showHistoryTradingPanel(JTable table, ResultSet resultSet) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        Object[] dataObjects = new Object[5];
        try {
            while (resultSet.next()) {
                dataObjects[0] = resultSet.getString("LoaiGD");
                dataObjects[1] = resultSet.getString("NgayGD");
                dataObjects[2] = resultSet.getString("NguoiNhan");
                dataObjects[3] = resultSet.getString("NoiDung");
                dataObjects[4] = UserController.BalanceFormat.format(resultSet.getDouble("SoTien"))  + " VNĐ";
                tableModel.addRow(dataObjects);
            }
        } catch (SQLException e) {
            System.out.println("Load Data Fail");
        }
    }

    public static void uploadTradingDataOverview(JTable table, String accountNumber) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        Object[] dataObjects = new Object[3];
        ResultSet resultSet = Transactions.getAllTradingByAccount(accountNumber);
        try {
            while (resultSet.next()) {
                dataObjects[0] = resultSet.getString("NguoiNhan");
                dataObjects[1] = resultSet.getString("NoiDung");
                dataObjects[2] = UserController.BalanceFormat.format(resultSet.getDouble("SoTien")) + " VNĐ";
                tableModel.addRow(dataObjects);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static boolean initTransaction(String transactionType, double amount, String accountNumber, String accountNumberReceived, String Content) {
        if(transactionType.equals("Chuyển Khoản") || transactionType.equals("Rút Tiền")){
            return UserController.AccountBalance > amount;
        }
        String transactionID = randomID(0, 9, 5);
        while (searchTransactionID(transactionID)) {
            transactionID = randomID(0, 9, 5);
        }
        Transactions.createdTransaction(accountNumber, transactionID, transactionType, accountNumberReceived, amount, Content);
        Accounts.updateAccountBalance(accountNumber, transactionType, amount);
        Accounts.updateAccountBalance(accountNumberReceived, transactionType, amount);
        return true;
    }


}
