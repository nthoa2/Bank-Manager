package Controller;

import Model.Model_Trading;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Control_Trading {
    public static void uploadAllTradingData(JTable table) {
        ResultSet resultSet = Model_Trading.getAllTrading();
        showHistoryTrading(table, resultSet);
    }

    public static void uploadTradingByType(JTable table, String type) {
        if (type.equals("Tất Cả")) {
            uploadAllTradingData(table);
            return;
        }
        ResultSet resultSet = Model_Trading.getTradedByType(type);
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
