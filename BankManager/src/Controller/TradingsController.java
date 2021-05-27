package Controller;

import Model.TradingsData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TradingsController {
    public static void uploadAllTradingData(JTable table, String accountNumber) {
        ResultSet resultSet = TradingsData.getAllTrading(accountNumber);
        showHistoryTrading(table, resultSet);
    }

    public static void uploadTradingByType(JTable table, String type, String accountNumber) {
        if (type.equals("Tất Cả")) {
            uploadAllTradingData(table, accountNumber);
            return;
        }
        ResultSet resultSet = TradingsData.getTradedByType(type);
        showHistoryTrading(table, resultSet);
    }

    private static void showHistoryTrading(JTable table, ResultSet resultSet) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        Object[] dataObjects = new Object[5];
        try {
            while (resultSet.next()) {
                dataObjects[0] = resultSet.getString("LoaiGD");
                dataObjects[1] = resultSet.getString("NgayGD");
                dataObjects[2] = resultSet.getString("SoTKNhan");
                dataObjects[3] = resultSet.getString("GhiChu");
                dataObjects[4] = resultSet.getString("SoTien");
                tableModel.addRow(dataObjects);
            }
        } catch (SQLException e) {
            System.out.println("Load Data Fail");
        }
    }

}
