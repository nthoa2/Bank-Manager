package Views;

import Controller.LoginController;
import Controller.TradingsController;
import Model.TradingsData;
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
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class LineGraphPanel
        extends JFXPanel {
    static LocalDate today = LocalDate.now();
    static LocalDate lastDay = today.minusDays(30);
    static String startDay = lastDay.getDayOfMonth() + "/" + lastDay.getMonthValue() + "/" + lastDay.getYear();
    static String endDay = today.getDayOfMonth() + "/" + today.getMonthValue() + "/" + today.getYear();


    private LineChart createChart() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("VNĐ");
        javafx.scene.chart.LineChart lineChart = new javafx.scene.chart.LineChart((Axis) xAxis, (Axis) yAxis);
        XYChart.Series spendingSeries = new XYChart.Series();
        spendingSeries.setName("Spending");
        XYChart.Series receivedSeries = new XYChart.Series();
        receivedSeries.setName("Received");
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy");
        long totalDays = 0L;
        try {
            Date startDayFormat = simple.parse(startDay);
            Date endDayFormat = simple.parse(endDay);
            totalDays = endDayFormat.getTime() - startDayFormat.getTime();
            totalDays = totalDays / 1000L / 60L / 60L / 24L;
            calendar.setTime(startDayFormat);
            long i = 0;
            while (i <= totalDays) {
                double Spending = TradingsController.getUsersSpendingPerDay(LoginController.accountNumber, new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
                spendingSeries.getData().add((Object) new XYChart.Data((Object) simple.format(calendar.getTime()), (Object) Spending));
                double receives = TradingsController.getUsersReceivedPerDay(LoginController.accountNumber, new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
                receivedSeries.getData().add((Object) new XYChart.Data((Object) simple.format(calendar.getTime()), (Object) receives));
                calendar.add(Calendar.DATE, 1);
                ++i;
            }
        } catch (Exception parseException) {
            System.out.println(parseException.getMessage());
        }
        lineChart.getData().addAll((Object[]) new XYChart.Series[]{spendingSeries, receivedSeries});
        return lineChart;
    }


    private Scene createScene() {
        BorderPane root = new BorderPane();
        Scene scene = new Scene((Parent)root, (Paint)Color.ALICEBLUE);
        root.setCenter((Node)this.createChart());
        return scene;
    }

    public LineGraphPanel() {
        this.setScene(this.createScene());
        this.setFont(new Font("Open Sans", Font.BOLD, 20));
        this.setBorder(new TitledBorder(new EtchedBorder(1, null, null), "Movement receive and spend in month", TitledBorder.CENTER, TitledBorder.TOP, new Font("Open Sans", Font.PLAIN, 16), new java.awt.Color(0, 0, 0)));
    }
}