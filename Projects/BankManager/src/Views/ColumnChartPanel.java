package Views;

import java.awt.Font;

import Controller.LoginController;
import Model.Accounts;
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

public class ColumnChartPanel
        extends JFXPanel {
    private double receivedOnMonth;
    private double spendingOnMonth;

    public BarChart createChart() {
        this.spendingOnMonth = OverviewPanel.totalSpending;
        this.receivedOnMonth = OverviewPanel.totalReceived;
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("vnd");
        XYChart.Series dataSpendingSeries = new XYChart.Series();
        dataSpendingSeries.setName("Chi Ra");
        dataSpendingSeries.getData().add((Object) new XYChart.Data((Object) "Chi ra", (Object) (this.spendingOnMonth)));
        XYChart.Series dataReceivedSeries = new XYChart.Series();
        dataReceivedSeries.setName("Nhận Vào");
        dataReceivedSeries.getData().add((Object) new XYChart.Data((Object) "Nhận vào", (Object) this.receivedOnMonth));
        BarChart chart = new BarChart((Axis) xAxis, (Axis) yAxis);
        chart.getData().addAll(new Object[]{dataSpendingSeries});
        chart.getData().addAll(new Object[]{dataReceivedSeries});
        return chart;
    }

    private Scene createScene() {
        BorderPane root = new BorderPane();
        Scene scene = new Scene((Parent) root, (Paint) Color.ALICEBLUE);
        root.setCenter((Node) this.createChart());
        return scene;
    }

    public ColumnChartPanel() {
        this.setScene(this.createScene());
        this.setFont(new Font("Open Sans", Font.BOLD, 20));
        this.setBorder(new TitledBorder(new EtchedBorder(1, null, null), "Tổng Thu Chi Trong Tháng ", TitledBorder.LEADING, TitledBorder.TOP, new Font("Open Sans", Font.PLAIN, 16), new java.awt.Color(0, 0, 0)));
    }
}
