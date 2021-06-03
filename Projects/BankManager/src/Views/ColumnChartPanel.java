package Views;

<<<<<<< HEAD:Projects/BankManager/src/Views/ColumnChartPanel.java
import java.awt.Font;

import Controller.LoginController;
import Model.Accounts;
=======
>>>>>>> Long:BankManager/src/Views/ColumnChart.java
import javafx.embed.swing.JFXPanel;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ColumnChartPanel
        extends JFXPanel
{

<<<<<<< HEAD:Projects/BankManager/src/Views/ColumnChartPanel.java
public class ColumnChartPanel
        extends JFXPanel {
    private double receivedOnMonth;
    private double spendingOnMonth;

    public BarChart createChart() {
        this.spendingOnMonth = OverviewPanel.totalSpending;
        this.receivedOnMonth = OverviewPanel.totalReceived;
=======


    public BarChart createChart(double spending, double receives)
    {

>>>>>>> Long:BankManager/src/Views/ColumnChart.java
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("vnd");
        XYChart.Series dataSpendingSeries = new XYChart.Series();
<<<<<<< HEAD:Projects/BankManager/src/Views/ColumnChartPanel.java
        dataSpendingSeries.setName("Chi Ra");
        dataSpendingSeries.getData().add((Object) new XYChart.Data((Object) "Chi ra", (Object) (this.spendingOnMonth)));
        XYChart.Series dataReceivedSeries = new XYChart.Series();
        dataReceivedSeries.setName("Nhận Vào");
        dataReceivedSeries.getData().add((Object) new XYChart.Data((Object) "Nhận vào", (Object) this.receivedOnMonth));
=======
        dataSpendingSeries.setName("Spending");
        dataSpendingSeries.getData().add((Object) new XYChart.Data((Object) "Spending", (Object) (spending)));
        XYChart.Series dataReceivedSeries = new XYChart.Series();
        dataReceivedSeries.setName("Received");
        dataReceivedSeries.getData().add((Object) new XYChart.Data((Object) "Received", (Object) receives));
>>>>>>> Long:BankManager/src/Views/ColumnChart.java
        BarChart chart = new BarChart((Axis) xAxis, (Axis) yAxis);
        chart.getData().addAll(new Object[]{dataSpendingSeries});
        chart.getData().addAll(new Object[]{dataReceivedSeries});
        return chart;
    }

    private Scene createScene(double spending, double receives)
    {
        BorderPane root = new BorderPane();
        Scene scene = new Scene((Parent) root, (Paint) Color.ALICEBLUE);
        root.setCenter((Node) this.createChart(spending, receives));
        return scene;
    }

<<<<<<< HEAD:Projects/BankManager/src/Views/ColumnChartPanel.java
    public ColumnChartPanel() {
        this.setScene(this.createScene());
=======
    public ColumnChartPanel(double spending, double receives)
    {
        this.setScene(this.createScene(spending, receives));
>>>>>>> Long:BankManager/src/Views/ColumnChart.java
        this.setFont(new Font("Open Sans", Font.BOLD, 20));
        this.setBorder(new TitledBorder(new EtchedBorder(1, null, null), "Total receive and spend in month", TitledBorder.CENTER, TitledBorder.TOP, new Font("Open Sans", Font.PLAIN, 16), new java.awt.Color(0, 0, 0)));
    }
}
