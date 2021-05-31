package Controller;

import Model.TradingsData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class TradingsController
{
    public static double totalSpendingValue;
    public static double totalReceivedValue;

    public static void uploadAllTradingData(JTable table, String accountNumber)
    {
        ResultSet resultSet = TradingsData.getAllTrading(accountNumber);
        showHistoryTrading(table, resultSet);
    }

    public static void uploadTradingByType(JTable table, String type, String accountNumber)
    {
        if (type.equals("Tất Cả"))
        {
            uploadAllTradingData(table, accountNumber);
            return;
        }
        ResultSet resultSet = TradingsData.getTradedByType(type, accountNumber);
        showHistoryTrading(table, resultSet);
    }


    public static void showHistoryTrading(JTable table, ResultSet resultSet)
    {
        totalSpendingValue = 0;
        totalReceivedValue = 0;
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        Object[] dataObjects = new Object[5];
        try
        {
            while (resultSet.next())
            {
                if (resultSet.getString("LoaiGD").equals("Chuyển tiền"))
                {
                    if (LoginController.accountNumber.equals(resultSet.getString("SoTK")))
                    {
                        totalSpendingValue += resultSet.getDouble("SoTien");
                        dataObjects[0] = "Chuyển khoản";
                        dataObjects[1] = resultSet.getString("NgayGD");
                        dataObjects[2] = getUserName(resultSet.getString("SoTKNhan"));
                        dataObjects[3] = resultSet.getString("GhiChu");
                        dataObjects[4] = String.format("%,.0f", resultSet.getDouble("SoTien"));
                    } else if (LoginController.accountNumber.equals(resultSet.getString("SoTKNhan")))
                    {
                        totalReceivedValue += resultSet.getDouble("SoTien");
                        dataObjects[0] = "Nhận chuyển khoản";
                        dataObjects[1] = resultSet.getString("NgayGD");
                        dataObjects[2] = getUserName(resultSet.getString("SoTK"));
                        dataObjects[3] = resultSet.getString("GhiChu");
                        dataObjects[4] = String.format("%,.0f", resultSet.getDouble("SoTien"));
                    }
                } else
                {
                    if(resultSet.getString("LoaiGD").equals("Rút tiền"))
                        totalSpendingValue += resultSet.getDouble("SoTien");
                    else totalReceivedValue += resultSet.getDouble("SoTien");
                    dataObjects[0] = resultSet.getString("LoaiGD");
                    dataObjects[1] = resultSet.getString("NgayGD");
                    dataObjects[2] = getUserName(resultSet.getString("SoTK"));
                    dataObjects[3] = resultSet.getString("GhiChu");
                    dataObjects[4] = String.format("%,.0f", resultSet.getDouble("SoTien"));
                }
                tableModel.addRow(dataObjects);
            }
        } catch (SQLException e)
        {
            System.out.println("Load Data Fail");
        }
    }

    private static String getUserName(String accountNumber)
    {
        ResultSet resultSet = TradingsData.getUserName(accountNumber);
        String result = null;
        try
        {
            resultSet.next();
            result = resultSet.getString("TenKH");
        } catch (Exception exception)
        {
            System.err.println("TradingsController.java: " + exception.getMessage());
        }
        return result;
    }
    public static void uploadTradingDataOverview(JTable table, String accountNumber){
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        Object[] dataObjects = new Object[3];
        ResultSet resultSet = TradingsData.getTop10Trading(accountNumber);
        try{
            while (resultSet.next()){
                if (resultSet.getString("LoaiGD").equals("Chuyển tiền"))
                {
                    if (LoginController.accountNumber.equals(resultSet.getString("SoTK")))
                    {
                        dataObjects[0] = getUserName(resultSet.getString("SoTKNhan"));
                        dataObjects[1] = resultSet.getString("GhiChu");
                        dataObjects[2] = String.format("%,.0f", resultSet.getDouble("SoTien"));
                    } else if (LoginController.accountNumber.equals(resultSet.getString("SoTKNhan")))
                    {
                        dataObjects[0] = getUserName(resultSet.getString("SoTK"));
                        dataObjects[1] = resultSet.getString("GhiChu");
                        dataObjects[2] = String.format("%,.0f", resultSet.getDouble("SoTien"));
                    }
                } else
                {
                    dataObjects[0] = getUserName(resultSet.getString("SoTK"));
                    dataObjects[1] = resultSet.getString("GhiChu");
                    dataObjects[2] = String.format("%,.0f", resultSet.getDouble("SoTien"));
                }
                tableModel.addRow(dataObjects);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public static double getUsersSpendingPerDay(String accountNumber, String date)
    {
        double result = 0;
        double spendingDay = 0;
//        double receivedDay = 0;
        ResultSet resultSet = TradingsData.getUsersSpendingAndReceivedPerDay(accountNumber, date);
        try
        {
            while (resultSet.next())
            {
                if (resultSet.getString("LoaiGD").equals("Chuyển tiền"))
                {
                    if (LoginController.accountNumber.equals(resultSet.getString("SoTK")))
                    {
                        if(date.equals(new SimpleDateFormat("dd/MM/yyyy").format(resultSet.getDate("NgayGD"))))
                        {
                            spendingDay += resultSet.getDouble("SoTien");
                        }
                        else spendingDay += 0;
                    }
//                    else if (LoginController.accountNumber.equals(resultSet.getString("SoTKNhan")))
//                    {
//                        receivedDay = 0;
//                    }
                }else
                {
                    if(resultSet.getString("LoaiGD").equals("Rút tiền"))
                        if(date.equals(new SimpleDateFormat("dd/MM/yyyy").format(resultSet.getDate("NgayGD"))))
                            result += resultSet.getDouble("SoTien");
                        else result += 0;
//                    else receivedDay = 0;
                }
            }
        }catch (Exception e)
        {
            System.err.println("TradingsCotroller.getUsersSpendingPerDay: " + e.getMessage());
        }
        return result + spendingDay;
    }

    public static double getUsersReceivedPerDay(String accountNumber, String date)
    {
        double result = 0;
        double receivedDay = 0;
        ResultSet resultSet = TradingsData.getUsersSpendingAndReceivedPerDay(accountNumber, date);
        try
        {
            while (resultSet.next())
            {
                if (resultSet.getString("LoaiGD").equals("Chuyển tiền"))
                {
                    if (LoginController.accountNumber.equals(resultSet.getString("SoTKNhan")))
                    {
                        if(date.equals(new SimpleDateFormat("dd/MM/yyyy").format(resultSet.getDate("NgayGD"))))
                        {
                            receivedDay += resultSet.getDouble("SoTien");
                        }
                        else receivedDay += 0;
                    }
                }else
                {
                    if(resultSet.getString("LoaiGD").equals("Nạp tiền"))
                        if(date.equals(new SimpleDateFormat("dd/MM/yyyy").format(resultSet.getDate("NgayGD"))))
                            result += resultSet.getDouble("SoTien");
                        else result += 0;
                }
            }
        }catch (Exception e)
        {
            System.err.println("TradingsCotroller.getUsersSpendingPerDay: " + e.getMessage());
        }
        return result + receivedDay;
    }
}

